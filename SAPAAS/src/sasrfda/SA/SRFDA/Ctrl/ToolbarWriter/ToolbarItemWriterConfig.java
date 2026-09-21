/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfigEx
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFramework.Base.XMLConfigEx;
import SA.SRFramework.Utility.StringHelper;

public class ToolbarItemWriterConfig
extends XMLConfigEx {
    public static final String TAG_TOOLBARITEMWRITER = "SRFDATOOLBARITEMWRITER";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    protected String strObject = "";
    protected String strLogicName = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
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

    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }
}

