/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import java.sql.Timestamp;
import microsoft.sql.DateTimeOffset;

/**
 *
 * @author lcabraja
 */
class DateTimeOffsetParser {
    public static DateTimeOffset parse(String input) {
        String[] time = input.substring(29, 34).split(":");
        Integer hours = Integer.valueOf(time[0]) * 60;
        Integer minutes = Integer.valueOf(time[1]);
        Integer offset = (hours + minutes) * ("+".equals(input.substring(28, 29)) ? 1 : -1);

        return DateTimeOffset.valueOf(Timestamp.valueOf(input.substring(0, 27)), offset);
    }
}
