package com.ingedwin.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.ingedwin.springboot.di.app.springboot_di.models.Product;
import com.ingedwin.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    /* 
     * Las clases de tipo service nos ayuda a poder modifical los datos una vez son pedidos desde el repositorio, de esta manera en esta parte
     * podemos modificar los datos con la lógica de negocios que queramos hacer, mientras que el servicio solo hace la lavor de pedir los datos
     * con los que vamos a trabajar
     */

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {

            // El precio lo modificamos para sumarle un 10%, pero al ser Long, debemos de hacer la operacion con Double y despues
            // castear el valor para retornar un dato de tipo STREAM

            Double price = p.getPrice()*1.10d;
            p.setPrice(price.longValue());
            
            return p;

            // El estar retornando un tipo STREAM ahora nosotros debemos de transormar ese Stream a una de tipo List, el cual se hacer con
            // el collectors de Java
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.finByiD(id);
    }

}
