package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Hospede;

public class HospedeDAO implements InterfaceDAO<Hospede>{

    @Override
    public void Create(Hospede objeto) {

        String sqlInstrucao = "Insert into hospede(nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, data_cadastro, cpf, rg, obs, status, usuario, senha, razao_social, cnpj, inscricao_estadual, contato) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{

            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement pstm = null;
            pstm = conexao.prepareStatement(sqlInstrucao);

            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());

            pstm.execute();

        } catch(SQLException ex){
            ex.printStackTrace();
        }
        

    }

    @Override
    public Hospede Retrieve(int id) {
        throw new RuntimeException("Seila");
    }

    @Override
    public List<Hospede> Retrieve(String atributo, String valor) {
        throw new RuntimeException("Seila2");
    }

    @Override
    public void Update(Hospede objeto) {
        
    }

    @Override
    public void Delete(Hospede objeto) {
        
    }
    
}
