package codeDesign.builder;

public class DoDoContact {
    private int age;
    private int safeID;
    private String name;
    private String address;

    public int getAge() {
        return age;
    }

    public int getSafeID() {
        return safeID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private int age = 0;
        private int safeID = 0;
        private String name = null;
        private String address = null;

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setSafeID(int safeID) {
            this.safeID = safeID;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public DoDoContact build() { // 构建返回一个新对象
            return new DoDoContact(this);
        }
    }

    private DoDoContact(Builder builder) {
        this.age = builder.age;
        this.safeID = builder.safeID;
        this.name = builder.name;
        this.address = builder.address;
    }
}
