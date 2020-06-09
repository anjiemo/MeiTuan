package com.example.meituan.utils;

public class Constants {

    public static final String SETTING = "setting";
    public static final String USER_ID = "userId";
    public static final String PASS_WORD = "password";
    public static final String ALL_PRICE = "allPrice";
    public static final String TYPE = "type";
    public static final String SHOP_NAME = "shopName";
    public static final String IS_LOGIN = "isLogin";
    public static String DISH_COUNT = "dishCount";
    public static String SHOPS_INFO = "[\n" +
            "{\"name\":\"雅府正红木桶鱼（杨柳河店）\",\"logo\":\"https://p0.meituan.net/600.600/bbia/ba15825ced07c5355571fed3d523fa961389918.jpg@220w_125h_1e_1c\",\"type\":0,\"address\":\"温江区杨柳西路中段205号\",\"sellNum\":999,\"startPrice\":12,\"phone\":15736666666,\"deliveryFee\":5},\n" +
            "{\"name\":\"麦香园（财大店）\",\"logo\":\"https://p1.meituan.net/600.600/shaitu/a39de0ebca510dbf4920caf0d56b270840376.jpg@220w_125h_1e_1c\",\"type\":0,\"address\":\"温江区南熏大道三段312-314\",\"sellNum\":456,\"startPrice\":15,\"phone\":1389999999,\"deliveryFee\":3},\n" +
            "{\"name\":\"牛宝贝养生黄牛肉（武侯立交桥店）\",\"logo\":\"https://img.meituan.net/msmerchant/fb3e8fa6d4cbe819c845dae9d8b5dd8981154.jpg@220w_125h_1e_1c\",\"type\":0,\"address\":\"武侯区武侯大道顺江段27号附8号\",\"sellNum\":454,\"startPrice\":40,\"phone\":1399645454,\"deliveryFee\":4},\n" +
            "{\"name\":\"蓉记香辣蟹爬爬虾（宽窄巷子店）\",\"logo\":\"https://img.meituan.net/600.600/msmerchant/0a816089db37310825af1b7d11db9e61282668.jpg@220w_125h_1e_1c\",\"type\":0,\"address\":\"金牛区西安中路40号豪瑞大厦1楼\",\"sellNum\":322,\"startPrice\":35,\"phone\":1825454848,\"deliveryFee\":6},\n" +
            "{\"name\":\"玛琪琳蛋糕面包（净居寺总店）\",\"logo\":\"https://img.meituan.net/600.600/msmerchant/1706b4f93a3dc52f9ffdcfdb5770fa6483169.jpg@220w_125h_1e_1c\",\"type\":1,\"address\":\"锦江区静居寺南街171号\",\"sellNum\":154,\"startPrice\":20,\"phone\":1650248484,\"deliveryFee\":5},\n" +
            "{\"name\":\"蓉和宫火锅\",\"logo\":\"https://p0.meituan.net/bbia/1268414280_1589343340224.jpeg@220w_125h_1e_1c\",\"type\":2,\"address\":\"新都区鸦红路雅雀口九组168号\",\"sellNum\":236,\"startPrice\":30,\"phone\":1655448484,\"deliveryFee\":5},\n" +
            "{\"name\":\"卡麦斯烘培\",\"logo\":\"https://img.meituan.net/600.600/msmerchant/fb1eb160c735f9243b0cd6d5cef41b5746023.jpg@220w_125h_1e_1c\",\"type\":3,\"address\":\"青羊区罗家碾街43号附16号（文汇苑旁）\",\"sellNum\":52,\"startPrice\":45,\"phone\":1650284284,\"deliveryFee\":3},\n" +
            "{\"name\":\"喜来蛋糕店（大石西路店）\",\"logo\":\"https://p0.meituan.net/600.600/deal/201301/25/175128_7646860.jpg@220w_125h_1e_1c\",\"type\":6,\"address\":\"武侯区百花正街65号\",\"sellNum\":234,\"startPrice\":30,\"phone\":1650246457,\"deliveryFee\":2},\n" +
            "\n" +
            "]";
    public static String USER_INFO = "[\n" +
            "{\"userId\":\"root\",\"password\":\"root\"},\n" +
            "{\"userId\":\"admin\",\"password\":\"admin\"}\n" +
            "]";

    public static String DISH_INFO = "[\n" +
            "{\"dishName\":\"鸡杂\",\"dishLogo\":\"https://p0.meituan.net/shaitu/5553e6c9e906aa7a7c3ee11bf584ce96147933.jpg\",\"starNum\":56,\"dishPrice\":9},\n" +
            "{\"dishName\":\"鸡血\",\"dishLogo\":\"https://p0.meituan.net/shaitu/eb0b7ea8b3a42d4eff60e4c1a3268bb9127859.jpg\",\"starNum\":32,\"dishPrice\":15},\n" +
            "{\"dishName\":\"柴火鸡\",\"dishLogo\":\"https://p0.meituan.net/shaitu/a971cc3850f0b4d07c93700e849e650094713.jpg\",\"starNum\":46,\"dishPrice\":32},\n" +
            "{\"dishName\":\"麻辣小龙虾\",\"dishLogo\":\"https://p0.meituan.net/shaitu/b052dbc6b5a47beab65ebcced420274e3055804.jpg\",\"starNum\":99,\"dishPrice\":30},\n" +
            "{\"dishName\":\"烤扇贝\",\"dishLogo\":\"https://qcloud.dpfile.com/pc/svgBh1U8RoQx5Px5WfywSB6GeaqAdyfNEygG1XlM4WZrOWv4oG-C7f_0BGsKfyjH5g_3Oo7Z9EXqcoVvW9arsw.jpg\",\"starNum\":25,\"dishPrice\":48},\n" +
            "{\"dishName\":\"香酥小龙虾\",\"dishLogo\":\"https://p0.meituan.net/xianfu/11371d1fcb22a4638c6611bb7ec744ef97909.jpg@130w_130h_1e_1c\",\"starNum\":53,\"dishPrice\":18},\n" +
            "{\"dishName\":\"水饺\",\"dishLogo\":\"https://qcloud.dpfile.com/pc/2iXJQFckdXFZ8oGxbO1NL_4czKAY9ZbCc8AeY8AEKSNMaAI_I2QB4EY3wdQzvPgW5g_3Oo7Z9EXqcoVvW9arsw.jpg\",\"starNum\":85,\"dishPrice\":12},\n" +
            "{\"dishName\":\"五花肉\",\"dishLogo\":\"https://p0.meituan.net/xianfu/28d4b0621faa89cc3e215eb3d29c7a5683462.jpg@130w_130h_1e_1c\",\"starNum\":33,\"dishPrice\":20},\n" +
            "{\"dishName\":\"烤黔鱼\",\"dishLogo\":\"https://qcloud.dpfile.com/pc/8-ucmChX-l_5Sf1zxFC7sDq8yvxXIBu29S5sXLrrbVqj0OCKsFhS1Xelvu4HSovt5g_3Oo7Z9EXqcoVvW9arsw.jpg\",\"starNum\":65,\"dishPrice\":78}\n" +
            "]";
}
