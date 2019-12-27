package spring.config.squares;

import BL.squares.BGoSquare;
import BL.squares.BSquare;
import BL.squares.PropertyType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "spring.consumer")
public class GoSquareConfiguration {

    @Bean
    public BSquare getSquare() {
        return new BGoSquare(PropertyType.NOCOLOR);
    }
}
