/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCMobAppTestDevice
extends BaseDataEntity {
    public static final String OSTYPE_IOS = "IOS";
    public static final String OSTYPE_ANDROID = "ANDROID";
    public static final String OSVER_A0400 = "A0400";
    public static final String OSVER_A0500 = "A0500";
    public static final String OSVER_A0600 = "A0600";
    public static final String OSVER_I0700 = "I0700";
    public static final String OSVER_I0800 = "I0800";
    public static final String OSVER_I0900 = "I0900";
    public static final String TAG_PSDCMOBAPPTESTDEVICEID = "PSDCMOBAPPTESTDEVICEID";
    public static final String TAG_PSDCMOBAPPTESTDEVICENAME = "PSDCMOBAPPTESTDEVICENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REFCOUNT = "REFCOUNT";
    public static final String TAG_DEVICEID = "DEVICEID";
    public static final String TAG_OSTYPE = "OSTYPE";
    public static final String TAG_OSVER = "OSVER";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSDCMOBAPPTESTDEVICEIDNull() {
        return this.IsParamNull(TAG_PSDCMOBAPPTESTDEVICEID);
    }

    public final String getPSDCMOBAPPTESTDEVICEID() {
        return this.GetParamStringValue(TAG_PSDCMOBAPPTESTDEVICEID, "");
    }

    public final void setPSDCMOBAPPTESTDEVICEID(String strValue) {
        this.SetParamValue(TAG_PSDCMOBAPPTESTDEVICEID, strValue);
    }

    public final boolean isPSDCMOBAPPTESTDEVICENAMENull() {
        return this.IsParamNull(TAG_PSDCMOBAPPTESTDEVICENAME);
    }

    public final String getPSDCMOBAPPTESTDEVICENAME() {
        return this.GetParamStringValue(TAG_PSDCMOBAPPTESTDEVICENAME, "");
    }

    public final void setPSDCMOBAPPTESTDEVICENAME(String strValue) {
        this.SetParamValue(TAG_PSDCMOBAPPTESTDEVICENAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isREFCOUNTNull() {
        return this.IsParamNull(TAG_REFCOUNT);
    }

    public final int getREFCOUNT() {
        return this.GetParamIntValue(TAG_REFCOUNT, 0);
    }

    public final void setREFCOUNT(int nValue) {
        this.SetParamValue(TAG_REFCOUNT, nValue);
    }

    public final boolean isDEVICEIDNull() {
        return this.IsParamNull(TAG_DEVICEID);
    }

    public final String getDEVICEID() {
        return this.GetParamStringValue(TAG_DEVICEID, "");
    }

    public final void setDEVICEID(String strValue) {
        this.SetParamValue(TAG_DEVICEID, strValue);
    }

    public final boolean isOSTYPENull() {
        return this.IsParamNull(TAG_OSTYPE);
    }

    public final String getOSTYPE() {
        return this.GetParamStringValue(TAG_OSTYPE, "");
    }

    public final void setOSTYPE(String strValue) {
        this.SetParamValue(TAG_OSTYPE, strValue);
    }

    public final boolean isOSVERNull() {
        return this.IsParamNull(TAG_OSVER);
    }

    public final String getOSVER() {
        return this.GetParamStringValue(TAG_OSVER, "");
    }

    public final void setOSVER(String strValue) {
        this.SetParamValue(TAG_OSVER, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

