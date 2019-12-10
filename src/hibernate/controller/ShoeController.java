package hibernate.controller;

import hibernate.entity.shoes;
import hibernate.service.shoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/shoes")
public class ShoeController {
    @Autowired
    private shoeService shoeService;

    @RequestMapping("/list")
    public String listShoes(Model theModel) {
        List<shoes> theList = shoeService.getShoes();

        theModel.addAttribute("shoes", theList);

        return "list-shoes";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String searchTerm,
                         Model theModel) {

        List<shoes> theList = shoeService.getShoeByName(searchTerm);

        theModel.addAttribute("shoes", theList);

        return "list-shoes";
    }

    @GetMapping("/delete")
    public String deleteShoe(@RequestParam("shoeId") int id){
        shoeService.deleteShoe(id);

        return "redirect:/shoes/list";
    }

    @RequestMapping("/showUpdateShoeForm")
    public String showUpdateShoeForm(@RequestParam("shoeId") int id,
                                      Model theModel) {
        shoes existingShoe = shoeService.getShoe(id);

        theModel.addAttribute("aShoe", existingShoe);


        return "add-shoe-form";
    }

    @GetMapping("/showAddShoeForm")
    public String showAddShoeForm(Model theModel) {
        shoes shoe = new shoes();

        theModel.addAttribute("aShoe", shoe);

        return "add-shoe-form";
    }
    @PostMapping("/addShoes")
    public String addShoe(Model theModel, @ModelAttribute(name = "aShoe")shoes theShoe){
        shoeService.saveShoes(theShoe);
        return "list-shoes";
    }

    @PostMapping("/save")
    public String saveShoe(@RequestParam(name = "shoeImage") MultipartFile file,
                            @Valid @ModelAttribute(name = "aShoe") shoes theShoe,
                            BindingResult bindingResult,
                            Model theModel,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            return "add-shoe-form";
        }

        //shoeService.saveShoes(theShoe);

        return "redirect:/shoes/list";
    }



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
