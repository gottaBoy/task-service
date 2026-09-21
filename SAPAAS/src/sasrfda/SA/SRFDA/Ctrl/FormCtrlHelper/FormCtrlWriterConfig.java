/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfigEx
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFramework.Base.XMLConfigEx;
import SA.SRFramework.Utility.StringHelper;

public class FormCtrlWriterConfig
extends XMLConfigEx {
    public static final String TAG_FORMCTRLWRITER = "SRFDAFORMCTRLWRITER";
    public static final String TAG_OBJECT = "OBJECT";
    protected String strObject = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }
}

