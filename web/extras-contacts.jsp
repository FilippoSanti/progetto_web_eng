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
                    <a href="../src/view/index.jsp" class="logo">
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
                        <li class="dropdown notification-list hide-phone">
                            <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="mdi mdi-earth"></i> English  <i class="mdi mdi-chevron-down"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    Spanish
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    Italian
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    French
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    Russian
                                </a>

                            </div>
                        </li>

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
                                    <i class="ti-lock"></i> <span>Lock Screen</span>
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
                        <li class="hide-phone app-search">
                            <form role="search" class="">
                                <input type="text" placeholder="Search..." class="form-control">
                                <a href=""><i class="fa fa-search"></i></a>
                            </form>
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
                        <a href="#">Stanley Jones</a>
                        <p class="text-muted m-0">Administrator</p>
                    </div>
                </div>

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu" id="side-menu">
                        <li class="menu-title">Navigation</li>
                        <li>
                            <a href="../src/view/index.jsp">
                                <i class="ti-home"></i><span> Dashboard </span>
                            </a>
                        </li>

                        <li>
                            <a href="ui-elements.html">
                                <i class="ti-paint-bucket"></i><span class="badge badge-custom pull-right">11</span> <span> UI Elements </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-light-bulb"></i> <span> Components </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="components-range-slider.html">Range Slider</a></li>
                                <li><a href="components-alerts.html">Alerts</a></li>
                                <li><a href="components-icons.html">Icons</a></li>
                                <li><a href="components-widgets.html">Widgets</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="typography.html">
                                <i class="ti-spray"></i> <span> Typography </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-pencil-alt"></i><span> Forms </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="forms-general.html">General Elements</a></li>
                                <li><a href="forms-advanced.html">Advanced Form</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-menu-alt"></i><span> Tables </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="tables-basic.html">Basic tables</a></li>
                                <li><a href="tables-advanced.html">Advanced tables</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="charts.html">
                                <i class="ti-pie-chart"></i><span class="badge badge-custom pull-right">5</span> <span> Charts </span>
                            </a>
                        </li>

                        <li>
                            <a href="maps.html">
                                <i class="ti-location-pin"></i> <span> Maps </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-files"></i><span> Pages </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="WEB-INF/views/login.ftlh">Login</a></li>
                                <li><a href="pages-register.html">Register</a></li>
                                <li><a href="pages-forget-password.html">Forget Password</a></li>
                                <li><a href="pages-lock-screen.html">Lock-screen</a></li>
                                <li><a href="pages-blank.html">Blank page</a></li>
                                <li><a href="pages-404.html">Error 404</a></li>
                                <li><a href="pages-confirm-mail.html">Confirm Mail</a></li>
                                <li><a href="pages-session-expired.html">Session Expired</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-widget"></i><span> Extra Pages </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="extras-timeline.jsp">Timeline</a></li>
                                <li><a href="extras-invoice.html">Invoice</a></li>
                                <li><a href="WEB-INF/views/extras-profile.ftl">Profile</a></li>
                                <li><a href="extras-calendar.html">Calendar</a></li>
                                <li><a href="extras-faqs.jsp">FAQs</a></li>
                                <li><a href="extras-pricing.html">Pricing</a></li>
                                <li><a href="extras-contacts.jsp">Contacts</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-share"></i> <span> Multi Level </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level nav" aria-expanded="false">
                                <li><a href="javascript: void(0);">Level 1.1</a></li>
                                <li><a href="javascript: void(0);" aria-expanded="false">Level 1.2 <span class="menu-arrow"></span></a>
                                    <ul class="nav-third-level nav" aria-expanded="false">
                                        <li><a href="javascript: void(0);">Level 2.1</a></li>
                                        <li><a href="javascript: void(0);">Level 2.2</a></li>
                                    </ul>
                                </li>
                            </ul>
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

                        <div class="row">
                            <div class="col-sm-12">
                                <h4 class="header-title m-t-0 m-b-20">Contacts</h4>
                            </div>
                        </div> <!-- end row -->


                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <span class="user-badge bg-warning">Founder</span>
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-1.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-success" title="verified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Kendra V. Alfaro</h5>
                                            <p class="text-muted">@CEO <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->

                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-2.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-muted" title="unverified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Mark A. McKnight</h5>
                                            <p class="text-muted">@Founder <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->

                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-3.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-success" title="verified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Robert E. Schroth</h5>
                                            <p class="text-muted">@Webdesigner <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->



                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-4.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-muted" title="unverified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Sandra D. Duby</h5>
                                            <p class="text-muted">@Manager <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->

                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <span class="user-badge bg-custom">Co-Founder</span>
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-5.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-success" title="verified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Edmund D. Barton</h5>
                                            <p class="text-muted">@Webdeveloper <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->

                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-4">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-6.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <i class="mdi mdi-information-outline member-star text-success" title="verified user"></i>
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Janene C. Cox</h5>
                                            <p class="text-muted">@Product Manager <span> | </span> <span> <a href="#" class="text-pink">websitename.com</a> </span></p>
                                        </div>

                                        <p class="text-muted font-13">
                                            Hi I'm Johnathn Deo,has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type.
                                        </p>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">Message</button>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Profile</button>

                                        <ul class="social-links list-inline m-t-30">
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                                            </li>
                                            <li class="list-inline-item">
                                                <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                                            </li>
                                        </ul>

                                    </div>

                                </div>

                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

                        <div class="row">
                            <div class="col-sm-12 text-center">
                                <button class="btn btn-primary btn-rounded btn-lg m-b-30" data-toggle="modal" data-target="#add-contact">Add Contact</button>
                            </div><!-- end col -->
                        </div>
                        <!-- end row -->


                    </div> <!-- container -->


                    <div class="footer">
                        <div class="pull-right hide-phone">
                            Project Completed <strong class="text-custom">57%</strong>.
                        </div>
                        <div>
                            <strong>Simple Admin</strong> - Copyright © 2017 - 2018
                        </div>
                    </div>

                </div> <!-- content -->

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- sample modal content -->
        <div id="add-contact" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="add-contactLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="add-contactLabel">Add Contact</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" placeholder="Enter name">
                            </div>
                            <div class="form-group">
                                <label for="position">Position</label>
                                <input type="text" class="form-control" id="position" placeholder="Enter position">
                            </div>
                            <div class="form-group">
                                <label for="company">Company</label>
                                <input type="text" class="form-control" id="company" placeholder="Enter company">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default " data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary ">Save</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->




        <!-- jQuery  -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/metisMenu.min.js"></script>
        <script src="assets/js/waves.js"></script>
        <script src="assets/js/jquery.slimscroll.js"></script>

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

    </body>
</html>