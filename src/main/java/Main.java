import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();

        Scanner scanner = new Scanner(System.in);

        //1.Запрашиваем у пользователя 3 автомобиля, каждый из которых имеет два параметра: название и скорость.
        for (int i=0; i < 3; i++) {
            System.out.println("— Введите название машины №" + (i+1));
            String name;
            while(true) {
                name = scanner.nextLine();
                if (name.trim().isEmpty()) {
                    System.out.println("(!) Неверное название машины №" + (i+1) + ". Повторите ввод");
                } else if(race.contains(name)) {
                    System.out.println("(!) Неверное название машины №" + (i + 1) + ". Машина с таким названием уже существует. Введите другое название");
                } else {
                    break;
                }
            }

            //2.После ввода данных пользователем проверяем, что введённая скорость >0 и ⩽250. Если скорость ввели неверно, программа должна запросить эти данные заново.
            System.out.println("— Введите скорость машины №" + (i + 1));
            String stringVelocity;
            int velocity;
            while (true) {
                stringVelocity = scanner.nextLine();
                try {
                    velocity = Integer.parseInt(stringVelocity.trim());
                }
                catch (NumberFormatException e) {
                    velocity = 0;
                }

                if (velocity <= 0 || velocity > 250) {
                    System.out.println("(!) Неверная скорость, введите целочисленное значение от 1 до 250");
                } else {
                    break;
                }
            }

            race.cars.add(new Car(name, velocity));
        }

        //3.После успешного ввода рассчитываем, сколько километров за 24 часа смог проехать каждый участник гонки (автомобиль), и запоминаем лидера.
        race.findLeader();

        //4.Выводим название автомобиля-лидера в консоль
        System.out.println("Самая быстрая машина: '" + race.leader.name + "'");
    }
}