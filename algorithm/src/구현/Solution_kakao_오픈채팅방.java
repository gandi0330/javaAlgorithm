package 구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_kakao_오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }


    public static String[] solution(String[] record) {

        HashMap<String, String> uidToName = new HashMap<>();
        List<String[]> uidToCommand = new ArrayList<>();

        for(String str : record){
            String[] strs = str.split(" ");


            String command = strs[0];
            String uid = strs[1];


            if(command.equals("Leave")) {
                uidToCommand.add(new String[]{uid,command});
                continue;
            }
            String name = strs[2];
            if(command.equals("Enter")){
                uidToCommand.add(new String[]{uid,command});
                uidToName.put(uid,name);
            }else if(command.equals("Change")){
                uidToName.put(uid,name);
            }
        }

        String[] answer = new String[uidToCommand.size()];

        for(int i=0;i<uidToCommand.size();i++){
            String[] temp = uidToCommand.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(uidToName.get(temp[0])+"님이 ").append(temp[1].equals("Enter")?"들어왔습니다.":"나갔습니다.");
            answer[i] = sb.toString();
        }

        return answer;
    }
}
