package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.VagaEstacionamento;

public class VagaEstacionamentoDAO implements InterfaceDAO<VagaEstacionamento> {

    @Override
    public void Create(VagaEstacionamento objeto) {
        String sqlInstrucao = "INSERT INTO vaga_estacionamento(descricao, obs, metragem_vaga, status) VALUES (?, ?, ?, ?)";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getObs());
            pstm.setFloat(3, (float) objeto.getMetragemVaga());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public VagaEstacionamento Retrieve(int id) {
        String sqlInstrucao = "SELECT * FROM vaga_estacionamento WHERE id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        VagaEstacionamento vaga = null; // Inicia como nulo

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            if (rst.next()) {
                vaga = new VagaEstacionamento();
                vaga.setId(rst.getInt("id"));
                vaga.setDescricao(rst.getString("descricao"));
                vaga.setObs(rst.getString("obs"));
                vaga.setMetragemVaga(rst.getFloat("metragem_vaga"));
                vaga.setStatus(rst.getString("status").charAt(0));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        return vaga;
    }

    @Override
    public List<VagaEstacionamento> Retrieve(String atributo, String valor) {
        // CORRIGIDO: A consulta agora é dinâmica
        String sqlInstrucao = "SELECT * FROM vaga_estacionamento WHERE " + atributo + " LIKE ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<VagaEstacionamento> listaVagas = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            // CORRIGIDO: Adicionado o '%' para a busca LIKE
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while (rst.next()) {
                VagaEstacionamento vaga = new VagaEstacionamento();
                vaga.setId(rst.getInt("id"));
                vaga.setDescricao(rst.getString("descricao"));
                vaga.setObs(rst.getString("obs"));
                vaga.setMetragemVaga(rst.getFloat("metragem_vaga"));
                vaga.setStatus(rst.getString("status").charAt(0));
                listaVagas.add(vaga);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, rst);
        }
        // CORRIGIDO: O return da lista completa é feito aqui
        return listaVagas;
    }

    @Override
    public void Update(VagaEstacionamento objeto) {
        String sqlInstrucao = "UPDATE vaga_estacionamento SET descricao = ?, obs = ?, metragem_vaga = ?, status = ? WHERE id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getObs());
            pstm.setFloat(3, (float) objeto.getMetragemVaga());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            pstm.setInt(5, objeto.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(VagaEstacionamento objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}