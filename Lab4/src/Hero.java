public abstract class Hero {

    private String name;
    private Location location;

    public Hero (String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Location getLocation() {
        return this.location;
    }

    public void think() {
        System.out.println(String.format("%s задумался.\n", this.getName()));
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void changeLocation(Location location);

}

