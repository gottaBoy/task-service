/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PatchRemoveItem
extends BaseDataEntity {
    public static final String TAG_PATCHREMOVEITEMID = "PATCHREMOVEITEMID";
    public static final String TAG_PATCHREMOVEITEMNAME = "PATCHREMOVEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PATCHGROUP = "PATCHGROUP";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_KEYDATA = "KEYDATA";

    public String getPATCHREMOVEITEMID() {
        return this.GetParamStringValue(TAG_PATCHREMOVEITEMID, "");
    }

    public void setPATCHREMOVEITEMID(String strValue) {
        this.SetParamValue(TAG_PATCHREMOVEITEMID, strValue);
    }

    public String getPATCHREMOVEITEMNAME() {
        return this.GetParamStringValue(TAG_PATCHREMOVEITEMNAME, "");
    }

    public void setPATCHREMOVEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PATCHREMOVEITEMNAME, strValue);
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

    public boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public int getPATCHGROUP() {
        return this.GetParamIntValue(TAG_PATCHGROUP, 0);
    }

    public void setPATCHGROUP(int strValue) {
        this.SetParamValue(TAG_PATCHGROUP, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getKEYDATA() {
        return this.GetParamStringValue(TAG_KEYDATA, "");
    }

    public void setKEYDATA(String strValue) {
        this.SetParamValue(TAG_KEYDATA, strValue);
    }
}

