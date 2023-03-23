import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int[][] connections2 = {{0,1},{0,2},{0,3},{1,2}};
        System.out.println(new Solution().makeConnected(6,connections2));
    }
}

