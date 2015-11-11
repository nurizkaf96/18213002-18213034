<?php
$token = $_POST["idtoken"];
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "progif";
// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$sql = "INSERT INTO tokens (id)
VALUES ('$token')";
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}
$display = "SELECT id FROM tokens";
$result = $conn->query($display);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. "<br>";
    }
} else {
    echo "0 results";
}
echo "jos";
$conn->close();
?>
