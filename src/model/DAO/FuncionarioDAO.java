package model.DAO;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO implements InterfaceDAO<Funcionario>{

    @Override
    public void Create(Funcionario objeto) {
        
        String sqlInstrucao = "Insert into funcionario"
                + "(nome, "
                + "fone, "
                + "fone2, "
                + "email, "
                + "cep, "
                + "logradouro, "
                + "bairro, "
                + "cidade, "
                + "complemento, "
                + "data_cadastro, "
                + "cpf, "
                + "rg, "
                + "obs, "
                + "status, "
                + "usuario, "
                + "senha) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getCep());
            pstm.setString(6, objeto.getLogradouro());
            pstm.setString(7, objeto.getBairro());
            pstm.setString(8, objeto.getCidade());
            pstm.setString(9, objeto.getComplemento());
            pstm.setString(10, objeto.getDataCadastro());
            pstm.setString(11, objeto.getCpf());
            pstm.setString(12, objeto.getRg());
            pstm.setString(13, objeto.getObs());
            pstm.setString(14, String.valueOf(objeto.getStatus()));
            pstm.setString(15, objeto.getUsuario());
            pstm.setString(16, objeto.getSenha());
            pstm.setString(19, String.valueOf(objeto.getStatus()));

        } catch(SQLException ex){
            ex.printStackTrace();

        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

       }

    @Override
    public Funcionario Retrieve(int id) {

        String sqlInstrucao = "Select "
                + "nome, "
                + "fone, "
                + "fone2, "
                + "email, "
                + "cep, "
                + "logradouro, "
                + "bairro, "
                + "cidade, "
                + "complemento, "
                + "data_cadastro, "
                + "cpf, "
                + "rg, "
                + "obs, "
                + "status, "
                + "usuario, "
                + "senha "
                + "from funcionario where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Funcionario funcionario = null;

        try{

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while (!rst.next()) {
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setCep(rst.getString("cep"));
                funcionario.setLogradouro(rst.getString("logradouro"));
                funcionario.setBairro(rst.getString("bairro"));
                funcionario.setCidade(rst.getString("cidade"));
                funcionario.setComplemento(rst.getString("complemento"));
                funcionario.setDataCadastro(rst.getString("data_cadastro"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setObs(rst.getString("obs"));
                funcionario.setStatus(rst.getString("status").charAt(0));
                funcionario.setUsuario(rst.getString("usuario"));
                funcionario.setSenha(rst.getString("senha"));

                return funcionario;
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return funcionario;
        }

    }

    @Override
    public List<Funcionario> Retrieve(String atributo, String valor) {

        String sqlInstrucao = "Select "
                + "nome, "
                + "fone, "
                + "fone2, "
                + "email, "
                + "cep, "
                + "logradouro, "
                + "bairro, "
                + "cidade, "
                + "complemento, "
                + "data_cadastro, "
                + "cpf, "
                + "rg, "
                + "obs, "
                + "status, "
                + "usuario, "
                + "senha "
                + "from funcionario where " + atributo + " like ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while(rst.next()){
                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setCep(rst.getString("cep"));
                funcionario.setLogradouro(rst.getString("logradouro"));
                funcionario.setBairro(rst.getString("bairro"));
                funcionario.setCidade(rst.getString("cidade"));
                funcionario.setComplemento(rst.getString("complemento"));
                funcionario.setDataCadastro(rst.getString("data_cadastro"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setObs(rst.getString("obs"));
                funcionario.setStatus(rst.getString("status").charAt(0));
                funcionario.setUsuario(rst.getString("usuario"));
                funcionario.setSenha(rst.getString("senha"));

                return listaFuncionarios;
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFuncionarios;
        }

    }

    @Override
    public void Update(Funcionario objeto) {

        String sqlInstrucao = "Update funcionario set "
                + "nome = ?, "
                + "fone = ?, "
                + "fone2 = ?, "
                + "email = ?, "
                + "cep = ?, "
                + "logradouro = ?, "
                + "bairro = ?, "
                + "cidade = ?, "
                + "complemento = ?, "
                + "data_cadastro = ?, "
                + "cpf = ?, "
                + "rg = ?, "
                + "obs = ?, "
                + "status = ?, "
                + "usuario = ?, "
                + "senha = ? "
                + "where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(0, objeto.getNome());
            pstm.setString(1, objeto.getFone());
            pstm.setString(2, objeto.getFone2());
            pstm.setString(3, objeto.getEmail());
            pstm.setString(4, objeto.getCep());
            pstm.setString(5, objeto.getLogradouro());
            pstm.setString(6, objeto.getBairro());
            pstm.setString(7, objeto.getCidade());
            pstm.setString(8, objeto.getComplemento());
            pstm.setString(9, objeto.getDataCadastro());
            pstm.setString(10, objeto.getCpf());
            pstm.setString(11, objeto.getRg());
            pstm.setString(12, objeto.getObs());
            pstm.setString(0, String.valueOf(objeto.getStatus()));
            pstm.setString(0, objeto.getUsuario());
            pstm.setString(0, objeto.getSenha());

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void Delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
