package Task1;

public class Bowl {
    public int food;

    public Bowl (int food){
        this.food = food;
        System.out.println("В миске " + this.food + "г. еды");
    }

    public void addFood(int count){
        this.food = this.food + count;
        System.out.println("В миске " + this.food + "г. еды");
    }
}
