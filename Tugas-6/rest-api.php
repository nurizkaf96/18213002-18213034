<?php 

	function get_info_by_id($id)
	{
		$result = array();
		mysql_connect('localhost', 'root', '');
		mysql_select_db('nunukupluk');
		$array = mysql_query('SELECT * FROM cinta WHERE id='.$id);
		$result = mysql_fetch_array ($array, MYSQL_ASSOC);
		
		return $result;
	}
	if(isset($_GET["action"]))
	{
		switch($_GET["action"])
		{
			case "get_info";
				if(isset($_GET["id"]))
					$value=get_info_by_id($_GET["id"]);
				else
					$value="ERROR";
				break;
		}
	}

	exit(json_encode($value));

?>
