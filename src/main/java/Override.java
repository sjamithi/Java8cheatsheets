
class Base {
    private void display() {
        System.out.println("Static or class method from Base");
    }

    public void print() {
        System.out.println("Non-static or instance method from Base");
    }
}

        class Derived extends Base {
            private void display() {
                System.out.println("Static or class method from Derived");
            }

            public void print() {
                System.out.println("Non-static or instance method from Derived");
            }


                public static void main(String args[]) {
                    Base obj = new Derived();
//                    obj.display();
                    obj.print();
                }
            }

