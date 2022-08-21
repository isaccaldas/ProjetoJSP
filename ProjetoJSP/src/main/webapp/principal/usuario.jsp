<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<!-- inclui uma página aqui -->
<jsp:include page="head.jsp"></jsp:include>

  <body>
  <!-- Pre-loader start -->
 <jsp:include page="preLoadStart.jsp"></jsp:include>
  <!-- Pre-loader end -->
  
  <div id="pcoded" class="pcoded">
      <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">

	<!-- Menu -->
<jsp:include page="menu.jsp"></jsp:include>

          <div class="pcoded-main-container">
              <div class="pcoded-wrapper">
             
       	<!-- Menu -->
    
       <jsp:include page="menuLateral.jsp"></jsp:include>
             
                  <div class="pcoded-content">
                      <!-- Page-header start -->
               <jsp:include page="pageHeader.jsp"></jsp:include>  
                      <!-- Page-header end -->
                        <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body">
                                        <div class="row">
                                         
                                		<h1>usuario</h1>
                                         
                                        </div>
                                    </div>
                                    <!-- Page-body end -->
                                </div>
                                <div id="styleSelector"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
  <jsp:include page="javascript.jsp"></jsp:include>
</body>

</html>
