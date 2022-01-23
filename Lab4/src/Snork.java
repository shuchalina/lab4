public class Snork extends Hero {

    public Snork(String name, Location location) {
        super(name, location);
        System.out.println(String.format("Создан персонаж: %s.\n", this.getName()));
    }

    // найти яму
    public void findPit(Pit pit) {
        System.out.println(String.format("%s нашёл: %s.\n", this.getName(), pit.getPit()));
    }

    @Override
    public void changeLocation(Location location) {

        System.out.println(String.format("%s отправляется из '%s' в '%s'.\n", this.getName(), this.getLocation().getName(), location.getName()));
        this.setLocation(location);

    }

    public void say(String text, Adverb adverb) {
        System.out.println(String.format("%s %s сказал: %s\n", this.getName(), adverb.getTranslation(), text));
    }

    public void see (Moomintroll moomintroll, Adverb adverb) {
        System.out.println(String.format("%s %s посмотрел на: %s.\n", this.getName(), adverb.getTranslation(), moomintroll.getName()));
    }

    public void see (Pit pit, Adverb adverb) {
        System.out.println(String.format("%s %s посмотрел на: %s.\n", this.getName(), adverb.getTranslation(), pit.getPit()));
    }

    public class Head {

        int angle;

        public Head (int angle) {
            this.angle = angle;
            System.out.println(String.format("Создан объект голова %s. Угол поворота: %d.\n", Snork.this.getName(), this.angle));
        }

        public void turn(int degree) {
            this.angle = degree;
            System.out.println(String.format("%s повернул голову на %d градусов.\n", Snork.this.getName(), this.angle));
        }

    }

    public class Hand {

        public void wave(Adverb adverb) {
            System.out.println(String.format("%s %s замахал рукой.\n", Snork.this.getName(), adverb.getTranslation()));
        }

    }

    @Override
    public String toString(){
        return String.format("Объект типа: Snork. Имя: %s. Локация: %s.", this.getName(), this.getLocation());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 11;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Snork)) return false;

        Snork obj2 = (Snork) obj1;
        return (obj2.getName() == this.getName());
    }

}
