//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package dao;

import application.Usuario;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDao {

    // Método para gravar um funcionário no BD
    public void gravar(Usuario u) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("insert into usuario(codigo, nome, senha) values (null,?,?)");
            //sql.setInt(1,p.getCod());
            sql.setString(1, u.getUsuario());
            sql.setString(2, u.getSenha());
            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean logar(String usuario, String senha) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM usuario WHERE nome=? AND senha=?");
            sql.setString(1, usuario);
            sql.setString(2, senha);
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                if (rs.getInt("codigo") != 0) {
                    JOptionPane.showMessageDialog(null, "Logado com sucesso!");
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Método para buscar as pessoas cadastradas no BD
    public ArrayList consultar() {
        PreparedStatement sql;
        ArrayList usuarios = new ArrayList();
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM usuario");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCodigo(rs.getInt("codigo"));
                u.setUsuario(rs.getString("nome"));
                usuarios.add(u);
            }// fim do while

        }// fim do try
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return usuarios;
    }

    /*public void alterar(Usuario u){
        PreparedStatement sql;
        try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("update funcionario set nome=?, salario=? where cod=?");
        sql.setString(1,u.getUsuario());
        sql.setDouble(2,u.getSenha());
        sql.setInt(3,u.getCodigo());
        sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }*/
    public void excluir(Usuario u) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("delete from usuario where codigo=?");
            sql.setInt(1, u.getCodigo());
            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
