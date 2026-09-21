/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCMobAppPackCert
extends BaseDataEntity {
    public static final String TAG_PSDCMOBPACKCERTID = "PSDCMOBPACKCERTID";
    public static final String TAG_PSDCMOBPACKCERTNAME = "PSDCMOBPACKCERTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ANDROIDCERTFILE = "ANDROIDCERTFILE";
    public static final String TAG_ANDROIDCERTDOMAIN = "ANDROIDCERTDOMAIN";
    public static final String TAG_ANDROIDCERTALIAS = "ANDROIDCERTALIAS";
    public static final String TAG_ANDROIDCERTSTOREPWD = "ANDROIDCERTSTOREPWD";
    public static final String TAG_ANDROIDCERTKEY = "ANDROIDCERTKEY";
    public static final String TAG_IOSAPPIDS = "IOSAPPIDS";
    public static final String TAG_IOSCERTPWD = "IOSCERTPWD";
    public static final String TAG_IOSDISTMPCERT = "IOSDISTMPCERT";
    public static final String TAG_IOSDISTP12CERT = "IOSDISTP12CERT";
    public static final String TAG_IOSWKAMPCERT = "IOSWKAMPCERT";
    public static final String TAG_IOSWKEMPCERT = "IOSWKEMPCERT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PACKTYPE = "PACKTYPE";
    public static final String TAG_ANDROIDCERTINFO = "ANDROIDCERTINFO";
    public static final String TAG_IOSCERTINFO = "IOSCERTINFO";

    public final boolean isPSDCMOBPACKCERTIDNull() {
        return this.IsParamNull(TAG_PSDCMOBPACKCERTID);
    }

    public final String getPSDCMOBPACKCERTID() {
        return this.GetParamStringValue(TAG_PSDCMOBPACKCERTID, "");
    }

    public final void setPSDCMOBPACKCERTID(String strValue) {
        this.SetParamValue(TAG_PSDCMOBPACKCERTID, strValue);
    }

    public final boolean isPSDCMOBPACKCERTNAMENull() {
        return this.IsParamNull(TAG_PSDCMOBPACKCERTNAME);
    }

    public final String getPSDCMOBPACKCERTNAME() {
        return this.GetParamStringValue(TAG_PSDCMOBPACKCERTNAME, "");
    }

    public final void setPSDCMOBPACKCERTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCMOBPACKCERTNAME, strValue);
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

    public final boolean isANDROIDCERTFILENull() {
        return this.IsParamNull(TAG_ANDROIDCERTFILE);
    }

    public final String getANDROIDCERTFILE() {
        return this.GetParamStringValue(TAG_ANDROIDCERTFILE, "");
    }

    public final void setANDROIDCERTFILE(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTFILE, strValue);
    }

    public final boolean isANDROIDCERTDOMAINNull() {
        return this.IsParamNull(TAG_ANDROIDCERTDOMAIN);
    }

    public final String getANDROIDCERTDOMAIN() {
        return this.GetParamStringValue(TAG_ANDROIDCERTDOMAIN, "");
    }

    public final void setANDROIDCERTDOMAIN(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTDOMAIN, strValue);
    }

    public final boolean isANDROIDCERTALIASNull() {
        return this.IsParamNull(TAG_ANDROIDCERTALIAS);
    }

    public final String getANDROIDCERTALIAS() {
        return this.GetParamStringValue(TAG_ANDROIDCERTALIAS, "");
    }

    public final void setANDROIDCERTALIAS(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTALIAS, strValue);
    }

    public final boolean isANDROIDCERTSTOREPWDNull() {
        return this.IsParamNull(TAG_ANDROIDCERTSTOREPWD);
    }

    public final String getANDROIDCERTSTOREPWD() {
        return this.GetParamStringValue(TAG_ANDROIDCERTSTOREPWD, "");
    }

    public final void setANDROIDCERTSTOREPWD(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTSTOREPWD, strValue);
    }

    public final boolean isANDROIDCERTKEYNull() {
        return this.IsParamNull(TAG_ANDROIDCERTKEY);
    }

    public final String getANDROIDCERTKEY() {
        return this.GetParamStringValue(TAG_ANDROIDCERTKEY, "");
    }

    public final void setANDROIDCERTKEY(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTKEY, strValue);
    }

    public final boolean isIOSAPPIDSNull() {
        return this.IsParamNull(TAG_IOSAPPIDS);
    }

    public final String getIOSAPPIDS() {
        return this.GetParamStringValue(TAG_IOSAPPIDS, "");
    }

    public final void setIOSAPPIDS(String strValue) {
        this.SetParamValue(TAG_IOSAPPIDS, strValue);
    }

    public final boolean isIOSCERTPWDNull() {
        return this.IsParamNull(TAG_IOSCERTPWD);
    }

    public final String getIOSCERTPWD() {
        return this.GetParamStringValue(TAG_IOSCERTPWD, "");
    }

    public final void setIOSCERTPWD(String strValue) {
        this.SetParamValue(TAG_IOSCERTPWD, strValue);
    }

    public final boolean isIOSDISTMPCERTNull() {
        return this.IsParamNull(TAG_IOSDISTMPCERT);
    }

    public final String getIOSDISTMPCERT() {
        return this.GetParamStringValue(TAG_IOSDISTMPCERT, "");
    }

    public final void setIOSDISTMPCERT(String strValue) {
        this.SetParamValue(TAG_IOSDISTMPCERT, strValue);
    }

    public final boolean isIOSDISTP12CERTNull() {
        return this.IsParamNull(TAG_IOSDISTP12CERT);
    }

    public final String getIOSDISTP12CERT() {
        return this.GetParamStringValue(TAG_IOSDISTP12CERT, "");
    }

    public final void setIOSDISTP12CERT(String strValue) {
        this.SetParamValue(TAG_IOSDISTP12CERT, strValue);
    }

    public final boolean isIOSWKAMPCERTNull() {
        return this.IsParamNull(TAG_IOSWKAMPCERT);
    }

    public final String getIOSWKAMPCERT() {
        return this.GetParamStringValue(TAG_IOSWKAMPCERT, "");
    }

    public final void setIOSWKAMPCERT(String strValue) {
        this.SetParamValue(TAG_IOSWKAMPCERT, strValue);
    }

    public final boolean isIOSWKEMPCERTNull() {
        return this.IsParamNull(TAG_IOSWKEMPCERT);
    }

    public final String getIOSWKEMPCERT() {
        return this.GetParamStringValue(TAG_IOSWKEMPCERT, "");
    }

    public final void setIOSWKEMPCERT(String strValue) {
        this.SetParamValue(TAG_IOSWKEMPCERT, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPACKTYPENull() {
        return this.IsParamNull(TAG_PACKTYPE);
    }

    public final String getPACKTYPE() {
        return this.GetParamStringValue(TAG_PACKTYPE, "");
    }

    public final void setPACKTYPE(String strValue) {
        this.SetParamValue(TAG_PACKTYPE, strValue);
    }

    public final boolean isANDROIDCERTINFONull() {
        return this.IsParamNull(TAG_ANDROIDCERTINFO);
    }

    public final String getANDROIDCERTINFO() {
        return this.GetParamStringValue(TAG_ANDROIDCERTINFO, "");
    }

    public final void setANDROIDCERTINFO(String strValue) {
        this.SetParamValue(TAG_ANDROIDCERTINFO, strValue);
    }

    public final boolean isIOSCERTINFONull() {
        return this.IsParamNull(TAG_IOSCERTINFO);
    }

    public final String getIOSCERTINFO() {
        return this.GetParamStringValue(TAG_IOSCERTINFO, "");
    }

    public final void setIOSCERTINFO(String strValue) {
        this.SetParamValue(TAG_IOSCERTINFO, strValue);
    }
}

