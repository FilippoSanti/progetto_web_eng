<!DOCTYPE html>
<html lang="en">
<head>
    <title>SO question 4112686</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        setInterval(function(){
            $.get("notify.do", function(responseText) {
                $("#somediv").text(responseText);
            });
        }, 5000);

    </script>
</head>
<body>
<button id="somebutton">press here</button>
<div id="somediv"></div>
</body>
</html>