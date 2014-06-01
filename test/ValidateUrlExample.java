/**
 * <h1> validate an url </h1>
 * Class to validate the string to check if it is a valid URL
 *
 * @author Archer Reilly
 * @version 0.1
 * @since 2014-05-29
 */
import org.apache.commons.validator.UrlValidator;
 
public class ValidateUrlExample{
 
	public static void main(String[] args) {
 
	    UrlValidator urlValidator = new UrlValidator();
 
	    //valid URL
	    if (urlValidator.isValid("http://www.mkyong.com")) {
	       System.out.println("url is valid");
	    } else {
	       System.out.println("url is invalid");
	    }

      
	    //invalid URL
	    if (urlValidator.isValid("http://invalidURL^$&%$&^")) {
	        System.out.println("url is valid");
	    } else {
	        System.out.println("url is invalid");
	    }
	    
	    for ( ; ; ) {
	      System.out.print("Enter a Url String: ");
	      String Url = System.console().readLine();
	      if (urlValidator.isValid(Url)) {
	        System.out.println(Url + " is valid");
	      } else {
	        System.out.println(Url + " is invalid");
	      }
	    }
 
	}
}
