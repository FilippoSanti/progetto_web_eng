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

    <!-- DataTables -->
    <link href="../../assets/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
    <!-- Responsive datatable examples -->
    <link href="../../assets/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />

    <!-- Multi Item Selection examples -->
    <link href="../../assets/plugins/datatables/select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

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


   <#include "/WEB-INF/views/FreeMarker/header.ftl">

    <!-- sidebar menu -->
   <#if sidemenu == "student">
       <#include "/WEB-INF/views/FreeMarker/sidebar_student.ftl">
   <#elseif sidemenu == "company">
       <#include "/WEB-INF/views/FreeMarker/sidebar_company.ftl">
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
                        <br>
                        <h4 class="header-title m-t-0 m-b-20">Manage Internship</h4>
                    </div>
                    <div class="col-md-4"></div>
                </div> <!-- end row -->
                <br><br><br>

                <#if Message?has_content>
                <div class="alert alert-warning" role="alert">
                ${Message}
                </div>
                </#if>

                <div class="m-b-20">
                    <div class="row">
                        <div class="col-md-6 centra text-center">
                            <b>Internship Status:</b> (<i class="interstatus1">${tirocinio}</i>)
                        </div>
                        <div class="col-md-6 centra text-center">
                            <b>End Date:</b> <i>${dataFinale}</i>
                        </div>
                    </div>

                    <#if intAccepted?has_content>

                    <br><br>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <h6 class="font-14 mt-4 margdoc">Documentation</h6>
                                <table class="table table-striped m-0 centra text-center">
                                    <br>
                                    <tbody>
                                    <tr>
                                        <th>Allegato_1.pdf</th>
                                        <td><a href="/documents?action=iter&student_id=${user_id}&internship_id=${internship_id}">View Iter & Download</a></td>
                                    </tr>
                                    <tr>
                                        <th>Allegato_2.pdf</th>
                                        <td><a href="/documents?action=document1_2&&id=50">View Iter & Download</a></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-1"></div>

                    </div>
                    <br><br>
                </#if>

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

<!-- Required datatable js -->
<script src="../../assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../assets/plugins/datatables/dataTables.bootstrap4.min.js"></script>
<!-- Buttons examples -->
<script src="../../assets/plugins/datatables/dataTables.buttons.min.js"></script>
<script src="../../assets/plugins/datatables/buttons.bootstrap4.min.js"></script>
<script src="../../assets/plugins/datatables/jszip.min.js"></script>
<script src="../../assets/plugins/datatables/pdfmake.min.js"></script>
<script src="../../assets/plugins/datatables/vfs_fonts.js"></script>
<script src="../../assets/plugins/datatables/buttons.html5.min.js"></script>
<script src="../../assets/plugins/datatables/buttons.print.min.js"></script>

<!-- Key Tables -->
<script src="../../assets/plugins/datatables/dataTables.keyTable.min.js"></script>

<!-- Responsive examples -->
<script src="../../assets/plugins/datatables/dataTables.responsive.min.js"></script>
<script src="../../assets/plugins/datatables/responsive.bootstrap4.min.js"></script>

<!-- Selection table -->
<script src="../../assets/plugins/datatables/dataTables.select.min.js"></script>

<!-- App js -->
<script src="../../assets/js/jquery.core.js"></script>
<script src="../../assets/js/jquery.app.js"></script>

<script type="text/javascript">
    $(document).ready(function() {

        // Default Datatable
        $('#datatable').DataTable();

        //Buttons examples
        var table = $('#datatable-buttons').DataTable({
            lengthChange: false,
            buttons: ['copy', 'excel', 'pdf']
        });

        // Key Tables

        $('#key-table').DataTable({
            keys: true
        });

        // Responsive Datatable
        $('#responsive-datatable').DataTable();

        // Multi Selection Datatable
        $('#selection-datatable').DataTable({
            select: {
                style: 'multi'
            }
        });

        table.buttons().container()
                .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
    } );

</script>


</body>
</html>