package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Fornecedor;
import java.sql.SQLException;

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    @Override
    public void Create(Fornecedor objeto) {

        String sqlInstrucao = "Insert into fornecedor(nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, data_cadastro, cpf, rg, obs, status, razao_social, cnpj, inscricao_estadual, contato) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 

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
            pstm.setString(17, objeto.getRazaoSocial());
            pstm.setString(18, objeto.getCnpj());
            pstm.setString(19, objeto.getInscricaoEstadual());
            pstm.setString(20, objeto.getContato());

            pstm.execute();

        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public Fornecedor Retrieve(int id) {
        String sqlInstrucao = "Select nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, data_cadastro, cpf, rg, obs, status, razao_social, cnpj, inscricao_estadual, contato from fornecedor where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Fornecedor fornecedor = new Fornecedor();

        try{

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while (!rst.next()) {
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setCep(rst.getString("cep"));
                fornecedor.setLogradouro(rst.getString("logradouro"));
                fornecedor.setBairro(rst.getString("bairro"));
                fornecedor.setCidade(rst.getString("cidade"));
                fornecedor.setComplemento(rst.getString("complemento"));
                fornecedor.setDataCadastro(rst.getString("data_cadastro"));
                fornecedor.setCpf(rst.getString("cpf"));
                fornecedor.setRg(rst.getString("rg"));
                fornecedor.setObs(rst.getString("obs"));
                fornecedor.setStatus(rst.getString("status").charAt(0));
                fornecedor.setRazaoSocial(rst.getString("razao_social"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("inscricao_estadual"));
                fornecedor.setContato(rst.getString("contato"));
                
                return fornecedor;
            }

        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return fornecedor;
        }
    }

    @Override
    public List<Fornecedor> Retrieve(String atributo, String valor) {
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
                + "razao_social, "
                + "cnpj, "
                + "inscricao_estadual, "
                + "contato "
                + "from fornecedor where " + atributo + " like ?";
            
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        List<Fornecedor> listaFornecedor = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                fornecedor.setCep(rst.getString("Cep"));
                fornecedor.setLogradouro(rst.getString("logradouro"));
                fornecedor.setBairro(rst.getString("bairro"));
                fornecedor.setCidade(rst.getString("Cidade"));
                fornecedor.setComplemento(rst.getString("complemento"));
                fornecedor.setDataCadastro(rst.getString("data_cadastro"));
                fornecedor.setCpf(rst.getString("cpf"));
                fornecedor.setRg(rst.getString("rg"));
                fornecedor.setObs(rst.getString("obs"));
                fornecedor.setStatus(rst.getString("status").charAt(0));
                fornecedor.setRazaoSocial(rst.getString("razao_social"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                fornecedor.setInscricaoEstadual(rst.getString("inscricao_social"));
                fornecedor.setContato(rst.getString("contato"));
                
                return listaFornecedor;
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaFornecedor;
        }
            
    }

    @Override
    public void Update(Fornecedor objeto) {
        String sqlInstrucao = "Update fornecedor set "
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
                + "razao_social = ?, "
                + "cnpj = ?, "
                + "inscricao_estadual = ?, "
                + "contato = ? "
                + "from fornecedor where id = ?";
        
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
            pstm.setString(13, String.valueOf(objeto.getStatus()));
            pstm.setString(14, objeto.getRazaoSocial());
            pstm.setString(15, objeto.getCnpj());
            pstm.setString(16, objeto.getInscricaoEstadual());
            pstm.setString(17, objeto.getContato());
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
