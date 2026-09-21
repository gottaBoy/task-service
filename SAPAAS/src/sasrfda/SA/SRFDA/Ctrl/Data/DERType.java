/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DERType
extends BaseDataEntity {
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_ISCOLLAPSE = "ISCOLLAPSE";
    public static final String TAG_DATAENTITY_DENAME = "DATAENTITY_DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DERTYPENAMELANRESID = "DERTYPENAMELANRESID";
    public static final String TAG_DERTYPENAMELANRESNAME = "DERTYPENAMELANRESNAME";

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

    public String getDERTYPEID() {
        return this.GetParamStringValue(TAG_DERTYPEID, "");
    }

    public void setDERTYPEID(String strValue) {
        this.SetParamValue(TAG_DERTYPEID, strValue);
    }

    public String getDERTYPENAME() {
        return this.GetParamStringValue(TAG_DERTYPENAME, "");
    }

    public void setDERTYPENAME(String strValue) {
        this.SetParamValue(TAG_DERTYPENAME, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public boolean getISCOLLAPSE() {
        return this.GetParamIntValue(TAG_ISCOLLAPSE, 0) == 1;
    }

    public void setISCOLLAPSE(boolean bValue) {
        this.SetParamValue(TAG_ISCOLLAPSE, bValue ? 1 : 0);
    }

    public String getDATAENTITY_DENAME() {
        return this.GetParamStringValue(TAG_DATAENTITY_DENAME, "");
    }

    public void setDATAENTITY_DENAME(String strValue) {
        this.SetParamValue(TAG_DATAENTITY_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isCOLLAPSE() {
        return this.GetParamIntValue(TAG_ISCOLLAPSE, 0) == 1;
    }

    public boolean isDERTYPENAMELANRESIDNull() {
        return this.IsParamNull(TAG_DERTYPENAMELANRESID);
    }

    public String getDERTYPENAMELANRESID() {
        return this.GetParamStringValue(TAG_DERTYPENAMELANRESID, "");
    }

    public void setDERTYPENAMELANRESID(String strValue) {
        this.SetParamValue(TAG_DERTYPENAMELANRESID, strValue);
    }

    public boolean isDERTYPENAMELANRESNAMENull() {
        return this.IsParamNull(TAG_DERTYPENAMELANRESNAME);
    }

    public String getDERTYPENAMELANRESNAME() {
        return this.GetParamStringValue(TAG_DERTYPENAMELANRESNAME, "");
    }

    public void setDERTYPENAMELANRESNAME(String strValue) {
        this.SetParamValue(TAG_DERTYPENAMELANRESNAME, strValue);
    }
}

