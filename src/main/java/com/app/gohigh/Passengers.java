package com.app.gohigh;

import java.io.Serializable;

public class Passengers {

    private String from_place;
    private String to_place;
    private int id;

    public static final String TABLE_DUO = "flop";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FROM = "xFrom";
    public static final String COLUMN_TO = "yTo";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_DUO + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_FROM + " BLOB, "
                    + COLUMN_TO + " BLOB "
                    + ")";
    public Passengers() {
    }

    public Passengers(int id,String from_place, String to_place)
    {
        this.id = id;
        this.from_place = from_place;
        this.to_place = to_place;

    }

    public String getFrom_place(String string) {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public String getTo_place(String string) {
        return to_place;
    }

    public void setTo_place(String to_place) {
        this.to_place = to_place;
    }

    public int getBooking_Id(String string) {
        return id;
    }

    public void setBooking_Id(int id) {
        this.id = id;
    }
}