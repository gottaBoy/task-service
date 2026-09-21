/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysServiceAPIHandler
extends BaseDataEntity {
    public static final int DYNAMODELFLAG_0 = 0;
    public static final int DYNAMODELFLAG_1 = 1;
    public static final int DYNAMODELFLAG_2 = 2;
    public static final String SATYPE_SAASADMIN = "SAASADMIN";
    public static final String SATYPE_WFSERVICE = "WFSERVICE";
    public static final String SATYPE_WFPROXYAPP = "WFPROXYAPP";
    public static final String SATYPE_WFCALLBACK = "WFCALLBACK";
    public static final String TAG_PSSYSSAHANDLERID = "PSSYSSAHANDLERID";
    public static final String TAG_PSSYSSAHANDLERNAME = "PSSYSSAHANDLERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSFSAHANDLERID = "PSSFSAHANDLERID";
    public static final String TAG_PSSFSAHANDLERNAME = "PSSFSAHANDLERNAME";
    public static final String TAG_HANDLEROBJ = "HANDLEROBJ";
    public static final String TAG_HANDLEROBJ2 = "HANDLEROBJ2";
    public static final String TAG_HANDLERPARAMS = "HANDLERPARAMS";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_SATYPE = "SATYPE";
    public static final String TAG_CLIENTHANDLEROBJ = "CLIENTHANDLEROBJ";
    public static final String TAG_CLIENTHANDLEROBJ2 = "CLIENTHANDLEROBJ2";

    public final boolean isPSSYSSAHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSYSSAHANDLERID);
    }

    public final String getPSSYSSAHANDLERID() {
        return this.GetParamStringValue(TAG_PSSYSSAHANDLERID, "");
    }

    public final void setPSSYSSAHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSYSSAHANDLERID, strValue);
    }

    public final boolean isPSSYSSAHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSYSSAHANDLERNAME);
    }

    public final String getPSSYSSAHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSYSSAHANDLERNAME, "");
    }

    public final void setPSSYSSAHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSAHANDLERNAME, strValue);
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

    public final boolean isPSSFSAHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSFSAHANDLERID);
    }

    public final String getPSSFSAHANDLERID() {
        return this.GetParamStringValue(TAG_PSSFSAHANDLERID, "");
    }

    public final void setPSSFSAHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSFSAHANDLERID, strValue);
    }

    public final boolean isPSSFSAHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSFSAHANDLERNAME);
    }

    public final String getPSSFSAHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSFSAHANDLERNAME, "");
    }

    public final void setPSSFSAHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSAHANDLERNAME, strValue);
    }

    public final boolean isHANDLEROBJNull() {
        return this.IsParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.GetParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ, strValue);
    }

    public final boolean isHANDLEROBJ2Null() {
        return this.IsParamNull(TAG_HANDLEROBJ2);
    }

    public final String getHANDLEROBJ2() {
        return this.GetParamStringValue(TAG_HANDLEROBJ2, "");
    }

    public final void setHANDLEROBJ2(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ2, strValue);
    }

    public final boolean isHANDLERPARAMSNull() {
        return this.IsParamNull(TAG_HANDLERPARAMS);
    }

    public final String getHANDLERPARAMS() {
        return this.GetParamStringValue(TAG_HANDLERPARAMS, "");
    }

    public final void setHANDLERPARAMS(String strValue) {
        this.SetParamValue(TAG_HANDLERPARAMS, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }

    public final boolean isSATYPENull() {
        return this.IsParamNull(TAG_SATYPE);
    }

    public final String getSATYPE() {
        return this.GetParamStringValue(TAG_SATYPE, "");
    }

    public final void setSATYPE(String strValue) {
        this.SetParamValue(TAG_SATYPE, strValue);
    }

    public final boolean isCLIENTHANDLEROBJNull() {
        return this.IsParamNull(TAG_CLIENTHANDLEROBJ);
    }

    public final String getCLIENTHANDLEROBJ() {
        return this.GetParamStringValue(TAG_CLIENTHANDLEROBJ, "");
    }

    public final void setCLIENTHANDLEROBJ(String strValue) {
        this.SetParamValue(TAG_CLIENTHANDLEROBJ, strValue);
    }

    public final boolean isCLIENTHANDLEROBJ2Null() {
        return this.IsParamNull(TAG_CLIENTHANDLEROBJ2);
    }

    public final String getCLIENTHANDLEROBJ2() {
        return this.GetParamStringValue(TAG_CLIENTHANDLEROBJ2, "");
    }

    public final void setCLIENTHANDLEROBJ2(String strValue) {
        this.SetParamValue(TAG_CLIENTHANDLEROBJ2, strValue);
    }
}

