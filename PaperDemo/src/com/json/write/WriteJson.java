/*package com.json.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.json.java.Friends;
import com.json.java.Groups;
import com.json.java.Pages;
import com.json.java.Surveys;
import com.json.java.UserProfile;
import com.json.read.ReadJson;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class WriteJson {
	
	@SuppressWarnings("unchecked")
	public void getLocationGraph(String location) throws FileNotFoundException, IOException, ParseException{
		UserProfile userProfile = new UserProfile();
		ReadJson read = new ReadJson();
		userProfile = read.getUserProfilfe();
		Friends friends = new Friends();
		friends = ReadJson.getFriends();
		System.out.println("Size of friends ==" + friends.getFriends().size());
		JSONArray countryObj = new JSONArray();  
		JSONObject obj = new JSONObject();
		for (int i = 0; i<friends.getFriends().size(); i++){
			if((friends.getFriends().get(i).getLocation()).equals(location)){
				obj = new JSONObject();
				obj.put("source", userProfile.getName());
				obj.put("target", friends.getFriends().get(i).getName());
				countryObj.add(obj);
			}
			
			
		}
		 try {  
             
	            // Writing to a file  
	            File file=new File("C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/"+location+".json");  
	            file.createNewFile();  
	            FileWriter fileWriter = new FileWriter(file);  
	            System.out.println("Writing JSON object to file");  
	            System.out.println("-----------------------");  
	            System.out.print(countryObj);  
	  
	            fileWriter.write(countryObj.toJSONString());  
	            fileWriter.flush();  
	            fileWriter.close();  
	  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  

	
		
	}
	
	@SuppressWarnings("unchecked")
	public void getHealthGroupGraph() throws FileNotFoundException, IOException, ParseException{
		List<Groups> grp = new ArrayList<Groups>();
		ReadJson read = new ReadJson();
		grp = read.getHealthGroups();
		JSONArray countryObj = new JSONArray();  
		JSONObject obj = new JSONObject();
		String source = grp.get(0).getName();
		for (int i = 1; i<grp.size(); i++){
				obj = new JSONObject();
				obj.put("source", source);
				obj.put("target", grp.get(i).getName());
				countryObj.add(obj);
			}
			
	
	 try {  
             
	            // Writing to a file  
	            File file=new File("C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/Groups.json");  
	            file.createNewFile();  
	            FileWriter fileWriter = new FileWriter(file);  
	            System.out.println("Writing JSON object to file");  
	            System.out.println("-----------------------");  
	            System.out.print(countryObj);  
	  
	            fileWriter.write(countryObj.toJSONString());  
	            fileWriter.flush();  
	            fileWriter.close();  
	  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void getHealthPageGraph() throws FileNotFoundException, IOException, ParseException{
		List<Pages> grp = new ArrayList<Pages>();
		ReadJson read = new ReadJson();
		grp = read.getHealthPages();
		JSONArray countryObj = new JSONArray();  
		JSONObject obj = new JSONObject();
		String source = grp.get(0).getName();
		for (int i = 1; i<grp.size(); i++){
				obj = new JSONObject();
				obj.put("source", source);
				obj.put("target", grp.get(i).getName());
				countryObj.add(obj);
			}
			
	
	 try {  
             
	            // Writing to a file  
	            File file=new File("C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/Pages.json");  
	            file.createNewFile();  
	            FileWriter fileWriter = new FileWriter(file);  
	            System.out.println("Writing JSON object to file");  
	            System.out.println("-----------------------");  
	            System.out.print(countryObj);  
	  
	            fileWriter.write(countryObj.toJSONString());  
	            fileWriter.flush();  
	            fileWriter.close();  
	  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	@SuppressWarnings("unchecked")
	public void noOfUsers(String location) throws FileNotFoundException, IOException, ParseException{
		int noOfUsersVisitingHG = 0;
		int noOfUsersVisitingHP = 0;
		int noOfUsersSmoke = 0;
		int noOfUsersDrinks = 0;
		int noOfUsersLikesPages = 0;
		int noOfUserQuitSmokingSurveys = 0;
		int noOfUsersDocFriends = 0;
		Integer pecentUserContriInHgHb = 0;
		Integer percentUserSmokeDrink = 0 ;
		Integer percentUserDocCont = 0;
		Integer percentUserQuitSur = 0;
		List<Groups> grpList = new ArrayList<Groups>();
		ReadJson read = new ReadJson();
		grpList = read.getHealthGroups();
		for(Groups grp : grpList){
			if(grp.getLocation().equals(location)){
				noOfUsersVisitingHG = noOfUsersVisitingHG + Integer.parseInt(grp.getMembers());
			}
		}
		noOfUsersVisitingHG = noOfUsersVisitingHG/10;
		List<Pages> pageList = new ArrayList<Pages>();
		
		UserProfile userProfile = new UserProfile();
		userProfile = read.getUserProfilfe();
		Friends friends = new Friends();
		friends = ReadJson.getFriends();
		List<UserProfile> usrPL = new ArrayList<UserProfile>();
		usrPL = friends.getFriends();
		List<Surveys> surL = new ArrayList<Surveys>();
		boolean flag = false;
		for(UserProfile usr : usrPL){
		   List<Pages> pages = new ArrayList<Pages>();
		   pages = usr.getPage();
		   surL = usr.getSurveys();
		   if(usr.getLocation().equals(location)){
			   if(usr.gedDinking().equals("yes")){
				   noOfUsersDrinks = noOfUsersDrinks + 1;
			   }
			   if(usr.getSmoking().equals("yes")){
				   noOfUsersSmoke = noOfUsersSmoke + 1;
			   }
			   for(Pages page : pages){
				   if(page.getCategory().equals("Health")){
					   flag = true;
					   break;
				   }			  
			   }
			   if(flag== true){
			    noOfUsersVisitingHP = noOfUsersVisitingHP +1;
			    flag = false;
			   }
			   for(Surveys sur : surL){
				   if(sur.getCategory().equals("Quit Smoking")){
					 flag = true;
					 break;
				   }
			   }
			   if(flag== true){
				   noOfUserQuitSmokingSurveys = noOfUserQuitSmokingSurveys +1;
				    flag = false;
				 }
			  
			   if(Integer.parseInt(usr.getNoOfDocContacts()) >= 5){
				   noOfUsersDocFriends = noOfUsersDocFriends +1;
			   }		 
		   }
		   
		}
		System.out.println("No of users drinks ==" + noOfUsersDrinks);
		System.out.println("No of users smoke ==" + noOfUsersSmoke);
		System.out.println("No of users visiting health pages ==" + noOfUsersVisitingHP);
		System.out.println("No of users visiting health Groups ==" + noOfUsersVisitingHG);
		System.out.println("No of users quit smoking surveys ==" + noOfUserQuitSmokingSurveys);
		System.out.println("No of users doc friends ==" + noOfUsersDocFriends);
		
		
		
		pageList = read.getHealthPages();
		for(Pages page : pageList){
			if(page.getLocation().equals(location)){
				noOfUsersLikesPages = noOfUsersLikesPages + Integer.parseInt(page.getLikes());
			}
		}
		
		noOfUsersLikesPages = noOfUsersLikesPages/10;
		pecentUserContriInHgHb =((noOfUsersVisitingHG + noOfUsersVisitingHP + noOfUsersLikesPages)*100) /(30);
		percentUserSmokeDrink=((noOfUsersSmoke+noOfUsersDrinks))*100/20;
		percentUserDocCont=(noOfUsersDocFriends*100)/10;
		percentUserQuitSur = (noOfUserQuitSmokingSurveys*100)/10;
		
		
		Integer healthyBehavior = 0;
		Integer riskBehavior = 0;
		Integer preventiveBehavior = 0;
		
		
		healthyBehavior = pecentUserContriInHgHb;
		riskBehavior = percentUserSmokeDrink;
		preventiveBehavior = (percentUserDocCont + percentUserQuitSur)/2;
		
		
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("JSChart");
			doc.appendChild(rootElement);
	 
			// staff elements
			Element dataset = doc.createElement("dataset");
			rootElement.appendChild(dataset);
	 
			// set attribute to staff element
			Attr attr = doc.createAttribute("type");
			attr.setValue("pie");
			dataset.setAttributeNode(attr);
	 	
			Element data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("PUSD");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(percentUserSmokeDrink.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
			
			data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("UHDC");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(percentUserDocCont.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
	 
			
			data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("PUCHGHB");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(pecentUserContriInHgHb.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
	 
			
			data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("PUQSS");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(percentUserQuitSur.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
	 
	 
			Element colorset = doc.createElement("colorset");
			rootElement.appendChild(colorset);
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FACC00");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FB9900");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FB6600");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FB4800");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
	 
			Element optionset = doc.createElement("optionset");
			rootElement.appendChild(optionset);
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setTitleColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#857D7D'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setPieUnitsColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#9B9B9B'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
			
			
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setPieValuesColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#6A0000'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
					
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/PieUsers"+location+".xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		
		
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("JSChart");
			doc.appendChild(rootElement);
	 
			// staff elements
			Element dataset = doc.createElement("dataset");
			rootElement.appendChild(dataset);
	 
			// set attribute to staff element
			Attr attr = doc.createAttribute("type");
			attr.setValue("pie");
			dataset.setAttributeNode(attr);
	 	
			Element data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("Healthy Behavior");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(healthyBehavior.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
			
			data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("Risk Behavior");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(riskBehavior.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
	 
			
			data = doc.createElement("data");
			attr = doc.createAttribute("unit");
			attr.setValue("Preventive Health Behavior");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue(preventiveBehavior.toString());
			data.setAttributeNode(attr);
			dataset.appendChild(data);
	 			 
			Element colorset = doc.createElement("colorset");
			rootElement.appendChild(colorset);
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FACC00");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FB9900");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			data = doc.createElement("color");
			attr = doc.createAttribute("value");
			attr.setValue("#FB6600");
			data.setAttributeNode(attr);
			colorset.appendChild(data);
			
			Element optionset = doc.createElement("optionset");
			rootElement.appendChild(optionset);
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setTitleColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#857D7D'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setPieUnitsColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#9B9B9B'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
			
			
			data = doc.createElement("option");
			attr = doc.createAttribute("set");
			attr.setValue("setPieValuesColor");
			data.setAttributeNode(attr);
			attr = doc.createAttribute("value");
			attr.setValue("'#6A0000'");
			data.setAttributeNode(attr);
			optionset.appendChild(data);
					
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/PieUsers"+location+"Behavior.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		
		
		
		
		
		}

	
	
	
	public static void main(String a[]) throws FileNotFoundException, IOException, ParseException{
		WriteJson write = new WriteJson();
		write.noOfUsers("Bangalore");
		write.noOfUsers("Delhi");
	
	}
	

}
*/