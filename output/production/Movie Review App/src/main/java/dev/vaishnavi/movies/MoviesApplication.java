package dev.vaishnavi.movies; // package that we created through spring

import org.springframework.boot.SpringApplication; // SpringApplication is a class that contains run method
import org.springframework.boot.autoconfigure.SpringBootApplication; // import the SpringBoot Annotation

// Annotations in java are used to let the compiler know about what this class does

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {

//		SpringApplication.run(MoviesApplication.class, args); // pass the App to be run
        System.out.print("Hello");
	}

}
