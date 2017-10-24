<?php
    $connect = mysqli_connect("localhost", "id3147768_tester", "tester", "id3147768_test");
    
    $book_name = $_POST["book_name"];
    $author = $_POST["author"];
    $publisher = $_POST["publisher"];
    $edition = $_POST["edition"];
    $subject = $_POST["subject"];
    $link = $_POST["link"];
    $contributer = $_POST["contributer"];

    // $statement = mysqli_prepare($con, "INSERT INTO test (fname, lname, username, password) VALUES (?, ?, ?, ?)");
    // mysqli_stmt_bind_param($statement, "ssss", $fname,$lname,$username,$password);
    // mysqli_stmt_execute($statement);
    
    $query = "INSERT INTO books (book_name,author,publisher,edition,subject,link,contributer) VALUES ('$book_name', '$author', '$publisher', '$edition','$subject','$link','$contributer')";
     $res = mysqli_query($connect,$query);
    
     //Step No. 3: Putting the fetched data in Arrays
    $response = array();
	
    // while($rows =mysqli_fetch_assoc($res))
    // {
    //     $response[] = $rows;
    // }
    
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
