
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



/**
 * 
 */
public class GridTravelerTabulation {


    /**
     * Say that you are a traveler on a 2D grid. You begin in the
     * top-left corner and your goal is to travel to the bottom-right
     * corner. You may only move down or right.
     * 
     * In how many ways can you travel to the goal on a grid with
     * dimensions m * n?
     * 
     * Use tabulation.
     * 
     * Time: O(m * n) - Space: O(m * n)
     */
    static long gridTraveler(int m, int n) {

        // **** sanity checks ****
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;

        // **** initialization ****
        long[][] table = new long[m + 1][n + 1];
        table[1][1] = 1;

        // **** traverse each row in table ****
        for (int r = 0; r < table.length; r++) {

            // **** traverse each column in this row in table ****
            for (int c = 0; c < table[r].length; c++) {

                // **** fill lower cell in table (if possible) ****
                if (r < m)
                    table[r + 1][c] += table[r][c];

                // **** fill right cell in table (if possible) ****
                if (c < n)
                    table[r][c + 1] += table[r][c];
            }
        }

        // ???? ????
        System.out.println("gridTraveler <<< table: ");
        for (int i = 0; i < table.length; i++)
            System.out.println(Arrays.toString(table[i]));

        // **** return answer ****
        return table[m][n];
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read m and n ****
        int[] mn = Arrays.stream(br.readLine().trim().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        // **** close buffered reader ****
        br.close();

        // **** create and set m and n ****
        int m = mn[0];
        int n = mn[1];

        // ???? ????
        System.out.println("main <<< m: " + m + " n: " + n);

        // **** generate and display answer ****
        System.out.println("main <<< gridTraveler: " + gridTraveler(m, n));
    }
}