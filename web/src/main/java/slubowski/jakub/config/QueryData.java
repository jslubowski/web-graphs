package slubowski.jakub.config;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data // no need for getters and setters
@EqualsAndHashCode(of = "id") // self-explanatory
public class QueryData {
    // == fields ==
    private String year;

    private String month;

    private String day;

    private String date;

    // == constructor ==

    public QueryData(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
        appendDate();
    }


    // == methods ==

    public void appendDate(){
        StringBuilder toAppend = new StringBuilder();
        this.date = toAppend.append(this.year + "-" + this.month + "-" + this.day).toString();
        log.info("Appending date");
        log.info("The date appended is {}", this.date);
    }
}
