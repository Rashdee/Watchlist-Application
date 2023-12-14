package com.example.WatchlistApplcation.controller;

import com.example.WatchlistApplcation.entity.Movie;
import com.example.WatchlistApplcation.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class MovieController {
    @Autowired
    DatabaseService databaseService;
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWactchListForm(@RequestParam(required = false)Integer id){
        String viewName= "watchlistItemForm";
        Map<String, Object> model=new HashMap<>();

        if(id==null){
            model.put("watchlistItem",new Movie());
        }else {
            model.put("watchlistItem",databaseService.getMovieById(id));
        }



        return new ModelAndView(viewName, model);
    }

    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //if errors are there redisplay form
            return new ModelAndView("watchlistItemForm");
        }

        Integer id =movie.getId();
        if(id==null){
            databaseService.create(movie);
        }else{
            databaseService.update(movie,id);
        }


        RedirectView rd= new RedirectView();
        rd.setUrl("/watchlist");

        return new ModelAndView(rd);
    }

    @GetMapping("/watchlist")
    public ModelAndView getWatchlist(){
        String viewName="watchlist";
        Map<String,Object>model=new HashMap<>();
        List<Movie> movieList = databaseService.getAllMovies();
        model.put("watchlistrows",movieList);
        model.put("noofmovies",movieList.size());
        return new ModelAndView(viewName,model);

    }

}
