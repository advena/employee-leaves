package pl.avra.employee;

public class Expirience {

    private int years;
    private int months;

    Expirience(int years, int months) {
        this.years = years;
        this.months = months;
    }

    public int getMonths() {
        return months + years*12;
    }
}
