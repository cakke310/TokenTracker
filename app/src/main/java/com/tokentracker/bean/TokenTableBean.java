package com.tokentracker.bean;

/**
 * Created by Riven on 2018/5/15.
 */

public class TokenTableBean {

    public String tokenAddress;
    public String tokenDate;
    public String tokenBalance;

    public String getTokenChange() {
        return tokenChange;
    }

    public void setTokenChange(String tokenChange) {
        this.tokenChange = tokenChange;
    }

    public String tokenChange;

    public TokenTableBean(String tokenAddress, String tokenDate, String tokenBalance,String tokenChange) {
        this.tokenAddress = tokenAddress;
        this.tokenDate = tokenDate;
        this.tokenBalance = tokenBalance;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    public String getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(String tokenDate) {
        this.tokenDate = tokenDate;
    }

    public String getTokenBalance() {
        return tokenBalance;
    }

    public void setTokenBalance(String tokenBalance) {
        this.tokenBalance = tokenBalance;
    }
}
