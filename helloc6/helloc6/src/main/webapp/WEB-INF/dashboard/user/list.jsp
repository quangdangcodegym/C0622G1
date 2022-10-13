<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Basic Tables | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
        <jsp:include page="/layout/meta_css.jsp"></jsp:include>

    </head>

    <body data-layout="horizontal">

        <!-- Begin page -->
        <div id="wrapper">

            <!-- Navigation Bar-->
            <jsp:include page="/layout/topnav.jsp"></jsp:include>
                <!-- End Navigation Bar-->

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">

                    <!-- Start Content-->
                    <div class="container-fluid">

                        <!-- start page title -->
                        <div class="row">
                            <div class="col-12">
                                <div class="page-title-box">
                                    <div class="page-title-right">
                                        <ol class="breadcrumb m-0">
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Zircos</a></li>
                                            <li class="breadcrumb-item"><a href="javascript: void(0);">Tables</a></li>
                                            <li class="breadcrumb-item active">Basic Tables</li>
                                        </ol>
                                    </div>
                                    <h4 class="page-title">Basic Tables</h4>
                                </div>
                            </div>
                        </div>
                        <!-- end page title -->

                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table m-0">

                                    <thead class="thead-light">
                                    <tr>
                                        <th>#</th>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Country</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.list}" var="user">
                                        <tr>
                                            <th scope="row">${user.getId()}</th>
                                            <td>${user.getName()}</td>
                                            <td>${user.getEmail()}</td>
                                            <td>
                                                <c:forEach items="${applicationScope.listCountry}" var="country">
                                                    <c:if test="${user.getIdCountry()==country.getId()}">
                                                        ${country.getName()}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <!-- end card-box -->
                            </div>
                            <!-- end col -->
                        </div>
                        <!-- end row -->

                    </div>
                    <!-- end container-fluid -->

                </div>
                <!-- end content -->

                

                <!-- Footer Start -->
                <jsp:include page="/layout/footer.jsp"></jsp:include>
                <!-- end Footer -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->

        </div>
        <!-- END wrapper -->

        <!-- Right Sidebar -->
        <jsp:include page="/layout/rightbar.jsp"></jsp:include>

        <jsp:include page="/layout/footer_js.jsp"></jsp:include>

    </body>

</html>