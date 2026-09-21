/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicNodeParam;

public class PSDELogicNode
extends BaseDataEntity {
    public static final String LOGICNODETYPE_BEGIN = "BEGIN";
    public static final String LOGICNODETYPE_DEACTION = "DEACTION";
    public static final String LOGICNODETYPE_PREPAREPARAM = "PREPAREPARAM";
    public static final String DSTPARAMACTION_RESET = "RESET";
    public static final String DSTPARAMACTION_COPY = "COPY";
    public static final String DSTPARAMACTION_RESETANDCOPY = "RESETANDCOPY";
    public static final String TAG_PSDELOGICNODEID = "PSDELOGICNODEID";
    public static final String TAG_PSDELOGICNODENAME = "PSDELOGICNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_LOGICNODETYPE = "LOGICNODETYPE";
    public static final String TAG_DSTPSDEID = "DSTPSDEID";
    public static final String TAG_DSTPSDENAME = "DSTPSDENAME";
    public static final String TAG_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String TAG_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String TAG_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String TAG_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DSTPARAMACTION = "DSTPARAMACTION";
    public static final String TAG_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String TAG_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    public static final String TAG_PARALLELOUTPUT = "PARALLELOUTPUT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String TAG_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String TAG_PSWFDEID = "PSWFDEID";
    public static final String TAG_PSWFDENAME = "PSWFDENAME";
    public static final String TAG_PSSYSSQLCMDID = "PSSYSSQLCMDID";
    public static final String TAG_PSSYSSQLCMDNAME = "PSSYSSQLCMDNAME";
    public static final String TAG_PSSYSDELOGICNODEID = "PSSYSDELOGICNODEID";
    public static final String TAG_PSSYSDELOGICNODENAME = "PSSYSDELOGICNODENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    private ArrayList<PSDELogicLink> childPSDELogicLinkList = null;
    private ArrayList<PSDELogicNodeParam> childPSDELogicNodeParamList = null;

    public final boolean isPSDELOGICNODEIDNull() {
        return this.isParamNull(TAG_PSDELOGICNODEID);
    }

    public final String getPSDELOGICNODEID() {
        return this.getParamStringValue(TAG_PSDELOGICNODEID, "");
    }

    public final void setPSDELOGICNODEID(String strValue) {
        this.setParamValue(TAG_PSDELOGICNODEID, strValue);
    }

    public final boolean isPSDELOGICNODENAMENull() {
        return this.isParamNull(TAG_PSDELOGICNODENAME);
    }

    public final String getPSDELOGICNODENAME() {
        return this.getParamStringValue(TAG_PSDELOGICNODENAME, "");
    }

    public final void setPSDELOGICNODENAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNODENAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.isParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.getParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isLOGICNODETYPENull() {
        return this.isParamNull(TAG_LOGICNODETYPE);
    }

    public final String getLOGICNODETYPE() {
        return this.getParamStringValue(TAG_LOGICNODETYPE, "");
    }

    public final void setLOGICNODETYPE(String strValue) {
        this.setParamValue(TAG_LOGICNODETYPE, strValue);
    }

    public final boolean isDSTPSDEIDNull() {
        return this.isParamNull(TAG_DSTPSDEID);
    }

    public final String getDSTPSDEID() {
        return this.getParamStringValue(TAG_DSTPSDEID, "");
    }

    public final void setDSTPSDEID(String strValue) {
        this.setParamValue(TAG_DSTPSDEID, strValue);
    }

    public final boolean isDSTPSDENAMENull() {
        return this.isParamNull(TAG_DSTPSDENAME);
    }

    public final String getDSTPSDENAME() {
        return this.getParamStringValue(TAG_DSTPSDENAME, "");
    }

    public final void setDSTPSDENAME(String strValue) {
        this.setParamValue(TAG_DSTPSDENAME, strValue);
    }

    public final boolean isDSTPSDEACTIONIDNull() {
        return this.isParamNull(TAG_DSTPSDEACTIONID);
    }

    public final String getDSTPSDEACTIONID() {
        return this.getParamStringValue(TAG_DSTPSDEACTIONID, "");
    }

    public final void setDSTPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_DSTPSDEACTIONID, strValue);
    }

    public final boolean isDSTPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_DSTPSDEACTIONNAME);
    }

    public final String getDSTPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_DSTPSDEACTIONNAME, "");
    }

    public final void setDSTPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDEACTIONNAME, strValue);
    }

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.isParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.isParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.getParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.setParamValue(TAG_DSTPSDLPARAMNAME, strValue);
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

    public final boolean isDSTPARAMACTIONNull() {
        return this.isParamNull(TAG_DSTPARAMACTION);
    }

    public final String getDSTPARAMACTION() {
        return this.getParamStringValue(TAG_DSTPARAMACTION, "");
    }

    public final void setDSTPARAMACTION(String strValue) {
        this.setParamValue(TAG_DSTPARAMACTION, strValue);
    }

    public final boolean isSRCPSDLPARAMIDNull() {
        return this.isParamNull(TAG_SRCPSDLPARAMID);
    }

    public final String getSRCPSDLPARAMID() {
        return this.getParamStringValue(TAG_SRCPSDLPARAMID, "");
    }

    public final void setSRCPSDLPARAMID(String strValue) {
        this.setParamValue(TAG_SRCPSDLPARAMID, strValue);
    }

    public final boolean isSRCPSDLPARAMNAMENull() {
        return this.isParamNull(TAG_SRCPSDLPARAMNAME);
    }

    public final String getSRCPSDLPARAMNAME() {
        return this.getParamStringValue(TAG_SRCPSDLPARAMNAME, "");
    }

    public final void setSRCPSDLPARAMNAME(String strValue) {
        this.setParamValue(TAG_SRCPSDLPARAMNAME, strValue);
    }

    public final boolean isPARALLELOUTPUTNull() {
        return this.isParamNull(TAG_PARALLELOUTPUT);
    }

    public final boolean getPARALLELOUTPUT() {
        return this.getParamIntValue(TAG_PARALLELOUTPUT, 0) == 1;
    }

    public final void setPARALLELOUTPUT(boolean bValue) {
        this.setParamValue(TAG_PARALLELOUTPUT, bValue ? 1 : 0);
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

    public final boolean isPSWORKFLOWIDNull() {
        return this.isParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.getParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.setParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.isParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.getParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.setParamValue(TAG_PSWORKFLOWNAME, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.isParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.getParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.setParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.isParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.getParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.setParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPSSYSSQLCMDIDNull() {
        return this.isParamNull(TAG_PSSYSSQLCMDID);
    }

    public final String getPSSYSSQLCMDID() {
        return this.getParamStringValue(TAG_PSSYSSQLCMDID, "");
    }

    public final void setPSSYSSQLCMDID(String strValue) {
        this.setParamValue(TAG_PSSYSSQLCMDID, strValue);
    }

    public final boolean isPSSYSSQLCMDNAMENull() {
        return this.isParamNull(TAG_PSSYSSQLCMDNAME);
    }

    public final String getPSSYSSQLCMDNAME() {
        return this.getParamStringValue(TAG_PSSYSSQLCMDNAME, "");
    }

    public final void setPSSYSSQLCMDNAME(String strValue) {
        this.setParamValue(TAG_PSSYSSQLCMDNAME, strValue);
    }

    public final boolean isPSSYSDELOGICNODEIDNull() {
        return this.isParamNull(TAG_PSSYSDELOGICNODEID);
    }

    public final String getPSSYSDELOGICNODEID() {
        return this.getParamStringValue(TAG_PSSYSDELOGICNODEID, "");
    }

    public final void setPSSYSDELOGICNODEID(String strValue) {
        this.setParamValue(TAG_PSSYSDELOGICNODEID, strValue);
    }

    public final boolean isPSSYSDELOGICNODENAMENull() {
        return this.isParamNull(TAG_PSSYSDELOGICNODENAME);
    }

    public final String getPSSYSDELOGICNODENAME() {
        return this.getParamStringValue(TAG_PSSYSDELOGICNODENAME, "");
    }

    public final void setPSSYSDELOGICNODENAME(String strValue) {
        this.setParamValue(TAG_PSSYSDELOGICNODENAME, strValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public ArrayList<PSDELogicLink> getPSDELogicLinks(boolean bCreated) {
        if (this.childPSDELogicLinkList != null) {
            return this.childPSDELogicLinkList;
        }
        if (bCreated) {
            this.childPSDELogicLinkList = new ArrayList();
        }
        return this.childPSDELogicLinkList;
    }

    public ArrayList<PSDELogicNodeParam> getPSDELogicNodeParams(boolean bCreated) {
        if (this.childPSDELogicNodeParamList != null) {
            return this.childPSDELogicNodeParamList;
        }
        if (bCreated) {
            this.childPSDELogicNodeParamList = new ArrayList();
        }
        return this.childPSDELogicNodeParamList;
    }

    public void resetChildDatas() {
        if (this.childPSDELogicLinkList != null) {
            this.childPSDELogicLinkList.clear();
            this.childPSDELogicLinkList = null;
        }
        if (this.childPSDELogicNodeParamList != null) {
            this.childPSDELogicNodeParamList.clear();
            this.childPSDELogicNodeParamList = null;
        }
    }
}

