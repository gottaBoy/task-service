/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSDEDataQueryJoin
extends BaseDataEntity {
    public static final String TAG_PSDEDQJOINID = "PSDEDQJOINID";
    public static final String TAG_PSDEDQJOINNAME = "PSDEDQJOINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_PPSDEDQJOINID = "PPSDEDQJOINID";
    public static final String TAG_PPSDEDQJOINNAME = "PPSDEDQJOINNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSDEJOINTYPEID = "PSDEJOINTYPEID";
    public static final String TAG_PSDEJOINTYPENAME = "PSDEJOINTYPENAME";
    public static final String TAG_JOINPSDEID = "JOINPSDEID";
    public static final String TAG_JOINPSDENAME = "JOINPSDENAME";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_CONDFLAG = "CONDFLAG";
    public static final String TAG_CONDMODEL = "CONDMODEL";
    public static final String TAG_ALIASNAME = "ALIASNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PJOINPSDEID = "PJOINPSDEID";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_MAINFLAG = "MAINFLAG";
    public static final String TAG_EXTCOLUMNS = "EXTCOLUMNS";
    public static final String TAG_QUERYVIEWFLAG = "QUERYVIEWFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_JOINTAG = "JOINTAG";
    public static final String TAG_JOINTAG2 = "JOINTAG2";
    public static final String TAG_USERCAT = "USERCAT";
    private ArrayList<PSDEDataQueryJoin> childPSDEDataQueryJoinList = null;
    private ArrayList<PSDEDataQueryCond> PSDEDataQueryCondList = null;

    public final boolean isPSDEDQJOINIDNull() {
        return this.IsParamNull(TAG_PSDEDQJOINID);
    }

    public final String getPSDEDQJOINID() {
        return this.GetParamStringValue(TAG_PSDEDQJOINID, "");
    }

    public final void setPSDEDQJOINID(String strValue) {
        this.SetParamValue(TAG_PSDEDQJOINID, strValue);
    }

    public final boolean isPSDEDQJOINNAMENull() {
        return this.IsParamNull(TAG_PSDEDQJOINNAME);
    }

    public final String getPSDEDQJOINNAME() {
        return this.GetParamStringValue(TAG_PSDEDQJOINNAME, "");
    }

    public final void setPSDEDQJOINNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQJOINNAME, strValue);
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

    public final boolean isPSDEDQIDNull() {
        return this.IsParamNull(TAG_PSDEDQID);
    }

    public final String getPSDEDQID() {
        return this.GetParamStringValue(TAG_PSDEDQID, "");
    }

    public final void setPSDEDQID(String strValue) {
        this.SetParamValue(TAG_PSDEDQID, strValue);
    }

    public final boolean isPSDEDQNAMENull() {
        return this.IsParamNull(TAG_PSDEDQNAME);
    }

    public final String getPSDEDQNAME() {
        return this.GetParamStringValue(TAG_PSDEDQNAME, "");
    }

    public final void setPSDEDQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDQNAME, strValue);
    }

    public final boolean isPPSDEDQJOINIDNull() {
        return this.IsParamNull(TAG_PPSDEDQJOINID);
    }

    public final String getPPSDEDQJOINID() {
        return this.GetParamStringValue(TAG_PPSDEDQJOINID, "");
    }

    public final void setPPSDEDQJOINID(String strValue) {
        this.SetParamValue(TAG_PPSDEDQJOINID, strValue);
    }

    public final boolean isPPSDEDQJOINNAMENull() {
        return this.IsParamNull(TAG_PPSDEDQJOINNAME);
    }

    public final String getPPSDEDQJOINNAME() {
        return this.GetParamStringValue(TAG_PPSDEDQJOINNAME, "");
    }

    public final void setPPSDEDQJOINNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEDQJOINNAME, strValue);
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

    public final boolean isPSDEJOINTYPEIDNull() {
        return this.IsParamNull(TAG_PSDEJOINTYPEID);
    }

    public final String getPSDEJOINTYPEID() {
        return this.GetParamStringValue(TAG_PSDEJOINTYPEID, "");
    }

    public final void setPSDEJOINTYPEID(String strValue) {
        this.SetParamValue(TAG_PSDEJOINTYPEID, strValue);
    }

    public final boolean isPSDEJOINTYPENAMENull() {
        return this.IsParamNull(TAG_PSDEJOINTYPENAME);
    }

    public final String getPSDEJOINTYPENAME() {
        return this.GetParamStringValue(TAG_PSDEJOINTYPENAME, "");
    }

    public final void setPSDEJOINTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDEJOINTYPENAME, strValue);
    }

    public final boolean isJOINPSDEIDNull() {
        return this.IsParamNull(TAG_JOINPSDEID);
    }

    public final String getJOINPSDEID() {
        return this.GetParamStringValue(TAG_JOINPSDEID, "");
    }

    public final void setJOINPSDEID(String strValue) {
        this.SetParamValue(TAG_JOINPSDEID, strValue);
    }

    public final boolean isJOINPSDENAMENull() {
        return this.IsParamNull(TAG_JOINPSDENAME);
    }

    public final String getJOINPSDENAME() {
        return this.GetParamStringValue(TAG_JOINPSDENAME, "");
    }

    public final void setJOINPSDENAME(String strValue) {
        this.SetParamValue(TAG_JOINPSDENAME, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
    }

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isCONDFLAGNull() {
        return this.IsParamNull(TAG_CONDFLAG);
    }

    public final boolean getCONDFLAG() {
        return this.GetParamIntValue(TAG_CONDFLAG, 0) == 1;
    }

    public final void setCONDFLAG(boolean bValue) {
        this.SetParamValue(TAG_CONDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCONDMODELNull() {
        return this.IsParamNull(TAG_CONDMODEL);
    }

    public final String getCONDMODEL() {
        return this.GetParamStringValue(TAG_CONDMODEL, "");
    }

    public final void setCONDMODEL(String strValue) {
        this.SetParamValue(TAG_CONDMODEL, strValue);
    }

    public final boolean isALIASNAMENull() {
        return this.IsParamNull(TAG_ALIASNAME);
    }

    public final String getALIASNAME() {
        return this.GetParamStringValue(TAG_ALIASNAME, "");
    }

    public final void setALIASNAME(String strValue) {
        this.SetParamValue(TAG_ALIASNAME, strValue);
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

    public final boolean isPJOINPSDEIDNull() {
        return this.IsParamNull(TAG_PJOINPSDEID);
    }

    public final String getPJOINPSDEID() {
        return this.GetParamStringValue(TAG_PJOINPSDEID, "");
    }

    public final void setPJOINPSDEID(String strValue) {
        this.SetParamValue(TAG_PJOINPSDEID, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isMAINFLAGNull() {
        return this.IsParamNull(TAG_MAINFLAG);
    }

    public final boolean getMAINFLAG() {
        return this.GetParamIntValue(TAG_MAINFLAG, 0) == 1;
    }

    public final void setMAINFLAG(boolean bValue) {
        this.SetParamValue(TAG_MAINFLAG, bValue ? 1 : 0);
    }

    public final boolean isEXTCOLUMNSNull() {
        return this.IsParamNull(TAG_EXTCOLUMNS);
    }

    public final String getEXTCOLUMNS() {
        return this.GetParamStringValue(TAG_EXTCOLUMNS, "");
    }

    public final void setEXTCOLUMNS(String strValue) {
        this.SetParamValue(TAG_EXTCOLUMNS, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isJOINTAGNull() {
        return this.IsParamNull(TAG_JOINTAG);
    }

    public final String getJOINTAG() {
        return this.GetParamStringValue(TAG_JOINTAG, "");
    }

    public final void setJOINTAG(String strValue) {
        this.SetParamValue(TAG_JOINTAG, strValue);
    }

    public final boolean isJOINTAG2Null() {
        return this.IsParamNull(TAG_JOINTAG2);
    }

    public final String getJOINTAG2() {
        return this.GetParamStringValue(TAG_JOINTAG2, "");
    }

    public final void setJOINTAG2(String strValue) {
        this.SetParamValue(TAG_JOINTAG2, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public ArrayList<PSDEDataQueryJoin> getChildPSDEDataQueryJoins(boolean bCreated) {
        if (this.childPSDEDataQueryJoinList != null) {
            return this.childPSDEDataQueryJoinList;
        }
        if (bCreated) {
            this.childPSDEDataQueryJoinList = new ArrayList();
        }
        return this.childPSDEDataQueryJoinList;
    }

    public ArrayList<PSDEDataQueryCond> getPSDEDataQueryConds(boolean bCreated) {
        if (this.PSDEDataQueryCondList != null) {
            return this.PSDEDataQueryCondList;
        }
        if (bCreated) {
            this.PSDEDataQueryCondList = new ArrayList();
        }
        return this.PSDEDataQueryCondList;
    }

    public void resetChildDatas() {
        if (this.childPSDEDataQueryJoinList != null) {
            this.childPSDEDataQueryJoinList.clear();
            this.childPSDEDataQueryJoinList = null;
        }
        if (this.PSDEDataQueryCondList != null) {
            this.PSDEDataQueryCondList.clear();
            this.PSDEDataQueryCondList = null;
        }
    }
}

