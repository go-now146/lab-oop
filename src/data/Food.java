/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Admin
 */
public class Food {

    protected String id;
    protected String name;
    protected String type;
    protected double weight;
    protected String location;
    protected String expiredDate;

    public Food() {
    }

    public Food(String id, String name, String type, double weight, String location, String expiredDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.location = location;
        this.expiredDate = expiredDate;
    }

  

    public String getId() {
        return id;
    }

//    public void setID(String ID) {
//        this.ID = ID;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", type=" + type + ", weight=" + weight + "(Kg)" + ", location=" + location + ", expiredDate=" + expiredDate + '}';
    }

    public void printFood() {
        System.out.printf("|%-8s|%-15s|%-8s|%-12.2f|%-15s|%-12s|\n",
                id, name, type, weight, location, expiredDate);
    }
}
