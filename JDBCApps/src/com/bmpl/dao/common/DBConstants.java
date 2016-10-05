package com.bmpl.dao.common;

public interface DBConstants {
String DB_CONFIG="db";
String ITEM_SELECT_SQL = "select itemid , name , price from items ";
String ITEM_INSERT_SQL = "insert into items (itemid , name, price ) values(?,?,?)";
}
