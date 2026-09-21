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

public class DEFDTColumnConfig
extends XMLConfig {
    public static final String TAG_DEFDTCOLUMN = "SRFDADEFDTCOLUMN";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_VALUEGENFUNC = "VALUEGENFUNC";
    protected String strObject = "";
    protected String strLogicName = "";
    protected String strValueGenFunc = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_VALUEGENFUNC, (String)strName, (boolean)true) == 0) {
            this.setValueGenFunc(strValue);
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

    public String getValueGenFunc() {
        return this.strValueGenFunc;
    }

    public String getValueGenFunc(String strDBType) {
        return this.GetExtValue(StringHelper.Format((String)"%1$s.%2$s", (Object)TAG_VALUEGENFUNC, (Object)strDBType), this.strValueGenFunc);
    }

    public void setValueGenFunc(String strValueGenFunc) {
        this.strValueGenFunc = strValueGenFunc;
    }
}

