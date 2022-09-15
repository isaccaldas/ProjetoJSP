//Função para limpar dados do formulário.
function limparForm() {

	var elementos = document.getElementById('formUser').elements; // retorna os elementos html dentro de um form

	for (p = 0; p < elementos.length; p++) {
		elementos[p].value = '';
	
}
}// fim limparForm()


 function criarDelete() {
	   
	 //  if(confirm('Deseja realmente excluir os dados?')){
	    
	    document.getElementById("formUser").method = 'get';
	    document.getElementById("acao").value = 'deletar';
	    document.getElementById("formUser").submit();
	    //}
}

 function criarDeleteAjax() {
	   
	   //<%=request.getContextPath()%>/ServletUsuarioController
	    
	    if(confirm('Deseja realmente excluir os dados ajax?')){
	 			 var  urlAction= document.getElementById("formUser").action;
           	     var idUser = 	document.getElementById("id").value;
	
		$.ajax({
			
			method:"get",
			url: urlAction,
			data: "id="+ idUser +"&acao=deletarAjax",
			success: function(response){
				//alert(response);
				limparForm();
					document.getElementById("msg").textContent = response;
			}
			
		}).fail(function(xhr, status, errorThrow){
			alert("Erro ao deletar usuário por id: " + xhr.responseText);
		});
		
	    }//fim if
}

