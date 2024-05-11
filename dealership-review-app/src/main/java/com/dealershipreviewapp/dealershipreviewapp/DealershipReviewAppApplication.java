package com.dealershipreviewapp.dealershipreviewapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dealershipreviewapp.dealershipreviewapp.entity.Dealership;
import com.dealershipreviewapp.dealershipreviewapp.repository.DealershipRepository;

@SpringBootApplication
public class DealershipReviewAppApplication implements CommandLineRunner {

	@Autowired
	DealershipRepository dealershipRepository;
	public static void main(String[] args) {
		SpringApplication.run(DealershipReviewAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Dealership[] dealerships = new Dealership[]{
			new Dealership(1,"El Paso", "Texas", "TX", "3 Nova Court", "88563", 31.6948, -106.3, "Holdlamis", "Holdlamis Car Dealership"),
			new Dealership(2,"Minneapolis", "Minnesota", "MN", "6337 Butternut Crossing", "55402", 44.9762, -93.2759, "Temp", "Temp Car Dealership"),
			new Dealership(3,"Birmingham", "Alabama", "AL", "9477 Twin Pines Center", "35285", 33.5446, -86.9292, "Sub-Ex", "Sub-Ex Car Dealership"),
			new Dealership(4,"Dallas", "Texas", "TX", "85800 Hazelcrest Circle", "75241", 32.6722, -96.7774, "Solarbreeze", "Solarbreeze Car Dealership"),
			new Dealership(5,"Baltimore", "Maryland", "MD", "93 Golf Course Pass", "21203", 39.2847, -76.6205, "Regrant", "Regrant Car Dealership"),
		};

		for(Dealership d : dealerships) {
			dealershipRepository.save(d);
		}
		
	}

}
