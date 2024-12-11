import java.util.ArrayList;

public class Race {
    ArrayList<Car> cars = new ArrayList<>();
    Car leader;

    //После успешного ввода рассчитываем, сколько километров за 24 часа смог проехать каждый участник гонки (автомобиль), и запоминаем лидера.
    public  void findLeader() {
        int greatest = 0;
        for (Car car : cars) {
            int passedIn24 = car.velocity*24;
            if (passedIn24 > greatest) {
                greatest = passedIn24;
                leader = car;
            }
        }
    }

    public boolean contains(String name){
        return cars.stream().anyMatch(o -> o.name.equals(name));
    }

}
