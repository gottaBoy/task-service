/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBChgLog
extends BaseDataEntity {
    public static final String CHGTYPE_CREATEDATAENTITY = "CREATEDATAENTITY";
    public static final String CHGTYPE_UPDATEDATAENTITY = "UPDATEDATAENTITY";
    public static final String CHGTYPE_DELETEDATAENTITY = "DELETEDATAENTITY";
    public static final String CHGTYPE_CREATEDEFIELD = "CREATEDEFIELD";
    public static final String CHGTYPE_UPDATEDEFIELD = "UPDATEDEFIELD";
    public static final String CHGTYPE_DELETEDEFIELD = "DELETEDEFIELD";
    public static final String TAG_PSSYSDBCHGLOGID = "PSSYSDBCHGLOGID";
    public static final String TAG_PSSYSDBCHGLOGNAME = "PSSYSDBCHGLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_CHGTYPE = "CHGTYPE";

    public final boolean isPSSYSDBCHGLOGIDNull() {
        return this.IsParamNull(TAG_PSSYSDBCHGLOGID);
    }

    public final String getPSSYSDBCHGLOGID() {
        return this.GetParamStringValue(TAG_PSSYSDBCHGLOGID, "");
    }

    public final void setPSSYSDBCHGLOGID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBCHGLOGID, strValue);
    }

    public final boolean isPSSYSDBCHGLOGNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBCHGLOGNAME);
    }

    public final String getPSSYSDBCHGLOGNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBCHGLOGNAME, "");
    }

    public final void setPSSYSDBCHGLOGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBCHGLOGNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSOBJIDNull() {
        return this.IsParamNull(TAG_PSOBJID);
    }

    public final String getPSOBJID() {
        return this.GetParamStringValue(TAG_PSOBJID, "");
    }

    public final void setPSOBJID(String strValue) {
        this.SetParamValue(TAG_PSOBJID, strValue);
    }

    public final boolean isPSOBJNAMENull() {
        return this.IsParamNull(TAG_PSOBJNAME);
    }

    public final String getPSOBJNAME() {
        return this.GetParamStringValue(TAG_PSOBJNAME, "");
    }

    public final void setPSOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSOBJNAME, strValue);
    }

    public final boolean isCHGTYPENull() {
        return this.IsParamNull(TAG_CHGTYPE);
    }

    public final String getCHGTYPE() {
        return this.GetParamStringValue(TAG_CHGTYPE, "");
    }

    public final void setCHGTYPE(String strValue) {
        this.SetParamValue(TAG_CHGTYPE, strValue);
    }
}

