
<?php
include 'config.php';
$conn = new mysqli($servername, $username, $password, $dbname);
$sql = "SELECT * FROM androidosnames";
$r = mysqli_query($con,$sql);
$result = array();
while($res = mysqli_fetch_array($r)){
array_push($result,array(
"AndroidNames"=>$res['AndroidNames'],
"ImagePath"=>$res['ImagePath']
)
);
}
echo json_encode(array("result"=>$result));
mysqli_close($con);
?>
