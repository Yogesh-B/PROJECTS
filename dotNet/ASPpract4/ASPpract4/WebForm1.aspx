<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ASPpract4.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h2>Example of Hit Counter And Advertisementes...<br />
            </h2>
            <br />
            <h2>
                <asp:Label ID="Label3" runat="server"></asp:Label></h2>
            <p>&nbsp;</p>
            <asp:AdRotator ID="AdRotator1" runat="server" AdvertisementFile="~/Images.xml" Height="400px" Width="600px" Target="_blank" />
            <br />
            <br />
            <br />
            <br />
        </div>

    </form>
</body>
</html>
