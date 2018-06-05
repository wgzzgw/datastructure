
public class testSingleLinkedList{
    public static void  main(String[] args){
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
        StackSingleLink stackSingleLink=new StackSingleLink();
        stackSingleLink.push(1);
        stackSingleLink.push(2);
        stackSingleLink.push(3);
        stackSingleLink.display();
        stackSingleLink.pop();
        stackSingleLink.display();
        DoublePointLinkedList doublePointLinkedList=new DoublePointLinkedList();
        doublePointLinkedList.addHead(1);
        doublePointLinkedList.addHead(2);
        doublePointLinkedList.addHead(3);
        doublePointLinkedList.display();
        doublePointLinkedList.deleteHead();
        doublePointLinkedList.display();
        doublePointLinkedList.addTail(4);
        doublePointLinkedList.display();
        QueueLinkedList queueLinkedList=new QueueLinkedList();
        queueLinkedList.insert(1);
        queueLinkedList.insert(2);
        queueLinkedList.insert(3);
        queueLinkedList.display();
        queueLinkedList.delete();
        queueLinkedList.display();
        queueLinkedList.getSize();
        RBTree rbTree=new RBTree();
        rbTree.insert(6);
        rbTree.insert(5);
        rbTree.insert(9);
        rbTree.insert(7);
        rbTree.insert(10);
        rbTree.insert(3);
        rbTree.insert(1);
        rbTree.insert(4);
        rbTree.infixOrder(rbTree.root);
        rbTree.insert(2);
        rbTree.infixOrder(rbTree.root);
        rbTree.insert(8);
        rbTree.infixOrder(rbTree.root);
        rbTree.insert(6);
        rbTree.infixOrder(rbTree.root);
        }
        }