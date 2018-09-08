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

        <!-- Plugins css-->
        <link href="assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/plugins/switchery/switchery.min.css">
        <link href="assets/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
        <link href="assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
        <link href="assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
        <link href="assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
        <link href="assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- Summernote css -->
        <link href="assets/plugins/summernote/summernote-bs4.css" rel="stylesheet" />

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
                            <div class="col-md-4"></div> 
                            <div class="col-md-4"><h4 class="header-title centra">Add New Internship</h4></div> 
                            <div class="col-lg-4"></div>
                            <p class="text-muted font-13 ">
                            Make sure you fill each field on the form correctly!
                            </p>
                        </div>

                        <form method="post" action="internships?view=add&submit=true" class="form-validation">

						<#if errorsList?has_content>
                <ul class="list-group">
                    <#list errorsList as item><li class="list-group-item list-group-item-danger">${item}</li></#list>
                </ul>
                </#if>


                        <div class="p-20 m-b-20">

                            <div class="form-group">
                                <label for ="sector" class="col-md-2 col-form-label">Sector</label>
                                <div class="col-md-10">
                                    <input type="text" name="settore" class="form-control" placeholder="Some text value..." value="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for ="nome" class="col-md-2 col-form-label">Internship Name</label>
                                <div class="col-md-10">
                                    <input type="text"  name="nome" class="form-control" placeholder="Some text value..." value="">
                                 </div>
                            </div>
<br>

                            <div class="form-group">
                                <label for ="dettagli" class="col-md-2 col-form-label">Offer Details</label>
                                <div class="col-md-10">
                                <textarea class="form-control"  name="dettagli" rows="3" placeholder="Type here (max 3 rows)"></textarea>
                                </div>
                            </div>
<br>
                            

                            <div class="form-group">
                                <label class="col-md-12 col-form-label">Place</label>
                                <div class="checkbox form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" name="company_headquarters" checked="unchecked" value="true">
                                    <label for="company_headquarters"> Company Headquarters </label>

                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" name="remote_connection" checked="unchecked" value="true">
                                    <label for="remote_connection"> Remote Connection (from home) </label>

                                </div>

                                <div class="form-group">
                                    <div class="row">
                                    <label for ="luogo" class="col-md-1 col-form-label ffww100">Other...</label>
                                    <div class="col-md-7">
                                        <input type="text"  name="luogo" class="form-control" placeholder="Some text value..." value="">
                                    </div>
                                </div>
                                </div>

                            </div>
<br>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for ="mesi" class="col-md-5 col-form-label">N&#176 Months</label>
                                        <select name="mesi" class="form-control mrglbladdint">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>
                                            <option>9</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-1"></div>
                                
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="ore"class="col-md-6 col-form-label">N&#176 Hours</label>
                                        <select name="orari" class="form-control">
                                            <option>10</option>
                                            <option>20</option>
                                            <option>30</option>
                                            <option>40</option>
                                            <option>50</option>
                                            <option>60</option>
                                            <option>70</option>
                                            <option>80</option>
                                            <option>90</option>
                                            <option>100</option>
                                            <option>110</option>
                                            <option>120</option>
                                            <option>130</option>
                                            <option>140</option>
                                            <option>150</option>
                                            <option>160</option>
                                            <option>170</option>
                                            <option>180</option>
                                            <option>190</option>
                                            <option>200</option>
                                            <option>210</option>
                                            <option>220</option>
                                            <option>230</option>
                                            <option>240</option>
                                            <option>250</option>
                                            <option>300</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-1"></div>

                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for ="orari"class="col-md-3 col-form-label">Timetables</label>
                                        <select name="ore" class="form-control">
                                            <option>08:00 - 12:00</option>
                                            <option>09:00 - 13:00</option>
                                            <option>10:00 - 14:00</option>
                                            <option>11:00 - 15:00</option>
                                            <option>12:00 - 16:00</option>
                                            <option>13:00 - 17:00</option>
                                            <option>14:00 - 18:00</option>
                                            <option>15:00 - 19:00</option>
                                        </select>
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
                                                    <input type="text" class="form-control" name="start_date" />
                                                </div>

                                                <div class="col-md-1"></div>

                                                <div class="col-md-3">
                                                    <input type="text" class="form-control" name="end_date" />
                                                </div>
                                                                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
<br>
                            <div class="form-group">
                                <label for ="obiettivi" class="col-md-2 col-form-label">Generic Targets</label>
                                <div class="col-md-10">
                                <textarea class="form-control" name="obiettivi" rows="3" placeholder="Type here (max 235 characters)"></textarea>
                                </div>
                            </div>
<br>

                            <div class="form-group">
                                <label for = "modalita" class="col-md-2 col-form-label">Work Mode</label>
                                <div class="col-md-10">
                                <textarea class="form-control" name="modalita" rows="3" placeholder="Type here (max 235 characters)"></textarea>
                                </div>
                            </div>
<br>

                            <div class="form-group">
                                <label class="col-md-12 col-form-label">Refunds and/or Facilitations</label>
                                <div class="checkbox form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" name="refound_of_expenses" checked="unchecked" value="true">
                                    <label for="refound_of_expenses"> Refound of Expenses </label>

                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" name="company_refactory" checked="unchecked" value="true">
                                    <label for="company_refactory"> Company Refectory </label>

                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd123">
                                    <input type="checkbox" name="training_aid" checked="unchecked" value="true">
                                    <label for="training_aid"> Training Aid </label>

                                </div>
                                <div class="checkbox checkbox-success form-check-inline mrgnlftcheckboxadd">
                                    <input type="checkbox" name="nothing" checked="unchecked" value="true">
                                    <label for="nothing">Nothing </label>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                    <label for ="rimborsi_spese_facilitazioni_previste" class="col-md-1 ffww100">Other...</label>
                                    <div class="col-md-7">
                                        <input type="text"  name="rimborsi_spese_facilitazioni_previste" class="form-control" placeholder="Some text value..." value="">
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
                            <button type="addinternship" class="btn btn-primary waves-effect waves-light"> Add Internship </button>    
                        </div>
                        <div class="col-md-3 centra">                                          
                            <button type="reset" class="btn btn-default waves-effect m-l-5"> Cancel </button>                          
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </div>
                
<br><br><br><br>
                </form>
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

        <script src="assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
        <script src="assets/plugins/select2/js/select2.min.js" type="text/javascript"></script>
        <script src="assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
        <script src="assets/plugins/switchery/switchery.min.js"></script>
        <script type="text/javascript" src="assets/plugins/parsleyjs/parsley.min.js"></script>

        <script src="assets/plugins/moment/moment.js"></script>
        <script src="assets/plugins/timepicker/bootstrap-timepicker.js"></script>
        <script src="assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
        <script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
        <script src="assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
        <script src="assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script src="assets/plugins/summernote/summernote-bs4.min.js"></script>

        <!-- form advanced init js -->
        <script src="assets/pages/jquery.form-advanced.init.js"></script>

        <!-- App js -->
        <script src="assets/js/jquery.core.js"></script>
        <script src="assets/js/jquery.app.js"></script>

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