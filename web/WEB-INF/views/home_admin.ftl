<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>SimpleAdmin - Responsive Admin Dashboard Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <!-- App favicon -->
    <link rel="shortcut icon" href="../../assets/images/favicon.ico">

    <!-- DataTables -->
    <link href="../../assets/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
    <!-- Responsive datatable examples -->
    <link href="../../assets/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />

    <!-- Multi Item Selection examples -->
    <link href="../../assets/plugins/datatables/select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

    <!-- App css -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/style.css" rel="stylesheet" type="text/css" />

    <script src="../../assets/js/modernizr.min.js"></script>

</head>


    <body>

        <!-- Begin page -->
        <div id="wrapper">

        <#include "/WEB-INF/views/FreeMarker/header_admin.ftl">

        <#include "/WEB-INF/views/FreeMarker/sidebar_admin.ftl">


            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">
<br>
                        <div class="row">
                        	<div class="col-sm-4"></div>
                            <div class="col-sm-4 centra">
                                <h4 class="header-title m-t-0 m-b-20">Administrator's Homepage</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div>
<br><br>


                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box widget-inline">
                                    <div class="row">
                                        <div class="col-lg-4 col-sm-8">
                                            <div class="widget-inline-box text-center">
                                                <h3 class="m-t-10"><i class="text-primary mdi mdi-cellphone-link"></i> <b>8954</b></h3>
                                                <p class="text-muted">Students Registred</p>
                                            </div>
                                        </div>

                                        <div class="col-lg-4 col-sm-8">
                                            <div class="widget-inline-box text-center">
                                                <h3 class="m-t-10"><i class="text-custom mdi mdi-airplay"></i> <b>7841</b></h3>
                                                <p class="text-muted">Companies Registred</p>
                                            </div>
                                        </div>

                                        <div class="col-lg-4 col-sm-8">
                                            <div class="widget-inline-box text-center">
                                                <h3 class="m-t-10"><i class="text-info mdi mdi-counter"></i> <b>6521</b></h3>
                                                <p class="text-muted">Internships Total</p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end row -->
<br><br>

                        <div class="row">
                            <div class="col-12">
                                <div class="card-box">
                                    <div class="table-responsive">
                                        <br>
                                        <table id="datatable" class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th><div class="height15"></div></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                            </thead>


                                            <tbody>
                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-1.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-3.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-4.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-5.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-6.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-4.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-6.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td><div class="notbell ti-bell"></div></td>

                                                <td>
                                                    <div class="centra"><img src="../../assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                        <br>
                                                        Company / Student Name
                                                    </div>
                                                </td>

                                                <td>Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...</td>

                                                <td>
                                                    <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end row -->


                    </div> <!-- container -->

<br><br><br><br><br>

                     <#include "/WEB-INF/views/FreeMarker/footer.ftl">

                </div> <!-- content -->

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- jQuery  -->
        <script src="../../assets/js/jquery.min.js"></script>
        <script src="../../assets/js/popper.min.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/metisMenu.min.js"></script>
        <script src="../../assets/js/waves.js"></script>
        <script src="../../assets/js/jquery.slimscroll.js"></script>

        <!-- Required datatable js -->
        <script src="../../assets/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="../../assets/plugins/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="../../assets/plugins/datatables/dataTables.buttons.min.js"></script>
        <script src="../../assets/plugins/datatables/buttons.bootstrap4.min.js"></script>
        <script src="../../assets/plugins/datatables/jszip.min.js"></script>
        <script src="../../assets/plugins/datatables/pdfmake.min.js"></script>
        <script src="../../assets/plugins/datatables/vfs_fonts.js"></script>
        <script src="../../assets/plugins/datatables/buttons.html5.min.js"></script>
        <script src="../../assets/plugins/datatables/buttons.print.min.js"></script>

        <!-- Key Tables -->
        <script src="../../assets/plugins/datatables/dataTables.keyTable.min.js"></script>

        <!-- Responsive examples -->
        <script src="../../assets/plugins/datatables/dataTables.responsive.min.js"></script>
        <script src="../../assets/plugins/datatables/responsive.bootstrap4.min.js"></script>

        <!-- Selection table -->
        <script src="../../assets/plugins/datatables/dataTables.select.min.js"></script>

        <!-- App js -->
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {

                // Default Datatable
                $('#datatable').DataTable();

                //Buttons examples
                var table = $('#datatable-buttons').DataTable({
                    lengthChange: false,
                    buttons: ['copy', 'excel', 'pdf']
                });

                // Key Tables

                $('#key-table').DataTable({
                    keys: true
                });

                // Responsive Datatable
                $('#responsive-datatable').DataTable();

                // Multi Selection Datatable
                $('#selection-datatable').DataTable({
                    select: {
                        style: 'multi'
                    }
                });

                table.buttons().container()
                        .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
            } );

        </script>

        <!-- Notifications -->
        <script>


/*
             MODIFICHE DA APPORTARE NELLO SCRIPT: NUOVO SCHEMA RAPPRESENTAZIONE NOTIFICA + DELETE_BUTTON:

            <div class="row">
                    <div class="col-md-11">
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-info"><i class="mdi mdi-account-plus"></i></div>
                            <p class="notify-details">New user registered.<small class="text-muted">5 hours ago</small></p>
                        </a>
                    </div>

                    <div class="col-md-1">
                        <button class="btn dltbtnhead" data-target="#" title="Delete"><img class="dltheadwidth" src="../../assets/images/dlt_ico2.png"></button>
                    </div>
             </div>

*/

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

                        table += '<a href="viewProfile?type=company&id='+product.id_azienda+'"'+'class="dropdown-item notify-item">';
                        table += '<div class="row">';
                        table += '<div class="col-md-11">';
                        table += '<div class="notify-icon bg-success"><i class="mdi mdi-comment-account-outline"></i></div>';
                        table += '<p class="notify-details">' + product.testo + '</p>';
                        table += '</div>';
                        table += '<div class="col-md-1">';
                        table += '<button class="btn dltbtnhead" data-target="#" title="Delete" onclick="delete_notification()" data-answerid= "'+ product.id_notifica +'" ><img class="dltheadwidth" src="../../assets/images/dlt_ico2.png"></button>';
                        table += '</div>';
                        table += '</div>';
                        table += '</a>';
                    });

                    $('#notifications_show').html(table);
                });
            }

            function getNotificationCount() {
                $.get("notify.do?action=getCount", function(responseText) {  // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#notifications_count").text(responseText);            // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            }

            function delete_notification() {
                var answerid;
                answerid = $(this).attr("data-answerid");
                $.get('notify.do?action=delete&id=' + answerid, function (data) {
                    getNotificationCount();
                    refreshNotifications();
                });
            }


            /*onclick event*/
            $(document).on("click", "float-right-custom", function(){
                $.get("notify.do?action=delete&id=all", function(responseText) {
                    getNotificationCount();
                    refreshNotifications();
                });
            });

        </script>

    </body>
</html>