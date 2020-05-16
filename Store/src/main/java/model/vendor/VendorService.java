package model.vendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository;
	
	public List<Vendor> getAllVendors(){
		List<Vendor> vendors = new ArrayList<>();
		vendorRepository.findAll().forEach(vendors::add);
//		HashMap<Integer,Double> map = new HashMap<>();
//		map.put(1, 100000.0);
//		map.put(4, 10.0);
//		vendors.add(new Vendor(1,"Pranav",map));
//		map.put(3, 500.0);
//		vendors.add(new Vendor(2,"Astha",map));
		return vendors;
	}
	public void addVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}
	public void removeVendor(int id) {
		vendorRepository.deleteById(id);
	}
	public Optional<Vendor> getVendor(int id)throws IllegalArgumentException {
		return vendorRepository.findById(id);

	}
}
