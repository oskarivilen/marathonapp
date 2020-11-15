package com.example.marathonapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.access.prepost.PreAuthorize;

import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;
import com.example.marathonapp.model.Starterrepository;

import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RunnerController {

	// Adds repositories to the controller

	@Autowired
	private RunnerRepository repository;
	@Autowired
	private Starterrepository srepository;

	// Starts with login page

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Gets all the runners to the runnerlist page

	@RequestMapping(value = { "/runnerlist" })
	public String runnerlist(Model model) {
		model.addAttribute("runners", repository.findAll());
		return "runnerlist";
	}

	// RESTful service to get all runners
	@RequestMapping(value = "/runners", method = RequestMethod.GET)
	public @ResponseBody List<Runner> runnerListRest() {
		return (List<Runner>) repository.findAll();
	}

	// RESTful service to get runner by id
	@RequestMapping(value = "/runner/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Runner> findRunnerRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	// to add a runner
	@RequestMapping(value = "/add")
	public String addRunner(Model model) {
		model.addAttribute("runner", new Runner());
		model.addAttribute("starters", srepository.findAll());
		return "addrunner";
	}

	// to save a runner
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Runner runner) {
		repository.save(runner);
		return "redirect:runnerlist";
	}

	// to delete a runner, needs to be admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteRunner(@PathVariable("id") Long runnerId, Model model) {
		repository.deleteById(runnerId);
		return "redirect:../runnerlist";
	}

	// to modify a runner needs to be admin
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
	public String modifyRunner(@PathVariable("id") Long runnerId, Model model) {
		Optional<Runner> runner = repository.findById(runnerId);
		model.addAttribute("runner", runner);
		model.addAttribute("starters", srepository.findAll());
		return "modifyrunner";
	}
}