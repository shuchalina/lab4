import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class Moomintroll extends Hero /*implements MoomintrollInventory*/{

    private String[] stock;
    Random random = new Random();

    // имя, локация, ИНВЕНТАРЬ (массив stock)
    public Moomintroll(String name, Location location, String[] stock) {
        super(name, location);
        this.stock = stock;
        System.out.println(String.format("Создан персонаж: %s.\n", this.getName()));
    }

    // найти банку (аргумент - банка)
    public void findJar(Jar jar) {

        System.out.println(String.format("%s нашёл: %s.", this.getName(), jar.getJar()));
        this.addInInventory(jar);

    }

    // вывести содержимое инвентаря
    public void checkInventory () {
        System.out.println(String.format("Инвентарь %s: %s, %s, %s.\n", this.getName(), stock[0], stock[1], stock[2]));
    }

    // добавить банку в инвентарь (аргумент банка)
    public void addInInventory (Jar jar) {

        boolean empty = false;

        for (int i = 0; i <= this.stock.length; i ++) {
            if (this.stock[i] == "---") {
                this.stock[i] = jar.getJar();
                empty = true;
                System.out.println(String.format("%s добавил в инвентарь: %s.\n", this.getName(), jar.getJar()));
                jar.setPosition("Инвнтарь Муми-Тролля");
                break;
            }
        }

        if (!empty) {
            System.out.println(String.format("Инвентарь %s переполнен.\n", this.getName()));
        }

    }

    // закопать банку
    void buryTheJar(Jar jar) {

        System.out.println(String.format("%s закопал: %s.\n", this.getName(), jar.getJar()));
        jar.setPosition("Под землей.");

    }

    @Override
    public void changeLocation(Location location) {

        System.out.println(String.format("%s отправляется из '%s'.", this.getName(), this.getLocation().getName()));

        int chance;
        do {
            chance = random.nextInt(100);
            System.out.println(String.format("%s идет... идет... идет...", this.getName()));
        } while (chance < 10);

        System.out.println(String.format("%s пришел в '%s'!\n", this.getName(), location.getName()));
        this.setLocation(location);

    }

    public void say(String text, Adverb adverb) {
        System.out.println(String.format("%s %s сказал: %s\n", this.getName(), adverb.getTranslation(), text));
    }

    public void see (Snork snork, Adverb adverb) {
        System.out.println(String.format("%s %s посмотрел на: %s.\n", this.getName(), adverb.getTranslation(), snork.getName()));
    }

    public void see (Pit pit, Adverb adverb) {
        System.out.println(String.format("%s %s посмотрел на: %s.\n", this.getName(), adverb.getTranslation(), pit.getPit()));
    }

    public class Head {

        int angle;

        public Head (int angle) {
            this.angle = angle;
            System.out.println(String.format("Создан объект голова %s. Угол поворота: %d.\n", Moomintroll.this.getName(), this.angle));
        }

        public void shake(int count) {

            System.out.print(String.format("%s потряс головой: ", Moomintroll.this.getName()));

            for (int i = 0; i < count; i ++) {

                if (i % 2 == 0) System.out.print("вправо ");
                else System.out.print("влево ");

            }

            System.out.println(String.format("\nУ %s закружилась голова.\n", Moomintroll.this.getName()));

        }

        public void turn(int degree) {
            this.angle = degree;
            System.out.println(String.format("%s повернул голову на %d градусов.\n", Moomintroll.this.getName(), this.angle));
        }

    }

    @Override
    public String toString(){
        return String.format("Объект типа: Moomintroll. Имя: %s. Локация: %s.", this.getName(), this.getLocation());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 9;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Moomintroll)) return false;

        Moomintroll obj2 = (Moomintroll) obj1;
        return (obj2.getName() == this.getName());
    }

}
