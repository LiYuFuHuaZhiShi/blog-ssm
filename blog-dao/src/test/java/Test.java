import java.util.UUID;

public class Test {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    public static void main(String[] args) {
        String id = getUUID();
        System.out.println(id);
    }
}
