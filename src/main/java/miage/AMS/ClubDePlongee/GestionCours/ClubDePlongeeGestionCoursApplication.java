package miage.AMS.ClubDePlongee.GestionCours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, 
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}) 
@EnableDiscoveryClient
public class ClubDePlongeeGestionCoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubDePlongeeGestionCoursApplication.class, args);
	}

}
