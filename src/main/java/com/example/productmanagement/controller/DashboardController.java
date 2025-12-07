package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final ProductService productService;

    @Autowired
    public DashboardController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showDashboard(Model model) {

        long totalProducts = productService.getTotalProductCount();
        BigDecimal totalValue = productService.getTotalInventoryValue();
        BigDecimal averagePrice = productService.getAverageProductPrice();
        List<Product> lowStockProducts = productService.getLowStockProducts(10);
        List<Product> recentProducts = productService.getRecentProducts(5);

        List<String> categories = productService.getAllCategories();
        Map<String, Long> productsByCategory = categories.stream()
                .collect(Collectors.toMap(
                        c -> c,
                        c -> productService.countProductsByCategory(c)
                ));

        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalValue", totalValue);
        model.addAttribute("averagePrice", averagePrice);
        model.addAttribute("lowStockProducts", lowStockProducts);
        model.addAttribute("recentProducts", recentProducts);
        model.addAttribute("productsByCategory", productsByCategory);

        return "dashboard"; // dashboard.html
    }
}
