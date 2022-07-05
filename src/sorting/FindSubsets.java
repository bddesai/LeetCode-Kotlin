package sorting;

public class FindSubsets {

    public static void main(String[] args) {
        System.out.println("Answer = "+find_subsets(20));
    }

    static double find_subsets(int n){
        if(n==0)
            return 1;

        return 2 * find_subsets(n-1);
    }

}
