package com.example.socialnetwork.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.socialnetwork.entity.Comment;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetCommentsService {
    public List<Comment> call_me_to_get_comments(String Id, String token) throws Exception{
        List<Comment> commentList = new ArrayList<Comment>();
        try {
            //SETUP THE CULR REQUEST
            String url = "https://graph.facebook.com/v10.0/"+ Id +"/comments?access_token="+ token;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            //TODO parse the json to obtain a list of comments

        }catch (Exception e){
            System.out.println(e);
        }
        return commentList;
    }
}
