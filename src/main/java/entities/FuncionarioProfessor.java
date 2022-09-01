//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package entities;

import java.text.ParseException;
import java.util.Date;

public class FuncionarioProfessor extends Funcionario {
	private String areaDeAtuacao;

	public FuncionarioProfessor(String nome, long cpf, Date dataNasc, String telefone, int codFuncional,
                float salario, String areaDeAtuacao) {
		super(nome, cpf, dataNasc, telefone, codFuncional, salario);
		this.areaDeAtuacao = areaDeAtuacao;
	}

	public FuncionarioProfessor() {
		super();
	}

	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}

	@Override
	public String toString() {
		return super.toString() + "\nArea de atuação: " + areaDeAtuacao;
	}

}
