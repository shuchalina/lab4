public class Jar {

    private Size size;
    private String position;

    public Jar(String position, Size size) {
        this.size = size;
        this.position = position;
        System.out.println(String.format("Создан объект: %s банка. Позиция: %s.\n", this.size.getTranslation(), this.getPosition()));
    }

    public String getPosition() { return this.position; }

    public void setPosition(String position) { this.position = position; }

    private Size getSize() {
        return this.size;
    }

    public String getJar() {
        return this.size.getTranslation() + " банка";
    }

    @Override
    public String toString(){
        return String.format("Объект типа: Jar. Название: банка. Размер: %s. Позиция: %s", this.getSize(), this.getPosition());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 8;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Jar)) return false;

        Jar obj2 = (Jar) obj1;
        return (obj2.getSize() == this.getSize());
    }

}
