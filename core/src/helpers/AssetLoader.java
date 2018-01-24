package helpers;

/**
 * Created by Hareesh on 3/11/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture eskimowalkdown, eskimowalkright, eskimowalkup, eskimowalkupright, eskimowalkdownright,
            penguinwalkdown, penguinwalkright, penguinwalkup, penguinwalkupright, penguinwalkdownright,
            map12, map34, map56, map78, map910, map1112, map1314, map1516, map1718, map1920, map2122, map2324, map2526, map2728, map2930,
            intro12, intro34, intro56, intro78, intro910, intro1112, intro1314, intro1516, intro1718, intro1920,
            intro2122, intro2324, intro2526, intro2728, intro2930, intro3132, intro3334, intro3536, intro3738, intro3940,
            intro4142, intro4344, intro4546, intro4748, intro4950, intro5152, intro5354, intro5556, intro5758, intro5960,
            intro6162, intro6364, intro6566, intro6768, intro6970, intro7172, intro7374, intro7576, intro7778, intro7980,
            intro8182, intro8384, intro8586, intro8788, intro8990, intro9192, intro9394, intro9596, intro9798,
            background,

    isaac1, isaac11, isaac2, isaac21, isaac3, isaac31, alex1, alex2,
            move;

    public static Animation
            ewalkdown, ewalkright, ewalkup, ewalkupright, ewalkdownright, efall,
            pwalkdown, pwalkright, pwalkup, pwalkupright, pwalkdownright,
            mapani, introani, introrepeatani,

    isaacFrontAni, isaacBackAni, isaacRightAni, isaacUpRightAni, isaacDownRightAni,
            walkDownAni, walkUpAni, walkRightAni, walkUpRightAni, walkDownRightAni,
            runDownAni, runUpAni, runRightAni, runUpRightAni, runDownRightAni,
            isaacTurnDownUpAni, isaacTauntAni,
            isaacSlidingUpAni, isaacSlidingDownAni, isaacSlidingLeftAni, isaacSlidingRightAni,
            isaacSlidingUpLeftAni, isaacSlidingUpRightAni, isaacSlidingDownLeftAni, isaacSlidingDownRightAni,
            isaacPsyDRAni, isaacPsyRAni, isaacPsyURAni, isaacPsyUAni, isaacPsyDAni,
            moveUpAni, moveRightAni, moveDownAni,
            isaacFallAni,

    alexFrontAni, alexBackAni, alexRightAni, alexUpRightAni, alexDownRightAni,
            alexWalkDownAni, alexWalkUpAni, alexWalkRightAni, alexWalkUpRightAni, alexWalkDownRightAni,
            alexRunDownAni, alexRunUpAni, alexRunRightAni, alexRunUpRightAni, alexRunDownRightAni;


    public static TextureRegion
            ewd1, ewd2, ewd3, ewd4, ewd5, ewd6, ewd7, ewd8, ewd9, ewd10, ewd11, ewd12, ewd13, ewd14, ewd15, ewd16,
            ewr1, ewr2, ewr3, ewr4, ewr5, ewr6, ewr7, ewr8, ewr9, ewr10, ewr11, ewr12, ewr13, ewr14, ewr15, ewr16,
            ewu1, ewu2, ewu3, ewu4, ewu5, ewu6, ewu7, ewu8, ewu9, ewu10, ewu11, ewu12, ewu13, ewu14, ewu15, ewu16,
            ewur1, ewur2, ewur3, ewur4, ewur5, ewur6, ewur7, ewur8, ewur9, ewur10, ewur11, ewur12, ewur13, ewur14, ewur15, ewur16,
            ewdr1, ewdr2, ewdr3, ewdr4, ewdr5, ewdr6, ewdr7, ewdr8, ewdr9, ewdr10, ewdr11, ewdr12, ewdr13, ewdr14, ewdr15, ewdr16,
            eupleft, eleft, edownleft,

    pwd1, pwd2, pwd3, pwd4, pwd5, pwd6, pwd7, pwd8, pwd9, pwd10, pwd11, pwd12, pwd13, pwd14, pwd15, pwd16,
            pwr1, pwr2, pwr3, pwr4, pwr5, pwr6, pwr7, pwr8, pwr9, pwr10, pwr11, pwr12, pwr13, pwr14, pwr15, pwr16,
            pwu1, pwu2, pwu3, pwu4, pwu5, pwu6, pwu7, pwu8, pwu9, pwu10, pwu11, pwu12, pwu13, pwu14, pwu15, pwu16,
            pwur1, pwur2, pwur3, pwur4, pwur5, pwur6, pwur7, pwur8, pwur9, pwur10, pwur11, pwur12, pwur13, pwur14, pwur15, pwur16,
            pwdr1, pwdr2, pwdr3, pwdr4, pwdr5, pwdr6, pwdr7, pwdr8, pwdr9, pwdr10, pwdr11, pwdr12, pwdr13, pwdr14, pwdr15, pwdr16,
            pupleft, pleft, pdownleft,

    map1, map2, map3, map4, map5, map6, map7, map8, map9, map10, map11, map012, map13, map14, map15,
            map16, map17, map18, map19, map20, map21, map22, map23, map24, map25, map26, map27, map28, map29, map30,

    intro1, intro2, intro3, intro4, intro5, intro6, intro7, intro8, intro9, intro10, intro11, intro012,
            intro13, intro14, intro15, intro16, intro17, intro18, intro19, intro20, intro21, intro22,
            intro23, intro24, intro25, intro26, intro27, intro28, intro29, intro30, intro31, intro32,
            intro33, intro034, intro35, intro36, intro37, intro38, intro39, intro40, intro41, intro42,
            intro43, intro44, intro45, intro46, intro47, intro48, intro49, intro50, intro51, intro52,
            intro53, intro54, intro55, intro056, intro57, intro58, intro59, intro60, intro61, intro62,
            intro63, intro64, intro65, intro66, intro067, intro68, intro69, intro70, intro71, intro72,
            intro73, intro74, intro75, intro76, intro77, intro078, intro79, intro80, intro81, intro82,
            intro83, intro84, intro85, intro86, intro87, intro88, intro089, intro90, intro91, intro92,
            intro93, intro94, intro95, intro96, intro97,

    isaac01, isaac02, isaac03, isaac4, isaac5, isaac6, isaac7, isaac8, isaac9, isaac10,
            isaac011, isaac12, isaac13, isaac14, isaac15, isaac16, isaac17, isaac18, isaac19, isaac20,
            isaac021, isaac22, isaac23, isaac24, isaac25, isaac26, isaac27, isaac28, isaac29, isaac30,
            isaac031, isaac32, isaac33, isaac34, isaac35, isaac36, isaac37, isaac38, isaac39, isaac40,
            isaac41, isaac42, isaac43, isaac44, isaac45, isaac46, isaac47, isaac48, isaac49, isaac50,
            isaac51, isaac52, isaac53, isaac54, isaac55, isaac56, isaac57, isaac58, isaac59, isaac60,
            isaac61, isaac62, isaac63, isaac64, isaac65, isaac66, isaac67, isaac68, isaac69, isaac70,
            isaac71, isaac72, isaac73, isaac74, isaac75, isaac76, isaac77, isaac78, isaac79, isaac80,
            isaac81, isaac82, isaac83, isaac84, isaac85, isaac86, isaac87, isaac88, isaac89, isaac90,
            isaac91, isaac92, isaac93, isaac94, isaac95, isaac96, isaac97, isaac98, isaac99, isaac100,
            isaac101, isaac102, isaac103, isaac104, isaac105, isaac106, isaac107, isaac108, isaac109, isaac110,
            isaac111, isaac112, isaac113, isaac114, isaac115, isaac116, isaac117, isaac118, isaac119, isaac120,
            isaac121, isaac122, isaac123, isaac124, isaac125, isaac126, isaac127, isaac128, isaac129, isaac130,
            isaac131, isaac132, isaac133, isaac134, isaac135, isaac136, isaac137, isaac138, isaac139, isaac140,
            isaac141, isaac142, isaac143, isaac144, isaac145, isaac146, isaac147, isaac148, isaac149, isaac150,
            isaac151, isaac152, isaac153, isaac154, isaac155, isaac156, isaac157, isaac158, isaac159, isaac160,
            isaac161, isaac162, isaac163, isaac164, isaac165, isaac166, isaac167, isaac168, isaac169, isaac170,
            isaac171, isaac172, isaac173, isaac174, isaac175, isaac176, isaac177, isaac178, isaac179, isaac180,
            isaac181, isaac182, isaac183, isaac184, isaac185, isaac186, isaac187, isaac188, isaac189, isaac190,
            isaac191, isaac192, isaac193, isaac194, isaac195, isaac196, isaac197, isaac198, isaac199, isaac200,
            isaac201, isaac202, isaac203, isaac204, isaac205, isaac206, isaac207, isaac208, isaac209, isaac210,
            isaacUpLeft, isaacLeft, isaacDownLeft,

    alex01, alex02, alex3, alex4, alex5, alex6, alex7, alex8, alex9, alex10,
            alex11, alex12, alex13, alex14, alex15, alex16, alex17, alex18, alex19, alex20,
            alex21, alex22, alex23, alex24, alex25, alex26, alex27, alex28, alex29, alex30,
            alex31, alex32, alex33, alex34, alex35,

    move1, move2, move3, move4, move5, move6;


    public static void load() {
        eskimowalkdown = new Texture(Gdx.files.internal("data/GoldenSun/sprites/eskimowalkdown.png"));
        eskimowalkright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/eskimowalkright.png"));
        eskimowalkup = new Texture(Gdx.files.internal("data/GoldenSun/sprites/eskimowalkup.png"));
        eskimowalkupright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/eskimowalkupright.png"));
        eskimowalkdownright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/eskimowalkdownright.png"));

        penguinwalkdown = new Texture(Gdx.files.internal("data/GoldenSun/sprites/penguinwalkdown.png"));
        penguinwalkright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/penguinwalkright.png"));
        penguinwalkup = new Texture(Gdx.files.internal("data/GoldenSun/sprites/penguinwalkup.png"));
        penguinwalkupright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/penguinwalkupright.png"));
        penguinwalkdownright = new Texture(Gdx.files.internal("data/GoldenSun/sprites/penguinwalkdownright.png"));

        map12 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map12.png"));
        map34 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map34.png"));
        map56 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map56.png"));
        map78 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map78.png"));
        map910 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map910.png"));
        map1112 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map1112.png"));
        map1314 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map1314.png"));
        map1516 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map1516.png"));
        map1718 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map1718.png"));
        map1920 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map1920.png"));
        map2122 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map2122.png"));
        map2324 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map2324.png"));
        map2526 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map2526.png"));
        map2728 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map2728.png"));
        map2930 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/map2930.png"));

        intro12 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro12.png"));
        intro34 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro34.png"));
        intro56 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro56.png"));
        intro78 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro78.png"));
        intro910 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro910.png"));
        intro1112 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro1112.png"));
        intro1314 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro1314.png"));
        intro1516 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro1516.png"));
        intro1718 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro1718.png"));
        intro1920 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro1920.png"));
        intro2122 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro2122.png"));
        intro2324 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro2324.png"));
        intro2526 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro2526.png"));
        intro2728 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro2728.png"));
        intro2930 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro2930.png"));
        intro3132 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro3132.png"));
        intro3334 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro3334.png"));
        intro3536 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro3536.png"));
        intro3738 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro3738.png"));
        intro3940 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro3940.png"));
        intro4142 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro4142.png"));
        intro4344 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro4344.png"));
        intro4546 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro4546.png"));
        intro4748 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro4748.png"));
        intro4950 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro4950.png"));
        intro5152 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro5152.png"));
        intro5354 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro5354.png"));
        intro5556 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro5556.png"));
        intro5758 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro5758.png"));
        intro5960 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro5960.png"));
        intro6162 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro6162.png"));
        intro6364 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro6364.png"));
        intro6566 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro6566.png"));
        intro6768 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro6768.png"));
        intro6970 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro6970.png"));
        intro7172 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro7172.png"));
        intro7374 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro7374.png"));
        intro7576 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro7576.png"));
        intro7778 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro7778.png"));
        intro7980 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro7980.png"));
        intro8182 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro8182.png"));
        intro8384 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro8384.png"));
        intro8586 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro8586.png"));
        intro8788 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro8788.png"));
        intro8990 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro8990.png"));
        intro9192 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro9192.png"));
        intro9394 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro9394.png"));
        intro9596 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro9596.png"));
        intro9798 = new Texture(Gdx.files.internal("data/GoldenSun/town/test/intro9798.png"));


        background = new Texture(Gdx.files.internal("data/GoldenSun/town/test/mountains+cloud.png"));


        isaac1 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac1.png"));
        isaac11 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac1-1.png"));
        isaac2 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac2.png"));
        isaac21 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac2-1.png"));
        isaac3 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac3.png"));
        isaac31 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/isaac3-1.png"));
        alex1 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/alex1.png"));
        alex2 = new Texture(Gdx.files.internal("data/GoldenSun/sprites/alex2.png"));
        move = new Texture(Gdx.files.internal("data/GoldenSun/psynergy/move.png"));

        eskimowalkdown.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        eskimowalkright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        eskimowalkup.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        eskimowalkupright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        eskimowalkdownright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        penguinwalkdown.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        penguinwalkright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        penguinwalkup.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        penguinwalkupright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        penguinwalkdownright.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        map12.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map34.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map56.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map78.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map910.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map1112.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map1314.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map1516.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map1718.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map1920.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map2122.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map2324.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map2526.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map2728.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        map2930.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        intro12.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro34.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro56.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro78.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro910.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro1112.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro1314.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro1516.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro1718.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro1920.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro2122.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro2324.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro2526.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro2728.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro2930.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro3132.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro3334.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro3536.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro3738.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro3940.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro4142.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro4344.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro4546.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro4748.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro4950.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro5152.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro5354.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro5556.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro5758.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro5960.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro6162.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro6364.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro6566.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro6768.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro6970.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro7172.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro7374.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro7576.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro7778.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro7980.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro8182.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro8384.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro8586.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro8788.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro8990.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro9192.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro9394.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro9596.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        intro9798.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        background.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        isaac1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        isaac11.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        isaac2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        isaac21.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        isaac3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        isaac31.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        alex1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        alex2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        move.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        ewd1 = new TextureRegion(eskimowalkdown, 0, 0, 256, 256);
        ewd2 = new TextureRegion(eskimowalkdown, 256, 0, 256, 256);
        ewd3 = new TextureRegion(eskimowalkdown, 512, 0, 256, 256);
        ewd4 = new TextureRegion(eskimowalkdown, 768, 0, 256, 256);
        ewd5 = new TextureRegion(eskimowalkdown, 0, 256, 256, 256);
        ewd6 = new TextureRegion(eskimowalkdown, 256, 256, 256, 256);
        ewd7 = new TextureRegion(eskimowalkdown, 512, 256, 256, 256);
        ewd8 = new TextureRegion(eskimowalkdown, 768, 256, 256, 256);
        ewd9 = new TextureRegion(eskimowalkdown, 0, 512, 256, 256);
        ewd10 = new TextureRegion(eskimowalkdown, 256, 512, 256, 256);
        ewd11 = new TextureRegion(eskimowalkdown, 512, 512, 256, 256);
        ewd12 = new TextureRegion(eskimowalkdown, 768, 512, 256, 256);
        ewd13 = new TextureRegion(eskimowalkdown, 0, 768, 256, 256);
        ewd14 = new TextureRegion(eskimowalkdown, 256, 768, 256, 256);
        ewd15 = new TextureRegion(eskimowalkdown, 512, 768, 256, 256);
        ewd16 = new TextureRegion(eskimowalkdown, 768, 768, 256, 256);

        ewr1 = new TextureRegion(eskimowalkright, 0, 0, 256, 256);
        ewr2 = new TextureRegion(eskimowalkright, 256, 0, 256, 256);
        ewr3 = new TextureRegion(eskimowalkright, 512, 0, 256, 256);
        ewr4 = new TextureRegion(eskimowalkright, 768, 0, 256, 256);
        ewr5 = new TextureRegion(eskimowalkright, 0, 256, 256, 256);
        ewr6 = new TextureRegion(eskimowalkright, 256, 256, 256, 256);
        ewr7 = new TextureRegion(eskimowalkright, 512, 256, 256, 256);
        ewr8 = new TextureRegion(eskimowalkright, 768, 256, 256, 256);
        ewr9 = new TextureRegion(eskimowalkright, 0, 512, 256, 256);
        ewr10 = new TextureRegion(eskimowalkright, 256, 512, 256, 256);
        ewr11 = new TextureRegion(eskimowalkright, 512, 512, 256, 256);
        ewr12 = new TextureRegion(eskimowalkright, 768, 512, 256, 256);
        ewr13 = new TextureRegion(eskimowalkright, 0, 768, 256, 256);
        ewr14 = new TextureRegion(eskimowalkright, 256, 768, 256, 256);
        ewr15 = new TextureRegion(eskimowalkright, 512, 768, 256, 256);
        ewr16 = new TextureRegion(eskimowalkright, 768, 768, 256, 256);

        ewu1 = new TextureRegion(eskimowalkup, 0, 0, 256, 256);
        ewu2 = new TextureRegion(eskimowalkup, 256, 0, 256, 256);
        ewu3 = new TextureRegion(eskimowalkup, 512, 0, 256, 256);
        ewu4 = new TextureRegion(eskimowalkup, 768, 0, 256, 256);
        ewu5 = new TextureRegion(eskimowalkup, 0, 256, 256, 256);
        ewu6 = new TextureRegion(eskimowalkup, 256, 256, 256, 256);
        ewu7 = new TextureRegion(eskimowalkup, 512, 256, 256, 256);
        ewu8 = new TextureRegion(eskimowalkup, 768, 256, 256, 256);
        ewu9 = new TextureRegion(eskimowalkup, 0, 512, 256, 256);
        ewu10 = new TextureRegion(eskimowalkup, 256, 512, 256, 256);
        ewu11 = new TextureRegion(eskimowalkup, 512, 512, 256, 256);
        ewu12 = new TextureRegion(eskimowalkup, 768, 512, 256, 256);
        ewu13 = new TextureRegion(eskimowalkup, 0, 768, 256, 256);
        ewu14 = new TextureRegion(eskimowalkup, 256, 768, 256, 256);
        ewu15 = new TextureRegion(eskimowalkup, 512, 768, 256, 256);
        ewu16 = new TextureRegion(eskimowalkup, 768, 768, 256, 256);

        ewur1 = new TextureRegion(eskimowalkupright, 0, 0, 256, 256);
        ewur2 = new TextureRegion(eskimowalkupright, 256, 0, 256, 256);
        ewur3 = new TextureRegion(eskimowalkupright, 512, 0, 256, 256);
        ewur4 = new TextureRegion(eskimowalkupright, 768, 0, 256, 256);
        ewur5 = new TextureRegion(eskimowalkupright, 0, 256, 256, 256);
        ewur6 = new TextureRegion(eskimowalkupright, 256, 256, 256, 256);
        ewur7 = new TextureRegion(eskimowalkupright, 512, 256, 256, 256);
        ewur8 = new TextureRegion(eskimowalkupright, 768, 256, 256, 256);
        ewur9 = new TextureRegion(eskimowalkupright, 0, 512, 256, 256);
        ewur10 = new TextureRegion(eskimowalkupright, 256, 512, 256, 256);
        ewur11 = new TextureRegion(eskimowalkupright, 512, 512, 256, 256);
        ewur12 = new TextureRegion(eskimowalkupright, 768, 512, 256, 256);
        ewur13 = new TextureRegion(eskimowalkupright, 0, 768, 256, 256);
        ewur14 = new TextureRegion(eskimowalkupright, 256, 768, 256, 256);
        ewur15 = new TextureRegion(eskimowalkupright, 512, 768, 256, 256);
        ewur16 = new TextureRegion(eskimowalkupright, 768, 768, 256, 256);

        ewdr1 = new TextureRegion(eskimowalkdownright, 0, 0, 256, 256);
        ewdr2 = new TextureRegion(eskimowalkdownright, 256, 0, 256, 256);
        ewdr3 = new TextureRegion(eskimowalkdownright, 512, 0, 256, 256);
        ewdr4 = new TextureRegion(eskimowalkdownright, 768, 0, 256, 256);
        ewdr5 = new TextureRegion(eskimowalkdownright, 0, 256, 256, 256);
        ewdr6 = new TextureRegion(eskimowalkdownright, 256, 256, 256, 256);
        ewdr7 = new TextureRegion(eskimowalkdownright, 512, 256, 256, 256);
        ewdr8 = new TextureRegion(eskimowalkdownright, 768, 256, 256, 256);
        ewdr9 = new TextureRegion(eskimowalkdownright, 0, 512, 256, 256);
        ewdr10 = new TextureRegion(eskimowalkdownright, 256, 512, 256, 256);
        ewdr11 = new TextureRegion(eskimowalkdownright, 512, 512, 256, 256);
        ewdr12 = new TextureRegion(eskimowalkdownright, 768, 512, 256, 256);
        ewdr13 = new TextureRegion(eskimowalkdownright, 0, 768, 256, 256);
        ewdr14 = new TextureRegion(eskimowalkdownright, 256, 768, 256, 256);
        ewdr15 = new TextureRegion(eskimowalkdownright, 512, 768, 256, 256);
        ewdr16 = new TextureRegion(eskimowalkdownright, 768, 768, 256, 256);

        pwd1 = new TextureRegion(penguinwalkdown, 0, 0, 256, 256);
        pwd2 = new TextureRegion(penguinwalkdown, 256, 0, 256, 256);
        pwd3 = new TextureRegion(penguinwalkdown, 512, 0, 256, 256);
        pwd4 = new TextureRegion(penguinwalkdown, 768, 0, 256, 256);
        pwd5 = new TextureRegion(penguinwalkdown, 0, 256, 256, 256);
        pwd6 = new TextureRegion(penguinwalkdown, 256, 256, 256, 256);
        pwd7 = new TextureRegion(penguinwalkdown, 512, 256, 256, 256);
        pwd8 = new TextureRegion(penguinwalkdown, 768, 256, 256, 256);
        pwd9 = new TextureRegion(penguinwalkdown, 0, 512, 256, 256);
        pwd10 = new TextureRegion(penguinwalkdown, 256, 512, 256, 256);
        pwd11 = new TextureRegion(penguinwalkdown, 512, 512, 256, 256);
        pwd12 = new TextureRegion(penguinwalkdown, 768, 512, 256, 256);
        pwd13 = new TextureRegion(penguinwalkdown, 0, 768, 256, 256);
        pwd14 = new TextureRegion(penguinwalkdown, 256, 768, 256, 256);
        pwd15 = new TextureRegion(penguinwalkdown, 512, 768, 256, 256);
        pwd16 = new TextureRegion(penguinwalkdown, 768, 768, 256, 256);

        pwr1 = new TextureRegion(penguinwalkright, 0, 0, 256, 256);
        pwr2 = new TextureRegion(penguinwalkright, 256, 0, 256, 256);
        pwr3 = new TextureRegion(penguinwalkright, 512, 0, 256, 256);
        pwr4 = new TextureRegion(penguinwalkright, 768, 0, 256, 256);
        pwr5 = new TextureRegion(penguinwalkright, 0, 256, 256, 256);
        pwr6 = new TextureRegion(penguinwalkright, 256, 256, 256, 256);
        pwr7 = new TextureRegion(penguinwalkright, 512, 256, 256, 256);
        pwr8 = new TextureRegion(penguinwalkright, 768, 256, 256, 256);
        pwr9 = new TextureRegion(penguinwalkright, 0, 512, 256, 256);
        pwr10 = new TextureRegion(penguinwalkright, 256, 512, 256, 256);
        pwr11 = new TextureRegion(penguinwalkright, 512, 512, 256, 256);
        pwr12 = new TextureRegion(penguinwalkright, 768, 512, 256, 256);
        pwr13 = new TextureRegion(penguinwalkright, 0, 768, 256, 256);
        pwr14 = new TextureRegion(penguinwalkright, 256, 768, 256, 256);
        pwr15 = new TextureRegion(penguinwalkright, 512, 768, 256, 256);
        pwr16 = new TextureRegion(penguinwalkright, 768, 768, 256, 256);

        pwu1 = new TextureRegion(penguinwalkup, 0, 0, 256, 256);
        pwu2 = new TextureRegion(penguinwalkup, 256, 0, 256, 256);
        pwu3 = new TextureRegion(penguinwalkup, 512, 0, 256, 256);
        pwu4 = new TextureRegion(penguinwalkup, 768, 0, 256, 256);
        pwu5 = new TextureRegion(penguinwalkup, 0, 256, 256, 256);
        pwu6 = new TextureRegion(penguinwalkup, 256, 256, 256, 256);
        pwu7 = new TextureRegion(penguinwalkup, 512, 256, 256, 256);
        pwu8 = new TextureRegion(penguinwalkup, 768, 256, 256, 256);
        pwu9 = new TextureRegion(penguinwalkup, 0, 512, 256, 256);
        pwu10 = new TextureRegion(penguinwalkup, 256, 512, 256, 256);
        pwu11 = new TextureRegion(penguinwalkup, 512, 512, 256, 256);
        pwu12 = new TextureRegion(penguinwalkup, 768, 512, 256, 256);
        pwu13 = new TextureRegion(penguinwalkup, 0, 768, 256, 256);
        pwu14 = new TextureRegion(penguinwalkup, 256, 768, 256, 256);
        pwu15 = new TextureRegion(penguinwalkup, 512, 768, 256, 256);
        pwu16 = new TextureRegion(penguinwalkup, 768, 768, 256, 256);

        pwur1 = new TextureRegion(penguinwalkupright, 0, 0, 256, 256);
        pwur2 = new TextureRegion(penguinwalkupright, 256, 0, 256, 256);
        pwur3 = new TextureRegion(penguinwalkupright, 512, 0, 256, 256);
        pwur4 = new TextureRegion(penguinwalkupright, 768, 0, 256, 256);
        pwur5 = new TextureRegion(penguinwalkupright, 0, 256, 256, 256);
        pwur6 = new TextureRegion(penguinwalkupright, 256, 256, 256, 256);
        pwur7 = new TextureRegion(penguinwalkupright, 512, 256, 256, 256);
        pwur8 = new TextureRegion(penguinwalkupright, 768, 256, 256, 256);
        pwur9 = new TextureRegion(penguinwalkupright, 0, 512, 256, 256);
        pwur10 = new TextureRegion(penguinwalkupright, 256, 512, 256, 256);
        pwur11 = new TextureRegion(penguinwalkupright, 512, 512, 256, 256);
        pwur12 = new TextureRegion(penguinwalkupright, 768, 512, 256, 256);
        pwur13 = new TextureRegion(penguinwalkupright, 0, 768, 256, 256);
        pwur14 = new TextureRegion(penguinwalkupright, 256, 768, 256, 256);
        pwur15 = new TextureRegion(penguinwalkupright, 512, 768, 256, 256);
        pwur16 = new TextureRegion(penguinwalkupright, 768, 768, 256, 256);

        pwdr1 = new TextureRegion(penguinwalkdownright, 0, 0, 256, 256);
        pwdr2 = new TextureRegion(penguinwalkdownright, 256, 0, 256, 256);
        pwdr3 = new TextureRegion(penguinwalkdownright, 512, 0, 256, 256);
        pwdr4 = new TextureRegion(penguinwalkdownright, 768, 0, 256, 256);
        pwdr5 = new TextureRegion(penguinwalkdownright, 0, 256, 256, 256);
        pwdr6 = new TextureRegion(penguinwalkdownright, 256, 256, 256, 256);
        pwdr7 = new TextureRegion(penguinwalkdownright, 512, 256, 256, 256);
        pwdr8 = new TextureRegion(penguinwalkdownright, 768, 256, 256, 256);
        pwdr9 = new TextureRegion(penguinwalkdownright, 0, 512, 256, 256);
        pwdr10 = new TextureRegion(penguinwalkdownright, 256, 512, 256, 256);
        pwdr11 = new TextureRegion(penguinwalkdownright, 512, 512, 256, 256);
        pwdr12 = new TextureRegion(penguinwalkdownright, 768, 512, 256, 256);
        pwdr13 = new TextureRegion(penguinwalkdownright, 0, 768, 256, 256);
        pwdr14 = new TextureRegion(penguinwalkdownright, 256, 768, 256, 256);
        pwdr15 = new TextureRegion(penguinwalkdownright, 512, 768, 256, 256);
        pwdr16 = new TextureRegion(penguinwalkdownright, 768, 768, 256, 256);

        map1 = new TextureRegion(map12, 0,0,800,480);
        map2 = new TextureRegion(map12, 0,480,800,480);
        map3 = new TextureRegion(map34, 0,0,800,480);
        map4 = new TextureRegion(map34, 0,480,800,480);
        map5 = new TextureRegion(map56, 0,0,800,480);
        map6 = new TextureRegion(map56, 0,480,800,480);
        map7 = new TextureRegion(map78, 0,0,800,480);
        map8 = new TextureRegion(map78, 0,480,800,480);
        map9 = new TextureRegion(map910, 0,0,800,480);
        map10 = new TextureRegion(map910, 0,480,800,480);
        map11 = new TextureRegion(map1112, 0,0,800,480);
        map012 = new TextureRegion(map1112, 0,480,800,480);
        map13 = new TextureRegion(map1314, 0,0,800,480);
        map14 = new TextureRegion(map1314, 0,480,800,480);
        map15 = new TextureRegion(map1516, 0,0,800,480);
        map16 = new TextureRegion(map1516, 0,480,800,480);
        map17 = new TextureRegion(map1718, 0,0,800,480);
        map18 = new TextureRegion(map1718, 0,480,800,480);
        map19 = new TextureRegion(map1920, 0,0,800,480);
        map20 = new TextureRegion(map1920, 0,480,800,480);
        map21 = new TextureRegion(map2122, 0,0,800,480);
        map22 = new TextureRegion(map2122, 0,480,800,480);
        map23 = new TextureRegion(map2324, 0,0,800,480);
        map24 = new TextureRegion(map2324, 0,480,800,480);
        map25 = new TextureRegion(map2526, 0,0,800,480);
        map26 = new TextureRegion(map2526, 0,480,800,480);
        map27 = new TextureRegion(map2728, 0,0,800,480);
        map28 = new TextureRegion(map2728, 0,480,800,480);
        map29 = new TextureRegion(map2930, 0,0,800,480);
        map30 = new TextureRegion(map2930, 0,480,800,480);

        intro1 = new TextureRegion(intro12, 0,0,800,480);
        intro2 = new TextureRegion(intro12, 0,480,800,480);
        intro3 = new TextureRegion(intro34, 0,0,800,480);
        intro4 = new TextureRegion(intro34, 0,480,800,480);
        intro5 = new TextureRegion(intro56, 0,0,800,480);
        intro6 = new TextureRegion(intro56, 0,480,800,480);
        intro7 = new TextureRegion(intro78, 0,0,800,480);
        intro8 = new TextureRegion(intro78, 0,480,800,480);
        intro9 = new TextureRegion(intro910, 0,0,800,480);
        intro10 = new TextureRegion(intro910, 0,480,800,480);
        intro11 = new TextureRegion(intro1112, 0,0,800,480);
        intro012 = new TextureRegion(intro1112, 0,480,800,480);
        intro13 = new TextureRegion(intro1314, 0,0,800,480);
        intro14 = new TextureRegion(intro1314, 0,480,800,480);
        intro15 = new TextureRegion(intro1516, 0,0,800,480);
        intro16 = new TextureRegion(intro1516, 0,480,800,480);
        intro17 = new TextureRegion(intro1718, 0,0,800,480);
        intro18 = new TextureRegion(intro1718, 0,480,800,480);
        intro19 = new TextureRegion(intro1920, 0,0,800,480);
        intro20 = new TextureRegion(intro1920, 0,480,800,480);
        intro21 = new TextureRegion(intro2122, 0,0,800,480);
        intro22 = new TextureRegion(intro2122, 0,480,800,480);
        intro23 = new TextureRegion(intro2324, 0,0,800,480);
        intro24 = new TextureRegion(intro2324, 0,480,800,480);
        intro25 = new TextureRegion(intro2526, 0,0,800,480);
        intro26 = new TextureRegion(intro2526, 0,480,800,480);
        intro27 = new TextureRegion(intro2728, 0,0,800,480);
        intro28 = new TextureRegion(intro2728, 0,480,800,480);
        intro29 = new TextureRegion(intro2930, 0,0,800,480);
        intro30 = new TextureRegion(intro2930, 0,480,800,480);
        intro31 = new TextureRegion(intro3132, 0,0,800,480);
        intro32 = new TextureRegion(intro3132, 0,480,800,480);
        intro33 = new TextureRegion(intro3334, 0,0,800,480);
        intro034 = new TextureRegion(intro3334, 0,480,800,480);
        intro35 = new TextureRegion(intro3536, 0,0,800,480);
        intro36 = new TextureRegion(intro3536, 0,480,800,480);
        intro37 = new TextureRegion(intro3738, 0,0,800,480);
        intro38 = new TextureRegion(intro3738, 0,480,800,480);
        intro39 = new TextureRegion(intro3940, 0,0,800,480);
        intro40 = new TextureRegion(intro3940, 0,480,800,480);
        intro41 = new TextureRegion(intro4142, 0,0,800,480);
        intro42 = new TextureRegion(intro4142, 0,480,800,480);
        intro43 = new TextureRegion(intro4344, 0,0,800,480);
        intro44 = new TextureRegion(intro4344, 0,480,800,480);
        intro45 = new TextureRegion(intro4546, 0,0,800,480);
        intro46 = new TextureRegion(intro4546, 0,480,800,480);
        intro47 = new TextureRegion(intro4748, 0,0,800,480);
        intro48 = new TextureRegion(intro4748, 0,480,800,480);
        intro49 = new TextureRegion(intro4950, 0,0,800,480);
        intro50 = new TextureRegion(intro4950, 0,480,800,480);
        intro51 = new TextureRegion(intro5152, 0,0,800,480);
        intro52 = new TextureRegion(intro5152, 0,480,800,480);
        intro53 = new TextureRegion(intro5354, 0,0,800,480);
        intro54 = new TextureRegion(intro5354, 0,480,800,480);
        intro55 = new TextureRegion(intro5556, 0,0,800,480);
        intro056 = new TextureRegion(intro5556, 0,480,800,480);
        intro57 = new TextureRegion(intro5758, 0,0,800,480);
        intro58 = new TextureRegion(intro5758, 0,480,800,480);
        intro59 = new TextureRegion(intro5960, 0,0,800,480);
        intro60 = new TextureRegion(intro5960, 0,480,800,480);
        intro61 = new TextureRegion(intro6162, 0,0,800,480);
        intro62 = new TextureRegion(intro6162, 0,480,800,480);
        intro63 = new TextureRegion(intro6364, 0,0,800,480);
        intro64 = new TextureRegion(intro6364, 0,480,800,480);
        intro65 = new TextureRegion(intro6566, 0,0,800,480);
        intro66 = new TextureRegion(intro6566, 0,480,800,480);
        intro067 = new TextureRegion(intro6768, 0,0,800,480);
        intro68 = new TextureRegion(intro6768, 0,480,800,480);
        intro69 = new TextureRegion(intro6970, 0,0,800,480);
        intro70 = new TextureRegion(intro6970, 0,480,800,480);
        intro71 = new TextureRegion(intro7172, 0,0,800,480);
        intro72 = new TextureRegion(intro7172, 0,480,800,480);
        intro73 = new TextureRegion(intro7374, 0,0,800,480);
        intro74 = new TextureRegion(intro7374, 0,480,800,480);
        intro75 = new TextureRegion(intro7576, 0,0,800,480);
        intro76 = new TextureRegion(intro7576, 0,480,800,480);
        intro77 = new TextureRegion(intro7778, 0,0,800,480);
        intro078 = new TextureRegion(intro7778, 0,480,800,480);
        intro79 = new TextureRegion(intro7980, 0,0,800,480);
        intro80 = new TextureRegion(intro7980, 0,480,800,480);
        intro81 = new TextureRegion(intro8182, 0,0,800,480);
        intro82 = new TextureRegion(intro8182, 0,480,800,480);
        intro83 = new TextureRegion(intro8384, 0,0,800,480);
        intro84 = new TextureRegion(intro8384, 0,480,800,480);
        intro85 = new TextureRegion(intro8586, 0,0,800,480);
        intro86 = new TextureRegion(intro8586, 0,480,800,480);
        intro87 = new TextureRegion(intro8788, 0,0,800,480);
        intro88 = new TextureRegion(intro8788, 0,480,800,480);
        intro089 = new TextureRegion(intro8990, 0,0,800,480);
        intro90 = new TextureRegion(intro8990, 0,480,800,480);
        intro91 = new TextureRegion(intro9192, 0,0,800,480);
        intro92 = new TextureRegion(intro9192, 0,480,800,480);
        intro93 = new TextureRegion(intro9394, 0,0,800,480);
        intro94 = new TextureRegion(intro9394, 0,480,800,480);
        intro95 = new TextureRegion(intro9596, 0,0,800,480);
        intro96 = new TextureRegion(intro9596, 0,480,800,480);
        intro97 = new TextureRegion(intro9798, 0,0,800,480);

        alex01 = new TextureRegion(alex1, 0,0,128,128);
        alex02 = new TextureRegion(alex1, 128,0,128,128);
        alex3 = new TextureRegion(alex1, 256,0,128,128);
        alex4 = new TextureRegion(alex1, 0,128,128,128);
        alex5 = new TextureRegion(alex1, 128,128,128,128);
        alex6 = new TextureRegion(alex1, 256,128,128,128);
        alex7 = new TextureRegion(alex1, 0,256,128,128);
        alex8 = new TextureRegion(alex1, 128,256,128,128);
        alex9 = new TextureRegion(alex1, 256,256,128,128);
        alex10 = new TextureRegion(alex1, 0,384,128,128);
        alex11 = new TextureRegion(alex1, 128,384,128,128);
        alex12 = new TextureRegion(alex1, 256,384,128,128);
        alex13 = new TextureRegion(alex1, 0,512,128,128);
        alex14 = new TextureRegion(alex1, 128,512,128,128);
        alex15 = new TextureRegion(alex1, 256,512,128,128);
        alex16 = new TextureRegion(alex1, 0,640,128,128);
        alex17 = new TextureRegion(alex1, 128,640,128,128);
        alex18 = new TextureRegion(alex1, 256,640,128,128);
        alex19 = new TextureRegion(alex2, 0,0,128,128);
        alex20 = new TextureRegion(alex2, 128,0,128,128);
        alex21 = new TextureRegion(alex2, 256,0,128,128);
        alex22 = new TextureRegion(alex2, 0,128,128,128);
        alex23 = new TextureRegion(alex2, 128,128,128,128);
        alex24 = new TextureRegion(alex2, 256,128,128,128);
        alex25 = new TextureRegion(alex2, 0,256,128,128);
        alex26 = new TextureRegion(alex2, 128,256,128,128);
        alex27 = new TextureRegion(alex2, 256,256,128,128);
        alex28 = new TextureRegion(alex2, 0,384,128,128);
        alex29 = new TextureRegion(alex2, 128,384,128,128);
        alex30 = new TextureRegion(alex2, 256,384,128,128);
        alex31 = new TextureRegion(alex2, 0,512,128,128);
        alex32 = new TextureRegion(alex2, 128,512,128,128);
        alex33 = new TextureRegion(alex2, 256,512,128,128);
        alex34 = new TextureRegion(alex2, 0,640,128,128);
        alex35 = new TextureRegion(alex2, 128,640,128,128);

        //--------------------Alex Standing---------------------------------
        TextureRegion[] alexRight = {alex3,alex3,alex3,alex6,alex3,alex3,alex3,alex6,alex3,alex3,alex12,alex12,alex12,alex12,alex12};
        alexRightAni = new Animation(0.06f, alexRight);
        alexRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] alexUpRight = {alex01,alex01,alex01,alex4,alex01,alex01,alex01,alex4,alex01,alex01,alex10,alex10,alex10,alex10,alex10};
        alexUpRightAni = new Animation(0.06f, alexUpRight);
        alexUpRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] alexDownRight = {alex02,alex02,alex02,alex5,alex02,alex02,alex02,alex5,alex02,alex02,alex11,alex11,alex11,alex11,alex11};
        alexDownRightAni = new Animation(0.06f, alexDownRight);
        alexDownRightAni.setPlayMode(Animation.PlayMode.LOOP);


        //--------------------Alex Walking---------------------------------
        TextureRegion[] alexWalkRight = {alex17, alex20, alex23, alex26, alex29, alex32};
        alexWalkRightAni = new Animation(0.06f, alexWalkRight);
        alexWalkRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] alexWalkUpRight = {alex15, alex18, alex21, alex24, alex27, alex30};
        alexWalkUpRightAni = new Animation(0.06f, alexWalkUpRight);
        alexWalkUpRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] alexWalkDownRight = {alex16, alex19, alex22, alex25, alex28, alex31};
        alexWalkDownRightAni = new Animation(0.06f, alexWalkDownRight);
        alexWalkDownRightAni.setPlayMode(Animation.PlayMode.LOOP);

        isaac01 = new TextureRegion(isaac1, 0,0,128,128);
        isaac02 = new TextureRegion(isaac1, 128,0,128,128);
        isaac03 = new TextureRegion(isaac1, 256,0,128,128);
        isaac4 = new TextureRegion(isaac1, 384,0,128,128);
        isaac5 = new TextureRegion(isaac1, 512,0,128,128);
        isaac6 = new TextureRegion(isaac1, 0,128,128,128);
        isaac7 = new TextureRegion(isaac1, 128,128,128,128);
        isaac8 = new TextureRegion(isaac1, 256,128,128,128);
        isaac9 = new TextureRegion(isaac1, 384,128,128,128);
        isaac10 = new TextureRegion(isaac1, 512,128,128,128);
        isaac011 = new TextureRegion(isaac1, 0,256,128,128);
        isaac12 = new TextureRegion(isaac1, 128,256,128,128);
        isaac13 = new TextureRegion(isaac1, 256,256,128,128);
        isaac14 = new TextureRegion(isaac1, 384,256,128,128);
        isaac15 = new TextureRegion(isaac1, 512,256,128,128);
        isaac16 = new TextureRegion(isaac1, 0,384,128,128);
        isaac17 = new TextureRegion(isaac1, 128,384,128,128);
        isaac18 = new TextureRegion(isaac1, 256,384,128,128);
        isaac19 = new TextureRegion(isaac1, 384,384,128,128);
        isaac20 = new TextureRegion(isaac1, 512,384,128,128);
        isaac021 = new TextureRegion(isaac1, 0,512,128,128);
        isaac22 = new TextureRegion(isaac1, 128,512,128,128);
        isaac23 = new TextureRegion(isaac1, 256,512,128,128);
        isaac24 = new TextureRegion(isaac1, 384,512,128,128);
        isaac25 = new TextureRegion(isaac1, 512,512,128,128);
        isaac26 = new TextureRegion(isaac1, 0,641,128,128);
        isaac27 = new TextureRegion(isaac1, 128,640,128,128);
        isaac28 = new TextureRegion(isaac1, 256,640,128,128);
        isaac29 = new TextureRegion(isaac1, 384,640,128,128);
        isaac30 = new TextureRegion(isaac1, 512,640,128,128);
        isaac031 = new TextureRegion(isaac1, 0,768,128,128);
        isaac32 = new TextureRegion(isaac1, 128,768,128,128);
        isaac33 = new TextureRegion(isaac1, 256,768,128,128);
        isaac34 = new TextureRegion(isaac1, 384,768,128,128);
        isaac35 = new TextureRegion(isaac1, 512,768,128,128);
        isaac36 = new TextureRegion(isaac1, 0,896,128,128);
        isaac37 = new TextureRegion(isaac1, 128,896,128,128);
        isaac38 = new TextureRegion(isaac1, 256,896,128,128);
        isaac39 = new TextureRegion(isaac1, 384,896,128,128);
        isaac40 = new TextureRegion(isaac1, 512,896,128,128);
        isaac41 = new TextureRegion(isaac11, 0,0,128,128);
        isaac42 = new TextureRegion(isaac11, 128,0,128,128);
        isaac43 = new TextureRegion(isaac11, 256,0,128,128);
        isaac44 = new TextureRegion(isaac11, 384,0,128,128);
        isaac45 = new TextureRegion(isaac11, 512,0,128,128);
        isaac46 = new TextureRegion(isaac11, 0,128,128,128);
        isaac47 = new TextureRegion(isaac11, 128,128,128,128);
        isaac48 = new TextureRegion(isaac11, 256,128,128,128);
        isaac49 = new TextureRegion(isaac11, 384,128,128,128);
        isaac50 = new TextureRegion(isaac11, 512,128,128,128);
        isaac51 = new TextureRegion(isaac11, 0,256,128,128);
        isaac52 = new TextureRegion(isaac11, 128,256,128,128);
        isaac53 = new TextureRegion(isaac11, 256,256,128,128);
        isaac54 = new TextureRegion(isaac11, 384,256,128,128);
        isaac55 = new TextureRegion(isaac11, 512,256,128,128);
        isaac56 = new TextureRegion(isaac11, 0,384,128,128);
        isaac57 = new TextureRegion(isaac11, 128,384,128,128);
        isaac58 = new TextureRegion(isaac11, 256,384,128,128);
        isaac59 = new TextureRegion(isaac11, 384,384,128,128);
        isaac60 = new TextureRegion(isaac11, 512,384,128,128);
        isaac61 = new TextureRegion(isaac11, 0,512,128,128);
        isaac62 = new TextureRegion(isaac11, 128,512,128,128);
        isaac63 = new TextureRegion(isaac11, 256,512,128,128);
        isaac64 = new TextureRegion(isaac11, 384,512,128,128);
        isaac65 = new TextureRegion(isaac11, 512,512,128,128);
        isaac66 = new TextureRegion(isaac11, 0,640,128,128);
        isaac67 = new TextureRegion(isaac11, 128,640,128,128);
        isaac68 = new TextureRegion(isaac11, 256,640,128,128);
        isaac69 = new TextureRegion(isaac11, 384,640,128,128);
        isaac70 = new TextureRegion(isaac11, 512,640,128,128);
        isaac71 = new TextureRegion(isaac11, 0,768,128,128);
        isaac72 = new TextureRegion(isaac11, 128,768,128,128);
        isaac73 = new TextureRegion(isaac11, 256,768,128,128);
        isaac74 = new TextureRegion(isaac11, 384,768,128,128);
        isaac75 = new TextureRegion(isaac11, 512,768,128,128);
        isaac76 = new TextureRegion(isaac11, 0,896,128,128);
        isaac77 = new TextureRegion(isaac11, 128,896,128,128);
        isaac78 = new TextureRegion(isaac11, 256,896,128,128);
        isaac79 = new TextureRegion(isaac11, 384,896,128,128);
        isaac80 = new TextureRegion(isaac11, 512,896,128,128);
        isaac81 = new TextureRegion(isaac2, 0,0,128,128);
        isaac82 = new TextureRegion(isaac2, 128,0,128,128);
        isaac83 = new TextureRegion(isaac2, 256,0,128,128);
        isaac84 = new TextureRegion(isaac2, 384,0,128,128);
        isaac85 = new TextureRegion(isaac2, 512,0,128,128);
        isaac86 = new TextureRegion(isaac2, 0,128,128,128);
        isaac87 = new TextureRegion(isaac2, 128,128,128,128);
        isaac88 = new TextureRegion(isaac2, 256,128,128,128);
        isaac89 = new TextureRegion(isaac2, 384,128,128,128);
        isaac90 = new TextureRegion(isaac2, 512,128,128,128);
        isaac91 = new TextureRegion(isaac2, 0,256,128,128);
        isaac92 = new TextureRegion(isaac2, 128,256,128,128);
        isaac93 = new TextureRegion(isaac2, 256,256,128,128);
        isaac94 = new TextureRegion(isaac2, 384,256,128,128);
        isaac95 = new TextureRegion(isaac2, 512,256,128,128);
        isaac96 = new TextureRegion(isaac2, 0,384,128,128);
        isaac97 = new TextureRegion(isaac2, 128,384,128,128);
        isaac98 = new TextureRegion(isaac2, 256,384,128,128);
        isaac99 = new TextureRegion(isaac2, 384,384,128,128);
        isaac100 = new TextureRegion(isaac2, 512,384,128,128);
        isaac101 = new TextureRegion(isaac2, 0,512,128,128);
        isaac102 = new TextureRegion(isaac2, 128,512,128,128);
        isaac103 = new TextureRegion(isaac2, 256,512,128,128);
        isaac104 = new TextureRegion(isaac2, 384,512,128,128);
        isaac105 = new TextureRegion(isaac2, 512,512,128,128);
        isaac106 = new TextureRegion(isaac2, 0,640,128,128);
        isaac107 = new TextureRegion(isaac2, 128,640,128,128);
        isaac108 = new TextureRegion(isaac2, 256,640,128,128);
        isaac109 = new TextureRegion(isaac2, 384,640,128,128);
        isaac110 = new TextureRegion(isaac2, 512,640,128,128);
        isaac111 = new TextureRegion(isaac2, 0,768,128,128);
        isaac112 = new TextureRegion(isaac2, 128,768,128,128);
        isaac113 = new TextureRegion(isaac2, 256,768,128,128);
        isaac114 = new TextureRegion(isaac2, 384,768,128,128);
        isaac115 = new TextureRegion(isaac2, 512,768,128,128);
        isaac116 = new TextureRegion(isaac2, 0,896,128,128);
        isaac117 = new TextureRegion(isaac2, 128,896,128,128);
        isaac118 = new TextureRegion(isaac2, 256,896,128,128);
        isaac119 = new TextureRegion(isaac2, 384,896,128,128);
        isaac120 = new TextureRegion(isaac2, 512,896,128,128);
        isaac121 = new TextureRegion(isaac21, 0,0,128,128);
        isaac122 = new TextureRegion(isaac21, 128,0,128,128);
        isaac123 = new TextureRegion(isaac21, 256,0,128,128);
        isaac124 = new TextureRegion(isaac21, 384,0,128,128);
        isaac125 = new TextureRegion(isaac21, 512,0,128,128);
        isaac126 = new TextureRegion(isaac21, 0,128,128,128);
        isaac127 = new TextureRegion(isaac21, 128,128,128,128);
        isaac128 = new TextureRegion(isaac21, 256,128,128,128);
        isaac129 = new TextureRegion(isaac21, 384,128,128,128);
        isaac130 = new TextureRegion(isaac21, 512,128,128,128);
        isaac131 = new TextureRegion(isaac21, 0,256,128,128);
        isaac132 = new TextureRegion(isaac21, 128,256,128,128);
        isaac133 = new TextureRegion(isaac21, 256,256,128,128);
        isaac134 = new TextureRegion(isaac21, 384,256,128,128);
        isaac135 = new TextureRegion(isaac21, 512,256,128,128);
        isaac136 = new TextureRegion(isaac21, 0,384,128,128);
        isaac137 = new TextureRegion(isaac21, 128,384,128,128);
        isaac138 = new TextureRegion(isaac21, 256,384,128,128);
        isaac139 = new TextureRegion(isaac21, 384,384,128,128);
        isaac140 = new TextureRegion(isaac21, 512,384,128,128);
        isaac141 = new TextureRegion(isaac21, 0,512,128,128);
        isaac142 = new TextureRegion(isaac21, 128,512,128,128);
        isaac143 = new TextureRegion(isaac21, 256,512,128,128);
        isaac144 = new TextureRegion(isaac21, 384,512,128,128);
        isaac145 = new TextureRegion(isaac21, 512,512,128,128);
        isaac146 = new TextureRegion(isaac21, 0,640,128,128);
        isaac147 = new TextureRegion(isaac21, 128,640,128,128);
        isaac148 = new TextureRegion(isaac21, 256,640,128,128);
        isaac149 = new TextureRegion(isaac21, 384,640,128,128);
        isaac150 = new TextureRegion(isaac21, 512,640,128,128);
        isaac151 = new TextureRegion(isaac21, 0,768,128,128);
        isaac152 = new TextureRegion(isaac21, 128,768,128,128);
        isaac153 = new TextureRegion(isaac21, 256,768,128,128);
        isaac154 = new TextureRegion(isaac21, 384,768,128,128);
        isaac155 = new TextureRegion(isaac21, 512,768,128,128);
        isaac156 = new TextureRegion(isaac21, 0,896,128,128);
        isaac157 = new TextureRegion(isaac21, 128,896,128,128);
        isaac158 = new TextureRegion(isaac21, 256,896,128,128);
        isaac159 = new TextureRegion(isaac21, 384,896,128,128);
        isaac160 = new TextureRegion(isaac21, 512,896,128,128);
        isaac161 = new TextureRegion(isaac3, 0,0,128,128);
        isaac162 = new TextureRegion(isaac3, 128,0,128,128);
        isaac163 = new TextureRegion(isaac3, 256,0,128,128);
        isaac164 = new TextureRegion(isaac3, 384,0,128,128);
        isaac165 = new TextureRegion(isaac3, 512,0,128,128);
        isaac166 = new TextureRegion(isaac3, 0,128,128,128);
        isaac167 = new TextureRegion(isaac3, 128,128,128,128);
        isaac168 = new TextureRegion(isaac3, 256,128,128,128);
        isaac169 = new TextureRegion(isaac3, 384,128,128,128);
        isaac170 = new TextureRegion(isaac3, 512,128,128,128);
        isaac171 = new TextureRegion(isaac3, 0,256,128,128);
        isaac172 = new TextureRegion(isaac3, 128,256,128,128);
        isaac173 = new TextureRegion(isaac3, 256,256,128,128);
        isaac174 = new TextureRegion(isaac3, 384,256,128,128);
        isaac175 = new TextureRegion(isaac3, 512,256,128,128);
        isaac176 = new TextureRegion(isaac3, 0,384,128,128);
        isaac177 = new TextureRegion(isaac3, 128,384,128,128);
        isaac178 = new TextureRegion(isaac3, 256,384,128,128);
        isaac179 = new TextureRegion(isaac3, 384,384,128,128);
        isaac180 = new TextureRegion(isaac3, 512,384,128,128);
        isaac181 = new TextureRegion(isaac3, 0,512,128,128);
        isaac182 = new TextureRegion(isaac3, 128,512,128,128);
        isaac183 = new TextureRegion(isaac3, 256,512,128,128);
        isaac184 = new TextureRegion(isaac3, 384,512,128,128);
        isaac185 = new TextureRegion(isaac3, 512,512,128,128);
        isaac186 = new TextureRegion(isaac3, 0,640,128,128);
        isaac187 = new TextureRegion(isaac3, 128,640,128,128);
        isaac188 = new TextureRegion(isaac3, 256,640,128,128);
        isaac189 = new TextureRegion(isaac3, 384,640,128,128);
        isaac190 = new TextureRegion(isaac3, 512,640,128,128);
        isaac191 = new TextureRegion(isaac3, 0,768,128,128);
        isaac192 = new TextureRegion(isaac3, 128,768,128,128);
        isaac193 = new TextureRegion(isaac3, 256,768,128,128);
        isaac194 = new TextureRegion(isaac3, 384,768,128,128);
        isaac195 = new TextureRegion(isaac3, 512,768,128,128);
        isaac196 = new TextureRegion(isaac3, 0,896,128,128);
        isaac197 = new TextureRegion(isaac3, 128,896,128,128);
        isaac198 = new TextureRegion(isaac3, 256,896,128,128);
        isaac199 = new TextureRegion(isaac3, 384,896,128,128);
        isaac200 = new TextureRegion(isaac3, 512,896,128,128);
        isaac201 = new TextureRegion(isaac31, 0,0,128,128);
        isaac202 = new TextureRegion(isaac31, 128,0,128,128);
        isaac203 = new TextureRegion(isaac31, 256,0,128,128);
        isaac204 = new TextureRegion(isaac31, 384,0,128,128);
        isaac205 = new TextureRegion(isaac31, 512,0,128,128);
        isaac206 = new TextureRegion(isaac31, 0,128,128,128);
        isaac207 = new TextureRegion(isaac31, 128,128,128,128);
        isaac208 = new TextureRegion(isaac31, 256,128,128,128);
        isaac209 = new TextureRegion(isaac31, 384,128,128,128);
        isaac210 = new TextureRegion(isaac31, 512,128,128,128);

        move1 = new TextureRegion(move, 0,0,128,128);
        move2 = new TextureRegion(move, 128,0,128,128);
        move3 = new TextureRegion(move, 0,128,128,128);
        move4 = new TextureRegion(move, 128,128,128,128);
        move5 = new TextureRegion(move, 0,256,128,128);
        move6 = new TextureRegion(move, 128,256,128,128);

        //--------------------Move Ani---------------------------------
        TextureRegion[] moveup = {move5, move6};
        moveUpAni = new Animation(0.06f, moveup);
        moveUpAni.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        TextureRegion[] movedown = {move3, move4};
        moveDownAni = new Animation(0.06f, movedown);
        moveDownAni.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        TextureRegion[] moveright = {move1, move2};
        moveRightAni = new Animation(0.06f, moveright);
        moveRightAni.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


        //--------------------Taunting---------------------------------
        TextureRegion[] isaactaunt = {isaac200,isaac200,isaac199,isaac198,isaac198,isaac200,isaac201,isaac202,isaac202,isaac202,isaac202,isaac202,
                isaac202,isaac202,isaac202,isaac202,isaac202,isaac201};
        isaacTauntAni = new Animation(0.06f, isaactaunt);
        isaacTauntAni.setPlayMode(Animation.PlayMode.NORMAL);

        //--------------------Move Psy---------------------------------
        TextureRegion[] isaacmovepsydr = {isaac160,isaac165,isaac165,isaac165,isaac165,isaac165,isaac165,isaac170,isaac175,isaac175,isaac175,isaac175,isaac175,isaac175,isaac175,isaac175,isaac175};
        isaacPsyDRAni = new Animation(0.06f, isaacmovepsydr);
        isaacPsyDRAni.setPlayMode(Animation.PlayMode.NORMAL);
        TextureRegion[] isaacmovepsyr = {isaac161,isaac166,isaac166,isaac166,isaac166,isaac166,isaac166,isaac171,isaac176,isaac176,isaac176,isaac176,isaac176,isaac176,isaac176,isaac176,isaac176};
        isaacPsyRAni = new Animation(0.06f, isaacmovepsyr);
        isaacPsyRAni.setPlayMode(Animation.PlayMode.NORMAL);
        TextureRegion[] isaacmovepsyur = {isaac162,isaac167,isaac167,isaac167,isaac167,isaac167,isaac167,isaac172,isaac177,isaac177,isaac177,isaac177,isaac177,isaac177,isaac177,isaac177,isaac177};
        isaacPsyURAni = new Animation(0.06f, isaacmovepsyur);
        isaacPsyURAni.setPlayMode(Animation.PlayMode.NORMAL);
        TextureRegion[] isaacmovepsyd = {isaac163,isaac168,isaac168,isaac168,isaac168,isaac168,isaac168,isaac173,isaac178,isaac178,isaac178,isaac178,isaac178,isaac178,isaac178,isaac178,isaac178};
        isaacPsyDAni = new Animation(0.06f, isaacmovepsyd);
        isaacPsyDAni.setPlayMode(Animation.PlayMode.NORMAL);
        TextureRegion[] isaacmovepsyu = {isaac164,isaac169,isaac169,isaac169,isaac169,isaac169,isaac169,isaac174,isaac179,isaac179,isaac179,isaac179,isaac179,isaac179,isaac179,isaac179,isaac179};
        isaacPsyUAni = new Animation(0.06f, isaacmovepsyu);
        isaacPsyUAni.setPlayMode(Animation.PlayMode.NORMAL);

        //--------------------Standing---------------------------------
        TextureRegion[] isaacFront = {isaac4,isaac4,isaac4,isaac9,isaac14,isaac14,isaac14,isaac29,isaac14,isaac29,isaac14,isaac9,isaac4,isaac4,isaac4};
        isaacFrontAni = new Animation(0.06f, isaacFront);
        isaacFrontAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] isaacBack = {isaac5,isaac5,isaac5,isaac10,isaac15,isaac15,isaac15,isaac30,isaac15,isaac30,isaac15,isaac10,isaac5,isaac5,isaac5};
        isaacBackAni = new Animation(0.06f, isaacBack);
        isaacBackAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] isaacRight = {isaac02,isaac02,isaac02,isaac7,isaac12,isaac12,isaac12,isaac27,isaac12,isaac27,isaac12,isaac7,isaac02,isaac02,isaac02};
        isaacRightAni = new Animation(0.06f, isaacRight);
        isaacRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] isaacUpRight = {isaac03,isaac03,isaac03,isaac8,isaac13,isaac13,isaac13,isaac28,isaac13,isaac28,isaac13,isaac8,isaac03,isaac03,isaac03};
        isaacUpRightAni = new Animation(0.06f, isaacUpRight);
        isaacUpRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] isaacDownRight = {isaac01,isaac01,isaac01,isaac6,isaac011,isaac011,isaac011,isaac26,isaac011,isaac26,isaac011,isaac6,isaac01,isaac01,isaac01};
        isaacDownRightAni = new Animation(0.06f, isaacDownRight);
        isaacDownRightAni.setPlayMode(Animation.PlayMode.LOOP);

        //--------------------Isaac Walking---------------------------------
        TextureRegion[] walkUp = {isaac35, isaac40, isaac45, isaac50, isaac55, isaac60};
        walkUpAni = new Animation(0.06f, walkUp);
        walkUpAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] walkDown = {isaac34, isaac39, isaac44, isaac49, isaac54, isaac59};
        walkDownAni = new Animation(0.06f, walkDown);
        walkDownAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] walkRight = {isaac32, isaac37, isaac42, isaac47, isaac52, isaac57};
        walkRightAni = new Animation(0.06f, walkRight);
        walkRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] walkUpRight = {isaac33, isaac38, isaac43, isaac48, isaac53, isaac58};
        walkUpRightAni = new Animation(0.06f, walkUpRight);
        walkUpRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] walkDownRight = {isaac031, isaac36, isaac41, isaac46, isaac51, isaac56};
        walkDownRightAni = new Animation(0.06f, walkDownRight);
        walkDownRightAni.setPlayMode(Animation.PlayMode.LOOP);


        //--------------------Running---------------------------------
        TextureRegion[] runUp = {isaac90,isaac95,isaac100,isaac105,isaac110,isaac115};
        runUpAni = new Animation(0.06f, runUp);
        runUpAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] runDown = {isaac89,isaac94,isaac99,isaac104,isaac109,isaac114};
        runDownAni = new Animation(0.06f, runDown);
        runDownAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] runRight = {isaac87,isaac92,isaac97,isaac102,isaac107,isaac112};
        runRightAni = new Animation(0.06f, runRight);
        runRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] runUpRight = {isaac88,isaac93,isaac98,isaac103,isaac108,isaac113};
        runUpRightAni = new Animation(0.06f, runUpRight);
        runUpRightAni.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion[] runDownRight = {isaac86,isaac91,isaac96,isaac101,isaac106,isaac111};
        runDownRightAni = new Animation(0.06f, runDownRight);
        runDownRightAni.setPlayMode(Animation.PlayMode.LOOP);

        //--------------------Turning---------------------------------
        TextureRegion[] downUp = {isaac4,isaac02,isaac5};
        isaacTurnDownUpAni = new Animation(2f, downUp);
        isaacTurnDownUpAni.setPlayMode(Animation.PlayMode.LOOP);

        //--------------------Falling---------------------------------

        isaacDownLeft = new TextureRegion(isaac1, 0,0,128,128);
        isaacLeft = new TextureRegion(isaac1, 128,0,128,128);
        isaacUpLeft= new TextureRegion(isaac1, 256,0,128,128);
        isaacUpLeft.flip(true,false);
        isaacLeft.flip(true,false);
        isaacDownLeft.flip(true,false);
        TextureRegion[] fall = {isaac4,isaac01,isaac02,isaac03,isaac5,isaacUpLeft,isaacLeft,isaacDownLeft};
        isaacFallAni = new Animation(2f, fall);
        isaacFallAni.setPlayMode(Animation.PlayMode.LOOP);




        TextureRegion[] ewd = {ewd1, ewd2, ewd3, ewd4, ewd5, ewd6, ewd7, ewd8, ewd9, ewd10, ewd11, ewd12, ewd13, ewd14, ewd15, ewd16};
        ewalkdown = new Animation(0.025f, ewd);
        ewalkdown.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] ewr = {ewr1, ewr2, ewr3, ewr4, ewr5, ewr6, ewr7, ewr8, ewr9, ewr10, ewr11, ewr12, ewr13, ewr14, ewr15, ewr16};
        ewalkright = new Animation(0.025f, ewr);
        ewalkright.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] ewu = {ewu1, ewu2, ewu3, ewu4, ewu5, ewu6, ewu7, ewu8, ewu9, ewu10, ewu11, ewu12, ewu13, ewu14, ewu15, ewu16};
        ewalkup = new Animation(0.025f, ewu);
        ewalkup.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] ewur = {ewur1, ewur2, ewur3, ewur4, ewur5, ewur6, ewur7, ewur8, ewur9, ewur10, ewur11, ewur12, ewur13, ewur14, ewur15, ewur16};
        ewalkupright = new Animation(0.025f, ewur);
        ewalkupright.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] ewdr = {ewdr1, ewdr2, ewdr3, ewdr4, ewdr5, ewdr6, ewdr7, ewdr8, ewdr9, ewdr10, ewdr11, ewdr12, ewdr13, ewdr14, ewdr15, ewdr16};
        ewalkdownright = new Animation(0.025f, ewdr);
        ewalkdownright.setPlayMode(Animation.PlayMode.LOOP);

        edownleft = new TextureRegion(eskimowalkdownright, 256,768,256,256);
        eleft = new TextureRegion(eskimowalkright, 256,768,256,256);
        eupleft= new TextureRegion(eskimowalkupright, 256,768,256,256);
        eupleft.flip(true,false);
        eleft.flip(true,false);
        edownleft.flip(true,false);
        TextureRegion[] ef = {ewd8,ewdr8,ewr8,ewur8,ewu8,eupleft,eleft,edownleft};
        efall= new Animation(2f, ef);
        efall.setPlayMode(Animation.PlayMode.LOOP);




        TextureRegion[] pwd = {pwd1, pwd2, pwd3, pwd4, pwd5, pwd6, pwd7, pwd8, pwd9, pwd10, pwd11, pwd12, pwd13, pwd14, pwd15, pwd16,};
        pwalkdown = new Animation(0.025f, pwd);
        pwalkdown.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] pwr = {pwr1, pwr2, pwr3, pwr4, pwr5, pwr6, pwr7, pwr8, pwr9, pwr10, pwr11, pwr12, pwr13, pwr14, pwr15, pwr16};
        pwalkright = new Animation(0.025f, pwr);
        pwalkright.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] pwu = {pwu1, pwu2, pwu3, pwu4, pwu5, pwu6, pwu7, pwu8, pwu9, pwu10, pwu11, pwu12, pwu13, pwu14, pwu15, pwu16};
        pwalkup = new Animation(0.025f, pwu);
        pwalkup.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] pwur = {pwur1, pwur2, pwur3, pwur4, pwur5, pwur6, pwur7, pwur8, pwur9, pwur10, pwur11, pwur12, pwur13, pwur14, pwur15, pwur16};
        pwalkupright = new Animation(0.025f, pwur);
        pwalkupright.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] pwdr = {pwdr1, pwdr2, pwdr3, pwdr4, pwdr5, pwdr6, pwdr7, pwdr8, pwdr9, pwdr10, pwdr11, pwdr12, pwdr13, pwdr14, pwdr15, pwdr16};
        pwalkdownright = new Animation(0.025f, pwdr);
        pwalkdownright.setPlayMode(Animation.PlayMode.LOOP);



        TextureRegion[] mp = { map1, map2, map3, map4, map5, map6, map7, map8, map9, map10, map11, map012, map13, map14, map15,
                map16, map17, map18, map19, map20, map21, map22, map23, map24, map25, map26, map27, map28, map29, map30,
        };
        mapani = new Animation(1/10f, mp);
        mapani.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);



        TextureRegion[] intr = {intro1, intro2, intro3, intro4, intro5, intro6, intro7, intro8, intro9, intro10, intro11, intro012,
                intro13, intro14, intro15, intro16, intro17, intro18, intro19, intro20, intro21, intro22,
                intro23, intro24, intro25, intro26, intro27, intro28, intro29, intro30, intro31, intro32,
                intro33, intro034, intro35, intro36, intro37, intro38, intro39, intro40, intro41, intro42,
                intro43, intro44, intro45, intro46, intro47, intro48, intro49, intro50
        };
        introani = new Animation(1/10f, intr);
        introani.setPlayMode(Animation.PlayMode.NORMAL);


        TextureRegion[] intrrep = {intro51, intro52,
                intro53, intro54, intro55, intro056, intro57, intro58, intro59, intro60, intro61, intro62,
                intro63, intro64, intro65, intro66, intro067, intro68, intro69, intro70, intro71, intro72,
                intro73, intro74, intro75, intro76, intro77, intro078, intro79, intro80, intro81, intro82,
                intro83, intro84, intro85, intro86, intro87, intro88, intro089, intro90, intro91, intro92,
                intro93, intro94, intro95, intro96, intro97
        };
        introrepeatani = new Animation(1/10f, intrrep);
        introrepeatani.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        eskimowalkdown.dispose();
        eskimowalkright.dispose();
        eskimowalkup.dispose();
        eskimowalkupright.dispose();
        eskimowalkdownright.dispose();
        penguinwalkdown.dispose();
        penguinwalkright.dispose();
        penguinwalkup.dispose();
        penguinwalkupright.dispose();
        penguinwalkdownright.dispose();
        map12.dispose();
        map34.dispose();
        map56.dispose();
        map78.dispose();
        map910.dispose();
        map1112.dispose();
        map1314.dispose();
        map1516.dispose();
        map1718.dispose();
        map1920.dispose();
        map2122.dispose();
        map2324.dispose();
        map2526.dispose();
        map2728.dispose();
        map2930.dispose();
        intro12.dispose();
        intro34.dispose();
        intro56.dispose();
        intro78.dispose();
        intro910.dispose();
        intro1112.dispose();
        intro1314.dispose();
        intro1516.dispose();
        intro1718.dispose();
        intro1920.dispose();
        intro2122.dispose();
        intro2324.dispose();
        intro2526.dispose();
        intro2728.dispose();
        intro2930.dispose();
        intro3132.dispose();
        intro3334.dispose();
        intro3536.dispose();
        intro3738.dispose();
        intro3940.dispose();
        intro4142.dispose();
        intro4344.dispose();
        intro4546.dispose();
        intro4748.dispose();
        intro4950.dispose();
        //intro5152.dispose();
        //intro5354.dispose();
        //intro5556.dispose();
        //intro5758.dispose();
        //intro5960.dispose();
        background.dispose();
        isaac1.dispose();
        isaac11.dispose();
        isaac2.dispose();
        isaac21.dispose();
        isaac3.dispose();
        isaac31.dispose();
        alex1.dispose();
        alex2.dispose();
        move.dispose();
    }
}
