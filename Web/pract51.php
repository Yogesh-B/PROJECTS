<!DOCTYPE html>
<!-- 1) Write PHP program to: To print whether given number is odd or even. -->
<html>

<head>

    <title>PHP Odd/Even</title>

<body>
    <h1>Odd-Even Test</h1>
    <form action="pract51.php" method="POST">
        <div class="Number">
            <input type="text" name="number" placeholder="Enter Any Number" autocomplete="off">
            <button type="submit">Submit</button>
        </div>
    </form>

    <?php 
         if(isset($_POST['number'])){ 
            $number = $_POST['number'];
             if($number%2==0){ 
                echo "<h1>Number is Even</h1>"; 
             }
            else{ 
                echo "<h1>Number is Odd</h1>"; 
            } 
         } 
    ?>

</body>

</html>