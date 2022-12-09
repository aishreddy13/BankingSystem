import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        String rateString = "AD: 1.560274, SD: 1.428138, INR: 86.9087, USD: 1.057308";
        Map<String, String> collect = Arrays.stream(rateString.split(","))
                .map(s -> s.split(":", 2))
                .collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
        System.out.println(collect);
    }
}
