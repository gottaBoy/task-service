/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

public class SOAResult {
    protected int nErrorCode = 0;
    protected String strErrorInfo = "";
    protected String strUserData = "";

    public int getErrorCode() {
        return this.nErrorCode;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public String getUserData() {
        return this.strUserData;
    }

    public void setErrorCode(int nErrorCode) {
        this.nErrorCode = nErrorCode;
    }

    public void setErrorInfo(String strErrorInfo) {
        this.strErrorInfo = strErrorInfo;
    }

    public void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }
}

