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

    @GetMapping("/frag")
    public String greeting2(Model model)
    {
      ItemArrayList = ItemRepositoryInstance.getAllItems();
        model.addAttribute("ItemArrayList", ItemArrayList);
        return "fragmentMain.html";
    }


//    @PostMapping("/additem") //den gamle additem
//      public String addItem(@RequestParam(name="ItemName", required=false) String ItemName,
//                            @RequestParam(name="ItemDescription", required=false) String ItemDescription,
//                            Model model){
//        Item newItem = new Item(ItemName, ItemDescription);
//
//        ItemArrayList.add(newItem);
//        model.addAttribute("ItemArrayList", ItemArrayList);
//    ItemArrayList.add(newItem);
//    return "redirect:";
//    }

//    @GetMapping("/set-session")
//    @ResponseBody
//    public String setSession(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.setAttribute("username", "CookieMonster42");
//
//        return "Username saved in the session";
//    }

//        @PostMapping("/login") //gammel login, som rent faktisk (næsten) kunne tjekke, om brugerens navn eksisterede i
    // databasen.
//       public String login(HttpServletRequest request,
//                        @RequestParam(name="username") String username) {
//
//        //ItemRepositoryInstance.doesUserExist(username);
//        HttpSession session = request.getSession();
//
//        int userID = ItemRepositoryInstance.doesUserExist(username);
//        if (userID == -1) {
//            System.out.println("User not OK!");
//            ItemRepositoryInstance.createNewUser(username);
//            userID = ItemRepositoryInstance.getLastUserId();
//        }
//        System.out.println("End of login method in controller");
//        session.setAttribute("userID", userID);
//
//
//        return "redirect:";
//    }

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

//    @GetMapping("/getallitems") //isnt used?
//    public String GetAllItems(Model model){
//        ItemArrayList = ItemRepositoryInstance.getAllItems();
//        model.addAttribute("AllItemList", ItemArrayList);
//        return "getallItems.html";
//    }
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

