//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package dao;

import conexao.BancoDados;
import entities.Alunos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AlunoDao {

    Alunos selecionado = new Alunos();
    // Método para gravar um funcionário no BD

    public void gravar(Alunos a) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("insert into aluno(codigo,nome,cpf,dataNasc,telefone,ra,cora) values (null,?,?,?,?,?,?)");
            //sql.setInt(1,a.getCodigo());
            sql.setString(1, a.getNome());
            sql.setLong(2, a.getCpf());
            sql.setObject(3, a.getDataNasc());
            sql.setString(4, a.getTelefone());
            sql.setString(5, a.getRa());
            sql.setFloat(6, a.getCora());
            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    // Método para buscar as pessoas cadastradas no BD
    public ArrayList consultar() {
        PreparedStatement sql;
        ArrayList alunos = new ArrayList();
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM aluno");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Alunos a = new Alunos();
                a.setCodigo(rs.getInt("codigo"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getLong("cpf"));
                a.setDataNasc(rs.getDate("dataNasc"));
                a.setTelefone(rs.getString("telefone"));
                a.setRa(rs.getString("ra"));
                a.setCora(rs.getFloat("cora"));
                alunos.add(a);
            }// fim do while

        }// fim do try
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return alunos;
    }
    
     public Alunos consultarUm(String cpf) {
        PreparedStatement sql;
       Alunos a = new Alunos();
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM aluno WHERE cpf LIKE ?");
            sql.setLong(1, Long.parseLong(cpf));
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                a.setCodigo(rs.getInt("codigo"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getLong("cpf"));
                a.setDataNasc(rs.getDate("dataNasc"));
                a.setTelefone(rs.getString("telefone"));
                a.setRa(rs.getString("ra"));
                a.setCora(rs.getFloat("cora"));
            }// fim do while

        }// fim do try
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;
    }

    public void alterar(Alunos a,String cpf) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("update aluno set nome=?, cpf=?, dataNasc=? , telefone=? , ra=? , cora=?  where cpf=?");
            sql.setString(1, a.getNome());
            sql.setLong(2, a.getCpf());
            sql.setObject(3, a.getDataNasc());
            sql.setString(4, a.getTelefone());
            sql.setString(5, a.getRa());
            sql.setFloat(6, a.getCora());
            sql.setLong(7, Long.parseLong(cpf));
            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void excluir(Long cpf) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("delete from aluno where cpf=?");
            sql.setLong(1, cpf);
            sql.execute();
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
            return;
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }

}
