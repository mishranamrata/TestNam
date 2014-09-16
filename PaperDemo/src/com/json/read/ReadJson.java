/*package com.json.read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.json.java.Friends;
import com.json.java.Groups;
import com.json.java.Pages;
import com.json.java.Surveys;
import com.json.java.UserProfile;

public class ReadJson {
    
    @SuppressWarnings("unchecked")
	public UserProfile getUserProfilfe(){
    	 JSONParser parser = new JSONParser();
         UserProfile userProfile = new UserProfile();
    	  try {
    		  
              Object userProfileObj = parser.parse(new FileReader(
                      "C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/User_Profile.json"));    
             
              JSONObject userProfileJsonObject = (JSONObject) userProfileObj;
              JSONArray groups = (JSONArray) userProfileJsonObject.get("groups");
              JSONArray pages = (JSONArray) userProfileJsonObject.get("page");
              JSONArray surveys = (JSONArray) userProfileJsonObject.get("surveys");
              userProfile.setId((String)userProfileJsonObject.get("id")); 
              userProfile.setName((String)userProfileJsonObject.get("name"));
              userProfile.setDinking((String)userProfileJsonObject.get("drinking"));
              userProfile.setSmoking((String)userProfileJsonObject.get("smoking"));
              userProfile.setWork((String)userProfileJsonObject.get("work"));
              userProfile.setLocation((String)userProfileJsonObject.get("location"));
              userProfile.setNoOfDocContacts((String)userProfileJsonObject.get("no_of_doc_contacts"));
              Iterator<JSONObject> iterator = groups.iterator();
              List<Groups> grp = new ArrayList<Groups>();
              while(iterator.hasNext()){
              	Groups grpTmp = new Groups();
              	JSONObject groupsJsonObject = (JSONObject) iterator.next();
              	grpTmp.setCategory((String)groupsJsonObject.get("category"));
              	grpTmp.setId((String)groupsJsonObject.get("id"));
              	grpTmp.setLocation((String)groupsJsonObject.get("location"));
              	grpTmp.setMembers((String)groupsJsonObject.get("members"));
              	grpTmp.setName((String)groupsJsonObject.get("name"));
              	grp.add(grpTmp);
              }
              userProfile.setGroup(grp);
              iterator = pages.iterator();
              List<Pages> pageList = new ArrayList<Pages>();
              while(iterator.hasNext()){
              	Pages pageTmp = new Pages();
              	JSONObject pagesJsonObject = (JSONObject) iterator.next();
              	pageTmp.setCategory((String)pagesJsonObject.get("category"));
              	pageTmp.setId((String)pagesJsonObject.get("id"));
              	pageTmp.setLocation((String)pagesJsonObject.get("location"));
              	pageTmp.setLikes((String)pagesJsonObject.get("likes"));
              	pageTmp.setName((String)pagesJsonObject.get("name"));
              	pageList.add(pageTmp);
              }            
              userProfile.setPage(pageList);
              iterator = surveys.iterator();
              List<Surveys> surveysList = new ArrayList<Surveys>();
              while(iterator.hasNext()){
              	Surveys surveysTmp = new Surveys();
              	JSONObject surveysJsonObject = (JSONObject) iterator.next();
              	surveysTmp.setCategory((String)surveysJsonObject.get("category"));
              	surveysTmp.setName((String)surveysJsonObject.get("name"));
              	surveysList.add(surveysTmp);
              }
              userProfile.setSurveys((surveysList));
             } catch (Exception e) {
              e.printStackTrace();
          }
    	  return userProfile;
    	
    }
    
    @SuppressWarnings("unchecked")
	public static Friends getFriends() throws FileNotFoundException, IOException, ParseException{
    	 JSONParser parser = new JSONParser();
    	 Object friendsProfileObj = parser.parse(new FileReader(
                 "C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/Friends.json"));
    	 Friends friendsList = new Friends();
         JSONObject friendsProfileJsonObject = (JSONObject) friendsProfileObj;
         JSONArray friends = (JSONArray) friendsProfileJsonObject.get("friends");
         Iterator<JSONObject> iterator = friends.iterator();
         List<UserProfile> userProfileList = new ArrayList<UserProfile>();
        while(iterator.hasNext()){
        	UserProfile userProfileTemp = new UserProfile();
         	JSONObject userProfileJsonObject = (JSONObject) iterator.next();
         	JSONArray groups = (JSONArray) userProfileJsonObject.get("groups");
         	JSONArray pages = (JSONArray) userProfileJsonObject.get("page");
         	JSONArray surveys = (JSONArray) userProfileJsonObject.get("surveys");
             userProfileTemp.setId((String)userProfileJsonObject.get("id")); 
             userProfileTemp.setName((String)userProfileJsonObject.get("name"));
             userProfileTemp.setDinking((String)userProfileJsonObject.get("drinking"));
             userProfileTemp.setSmoking((String)userProfileJsonObject.get("smoking"));
             userProfileTemp.setWork((String)userProfileJsonObject.get("work"));
             userProfileTemp.setLocation((String)userProfileJsonObject.get("location"));
             userProfileTemp.setNoOfDocContacts((String)userProfileJsonObject.get("no_of_doc_contacts"));
              Iterator<JSONObject> iteratorgrp = groups.iterator();
              List<Groups> grp = new ArrayList<Groups>();
             while(iteratorgrp.hasNext()){
             	Groups grpTmp = new Groups();
             	JSONObject groupsJsonObject = (JSONObject) iteratorgrp.next();
             	grpTmp.setCategory((String)groupsJsonObject.get("category"));
             	grpTmp.setId((String)groupsJsonObject.get("id"));
             	grpTmp.setLocation((String)groupsJsonObject.get("location"));
             	grpTmp.setMembers(groupsJsonObject.get("members").toString());
             	grpTmp.setName((String)groupsJsonObject.get("name"));
             	grp.add(grpTmp);
             }
             userProfileTemp.setGroup(grp);
             Iterator<JSONObject> iteratorp = pages.iterator();
             List<Pages> pageList = new ArrayList<Pages>();
             while(iteratorp.hasNext()){
             	Pages pageTmp = new Pages();
             	JSONObject pagesJsonObject = (JSONObject) iteratorp.next();
             	pageTmp.setCategory((String)pagesJsonObject.get("category"));
             	pageTmp.setId((String)pagesJsonObject.get("id"));
             	pageTmp.setLocation((String)pagesJsonObject.get("location"));
             	pageTmp.setLikes((String)pagesJsonObject.get("likes"));
             	pageTmp.setName((String)pagesJsonObject.get("name"));
             	pageList.add(pageTmp);
             }            
             userProfileTemp.setPage(pageList);
             Iterator<JSONObject> iteratorS = surveys.iterator();
            List<Surveys> surveysList = new ArrayList<Surveys>();
             while(iteratorS.hasNext()){
             	Surveys surveysTmp = new Surveys();
             	JSONObject surveysJsonObject = (JSONObject) iteratorS.next();
             	surveysTmp.setCategory((String)surveysJsonObject.get("category"));
             	surveysTmp.setName((String)surveysJsonObject.get("name"));
             	surveysList.add(surveysTmp);
             }
             userProfileTemp.setSurveys((surveysList));
             userProfileList.add(userProfileTemp);
         }
         friendsList.setFriends(userProfileList);
        
      return friendsList;
    }
    
    @SuppressWarnings("unchecked")
	public List<Groups> getHealthGroups() throws FileNotFoundException, IOException, ParseException{
    	 JSONParser parser = new JSONParser();
    	 Object healthGroupsObj = parser.parse(new FileReader(
                 "C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/Health_Groups.json"));
    	 JSONObject healthGroupsJsonObject = (JSONObject) healthGroupsObj;
    	 JSONArray groups = (JSONArray) healthGroupsJsonObject.get("groups");
    	 Iterator<JSONObject>iterator = groups.iterator();
         List<Groups> grp = new ArrayList<Groups>();
        while(iterator.hasNext()){
        	Groups grpTmp = new Groups();
        	JSONObject groupsJsonObject = (JSONObject) iterator.next();
        	grpTmp.setCategory((String)groupsJsonObject.get("category"));
        	grpTmp.setId((String)groupsJsonObject.get("id"));
        	grpTmp.setLocation((String)groupsJsonObject.get("location"));
        	grpTmp.setMembers((String)groupsJsonObject.get("members"));
        	grpTmp.setName((String)groupsJsonObject.get("name"));
        	if(grpTmp.getCategory().equals("Health Care")){
        		grp.add(grpTmp);
        	}
        	
        }
        return grp;
    }
    
    @SuppressWarnings("unchecked")
	public List<Pages> getHealthPages() throws FileNotFoundException, IOException, ParseException{
    	 JSONParser parser = new JSONParser();
    	 Object healthPagesObj = parser.parse(new FileReader(
                 "C:/Users/nmishra/workspace/PaperDemo/src/com/json/file/Health_Pages.json"));
    	 JSONObject healthPagesJsonObject = (JSONObject) healthPagesObj;
    	 JSONArray groups = (JSONArray) healthPagesJsonObject.get("pages");
    	 Iterator<JSONObject>iterator = groups.iterator();
         List<Pages> pageList = new ArrayList<Pages>();
        while(iterator.hasNext()){
        	Pages pageTmp = new Pages();
         	JSONObject pagesJsonObject = (JSONObject) iterator.next();
         	pageTmp.setCategory((String)pagesJsonObject.get("category"));
         	pageTmp.setId((String)pagesJsonObject.get("id"));
         	pageTmp.setLocation((String)pagesJsonObject.get("location"));
         	pageTmp.setLikes((String)pagesJsonObject.get("likes"));
         	pageTmp.setName((String)pagesJsonObject.get("name"));
         	if(pageTmp.getCategory().equals("Health")){
         	pageList.add(pageTmp);
         	}
         
        }
    	return pageList;
    }
    
           
   
    
    public static void main(String a[]) throws FileNotFoundException, IOException, ParseException{
    	Friends frnd = new Friends();
    	frnd = getFriends();
    	for(int i = 0; i< frnd.getFriends().size();i++){
    		System.out.println("Name : " + frnd.getFriends().get(i).getName());
    		System.out.println("Groups : " + frnd.getFriends().get(i).getGroup().size());
    		System.out.println("Pages : " + frnd.getFriends().get(i).getPage().size());
    		System.out.println("Surveys : " + frnd.getFriends().get(i).getSurveys().size());
    	}
    
    List<Pages> page = new ArrayList<Pages>();
    page = getHealthPages();
    for(int i = 0; i < page.size() ; i++){
    	System.out.println("Name : " + page.get(i).getName());
    }
    }
    
}
    
    
*/