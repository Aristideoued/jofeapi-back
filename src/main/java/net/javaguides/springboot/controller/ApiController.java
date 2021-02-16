package net.javaguides.springboot.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import org.xml.sax.InputSource;

import com.google.common.hash.Hashing;
import com.stripe.model.Charge;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.SpringbootPostgresqHibernateExampleApplication;
import net.javaguides.springboot.entity.Api;
import net.javaguides.springboot.entity.Trace;
import net.javaguides.springboot.repository.ApiRepository;
import net.javaguides.springboot.repository.TraceRepository;

@RestController
@RequestMapping("/jofeapi")
public class ApiController {
	
	
	 private StripeClient stripeClient;

	    @Autowired
	    ApiController(StripeClient stripeClient) {
	        this.stripeClient = stripeClient;
	    }

	Date d=new Date();
	String xmlData="";
	String url="";
	 StringBuffer  response =new StringBuffer();
	 String response2="";
	 Map<String ,String> response3 =new HashMap<>();
		String x="";
	
	@Autowired
	private ApiRepository apiRepository;
	
	@Autowired
	private TraceRepository traceRepository;
	
	@GetMapping("/initApi")
	public String initData() {
		apiRepository.save(new Api("OrangeMoney","../assets/images/orangelogo.png"));
		apiRepository.save(new Api("Mobicash","../assets/images/logoMobi.png"));
		//apiRepository.save(new Api("Moneygram","../assets/images/logoMoney.jpg"));
		
		return "Données envoyées ";
		
	}
	

	
	//get apis
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/apis")
	public List<Api> getAllApi(){
		return this.apiRepository.findAll();
	}
	
	
	//get api by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/apis/{id}")
	public ResponseEntity<Api> getApiById(@PathVariable(value="id") Long ApiId)
	      throws ResourceNotFoundException{
		Api api = apiRepository.findById(ApiId)
				.orElseThrow(() -> new ResourceNotFoundException("Api not found for this id"
				+ " :: "+ApiId));
				return ResponseEntity.ok().body(api);
		
		
	}
	
	//save admin
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("apis")
	public Api createApi(@RequestBody Api api) {
		return this.apiRepository.save(api);
	}
	//update admins
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("apis/{id}")
	public ResponseEntity<Api> updateApi(@PathVariable(value = "id") Long apiId,@Validated @RequestBody Api apiDetails)
	throws ResourceNotFoundException{
		Api api = apiRepository.findById(apiId)
				.orElseThrow(() -> new ResourceNotFoundException("Api not found for this id"
				+ " :: "+apiId));
		api.setDesignation(apiDetails.getDesignation());
		api.setLogo(apiDetails.getLogo());
		
		
		return ResponseEntity.ok(this.apiRepository.save(api));
		
	}
	
	
	//delete admin
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("apis/{id}")
	public Map<String, Boolean> deleteApi(@PathVariable(value = "id") Long apiId) throws ResourceNotFoundException{
		
		Api api = apiRepository.findById(apiId)
				.orElseThrow(() -> new ResourceNotFoundException("Api not found for this id"
				+ " :: "+apiId));
		
		this.apiRepository.delete(api);
		
		Map<String ,Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/payment",consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
    public Map<String ,String>   Payment(@RequestBody String body, 
	                       HttpServletRequest request)  {
		
		body="["+body+"]";
		JSONObject object = null;
		JSONArray array = null;
		HttpURLConnection connection = null;
	
		try {
			array = new JSONArray(body);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for(int i=0; i < array.length(); i++)   
		{  
		
		try {
			object = array.getJSONObject(i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		}  
		
		
		try {
			xmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
					           "<COMMAND>\n" + 
				   	                "<TYPE>OMPREQ</TYPE>\n" + 
					                "<customer_msisdn>"+object.getString("phone")+"</customer_msisdn>\n" + 
					                "<merchant_msisdn>77919173</merchant_msisdn>\n" + 
					                "<api_username>JOFEDIGITAL</api_username>\n" + 
					                "<api_password>DIGITAL@9</api_password>\n" + 
					                "<amount>"+ object.getInt("montant")+"</amount>\n" + 
					                "<PROVIDER>101</PROVIDER>\n" + 
					                "<PROVIDER2>101</PROVIDER2>\n" + 
					                "<PAYID>12</PAYID>\n" + 
					                "<PAYID2>12</PAYID2>\n" + 
					                "<otp>"+object.getString("otp")+"</otp>\n" + 
					                "<reference_number>789233</reference_number>\n" + 
					                "<ext_txn_id>201500068544</ext_txn_id>\n" + 
					                "</COMMAND>";
		
			
			
			// Traitement ...
			this.url=object.getString("url");
			

			  try {
			    //Create connection
			    URL url = new URL(this.url);
			    connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("POST");
			    connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

			    connection.setRequestProperty("Content-Length", 
			        Integer.toString(xmlData.getBytes().length));
			    connection.setRequestProperty("Content-Language", "en-US");  

			    connection.setUseCaches(false);
			    connection.setDoOutput(true);

			    //Send request
			    DataOutputStream wr = new DataOutputStream (
			        connection.getOutputStream());
			    wr.writeBytes(xmlData);
			    wr.close();

			    //Get Response  
			    InputStream is = connection.getInputStream();
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			   // or StringBuffer if Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			      response.append(line);
			      response.append('\r');
			    }
			    rd.close();
			    
			   
			   
			  } catch (Exception e) {
			    e.printStackTrace();
			    Map<String ,String> response3 =new HashMap<>();
			    response3.put("Message","echec de connexion");
			   
			    System.out.println(response3);
			    return response3;
			    
			  } finally {
			    if (connection != null) {
			      connection.disconnect();
			    }
			  }
			
		
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
	    
	   try {
		   String rsp="<response>"+this.response.toString()+"</response>";
		   
		   Document doc = DocumentBuilderFactory.newInstance()
	                .newDocumentBuilder()
	                .parse(new InputSource(new StringReader(rsp)));

	      this.x= doc.getElementsByTagName("message")
	     .item(0)
	     .getTextContent();
	     System.out.println(this.x);
		   
	     }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   response3.put("Message",this.x);
	   
	   System.out.println(this.response);
	   
	  /*if(response.toString().contains("succes")) {
		  try {
			  traceRepository.save(new Trace( object.getString("phone"),String.valueOf(object.getInt("montant"))));
		  }
		  catch(Exception e)
		  {System.out.print(e);} 
	  }*/
	   
	 
	  
	  
	      connection.disconnect();
		  connection=null;
		  //request.getSession().invalidate();
		  
		  
		  SpringbootPostgresqHibernateExampleApplication.restart();
		return this.response3;
		
   
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/cardPayment",consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
    public Charge  cardPayment(@RequestBody String body, 
	                       HttpServletRequest request) throws Exception  {
		
		body="["+body+"]";
		JSONObject object = null;
		JSONArray array = null;
	
		try {
			array = new JSONArray(body);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for(int i=0; i < array.length(); i++)   
		{  
		
		try {
			object = array.getJSONObject(i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {System.out.println(object.getString("token"));
		
		System.out.println(object.getDouble("montant"));
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }  
		
		
		
		/*
		 * 'Content-Type', 'text/xml; charset=utf-8'
​
*/
		
		/*try {
			xmlData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
					           "<COMMAND>\n" + 
				   	                "<TYPE>OMPREQ</TYPE>\n" + 
					                "<customer_msisdn>"+object.getString("phone")+"</customer_msisdn>\n" + 
					                "<merchant_msisdn>77949495</merchant_msisdn>\n" + 
					                "<api_username>JOFEDIGITAL</api_username>\n" + 
					                "<api_password>DIGITAL@9</api_password>\n" + 
					                "<amount>"+ object.getInt("montant")+"</amount>\n" + 
					                "<PROVIDER>101</PROVIDER>\n" + 
					                "<PROVIDER2>101</PROVIDER2>\n" + 
					                "<PAYID>12</PAYID>\n" + 
					                "<PAYID2>12</PAYID2>\n" + 
					                "<otp>"+object.getString("otp")+"</otp>\n" + 
					                "<reference_number>789233</reference_number>\n" + 
					                "<ext_txn_id>201500068544</ext_txn_id>\n" + 
					                "</COMMAND>";
		
			
			
			// Traitement ...
			this.url=object.getString("url");
			HttpURLConnection connection = null;

			  try {
			    //Create connection
			    URL url = new URL(this.url);
			    connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("POST");
			    connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

			    connection.setRequestProperty("Content-Length", 
			        Integer.toString(xmlData.getBytes().length));
			    connection.setRequestProperty("Content-Language", "en-US");  

			    connection.setUseCaches(false);
			    connection.setDoOutput(true);

			    //Send request
			    DataOutputStream wr = new DataOutputStream (
			        connection.getOutputStream());
			    wr.writeBytes(xmlData);
			    wr.close();

			    //Get Response  
			    InputStream is = connection.getInputStream();
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			    StringBuffer  response = new StringBuffer(); // or StringBuffer if Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			      response.append(line);
			      response.append('\r');
			    }
			    rd.close();
			   System.out.println(response);
			  } catch (Exception e) {
			    e.printStackTrace();
			    return null;
			  } finally {
			    if (connection != null) {
			      connection.disconnect();
			    }
			  }
			
		
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		       
	  

		/*Map<String ,Boolean> response =new HashMap<>();
		response.put("ok", Boolean.TRUE);
		
		return response;*/
		String token = object.getString("token");
        Double amount = object.getDouble("montant");
        return this.stripeClient.chargeCreditCard(token, amount);
		}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/paymentMoov",consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
    public Map<String ,String>   PaymentMoov(@RequestBody String body, 
	                       HttpServletRequest request)  {
		
		Map<String ,String> response3 =new HashMap<>();
		String name = "JofeDigital";
		String password = "jofedigit@lp@ss";
		String urlMoov="https://196.28.245.227/tlcfzc_gw/api/gateway/3pp/transaction/process";
        
		String authString = name + ":" + password;
		System.out.println("auth string: " + authString);
		String authEncBytes = Base64.getEncoder().encodeToString(authString.getBytes());;
		
		final String hashed = Hashing.sha256()
		        .hashString(body, StandardCharsets.UTF_8)
		        .toString();
		
		String body1="["+body+"]";
		JSONObject object = null;
		JSONArray array = null;
	
		try {
			array = new JSONArray(body1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for(int i=0; i < array.length(); i++)   
		{  
		
		try {
			object = array.getJSONObject(i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			System.out.println(object.getString("phone"));
		
			System.out.println(object.getInt("montant"));
			System.out.println(object.getString("message"));
			System.out.println(object.getString("remarks"));
			System.out.println(object.getString("request_id"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }  
		
		
		
		
		/* 'Content-Type', 'text/xml charset=utf-8'*/


		
		
			
			
			
			// Traitement ...
			
			HttpURLConnection connection = null;

			  try {
			    //Creation de la connection
			    URL url = new URL(urlMoov);
			    connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("POST");
			    connection.setRequestProperty("Content-Type", "application/json");
			     connection.setRequestProperty("hash", hashed);
                connection.setRequestProperty("Authorization", "Basic " + authEncBytes);
			    connection.setRequestProperty("Content-Length", 
			        Integer.toString(body.getBytes().length));
			   connection.setRequestProperty("command-id","mror-transaction-ussd");
			   //System.setProperty("http.proxyPort", "8080");
			   
			    connection.setRequestProperty("Content-Language", "en-US");  

			    connection.setUseCaches(false);
			    connection.setDoOutput(true);

			    //Envoie de la requète
			    DataOutputStream wr = new DataOutputStream (
			        connection.getOutputStream());
			    wr.writeBytes(body);
			    wr.close();

			    //Reception de la reponse  
			    InputStream is = connection.getInputStream();
			    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			   // Ou bien StringBuffer si Java version 5+
			    String line;
			    while ((line = rd.readLine()) != null) {
			      response.append(line);
			      response.append('\r');
			    }
			    rd.close();
			    
			  
			   
			  } catch (Exception e) {
			    e.printStackTrace();
			   
			    response3.put("Message","echec de connexion");
			   
			   // System.out.println(response3);
			    return response3;
			    
			  } finally {
			    if (connection != null) {
			      connection.disconnect();
			    }
			  }
			
		
			
		
		 System.out.println(response);    
	  

		
		//Map<String ,String> response3 =new HashMap<>();
	
		return response3;
   
	}
	
	
	
}