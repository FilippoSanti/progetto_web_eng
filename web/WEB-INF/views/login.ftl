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

        <!-- App css -->
        <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../../assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="../../assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="../../assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="../../assets/js/modernizr.min.js"></script>

    </head>


    <body>

        <section>

            <form method="post" action="login">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="m-t-40 card-box">
                                <div class="text-center">

                                    <h2 class="text-uppercase m-t-0 m-b-30">
                                        <a href="../src/view/index.jsp" class="text-success">
                                            <span><img src="../../assets/images/logo_dark.png" alt="" height="30"></span>
                                        </a>
                                    </h2>
                                    <!--<h4 class="text-uppercase font-bold m-b-0">Sign In</h4>-->
                                </div>

                                <#if registeredMessage?has_content>
                                    <div class="alert alert-success">
                                        <strong>Success!</strong> ${registeredMessage}
                                    </div>
                                </#if>

                                <#if Message?has_content>
                                    <div class="alert alert-warning">
                                        <strong>Warning!</strong> ${Message}
                                    </div>
                                </#if>

                                <div class="account-content">
                                        <div class="form-group m-b-20">
                                            <div class="col-xs-12">
                                                <label for="UserNamelog">E-mail</label>

                                                <input name="email" class="form-control" type="name" id="UserNamelog" required placeholder="Email / Password"
                                                <#if email?has_content> value="${email}" </#if>/>

                                            </div>
                                        </div>

                                        <div class="form-group m-b-20">
                                            <div class="col-xs-12">
                                                <a href="/resetPassword" class="text-muted pull-right font-14">Forgot your password?</a>
                                                <label for="passwordlog">Password</label>
                                                <input name="pass" class="form-control" type="password" required id="passwordlog" placeholder="Enter your password">
                                            </div>
                                        </div>

                                        <div class="form-group m-b-30">
                                            <div class="col-xs-12">
                                                <div class="checkbox checkbox-primary">
                                                    <input name="checkbox5" id="checkbox5" type="checkbox" <#if email?has_content> checked </#if>>
                                                    <label for="checkbox5">
                                                        Remember username
                                                    </label>
                                                </div>
                                            </div>
                                            <br>
                                        </div>

                                        <div class="form-group account-btn text-center m-t-10">
                                            <div class="col-xs-12">
                                                <button class="btn btn-lg btn-primary btn-block" type="submit" name="login">Sign In</button>
                                            </div>
                                        </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <!-- end card-box-->

                            <div class="row m-t-50">
                                <div class="col-sm-12 text-center">
                                    <p class="text-muted">Don't have an account? <ins><a href="/register" class="text-dark m-l-5">Sign Up</a></ins></p>
                                </div>
                            </div>

                            <div class="row m-t-50">
                                <div class="col-sm-12 text-center">
                                    <p class="text-muted">You can also enter the site as<ins><a href="/home" class="text-dark m-l-5"> Anonymous User</a></ins></p>
                                </div>
                            </div>

                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
            </form>
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