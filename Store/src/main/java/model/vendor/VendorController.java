package model.vendor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping("/vendors")
	public List<Vendor> getAllVendors(){
		return vendorService.getAllVendors();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vendors")
	public void addVendor(@RequestBody Vendor vendor) {
		vendorService.addVendor(vendor);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/vendors")
	public void removeVendor(@RequestBody int id) {
		vendorService.removeVendor(id);
	}
	@RequestMapping("/vendors/{id}")
	public Optional<Vendor> getVendor(@PathVariable int id) {
		return vendorService.getVendor(id);
	}
	
}
