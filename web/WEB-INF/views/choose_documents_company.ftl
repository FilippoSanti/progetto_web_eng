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

        <section>
            <div class="container spzsopraaaa">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="m-t-40 card-box">
                                <div class="text-center">
                                    <h2 class="text-uppercase m-t-0 m-b-30">
                                        <a href="index.html" class="text-success">
                                            <span><img src="../../assets/images/logo_dark.png" alt="" height="30"></span>
                                        </a>
                                    </h2>
                                    <h6 class=" font-bold">Which Documentation Are You Interested In?</h6>
                                    <br>
                                </div>
                                <div class="account-content">
                                    <form class="form-horizontal" action="#">

                                        <#if urlData?has_content>

                                        </#if>
                                        <div class="form-group metismenu styleregchoose">
                                            <li class="container"><a href="${urlData}"><i class="sceltaregistrazione1 ti-files"></i><span class="sceltaregistrazione"> Agreement Document </span>
                                         </a>
                                        </li>
                                        </div>

                                        <br>

                                        <div class="form-group metismenu styleregchoose">
                                            <li class="container">
                            <a href="/documents?action=students"><i class="sceltaregistrazione1 ti-files"></i><span class="sceltaregistrazione"> Documents Relating to Internships </span>
                             </a>
                        </li>
                                        </div>

                                    </form>

                                    <div class="clearfix"></div>

                                </div>
                            </div>
                            <!-- end card-box-->

                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
        </section>


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

    </body>
</html>