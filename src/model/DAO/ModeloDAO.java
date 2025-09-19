package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Marca;
import model.Modelo;

public class ModeloDAO implements InterfaceDAO<Modelo>{

    @Override
    public void Create(Modelo objeto) {
        String sqlInstrucao = "Insert into modelo("
                + "descricao, "
                + "status, "
                + "marca_id) "
                + "values(?, ?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {
            
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(0, objeto.getDescricao());
            pstm.setString(1, String.valueOf(objeto.getStatus()));
            pstm.setInt(2, objeto.getMarca().getId());

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public Modelo Retrieve(int id) {
        String sqlInstrucao = "Select "
                + "id, "
                + "descricao, "
                + "status, "
                + "marca_id "
                + "from modelo where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Modelo modelo = new Modelo();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while(rst.next()){

                modelo.setId(rst.getInt("id"));
                modelo.setDescricao(rst.getString("descricao"));
                modelo.setStatus(rst.getString("status").charAt(0));
                modelo.setMarca(null);//new Marca(rst.getInt("marca_id")));

                return modelo;

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return modelo;
        }

    }

    @Override
    public List<Modelo> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select "
                + "id, "
                + "descricao, "
                + "status, "
                + "marca_id "
                + "from modelo where " + atributo + " like ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Modelo> listaModelos = new ArrayList<>();

        try{

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while(rst.next()){

                Modelo modelo = new Modelo();

                modelo.setId(rst.getInt("id"));
                modelo.setDescricao(rst.getString("descricao"));
                modelo.setStatus(rst.getString("status").charAt(0));
                modelo.setMarca(null);//new Marca(rst.getInt("marca_id")));
                listaModelos.add(modelo);

            }

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaModelos;
        }

    }

    @Override
    public void Update(Modelo objeto) {
        String sqlInstrucao = "Update modelo set "
                + "descricao = ?, "
                + "status = ?, "
                + "marca_id = ? "
                + "where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, String.valueOf(objeto.getStatus()));
            pstm.setInt(3, objeto.getMarca().getId());
            pstm.setInt(4, objeto.getId());

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Modelo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
