/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.Hashtable;

public class KeyCode {
private int keycode;
public static final KeyCode KC_UNUSED = new KeyCode (-1);
public static final KeyCode KC_NULL = new KeyCode (0);
public static final KeyCode KC_01 = new KeyCode (1);
public static final KeyCode KC_02 = new KeyCode (2);
public static final KeyCode KC_03 = new KeyCode (3);
public static final KeyCode KC_04 = new KeyCode (4);
public static final KeyCode KC_05 = new KeyCode (5);
public static final KeyCode KC_06 = new KeyCode (6);
public static final KeyCode KC_07 = new KeyCode (7);
public static final KeyCode KC_08 = new KeyCode (8);
public static final KeyCode KC_09 = new KeyCode (9);
public static final KeyCode KC_10 = new KeyCode (10);
public static final KeyCode KC_11 = new KeyCode (11);
public static final KeyCode KC_12 = new KeyCode (12);
public static final KeyCode KC_13 = new KeyCode (13);
public static final KeyCode KC_14 = new KeyCode (14);
public static final KeyCode KC_15 = new KeyCode (15);
public static final KeyCode KC_16 = new KeyCode (16);
public static final KeyCode KC_17 = new KeyCode (17);
public static final KeyCode KC_18 = new KeyCode (18);
public static final KeyCode KC_19 = new KeyCode (19);
public static final KeyCode KC_20 = new KeyCode (20);
public static final KeyCode KC_21 = new KeyCode (21);
public static final KeyCode KC_22 = new KeyCode (22);
public static final KeyCode KC_23 = new KeyCode (23);
public static final KeyCode KC_24 = new KeyCode (24);
public static final KeyCode KC_25 = new KeyCode (25);
public static final KeyCode KC_26 = new KeyCode (26);
public static final KeyCode KC_27 = new KeyCode (27);
public static final KeyCode KC_28 = new KeyCode (28);
public static final KeyCode KC_29 = new KeyCode (29);
public static final KeyCode KC_30 = new KeyCode (30);
public static final KeyCode KC_31 = new KeyCode (31);
public static final KeyCode KC_32 = new KeyCode (32);
public static final KeyCode KC_33 = new KeyCode (33);
public static final KeyCode KC_34 = new KeyCode (34);
public static final KeyCode KC_35 = new KeyCode (35);
public static final KeyCode KC_36 = new KeyCode (36);
public static final KeyCode KC_37 = new KeyCode (37);
public static final KeyCode KC_38 = new KeyCode (38);
public static final KeyCode KC_39 = new KeyCode (39);
public static final KeyCode KC_40 = new KeyCode (40);
public static final KeyCode KC_41 = new KeyCode (41);
public static final KeyCode KC_42 = new KeyCode (42);
public static final KeyCode KC_43 = new KeyCode (43);
public static final KeyCode KC_44 = new KeyCode (44);
public static final KeyCode KC_45 = new KeyCode (45);
public static final KeyCode KC_46 = new KeyCode (46);
public static final KeyCode KC_47 = new KeyCode (47);
public static final KeyCode KC_48 = new KeyCode (48);
public static final KeyCode KC_49 = new KeyCode (49);
public static final KeyCode KC_50 = new KeyCode (50);
public static final KeyCode KC_51 = new KeyCode (51);
public static final KeyCode KC_52 = new KeyCode (52);
public static final KeyCode KC_53 = new KeyCode (53);
public static final KeyCode KC_54 = new KeyCode (54);
public static final KeyCode KC_55 = new KeyCode (55);
public static final KeyCode KC_56 = new KeyCode (56);
public static final KeyCode KC_57 = new KeyCode (57);
public static final KeyCode KC_58 = new KeyCode (58);
public static final KeyCode KC_59 = new KeyCode (59);
public static final KeyCode KC_60 = new KeyCode (60);
public static final KeyCode KC_61 = new KeyCode (61);
public static final KeyCode KC_62 = new KeyCode (62);
public static final KeyCode KC_63 = new KeyCode (63);
public static final KeyCode KC_64 = new KeyCode (64);
public static final KeyCode KC_65 = new KeyCode (65);
public static final KeyCode KC_66 = new KeyCode (66);
public static final KeyCode KC_67 = new KeyCode (67);
public static final KeyCode KC_68 = new KeyCode (68);
public static final KeyCode KC_69 = new KeyCode (69);
public static final KeyCode KC_70 = new KeyCode (70);
public static final KeyCode KC_71 = new KeyCode (71);
public static final KeyCode KC_72 = new KeyCode (72);
public static final KeyCode KC_73 = new KeyCode (73);
public static final KeyCode KC_74 = new KeyCode (74);
public static final KeyCode KC_75 = new KeyCode (75);
public static final KeyCode KC_76 = new KeyCode (76);
public static final KeyCode KC_77 = new KeyCode (77);
public static final KeyCode KC_78 = new KeyCode (78);
public static final KeyCode KC_79 = new KeyCode (79);
public static final KeyCode KC_80 = new KeyCode (80);
public static final KeyCode KC_81 = new KeyCode (81);
public static final KeyCode KC_82 = new KeyCode (82);
public static final KeyCode KC_83 = new KeyCode (83);
public static final KeyCode KC_84 = new KeyCode (84);
public static final KeyCode KC_85 = new KeyCode (85);
public static final KeyCode KC_86 = new KeyCode (86);
public static final KeyCode KC_87 = new KeyCode (87);
public static final KeyCode KC_88 = new KeyCode (88);
public static final KeyCode KC_89 = new KeyCode (89);
public static final KeyCode KC_90 = new KeyCode (90);
public static final KeyCode KC_91 = new KeyCode (91);
public static final KeyCode KC_92 = new KeyCode (92);
public static final KeyCode KC_93 = new KeyCode (93);
public static final KeyCode KC_94 = new KeyCode (94);
public static final KeyCode KC_95 = new KeyCode (95);
public static final KeyCode KC_96 = new KeyCode (96);
public static final KeyCode KC_97 = new KeyCode (97);
public static final KeyCode KC_98 = new KeyCode (98);
public static final KeyCode KC_99 = new KeyCode (99);
public static final KeyCode KC_100 = new KeyCode (100);
public static final KeyCode KC_101 = new KeyCode (101);
public static final KeyCode KC_102 = new KeyCode (102);
public static final KeyCode KC_103 = new KeyCode (103);
public static final KeyCode KC_104 = new KeyCode (104);

private static Hashtable keycodes_by_name = new Hashtable();
static {
keycodes_by_name.put("KC_1", KC_01);
keycodes_by_name.put("KC_2", KC_02);
keycodes_by_name.put("KC_3", KC_03);
keycodes_by_name.put("KC_4", KC_04);
keycodes_by_name.put("KC_5", KC_05);
keycodes_by_name.put("KC_6", KC_06);
keycodes_by_name.put("KC_7", KC_07);
keycodes_by_name.put("KC_8", KC_08);
keycodes_by_name.put("KC_9", KC_09);
keycodes_by_name.put("KC_10", KC_10);
keycodes_by_name.put("KC_11", KC_11);
keycodes_by_name.put("KC_12", KC_12);
keycodes_by_name.put("KC_13", KC_13);
keycodes_by_name.put("KC_14", KC_14);
keycodes_by_name.put("KC_15", KC_15);
keycodes_by_name.put("KC_16", KC_16);
keycodes_by_name.put("KC_17", KC_17);
keycodes_by_name.put("KC_18", KC_18);
keycodes_by_name.put("KC_19", KC_19);
keycodes_by_name.put("KC_20", KC_20);
keycodes_by_name.put("KC_21", KC_21);
keycodes_by_name.put("KC_22", KC_22);
keycodes_by_name.put("KC_23", KC_23);
keycodes_by_name.put("KC_24", KC_24);
keycodes_by_name.put("KC_25", KC_25);
keycodes_by_name.put("KC_26", KC_26);
keycodes_by_name.put("KC_27", KC_27);
keycodes_by_name.put("KC_28", KC_28);
keycodes_by_name.put("KC_29", KC_29);
keycodes_by_name.put("KC_30", KC_30);
keycodes_by_name.put("KC_31", KC_31);
keycodes_by_name.put("KC_32", KC_32);
keycodes_by_name.put("KC_33", KC_33);
keycodes_by_name.put("KC_34", KC_34);
keycodes_by_name.put("KC_35", KC_35);
keycodes_by_name.put("KC_36", KC_36);
keycodes_by_name.put("KC_37", KC_37);
keycodes_by_name.put("KC_38", KC_38);
keycodes_by_name.put("KC_39", KC_39);
keycodes_by_name.put("KC_40", KC_40);
keycodes_by_name.put("KC_41", KC_41);
keycodes_by_name.put("KC_42", KC_42);
keycodes_by_name.put("KC_43", KC_43);
keycodes_by_name.put("KC_44", KC_44);
keycodes_by_name.put("KC_45", KC_45);
keycodes_by_name.put("KC_46", KC_46);
keycodes_by_name.put("KC_47", KC_47);
keycodes_by_name.put("KC_48", KC_48);
keycodes_by_name.put("KC_49", KC_49);
keycodes_by_name.put("KC_50", KC_50);
keycodes_by_name.put("KC_51", KC_51);
keycodes_by_name.put("KC_52", KC_52);
keycodes_by_name.put("KC_53", KC_53);
keycodes_by_name.put("KC_54", KC_54);
keycodes_by_name.put("KC_55", KC_55);
keycodes_by_name.put("KC_56", KC_56);
keycodes_by_name.put("KC_57", KC_57);
keycodes_by_name.put("KC_58", KC_58);
keycodes_by_name.put("KC_59", KC_59);
keycodes_by_name.put("KC_60", KC_60);
keycodes_by_name.put("KC_61", KC_61);
keycodes_by_name.put("KC_62", KC_62);
keycodes_by_name.put("KC_63", KC_63);
keycodes_by_name.put("KC_64", KC_64);
keycodes_by_name.put("KC_65", KC_65);
keycodes_by_name.put("KC_66", KC_66);
keycodes_by_name.put("KC_67", KC_67);
keycodes_by_name.put("KC_68", KC_68);
keycodes_by_name.put("KC_69", KC_69);
keycodes_by_name.put("KC_70", KC_70);
keycodes_by_name.put("KC_71", KC_71);
keycodes_by_name.put("KC_72", KC_72);
keycodes_by_name.put("KC_73", KC_73);
keycodes_by_name.put("KC_74", KC_74);
keycodes_by_name.put("KC_75", KC_75);
keycodes_by_name.put("KC_76", KC_76);
keycodes_by_name.put("KC_77", KC_77);
keycodes_by_name.put("KC_78", KC_78);
keycodes_by_name.put("KC_79", KC_79);
keycodes_by_name.put("KC_80", KC_80);
keycodes_by_name.put("KC_81", KC_81);
keycodes_by_name.put("KC_82", KC_82);
keycodes_by_name.put("KC_83", KC_83);
keycodes_by_name.put("KC_84", KC_84);
keycodes_by_name.put("KC_85", KC_85);
keycodes_by_name.put("KC_86", KC_86);
keycodes_by_name.put("KC_87", KC_87);
keycodes_by_name.put("KC_88", KC_88);
keycodes_by_name.put("KC_89", KC_89);
keycodes_by_name.put("KC_90", KC_90);
keycodes_by_name.put("KC_91", KC_91);
keycodes_by_name.put("KC_92", KC_92);
keycodes_by_name.put("KC_93", KC_93);
keycodes_by_name.put("KC_94", KC_94);
keycodes_by_name.put("KC_95", KC_95);
keycodes_by_name.put("KC_96", KC_96);
keycodes_by_name.put("KC_97", KC_97);
keycodes_by_name.put("KC_98", KC_98);
keycodes_by_name.put("KC_99", KC_99);
keycodes_by_name.put("KC_100", KC_100);
keycodes_by_name.put("KC_101", KC_101);
keycodes_by_name.put("KC_102", KC_102);
keycodes_by_name.put("KC_103", KC_103);
keycodes_by_name.put("KC_104", KC_104);
}

public KeyCode (int keycode){
this.keycode = keycode;
}
public static KeyCode find_keycode(String name){
return ((KeyCode)(keycodes_by_name.get(name)));
}
public String toString (){
return (""+ keycode);
}
/*public static void main (String args[]){
System.out.println("**CLASS TEST CODE**");
System.out.println(KC_NULL);
System.out.println(KC_01);
System.out.println(KC_104);
System.out.println(find_keycode("KC_NULL"));
System.out.println(find_keycode("KC_1"));
System.out.println(find_keycode("KC_104"));
}*/
}