package Model;

import java.time.LocalDate;

public class TestLog {
    private final String deckName;
    private final double percentCorrect;
    private final LocalDate date;

    public TestLog(String deckName, double percentCorrect, LocalDate date) {
        this.deckName = deckName;
        this.percentCorrect = percentCorrect;
        this.date = date;
    }

    public double getPercentageCorrect() {
        return this.percentCorrect;
    }

    public String getDeckName() {
        return this.deckName;
    }

    public String getDate() {
        return this.date.toString();
    }

}
