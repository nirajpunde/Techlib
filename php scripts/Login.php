<?php
   $connect = mysqli_connect("localhost", "id3147768_tester", "tester", "id3147768_test");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
   
  
    $query = "SELECT * FROM test WHERE username = '$username' AND password = '$password' ";
     $res = mysqli_query($connect,$query);
    
     //Step No. 3: Putting the fetched data in Arrays
    $response = array();
	
    while($rows =mysqli_fetch_assoc($res))
    {
        $response[] = $rows;
        
    }
    
    echo json_encode($response);
?>

