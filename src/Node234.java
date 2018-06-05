public class Node234 {
    private static final int ORDER = 4;
    private int numItems;//表示该节点有多少个数据项
    private Node234 parent;//父节点
    private Node234 childArray[] = new Node234[ORDER];//存储子节点的数组，最多有4个子节点
    private DataItem itemArray[] = new DataItem[ORDER-1];//存放数据项的数组，一个节点最多有三个数据项
    //连接子节点
    public void connectChild(int childNum,Node234 child){
        childArray[childNum] = child;
        if(child != null){
            child.parent = this;
        }
    }
    //断开与子节点的连接，并返回该子节点
    public Node234 disconnectChild(int childNum){
        Node234 tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
    //得到节点的某个子节点
    public Node234 getChild(int childNum){
        return childArray[childNum];
    }
    //得到父节点
    public Node234 getParent(){
        return parent;
    }
    //判断是否是叶节点
    public boolean isLeaf(){
        return (childArray[0] == null)?true:false;
    }
    //得到节点数据项的个数
    public int getNumItems(){
        return numItems;
    }
    //得到节点的某个数据项
    public DataItem getItem(int index){
        return itemArray[index];
    }
    //判断节点的数据项是否满了（最多3个）
    public boolean isFull(){
        return (numItems == ORDER-1) ? true:false;
    }

    //找到数据项在节点中的位置
    public int findItem(long key){
        for(int j = 0 ; j < ORDER-1 ; j++){
            if(itemArray[j]==null){
                break;
            }else if(itemArray[j].dData == key){
                return j;
            }
        }
        return -1;
    }

    //将数据项插入到节点
    public int insertItem(DataItem newItem){
        numItems++;
        long newKey = newItem.dData;
        for(int j = ORDER-2 ; j >= 0 ; j--){
            if(itemArray[j] == null){//如果为空，继续向前循环
                continue;
            }else{
                long itsKey = itemArray[j].dData;//保存节点某个位置的数据项
                if(newKey < itsKey){//如果比新插入的数据项大
                    itemArray[j+1] = itemArray[j];//将大数据项向后移动一位
                }else{
                    itemArray[j+1] = newItem;//如果比新插入的数据项小，则直接插入
                    return j+1;
                }
            }
        }
        //如果都为空，或者都比待插入的数据项大，则将待插入的数据项放在节点第一个位置
        itemArray[0] = newItem;
        return 0;
    }
    //移除节点的数据项
    public DataItem removeItem(){
        DataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }
    //打印节点的所有数据项
    public void displayNode(){
        for(int j = 0 ; j < numItems ; j++){
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }
}
