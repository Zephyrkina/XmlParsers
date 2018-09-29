package ua.training.json;

import java.util.Objects;

public class Currency {
    String r030;
    String txt;
    String rate;
    String cc;
    String exchangedate;



    public Currency() {
    }

    public Currency(String r030, String txt, String rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public String getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public String getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(r030, currency.r030) &&
                Objects.equals(txt, currency.txt) &&
                Objects.equals(rate, currency.rate) &&
                Objects.equals(cc, currency.cc) &&
                Objects.equals(exchangedate, currency.exchangedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(r030, txt, rate, cc, exchangedate);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "r030='" + r030 + '\'' +
                ", txt='" + txt + '\'' +
                ", rate='" + rate + '\'' +
                ", cc='" + cc + '\'' +
                ", exchangedate='" + exchangedate + '\'' +
                '}';
    }
}
