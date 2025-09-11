package controller;

import models.ProdutoCopa;
import java.util.ArrayList;

public class ProdutoCopaController {
    private ArrayList<ProdutoCopa> produtos = new ArrayList<>();

    public void adicionarProduto(ProdutoCopa produto) {
        produtos.add(produto);
    }

    public ArrayList<ProdutoCopa> listarProdutos() {
        return produtos;
    }
}