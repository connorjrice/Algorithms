package homeworkexamples;

/**
 *
 * @author Connor
 */
public class ch1n30 {
    
    public static void main(String[] args) {
        /**
        System.out.println("6:");
        doThing(6);
        System.out.println("8:");
        doThing(8);
        System.out.println("10:");
        doThing(10);
        */
        System.out.println("6:");
        doString(6);
        System.out.println("8:");
        doString(8);
        System.out.println("10:");
        doString(10);
    
    }
    public ch1n30() {
        
    }
    
    public static void doThing(int n) {
        int j = 1;
        int i = 0;
        while (j <= n/2) {
            i = 1;
            while (i <= j) {
                System.out.print(j);
                System.out.print(i);
                i++;
            }
            j++;
        }
        System.out.println();
    }
    
    public static void doString(int n) {
        int j = 1;
        int i = 0;
        String gr8 = "";
        while (j <= n/2) {
            i = 1;
            while (i <= j) {
                gr8 = gr8 + j + i;
                i++;                
            }
            j++;
        }
        System.out.println(gr8 + "\nLength: " +gr8.length());
    }
}
