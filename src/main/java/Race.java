import java.util.HashSet;

public class Race {
    HashSet<Car> cars = new HashSet<>();
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

}
