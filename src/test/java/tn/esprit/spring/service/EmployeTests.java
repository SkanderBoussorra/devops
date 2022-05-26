package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

import static org.junit.Assert.assertNotEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTests {
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ContratServiceImpl contratService;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService iEmployeService;
	@Autowired
	IEntrepriseService iEntrepriseService;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EntrepriseRepository enterpriseRepository;
	@Autowired
	ContratRepository contratRepository;


	Entreprise entreprise;
	Contrat contract_1, contract_2, contract_3;
	Departement department_1;
	Employe employee_2 = new Employe("Khaled", "Kallel", "Khaled_.kallel@ssiiconsulting.tn", true, Role.INGENIEUR);
	Employe employee_1 = new Employe("Khaled", "ben", "updatedmail@mail.com", true, Role.INGENIEUR);
	Employe employee_3 = new Employe("monji", "slim", "monji@ssiiconsulting.tn", true, Role.CHEF_DEPARTEMENT);

	@Test
	public void getNombreEmployeJPQL() {
		int count = employeService.getNombreEmployeJPQL();
		if (count == 0)
			employeService.ajouterEmploye(employee_1);
		Assert.assertNotEquals(0, count);
	}

	@Test
	public void getAllEmployeNamesJPQL() {
		List<String> actual_names = employeService.getAllEmployeNamesJPQL();
		Assert.assertTrue(actual_names.size() > 0);
	}

	@Test
	public void getAllEmployeByEntreprise() {
		entreprise = new Entreprise("Accretio", "Accretio France");
		department_1 = new Departement("Mobile", employeService.getAllEmployes(), entreprise);
		entreprise.addDepartement(department_1);
		enterpriseRepository.save(entreprise);
		departementRepository.save(department_1);
		List<Employe> actual_employee_by_enterprise = employeService.getAllEmployeByEntreprise(entreprise);
		Assert.assertNotNull(actual_employee_by_enterprise);
	}

	@Test
	public void mettreAjourEmailByEmployeIdJPQL() {
		String newMail = "hedil@mail.com";
		employeService.mettreAjourEmailByEmployeIdJPQL(newMail, employeService.getAllEmployes().get(1).getId());
		String updatedMail = employeService.getAllEmployes().get(1).getEmail();

		Assert.assertEquals("check updated mail ", newMail, updatedMail);
	}

	@Test
	public void deleteAllContratJPQL() {
		employeService.deleteAllContratJPQL();
		long count = contratRepository.count();
		Assert.assertEquals("deleteAllContractJPQL... ", 0, count);
	}

	@Test
	public void getSalaireByEmployeIdJPQL() throws ParseException {
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
		Date date = DateFor.parse("2021/11/25");
		contract_1 = new Contrat(111, date, "CIVP", 1200);
		contract_1.setEmploye(employeService.getAllEmployes().get(0));
		contratRepository.save(contract_1);
		float salary = employeService.getSalaireByEmployeIdJPQL(employeService.getAllEmployes().get(0).getId());
		MatcherAssert.assertThat("getSalaireByEmployeIdJPQL... ", salary, Matchers.equalTo(contract_1.getSalaire()));
	}

	@Test
	public void getAllEmployes() {
		List<Employe> employees = employeService.getAllEmployes();
		Assert.assertNotNull(employees);
	}

	@Test
	public void ajouterEmploye() throws ParseException {

		Employe em = new Employe("did", "bsr" 	,"didi@esprit.tn","aaaa",true,Role.CHEF_DEPARTEMENT);
		int employeId = employeService.ajouterEmploye(em);
		assertEquals("check ajout employé ",5,employeId);
	}
	@Test
	public void ajouterContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-10-30");
		Contrat c = new Contrat(155,d, "CVP", 3200);

		int ContratRef = employeService.ajouterContrat(c);
		assertEquals("check ajout contrat ",155,ContratRef);
	}


}
