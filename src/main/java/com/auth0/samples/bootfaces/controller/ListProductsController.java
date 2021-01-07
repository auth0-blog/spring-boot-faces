package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope (value = "session")
@Component (value = "listProducts")
@ELBeanName(value = "listProducts")
@Join(path = "/", to = "/product/product-list.jsf")
public class ListProductsController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductController productController;
	private List<Product> products;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String create() {
		return setupAndRedirectToCrudView(new Product(), false);
	}
	public String view(Product product) {
		return setupAndRedirectToCrudView(product, true);
	}
	public String edit(Product product) {
		return setupAndRedirectToCrudView(product, false);
	}
	public void delete(Product product) {
		productRepository.delete(product.getId());
		loadData();
	}
	private String setupAndRedirectToCrudView(Product product, boolean readOnly) {
		productController.setReadOnly(readOnly);
		productController.setProduct(product);
		return "/product/product-form.xhtml?faces-redirect=true";
	}
}