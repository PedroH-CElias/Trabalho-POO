//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import application.Cpf;

//Classe mãe
public class Pessoas {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// Formato pré definido para as datas
	Cpf cpfaux = new Cpf();
        protected int codigo;
	protected Date dataAtual = new Date();
	protected String nome;
	protected long cpf;
	protected Date dataNasc;
	protected String telefone;
	protected String aux;
	protected Cpf validaCpf = new Cpf();
	public Pessoas(){
		
	}
	public Pessoas(String nome, long cpf, Date dataNasc, String telefone) {
		this.dataNasc = dataNasc;
                validaData();
		this.nome = nome;
		this.cpf=cpf;
                if(!validaCpf.validaCpf(cpf)){
                    JOptionPane.showMessageDialog(null,"Erro! Cpf inválido!","ERROR!",JOptionPane.ERROR_MESSAGE);
                }
		this.telefone = telefone;
	}

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

       
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc= dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Método para calcular a idade atual de acordo com a data atual e data de nascimento cadastrada
	public long idadeAtual() {
		long diff = dataAtual.getTime() - dataNasc.getTime();
		TimeUnit time = TimeUnit.DAYS;
		
		return (time.convert(diff,TimeUnit.MILLISECONDS))/365; 
	}
	
	//Método para validação de datas, de acordo com o formato, se ela é uma data existente e válida
	public void validaData() {
		sdf.setLenient(false);
		try {
			this.dataNasc = sdf.parse(aux);
			sdf.parse(aux);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "ERRO! Data inválida.","ERRO!",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	//Método para mostrar os atributos de pessoas
	@Override
	public String toString() {
		return "Nome: " + nome + "\nCPF: " + cpf + "\nData de Nascimento: " + sdf.format(dataNasc) + "\nTelefone: "
				+ telefone + "\nIdade atual: " + idadeAtual();
	}
}
