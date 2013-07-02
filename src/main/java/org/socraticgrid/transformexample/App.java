package org.socraticgrid.transformexample;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.socraticgrid.documenttransformer.Transformer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:MDWSDocumentTransformer.xml");
        Transformer tx = (Transformer) ctx.getBean("Xform");
        Resource res = new ClassPathResource("PatientDataRequest_meds_10013.xml");

        try
        {
            InputStream ris = tx.transformAsStream("Medications", res.getInputStream(), null);
            org.apache.commons.io.IOUtils.copy(ris, System.out);
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
}
