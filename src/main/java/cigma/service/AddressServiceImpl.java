package cigma.service;

import cigma.dao.IAddressDao;
import cigma.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private IAddressDao dao;

    @Override
    @Transactional
    public void save(Address address) {
        dao.save(address);
    }
}
