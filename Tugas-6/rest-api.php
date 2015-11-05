<?php 

	function get_info_by_id($id)
	{
		$conn = new mysqli('localhost', 'root', '', nunukupluk);
		
		if ($conn->connect_error) {
  	  		die("Connection failed: " . $conn->connect_error);
		}a

		$sql = "SELECT * FROM cinta";
		$result = $conn->query($sql);

		mysql_connect('localhost', 'root', '');
		mysql_select_db('nunukupluk');
		$result = mysql_query("SELECT * FROM cinta WHERE id=$id");
		if ($result->num_rows > 0) {
 	   	while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " - Name: " . $row["Nama"]. " " . $row["Angkatan"]. "<br>";
    		}
		}
		$conn->close();

		return $result;

	}

?>
