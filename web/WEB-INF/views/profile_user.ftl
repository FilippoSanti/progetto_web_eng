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

            <!-- header -->

   <#if header == "anonymous">
       <#include "/WEB-INF/views/FreeMarker/header_visitor.ftl">
   <#elseif header == "admin">
       <#include "/WEB-INF/views/FreeMarker/header_admin.ftl">
   <#else>
       <#include "/WEB-INF/views/FreeMarker/header.ftl">
   </#if>
            <!-- sidebar menu -->
   <#if sidemenu == "anonymous">
       <#include "/WEB-INF/views/FreeMarker/sidebar_visitor.ftl">
   <#elseif sidemenu == "student">
       <#include "/WEB-INF/views/FreeMarker/sidebar_student.ftl">
   <#elseif sidemenu == "company">
       <#include "/WEB-INF/views/FreeMarker/sidebar_company.ftl">
   <#elseif sidemenu == "admin">
       <#include "/WEB-INF/views/FreeMarker/sidebar_admin.ftl">
   </#if>

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

                                            <#if user_type?has_content>
                                                <img src="/displayImage?type=${user_type}&id=${user_id}" class="rounded-circle img-thumbnail" alt="profile-image">
                                            <#else>
                                                <img src="/displayImage" class="rounded-circle img-thumbnail" alt="profile-image">
                                            </#if>
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
                                                                <p class="text-muted uppercase">${userData.getCod_fiscale()}</p>
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
                                                                <p class="text-muted">${userData.getProvincia()}</p>
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
                                </div>
                            </div>
                        </div>

                    </div> <!-- container -->


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

        <!-- App js -->
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>


        <!-- Notifications -->
        <script src="../../assets/js/notifications_table.js"></script>
        <script src="../../assets/js/bootstrap-table.js"></script>
    </body>
</html>