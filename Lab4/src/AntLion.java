import java.util.Random;

public class AntLion extends Hero implements DoHoles {

    Random random = new Random();

    public AntLion(String name, Location location) {
        super(name, location);
        System.out.println(String.format("Создан персонаж: %s.\n", this.getName()));
    }

    public void doHoles(int count) throws HolesException {

        System.out.println(String.format("%s устраивает норы. Количество нор: %d.", this.getName(), count));

        // анонимный класс для подсчета количества ходов между норами
        FindCountTunnels holes = new FindCountTunnels () {

            @Override
            public int countWays() {
                int sum = count * (count - 1) / 2; // количество возможных путей sum при count норах
                return random.nextInt(sum) + 1; // случайное число от 0 до sum (столько путей будет сделано)
            }

        };

        int a, b, ways = holes.countWays();

        System.out.println(String.format("%s соединяет норы. Выкопаны ходы:", this.getName()));

        for (int i = 0; i < ways; i ++) {

            // выкопан случайный ход от a-й норы до b-ой норы
            a = random.nextInt(count) + 1;
            do {
                b = random.nextInt(count) + 1;
            } while (a == b);

            System.out.println(String.format("- от %d-ой норы до %d-ой норы", a, b));
        }

        if (ways < 6) throw new HolesException("ОШИБКА! Туннелей слишком мало. Коварные норы не получились.");
        else System.out.println("Получились коварные норы!\n");

    }

    @Override
    public void changeLocation(Location location) {

        System.out.println(String.format("%s отправляется из '%s'.", this.getName(), this.getLocation().getName()));

        int chance;
        do {
            chance = random.nextInt(100);
            System.out.println(String.format("%s идет... идет... идет...", this.getName()));
        } while (chance < 50);

        System.out.println(String.format("%s пришел в '%s'!\n", this.getName(), location.getName()));
        this.setLocation(location);

    }

    @Override
    public String toString() {
        return String.format("Объект типа: AntLion. Имя: %s. Локация: %s.", this.getName(), this.getLocation());
    }

    @Override
    public int hashCode() {
        return 100 * this.hashCode() + 1;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof AntLion)) return false;

        AntLion obj2 = (AntLion) obj1;
        return (obj2.getName() == this.getName());
    }

}
