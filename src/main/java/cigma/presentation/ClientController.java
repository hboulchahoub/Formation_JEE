package cigma.presentation;

import cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import cigma.service.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // methods distantes
@RequestMapping("/clients")
public class ClientController {
    // API  ->  LOCAL / SHARED JAR
            // -> PERMET D'APPELER DES METHODS SANS CONNAITRE LEURS CORPS
    // WEB API --> DISTANT
          // UN ENSEMBLE DE WEB SERVICES REST
          // APPELER DES METHODES DISTANTES EN UTILISANT LES WEB SERVICE
    @Autowired
    private IClientService service;

    @PostMapping(value = "/add")
    public Client save(@RequestBody  Client person) {
        return service.save(person);
    }
    @PutMapping("/update")
    public Client update(@RequestBody Client person) {
        return service.update(person);
    }
    @DeleteMapping("/{id}") // /api/clients/1 , DELETE
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
    @GetMapping("/{id}") // /api/clients/1 , GET
    public Client getOne(@PathVariable("id") long id) {
        return service.getOne(id);
    }
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }

}
