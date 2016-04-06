package com.codesanook.springbootthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.PrintWriter;
import java.io.StringWriter;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {

        try {
            Exception ex = new Exception("my custom exception message");
            throw ex;
        } catch (Exception ex) {
            model.addAttribute("exception", ex);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String stackTrace = sw.toString();
            model.addAttribute("stackTrace", stackTrace);
        }

        return "index";
    }
}
