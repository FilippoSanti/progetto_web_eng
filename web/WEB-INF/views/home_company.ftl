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
<!-- Scelta lingua -->
                        <li class="dropdown notification-list hide-phone">
                            <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="mdi mdi-earth"></i> English  <i class="mdi mdi-chevron-down"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    Italiano
                                </a>

                            </div>
                        </li>
<!-- Gestione Notifiche -->
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

                                <div class="slimscroll" style="max-height: 200px;">
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
<!-- Menu Account -->
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
                                <a href="extras-profile.html" class="dropdown-item notify-item">
                                    <i class="ti-user"></i> <span>My Account</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="ti-settings"></i> <span>My Internship</span>
                                </a>

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item notify-item">
                                    <i class="ti-power-off"></i> <span>Logout</span>
                                </a>

                            </div>
                        </li>
                    </ul>
<!-- Nascondi menù laterale sinistro -->
                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left waves-light waves-effect">
                                <i class="mdi mdi-menu"></i>
                            </button>
                        </li>
<!-- Ricerca -->
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
                        <a href="#">Company Name</a>
                        <p class="text-muted m-0">Company</p>
                    </div>
                </div>

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu" id="side-menu">
                        <li class="menu-title">Navigation</li>
                        <li>
                            <a href="index.html">
                                <i class="ti-home"></i><span> Homepage </span>
                            </a>
                        </li>

                        <li>
                            <a href="internships_list.html"><i class="ti-menu-alt"></i> <span> Internship List </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-user"></i> <span> Company Profile </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="account_info_company.html">Account Info</a></li>
                                <li><a href="*.html">Edit Informations</a></li>
                                <li><a href="*.html">Documents</a></li>
                            </ul>
                        </li>                        

                         <li>
                            <a href="extras-timeline.html"><i class="ti-bell"></i> 
                                <span class="badge badge-custom pull-right">11</span> <span> Notifications </span>
                            </a>
                        </li>

                        <li>
                            <a href="extras-contacts.html"><i class="ti-info"></i> <span> Contacts </span>
                            </a>
                        </li>

                        <li>
                            <a href="extras-faqs.html"><i class="ti-light-bulb"></i> <span> FAQs </span>
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

                        <div class="row">
                            <div class="col-sm-4"></div>
                            <div class=" col-sm-4 centra">
                                 <h4 class="header-title m-t-0 m-b-20">Company's Homepage</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->






<!--TODO  GESTIRE LA LUNGHEZZA DEI CARATTERI NEL DB DELLA SEDE LEGALE E NUMERO DEI TIROCINI PE RLA GRANDEZZA DELLE FINESTRE HOME -->






<!--Add Internship-->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                       
                                        <h5 class="m-b-5 mt-2">Add Internship</h5>

                                        <div class="container containeradd_dim">
                                        	<button type="button" class="btn btnadd"><img class="imgadddim" src="assets/images/users/add3.1.png"></button>
                                        
                                        </div>                                        

                                    </div>

                                </div>

                            </div> <!-- end col -->

<!--Internship 1-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 01</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 15  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>

                                    </div>

                                </div>

                            </div> <!-- end col -->

<!--Internship 2-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <h5 class="m-b-5 mt-2">Internship n° 02</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 25  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>

                                    </div>

                                </div>

                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

<!--Internship 3-->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 03</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 05  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
      
                                    </div>
                                </div>

                            </div> <!-- end col -->

<!--Internship 4-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 04</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 19  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
                                        
                                    </div>

                                </div>

                            </div> <!-- end col -->


<!--Internship 5-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 05</h5>
                                        
 										<div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 27  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
                                    </div>
                                </div>

                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

<!--Internship 6-->
                         <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 06</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 13  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
      
                                    </div>
                                </div>

                            </div> <!-- end col -->

<!--Internship 7-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 07</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 52  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
                                        
                                    </div>

                                </div>

                            </div> <!-- end col -->


<!--Internship 8-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">Internship n° 08</h5>
                                        
 										<div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Online Since: </i><br> dd/mm/yyyy  </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>N° Requests: </i><br> 64  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">See Details</button>
                                        
                                    </div>
                                </div>

                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->


<br><br>

                    </div> <!-- container -->


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