package userDataFront;

import lombok.Data;

@Data
public class UserData {

    private long id;

    private String name;

    private int birth_year;

    private int birth_month;

    private int birth_day;

    private String sex;

    private String memo;

}
