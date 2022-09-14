package 삼성B형;

import java.util.*;
class UserSolution {

    static int mstrlen(char[] a) {
        int len = 0;

        while (a[len] != '\0')
            len++;
        return len;
    }

    static class Search{
        int searchTimestamp;
        char[] searchWord;

        public Search(int searchTimestamp, char[] searchWord) {
            this.searchTimestamp = searchTimestamp;
            this.searchWord = searchWord;
        }
    }

    public boolean isTypoType(char[] a, char[] b){
        int lenA = mstrlen(a);
        int lenB = mstrlen(b);
        if(lenA == lenB){
            int dif = 0;
            int i = 0;
            while(a[i] != '\0'){
                if(a[i] != b[i]) dif++;
                i++;
            }

            if(dif != 1) return false;
            else return true;
        }else if(Math.abs(lenA - lenB)==1) {
            char[] l = new char[0];
            char[] s = new char[0];

            if(lenA < lenB){
                l = b;
                s = a;
            }else if(lenA > lenB){
                s = b;
                l = a;
            }

            int dif = 0;
            int i = 0;
            int j = 0;
            while(s[j] != '\0'){
//                System.out.println("i , j " + i + ", "+ j );
                if(l[i] != s[j]) {
                    dif++;
                    i--;
                }
                i++;
                j++;
            }
            if(dif != 1) return false;
            else return true;
        }
        else return false;
    }

    static List<Search> preSearchList;
    static int[] preSearchIndex;
    static Map<String, Map<String, HashSet<Integer>>> db;
    void init(int n) {
        preSearchIndex = new int[n+1];
        Arrays.fill(preSearchIndex,-1);
        preSearchList = new ArrayList<>();

        db = new HashMap<>();
    }

    int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
        for(int i=0;i<5;i++){
            for(int j=0;j<11;j++){
                correctWord[i][j] = '\0';
            }
        }
        // 처음 검색했을 때
        if(preSearchIndex[mId] == -1){
            preSearchIndex[mId] = preSearchList.size();
            preSearchList.add(new Search(searchTimestamp, searchWord));
            return 0;
        }

        Search pre = preSearchList.get(preSearchIndex[mId]);


        // 이전의 검색이 존재하며 현재 검색과 10초 이하로 떨어져 있을 때
        if(pre.searchTimestamp >= searchTimestamp - 10){
//            System.out.println("pre" + " " + Arrays.toString(pre.searchWord) + " " + "now " + Arrays.toString(searchWord));

            // 오타 유형에 속한다면
            if(isTypoType(pre.searchWord, searchWord)){
                // 이미 오타 후보 유형에 존재하면
                if(db.containsKey(String.valueOf(pre.searchWord))){
                    Map<String, HashSet<Integer>> correctMap = db.get(String.valueOf(pre.searchWord));
                    // 정답 후보 유형에도 존재하면
                    if(correctMap.containsKey(String.valueOf(searchWord))){
                        Set<Integer> set = correctMap.get(String.valueOf(searchWord));
                        set.add(mId);
                    }
                    // 없다면 정답 후보를 만들어 주기
                    else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(mId);
                        correctMap.put(String.valueOf(searchWord), set);
                    }
                }
                else{
                    Map<String, HashSet<Integer>> correctMap = new HashMap<>();
                    HashSet<Integer> set = new HashSet<>();
                    set.add(mId);

                    correctMap.put(String.valueOf(searchWord), set);

                    db.put(String.valueOf(pre.searchWord), correctMap);
                }
            }
        }

        pre.searchTimestamp = searchTimestamp;
        pre.searchWord = searchWord;

        // 검색한 내용이 오타 수정 DB의 키로 존재하고 해당 검색 기록이 3번 이상인 정타 단어를 저장
        if(db.containsKey(String.valueOf(searchWord))){
            Map<String, HashSet<Integer>> correctMap = db.get(String.valueOf(searchWord));
            int correctCnt = 0;

            for(String key : correctMap.keySet()){
                if(correctMap.get(key).size() >= 3){
                    correctCnt++;
                    int i=0;
                    while(correctWord[i][0] != '\0'){
                        i++;
                    };
                    correctWord[i] = key.toCharArray();
                }
            }

            if(correctCnt > 0)
                return correctCnt;
        }

        return 0;

    }
}

