package Model;

import java.time.LocalDate;

public class PracticeLog {
    private final long hrs;
    private final long mins;
    private final long secs;
    private final long millis;

    LocalDate date;

    public PracticeLog(LocalDate date, long timeInMillis) {
        this.date = date;
        this.millis = timeInMillis;
        this.secs = millis / 1000;
        this.mins = secs / 60;
        this.hrs = mins / 60;
    }

    public PracticeLog(LocalDate date, int hrs, int mins, int secs) {
        this.date = date;
        this.millis = 0;
        this.secs = secs;
        this.mins = mins;
        this.hrs = hrs;
    }

    public String getTime() {
        return hrs + "-" + mins + "-" + secs;
    }

    public String getDate() {
        return this.date.toString();
    }

    public long getMins() {
        return this.mins;
    }

}
