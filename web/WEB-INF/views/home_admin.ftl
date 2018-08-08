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

            <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="index.html" class="logo">
                        <span>
                            <img src="assets/images/logo.png" alt="">
                        </span>
                        <i>
                            <img src="assets/images/logo_sm.png" alt="">
                        </i>
                    </a>
                </div>

                <nav class="navbar-custom">

                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="mdi mdi-bell noti-icon"></i>
                                <span class="badge badge-danger badge-pill noti-icon-badge">4</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h6 class="m-0"><span class="float-right"><a href="" class="text-dark"><small>Clear All</small></a> </span>Notification</h6>
                                </div>

                                <div class="slimscroll" style="max-height: 190px;">
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-success"><i class="mdi mdi-comment-account-outline"></i></div>
                                        <p class="notify-details">Caleb Flakelar commented on Admin<small class="text-muted">1 min ago</small></p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-info"><i class="mdi mdi-account-plus"></i></div>
                                        <p class="notify-details">New user registered.<small class="text-muted">5 hours ago</small></p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-danger"><i class="mdi mdi-heart"></i></div>
                                        <p class="notify-details">Carlos Crouch liked <b>Admin</b><small class="text-muted">3 days ago</small></p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-warning"><i class="mdi mdi-comment-account-outline"></i></div>
                                        <p class="notify-details">Caleb Flakelar commented on Admin<small class="text-muted">4 days ago</small></p>
                                    </a>

                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-custom"><i class="mdi mdi-heart"></i></div>
                                        <p class="notify-details">Carlos Crouch liked <b>Admin</b><small class="text-muted">13 days ago</small></p>
                                    </a>
                                </div>

                                <!-- All-->
                                <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                                    View all <i class="fi-arrow-right"></i>
                                </a>

                            </div>
                        </li>

                        <li class="dropdown notification-list">
                            <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <img src="assets/images/users/avatar-1.jpg" alt="user" class="rounded-circle"> <span class="ml-1">Anderson <i class="mdi mdi-chevron-down"></i> </span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h6 class="text-overflow m-0">Welcome !</h6>
                                </div>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="ti-user"></i> <span>My Account</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="ti-settings"></i> <span>Settings</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="ti-power-off"></i> <span>Logout</span>
                                </a>

                            </div>
                        </li>

                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left waves-light waves-effect">
                                <i class="mdi mdi-menu"></i>
                            </button>
                        </li>
                    </ul>

                </nav>

            </div>
            <!-- Top Bar End -->


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

    </body>
</html>