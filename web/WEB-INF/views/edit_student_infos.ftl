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

        <!-- Plugins css-->
        <link href="../../assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link rel="stylesheet" href="../../assets/plugins/switchery/switchery.min.css">
        <link href="../../assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">

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
                    </ul>

                </nav>

            </div>
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="user-details">
                    <div class="pull-left">
                        <img src="${image_path}" alt="" class="thumb-md rounded-circle">
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
                                 <h4 class="header-title m-t-0 m-b-20">Edit Informations</h4>
                            </div>
<br><br><br><br>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->

                        <div class="row">
                            <div class="col-md-12">
                                <div class="p-0">
                                    <div class="member-card">

                                        <#if errorMessage?has_content >
                                            <div class="alert alert-danger">
                                                <strong>Error</strong> ${errorMessage}
                                            </div>
                                        </#if>

                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="${image_path}" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>
                                        <br>
                                        <form action="upload" method ="post" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <label for="exampleFormControlFile1">Choose a profile image</label>
                                                <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Upload</button>
                                        </form>
                                    </div>

                                </div> <!-- end card-box -->
                            </div> <!-- end col -->
                        </div> <!-- end row -->

                        <div class="m-t-30">
                            <div class="tab-pane" id="profile-b1">

                                <form method="post" action="editProfile?sumbit=login" class="form-validation">

                                    <!-- Personal-Information -->
                                    <div class="panel panel-default panel-fill">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Edit Log In Informations</h3>
                                        </div>
                                        <div class="container">
                                            <div class="row">
                                                <div class="col-md-6 mrgntopcol">

                                                    <div class="form-group">
                                                        <label for="C_Username">email</label>
                                                        <input type="email" value="${userData.getEmail()}" id="C_Username" class="form-control" name="email_student">
                                                    </div>
                                                </div>

                                                <div class="col-md-6 mrgntopcol">
                                                    <div class="form-group">
                                                        <label for="edit_company_pass rippwd4">New Password</label>
                                                        <input id="edit_company_pass" type="password" placeholder="New Password" class="form-control" name="password_student">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-6"></div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="edit_company_pass_2">Repeat New Password</label>
                                                        <input id="edit_company_pass_2" type="password" placeholder="Repeat New Password" class="form-control" name="ripeti_password_student">
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                        <br><br>
                                        <div class="center-page centra">
                                            <button class="btn btn-primary waves-effect waves-light w-md" type="submit">Update</button>
                                        </div>
                                        <br>

                                    </div>
                                    <!-- Personal-Information -->
                                </form>

                                <form method="post" action="editProfile?sumbit=info" class="form-validation">
                                <div class="m-t-30">
                                <div class="tab-pane" id="profile-b1">

                                    <!-- Personal-Information -->
                                    <div class="panel panel-default panel-fill">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Edit Profile</h3>
                                        </div>
                                        <div class="container">
                                            <form role="form">
                                            <div class="row">                                            

                                <div class="col-md-6 mrgntopcol">

                                            <form role="form">
                                                <div class="form-group">
                                                    <label for="Name">Name</label>
                                                    <input type="text" value="${userData.getNome()}" id="Name" class="form-control" name="nome">
                                                </div>
                                                <div class="form-group">
                                                    <label>Birth Date<span class="text-danger">* </span><a>  (use the format: mm/dd/yyyy)</a></label>
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" value= "${userData.getDate()}" id="datepicker-autoclose" name ="data_nascita">
                                                        <div class="input-group-append">
                                                            <span class="input-group-text"><i class="mdi mdi-calendar"></i></span>
                                                        </div>
                                                    </div><!-- input-group -->
                                                </div>
                                                <div class="form-group">
                                        <label>Birth Province</label>
                                        <select class="form-control select2" name="provincia_n">
                                        <option>${userData.getProvincia_n()}</option>
                                        <option value="AG">Agrigento</option>
                                        <option value="AL">Alessandria</option>
                                        <option value="AN">Ancona</option>
                                        <option value="AO">Aosta</option>
                                        <option value="AR">Arezzo</option>
                                        <option value="AP">Ascoli Piceno</option>
                                        <option value="AT">Asti</option>
                                        <option value="AV">Avellino</option>
                                        <option value="BA">Bari</option>
                                        <option value="BL">Belluno</option>
                                        <option value="BN">Benevento</option>
                                        <option value="BG">Bergamo</option>
                                        <option value="BI">Biella</option>
                                        <option value="BO">Bologna</option>
                                        <option value="BZ">Bolzano</option>
                                        <option value="BS">Brescia</option>
                                        <option value="BR">Brindisi</option>
                                        <option value="CA">Cagliari</option>
                                        <option value="CL">Caltanissetta</option>
                                        <option value="CB">Campobasso</option>
                                        <option value="CE">Caserta</option>
                                        <option value="CT">Catania</option>
                                        <option value="CZ">Catanzaro</option>
                                        <option value="CH">Chieti</option>
                                        <option value="CO">Como</option>
                                        <option value="CS">Cosenza</option>
                                        <option value="CR">Cremona</option>
                                        <option value="KR">Crotone</option>
                                        <option value="CN">Cuneo</option>
                                        <option value="EN">Enna</option>
                                        <option value="FE">Ferrara</option>
                                        <option value="FI">Firenze</option>
                                        <option value="FG">Foggia</option>
                                        <option value="FO">Forl&igrave; - Cesena</option>
                                        <option value="FR">Frosinone</option>
                                        <option value="GE">Genova</option>
                                        <option value="GO">Gorizia</option>
                                        <option value="GR">Grosseto</option>
                                        <option value="IM">Imperia</option>
                                        <option value="IS">Isernia</option>
                                        <option value="SP">La Spezia</option>
                                        <option value="AQ">L'Aquila</option>
                                        <option value="LT">Latina</option>
                                        <option value="LE">Lecce</option>
                                        <option value="LC">Lecco</option>
                                        <option value="LI">Livorno</option>
                                        <option value="LO">Lodi</option>
                                        <option value="LU">Lucca</option>
                                        <option value="MC">Macerata</option>
                                        <option value="MN">Mantova</option>
                                        <option value="MS">Massa Carrara</option>
                                        <option value="MT">Matera</option>
                                        <option value="ME">Messina</option>
                                        <option value="MI">Milano</option>
                                        <option value="MO">Modena</option>
                                        <option value="NA">Napoli</option>
                                        <option value="NO">Novara</option>
                                        <option value="NU">Nuoro</option>
                                        <option value="OR">Oristano</option>
                                        <option value="PD">Padova</option>
                                        <option value="PA">Palermo</option>
                                        <option value="PR">Parma</option>
                                        <option value="PV">Pavia</option>
                                        <option value="PG">Perugia</option>
                                        <option value="PS">Pesaro</option>
                                        <option value="PE">Pescara</option>
                                        <option value="PC">Piacenza</option>
                                        <option value="PI">Pisa</option>
                                        <option value="PT">Pistoia</option>
                                        <option value="PN">Pordenone</option>
                                        <option value="PZ">Potenza</option>
                                        <option value="PO">Prato</option>
                                        <option value="RG">Ragusa</option>
                                        <option value="RA">Ravenna</option>
                                        <option value="RC">Reggio Calabria</option>
                                        <option value="RE">Reggio Emilia</option>
                                        <option value="RI">Rieti</option>
                                        <option value="RN">Rimini</option>
                                        <option value="RM">Roma</option>
                                        <option value="RO">Rovigo</option>
                                        <option value="SA">Salerno</option>
                                        <option value="SS">Sassari</option>
                                        <option value="SV">Savona</option>
                                        <option value="SI">Siena</option>
                                        <option value="SR">Siracusa</option>
                                        <option value="SO">Sondrio</option>
                                        <option value="TA">Taranto</option>
                                        <option value="TE">Teramo</option>
                                        <option value="TR">Terni</option>
                                        <option value="TO">Torino</option>
                                        <option value="TP">Trapani</option>
                                        <option value="TN">Trento</option>
                                        <option value="TV">Treviso</option>
                                        <option value="TS">Trieste</option>
                                        <option value="UD">Udine</option>
                                        <option value="VA">Varese</option>
                                        <option value="VE">Venezia</option>
                                        <option value="VB">Verbania-Cusio-Ossola</option>
                                        <option value="VC">Vercelli</option>
                                        <option value="VR">Verona</option>
                                        <option value="VV">Vibo Valentia</option>
                                        <option value="VI">Vicenza</option>
                                        <option value="VT">Viterbo</option>
                                    </select>
                                    </div>
                                                <div class="form-group">

                                        <label>Residence Province</label>
                                        <select class="form-control select2" name="provincia">
                                        <option>${userData.getProvincia()}</option>
                                        <option value="AG">Agrigento</option>
                                        <option value="AL">Alessandria</option>
                                        <option value="AN">Ancona</option>
                                        <option value="AO">Aosta</option>
                                        <option value="AR">Arezzo</option>
                                        <option value="AP">Ascoli Piceno</option>
                                        <option value="AT">Asti</option>
                                        <option value="AV">Avellino</option>
                                        <option value="BA">Bari</option>
                                        <option value="BL">Belluno</option>
                                        <option value="BN">Benevento</option>
                                        <option value="BG">Bergamo</option>
                                        <option value="BI">Biella</option>
                                        <option value="BO">Bologna</option>
                                        <option value="BZ">Bolzano</option>
                                        <option value="BS">Brescia</option>
                                        <option value="BR">Brindisi</option>
                                        <option value="CA">Cagliari</option>
                                        <option value="CL">Caltanissetta</option>
                                        <option value="CB">Campobasso</option>
                                        <option value="CE">Caserta</option>
                                        <option value="CT">Catania</option>
                                        <option value="CZ">Catanzaro</option>
                                        <option value="CH">Chieti</option>
                                        <option value="CO">Como</option>
                                        <option value="CS">Cosenza</option>
                                        <option value="CR">Cremona</option>
                                        <option value="KR">Crotone</option>
                                        <option value="CN">Cuneo</option>
                                        <option value="EN">Enna</option>
                                        <option value="FE">Ferrara</option>
                                        <option value="FI">Firenze</option>
                                        <option value="FG">Foggia</option>
                                        <option value="FO">Forl&igrave; - Cesena</option>
                                        <option value="FR">Frosinone</option>
                                        <option value="GE">Genova</option>
                                        <option value="GO">Gorizia</option>
                                        <option value="GR">Grosseto</option>
                                        <option value="IM">Imperia</option>
                                        <option value="IS">Isernia</option>
                                        <option value="SP">La Spezia</option>
                                        <option value="AQ">L'Aquila</option>
                                        <option value="LT">Latina</option>
                                        <option value="LE">Lecce</option>
                                        <option value="LC">Lecco</option>
                                        <option value="LI">Livorno</option>
                                        <option value="LO">Lodi</option>
                                        <option value="LU">Lucca</option>
                                        <option value="MC">Macerata</option>
                                        <option value="MN">Mantova</option>
                                        <option value="MS">Massa Carrara</option>
                                        <option value="MT">Matera</option>
                                        <option value="ME">Messina</option>
                                        <option value="MI">Milano</option>
                                        <option value="MO">Modena</option>
                                        <option value="NA">Napoli</option>
                                        <option value="NO">Novara</option>
                                        <option value="NU">Nuoro</option>
                                        <option value="OR">Oristano</option>
                                        <option value="PD">Padova</option>
                                        <option value="PA">Palermo</option>
                                        <option value="PR">Parma</option>
                                        <option value="PV">Pavia</option>
                                        <option value="PG">Perugia</option>
                                        <option value="PS">Pesaro</option>
                                        <option value="PE">Pescara</option>
                                        <option value="PC">Piacenza</option>
                                        <option value="PI">Pisa</option>
                                        <option value="PT">Pistoia</option>
                                        <option value="PN">Pordenone</option>
                                        <option value="PZ">Potenza</option>
                                        <option value="PO">Prato</option>
                                        <option value="RG">Ragusa</option>
                                        <option value="RA">Ravenna</option>
                                        <option value="RC">Reggio Calabria</option>
                                        <option value="RE">Reggio Emilia</option>
                                        <option value="RI">Rieti</option>
                                        <option value="RN">Rimini</option>
                                        <option value="RM">Roma</option>
                                        <option value="RO">Rovigo</option>
                                        <option value="SA">Salerno</option>
                                        <option value="SS">Sassari</option>
                                        <option value="SV">Savona</option>
                                        <option value="SI">Siena</option>
                                        <option value="SR">Siracusa</option>
                                        <option value="SO">Sondrio</option>
                                        <option value="TA">Taranto</option>
                                        <option value="TE">Teramo</option>
                                        <option value="TR">Terni</option>
                                        <option value="TO">Torino</option>
                                        <option value="TP">Trapani</option>
                                        <option value="TN">Trento</option>
                                        <option value="TV">Treviso</option>
                                        <option value="TS">Trieste</option>
                                        <option value="UD">Udine</option>
                                        <option value="VA">Varese</option>
                                        <option value="VE">Venezia</option>
                                        <option value="VB">Verbania-Cusio-Ossola</option>
                                        <option value="VC">Vercelli</option>
                                        <option value="VR">Verona</option>
                                        <option value="VV">Vibo Valentia</option>
                                        <option value="VI">Vicenza</option>
                                        <option value="VT">Viterbo</option>
                                    </select>
                                    </div>

                                                <div class="form-group">
                                                    <label for="Phone_Number">Residenza</label>
                                                    <input type="text" value="${userData.getResidenza()}" id="Phone_Number" class="form-control" name="residenza">
                                                </div>
                                                <div class="form-group">
                                                    <label for="Phone_Number">Telephone Number</label>
                                                    <input type="text" value="${userData.getTel()}" id="Phone_Number" class="form-control" name="telefono">
                                                </div>
                                                <div class="form-group">
                                                    <label for="Degree">Degree Course</label>
                                                    <input type="text" value="${userData.getCorso()}" id="Degree" class="form-control" name="corso">
                                                </div>
                                </div>

                                <div class="col-md-6 mrgntopcol">

                                                <div class="form-group">
                                                    <label for="cognome">Cognome</label>
                                                    <input type="text" value="${userData.getCognome()}" id="cognome" class="form-control" name="cognome">
                                                </div>
                                                <div class="form-group">
                                                    <label for="BPlace">Birth Place</label>
                                                    <input type="text" value="${userData.getLuogo_nascita()}" id="BPlace" class="form-control" name="luogo_nascita">
                                                </div>
                                                <div class="form-group">
                                                    <label for="Fiscal_Code">Fiscal Code</label>
                                                    <input type="text" value="${userData.getCod_fiscale()}" id="Fiscal_Code" class="form-control uppercase" name="codice_fiscale">
                                                </div>
                                                <div class="form-group">
                                                    <label for="City">City</label>
                                                    <input type="text" value="${userData.getCitta()}" id="City" class="form-control" name="citta">
                                                </div>
                                                <div class="form-group">
                                                    <label for="CAP">C.A.P.</label>
                                                    <input type="text" value="${userData.getCap()}" id="CAP" class="form-control" name="cap">
                                                </div>
                                              </div>
                                            </div>
                                                <br><br>
                                                <div class="center-page centra">
                                                    <button class="btn btn-primary waves-effect waves-light w-md" type="submit">Save</button>
                                                </div>
<br>
                                            </form>
                                        </div>

                                    <!-- Personal-Information -->

                                </div>

                            </div>

                        </div> <!-- container -->
                                    </form>
                                </form>

<br><br>

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
        <script src="../../assets/js/jquery.min.js"></script>
        <script src="../../assets/js/popper.min.js"></script>
        <script src="../../assets/js/bootstrap.min.js"></script>
        <script src="../../assets/js/metisMenu.min.js"></script>
        <script src="../../assets/js/waves.js"></script>
        <script src="../../assets/js/jquery.slimscroll.js"></script>
        <script src="../../assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
        <script src="../../assets/plugins/summernote/summernote-bs4.min.js"></script>
        <script src="../../assets/pages/jquery.form-advanced.init.js"></script>
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

        <!-- App js -->
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

    </body>
</html>