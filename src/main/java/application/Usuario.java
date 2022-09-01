//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package application;

import java.text.SimpleDateFormat;
import java.util.Date;

// Classe para criação e validação de senha
public class Usuario {
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

	private Date dataAtual = new Date();
	private String usuario;
	private String senha;

    
        private int codigo;

	public Usuario(String usuario) {
		this.usuario = usuario;
	}

    public Usuario() {
      
    }

	public String getSenha() {
		return senha;
	}
        
        public void setSenha(String senha) {
        this.senha = senha;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
        
	
	//Método para geração de senha no formato de acordo com usuário e data
	public void geraSenha() {
		String[] aux = getUsuario().split(" ");
		this.senha = aux[0].toUpperCase() + sdf.format(dataAtual);
	}
	
	//Método para verificção de senha após tentativa de login, verifica se a senha está correta
	public boolean verificaSenha(String senha) {
		if (this.getSenha().compareTo(senha) == 0) {
			return true;
		}
		return false;
	}
}
