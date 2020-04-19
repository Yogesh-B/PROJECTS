<!DOCTYPE html>
<!-- 4) Create a database called country and create table called city having fields
 (cityname, area, population) using PHP commands. 
 Create an HTML form to get the city data and write a script to insert that data into the table. -->

<html>

<head>

    <title>Country Database</title>
</head>

<body>
    <form action="pract54.php" method="POST">
        <input type="text" name="cityname" placeholder="Enter City Name"><br /><br />
        <input type="text" name="area" placeholder="Enter Area Name"><br /><br />
        <input type="text" name="population" placeholder="Enter Population"><br /><br />
        <button type="submit">Submit</button>
    </form>
    <?php

    if (isset($_POST['cityname'])) {
        $cityname = $_POST['cityname'];
        $area = $_POST['area'];
        $population = $_POST['population'];
        $connect = mysqli_connect("localhost", "LMS", "library123") or die(mysqli_connect_error());
        $db = mysqli_select_db( $connect,"country") or die(mysqli_connect_error());
        $query = sprintf("INSERT INTO `city`(`cityname`, `area`, `population`) VALUES ('%s','%s',%d)", $cityname, $area, $population);
        // $result = mysqli_query($query) or die(mysqli_connect_error());
        $result = $connect->query($query) or die(mysqli_connect_error());
        if ($result) {
            echo "<h1>Data Successfully Added</h1>";
        }
    }
    ?>
</body>

</html>