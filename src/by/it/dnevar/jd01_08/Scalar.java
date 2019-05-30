package by.it.dnevar.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value=Double.parseDouble(strValue);
    }

    Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }
}
