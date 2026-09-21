/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEACMode
extends BaseDataEntity {
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_FILLEROBJ = "FILLEROBJ";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_PAGINGSIZE = "PAGINGSIZE";
    public static final String TAG_ENABLEPAGINGBAR = "ENABLEPAGINGBAR";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_ACIPSSYSPFPLUGINID = "ACIPSSYSPFPLUGINID";
    public static final String TAG_ACIPSSYSPFPLUGINNAME = "ACIPSSYSPFPLUGINNAME";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";

    public final boolean isPSDEACMODEIDNull() {
        return this.isParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.getParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.setParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.isParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.getParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.setParamValue(TAG_PSDEACMODENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.isParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.getParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
    }

    public final boolean isFILLEROBJNull() {
        return this.isParamNull(TAG_FILLEROBJ);
    }

    public final String getFILLEROBJ() {
        return this.getParamStringValue(TAG_FILLEROBJ, "");
    }

    public final void setFILLEROBJ(String strValue) {
        this.setParamValue(TAG_FILLEROBJ, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.isParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.getParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.setParamValue(TAG_MINORSORTDIR, strValue);
    }

    public final boolean isPAGINGSIZENull() {
        return this.isParamNull(TAG_PAGINGSIZE);
    }

    public final int getPAGINGSIZE() {
        return this.getParamIntValue(TAG_PAGINGSIZE, 0);
    }

    public final void setPAGINGSIZE(int nValue) {
        this.setParamValue(TAG_PAGINGSIZE, nValue);
    }

    public final boolean isENABLEPAGINGBARNull() {
        return this.isParamNull(TAG_ENABLEPAGINGBAR);
    }

    public final boolean getENABLEPAGINGBAR() {
        return this.getParamIntValue(TAG_ENABLEPAGINGBAR, 0) == 1;
    }

    public final void setENABLEPAGINGBAR(boolean bValue) {
        this.setParamValue(TAG_ENABLEPAGINGBAR, bValue ? 1 : 0);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.isParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.isParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.isParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.getParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.setParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.isParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.getParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.setParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.isParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.getParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.setParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.isParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.getParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isACIPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_ACIPSSYSPFPLUGINID);
    }

    public final String getACIPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_ACIPSSYSPFPLUGINID, "");
    }

    public final void setACIPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_ACIPSSYSPFPLUGINID, strValue);
    }

    public final boolean isACIPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_ACIPSSYSPFPLUGINNAME);
    }

    public final String getACIPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_ACIPSSYSPFPLUGINNAME, "");
    }

    public final void setACIPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_ACIPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.isParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.getParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.setParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }
}

