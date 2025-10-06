package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Hospede;

public class HospedeDAO implements InterfaceDAO<Hospede>{

    @Override
    public void Create(Hospede objeto) {

        String sqlInstrucao = "Insert into hospede"
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
                + "razao_social, "
                + "cnpj, "
                + "inscricao_estadual, "
                + "contato) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(15, objeto.getRazaoSocial());
            pstm.setString(16, objeto.getCnpj());
            pstm.setString(17, objeto.getInscricaoEstadual());
            pstm.setString(18, objeto.getContato());

            pstm.execute();

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        

    }

    @Override
    public Hospede Retrieve(int id) {

        String sqlInstrucao = "Select "
                + "id, "
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
                + "from hospede where id = ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        Hospede hospede = new Hospede();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();

            while(rst.next()){

                hospede.setId(rst.getInt("id"));
                hospede.setNome(rst.getString("nome"));
                hospede.setFone1(rst.getString("fone"));
                hospede.setFone2(rst.getString("fone2"));
                hospede.setEmail(rst.getString("email"));
                hospede.setCep(rst.getString("cep"));
                hospede.setLogradouro(rst.getString("logradouro"));
                hospede.setBairro(rst.getString("bairro"));
                hospede.setCidade(rst.getString("cidade"));
                hospede.setComplemento(rst.getString("complemento"));
                hospede.setDataCadastro(rst.getString("data_cadastro"));
                hospede.setCpf(rst.getString("cpf"));
                hospede.setRg(rst.getString("rg"));
                hospede.setObs(rst.getString("obs"));
                hospede.setStatus(rst.getString("status").charAt(0));
                hospede.setRazaoSocial(rst.getString("razao_social"));
                hospede.setCnpj(rst.getString("cnpj"));
                hospede.setInscricaoEstadual(rst.getString("inscricao_estadual"));
                hospede.setContato(rst.getString("contato"));

                return hospede;

            }

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return hospede;
        }

    }

    @Override
    public List<Hospede> Retrieve(String atributo, String valor) {
        String sqlInstrucao = "Select "
                + "id, "
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
                + "from hospede where " + atributo + " like ?";
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;

        List<Hospede> listaHospedes = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");;
            rst = pstm.executeQuery();

            while(rst.next()){
                Hospede hospede = new Hospede();

                hospede.setId(rst.getInt("id"));
                hospede.setNome(rst.getString("nome"));
                hospede.setFone1(rst.getString("fone"));
                hospede.setFone2(rst.getString("fone2"));
                hospede.setEmail(rst.getString("email"));
                hospede.setCep(rst.getString("cep"));
                hospede.setLogradouro(rst.getString("logradouro"));
                hospede.setBairro(rst.getString("bairro"));
                hospede.setCidade(rst.getString("cidade"));
                hospede.setComplemento(rst.getString("complemento"));
                hospede.setDataCadastro(rst.getString("data_cadastro"));
                hospede.setCpf(rst.getString("cpf"));
                hospede.setRg(rst.getString("rg"));
                hospede.setObs(rst.getString("obs"));
                hospede.setStatus(rst.getString("status").charAt(0));
                hospede.setRazaoSocial(rst.getString("razao_social"));
                hospede.setCnpj(rst.getString("cnpj"));
                hospede.setInscricaoEstadual(rst.getString("inscricao_estadual"));
                hospede.setContato(rst.getString("contato"));

                return listaHospedes;

            }

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaHospedes;
        }
    }

    @Override
    public void Update(Hospede objeto) {
        
        String sqlInstrucao = "Update hospede set "
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
                + "where id = ?";

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        try{
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

            pstm.execute();

        } catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
    }

    @Override
    public void Delete(Hospede objeto) {
        
    }
    
}
