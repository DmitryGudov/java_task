package ru.hr.link;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmountCalculateTest {

    // 1_Геттеры.
    AmountCalculateService service = new AmountCalculateService(
            30,
            10,
            10_000);

    // 1.1_Получение количества этажей.
    @Test
    public void shouldGetNumberOfFloors() {
        int expected = 30;
        int actual = service.getNumberOfFloors();

        Assertions.assertEquals(expected, actual);
    }

    // 1.2_Получение интревала этажей подорожания квартир.
    @Test
    public void shouldGetFloorSpacing() {
        int expected = 10;
        int actual = service.getFloorSpacing();

        Assertions.assertEquals(expected, actual);
    }

    // 1.3_Получение стоимости квартиры.
    @Test
    public void shouldGetPrice() {
        int expected = 10_000;
        int actual = service.getPrice();

        Assertions.assertEquals(expected, actual);
    }

    // 1.4_Получение стоимости всех квартир в доме.
    @Test
    public void shouldGetSum() {
        int expected = 330_000;
        int actual = service.getSum();

        Assertions.assertEquals(expected, actual);
    }

    // 2_Исключения.
    // 2.1_Должно выкидываться исключение в случае, если количество этажей равно 0:
    @Test
    public void shouldAnExceptionMustBeThrownWhenNumberOfFloorsIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AmountCalculateService service = new AmountCalculateService(
                    0,
                    10,
                    10_000);
        });
    }

    // 2.2_Должно выкидываться исключение в случае, если количество этажей меньше 0:
    @Test
    public void shouldAnExceptionMustBeThrownWhenNumberOfFloorsLessNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AmountCalculateService service = new AmountCalculateService(
                    -30,
                    10,
                    10_000);
        });
    }

    // 2.3_Должно выкидываться исключение в случае, если интревал этажей подорожания квартир меньше 1:
    @Test
    public void shouldAnExceptionMustBeThrownWhenFloorSpacingLessOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AmountCalculateService service = new AmountCalculateService(
                    30,
                    0,
                    10_000);
        });
    }

    // 2.4_Должно выкидываться исключение в случае, если стоимость квартиры равна 0:
    @Test
    public void shouldAnExceptionMustBeThrownWhenPriceIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AmountCalculateService service = new AmountCalculateService(
                    30,
                    10,
                    0);
        });
    }

    // 2.5_Должно выкидываться исключение в случае, если стоимость квартиры меньше 0:
    @Test
    public void shouldAnExceptionMustBeThrownWhenNumberOfFloorsLessNul() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AmountCalculateService service = new AmountCalculateService(
                    30,
                    10,
                    -10_000);
        });
    }

    // 3_Расчет стоимости всех квартир (при корректных значениях переменных).

    // 3.1_Пример расчета стоимости всех квартир №1:
    @Test
    public void shouldReturnGetSumFirst() {
        service.setNumberOfFloors(32);
        service.setFloorSpacing(5);
        service.setPrice(4_000);

        int expected = 215_000;
        int actual = service.getSum();

        Assertions.assertEquals(expected, actual);
    }

    // 3.2_Пример расчета стоимости всех квартир №2:
    @Test
    public void shouldReturnGetSumSecond() {
        service.setNumberOfFloors(21);
        service.setFloorSpacing(3);
        service.setPrice(8_000);

        int expected = 231_000;
        int actual = service.getSum();

        Assertions.assertEquals(expected, actual);
    }

}