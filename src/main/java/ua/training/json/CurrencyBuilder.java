package ua.training.json;

public class CurrencyBuilder {
    private String r030;
    private String txt;
    private String rate;
    private String cc;
    private String exchangedate;

    public CurrencyBuilder setR030(String r030) {
        this.r030 = r030;
        return this;
    }

    public CurrencyBuilder setTxt(String txt) {
        this.txt = txt;
        return this;
    }

    public CurrencyBuilder setRate(String rate) {
        this.rate = rate;
        return this;
    }

    public CurrencyBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public CurrencyBuilder setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
        return this;
    }

    public Currency createCurrency() {
        return new Currency(r030, txt, rate, cc, exchangedate);
    }
}