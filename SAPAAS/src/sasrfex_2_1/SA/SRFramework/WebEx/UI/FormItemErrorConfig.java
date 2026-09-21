/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class FormItemErrorConfig
extends XMLConfig {
    public static final String TAG_FORMITEMERROR = "SRFEXFORMITEMERROR";
    public static final String TAG_MESSAGE = "MESSAGE";
    public static final String ERROR_EMPTY = "EMPTY";
    public static final String ERROR_DATATYPE = "DATATYPE";
    public static final String ERROR_LOGIC = "LOGIC";
    protected String strMessage = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_MESSAGE, (boolean)true) == 0) {
            this.strMessage = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getMessage() {
        return this.strMessage;
    }

    public void setMessage(String strMessage) {
        this.strMessage = strMessage;
    }
}

