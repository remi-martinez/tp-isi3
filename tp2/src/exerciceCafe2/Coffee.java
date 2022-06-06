package exerciceCafe2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Coffee {
    private String name;
    private float price;
    private List<Supplement> supplementList;

    public Coffee() {
        this.supplementList = new ArrayList<Supplement>();
    }

    @Override
    public String toString(){
        return String.format("%s (%.2f€)", getName(), getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice(){
        getSupplementList().forEach((supplement -> price += supplement.getCost()));
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }


    public List<Supplement> getSupplementList() {
        return supplementList;
    }

    public void setSupplementList(List<Supplement> supplementList) {
        this.supplementList = supplementList;
    }

    public void addSupplement(Supplement supplement) {
        getSupplementList().add(supplement);
    }
}
