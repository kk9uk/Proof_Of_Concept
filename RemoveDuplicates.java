import java.util.Arrays;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).parallel().distinct().toArray();
    }
}
