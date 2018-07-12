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

            <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="../../index.html" class="logo">
                        <span>
                            <img src="../../assets/images/logo.png" alt="">
                        </span>
                        <i>
                            <img src="../../assets/images/logo_sm.png" alt="">
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
                                <img src="../../assets/images/users/avatar-1.jpg" alt="user" class="rounded-circle"> <span class="ml-1">Anderson <i class="mdi mdi-chevron-down"></i> </span>
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
                        <img src="../../assets/images/users/avatar-1.jpg" alt="" class="thumb-md rounded-circle">
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
                            <a href="../../index.html">
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
                                <li><a href="../../pages-login.html">Login</a></li>
                                <li><a href="../../pages-register.html">Register</a></li>
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
                                <li><a href="extras-timeline.html">Timeline</a></li>
                                <li><a href="extras-invoice.html">Invoice</a></li>
                                <li><a href="extras-profile.html">Profile</a></li>
                                <li><a href="extras-calendar.html">Calendar</a></li>
                                <li><a href="extras-faqs.html">FAQs</a></li>
                                <li><a href="extras-pricing.html">Pricing</a></li>
                                <li><a href="extras-contacts.html">Contacts</a></li>
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
                            <div class="col-sm-4"></div>
                            <div class=" col-sm-4 centra">
                                 <h4 class="header-title m-t-0 m-b-20">My Account</h4>
                            </div>
                            <br><br>
                             <br><br>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->

                        <div class="row">
                            <div class="col-md-12">
                                <div class="p-0 text-center">
                                    <div class="member-card">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="${image_path}" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-3">${userData.getNome()} ${userData.getCognome()}</h5>
                                        </div>
                                    </div>

                                </div> <!-- end card-box -->

                            </div> <!-- end col -->
                        </div> <!-- end row -->

                        <div class="m-t-30">
                            <div class="tab-content">
                                <div class="tab-pane active" id="home-b1">
                                    <div class="row">

                                        <div class="col-md-1"></div>


                                        <#if errorMessage?has_content>

                                        <div class="alert alert-danger" role="alert">
                                            ${errorMessage}
                                        </div>

                                        </#if>

                                        <div class="col-md-10">
                                            <!-- Personal-Information -->
                                            <div class="panel panel-default panel-fill">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Personal Informations</h3>
                                                </div>

                                                <div class="container">
                                                    <div class="row">

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>Name</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getNome()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Birth Date</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getDate()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Birth Prov</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getProvincia_n()}</p>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>Surname</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getCognome()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Birth Place</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getLuogo_nascita()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Fiscal Code</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getCod_fiscale()}</p>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            </div>
                                            <!-- Personal-Information -->

                                            <!-- Social -->
                                            <div class="panel panel-default panel-fill">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Others Informations</h3>
                                                </div>

                                                <div class="container">
                                                    <div class="row">

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>Address</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getResidenza()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Resident Prov</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getResidenza()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Telephone Number</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getTel()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Degree Course</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getCorso()}</p>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>City</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getCitta()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>C.A.P.</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getCap()}</p>
                                                            </div><div class="m-b-20">
                                                                <strong>E-mail</strong>
                                                                <br>
                                                                <p class="text-muted">${userData.getEmail()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Handicap</strong>
                                                                <br>
                                                                <p class="text-muted">

                                                                <#if userData.isHandicap() == true>
                                                                <p class="text-muted">Yes</p>

                                                                <#else>
                                                                <p class="text-muted">No</p>
                                                                </#if>
                                                             </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Social -->
                                        </div>

                                        <div class="col-md-1"></div>

                                    </div>
                                    <div class="row">
                                    <div class="col-md-5"></div>
                                    <div class="col-md-2 text-center">
                                        <button class="btn btn-primary btn-rounded btn-lg" data-toggle="modal" data-target="#add-contact">Edit Informations</button>
                                    <div class="col-md-5"></div>
                                    </div><!-- end col -->
                                </div>
                                </div>
                            </div>
                        </div>

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



        <!-- jQuery  -->
        <script src="../../assets/js/jquery.min.js"></script>
        <script src="../../assets/js/popper.min.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/metisMenu.min.js"></script>
        <script src="../../assets/js/waves.js"></script>
        <script src="../../assets/js/jquery.slimscroll.js"></script>

        <!-- App js -->
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

    </body>
</html>