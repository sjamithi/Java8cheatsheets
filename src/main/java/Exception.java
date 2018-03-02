public class Exception extends Throwable {
        public static void main(String args[]) {
            try {
                int a[]= new int[10];
                a[10]= 10/0;
            }

            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Array index out of bounds in second catch block");
            }
            catch(ArithmeticException e)
            {
                System.out.println("Arithmetic exception in first catch block");
            }
        }

    }
