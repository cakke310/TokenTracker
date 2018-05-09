package com.tokentracker.api;

/**
 * Created by Riven
 */
public class ApiConstants {

    public static final String EOS_URL = "https://api.etherscan.io/";

    //新浪图片 Host
    /**
     * 根据HostType类型种类获取host
     * @param hostType
     * @return
     */
    public static String getHost(int hostType) {

        String host;
        switch (hostType) {
            case HostType.EOS_URL:
                host = EOS_URL;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}