package com.example.Test.controllers;

import com.example.Test.Repositoriy.BananasRepository;
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
@RequestMapping("/Bananas")
public class BananaController {

    @Autowired
    private BananasRepository bananasRepository;

    @GetMapping("/")
    public  String Index(Model model){
        Iterable<Bananas> bananas =  bananasRepository.findAll();
        model.addAttribute("bananas", bananas);
        return "Bananas/index";
    }

    @GetMapping("/addView")
    public  String addView(Model model){

        model.addAttribute("banana",new Bananas());
        return "Bananas/add";
    }


    @PostMapping("/add")
    public  String add(
            @ModelAttribute("banana") @Valid Bananas newOne,
            BindingResult bind,
            Model model){

        if(bind.hasErrors())
            return "Bananas/add";

        bananasRepository.save(newOne);
        return "redirect:/Bananas/";
    }

    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable("id")Long id, Model model
    )
    {
        if(!bananasRepository.existsById(id))
        {
            return "redirect:/Bananas/";
        }
        Optional<Bananas> news = bananasRepository.findById(id);
        ArrayList<Bananas> newArrayList = new ArrayList<>();
        news.ifPresent(newArrayList::add);
        model.addAttribute("banana",newArrayList.get(0));

        return "Bananas/Edit";
    }
    @PostMapping("/edit/{id}")
    public  String editNews(
            @PathVariable("id")Long id,
            @ModelAttribute("banana") @Valid Bananas newOne, BindingResult bind, Model model
    )
    {
        if(!bananasRepository.existsById(id))
        {
            return "redirect:/Bananas/";
        }
        if(bind.hasErrors())
            return "Bananas/Edit";

        newOne.setId(id);

        bananasRepository.save(newOne);
        return "redirect:/Bananas/";
    }

    @GetMapping("/search")
    public  String searchMetrhod(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Bananas> bananas =  bananasRepository.findAll();
            model.addAttribute("bananas", bananas);
            return "Bananas/index";
        }
        else {
            List<Bananas> bananasList = bananasRepository.findByName(name);
            model.addAttribute("bananas", bananasList);
            return "/Bananas/index";
        }
    }
    @GetMapping("/searchContaints")
    public  String searchMetrhodContains(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Bananas> bananas =  bananasRepository.findAll();
            model.addAttribute("bananas", bananas);
            return "Bananas/index";
        }
        else {
            List<Bananas> bananasList = bananasRepository.findByNameContains(name);
            model.addAttribute("bananas", bananasList);
            return "/Bananas/index";
        }
    }

    @GetMapping("/{id}")
    public  String read(
            @PathVariable("id")Long id,
            Model model)
    {
        Optional<Bananas> news = bananasRepository.findById(id);
        ArrayList<Bananas> newArrayList = new ArrayList<>();
        news.ifPresent(newArrayList::add);
        model.addAttribute("bananas",newArrayList);
        return "Bananas/Info";
    }

    @GetMapping("/del/{id}")
    public  String del(
            @PathVariable("id")Long id)
    {
        Bananas news = bananasRepository.findById(id).orElseThrow();
        bananasRepository.delete(news);
        return "redirect:/Bananas/";
    }



}
