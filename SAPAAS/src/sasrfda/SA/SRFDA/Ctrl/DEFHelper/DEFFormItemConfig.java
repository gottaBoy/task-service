/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEFFormItemConfig
extends XMLConfig {
    public static final String TAG_DEFFORMITEM = "SRFDADEFFORMITEM";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    protected String strObject = "";
    protected String strLogicName = "";
    protected String strItemFormat = "%1$s";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_ITEMFORMAT, (String)strName, (boolean)true) == 0) {
            this.setItemFormat(strValue);
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

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }
}

