package com.fiec.estoqueia.controller;

import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Categorias;
import com.fiec.estoqueia.business.entities.Fornecedores;
import com.fiec.estoqueia.services.CategoriaService;
import com.fiec.estoqueia.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    ResponseEntity<Fornecedores> createFornecedor(@RequestBody CreateFornecedorDto createFornecedorDto){
        Fornecedores fornecedor = fornecedorService.createFornecedores(createFornecedorDto);
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedores>> listaFornecedores(){
        List<Fornecedores> fornecedores = fornecedorService.listaFornecedores();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }
}