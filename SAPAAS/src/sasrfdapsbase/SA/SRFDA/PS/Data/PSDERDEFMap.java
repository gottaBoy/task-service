/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDERDEFMap
extends BaseDataEntity {
    public static final String MAPTYPE_DIGEST = "DIGEST";
    public static final String MAPTYPE_SUM = "SUM";
    public static final String MAPTYPE_AVG = "AVG";
    public static final String MAPTYPE_MAX = "MAX";
    public static final String MAPTYPE_MIN = "MIN";
    public static final String MAPTYPE_COUNT = "COUNT";
    public static final String TAG_PSDERDEFMAPID = "PSDERDEFMAPID";
    public static final String TAG_PSDERDEFMAPNAME = "PSDERDEFMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MAJORPSDEID = "MAJORPSDEID";
    public static final String TAG_MINORPSDEID = "MINORPSDEID";
    public static final String TAG_MAPTYPE = "MAPTYPE";
    public static final String TAG_MAJORPSDEFID = "MAJORPSDEFID";
    public static final String TAG_MINORPSDEFID = "MINORPSDEFID";
    public static final String TAG_MINORPSDEFNAME = "MINORPSDEFNAME";
    public static final String TAG_MAJORPSDEFNAME = "MAJORPSDEFNAME";
    public static final String TAG_PSDEDQID = "PSDEDQID";
    public static final String TAG_PSDEDQNAME = "PSDEDQNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_FORMULAFORMAT = "FORMULAFORMAT";
    public static final String TAG_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String TAG_SRCVALUE = "SRCVALUE";
    public static final String TAG_SRCVALUESTDDATATYPE = "SRCVALUESTDDATATYPE";

    public final boolean isPSDERDEFMAPIDNull() {
        return this.IsParamNull(TAG_PSDERDEFMAPID);
    }

    public final String getPSDERDEFMAPID() {
        return this.GetParamStringValue(TAG_PSDERDEFMAPID, "");
    }

    public final void setPSDERDEFMAPID(String strValue) {
        this.SetParamValue(TAG_PSDERDEFMAPID, strValue);
    }

    public final boolean isPSDERDEFMAPNAMENull() {
        return this.IsParamNull(TAG_PSDERDEFMAPNAME);
    }

    public final String getPSDERDEFMAPNAME() {
        return this.GetParamStringValue(TAG_PSDERDEFMAPNAME, "");
    }

    public final void setPSDERDEFMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSDERDEFMAPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMAJORPSDEIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEID);
    }

    public final String getMAJORPSDEID() {
        return this.GetParamStringValue(TAG_MAJORPSDEID, "");
    }

    public final void setMAJORPSDEID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEID, strValue);
    }

    public final boolean isMINORPSDEIDNull() {
        return this.IsParamNull(TAG_MINORPSDEID);
    }

    public final String getMINORPSDEID() {
        return this.GetParamStringValue(TAG_MINORPSDEID, "");
    }

    public final void setMINORPSDEID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEID, strValue);
    }

    public final boolean isMAPTYPENull() {
        return this.IsParamNull(TAG_MAPTYPE);
    }

    public final String getMAPTYPE() {
        return this.GetParamStringValue(TAG_MAPTYPE, "");
    }

    public final void setMAPTYPE(String strValue) {
        this.SetParamValue(TAG_MAPTYPE, strValue);
    }

    public final boolean isMAJORPSDEFIDNull() {
        return this.IsParamNull(TAG_MAJORPSDEFID);
    }

    public final String getMAJORPSDEFID() {
        return this.GetParamStringValue(TAG_MAJORPSDEFID, "");
    }

    public final void setMAJORPSDEFID(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFID, strValue);
    }

    public final boolean isMINORPSDEFIDNull() {
        return this.IsParamNull(TAG_MINORPSDEFID);
    }

    public final String getMINORPSDEFID() {
        return this.GetParamStringValue(TAG_MINORPSDEFID, "");
    }

    public final void setMINORPSDEFID(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFID, strValue);
    }

    public final boolean isMINORPSDEFNAMENull() {
        return this.IsParamNull(TAG_MINORPSDEFNAME);
    }

    public final String getMINORPSDEFNAME() {
        return this.GetParamStringValue(TAG_MINORPSDEFNAME, "");
    }

    public final void setMINORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MINORPSDEFNAME, strValue);
    }

    public final boolean isMAJORPSDEFNAMENull() {
        return this.IsParamNull(TAG_MAJORPSDEFNAME);
    }

    public final String getMAJORPSDEFNAME() {
        return this.GetParamStringValue(TAG_MAJORPSDEFNAME, "");
    }

    public final void setMAJORPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MAJORPSDEFNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isFORMULAFORMATNull() {
        return this.IsParamNull(TAG_FORMULAFORMAT);
    }

    public final String getFORMULAFORMAT() {
        return this.GetParamStringValue(TAG_FORMULAFORMAT, "");
    }

    public final void setFORMULAFORMAT(String strValue) {
        this.SetParamValue(TAG_FORMULAFORMAT, strValue);
    }

    public final boolean isSRCVALUETYPENull() {
        return this.IsParamNull(TAG_SRCVALUETYPE);
    }

    public final String getSRCVALUETYPE() {
        return this.GetParamStringValue(TAG_SRCVALUETYPE, "");
    }

    public final void setSRCVALUETYPE(String strValue) {
        this.SetParamValue(TAG_SRCVALUETYPE, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.IsParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.GetParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.SetParamValue(TAG_SRCVALUE, strValue);
    }

    public final boolean isSRCVALUESTDDATATYPENull() {
        return this.IsParamNull(TAG_SRCVALUESTDDATATYPE);
    }

    public final int getSRCVALUESTDDATATYPE() {
        return this.GetParamIntValue(TAG_SRCVALUESTDDATATYPE, 0);
    }

    public final void setSRCVALUESTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_SRCVALUESTDDATATYPE, nValue);
    }
}

