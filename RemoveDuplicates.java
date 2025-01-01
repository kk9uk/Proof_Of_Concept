import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("removeDuplicates(): arr shouldn't be null");
        return Arrays.stream(arr).parallel().distinct().toArray();
    }
}
