package model.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import model.vendor.*;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public void removeProduct(int id) {
		productRepository.deleteById(id);
	}
	
	@Autowired
	private VendorService vendorService;
	
	public HashMap<String,Double> getBid(int id) {
		if(productRepository.existsById(id)==false) {
			return null;
		}
		List<Vendor> vendors = new ArrayList<>();
		vendors = vendorService.getAllVendors();
		HashMap<String,Double> bids = new HashMap<>();
		RestTemplate restTemplate =new RestTemplate();
//		for all vendors:
//			bid=getbid
//			bids.put(vid+" "+vname, bid);
		for(Vendor vendor: vendors) {
			if(vendor.getProducts().containsKey(id)) {
				bids.put(vendor.getId()+" "+vendor.getName() , vendor.getProducts().get(id));
			}
		}
		return bids;
		
	}
}
