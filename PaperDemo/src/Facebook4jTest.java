import java.io.File;
import java.io.IOException;

import javax.xml.ws.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friend;
import facebook4j.Friendlist;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;


public class Facebook4jTest {
	
	@SuppressWarnings("deprecation")
	public static void writeToJsonFile(Object obj,String name){
		ObjectMapper mapper = new ObjectMapper();
	      try
	      {
	         mapper.defaultPrettyPrintingWriter().writeValue(new File("d://temp/"+name+".json"), obj);
	      } catch (JsonGenerationException e)
	      {
	         e.printStackTrace();
	      } catch (JsonMappingException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	   
	}
	

	public static void main(String[] args) throws FacebookException {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("1450285578545060", "86c80bc8c23b0af778988b280ab151ec");
		AccessToken accesstoken = new AccessToken("CAACEdEose0cBADgd7X28qyUOIlYYwmuXdqQa9vysGOvXsosyPCEjjZBZAr4yfPGlvzRlWgdUkiwdFYoUIqoCiZAsfBKbI8c7WkLnWzcPRZCweLegpFGYaM2oBCVrm4o7yLK3pKISbHRZBc4FSyn2EiToQkaPprZCyIUiriwKw8IF70ZCVnUrA3WzEZBfXZB6xzDIZBf48UiOOuZADNP9pwryqYPy11ji8TlJjwZD");
		facebook.setOAuthAccessToken(accesstoken);
		/*ResponseList<Friendlist> friends = facebook.getFriendlists();
		System.out.println(friends.size());
		System.out.println(friends.get(0).getName());*/

		/*ResponseList<Friend> friend = facebook.getFriends();
		System.out.println(friend.size());
		for(int i=0 ; i< friend.size() ;i++){
			if(null != friend.get(i).getLocation()){
				System.out.println(friend.get(i).getLocation().getName());
			}
			else
				System.out.println(friend.get(i).getName());
		}*/
		
		ResponseList<Post> posts = facebook.getFeed();
		for(Post post :posts){
			writeToJsonFile(post,post.getId()+"_Posts");
		}
		
	}

}
