package web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private List<Car> carsList;

    {
        carsList = new ArrayList<>();
        carsList.add(new Car("VAZ", "Black", 2010));
        carsList.add(new Car("Mercedes", "Red", 2018));
        carsList.add(new Car("Volvo", "Yellow", 2022));
        carsList.add(new Car("BMW", "Green", 2020));
        carsList.add(new Car("Toyota", "Orange", 2016));
    }

    public List<Car> getCarsList(int count) {
        return carsList.stream().limit(count).collect(Collectors.toList());
    }
}
