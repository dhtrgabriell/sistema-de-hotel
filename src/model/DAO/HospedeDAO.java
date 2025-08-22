package model.DAO;

import java.util.List;
import model.Hospede;

public class HospedeDAO implements InterfaceDAO<Hospede>{

    @Override
    public void Create(Hospede objeto) {
        
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
