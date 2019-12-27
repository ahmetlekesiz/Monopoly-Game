package spring.config.squares;

import BL.squares.BCommunityChestSquare;
import BL.squares.BSquare;
import BL.squares.PropertyType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "spring.consumer")
public class CommunityChestSquareConfiguration {

    @Bean
    public BSquare getSquare() {
        return new BCommunityChestSquare(PropertyType.NOCOLOR);
    }
}
