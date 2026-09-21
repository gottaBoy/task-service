/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.WT.Data;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class WTServiceBase
extends BaseDataEntity {
    public static final String PRESERVICEMODE_VERIFYSERVICE = "VERIFYSERVICE";
    public static final String PRESERVICEMODE_DEFAULTSERVICE = "DEFAULTSERVICE";
    public static final String PRESERVICEMODE_SUBSCRIBESERVICE = "SUBSCRIBESERVICE";
    public static final String TAG_WTSERVICEBASEID = "WTSERVICEBASEID";
    public static final String TAG_WTSERVICEBASENAME = "WTSERVICEBASENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_WTSERVICEBASETYPE = "WTSERVICEBASETYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_SERVICEHELPER = "SERVICEHELPER";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SENDTEXT = "SENDTEXT";
    public static final String TAG_SENDCONTENT = "SENDCONTENT";
    public static final String TAG_ACTIONMODEL = "ACTIONMODEL";
    public static final String TAG_DEBUGOUTPUT = "DEBUGOUTPUT";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_VERIFYFLAG = "VERIFYFLAG";
    public static final String TAG_SERVICECODE = "SERVICECODE";
    public static final String TAG_REQVERFIY = "REQVERFIY";
    public static final String TAG_PRESERVICEMODE = "PRESERVICEMODE";
    protected DEDCConfig dedcConfig = null;

    public final boolean isWTSERVICEBASEIDNull() {
        return this.IsParamNull(TAG_WTSERVICEBASEID);
    }

    public final String getWTSERVICEBASEID() {
        return this.GetParamStringValue(TAG_WTSERVICEBASEID, "");
    }

    public final void setWTSERVICEBASEID(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASEID, strValue);
    }

    public final boolean isWTSERVICEBASENAMENull() {
        return this.IsParamNull(TAG_WTSERVICEBASENAME);
    }

    public final String getWTSERVICEBASENAME() {
        return this.GetParamStringValue(TAG_WTSERVICEBASENAME, "");
    }

    public final void setWTSERVICEBASENAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isWTSERVICEBASETYPENull() {
        return this.IsParamNull(TAG_WTSERVICEBASETYPE);
    }

    public final String getWTSERVICEBASETYPE() {
        return this.GetParamStringValue(TAG_WTSERVICEBASETYPE, "");
    }

    public final void setWTSERVICEBASETYPE(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASETYPE, strValue);
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

    public final boolean isWTACCOUNTIDNull() {
        return this.IsParamNull(TAG_WTACCOUNTID);
    }

    public final String getWTACCOUNTID() {
        return this.GetParamStringValue(TAG_WTACCOUNTID, "");
    }

    public final void setWTACCOUNTID(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTID, strValue);
    }

    public final boolean isWTACCOUNTNAMENull() {
        return this.IsParamNull(TAG_WTACCOUNTNAME);
    }

    public final String getWTACCOUNTNAME() {
        return this.GetParamStringValue(TAG_WTACCOUNTNAME, "");
    }

    public final void setWTACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTNAME, strValue);
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

    public final boolean isSERVICEHELPERNull() {
        return this.IsParamNull(TAG_SERVICEHELPER);
    }

    public final String getSERVICEHELPER() {
        return this.GetParamStringValue(TAG_SERVICEHELPER, "");
    }

    public final void setSERVICEHELPER(String strValue) {
        this.SetParamValue(TAG_SERVICEHELPER, strValue);
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

    public final boolean isSENDTEXTNull() {
        return this.IsParamNull(TAG_SENDTEXT);
    }

    public final String getSENDTEXT() {
        return this.GetParamStringValue(TAG_SENDTEXT, "");
    }

    public final void setSENDTEXT(String strValue) {
        this.SetParamValue(TAG_SENDTEXT, strValue);
    }

    public final boolean isSENDCONTENTNull() {
        return this.IsParamNull(TAG_SENDCONTENT);
    }

    public final String getSENDCONTENT() {
        return this.GetParamStringValue(TAG_SENDCONTENT, "");
    }

    public final void setSENDCONTENT(String strValue) {
        this.SetParamValue(TAG_SENDCONTENT, strValue);
    }

    public final boolean isACTIONMODELNull() {
        return this.IsParamNull(TAG_ACTIONMODEL);
    }

    public final String getACTIONMODEL() {
        return this.GetParamStringValue(TAG_ACTIONMODEL, "");
    }

    public final void setACTIONMODEL(String strValue) {
        this.SetParamValue(TAG_ACTIONMODEL, strValue);
    }

    public final boolean isDEBUGOUTPUTNull() {
        return this.IsParamNull(TAG_DEBUGOUTPUT);
    }

    public final boolean getDEBUGOUTPUT() {
        return this.GetParamIntValue(TAG_DEBUGOUTPUT, 0) == 1;
    }

    public final void setDEBUGOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_DEBUGOUTPUT, bValue ? 1 : 0);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isVERIFYFLAGNull() {
        return this.IsParamNull(TAG_VERIFYFLAG);
    }

    public final boolean getVERIFYFLAG() {
        return this.GetParamIntValue(TAG_VERIFYFLAG, 0) == 1;
    }

    public final void setVERIFYFLAG(boolean bValue) {
        this.SetParamValue(TAG_VERIFYFLAG, bValue ? 1 : 0);
    }

    public final boolean isSERVICECODENull() {
        return this.IsParamNull(TAG_SERVICECODE);
    }

    public final String getSERVICECODE() {
        return this.GetParamStringValue(TAG_SERVICECODE, "");
    }

    public final void setSERVICECODE(String strValue) {
        this.SetParamValue(TAG_SERVICECODE, strValue);
    }

    public final boolean isREQVERFIYNull() {
        return this.IsParamNull(TAG_REQVERFIY);
    }

    public final boolean getREQVERFIY() {
        return this.GetParamIntValue(TAG_REQVERFIY, 0) == 1;
    }

    public final void setREQVERFIY(boolean bValue) {
        this.SetParamValue(TAG_REQVERFIY, bValue ? 1 : 0);
    }

    public final boolean isPRESERVICEMODENull() {
        return this.IsParamNull(TAG_PRESERVICEMODE);
    }

    public final String getPRESERVICEMODE() {
        return this.GetParamStringValue(TAG_PRESERVICEMODE, "");
    }

    public final void setPRESERVICEMODE(String strValue) {
        this.SetParamValue(TAG_PRESERVICEMODE, strValue);
    }

    public DEDCConfig getDEDCConfig() {
        if (this.dedcConfig == null) {
            this.dedcConfig = new DEDCConfig();
            if (!StringHelper.IsNullOrEmpty((String)this.getACTIONMODEL())) {
                this.dedcConfig.LoadFromXML(this.getACTIONMODEL());
            }
        }
        return this.dedcConfig;
    }
}

