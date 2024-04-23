package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Product;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    /* INYECCIÓN DE DEPENDENCIAS CRUD DE IPRODUCTOS
     * Se crea un objeto para poder llamar todos los métodos definidos en IPRODUCTOS 
     * Principio solid me dice que toda la inyección de dependencias se debe hacer sobre interfaces */
    @Autowired
    private final IProductService productService;

    /* LISTAR TODOS */
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    /* BUSCAR POR ID */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    /* GUARDAR */
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product objProduct) {
        return ResponseEntity.ok(this.productService.save(objProduct));
    }

    /* ACTUALIZAR */
    @PutMapping(path = "/{id}")
        /* PathVariable porque el id viene por el url */
        /* RequestBody porque los datos vienen por el cuerpo de la petición*/
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(this.productService.update(id, product));
    }

    /* ELIMINAR */
    @DeleteMapping(path = "/{id}")
    /* Void de "JAVA.LANG" */
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.productService.delete(id);
        /* Ponemos el "noContent" y el "build" para construir una respuesta de tipo "void" */
        return ResponseEntity.noContent().build();
    }
}
