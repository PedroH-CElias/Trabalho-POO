//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package entities;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class Alunos extends Pessoas {
	DecimalFormat df = new DecimalFormat("0.00");
	private String ra;
	private float cora;

	public Alunos(String nome, long cpf, Date dataNasc, String telefone, String ra, float cora) {
		super(nome, cpf, dataNasc, telefone);
		this.ra = ra;
		this.cora = cora;
	}

	public Alunos(){
		super();
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public float getCora() {
		return cora;
	}

	public void setCora(float cora) {
		this.cora = cora;
	}

	@Override
	public String toString() {
		return super.toString() + "\nRA: " + ra + "\nCORA: " + df.format(cora);
	}
}
