/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.UI;

public class NavigateItem {
    protected String strURL = "";
    protected String strTarget = "";
    protected String strCaption = "";
    protected String strTips = "";
    protected String strJSCode = "";

    public String getURL() {
        return this.strURL;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }

    public String getTarget() {
        return this.strTarget;
    }

    public void setTarget(String strTarget) {
        this.strTarget = strTarget;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public void setJSCode(String strJSCode) {
        this.strJSCode = strJSCode;
    }

    public String getJSCode() {
        return this.strJSCode;
    }
}

