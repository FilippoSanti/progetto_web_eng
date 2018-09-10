<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Internship Tutor</title>
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
            <div class="content-page nominheight">
                <!-- Start content -->
                <div class="content nominheight">
                    <div class="container-fluid">

                         <div class="row">
                            <div class="col-sm-4"></div>
                            <div class=" col-sm-4 centra">
                                 <h4 class="header-title m-t-0 m-b-20">Account Info</h4>
                            </div>
<br><br><br><br>
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
                                            <h5 class="m-b-5 mt-3">${companyData.getRagione_sociale()}</h5>
                                        </div>
                                        <p class="text-muted m-t-10">
                                           ${companyData.getDescrizione()}
                                    </div>

                                </div> <!-- end card-box -->

                            </div> <!-- end col -->
                        </div> <!-- end row -->

                        <div class="m-t-30">
                            <div class="tab-content">
                                <div class="tab-pane active" id="home-b1">
                                    <div class="row">

                                        <div class="col-md-1"></div>

                                        <div class="col-md-10">
                                            <!-- Information -->
                                            <div class="panel panel-default panel-fill">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Company Informations</h3>
                                                </div>

                                                <div class="container">
                                                    <div class="row">

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>Business Name/Name</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getRagione_sociale()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Legal Address</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getIndirizzo_sede_leg()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Solicitor's Name and Surname</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getNome_cognome_rap()}</p>
                                                            </div> 
                                                            <div class="m-b-20">
                                                                <strong>Internships Manager's Name and Surname</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getNome_cognome_tir()}</p>
                                                            </div>
                                                            <div class="m-b-20">
                                                                <strong>Internships Manager's Email Address</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getEmail_tirocini()}</p>
                                                            </div>
                                                        </div>

                                                        <div class="col-md-6 mrgntopcol">
                                                            <div class="m-b-20">
                                                                <strong>Fiscal Code (NIN)/Partita I.V.A. (VAT)</strong>
                                                                <br>
                                                                <p class="text-muted uppercase">${companyData.get_cf_iva()}</p>
                                                            </div>

                                                            <div class="m-b-20">
                                                                <strong>Province</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getProvincia()}</p>
                                                            </div>

                                                            <div class="m-b-20">
                                                                <strong>Login Email address</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getEmail_login()}</p>
                                                            </div>

                                                            <div class="m-b-20">
                                                                <strong>Internships Manager's Telephone Number</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getTelefono_tirocini()}</p>
                                                            </div>

                                                            <div class="m-b-20">
                                                                <strong>Competent Jurisdiction</strong>
                                                                <br>
                                                                <p class="text-muted">${companyData.getForo_competente()}</p>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Information -->
                                        </div>

                                    </div>
<br> <br>
                                    <div class="col-md-12 text-center">
                                        <a href=/internships_list?view=${companyData.getCompany_id()}> <button class="btn btn-primary btn-rounded btn-lg m-b-30">See Internship Offers</button></a>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div> <!-- container -->
<br><br>

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

    <!-- Notifications -->
    <script src="../../assets/js/notifications_table.js"></script>
    <script src="../../assets/js/bootstrap-table.js"></script>

    </body>
</html>