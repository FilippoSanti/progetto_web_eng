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
        <link rel="shortcut icon" href="../assets/images/favicon.ico">

        <!-- Plugins css-->
        <link href="../assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link rel="stylesheet" href="../assets/plugins/switchery/switchery.min.css">
        <link href="../assets/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="../assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
        <link href="../assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
        <link href="../assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
        <link href="../assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
        <link href="../assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- Summernote css -->
        <link href="../assets/plugins/summernote/summernote-bs4.css" rel="stylesheet" />

        <!-- App css -->
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="../assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="../assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="../assets/js/modernizr.min.js"></script>

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
                            <img src="../assets/images/logo.png" alt="">
                        </span>
                        <i>
                            <img src="../assets/images/logo_sm.png" alt="">
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
                                <img src="../assets/images/users/avatar-1.jpg" alt="user" class="rounded-circle"> <span class="ml-1">Anderson <i class="mdi mdi-chevron-down"></i> </span>
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
                        <img src="../assets/images/users/avatar-1.jpg" alt="" class="thumb-md rounded-circle">
                    </div>
                    <div class="user-info">
                        <a href="#">Student Name</a>
                        <p class="text-muted m-0">Student</p>
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
                            <a href="javascript: void(0);"><i class="ti-user"></i> <span> My Profile </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="../my_account_student.html">My Account</a></li>
                                <li><a href="../edit_student_infos.html">Edit Informations</a></li>
                                <li><a href="../my_internship.html">Manage Internships</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="../companies_list.html"><i class="ti-list"></i><span> Companies List </span>
                            </a>
                        </li>                        


                        <li>
                            <a href="../internships_list.html"><i class="ti-menu-alt"></i> <span> Internships List </span>
                            </a>
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
                            <div class="col-md-4"></div> 
                            <div class="col-md-4"><h4 class="header-title centra">Internship Details</h4></div> 
                            <div class="col-lg-4"></div>
                        </div>
<br>

                        <div class="p-20 m-b-20">

                            <div class="form-group">
                                <label class="col-md-2 col-form-label">Offer Details</label>
                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="container intrnshpdtls"> ${internshipData.getDettagli()} </div>
                                    </div>
                                </div>
                            </div>
<br>

<!--  Usare:
             disbled                come ultimo campo di input se la casella da disabilitare NON DEVE essere flaggata
             disabled checked       come ultimo campo di input se la casella da disabilitare DEVE essere flaggata  -->

                            <div class="form-group">
                                <label class="col-md-12 col-form-label">Place</label>

                                <div class="checkbox form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" id="inlineCheckbox1" value="option1" disabled checked>
                                    <label for="inlineCheckbox1"> Company Headquarters </label>
                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" id="inlineCheckbox2" value="option1" disabled checked >
                                    <label for="inlineCheckbox2"> Remote Connection (from home) </label>
                                </div>
                                <div class="checkbox checkbox-pink form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" id="inlineCheckbox3" value="option1" disabled>
                                    <label for="inlineCheckbox3"> Other </label>
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="container intrnshpdtls mrgnlft15px">${internshipData.getLuogo()}  </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
<br>
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-3 col-form-label">Months</label>

                                        <div class="row">
                                            <div class="container intrnshpdtls mrgnlft15px">${internshipData.getMesi()}  </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-1"></div>
                                
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-3 col-form-label">Hours</label>
                                        <div class="row">
                                            <div class="container intrnshpdtls mrgnlft15px">${internshipData.getOre()}</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-1"></div>

                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-3 col-form-label">Timetables</label>
                                        <div class="row">
                                            <div class="container intrnshpdtls mrgnlft15px">${internshipData.getOrari()}</div>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>
<br>
                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="form-group">
                                        <div class="row">
                                        <div class="col-md-3 mrglbladdint">
                                            <label>Start Date</label>                                           
                                        </div>
                                        <div class="col-md-1"></div>
                                        <div class="col-md-3">
                                            <label>End Date</label>
                                        </div>

                                        </div>                                       
                                        
                                        <div>
                                            <div class="input-daterange input-group" data-date-format="dd/mm/yyyy" id="date-range">
                                                <div class="col-md-3 ">
                                                    <input type="text" class="form-control" name="start date" disabled placeholder="dd-mm-yyyy here!" />
                                                </div>

                                                <div class="col-md-1"></div>

                                                <div class="col-md-3">
                                                    <input type="text" class="form-control" name="end date" disabled placeholder="dd-mm-yyyy here!"> </input>
                                                </div>
                                                                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
<br>
                            <div class="form-group">
                                <label class="col-md-2 col-form-label">Generic Targets</label>
                                <div class="col-md-10">
                                <div class="row">
                                    <div class="container intrnshpdtls"> ${internshipData.getObiettivi()} </div>
                                    </div>
                                </div>
                            </div>
<br>

                            <div class="form-group">
                                <label class="col-md-2 col-form-label">Work Mode</label>
                                <div class="col-md-10">
                                <div class="row">
                                    <div class="container intrnshpdtls"> ${internshipData.getModalita()} </div>
                                    </div>
                                </div>
                            </div>
<br>

<!--  Usare:
             disbled                come ultimo campo di input se la casella da disabilitare NON DEVE essere flaggata
             disabled checked       come ultimo campo di input se la casella da disabilitare DEVE essere flaggata  -->

                            <div class="form-group">
                                <label class="col-md-12 col-form-label">Refunds and/or Facilitations</label>

                                <div class="checkbox form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" id="inlineCheckbox1" value="option10" disabled>
                                    <label for="inlineCheckbox1"> Refound of Expenses </label>
                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" id="inlineCheckbox2" value="option11" disabled checked>
                                    <label for="inlineCheckbox2"> Company Refectory </label>
                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" id="inlineCheckbox2" value="option12" disabled checked>
                                    <label for="inlineCheckbox2"> Training Aid </label>
                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" id="inlineCheckbox2" value="option13" disabled>
                                    <label for="inlineCheckbox2">Nothing </label>
                                </div>
                                <div class="checkbox checkbox-pink form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" id="inlineCheckbox3" value="option14">
                                    <label for="inlineCheckbox3"> Other... </label>
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="container intrnshpdtls mrgnlft15px">${internshipData.getRimborsi_spese_facilitazioni_previste()}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                                  
                <div class="form-group formspace">             
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-3 centra">
                            <td>  <a href="/internships?view=candidate&submit=${internshipData.getIternship_id()}"><button type="addinternship" class="btn btn-primary waves-effect waves-light"> Candidates for this Internship </button>  </a></td>
                        </div>
                        <div class="col-md-3 centra">                                          
                            <button type="reset" class="btn btn-default waves-effect m-l-5"> Cancel </button>                          
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </div>


<br><br><br><br>

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
        <script src="../assets/js/jquery.min.js"></script>
        <script src="../assets/js/popper.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/metisMenu.min.js"></script>
        <script src="../assets/js/waves.js"></script>
        <script src="../assets/js/jquery.slimscroll.js"></script>

        <script src="../assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
        <script src="../assets/plugins/select2/js/select2.min.js" type="text/javascript"></script>
        <script src="../assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
        <script src="../assets/plugins/switchery/switchery.min.js"></script>
        <script type="text/javascript" src="../assets/plugins/parsleyjs/parsley.min.js"></script>

        <script src="../assets/plugins/moment/moment.js"></script>
        <script src="../assets/plugins/timepicker/bootstrap-timepicker.js"></script>
        <script src="../assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
        <script src="../assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
        <script src="../assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
        <script src="../assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script src="../assets/plugins/summernote/summernote-bs4.min.js"></script>

        <!-- form advanced init js -->
        <script src="../assets/pages/jquery.form-advanced.init.js"></script>

        <!-- App js -->
        <script src="../assets/js/jquery.core.js"></script>
        <script src="../assets/js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('.form-validation').parsley();
                $('.summernote').summernote({
                    height: 350,                 // set editor height
                    minHeight: null,             // set minimum height of editor
                    maxHeight: null,             // set maximum height of editor
                    focus: false                 // set focus to editable area after initializing summernote
                });
            });
        </script>

    </body>
</html>