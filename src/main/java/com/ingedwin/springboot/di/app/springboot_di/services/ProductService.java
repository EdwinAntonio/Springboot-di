package com.ingedwin.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductRepositoryInterface;
import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductServiceInterface;
import com.ingedwin.springboot.di.app.springboot_di.models.Product;

@Service
@RequestScope
public class ProductService implements ProductServiceInterface{

    /*
     * El @Autowired funciona cada vez que nosotros marcamos con la notación @Component para decirle que esa
     * clase marcada como componente será inyectada en alguna otra clase para hacer uso de sus metodos e
     * incluso variables, por tal motivo usar Autowired es lo mismo a instanciar una clase, ejemplo 
     * 
     * private ProductRepository repository = new ProductRepository();
     * 
     * Eso es igual a 
     * 
     * @Autorwired
     * private ProductRepository repository;
     */


    @Autowired
    private ProductRepositoryInterface repository;

    @Value("${valor.config}")
    private Double iva;

    /* 
     * Las clases de tipo service nos ayuda a poder modifical los datos una vez son pedidos desde el repositorio, de esta manera en esta parte
     * podemos modificar los datos con la lógica de negocios que queramos hacer, mientras que el servicio solo hace la lavor de pedir los datos
     * con los que vamos a trabajar
     */

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {

            // El precio lo modificamos para sumarle un 10%, pero al ser Long, debemos de hacer la operacion con Double y despues
            // castear el valor para retornar un dato de tipo STREAM
            
            Double price = p.getPrice()* iva;
            p.setPrice(price.longValue());
            
            return p;

            // El estar retornando un tipo STREAM ahora nosotros debemos de transormar ese Stream a una de tipo List, el cual se hacer con
            // el collectors de Java
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        try {
            return repository.findById(id);
        } catch (Exception e) {
            return new Product(0L, "No existe el producto", 0L);
        }
    }

}
