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

    <!-- Plugins css-->
    <link href="../../assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../assets/plugins/switchery/switchery.min.css">
    <link href="../../assets/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
    <link href="../../assets/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css" rel="stylesheet">
    <link href="../../assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="../../assets/plugins/clockpicker/css/bootstrap-clockpicker.min.css" rel="stylesheet">
    <link href="../../assets/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Summernote css -->
    <link href="../../assets/plugins/summernote/summernote-bs4.css" rel="stylesheet" />

    <!-- App css -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
    <link href="../../assets/css/style.css" rel="stylesheet" type="text/css" />

    <script src="../../assets/js/modernizr.min.js"></script>

    <script type="text/javascript">
        $('.input-group.text').datepicker({
            format: 'dd/mm/yyyy'
        });
    </script>
</head>
<body>

<!-- Begin page -->
<div id="wrapper">

    <!-- Top Bar Start -->
    <div class="topbar">

        <!-- LOGO -->
        <div class="topbar-left">
            <a href="index.html" class="logo">
                <span>
                    <img src="../../assets/images/logo.png" alt="">
                </span>
                <i>
                    <img src="../../assets/images/logo_sm.png" alt="">
                </i>
            </a>
        </div>

        <nav class="navbar-custom">
            <ul class="list-unstyled topbar-right-menu float-right mb-0">

            </ul>
        </nav>
    </div>
    <!-- Top Bar End -->

    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6"><h4 class="header-title centra">Student Registation Form  2/2</h4></div>
                    <div class="col-lg-3"></div>
                    <p class="text-muted font-13 ">
                        Make sure you fill each field on the form correctly!
                    </p>
                </div>

                <form method="post" action="register?user=student&submit=true" class="form-validation">

                <div class="row">

                    <div class="col-md-6">

                    <#if errors>

                     <ul class="list-group">
                        <#list errorsList as item><li class="list-group-item list-group-item-danger">${item}</li></#list>
                     </ul>

                    </#if>

                        <div class="p-20 m-b-20">

                            <div class="m-b-20">
                                    <div class="form-group">
                                        <label for="name">Name<span class="text-danger">*</span></label>
                                        <input type="text" name="nome" parsley-trigger="change" required
                                               placeholder="Enter Name" class="form-control" id="name">
                                    </div>

                                    <div class="form-group">
                                        <label>Birth Date<span class="text-danger">*</span><a>  (use format: mm/dd/yyyy)</a></label>
                                        <div class="input-group">
                                            <input type="text" name="date" class="form-control" placeholder="mm/dd/yyyy" id="datepicker-autoclose">
                                            <div class="input-group-append">
                                                <span class="input-group-text"><i class="mdi mdi-calendar"></i></span>
                                            </div>
                                        </div><!-- input-group -->
                                    </div>

                                    <div class="form-group">
                                        <label>Birth Province<span class="text-danger">*</span></label>
                                        <select name="provincia_nascita" class="form-control select2">
                                            <option>-- Select --</option>
                                            <option value="AG">Agrigento</option>
                                            <option value="AL">Alessandria</option>
                                            <option value="AN">Ancona</option>
                                            <option value="AO">Aosta</option>
                                            <option value="AR">Arezzo</option>
                                            <option value="AP">Ascoli Piceno</option>
                                            <option value="AT">Asti</option>
                                            <option value="AV">Avellino</option>
                                            <option value="BA">Bari</option>
                                            <option value="BL">Belluno</option>
                                            <option value="BN">Benevento</option>
                                            <option value="BG">Bergamo</option>
                                            <option value="BI">Biella</option>
                                            <option value="BO">Bologna</option>
                                            <option value="BZ">Bolzano</option>
                                            <option value="BS">Brescia</option>
                                            <option value="BR">Brindisi</option>
                                            <option value="CA">Cagliari</option>
                                            <option value="CL">Caltanissetta</option>
                                            <option value="CB">Campobasso</option>
                                            <option value="CE">Caserta</option>
                                            <option value="CT">Catania</option>
                                            <option value="CZ">Catanzaro</option>
                                            <option value="CH">Chieti</option>
                                            <option value="CO">Como</option>
                                            <option value="CS">Cosenza</option>
                                            <option value="CR">Cremona</option>
                                            <option value="KR">Crotone</option>
                                            <option value="CN">Cuneo</option>
                                            <option value="EN">Enna</option>
                                            <option value="FE">Ferrara</option>
                                            <option value="FI">Firenze</option>
                                            <option value="FG">Foggia</option>
                                            <option value="FO">Forl&igrave; - Cesena</option>
                                            <option value="FR">Frosinone</option>
                                            <option value="GE">Genova</option>
                                            <option value="GO">Gorizia</option>
                                            <option value="GR">Grosseto</option>
                                            <option value="IM">Imperia</option>
                                            <option value="IS">Isernia</option>
                                            <option value="SP">La Spezia</option>
                                            <option value="AQ">L'Aquila</option>
                                            <option value="LT">Latina</option>
                                            <option value="LE">Lecce</option>
                                            <option value="LC">Lecco</option>
                                            <option value="LI">Livorno</option>
                                            <option value="LO">Lodi</option>
                                            <option value="LU">Lucca</option>
                                            <option value="MC">Macerata</option>
                                            <option value="MN">Mantova</option>
                                            <option value="MS">Massa Carrara</option>
                                            <option value="MT">Matera</option>
                                            <option value="ME">Messina</option>
                                            <option value="MI">Milano</option>
                                            <option value="MO">Modena</option>
                                            <option value="NA">Napoli</option>
                                            <option value="NO">Novara</option>
                                            <option value="NU">Nuoro</option>
                                            <option value="OR">Oristano</option>
                                            <option value="PD">Padova</option>
                                            <option value="PA">Palermo</option>
                                            <option value="PR">Parma</option>
                                            <option value="PV">Pavia</option>
                                            <option value="PG">Perugia</option>
                                            <option value="PS">Pesaro</option>
                                            <option value="PE">Pescara</option>
                                            <option value="PC">Piacenza</option>
                                            <option value="PI">Pisa</option>
                                            <option value="PT">Pistoia</option>
                                            <option value="PN">Pordenone</option>
                                            <option value="PZ">Potenza</option>
                                            <option value="PO">Prato</option>
                                            <option value="RG">Ragusa</option>
                                            <option value="RA">Ravenna</option>
                                            <option value="RC">Reggio Calabria</option>
                                            <option value="RE">Reggio Emilia</option>
                                            <option value="RI">Rieti</option>
                                            <option value="RN">Rimini</option>
                                            <option value="RM">Roma</option>
                                            <option value="RO">Rovigo</option>
                                            <option value="SA">Salerno</option>
                                            <option value="SS">Sassari</option>
                                            <option value="SV">Savona</option>
                                            <option value="SI">Siena</option>
                                            <option value="SR">Siracusa</option>
                                            <option value="SO">Sondrio</option>
                                            <option value="TA">Taranto</option>
                                            <option value="TE">Teramo</option>
                                            <option value="TR">Terni</option>
                                            <option value="TO">Torino</option>
                                            <option value="TP">Trapani</option>
                                            <option value="TN">Trento</option>
                                            <option value="TV">Treviso</option>
                                            <option value="TS">Trieste</option>
                                            <option value="UD">Udine</option>
                                            <option value="VA">Varese</option>
                                            <option value="VE">Venezia</option>
                                            <option value="VB">Verbania-Cusio-Ossola</option>
                                            <option value="VC">Vercelli</option>
                                            <option value="VR">Verona</option>
                                            <option value="VV">Vibo Valentia</option>
                                            <option value="VI">Vicenza</option>
                                            <option value="VT">Viterbo</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="Address">Residence Address<span class="text-danger">*</span></label>
                                        <input type="text" name="residenza" parsley-trigger="change" required
                                               placeholder="Enter Address" class="form-control" id="Address">
                                    </div>

                                    <div class="form-group">
                                        <label>Residence Province<span class="text-danger">*</span></label>
                                        <select name="provincia" class="form-control select2" parsley-trigger="change" required>
                                            <option>-- Select --</option>
                                            <option value="AG">Agrigento</option>
                                            <option value="AL">Alessandria</option>
                                            <option value="AN">Ancona</option>
                                            <option value="AO">Aosta</option>
                                            <option value="AR">Arezzo</option>
                                            <option value="AP">Ascoli Piceno</option>
                                            <option value="AT">Asti</option>
                                            <option value="AV">Avellino</option>
                                            <option value="BA">Bari</option>
                                            <option value="BL">Belluno</option>
                                            <option value="BN">Benevento</option>
                                            <option value="BG">Bergamo</option>
                                            <option value="BI">Biella</option>
                                            <option value="BO">Bologna</option>
                                            <option value="BZ">Bolzano</option>
                                            <option value="BS">Brescia</option>
                                            <option value="BR">Brindisi</option>
                                            <option value="CA">Cagliari</option>
                                            <option value="CL">Caltanissetta</option>
                                            <option value="CB">Campobasso</option>
                                            <option value="CE">Caserta</option>
                                            <option value="CT">Catania</option>
                                            <option value="CZ">Catanzaro</option>
                                            <option value="CH">Chieti</option>
                                            <option value="CO">Como</option>
                                            <option value="CS">Cosenza</option>
                                            <option value="CR">Cremona</option>
                                            <option value="KR">Crotone</option>
                                            <option value="CN">Cuneo</option>
                                            <option value="EN">Enna</option>
                                            <option value="FE">Ferrara</option>
                                            <option value="FI">Firenze</option>
                                            <option value="FG">Foggia</option>
                                            <option value="FO">Forl&igrave; - Cesena</option>
                                            <option value="FR">Frosinone</option>
                                            <option value="GE">Genova</option>
                                            <option value="GO">Gorizia</option>
                                            <option value="GR">Grosseto</option>
                                            <option value="IM">Imperia</option>
                                            <option value="IS">Isernia</option>
                                            <option value="SP">La Spezia</option>
                                            <option value="AQ">L'Aquila</option>
                                            <option value="LT">Latina</option>
                                            <option value="LE">Lecce</option>
                                            <option value="LC">Lecco</option>
                                            <option value="LI">Livorno</option>
                                            <option value="LO">Lodi</option>
                                            <option value="LU">Lucca</option>
                                            <option value="MC">Macerata</option>
                                            <option value="MN">Mantova</option>
                                            <option value="MS">Massa Carrara</option>
                                            <option value="MT">Matera</option>
                                            <option value="ME">Messina</option>
                                            <option value="MI">Milano</option>
                                            <option value="MO">Modena</option>
                                            <option value="NA">Napoli</option>
                                            <option value="NO">Novara</option>
                                            <option value="NU">Nuoro</option>
                                            <option value="OR">Oristano</option>
                                            <option value="PD">Padova</option>
                                            <option value="PA">Palermo</option>
                                            <option value="PR">Parma</option>
                                            <option value="PV">Pavia</option>
                                            <option value="PG">Perugia</option>
                                            <option value="PS">Pesaro</option>
                                            <option value="PE">Pescara</option>
                                            <option value="PC">Piacenza</option>
                                            <option value="PI">Pisa</option>
                                            <option value="PT">Pistoia</option>
                                            <option value="PN">Pordenone</option>
                                            <option value="PZ">Potenza</option>
                                            <option value="PO">Prato</option>
                                            <option value="RG">Ragusa</option>
                                            <option value="RA">Ravenna</option>
                                            <option value="RC">Reggio Calabria</option>
                                            <option value="RE">Reggio Emilia</option>
                                            <option value="RI">Rieti</option>
                                            <option value="RN">Rimini</option>
                                            <option value="RM">Roma</option>
                                            <option value="RO">Rovigo</option>
                                            <option value="SA">Salerno</option>
                                            <option value="SS">Sassari</option>
                                            <option value="SV">Savona</option>
                                            <option value="SI">Siena</option>
                                            <option value="SR">Siracusa</option>
                                            <option value="SO">Sondrio</option>
                                            <option value="TA">Taranto</option>
                                            <option value="TE">Teramo</option>
                                            <option value="TR">Terni</option>
                                            <option value="TO">Torino</option>
                                            <option value="TP">Trapani</option>
                                            <option value="TN">Trento</option>
                                            <option value="TV">Treviso</option>
                                            <option value="TS">Trieste</option>
                                            <option value="UD">Udine</option>
                                            <option value="VA">Varese</option>
                                            <option value="VE">Venezia</option>
                                            <option value="VB">Verbania-Cusio-Ossola</option>
                                            <option value="VC">Vercelli</option>
                                            <option value="VR">Verona</option>
                                            <option value="VV">Vibo Valentia</option>
                                            <option value="VI">Vicenza</option>
                                            <option value="VT">Viterbo</option>
                                        </select>
                                    </div>


                                    <div class="form-group">
                                        <label for="telephone">Telephone<span class="text-danger">*</span></label>
                                        <input type="text" name="telefono" parsley-trigger="change" required
                                               placeholder="Enter Telephone Number" class="form-control" id="telephone">
                                    </div>

                                    <div class="form-group">
                                        <label for="degree">Degree Course<span class="text-danger">*</span></label>
                                        <input type="text" name="corso_laurea" parsley-trigger="change" required
                                               placeholder="Enter Degree Course" class="form-control" id="degree">
                                    </div>

                                    <br>
                                    <div class="col-lg-3"></div>
                                    <p class="text-muted font-13 logininfo">
                                        Log In information:
                                    </p>

                                    <div class="form-group">
                                        <label for="pass1">Password<span class="text-danger">*</span></label>
                                        <input id="pass1" name ="password" type="password" placeholder="Password" required
                                               class="form-control">
                                    </div>

                            </div>

                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="p-20 m-b-20">

                            <div class="m-b-20">
                                    <div class="form-group">
                                        <label for="userSurname">Surname<span class="text-danger">*</span></label>
                                        <input type="text" name="cognome" parsley-trigger="change" required
                                               placeholder="Enter Surname" class="form-control" id="userSurname">
                                    </div>

                                    <div class="form-group">
                                        <label for="birthPlace">Birth Place<span class="text-danger">*</span></label>
                                        <input type="text" name="luogo_nascita" parsley-trigger="change" required
                                               placeholder="Enter Birth Place" class="form-control" id="birthPlace">
                                    </div>

                                    <div class="form-group">
                                        <label for="code">Fiscal Code (NIN)<span class="text-danger">*</span></label>
                                        <input type="text" name="cod_fiscale" parsley-trigger="change" required
                                               placeholder="Enter fiscal code" class="form-control" id="code">
                                    </div>

                                    <div class="form-group">
                                        <label for="city">City<span class="text-danger">*</span></label>
                                        <input type="text" name="citta" parsley-trigger="change" required
                                               placeholder="Enter City" class="form-control" id="city">
                                    </div>

                                    <div class="form-group">
                                        <label for="cap">C A P<span class="text-danger">*</span></label>
                                        <input type="text" name="CAP" parsley-trigger="change" required
                                               placeholder="Enter CAP" class="form-control" id="cap">
                                    </div>

                                    <div class="form-group">
                                        <label for="userEmail">E-mail Address<span class="text-danger">*</span></label>
                                        <input type="text" name="email" parsley-trigger="change" required
                                               placeholder="Enter Email Address" class="form-control" id="userEmail">
                                    </div>

                                    <div class="form-group">
                                        <label for="handicap">Other</label>
                                        <div class="checkbox handicap">
                                            <input id="handicap" name="handicap" type="checkbox">
                                            <label for="handicap">Disabled Person </label>
                                        </div>
                                    </div>

<br><br><br>
                                <div class="form-group rippwd4">
                                    <label for="pass2">Repeat Password<span class="text-danger">*</span></label>
                                    <input id="pass2" name="ripeti_password" type="password" placeholder="Repeat Password" required
                                           class="form-control">
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>

                    <div class="row">

                        <div class="col-md-3"></div>
                        <div class="col-md-3 centra">
                            <button type="submit" class="btn btn-primary waves-effect waves-light">
                                Sign Up
                            </button>
                        </div>
                        <div class="col-md-3 centra">
                            <button type="reset" class="btn btn-default waves-effect m-l-5"> Cancel </button>
                        </div>

                    </div>
                </div>
                </form>
                <!-- end row -->
                <br><br><br><br><br><br><br><br>
            <div class="footer">
                <div class="pull-right hide-phone">
                    Web Engineering Project
                </div>
                <div>
                    Copyright © 2018 - <a class="ti-infinite infindim"></a>
                </div>

                <div class="centra"> All Rights Reserved - <strong class="text-custom">Unnamed Group</strong></div>
            </div>

            </div> <!-- content -->

        </div>


        <!-- ============================================================== -->
        <!-- End Right content here -->
        <!-- ============================================================== -->


    </div>
</div>
    <!-- END wrapper -->



    <!-- jQuery  -->
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../assets/js/popper.min.js"></script>
    <script src="../../assets/js/bootstrap.min.js"></script>
    <script src="../../assets/js/metisMenu.min.js"></script>
    <script src="../../assets/js/waves.js"></script>
    <script src="../../assets/js/jquery.slimscroll.js"></script>

    <script src="../../assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
    <script src="../../assets/plugins/select2/js/select2.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
    <script src="../../assets/plugins/switchery/switchery.min.js"></script>
    <script type="text/javascript" src="../../assets/plugins/parsleyjs/parsley.min.js"></script>

    <script src="../../assets/plugins/moment/moment.js"></script>
    <script src="../../assets/plugins/timepicker/bootstrap-timepicker.js"></script>
    <script src="../../assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
    <script src="../../assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
    <script src="../../assets/plugins/clockpicker/js/bootstrap-clockpicker.min.js"></script>
    <script src="../../assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
    <script src="../../assets/plugins/summernote/summernote-bs4.min.js"></script>

    <!-- form advanced init js -->
    <script src="../../assets/pages/jquery.form-advanced.init.js"></script>

    <!-- App js -->
    <script src="../../assets/js/jquery.core.js"></script>
    <script src="../../assets/js/jquery.app.js"></script>

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