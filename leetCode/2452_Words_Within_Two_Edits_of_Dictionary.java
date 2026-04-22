import java.util.*;
class TwoEditDic {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> l=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<dictionary.length;j++){
                if(twoEdit(queries[i],dictionary[j])){
                    l.add(queries[i]);
                    break;                      // important only one query ko ek dictionary se replace kar sakta hai.
                }
            }
        }
        return l;
    }
    private boolean twoEdit(String s,String q){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=q.charAt(i)){
                count++;
            }
        }
        if(count>2){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        TwoEditDic t = new TwoEditDic();
        String[] queries = {"word","note","ants","wood"};
        String[] dictionary = {"wood","joke","moat"};
        List<String> result = t.twoEditWords(queries, dictionary);
        System.out.println(result); // Output: ["word","note","wood"]
    }
}