public class Head {

    private Hero host; // хозяин головы

    public Head(Hero host) {
        this.host = host;
        System.out.println(String.format("Создан объект: Голова. Хозяин: %s.\n", host.getName()));
    }

    public Hero getHost() {
        return this.host;
    }

    public void shake(int count) {

        System.out.print(String.format("%s потряс головой: ", this.getHost().getName()));
        int sum = 0;

        for (int i = 0; i < count; i ++) {

            if (i % 2 == 0) System.out.print("вправо ");
            else System.out.print("влево ");

        }

        System.out.println(String.format("У %s закружилась голова.\n", this.getHost().getName()));

    }

    @Override
    public String toString(){
        return String.format("Объект типа: Hand. Название: Голова. Хозяин: %s.", this.getHost().getName());
    }

    @Override
    public int hashCode(){
        return 100 * this.hashCode() + 4;
    }

    @Override
    public boolean equals(Object obj1) {
        if (!(obj1 instanceof Head)) return false;

        Head obj2 = (Head) obj1;
        return (obj2.getHost() == this.getHost());
    }

}
