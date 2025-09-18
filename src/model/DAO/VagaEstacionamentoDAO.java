package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.VagaEstacionamento;

public class VagaEstacionamentoDAO implements InterfaceDAO<VagaEstacionamento>{

    @Override
    public void Create(VagaEstacionamento objeto) {
        String sqlInstrucao = "Insert into vaga_estacionamento(descricao, obs, metragem_vaga, status) values (?, ?, ?, ?)";

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
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public VagaEstacionamento Retrieve(int id) {
        String sqlInstrucao = "Select * from vaga_estacionamento where id = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        VagaEstacionamento vaga = new VagaEstacionamento();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while (rst.next()) {
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
            return vaga;
        }

    }

    @Override
    public List<VagaEstacionamento> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select * from vaga_estacionamento where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<VagaEstacionamento> listaVagas = new ArrayList<>();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, valor);
            rst = pstm.executeQuery();

            while (rst.next()) {
                VagaEstacionamento vaga = new VagaEstacionamento();

                vaga.setId(rst.getInt("id"));
                vaga.setDescricao(rst.getString("descricao"));
                vaga.setObs(rst.getString("obs"));
                vaga.setMetragemVaga(rst.getFloat("metragem_vaga"));
                vaga.setStatus(rst.getString("status").charAt(0));

                listaVagas.add(vaga);
                return listaVagas;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaVagas;
        }
    }

    @Override
    public void Update(VagaEstacionamento objeto) {
        String sqlInstrucao = "Update vaga_estacionamento set descricao = ?, obs = ?, metragem_vaga = ?, status = ? where id = ?";

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
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(VagaEstacionamento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
