package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    /* INYECCIÓN DE DEPENDENCIAS */
    @Autowired
    private final ProductRepository productRepository;

    /* GUARDAR */
    @Override
    public Product save(Product product) {
        /* Se almacena el objeto */
        return this.productRepository.save(product);
    }

    /* BUSCAR TODOS */
    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    /* BUSCAR POR ID */
    @Override
    public Product findById(Long id) {
        /* Sirve para buscar por id */
        return this.productRepository.findById(id).orElseThrow();
    }

    /* ELIMINAR */
    @Override
    public void delete(Long id) {
        /* Se valida si algún id coincide con alguno de los objetos almacenados */
        Product productFind = this.productRepository.findById(id).orElseThrow();
        /* Elimino el objeto que se encontro con el id */
        this.productRepository.delete(productFind);
    }

    /* ACTUALIZAR */
    @Override
    public Product update(Long id, Product objProduct) {
        /* Se valida si algún id coincide con alguno de los objetos almacenados */
        this.productRepository.findById(id).orElseThrow();

        /* Selecciona el objeto al que pertenece el id */
        objProduct.setId(id);

        /* Almacena el objeto modificado */
        return this.productRepository.save(objProduct);
    }

    /* BUSCAR */
    @Override
    public List<Product> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
