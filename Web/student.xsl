<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Student XML</title>
            </head>
            <body>
                <table border="1">
                    <caption>Student Details</caption>
                    <tr>    
                        <th>RollNo</th>
                        <th>Name</th>
                        <th>Name of College</th>
                        <th>Branch</th>
                        <th>Year of Joining</th>
                        <th>email id</th>
                    </tr>
                    <xsl:for-each select="student/object">
                       <tr>
                        <td><xsl:value-of select="rollNo"></xsl:value-of></td>
                        <td><xsl:value-of select="name"></xsl:value-of></td>
                        <td><xsl:value-of select="college"></xsl:value-of></td>
                        <td><xsl:value-of select="branch"></xsl:value-of></td>
                        <td><xsl:value-of select="joinYear"></xsl:value-of></td>
                        <td><xsl:value-of select="email"></xsl:value-of></td>
                       </tr>                     
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>