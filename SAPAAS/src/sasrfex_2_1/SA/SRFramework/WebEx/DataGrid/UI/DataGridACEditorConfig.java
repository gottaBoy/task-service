/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DataGrid.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DataGrid.UI.DataGridBaseEditorConfig;

public class DataGridACEditorConfig
extends DataGridBaseEditorConfig {
    public static final String TAG_SRFEXDATAGRIDACEDITOR = "SRFEXDATAGRIDACEDITOR";
    public static final String TAG_ACMODE = "ACMODE";
    public static final String TAG_ACPARAMS = "ACPARAMS";
    public static final String TAG_ACFILLPARAMS = "ACFILLPARAMS";
    public static final String TAG_ACDATAURL = "ACDATAURL";
    public static final String TAG_ACMINCHARS = "ACMINCHARS";
    public static final String TAG_ACLISTWIDTH = "ACLISTWIDTH";
    public static final String TAG_ACFORCESELECTION = "FORCESELECTION";
    public static final String TAG_ACAPPENDPARAMS = "ACAPPENDPARAMS";
    public static final String TAG_ACUSERPARAMS = "ACUSERPARAMS";
    public static final String TAG_ACHIDETRIGGER = "ACHIDETRIGGER";
    public static final String TAG_ACAFTERSELECTCODE = "ACAFTERSELECTCODE";
    public static final String TAG_ACTRIGGERASALL = "ACTRIGGERASALL";
    public static final String TAG_ACAPPENDURLPARAMS = "ACAPPENDURLPARAMS";
    protected String strACAppendURLParams = "";
    protected String strACMode = "";
    protected String strACParams = "";
    protected String strACFillParams = "";
    protected String strACDataURL = "";
    protected int nACMinChars = 2;
    protected boolean bACForceSelection = false;
    protected String strACAppendParams = "";
    protected String strACUserParams = "";
    protected int nACListWidth = 0;
    protected boolean bACHideTrigger = true;
    protected String strACAfterSelectCode = "";
    protected boolean bACTriggerAsAll = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ACMODE, (boolean)true) == 0) {
            this.strACMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACPARAMS, (boolean)true) == 0) {
            this.strACParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACFILLPARAMS, (boolean)true) == 0) {
            this.strACFillParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACDATAURL, (boolean)true) == 0) {
            this.strACDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACLISTWIDTH, (boolean)true) == 0) {
            this.nACListWidth = DataGridACEditorConfig.GetValue((String)strValue, (int)this.nACListWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACMINCHARS, (boolean)true) == 0) {
            this.nACMinChars = DataGridACEditorConfig.GetValue((String)strValue, (int)this.nACMinChars);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACFORCESELECTION, (boolean)true) == 0) {
            this.bACForceSelection = DataGridACEditorConfig.GetValue((String)strValue, (boolean)this.bACForceSelection);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACAPPENDPARAMS, (boolean)true) == 0) {
            this.strACAppendParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACUSERPARAMS, (boolean)true) == 0) {
            this.strACUserParams = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACHIDETRIGGER, (boolean)true) == 0) {
            this.bACHideTrigger = DataGridACEditorConfig.GetValue((String)strValue, (boolean)this.bACHideTrigger);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACAFTERSELECTCODE, (boolean)true) == 0) {
            this.strACAfterSelectCode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTRIGGERASALL, (boolean)true) == 0) {
            this.bACTriggerAsAll = DataGridACEditorConfig.GetValue((String)strValue, (boolean)this.bACTriggerAsAll);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACAPPENDURLPARAMS, (boolean)true) == 0) {
            this.setACAppendURLParams(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getACMinChars() {
        return this.nACMinChars;
    }

    public void setACMinChars(int value) {
        this.nACMinChars = value;
    }

    public int getACListWidth() {
        return this.nACListWidth;
    }

    public void setACListWidth(int value) {
        this.nACListWidth = value;
    }

    public String getACMode() {
        return this.strACMode;
    }

    public void setACMode(String value) {
        this.strACMode = value;
    }

    public String getACDataURL() {
        return this.strACDataURL;
    }

    public void setACDataURL(String strACDataURL) {
        this.strACDataURL = strACDataURL;
    }

    public void setACAppendParams(String strACAppendParams) {
        this.strACAppendParams = strACAppendParams;
    }

    public String getACAppendParams() {
        return this.strACAppendParams;
    }

    public void setACUserParams(String strACUserParams) {
        this.strACUserParams = strACUserParams;
    }

    public String getACUserParams() {
        return this.strACUserParams;
    }

    public boolean getACForceSelection() {
        return this.bACForceSelection;
    }

    public void setACForceSelection(boolean bACForceSelection) {
        this.bACForceSelection = bACForceSelection;
    }

    public String getACParams() {
        return this.strACParams;
    }

    public void setACParams(String value) {
        this.strACParams = value;
    }

    public String getACFillParams() {
        return this.strACFillParams;
    }

    public void setACFillParams(String value) {
        this.strACFillParams = value;
    }

    public boolean getACHideTrigger() {
        return this.bACHideTrigger;
    }

    public void setACHideTrigger(boolean bACHideTrigger) {
        this.bACHideTrigger = bACHideTrigger;
    }

    public String getACAfterSelectCode() {
        return this.strACAfterSelectCode;
    }

    public void setACAfterSelectCode(String value) {
        this.strACAfterSelectCode = value;
    }

    public boolean isACTriggerAsAll() {
        return this.bACTriggerAsAll;
    }

    public void setACTriggerAsAll(boolean triggerAsAll) {
        this.bACTriggerAsAll = triggerAsAll;
    }

    public String getACAppendURLParams() {
        return this.strACAppendURLParams;
    }

    public void setACAppendURLParams(String strACAppendURLParams) {
        this.strACAppendURLParams = strACAppendURLParams;
    }
}

