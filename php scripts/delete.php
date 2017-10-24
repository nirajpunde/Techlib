<?php
   
   $connect = mysqli_connect("localhost", "id3147768_tester", "tester", "id3147768_test");
   
   $id=$_POST["book_id"];

     
     //Step No. 2: Extracting data from database
    $query = "DELETE FROM books where book_id ='$id'";
     $res = mysqli_query($connect,$query);
    
     //Step No. 3: Putting the fetched data in Arrays
    $response = array();
    
    
   if($res)
        {
        $response["success"] = true;
        }
    else 
        {
            $response["success"] = false;
        }
    
    
	echo json_encode($response);

 
    mysqli_close($connect); 


	
?>

