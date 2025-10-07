package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class FuncionarioDAO implements InterfaceDAO<Funcionario> {

    @Override
    public void Create(Funcionario objeto) {
        // CORRIGIDO: Removido usuario e senha. Agora são 14 colunas e 14 '?'
        String sqlInstrucao = "Insert into funcionario"
                + "(nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, "
                + "data_cadastro, cpf, rg, obs, status) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);

            // CORRIGIDO: Sequência de parâmetros ajustada de 1 a 14
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

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Funcionario Retrieve(int id) {
        // CORRIGIDO: Removido usuario e senha do SELECT
        String sqlInstrucao = "Select id, nome, fone, fone2, email, cep, logradouro, bairro, cidade, "
                + "complemento, data_cadastro, cpf, rg, obs, status "
                + "from funcionario where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Funcionario funcionario = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            // CORRIGIDO: Lógica ajustada para if(rst.next())
            if (rst.next()) {
                funcionario = new Funcionario(); // Inicializa o objeto APENAS se encontrar
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
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        // CORRIGIDO: return fora do 'finally'
        return funcionario;
    }

    @Override
    public List<Funcionario> Retrieve(String atributo, String valor) {
        // CORRIGIDO: Removido usuario e senha do SELECT
        String sqlInstrucao = "Select id, nome, fone, fone2, email, cpf, rg, status "
                + "from funcionario where " + atributo + " like ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString("email"));
                funcionario.setCpf(rst.getString("cpf"));
                funcionario.setRg(rst.getString("rg"));
                funcionario.setStatus(rst.getString("status").charAt(0));
                
                // CORRIGIDO: Adiciona à lista em vez de retornar
                listaFuncionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        // CORRIGIDO: return da lista completa aqui.
        return listaFuncionarios;
    }

    @Override
    public void Update(Funcionario objeto) {
        // CORRIGIDO: Removido usuario e senha do UPDATE
        String sqlInstrucao = "Update funcionario set nome = ?, fone = ?, fone2 = ?, email = ?, "
                + "cep = ?, logradouro = ?, bairro = ?, cidade = ?, complemento = ?, "
                + "data_cadastro = ?, cpf = ?, rg = ?, obs = ?, status = ? "
                + "where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            // CORRIGIDO: Índices de 1 a 15 (14 para SET + 1 para WHERE)
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
            pstm.setInt(15, objeto.getId()); // Parâmetro do WHERE

            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}