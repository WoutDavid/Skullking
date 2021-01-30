public class NumericCard extends Card{
    private String name = "number";
    private int number;
    private String color;
    
    public NumericCard(int number, String color){
        this.number=number;
        this.color=color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NumericCard [color=" + color + ", number=" + number + "]";
    }
    
    
}
