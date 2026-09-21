/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DBCallerCheck
extends XMLConfig {
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_CONDITION = "CONDITION";
    public static final String TAG_RETCODE = "RETCODE";
    public static final String TAG_MESSAGE = "MESSAGE";
    public static final String TAG_DATABASE = "DATABASE";
    public static final String TAG_FORMITEMS = "FORMITEMS";
    public static final String TAG_CUSTOMCMD = "CUSTOMCMD";
    protected String strParams = "";
    protected String strCondition = "";
    protected int nRetCode = 1000;
    protected String strMessage = "";
    protected String strDatabase = "";
    protected String strCustomCmd = "";
    protected String strFormItems = "";
    public static final int USERERROR = 1000;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, TAG_PARAMS, true) == 0) {
            this.strParams = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TAG_CONDITION) == 0) {
            this.strCondition = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TAG_RETCODE) == 0) {
            this.nRetCode = DBCallerCheck.GetValue(strValue, this.nRetCode);
            return;
        }
        if (strName.compareToIgnoreCase(TAG_MESSAGE) == 0) {
            this.strMessage = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TAG_DATABASE) == 0) {
            this.strDatabase = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_CUSTOMCMD, true) == 0) {
            this.strCustomCmd = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_FORMITEMS, true) == 0) {
            this.strFormItems = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getParams() {
        return this.strParams;
    }

    public void setParams(String strParams) {
        this.strParams = strParams;
    }

    public String getCondition() {
        return this.strCondition;
    }

    public void setCondition(String strCondition) {
        this.strCondition = strCondition;
    }

    public String getMessage() {
        return this.strMessage;
    }

    public void setMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetCode(int nRetCode) {
        this.nRetCode = nRetCode;
    }

    public String getDatabase() {
        return this.strDatabase;
    }

    public void setDatabase(String strDatabase) {
        this.strDatabase = strDatabase;
    }

    public String getCustomCmd() {
        return this.strCustomCmd;
    }

    public void setCustomCmd(String strCustomCmd) {
        this.strCustomCmd = strCustomCmd;
    }

    public String getFormItems() {
        if (StringHelper.Length(this.strFormItems) == 0) {
            return this.getParams();
        }
        return this.strFormItems;
    }

    public void setFormItems(String strFormItems) {
        this.strFormItems = strFormItems;
    }
}

