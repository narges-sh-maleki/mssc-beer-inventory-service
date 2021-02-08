package guru.sfg.beer.inventory.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeerInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerInventoryApplication.class, args);
    }

    @Bean
    public String getMyProfile(@Value("${spring.profiles.active:my default value}") String myProfile){
        System.out.println("********************" + myProfile +"********************" );
        return myProfile;
    }

}
