package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import source.model.Product;
import source.service.ProductService;

import java.util.ArrayList;

@Controller
@SessionAttributes("productCart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productsList")
    public ModelAndView listProduct() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView saveProduct(Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/add-product/{id}")
    public ModelAndView addProduct(@PathVariable Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/add-product")
    public String updateProduct(@ModelAttribute("product") Product product, @ModelAttribute("productCart") ArrayList<Product> productArrayList ){
        Product productInput = productService.findById(product.getId());
        productArrayList.add(productInput);
        return "redirect:productsList";
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product, @ModelAttribute("productCart") ArrayList<Product> productArrayList ){
        Product productInput = productService.findById(product.getId());
        productArrayList.remove(productInput);
        return "redirect:productsList";
    }

    @GetMapping("/clear-product")
    public String clearProduct(@ModelAttribute("productCart") ArrayList<Product> productArrayList){
        productArrayList.clear();
        return "redirect:productsList";
    }
}
