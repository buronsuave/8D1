<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>03. Consulta de Clientes con Ciudad Tonala (TNL)</h2>  
                <xsl:apply-templates/>  
            </body>
        </html>
    </xsl:template>

    <xsl:template match="cliente">
        <p>
            <xsl:apply-templates select="nombre"/>  
            <xsl:apply-templates select="correo"/>
        </p>
    </xsl:template>

    <xsl:template match="nombre">
        Nombre: <span><strong>
            <xsl:value-of select="."/></strong></span>
        <br />
    </xsl:template>

    <xsl:template match="correo">
        Correo: <span style="color:#999">
            <xsl:value-of select="."/></span>
        <br />
    </xsl:template> 

</xsl:stylesheet>