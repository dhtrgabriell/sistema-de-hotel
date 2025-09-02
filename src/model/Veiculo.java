package model;

public class Veiculo {
    private String placa;
    private Modelo modelo;
    private Marca marca;

    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private Hospede hospede;

    public Veiculo() {}

    public Veiculo(String placa, Modelo modelo, Marca marca, Funcionario funcionario, Fornecedor fornecedor, Hospede hospede) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;

        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.hospede = hospede;
    }

    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    
}