package com.riwi.products.services.service_abstract;

import java.util.List;

import com.riwi.products.entities.Product;

/**
 * IProductService
 */
public interface IProductService {

    public Product save(Product product);

    public List<Product> getAll();

    public Product findById(Long id);

    /* ELIMINAR no me retorne nada */
    public void delete(Long id);

    /* ACTUALIZAR me retorna un objeto de tipo PRODUCT */
    public Product update(Long id, Product product);

    /* BUSCAR me retorna una listade productos */
    public List<Product> search(String name);

}