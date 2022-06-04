package ru.gb.SpringShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/catalog")
    public String showPageWithProducts (Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping(value = "/create")
    public String showCreateProductForm (){
        return "create_product";
    }

    @PostMapping(value = "/create")
    public String saveCreatedProduct (@RequestParam int id, @RequestParam String title, @RequestParam int cost){
        productRepository.save(new Product(id, title, cost));
        return "redirect:/catalog";
    }

    @GetMapping(value = "/costPlus")
    public String costPlus (@RequestParam int id){
        productRepository.findById(id).costPlus();
        return "redirect:/catalog";
    }
    @GetMapping(value = "/costMinus")
    public String costMinus (@RequestParam int id){
        productRepository.findById(id).costMinus();
        return "redirect:/catalog";
    }

}
