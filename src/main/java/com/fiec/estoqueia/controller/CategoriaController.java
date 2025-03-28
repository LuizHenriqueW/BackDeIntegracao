package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Categorias;
import com.fiec.estoqueia.business.entities.Produtos;
import com.fiec.estoqueia.services.CategoriaService;
import com.fiec.estoqueia.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    ResponseEntity<Categorias> createCategoria(@RequestBody CreateCategoriaDto createCategoriaDto){
        Categorias categoria = categoriaService.createCategoria(createCategoriaDto);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> listaCategorias(){
        List<Categorias> categorias = categoriaService.listaCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}