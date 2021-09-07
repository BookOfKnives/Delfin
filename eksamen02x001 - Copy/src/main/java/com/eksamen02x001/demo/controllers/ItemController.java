package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.Item;
import com.eksamen02x001.demo.models.ProjectModel;
import com.eksamen02x001.demo.repository.ItemRepository;
import com.eksamen02x001.demo.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ItemController {

    private ItemRepository ItemRepositoryInstance = new ItemRepository();
    private ArrayList<Item> ItemArrayList = new ArrayList<>();



    @GetMapping("/item")
    public String greeting(  Model model )
    {
        ItemArrayList = ItemRepositoryInstance.getAllItems();
        model.addAttribute("ItemArrayList", ItemArrayList);
        //testprojectmodel
        //ProjectModel testProject = new ProjectModel(1, "hanstest", "årpekctDESCROÅ", "ejerern", 1, "2021-08-01", 0);
        //ProjectRepository testproj = new ProjectRepository();
        //testproj.addProjectToDB(testProject);
        return "item.html";
    }


    @GetMapping("/get-session")
    @ResponseBody
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        return username;
    }

    @GetMapping("/invalidate-session")
    @ResponseBody
    public String invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "Session invalidated";
    }

    @GetMapping("/additem")
    public String foo(){
        return "addItem.html";
    }

    @PostMapping("/additem")
    public String bar(@RequestParam(name="ItemName", required= false) String ItemName,
                      @RequestParam(name="ItemDescription", required= false) String ItemDescription)
    {
        ItemRepositoryInstance.addItem(ItemName, ItemDescription);
        return "redirect:";
    }

    @GetMapping("/removeitem")
    public String removeItem(){
        return "removeitem.html";
    }

    @PostMapping("/removeitem")
    public String removeItem(@RequestParam(name="ItemNumber", required=false) int ItemNumber)
    {
        ItemRepositoryInstance.deleteItem(ItemNumber);
                        return "redirect:";
    }

    @GetMapping("/updateitem")
    public String updateItem()
    {
        return "updateitem.html";
    }
    @PostMapping("/updateitem")
    public String updateItem(@RequestParam(name="ItemID") int ItemNumber,
                             @RequestParam(name="NewItemName") String NewItemName)
    {
        ItemRepositoryInstance.updateItem(NewItemName, ItemNumber);
        return "redirect:";
    }

}

