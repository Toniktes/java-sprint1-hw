public class Converter {

    double getKilometers(int sum) {//перводим в километры, при условии что 1 шаг 75 см
        return sum * 0.00075;
    }

    double getKilocalories (int sum) {// переводим в килокалории 1 шаг 50 калорий
       return (sum * 50)/1000;
    }
}
