//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package entities;

import java.text.ParseException;
import java.util.Date;

public class Funcionario extends Pessoas{
	private int codFuncional;
	private float salario;

	public Funcionario() {
		
	}
	public Funcionario(String nome, long cpf, Date dataNasc, String telefone, int codFuncional,
			float salario) {
		super(nome, cpf, dataNasc, telefone);
		this.codFuncional = codFuncional;
		this.salario = salario;
	}

	public int getCodFuncional() {
		return codFuncional;
	}

	public void setCodFuncional(int codFuncional) {
		this.codFuncional = codFuncional;
	}


	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() +  "\nCodigo: " + codFuncional + "\nSalario: R$" + salario;
	}
	
	
}
