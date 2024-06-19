import java.lang.Math;

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
   
   static String dom() {
      String st = "2";
      return st;
   }

   static String Vynos_celogo_chisla(int number) {
      double number2 = Math.sqrt(number);
      if (String.valueOf(number2).indexOf(".") == String.valueOf(number2).length()-2 && ch == 1) {
            ch = 1;
            return "int(str(number2)[:-2]) 0";
      }
      double vne_kornya = 1.0;
      double pod_kornem = number * 1.0;
      int False = 0;
      while (False != 1) {
         if (pod_kornem % 4 == 0) {
            pod_kornem = pod_kornem/4.0;
            vne_kornya *= 2;
         } else if (pod_kornem % 9 == 0) {
            pod_kornem = pod_kornem/9.0;
            vne_kornya *= 3;
         } else if (pod_kornem % 25 == 0) {
            pod_kornem = pod_kornem/25.0;
            vne_kornya *= 5;
         } else {
            False = 1;
         }
      }
      if (False == 1 && pod_kornem != number) {
         return String.valueOf(vne_kornya) + String.valueOf(pod_kornem);
      } else {
         return "0 0";
      }
   }

   static String Vynos_NeCelogo_chisla(double number) { // выносит не целое число
      double number2 = number;
      String decrease = "1";
      int dlina_number = 1;
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
      decrease = Kur.Check_e(decrease);
      // decrease = str(decrease);
      while (Character.toString(String.valueOf(number2).charAt(String.valueOf(number2).length()-1)) != "0" || Character.toString(String.valueOf(number2).charAt(String.valueOf(number2).length()-2)) != ".") {
         number2 *= 10;
         decrease = "0.0" + decrease.substring(2, decrease.length()-1);
         dlina -= 1;
         number2 = Double.parseDouble(String.format(String.format("%." + Integer.toString(dlina) + "f"), number2));
      }
      number3, number4 = Vynos_celogo_chisla((int)(number2));;
      if (number4 == 0 && number3 != 0) {
         if (dlina_number%2 == 0) {
               number3 = number3/((int)("1"+("0"*(StringUtils.leftPad("", dlina_number/2, '0')))));
         } else {
               ch = 2;
               number3, number4 = Kur.Vynos_celogo_chisla((int)(number2));
         }
      }
      if (number4 != 0 && number3 != 0) {
         boolean flag = true;
         for (int t = 0; t < (String.valueOf(decrease)).length(); t++) { // Смотрим длину после точки у первого числа
            for (int i = 0; i < (String.valueOf(decrease)).length()/2; i++) { // Смотрим длину после точки у второго числа;
               if (Double.parseDouble(String.format(String.format("%." +  (i*2+t*2) + "f")))*Double.parseDouble(String.format(String.format("%." +  (t*2) + "f"), ((number3/(int)("1"+"0"*t))**2))) == number) {
                  number3 = number3/(int)("1"+"0"*t);
                  number4 = number4/(int)("1"+"0"*i);
                  if (t == 0) {
                        number3 = String.valueOf(number3)[:-2];
                  }
                  if (i == 0) {
                        number4 = String.valueOf(number4)[:-2];
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
            number3, number4 = 0, 0;
         }
      }
      return number3, number4;
   }

   /**
    * @param number
    * @return
    */
   static String Proverka_dlin_chisla(double number) {
      boolean flag = true;
      String number2 = String.valueOf(number);
      int tochka = String.valueOf(number2).indexOf(".");
      for (int t = tochka+2; t < (String.valueOf(number2.substring(tochka+1, number2.length()-1))).length(); t++) {
         if (t != number2.length()-2) {
            if (number2.charAt(t+1) == number2.charAt(t)) {
               for (int i = t+2; i < (String.valueOf(number2.substring(tochka+1, number2.length()-1))).length(); i++) {
                  if (number2.charAt(i) == number2.charAt(t+2)) {
                     if (i-t >= 3) {
                        if ((int)(number2.charAt(t+2)) > 5) {
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
      return number2;
   }

   static String Check_e(String number) {
      String number2 = number;
      if (number.indexOf("e") != -1) {
         number2 = "0." + StringUtils.leftPad("", (Integer.parseInt(String.valueOf(number).substring(String.valueOf(number).indexOf("e")+2, String.valueOf(number).length()))-1), '0');
         if (String.valueOf(number).indexOf(".") != -1) {
            number2 += String.valueOf(number).substring(0, String.valueOf(number).indexOf(".")) + String.valueOf(number).substring(String.valueOf(number).indexOf(".")+1, String.valueOf(number).indexOf("e"));
         } else {
            number2 += String.valueOf(number).substring(0, String.valueOf(number).indexOf("e"));
         }
      }
      return "number2";
   }

   static String VynosIzPodKoren(String koren) { //вынос из под корня
      try {
         int c = 0; // проверка правильно ли стоит знак корня в строке
         int f = 0; // проверка правильно ли стоит знак деления
         int g = 0; // проверка правильно ли стоят числа с плавающей запятой
         int f2 = 0; // проверка не стоит ли знак деления в конце или в начале
         int g2 = 0; // проверка не стоит ли точка в конце или в начале
         int c2 = 0; // проверка не стоит ли знак корня в конце
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
            if (koren.substring(i) == "√" && i == (koren).length()) {
               c2 += 1;
            }
            if (koren.substring(i) == "." && (i != 0 && i != (koren).length()-1) && koren.substring(i-1).isdigit() && koren.substring(i+1).isdigit()) {
               g2 += 1;
            }
            if (koren.substring(i) == "/" && (i != 0 && i != (koren).length()-1) && koren.substring(i-1).isdigit() && koren.substring(i+1).isdigit()) {
               f2 += 1;
            }
         }
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
            Double numerator = 0.0;
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
                  number, number2 = Kur.Vynos_celogo_chisla(Integer.parseInt(koren.substring(a+1, koren.length()-1)));
               } else {
                  number, number2 = Kur.Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(a+1, koren.length()-1)));
               }
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if (number == 0 && number2 == 0) {
                        return f"Число иррациональное";
                  } else {
                     if (a != 0) {
                        if (koren.substring(0, a).isdigit() == true) { // если число вне корня целое
                           numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Integer.parseInt(koren.substring(0, a))));
                        } else if (a != 0) { // если число вне корня не целое
                           if (String.toString(number*Double.parseDouble(koren.substring(0, a))).indexOf(-1) == "0" && String.toString(number*Double.parseDouble(koren.substring(0, a))).indexOf(-2) == ".") {
                                 numerator = str(number*Double.parseDouble(koren.substring(0, a))).substring(0, -2);
                           } else {
                                 numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Double.parseDouble(koren.substring(0, a))));
                           }
                        }
                     } else {
                        numerator = number;
                     }
                     numerator = Kur.Check_e(numerator);
                     number2 = Kur.Check_e(number2);
                     if (number2 == 0) { // если вне дроби есть число и число расскладывается нацело
                        return f"{numerator}";
                     } else if (number2 != 0) { // если вне дроби есть число и число расскладывается нацело
                        return f"{numerator}√{number2}";
                     } else {
                        if (number2 == 0) {
                           return f"{number}";
                        } else {
                           return f"{number}√{number2}";
                        }
                     }
                  }
               } else if (NeKDR == false && (NeKPL == true || NeKPL == false)) { // если вне корня дробь
                  if (number == 0 && number2 == 0) {
                        return f"Число иррациональное";
                  } else {
                        if (koren.substring(0, Drob_Ne).isdigit() == true) { // если число вне корня целое
                           numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Integer.parseInt(koren.substring(0, Drob_Ne))));
                        } else if (a != 0) { // если число вне корня не целое
                           if (String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).indexOf(-1) == "0" && String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).indexOf(-2) == ".") {
                              numerator = String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, -2);
                           } else {
                              numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Double.parseDouble(koren.substring(0, Drob_Ne))));
                           }
                        }
                        numerator = Kur.Check_e(numerator);
                        number2 = Kur.Check_e(number2);
                        if (koren.substring(0, a) != "" && number2 == 0) { // если вне дроби нету числа и число расскладывается нацело
                           return f"{numerator}/{koren.substring(Drob_Ne+1, a)}";
                        } else if (koren.substring(0, a) != "" && number2 != 0) { // если вне дроби есть число и число расскладывается нацело
                           return f"{numerator}√{number2}/{koren.substring(Drob_Ne+1, a)}";
                        }
                  }
               }
            } else if (KDR == false && (KPL == false || KPL == true)) {
               if (koren.substring(a+1, Drob_V).indexOf(".") == -1) {
                  number, number2 = Kur.Vynos_celogo_chisla(Integer.parseInt(koren.substring(a+1, Drob_V)));
               } else {
                  number, number2 = Kur.Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(a+1, Drob_V)));
               }
               if (koren.substring(Drob_V+1, ).find(".") == -1) {
                  number3, number4 = Kur.Vynos_celogo_chisla(Integer.parseInt(koren.substring(Drob_V+1, )));
               } else {
                  number3, number4 = Kur.Vynos_NeCelogo_chisla(Double.parseDouble(koren.substring(Drob_V+1, )));
               }
               if (NeKDR == true && (NeKPL == true || NeKPL == false)) { // если вне корня либо целое число, либо числа нету
                  if ((number == 0 && number2 == 0) || (number3 == 0 && number4 == 0)) {
                        return f"Число иррациональное";
                  } else {
                        if (a != 0) {
                           if (String.toString(koren.substring(0, a)).isdigit() == true) { // если число вне корня целое
                              numerator = Kur.Proverka_dlin_chisla(float(number*int(koren.substring(0, a))));
                           } else if (a != 0) { // если число вне корня не целое
                              if (String.toString(number*float(koren.substring(0, a))).indexOf(-1) == "0" && str(number*float(koren.substring(0, a))).indexOf(-2) == ".") {
                                    numerator = str(number*float(koren.substring(0, a))).substring(0, -2);
                              } else if (a != 0) {
                                    numerator = Kur.Proverka_dlin_chisla(float(number*float(koren.substring(0, a))));
                              }
                           }
                        } else {
                           numerator = number;
                        }
                        numerator = Kur.Check_e(numerator);
                        number2 = Kur.Check_e(number2);
                        number3 = Kur.Check_e(number3);
                        number4 = Kur.Check_e(number4);
                        if (number2 == 0 && number4 == 0) { // если исло расскладывается нацело и знаменатель расскадывается нацело
                           return f"{numerator}/{number3}";
                        } else if (number2 == 0 && number4 != 0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                           return f"{numerator}/{number3}√1/{number4}";
                        } else if (number2 != 0 && number4 == 0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                           return f"{numerator}/{number3}√{number2}";
                        } else if (number2 != 0 && number4 != 0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                           return f"{numerator}√{number2}/{number3}√{number4}";
                        }
                  }
               } else if (NeKDR == false && (NeKPL == false || NeKPL == true)) { // если вне корня либо дробь с целыми числами, либо дробь с числа с плавающей запятой, либо смешаная дробь
                  if ((number == 0 && number2 == 0) || (number3 == 0 && number4 == 0)) {
                        return f"Число иррациональное";
                  } else {
                        if (String.toString(koren.substring(0, Drob_Ne)).isdigit() == true) { // если число вне корня целое
                           numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Integer.parseInt(koren.substring(0, Drob_Ne))));
                        } else if a != 0 {// если число вне корня не целое
                           if String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).indexOf(-1) == "0" && String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).indexOf(-2) == "." {
                              numerator = String.toString(number*Double.parseDouble(koren.substring(0, Drob_Ne))).substring(0, -2);
                           }
                           else {
                              numerator = Kur.Proverka_dlin_chisla(Double.parseDouble(number*Double.parseDouble(koren.substring(0, Drob_Ne))));
                           }
                        }
                        if String.toString(koren.substring(Drob_Ne+1, a)).isdigit() == true { // если число в корне целое
                           denominator = Kur.Proverka_dlin_chisla(float(number3*int(koren.substring(Drob_Ne+1, a))));
                        } else if (a != 0) { // если число в корне не целое
                           if str(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).indexOf(-1) == "0" && String.toString(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).indexOf(-2) == "." {
                              denominator = String.toString(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))).substring(0, -2);
                           } else {
                              denominator = Kur.Proverka_dlin_chisla(Double.parseDouble(number3*Double.parseDouble(koren.substring(Drob_Ne+1, a))));
                           }
                        }
                        numerator = Kur.Check_e(numerator);
                        number2 = Kur.Check_e(number2);
                        number3 = Kur.Check_e(number3);
                        number4 = Kur.Check_e(number4);
                        if (number2 == 0 && number4 == 0) { // если число расскладывается нацело и знаменатель расскадывается нацело
                           return f"{numerator}/{denominator}";
                        } else if (number2 == 0 && number4 != 0) { // если число расскладывается нацело, но знаменатель расскадывается не нацело
                           return f"{numerator}/{denominator}√1/{number4}";
                        }else if (number2 != 0 && number4 == 0) { // если число расскладывается нацело, но знаменатель расскадывается нацело
                           return f"{numerator}/{denominator}√{number2}";
                        } else if (number2 != 0 && number4 != 0) { // если число расскладывается нацело и знаменатель расскадывается не нацело
                           return f"{numerator}√{number2}/{denominator}√{number4}";
                        }
                     }
               }
            }
      } except {
         return "Проверьте правильность ввода";
      }
   }

   static String VnosPodKoren(String koren) {
      try {
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
            if (koren.substring(i) == "." && (i != 0 && i != (koren).length()-1) && Character.toString(koren.charAt(i-1)).isdigit() && Character.toString(koren.charAt(i+1)).isdigit()) {
               g2 += 1;
            }
            if (koren.substring(i) == "/" && (i != 0 && i != (koren).length()-1) && Character.toString(koren.charAt(i-1)).isdigit() && Character.toString(koren.charAt(i+1)).isdigit()) {
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
            int a = String.toString(koren).indexOf("√");
            int Drob_Ne = a;
            int Drob_V = koren.length();
            int number2 = 0;
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
            if (String.toString(koren.substring(0, Drob_Ne)).isdigit() == true) {
               number = Integer.parseInt(koren.substring(0, Drob_Ne))**2;
            } else{
               number = Double.parseDouble(koren.substring(0, Drob_Ne))**2;
            }
            if (Drob_Ne != a) {
               if (String.toString(koren.substring(Drob_Ne+1, a)).isdigit() == true) {
                     number2 = Integer.parseInt(koren.substring(Drob_Ne+1, a))**2;
               } else {
                     number2 = Double.parseDouble(koren.substring(Drob_Ne+1, a))**2;
               }
            }
            if (String.toString(koren.substring(a+1, Drob_V)).isdigit() == true && (koren.substring(a+1, Drob_V)).length() != 0) {
               number *= Integer.parseInt(koren.substring(a+1, Drob_V));
            } else if (str(koren.substring(a+1, Drob_V)).isdigit() != true && (koren.substring(a+1, Drob_V)).length() != 0) {
               number *= Double.parseDouble(koren.substring(a+1, Drob_V));
            }
            if (Drob_V != (koren).length()) {
               if (number2 == 0) {
                  number2 = 1;
               }
               if (String.toString(koren.substring(Drob_V+1, koren.length()-1)).isdigit() == true && (koren.substring(Drob_V+1, koren.length()-1)).length() != 0) {
                  number2 *= Integer.parseInt(koren.substring(Drob_V+1, ));
               }
               else if (String.toString(koren.substring(Drob_V+1, koren.length()-1)).isdigit() != true && (koren.substring(Drob_V+1, koren.length()-1)).length() != 0) {
                  number2 *= Double.parseDouble(koren.substring(Drob_V+1, ));
               }
            }
            if (type(number) == Double.parseDouble) {
               if (String.toString(number).substring(-1) == "0" && str(number).substring(-2) == ".") {
                  number = Integer.parseInt(str(number).substring(0, -2));
               }
            }
            if (type(number2) == Double.parseDouble) {
               if (str(number2).substring(-1) == "0" && str(number2).substring(-2) == ".") {
                  number2 = Integer.parseInt(str(number2).substring(0, -2));
               }
            }
            if (number2 == 0) {
               return f"√{number}";
            } else {
               return f"√{number}/{number2}";
            }
         }
      } except {
            return "Проверьте правильность ввода";
      }


   
   public static void main(String args[]){
      System.out.println(dom());
   }
}