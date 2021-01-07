package com.auth0.samples.bootfaces.controller;

import com.auth0.samples.bootfaces.model.Product;
import com.auth0.samples.bootfaces.persistence.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/product", to = "/product/product-form.jsf")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	private Product product = new Product();
	private boolean readOnly = false;

	public String save() {
		productRepository.save(product);
		return redirectBackToListView();
	}

	public String cancel() {
		return redirectBackToListView();
	}

	private String redirectBackToListView() {
		return "/product/product-list.xhtml?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}	
}