package model.product;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/products")
	public void removeProduct(@RequestBody int id) {
		productService.removeProduct(id);
	}
	@RequestMapping("/products/{id}")
	public HashMap<String,Double> getBid(@PathVariable int id) {
		return productService.getBid(id);
	}
	
}
