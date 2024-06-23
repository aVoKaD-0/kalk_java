import java.lang.Math;

import org.apache.commons.lang3.StringUtils;

public class proba {
    public static void main(String args[]) {
        int d = 4;
        int a = 2;
        System.out.println(Math.pow(d, a));
        Double d2 = 2.1236;
        int a2 = 2;
        System.out.println(Math.round(2.1236*Double.parseDouble("1"+(StringUtils.leftPad("", a2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", a2, '0')) + "d") + "\n");
        System.out.println(Integer.parseInt("1"+(StringUtils.leftPad("", 3, '0'))));
        Double number3 = 1.44;
        Double number4 = 0.64;
        int i = 2;
        int t = 4;
        System.out.println(Math.round((Math.round((Math.pow((number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')))), 2))*Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))*Math.round((number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0'))))*Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d")*Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d"));
                        System.out.println((Math.round((Math.pow((number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')))), 2))*Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))*Math.round((number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0'))))*Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"));
        // round(round(((number3/int("1"+"0"*t))**2), t*2)*round((number4/int("1"+"0"*i)), i*2), i*2+t*2) == number
        // if (Math.round((Math.round((Math.pow((number3/Integer.parseInt("1"+(StringUtils.leftPad("", t, '0')))), 2))*Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", t*2, '0')) + "d"))*Math.round((number4/Integer.parseInt("1"+(StringUtils.leftPad("", i, '0'))))*Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2, '0')) + "d")*Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d"))/Double.parseDouble("1"+(StringUtils.leftPad("", i*2+t*2, '0')) + "d") == number) {

        // }
        Object n;
        n = 2;
        System.out.println(d2.getClass().getSimpleName() + n);
        n = 2.9;
        System.out.println(n);
    }
}
