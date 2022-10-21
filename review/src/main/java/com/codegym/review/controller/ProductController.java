package com.codegym.review.controller;

import com.codegym.review.model.Category;
import com.codegym.review.model.Product;
import com.codegym.review.model.dto.CategoryDTO;
import com.codegym.review.model.dto.ProductDTO;
import com.codegym.review.repository.CategoryRepository;
import com.codegym.review.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
@Transactional
public class ProductController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;


    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView homeProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product");
        List<Category> categoryByMethods = categoryRepository.findAllByDescriptionLike("sam");
        List<CategoryDTO> categoryDTOS = categoryRepository.findAllCategoryDTOByDesciption("sam");
        List<ProductDTO> productDTOS = productRepository.findAllProductByDesctiptionCategoryWithJoin("same");

        System.out.println(categoryByMethods);
        System.out.println(categoryDTOS);
        System.out.println(productDTOS);

        Category c = categoryRepository.findById(1L).get();
        Set<Product> products = c.getProducts();


        UserDetails p = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(products);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("USER"))){
            System.out.println("Role user");
        }
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
            System.out.println("Role admin");
        }
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProduct(@Valid ProductDTO productDTO, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product");

        return  modelAndView;
    }
}
