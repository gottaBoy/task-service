/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBOPDTMap
extends BaseDataEntity {
    public static final String TAG_EAIDBOPDTMAPID = "EAIDBOPDTMAPID";
    public static final String TAG_EAIDBOPDTMAPNAME = "EAIDBOPDTMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIDBOPSETTINGID = "EAIDBOPSETTINGID";
    public static final String TAG_EAIDBOPSETTINGNAME = "EAIDBOPSETTINGNAME";
    public static final String TAG_DBDATATYPE = "DBDATATYPE";
    public static final String TAG_PARAMCNT = "PARAMCNT";
    public static final String TAG_LENGTHDV = "LENGTHDV";
    public static final String TAG_PRECISIONDV = "PRECISIONDV";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isEAIDBOPDTMAPIDNull() {
        return this.IsParamNull(TAG_EAIDBOPDTMAPID);
    }

    public String getEAIDBOPDTMAPID() {
        return this.GetParamStringValue(TAG_EAIDBOPDTMAPID, "");
    }

    public void setEAIDBOPDTMAPID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPDTMAPID, strValue);
    }

    public boolean isEAIDBOPDTMAPNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPDTMAPNAME);
    }

    public String getEAIDBOPDTMAPNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPDTMAPNAME, "");
    }

    public void setEAIDBOPDTMAPNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPDTMAPNAME, strValue);
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

    public boolean isEAIDBOPSETTINGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGID);
    }

    public String getEAIDBOPSETTINGID() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGID, "");
    }

    public void setEAIDBOPSETTINGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGID, strValue);
    }

    public boolean isEAIDBOPSETTINGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGNAME);
    }

    public String getEAIDBOPSETTINGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGNAME, "");
    }

    public void setEAIDBOPSETTINGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGNAME, strValue);
    }

    public boolean isDBDATATYPENull() {
        return this.IsParamNull(TAG_DBDATATYPE);
    }

    public String getDBDATATYPE() {
        return this.GetParamStringValue(TAG_DBDATATYPE, "");
    }

    public void setDBDATATYPE(String strValue) {
        this.SetParamValue(TAG_DBDATATYPE, strValue);
    }

    public boolean isPARAMCNTNull() {
        return this.IsParamNull(TAG_PARAMCNT);
    }

    public int getPARAMCNT() {
        return this.GetParamIntValue(TAG_PARAMCNT, 0);
    }

    public void setPARAMCNT(int strValue) {
        this.SetParamValue(TAG_PARAMCNT, strValue);
    }

    public boolean isLENGTHDVNull() {
        return this.IsParamNull(TAG_LENGTHDV);
    }

    public int getLENGTHDV() {
        return this.GetParamIntValue(TAG_LENGTHDV, 0);
    }

    public void setLENGTHDV(int strValue) {
        this.SetParamValue(TAG_LENGTHDV, strValue);
    }

    public boolean isPRECISIONDVNull() {
        return this.IsParamNull(TAG_PRECISIONDV);
    }

    public int getPRECISIONDV() {
        return this.GetParamIntValue(TAG_PRECISIONDV, 0);
    }

    public void setPRECISIONDV(int strValue) {
        this.SetParamValue(TAG_PRECISIONDV, strValue);
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

