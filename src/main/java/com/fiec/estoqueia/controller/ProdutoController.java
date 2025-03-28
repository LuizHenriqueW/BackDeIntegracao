package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Categorias;
import com.fiec.estoqueia.business.entities.Produtos;
import com.fiec.estoqueia.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    ResponseEntity<Produtos> createProduto(@RequestBody CreateProdutoDto createProdutoDto){
        Produtos produto = produtoService.criaProduto(createProdutoDto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listaProdutos(){
        List<Produtos> produtos = produtoService.listaProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}