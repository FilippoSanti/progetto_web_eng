$(document).on("click", ".vote", function () {
    var answerid;
    answerid = $(this).attr("data-answerid");
    $.get('notify.do?action=delete&id=' + answerid + '', function (data) {
        getNotificationCount();
        refreshNotifications();
    });
});

$(document).ready(function () {

    // Fetch the initial data
    refreshNotifications();

    // Fetch every 5 seconds
    setInterval(refreshNotifications, 5000);

    /*onclick event*/
    $(".float-right-custom").click(function () {
        $.get("notify.do?action=delete&id=all", function (responseText) {
            getNotificationCount();
            refreshNotifications();
        });
    });
});

function refreshNotifications() {
    getNotificationCount();
    $.get("notify.do?action=update", function (responseJson) {
        var table = '';

        $.each(responseJson, function (index, product) {

            table += '<div class="row">';
            table += '<div class="col-md-11">';
            table += '<a href="viewProfile?type=company&id=' + product.id_azienda + '"' + 'class="dropdown-item notify-item">';
            table += '<div class="notify-icon bg-info"><i class="mdi mdi-account-plus"></i></div>';
            table += '<p class="notify-details">' + product.testo + '</p>';
            table += '</a>';
            table += '</div>';

            table += '<div class="col-md-1">';
            table += '<button class="vote btn dltbtnhead" data-target="#" title="Delete" data-answerid="' + product.id_notifica + '"' + '><img class="dltheadwidth" src="../../assets/images/dlt_ico2.png"></button>';
            table += '</div>';
            table += '</div>';
        });

        $('#notifications_show').html(table);
    });

    // Update the table
    $.get("notify.do?action=update", function (responseJson) {
        var table = '';
        $.each(responseJson, function (index, product) {
            table += '<tr><td><div class="notbell ti-bell"></div></td>';
            table += '<td>'+product.testo+'</td>';
            table += '<td><a href="#" class="vote text-muted" data-answerid="'+product.id_notifica+'"><button type="button" class="btn btn-danger">Delete</button></a></td></tr>'
        });

        $('#notifications_table_custom').html(table);
    });

}


function getNotificationCount() {
    $.get("notify.do?action=getCount", function (responseText) {  // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $("#notifications_count").text(responseText);            // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
}