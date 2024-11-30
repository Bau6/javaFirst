class DivisionExc extends Exception {
    double firsNum;
    double secondNum;

    public DivisionExc(double firsNum, double secondNum) {
        this.firsNum = firsNum;
        this.secondNum = secondNum;
    }

    @Override
    public String toString() {
        return "Результат деления " + String.format("%.2f", firsNum) +
                " на " + String.format("%.2f", secondNum) +
                " меньше 1";
    }
}
