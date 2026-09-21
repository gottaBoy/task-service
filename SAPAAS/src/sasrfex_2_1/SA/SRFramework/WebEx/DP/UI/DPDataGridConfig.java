/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;

public class DPDataGridConfig
extends BaseControlConfig {
    public static final String TAG_DPDATAGRID = "SRFEXDPDATAGRID";
    public static final String TAG_URL = "URL";
    public static final String TAG_KEYFIELDS = "KEYFIELDS";
    public static final String TAG_RELATEDFIELDS = "RELATEDFIELDS";
    public static final String TAG_SAVEBEFOREMAJOR = "SAVEBEFOREMAJOR";
    public static final String TAG_TEMPDATA = "TEMPDATA";
    public static final String TAG_SAVEMAJORTIP = "SAVEMAJORTIP";
    public static final String TAG_RELATEDFORMSTATE = "RELATEDFORMSTATE";
    public static final String TAG_APPENDCTXPARAMS = "APPENDCTXPARAMS";
    protected String strURL = "";
    protected String strKeyFields = "";
    protected String strRelatedFields = "";
    protected boolean bSaveBeforeMajor = false;
    protected boolean bTempData = true;
    protected String strRelatedFormState = "";
    protected String strAppendCTXParams = "";
    protected String strSaveMajorTip = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_URL, (String)strName, (boolean)true) == 0) {
            this.setURL(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_KEYFIELDS, (String)strName, (boolean)true) == 0) {
            this.setKeyFields(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_RELATEDFIELDS, (String)strName, (boolean)true) == 0) {
            this.setRelatedFields(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_SAVEBEFOREMAJOR, (String)strName, (boolean)true) == 0) {
            this.setSaveBeforeMajor(DPDataGridConfig.GetValue((String)strValue, (boolean)this.isSaveBeforeMajor()));
            return;
        }
        if (StringHelper.Compare((String)TAG_TEMPDATA, (String)strName, (boolean)true) == 0) {
            this.setTempData(DPDataGridConfig.GetValue((String)strValue, (boolean)this.getTempData()));
            return;
        }
        if (StringHelper.Compare((String)TAG_RELATEDFORMSTATE, (String)strName, (boolean)true) == 0) {
            this.setRelatedFormState(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_APPENDCTXPARAMS, (String)strName, (boolean)true) == 0) {
            this.setAppendCTXParams(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_SAVEMAJORTIP, (String)strName, (boolean)true) == 0) {
            this.setSaveMajorTip(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getURL() {
        return this.strURL;
    }

    public void setURL(String strURL) {
        this.strURL = strURL;
    }

    public String getKeyFields() {
        return this.strKeyFields;
    }

    public String getRelatedFields() {
        return this.strRelatedFields;
    }

    public void setKeyFields(String strKeyFields) {
        this.strKeyFields = strKeyFields;
    }

    public void setRelatedFields(String strRelatedFields) {
        this.strRelatedFields = strRelatedFields;
    }

    public boolean isSaveBeforeMajor() {
        return this.bSaveBeforeMajor;
    }

    public void setSaveBeforeMajor(boolean bSaveBeforeMajor) {
        this.bSaveBeforeMajor = bSaveBeforeMajor;
    }

    public boolean getTempData() {
        return this.bTempData;
    }

    public void setTempData(boolean bTempData) {
        this.bTempData = bTempData;
    }

    public String getRelatedFormState() {
        return this.strRelatedFormState;
    }

    public void setRelatedFormState(String strRelatedFormState) {
        this.strRelatedFormState = strRelatedFormState;
    }

    public String getAppendCTXParams() {
        return this.strAppendCTXParams;
    }

    public void setAppendCTXParams(String strAppendCTXParams) {
        this.strAppendCTXParams = strAppendCTXParams;
    }

    public String getSaveMajorTip() {
        return this.strSaveMajorTip;
    }

    public void setSaveMajorTip(String strSaveMajorTip) {
        this.strSaveMajorTip = strSaveMajorTip;
    }
}

