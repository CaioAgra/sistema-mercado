package com.mercado.springboot.service;

import com.mercado.springboot.model.entities.Produto;
import com.mercado.springboot.repository.ProdutoRepository;
import javassist.NotFoundException;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto){

        return produtoRepository.save(produto);
    }

    public Produto buscarProduto(Long id) throws NotFoundException {
        Optional <Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            return produtoOptional.get();
        }else{
            throw new NotFoundException("Produto não encontrado");
        }
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
