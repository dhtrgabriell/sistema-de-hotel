package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    @Override
    public void Create(Fornecedor objeto) {
        String sqlInstrucao = "Insert into fornecedor"
                + "(nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, "
                + "data_cadastro, cpf, rg, obs, status, razao_social, cnpj, "
                + "inscricao_estadual, contato) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone()); // Verifique se é getFone1() ou getFone()
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
            pstm.setString(15, objeto.getRazaoSocial()); 
            pstm.setString(16, objeto.getCnpj());        
            pstm.setString(17, objeto.getInscricaoEstadual());
            pstm.setString(18, objeto.getContato());      

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Fornecedor Retrieve(int id) {
        String sqlInstrucao = "Select id, nome, fone, fone2, email, cep, logradouro, bairro, cidade, "
                + "complemento, data_cadastro, cpf, rg, obs, status, razao_social, cnpj, "
                + "inscricao_estadual, contato from fornecedor where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Fornecedor fornecedor = new Fornecedor();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            if (rst.next()) {
                fornecedor.setId(rst.getInt("id")); // Adicionado o ID
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString("email"));
                // ... continue preenchendo todos os outros campos aqui
                fornecedor.setContato(rst.getString("contato"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select id, nome, fone, fone2, email, cep, logradouro, bairro, cidade, "
                + "complemento, data_cadastro, cpf, rg, obs, status, razao_social, cnpj, "
                + "inscricao_estadual, contato from fornecedor where " + atributo + " like ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setRazaoSocial(rst.getString("razao_social"));
                fornecedor.setCnpj(rst.getString("cnpj"));
                // ... continue preenchendo todos os outros campos aqui

                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return listaFornecedor;
    }

    @Override
    public void Update(Fornecedor objeto) {
        String sqlInstrucao = "Update fornecedor set nome = ?, fone = ?, fone2 = ?, email = ?, "
                + "cep = ?, logradouro = ?, bairro = ?, cidade = ?, complemento = ?, "
                + "data_cadastro = ?, cpf = ?, rg = ?, obs = ?, status = ?, razao_social = ?, "
                + "cnpj = ?, inscricao_estadual = ?, contato = ? where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
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
            pstm.setString(15, objeto.getRazaoSocial());
            pstm.setString(16, objeto.getCnpj());
            pstm.setString(17, objeto.getInscricaoEstadual());
            pstm.setString(18, objeto.getContato());
            pstm.setInt(19, objeto.getId());

            pstm.executeUpdate(); // Use executeUpdate() para INSERT, UPDATE, DELETE

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}