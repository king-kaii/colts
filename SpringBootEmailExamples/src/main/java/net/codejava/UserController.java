package net.codejava;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
 
@Controller
public class UserController {
 
         
    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<String> listUsers = new ArrayList<>();
        listUsers.add("Hey");
        listUsers.add("Kumar");
        listUsers.add("Welcom");
        listUsers.add("to Lender");
        listUsers.add("Thanks for taking loan");
        
        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);
         
    }
}