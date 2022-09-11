package com.example.Test.controllers;
import com.example.Test.Repositoriy.BananasRepository;
import com.example.Test.Repositoriy.MonkeRepository;
import com.example.Test.Repositoriy.NuwesRepositoriy;
import com.example.Test.models.Bananas;
import com.example.Test.models.Monke;
import com.example.Test.models.Nuwes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Monke")
public class MonkeController {

    @Autowired
    private MonkeRepository monkeRepository;

    @GetMapping("/")
    public  String Index(Model model){
        Iterable<Monke> monkes =  monkeRepository.findAll();
        model.addAttribute("monkes", monkes);
        return "Monke/index";
    }

    @GetMapping("/addView")
    public  String addView(Model model){

        model.addAttribute("monke",new Monke());
        return "Monke/add";
    }


    @PostMapping("/add")
    public  String add(
            @ModelAttribute("monke") @Valid Monke newOne,
            BindingResult bind,
            Model model){

        if(bind.hasErrors())
            return "Monke/add";

        monkeRepository.save(newOne);
        return "redirect:/Monke/";
    }

    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable("id")Long id, Model model
    )
    {
        if(!monkeRepository.existsById(id))
        {
            return "redirect:/Monke/";
        }
        Optional<Monke> news = monkeRepository.findById(id);
        ArrayList<Monke> newArrayList = new ArrayList<>();
        news.ifPresent(newArrayList::add);
        model.addAttribute("monkePer",newArrayList.get(0));

        return "Monke/Edit";
    }
    @PostMapping("/edit/{id}")
    public  String editNews(
            @PathVariable("id")Long id,
            @ModelAttribute("monkePer") @Valid Monke newOne, BindingResult bind, Model model
    )
    {
        if(!monkeRepository.existsById(id))
        {
            return "redirect:/Monke/";
        }
        if(bind.hasErrors())
            return "Monke/Edit";

        newOne.setId(id);

        monkeRepository.save(newOne);
        return "redirect:/Monke/";
    }

    @GetMapping("/search")
    public  String searchMetrhod(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Monke> monkes =  monkeRepository.findAll();
            model.addAttribute("monkes", monkes);
            return "Monke/index";
        }
        else {
            List<Monke> monkkeList = monkeRepository.findByName(name);
            model.addAttribute("monkes", monkkeList);
            return "/Monke/index"; //searchContains
        }
    }
    @GetMapping("/searchContains")
    public  String searchMetrhodContains(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Monke> monkes =  monkeRepository.findAll();
            model.addAttribute("monkes", monkes);
            return "Monke/index";
        }
        else {
            List<Monke> monkkeList = monkeRepository.findByNameContains(name);
            model.addAttribute("monkes", monkkeList);
            return "/Monke/index"; //searchContains
        }
    }

    @GetMapping("/{id}")
    public  String read(
            @PathVariable("id")Long id,
            Model model)
    {
        Optional<Monke> news = monkeRepository.findById(id);
        ArrayList<Monke> newArrayList = new ArrayList<>();
        news.ifPresent(newArrayList::add);
        model.addAttribute("monkes",newArrayList);
        return "Monke/Info";
    }

    @GetMapping("/del/{id}")
    public  String del(
            @PathVariable("id")Long id)
    {
        Monke news = monkeRepository.findById(id).orElseThrow();
        monkeRepository.delete(news);
        return "redirect:/Monke/";
    }



}
