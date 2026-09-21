/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSWFLinkCond
extends BaseDataEntity {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";
    public static final String GROUPOP_AND = "AND";
    public static final String GROUPOP_OR = "OR";
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";
    public static final String PARAMTYPE_TIMERULE = "TIMERULE";
    public static final String TAG_PSWFLINKCONDID = "PSWFLINKCONDID";
    public static final String TAG_PSWFLINKCONDNAME = "PSWFLINKCONDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFLINKID = "PSWFLINKID";
    public static final String TAG_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String TAG_PPSWFLINKCONDID = "PPSWFLINKCONDID";
    public static final String TAG_PPSWFLINKCONDNAME = "PPSWFLINKCONDNAME";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_LOGICTYPE = "LOGICTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String TAG_CONDVALUE = "CONDVALUE";
    public static final String TAG_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String TAG_GROUPOP = "GROUPOP";
    public static final String TAG_DSTPSDEFID = "DSTPSDEFID";
    public static final String TAG_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    private ArrayList<PSWFLinkCond> childPSWFLinkCondList = null;

    public final boolean isPSWFLINKCONDIDNull() {
        return this.IsParamNull(TAG_PSWFLINKCONDID);
    }

    public final String getPSWFLINKCONDID() {
        return this.GetParamStringValue(TAG_PSWFLINKCONDID, "");
    }

    public final void setPSWFLINKCONDID(String strValue) {
        this.SetParamValue(TAG_PSWFLINKCONDID, strValue);
    }

    public final boolean isPSWFLINKCONDNAMENull() {
        return this.IsParamNull(TAG_PSWFLINKCONDNAME);
    }

    public final String getPSWFLINKCONDNAME() {
        return this.GetParamStringValue(TAG_PSWFLINKCONDNAME, "");
    }

    public final void setPSWFLINKCONDNAME(String strValue) {
        this.SetParamValue(TAG_PSWFLINKCONDNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFLINKIDNull() {
        return this.IsParamNull(TAG_PSWFLINKID);
    }

    public final String getPSWFLINKID() {
        return this.GetParamStringValue(TAG_PSWFLINKID, "");
    }

    public final void setPSWFLINKID(String strValue) {
        this.SetParamValue(TAG_PSWFLINKID, strValue);
    }

    public final boolean isPSWFLINKNAMENull() {
        return this.IsParamNull(TAG_PSWFLINKNAME);
    }

    public final String getPSWFLINKNAME() {
        return this.GetParamStringValue(TAG_PSWFLINKNAME, "");
    }

    public final void setPSWFLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSWFLINKNAME, strValue);
    }

    public final boolean isPPSWFLINKCONDIDNull() {
        return this.IsParamNull(TAG_PPSWFLINKCONDID);
    }

    public final String getPPSWFLINKCONDID() {
        return this.GetParamStringValue(TAG_PPSWFLINKCONDID, "");
    }

    public final void setPPSWFLINKCONDID(String strValue) {
        this.SetParamValue(TAG_PPSWFLINKCONDID, strValue);
    }

    public final boolean isPPSWFLINKCONDNAMENull() {
        return this.IsParamNull(TAG_PPSWFLINKCONDNAME);
    }

    public final String getPPSWFLINKCONDNAME() {
        return this.GetParamStringValue(TAG_PPSWFLINKCONDNAME, "");
    }

    public final void setPPSWFLINKCONDNAME(String strValue) {
        this.SetParamValue(TAG_PPSWFLINKCONDNAME, strValue);
    }

    public final boolean isPSDBVALUEOPIDNull() {
        return this.IsParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.IsParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPNAME, strValue);
    }

    public final boolean isLOGICTYPENull() {
        return this.IsParamNull(TAG_LOGICTYPE);
    }

    public final String getLOGICTYPE() {
        return this.GetParamStringValue(TAG_LOGICTYPE, "");
    }

    public final void setLOGICTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICTYPE, strValue);
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

    public final boolean isGROUPNOTFLAGNull() {
        return this.IsParamNull(TAG_GROUPNOTFLAG);
    }

    public final boolean getGROUPNOTFLAG() {
        return this.GetParamIntValue(TAG_GROUPNOTFLAG, 0) == 1;
    }

    public final void setGROUPNOTFLAG(boolean bValue) {
        this.SetParamValue(TAG_GROUPNOTFLAG, bValue ? 1 : 0);
    }

    public final boolean isCONDVALUENull() {
        return this.IsParamNull(TAG_CONDVALUE);
    }

    public final String getCONDVALUE() {
        return this.GetParamStringValue(TAG_CONDVALUE, "");
    }

    public final void setCONDVALUE(String strValue) {
        this.SetParamValue(TAG_CONDVALUE, strValue);
    }

    public final boolean isCUSTOMDSTPARAMNull() {
        return this.IsParamNull(TAG_CUSTOMDSTPARAM);
    }

    public final String getCUSTOMDSTPARAM() {
        return this.GetParamStringValue(TAG_CUSTOMDSTPARAM, "");
    }

    public final void setCUSTOMDSTPARAM(String strValue) {
        this.SetParamValue(TAG_CUSTOMDSTPARAM, strValue);
    }

    public final boolean isGROUPOPNull() {
        return this.IsParamNull(TAG_GROUPOP);
    }

    public final String getGROUPOP() {
        return this.GetParamStringValue(TAG_GROUPOP, "");
    }

    public final void setGROUPOP(String strValue) {
        this.SetParamValue(TAG_GROUPOP, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.GetParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEFNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFNAME);
    }

    public final String getDSTPSDEFNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFNAME, "");
    }

    public final void setDSTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFNAME, strValue);
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

    public final boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public final String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public final void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public ArrayList<PSWFLinkCond> getChildPSWFLinkConds(boolean bCreated) {
        if (this.childPSWFLinkCondList != null) {
            return this.childPSWFLinkCondList;
        }
        if (bCreated) {
            this.childPSWFLinkCondList = new ArrayList();
        }
        return this.childPSWFLinkCondList;
    }

    public void resetChildDatas() {
        if (this.childPSWFLinkCondList != null) {
            this.childPSWFLinkCondList.clear();
            this.childPSWFLinkCondList = null;
        }
    }
}

