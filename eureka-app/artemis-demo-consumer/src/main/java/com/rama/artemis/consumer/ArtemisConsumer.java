package com.rama.artemis.consumer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class ArtemisConsumer {

    
	@Autowired
	private JavaMailSender mailSender;
	
	 @Value("${spring.mail.username}")
	    private String user;
	
    @JmsListener(destination = "${jms.out.queue.destination}")
    public void receive(String msg) throws Exception{
    	String[] arrOfStr = msg.split(":");
    	
        System.out.println("Consumer Got Message: " + msg);
		String from = user;
		String to = arrOfStr[0];
		/*SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Approved Loan Details");
		message.setText(arrOfStr[1]);
		
		mailSender.send(message);*/
		
		
		
		
	
		List<String> listUsers = new ArrayList<>();
        listUsers.add("Hey");
        listUsers.add("Kumar");
        listUsers.add("Welcom");
        listUsers.add("to Lender");
        listUsers.add("Thanks for taking loan");
		listUsers.add(arrOfStr[1]);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		UserPDFExporter exporter = new UserPDFExporter(listUsers);
        //now write the PDF content to the output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        exporter.writePdf(outputStream);
        byte[] bytes = outputStream.toByteArray();
        OutputStream out = new FileOutputStream("out.pdf");
        out.write(bytes);
        out.close();
               //send off the email
        
		helper.setSubject("Here's your e-book");
		helper.setFrom(from);
		helper.setTo(to);
		
		helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);
		
		FileSystemResource file = new FileSystemResource(new File("out.pdf"));
		helper.addAttachment("FreelanceSuccess.pdf", file);

		mailSender.send(message);
		

        
        //producer.send("Consumer send back:"+msg);
    }
    
 	

		


	

}

