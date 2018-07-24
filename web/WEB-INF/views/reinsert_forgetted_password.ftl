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

        <!-- App css -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="assets/js/modernizr.min.js"></script>

    </head>


    <body>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="m-t-40 card-box">
                                <div class="text-center">
                                    <h2 class="text-uppercase m-t-0 m-b-30">
                                        <a href="index.html" class="text-success">
                                            <span><img src="assets/images/logo_dark.png" alt="" height="30"></span>
                                        </a>
                                    </h2>
                                </div>

                                <div class="account-content">
                                    <div class="text-center m-b-20">
                                        <p class="text-muted m-b-0 line-h-24">Re-enter your new password here!  Be careful not to forget it again!  </p>
                                    </div>
                                    <form method="post" action="resetPassword?changePassword=true">
                                        <input type="hidden" id="tokenId" name="token_2" value="${token}">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="newpassword1">New Password</label>
                                             <input class="form-control" name="password" type="password" id="newpassword1" required="" placeholder="New Password">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="newpassword2">Repeat New Password</label>
                                             <input class="form-control" name="repeat_password" type="password" id="newpassword2" required="" placeholder="Repeat New Password">
                                        </div>
                                    </div>

                                    <div class="form-group account-btn text-center m-t-10">
                                        <div class="col-xs-12">
                                            <button class="btn btn-lg btn-primary btn-block" type="submit">Reset Password</button>
                                        </div>
                                    </div>
                                    </form>
                                    <div class="clearfix"></div>

                                </div>

                            </div>

                            <!-- end card-box-->


                            <div class="row m-t-50">
                                <div class="col-sm-12 text-center">
                                    <p class="text-muted">Back to <ins><a href="/login" class="text-dark m-l-5">Sign In</a></ins></p>
                                </div>
                            </div>

                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
        </section>




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