//Função para limpar dados do formulário.
function limparForm() {
			
  		var elementos = document.getElementById('formUser').elements; // retorna os elementos html dentro de um form
  		
  		for(p=0; p < elementos.length; p++){
	
  			elementos[p].value = '';
  			  			
  		}
  			
	}
	
	
	function criarDelete(){
		
		 document.getElementById('formUser').method = 'get';
		 document.getElementById('acao').value = 'deletar';
		 document.getElementById('formUser').submit;
		 
		 alert("sim");
	}
 