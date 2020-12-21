package tianzefa.work.algorithm.exam;

public class Main7 {


    public static void main(String[] args) {
        String str = "<!DOCTYPE html><html><head><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><script>window.ecologyContentPath='/htoa';</script><meta charset=\"UTF-8\"><title>加载中...</title><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\"/><link rel=\"stylesheet\" href=\"/htoa/cloudstore/resource/pc/com/v1/index.min.css?v=1585591203013\"><link rel=\"stylesheet\" href=\"/htoa/cloudstore/resource/pc/com/v1/ecCom.min.css?v=1585591203013\"><script type=\"text/javascript\" src=\"/htoa/cloudstore/resource/pc/jquery/jquery-1.12.4.min.js\"></script><script>localStorage.setItem(\"staticVersion\",1585593896679)</script></head><body><div id=\"container\"></div><script type=\"text/javascript\" src=\"/htoa/cloudstore/resource/pc/polyfill/polyfill.min.js\"></script><!-- Polyfills --><!--[if lt IE 10]>\n" +
                "    <script type=\"text/javascript\" src=\"/htoa/cloudstore/resource/pc/shim/shim.min.js\"></script>\n" +
                "    <![endif]--><script type=\"text/javascript\">var agent = window.navigator.userAgent;\n" +
                "    if (agent.indexOf(\"Windows\") > -1 && agent.indexOf(\"Safari\") > -1 && agent.indexOf(\"Chrome\") < 0) { // windows safari\n" +
                "      window.location.href = \"/htoa/wui/common/page/sysRemind.jsp?labelid=7\";\n" +
                "    } else if ((agent.indexOf(\"Chrome\") > -1 || agent.indexOf(\"CriOS\") > -1) && agent.indexOf(\"Safari\") > -1) { // chrome\n" +
                "      var regStr_chrome = /chrome\\/[\\d.]+/gi;\n" +
                "      var chrome_info = agent.match(regStr_chrome);\n" +
                "      var chrome_version = chrome_info[0].replace('Chrome/', '').split('.')[0];\n" +
                "      if (chrome_version < 49) {\n" +
                "        // 通过接口判断是否开启chrome拦截";


        System.out.println(str.replaceAll("\\<script\\>window.ecologyContentPath=.*\\;\\<\\/script\\>",""));
    }
}
