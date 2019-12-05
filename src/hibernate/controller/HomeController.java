package hibernate.controller;

import hibernate.entity.shoes;
import hibernate.service.shoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private shoeService ShoeService;

    @RequestMapping(path = "/")
    public String showHomePage(){return "index";}




    @RequestMapping(value = "/showSearchPage", method = RequestMethod.GET)
    public String showSearchPage(Model theModel) {
        List<shoes> list = ShoeService.getShoes();
        theModel.addAttribute("shoes", list);

        return "list-shoes";
    }




    @RequestMapping("/error")
    public String showErrorPage(HttpServletRequest request,
                                Model theModel) {
        int httpErrorCode = (Integer)request.getAttribute("javax.servlet.error.status_code");

        String message;

        switch(httpErrorCode) {
            case 404:
                message = "Error 404: Resource not found";
                break;
            case 500:
                message = "Error 500: Internal server error";
                break;
            case 402:
                message = "Error 402: Payment required";
                break;
            default:
                message = "Unexpected Error!";
        }

        theModel.addAttribute("errorMessage", message);

        return "errors";
    }


}
