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
                            <div class=" col-sm-4 centra">
                                <br>
                                 <h4 class="header-title m-t-0 m-b-20">Documentation's Iter</h4>
                            </div>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->
                    <#if errorMessage?has_content>
                     <div class="alert alert-danger" role="alert">
                         ${errorMessage}
                     </div>
                    </#if>
                    <#if Message?has_content>
                     <div class="alert alert-success" role="alert">
                         ${Message}
                     </div>
                    </#if>

                    <#if companyApproved?has_content>
                     <div class="alert alert-warning" role="alert">
                         ${companyApproved}
                     </div>
                    </#if>
                    <br><br><br>

                        <div class="m-b-20">
                            <div class="container">

                                <div class="row">

                                    <div class="col-md-3 centra">
                                        <b>STEP 1</b>                                    
                                    </div>

                                    <div class="col-md-6 centra">
                                        <i>Download this document, <ins>SIGN IT</ins> and <ins>REGISTER IT</ins> by the students secretary.</i>
                                    </div>                                    
                                </div>
                                <br><br>
                                <div class="row">

                                    <div class="col-sm-3"></div>

                                    <iframe src="/documents?type=${type}&id=${id}" style="display:none;" name="frame"></iframe>

                                    <div class="centra">
                                        <a href="javascript:frames['frame'].print()" class="btn btn-dark waves-effect waves-light"><i class="fa fa-print"></i> Download</a>
                                        <a href="/documents?type=${type}&id=${id}"><button type="button" class="btn btn-outline-secondary">View document</button></a>
                                    </div>
                                </div>
                                <br><br>
                                <br><br>
                                <br>
                                <div class="row">
                                    <div class="col-md-3 centra">
                                        <b>STEP 2</b>                                    
                                    </div>
                                    <div class="col-md-6 centra">
                                        <i>Be sure to upload the document only after it has been properly <ins>SIGNED</ins> and <ins>REGISTERED</ins>.</i>
                                    </div>                                    
                                </div>
                                <br><br>
                                <div class="row">
                                    <div class="col-sm-3"></div>
                                    <form action="viewDocumentation?action=upload&type=${type}&id=${id}" method ="post" enctype="multipart/form-data">
                                    <div class="centra">
                                        <input type="file" name="file" class="filestyle" data-input="false">
                                        <button type="submit" class="btn btn-secondary">Upload</button>
                                    </div>
                                    </form>
                                </div>
                                <br><br>
                                <br><br><br>
                                <div class="row">
                                    <div class="col-md-3 centra">
                                        <b>STEP 3</b>                                    
                                    </div>
                                    
                                    <div class="col-md-6 centra">
                                        <i>A company can be enabled <ins>ONLY</ins> after uploading the signed document</i>
                                    </div>                                    
                                </div>
                                <br><br>
                                <div class="row">
                                    <div class="col-sm-3"></div>

                                <#if approveButton?has_content>
                                    <a href="agreementRequests?action=approve&id=${id}"><button class="btn btn-primary btn-rounded btn-lg m-b-30" data-target="validateCompany">Validate Company</button></a>
                                <#else>
                                    <button class="btn btn-primary btn-rounded btn-lg m-b-30" data-target="validateCompany" disabled>Upload the documentation first</button>
                                </#if>
                                </div>
                            </div>
                        </div>
                    </div> <!-- container -->

                    <br><br>


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

            <!-- Notifications -->
            <script src="../../assets/js/notifications_table.js"></script>
        <script src="../../assets/js/bootstrap-table.js"></script>


    </body>
</html>