<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ASPpract6.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px" CellPadding="4" DataKeyNames="Id" DataSourceID="SqlDataSource1" ForeColor="Black" GridLines="Vertical" ShowFooter="True">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:TemplateField ShowHeader="False">
                    <EditItemTemplate>
                        <asp:LinkButton ID="LinkButton1" runat="server" CausesValidation="True" CommandName="Update" Text="Update"></asp:LinkButton>
                        &nbsp;<asp:LinkButton ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel"></asp:LinkButton>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:LinkButton ID="LinkButton1" runat="server" CausesValidation="False" CommandName="Edit" Text="Edit"></asp:LinkButton>
                        &nbsp;<asp:LinkButton ID="LinkButton2" runat="server" CausesValidation="False" CommandName="Delete" Text="Delete"></asp:LinkButton>
                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:LinkButton ID="lnkbtnInsert" OnClick="lnkbtnInsert_Click" ValidationGroup="INSERT" runat="server">Insert</asp:LinkButton>

                    </FooterTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="Id" SortExpression="Id">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBoxId" runat="server" Text='<%# Bind("Id") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvId" runat="server" ErrorMessage="Id Is Required!"
                            Text="*" ForeColor="Red" ControlToValidate="TextBoxId"></asp:RequiredFieldValidator>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label1" runat="server" Text='<%# Bind("Id") %>'></asp:Label>
                    </ItemTemplate>
                    <FooterTemplate>


                        <asp:TextBox ID="txtId" runat="server"></asp:TextBox>


                        <asp:RequiredFieldValidator ID="rfvInsertId" runat="server" ErrorMessage="Id Is Required!"
                            Text="*" ForeColor="Red" ValidationGroup="INSERT" ControlToValidate="txtId"></asp:RequiredFieldValidator>
                    </FooterTemplate>

                </asp:TemplateField>
                <asp:TemplateField HeaderText="Enrollment" SortExpression="Enrollment">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Enrollment") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvEnrollmentNo" runat="server" ErrorMessage="Enrollment Is Required!"
                            Text="*" ForeColor="Red" ControlToValidate="TextBox1"></asp:RequiredFieldValidator>
                    </EditItemTemplate>

                    <ItemTemplate>
                        <asp:Label ID="Label2" runat="server" Text='<%# Bind("Enrollment") %>'></asp:Label>
                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:TextBox ID="txtEnrollmentNo" runat="server"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvInsertEnrollmentNo" runat="server" ErrorMessage="Enrollment Is Required!"
                            Text="*" ForeColor="Red" ValidationGroup="INSERT" ControlToValidate="txtEnrollmentNo"></asp:RequiredFieldValidator>
                    </FooterTemplate>

                </asp:TemplateField>
                <asp:TemplateField HeaderText="Name" SortExpression="Name">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("Name") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvName" runat="server" ErrorMessage="Please Enter Name!" ForeColor="Red"
                            ControlToValidate="TextBox2" Text="*"></asp:RequiredFieldValidator>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label3" runat="server" Text='<%# Bind("Name") %>'></asp:Label>
                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvInsertName" runat="server" ErrorMessage="Enter BookName!" ForeColor="Red"
                            ControlToValidate="txtName" ValidationGroup="INSERT" Text="*"></asp:RequiredFieldValidator>
                    </FooterTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="BookName" SortExpression="BookName">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox3" runat="server" Text='<%# Bind("[BookName]") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvBookName" runat="server" ErrorMessage="Enter BookName!" ForeColor="Red"
                            ControlToValidate="TextBox3" Text="*"></asp:RequiredFieldValidator>

                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label4" runat="server" Text='<%# Bind("[BookName]") %>'></asp:Label>


                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:TextBox ID="txtBookName" runat="server"></asp:TextBox>


                        <asp:RequiredFieldValidator ID="rfvInsertBookName" runat="server" ErrorMessage="Enter BookName!" ForeColor="Red"
                            ControlToValidate="txtBookName" ValidationGroup="INSERT" Text="*"></asp:RequiredFieldValidator>


                    </FooterTemplate>
                </asp:TemplateField>
                <asp:TemplateField HeaderText="IssueDate" SortExpression="IssueDate">
                    <EditItemTemplate>
                        <asp:TextBox ID="TextBox4" runat="server" Text='<%# Bind("IssueDate") %>'></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvIssueDate" runat="server" ErrorMessage="Date Is Required!" ForeColor="Red"
                            ControlToValidate="TextBox4" Text="*"></asp:RequiredFieldValidator>
                    </EditItemTemplate>
                    <ItemTemplate>
                        <asp:Label ID="Label5" runat="server" Text='<%# Bind("IssueDate") %>'></asp:Label>
                    </ItemTemplate>
                    <FooterTemplate>
                        <asp:TextBox ID="txtIssueDate" runat="server"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="rfvInsertIssueDate" runat="server" ErrorMessage="Date Is Required!" ForeColor="Red"
                            ControlToValidate="txtIssueDate" ValidationGroup="INSERT" Text="*"></asp:RequiredFieldValidator>

                    </FooterTemplate>
                </asp:TemplateField>
            </Columns>
            <FooterStyle BackColor="#CCCC99" />
            <HeaderStyle BackColor="#6B696B" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
            <RowStyle BackColor="#F7F7DE" />
            <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#FBFBF2" />
            <SortedAscendingHeaderStyle BackColor="#848384" />
            <SortedDescendingCellStyle BackColor="#EAEAD3" />
            <SortedDescendingHeaderStyle BackColor="#575357" />
        </asp:GridView>
        <asp:ValidationSummary ID="ValidationSummary1" ValidationGroup="INSERT" ForeColor="Red" runat="server" />
        <asp:ValidationSummary ID="ValidationSummary2" ForeColor="Red" runat="server" />

        <br />
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:LibraryCS %>" DeleteCommand="DELETE FROM [libraryTable] WHERE [Id] = @Id" InsertCommand="INSERT INTO [libraryTable] ([Id], [Enrollment], [Name], [BookName], [IssueDate]) VALUES (@Id, @Enrollment, @Name, @BookName, @IssueDate)" SelectCommand="SELECT * FROM [libraryTable]" UpdateCommand="UPDATE [libraryTable] SET [Enrollment] = @Enrollment, [Name] = @Name, [BookName] = @BookName, [IssueDate] = @IssueDate WHERE [Id] = @Id">
            <DeleteParameters>
                <asp:Parameter Name="Id" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>

                <asp:Parameter Name="Id" Type="Int32" />
                <asp:Parameter Name="EnrollmentNo" Type="String" />
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="BookName" Type="String" />
                <asp:Parameter Name="IssueDate" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="Enrollment" Type="String" />
                <asp:Parameter Name="Name" Type="String" />
                <asp:Parameter Name="BookName" Type="String" />

                <asp:Parameter Name="IssueDate" Type="String" />
                <asp:Parameter Name="Id" Type="Int32" />


            </UpdateParameters>
        </asp:SqlDataSource>
    </form>
</body>
</html>
