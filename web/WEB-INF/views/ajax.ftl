<!DOCTYPE html>
<html lang="en">
<head>
    <title>SO question 4112686</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        $(document).ready(function () {

            // Fetch the initial data
            refreshNotifications();

            // Fetch every 5 seconds
            setInterval(refreshNotifications, 5000);
        });

        function refreshNotifications() {
            getNotificationCount();
            $.get("notify.do?action=update", function (responseJson) {
                var table = '';
                $.each(responseJson, function (index, product) {

                    table += '<tr id="rowVehicleStatus" class="">';
                    table += '<td>' + product.id_notifica + '</td>';
                    table += '<td>' + product.id_utente + '</td>';
                    table += '<td>' + product.id_azienda + '</td>';
                    table += '<td>' + product.testo + '</td>';
                    table += '</tr>';
                });
                $('#somediv').html(table);
            });
        }

        function getNotificationCount() {
                $.get("notify.do?action=getCount", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#countdiv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
        }

        $(document).on("click", "#somebutton", function() {
            $.get("notify.do?action=delete&id=6", function(responseText) {
                getNotificationCount();
                refreshNotifications();
            });
        });


    </script>

</head>
<body>

<button id="somebutton">press here</button>
<div id="somediv"></div>
<div id="countdiv"></div>

</body>
</html>