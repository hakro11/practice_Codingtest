import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> mapOfparticipant = makeMap(participant);

        for(String name : completion){
            if(mapOfparticipant.get(name) == 0){
                mapOfparticipant.remove(name);
            } else if (mapOfparticipant.get(name) > 0) {
                mapOfparticipant.replace(name, mapOfparticipant.get(name), mapOfparticipant.get(name)-1);
            }
        }

        char[] charArr = mapOfparticipant.keySet().toString().toCharArray();
        String answer = "";

        for(int i = 1; i < charArr.length -1; i++){
            answer += charArr[i];
        }

        return answer;
    }

    public Map<String, Integer> makeMap(String[] participant){
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            if (!map.containsKey(name)) {
                map.put(name, 0);
            }else {
                map.replace(name, map.get(name), map.get(name)+1);
            }
        }

        return map;
    }
}