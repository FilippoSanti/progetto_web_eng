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


           <#include "/WEB-INF/views/FreeMarker/header.ftl">

           <#include "/WEB-INF/views/FreeMarker/sidebar_student.ftl">


            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-md-4"></div> 
                            <div class="col-md-4"><h4 class="header-title centra">Candidates for this Internship</h4></div> 
                            <div class="col-lg-4"></div>
                            <p class="text-muted font-13 ">
                            Make sure you fill each field on the form correctly!
                            </p>
                        </div>
<br>
                        <form method="post" action="/internships?view=candidate&submit=${userId}" class="form-validation">
                        <div class="p-20 m-b-20">

                            <div class="form-group col-md-2">
                                <label class="col-form-label">Quantity of CFU</label>
                                 <select name ="cfu" class="form-control" >
                                            <option>3</option>
                                            <option>6</option>
                                            <option>12</option>                                            
                                </select>
                            </div>
<br>


                            <div class="row">

                                <div class="col-md-4">
                                    <div class="form-group mrgnacceptint">
                                    <label for="tutor_name">Name of the Chosen University Tutor</label>
                                    <input type="text" name="tutor_name" parsley-trigger="change" required
                                    placeholder="Enter Name of the Chosen University Tutor" class="form-control" id="nametutor">
                                    </div>                                    

                                </div>

                                <div class="col-md-2"></div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                    <label for="tutor_surname">Surname of the Chosen University Tutor</label>
                                    <input type="text" name="tutor_surname" parsley-trigger="change" required
                                    placeholder="Enter Surname of the Chosen University Tutor" class="form-control" id="surnametutor">
                                </div> 
                                    
                                </div>

                            </div>

<br>

                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="tutor_email">Email Address of the Chosen University Tutor</label>
                                    <input type="email" name="tutor_email" parsley-trigger="change" required
                                    placeholder="Enter Email Address of the Chosen University Tutor" class="form-control" id="emailtutor">
                                </div>
                            </div>
                        </div>


                                  
                        <div class="form-group formspace">             
                            <div class="row">
                                <div class="col-md-3"></div>
                                <div class="col-md-3 centra">
                                    <td> <a href="/internships?view=candidate&submit=${userId}"><button type="addinternship" class="btn btn-primary waves-effect waves-light"> Send Request to Company </button></a>  </td>
                                </div>
                                <div class="col-md-3 centra">                                          
                                    <button type="reset" class="btn btn-default waves-effect m-l-5"> Cancel </button>                          
                                </div>
                                <div class="col-md-3"></div>
                            </div>
                        </div>


<br><br><br><br>

            <#include "/WEB-INF/views/FreeMarker/footer.ftl">

                </div> <!-- content -->

            </div>

                </form>
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