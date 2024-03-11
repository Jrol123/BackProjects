class Cat {
    private final String name;
    private final int age;
    private final String name_host;

    Cat(String name, int age, String name_host) {
        if (age < 0) {
            throw new Error("LowAge");
        }
        this.name = name;
        this.age = age;
        this.name_host = name_host;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void jump() {
    }

    public void meow() {
    }

    public void lick() {
    }
}
