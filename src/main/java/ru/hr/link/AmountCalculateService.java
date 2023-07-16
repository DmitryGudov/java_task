package ru.hr.link;

public class AmountCalculateService {
    protected int numberOfFloors; // Количество этажей
    protected int floorSpacing; // Интревал этажей подорожания квартир
    protected int price; // Стоимость квартиры
    protected int sum; // Стоимость всех квартир в доме

    public AmountCalculateService(int numberOfFloors, int floorSpacing, int price) {
        if (numberOfFloors <= 0) {
            throw new IllegalArgumentException(
                    "Количество этажей не может быть отрицательным или равным нулю, а у вас: " + numberOfFloors
            );
        }
        if (floorSpacing < 1) {
            throw new IllegalArgumentException(
                    "Интервал между этажами не может быть меньше 1, а у вас: " + floorSpacing
            );
        }
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Стоимость квартиры не может быть отрицательной или равной нулю, а у вас: " + price
            );
        }

        this.numberOfFloors = numberOfFloors;
        this.floorSpacing = floorSpacing;
        this.price = price;
    }

    public int getSum() {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= numberOfFloors; i++) {
            if (i % floorSpacing == 0) {
                price += 1000;
                count++;
            }
            sum += price;
        }
        return sum - (count * 1000);
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getFloorSpacing() {
        return floorSpacing;
    }

    public void setFloorSpacing(int floorSpacing) {
        this.floorSpacing = floorSpacing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}