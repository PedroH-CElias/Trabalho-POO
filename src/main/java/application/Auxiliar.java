//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package application;

import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import entities.Alunos;
import entities.Funcionario;
import entities.FuncionarioProfessor;
import entities.FuncionarioTecnicoAdministrativo;
import entities.Pessoas;

public class Auxiliar {

    Cpf cpf = new Cpf();

    //Cria senha
    public void criaSenha(Usuario senha) {
        senha.geraSenha();
        JOptionPane.showMessageDialog(null, "Usuário: "
                + senha.getUsuario()
                + "\nSenha gerada! \nPrimeiro nome do usuário em maiusculo + Data de criação da conta(ddMMyyyy)\nExemplo: JOAO20032001"
        );
        /*String senhaDigitada = JOptionPane.showInputDialog("Usuario: "
                + senha.getUsuario() + "\nSenha: ");
        while (!senha.verificaSenha(senhaDigitada)) {
            JOptionPane.showMessageDialog(null, "Senha inválida", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            senhaDigitada
                    = JOptionPane.showInputDialog("Usuario: " + senha.getUsuario() + "\nSenha: ");
        }
        JOptionPane.showMessageDialog(null, "Usuario " + senha.getUsuario()
                + " logado com sucesso!", "CORRETO", JOptionPane.PLAIN_MESSAGE);*/

    }
    
}
  
