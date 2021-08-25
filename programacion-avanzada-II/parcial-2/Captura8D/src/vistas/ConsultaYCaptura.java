package vistas;

import basesDeDatos.PersonaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import model.Persona;
import controles.Registro;

import java.util.ArrayList;

import exceptions.InvalidIdException;

public class ConsultaYCaptura extends JFrame implements ActionListener
{
    private JLabel lblId, lblNombre;
    private JTextField txtId, txtNombre;
    private JRadioButton rbFemenino, rbMasculino;
    private JComboBox<Persona> cbDatos;
    private JButton agregar, borrar, modificar;

    public ConsultaYCaptura()
    {
        super("Ventana de captura");
        configuracion();
        
        PersonaDAO personaDAO;
        Persona x;
        personaDAO = new PersonaDAO();
        
        ArrayList<Persona> lista;
        lista = personaDAO.getAll();
        
        for (int i = 0; i < lista.size(); i++)
        {
            x = lista.get(i);
            Registro.datos.add(x);
            cbDatos.addItem(x);
        }
    }
    
    private void configuracion()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,500);
        setLocationRelativeTo(null);  
        
        setLayout(null);
        
        lblId = new JLabel("ID");
        lblId.setLocation(100, 100);
        lblId.setSize(50, 25);
        add (lblId);
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setLocation(100, 150);
        lblNombre.setSize(100, 25);
        add (lblNombre);
        
        txtId = new JTextField();
        txtId.setBounds(200, 100, 100, 30);
        add(txtId);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(200, 150, 100, 30);
        add(txtNombre);
        
        rbFemenino = new JRadioButton("Femenino");
        rbFemenino.setBounds(100, 200, 100, 30);
        rbFemenino.setSelected(true);
        add(rbFemenino);
        
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(200, 200, 100, 30);
        add(rbMasculino);
                
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbFemenino);
        grupo.add(rbMasculino);
        
        agregar = new JButton("Agregar");
        agregar.setBounds(250, 250, 100, 30);
        agregar.addActionListener(this);
        add(agregar);
        
        borrar = new JButton("Borrar");
        borrar.setBounds(355, 250, 100, 30);
        borrar.addActionListener(this);
        add(borrar);
        
        modificar = new JButton("Modificar");
        modificar.setBounds(460, 250, 100, 30);
        modificar.addActionListener(this);
        add(modificar);
        
        cbDatos = new JComboBox();
        cbDatos.setBounds(50, 20, 500, 40);
        cbDatos.addItemListener
        (
               (ItemEvent e) -> { cbDatosOnChange(); }                       
        );
        add(cbDatos);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == agregar)
            agregarOnclick(); 
        else if (ae.getSource() == borrar)
            borrarOnClick(); 
        else if (ae.getSource() == modificar)
            modificarOnClick(); 
    }

    private void agregarOnclick() 
    {
        String nombre, id;
        boolean genero;
        PersonaDAO personaDAO;
        
        nombre = txtNombre.getText();
        id = txtId.getText();
        genero = rbFemenino.isSelected();
        
        Persona miPersona;
        miPersona = new Persona();
        try
        {
            miPersona.setId(Integer.parseInt(id));
            miPersona.setNombre(nombre);
            miPersona.setGenero(genero);
            checkUnusedId(miPersona.getId());
            
            Registro.datos.add(miPersona);
            
            personaDAO = new PersonaDAO();
            personaDAO.add(miPersona);
                        
            txtId.setText("");
            txtNombre.setText("");
            rbFemenino.setSelected(true);
            
            cbDatos.addItem(miPersona);        
            
            
            personaDAO.close();
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Error en el formato numerico del ID");
        }
        catch(InvalidIdException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void borrarOnClick() 
    {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.remove(Integer.parseInt(txtId.getText()));
        personaDAO.close();
        
        Persona item = (Persona) cbDatos.getSelectedItem();
        Registro.datos.remove(item);
        cbDatos.removeItem(item);
    }

    private void modificarOnClick() 
    {
        String nombre, id;
        boolean genero;
        Persona item = (Persona) cbDatos.getSelectedItem();
       
        nombre = txtNombre.getText();
        id = txtId.getText();
        genero = rbFemenino.isSelected();
        
        try 
        {
            int prevId = item.getId();
            Persona persona = new Persona(Integer.parseInt(id), nombre, genero);
            if (persona.getId() != prevId)
            {
                checkUnusedId(persona.getId());
            }
            PersonaDAO personaDAO = new PersonaDAO();
            personaDAO.update(prevId, persona);

            item.setNombre(nombre);
            item.setId(Integer.parseInt(id));
            item.setGenero(genero);         
        }
        catch (InvalidIdException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    private void cbDatosOnChange()
    {
        Persona item = (Persona) cbDatos.getSelectedItem();
        
        txtId.setText("" + item.getId());
        txtId.setText(String.valueOf(item.getId()));
             
        txtNombre.setText(item.getNombre());
        
        if (item.isGenero())
            rbFemenino.setSelected(true);
        else
            rbMasculino.setSelected(true);
        
    }
    
    private void checkUnusedId(int id) throws InvalidIdException
    {
        for (int i = 0; i < Registro.datos.size(); i++)
        {
            if (id == Registro.datos.get(i).getId())
            {
                throw new InvalidIdException("Id is already in use", new Throwable());
            }
        }
    }
}
