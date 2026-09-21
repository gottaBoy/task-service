/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.SRFForm;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.util.EventObject;

public class UserWebCtrlEvent
extends EventObject {
    protected WebCtrlConfig webCtrlConfig = null;
    protected SRFWebControl userControl = null;
    protected String strValue = null;
    protected String strIdFormat = "";

    public UserWebCtrlEvent(SRFForm source) {
        super(source);
    }

    public WebCtrlConfig getConfig() {
        return this.webCtrlConfig;
    }

    public void setConfig(WebCtrlConfig value) {
        this.webCtrlConfig = value;
    }

    public SRFWebControl getUserControl() {
        return this.userControl;
    }

    public void setUserControl(SRFWebControl value) {
        this.userControl = value;
    }

    public String getIdFormat() {
        return this.strIdFormat;
    }

    public void setIdFormat(String value) {
        this.strIdFormat = value;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String value) {
        this.strValue = value;
    }
}

