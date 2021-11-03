package com.mercado.springboot.controller;

import com.mercado.springboot.model.entities.Produto;
import com.mercado.springboot.service.ProdutoService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produto")
@Slf4j
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        log.info("Produto = " + produto);
        return new ResponseEntity<>(produtoService.cadastrarProduto(produto), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){
       try {
            return new ResponseEntity<>(produtoService.buscarProduto(id), HttpStatus.OK);
        }catch(NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
