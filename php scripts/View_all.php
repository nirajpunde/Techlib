<?php
   
   $connect = mysqli_connect("localhost", "id3147768_tester", "tester", "id3147768_test");

     
     //Step No. 2: Extracting data from database
    $query = "SELECT * FROM books";
     $res = mysqli_query($connect,$query);
    
     //Step No. 3: Putting the fetched data in Arrays
    $response = array();
	
    while($rows =mysqli_fetch_assoc($res))
    {
        $response[] = $rows;
    }
	echo json_encode($response);

 
    mysqli_close($connect); 


	
?>

