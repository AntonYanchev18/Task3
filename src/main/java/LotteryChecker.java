public class LotteryChecker{
    public static void main(String[] args) {
        checkText("home", "home");
    }

    private static void checkText(String text, String text2) {
    if (text.equals(text2)) {
        System.out.println("Хвана голямата мистерия");
    } else {
        System.out.println("Тъпо браааат");
    }
    }
}
