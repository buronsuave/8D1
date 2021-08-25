-- INSERT MACHINE 2 --

use Mercado
go

insert into dbo.Puesto values(6, 'El gordo', 'Puesto de tamales')
insert into dbo.Puesto values(7, 'Tacos Paquita', 'Puesto de tacos')
insert into dbo.Puesto values(8, 'Enchiladas Maria', 'Puesto de enchiladas')
insert into dbo.Puesto values(9, 'Mariscos Victoria', 'Puesto de mariscos')
insert into dbo.Puesto values(10, 'Doña Paty', 'Puesto de puercadas')
go

-- Producto Machine 1 --
-- id int PK
-- nombre varchar(50)


-- Producto Machine 2 --
-- id int PK
-- descripcion varchar(50)

insert into dbo.Producto values (1, 'Tamales', 'Verdes y Rojos')
insert into dbo.Producto values (2, 'Tacos', 'Bistec y al Pastor')
insert into dbo.Producto values (3, 'Enchiladas', 'Rojas y Verdes')
insert into dbo.Producto values (4, 'Mariscos', 'Sabrosos cocteles')
insert into dbo.Producto values (5, 'Lonches', 'Rompe almas')



insert into dbo.Producto values (1, 'Verdes y Rojos')
insert into dbo.Producto values (2, 'Bistec y al Pastor')
insert into dbo.Producto values (3, 'Rojas y Verdes')
insert into dbo.Producto values (4, 'Sabrosos cocteles')
insert into dbo.Producto values (5, 'Rompe almas')



GO 

SELECT * FROM B.id, A.nombre, B.descripcion FROM dbo.Producto AS B
[IP].Mercado.dbo.Producto AS A WHERE A.id = B.id

GO 





