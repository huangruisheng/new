package com.trusthiker.common.db.editor;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rui on 2015/1/19.
 */
public class TimeEditor extends PropertyEditorSupport {

    private String format = "H:mm";

    public TimeEditor() {
    }

    public TimeEditor(String format) {
        this.format = format;
    }

    public void setAsText(String text) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date date = df.parse(text);
            Time time = new Time(date.getTime());
            setValue(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
