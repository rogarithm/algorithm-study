package hackerrank;

public class CeasarCipher {

    public static void main(String[] args) {
        CeasarCipher tester = new CeasarCipher();
        System.out.println(tester.caesarCipher("middle-Outz", 1));
    }

    public String caesarCipher(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        if (k > 26) {
            k = k % 26;
        }

        for (char c : chars) {
            if (c >= 'a' && c <= 'z' && c + k <= 'z') {
                c += k;
                result.append(c);
            } else if (c >= 'a' && c <= 'z' && c + k > 'z') {
                int newC = (int) 'a' + c + k - (int) 'z' - 1;
                result.append((char) newC);
            } else if (c >= 'A' && c <= 'Z' && c + k <= 'Z') {
                c += k;
                result.append(c);
            } else if (c >= 'A' && c <= 'Z' && c + k > 'Z') {
                int newC = (int) 'A' + c + k - (int) 'Z' - 1;
                result.append((char) newC);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}