package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class BaiduExam {

    /**
     * n个单位，每个单位身份为：人 或 兽 （知道自己身份，不知道别人身份），战斗力为ai
     * 两个单位相遇时，首先确认身份（可能告诉真，可能告诉假）
     * <p>
     * 判断：
     * 1. 如果单位为兽，另一单位为人 => 攻击
     * 2. 如果单位为人，另一单位为兽 => 权衡战斗力（大于兽时才攻击）
     * 3. 如果同为人或同为兽 => 什么也不做
     * <p>
     * 发生攻击时：
     * 1. 战斗力相等，同归于尽
     * 2. 战斗力不等，战斗力高的获胜
     * <p>
     * 小红进行了m轮遭遇，输出存活情况。
     */

    private static class Role {
        public String identity;
        public int energy;

        public Role() {

        }

        public Role(String identity, int energy) {
            this.identity = identity;
            this.energy = energy;
        }
    }

    private static class Battle {
        public int roleId1;
        public int roleId2;
        public String publishId1;
        public String publishId2;

        public Battle() {

        }

        public Battle(int roleId1, int roleId2, String publishId1, String publishId2) {
            this.roleId1 = roleId1;
            this.roleId2 = roleId2;
            this.publishId1 = publishId1;
            this.publishId2 = publishId2;
        }
    }


    // 正确率 0%， 他麻辣隔壁的
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int unitCount; // 单位数量
        int roundCount; // 回合数

        String[] nm = in.nextLine().split(" ");
        unitCount = Integer.parseInt(nm[0]);
        roundCount = Integer.parseInt(nm[1]);


        ArrayList<Role> roleList = new ArrayList<>();
        for (int i = 0; i < unitCount; i++) {
            String[] split = in.nextLine().split(" ");
            roleList.add(new Role(split[0], Integer.parseInt(split[1])));
        }

        ArrayList<Battle> battleList = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            String[] split = in.nextLine().split(" ");
            battleList.add(new Battle(Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]) - 1, split[2], split[3]));
        }

        for (Battle battle : battleList) {

            Role role1 = roleList.get(battle.roleId1);
            Role role2 = roleList.get(battle.roleId2);

            if (role1.energy != 0 && role2.energy != 0) {

                if ("monster".equals(role1.identity) && "human".equals(role2.identity) && "Y".equals(battle.publishId2)) {
                    if (role1.energy > role2.energy) role2.energy = 0;
                    if (role1.energy < role2.energy) role1.energy = 0;
                    if (role1.energy == role2.energy) {
                        role2.energy = 0;
                        role1.energy = 0;
                    }
                }

                if ("human".equals(role1.identity) && "monster".equals(role2.identity)) {
                    if ("Y".equals(battle.publishId1)) {
                        if (role2.energy > role1.energy) role1.energy = 0;
                        if (role2.energy < role1.energy) role2.energy = 0;
                        if (role1.energy == role2.energy) {
                            role1.energy = 0;
                            role2.energy = 0;
                        }
                    }
                    if ("N".equals(battle.publishId1)) {
                        if (role1.energy > role2.energy) role2.energy = 0;
                    }
                }

            }

        }

        StringBuilder res = new StringBuilder();
        for (Role role : roleList) {
            if (role.energy == 0) res.append("N");
            else res.append("Y");
        }

        System.out.println(res.toString());

    }











//    题目1 => 正确率 100%
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//
//        int[][] data = new int[4][n];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < n; j++) {
//                data[i][j] = in.nextInt();
//            }
//        }
//
//        int[] price_a = data[0];
//        int[] price_b = data[1];
//        int[] score_a = data[2];
//        int[] score_b = data[3];
//
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (price_a[i] < price_b[i] && score_a[i] > score_b[i]) {
//                count++;
//                continue;
//            }
//            if (price_b[i] < price_a[i] && score_b[i] > score_a[i]) {
//                count++;
//                continue;
//            }
//        }
//
//        System.out.println(count);
//
//    }

    // 题目2 => 正确率 100%
    // select
    //   *
    // from(
    //   select
    //     channel,
    //     count(1) as cnt
    //   from user_info
    //   where uid not in (select uid from order_log)
    //   group by channel
    // ) t1
    // order by cnt desc, channel
    // limit 1
    //

}
