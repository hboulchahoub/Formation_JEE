package cigma.presentation;

import cigma.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cigma.service.AddressService;

@Controller
public class AddressController {
    @Autowired
    private AddressService service;
    public void save(Address address){
        service.save(address);
    }
}
