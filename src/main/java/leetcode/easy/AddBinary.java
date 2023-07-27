package leetcode.easy;

class AddBinary {

    public static void main(String[] args) {
        AddBinary t = new AddBinary();
        // t.nthElem("10", 2);
        // t.nthElem("102", 3);
        // t.nthElem("1021234", 7);

        // System.out.println("".concat("2"));
        System.out.println("result is: " + t.addBinary("100", "101") + "should be 102");
        // t.addBinary("10", "1");
        // t.addBinary("100", "11");
    }

    public String addBinary(String a, String b) {
        // int lenResult = len1 > len2 ? len1 : len2;
        // char[] rev1 = new StringBuilder(a).reverse().toString().toCharArray();
        // char[] rev2 = new StringBuilder(b).reverse().toString().toCharArray();
        String result = "";
        String currentSum = "";

        for (int n = a.length(); n > 0; n--) {
            String elem1 = nthElem(a, n);
            String elem2 = nthElem(b, n);
            currentSum = addElement(elem1, elem2);
            System.out.println("adding " + currentSum + "...");
            result = result.concat(currentSum);
            System.out.println("current result: " + result);
        }
        return result;
    }

    public String nthElem(String number, int nthIdx) {
        String elem = number.substring(nthIdx - 1, nthIdx);
        System.out.println(nthIdx + "th element of " + number + "is " + elem);
        return elem;
    }

    public String addElement(String elem1, String elem2) {
        System.out.println("addElement elem1: " + elem1);
        System.out.println("addElement elem2: " + elem2);
        String result = new String("");
        if (elem1.equals("0") && elem2.equals("0")) {
            System.out.println("e1 is 0 n e2 is 0");
            result = "0";
        }
        if ((elem1.equals("1") && elem2.equals("0")) || (elem1.equals("0") && elem2.equals("1"))) {
            System.out.println("e1 or e2 is 1");
            result = "1";
        }
        if (elem1.equals("1") && elem2.equals("1")) {
            System.out.println("e1 and e2 is 1");
            result = "2";
        }
        System.out.println("addElement result: " + result);
        return result;
    }
}