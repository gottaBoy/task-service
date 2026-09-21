/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDataQuery
extends BaseDataEntity {
    public static final String TAG_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String TAG_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_DQSN = "DQSN";
    public static final String TAG_DQJOINMODEL = "DQJOINMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_PRIVMODE = "PRIVMODE";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_VIEWCOLLEVEL = "VIEWCOLLEVEL";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_REQUESTPATH = "REQUESTPATH";
    public static final String TAG_REQUESTMETHOD = "REQUESTMETHOD";
    public static final String TAG_QUERYVIEWFLAG = "QUERYVIEWFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEFGROUPID = "PSDEFGROUPID";
    public static final String TAG_PSDEFGROUPNAME = "PSDEFGROUPNAME";
    public static final String TAG_PSDEDATAFLOWNAME = "PSDEDATAFLOWNAME";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_SUBSYSSADETAILMODE = "SUBSYSSADETAILMODE";
    public static final String TAG_ENABLEPQL = "ENABLEPQL";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

    public final boolean isPSDEDATAQUERYIDNull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYID);
    }

    public final String getPSDEDATAQUERYID() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYID, "");
    }

    public final void setPSDEDATAQUERYID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYID, strValue);
    }

    public final boolean isPSDEDATAQUERYNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAQUERYNAME);
    }

    public final String getPSDEDATAQUERYNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAQUERYNAME, "");
    }

    public final void setPSDEDATAQUERYNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAQUERYNAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isDQSNNull() {
        return this.IsParamNull(TAG_DQSN);
    }

    public final String getDQSN() {
        return this.GetParamStringValue(TAG_DQSN, "");
    }

    public final void setDQSN(String strValue) {
        this.SetParamValue(TAG_DQSN, strValue);
    }

    public final boolean isDQJOINMODELNull() {
        return this.IsParamNull(TAG_DQJOINMODEL);
    }

    public final String getDQJOINMODEL() {
        return this.GetParamStringValue(TAG_DQJOINMODEL, "");
    }

    public final void setDQJOINMODEL(String strValue) {
        this.SetParamValue(TAG_DQJOINMODEL, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isPRIVMODENull() {
        return this.IsParamNull(TAG_PRIVMODE);
    }

    public final boolean getPRIVMODE() {
        return this.GetParamIntValue(TAG_PRIVMODE, 0) == 1;
    }

    public final void setPRIVMODE(boolean bValue) {
        this.SetParamValue(TAG_PRIVMODE, bValue ? 1 : 0);
    }

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.GetParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isVIEWCOLLEVELNull() {
        return this.IsParamNull(TAG_VIEWCOLLEVEL);
    }

    public final int getVIEWCOLLEVEL() {
        return this.GetParamIntValue(TAG_VIEWCOLLEVEL, 0);
    }

    public final void setVIEWCOLLEVEL(int nValue) {
        this.SetParamValue(TAG_VIEWCOLLEVEL, nValue);
    }

    public final boolean isPUBMODENull() {
        return this.IsParamNull(TAG_PUBMODE);
    }

    public final boolean getPUBMODE() {
        return this.GetParamIntValue(TAG_PUBMODE, 0) == 1;
    }

    public final void setPUBMODE(boolean bValue) {
        this.SetParamValue(TAG_PUBMODE, bValue ? 1 : 0);
    }

    public final boolean isREQUESTPATHNull() {
        return this.IsParamNull(TAG_REQUESTPATH);
    }

    public final String getREQUESTPATH() {
        return this.GetParamStringValue(TAG_REQUESTPATH, "");
    }

    public final void setREQUESTPATH(String strValue) {
        this.SetParamValue(TAG_REQUESTPATH, strValue);
    }

    public final boolean isREQUESTMETHODNull() {
        return this.IsParamNull(TAG_REQUESTMETHOD);
    }

    public final String getREQUESTMETHOD() {
        return this.GetParamStringValue(TAG_REQUESTMETHOD, "");
    }

    public final void setREQUESTMETHOD(String strValue) {
        this.SetParamValue(TAG_REQUESTMETHOD, strValue);
    }

    public final boolean isQUERYVIEWFLAGNull() {
        return this.IsParamNull(TAG_QUERYVIEWFLAG);
    }

    public final boolean getQUERYVIEWFLAG() {
        return this.GetParamIntValue(TAG_QUERYVIEWFLAG, 0) == 1;
    }

    public final void setQUERYVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_QUERYVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEFGROUPID);
    }

    public final String getPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_PSDEFGROUPID, "");
    }

    public final void setPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPID, strValue);
    }

    public final boolean isPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEFGROUPNAME);
    }

    public final String getPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEFGROUPNAME, "");
    }

    public final void setPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGROUPNAME, strValue);
    }

    public final boolean isSUBSYSSADETAILMODENull() {
        return this.IsParamNull(TAG_SUBSYSSADETAILMODE);
    }

    public final int getSUBSYSSADETAILMODE() {
        return this.GetParamIntValue(TAG_SUBSYSSADETAILMODE, 0);
    }

    public final void setSUBSYSSADETAILMODE(int bValue) {
        this.SetParamValue(TAG_SUBSYSSADETAILMODE, bValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isENABLEPQLNull() {
        return this.IsParamNull(TAG_ENABLEPQL);
    }

    public final boolean getENABLEPQL() {
        return this.GetParamIntValue(TAG_ENABLEPQL, 0) == 1;
    }

    public final void setENABLEPQL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPQL, bValue ? 1 : 0);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }
}

