package spring.config.squares;

import BL.squares.BPropertySquare;
import BL.squares.BSquare;
import BL.squares.PropertyType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "spring.consumer")
public class PropertySquareConfiguration {

    @Bean
    public BSquare getSquare() {
        return new BPropertySquare("Property", PropertyType.BLUE, 100, 450);
    }
}
