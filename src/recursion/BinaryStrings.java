public class BinaryStrings {
    public static void main(String[] args) {
        //binaryStrings("", 5);
        decimalStrings("", 4);
    }

    public static void binaryStrings(String slate, int n) {
        if (n == 0)
            System.out.print(slate+"\n");
        else {
            binaryStrings(slate + "0", n - 1);
            binaryStrings(slate + "1", n - 1);
        }
    }


    public static void decimalStrings(String slate, int n){
        if(n==0)
            System.out.print(slate+"\n");
        else{
            for(int i=0; i<=9; i++) {
                decimalStrings(
                        slate + String.valueOf(i),
                        n - 1
                );
            }
        }
    }
}
