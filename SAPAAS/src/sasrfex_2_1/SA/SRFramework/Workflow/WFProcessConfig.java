/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.WFEntityConfig;

public class WFProcessConfig
extends WFEntityConfig {
    public static final String TAG_WFPROCESS = "SRFEXWFPROCESS";
    public static final String TAG_ALWAYSUCCESS = "ALWAYSUCCESS";
    public static final String TAG_TRANSACTION = "TRANSACTION";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_EXECUTEMODE = "EXECUTEMODE";
    protected boolean bTransaction = false;
    protected String strObject = null;
    protected String strExecuteMode = "";
    protected boolean bAlwaySuccess = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TRANSACTION, (boolean)true) == 0) {
            this.bTransaction = WFProcessConfig.GetValue((String)strValue, (boolean)this.bTransaction);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_OBJECT, (boolean)true) == 0) {
            this.strObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXECUTEMODE, (boolean)true) == 0) {
            this.strExecuteMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALWAYSUCCESS, (boolean)true) == 0) {
            this.bAlwaySuccess = WFProcessConfig.GetValue((String)strValue, (boolean)this.bAlwaySuccess);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getTransaction() {
        return this.bTransaction;
    }

    void setTransaction(boolean bTransaction) {
        this.bTransaction = bTransaction;
    }

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String value) {
        this.strObject = value;
    }

    public boolean getAlwaySuccess() {
        return this.bAlwaySuccess;
    }

    void setAlwaySuccess(boolean bAlwaySuccess) {
        this.bAlwaySuccess = bAlwaySuccess;
    }
}

