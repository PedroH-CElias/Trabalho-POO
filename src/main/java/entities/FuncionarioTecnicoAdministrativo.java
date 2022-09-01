//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package entities;

import java.text.ParseException;
import java.util.Date;

public class FuncionarioTecnicoAdministrativo extends Funcionario{

	private String departamento;

	public FuncionarioTecnicoAdministrativo(String nome, long cpf, Date dataNasc, String telefone,
			int codFuncional, float salario, String departamento) {
		super(nome, cpf, dataNasc, telefone, codFuncional, salario);
		this.departamento = departamento;
	}

	public FuncionarioTecnicoAdministrativo() {
		super();
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDepartamento: " + departamento;
	}
	
}
