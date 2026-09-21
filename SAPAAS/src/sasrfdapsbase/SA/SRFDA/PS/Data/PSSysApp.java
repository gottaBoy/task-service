/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysApp
extends BaseDataEntity {
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_APPPKGNAME = "APPPKGNAME";
    public static final String TAG_CODEFOLDER = "CODEFOLDER";
    public static final String TAG_DEFAULTPUB = "DEFAULTPUB";
    public static final String TAG_UACLOGIN = "UACLOGIN";
    public static final String TAG_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String TAG_ENABLEC12TOC24 = "ENABLEC12TOC24";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_GRIDROWACTIVEMODE = "GRIDROWACTIVEMODE";
    public static final String TAG_FINOPRIVDM = "FINOPRIVDM";
    public static final String TAG_GCNOPRIVDM = "GCNOPRIVDM";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

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

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
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

    public final boolean isAPPPKGNAMENull() {
        return this.IsParamNull(TAG_APPPKGNAME);
    }

    public final String getAPPPKGNAME() {
        return this.GetParamStringValue(TAG_APPPKGNAME, "");
    }

    public final void setAPPPKGNAME(String strValue) {
        this.SetParamValue(TAG_APPPKGNAME, strValue);
    }

    public final boolean isCODEFOLDERNull() {
        return this.IsParamNull(TAG_CODEFOLDER);
    }

    public final String getCODEFOLDER() {
        return this.GetParamStringValue(TAG_CODEFOLDER, "");
    }

    public final void setCODEFOLDER(String strValue) {
        this.SetParamValue(TAG_CODEFOLDER, strValue);
    }

    public final boolean isUACLOGINNull() {
        return this.IsParamNull(TAG_UACLOGIN);
    }

    public final boolean getUACLOGIN() {
        return this.GetParamIntValue(TAG_UACLOGIN, 0) == 1;
    }

    public final void setUACLOGIN(boolean bValue) {
        this.SetParamValue(TAG_UACLOGIN, bValue ? 1 : 0);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.IsParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.GetParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.SetParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isENABLEC12TOC24Null() {
        return this.IsParamNull(TAG_ENABLEC12TOC24);
    }

    public final boolean getENABLEC12TOC24() {
        return this.GetParamIntValue(TAG_ENABLEC12TOC24, 0) == 1;
    }

    public final void setENABLEC12TOC24(boolean bValue) {
        this.SetParamValue(TAG_ENABLEC12TOC24, bValue ? 1 : 0);
    }

    public final boolean isPREVENTXSSNull() {
        return this.IsParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.GetParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.SetParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isGRIDROWACTIVEMODENull() {
        return this.IsParamNull(TAG_GRIDROWACTIVEMODE);
    }

    public final int getGRIDROWACTIVEMODE() {
        return this.GetParamIntValue(TAG_GRIDROWACTIVEMODE, 0);
    }

    public final void setGRIDROWACTIVEMODE(int nValue) {
        this.SetParamValue(TAG_GRIDROWACTIVEMODE, nValue);
    }

    public final boolean isFINOPRIVDMNull() {
        return this.IsParamNull(TAG_FINOPRIVDM);
    }

    public final int getFINOPRIVDM() {
        return this.GetParamIntValue(TAG_FINOPRIVDM, 0);
    }

    public final void setFINOPRIVDM(int nValue) {
        this.SetParamValue(TAG_FINOPRIVDM, nValue);
    }

    public final boolean isGCNOPRIVDMNull() {
        return this.IsParamNull(TAG_GCNOPRIVDM);
    }

    public final int getGCNOPRIVDM() {
        return this.GetParamIntValue(TAG_GCNOPRIVDM, 0);
    }

    public final void setGCNOPRIVDM(int nValue) {
        this.SetParamValue(TAG_GCNOPRIVDM, nValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPINAME);
    }

    public final String getPSSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPINAME, "");
    }

    public final void setPSSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPINAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }
}

