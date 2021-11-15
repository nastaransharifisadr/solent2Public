/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent.ac.uk.ood.examples.cardcheck;

import org.junit.Test;
import static org.junit.Assert.*;
import solent.ac.uk.ood.examples.cardcheck.CalculateLunnDigit;
import static solent.ac.uk.ood.examples.cardcheck.TestRegexCardValidator.VALID_VISA_1;
import java.util.Arrays;


/**
 *
 * @author cgallen
 */
public class CheckCalculateLunnTest {
    

    @Test
    public void checkCalculateLunn() {
        
        String pan =  "550000555555555"; // correct mastercard 5500005555555559

        String check = CalculateLunnDigit.calculateCheckDigit(pan);
        
        String ccNumber = pan+check;
        
        CardValidationResult result = RegexCardValidator.isValid(ccNumber);
        
        System.out.println("pan:"+pan
                + " ccNumber with check digit:"+ ccNumber);

        assertTrue(result.isValid());
                
    }
    @Test
    public void checkCalculateLuhnnullpan() {
        
        String pan = null; 

           
        CardValidationResult result = RegexCardValidator.isValid(pan);
        
        
        System.out.println(result.getError());

        assertFalse(result.isValid());
        assertEquals(result.getError(),"card cannot be null" );
                
    }
    @Test
    public void checkCalculateLuhnnchecklengh() {
        
        for(int i=0; i<50;i++){  
            if (i>=13 && i<=19) continue;
            char[] chars = new char[i];
            Arrays.fill(chars, '5');
            String pan = new String(chars);
            CardValidationResult result = RegexCardValidator.isValid(pan);     
        
            System.out.println(result.getError());
            assertFalse(result.isValid());
            assertEquals(result.getError(),"failed length check" );
                

        }
    }
    
           
      
    
    
}
