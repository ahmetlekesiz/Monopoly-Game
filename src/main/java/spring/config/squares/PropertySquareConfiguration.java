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

    private static BSquare square;

    @Bean
    public BSquare getSquare() {
        return square;
    }

    public void setSquare(BSquare square) {
        PropertySquareConfiguration.square = square;
    }
}
