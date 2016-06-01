<?php
 define('SERVER_URL','192.168.1.2');
 
 
 $image = $_POST['image'];
 $name = $_POST['name'];
 $id = $_POST['id'];

 $path = $id.$name;
 

 file_put_contents($path,base64_decode($image)) or die;
 echo "Successfully Uploaded";
 
 ?>