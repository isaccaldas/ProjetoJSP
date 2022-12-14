<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<!-- inclui uma p?gina aqui -->
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
                                       
                                         
                                		 <div class="card">
                                                    <div class="card-header">
                                                        <h5>Cadastro de usu?rio</h5>
                                                        <!--<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span>-->
                                                    </div>
                                                    <div class="card-block">
                                                        <form id="formUser" class="form-material" action="<%=request.getContextPath()%>/ServletUsuarioController" method="post">
                                                        	
                                                        	<input type="hidden" name="acao" id ="acao" value="">
                                                        	
                                                              <div class="form-group form-default form-static-label">
                                                                <input type="text" id="id" name="id" class="form-control"  readonly="readonly" value="${Usuario.id}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">ID</label>
                                                            </div>
                                                             <div class="form-group form-default form-static-label">
                                                                <input type="text" id="nome"  name="nome" class="form-control" required="required" value="${Usuario.nome}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Nome</label>
                                                            </div>
                                                          <div class="form-group form-default form-static-label">
                                                                <input type="email" id="email" name="email" class="form-control" required="required" autocomplete="off" value="${Usuario.email}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Email (exa@gmail.com)</label>
                                                            </div>
                                                              <div class="form-group form-default form-static-label">
                                                                <input type="text" id="login"  name="login" class="form-control" required="required" value="${Usuario.login}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Login</label>
                                                            </div>
                                                            <div class="form-group form-default form-static-label">
                                                                <input type="password" id ="senha" name="senha" class="form-control" required="required" autocomplete="off" value="${Usuario.senha}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Senha</label>
                                                            </div>
                                                            
                                                            <button   type ="button" class="btn waves-effect waves-light btn-primary btn-square" onclick="limparForm();">Limpar</button>
                                                            <button  type="submit" class="btn waves-effect waves-light btn-success btn-square">Salvar</button>
            												<button  type ="button" class="btn waves-effect waves-light btn-info btn-square"  data-toggle="modal" data-target="#exclusaoModal" >Excluir</button>
                                                   
													<!-- Modal -->
													<div class="modal fade" id="exclusaoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
														<div class="modal-dialog" role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">Excluir Usu?rio</h5>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<div class="modal-body">Deseja realmente excluir os dados?</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-dismiss="modal">Fechar</button>
																	<button type="button" class="btn btn-primary"  onclick="criarDelete();">Sim</button>
																</div>
															</div>
														</div>
													</div>
													
												</form>
                                                        
                                                      
                                                    </div>
                                                </div> 
                                        		<div class="alert alert-danger" role="alert">
  													<h6  id="msg">${msg} </h6>
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
  
 <script type="text/javascript" src="script.js">
 

 </script>

</body>

</html>
