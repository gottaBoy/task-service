/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework;

public final class SRFMetaData {
    public static final int MAJORVERSION = 1;
    public static final int MINORVERSION = 0;
    public static final String BUILDDATE = "060912";
    public static final String BUILDNO = "00200";

    public static String getVersion() {
        return String.format("%1$d.%2$d.%3$s", 1, 0, BUILDNO);
    }

    public static String getChangeLog() {
        String strLog = "";
        strLog = String.valueOf(strLog) + "[2006-05-17] \u6253\u5370catch\u65f6\u7684\u5806\u6808\u4fe1\u606f\n";
        strLog = String.valueOf(strLog) + "[2006-05-17] \u4fee\u6539\u4e86\u52a8\u6001\u641c\u7d22\u8868\u5355\u672a\u8f93\u51fa\u8868\u7ed3\u675f\u7b26\u53f7\u7684\u9519\u8bef\n";
        strLog = String.valueOf(strLog) + "[2006-05-17] \u52a8\u6001\u641c\u7d22\u8868\u5355\u652f\u6301\u9690\u85cf\n";
        strLog = String.valueOf(strLog) + "[2006-05-16] \u63d0\u4f9b\u4e86ListBox\u5bf9\u8c61\n";
        strLog = String.valueOf(strLog) + "[2006-05-14] \u5c06\u5e73\u53f0\u4e2d\u7684\u56fe\u7247\u540d\u79f0\u6539\u4e3a\u5c0f\u5199\n";
        strLog = String.valueOf(strLog) + "[2006-05-14] \u4fee\u6539\u4e86Page\u52a0\u8f7d\u65f6\u5b58\u5728\u7684\u95ee\u9898\n";
        strLog = String.valueOf(strLog) + "[2006-05-12] \u589e\u52a0\u4e86\u4e3b\u83dc\u5355\u548c\u5b50\u83dc\u5355\u90e8\u4ef6\n";
        strLog = String.valueOf(strLog) + "[2006-05-10] \u4fee\u6539\u4e86Oracle\u8c03\u7528\u4e2d\u5b58\u5728\u7684\u95ee\u9898\n";
        strLog = String.valueOf(strLog) + "[2006-05-09] \u914d\u7f6e\u6587\u4ef6\u6807\u793a\u652f\u6301\u547d\u540d\u7a7a\u95f4\n";
        strLog = String.valueOf(strLog) + "[2006-05-08] \u589e\u52a0\u4e86\u7528\u6237\u63a7\u4ef6\u6982\u5ff5\n";
        strLog = String.valueOf(strLog) + "[2006-05-08] ParamConfig \u5bf9\u8c61\u589e\u52a0 Default \u5c5e\u6027\uff0c\u7528\u4e8e\u63cf\u8ff0\u503c\u4e3a\u7a7a\u65f6\u7684\u9ed8\u8ba4\u503c\n";
        strLog = String.valueOf(strLog) + "[2006-05-08] DynamicForm \u6539\u8fdb\u4e86\u503c\u586b\u5145\u6a21\u5f0f\n";
        return strLog;
    }
}

