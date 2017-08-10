package aashish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aashish.dao.SupplierDAOInt;
import aashish.model.Supplier;
@Service
public class SupplierServiceImpl implements SupplierServiceInt {
	@Autowired
	private SupplierDAOInt supplierDao;
	

	public void addSupplier(Supplier sup) {
		supplierDao.addSupplier(sup);
	}

	public void deleteSupplier(String sp) {
		supplierDao.deleteSupplier(sp);

	}

	public void updateSupplier(Supplier sup) {
		supplierDao.updateSupplier(sup);

	}

	public List<Supplier> getSupplier() {
		return supplierDao.getSupplier();
	}

	public Supplier getSupplierByID(String sp) {
		return supplierDao.getSupplierByID(sp);
	}

}
