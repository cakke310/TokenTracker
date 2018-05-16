package com.tokentracker.db;

/**
 * Created by Riven on 2018/5/15.
 */

public class TableConfig {
    public static final String TABLE_Token = "tokenTable";
    /**
     * Customer数据表的字段
     */
    public static class Customer{
        //Customer
        public static final String TOKEN_ID="id";
        public static final String TOKEN_ADDRESS="tokenAddress";
        public static final String TOKEN_DATE="tokenDate";
        public static final String TOKEN_BALANCE="tokenBalance";
    }
}
