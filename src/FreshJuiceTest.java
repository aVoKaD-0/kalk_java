package src;
import java.lang.Math;
import org.apache.commons.lang3.StringUtils;

public class FreshJuiceTest {

   static int ch = 1;
   static double x1;
   static double x2;
   static double y1;
   static double y2;
   static double x1z;
   static double x2z;
   static double y1z;
   static double y2z;
   
   // static String dom() {
   //    String st = "2";
   //    return st;
   // }

   static int[] Vynos_celogo_chisla(int number) {
      double number2 = Math.sqrt(number);
      if (String.valueOf(number2).indexOf(".") == String.valueOf(number2).length()-2 && ch == 1) {
            ch = 1;
            return new int[]{Integer.parseInt(String.valueOf(number2).substring(0, String.valueOf(number2).length())), 0};
      }
      int vne_kornya = 1;
      int pod_kornem = number * 1;
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
         return new int[] {vne_kornya, pod_kornem};
      } else {
         return new int[] {0, 0};
      }
   }

   static Double[] Vynos_NeCelogo_chisla(double number) { // выносит не целое число
      double number2 = number;
      String decrease = "1";
      int dlina_number = 1;
      double number3;
      double number4;
      int[] celiy;
      for (int i = String.valueOf(number2).length()-1; i > 0; i--) {
         if (Character.toString(String.valueOf(number2).charAt(i)) == "e") {
            decrease += StringUtils.leftPad("", Integer.parseInt(String.valueOf(number2).substring(i+2, decrease.length()-1)), '0');
            if (String.valueOf(number2).indexOf(".") != -1) {
               dlina_number = Integer.parseInt(String.valueOf(number2).substring(i+2, String.valueOf(number2).length()-1))+1;
            } else {
               dlina_number = Integer.parseInt(String.valueOf(number2).substring(i+2, String.valueOf(number2).length()-1));
            }
            break;
         }
      }
      number2 *= Double.parseDouble(decrease);
      double decrease2 = 1/Integer.parseInt(decrease);
      int dlina = String.valueOf(number2).substring((String.valueOf(number2).indexOf("."))+1, String.valueOf(number2).length()-1).length();
      if (dlina_number == 1) {
         dlina_number = dlina;
      }
      if (decrease2 != 1.0) {
         number2 = Double.parseDouble(String.format("%.1f", number2));
      }
      decrease = String.valueOf(Check_e(decrease));
      // decrease = str(decrease);
      while (Character.toString(String.valueOf(number2).charAt(String.valueOf(number2).length()-1)) != "0" || Character.toString(String.valueOf(number2).charAt(String.valueOf(number2).length()-2)) != ".") {
         number2 *= 10;
         decrease = "0.0" + decrease.substring(2, decrease.length()-1);
         dlina -= 1;
         number2 = Double.parseDouble(String.format(String.format("%." + String.valueOf(dlina) + "f"), number2));
      }
      celiy = Vynos_celogo_chisla((int)(number2));
      number3 = celiy[0];
      number4 = celiy[1];
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
      if (number4 != 0 && number3 != 0) {
         boolean flag = true;
         for (int t = 0; t < (String.valueOf(decrease)).length(); t++) { // Смотрим длину после точки у первого числа
            for (int i = 0; i < (String.valueOf(decrease)).length()/2; i++) { // Смотрим длину после точки у второго числа;
               if (Math.round((Math.round((Math.pow((number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')))), 2))*Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))*Math.round((number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0'))))*Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d")*Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d") == number) {
                  number3 = number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')));
                  number4 = number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0')));
                  if (t == 0) {
                        number3 = Double.parseDouble(String.valueOf(number3).substring(0, String.valueOf(number3).length()-3));
                  }
                  if (i == 0) {
                        number4 = Double.parseDouble(String.valueOf(number4).substring(0, String.valueOf(number4).length()-3));
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
      for (int t = tochka+2; t < (String.valueOf(number2.substring(tochka+1, number2.length()-1))).length(); t++) {
         if (t != number2.length()-2) {
            if (number2.charAt(t+1) == number2.charAt(t)) {
               for (int i = t+2; i < (String.valueOf(number2.substring(tochka+1, number2.length()-1))).length(); i++) {
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
      if (Character.toString(number2.charAt(number2.length()-2)) == "0" && Character.toString(number2.charAt(number2.length()-3)) == ".") {
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
            if (Character.toString(koren.charAt(i)) == "√") {
               c += 1;
               System.out.println("a");
            }
            if (Character.toString(koren.charAt(i)) == "/") {
               f += 1;
               System.out.println("b");
            }
            if (Character.toString(koren.charAt(i)) == ".") {
               g += 1;
               System.out.println("c");
            }
            if (Character.toString(koren.charAt(i)) == "√" && i == (koren).length()) {
               c2 += 1;
               System.out.println("d");
            }
            if (Character.toString(koren.charAt(i)) == "." && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(koren.substring(i-1)) && StringUtils.isNumeric(koren.substring(i-1))) {
               g2 += 1;
               System.out.println("f");
            }
            if (Character.toString(koren.charAt(i)) == "/" && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(koren.substring(i-1)) && StringUtils.isNumeric(koren.substring(i-1))) {
               f2 += 1;
               System.out.println("j");
            }
            System.out.println(i + " " + Character.toString(koren.charAt(i)));
         }
         System.out.println(g + " " + c + " " + f + " " + f2 + " " + g2 + " " + c2 + " " + (koren).length());
         if (g > 4 || c != 1 || f > 2 || f != f2 || g != g2 || c2 != 0) {
               return "Проверьте правильность ввода";
         } else if (koren.length() == 1) {
               return "Проверьте правильность ввода";
         } else {
            int a = koren.indexOf("√");
            boolean NeKPL = true; // проверяет есть ли число с плавающей запятой вне корня
            boolean KPL = true; // проверяет есть ли число с плавающей запятой под корнем
            boolean KDR = true; // проверяет есть ли дробь под корняем
            boolean NeKDR = true; // проверяет есть ли дробь вне корня
            int Drob_Ne = 0;
            int Drob_V = 0;
            Object numerator = 0;
            Object number = 0;
            Object number2 = 0;
            Object number3 = 0;
            Object number4 = 0;
            Object denominator = 0;
            Double[] neceliy;
            int[] celiy;
            for (int i = 0; i < koren.length(); i++) {
               if (koren.substring(i) == ".") {
                  KPL = false;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.substring(i) ==".") {
                  NeKPL = false;
               }
            }
            for (int i = 0; i < koren.length(); i++) {
               if (koren.substring(i) == "/") {
                  KDR = false;
                  Drob_V = i;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.substring(i) == "/") {
                  NeKDR = false;
                  Drob_Ne = i;
               }
            }
            if (KDR == true && (KPL == true || KPL == false)) {
               if (koren.substring(a+1, koren.length()-1).indexOf(".") == -1) {
                  celiy = Vynos_celogo_chisla(Integer.parseInt(koren.substring(a+1, koren.length()-1)));
                  number = celiy[0];
                  number2 = celiy[1];
               } else {
                  neceliy = Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(a+1, koren.length()-1)));
                  number = neceliy[0];
                  number2 = neceliy[1];
               }
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if ((Double)(number) == 0.0 && (Double)number2 == 0.0) {
                        return "Число иррациональное";
                  } else {
                     if (a != 0) {
                        // if (number_d == 0 && celiy.length != 0) {
                        //    int number = number_i;
                        // } else {
                        //    Double number = number_d;
                        // }
                        if (StringUtils.isNumeric(koren.substring(0, a)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((Double)((Double)(number)*Double.parseDouble(koren.substring(0, a))));
                        } else if (a != 0) { // если число вне корня не целое
                           if (Character.toString(String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, a))).charAt(-1)) == "0" && Character.toString(String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, a))).charAt(-2)) == ".") {
                                 numerator = Double.parseDouble(String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, a))).substring(0, String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, a))).length()-3));
                           } else {
                                 numerator = Proverka_dlin_chisla(((Double)(number))*Double.parseDouble(koren.substring(0, a)));
                           }
                        }
                     } else {
                        numerator = number;
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     if ((Double)number2 == 0.0) { // если вне дроби есть число и число расскладывается нацело
                        return String.valueOf(numerator);
                     } else if ((Double)number2 != 0.0) { // если вне дроби есть число и число расскладывается нацело
                        return numerator + "√" + number2;
                     } else {
                        if ((Double)number2 == 0.0) {
                           return String.valueOf(number);
                        } else {
                           return number + "√" + number2;
                        }
                     }
                  }
               } else if (NeKDR == false && (NeKPL == true || NeKPL == false)) { // если вне корня дробь
                  if ((Double)number == 0.0 && (Double)number2 == 0.0) {
                        return "Число иррациональное";
                  } else {
                        if (StringUtils.isNumeric(koren.substring(0, Drob_Ne)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((Double)(((Double)(number))*Integer.parseInt(koren.substring(0, Drob_Ne))));
                        } else if (a != 0) { // если число вне корня не целое
                           if (Character.toString(String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-1)) == "0" && Character.toString(String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-2)) == ".") {
                              numerator = String.valueOf(((Double)(number))*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, -2);
                           } else {
                              numerator = Proverka_dlin_chisla((Double)(((Double)(number))*Double.parseDouble(koren.substring(0, Drob_Ne))));
                           }
                        }
                        numerator = Check_e(String.valueOf(numerator));
                        number2 = Check_e(String.valueOf(number2));
                        if (koren.substring(0, a) != "" && (Double)number2 == 0.0) { // если вне дроби нету числа и число расскладывается нацело
                           return numerator + "/" + koren.substring(Drob_Ne+1, a);
                        } else if (koren.substring(0, a) != "" && (Double)number2 != 0.0) { // если вне дроби есть число и число расскладывается нацело
                           return numerator + "√" +number2 + "/" + koren.substring(Drob_Ne+1, a);
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
                  celiy = Vynos_celogo_chisla(Integer.parseInt(koren.substring(Drob_V+1, koren.length()-1)));
                  number3 = celiy[0];
                  number4 = celiy[1];
               } else {
                  neceliy = Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(Drob_V+1, koren.length()-1)));
                  number3 = neceliy[0];
                  number4 = neceliy[1];
               }
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if (((Double)number == 0.0 && (Double)number2 == 0.0) || ((Double)number3 == 0.0 && (Double)number4 == 0.0)) {
                     return "Число иррациональное";
                  } else {
                     if (a != 0) {
                        if (StringUtils.isNumeric(koren.substring(0, a)) == true) { // если число вне корня целое
                           numerator = Proverka_dlin_chisla((Double)((Double)number*Integer.parseInt(koren.substring(0, a))));
                        } else if (a != 0) { // если число вне корня не целое
                           if (Character.toString(String.valueOf((Double)number*Double.parseDouble(koren.substring(0, a))).charAt(-1)) == "0" && Character.toString(String.valueOf((Double)number*Double.parseDouble(koren.substring(0, a))).charAt(-2)) == ".") {
                                 numerator = String.valueOf((Double)number*Double.parseDouble(koren.substring(0, a))).substring(0, -2);
                           } else if (a != 0) {
                                 numerator = Proverka_dlin_chisla((Double)((Double)number*Double.parseDouble(koren.substring(0, a))));
                           }
                        }
                     } else {
                        numerator = number;
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     number3 = Check_e(String.valueOf(number3));
                     number4 = Check_e(String.valueOf(number4));
                     if ((Double)number2 == 0.0 && (Double)number4 == 0.0) { // если исло расскладывается нацело и знаменатель расскадывается нацело
                        return numerator + "/" + number3;
                     } else if ((Double)number2 == 0.0 && (Double)number4 != 0.0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                        return numerator + "/" + number3 + "√1/" + number4;
                     } else if ((Double)number2 != 0.0 && (Double)number4 == 0.0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                        return numerator + "/" + number3 + "√" + number2;
                     } else if ((Double)number2 != 0.0 && (Double)number4 != 0.0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                        return numerator + "√" + number2 + "/" + number3 + "√" + number4;
                     }
                  }
               } else if (NeKDR == false && (NeKPL == false || NeKPL == true)) { // если вне корня либо дробь с целыми числами, либо дробь с числа с плавающей запятой, либо смешаная дробь
                  if (((Double)number == 0.0 && (Double)number2 == 0.0) || ((Double)number3 == 0.0 && (Double)number4 == 0.0)) {
                     return "Число иррациональное";
                  } else {
                     if (StringUtils.isNumeric(String.valueOf(koren.substring(0, Drob_Ne))) == true) { // если число вне корня целое
                        numerator = Proverka_dlin_chisla((Double)((Double)number*Integer.parseInt(koren.substring(0, Drob_Ne))));
                     } else if (a != 0) {// если число вне корня не целое
                        if (Character.toString(String.valueOf((Double)number*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-1)) == "0" && Character.toString(String.valueOf((Double)number*Double.parseDouble(koren.substring(0, Drob_Ne))).charAt(-2)) == ".") {
                           numerator = String.valueOf((Double)number*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, -2);
                        } else {
                           numerator = Proverka_dlin_chisla((Double)((Double)number*Double.parseDouble(koren.substring(0, Drob_Ne))));
                        }
                     }
                     if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_Ne+1, a))) == true) { // если число в корне целое
                        denominator = Proverka_dlin_chisla(((Double)number3*Integer.parseInt(koren.substring(Drob_Ne+1, a))));
                     } else if (a != 0) { // если число в корне не целое
                        if (Character.toString(String.valueOf((Double)number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).charAt(-1)) == "0" && Character.toString(String.valueOf((Double)number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).charAt(-2)) == ".") {
                           denominator = String.valueOf((Double)number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).substring(0, -2);
                        } else {
                           denominator = Proverka_dlin_chisla(((Double)number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))));
                        }
                     }
                     numerator = Check_e(String.valueOf(numerator));
                     number2 = Check_e(String.valueOf(number2));
                     number3 = Check_e(String.valueOf(number3));
                     number4 = Check_e(String.valueOf(number4));
                     if ((Double)number2 == 0.0 && (Double)number4 == 0.0) { // если число расскладывается нацело и знаменатель расскадывается нацело
                        return numerator + "/" + denominator;
                     } else if ((Double)number2 == 0.0 && (Double)number4 != 0.0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                        return numerator + "/" + denominator + "√1/" + number4;
                     }else if ((Double)number2 != 0.0 && (Double)number4 == 0.0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                        return numerator + "/" + denominator + "√" + number2;
                     } else if ((Double)number2 != 0.0 && (Double)number4 != 0.0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                        return numerator + "√" + number2 + "/" + denominator + "√" + number4;
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
         for (int i = 0; i < (koren).length()-1; i++) {
            if (koren.substring(i) == "√") {
               c += 1;
            }
            if (koren.substring(i) == "/") {
               f += 1;
            }
            if (koren.substring(i) == ".") {
               g += 1;
            }
            if (koren.substring(i) == "√" && i == 0) {
               c2 += 1;
            }
            if (koren.substring(i) == "." && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1)))) {
               g2 += 1;
            }
            if (koren.substring(i) == "/" && (i != 0 && i != (koren).length()-1) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1))) && StringUtils.isNumeric(Character.toString(koren.charAt(i-1)))) {
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
            Object number = 0;
            Object number2 = 0;
            // Object number3 = 0;
            // Object number4 = 0;
            for (int i = 0; i < (koren).length(); i++) {
               if (koren.substring(i) == "/") {
                     Drob_V = i;
               }
            }
            for (int i = 0; i < a; i++) {
               if (koren.substring(i) == "/") {
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
               number = (Double)number*Integer.parseInt(koren.substring(a+1, Drob_V));
            } else if (StringUtils.isNumeric(String.valueOf(koren.substring(a+1, Drob_V))) != true && (koren.substring(a+1, Drob_V)).length() != 0) {
               number = (Double)number*Double.parseDouble(koren.substring(a+1, Drob_V));
            }
            if (Drob_V != (koren).length()) {
               if ((Double)number2 == 0.0) {
                  number2 = 1.0;
               }
               if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_V+1, koren.length()-1))) == true && (koren.substring(Drob_V+1, koren.length()-1)).length() != 0) {
                  number2 = (Double)number2*Integer.parseInt(koren.substring(Drob_V+1, koren.length()-1));
               }
               else if (StringUtils.isNumeric(String.valueOf(koren.substring(Drob_V+1, koren.length()-1))) != true && (koren.substring(Drob_V+1, koren.length()-1)).length() != 0) {
                  number2 = (Double)number2*Double.parseDouble(koren.substring(Drob_V+1, koren.length()-1));
               }
            }
            if ((number).getClass().getSimpleName() == "Double") {
               if (String.valueOf(number).substring(-1) == "0" && String.valueOf(number).substring(-2) == ".") {
                  number = Integer.parseInt(String.valueOf(number).substring(0, String.valueOf(number).length()-3));
               }
            }
            if ((number2).getClass().getSimpleName() == "Double") {
               if (String.valueOf(number2).substring(-1) == "0" && String.valueOf(number2).substring(-2) == ".") {
                  number2 = Integer.parseInt(String.valueOf(number2).substring(0, -2));
               }
            }
            if ((Double)number2 == 0.0) {
               return "√" + number;
            } else {
               return "√" + number + "/" + number2;
            }
         }
      // } except {
      //       return "Проверьте правильность ввода";
      // }
   }
   
   public static void main(String args[]) {
      String ur = "√144";
      System.out.println(VynosIzPodKoren(ur));
   }
}