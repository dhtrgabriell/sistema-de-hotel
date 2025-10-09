package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Quarto;

public class QuartoDAO implements InterfaceDAO<Quarto>{

    @Override
    public void Create(Quarto objeto) {
        String sqlInstrucao = "Insert into quarto"
                + "(descricao, "
                + "capacidade_hospedes, "
                + "metragem, identificacao, "
                + "andar, "
                + "flag_animais, "
                + "obs, status) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try{

            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getCapacidadeHospedes());
            pstm.setFloat(3, objeto.getMetragem());
            pstm.setString(4, objeto.getIdentificacao());
            pstm.setInt(5, objeto.getAndar());
            pstm.setBoolean(6, objeto.isFlagAnimais());
            pstm.setString(7, objeto.getObs());
            pstm.setString(8, String.valueOf(objeto.getStatus()));

            pstm.execute();

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public Quarto Retrieve(int id) {
        String sqlInstrucao = "Select "
                + "id, "
                + "descricao, "
                + "capacidade_hospedes, "
                + "metragem, "
                + "identificacao, "
                + "andar, "
                + "flag_animais, "
                + "obs, "
                + "status "
                + "from quarto where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Quarto quarto = new Quarto();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while(rst.next()){

                quarto.setId(rst.getInt("id"));
                quarto.setDescricao(rst.getString("descricao"));
                quarto.setCapacidadeHospedes(rst.getInt("capacidade_hospedes"));
                quarto.setMetragem(rst.getFloat("metragem"));
                quarto.setIdentificacao(rst.getString("identificacao"));
                quarto.setAndar(rst.getInt("andar"));
                quarto.setFlagAnimais(rst.getBoolean("flag_animais"));
                quarto.setObs(rst.getString("obs"));
                quarto.setStatus(rst.getString("status").charAt(0));

                return quarto;

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return quarto;
        }
    }

    @Override
    public List<Quarto> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select "
                + "id, "
                + "descricao, "
                + "capacidade_hospedes, "
                + "metragem, "
                + "identificacao, "
                + "andar, "
                + "flag_animais, "
                + "obs, "
                + "status "
                + "from quarto where " + atributo + " like ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Quarto> listaQuartos = new ArrayList<>();

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();

            while(rst.next()){

                Quarto quarto = new Quarto();

                quarto.setId(rst.getInt("id"));
                quarto.setDescricao(rst.getString("descricao"));
                quarto.setCapacidadeHospedes(rst.getInt("capacidade_hospedes"));
                quarto.setMetragem(rst.getFloat("metragem"));
                quarto.setIdentificacao(rst.getString("identificacao"));
                quarto.setAndar(rst.getInt("andar"));
                quarto.setFlagAnimais(rst.getBoolean("flag_animais"));
                quarto.setObs(rst.getString("obs"));
                quarto.setStatus(rst.getString("status").charAt(0));

                listaQuartos.add(quarto);
                return listaQuartos;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaQuartos;
        }
    }

    @Override
    public void Update(Quarto objeto) {
        String sqlInstrucao = "update quarto set "
                + "descricao = ?, "
                + "capacidade_hospedes = ?, "
                + "metragem = ?, "
                + "identificacao = ?, "
                + "andar = ?, "
                + "flag_animais = ?, "
                + "obs = ?, "
                + "status = ? "
                + "where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try {

            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getCapacidadeHospedes());
            pstm.setFloat(3, objeto.getMetragem());
            pstm.setString(4, objeto.getIdentificacao());
            pstm.setInt(5, objeto.getAndar());
            pstm.setBoolean(6, objeto.isFlagAnimais());
            pstm.setString(7, objeto.getObs());
            pstm.setString(8, String.valueOf(objeto.getStatus()));
            pstm.setInt(9, objeto.getId());

            pstm.execute();

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void Delete(Quarto objeto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
