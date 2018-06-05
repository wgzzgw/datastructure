public class Tree234 {
    private Node234 root = new Node234() ;//234树的根结点
    //查找关键字值
    public int find(long key){
        Node234 curNode = root;
        int childNumber ;
        while(true){
            if((childNumber = curNode.findItem(key))!=-1){
                //所找数据在此节点的某个位置上
                return childNumber;
            }else if(curNode.isLeaf()){//节点是叶节点，上句判断已说明此叶节点无此数据
                return -1;
            }else{
                curNode = getNextChild(curNode,key);
            }
        }
    }
    public Node234 getNextChild(Node234 theNode,long theValue){
        int j;
        //获取数据项的个数
        int numItems = theNode.getNumItems();
        //返回待插入数据所要插入的结点
        for(j = 0 ; j < numItems ; j++){
            if(theValue < theNode.getItem(j).dData){
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }
    //插入数据项
    public void insert(long dValue){
        Node234 curNode = root;
        DataItem tempItem = new DataItem(dValue);
        while(true){
            if(curNode.isFull()){//如果节点满数据项了，则分裂节点
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            }else if(curNode.isLeaf()){//当前节点是叶节点
                break;
            }else{
                curNode = getNextChild(curNode, dValue);
            }
        }//end while
        curNode.insertItem(tempItem);
    }

    public void split(Node234 thisNode){
        DataItem itemB,itemC;
        Node234 parent,child2,child3;
        int itemIndex;
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node234 newRight = new Node234();
        if(thisNode == root){//如果当前节点是根节点，执行根分裂
            root = new Node234();
            parent = root;
            root.connectChild(0, thisNode);
        }else{
            parent = thisNode.getParent();
        }
        //处理父节点
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for(int j = n-1; j > itemIndex ; j--){
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        parent.connectChild(itemIndex+1, newRight);

        //处理新建的右节点
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }
    //打印树节点
    public void displayTree(){
        recDisplayTree(root,0,0);
    }
    private void recDisplayTree(Node234 thisNode,int level,int childNumber){
        System.out.println("levle="+level+" child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems+1 ; j++){
            Node234 nextNode = thisNode.getChild(j);
            if(nextNode != null){
                recDisplayTree(nextNode, level+1, j);
            }else{
                return;
            }
        }
    }
}
