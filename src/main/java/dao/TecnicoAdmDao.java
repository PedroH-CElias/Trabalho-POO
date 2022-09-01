//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package dao;

import conexao.BancoDados;
import entities.FuncionarioTecnicoAdministrativo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TecnicoAdmDao {

    // Método para gravar um funcionário no BD
    public void gravar(FuncionarioTecnicoAdministrativo t) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("insert into tecnicoadm(codigo,nome,cpf,dataNasc,telefone,codFun,salario,departamento) values (null,?,?,?,?,?,?,?)");
            sql.setInt(1,t.getCodigo());
            sql.setString(1, t.getNome());
            sql.setLong(2, t.getCpf());
            sql.setObject(3, t.getDataNasc());
            sql.setString(4, t.getTelefone());
            sql.setInt(5, t.getCodFuncional());
            sql.setFloat(6, (float) t.getSalario());
            sql.setString(7, t.getDepartamento());

            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    // Método para buscar as pessoas cadastradas no BD
    public ArrayList consultar() {
        PreparedStatement sql;
        ArrayList tecnicoAdm = new ArrayList();
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM tecnicoadm");
            ResultSet rs = sql.executeQuery();

            while (rs.next()) {
                FuncionarioTecnicoAdministrativo t = new FuncionarioTecnicoAdministrativo();
                t.setCodigo(rs.getInt("codigo"));
                t.setNome(rs.getString("nome"));
                t.setCpf(rs.getLong("cpf"));
                t.setDataNasc(rs.getDate("dataNasc"));
                t.setTelefone(rs.getString("telefone"));
                t.setCodFuncional(rs.getInt("codFun"));
                t.setSalario(rs.getFloat("salario"));
                t.setDepartamento(rs.getString("departamento"));

                tecnicoAdm.add(t);
            }// fim do while

        }// fim do try// fim do try// fim do try// fim do try
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return tecnicoAdm;
    }
    
    public FuncionarioTecnicoAdministrativo consultarUm(String cpf){
        PreparedStatement sql; 
        FuncionarioTecnicoAdministrativo t = new FuncionarioTecnicoAdministrativo();
        try{
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM tecnicoadm WHERE cpf LIKE ?");
            sql.setLong(1, Long.parseLong(cpf));
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()){
                t.setCodigo(rs.getInt("codigo"));
                t.setNome(rs.getString("nome"));
                t.setCpf(rs.getLong("cpf"));
                t.setDataNasc(rs.getDate("dataNasc"));
                t.setTelefone(rs.getString("telefone"));
                t.setCodFuncional(rs.getInt("codFun"));
                t.setSalario(rs.getFloat("salario"));
                t.setDepartamento(rs.getString("departamento"));
                
            }// fim do while
            
        }// fim do try// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return t;
    }

    public void alterar(FuncionarioTecnicoAdministrativo t, String cpf) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement
        ("update tecnicoadm set nome=?, cpf=?, dataNasc=? , telefone=?, codFun=? , salario=? , departamento=?  where cpf=?");
            sql.setString(1, t.getNome());
            sql.setLong(2, t.getCpf());
            sql.setObject(3, t.getDataNasc());
            sql.setString(4, t.getTelefone());
            sql.setInt(5, t.getCodFuncional());
            sql.setFloat(6, (float) t.getSalario());
            sql.setString(7, t.getDepartamento());
            sql.setLong(8,Long.parseLong(cpf));
            sql.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void excluir(Long cpf) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("delete from tecnicoadm where cpf=?");
            sql.setLong(1, cpf);
            sql.execute();
            JOptionPane.showMessageDialog(null, "Técnico ADM excluído com sucesso!");
            return;
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }

}
