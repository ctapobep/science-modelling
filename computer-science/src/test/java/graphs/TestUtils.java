package graphs;

public class TestUtils {

    public static Object[] arr(boolean ... bools) {
        Object[] result = new Object[bools.length];
        for(int i = 0; i < bools.length; i++) {
            result[i] = bools[i];
        }
        return result;
    }
}
