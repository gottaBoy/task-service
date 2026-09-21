/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPL
extends BaseDataEntity {
    public static final String TAG_BIREPPLID = "BIREPPLID";
    public static final String TAG_BIREPPLNAME = "BIREPPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_NAMESPACE = "NAMESPACE";
    public static final String TAG_OBJECTNAME = "OBJECTNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isBIREPPLIDNull() {
        return this.IsParamNull(TAG_BIREPPLID);
    }

    public String getBIREPPLID() {
        return this.GetParamStringValue(TAG_BIREPPLID, "");
    }

    public void setBIREPPLID(String strValue) {
        this.SetParamValue(TAG_BIREPPLID, strValue);
    }

    public boolean isBIREPPLNAMENull() {
        return this.IsParamNull(TAG_BIREPPLNAME);
    }

    public String getBIREPPLNAME() {
        return this.GetParamStringValue(TAG_BIREPPLNAME, "");
    }

    public void setBIREPPLNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPLNAME, strValue);
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

    public boolean isNAMESPACENull() {
        return this.IsParamNull(TAG_NAMESPACE);
    }

    public String getNAMESPACE() {
        return this.GetParamStringValue(TAG_NAMESPACE, "");
    }

    public void setNAMESPACE(String strValue) {
        this.SetParamValue(TAG_NAMESPACE, strValue);
    }

    public boolean isOBJECTNAMENull() {
        return this.IsParamNull(TAG_OBJECTNAME);
    }

    public String getOBJECTNAME() {
        return this.GetParamStringValue(TAG_OBJECTNAME, "");
    }

    public void setOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_OBJECTNAME, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

