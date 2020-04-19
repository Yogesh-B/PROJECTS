<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ASPpract3.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <h1>Web Form1(Cookies)</h1>
        <br />
        Name:<asp:TextBox ID="txtName" runat="server"></asp:TextBox>
        <br />
        Email:<asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
        <div>
        </div>
        <asp:Button ID="Send_data" runat="server" Height="44px" OnClick="Button1_Click" Text="Submit" Width="121px" />
    </form>
</body>
</html>
