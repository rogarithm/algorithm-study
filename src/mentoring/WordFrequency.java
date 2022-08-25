import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 문자열 리스트 words 를 입력받으면, 문자열의 공백과 대소문자 구분은 하지 않은채로, 각 단어의 빈도수 를 리턴하는 함수를 작성해주세요.
// 예시
// input : [“apple”, “book”, “Apple “]
// output : mapOf(“apple”,2 , “book”, 1)
// (apple 이라는 key 의 value 가 2 이고,  book 이라는 key 의 value 가 1 인 Map)
public class WordFrequency {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("apple");
        test.add("book");
        test.add("Apple ");
        test.add("aPple");
        test.add("cargo");
        test.add("cargO");
        test.add("aPPle");

        System.out.println(solution(test));
    }

    public static Map<String, Integer> solution(List<String> words) {
        Map<String, Integer> result = new HashMap<>();
        // 대소문자 구분 처리? 먼저 대문자를 모두 소문자로 바꾸는 것은 어떨까?
        for (int i=0; i<words.size(); i++) {
            words.set(i, words.get(i).toLowerCase());
            words.set(i, words.get(i).trim());
        }
        // System.out.println("after toLowerCase, " + words);
        // result에 키와 빈도수를 추가한다.
        // 다음 키가 이미 존재한다면, 그 키의 빈도수를 높이고, 아니라면 새로운 키를 만들고 빈도수를 하나 높인다.
        // 단어에 대한 키와 값을 추가한다. 메서드?
        for (String word : words) {
            if (!result.containsKey(word)) { // containsKey가 apple과 apple을 비교 못하나? hashCode 값으로 비교해야 하나?
                result.put(word, 1);
            }
            else { // 여기가 if절이면 위의 if 절이 끝나면 항상 새로운 키값 쌍이 생긴 채로 이 블록이 실행된다.
                // 해당 키의 값을 하나 늘린다.
                Integer value = result.get(word);
                // result.remove(word, value); // 이미 있는 키값 쌍을 지우려고 했는데 왜 안될까?
                // result.put(word, value+1); // 여기서 이미 있는 키값 쌍이 값이 하나 더 큰 것으로 하나 더 추가된다.
                System.out.println(word + " switches " + value + " to " + value + " plus 1");
                result.replace(word, value, value+1); // 키값 쌍은 두고 값만 하나 늘린다.
            }
        }
        return result;
    }
}
