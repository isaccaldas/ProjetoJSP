<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html lang="en">

<!-- inclui uma página aqui -->
<jsp:include page="principal/head.jsp"></jsp:include>
    

  <body themebg-pattern="theme1">
  
   <!-- Pre-loader start -->
 <jsp:include page="principal/preLoadStart.jsp"></jsp:include>

    <section class="login-block">
        <!-- Container-fluid starts -->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <!-- Authentication card start -->
                     <input type="hidden" value="<%= request.getParameter("url") %>"  name="url"> <!-- Captura a url do browser -->
                        <form action="<%=request.getContextPath() %>/ServletLogin"  method="post" class="md-float-material form-material">
                            <div class="text-center">
                                <img src="assets/images/logo.png" alt="logo.png">
                            </div>
                            <div class="auth-box card">
                                <div class="card-block">
                                    <div class="row m-b-20">
                                        <div class="col-md-12">
                                            <h3 class="text-center">Sign In</h3>
                                        </div>
                                    </div>
                                   <div class="form-group form-primary">
                                        <input type="text" name="_login" class="form-control" required="required">
                                        <span class="form-bar"></span>
                                        <label class="float-label">Informe o seu usuário.</label>
                                    </div>
                                    <div class="form-group form-primary">
                                        <input type="password" name="_senha" class="form-control" required="required">
                                        <span class="form-bar"></span>
                                        <label class="float-label">Informe a sua senha.</label>
                                    </div>
                                    <div class="row m-t-25 text-left">
                                        <div class="col-12">
                                            <div class="checkbox-fade fade-in-primary d-">
                                                <label>
                                                    <input type="checkbox" value="">
                                                    <span class="cr"><i class="cr-icon icofont icofont-ui-check txt-primary"></i></span>
                                                    <span class="text-inverse">Lembre meus Dados</span>
                                                </label>
                                            </div>
                                            <div class="forgot-phone text-right f-right">
                                                <a href="#" class="text-right f-w-600"> Esqueceu a senha?</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row m-t-30">
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary btn-md btn-block waves-effect waves-light text-center m-b-20">Entrar</button>
                                        </div>
                                    </div>
                                   
                                </div>
                            </div>
                        </form>
                        <!-- end of form -->
                        <!-- Ajustar depois a mensagem 
                        <div class="alert alert-danger" role="alert">
  							<h6>${msg} </h6>
							</div>
							-->
                </div>
                <!-- end of col-sm-12 -->
            </div>
            <!-- end of row -->
        </div>
        <!-- end of container-fluid -->
    </section>
    
  <jsp:include page="principal/javascript.jsp"></jsp:include>
</body>

</html>
		