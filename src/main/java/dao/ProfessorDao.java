//Grupo: Bruno Dionísio Alves, Jean Maia Mendonça dos Santos, Pedro Henrique Cardoso Elias
package dao;

import conexao.BancoDados;
import entities.FuncionarioProfessor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ProfessorDao {    
    // Método para gravar um funcionário no BD
    public void gravar(FuncionarioProfessor p){
        PreparedStatement sql;
        try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("insert into professor(codigo,nome,cpf,dataNasc,telefone,codFun,salario,areaDeAtuacao) values (null,?,?,?,?,?,?,?)");
        //sql.setInt(1,p.getCodigo());
        sql.setString(1,p.getNome());
        sql.setLong(2,p.getCpf());
        sql.setObject(3,p.getDataNasc());
        sql.setString(4,p.getTelefone());
        sql.setInt(5,p.getCodFuncional());
        sql.setFloat(6, p.getSalario());
        sql.setString(7,p.getAreaDeAtuacao());
        
        sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
        
    }
    
    
    
     // Método para buscar as pessoas cadastradas no BD
    public ArrayList consultar(){
        PreparedStatement sql; 
        ArrayList professores = new ArrayList();
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("SELECT * FROM professor");
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()){
                FuncionarioProfessor p = new FuncionarioProfessor();
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getLong("cpf"));
                p.setDataNasc(rs.getDate("dataNasc"));
                p.setTelefone(rs.getString("telefone"));
                p.setCodFuncional(rs.getInt("codFun"));
                p.setSalario(rs.getFloat("salario"));
                p.setAreaDeAtuacao(rs.getString("areaDeAtuacao"));
                
                professores.add(p);
            }// fim do while
            
        }// fim do try// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return professores;
    }
    
    public FuncionarioProfessor consultarUm(String cpf){
        PreparedStatement sql; 
        FuncionarioProfessor p = new FuncionarioProfessor();
        try{
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("SELECT * FROM professor WHERE cpf LIKE ?");
            sql.setLong(1, Long.parseLong(cpf));
            ResultSet rs = sql.executeQuery();
            
            while(rs.next()){
                p.setCodigo(rs.getInt("codigo"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getLong("cpf"));
                p.setDataNasc(rs.getDate("dataNasc"));
                p.setTelefone(rs.getString("telefone"));
                p.setCodFuncional(rs.getInt("codFun"));
                p.setSalario(rs.getFloat("salario"));
                p.setAreaDeAtuacao(rs.getString("areaDeAtuacao"));
                
            }// fim do while
            
        }// fim do try// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return p;
    }
    
    
    public void alterar(FuncionarioProfessor p, String cpf){
        PreparedStatement sql;
        try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("update professor set nome=?, cpf=?, dataNasc=? , telefone=?, codFun=? , salario=? , areaDeAtuacao=?  where cpf=?");
        sql.setString(1,p.getNome());
        sql.setLong(2,p.getCpf());
        sql.setObject(3, p.getDataNasc());
        sql.setString(4,p.getTelefone());
        sql.setInt(5,p.getCodFuncional());
        sql.setFloat(6, (float) p.getSalario());
        sql.setString(7,p.getAreaDeAtuacao());
        sql.setLong(8,Long.parseLong(cpf));
        sql.execute();
        }
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
    
   public void excluir(Long cpf) {
        PreparedStatement sql;
        try {
            sql = (PreparedStatement) BancoDados.getInstance().prepareStatement("delete from professor where cpf=?");
            sql.setLong(1, cpf);
            sql.execute();
            JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
            return;
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }
    
    

}