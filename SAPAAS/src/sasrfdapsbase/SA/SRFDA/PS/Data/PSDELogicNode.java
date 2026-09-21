/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

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
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_PARAM10 = "PARAM10";
    public static final String TAG_PARAM11 = "PARAM11";
    public static final String TAG_PARAM12 = "PARAM12";
    public static final String TAG_PARAM13 = "PARAM13";
    public static final String TAG_PARAM14 = "PARAM14";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM9 = "PARAM9";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String TAG_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_LOGICNODESUBTYPE = "LOGICNODESUBTYPE";
    public static final String TAG_DSTPSDELOGICID = "DSTPSDELOGICID";
    public static final String TAG_DSTPSDELOGICNAME = "DSTPSDELOGICNAME";
    public static final String TAG_DSTPSDENOTIFYID = "DSTPSDENOTIFYID";
    public static final String TAG_DSTPSDENOTIFYNAME = "DSTPSDENOTIFYNAME";
    public static final String TAG_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String TAG_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String TAG_RETPSDLPARAMID = "RETPSDLPARAMID";
    public static final String TAG_RETPSDLPARAMNAME = "RETPSDLPARAMNAME";
    public static final String TAG_DEBUGMODE = "DEBUGMODE";
    public static final String TAG_THREADRUNMODE = "THREADRUNMODE";
    public static final String TAG_THREADRUNTIMER = "THREADRUNTIMER";
    public static final String TAG_PSSYSDATASYNCAGENTID = "PSSYSDATASYNCAGENTID";
    public static final String TAG_PSSYSDATASYNCAGENTNAME = "PSSYSDATASYNCAGENTNAME";
    public static final String TAG_DSTPSDEPRINTID = "DSTPSDEPRINTID";
    public static final String TAG_DSTPSDEPRINTNAME = "DSTPSDEPRINTNAME";
    public static final String TAG_DSTPSDEREPORTID = "DSTPSDEREPORTID";
    public static final String TAG_DSTPSDEREPORTNAME = "DSTPSDEREPORTNAME";
    public static final String TAG_DSTPSDEDTSQUEUEID = "DSTPSDEDTSQUEUEID";
    public static final String TAG_DSTPSDEDTSQUEUENAME = "DSTPSDEDTSQUEUENAME";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String TAG_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String TAG_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String TAG_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String TAG_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String TAG_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String TAG_NODEPARAMS = "NODEPARAMS";
    public static final String TAG_TSMODE = "TSMODE";
    public static final String TAG_DSTPSDEDATAQUERYID = "DSTPSDEDATAQUERYID";
    public static final String TAG_DSTPSDEDATAQUERYNAME = "DSTPSDEDATAQUERYNAME";
    public static final String TAG_DSTPSDEDATASYNCID = "DSTPSDEDATASYNCID";
    public static final String TAG_DSTPSDEDATASYNCNAME = "DSTPSDEDATASYNCNAME";
    public static final String TAG_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String TAG_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String TAG_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String TAG_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String TAG_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String TAG_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String TAG_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String TAG_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String TAG_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String TAG_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String TAG_DSTPSDEDATAIMPID = "DSTPSDEDATAIMPID";
    public static final String TAG_DSTPSDEDATAIMPNAME = "DSTPSDEDATAIMPNAME";
    public static final String TAG_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String TAG_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String TAG_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String TAG_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String TAG_DSTPSDEDATAEXPID = "DSTPSDEDATAEXPID";
    public static final String TAG_DSTPSDEDATAEXPNAME = "DSTPSDEDATAEXPNAME";
    public static final String TAG_DSTSORTDIR = "DSTSORTDIR";
    public static final String TAG_SRCSIZE = "SRCSIZE";
    public static final String TAG_SRCINDEX = "SRCINDEX";
    public static final String TAG_DSTINDEX = "DSTINDEX";
    public static final String TAG_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String TAG_CUSTOMSRCPARAM = "CUSTOMSRCPARAM";
    public static final String TAG_DSTPSDEVRGROUPID = "DSTPSDEVRGROUPID";
    public static final String TAG_DSTPSDEVRGROUPNAME = "DSTPSDEVRGROUPNAME";
    public static final String TAG_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String TAG_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String TAG_DSTPSDEFVALUERULEID = "DSTPSDEFVALUERULEID";
    public static final String TAG_DSTPSDEFVALUERULENAME = "DSTPSDEFVALUERULENAME";
    public static final String TAG_ISPSDLPARAMID = "ISPSDLPARAMID";
    public static final String TAG_ISPSDLPARAMNAME = "ISPSDLPARAMNAME";
    public static final String TAG_OSPSDLPARAMID = "OSPSDLPARAMID";
    public static final String TAG_OSPSDLPARAMNAME = "OSPSDLPARAMNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String TAG_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String TAG_DSTPSDEMAPID = "DSTPSDEMAPID";
    public static final String TAG_DSTPSDEMAPNAME = "DSTPSDEMAPNAME";
    public static final String TAG_PSSYSBACKSERVICEID = "PSSYSBACKSERVICEID";
    public static final String TAG_PSSYSBACKSERVICENAME = "PSSYSBACKSERVICENAME";
    public static final String TAG_MSGPSLANRESID = "MSGPSLANRESID";
    public static final String TAG_MSGPSLANRESNAME = "MSGPSLANRESNAME";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_DSTPSDEUILOGICID = "DSTPSDEUILOGICID";
    public static final String TAG_DSTPSDEUILOGICNAME = "DSTPSDEUILOGICNAME";
    public static final String TAG_DSTPSDEVIEWID = "DSTPSDEVIEWID";
    public static final String TAG_DSTPSDEVIEWNAME = "DSTPSDEVIEWNAME";
    public static final String TAG_DSTPSDEFORMID = "DSTPSDEFORMID";
    public static final String TAG_DSTPSDEFORMNAME = "DSTPSDEFORMNAME";
    public static final String TAG_DSTPSDEWIZARDID = "DSTPSDEWIZARDID";
    public static final String TAG_DSTPSDEWIZARDNAME = "DSTPSDEWIZARDNAME";
    public static final String TAG_DSTPSDEUAGROUPID = "DSTPSDEUAGROUPID";
    public static final String TAG_DSTPSDEUAGROUPNAME = "DSTPSDEUAGROUPNAME";
    public static final String TAG_DSTPSDEFGROUPID = "DSTPSDEFGROUPID";
    public static final String TAG_DSTPSDEFGROUPNAME = "DSTPSDEFGROUPNAME";
    public static final String TAG_DSTPSDEDATAFLOWID = "DSTPSDEDATAFLOWID";
    public static final String TAG_DSTPSDEDATAFLOWNAME = "DSTPSDEDATAFLOWNAME";
    public static final String TAG_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String TAG_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_DSTPSDESAMPLEDATAID = "DSTPSDESAMPLEDATAID";
    public static final String TAG_DSTPSDESAMPLEDATANAME = "DSTPSDESAMPLEDATANAME";
    public static final String TAG_DSTDEUTILDEID = "DSTDEUTILDEID";
    public static final String TAG_DSTDEUTILDENAME = "DSTDEUTILDENAME";
    public static final String TAG_OPTPSDLPARAMID = "OPTPSDLPARAMID";
    public static final String TAG_OPTPSDLPARAMNAME = "OPTPSDLPARAMNAME";
    public static final String TAG_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String TAG_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String TAG_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String TAG_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String TAG_PSSYSAICHATAGENTID = "PSSYSAICHATAGENTID";
    public static final String TAG_PSSYSAICHATAGENTNAME = "PSSYSAICHATAGENTNAME";
    public static final String TAG_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String TAG_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
    private ArrayList<PSDELogicLink> childPSDELogicLinkList = null;
    private ArrayList<PSDELogicNodeParam> childPSDELogicNodeParamList = null;

    public final boolean isPSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSDELOGICNODEID);
    }

    public final String getPSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_PSDELOGICNODEID, "");
    }

    public final void setPSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNODEID, strValue);
    }

    public final boolean isPSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNODENAME);
    }

    public final String getPSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNODENAME, "");
    }

    public final void setPSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNODENAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isLOGICNODETYPENull() {
        return this.IsParamNull(TAG_LOGICNODETYPE);
    }

    public final String getLOGICNODETYPE() {
        return this.GetParamStringValue(TAG_LOGICNODETYPE, "");
    }

    public final void setLOGICNODETYPE(String strValue) {
        this.SetParamValue(TAG_LOGICNODETYPE, strValue);
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

    public final boolean isDSTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONID);
    }

    public final String getDSTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONID, "");
    }

    public final void setDSTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONID, strValue);
    }

    public final boolean isDSTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONNAME);
    }

    public final String getDSTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONNAME, "");
    }

    public final void setDSTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONNAME, strValue);
    }

    public final boolean isDSTPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMID);
    }

    public final String getDSTPSDLPARAMID() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMID, "");
    }

    public final void setDSTPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMID, strValue);
    }

    public final boolean isDSTPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_DSTPSDLPARAMNAME);
    }

    public final String getDSTPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_DSTPSDLPARAMNAME, "");
    }

    public final void setDSTPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDLPARAMNAME, strValue);
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

    public final boolean isDSTPARAMACTIONNull() {
        return this.IsParamNull(TAG_DSTPARAMACTION);
    }

    public final String getDSTPARAMACTION() {
        return this.GetParamStringValue(TAG_DSTPARAMACTION, "");
    }

    public final void setDSTPARAMACTION(String strValue) {
        this.SetParamValue(TAG_DSTPARAMACTION, strValue);
    }

    public final boolean isSRCPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMID);
    }

    public final String getSRCPSDLPARAMID() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMID, "");
    }

    public final void setSRCPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_SRCPSDLPARAMID, strValue);
    }

    public final boolean isSRCPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_SRCPSDLPARAMNAME);
    }

    public final String getSRCPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_SRCPSDLPARAMNAME, "");
    }

    public final void setSRCPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_SRCPSDLPARAMNAME, strValue);
    }

    public final boolean isPARALLELOUTPUTNull() {
        return this.IsParamNull(TAG_PARALLELOUTPUT);
    }

    public final boolean getPARALLELOUTPUT() {
        return this.GetParamIntValue(TAG_PARALLELOUTPUT, 0) == 1;
    }

    public final void setPARALLELOUTPUT(boolean bValue) {
        this.SetParamValue(TAG_PARALLELOUTPUT, bValue ? 1 : 0);
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

    public final boolean isPSWORKFLOWIDNull() {
        return this.IsParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.GetParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.IsParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWNAME, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.IsParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.GetParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.SetParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.IsParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.GetParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPSSYSSQLCMDIDNull() {
        return this.IsParamNull(TAG_PSSYSSQLCMDID);
    }

    public final String getPSSYSSQLCMDID() {
        return this.GetParamStringValue(TAG_PSSYSSQLCMDID, "");
    }

    public final void setPSSYSSQLCMDID(String strValue) {
        this.SetParamValue(TAG_PSSYSSQLCMDID, strValue);
    }

    public final boolean isPSSYSSQLCMDNAMENull() {
        return this.IsParamNull(TAG_PSSYSSQLCMDNAME);
    }

    public final String getPSSYSSQLCMDNAME() {
        return this.GetParamStringValue(TAG_PSSYSSQLCMDNAME, "");
    }

    public final void setPSSYSSQLCMDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSQLCMDNAME, strValue);
    }

    public final boolean isPSSYSDELOGICNODEIDNull() {
        return this.IsParamNull(TAG_PSSYSDELOGICNODEID);
    }

    public final String getPSSYSDELOGICNODEID() {
        return this.GetParamStringValue(TAG_PSSYSDELOGICNODEID, "");
    }

    public final void setPSSYSDELOGICNODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDELOGICNODEID, strValue);
    }

    public final boolean isPSSYSDELOGICNODENAMENull() {
        return this.IsParamNull(TAG_PSSYSDELOGICNODENAME);
    }

    public final String getPSSYSDELOGICNODENAME() {
        return this.GetParamStringValue(TAG_PSSYSDELOGICNODENAME, "");
    }

    public final void setPSSYSDELOGICNODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDELOGICNODENAME, strValue);
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

    public final boolean isPARAM1Null() {
        return this.IsParamNull(TAG_PARAM1);
    }

    public final String getPARAM1() {
        return this.GetParamStringValue(TAG_PARAM1, "");
    }

    public final void setPARAM1(String strValue) {
        this.SetParamValue(TAG_PARAM1, strValue);
    }

    public final boolean isPARAM10Null() {
        return this.IsParamNull(TAG_PARAM10);
    }

    public final boolean getPARAM10() {
        return this.GetParamIntValue(TAG_PARAM10, 0) == 1;
    }

    public final void setPARAM10(boolean bValue) {
        this.SetParamValue(TAG_PARAM10, bValue ? 1 : 0);
    }

    public final boolean isPARAM11Null() {
        return this.IsParamNull(TAG_PARAM11);
    }

    public final String getPARAM11() {
        return this.GetParamStringValue(TAG_PARAM11, "");
    }

    public final void setPARAM11(String strValue) {
        this.SetParamValue(TAG_PARAM11, strValue);
    }

    public final boolean isPARAM12Null() {
        return this.IsParamNull(TAG_PARAM12);
    }

    public final String getPARAM12() {
        return this.GetParamStringValue(TAG_PARAM12, "");
    }

    public final void setPARAM12(String strValue) {
        this.SetParamValue(TAG_PARAM12, strValue);
    }

    public final boolean isPARAM13Null() {
        return this.IsParamNull(TAG_PARAM13);
    }

    public final String getPARAM13() {
        return this.GetParamStringValue(TAG_PARAM13, "");
    }

    public final void setPARAM13(String strValue) {
        this.SetParamValue(TAG_PARAM13, strValue);
    }

    public final boolean isPARAM14Null() {
        return this.IsParamNull(TAG_PARAM14);
    }

    public final String getPARAM14() {
        return this.GetParamStringValue(TAG_PARAM14, "");
    }

    public final void setPARAM14(String strValue) {
        this.SetParamValue(TAG_PARAM14, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public final void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public final void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public final void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public final void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public final boolean isPARAM9Null() {
        return this.IsParamNull(TAG_PARAM9);
    }

    public final boolean getPARAM9() {
        return this.GetParamIntValue(TAG_PARAM9, 0) == 1;
    }

    public final void setPARAM9(boolean bValue) {
        this.SetParamValue(TAG_PARAM9, bValue ? 1 : 0);
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

    public final boolean isPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEUIACTIONID);
    }

    public final String getPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONID, "");
    }

    public final void setPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONID, strValue);
    }

    public final boolean isPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEUIACTIONNAME);
    }

    public final String getPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEUIACTIONNAME, "");
    }

    public final void setPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUIACTIONNAME, strValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isLOGICNODESUBTYPENull() {
        return this.IsParamNull(TAG_LOGICNODESUBTYPE);
    }

    public final String getLOGICNODESUBTYPE() {
        return this.GetParamStringValue(TAG_LOGICNODESUBTYPE, "");
    }

    public final void setLOGICNODESUBTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICNODESUBTYPE, strValue);
    }

    public final boolean isDSTPSDELOGICIDNull() {
        return this.IsParamNull(TAG_DSTPSDELOGICID);
    }

    public final String getDSTPSDELOGICID() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICID, "");
    }

    public final void setDSTPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICID, strValue);
    }

    public final boolean isDSTPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_DSTPSDELOGICNAME);
    }

    public final String getDSTPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_DSTPSDELOGICNAME, "");
    }

    public final void setDSTPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDELOGICNAME, strValue);
    }

    public final boolean isDSTPSDENOTIFYIDNull() {
        return this.IsParamNull(TAG_DSTPSDENOTIFYID);
    }

    public final String getDSTPSDENOTIFYID() {
        return this.GetParamStringValue(TAG_DSTPSDENOTIFYID, "");
    }

    public final void setDSTPSDENOTIFYID(String strValue) {
        this.SetParamValue(TAG_DSTPSDENOTIFYID, strValue);
    }

    public final boolean isDSTPSDENOTIFYNAMENull() {
        return this.IsParamNull(TAG_DSTPSDENOTIFYNAME);
    }

    public final String getDSTPSDENOTIFYNAME() {
        return this.GetParamStringValue(TAG_DSTPSDENOTIFYNAME, "");
    }

    public final void setDSTPSDENOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDENOTIFYNAME, strValue);
    }

    public final boolean isDSTPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETID);
    }

    public final String getDSTPSDEDATASETID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETID, "");
    }

    public final void setDSTPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETID, strValue);
    }

    public final boolean isDSTPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATASETNAME);
    }

    public final String getDSTPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASETNAME, "");
    }

    public final void setDSTPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASETNAME, strValue);
    }

    public final boolean isRETPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_RETPSDLPARAMID);
    }

    public final String getRETPSDLPARAMID() {
        return this.GetParamStringValue(TAG_RETPSDLPARAMID, "");
    }

    public final void setRETPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_RETPSDLPARAMID, strValue);
    }

    public final boolean isRETPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_RETPSDLPARAMNAME);
    }

    public final String getRETPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_RETPSDLPARAMNAME, "");
    }

    public final void setRETPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_RETPSDLPARAMNAME, strValue);
    }

    public final boolean isDEBUGMODENull() {
        return this.IsParamNull(TAG_DEBUGMODE);
    }

    public final int getDEBUGMODE() {
        return this.GetParamIntValue(TAG_DEBUGMODE, 0);
    }

    public final void setDEBUGMODE(int nValue) {
        this.SetParamValue(TAG_DEBUGMODE, nValue);
    }

    public final boolean isTHREADRUNMODENull() {
        return this.IsParamNull(TAG_THREADRUNMODE);
    }

    public final int getTHREADRUNMODE() {
        return this.GetParamIntValue(TAG_THREADRUNMODE, 0);
    }

    public final void setTHREADRUNMODE(int nValue) {
        this.SetParamValue(TAG_THREADRUNMODE, nValue);
    }

    public final boolean isTHREADRUNTIMERNull() {
        return this.IsParamNull(TAG_THREADRUNTIMER);
    }

    public final int getTHREADRUNTIMER() {
        return this.GetParamIntValue(TAG_THREADRUNTIMER, 0);
    }

    public final void setTHREADRUNTIMER(int nValue) {
        this.SetParamValue(TAG_THREADRUNTIMER, nValue);
    }

    public final boolean isPSSYSDATASYNCAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSDATASYNCAGENTID);
    }

    public final String getPSSYSDATASYNCAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSDATASYNCAGENTID, "");
    }

    public final void setPSSYSDATASYNCAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSDATASYNCAGENTID, strValue);
    }

    public final boolean isPSSYSDATASYNCAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSDATASYNCAGENTNAME);
    }

    public final String getPSSYSDATASYNCAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSDATASYNCAGENTNAME, "");
    }

    public final void setPSSYSDATASYNCAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDATASYNCAGENTNAME, strValue);
    }

    public final boolean isDSTPSDEPRINTIDNull() {
        return this.IsParamNull(TAG_DSTPSDEPRINTID);
    }

    public final String getDSTPSDEPRINTID() {
        return this.GetParamStringValue(TAG_DSTPSDEPRINTID, "");
    }

    public final void setDSTPSDEPRINTID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEPRINTID, strValue);
    }

    public final boolean isDSTPSDEPRINTNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEPRINTNAME);
    }

    public final String getDSTPSDEPRINTNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEPRINTNAME, "");
    }

    public final void setDSTPSDEPRINTNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEPRINTNAME, strValue);
    }

    public final boolean isDSTPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_DSTPSDEREPORTID);
    }

    public final String getDSTPSDEREPORTID() {
        return this.GetParamStringValue(TAG_DSTPSDEREPORTID, "");
    }

    public final void setDSTPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEREPORTID, strValue);
    }

    public final boolean isDSTPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEREPORTNAME);
    }

    public final String getDSTPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEREPORTNAME, "");
    }

    public final void setDSTPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEREPORTNAME, strValue);
    }

    public final boolean isDSTPSDEDTSQUEUEIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDTSQUEUEID);
    }

    public final String getDSTPSDEDTSQUEUEID() {
        return this.GetParamStringValue(TAG_DSTPSDEDTSQUEUEID, "");
    }

    public final void setDSTPSDEDTSQUEUEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDTSQUEUEID, strValue);
    }

    public final boolean isDSTPSDEDTSQUEUENAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDTSQUEUENAME);
    }

    public final String getDSTPSDEDTSQUEUENAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDTSQUEUENAME, "");
    }

    public final void setDSTPSDEDTSQUEUENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDTSQUEUENAME, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
    }

    public final boolean isPSSUBSYSSADETAILIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILID);
    }

    public final String getPSSUBSYSSADETAILID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILID, "");
    }

    public final void setPSSUBSYSSADETAILID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILID, strValue);
    }

    public final boolean isPSSUBSYSSADETAILNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADETAILNAME);
    }

    public final String getPSSUBSYSSADETAILNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADETAILNAME, "");
    }

    public final void setPSSUBSYSSADETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADETAILNAME, strValue);
    }

    public final boolean isPSSYSDBSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMEID);
    }

    public final String getPSSYSDBSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMEID, "");
    }

    public final void setPSSYSDBSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMEID, strValue);
    }

    public final boolean isPSSYSDBSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMENAME);
    }

    public final String getPSSYSDBSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMENAME, "");
    }

    public final void setPSSYSDBSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMENAME, strValue);
    }

    public final boolean isPSSYSDBTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBTABLEID);
    }

    public final String getPSSYSDBTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLEID, "");
    }

    public final void setPSSYSDBTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLEID, strValue);
    }

    public final boolean isPSSYSDBTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBTABLENAME);
    }

    public final String getPSSYSDBTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLENAME, "");
    }

    public final void setPSSYSDBTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLENAME, strValue);
    }

    public final boolean isNODEPARAMSNull() {
        return this.IsParamNull(TAG_NODEPARAMS);
    }

    public final String getNODEPARAMS() {
        return this.GetParamStringValue(TAG_NODEPARAMS, "");
    }

    public final void setNODEPARAMS(String strValue) {
        this.SetParamValue(TAG_NODEPARAMS, strValue);
    }

    public final boolean isTSMODENull() {
        return this.IsParamNull(TAG_TSMODE);
    }

    public final int getTSMODE() {
        return this.GetParamIntValue(TAG_TSMODE, 0);
    }

    public final void setTSMODE(int nValue) {
        this.SetParamValue(TAG_TSMODE, nValue);
    }

    public final boolean isDSTPSDEDATAQUERYIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATAQUERYID);
    }

    public final String getDSTPSDEDATAQUERYID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAQUERYID, "");
    }

    public final void setDSTPSDEDATAQUERYID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAQUERYID, strValue);
    }

    public final boolean isDSTPSDEDATAQUERYNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATAQUERYNAME);
    }

    public final String getDSTPSDEDATAQUERYNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAQUERYNAME, "");
    }

    public final void setDSTPSDEDATAQUERYNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAQUERYNAME, strValue);
    }

    public final boolean isDSTPSDEDATASYNCIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATASYNCID);
    }

    public final String getDSTPSDEDATASYNCID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASYNCID, "");
    }

    public final void setDSTPSDEDATASYNCID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASYNCID, strValue);
    }

    public final boolean isDSTPSDEDATASYNCNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATASYNCNAME);
    }

    public final String getDSTPSDEDATASYNCNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATASYNCNAME, "");
    }

    public final void setDSTPSDEDATASYNCNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATASYNCNAME, strValue);
    }

    public final boolean isPSSYSBDSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMEID);
    }

    public final String getPSSYSBDSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMEID, "");
    }

    public final void setPSSYSBDSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMEID, strValue);
    }

    public final boolean isPSSYSBDSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDSCHEMENAME);
    }

    public final String getPSSYSBDSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDSCHEMENAME, "");
    }

    public final void setPSSYSBDSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDSCHEMENAME, strValue);
    }

    public final boolean isPSSYSBDTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBDTABLEID);
    }

    public final String getPSSYSBDTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLEID, "");
    }

    public final void setPSSYSBDTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLEID, strValue);
    }

    public final boolean isPSSYSBDTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBDTABLENAME);
    }

    public final String getPSSYSBDTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBDTABLENAME, "");
    }

    public final void setPSSYSBDTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBDTABLENAME, strValue);
    }

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isPSSYSBISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMENAME);
    }

    public final String getPSSYSBISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMENAME, "");
    }

    public final void setPSSYSBISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMENAME, strValue);
    }

    public final boolean isPSSYSBIREPORTIDNull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTID);
    }

    public final String getPSSYSBIREPORTID() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTID, "");
    }

    public final void setPSSYSBIREPORTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTID, strValue);
    }

    public final boolean isPSSYSBIREPORTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTNAME);
    }

    public final String getPSSYSBIREPORTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTNAME, "");
    }

    public final void setPSSYSBIREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTNAME, strValue);
    }

    public final boolean isPSSYSSEARCHSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMEID);
    }

    public final String getPSSYSSEARCHSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMEID, "");
    }

    public final void setPSSYSSEARCHSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMEID, strValue);
    }

    public final boolean isPSSYSSEARCHSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMENAME);
    }

    public final String getPSSYSSEARCHSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMENAME, "");
    }

    public final void setPSSYSSEARCHSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMENAME, strValue);
    }

    public final boolean isPSSYSSEARCHDOCIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCID);
    }

    public final String getPSSYSSEARCHDOCID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCID, "");
    }

    public final void setPSSYSSEARCHDOCID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCID, strValue);
    }

    public final boolean isPSSYSSEARCHDOCNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCNAME);
    }

    public final String getPSSYSSEARCHDOCNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCNAME, "");
    }

    public final void setPSSYSSEARCHDOCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCNAME, strValue);
    }

    public final boolean isDSTPSDEDATAIMPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATAIMPID);
    }

    public final String getDSTPSDEDATAIMPID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAIMPID, "");
    }

    public final void setDSTPSDEDATAIMPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAIMPID, strValue);
    }

    public final boolean isDSTPSDEDATAIMPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATAIMPNAME);
    }

    public final String getDSTPSDEDATAIMPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAIMPNAME, "");
    }

    public final void setDSTPSDEDATAIMPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAIMPNAME, strValue);
    }

    public final boolean isPSSYSEAISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMEID);
    }

    public final String getPSSYSEAISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMEID, "");
    }

    public final void setPSSYSEAISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMEID, strValue);
    }

    public final boolean isPSSYSEAISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMENAME);
    }

    public final String getPSSYSEAISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMENAME, "");
    }

    public final void setPSSYSEAISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMENAME, strValue);
    }

    public final boolean isPSSYSEAIELEMENTIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTID);
    }

    public final String getPSSYSEAIELEMENTID() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTID, "");
    }

    public final void setPSSYSEAIELEMENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTID, strValue);
    }

    public final boolean isPSSYSEAIELEMENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTNAME);
    }

    public final String getPSSYSEAIELEMENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTNAME, "");
    }

    public final void setPSSYSEAIELEMENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTNAME, strValue);
    }

    public final boolean isDSTPSDEDATAEXPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATAEXPID);
    }

    public final String getDSTPSDEDATAEXPID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAEXPID, "");
    }

    public final void setDSTPSDEDATAEXPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAEXPID, strValue);
    }

    public final boolean isDSTPSDEDATAEXPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATAEXPNAME);
    }

    public final String getDSTPSDEDATAEXPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAEXPNAME, "");
    }

    public final void setDSTPSDEDATAEXPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAEXPNAME, strValue);
    }

    public final boolean isDSTSORTDIRNull() {
        return this.IsParamNull(TAG_DSTSORTDIR);
    }

    public final String getDSTSORTDIR() {
        return this.GetParamStringValue(TAG_DSTSORTDIR, "");
    }

    public final void setDSTSORTDIR(String strValue) {
        this.SetParamValue(TAG_DSTSORTDIR, strValue);
    }

    public final boolean isSRCSIZENull() {
        return this.IsParamNull(TAG_SRCSIZE);
    }

    public final int getSRCSIZE() {
        return this.GetParamIntValue(TAG_SRCSIZE, 0);
    }

    public final void setSRCSIZE(int nValue) {
        this.SetParamValue(TAG_SRCSIZE, nValue);
    }

    public final boolean isSRCINDEXNull() {
        return this.IsParamNull(TAG_SRCINDEX);
    }

    public final int getSRCINDEX() {
        return this.GetParamIntValue(TAG_SRCINDEX, 0);
    }

    public final void setSRCINDEX(int nValue) {
        this.SetParamValue(TAG_SRCINDEX, nValue);
    }

    public final boolean isDSTINDEXNull() {
        return this.IsParamNull(TAG_DSTINDEX);
    }

    public final int getDSTINDEX() {
        return this.GetParamIntValue(TAG_DSTINDEX, 0);
    }

    public final void setDSTINDEX(int nValue) {
        this.SetParamValue(TAG_DSTINDEX, nValue);
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

    public final boolean isCUSTOMSRCPARAMNull() {
        return this.IsParamNull(TAG_CUSTOMSRCPARAM);
    }

    public final String getCUSTOMSRCPARAM() {
        return this.GetParamStringValue(TAG_CUSTOMSRCPARAM, "");
    }

    public final void setCUSTOMSRCPARAM(String strValue) {
        this.SetParamValue(TAG_CUSTOMSRCPARAM, strValue);
    }

    public final boolean isDSTPSDEVRGROUPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEVRGROUPID);
    }

    public final String getDSTPSDEVRGROUPID() {
        return this.GetParamStringValue(TAG_DSTPSDEVRGROUPID, "");
    }

    public final void setDSTPSDEVRGROUPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVRGROUPID, strValue);
    }

    public final boolean isDSTPSDEVRGROUPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEVRGROUPNAME);
    }

    public final String getDSTPSDEVRGROUPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEVRGROUPNAME, "");
    }

    public final void setDSTPSDEVRGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVRGROUPNAME, strValue);
    }

    public final boolean isPSSYSUNISTATEIDNull() {
        return this.IsParamNull(TAG_PSSYSUNISTATEID);
    }

    public final String getPSSYSUNISTATEID() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATEID, "");
    }

    public final void setPSSYSUNISTATEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATEID, strValue);
    }

    public final boolean isPSSYSUNISTATENAMENull() {
        return this.IsParamNull(TAG_PSSYSUNISTATENAME);
    }

    public final String getPSSYSUNISTATENAME() {
        return this.GetParamStringValue(TAG_PSSYSUNISTATENAME, "");
    }

    public final void setPSSYSUNISTATENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNISTATENAME, strValue);
    }

    public final boolean isDSTPSDEFVALUERULEIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFVALUERULEID);
    }

    public final String getDSTPSDEFVALUERULEID() {
        return this.GetParamStringValue(TAG_DSTPSDEFVALUERULEID, "");
    }

    public final void setDSTPSDEFVALUERULEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFVALUERULEID, strValue);
    }

    public final boolean isDSTPSDEFVALUERULENAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFVALUERULENAME);
    }

    public final String getDSTPSDEFVALUERULENAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFVALUERULENAME, "");
    }

    public final void setDSTPSDEFVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFVALUERULENAME, strValue);
    }

    public final boolean isISPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_ISPSDLPARAMID);
    }

    public final String getISPSDLPARAMID() {
        return this.GetParamStringValue(TAG_ISPSDLPARAMID, "");
    }

    public final void setISPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_ISPSDLPARAMID, strValue);
    }

    public final boolean isISPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_ISPSDLPARAMNAME);
    }

    public final String getISPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_ISPSDLPARAMNAME, "");
    }

    public final void setISPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_ISPSDLPARAMNAME, strValue);
    }

    public final boolean isOSPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_OSPSDLPARAMID);
    }

    public final String getOSPSDLPARAMID() {
        return this.GetParamStringValue(TAG_OSPSDLPARAMID, "");
    }

    public final void setOSPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_OSPSDLPARAMID, strValue);
    }

    public final boolean isOSPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_OSPSDLPARAMNAME);
    }

    public final String getOSPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_OSPSDLPARAMNAME, "");
    }

    public final void setOSPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_OSPSDLPARAMNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isPSSYSUTILDEIDNull() {
        return this.IsParamNull(TAG_PSSYSUTILDEID);
    }

    public final String getPSSYSUTILDEID() {
        return this.GetParamStringValue(TAG_PSSYSUTILDEID, "");
    }

    public final void setPSSYSUTILDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILDEID, strValue);
    }

    public final boolean isPSSYSUTILDENAMENull() {
        return this.IsParamNull(TAG_PSSYSUTILDENAME);
    }

    public final String getPSSYSUTILDENAME() {
        return this.GetParamStringValue(TAG_PSSYSUTILDENAME, "");
    }

    public final void setPSSYSUTILDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILDENAME, strValue);
    }

    public final boolean isDSTPSDEMAPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEMAPID);
    }

    public final String getDSTPSDEMAPID() {
        return this.GetParamStringValue(TAG_DSTPSDEMAPID, "");
    }

    public final void setDSTPSDEMAPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEMAPID, strValue);
    }

    public final boolean isDSTPSDEMAPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEMAPNAME);
    }

    public final String getDSTPSDEMAPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEMAPNAME, "");
    }

    public final void setDSTPSDEMAPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEMAPNAME, strValue);
    }

    public final boolean isPSSYSBACKSERVICEIDNull() {
        return this.IsParamNull(TAG_PSSYSBACKSERVICEID);
    }

    public final String getPSSYSBACKSERVICEID() {
        return this.GetParamStringValue(TAG_PSSYSBACKSERVICEID, "");
    }

    public final void setPSSYSBACKSERVICEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBACKSERVICEID, strValue);
    }

    public final boolean isPSSYSBACKSERVICENAMENull() {
        return this.IsParamNull(TAG_PSSYSBACKSERVICENAME);
    }

    public final String getPSSYSBACKSERVICENAME() {
        return this.GetParamStringValue(TAG_PSSYSBACKSERVICENAME, "");
    }

    public final void setPSSYSBACKSERVICENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBACKSERVICENAME, strValue);
    }

    public final boolean isMSGPSLANRESIDNull() {
        return this.IsParamNull(TAG_MSGPSLANRESID);
    }

    public final String getMSGPSLANRESID() {
        return this.GetParamStringValue(TAG_MSGPSLANRESID, "");
    }

    public final void setMSGPSLANRESID(String strValue) {
        this.SetParamValue(TAG_MSGPSLANRESID, strValue);
    }

    public final boolean isMSGPSLANRESNAMENull() {
        return this.IsParamNull(TAG_MSGPSLANRESNAME);
    }

    public final String getMSGPSLANRESNAME() {
        return this.GetParamStringValue(TAG_MSGPSLANRESNAME, "");
    }

    public final void setMSGPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_MSGPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isDSTPSDEUILOGICIDNull() {
        return this.IsParamNull(TAG_DSTPSDEUILOGICID);
    }

    public final String getDSTPSDEUILOGICID() {
        return this.GetParamStringValue(TAG_DSTPSDEUILOGICID, "");
    }

    public final void setDSTPSDEUILOGICID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEUILOGICID, strValue);
    }

    public final boolean isDSTPSDEUILOGICNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEUILOGICNAME);
    }

    public final String getDSTPSDEUILOGICNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEUILOGICNAME, "");
    }

    public final void setDSTPSDEUILOGICNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEUILOGICNAME, strValue);
    }

    public final boolean isDSTPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_DSTPSDEVIEWID);
    }

    public final String getDSTPSDEVIEWID() {
        return this.GetParamStringValue(TAG_DSTPSDEVIEWID, "");
    }

    public final void setDSTPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVIEWID, strValue);
    }

    public final boolean isDSTPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEVIEWNAME);
    }

    public final String getDSTPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEVIEWNAME, "");
    }

    public final void setDSTPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVIEWNAME, strValue);
    }

    public final boolean isDSTPSDEFORMIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFORMID);
    }

    public final String getDSTPSDEFORMID() {
        return this.GetParamStringValue(TAG_DSTPSDEFORMID, "");
    }

    public final void setDSTPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFORMID, strValue);
    }

    public final boolean isDSTPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFORMNAME);
    }

    public final String getDSTPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFORMNAME, "");
    }

    public final void setDSTPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFORMNAME, strValue);
    }

    public final boolean isDSTPSDEWIZARDIDNull() {
        return this.IsParamNull(TAG_DSTPSDEWIZARDID);
    }

    public final String getDSTPSDEWIZARDID() {
        return this.GetParamStringValue(TAG_DSTPSDEWIZARDID, "");
    }

    public final void setDSTPSDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEWIZARDID, strValue);
    }

    public final boolean isDSTPSDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEWIZARDNAME);
    }

    public final String getDSTPSDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEWIZARDNAME, "");
    }

    public final void setDSTPSDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEWIZARDNAME, strValue);
    }

    public final boolean isDSTPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEUAGROUPID);
    }

    public final String getDSTPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_DSTPSDEUAGROUPID, "");
    }

    public final void setDSTPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEUAGROUPID, strValue);
    }

    public final boolean isDSTPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEUAGROUPNAME);
    }

    public final String getDSTPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEUAGROUPNAME, "");
    }

    public final void setDSTPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEUAGROUPNAME, strValue);
    }

    public final boolean isDSTPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFGROUPID);
    }

    public final String getDSTPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_DSTPSDEFGROUPID, "");
    }

    public final void setDSTPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFGROUPID, strValue);
    }

    public final boolean isDSTPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFGROUPNAME);
    }

    public final String getDSTPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFGROUPNAME, "");
    }

    public final void setDSTPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFGROUPNAME, strValue);
    }

    public final boolean isDSTPSDEDATAFLOWIDNull() {
        return this.IsParamNull(TAG_DSTPSDEDATAFLOWID);
    }

    public final String getDSTPSDEDATAFLOWID() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAFLOWID, "");
    }

    public final void setDSTPSDEDATAFLOWID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAFLOWID, strValue);
    }

    public final boolean isDSTPSDEDATAFLOWNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEDATAFLOWNAME);
    }

    public final String getDSTPSDEDATAFLOWNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEDATAFLOWNAME, "");
    }

    public final void setDSTPSDEDATAFLOWNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEDATAFLOWNAME, strValue);
    }

    public final boolean isDSTPSDESAMPLEDATAIDNull() {
        return this.IsParamNull(TAG_DSTPSDESAMPLEDATAID);
    }

    public final String getDSTPSDESAMPLEDATAID() {
        return this.GetParamStringValue(TAG_DSTPSDESAMPLEDATAID, "");
    }

    public final void setDSTPSDESAMPLEDATAID(String strValue) {
        this.SetParamValue(TAG_DSTPSDESAMPLEDATAID, strValue);
    }

    public final boolean isDSTPSDESAMPLEDATANAMENull() {
        return this.IsParamNull(TAG_DSTPSDESAMPLEDATANAME);
    }

    public final String getDSTPSDESAMPLEDATANAME() {
        return this.GetParamStringValue(TAG_DSTPSDESAMPLEDATANAME, "");
    }

    public final void setDSTPSDESAMPLEDATANAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDESAMPLEDATANAME, strValue);
    }

    public final boolean isPSVIEWMSGIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGID);
    }

    public final String getPSVIEWMSGID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGID, "");
    }

    public final void setPSVIEWMSGID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGID, strValue);
    }

    public final boolean isPSVIEWMSGNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGNAME);
    }

    public final String getPSVIEWMSGNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGNAME, "");
    }

    public final void setPSVIEWMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGNAME, strValue);
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

    public final boolean isOPTPSDLPARAMIDNull() {
        return this.IsParamNull(TAG_OPTPSDLPARAMID);
    }

    public final String getOPTPSDLPARAMID() {
        return this.GetParamStringValue(TAG_OPTPSDLPARAMID, "");
    }

    public final void setOPTPSDLPARAMID(String strValue) {
        this.SetParamValue(TAG_OPTPSDLPARAMID, strValue);
    }

    public final boolean isOPTPSDLPARAMNAMENull() {
        return this.IsParamNull(TAG_OPTPSDLPARAMNAME);
    }

    public final String getOPTPSDLPARAMNAME() {
        return this.GetParamStringValue(TAG_OPTPSDLPARAMNAME, "");
    }

    public final void setOPTPSDLPARAMNAME(String strValue) {
        this.SetParamValue(TAG_OPTPSDLPARAMNAME, strValue);
    }

    public final boolean isPSSYSAIFACTORYIDNull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYID);
    }

    public final String getPSSYSAIFACTORYID() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYID, "");
    }

    public final void setPSSYSAIFACTORYID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYID, strValue);
    }

    public final boolean isPSSYSAIFACTORYNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIFACTORYNAME);
    }

    public final String getPSSYSAIFACTORYNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIFACTORYNAME, "");
    }

    public final void setPSSYSAIFACTORYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIFACTORYNAME, strValue);
    }

    public final boolean isPSSYSAIPIPELINEAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEAGENTID);
    }

    public final String getPSSYSAIPIPELINEAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEAGENTID, "");
    }

    public final void setPSSYSAIPIPELINEAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEAGENTID, strValue);
    }

    public final boolean isPSSYSAIPIPELINEAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIPIPELINEAGENTNAME);
    }

    public final String getPSSYSAIPIPELINEAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIPIPELINEAGENTNAME, "");
    }

    public final void setPSSYSAIPIPELINEAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIPIPELINEAGENTNAME, strValue);
    }

    public final boolean isPSSYSAICHATAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAICHATAGENTID);
    }

    public final String getPSSYSAICHATAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAICHATAGENTID, "");
    }

    public final void setPSSYSAICHATAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAICHATAGENTID, strValue);
    }

    public final boolean isPSSYSAICHATAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAICHATAGENTNAME);
    }

    public final String getPSSYSAICHATAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAICHATAGENTNAME, "");
    }

    public final void setPSSYSAICHATAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAICHATAGENTNAME, strValue);
    }

    public final boolean isPSSYSAIWORKERAGENTIDNull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTID);
    }

    public final String getPSSYSAIWORKERAGENTID() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTID, "");
    }

    public final void setPSSYSAIWORKERAGENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTID, strValue);
    }

    public final boolean isPSSYSAIWORKERAGENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSAIWORKERAGENTNAME);
    }

    public final String getPSSYSAIWORKERAGENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSAIWORKERAGENTNAME, "");
    }

    public final void setPSSYSAIWORKERAGENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAIWORKERAGENTNAME, strValue);
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

