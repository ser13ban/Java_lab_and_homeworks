package com.example.socialnetwork.service;

import com.example.socialnetwork.entity.Comment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetCommentsQaService {
    public List<Comment> qaComments(String Id, String token) throws Exception {
        GetCommentsService commentsService = new GetCommentsService();
        List<Comment> commentList = commentsService.call_me_to_get_comments(Id,token);
        commentList = filterQuestionMark(commentList);
        //commentList = filterVulgarity(commentList);
        return commentList;
    }

    //return the list of comments that have at least a question mark in them
    public List<Comment> filterQuestionMark(List<Comment> commentList){
        List<Comment> filteredList = commentList.stream()
                .filter(
                        c -> c.getMessage().contains("?") &&
                                c.getMessage() != null &&
                                c.getName() != null
                ).collect(Collectors.toList());
        return filteredList;
    }

    public List<Comment> filterVulgarity(List<Comment> commentList){
        //TODO filter the comments list for question that have clean language

        return null;
    }
    public Comment randomComment(List<Comment> commentList){
        Comment comment = new Comment();
        //TODO returns a random comment for the user to answer
        return comment;
    }
}
