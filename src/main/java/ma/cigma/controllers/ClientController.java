package ma.cigma.controllers;

import ma.cigma.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {

    // CETTE CLASSE DOIT APPELER LE BACK-END
    // URL

    @Value("${api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping (value={"/","/clients"})
   public String getAll(Model model,@ModelAttribute("o") Client client){
       List<Client> clients = restTemplate.getForObject(apiUrl+"/clients/all", List.class);
       // On doit passer la liste des clients à la page index-client.html
       model.addAttribute("list1",clients);
       model.addAttribute("o",client==null?new Client():client);
       return "index-client";
   }

   @PostMapping("/add-client")
   public String add(Model model, @ModelAttribute("o") Client o){
       Client c= restTemplate.postForObject(apiUrl+"/clients/add",o,Client.class);
       return "redirect:/clients";
   }

   @GetMapping("/delete-client/{id}")
    public String delete(@PathVariable  long id){
        restTemplate.delete(apiUrl+"/clients/"+id);
        return "redirect:/clients";
   }
   @GetMapping("/show-client/{id}")
    public String getOne(@PathVariable long id, RedirectAttributes ra){
       Client client= restTemplate.getForObject(apiUrl+"/clients/"+id,Client.class);
       // Afficher dans front : dans la page HTML
       // client --> index-client.html
       ra.addFlashAttribute("o",client);
       return "redirect:/clients";
   }



}
