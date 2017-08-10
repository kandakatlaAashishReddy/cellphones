package aashish.service;

import java.util.List;

import aashish.model.Supplier;

public interface SupplierServiceInt {
	void addSupplier(Supplier sup);
	void deleteSupplier(String sp);
	void updateSupplier(Supplier sup);
	List<Supplier> getSupplier();
	Supplier getSupplierByID(String sp);


}
