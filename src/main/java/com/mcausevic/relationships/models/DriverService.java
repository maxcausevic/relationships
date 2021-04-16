package com.mcausevic.relationships.models;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcausevic.relationships.repos.LicenseRepo;
import com.mcausevic.relationships.repos.PersonRepo;

@Service
public class DriverService {
private final PersonRepo personRepo;
private  final LicenseRepo licenseRepo;
	public DriverService(PersonRepo personRepo, LicenseRepo licenseRepo) {
		this.personRepo = personRepo;
		this.licenseRepo = licenseRepo;
	}
	public List<Person>allpersons(){
		return personRepo.findAll();
	}
	public List<License>allLicenes(){
		return licenseRepo.findAll();
	}
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	public Person findPerson(Long id) {
		Optional<Person>optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else {
			return null;
		}
	}
	public License findLicense(Long id) {
		Optional<License>optionalLicense = licenseRepo.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else {
			return null;
		}
}
	
}
