package com.khan.hw4.controllers;

import com.khan.hw4.Models.MovieRepo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class MainController {


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get (@RequestParam("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/");
        String movie = getMovieById(id);
        try{
            JSONObject json = new JSONObject(movie);

            mv.addObject("Title", json.getString("Title"));
            mv.addObject("Released", json.getString("Released"));
            mv.addObject("Runtime", json.getString("Runtime"));
            mv.addObject("Genre", json.getString("Genre"));
            mv.addObject("Director", json.getString("Director"));



        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return mv;
    }

    private String getMovieById(String id){
        try {
            String apiKey = "cfc6ae8e";
            URL urlForGetRequest = new URL("http://www.omdbapi.com/?i=" + id + "&apikey=" + apiKey);

            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                return "Unexpected HTTP response";
            }
        } catch (Exception e){
                return "Exception: " + e.getMessage();
        }
    }




}




