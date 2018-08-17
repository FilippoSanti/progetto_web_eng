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
        <link rel="shortcut icon" href="assets/images/favicon.ico">

        <!--Morris Chart CSS -->
        <link rel="stylesheet" href="assets/plugins/morris/morris.css">

        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="assets/js/modernizr.min.js"></script>

    </head>


    <body>

        <!-- Begin page -->
        <div id="wrapper">

            <#include "/WEB-INF/views/FreeMarker/header_admin.ftl">

            <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="user-details">
                    <div class="pull-left">
                        <img src="assets/images/users/avatar-1.jpg" alt="" class="thumb-md rounded-circle">
                    </div>
                    <div class="user-info">
                        <a href="#">Admin Name</a>
                        <p class="text-muted m-0">Administrator</p>
                    </div>
                </div>

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu" id="side-menu">
                        <li class="menu-title">Navigation</li>
                        <li>
                            <a href="index.html">
                                <i class="ti-home"></i><span> Dashboard </span>
                            </a>
                        </li>

                        <li>
                            <a href="companies_list.html">
                                <i class="ti-briefcase"></i><span> Companies List </span>
                            </a>
                        </li>

                         <li>
                            <a href="*.html">
                                <i class="ti-user"></i><span> Students List </span>
                            </a>
                        </li>

						<li>
                            <a href="Internships_list.html">
                                <i class="ti-menu-alt"></i><span> Internships List </span>
                            </a>
                        </li>

                        <li>
                            <a href="*.html">
                            	<i class="ti-files"></i><span> Documentation </span>
                             </a>
                        </li>

                        <li>
                            <a href="*.html">
                            	<i class="ti-stats-up"></i><span> View Statistics </span>
                             </a>
                        </li>


                        <li>
                            <a href="*.html">
                            	<i class="ti-check"></i><span> Agreements Requests </span>
                             </a>
                        </li> 

                        <li>
                            <a href="notification.html"><i class="ti-bell"></i> 
                                <span class="badge badge-custom pull-right">11</span> <span> Notifications </span>
                            </a>
                        </li>             

                       
                    </ul>

                </div>
                <!-- Sidebar -->
                <div class="clearfix"></div>

            </div>
            <!-- Left Sidebar End -->



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
                            <div class="col-sm-12">
                                <div class="card-box">
                                    <h6 class="m-t-0">Notifications</h6>
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <tbody>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	 <div class="centra ti-close red"></div> <a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-1.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	 <div class="centra ti-close red"></div> <a href="tables-advanced.html" class=" text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-3.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	<div class="centra ti-close red"></div> <a href="tables-advanced.html" class=" text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-4.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	 <div class="centra ti-close red"></div><a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-5.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	 <div class="centra ti-close red"></div><a href="tables-advanced.html" class=" text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <div class="notbell ti-bell"></div>
                                                </td>

                                                <td>

                                                    <div class="centra"><img src="assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    Company / Student Name 
                                                </div></td>

                                                <td>
                                                    Aaaaaaa aaaaaa aaaaa aaaaaaaa  aa aaa aaaa aaaaa a aaaaaaaaa a aaaaaaaa a aaa aaaamm mm mmm mmmmmmm mmm mm mm mmmm mm mmm mm m mm m mm m m  m m m mmmmm mmm mmm mmmmm mmmmm ...
                                                </td>

                                                <td>
                                                	 <div class="centra ti-close red"></div><a href="tables-advanced.html" class="text-muted"> Delete</a>
                                                </td>

                                            </tr>

                                            <tr>
                                            	<td></td>
                                            	<td></td>
                                            	<td></div><a href="notification.html" class="centa text-muted"> Vedi Tutte...</a></td>
                                            	<td></td>
                                            	<td></td>
                                            </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div> <!-- container -->

<br><br><br><br><br>

                     <div class="footer">
                        <div class="pull-right hide-phone">
                            Web Engineering Project 
                        </div>
                        <div>
                             Copyright © 2018 - <a class="ti-infinite infindim"></a>
                        </div>
                        
                            <div class="centra"> All Rights Reserved - <strong class="text-custom">Unnamed Group</strong></div>
                    </div>

                </div> <!-- content -->

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- jQuery  -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/metisMenu.min.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>

        <!--Morris Chart-->
        <script src="assets/plugins/morris/morris.min.js"></script>
        <script src="assets/plugins/raphael/raphael-min.js"></script>

        <!-- Dashboard init -->
        <script src="assets/pages/jquery.dashboard.js"></script>

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

        <!-- Notifications -->
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