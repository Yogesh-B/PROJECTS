<!DOCTYPE html>
<!-- 2) Write PHP program to first 10 Fibonacci number.  -->
<html>

<head>
   <title>Fibonacci Series</title>
</head>

<body>
   <h1>Fibonacci Series</h1>
   <form action="pract52.php" method="POST">
      <div class="Number">
         <input type="text" name="number" placeholder="Enter Number" autocomplete="off">
         <button type="submit">Submit</button>
      </div>
   </form>

   <?php
   if (isset($_POST['number'])) {
      $number = $_POST['number'];
      $previous = 0;
      $current = 1;
      $result = " ";
      for ($i = 0; $i < $number; $i++) {
         $next = $previous + $current;
         $previous = $current;
         $current = $next;
         $result = " " . $result . " " . $next . " ";
      }
      echo "<h1>1 " . $result . "</h1>";
   }
   ?>
</body>

</html>