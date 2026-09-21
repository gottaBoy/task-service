/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class VCLog
extends BaseDataEntity {
    public static final String VCLOGNAME_CREATE = "CREATE";
    public static final String VCLOGNAME_CHECKOUT = "CHECKOUT";
    public static final String VCLOGNAME_CHECKIN = "CHECKIN";
    public static final String VCLOGNAME_DELETE = "DELETE";
    public static final String VCLOGNAME_UNDOCHECKOUT = "UNDOCHECKOUT";
    public static final String TAG_VCLOGID = "VCLOGID";
    public static final String TAG_VCLOGNAME = "VCLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DATAID = "DATAID";
    public static final String TAG_DATAVERSION = "DATAVERSION";

    public final boolean isVCLOGIDNull() {
        return this.IsParamNull(TAG_VCLOGID);
    }

    public final String getVCLOGID() {
        return this.GetParamStringValue(TAG_VCLOGID, "");
    }

    public final void setVCLOGID(String strValue) {
        this.SetParamValue(TAG_VCLOGID, strValue);
    }

    public final boolean isVCLOGNAMENull() {
        return this.IsParamNull(TAG_VCLOGNAME);
    }

    public final String getVCLOGNAME() {
        return this.GetParamStringValue(TAG_VCLOGNAME, "");
    }

    public final void setVCLOGNAME(String strValue) {
        this.SetParamValue(TAG_VCLOGNAME, strValue);
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

    public final boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public final String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public final void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public final boolean isDATAIDNull() {
        return this.IsParamNull(TAG_DATAID);
    }

    public final String getDATAID() {
        return this.GetParamStringValue(TAG_DATAID, "");
    }

    public final void setDATAID(String strValue) {
        this.SetParamValue(TAG_DATAID, strValue);
    }

    public final boolean isDATAVERSIONNull() {
        return this.IsParamNull(TAG_DATAVERSION);
    }

    public final int getDATAVERSION() {
        return this.GetParamIntValue(TAG_DATAVERSION, 0);
    }

    public final void setDATAVERSION(int nValue) {
        this.SetParamValue(TAG_DATAVERSION, nValue);
    }
}

