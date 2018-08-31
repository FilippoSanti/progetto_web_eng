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



 <#include "/WEB-INF/views/FreeMarker/header_admin.ftl">


 <#include "/WEB-INF/views/FreeMarker/sidebar_admin.ftl">


            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <div class="row">
                        	<div class="col-sm-4"></div>
                            <div class="col-sm-4 centra">
                                <h4 class="header-title m-t-0 m-b-20">Agreements Requests</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div>

                        <#if Message?has_content>
                        <div class="alert alert-success" role="alert">
                            ${Message}
                        </div>
                        </#if>

                        <br><br><br>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box">
                                    <h6 class="m-t-0 agrmnts">Agreements Requests List</h6>
                                    <div class="table-responsive">

                                    <#if errorMessage?has_content>

                                        <div class="alert alert-danger" role="alert">
                                            ${errorMessage}
                                        </div>

                                    </#if>
                                        <table class="table table-hover centra">
                                            <tbody>

                                            <#if companiesList?has_content>
                                                <#list companiesList as val>

                                            <tr>
                                                <td>
                                                    <div class="notbell pdom ti-help"></div>
                                                </td>
                                                <td>
                                                    <div class="centra"><img src="assets/images/users/avatar-2.jpg" alt="contact-img" title="contact-img" class="rounded-circle thumb-sm" />
                                                    <br>
                                                    ${val.getRagione_sociale()}
                                                	</div>
                                            	</td>
                                               <td>
                                                    <label>Legal Address: <i> ${val.getIndirizzo_sede_leg()} </i>  --   Prov: <i>${val.getProvincia()}</i>   --   Internships Manager's Email Address: <i>${val.getEmail_tirocini()}</i>  --   Fiscal Code/P. IVA: <i>${val.get_cf_iva()}</i></label>
                                                </td>
												<td>
                                                    <a href="viewProfile?type=company&id=${val.getCompany_id()}"><button class="btn btn-primary btn-lg brdrcolorblue" data-target="#"><div class="centra ti-eye"></div>Profile</button></a>
                                                </td>
                                                <td>
                                                    <a href="agreementRequests?action=approve&id=${val.getCompany_id()}"><button class="btn btn-primary btn-lg brdrcolorgreen" data-target="#"><div class="centra ti-check"></div>Approve</button></a>
                                                </td>
                                                <td>
                                                    <a href="agreementRequests?action=delete&id=${val.getCompany_id()}"><button class="btn btn-primary btn-lg brdrcolorred" data-target="#"><div class="centra ti-close"></div>Refuses</button></a></td>
                                            </tr>

                                                </#list>
                                            </#if>

                                            <br><br>
                                            </tbody>
                                        </table>
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