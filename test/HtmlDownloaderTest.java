/**
 * <h1> Testing the HtmlDownloader Class </h1>
 *
 * @author Archer Reilly
 * @version 0.1
 * @since 2014-05-31
 */

import java.security.InvalidParameterException;

import org.csrgxtu.net.HtmlDownloader;

public class HtmlDownloaderTest {

  public static void main(String[] args) {
    for ( ; ; ) {
      System.out.print("Input An Url To Test: ");
      String url = System.console().readLine();
      
      try {
        HtmlDownloader htmlObj = new HtmlDownloader(url);
        
        if (htmlObj.doRequest()) {
          System.out.println("Response Code: " + htmlObj.getResponseCode());
        } else {
          System.out.println("Failed To Do The Request");
        }
      } catch(InvalidParameterException e) {
        System.out.println("Invalid Url");
      }
    }
  }
}
