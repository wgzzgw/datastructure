public class test234tree {
    public static void  main(String[] args){
        Tree234 tree234=new Tree234();
        tree234.displayTree();
        tree234.insert(1);
        tree234.insert(2);
        tree234.insert(3);
        tree234.insert(4);
        tree234.insert(5);
        tree234.insert(6);
        tree234.insert(7);
        tree234.insert(8);
        tree234.insert(9);
        System.out.print(tree234.find(9));
        System.out.print(tree234.find(1));
       tree234.displayTree();
        tree234.insert(10);
        tree234.displayTree();
    }
}
