package hw;

import javax.persistence.*;

@Entity
public class DishSample {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int mass;
    @Column
    private boolean hasDiscount;

    public DishSample() {
    }

    public DishSample(long id, String name, int price, int mass, boolean hasDiscount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mass = mass;
        this.hasDiscount = hasDiscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    @Override
    public String toString() {
        return "DishSample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mass=" + mass +
                ", hasDiscount=" + hasDiscount +
                '}';
    }
}
