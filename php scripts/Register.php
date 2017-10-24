<?php
    $connect = mysqli_connect("localhost", "id3147768_tester", "tester", "id3147768_test");
    
    $fname = $_POST["fname"];
    $lname = $_POST["lname"];
    $username = $_POST["username"];
    $password = $_POST["password"];

   
    $query = "INSERT INTO test (fname, lname, username, password) VALUES ('$fname', '$lname', '$username', '$password')";
     $res = mysqli_query($connect,$query);
    
     //Step No. 3: Putting the fetched data in Arrays
    $response = array();
	

    
    // echo json_encode($response);
    if($res)
    {
    $response["success"] = true;
    }
    else 
    {
        $response["success"] = false;
    }
    
    echo json_encode($response);
?>

