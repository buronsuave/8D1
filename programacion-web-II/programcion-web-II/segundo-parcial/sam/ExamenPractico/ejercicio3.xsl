<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Clientes con ciudad Tonalá</h3>  
                <xsl:apply-templates/>  
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Cliente">
        <p>
            <xsl:apply-templates select="NombC"/>  
            <xsl:apply-templates select="CorreoC"/>
        </p>
    </xsl:template>

    <xsl:template match="NombC">
        NomC: <span><strong>
            <xsl:value-of select="."/></strong></span>
        <br />
    </xsl:template>

    <xsl:template match="CorreoC">
        CorreoC: <span style="color:#888">
            <xsl:value-of select="."/></span>
        <br />
    </xsl:template> 

</xsl:stylesheet>