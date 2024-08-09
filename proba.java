import java.lang.Math;

// import org.apache.commons.lang3.StringUtils;

// import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class proba {
    static String Kalk(String ur) {
        int a = 0;
        int a2 = 0;
        for (int i = ur.indexOf('*'); i > -2; i = a) {
            if (ur.indexOf("**") != -1) {
                int u = Math.min(ur.substring(a+1, ur.length()-1).indexOf('*'), ur.substring(a+1, ur.length()-1).indexOf('/'));
                int u2 = Math.min(ur.substring(a+1, ur.length()-1).indexOf('+'), ur.substring(a+1, ur.length()-1).indexOf('-'));
                u = Math.min(u, u2);
                a2 = a;
                ur = ur.substring(0, ur.indexOf("**")-1) + Double.toString(Math.pow(Integer.parseInt(ur.substring(a, ur.indexOf("**")-1)), u)) + ur.substring(ur.indexOf("**"), ur.length()-1);
                a = a2;
            } else if ((ur.indexOf('*') < ur.indexOf('/')) && ur.indexOf('*') != -1) {
                int u = Math.min(ur.substring(a+1, ur.length()-1).indexOf('*'), ur.substring(a+1, ur.length()-1).indexOf('/'));
                int u2 = Math.min(ur.substring(a+1, ur.length()-1).indexOf('+'), ur.substring(a+1, ur.length()-1).indexOf('-'));
                u = Math.min(u, u2);
                a2 = a;
                ur = ur.substring(0, ur.indexOf("**")-1) + Double.toString(Math.pow(Integer.parseInt(ur.substring(a, ur.indexOf("**")-1)), u)) + ur.substring(ur.indexOf("**"), ur.length()-1);
                a = a2;
                a = u;
            } else if ((ur.indexOf('/') < ur.indexOf('*')) && ur.indexOf('/') != -1) {
                int u = Math.min(ur.substring(a+1, ur.length()-1).indexOf('*'), ur.substring(a+1, ur.length()-1).indexOf('/'));
                int u2 = Math.min(ur.substring(a+1, ur.length()-1).indexOf('+'), ur.substring(a+1, ur.length()-1).indexOf('-'));
                u = Math.min(u, u2);
                a2 = a;
                ur = ur.substring(0, ur.indexOf("**")-1) + Double.toString(Math.pow(Integer.parseInt(ur.substring(a, ur.indexOf("**")-1)), u)) + ur.substring(ur.indexOf("**"), ur.length()-1);
                a = a2;
                a = u;
            } else if ((ur.indexOf('+') < ur.indexOf('-')) && ur.indexOf('+') != -1) {
                a = ur.indexOf('+');
            } else if ((ur.indexOf('-') < ur.indexOf('+')) && ur.indexOf('-') != -1) {
                a = ur.indexOf('-');
            } else {
                a = -3;
            }
        }
        return ur;
    }
    public static void main(String args[]) {
        String a = "16x**2-2x+4=0";
        // ArrayList<Integer> ind_num = new ArrayList<>();
        int sv_ch = 0;
        int in = 0;
        for (int i = 0; i < a.length()-1; i++) {
            // System.out.println(Character.toString(a.charAt(i)));
            // System.out.println(i + " " + Character.toString(a.charAt(i)));
            if ((a.charAt(i) == '+' || a.charAt(i) == '-' || a.charAt(i) == '/' || (a.charAt(i) == '*' && a.charAt(i+1) != '*' && a.charAt(i+2) != 'x'))) {
                in = i;
            }
            if (StringUtils.isNumeric(Character.toString(a.charAt(i))) == true && (a.charAt(i+1) == '=' || a.charAt(i+1) == '+' || a.charAt(i+1) == '-' || a.charAt(i+1) == '/' || (a.charAt(i+1) == '*' && a.charAt(i+2) != '*' && a.charAt(i+3) != 'x'))) {
                sv_ch = Integer.parseInt(a.substring(in+1, i+1));
                // for (int t = 1; t < a.length(); t++) {
                //     if (a.charAt(t) == 'x') {
                //         if (a.charAt(i-1) != '*') {
                //             a = a.substring(0, t) + "*" + a.substring(t, a.length());
                //             t += 2;
                //         }
                //     }
                // }
            }
            if (a.charAt(i) == 'x' && i != 0) {
                a = a.substring(0, i) + "*" + a.substring(i, a.length());
                i += 1;
                in += 1;
            }
        }
        int x = 0;
        int n = 0;
        System.out.println(a + " " + sv_ch);
        for (int i = 1; i < sv_ch/2+1; i++) {
            if (sv_ch % i == 0) {
                String a2 = a;
                String a3 = a;
                for (int t = a2.indexOf('x'); t != -1; t = a2.indexOf('x')) {
                    a2 = a2.substring(0, t) + String.valueOf(i) + a2.substring(t+1, a2.length());
                }
                int i2 = i*-1;
                for (int t = a3.indexOf('x'); t != -1; t = a3.indexOf('x')) {
                    a3 = a3.substring(0, t) + String.valueOf(i2) + a3.substring(t+1, a3.length());
                }
                System.out.println(a2 + " " + a3);
            }
        }
    }
}
