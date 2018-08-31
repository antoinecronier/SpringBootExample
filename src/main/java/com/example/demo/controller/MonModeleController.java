package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MonModele;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/MonModele")
public class MonModeleController {

    List<MonModele> table = new ArrayList<MonModele>();
    Gson gson = new Gson();
    Long lastInsertedId;

    public MonModeleController() {
        table.add(new MonModele(1l,"machin", "chose", 10, true, new String[] {"bidule", "truc"}));
        table.add(new MonModele(2l,"énergumène", "chose", 10, true, new String[] {"bidule", "truc"}));
        table.add(new MonModele((long) 3,"toto", "chose", 10, true, new String[] {"bidule", "truc"}));
        this.lastInsertedId = 3l;
    }

    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
        return gson.toJson(table);
    }

    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Integer index) {
        return gson.toJson(table.get(index));
    }

    /*
     * @RequestBody => raw
     * @ModelAttribute => form
     * */
    @RequestMapping(path={"/", ""}, method=RequestMethod.POST)
    public String postItem(@RequestBody MonModele monModele) {
    	this.lastInsertedId++;
    	monModele.setKey(this.lastInsertedId);
        this.table.add(monModele);
        return gson.toJson(monModele);
    }

    @RequestMapping(path={"/", ""}, method=RequestMethod.PUT)
    public String updateItem(@RequestBody MonModele monModele) {
    	for (int i = 0; i < table.size(); i++) {
    		if (table.get(i).getKey().equals(monModele.getKey())) {
    			table.remove(i);
    			table.add(monModele);
    			break;
    		}
		}

        return gson.toJson(table.get(table.indexOf(monModele)));
    }
    
    @RequestMapping(path={"/", ""}, method=RequestMethod.DELETE)
    public String deleteItem(@RequestBody MonModele monModele) {
    	for (int i = 0; i < table.size(); i++) {
    		if (table.get(i).getKey().equals(monModele.getKey())) {
    			table.remove(i);
    			break;
    		}
		}

        return "ok";
    }
}