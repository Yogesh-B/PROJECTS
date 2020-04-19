<!DOCTYPE html>
<!-- 3) Write modules using HTML and PHP to store information of 
employee (employee id, job title, years of experience) 
in an array. And output the data to a web page by arranging the employees in ascending order 
of experience.  -->
<html>

<head>
    <title> Employee Information</title>
    </style>
</head>

<body>
    <h1>Employee Details</h1>
    <table>
        <form action="pract53.php" method="POST">
            <tr>
                <td>
                    <input type="text" name="eid0" placeholder="Enter Employee Id" required>
                </td>
                <td>
                    <input type="text" name="title0" placeholder="Enter Job Title" required>
                </td>
                <td>
                    <input type="text" name="experience0" placeholder="Enter Year of  Experience" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="eid1" placeholder="Enter Employee Id" required>
                </td>
                <td>
                    <input type="text" name="title1" placeholder="Enter Job Title" required>
                </td>
                <td>
                    <input type="text" name="experience1" placeholder="Enter Year of  Experience" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="eid2" placeholder="Enter Employee Id" required>
                </td>
                <td>
                    <input type="text" name="title2" placeholder="Enter Job Title" required>
                </td>
                <td>
                    <input type="text" name="experience2" placeholder="Enter Year of  Experience" required>
                </td>
            </tr>
            <tr>
                <center>
                    <td colspan="3">
                        <button type="submit">Submit</button>
                    </td>
            </tr>
        </form>
    </table>

    <?php
    if (isset($_POST['eid0'])) {

        $eid0 = $_POST['eid0'];
        $title0 = $_POST['title0'];
        $exp0 = $_POST['experience0'];


        $eid1 = $_POST['eid1'];
        $title1 = $_POST['title1'];
        $exp1 = $_POST['experience1'];

        $eid2 = $_POST['eid2'];
        $title2 = $_POST['title2'];
        $exp2 = $_POST['experience2'];

        $employee = array(
            array('eid' => $eid0, 'title' => "$title0", 'experience' => $exp0),
            array('eid' => $eid1, 'title' => "$title1", 'experience' => $exp1),
            array('eid' => $eid2, 'title' => "$title2", 'experience' => $exp2),
        );

        class Employee
        {
            var $eid, $title, $experience;

            public function Employee($data)
            {
                $this->eid = $data['eid'];
                $this->title = $data['title'];
                $this->experience = $data['experience'];
            }
        }
        function data2Object($data)
        {
            $class_object = new Employee($data);
            return $class_object;
        }
        function comparator($object1, $object2)
        {
            return $object1->experience > $object2->experience;
        }
        $emp_data = array_map('data2Object', $employee);
        usort($emp_data, 'comparator');
        echo ("<h1>After Sorting</h1>");
        foreach ($emp_data as $key) {
            $str = "Id : " . $key->eid . " Title : " . $key->title . " Experience : " . $key->experience . "<br>";
            echo ("<h1>" . $str . "</h1>");
        }
    }
    ?>

</body>

</html>