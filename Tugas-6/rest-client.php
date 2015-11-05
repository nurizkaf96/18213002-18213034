<?php
	if(isset($_GET["action"]) && isset($_GET["id"]) && isset($_GET["action"])=="get_info")
	{
		$info = file_get_contents('http://localhost/rest-api.php?action= get_info&id =' . $_GET["id"]);

		echo $info;
		
		$info= json_decode($info, true);
	}

?>

<table border = "1">
<tr>
	<td>ID</td>
	<td><?php echo $info["id"]?></td>
</tr>
<tr>
	<td>Nama</td>
	<td><?php echo $info["Nama"]?></td>
</tr>
<tr>
	<td>Jurusan</td>
	<td><?php echo $info["Jurusan"]?></td>
</tr>
<tr>
	<td>Angkatan</td>
	<td><?php echo $info["Angkatan"]?></td>
</tr>
