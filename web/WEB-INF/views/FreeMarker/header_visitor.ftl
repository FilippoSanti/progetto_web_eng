 <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="/home" class="logo">
                        <span>
                            <img class="hei45" src="assets/images/logo.png" alt="">
                        </span>
                        <i>
                            <img src="assets/images/logo_sm.png" alt="">
                        </i>
                    </a>
                </div>

                <nav class="navbar-custom">

                    <ul class="list-unstyled topbar-right-menu float-right mb-0">

<!-- Menu Account -->
                        
                        <li>
                    <a class="nav-link  waves-effect waves-light nav-user loginmargin"  href="/login"
                       aria-haspopup="false" aria-expanded="false">
                        <i class="mdi mdi-login"></i> Log In
                    </a>

                         </li>
                    </ul>

<!-- Nascondi menù laterale sinistro -->
                    <ul class="list-inline mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left waves-light waves-effect">
                                <i class="mdi mdi-menu"></i>
                            </button>
                        </li>

                        <!-- Ricerca -->
                        <li class="nav-item dropdown">
                            <div class="container">
                                <div class="row ">
                                    <div class="col-md-3 yes">
                                        <div class="row">
                                            <form class="displaycorrectdim" method="get" action="/search.do" data-validate="parsley">
                                                <div class="input-group app-search" id="adv-search">
                                                    <input type="text" name="term" data-parsley-minlength="4" class="form-control borderradius postotasti" placeholder="Search for internships..." />
                                                    <div class="input-group-btn ">
                                                        <div class="btn-group btnsearchposition" role="group">
                                                            <div class="dropdown">
                                                                <button type="button" class="btn dropdown-toggle mdi mdi-chevron-down stylesearchbtn" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                                                                <div class="dropdown-menu dropdown-menu-right profile-dropdown customdrop" role="menu">
                                                                    <form class="form-vertical" role="form">
                                                                        <div class="form-group">
                                                                            <label for="filter">Internship Place</label>
                                                                            <select name="place" class="form-control customitem">
                                                                                <option value="0">Company Headquarters</option>
                                                                                <option value="1">Remote Connection (from home)</option>
                                                                                <option value="2" selected>Any</option>
                                                                            </select>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <label for="filter">Duration MIN</label>
                                                                                    <select name="duration_min" class="form-control customitem">
                                                                                        <option value="1" selected>1 month</option>
                                                                                        <option value="2">2 months</option>
                                                                                        <option value="3">3 months</option>
                                                                                        <option value="4">4 months</option>
                                                                                        <option value="5">5 months</option>
                                                                                        <option value="6">6 months</option>
                                                                                        <option value="7">7 months</option>
                                                                                        <option value="8">8 months</option>
                                                                                        <option value="9">9 months</option>
                                                                                        <option value="10">10 months</option>
                                                                                        <option value="11">11 months</option>
                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <div class="form-group">
                                                                                    <label for="filter">Duration MAX</label>
                                                                                    <select name="duration_max" class="form-control customitem">
                                                                                        <option value="0">2 months</option>
                                                                                        <option value="1">3 months</option>
                                                                                        <option value="2">4 months</option>
                                                                                        <option value="3">5 months</option>
                                                                                        <option value="4">6 months</option>
                                                                                        <option value="5">7 months</option>
                                                                                        <option value="6">8 months</option>
                                                                                        <option value="7">9 months</option>
                                                                                        <option value="8">10 months</option>
                                                                                        <option value="9">11 months</option>
                                                                                        <option value="10" selected="">12 months</option>
                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                            <button type="submit" class="btn stylesearchbtn2"><span class="fa fa-search" aria-hidden="true"></span></button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </ul>

                </nav>

            </div>
            <!-- Top Bar End -->