<!DOCTYPE html>
<html lang="en">
<head>
    <title>SO question 4112686</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        setInterval(function(){
            $.get("notify.do", function(responseJson) {
                var table = '';
                $.each(responseJson, function(index, product) {

                    table += '<tr id="rowVehicleStatus" class="">';
                    table += '<td>'+product.id_notifica+'</td>';
                    table += '<td>'+product.id_utente+'</td>';
                    table += '<td>'+product.id_azienda+'</td>';
                    table += '<td>'+product.testo+'</td>';
                    table += '</tr>';
                });

                $('#somediv').html(table);
            });
        }, 5000);



    </script>

</head>
<body>

<button id="somebutton">press here</button>
<div id="somediv">
</div>

</body>
</html>