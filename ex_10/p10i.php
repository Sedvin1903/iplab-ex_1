<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IPL_10💻</title>
</head>
<body>
<?php
$JDBC_DRIVER = "com.mysql.jdbc.Driver";
$DB_HOST = "localhost";
$DB_PORT = 3307;
$DB_NAME = "cricket";
$DB_USER = "root";
$DB_PASS = "";

// Set response content type
header("Content-Type: text/html");
$out1 = fopen("php://output", "w");

$title = "Database Result [ PHP ]";

fwrite($out1, "<html>\n");
fwrite($out1, "<head>\n");
fwrite($out1, "<title>$title</title>\n");
fwrite($out1, "</head>\n");
fwrite($out1, "<body bgcolor=\"#f0f0f0\">\n");
fwrite($out1, "<br>\n");
fwrite($out1, "<hr>\n");
fwrite($out1, "<center><h1>$title</h1></center>\n");

try {
    // Create a new MySQLi instance
    $conn = new mysqli($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);

    // Check for connection errors
    if ($conn->connect_error) {
        throw new Exception("Failed to connect to the database: " . $conn->connect_error);
    }

    // Execute SQL query
    $stmt = $conn->prepare("UPDATE profile SET runrate=? WHERE bod=?");
    $stmt->bind_param("ss", $comnt, $yr);

    $comnt = $_POST['input'];
    $yr = $_POST['yr'];
    $stmt->execute();
    $stmt->close();

    $sql = "SELECT * FROM profile";
    $result = $conn->query($sql);

    fwrite($out1, "<style> th, td { padding-top: 10px; padding-bottom: 20px; padding-left: 30px; padding-right: 40px; }</style>\n");
    fwrite($out1, "<center><div><table border=\"1\">\n");
    fwrite($out1, "<tr><td> Name </td>");
    fwrite($out1, "<td> Birth_Year </td>");
    fwrite($out1, "<td> Country of Origin </td>");
    fwrite($out1, "<td> Avr_Run_rate </td></tr>\n");

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $name = $row['name'];
            $co = $row['co'];
            $rrt = $row['runrate'];
            $boY = $row['bod'];

            fwrite($out1, "<tr><td>$name</td>");
            fwrite($out1, "<td>$boY</td>");
            fwrite($out1, "<td>$co</td>");
            fwrite($out1, "<td>$rrt</td>");
            fwrite($out1, "<td>\n");
            fwrite($out1, "<form action='p10.php' method='post'>\n");
            fwrite($out1, "<input type='text' name='input'>\n");
            fwrite($out1, "<input type='hidden' name='yr' value='$boY'>\n");
            fwrite($out1, "<input type='submit' value='UPDATE'>\n");
            fwrite($out1, "</form>\n");
            fwrite($out1, "</td></tr>\n");
        }
    } else {
        fwrite($out1, "<tr><td colspan='5'>No records found.</td></tr>\n");
    }

    fwrite($out1, "</table></div></center>\n");
    fwrite($out1, "<br><br><button id='render-btn' type='submit' onclick='R()'>BACK</button>\n");
    fwrite($out1, "<script>function R() {location.replace('http://localhost/ex_10/p10.php')}</script>\n");

    $result->close();
    $conn->close();
} catch (Exception $e) {
    fwrite($out1, "Failed to connect to the database - Error: " . $e->getMessage());
}

fclose($out1);
?>
</body>
</html>