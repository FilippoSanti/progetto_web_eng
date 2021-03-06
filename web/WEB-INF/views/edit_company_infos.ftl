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

        <!-- Plugins css-->
        <link href="../../assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link rel="stylesheet" href="../../assets/plugins/switchery/switchery.min.css">
        <link href="../../assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">

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


            <#include "/WEB-INF/views/FreeMarker/sidebar_company.ftl">



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
                                 <h4 class="header-title m-t-0 m-b-20">Edit Company Informations</h4>
                            </div>
                            <br><br>
                                <br><br>
                            <div class="col-md-4"></div>
                        </div> <!-- end row -->

                        <div class="row">
                            <div class="col-md-12">
                                <div class="p-0">
                                    <div class="member-card">

                                        <#if errorMessage?has_content >
                                            <div class="alert alert-danger">
                                                <strong>Error</strong> ${errorMessage}
                                            </div>
                                        </#if>

                                        <div class="thumb-xl member-thumb m-b-10 center-page">
                                            <img src="/displayImage" class="rounded-circle img-thumbnail" alt="profile-image">
                                        </div>
                                        <br>
                                        <form action="upload" method ="post" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <label for="exampleFormControlFile1">Choose a profile image</label>
                                                <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Upload</button>
                                        </form>
                                    </div>

                                </div> <!-- end card-box -->
                            </div> <!-- end col -->
                        </div> <!-- end row -->

                        <div class="m-t-30">
                                <div class="tab-pane" id="profile-b1">

                                    <form method="post" action="editProfile?sumbit=login" class="form-validation">

                                    <!-- Personal-Information -->
                                    <div class="panel panel-default panel-fill">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Edit Log In Informations</h3>
                                        </div>
                                        <div class="container">
                                            <div class="row">
                                                <div class="col-md-6 mrgntopcol">

                                                    <div class="form-group">
                                                        <label for="C_Username">email</label>
                                                        <input type="email" value="${companyData.getEmail_login()}" id="C_Username" class="form-control" name="email_login">
                                                    </div>
                                                </div>

                                                <div class="col-md-6 mrgntopcol">
                                                    <div class="form-group">
                                                        <label for="edit_company_pass rippwd4">New Password</label>
                                                        <input id="edit_company_pass" type="password" placeholder="New Password" class="form-control" name="password_company">
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-6"></div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="edit_company_pass_2">Repeat New Password</label>
                                                        <input id="edit_company_pass_2" type="password" placeholder="Repeat New Password" class="form-control" name="ripeti_password_company">
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                        <br><br>
                                        <div class="center-page centra">
                                            <button class="btn btn-primary waves-effect waves-light w-md" type="submit">Update</button>
                                        </div>
                                        <br>

                                    </div>
                                    <!-- Personal-Information -->
                                    </form>

                                    <form method="post" action="editProfile?sumbit=info" class="form-validation">
                                    <!-- Personal-Information -->
                                    <div class="panel panel-default panel-fill">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Edit Company Informations</h3>
                                        </div>
                                        <div class="container">
                                            <div class="row">

                                                <div class="col-md-6 mrgntopcol">

                                                    <div class="form-group">
                                                        <label for="Business_Name">Business Name/Name</label>
                                                        <input type="text" value="${companyData.getRagione_sociale()}" id="Business_Name" class="form-control" name="ragione_sociale">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Legal_Address">Legal Address</label>
                                                        <input type="text" value="${companyData.getIndirizzo_sede_leg()}" id="Legal_Address" class="form-control" name="indirizzo_legale">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Solicitor_Name">Solicitor's Name and Surname</label>
                                                        <input type="text" value="${companyData.getNome_cognome_rap()}" id="Solicitor_Name" class="form-control" name="nome_cognome_rap">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Manager_Name">Internships Manager's Name and Surname</label>
                                                        <input type="text" value="${companyData.getNome_cognome_tir()}" id="Manager_Name" class="form-control" name="nome_cognome_tir" >
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Jurisdiction">Competent Jurisdiction</label>
                                                        <input type="text" value="${companyData.getForo_competente()}" id="Jurisdiction" class="form-control"name="foro_comp">
                                                    </div>

                                                </div>

                                                <div class="col-md-6 mrgntopcol">
                                                    <div class="form-group">
                                                        <label class="uppercase" for="Fiscal_Code">Fiscal Code (NIN)/Partita I.V.A. (VAT)</label>
                                                        <input type="text" value="${companyData.get_cf_iva()}" id="Fiscal_Code" class="form-control uppercase" name="cf_iva">
                                                    </div>

                                                    <div class="form-group">
                                                        <label>Province<span class="text-danger"></span></label>
                                                        <select name="provincia" class="form-control select2">
                                                            <option>${companyData.getProvincia()}</option>
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
                                                        <label for="Manager_Email">Internships Manager's Email Address</label>
                                                        <input type="text" value="${companyData.getEmail_tirocini()}" id="Manager_Email" class="form-control" name="email_tirocini">
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="Manager_Phone">Internships Manager's Telephone Number</label>
                                                        <input type="text" value="${companyData.getTelefono_tirocini()}" id="Manager_Phone" class="form-control" name="telefono">
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="AboutMe">Edit Company Description</label>
                                                <textarea name="descrizione" style="height: 125px" id="AboutMe" class="form-control">${companyData.getDescrizione()}</textarea>
                                            </div>

                                            <br><br>
                                            <div class="center-page centra">
                                                <button class="btn btn-primary waves-effect waves-light w-md" type="submit">Update</button>
                                            </div>
                                            <br>

                                        </div>
                                        <!-- Personal-Information -->
                                    </form>
                                    </div>
                                        <br>


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
        <script src="../../assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
        <script src="../../assets/plugins/summernote/summernote-bs4.min.js"></script>
        <script src="../../assets/pages/jquery.form-advanced.init.js"></script>
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

        <!-- App js -->
        <script src="../../assets/js/jquery.core.js"></script>
        <script src="../../assets/js/jquery.app.js"></script>

    </body>
</html>