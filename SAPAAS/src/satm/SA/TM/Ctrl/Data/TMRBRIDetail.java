/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMRBRIDetail
extends BaseDataEntity {
    public static final String TAG_TMRBRIDETAILID = "TMRBRIDETAILID";
    public static final String TAG_TMRBRIDETAILNAME = "TMRBRIDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMRBRULEITEMID = "TMRBRULEITEMID";
    public static final String TAG_TMRBRULEITEMNAME = "TMRBRULEITEMNAME";
    public static final String TAG_TMRESBOOKINGID = "TMRESBOOKINGID";
    public static final String TAG_TMRESBOOKINGNAME = "TMRESBOOKINGNAME";

    public boolean isTMRBRIDETAILIDNull() {
        return this.IsParamNull(TAG_TMRBRIDETAILID);
    }

    public String getTMRBRIDETAILID() {
        return this.GetParamStringValue(TAG_TMRBRIDETAILID, "");
    }

    public void setTMRBRIDETAILID(String strValue) {
        this.SetParamValue(TAG_TMRBRIDETAILID, strValue);
    }

    public boolean isTMRBRIDETAILNAMENull() {
        return this.IsParamNull(TAG_TMRBRIDETAILNAME);
    }

    public String getTMRBRIDETAILNAME() {
        return this.GetParamStringValue(TAG_TMRBRIDETAILNAME, "");
    }

    public void setTMRBRIDETAILNAME(String strValue) {
        this.SetParamValue(TAG_TMRBRIDETAILNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isTMRBRULEITEMIDNull() {
        return this.IsParamNull(TAG_TMRBRULEITEMID);
    }

    public String getTMRBRULEITEMID() {
        return this.GetParamStringValue(TAG_TMRBRULEITEMID, "");
    }

    public void setTMRBRULEITEMID(String strValue) {
        this.SetParamValue(TAG_TMRBRULEITEMID, strValue);
    }

    public boolean isTMRBRULEITEMNAMENull() {
        return this.IsParamNull(TAG_TMRBRULEITEMNAME);
    }

    public String getTMRBRULEITEMNAME() {
        return this.GetParamStringValue(TAG_TMRBRULEITEMNAME, "");
    }

    public void setTMRBRULEITEMNAME(String strValue) {
        this.SetParamValue(TAG_TMRBRULEITEMNAME, strValue);
    }

    public boolean isTMRESBOOKINGIDNull() {
        return this.IsParamNull(TAG_TMRESBOOKINGID);
    }

    public String getTMRESBOOKINGID() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGID, "");
    }

    public void setTMRESBOOKINGID(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGID, strValue);
    }

    public boolean isTMRESBOOKINGNAMENull() {
        return this.IsParamNull(TAG_TMRESBOOKINGNAME);
    }

    public String getTMRESBOOKINGNAME() {
        return this.GetParamStringValue(TAG_TMRESBOOKINGNAME, "");
    }

    public void setTMRESBOOKINGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESBOOKINGNAME, strValue);
    }
}

