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


            <!-- header -->
 <#if header == "student">
     <#include "/WEB-INF/views/FreeMarker/header.ftl">
 <#elseif header == "admin">
     <#include "/WEB-INF/views/FreeMarker/header_admin.ftl">
 </#if>

            <!-- sidebar menu -->
   <#if sidemenu == "student">
       <#include "/WEB-INF/views/FreeMarker/sidebar_student.ftl">
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
                            <div class="col-md-4"></div> 
                            <div class="col-md-4"><h4 class="header-title centra">Internship Details</h4></div> 
                            <div class="col-lg-4"></div>
                        </div>
<br>

                        <div class="p-20 m-b-20">

                            <div class="form-group">
                                <label class="col-md-2 col-form-label">Sector</label>
                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="container intrnshpdtls"> ${internshipData.getSettore()} </div>
                                    </div>
                                </div>
                            </div>

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
                                                    <input type="text" class="form-control" name="start date" disabled placeholder="${internshipData.getMeseInziale()}" />
                                                </div>

                                                <div class="col-md-1"></div>

                                                <div class="col-md-3">
                                                    <input type="text" class="form-control" name="end date" disabled placeholder="${internshipData.getMeseFinale()}"> </input>
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
                                    <input type="checkbox" id="inlineCheckbox3" value="option14" disabled>
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
                        <td>  <a href="/internships?view=candidatePage&submit=${internshipData.getIternship_id()}"><button type="submit" class="btn btn-primary waves-effect waves-light"> Candidate for this Internship </button>  </a></td>
                        </div>

                        <div class="col-md-3"></div>
                    </div>
                </div>
<br><br><br><br>

                    <#include "/WEB-INF/views/FreeMarker/footer.ftl">

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