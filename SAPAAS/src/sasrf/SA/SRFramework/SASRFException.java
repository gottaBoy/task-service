/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework;

public class SASRFException
extends Exception {
    protected int nExceptionType = 1;
    protected String strUserMsg;

    public SASRFException(int nType) {
        this.nExceptionType = nType;
    }

    public SASRFException(String strErrorMsg) {
        this.strUserMsg = strErrorMsg;
        this.nExceptionType = 2;
    }

    public int getCurType() {
        return this.nExceptionType;
    }

    public String getUserMsg() {
        return this.strUserMsg;
    }

    @Override
    public String toString() {
        return this.ErrorToMsg();
    }

    public String ErrorToMsg() {
        if (this.nExceptionType == 1) {
            return "\u4e0d\u660e\u7684\u5f02\u5e38";
        }
        if (this.nExceptionType == 2) {
            return this.strUserMsg;
        }
        if (this.nExceptionType == 100) {
            return "\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5";
        }
        return "\u7cfb\u7edf\u5185\u90e8\u9519\u8bef";
    }

    @Override
    public String getMessage() {
        return this.ErrorToMsg();
    }
}

