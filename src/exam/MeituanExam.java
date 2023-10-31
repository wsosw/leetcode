package exam;

public class MeituanExam {

    // 美团题目五
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int m = in.nextInt();
//        in.nextLine();
//
//        if (m < n - 1) {
//            System.out.println(-1);
//        } else {
//
//
//
//        }
//
//
//
//    }


    // 美团题目四
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int length = in.nextInt();
//        int[] array = new int[length];
//        for (int i = 0; i < length; i++) {
//            array[i] = in.nextInt();
//        }
//
//        int
//
//
//
//
//
//    }


    // 美团题目三
//    private static class Monster {
//        int blood;
//        int power;
//
//        public Monster(){}
//        public Monster(int blood, int power) {
//            this.blood = blood;
//            this.power = power;
//        }
//    }
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int monsterCount = in.nextInt();
//        int playerBlood = in.nextInt();
//        int playerPower = in.nextInt();
//
//        Monster[] monsters = new Monster[monsterCount];
//        for (int i = 0; i < monsterCount; i++) {
//            monsters[i] = new Monster(in.nextInt(), 0);
//        }
//        for (int i = 0; i < monsterCount; i++) {
//            monsters[i].power = in.nextInt();
//        }
//
//        // 最多消灭多少个怪物
//
//        int count = 0;
//        for (Monster monster : monsters) {
//
//            if (playerBlood <= monster.blood || playerPower <= monster.power) continue;
//
//            playerBlood = monster.blood;
//            playerPower = monster.power;
//
//            count++;
//        }
//
//        System.out.println(count);
//    }


    // 美团题目二
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int x = in.nextInt();
//        int y = in.nextInt();
//
//        int len = (int) Math.ceil(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
//
//        if (len == 0) {
//            System.out.println(10);
//        } else if (len <= 10) {
//            System.out.println(11 - len);
//        } else {
//            System.out.println(0);
//        }
//
//    }


    // 美团题目一
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int raceCount = in.nextInt();
//
//        int[] races = new int[raceCount];
//        for (int i = 0; i < raceCount; i++) {
//            races[i] = in.nextInt();
//        }
//
//        if (raceCount == 0) {
//            System.out.println(0);
//        } else {
//
//            int score = races[0];
//            int lastRes = 0;
//            for (int i = 1; i < races.length; i++) {
//                if (races[i] == 1) lastRes = races[i-1];
//                if (races[i] == 0) lastRes = 0;
//                score = score + races[i] + lastRes;
//            }
//
//            System.out.println(score);
//        }
//
//    }


}
