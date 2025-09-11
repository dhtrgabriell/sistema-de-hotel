package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import models.Fornecedor;
import models.Funcionario;
import models.Hospede;
import models.Modelo;
import models.Veiculo;

public class VeiculoDAO implements InterfaceDAO<Veiculo>{

    @Override
    public void Create(Veiculo objeto) {
        String sqlInstrucao = "Insert into veiculo(placa, cor, modelo_id, funcionario_id, fornecedor_id, hospede_id, status) values(?, ?, ?, ?, ?, ?, ?,)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getPlaca());
            pstm.setString(2, objeto.getCor());
            pstm.setString(3, String.valueOf(objeto.getModelo()));
            pstm.setString(4, String.valueOf(objeto.getFuncionario()));
            pstm.setString(5, String.valueOf(objeto.getFornecedor()));
            pstm.setString(6, String.valueOf(objeto.getHospede()));
            pstm.setString(7, String.valueOf(objeto.getStatus()));

            pstm.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Veiculo Retrieve(int id) {
        String sqlInstrucao = "Select id, placa, cor, modelo_id, funcionario_id, fornecedor_id, hospede_id, status from veiculo where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Veiculo veiculo = new Veiculo();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while(rst.next()){

                veiculo.setId(rst.getInt("id"));
                veiculo.setPlaca(rst.getString("placa"));
                veiculo.setCor(rst.getString("cor"));
                veiculo.setModelo(null); //new Modelo(rst.getInt("modelo_id"));
                veiculo.setFuncionario(null); //new Funcionario(rst.getInt("funcionario_id"));
                veiculo.setFornecedor(null); //new Fornecedor(rst.getInt("fornecedor_id"));
                veiculo.setHospede(null); //new Hospede(rst.getInt("hospede_id"));
                veiculo.setStatus(rst.getString("status").charAt(0));

                return veiculo;

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return veiculo;
        }

    }

    @Override
    public List<Veiculo> Retrieve(String atributo, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update(Veiculo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete(Veiculo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
