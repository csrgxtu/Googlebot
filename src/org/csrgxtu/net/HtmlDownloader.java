/**
 * <h1> Download An Html Page </h1>
 * The class is used to download an html page according the URL you
 * give.
 *
 * @author Archer Reilly
 * @version 0.1
 * @since 2014-05-29
 */
package org.csrgxtu.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.*;
import org.apache.http.Header;
import org.apache.http.params.*;

import org.apache.commons.validator.UrlValidator;

public class HtmlDownloader {
  /**
   * url hold the target resource you want to retrive
   */
  private String url = null;

  /**
   * response contains the response data
   */
  private HttpResponse response = null;

  /**
   * responseCode contains the return code of the http request
   */
  private int responseCode = 403;

  /**
   * httpClient is the client instance var
   */
  private HttpClient httpClient = null;

  /**
   * httpParams is the HttpParams used to set options for the
   * connection
   */
  private HttpParams httpParams = null;

  /**
   * methodGet is the method instance var
   */
  private HttpGet methodGet = null;

  /**
   * content is the html source code
   */
  private String content = "";


  /**
   * constructor, initialize url, http client, http method
   * instance.
   *
   * @param url string
   * @exception InvalidParameterException
   */
  public HtmlDownloader(String url) throws InvalidParameterException {
    if ( !this.validator(url)) {
      throw new InvalidParameterException("Invalid Parameter url");
    }
    
    // init
    this.url = url;
    this.httpClient = new DefaultHttpClient();
    this.httpParams = this.httpClient.getParams();
    // 20 seconds to connect
    HttpConnectionParams.setConnectionTimeout(this.httpParams, 20000);
    HttpConnectionParams.setSoTimeout(this.httpParams, 20000);

    try {
      this.methodGet = new HttpGet(this.url);
    } catch (IllegalArgumentException e) {
      throw new InvalidParameterException("Invalid Parameter url");
    }
  }

  /**
   * <h3> validate URL </h3>
   * validate an string to see if it is a valid url string
   *
   * @param url the string of the url you want to varify
   * @return boolean
   */
  private boolean validator(String url) {
    if (url == null || url == "") {
      return false;
    }
    
    // use url validator from apache validate the url
    UrlValidator urlValidator = new UrlValidator();
    
    if (urlValidator.isValid(url)) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * doRequest is used to send the request
   *
   * @return boolean
   */
  public boolean doRequest() {
    try {
      // in constructor, HttpGet will fail if the url passed to
      // it is too strange
      if (this.methodGet == null) {
        return false;
      }
      
      this.response = this.httpClient.execute(this.methodGet);
  
      if (this.response.getStatusLine().getStatusCode() != 200) {
        return false;
      }

      this.responseCode = this.response.getStatusLine().getStatusCode();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(
        this.response.getEntity().getContent()));

      String output;
      //System.out.println("Output from server ...\n");
      while ((output = br.readLine()) != null) {
        //System.out.println(output);
        output += "\n";
        this.content += output;
      }
    } catch (ClientProtocolException e) {
      return false;
    } catch (IOException e) {
      return false;
    } finally {
      this.httpClient.getConnectionManager().shutdown();
    }

    // request ok
    return true;
  }

  /**
   * setters for member variable url
   *
   * @param url string representation of the url
   * @exception InvalidParameterException
   */
  private void setUrl(String url) throws InvalidParameterException {
    if ( !this.validator(url)) {
      throw new InvalidParameterException("Invalid Parameter url");
    }
    this.url = url;
  }

  /**
   * get the member url
   *
   * @return url string
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * get the response object
   *
   * @return response HttpResponse
   */
  private HttpResponse getResponse() {
    return this.response;
  }

  /**
   * get the response code
   *
   * @return code int
   */
  public int getResponseCode() {
    return this.responseCode;
  }

  /**
   * get the content of the request
   *
   * @return content string
   */
  public String getContent() {
    return this.content;
  }

  /**
   * getRequestHead is used to get the head data of the request
   *
   * @return String
   */
  public String getRequestHead() {
    Header[] headers = this.response.getAllHeaders();
    String res = "";
    
    for (Header header : headers) {
      res += header.toString();
      res += "\n";
    }
    
    // Add url
    res += "Url: " + this.url + "\n\n";
    
    return res;
  }

}
