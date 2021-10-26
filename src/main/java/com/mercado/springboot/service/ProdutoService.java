package com.mercado.springboot.service;

import com.mercado.springboot.model.entities.Produto;
import com.mercado.springboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto){

        return produtoRepository.save(produto);
    }
}
