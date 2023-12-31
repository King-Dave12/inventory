package ng.edu.binghamuni.inventory.repository;

import ng.edu.binghamuni.inventory.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long>
{
    //@Query("")
    //List<Drink> findDrinkByPriceGreaterThan(int price);
}
