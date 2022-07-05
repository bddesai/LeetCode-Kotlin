package sorting;

public class DutchNationalFlag {
    public static void main(String args[]) {
        String str = "RGBBGRRBRGRRRBBBGGG";
        //String str = "RRRRGGGYYR";
        char[] charArray = str.toCharArray();
        dutch_flag_sort(charArray);

        for (char c : charArray) {
            System.out.println(c);
        }
    }

    static void dutch_flag_sort_lumoto(char[] balls){
        int n = balls.length;
        int r = -1, g = -1, b = 0;
    }

    // Hoare's
    static void dutch_flag_sort(char[] balls) {
        int n = balls.length;
        int r = 0, g = 0, b = n - 1;

        while (g <= b) {
            if (balls[g] == 'G') {
                g++;
            } else if (balls[g] == 'B') {
                swap(balls, g, b);
                b--;
            } else {
                swap(balls, r, g);
                g++;
                r++;
            }
        }
    }

    static void swap(char[] balls, int a, int b) {
        char temp = balls[a];
        balls[a] = balls[b];
        balls[b] = temp;
    }
}
