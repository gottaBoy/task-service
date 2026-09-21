/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMap
extends BaseDataEntity {
    public static final String MAPTARGET_SYSCUR = "SYSCUR";
    public static final String MAPTARGET_SYSREF = "SYSREF";
    public static final String MAPMODE_DEFAULT = "DEFAULT";
    public static final String TAG_PSDEMAPID = "PSDEMAPID";
    public static final String TAG_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_MAPTARGET = "MAPTARGET";
    public static final String TAG_PSSYSREFID = "PSSYSREFID";
    public static final String TAG_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String TAG_DSTPSSYSREFDEID = "DSTPSSYSREFDEID";
    public static final String TAG_DSTPSSYSREFDENAME = "DSTPSSYSREFDENAME";
    public static final String TAG_DSTPSDEID = "DSTPSDEID";
    public static final String TAG_DSTPSDENAME = "DSTPSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_AUTODEFIELDMAP = "AUTODEFIELDMAP";
    public static final String TAG_AUTODEACTIONMAP = "AUTODEACTIONMAP";
    public static final String TAG_AUTODEDQMAP = "AUTODEDQMAP";
    public static final String TAG_AUTODEDSMAP = "AUTODEDSMAP";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_MAPMODE = "MAPMODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_LOGICHOLDER = "LOGICHOLDER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";

    public final boolean isPSDEMAPIDNull() {
        return this.IsParamNull(TAG_PSDEMAPID);
    }

    public final String getPSDEMAPID() {
        return this.GetParamStringValue(TAG_PSDEMAPID, "");
    }

    public final void setPSDEMAPID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPID, strValue);
    }

    public final boolean isPSDEMAPNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPNAME);
    }

    public final String getPSDEMAPNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPNAME, "");
    }

    public final void setPSDEMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isMAPTARGETNull() {
        return this.IsParamNull(TAG_MAPTARGET);
    }

    public final String getMAPTARGET() {
        return this.GetParamStringValue(TAG_MAPTARGET, "");
    }

    public final void setMAPTARGET(String strValue) {
        this.SetParamValue(TAG_MAPTARGET, strValue);
    }

    public final boolean isPSSYSREFIDNull() {
        return this.IsParamNull(TAG_PSSYSREFID);
    }

    public final String getPSSYSREFID() {
        return this.GetParamStringValue(TAG_PSSYSREFID, "");
    }

    public final void setPSSYSREFID(String strValue) {
        this.SetParamValue(TAG_PSSYSREFID, strValue);
    }

    public final boolean isPSSYSREFNAMENull() {
        return this.IsParamNull(TAG_PSSYSREFNAME);
    }

    public final String getPSSYSREFNAME() {
        return this.GetParamStringValue(TAG_PSSYSREFNAME, "");
    }

    public final void setPSSYSREFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREFNAME, strValue);
    }

    public final boolean isDSTPSSYSREFDEIDNull() {
        return this.IsParamNull(TAG_DSTPSSYSREFDEID);
    }

    public final String getDSTPSSYSREFDEID() {
        return this.GetParamStringValue(TAG_DSTPSSYSREFDEID, "");
    }

    public final void setDSTPSSYSREFDEID(String strValue) {
        this.SetParamValue(TAG_DSTPSSYSREFDEID, strValue);
    }

    public final boolean isDSTPSSYSREFDENAMENull() {
        return this.IsParamNull(TAG_DSTPSSYSREFDENAME);
    }

    public final String getDSTPSSYSREFDENAME() {
        return this.GetParamStringValue(TAG_DSTPSSYSREFDENAME, "");
    }

    public final void setDSTPSSYSREFDENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSSYSREFDENAME, strValue);
    }

    public final boolean isDSTPSDEIDNull() {
        return this.IsParamNull(TAG_DSTPSDEID);
    }

    public final String getDSTPSDEID() {
        return this.GetParamStringValue(TAG_DSTPSDEID, "");
    }

    public final void setDSTPSDEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEID, strValue);
    }

    public final boolean isDSTPSDENAMENull() {
        return this.IsParamNull(TAG_DSTPSDENAME);
    }

    public final String getDSTPSDENAME() {
        return this.GetParamStringValue(TAG_DSTPSDENAME, "");
    }

    public final void setDSTPSDENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDENAME, strValue);
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

    public final boolean isAUTODEFIELDMAPNull() {
        return this.IsParamNull(TAG_AUTODEFIELDMAP);
    }

    public final boolean getAUTODEFIELDMAP() {
        return this.GetParamIntValue(TAG_AUTODEFIELDMAP, 0) == 1;
    }

    public final void setAUTODEFIELDMAP(boolean bValue) {
        this.SetParamValue(TAG_AUTODEFIELDMAP, bValue ? 1 : 0);
    }

    public final boolean isAUTODEACTIONMAPNull() {
        return this.IsParamNull(TAG_AUTODEACTIONMAP);
    }

    public final boolean getAUTODEACTIONMAP() {
        return this.GetParamIntValue(TAG_AUTODEACTIONMAP, 0) == 1;
    }

    public final void setAUTODEACTIONMAP(boolean bValue) {
        this.SetParamValue(TAG_AUTODEACTIONMAP, bValue ? 1 : 0);
    }

    public final boolean isAUTODEDQMAPNull() {
        return this.IsParamNull(TAG_AUTODEDQMAP);
    }

    public final boolean getAUTODEDQMAP() {
        return this.GetParamIntValue(TAG_AUTODEDQMAP, 0) == 1;
    }

    public final void setAUTODEDQMAP(boolean bValue) {
        this.SetParamValue(TAG_AUTODEDQMAP, bValue ? 1 : 0);
    }

    public final boolean isAUTODEDSMAPNull() {
        return this.IsParamNull(TAG_AUTODEDSMAP);
    }

    public final boolean getAUTODEDSMAP() {
        return this.GetParamIntValue(TAG_AUTODEDSMAP, 0) == 1;
    }

    public final void setAUTODEDSMAP(boolean bValue) {
        this.SetParamValue(TAG_AUTODEDSMAP, bValue ? 1 : 0);
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

    public final boolean isMAPMODENull() {
        return this.IsParamNull(TAG_MAPMODE);
    }

    public final String getMAPMODE() {
        return this.GetParamStringValue(TAG_MAPMODE, "");
    }

    public final void setMAPMODE(String strValue) {
        this.SetParamValue(TAG_MAPMODE, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPROPERTYMAPNull() {
        return this.IsParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.GetParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.SetParamValue(TAG_PROPERTYMAP, strValue);
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

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
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

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isLOGICHOLDERNull() {
        return this.IsParamNull(TAG_LOGICHOLDER);
    }

    public final int getLOGICHOLDER() {
        return this.GetParamIntValue(TAG_LOGICHOLDER, 0);
    }

    public final void setLOGICHOLDER(int nValue) {
        this.SetParamValue(TAG_LOGICHOLDER, nValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }
}

