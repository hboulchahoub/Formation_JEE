package cigma.service;

import cigma.dao.IClientDao;
import cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientDao dao;

    @Override
    @Transactional
    public Client save(Client c) {
        return dao.save(c);
    }

    @Override
    @Transactional

    public Client update(Client p) {
        Client old = dao.findById(p.getId()).get();
        old.setName(p.getName());
        return dao.save(old);
    }

    @Override
    @Transactional

    public void delete(long id) {
        dao.deleteById(id);
    }

    @Override
    public Client getOne(long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Client> getAll() {
        return dao.findAll();
    }
}
