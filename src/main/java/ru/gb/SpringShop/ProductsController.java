package ru.gb.SpringShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private ProductDao productDao;
    private CustomerDao customerDao;
    private CustomerProductService customerProductService;

    @Autowired
    public ProductsController(ProductDao productDao, CustomerDao customerDao, CustomerProductService customerProductService){
        this.productDao = productDao;
        this.customerDao = customerDao;
        this.customerProductService = customerProductService;
    }

    @GetMapping(value = "/catalog")
    public String showPageWithProducts (Model model){
        model.addAttribute("products", productDao.findAll());
        return "products";
    }

    @GetMapping(value = "/create")
    public String showCreateProductForm (){
        return "create_product";
    }

    @PostMapping(value = "/create")
    public String saveCreatedProduct ( @RequestParam String title, @RequestParam int cost){
        productDao.save(new Product( title, cost));
        return "redirect:/catalog";
    }

    @GetMapping(value = "/costPlus")
    public String costPlus (@RequestParam int id){
        productDao.costPlus(id);
        return "redirect:/catalog";
    }
    @GetMapping(value = "/costMinus")
    public String costMinus (@RequestParam int id){
        productDao.costMinus(id);
        return "redirect:/catalog";
    }

}
