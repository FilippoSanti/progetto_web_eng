 <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="user-details">
                    <div class="pull-left">
                        <img src="/displayImage" alt="" class="thumb-md rounded-circle">
                    </div>
                    <div class="user-info">
                        <a href="#"><#if username?has_content>${username}</#if></a>
                        <p class="text-muted m-0">Administrator</p>
                    </div>
                </div>

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu" id="side-menu">
                        <li class="menu-title">Navigation</li>
                        <li>
                            <a href="/home">
                                <i class="ti-home"></i><span> Dashboard </span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);"><i class="ti-user"></i> <span> My Profile </span> <span class="menu-arrow"></span></a>
                            <ul class="nav-second-level" aria-expanded="false">
                                <li><a href="/viewProfile">My Account</a></li>
                                <li><a href="/editProfile">Edit Informations</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="/companiesList">
                                <i class="ti-briefcase"></i><span> Companies List </span>
                            </a>
                        </li>

                         <li>
                            <a href="/userList">
                                <i class="ti-user"></i><span> Students List </span>
                            </a>
                        </li>

                        <li>
                            <a href="/internships_list?view=all">
                                <i class="ti-menu-alt"></i><span> Internships List </span>
                            </a>
                        </li>

                        <li>
                            <a href="/agreementRequests">
                                <i class="ti-check"></i><span> Agreements Requests </span>
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="ti-files"></i><span> Documentation </span>
                             </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="ti-stats-up"></i><span> View Statistics </span>
                             </a>
                        </li>
                       
                    </ul>

                </div>
                <!-- Sidebar -->
                <div class="clearfix"></div>

            </div>
            <!-- Left Sidebar End -->