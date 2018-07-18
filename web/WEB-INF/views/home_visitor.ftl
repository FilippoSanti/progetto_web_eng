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
                    <a href="/home" class="logo">
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
                        <li class="dropdown notification-list hide-phone langmargin">
                            <div class="dropdown-menu dropdown-menu-right">

                                <!-- item-->
                                <a href="javascript:void(0);" class="dropdown-item">
                                    Italiano
                                </a>

                            </div>
                        </li>

<!-- Menu Account -->           
                            <li>
                               <a class="nav-link  waves-effect waves-light nav-user loginmargin"  href="/login"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="mdi mdi-login"></i> Log In 
                            </a>
                           
                        
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

            <#include "/WEB-INF/views/sidebar_visitor.ftl">

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
                                 <h4 class="header-title m-t-0 m-b-20">Visitor's Homepage</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->






<!--TODO  GESTIRE LA LUNGHEZZA DEI CARATTERI NEL DB DELLA SEDE LEGALE E NUMERO DEI TIROCINI PE RLA GRANDEZZA DELLE FINESTRE HOME -->






<!--Company 1-->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-1.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            
                                        </div>

                                            <h5 class="m-b-5 mt-2">Company 1</h5>

                                        <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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

<!--Company 2-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-2.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>

                                            <h5 class="m-b-5 mt-2">Company 2</h5>

                                         <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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

<!--Company 3-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-3.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>

                                            <h5 class="m-b-5 mt-2">Company 3</h5>
                                             <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>

                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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

<!--Company 4-->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-4.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                            
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Company 4</h5>
                                        </div>

                                       <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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

<!--Company 5-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-5.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Company 5</h5>
                                        </div>

                                       <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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


<!--Company 6-->
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="assets/images/users/avatar-6.jpg" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>

                                        <div class="">
                                            <h5 class="m-b-5 mt-2">Company 6</h5>
                                        </div>

                                        <div class="container container_dim">
                                        <p class="text-muted font-13">
                                           <div class=""><row class="col-xs-6"><i>Internship Offers: </i><br> 95825 </row></div>
                                           <div class="legspace"><row class="col-xs-6"> <i>Legal Address: </i><br> Non mi viene un indirizzo  </row></div>
                                        </p>
                                        </div>
                                        <button type="button" class="btn btn-default btn-sm m-t-10">View Company</button>

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
<!--TODO   Spegnere Prev. Page se ci si trova all prima pagina-->
                            <div class="col-md-6 text-center">
                                <button class="btn btn-primary btn-rounded btn-lg m-b-30" data-toggle="modal" data-target="#add-contact">Prev. Page</button>
                            </div><!-- end col -->

                            <div class="col-sm-6 text-center">
                                <button class="btn btn-primary btn-rounded btn-lg m-b-30" data-toggle="modal" data-target="#add-contact">Next Page</button>
                            </div><!-- end col -->

                            
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