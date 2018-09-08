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


<#include "/WEB-INF/views/FreeMarker/header.ftl">


<#include "/WEB-INF/views/FreeMarker/sidebar_company.ftl">


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
<br>
                                 <h4 class="header-title m-t-0 m-b-20">Company's Homepage</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->
<br><br>


<!--TODO  GESTIRE LA LUNGHEZZA DEI CARATTERI NEL DB DELLA SEDE LEGALE E NUMERO DEI TIROCINI PE RLA GRANDEZZA DELLE FINESTRE HOME -->


<!--Add Internship-->
                        <div class="row">
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">
                                       
                                        <h5 class="m-b-5 mt-2">Add Internship</h5>

                                        <div class="container containeradd_dim">
                                            <td><a href="/internships?view=add"><button type="button" class="btn btnadd"><img class="imgadddim" src="assets/images/users/add3.1.png"></button></a></td>
                                        
                                        </div>                                        

                                    </div>

                                </div>

                            </div> <!-- end col -->
                             <#if internships_list_company?has_content>
<!--Internship 1-->         <#list internships_list_company as val>
                            <div class="col-md-4">
                                <div class="text-center card-box">
                                    <div class="member-card mt-1">

                                        <h5 class="m-b-5 mt-2">${val.getNome()}</h5>

                                         <div class="container container_dim">
                                           <p class="text-muted font-13">
                                           <div class="legspace"><row class="col-xs-6"> <i>Start Month: </i><br> ${val.getMeseInziale()} </row></div> <br>

                                           <div class="legspace"><row class="col-xs-6"> <i>End Month: </i><br> ${val.getMeseFinale()} </row></div>
                                        </p>
                                        </div>

                                        <td><a href="/internships?view=${val.getIternship_id()}"><button type="button" class="btn btn-default btn-sm m-t-10">See Details</button></a></td>

                                    </div>

                                </div>

                            </div> <!-- end col -->


                    </#list>
                             </#if>



                    </div> <!-- container -->
<br><br>
                     

                        </div>
                        <!-- end row -->

                     <#include "/WEB-INF/views/FreeMarker/footer.ftl">

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

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

    </body>
</html>