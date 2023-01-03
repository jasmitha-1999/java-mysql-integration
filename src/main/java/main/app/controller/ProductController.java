package main.app.controller;

import main.app.entity.Product;
import main.app.model.ProductInformation;
import main.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository product;


    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello World.";
    }

    @GetMapping("/getAllproducts")
    public List<ProductInformation> getAllproducts(){
        List<Product> productsInDB = product.findAll();
        List<ProductInformation> productsWithNameAndPrice = new ArrayList<>();
        for (Product product:productsInDB){
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProductName(product.getProductName());
            productInformation.setPrice(product.getPrice());
            productsWithNameAndPrice.add(productInformation);



        }
        return productsWithNameAndPrice;

    }
}
