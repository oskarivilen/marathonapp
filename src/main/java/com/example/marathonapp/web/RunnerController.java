package com.example.marathonapp.web;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//import com.example.marathonapp.model.GroupRepository;
import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RunnerController {
	@Autowired
	private RunnerRepository repository; 
	
	
	
	
	 @RequestMapping(value= {"/", "/runnerlist"})
    public String runnerlist(Model model) {	
        model.addAttribute("runners", repository.findAll());
        return "runnerlist";
    }
	 
	

    @RequestMapping(value = "/add")
    public String addRunner(Model model){
    	model.addAttribute("runner", new Runner());
    	//model.addAttribute("groups", grepository.findAll());
        return "addrunner";
    }     
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRunner(Long id, Model model){
    	model.addAttribute("runner", repository.findById(id));
        return "editRunner";
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
   /* @RequestMapping(value = "/modify/{runnerId}", method = RequestMethod.GET)
    public String modifyRunner(@PathVariable("id") Long runnerId, Model model) {
    	Optional<Runner> runner = repository.findById(runnerId);
    	model.addAttribute("runner", runner);
    	model.addAttribute("groups", grepository.findAll());
        return "modifyrunner"; 
    }  */
}