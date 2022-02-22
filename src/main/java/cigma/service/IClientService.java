package cigma.service;

import cigma.models.Client;

import java.util.List;

public interface IClientService {
    Client save(Client p);
    Client update(Client p);
    void delete(long id);
    Client getOne(long id);
    List<Client> getAll();




}
