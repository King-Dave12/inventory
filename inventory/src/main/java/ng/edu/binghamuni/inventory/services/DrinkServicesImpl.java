package ng.edu.binghamuni.inventory.services;

import ng.edu.binghamuni.inventory.domain.Drink;
import ng.edu.binghamuni.inventory.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServicesImpl implements DrinkService
{
    @Autowired
    DrinkRepository drinkRepository;

    @Override
    public Drink saveDrink(Drink drink)
    {
        return drinkRepository.save(drink);
    }

    @Override
    public Drink getDrinkById(long id)
    {
        Optional<Drink> drink = drinkRepository.findById(id);

        Drink emptyDrink;
        if(drink.isPresent())
        {
          emptyDrink = drink.get();
          return emptyDrink;
        }
        else
        {
            throw new RuntimeException("Drink Not Found");
        }
    }

    @Override
    public List<Drink> getAllDrinks()
    {
        return drinkRepository.findAll();
    }

    @Override
    public Drink updateDrink(Drink drink)
    {
        Optional<Drink> optionalDrink = drinkRepository.findById(drink.getId());
        if (optionalDrink.isPresent())
        {
            Drink updateDrink = new Drink();
            updateDrink.setCapacity(drink.getCapacity());
            updateDrink.setColor(drink.getColor());
            updateDrink.setCompany(drink.getCompany());
            updateDrink.setName(drink.getName());
            updateDrink.setPrice(drink.getPrice());
            updateDrink.setIngredients(drink.getIngredients());

            drinkRepository.save(updateDrink);
            return updateDrink;
        }
        else
        {
            throw new RuntimeException("Drink does not exist");
        }
    }


    @Override
    public void deleteDrink(long id)
    {
        drinkRepository.deleteById(id);
    }

}
