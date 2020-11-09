package com.example.marathonapp.web;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;
import com.example.marathonapp.model.Starterrepository;

import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RunnerController {
	@Autowired
	private RunnerRepository repository; 
	@Autowired
 	private Starterrepository srepository; 
	
	
	
	 @RequestMapping(value= {"/", "/runnerlist"})
    public String runnerlist(Model model) {	
        model.addAttribute("runners", repository.findAll());
        return "runnerlist";
    }
	 
	

    @RequestMapping(value = "/add")
    public String addRunner(Model model){
    	model.addAttribute("runner", new Runner());
    	model.addAttribute("starters", srepository.findAll());
        return "addrunner";
    }     
    
   

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Runner runner){
        repository.save(runner);
        return "redirect:runnerlist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRunner(@PathVariable("id") Long runnerId, Model model) {
    	repository.deleteById(runnerId);
        return "redirect:../runnerlist";
    } 
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyRunner(@PathVariable("id") Long runnerId, Model model) {
    	Optional<Runner> runner = repository.findById(runnerId);
    	model.addAttribute("runner", runner);
    	model.addAttribute("starters", srepository.findAll());
        return "modifyrunner"; 
    }  
}