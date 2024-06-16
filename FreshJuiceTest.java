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

   static String  Check_e(String number) {
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
   
   public static void main(String args[]){
      System.out.println(dom());
   }
}