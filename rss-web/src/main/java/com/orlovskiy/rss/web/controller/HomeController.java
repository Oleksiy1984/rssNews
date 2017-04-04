package com.orlovskiy.rss.web.controller;

import com.orlovskiy.rss.entity.RssFeedEntryEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orlovskiy.rss.repository.RssRepository;
import com.orlovskiy.rss.repository.SearchRepository;


@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    RssRepository repository;

    @Autowired
    SearchRepository searchRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @PageableDefault(size = 5)
    @SortDefault.SortDefaults(  // (1)
            {
                    @SortDefault(  // (2)
                            sort = "publishedDate",    // (3)
                            direction = Sort.Direction.DESC // (4)
                    )
            }) Pageable pageable ) {
         model.addAttribute("page", repository.findAll(pageable));

        return "index";
    }



    @RequestMapping("/search")
    public String search(@RequestParam(value ="search", required = false) String search, Model model)  {
        if(search == null){
            search = "";
            model.addAttribute("search",search);
        }
        else {
            model.addAttribute("sort",
                    searchRepository.findByTitleContaining(search,new Sort(Sort.Direction.DESC,"publishedDate")));
            model.addAttribute("search",search);
        }
        return "search";
    }


}
