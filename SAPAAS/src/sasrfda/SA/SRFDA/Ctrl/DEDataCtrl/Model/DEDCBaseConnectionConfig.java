/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public abstract class DEDCBaseConnectionConfig
extends XMLConfig {
    public static String TAG_NEXT = "NEXT";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DESC = "DESC";
    protected String strNext = "";
    protected String strName = "";
    protected String strLogicName = "";
    protected String strDesc = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NEXT, (boolean)true) == 0) {
            this.strNext = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0) {
            this.strName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOGICNAME, (boolean)true) == 0) {
            this.strLogicName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESC, (boolean)true) == 0) {
            this.strDesc = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getNext() {
        return this.strNext;
    }

    public void setNext(String strNext) {
        this.strNext = strNext;
    }

    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
            return this.getName();
        }
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getDesc() {
        return this.strDesc;
    }

    public void setDesc(String strDesc) {
        this.strDesc = strDesc;
    }
}

