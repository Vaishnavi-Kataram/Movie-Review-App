package dev.vaishnavi.movies; // package that we created through spring

import org.springframework.boot.SpringApplication; // SpringApplication is a class that contains run method
import org.springframework.boot.autoconfigure.SpringBootApplication; // import the SpringBoot Annotation
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotations in java are used to let the compiler know about what this class does

@SpringBootApplication
@RestController // tells the compiler that this class is a Rest API Controller not just any other class
public class MoviesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoviesApplication.class, args); // pass the App to be run
	}

//	@GetMapping("/")	// this annotation lets the framework know that the method apiRoot is a get endpoint
//	public String apiRoot() {
//		return "Hello World!";
//	}


}
