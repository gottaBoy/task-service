/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class TBTempl
extends BaseDataEntity {
    public static final String TAG_TBTEMPLID = "TBTEMPLID";
    public static final String TAG_TBTEMPLNAME = "TBTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TBMODEL = "TBMODEL";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    protected ToolbarConfig toolbarConfig = null;

    public ToolbarConfig getToolbarConfig() {
        if (this.toolbarConfig == null) {
            this.toolbarConfig = new ToolbarConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getTBMODEL())) {
                this.toolbarConfig.LoadXML(this.getTBMODEL());
            }
        }
        return this.toolbarConfig;
    }

    public String getTBTEMPLID() {
        return this.GetParamStringValue(TAG_TBTEMPLID, "");
    }

    public void setTBTEMPLID(String strValue) {
        this.SetParamValue(TAG_TBTEMPLID, strValue);
    }

    public String getTBTEMPLNAME() {
        return this.GetParamStringValue(TAG_TBTEMPLNAME, "");
    }

    public void setTBTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_TBTEMPLNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getTBMODEL() {
        return this.GetParamStringValue(TAG_TBMODEL, "");
    }

    public void setTBMODEL(String strValue) {
        this.SetParamValue(TAG_TBMODEL, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

