function fetchPlayerInfo() {
    var searchValue = document.getElementById("searchInput").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if (this.readyState === 4 && this.status === 200) {
        displayPlayerInfo(this, searchValue);
      }
    };
    xhttp.open("GET", "players.xml", true); // Replace "players.xml" with the path to your XML file
    xhttp.send();
  }

  function displayPlayerInfo(xml, searchValue) {
    var xmlDoc = xml.responseXML;
    var players = xmlDoc.getElementsByTagName("player");

    var playerInfoContainer = document.getElementById("playerInfoContainer");
    playerInfoContainer.innerHTML = ""; // Clear previous search results

    // Iterate through each player
    for (var i = 0; i < players.length; i++) {
      var player = players[i];
      var name = player.getElementsByTagName("name")[0].childNodes[0].nodeValue;
      var country = player.getElementsByTagName("country")[0].childNodes[0].nodeValue;
      var role = player.getElementsByTagName("role")[0].childNodes[0].nodeValue;

      // If search value matches any attribute, display player info
      if (name === searchValue || country === searchValue || role === searchValue) {
        // Create player info elements
        var playerInfo = document.createElement("div");
        var playerName = document.createElement("p");
        var playerCountry = document.createElement("p");
        var playerRole = document.createElement("p");

        // Set player info content
        playerName.innerHTML = "Player: " + name;
        playerCountry.innerHTML = "Country: " + country;
        playerRole.innerHTML = "Role: " + role;

        // Append player info elements to the container
        playerInfo.appendChild(playerName);
        playerInfo.appendChild(playerCountry);
        playerInfo.appendChild(playerRole);
        playerInfoContainer.appendChild(playerInfo);
        
      }
    }
  }