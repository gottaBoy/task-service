/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

public class ValueError {
    protected int nErrorCode = 0;
    protected String strErrorInfo = "";
    protected Object userObject = null;
    protected String strValue = "";

    public ValueError(String strValue, int nErrorCode) {
        this.strValue = strValue;
        this.nErrorCode = nErrorCode;
    }

    public ValueError(String strValue, int nErrorCode, String strErrorInfo) {
        this.strValue = strValue;
        this.nErrorCode = nErrorCode;
        this.strErrorInfo = strErrorInfo;
    }

    public ValueError(String strValue, int nErrorCode, String strErrorInfo, Object userObject) {
        this.strValue = strValue;
        this.nErrorCode = nErrorCode;
        this.strErrorInfo = strErrorInfo;
        this.userObject = userObject;
    }

    public ValueError() {
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }

    public void setErrorCode(int value) {
        this.nErrorCode = value;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setErrorInfo(String value) {
        this.strErrorInfo = value;
    }

    public Object getUserObject() {
        return this.userObject;
    }

    public void setUserObject(Object userObject) {
        this.userObject = userObject;
    }
}

