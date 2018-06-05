public class Combination {
    private char[] persons;//组中所有可供选择的人员
    private boolean[] selects;//标记成员是否被选中，选中为true
    private int count;
    public Combination(char[] persons){
        this.persons = persons;
        selects = new boolean[persons.length];
        count=0;
    }
    public void showTeams(int teamNumber){
        combination(teamNumber,0);
    }
    /**
     *
     * @param teamNumber 需要选择的队员数
     * @param index 从第几个队员开始选择
     */
    public void combination(int teamNumber,int index){
        if(teamNumber == 0){//当teamNumber=0时，找到一组
            for(int i = 0 ; i < selects.length ; i++){
                if(selects[i] == true){
                    System.out.print(persons[i]+" ");
                }
            }
            count++;
            System.out.println();
            return;
        }
        //index超过组中人员总数，表示未找到
        if(index >= persons.length ){
            return;
        }
        selects[index] = true;
        combination(teamNumber-1, index+1);
        selects[index] = false;
        combination(teamNumber, index+1);
    }

    public static void main(String[] args) {
        char[] persons = {'A','B','C','D','E','F','G'};
        Combination cb = new Combination(persons);
        cb.showTeams(2);
        System.out.print(cb.count);
    }
}