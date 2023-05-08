package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Classe;
import tn.esprit.spring.entities.Examen;
import tn.esprit.spring.serviceInterface.IExamenService;
import tn.esprit.spring.serviceInterface.Iservice;

@RestController
@Api(tags = "Gestion des services")
@RequestMapping("/service")
public class ClientRestController {

	@Autowired
	IExamenService examenService;
    //http://localhost:8087/SpringMVC/swagger-ui/index.html
	@ApiOperation(value = "Récupérer la liste des examens")
	@GetMapping("/retrieve-all-examens")
	@ResponseBody
	public List<Examen> getClients() {
		return examenService.retrieveAllExamens();
	}

	@Autowired
	Iservice service;
	// http://localhost:8089/SpringMVC/classe/retrieve-all-classes
	@ApiOperation(value = "Récupérer la liste des classes")
	@GetMapping("/retrieve-all-classes")
	public List<Classe> getClasses() {
		List<Classe> listClasses = service.retrieveAllClasses();
		return listClasses;
	}

	// http://localhost:8089/SpringMVC/classe/retrieve-classe/8
	@ApiOperation(value = "Récupérer un classe par Id")
	@GetMapping("/retrieve-classe/{classe-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Classe retrieveClasse(@PathVariable("classe-id") Integer classeId) {
		return service.retrieveClasse(classeId);
	}

	@PostMapping("/add-classe")
	public Classe addClasse(@RequestBody Classe c) {
		return service.ajouterClasse(c);
	}

	// http://localhost:8089/SpringMVC/classe/remove-classe/{classe-id}
	@DeleteMapping("/remove-classe/{classe-id}")
	public void removeClasse(@PathVariable("classe-id") Integer classeId) {
		service.deleteClasse(classeId);
	}

	// http://localhost:8089/SpringMVC/classe/modify-classe
	@PutMapping("/modify-classe")
	public Classe modifyClasse(@RequestBody Classe classe) {
		return service.updateClasse(classe);
	}

	// http://localhost:8089/SpringMVC/classe/add-classe-assign-coursclassroom/{coursclassroom-id}
	@PostMapping("/add-classe-assign-coursclassroom/{coursclassroom-id}")
	public Classe addClasse(@RequestBody Classe c, @PathVariable("coursclassroom-id") Integer coursClassroomId) {
		return service.AjouterClasseEtAffecterCoursClasse(c, coursClassroomId);
	}

	


}
