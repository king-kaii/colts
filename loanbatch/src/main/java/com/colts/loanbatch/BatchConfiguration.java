package com.colts.loanbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.colts.loanbatch.mongo.PayMongoRepository;
import com.colts.loanbatch.mongo.PaymentsMongo;
import com.colts.loanbatch.mysql.Payments;
import com.colts.loanbatch.mysql.PaymentsRepository;
import com.example.batchprocessing.PaymentsReader;
import com.example.batchprocessing.ValidationProcessor;



@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	PaymentsRepository paymentsRepository;
	@Autowired
	PayMongoRepository payMongoRepository;
	
	
	
	@Bean
	public ItemReader<Payments> reader() {
		 return new PaymentsReader();		 	
	}
	
	  @Bean
	  public ItemProcessor<Payments, PaymentsMongo> processor() {
	    return new ValidationProcessor();
	  }
	
        @Bean
	    public ItemWriter<PaymentsMongo> writer(){
	       // return new InvoiceItemWriter(); // Using lambda expression code instead of a separate implementation
	       return paymentMongoList -> {
	    	   payMongoRepository.saveAll(paymentMongoList);
	       };
	    }

	 @Bean
	    public JobExecutionListener listener() {
	       return new InvoiceListener();
	    }


    @Autowired
    private StepBuilderFactory sbf;

    //Step Object
    @Bean
    public Step stepA() {
       return sbf.get("stepA")
               .<Payments,PaymentsMongo>chunk(2)
               .reader(reader())
               .processor(processor())
               .writer(writer())
               .build() 
       ;
    }
    //Autowire JobBuilderFactory
    @Autowired
    private JobBuilderFactory jbf;

    //Job Object
    @Bean
    public Job jobA(){
       return jbf.get("jobA")
              .incrementer(new RunIdIncrementer())
              .listener(listener())
              .start(stepA())
           // .next(stepB()) 
           // .next(stepC())
              .build()
       ;
    }
	
}
