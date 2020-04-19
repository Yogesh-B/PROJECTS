<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ASPpract2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <p>
            Username:<asp:TextBox ID="txtUsername" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidatorUsername" runat="server" ErrorMessage="Username is required" ForeColor="Red"
                ControlToValidate="txtUsername" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ID="RegularExpressionValidatorUsername" runat="server" ErrorMessage="Username should be correct Format!!"
                ControlToValidate="txtUsername" ValidationExpression="^(?i)(((?=.{6,21}$)[a-z\d]+\.[a-z\d]+)|[a-z\d]{5,20})$" ForeColor="Red" Display="Dynamic"></asp:RegularExpressionValidator>
        </p>

        <p>
            Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :<asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidatorEmail" runat="server" ErrorMessage="Email is required" ForeColor="Red"
                ControlToValidate="txtEmail" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ID="RegularExpressionValidatorEmail" runat="server" ErrorMessage="Email Should correct format!" ForeColor="Red"
                ControlToValidate="txtEmail" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" Display="Dynamic"></asp:RegularExpressionValidator>
        </p>
        <p>
            Mobile&nbsp;&nbsp;&nbsp; :<asp:TextBox ID="txtMobile" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidatorMobile" runat="server" ErrorMessage="Mobile is required" ForeColor="Red"
                ControlToValidate="txtMobile" Display="Dynamic"></asp:RequiredFieldValidator>

            <asp:RegularExpressionValidator ID="RegularExpressionValidatorMobile" runat="server" ErrorMessage="Enter Valid mobile number!" ForeColor="Red"
                ValidationExpression="^[01]?[- .]?(\([2-9]\d{2}\)|[2-9]\d{2})[- .]?\d{3}[- .]?\d{4}$" ControlToValidate="txtMobile" Display="Dynamic"></asp:RegularExpressionValidator>

        </p>



        <p>
            Password:<asp:TextBox type="password" ID="txtPassword" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidatorPassword" runat="server" ErrorMessage="Password is required" ForeColor="Red"
                ControlToValidate="txtPassword" Display="Dynamic"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ID="RegularExpressionValidatorPassword" runat="server" ErrorMessage="Password must greater than seven characters. - Contains at least one digit. - Contains at least one special (non-alphanumeric) character."
                ControlToValidate="txtPassword" ForeColor="Red" ValidationExpression="^.*(?=.{8,})(?=.*[\d])(?=.*[\W]).*$" Display="Dynamic"></asp:RegularExpressionValidator>
        </p>
        <p>
            Re-Type Password:<asp:TextBox type="password" ID="txtReTypePassword" runat="server"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidatorReTypePassword" runat="server" ErrorMessage="Please retype the password"
                ForeColor="Red" ControlToValidate="txtReTypePassword" Display="Dynamic"></asp:RequiredFieldValidator>

            <asp:CompareValidator ID="CompareValidatorReTypeValidator" runat="server" ErrorMessage="Password and Re-Type password must match"
                ControlToValidate="txtReTypePassword" ControlToCompare="txtPassword" ForeColor="Red" Operator="Equal" Type="String" Display="Dynamic"></asp:CompareValidator>
        </p>

        <p>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Submit" />
        </p>
        <p>
            <asp:Label ID="Label1" runat="server" ForeColor="#339933"></asp:Label>
        </p>
    </form>
</body>
</html>
