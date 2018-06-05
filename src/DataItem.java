//数据项
class DataItem{
    public long dData;
    public DataItem(long dData){
        this.dData = dData;
    }
    public void displayItem(){
        System.out.println("/"+dData);
    }
}