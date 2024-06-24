package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import org.apache.commons.lang3.StringUtils;

public class FreshJuiceTest {

   static int ch = 1;
   // static double x1;
   // static double x2;
   // static double y1;
   // static double y2;
   // static double x1z;
   // static double x2z;
   // static double y1z;
   // static double y2z;

   static Double[] Vynos_celogo_chisla(int number) {
      double number2 = Math.sqrt(number);
      if (String.valueOf(number2).indexOf(".") == String.valueOf(number2).length()-2 && ch == 1) {
            ch = 1;
            System.out.println("null");
            return new Double[]{number2, 0.0};
      }
      Double vne_kornya = 1.0;
      Double pod_kornem = number * 1.0;
      int False = 0;
      while (False != 1) {
         if (pod_kornem % 4 == 0) {
            pod_kornem = pod_kornem/4;
            vne_kornya *= 2;
         } else if (pod_kornem % 9 == 0) {
            pod_kornem = pod_kornem/9;
            vne_kornya *= 3;
         } else if (pod_kornem % 25 == 0) {
            pod_kornem = pod_kornem/25;
            vne_kornya *= 5;
         } else {
            False = 1;
         }
      }
      if (False == 1 && pod_kornem != number) {
         System.out.println("null2");
         return new Double[] {vne_kornya, pod_kornem};
      } else {
         System.out.println("null3");
         return new Double[]{0.0, 0.0};
      }
   }

   static Double[] Vynos_NeCelogo_chisla(double number) { // выносит не целое число
      double number2 = number;
      String decrease = "1";
      int dlina_number = 1;
      double number3;
      double number4;
      Double[] celiy;
      for (int i = String.valueOf(number2).length()-1; i >= 0; i--) {
         if (String.valueOf(number2).charAt(i) == 'e') {
            decrease += StringUtils.leftPad("", Integer.parseInt(String.valueOf(number2).substring(i+2, decrease.length())), '0');
            if (String.valueOf(number2).indexOf(".") != -1) {
               dlina_number = Integer.parseInt(String.valueOf(number2).substring(i+2, String.valueOf(number2).length()))+1;
            } else {
               dlina_number = Integer.parseInt(String.valueOf(number2).substring(i+2, String.valueOf(number2).length()));
            }
            break;
         }
      }
      number2 *= Double.parseDouble(decrease);
      double decrease2 = 1/Integer.parseInt(decrease);
      int dlina = String.valueOf(number2).substring((String.valueOf(number2).indexOf("."))+1, String.valueOf(number2).length()).length();
      if (dlina_number == 1) {
         dlina_number = dlina;
      }
      if (decrease2 != 1.0) {
         number2 = Math.round(number2*10d)/10d;
      }
      System.out.println(number2 + " df");
      decrease = String.valueOf(Check_e(decrease));
      // decrease = str(decrease);
      while (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' || String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
         number2 *= 10;
         decrease = "0.0" + decrease.substring(2, decrease.length());
         dlina -= 1;
         // System.out.println(dlina + " " + decrease + " " + number2 + " 1" + StringUtils.leftPad("", dlina, '0') + "d " + Math.round(number2*10d)/10d);
         number2 = Math.round(number2*Double.parseDouble("1" + StringUtils.leftPad("", dlina, '0') + "d"))/Double.parseDouble("1" + StringUtils.leftPad("", dlina, '0') + "d");
         System.out.println(dlina + " " + decrease + " " + number2 + " 1" + StringUtils.leftPad("", dlina, '0') + "d");
      }
      celiy = Vynos_celogo_chisla((int)(number2));
      number3 = celiy[0];
      number4 = celiy[1];
      System.out.println(celiy + " celiy " + number3 + " " + number4 + " " + number2);
      if (number4 == 0 && number3 != 0) {
         if (dlina_number%2 == 0) {
               number3 = number3/(Integer.parseInt("1"+((StringUtils.leftPad("", dlina_number/2, '0')))));
         } else {
               ch = 2;
               celiy = Vynos_celogo_chisla((int)(number2));
               number3 = celiy[0];
               number4 = celiy[1];
         }
      }
      System.out.println(number3 + " " + number4);
      if (number4 != 0 && number3 != 0) {
         boolean flag = true;
         for (int t = 0; t < (String.valueOf(decrease)).length(); t++) { // Смотрим длину после точки у первого числа
            for (int i = 0; i < (String.valueOf(decrease)).length()/2; i++) { // Смотрим длину после точки у второго числа;
               if (Math.round((Math.round((Math.pow((number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')))), 2))*Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))*Math.round((number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0'))))*Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d")*Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d") == number) {
                  number3 = number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')));
                  number4 = number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0')));
                  if (t == 0) {
                        number3 = Double.parseDouble(String.valueOf(number3).substring(0, String.valueOf(number3).length()-2));
                  }
                  if (i == 0) {
                        number4 = Double.parseDouble(String.valueOf(number4).substring(0, String.valueOf(number4).length()-2));
                  }
                  flag = false;
                  break;
               }
            }
            if (flag == false) {
               break;
            }
         }
         if (flag == true) {
            number3 = 0;
            number4 = 0;
         }
      }
      System.out.println(number3 + " " + number4);
      return new Double[] {number3, number4};
   }

   /**
    * @param number
    * @return
    */
    
   static Double Proverka_dlin_chisla(double number) {
      boolean flag = true;
      String number2 = String.valueOf(number);
      int tochka = String.valueOf(number2).indexOf(".");
      for (int t = tochka+2; t < (String.valueOf(number2.substring(tochka+1, number2.length()))).length(); t++) {
         if (t != number2.length()-2) {
            if (number2.charAt(t+1) == number2.charAt(t)) {
               for (int i = t+2; i < (String.valueOf(number2.substring(tochka+1, number2.length()))).length(); i++) {
                  if (number2.charAt(i) == number2.charAt(t+2)) {
                     if (i-t >= 3) {
                        if (Integer.parseInt(Character.toString(number2.charAt(t+2))) > 5) {
                              number2 = number2.substring(0, t-1)+String.valueOf((int)(number2.charAt(t-1))+1);
                              flag = false;
                        } else {
                              number2 = number2.substring(0, t);
                              flag = false;
                        }
                        break;
                     }
                  } else {
                     break;
                  }
               }
            }
         }
         if (flag == false) {
            break;
         }
      }
      if (Character.toString(number2.charAt(number2.length()-1)) == "0" && Character.toString(number2.charAt(number2.length()-2)) == ".") {
         number2 = number2.substring(0, number2.length()-2);
      }
      return Double.parseDouble(number2);
   }

   static Double Check_e(String number) {
      String number2 = number;
      if (number.indexOf("e") != -1) {
         number2 = "0." + StringUtils.leftPad("", (Integer.parseInt(String.valueOf(number).substring(String.valueOf(number).indexOf("e")+2, String.valueOf(number).length()))-1), '0');
         if (String.valueOf(number).indexOf(".") != -1) {
            number2 += String.valueOf(number).substring(0, String.valueOf(number).indexOf(".")) + String.valueOf(number).substring(String.valueOf(number).indexOf(".")+1, String.valueOf(number).indexOf("e"));
         } else {
            number2 += String.valueOf(number).substring(0, String.valueOf(number).indexOf("e"));
         }
      }
      return Double.parseDouble(number2);
   }

   static String VynosIzPodKoren(String koren) { //вынос из под корня
      // try {
         int c = 0; // проверка правильно ли стоит знак корня в строке
         int f = 0; // проверка правильно ли стоит знак деления
         int g = 0; // проверка правильно ли стоят числа с плавающей запятой
         int f2 = 0; // проверка не стоит ли знак деления в конце или в начале
         int g2 = 0; // проверка не стоит ли точка в конце или в начале
         int c2 = 0; // проверка не стоит ли знак корня в конце
         // Double number_d = 0.0;
         // Double number2_d = 0.0;
         // Double number3_d = 0.0;
         // Double number4_d = 0.0;
         // int number_i = 0;
         // int number2_i = 0;
         // int number3_i = 0;
         // int number4_i = 0;
         for (int i = 0; i < (koren).length(); i++) {
            if (koren.charAt(i) == '√') {
               c += 1;
               System.out.println("a");
            }
            if (koren.charAt(i) == '/') {
               f += 1;
               System.out.println("b");
            }
            if (koren.charAt(i) == '.') {
               g += 1;
               System.out.println("c");
            }
            if (koren.charAt(i) == '√' && i == (koren).length()) {
               c2 += 1;
               System.out.println("d");
            }
            if (koren.charAt(i) == '.' && (i != 0 && i != (koren).length()) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i+1)))) {
               g2 += 1;
               System.out.println("f");
            }
            if (koren.charAt(i) == '/' && (i != 0 && i != (koren).length()) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i+1)))) {
               f2 += 1;
               System.out.println("j");
            }
            System.out.println(i + " " + String.valueOf(koren.charAt(i)));
         }
         System.out.println(g + " " + c + " " + f + " " + g2 + " " + c2 + " " + f2 + " " + (koren).length());
         if (g > 4 || c != 1 || f > 2 || f != f2 || g != g2 || c2 != 0) {
               System.out.println("ASD");
               return "Проверьте правильность ввода";
         } else if (koren.length() == 1) {
               System.out.println("A2SD");
               return "Проверьте правильность ввода";

         } else {
            System.out.println("As");
            int a = koren.indexOf("√");
            boolean NeKPL = true; // проверяет есть ли число с плавающей запятой вне корня
            boolean KPL = true; // проверяет есть ли число с плавающей запятой под корнем
            boolean KDR = true; // проверяет есть ли дробь под корняем
            boolean NeKDR = true; // проверяет есть ли дробь вне корня
            int Drob_Ne = 0;
            int Drob_V = 0;
            Double numerator = 0.0;
            Double number = 0.0;
            Double number2 = 0.0;
            Double number3 = 0.0;
            Double number4 = 0.0;
            Double denominator = 0.0;
            Double[] neceliy;
            Double[] celiy;
            for (int i = a; i < koren.length(); i++) {
               if (koren.charAt(i) == '.') {
                  KPL = false;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.charAt(i) == '.') {
                  NeKPL = false;
               }
            }
            for (int i = a; i < koren.length(); i++) {
               if (koren.charAt(i) == '/') {
                  KDR = false;
                  Drob_V = i;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.charAt(i) == '/') {
                  NeKDR = false;
                  Drob_Ne = i;
               }
            }
            System.out.println(KDR + " " + NeKDR + " " + KPL + " " + NeKPL);
            if (KDR == true && (KPL == true || KPL == false)) {
               if (koren.substring(a+1, koren.length()).indexOf(".") == -1) {
                  celiy = Vynos_celogo_chisla(Integer.parseInt(koren.substring(a+1, koren.length())));
                  number = celiy[0];
                  number2 = celiy[1];
                  System.out.println("A" + " " + celiy + " " + koren.substring(a+1, koren.length()));
               } else {
                  neceliy = Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(a+1, koren.length())));
                  number = neceliy[0];
                  number2 = neceliy[1];
                  System.out.println("B " + koren.substring(a+1, koren.length()));
               }
               System.out.println(number + " " + number2);
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if (number == 0.0 && (number2) == 0.0) {
                        return "Число иррациональное";
                  } else {
                     if (a != 0) {
                        // if (number_d == 0 && celiy.length != 0) {
                        //    int number = number_i;
                        // } else {
                        //    Double number = number_d;
                        // }
                        if (StringUtils.isNumeric(koren.substring(0, a)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((Double.parseDouble(String.valueOf(number))*Double.parseDouble(koren.substring(0, a))));
                        } else if (a != 0) { // если число вне корня не целое
                           // if (Character.toString(String.valueOf(((number))*Double.parseDouble(koren.substring(0, a))).charAt(-1)) == "0" && Character.toString(String.valueOf(((number))*Double.parseDouble(koren.substring(0, a))).charAt(-2)) == ".") {
                           //       numerator = Double.parseDouble(String.valueOf(((number))*Double.parseDouble(koren.substring(0, a))).substring(0, String.valueOf(((number))*Double.parseDouble(koren.substring(0, a))).length()-3));
                           // } else {
                           numerator = Proverka_dlin_chisla(((number))*Double.parseDouble(koren.substring(0, a)));
                           // }
                        }
                     } else {
                        numerator = number;
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     if (number2 == 0.0) { // если вне дроби есть число и число расскладывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2);
                        } else {
                           return String.valueOf(numerator);
                        }
                     } else if (number2 != 0.0) { // если вне дроби есть число и число расскладывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.') {
                           if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                              return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                           } else {
                              return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2;
                           }
                        } else {
                           if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                              return String.valueOf(numerator) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                           } else {
                              return String.valueOf(numerator) + "√" + number2;
                           }
                        }
                     } 
                     // else {
                     //    if (number2 == 0.0) {
                     //       return String.valueOf(number);
                     //    } else {
                     //       return number + "√" + number2;
                     //    }
                     // }
                  }
               } else if (NeKDR == false && (NeKPL == true || NeKPL == false)) { // если вне корня дробь
                  if (number == 0.0 && number2 == 0.0) {
                        return "Число иррациональное";
                  } else {
                        if (StringUtils.isNumeric(koren.substring(0, Drob_Ne)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((((number))*Integer.parseInt(koren.substring(0, Drob_Ne))));
                        } else if (a != 0) { // если число вне корня не целое
                           // if (Character.toString(String.valueOf(((number))*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-1)) == "0" && Character.toString(String.valueOf(((number))*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-2)) == ".") {
                           //    numerator = String.valueOf(((number))*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, -2);
                           // } else {
                           numerator = Proverka_dlin_chisla((((number))*Double.parseDouble(koren.substring(0, Drob_Ne))));
                           // }
                        }
                        numerator = Check_e(String.valueOf(numerator));
                        number2 = Check_e(String.valueOf(number2));
                        if (koren.substring(0, a) != "" && number2 == 0.0 && (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.')) { // если вне дроби нету числа и число расскладывается нацело
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + koren.substring(Drob_Ne+1, a);
                        } else if (koren.substring(0, a) != "" && number2 == 0.0 && (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.')){
                           return numerator + "/" + koren.substring(Drob_Ne+1, a);
                        } else if (koren.substring(0, a) != "" && number2 != 0.0 && (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.')) { // если вне дроби есть число и число расскладывается нацело
                           if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                              return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + koren.substring(Drob_Ne+1, a);
                           } else {
                              return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + koren.substring(Drob_Ne+1, a);
                           }
                        } else if (koren.substring(0, a) != "" && number2 != 0.0 && (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.')) { // если вне дроби есть число и число расскладывается нацело
                           if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                              return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + koren.substring(Drob_Ne+1, a);
                           } else {
                              return numerator + "√" + number2 + "/" + koren.substring(Drob_Ne+1, a);
                           }
                        }
                  }
               }
            } else if (KDR == false && (KPL == false || KPL == true)) {
               if (koren.substring(a+1, Drob_V).indexOf(".") == -1) {
                  celiy = Vynos_celogo_chisla(Integer.parseInt(koren.substring(a+1, Drob_V)));
                  number = celiy[0];
                  number2 = celiy[1];
               } else {
                  neceliy = Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(a+1, Drob_V)));
                  number = neceliy[0];
                  number2 = neceliy[1];
               }
               if (koren.substring(Drob_V+1, koren.length()-1).indexOf(".") == -1) {
                  celiy = Vynos_celogo_chisla(Integer.parseInt(koren.substring(Drob_V+1, koren.length())));
                  number3 = celiy[0];
                  number4 = celiy[1];
               } else {
                  neceliy = Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(Drob_V+1, koren.length())));
                  number3 = neceliy[0];
                  number4 = neceliy[1];
               }
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if ((number == 0.0 && number2 == 0.0) || (number3 == 0.0 && number4 == 0.0)) {
                     return "Число иррациональное";
                  } else {
                     if (a != 0) {
                        if (StringUtils.isNumeric(koren.substring(0, a)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((number*Integer.parseInt(koren.substring(0, a))));
                        } else if (a != 0) { // если число вне корня не целое
                           // if (Character.toString(String.valueOf(number*Double.parseDouble(koren.substring(0, a))).charAt(-1)) == "0" && Character.toString(String.valueOf(number*Double.parseDouble(koren.substring(0, a))).charAt(-2)) == ".") {
                           //       numerator = Double.parseDouble(String.valueOf(number*Double.parseDouble(koren.substring(0, a))).substring(0, String.valueOf(number*Double.parseDouble(koren.substring(0, a))).length()-2));
                           // } else if (a != 0) {
                           numerator = Proverka_dlin_chisla((number*Double.parseDouble(koren.substring(0, a))));
                           // }
                        }
                     } else {
                        numerator = number;
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     number3 = Check_e(String.valueOf(number3));
                     number4 = Check_e(String.valueOf(number4));
                     if (number2 == 0.0 && number4 == 0.0) { // если исло расскладывается нацело и знаменатель расскадывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + number3;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.') {
                           return numerator + "/" + number3;
                        }
                     } else if (number2 == 0.0 && number4 != 0.0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + number3 + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + number3 + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "/" + number3 + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else {
                           return numerator + "/" + number3 + "√1/" + number4;
                        }
                     } else if (number2 != 0.0 && number4 == 0.0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + number3 + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + number3 + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return numerator + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return numerator + "/" + number3 + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else {
                           return numerator + "/" + number3 + "√1/" + number2;
                        }
                     } else if (number2 != 0.0 && number4 != 0.0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + number3 + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + number3 + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + number2 + "/" + number3 + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + number2 + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + number3 + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + number3 + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + number3 + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + number3 + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "√" + number2 + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) != '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + number3 + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(number3).charAt(String.valueOf(number3).length()-1) == '0' && String.valueOf(number3).charAt(String.valueOf(number3).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + String.valueOf(number3).substring(0, String.valueOf(number3).length()-2) + "√" + number4;
                        } else {
                           return numerator + "√" + number2 + "/" + number3 + "√" + number4;
                        }
                     }
                  }
               } else if (NeKDR == false && (NeKPL == false || NeKPL == true)) { // если вне корня либо дробь с целыми числами, либо дробь с числа с плавающей запятой, либо смешаная дробь
                  if ((number == 0.0 && number2 == 0.0) || (number3 == 0.0 && number4 == 0.0)) {
                     return "Число иррациональное";
                  } else {
                     if (StringUtils.isNumeric(String.valueOf(koren.substring(0, Drob_Ne))) == true) { // если число вне корня целое
                        numerator = Proverka_dlin_chisla((number*Integer.parseInt(koren.substring(0, Drob_Ne))));
                     } else if (a != 0) {// если число вне корня не целое
                        // if (Character.toString(String.valueOf(number*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-1)) == "0" && Character.toString(String.valueOf(number*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-2)) == ".") {
                        //    numerator = (String.valueOf(number*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, String.valueOf(number*Double.parseDouble(koren.substring(0, Drob_Ne))).length()-2));
                        // } else {
                        numerator = Proverka_dlin_chisla((number*Double.parseDouble(koren.substring(0, Drob_Ne))));
                        // }
                     }
                     if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_Ne+1, a))) == true) { // если число в корне целое
                        denominator = Proverka_dlin_chisla((number3*Integer.parseInt(koren.substring(Drob_Ne+1, a))));
                     } else if (a != 0) { // если число в корне не целое
                        // if (Character.toString(String.valueOf(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).charAt(-1)) == "0" && Character.toString(String.valueOf(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).charAt(-2)) == ".") {
                        //    denominator = String.valueOf(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).substring(0, -2);
                        // } else {
                        denominator = Proverka_dlin_chisla((number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))));
                        // }
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     number3 = Check_e(String.valueOf(number3));
                     number4 = Check_e(String.valueOf(number4));
                     if (number2 == 0.0 && number4 == 0.0) { // если число расскладывается нацело и знаменатель расскадывается нацело
                        return numerator + "/" + denominator;
                     } else if (number2 == 0.0 && number4 != 0.0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                        return numerator + "/" + denominator + "√1/" + number4;
                     }else if (number2 != 0.0 && number4 == 0.0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                        return numerator + "/" + denominator + "√" + number2;
                     } else if (number2 != 0.0 && number4 != 0.0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                        return numerator + "√" + number2 + "/" + denominator + "√" + number4;
                     }
                     if (number2 == 0.0 && number4 == 0.0) { // если исло расскладывается нацело и знаменатель расскадывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + denominator;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.') {
                           return numerator + "/" + denominator;
                        }
                     } else if (number2 == 0.0 && number4 != 0.0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + denominator + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + denominator + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "/" + denominator + "√1/" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else {
                           return numerator + "/" + denominator + "√1/" + number4;
                        }
                     } else if (number2 != 0.0 && number4 == 0.0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + denominator + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "/" + denominator + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.') {
                           return numerator + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + number2;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return numerator + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                           return numerator + "/" + denominator + "√1/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                        } else {
                           return numerator + "/" + denominator + "√1/" + number2;
                        }
                     } else if (number2 != 0.0 && number4 != 0.0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                        if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + denominator + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + denominator + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + number2 + "/" + denominator + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + number2 + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + denominator + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + denominator + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + denominator + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + denominator + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return numerator + "√" + number2 + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + number4;
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) != '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) != '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) != '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) != '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) == '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) == '.') {
                           return numerator + "√" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2) + "/" + denominator + "√" + String.valueOf(number4).substring(0, String.valueOf(number4).length()-2);
                        } else if (String.valueOf(numerator).charAt(String.valueOf(numerator).length()-1) == '0' && String.valueOf(numerator).charAt(String.valueOf(numerator).length()-2) == '.' && String.valueOf(number2).charAt(String.valueOf(number2).length()-1) != '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) != '.' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-1) == '0' && String.valueOf(denominator).charAt(String.valueOf(denominator).length()-2) == '.' && String.valueOf(number4).charAt(String.valueOf(number4).length()-1) != '0' && String.valueOf(number4).charAt(String.valueOf(number4).length()-2) != '.') {
                           return String.valueOf(numerator).substring(0, String.valueOf(numerator).length()-2) + "√" + number2 + "/" + String.valueOf(denominator).substring(0, String.valueOf(denominator).length()-2) + "√" + number4;
                        } else {
                           return numerator + "√" + number2 + "/" + denominator + "√" + number4;
                        }
                     }
                  }
               }
            }
         }
      return "Проверьте правильность ввода";
      // } except {
      //    return "Проверьте правильность ввода";
      // }
   }

   static String VnosPodKoren(String koren) {
      // try {
         int c = 0;
         int f = 0;
         int g = 0;
         int f2 = 0;
         int g2 = 0;
         int c2 = 0;
         for (int i = 0; i < (koren).length(); i++) {
            if (koren.charAt(i) == '√') {
               c += 1;
            }
            if (koren.charAt(i) == '/') {
               f += 1;
            }
            if (koren.charAt(i) == '.') {
               g += 1;
            }
            if (koren.charAt(i) == '√' && i == 0) {
               c2 += 1;
            }
            if (koren.charAt(i) == '.' && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1)))) {
               g2 += 1;
            }
            if (koren.charAt(i) == '/' && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1)))) {
               f2 += 1;
            }
         }
         if (Character.toString(koren.charAt(koren.length()-1)) == "√") {
            c += 1;
         }
         if (g > 4 || c != 1 || f > 2 || f != f2 || g != g2 || c2 != 0) {
            return "Проверьте правильность ввода";
         } else if ((koren).length() == 1) {
            return "Проверьте правильность ввода";
         } else {
            int a = String.valueOf(koren).indexOf("√");
            int Drob_Ne = a;
            int Drob_V = koren.length();
            Double number = 0.0;
            Double number2 = 0.0;
            // Double number3 = 0;
            // Double number4 = 0;
            for (int i = 0; i < (koren).length(); i++) {
               if (koren.charAt(i) == '/') {
                     Drob_V = i;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.charAt(i) == '/') {
                     Drob_Ne = i;
               }
            }
            if (StringUtils.isNumeric(String.valueOf(koren.substring(0, Drob_Ne))) == true) {
               number = Math.pow(Integer.parseInt(koren.substring(0, Drob_Ne)), 2);
            } else{
               number = Math.pow(Double.parseDouble(koren.substring(0, Drob_Ne)), 2);
            }
            if (Drob_Ne != a) {
               if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_Ne+1, a))) == true) {
                     number2 = Math.pow(Integer.parseInt(koren.substring(Drob_Ne+1, a)), 2);
               } else {
                     number2 = Math.pow(Double.parseDouble(koren.substring(Drob_Ne+1, a)), 2);
               }
            }
            if (StringUtils.isNumeric(String.valueOf(koren.substring(a+1, Drob_V))) == true && (koren.substring(a+1, Drob_V)).length() != 0) {
               number = number*Integer.parseInt(koren.substring(a+1, Drob_V));
            } else if (StringUtils.isNumeric(String.valueOf(koren.substring(a+1, Drob_V))) != true && (koren.substring(a+1, Drob_V)).length() != 0) {
               number = number*Double.parseDouble(koren.substring(a+1, Drob_V));
            }
            if (Drob_V != (koren).length()) {
               if (number2 == 0.0) {
                  number2 = 1.0;
               }
               if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_V+1, koren.length()))) == true && (koren.substring(Drob_V+1, koren.length())).length() != 0) {
                  number2 = number2*Integer.parseInt(koren.substring(Drob_V+1, koren.length()));
               }
               else if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_V+1, koren.length()))) != true && (koren.substring(Drob_V+1, koren.length())).length() != 0) {
                  number2 = number2*Double.parseDouble(koren.substring(Drob_V+1, koren.length()));
               }
            }
            if (String.valueOf(number).charAt(String.valueOf(number).length()-1) == '0' && String.valueOf(number).charAt(String.valueOf(number).length()-2) == '.') {
               if (number2 == 0.0) {
                  return "√" + String.valueOf(number).substring(0, String.valueOf(number).length()-2);
               } else {
                  if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                     return "√" + String.valueOf(number).substring(0, String.valueOf(number).length()-2) + "/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                  } else {
                     return "√" + String.valueOf(number).substring(0, String.valueOf(number).length()-2) + "/" + number2;
                  }
               }
            } else {
               if (number2 == 0.0) {
                  return "√" + number;
               } else {
                  if (String.valueOf(number2).charAt(String.valueOf(number2).length()-1) == '0' && String.valueOf(number2).charAt(String.valueOf(number2).length()-2) == '.') {
                     return "√" + number + "/" + String.valueOf(number2).substring(0, String.valueOf(number2).length()-2);
                  } else {
                     return "√" + number + "/" + number2;
                  }
               }
            }
         }
      // } except {
      //       return "Проверьте правильность ввода";
      // }
   }
   
   public static void main(String args[]) {
      // String ur = "√4/4";
      // System.out.println("Ответ: " + VynosIzPodKoren(ur));
      try(FileWriter writer = new FileWriter("o.txt", false)) {
        // запись всей строки
         try {
            // читаем посимвольно
            File file = new File("ppp.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
               for (int i = 0; i < line.length()-3; i++) {
                  // System.out.println(line.substring(i, i+3) );
                  if (line.charAt(i) == 'в') {
                     System.out.println("a");
                     line = line.substring(0, i) + "√" + line.substring(i+3, line.length());
                     break;
                  }
               }
               System.out.println("Ответы: " + VynosIzPodKoren(line));
               writer.append(VynosIzPodKoren(line) + "\n");
               // считываем остальные строки в цикле
               line = reader.readLine();
               
            }
         } catch(IOException ex) {
               System.out.println(ex.getMessage());
         }   
     } catch(IOException ex) {
         System.out.println(ex.getMessage());
     } 
   }
}