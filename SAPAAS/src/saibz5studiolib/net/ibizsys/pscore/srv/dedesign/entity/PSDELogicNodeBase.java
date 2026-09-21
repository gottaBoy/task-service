/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIChatAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIFactory;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIPipelineAgent;
import net.ibizsys.pscore.srv.aidesign.entity.PSSysAIWorkerAgent;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIChatAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIFactoryService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIPipelineAgentService;
import net.ibizsys.pscore.srv.aidesign.service.PSSysAIWorkerAgentService;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDScheme;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDSchemeService;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDTableService;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIAggTable;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDTSQueue;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSync;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELNParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.entity.PSDENotify;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESampleData;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUtilDE;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEVRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDTSQueueService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSyncService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDENotifyService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESampleDataService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUtilDEService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEVRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDoc;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchScheme;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDocService;
import net.ibizsys.pscore.srv.search.service.PSSysSearchSchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysBackService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDELogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDataSyncAgent;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSQLCmd;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniState;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUtilDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysSADetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysBackServiceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDELogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDataSyncAgentService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSQLCmdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniStateService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUtilDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFDEService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELogicNodeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String FIELD_CUSTOMSRCPARAM = "CUSTOMSRCPARAM";
    public static final String FIELD_DEBUGMODE = "DEBUGMODE";
    public static final String FIELD_DSTPSDEUTILDEID = "DSTDEUTILDEID";
    public static final String FIELD_DSTPSDEUTILDENAME = "DSTDEUTILDENAME";
    public static final String FIELD_DSTINDEX = "DSTINDEX";
    public static final String FIELD_DSTPARAMACTION = "DSTPARAMACTION";
    public static final String FIELD_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String FIELD_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String FIELD_DSTPSDEDATAEXPID = "DSTPSDEDATAEXPID";
    public static final String FIELD_DSTPSDEDATAEXPNAME = "DSTPSDEDATAEXPNAME";
    public static final String FIELD_DSTPSDEDATAFLOWID = "DSTPSDEDATAFLOWID";
    public static final String FIELD_DSTPSDEDATAFLOWNAME = "DSTPSDEDATAFLOWNAME";
    public static final String FIELD_DSTPSDEDATAIMPID = "DSTPSDEDATAIMPID";
    public static final String FIELD_DSTPSDEDATAIMPNAME = "DSTPSDEDATAIMPNAME";
    public static final String FIELD_DSTPSDEDATAQUERYID = "DSTPSDEDATAQUERYID";
    public static final String FIELD_DSTPSDEDATAQUERYNAME = "DSTPSDEDATAQUERYNAME";
    public static final String FIELD_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String FIELD_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String FIELD_DSTPSDEDATASYNCID = "DSTPSDEDATASYNCID";
    public static final String FIELD_DSTPSDEDATASYNCNAME = "DSTPSDEDATASYNCNAME";
    public static final String FIELD_DSTPSDEDTSQUEUEID = "DSTPSDEDTSQUEUEID";
    public static final String FIELD_DSTPSDEDTSQUEUENAME = "DSTPSDEDTSQUEUENAME";
    public static final String FIELD_DSTPSDEFGROUPID = "DSTPSDEFGROUPID";
    public static final String FIELD_DSTPSDEFGROUPNAME = "DSTPSDEFGROUPNAME";
    public static final String FIELD_DSTPSDEFORMID = "DSTPSDEFORMID";
    public static final String FIELD_DSTPSDEFORMNAME = "DSTPSDEFORMNAME";
    public static final String FIELD_DSTPSDEFVALUERULEID = "DSTPSDEFVALUERULEID";
    public static final String FIELD_DSTPSDEFVALUERULENAME = "DSTPSDEFVALUERULENAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_DSTPSDELOGICID = "DSTPSDELOGICID";
    public static final String FIELD_DSTPSDELOGICNAME = "DSTPSDELOGICNAME";
    public static final String FIELD_DSTPSDEMAPID = "DSTPSDEMAPID";
    public static final String FIELD_DSTPSDEMAPNAME = "DSTPSDEMAPNAME";
    public static final String FIELD_DSTPSDENAME = "DSTPSDENAME";
    public static final String FIELD_DSTPSDENOTIFYID = "DSTPSDENOTIFYID";
    public static final String FIELD_DSTPSDENOTIFYNAME = "DSTPSDENOTIFYNAME";
    public static final String FIELD_DSTPSDEPRINTID = "DSTPSDEPRINTID";
    public static final String FIELD_DSTPSDEPRINTNAME = "DSTPSDEPRINTNAME";
    public static final String FIELD_DSTPSDEREPORTID = "DSTPSDEREPORTID";
    public static final String FIELD_DSTPSDEREPORTNAME = "DSTPSDEREPORTNAME";
    public static final String FIELD_DSTPSDESAMPLEDATAID = "DSTPSDESAMPLEDATAID";
    public static final String FIELD_DSTPSDESAMPLEDATANAME = "DSTPSDESAMPLEDATANAME";
    public static final String FIELD_DSTPSDEUAGROUPID = "DSTPSDEUAGROUPID";
    public static final String FIELD_DSTPSDEUAGROUPNAME = "DSTPSDEUAGROUPNAME";
    public static final String FIELD_DSTPSDEUILOGICID = "DSTPSDEUILOGICID";
    public static final String FIELD_DSTPSDEUILOGICNAME = "DSTPSDEUILOGICNAME";
    public static final String FIELD_DSTPSDEVIEWID = "DSTPSDEVIEWID";
    public static final String FIELD_DSTPSDEVIEWNAME = "DSTPSDEVIEWNAME";
    public static final String FIELD_DSTPSDEVRGROUPID = "DSTPSDEVRGROUPID";
    public static final String FIELD_DSTPSDEVRGROUPNAME = "DSTPSDEVRGROUPNAME";
    public static final String FIELD_DSTPSDEWIZARDID = "DSTPSDEWIZARDID";
    public static final String FIELD_DSTPSDEWIZARDNAME = "DSTPSDEWIZARDNAME";
    public static final String FIELD_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String FIELD_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String FIELD_DSTSORTDIR = "DSTSORTDIR";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ISPSDLPARAMID = "ISPSDLPARAMID";
    public static final String FIELD_ISPSDLPARAMNAME = "ISPSDLPARAMNAME";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_LOGICNODESUBTYPE = "LOGICNODESUBTYPE";
    public static final String FIELD_LOGICNODETYPE = "LOGICNODETYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MSGPSLANRESID = "MSGPSLANRESID";
    public static final String FIELD_MSGPSLANRESNAME = "MSGPSLANRESNAME";
    public static final String FIELD_NODEPARAMS = "NODEPARAMS";
    public static final String FIELD_OPTPSDLPARAMID = "OPTPSDLPARAMID";
    public static final String FIELD_OPTPSDLPARAMNAME = "OPTPSDLPARAMNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_OSPSDLPARAMID = "OSPSDLPARAMID";
    public static final String FIELD_OSPSDLPARAMNAME = "OSPSDLPARAMNAME";
    public static final String FIELD_PARALLELOUTPUT = "PARALLELOUTPUT";
    public static final String FIELD_PARAM1 = "PARAM1";
    public static final String FIELD_PARAM10 = "PARAM10";
    public static final String FIELD_PARAM11 = "PARAM11";
    public static final String FIELD_PARAM12 = "PARAM12";
    public static final String FIELD_PARAM13 = "PARAM13";
    public static final String FIELD_PARAM14 = "PARAM14";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PARAM9 = "PARAM9";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDELOGICNODEID = "PSDELOGICNODEID";
    public static final String FIELD_PSDELOGICNODENAME = "PSDELOGICNODENAME";
    public static final String FIELD_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String FIELD_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSUBSYSSADETAILID = "PSSUBSYSSADETAILID";
    public static final String FIELD_PSSUBSYSSADETAILNAME = "PSSUBSYSSADETAILNAME";
    public static final String FIELD_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String FIELD_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String FIELD_PSSYSAICHATAGENTID = "PSSYSAICHATAGENTID";
    public static final String FIELD_PSSYSAICHATAGENTNAME = "PSSYSAICHATAGENTNAME";
    public static final String FIELD_PSSYSAIFACTORYID = "PSSYSAIFACTORYID";
    public static final String FIELD_PSSYSAIFACTORYNAME = "PSSYSAIFACTORYNAME";
    public static final String FIELD_PSSYSAIPIPELINEAGENTID = "PSSYSAIPIPELINEAGENTID";
    public static final String FIELD_PSSYSAIPIPELINEAGENTNAME = "PSSYSAIPIPELINEAGENTNAME";
    public static final String FIELD_PSSYSAIWORKERAGENTID = "PSSYSAIWORKERAGENTID";
    public static final String FIELD_PSSYSAIWORKERAGENTNAME = "PSSYSAIWORKERAGENTNAME";
    public static final String FIELD_PSSYSBACKSERVICEID = "PSSYSBACKSERVICEID";
    public static final String FIELD_PSSYSBACKSERVICENAME = "PSSYSBACKSERVICENAME";
    public static final String FIELD_PSSYSBDSCHEMEID = "PSSYSBDSCHEMEID";
    public static final String FIELD_PSSYSBDSCHEMENAME = "PSSYSBDSCHEMENAME";
    public static final String FIELD_PSSYSBDTABLEID = "PSSYSBDTABLEID";
    public static final String FIELD_PSSYSBDTABLENAME = "PSSYSBDTABLENAME";
    public static final String FIELD_PSSYSBIAGGTABLEID = "PSSYSBIAGGTABLEID";
    public static final String FIELD_PSSYSBIAGGTABLENAME = "PSSYSBIAGGTABLENAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String FIELD_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_PSSYSDATASYNCAGENTID = "PSSYSDATASYNCAGENTID";
    public static final String FIELD_PSSYSDATASYNCAGENTNAME = "PSSYSDATASYNCAGENTNAME";
    public static final String FIELD_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String FIELD_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String FIELD_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String FIELD_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String FIELD_PSSYSDELOGICNODEID = "PSSYSDELOGICNODEID";
    public static final String FIELD_PSSYSDELOGICNODENAME = "PSSYSDELOGICNODENAME";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String FIELD_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String FIELD_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String FIELD_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSSQLCMDID = "PSSYSSQLCMDID";
    public static final String FIELD_PSSYSSQLCMDNAME = "PSSYSSQLCMDNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSUNISTATEID = "PSSYSUNISTATEID";
    public static final String FIELD_PSSYSUNISTATENAME = "PSSYSUNISTATENAME";
    public static final String FIELD_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String FIELD_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String FIELD_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String FIELD_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSWFDENAME = "PSWFDENAME";
    public static final String FIELD_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String FIELD_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String FIELD_RETPSDLPARAMID = "RETPSDLPARAMID";
    public static final String FIELD_RETPSDLPARAMNAME = "RETPSDLPARAMNAME";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_SRCINDEX = "SRCINDEX";
    public static final String FIELD_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String FIELD_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    public static final String FIELD_SRCSIZE = "SRCSIZE";
    public static final String FIELD_THREADRUNMODE = "THREADRUNMODE";
    public static final String FIELD_THREADRUNTIMER = "THREADRUNTIMER";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_TSMODE = "TSMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMDSTPARAM = 3;
    private static final int INDEX_CUSTOMSRCPARAM = 4;
    private static final int INDEX_DEBUGMODE = 5;
    private static final int INDEX_DSTPSDEUTILDEID = 6;
    private static final int INDEX_DSTPSDEUTILDENAME = 7;
    private static final int INDEX_DSTINDEX = 8;
    private static final int INDEX_DSTPARAMACTION = 9;
    private static final int INDEX_DSTPSDEACTIONID = 10;
    private static final int INDEX_DSTPSDEACTIONNAME = 11;
    private static final int INDEX_DSTPSDEDATAEXPID = 12;
    private static final int INDEX_DSTPSDEDATAEXPNAME = 13;
    private static final int INDEX_DSTPSDEDATAFLOWID = 14;
    private static final int INDEX_DSTPSDEDATAFLOWNAME = 15;
    private static final int INDEX_DSTPSDEDATAIMPID = 16;
    private static final int INDEX_DSTPSDEDATAIMPNAME = 17;
    private static final int INDEX_DSTPSDEDATAQUERYID = 18;
    private static final int INDEX_DSTPSDEDATAQUERYNAME = 19;
    private static final int INDEX_DSTPSDEDATASETID = 20;
    private static final int INDEX_DSTPSDEDATASETNAME = 21;
    private static final int INDEX_DSTPSDEDATASYNCID = 22;
    private static final int INDEX_DSTPSDEDATASYNCNAME = 23;
    private static final int INDEX_DSTPSDEDTSQUEUEID = 24;
    private static final int INDEX_DSTPSDEDTSQUEUENAME = 25;
    private static final int INDEX_DSTPSDEFGROUPID = 26;
    private static final int INDEX_DSTPSDEFGROUPNAME = 27;
    private static final int INDEX_DSTPSDEFORMID = 28;
    private static final int INDEX_DSTPSDEFORMNAME = 29;
    private static final int INDEX_DSTPSDEFVALUERULEID = 30;
    private static final int INDEX_DSTPSDEFVALUERULENAME = 31;
    private static final int INDEX_DSTPSDEID = 32;
    private static final int INDEX_DSTPSDELOGICID = 33;
    private static final int INDEX_DSTPSDELOGICNAME = 34;
    private static final int INDEX_DSTPSDEMAPID = 35;
    private static final int INDEX_DSTPSDEMAPNAME = 36;
    private static final int INDEX_DSTPSDENAME = 37;
    private static final int INDEX_DSTPSDENOTIFYID = 38;
    private static final int INDEX_DSTPSDENOTIFYNAME = 39;
    private static final int INDEX_DSTPSDEPRINTID = 40;
    private static final int INDEX_DSTPSDEPRINTNAME = 41;
    private static final int INDEX_DSTPSDEREPORTID = 42;
    private static final int INDEX_DSTPSDEREPORTNAME = 43;
    private static final int INDEX_DSTPSDESAMPLEDATAID = 44;
    private static final int INDEX_DSTPSDESAMPLEDATANAME = 45;
    private static final int INDEX_DSTPSDEUAGROUPID = 46;
    private static final int INDEX_DSTPSDEUAGROUPNAME = 47;
    private static final int INDEX_DSTPSDEUILOGICID = 48;
    private static final int INDEX_DSTPSDEUILOGICNAME = 49;
    private static final int INDEX_DSTPSDEVIEWID = 50;
    private static final int INDEX_DSTPSDEVIEWNAME = 51;
    private static final int INDEX_DSTPSDEVRGROUPID = 52;
    private static final int INDEX_DSTPSDEVRGROUPNAME = 53;
    private static final int INDEX_DSTPSDEWIZARDID = 54;
    private static final int INDEX_DSTPSDEWIZARDNAME = 55;
    private static final int INDEX_DSTPSDLPARAMID = 56;
    private static final int INDEX_DSTPSDLPARAMNAME = 57;
    private static final int INDEX_DSTSORTDIR = 58;
    private static final int INDEX_DYNAMODELFLAG = 59;
    private static final int INDEX_ISPSDLPARAMID = 60;
    private static final int INDEX_ISPSDLPARAMNAME = 61;
    private static final int INDEX_LEFTPOS = 62;
    private static final int INDEX_LOGICNODESUBTYPE = 63;
    private static final int INDEX_LOGICNODETYPE = 64;
    private static final int INDEX_MEMO = 65;
    private static final int INDEX_MSGPSLANRESID = 66;
    private static final int INDEX_MSGPSLANRESNAME = 67;
    private static final int INDEX_NODEPARAMS = 68;
    private static final int INDEX_OPTPSDLPARAMID = 69;
    private static final int INDEX_OPTPSDLPARAMNAME = 70;
    private static final int INDEX_ORDERVALUE = 71;
    private static final int INDEX_OSPSDLPARAMID = 72;
    private static final int INDEX_OSPSDLPARAMNAME = 73;
    private static final int INDEX_PARALLELOUTPUT = 74;
    private static final int INDEX_PARAM1 = 75;
    private static final int INDEX_PARAM10 = 76;
    private static final int INDEX_PARAM11 = 77;
    private static final int INDEX_PARAM12 = 78;
    private static final int INDEX_PARAM13 = 79;
    private static final int INDEX_PARAM14 = 80;
    private static final int INDEX_PARAM2 = 81;
    private static final int INDEX_PARAM3 = 82;
    private static final int INDEX_PARAM4 = 83;
    private static final int INDEX_PARAM5 = 84;
    private static final int INDEX_PARAM6 = 85;
    private static final int INDEX_PARAM7 = 86;
    private static final int INDEX_PARAM8 = 87;
    private static final int INDEX_PARAM9 = 88;
    private static final int INDEX_PSDEID = 89;
    private static final int INDEX_PSDELOGICID = 90;
    private static final int INDEX_PSDELOGICNAME = 91;
    private static final int INDEX_PSDELOGICNODEID = 92;
    private static final int INDEX_PSDELOGICNODENAME = 93;
    private static final int INDEX_PSDEMAINSTATEID = 94;
    private static final int INDEX_PSDEMAINSTATENAME = 95;
    private static final int INDEX_PSDEUIACTIONID = 96;
    private static final int INDEX_PSDEUIACTIONNAME = 97;
    private static final int INDEX_PSDYNAINSTID = 98;
    private static final int INDEX_PSSUBSYSSADETAILID = 99;
    private static final int INDEX_PSSUBSYSSADETAILNAME = 100;
    private static final int INDEX_PSSUBSYSSERVICEAPIID = 101;
    private static final int INDEX_PSSUBSYSSERVICEAPINAME = 102;
    private static final int INDEX_PSSYSAICHATAGENTID = 103;
    private static final int INDEX_PSSYSAICHATAGENTNAME = 104;
    private static final int INDEX_PSSYSAIFACTORYID = 105;
    private static final int INDEX_PSSYSAIFACTORYNAME = 106;
    private static final int INDEX_PSSYSAIPIPELINEAGENTID = 107;
    private static final int INDEX_PSSYSAIPIPELINEAGENTNAME = 108;
    private static final int INDEX_PSSYSAIWORKERAGENTID = 109;
    private static final int INDEX_PSSYSAIWORKERAGENTNAME = 110;
    private static final int INDEX_PSSYSBACKSERVICEID = 111;
    private static final int INDEX_PSSYSBACKSERVICENAME = 112;
    private static final int INDEX_PSSYSBDSCHEMEID = 113;
    private static final int INDEX_PSSYSBDSCHEMENAME = 114;
    private static final int INDEX_PSSYSBDTABLEID = 115;
    private static final int INDEX_PSSYSBDTABLENAME = 116;
    private static final int INDEX_PSSYSBIAGGTABLEID = 117;
    private static final int INDEX_PSSYSBIAGGTABLENAME = 118;
    private static final int INDEX_PSSYSBICUBEID = 119;
    private static final int INDEX_PSSYSBICUBENAME = 120;
    private static final int INDEX_PSSYSBIREPORTID = 121;
    private static final int INDEX_PSSYSBIREPORTNAME = 122;
    private static final int INDEX_PSSYSBISCHEMEID = 123;
    private static final int INDEX_PSSYSBISCHEMENAME = 124;
    private static final int INDEX_PSSYSDATASYNCAGENTID = 125;
    private static final int INDEX_PSSYSDATASYNCAGENTNAME = 126;
    private static final int INDEX_PSSYSDBSCHEMEID = 127;
    private static final int INDEX_PSSYSDBSCHEMENAME = 128;
    private static final int INDEX_PSSYSDBTABLEID = 129;
    private static final int INDEX_PSSYSDBTABLENAME = 130;
    private static final int INDEX_PSSYSDELOGICNODEID = 131;
    private static final int INDEX_PSSYSDELOGICNODENAME = 132;
    private static final int INDEX_PSSYSEAIELEMENTID = 133;
    private static final int INDEX_PSSYSEAIELEMENTNAME = 134;
    private static final int INDEX_PSSYSEAISCHEMEID = 135;
    private static final int INDEX_PSSYSEAISCHEMENAME = 136;
    private static final int INDEX_PSSYSMSGTEMPLID = 137;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 138;
    private static final int INDEX_PSSYSPFPLUGINID = 139;
    private static final int INDEX_PSSYSPFPLUGINNAME = 140;
    private static final int INDEX_PSSYSRESOURCEID = 141;
    private static final int INDEX_PSSYSRESOURCENAME = 142;
    private static final int INDEX_PSSYSSEARCHDOCID = 143;
    private static final int INDEX_PSSYSSEARCHDOCNAME = 144;
    private static final int INDEX_PSSYSSEARCHSCHEMEID = 145;
    private static final int INDEX_PSSYSSEARCHSCHEMENAME = 146;
    private static final int INDEX_PSSYSSFPLUGINID = 147;
    private static final int INDEX_PSSYSSFPLUGINNAME = 148;
    private static final int INDEX_PSSYSSQLCMDID = 149;
    private static final int INDEX_PSSYSSQLCMDNAME = 150;
    private static final int INDEX_PSSYSTEMID = 151;
    private static final int INDEX_PSSYSUNISTATEID = 152;
    private static final int INDEX_PSSYSUNISTATENAME = 153;
    private static final int INDEX_PSSYSUTILDEID = 154;
    private static final int INDEX_PSSYSUTILDENAME = 155;
    private static final int INDEX_PSVIEWMSGID = 156;
    private static final int INDEX_PSVIEWMSGNAME = 157;
    private static final int INDEX_PSWFDEID = 158;
    private static final int INDEX_PSWFDENAME = 159;
    private static final int INDEX_PSWORKFLOWID = 160;
    private static final int INDEX_PSWORKFLOWNAME = 161;
    private static final int INDEX_RETPSDLPARAMID = 162;
    private static final int INDEX_RETPSDLPARAMNAME = 163;
    private static final int INDEX_SHAPEPARAMS = 164;
    private static final int INDEX_SRCINDEX = 165;
    private static final int INDEX_SRCPSDLPARAMID = 166;
    private static final int INDEX_SRCPSDLPARAMNAME = 167;
    private static final int INDEX_SRCSIZE = 168;
    private static final int INDEX_THREADRUNMODE = 169;
    private static final int INDEX_THREADRUNTIMER = 170;
    private static final int INDEX_TOPPOS = 171;
    private static final int INDEX_TSMODE = 172;
    private static final int INDEX_UPDATEDATE = 173;
    private static final int INDEX_UPDATEMAN = 174;
    private static final int INDEX_USERCAT = 175;
    private static final int INDEX_USERPARAMS = 176;
    private static final int INDEX_USERTAG = 177;
    private static final int INDEX_USERTAG2 = 178;
    private static final int INDEX_USERTAG3 = 179;
    private static final int INDEX_USERTAG4 = 180;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELogicNodeBase proxyPSDELogicNodeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdstparamDirtyFlag = false;
    private boolean customsrcparamDirtyFlag = false;
    private boolean debugmodeDirtyFlag = false;
    private boolean dstpsdeutildeidDirtyFlag = false;
    private boolean dstpsdeutildenameDirtyFlag = false;
    private boolean dstindexDirtyFlag = false;
    private boolean dstparamactionDirtyFlag = false;
    private boolean dstpsdeactionidDirtyFlag = false;
    private boolean dstpsdeactionnameDirtyFlag = false;
    private boolean dstpsdedataexpidDirtyFlag = false;
    private boolean dstpsdedataexpnameDirtyFlag = false;
    private boolean dstpsdedataflowidDirtyFlag = false;
    private boolean dstpsdedataflownameDirtyFlag = false;
    private boolean dstpsdedataimpidDirtyFlag = false;
    private boolean dstpsdedataimpnameDirtyFlag = false;
    private boolean dstpsdedataqueryidDirtyFlag = false;
    private boolean dstpsdedataquerynameDirtyFlag = false;
    private boolean dstpsdedatasetidDirtyFlag = false;
    private boolean dstpsdedatasetnameDirtyFlag = false;
    private boolean dstpsdedatasyncidDirtyFlag = false;
    private boolean dstpsdedatasyncnameDirtyFlag = false;
    private boolean dstpsdedtsqueueidDirtyFlag = false;
    private boolean dstpsdedtsqueuenameDirtyFlag = false;
    private boolean dstpsdefgroupidDirtyFlag = false;
    private boolean dstpsdefgroupnameDirtyFlag = false;
    private boolean dstpsdeformidDirtyFlag = false;
    private boolean dstpsdeformnameDirtyFlag = false;
    private boolean dstpsdefvalueruleidDirtyFlag = false;
    private boolean dstpsdefvaluerulenameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean dstpsdelogicidDirtyFlag = false;
    private boolean dstpsdelogicnameDirtyFlag = false;
    private boolean dstpsdemapidDirtyFlag = false;
    private boolean dstpsdemapnameDirtyFlag = false;
    private boolean dstpsdenameDirtyFlag = false;
    private boolean dstpsdenotifyidDirtyFlag = false;
    private boolean dstpsdenotifynameDirtyFlag = false;
    private boolean dstpsdeprintidDirtyFlag = false;
    private boolean dstpsdeprintnameDirtyFlag = false;
    private boolean dstpsdereportidDirtyFlag = false;
    private boolean dstpsdereportnameDirtyFlag = false;
    private boolean dstpsdesampledataidDirtyFlag = false;
    private boolean dstpsdesampledatanameDirtyFlag = false;
    private boolean dstpsdeuagroupidDirtyFlag = false;
    private boolean dstpsdeuagroupnameDirtyFlag = false;
    private boolean dstpsdeuilogicidDirtyFlag = false;
    private boolean dstpsdeuilogicnameDirtyFlag = false;
    private boolean dstpsdeviewidDirtyFlag = false;
    private boolean dstpsdeviewnameDirtyFlag = false;
    private boolean dstpsdevrgroupidDirtyFlag = false;
    private boolean dstpsdevrgroupnameDirtyFlag = false;
    private boolean dstpsdewizardidDirtyFlag = false;
    private boolean dstpsdewizardnameDirtyFlag = false;
    private boolean dstpsdlparamidDirtyFlag = false;
    private boolean dstpsdlparamnameDirtyFlag = false;
    private boolean dstsortdirDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean ispsdlparamidDirtyFlag = false;
    private boolean ispsdlparamnameDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean logicnodesubtypeDirtyFlag = false;
    private boolean logicnodetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean msgpslanresidDirtyFlag = false;
    private boolean msgpslanresnameDirtyFlag = false;
    private boolean nodeparamsDirtyFlag = false;
    private boolean optpsdlparamidDirtyFlag = false;
    private boolean optpsdlparamnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ospsdlparamidDirtyFlag = false;
    private boolean ospsdlparamnameDirtyFlag = false;
    private boolean paralleloutputDirtyFlag = false;
    private boolean param1DirtyFlag = false;
    private boolean param10DirtyFlag = false;
    private boolean param11DirtyFlag = false;
    private boolean param12DirtyFlag = false;
    private boolean param13DirtyFlag = false;
    private boolean param14DirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean param9DirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdelogicnodeidDirtyFlag = false;
    private boolean psdelogicnodenameDirtyFlag = false;
    private boolean psdemainstateidDirtyFlag = false;
    private boolean psdemainstatenameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssubsyssadetailidDirtyFlag = false;
    private boolean pssubsyssadetailnameDirtyFlag = false;
    private boolean pssubsysserviceapiidDirtyFlag = false;
    private boolean pssubsysserviceapinameDirtyFlag = false;
    private boolean pssysaichatagentidDirtyFlag = false;
    private boolean pssysaichatagentnameDirtyFlag = false;
    private boolean pssysaifactoryidDirtyFlag = false;
    private boolean pssysaifactorynameDirtyFlag = false;
    private boolean pssysaipipelineagentidDirtyFlag = false;
    private boolean pssysaipipelineagentnameDirtyFlag = false;
    private boolean pssysaiworkeragentidDirtyFlag = false;
    private boolean pssysaiworkeragentnameDirtyFlag = false;
    private boolean pssysbackserviceidDirtyFlag = false;
    private boolean pssysbackservicenameDirtyFlag = false;
    private boolean pssysbdschemeidDirtyFlag = false;
    private boolean pssysbdschemenameDirtyFlag = false;
    private boolean pssysbdtableidDirtyFlag = false;
    private boolean pssysbdtablenameDirtyFlag = false;
    private boolean pssysbiaggtableidDirtyFlag = false;
    private boolean pssysbiaggtablenameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbireportidDirtyFlag = false;
    private boolean pssysbireportnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean pssysdatasyncagentidDirtyFlag = false;
    private boolean pssysdatasyncagentnameDirtyFlag = false;
    private boolean pssysdbschemeidDirtyFlag = false;
    private boolean pssysdbschemenameDirtyFlag = false;
    private boolean pssysdbtableidDirtyFlag = false;
    private boolean pssysdbtablenameDirtyFlag = false;
    private boolean pssysdelogicnodeidDirtyFlag = false;
    private boolean pssysdelogicnodenameDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssearchdocidDirtyFlag = false;
    private boolean pssyssearchdocnameDirtyFlag = false;
    private boolean pssyssearchschemeidDirtyFlag = false;
    private boolean pssyssearchschemenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssyssqlcmdidDirtyFlag = false;
    private boolean pssyssqlcmdnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysunistateidDirtyFlag = false;
    private boolean pssysunistatenameDirtyFlag = false;
    private boolean pssysutildeidDirtyFlag = false;
    private boolean pssysutildenameDirtyFlag = false;
    private boolean psviewmsgidDirtyFlag = false;
    private boolean psviewmsgnameDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean pswfdenameDirtyFlag = false;
    private boolean psworkflowidDirtyFlag = false;
    private boolean psworkflownameDirtyFlag = false;
    private boolean retpsdlparamidDirtyFlag = false;
    private boolean retpsdlparamnameDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean srcindexDirtyFlag = false;
    private boolean srcpsdlparamidDirtyFlag = false;
    private boolean srcpsdlparamnameDirtyFlag = false;
    private boolean srcsizeDirtyFlag = false;
    private boolean threadrunmodeDirtyFlag = false;
    private boolean threadruntimerDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean tsmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdstparam")
    private String customdstparam;
    @Column(name="customsrcparam")
    private String customsrcparam;
    @Column(name="debugmode")
    private Integer debugmode;
    @Column(name="dstpsdeutildeid")
    private String dstpsdeutildeid;
    @Column(name="dstpsdeutildename")
    private String dstpsdeutildename;
    @Column(name="dstindex")
    private Integer dstindex;
    @Column(name="dstparamaction")
    private String dstparamaction;
    @Column(name="dstpsdeactionid")
    private String dstpsdeactionid;
    @Column(name="dstpsdeactionname")
    private String dstpsdeactionname;
    @Column(name="dstpsdedataexpid")
    private String dstpsdedataexpid;
    @Column(name="dstpsdedataexpname")
    private String dstpsdedataexpname;
    @Column(name="dstpsdedataflowid")
    private String dstpsdedataflowid;
    @Column(name="dstpsdedataflowname")
    private String dstpsdedataflowname;
    @Column(name="dstpsdedataimpid")
    private String dstpsdedataimpid;
    @Column(name="dstpsdedataimpname")
    private String dstpsdedataimpname;
    @Column(name="dstpsdedataqueryid")
    private String dstpsdedataqueryid;
    @Column(name="dstpsdedataqueryname")
    private String dstpsdedataqueryname;
    @Column(name="dstpsdedatasetid")
    private String dstpsdedatasetid;
    @Column(name="dstpsdedatasetname")
    private String dstpsdedatasetname;
    @Column(name="dstpsdedatasyncid")
    private String dstpsdedatasyncid;
    @Column(name="dstpsdedatasyncname")
    private String dstpsdedatasyncname;
    @Column(name="dstpsdedtsqueueid")
    private String dstpsdedtsqueueid;
    @Column(name="dstpsdedtsqueuename")
    private String dstpsdedtsqueuename;
    @Column(name="dstpsdefgroupid")
    private String dstpsdefgroupid;
    @Column(name="dstpsdefgroupname")
    private String dstpsdefgroupname;
    @Column(name="dstpsdeformid")
    private String dstpsdeformid;
    @Column(name="dstpsdeformname")
    private String dstpsdeformname;
    @Column(name="dstpsdefvalueruleid")
    private String dstpsdefvalueruleid;
    @Column(name="dstpsdefvaluerulename")
    private String dstpsdefvaluerulename;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="dstpsdelogicid")
    private String dstpsdelogicid;
    @Column(name="dstpsdelogicname")
    private String dstpsdelogicname;
    @Column(name="dstpsdemapid")
    private String dstpsdemapid;
    @Column(name="dstpsdemapname")
    private String dstpsdemapname;
    @Column(name="dstpsdename")
    private String dstpsdename;
    @Column(name="dstpsdenotifyid")
    private String dstpsdenotifyid;
    @Column(name="dstpsdenotifyname")
    private String dstpsdenotifyname;
    @Column(name="dstpsdeprintid")
    private String dstpsdeprintid;
    @Column(name="dstpsdeprintname")
    private String dstpsdeprintname;
    @Column(name="dstpsdereportid")
    private String dstpsdereportid;
    @Column(name="dstpsdereportname")
    private String dstpsdereportname;
    @Column(name="dstpsdesampledataid")
    private String dstpsdesampledataid;
    @Column(name="dstpsdesampledataname")
    private String dstpsdesampledataname;
    @Column(name="dstpsdeuagroupid")
    private String dstpsdeuagroupid;
    @Column(name="dstpsdeuagroupname")
    private String dstpsdeuagroupname;
    @Column(name="dstpsdeuilogicid")
    private String dstpsdeuilogicid;
    @Column(name="dstpsdeuilogicname")
    private String dstpsdeuilogicname;
    @Column(name="dstpsdeviewid")
    private String dstpsdeviewid;
    @Column(name="dstpsdeviewname")
    private String dstpsdeviewname;
    @Column(name="dstpsdevrgroupid")
    private String dstpsdevrgroupid;
    @Column(name="dstpsdevrgroupname")
    private String dstpsdevrgroupname;
    @Column(name="dstpsdewizardid")
    private String dstpsdewizardid;
    @Column(name="dstpsdewizardname")
    private String dstpsdewizardname;
    @Column(name="dstpsdlparamid")
    private String dstpsdlparamid;
    @Column(name="dstpsdlparamname")
    private String dstpsdlparamname;
    @Column(name="dstsortdir")
    private String dstsortdir;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="ispsdlparamid")
    private String ispsdlparamid;
    @Column(name="ispsdlparamname")
    private String ispsdlparamname;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="logicnodesubtype")
    private String logicnodesubtype;
    @Column(name="logicnodetype")
    private String logicnodetype;
    @Column(name="memo")
    private String memo;
    @Column(name="msgpslanresid")
    private String msgpslanresid;
    @Column(name="msgpslanresname")
    private String msgpslanresname;
    @Column(name="nodeparams")
    private String nodeparams;
    @Column(name="optpsdlparamid")
    private String optpsdlparamid;
    @Column(name="optpsdlparamname")
    private String optpsdlparamname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ospsdlparamid")
    private String ospsdlparamid;
    @Column(name="ospsdlparamname")
    private String ospsdlparamname;
    @Column(name="paralleloutput")
    private Integer paralleloutput;
    @Column(name="param1")
    private String param1;
    @Column(name="param10")
    private Integer param10;
    @Column(name="param11")
    private String param11;
    @Column(name="param12")
    private String param12;
    @Column(name="param13")
    private String param13;
    @Column(name="param14")
    private String param14;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private String param5;
    @Column(name="param6")
    private String param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="param9")
    private Integer param9;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdelogicnodeid")
    private String psdelogicnodeid;
    @Column(name="psdelogicnodename")
    private String psdelogicnodename;
    @Column(name="psdemainstateid")
    private String psdemainstateid;
    @Column(name="psdemainstatename")
    private String psdemainstatename;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssubsyssadetailid")
    private String pssubsyssadetailid;
    @Column(name="pssubsyssadetailname")
    private String pssubsyssadetailname;
    @Column(name="pssubsysserviceapiid")
    private String pssubsysserviceapiid;
    @Column(name="pssubsysserviceapiname")
    private String pssubsysserviceapiname;
    @Column(name="pssysaichatagentid")
    private String pssysaichatagentid;
    @Column(name="pssysaichatagentname")
    private String pssysaichatagentname;
    @Column(name="pssysaifactoryid")
    private String pssysaifactoryid;
    @Column(name="pssysaifactoryname")
    private String pssysaifactoryname;
    @Column(name="pssysaipipelineagentid")
    private String pssysaipipelineagentid;
    @Column(name="pssysaipipelineagentname")
    private String pssysaipipelineagentname;
    @Column(name="pssysaiworkeragentid")
    private String pssysaiworkeragentid;
    @Column(name="pssysaiworkeragentname")
    private String pssysaiworkeragentname;
    @Column(name="pssysbackserviceid")
    private String pssysbackserviceid;
    @Column(name="pssysbackservicename")
    private String pssysbackservicename;
    @Column(name="pssysbdschemeid")
    private String pssysbdschemeid;
    @Column(name="pssysbdschemename")
    private String pssysbdschemename;
    @Column(name="pssysbdtableid")
    private String pssysbdtableid;
    @Column(name="pssysbdtablename")
    private String pssysbdtablename;
    @Column(name="pssysbiaggtableid")
    private String pssysbiaggtableid;
    @Column(name="pssysbiaggtablename")
    private String pssysbiaggtablename;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbireportid")
    private String pssysbireportid;
    @Column(name="pssysbireportname")
    private String pssysbireportname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="pssysdatasyncagentid")
    private String pssysdatasyncagentid;
    @Column(name="pssysdatasyncagentname")
    private String pssysdatasyncagentname;
    @Column(name="pssysdbschemeid")
    private String pssysdbschemeid;
    @Column(name="pssysdbschemename")
    private String pssysdbschemename;
    @Column(name="pssysdbtableid")
    private String pssysdbtableid;
    @Column(name="pssysdbtablename")
    private String pssysdbtablename;
    @Column(name="pssysdelogicnodeid")
    private String pssysdelogicnodeid;
    @Column(name="pssysdelogicnodename")
    private String pssysdelogicnodename;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementname")
    private String pssyseaielementname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssearchdocid")
    private String pssyssearchdocid;
    @Column(name="pssyssearchdocname")
    private String pssyssearchdocname;
    @Column(name="pssyssearchschemeid")
    private String pssyssearchschemeid;
    @Column(name="pssyssearchschemename")
    private String pssyssearchschemename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssyssqlcmdid")
    private String pssyssqlcmdid;
    @Column(name="pssyssqlcmdname")
    private String pssyssqlcmdname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysunistateid")
    private String pssysunistateid;
    @Column(name="pssysunistatename")
    private String pssysunistatename;
    @Column(name="pssysutildeid")
    private String pssysutildeid;
    @Column(name="pssysutildename")
    private String pssysutildename;
    @Column(name="psviewmsgid")
    private String psviewmsgid;
    @Column(name="psviewmsgname")
    private String psviewmsgname;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="pswfdename")
    private String pswfdename;
    @Column(name="psworkflowid")
    private String psworkflowid;
    @Column(name="psworkflowname")
    private String psworkflowname;
    @Column(name="retpsdlparamid")
    private String retpsdlparamid;
    @Column(name="retpsdlparamname")
    private String retpsdlparamname;
    @Column(name="shapeparams")
    private String shapeparams;
    @Column(name="srcindex")
    private Integer srcindex;
    @Column(name="srcpsdlparamid")
    private String srcpsdlparamid;
    @Column(name="srcpsdlparamname")
    private String srcpsdlparamname;
    @Column(name="srcsize")
    private Integer srcsize;
    @Column(name="threadrunmode")
    private Integer threadrunmode;
    @Column(name="threadruntimer")
    private Integer threadruntimer;
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="tsmode")
    private Integer tsmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objDstPSDELock = new Integer(1);
    private PSDataEntity dstpsde = null;
    private Integer objDstPSDEActionLock = new Integer(1);
    private PSDEAction dstpsdeaction = null;
    private Integer objDstPSDEDataExpLock = new Integer(1);
    private PSDEDataExp dstpsdedataexp = null;
    private Integer objDstPSDEDataImpLock = new Integer(1);
    private PSDEDataImp dstpsdedataimp = null;
    private Integer objDstPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery dstpsdedataquery = null;
    private Integer objDstPSDEDataSetLock = new Integer(1);
    private PSDEDataSet dstpsdedataset = null;
    private Integer objDstPSDEDataSyncLock = new Integer(1);
    private PSDEDataSync dstpsdedatasync = null;
    private Integer objDstPSDEDTSQueueLock = new Integer(1);
    private PSDEDTSQueue dstpsdedtsqueue = null;
    private Integer objDstPSDEFGroupLock = new Integer(1);
    private PSDEFGroup dstpsdefgroup = null;
    private Integer objDstPSDEFormLock = new Integer(1);
    private PSDEForm dstpsdeform = null;
    private Integer objDstPSDEFValueRuleLock = new Integer(1);
    private PSDEFValueRule dstpsdefvaluerule = null;
    private Integer objDstPSDLParamLock = new Integer(1);
    private PSDELogicParam dstpsdlparam = null;
    private Integer objISPSDLParamLock = new Integer(1);
    private PSDELogicParam ispsdlparam = null;
    private Integer objOptPSDLParamLock = new Integer(1);
    private PSDELogicParam optpsdlparam = null;
    private Integer objOSPSDLParamLock = new Integer(1);
    private PSDELogicParam ospsdlparam = null;
    private Integer objRetPSDLParamLock = new Integer(1);
    private PSDELogicParam retpsdlparam = null;
    private Integer objSrcPSDLParamLock = new Integer(1);
    private PSDELogicParam srcpsdlparam = null;
    private Integer objDstPSDEDataFlowLock = new Integer(1);
    private PSDELogic dstpsdedataflow = null;
    private Integer objDstPSDELogicLock = new Integer(1);
    private PSDELogic dstpsdelogic = null;
    private Integer objDstPSDEUILogicLock = new Integer(1);
    private PSDELogic dstpsdeuilogic = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDEMainStateLock = new Integer(1);
    private PSDEMainState psdemainstate = null;
    private Integer objDstPSDEMapLock = new Integer(1);
    private PSDEMap dstpsdemap = null;
    private Integer objDstPSDENotifyLock = new Integer(1);
    private PSDENotify dstpsdenotify = null;
    private Integer objDstPSDEPrintLock = new Integer(1);
    private PSDEPrint dstpsdeprint = null;
    private Integer objDstPSDEReportLock = new Integer(1);
    private PSDEReport dstpsdereport = null;
    private Integer objDstPSDESampleDataLock = new Integer(1);
    private PSDESampleData dstpsdesampledata = null;
    private Integer objDstPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup dstpsdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objDstPSDEUtilDELock = new Integer(1);
    private PSDEUtilDE dstpsdeutilde = null;
    private Integer objDstPSDEViewLock = new Integer(1);
    private PSDEViewBase dstpsdeview = null;
    private Integer objDstPSDEVRGroupLock = new Integer(1);
    private PSDEVRGroup dstpsdevrgroup = null;
    private Integer objDstPSDEWizardLock = new Integer(1);
    private PSDEWizard dstpsdewizard = null;
    private Integer objMsgPSLanResLock = new Integer(1);
    private PSLanguageRes msgpslanres = null;
    private Integer objPSSubSysSADetailLock = new Integer(1);
    private PSSubSysSADetail pssubsyssadetail = null;
    private Integer objPSSubSysServiceAPILock = new Integer(1);
    private PSSubSysServiceAPI pssubsysserviceapi = null;
    private Integer objPSSysAIChatAgentLock = new Integer(1);
    private PSSysAIChatAgent pssysaichatagent = null;
    private Integer objPSSysAIFactoryLock = new Integer(1);
    private PSSysAIFactory pssysaifactory = null;
    private Integer objPSSysAIPipelineAgentLock = new Integer(1);
    private PSSysAIPipelineAgent pssysaipipelineagent = null;
    private Integer objPSSysAIWorkerAgentLock = new Integer(1);
    private PSSysAIWorkerAgent pssysaiworkeragent = null;
    private Integer objPSSysBackServiceLock = new Integer(1);
    private PSSysBackService pssysbackservice = null;
    private Integer objPSSysBDSchemeLock = new Integer(1);
    private PSSysBDScheme pssysbdscheme = null;
    private Integer objPSSysBDTableLock = new Integer(1);
    private PSSysBDTable pssysbdtable = null;
    private Integer objPSSysBIAggTableLock = new Integer(1);
    private PSSysBIAggTable pssysbiaggtable = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysBIReportLock = new Integer(1);
    private PSSysBIReport pssysbireport = null;
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysDatasyncAgentLock = new Integer(1);
    private PSSysDataSyncAgent pssysdatasyncagent = null;
    private Integer objPSSysDBSchemeLock = new Integer(1);
    private PSSysDBScheme pssysdbscheme = null;
    private Integer objPSSysDBTableLock = new Integer(1);
    private PSSysDBTable pssysdbtable = null;
    private Integer objPSSysDELogicNodeLock = new Integer(1);
    private PSSysDELogicNode pssysdelogicnode = null;
    private Integer objPSSysEAIElementLock = new Integer(1);
    private PSSysEAIElement pssyseaielement = null;
    private Integer objPSSysEAISchemeLock = new Integer(1);
    private PSSysEAIScheme pssyseaischeme = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSearchDocLock = new Integer(1);
    private PSSysSearchDoc pssyssearchdoc = null;
    private Integer objPSSysSearchSchemeLock = new Integer(1);
    private PSSysSearchScheme pssyssearchscheme = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysSqlCmdLock = new Integer(1);
    private PSSysSQLCmd pssyssqlcmd = null;
    private Integer objPSSysUniStateLock = new Integer(1);
    private PSSysUniState pssysunistate = null;
    private Integer objPSSysUtilDELock = new Integer(1);
    private PSSysUtilDE pssysutilde = null;
    private Integer objPSViewMsgLock = new Integer(1);
    private PSViewMsg psviewmsg = null;
    private Integer objPSWFLock = new Integer(1);
    private PSWFDE pswf = null;
    private Integer objPSWorkflowLock = new Integer(1);
    private PSWorkflow psworkflow = null;
    private Integer objPSDELNParamsLock = new Integer(1);
    private ArrayList<PSDELNParam> psdelnparams = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
        this.createmanDirtyFlag = true;
    }

    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setCustomDSTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDSTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdstparam = string;
        this.customdstparamDirtyFlag = true;
    }

    public String getCustomDSTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDSTParam();
        }
        return this.customdstparam;
    }

    public boolean isCustomDSTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDSTParamDirty();
        }
        return this.customdstparamDirtyFlag;
    }

    public void resetCustomDSTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDSTParam();
            return;
        }
        this.customdstparamDirtyFlag = false;
        this.customdstparam = null;
    }

    public void setCustomSrcParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomSrcParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customsrcparam = string;
        this.customsrcparamDirtyFlag = true;
    }

    public String getCustomSrcParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomSrcParam();
        }
        return this.customsrcparam;
    }

    public boolean isCustomSrcParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomSrcParamDirty();
        }
        return this.customsrcparamDirtyFlag;
    }

    public void resetCustomSrcParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomSrcParam();
            return;
        }
        this.customsrcparamDirtyFlag = false;
        this.customsrcparam = null;
    }

    public void setDebugMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDebugMode(n);
            return;
        }
        this.debugmode = n;
        this.debugmodeDirtyFlag = true;
    }

    public Integer getDebugMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDebugMode();
        }
        return this.debugmode;
    }

    public boolean isDebugModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDebugModeDirty();
        }
        return this.debugmodeDirtyFlag;
    }

    public void resetDebugMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDebugMode();
            return;
        }
        this.debugmodeDirtyFlag = false;
        this.debugmode = null;
    }

    public void setDstPSDEUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeutildeid = string;
        this.dstpsdeutildeidDirtyFlag = true;
    }

    public String getDstPSDEUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUtilDEId();
        }
        return this.dstpsdeutildeid;
    }

    public boolean isDstPSDEUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUtilDEIdDirty();
        }
        return this.dstpsdeutildeidDirtyFlag;
    }

    public void resetDstPSDEUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUtilDEId();
            return;
        }
        this.dstpsdeutildeidDirtyFlag = false;
        this.dstpsdeutildeid = null;
    }

    public void setDstPSDEUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeutildename = string;
        this.dstpsdeutildenameDirtyFlag = true;
    }

    public String getDstPSDEUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUtilDEName();
        }
        return this.dstpsdeutildename;
    }

    public boolean isDstPSDEUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUtilDENameDirty();
        }
        return this.dstpsdeutildenameDirtyFlag;
    }

    public void resetDstPSDEUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUtilDEName();
            return;
        }
        this.dstpsdeutildenameDirtyFlag = false;
        this.dstpsdeutildename = null;
    }

    public void setDstIndex(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstIndex(n);
            return;
        }
        this.dstindex = n;
        this.dstindexDirtyFlag = true;
    }

    public Integer getDstIndex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstIndex();
        }
        return this.dstindex;
    }

    public boolean isDstIndexDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstIndexDirty();
        }
        return this.dstindexDirtyFlag;
    }

    public void resetDstIndex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstIndex();
            return;
        }
        this.dstindexDirtyFlag = false;
        this.dstindex = null;
    }

    public void setDstParamAction(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstParamAction(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstparamaction = string;
        this.dstparamactionDirtyFlag = true;
    }

    public String getDstParamAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstParamAction();
        }
        return this.dstparamaction;
    }

    public boolean isDstParamActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstParamActionDirty();
        }
        return this.dstparamactionDirtyFlag;
    }

    public void resetDstParamAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstParamAction();
            return;
        }
        this.dstparamactionDirtyFlag = false;
        this.dstparamaction = null;
    }

    public void setDstPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionid = string;
        this.dstpsdeactionidDirtyFlag = true;
    }

    public String getDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionId();
        }
        return this.dstpsdeactionid;
    }

    public boolean isDstPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionIdDirty();
        }
        return this.dstpsdeactionidDirtyFlag;
    }

    public void resetDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionId();
            return;
        }
        this.dstpsdeactionidDirtyFlag = false;
        this.dstpsdeactionid = null;
    }

    public void setDstPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionname = string;
        this.dstpsdeactionnameDirtyFlag = true;
    }

    public String getDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionName();
        }
        return this.dstpsdeactionname;
    }

    public boolean isDstPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionNameDirty();
        }
        return this.dstpsdeactionnameDirtyFlag;
    }

    public void resetDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionName();
            return;
        }
        this.dstpsdeactionnameDirtyFlag = false;
        this.dstpsdeactionname = null;
    }

    public void setDstPSDEDataExpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataExpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataexpid = string;
        this.dstpsdedataexpidDirtyFlag = true;
    }

    public String getDstPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataExpId();
        }
        return this.dstpsdedataexpid;
    }

    public boolean isDstPSDEDataExpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataExpIdDirty();
        }
        return this.dstpsdedataexpidDirtyFlag;
    }

    public void resetDstPSDEDataExpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataExpId();
            return;
        }
        this.dstpsdedataexpidDirtyFlag = false;
        this.dstpsdedataexpid = null;
    }

    public void setDstPSDEDataExpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataExpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataexpname = string;
        this.dstpsdedataexpnameDirtyFlag = true;
    }

    public String getDstPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataExpName();
        }
        return this.dstpsdedataexpname;
    }

    public boolean isDstPSDEDataExpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataExpNameDirty();
        }
        return this.dstpsdedataexpnameDirtyFlag;
    }

    public void resetDstPSDEDataExpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataExpName();
            return;
        }
        this.dstpsdedataexpnameDirtyFlag = false;
        this.dstpsdedataexpname = null;
    }

    public void setDstPSDEDataFlowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataFlowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataflowid = string;
        this.dstpsdedataflowidDirtyFlag = true;
    }

    public String getDstPSDEDataFlowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataFlowId();
        }
        return this.dstpsdedataflowid;
    }

    public boolean isDstPSDEDataFlowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataFlowIdDirty();
        }
        return this.dstpsdedataflowidDirtyFlag;
    }

    public void resetDstPSDEDataFlowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataFlowId();
            return;
        }
        this.dstpsdedataflowidDirtyFlag = false;
        this.dstpsdedataflowid = null;
    }

    public void setDstPSDEDataFlowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataFlowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataflowname = string;
        this.dstpsdedataflownameDirtyFlag = true;
    }

    public String getDstPSDEDataFlowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataFlowName();
        }
        return this.dstpsdedataflowname;
    }

    public boolean isDstPSDEDataFlowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataFlowNameDirty();
        }
        return this.dstpsdedataflownameDirtyFlag;
    }

    public void resetDstPSDEDataFlowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataFlowName();
            return;
        }
        this.dstpsdedataflownameDirtyFlag = false;
        this.dstpsdedataflowname = null;
    }

    public void setDstPSDEDataImpId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataImpId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataimpid = string;
        this.dstpsdedataimpidDirtyFlag = true;
    }

    public String getDstPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataImpId();
        }
        return this.dstpsdedataimpid;
    }

    public boolean isDstPSDEDataImpIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataImpIdDirty();
        }
        return this.dstpsdedataimpidDirtyFlag;
    }

    public void resetDstPSDEDataImpId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataImpId();
            return;
        }
        this.dstpsdedataimpidDirtyFlag = false;
        this.dstpsdedataimpid = null;
    }

    public void setDstPSDEDataImpName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataImpName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataimpname = string;
        this.dstpsdedataimpnameDirtyFlag = true;
    }

    public String getDstPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataImpName();
        }
        return this.dstpsdedataimpname;
    }

    public boolean isDstPSDEDataImpNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataImpNameDirty();
        }
        return this.dstpsdedataimpnameDirtyFlag;
    }

    public void resetDstPSDEDataImpName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataImpName();
            return;
        }
        this.dstpsdedataimpnameDirtyFlag = false;
        this.dstpsdedataimpname = null;
    }

    public void setDstPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryid = string;
        this.dstpsdedataqueryidDirtyFlag = true;
    }

    public String getDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryId();
        }
        return this.dstpsdedataqueryid;
    }

    public boolean isDstPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryIdDirty();
        }
        return this.dstpsdedataqueryidDirtyFlag;
    }

    public void resetDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryId();
            return;
        }
        this.dstpsdedataqueryidDirtyFlag = false;
        this.dstpsdedataqueryid = null;
    }

    public void setDstPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryname = string;
        this.dstpsdedataquerynameDirtyFlag = true;
    }

    public String getDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryName();
        }
        return this.dstpsdedataqueryname;
    }

    public boolean isDstPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryNameDirty();
        }
        return this.dstpsdedataquerynameDirtyFlag;
    }

    public void resetDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryName();
            return;
        }
        this.dstpsdedataquerynameDirtyFlag = false;
        this.dstpsdedataqueryname = null;
    }

    public void setDstPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetid = string;
        this.dstpsdedatasetidDirtyFlag = true;
    }

    public String getDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetId();
        }
        return this.dstpsdedatasetid;
    }

    public boolean isDstPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetIdDirty();
        }
        return this.dstpsdedatasetidDirtyFlag;
    }

    public void resetDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetId();
            return;
        }
        this.dstpsdedatasetidDirtyFlag = false;
        this.dstpsdedatasetid = null;
    }

    public void setDstPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetname = string;
        this.dstpsdedatasetnameDirtyFlag = true;
    }

    public String getDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetName();
        }
        return this.dstpsdedatasetname;
    }

    public boolean isDstPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetNameDirty();
        }
        return this.dstpsdedatasetnameDirtyFlag;
    }

    public void resetDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetName();
            return;
        }
        this.dstpsdedatasetnameDirtyFlag = false;
        this.dstpsdedatasetname = null;
    }

    public void setDstPSDEDataSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasyncid = string;
        this.dstpsdedatasyncidDirtyFlag = true;
    }

    public String getDstPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSyncId();
        }
        return this.dstpsdedatasyncid;
    }

    public boolean isDstPSDEDataSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSyncIdDirty();
        }
        return this.dstpsdedatasyncidDirtyFlag;
    }

    public void resetDstPSDEDataSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSyncId();
            return;
        }
        this.dstpsdedatasyncidDirtyFlag = false;
        this.dstpsdedatasyncid = null;
    }

    public void setDstPSDEDataSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasyncname = string;
        this.dstpsdedatasyncnameDirtyFlag = true;
    }

    public String getDstPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSyncName();
        }
        return this.dstpsdedatasyncname;
    }

    public boolean isDstPSDEDataSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSyncNameDirty();
        }
        return this.dstpsdedatasyncnameDirtyFlag;
    }

    public void resetDstPSDEDataSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSyncName();
            return;
        }
        this.dstpsdedatasyncnameDirtyFlag = false;
        this.dstpsdedatasyncname = null;
    }

    public void setDstPSDEDTSQueueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDTSQueueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedtsqueueid = string;
        this.dstpsdedtsqueueidDirtyFlag = true;
    }

    public String getDstPSDEDTSQueueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDTSQueueId();
        }
        return this.dstpsdedtsqueueid;
    }

    public boolean isDstPSDEDTSQueueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDTSQueueIdDirty();
        }
        return this.dstpsdedtsqueueidDirtyFlag;
    }

    public void resetDstPSDEDTSQueueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDTSQueueId();
            return;
        }
        this.dstpsdedtsqueueidDirtyFlag = false;
        this.dstpsdedtsqueueid = null;
    }

    public void setDstPSDEDTSQueueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDTSQueueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedtsqueuename = string;
        this.dstpsdedtsqueuenameDirtyFlag = true;
    }

    public String getDstPSDEDTSQueueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDTSQueueName();
        }
        return this.dstpsdedtsqueuename;
    }

    public boolean isDstPSDEDTSQueueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDTSQueueNameDirty();
        }
        return this.dstpsdedtsqueuenameDirtyFlag;
    }

    public void resetDstPSDEDTSQueueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDTSQueueName();
            return;
        }
        this.dstpsdedtsqueuenameDirtyFlag = false;
        this.dstpsdedtsqueuename = null;
    }

    public void setDstPSDEFGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefgroupid = string;
        this.dstpsdefgroupidDirtyFlag = true;
    }

    public String getDstPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFGroupId();
        }
        return this.dstpsdefgroupid;
    }

    public boolean isDstPSDEFGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFGroupIdDirty();
        }
        return this.dstpsdefgroupidDirtyFlag;
    }

    public void resetDstPSDEFGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFGroupId();
            return;
        }
        this.dstpsdefgroupidDirtyFlag = false;
        this.dstpsdefgroupid = null;
    }

    public void setDstPSDEFGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefgroupname = string;
        this.dstpsdefgroupnameDirtyFlag = true;
    }

    public String getDstPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFGroupName();
        }
        return this.dstpsdefgroupname;
    }

    public boolean isDstPSDEFGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFGroupNameDirty();
        }
        return this.dstpsdefgroupnameDirtyFlag;
    }

    public void resetDstPSDEFGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFGroupName();
            return;
        }
        this.dstpsdefgroupnameDirtyFlag = false;
        this.dstpsdefgroupname = null;
    }

    public void setDstPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeformid = string;
        this.dstpsdeformidDirtyFlag = true;
    }

    public String getDstPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFormId();
        }
        return this.dstpsdeformid;
    }

    public boolean isDstPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFormIdDirty();
        }
        return this.dstpsdeformidDirtyFlag;
    }

    public void resetDstPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFormId();
            return;
        }
        this.dstpsdeformidDirtyFlag = false;
        this.dstpsdeformid = null;
    }

    public void setDstPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeformname = string;
        this.dstpsdeformnameDirtyFlag = true;
    }

    public String getDstPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFormName();
        }
        return this.dstpsdeformname;
    }

    public boolean isDstPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFormNameDirty();
        }
        return this.dstpsdeformnameDirtyFlag;
    }

    public void resetDstPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFormName();
            return;
        }
        this.dstpsdeformnameDirtyFlag = false;
        this.dstpsdeformname = null;
    }

    public void setDstPSDEFValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefvalueruleid = string;
        this.dstpsdefvalueruleidDirtyFlag = true;
    }

    public String getDstPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFValueRuleId();
        }
        return this.dstpsdefvalueruleid;
    }

    public boolean isDstPSDEFValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFValueRuleIdDirty();
        }
        return this.dstpsdefvalueruleidDirtyFlag;
    }

    public void resetDstPSDEFValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFValueRuleId();
            return;
        }
        this.dstpsdefvalueruleidDirtyFlag = false;
        this.dstpsdefvalueruleid = null;
    }

    public void setDstPSDEFValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefvaluerulename = string;
        this.dstpsdefvaluerulenameDirtyFlag = true;
    }

    public String getDstPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFValueRuleName();
        }
        return this.dstpsdefvaluerulename;
    }

    public boolean isDstPSDEFValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFValueRuleNameDirty();
        }
        return this.dstpsdefvaluerulenameDirtyFlag;
    }

    public void resetDstPSDEFValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFValueRuleName();
            return;
        }
        this.dstpsdefvaluerulenameDirtyFlag = false;
        this.dstpsdefvaluerulename = null;
    }

    public void setDstPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDstPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDstPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDstPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setDstPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicid = string;
        this.dstpsdelogicidDirtyFlag = true;
    }

    public String getDstPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicId();
        }
        return this.dstpsdelogicid;
    }

    public boolean isDstPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicIdDirty();
        }
        return this.dstpsdelogicidDirtyFlag;
    }

    public void resetDstPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicId();
            return;
        }
        this.dstpsdelogicidDirtyFlag = false;
        this.dstpsdelogicid = null;
    }

    public void setDstPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicname = string;
        this.dstpsdelogicnameDirtyFlag = true;
    }

    public String getDstPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicName();
        }
        return this.dstpsdelogicname;
    }

    public boolean isDstPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicNameDirty();
        }
        return this.dstpsdelogicnameDirtyFlag;
    }

    public void resetDstPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicName();
            return;
        }
        this.dstpsdelogicnameDirtyFlag = false;
        this.dstpsdelogicname = null;
    }

    public void setDstPSDEMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdemapid = string;
        this.dstpsdemapidDirtyFlag = true;
    }

    public String getDstPSDEMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEMapId();
        }
        return this.dstpsdemapid;
    }

    public boolean isDstPSDEMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEMapIdDirty();
        }
        return this.dstpsdemapidDirtyFlag;
    }

    public void resetDstPSDEMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEMapId();
            return;
        }
        this.dstpsdemapidDirtyFlag = false;
        this.dstpsdemapid = null;
    }

    public void setDstPSDEMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdemapname = string;
        this.dstpsdemapnameDirtyFlag = true;
    }

    public String getDstPSDEMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEMapName();
        }
        return this.dstpsdemapname;
    }

    public boolean isDstPSDEMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEMapNameDirty();
        }
        return this.dstpsdemapnameDirtyFlag;
    }

    public void resetDstPSDEMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEMapName();
            return;
        }
        this.dstpsdemapnameDirtyFlag = false;
        this.dstpsdemapname = null;
    }

    public void setDstPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdename = string;
        this.dstpsdenameDirtyFlag = true;
    }

    public String getDstPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEName();
        }
        return this.dstpsdename;
    }

    public boolean isDstPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDENameDirty();
        }
        return this.dstpsdenameDirtyFlag;
    }

    public void resetDstPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEName();
            return;
        }
        this.dstpsdenameDirtyFlag = false;
        this.dstpsdename = null;
    }

    public void setDstPSDENotifyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDENotifyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdenotifyid = string;
        this.dstpsdenotifyidDirtyFlag = true;
    }

    public String getDstPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDENotifyId();
        }
        return this.dstpsdenotifyid;
    }

    public boolean isDstPSDENotifyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDENotifyIdDirty();
        }
        return this.dstpsdenotifyidDirtyFlag;
    }

    public void resetDstPSDENotifyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDENotifyId();
            return;
        }
        this.dstpsdenotifyidDirtyFlag = false;
        this.dstpsdenotifyid = null;
    }

    public void setDstPSDENotifyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDENotifyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdenotifyname = string;
        this.dstpsdenotifynameDirtyFlag = true;
    }

    public String getDstPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDENotifyName();
        }
        return this.dstpsdenotifyname;
    }

    public boolean isDstPSDENotifyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDENotifyNameDirty();
        }
        return this.dstpsdenotifynameDirtyFlag;
    }

    public void resetDstPSDENotifyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDENotifyName();
            return;
        }
        this.dstpsdenotifynameDirtyFlag = false;
        this.dstpsdenotifyname = null;
    }

    public void setDstPSDEPrintId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEPrintId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeprintid = string;
        this.dstpsdeprintidDirtyFlag = true;
    }

    public String getDstPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEPrintId();
        }
        return this.dstpsdeprintid;
    }

    public boolean isDstPSDEPrintIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEPrintIdDirty();
        }
        return this.dstpsdeprintidDirtyFlag;
    }

    public void resetDstPSDEPrintId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEPrintId();
            return;
        }
        this.dstpsdeprintidDirtyFlag = false;
        this.dstpsdeprintid = null;
    }

    public void setDstPSDEPrintName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEPrintName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeprintname = string;
        this.dstpsdeprintnameDirtyFlag = true;
    }

    public String getDstPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEPrintName();
        }
        return this.dstpsdeprintname;
    }

    public boolean isDstPSDEPrintNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEPrintNameDirty();
        }
        return this.dstpsdeprintnameDirtyFlag;
    }

    public void resetDstPSDEPrintName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEPrintName();
            return;
        }
        this.dstpsdeprintnameDirtyFlag = false;
        this.dstpsdeprintname = null;
    }

    public void setDstPSDEReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdereportid = string;
        this.dstpsdereportidDirtyFlag = true;
    }

    public String getDstPSDEReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEReportId();
        }
        return this.dstpsdereportid;
    }

    public boolean isDstPSDEReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEReportIdDirty();
        }
        return this.dstpsdereportidDirtyFlag;
    }

    public void resetDstPSDEReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEReportId();
            return;
        }
        this.dstpsdereportidDirtyFlag = false;
        this.dstpsdereportid = null;
    }

    public void setDstPSDEReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdereportname = string;
        this.dstpsdereportnameDirtyFlag = true;
    }

    public String getDstPSDEReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEReportName();
        }
        return this.dstpsdereportname;
    }

    public boolean isDstPSDEReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEReportNameDirty();
        }
        return this.dstpsdereportnameDirtyFlag;
    }

    public void resetDstPSDEReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEReportName();
            return;
        }
        this.dstpsdereportnameDirtyFlag = false;
        this.dstpsdereportname = null;
    }

    public void setDstPSDESampleDataId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDESampleDataId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdesampledataid = string;
        this.dstpsdesampledataidDirtyFlag = true;
    }

    public String getDstPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDESampleDataId();
        }
        return this.dstpsdesampledataid;
    }

    public boolean isDstPSDESampleDataIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDESampleDataIdDirty();
        }
        return this.dstpsdesampledataidDirtyFlag;
    }

    public void resetDstPSDESampleDataId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDESampleDataId();
            return;
        }
        this.dstpsdesampledataidDirtyFlag = false;
        this.dstpsdesampledataid = null;
    }

    public void setDstPSDESampleDataName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDESampleDataName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdesampledataname = string;
        this.dstpsdesampledatanameDirtyFlag = true;
    }

    public String getDstPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDESampleDataName();
        }
        return this.dstpsdesampledataname;
    }

    public boolean isDstPSDESampleDataNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDESampleDataNameDirty();
        }
        return this.dstpsdesampledatanameDirtyFlag;
    }

    public void resetDstPSDESampleDataName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDESampleDataName();
            return;
        }
        this.dstpsdesampledatanameDirtyFlag = false;
        this.dstpsdesampledataname = null;
    }

    public void setDstPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeuagroupid = string;
        this.dstpsdeuagroupidDirtyFlag = true;
    }

    public String getDstPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUAGroupId();
        }
        return this.dstpsdeuagroupid;
    }

    public boolean isDstPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUAGroupIdDirty();
        }
        return this.dstpsdeuagroupidDirtyFlag;
    }

    public void resetDstPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUAGroupId();
            return;
        }
        this.dstpsdeuagroupidDirtyFlag = false;
        this.dstpsdeuagroupid = null;
    }

    public void setDstPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeuagroupname = string;
        this.dstpsdeuagroupnameDirtyFlag = true;
    }

    public String getDstPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUAGroupName();
        }
        return this.dstpsdeuagroupname;
    }

    public boolean isDstPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUAGroupNameDirty();
        }
        return this.dstpsdeuagroupnameDirtyFlag;
    }

    public void resetDstPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUAGroupName();
            return;
        }
        this.dstpsdeuagroupnameDirtyFlag = false;
        this.dstpsdeuagroupname = null;
    }

    public void setDstPSDEUILogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUILogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeuilogicid = string;
        this.dstpsdeuilogicidDirtyFlag = true;
    }

    public String getDstPSDEUILogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUILogicId();
        }
        return this.dstpsdeuilogicid;
    }

    public boolean isDstPSDEUILogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUILogicIdDirty();
        }
        return this.dstpsdeuilogicidDirtyFlag;
    }

    public void resetDstPSDEUILogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUILogicId();
            return;
        }
        this.dstpsdeuilogicidDirtyFlag = false;
        this.dstpsdeuilogicid = null;
    }

    public void setDstPSDEUILogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEUILogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeuilogicname = string;
        this.dstpsdeuilogicnameDirtyFlag = true;
    }

    public String getDstPSDEUILogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUILogicName();
        }
        return this.dstpsdeuilogicname;
    }

    public boolean isDstPSDEUILogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEUILogicNameDirty();
        }
        return this.dstpsdeuilogicnameDirtyFlag;
    }

    public void resetDstPSDEUILogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEUILogicName();
            return;
        }
        this.dstpsdeuilogicnameDirtyFlag = false;
        this.dstpsdeuilogicname = null;
    }

    public void setDstPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeviewid = string;
        this.dstpsdeviewidDirtyFlag = true;
    }

    public String getDstPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEViewId();
        }
        return this.dstpsdeviewid;
    }

    public boolean isDstPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEViewIdDirty();
        }
        return this.dstpsdeviewidDirtyFlag;
    }

    public void resetDstPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEViewId();
            return;
        }
        this.dstpsdeviewidDirtyFlag = false;
        this.dstpsdeviewid = null;
    }

    public void setDstPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeviewname = string;
        this.dstpsdeviewnameDirtyFlag = true;
    }

    public String getDstPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEViewName();
        }
        return this.dstpsdeviewname;
    }

    public boolean isDstPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEViewNameDirty();
        }
        return this.dstpsdeviewnameDirtyFlag;
    }

    public void resetDstPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEViewName();
            return;
        }
        this.dstpsdeviewnameDirtyFlag = false;
        this.dstpsdeviewname = null;
    }

    public void setDstPSDEVRGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEVRGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevrgroupid = string;
        this.dstpsdevrgroupidDirtyFlag = true;
    }

    public String getDstPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEVRGroupId();
        }
        return this.dstpsdevrgroupid;
    }

    public boolean isDstPSDEVRGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEVRGroupIdDirty();
        }
        return this.dstpsdevrgroupidDirtyFlag;
    }

    public void resetDstPSDEVRGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEVRGroupId();
            return;
        }
        this.dstpsdevrgroupidDirtyFlag = false;
        this.dstpsdevrgroupid = null;
    }

    public void setDstPSDEVRGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEVRGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdevrgroupname = string;
        this.dstpsdevrgroupnameDirtyFlag = true;
    }

    public String getDstPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEVRGroupName();
        }
        return this.dstpsdevrgroupname;
    }

    public boolean isDstPSDEVRGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEVRGroupNameDirty();
        }
        return this.dstpsdevrgroupnameDirtyFlag;
    }

    public void resetDstPSDEVRGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEVRGroupName();
            return;
        }
        this.dstpsdevrgroupnameDirtyFlag = false;
        this.dstpsdevrgroupname = null;
    }

    public void setDstPSDEWizardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEWizardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdewizardid = string;
        this.dstpsdewizardidDirtyFlag = true;
    }

    public String getDstPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEWizardId();
        }
        return this.dstpsdewizardid;
    }

    public boolean isDstPSDEWizardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEWizardIdDirty();
        }
        return this.dstpsdewizardidDirtyFlag;
    }

    public void resetDstPSDEWizardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEWizardId();
            return;
        }
        this.dstpsdewizardidDirtyFlag = false;
        this.dstpsdewizardid = null;
    }

    public void setDstPSDEWizardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEWizardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdewizardname = string;
        this.dstpsdewizardnameDirtyFlag = true;
    }

    public String getDstPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEWizardName();
        }
        return this.dstpsdewizardname;
    }

    public boolean isDstPSDEWizardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEWizardNameDirty();
        }
        return this.dstpsdewizardnameDirtyFlag;
    }

    public void resetDstPSDEWizardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEWizardName();
            return;
        }
        this.dstpsdewizardnameDirtyFlag = false;
        this.dstpsdewizardname = null;
    }

    public void setDstPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdlparamid = string;
        this.dstpsdlparamidDirtyFlag = true;
    }

    public String getDstPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParamId();
        }
        return this.dstpsdlparamid;
    }

    public boolean isDstPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDLParamIdDirty();
        }
        return this.dstpsdlparamidDirtyFlag;
    }

    public void resetDstPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDLParamId();
            return;
        }
        this.dstpsdlparamidDirtyFlag = false;
        this.dstpsdlparamid = null;
    }

    public void setDstPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdlparamname = string;
        this.dstpsdlparamnameDirtyFlag = true;
    }

    public String getDstPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParamName();
        }
        return this.dstpsdlparamname;
    }

    public boolean isDstPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDLParamNameDirty();
        }
        return this.dstpsdlparamnameDirtyFlag;
    }

    public void resetDstPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDLParamName();
            return;
        }
        this.dstpsdlparamnameDirtyFlag = false;
        this.dstpsdlparamname = null;
    }

    public void setDstSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstsortdir = string;
        this.dstsortdirDirtyFlag = true;
    }

    public String getDstSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstSortDir();
        }
        return this.dstsortdir;
    }

    public boolean isDstSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstSortDirDirty();
        }
        return this.dstsortdirDirtyFlag;
    }

    public void resetDstSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstSortDir();
            return;
        }
        this.dstsortdirDirtyFlag = false;
        this.dstsortdir = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setISPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setISPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ispsdlparamid = string;
        this.ispsdlparamidDirtyFlag = true;
    }

    public String getISPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getISPSDLParamId();
        }
        return this.ispsdlparamid;
    }

    public boolean isISPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isISPSDLParamIdDirty();
        }
        return this.ispsdlparamidDirtyFlag;
    }

    public void resetISPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetISPSDLParamId();
            return;
        }
        this.ispsdlparamidDirtyFlag = false;
        this.ispsdlparamid = null;
    }

    public void setISPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setISPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ispsdlparamname = string;
        this.ispsdlparamnameDirtyFlag = true;
    }

    public String getISPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getISPSDLParamName();
        }
        return this.ispsdlparamname;
    }

    public boolean isISPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isISPSDLParamNameDirty();
        }
        return this.ispsdlparamnameDirtyFlag;
    }

    public void resetISPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetISPSDLParamName();
            return;
        }
        this.ispsdlparamnameDirtyFlag = false;
        this.ispsdlparamname = null;
    }

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
    }

    public void setLogicNodeSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicNodeSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicnodesubtype = string;
        this.logicnodesubtypeDirtyFlag = true;
    }

    public String getLogicNodeSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicNodeSubType();
        }
        return this.logicnodesubtype;
    }

    public boolean isLogicNodeSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNodeSubTypeDirty();
        }
        return this.logicnodesubtypeDirtyFlag;
    }

    public void resetLogicNodeSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicNodeSubType();
            return;
        }
        this.logicnodesubtypeDirtyFlag = false;
        this.logicnodesubtype = null;
    }

    public void setLogicNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicnodetype = string;
        this.logicnodetypeDirtyFlag = true;
    }

    public String getLogicNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicNodeType();
        }
        return this.logicnodetype;
    }

    public boolean isLogicNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNodeTypeDirty();
        }
        return this.logicnodetypeDirtyFlag;
    }

    public void resetLogicNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicNodeType();
            return;
        }
        this.logicnodetypeDirtyFlag = false;
        this.logicnodetype = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
        this.memoDirtyFlag = true;
    }

    public String getMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    public boolean isMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    public void resetMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMemo();
            return;
        }
        this.memoDirtyFlag = false;
        this.memo = null;
    }

    public void setMsgPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpslanresid = string;
        this.msgpslanresidDirtyFlag = true;
    }

    public String getMsgPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPSLanResId();
        }
        return this.msgpslanresid;
    }

    public boolean isMsgPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPSLanResIdDirty();
        }
        return this.msgpslanresidDirtyFlag;
    }

    public void resetMsgPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPSLanResId();
            return;
        }
        this.msgpslanresidDirtyFlag = false;
        this.msgpslanresid = null;
    }

    public void setMsgPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.msgpslanresname = string;
        this.msgpslanresnameDirtyFlag = true;
    }

    public String getMsgPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPSLanResName();
        }
        return this.msgpslanresname;
    }

    public boolean isMsgPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgPSLanResNameDirty();
        }
        return this.msgpslanresnameDirtyFlag;
    }

    public void resetMsgPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgPSLanResName();
            return;
        }
        this.msgpslanresnameDirtyFlag = false;
        this.msgpslanresname = null;
    }

    public void setNodeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodeparams = string;
        this.nodeparamsDirtyFlag = true;
    }

    public String getNodeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeParams();
        }
        return this.nodeparams;
    }

    public boolean isNodeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeParamsDirty();
        }
        return this.nodeparamsDirtyFlag;
    }

    public void resetNodeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeParams();
            return;
        }
        this.nodeparamsDirtyFlag = false;
        this.nodeparams = null;
    }

    public void setOptPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOptPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.optpsdlparamid = string;
        this.optpsdlparamidDirtyFlag = true;
    }

    public String getOptPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOptPSDLParamId();
        }
        return this.optpsdlparamid;
    }

    public boolean isOptPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOptPSDLParamIdDirty();
        }
        return this.optpsdlparamidDirtyFlag;
    }

    public void resetOptPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOptPSDLParamId();
            return;
        }
        this.optpsdlparamidDirtyFlag = false;
        this.optpsdlparamid = null;
    }

    public void setOptPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOptPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.optpsdlparamname = string;
        this.optpsdlparamnameDirtyFlag = true;
    }

    public String getOptPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOptPSDLParamName();
        }
        return this.optpsdlparamname;
    }

    public boolean isOptPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOptPSDLParamNameDirty();
        }
        return this.optpsdlparamnameDirtyFlag;
    }

    public void resetOptPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOptPSDLParamName();
            return;
        }
        this.optpsdlparamnameDirtyFlag = false;
        this.optpsdlparamname = null;
    }

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setOSPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ospsdlparamid = string;
        this.ospsdlparamidDirtyFlag = true;
    }

    public String getOSPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSPSDLParamId();
        }
        return this.ospsdlparamid;
    }

    public boolean isOSPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSPSDLParamIdDirty();
        }
        return this.ospsdlparamidDirtyFlag;
    }

    public void resetOSPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSPSDLParamId();
            return;
        }
        this.ospsdlparamidDirtyFlag = false;
        this.ospsdlparamid = null;
    }

    public void setOSPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ospsdlparamname = string;
        this.ospsdlparamnameDirtyFlag = true;
    }

    public String getOSPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSPSDLParamName();
        }
        return this.ospsdlparamname;
    }

    public boolean isOSPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSPSDLParamNameDirty();
        }
        return this.ospsdlparamnameDirtyFlag;
    }

    public void resetOSPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSPSDLParamName();
            return;
        }
        this.ospsdlparamnameDirtyFlag = false;
        this.ospsdlparamname = null;
    }

    public void setParallelOutput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParallelOutput(n);
            return;
        }
        this.paralleloutput = n;
        this.paralleloutputDirtyFlag = true;
    }

    public Integer getParallelOutput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParallelOutput();
        }
        return this.paralleloutput;
    }

    public boolean isParallelOutputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParallelOutputDirty();
        }
        return this.paralleloutputDirtyFlag;
    }

    public void resetParallelOutput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParallelOutput();
            return;
        }
        this.paralleloutputDirtyFlag = false;
        this.paralleloutput = null;
    }

    public void setParam1(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam1(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param1 = string;
        this.param1DirtyFlag = true;
    }

    public String getParam1() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam1();
        }
        return this.param1;
    }

    public boolean isParam1Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam1Dirty();
        }
        return this.param1DirtyFlag;
    }

    public void resetParam1() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam1();
            return;
        }
        this.param1DirtyFlag = false;
        this.param1 = null;
    }

    public void setParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam10(n);
            return;
        }
        this.param10 = n;
        this.param10DirtyFlag = true;
    }

    public Integer getParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam10();
        }
        return this.param10;
    }

    public boolean isParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam10Dirty();
        }
        return this.param10DirtyFlag;
    }

    public void resetParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam10();
            return;
        }
        this.param10DirtyFlag = false;
        this.param10 = null;
    }

    public void setParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param11 = string;
        this.param11DirtyFlag = true;
    }

    public String getParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam11();
        }
        return this.param11;
    }

    public boolean isParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam11Dirty();
        }
        return this.param11DirtyFlag;
    }

    public void resetParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam11();
            return;
        }
        this.param11DirtyFlag = false;
        this.param11 = null;
    }

    public void setParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param12 = string;
        this.param12DirtyFlag = true;
    }

    public String getParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam12();
        }
        return this.param12;
    }

    public boolean isParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam12Dirty();
        }
        return this.param12DirtyFlag;
    }

    public void resetParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam12();
            return;
        }
        this.param12DirtyFlag = false;
        this.param12 = null;
    }

    public void setParam13(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam13(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param13 = string;
        this.param13DirtyFlag = true;
    }

    public String getParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam13();
        }
        return this.param13;
    }

    public boolean isParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam13Dirty();
        }
        return this.param13DirtyFlag;
    }

    public void resetParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam13();
            return;
        }
        this.param13DirtyFlag = false;
        this.param13 = null;
    }

    public void setParam14(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam14(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param14 = string;
        this.param14DirtyFlag = true;
    }

    public String getParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam14();
        }
        return this.param14;
    }

    public boolean isParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam14Dirty();
        }
        return this.param14DirtyFlag;
    }

    public void resetParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam14();
            return;
        }
        this.param14DirtyFlag = false;
        this.param14 = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param5 = string;
        this.param5DirtyFlag = true;
    }

    public String getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param6 = string;
        this.param6DirtyFlag = true;
    }

    public String getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam9(n);
            return;
        }
        this.param9 = n;
        this.param9DirtyFlag = true;
    }

    public Integer getParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam9();
        }
        return this.param9;
    }

    public boolean isParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam9Dirty();
        }
        return this.param9DirtyFlag;
    }

    public void resetParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam9();
            return;
        }
        this.param9DirtyFlag = false;
        this.param9 = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
    }

    public void setPSDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodeid = string;
        this.psdelogicnodeidDirtyFlag = true;
    }

    public String getPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeId();
        }
        return this.psdelogicnodeid;
    }

    public boolean isPSDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeIdDirty();
        }
        return this.psdelogicnodeidDirtyFlag;
    }

    public void resetPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeId();
            return;
        }
        this.psdelogicnodeidDirtyFlag = false;
        this.psdelogicnodeid = null;
    }

    public void setPSDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodename = string;
        this.psdelogicnodenameDirtyFlag = true;
    }

    public String getPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeName();
        }
        return this.psdelogicnodename;
    }

    public boolean isPSDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeNameDirty();
        }
        return this.psdelogicnodenameDirtyFlag;
    }

    public void resetPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeName();
            return;
        }
        this.psdelogicnodenameDirtyFlag = false;
        this.psdelogicnodename = null;
    }

    public void setPSDEMainStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstateid = string;
        this.psdemainstateidDirtyFlag = true;
    }

    public String getPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateId();
        }
        return this.psdemainstateid;
    }

    public boolean isPSDEMainStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateIdDirty();
        }
        return this.psdemainstateidDirtyFlag;
    }

    public void resetPSDEMainStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateId();
            return;
        }
        this.psdemainstateidDirtyFlag = false;
        this.psdemainstateid = null;
    }

    public void setPSDEMainStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMainStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemainstatename = string;
        this.psdemainstatenameDirtyFlag = true;
    }

    public String getPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainStateName();
        }
        return this.psdemainstatename;
    }

    public boolean isPSDEMainStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMainStateNameDirty();
        }
        return this.psdemainstatenameDirtyFlag;
    }

    public void resetPSDEMainStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMainStateName();
            return;
        }
        this.psdemainstatenameDirtyFlag = false;
        this.psdemainstatename = null;
    }

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSSubSysSADetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailid = string;
        this.pssubsyssadetailidDirtyFlag = true;
    }

    public String getPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailId();
        }
        return this.pssubsyssadetailid;
    }

    public boolean isPSSubSysSADetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailIdDirty();
        }
        return this.pssubsyssadetailidDirtyFlag;
    }

    public void resetPSSubSysSADetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailId();
            return;
        }
        this.pssubsyssadetailidDirtyFlag = false;
        this.pssubsyssadetailid = null;
    }

    public void setPSSubSysSADetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysSADetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsyssadetailname = string;
        this.pssubsyssadetailnameDirtyFlag = true;
    }

    public String getPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetailName();
        }
        return this.pssubsyssadetailname;
    }

    public boolean isPSSubSysSADetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysSADetailNameDirty();
        }
        return this.pssubsyssadetailnameDirtyFlag;
    }

    public void resetPSSubSysSADetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysSADetailName();
            return;
        }
        this.pssubsyssadetailnameDirtyFlag = false;
        this.pssubsyssadetailname = null;
    }

    public void setPSSubSysServiceAPIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiid = string;
        this.pssubsysserviceapiidDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIId();
        }
        return this.pssubsysserviceapiid;
    }

    public boolean isPSSubSysServiceAPIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPIIdDirty();
        }
        return this.pssubsysserviceapiidDirtyFlag;
    }

    public void resetPSSubSysServiceAPIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIId();
            return;
        }
        this.pssubsysserviceapiidDirtyFlag = false;
        this.pssubsysserviceapiid = null;
    }

    public void setPSSubSysServiceAPIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysServiceAPIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysserviceapiname = string;
        this.pssubsysserviceapinameDirtyFlag = true;
    }

    public String getPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPIName();
        }
        return this.pssubsysserviceapiname;
    }

    public boolean isPSSubSysServiceAPINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysServiceAPINameDirty();
        }
        return this.pssubsysserviceapinameDirtyFlag;
    }

    public void resetPSSubSysServiceAPIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysServiceAPIName();
            return;
        }
        this.pssubsysserviceapinameDirtyFlag = false;
        this.pssubsysserviceapiname = null;
    }

    public void setPSSysAIChatAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentid = string;
        this.pssysaichatagentidDirtyFlag = true;
    }

    public String getPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentId();
        }
        return this.pssysaichatagentid;
    }

    public boolean isPSSysAIChatAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentIdDirty();
        }
        return this.pssysaichatagentidDirtyFlag;
    }

    public void resetPSSysAIChatAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentId();
            return;
        }
        this.pssysaichatagentidDirtyFlag = false;
        this.pssysaichatagentid = null;
    }

    public void setPSSysAIChatAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIChatAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaichatagentname = string;
        this.pssysaichatagentnameDirtyFlag = true;
    }

    public String getPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgentName();
        }
        return this.pssysaichatagentname;
    }

    public boolean isPSSysAIChatAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIChatAgentNameDirty();
        }
        return this.pssysaichatagentnameDirtyFlag;
    }

    public void resetPSSysAIChatAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIChatAgentName();
            return;
        }
        this.pssysaichatagentnameDirtyFlag = false;
        this.pssysaichatagentname = null;
    }

    public void setPSSysAIFactoryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryid = string;
        this.pssysaifactoryidDirtyFlag = true;
    }

    public String getPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryId();
        }
        return this.pssysaifactoryid;
    }

    public boolean isPSSysAIFactoryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryIdDirty();
        }
        return this.pssysaifactoryidDirtyFlag;
    }

    public void resetPSSysAIFactoryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryId();
            return;
        }
        this.pssysaifactoryidDirtyFlag = false;
        this.pssysaifactoryid = null;
    }

    public void setPSSysAIFactoryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIFactoryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaifactoryname = string;
        this.pssysaifactorynameDirtyFlag = true;
    }

    public String getPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactoryName();
        }
        return this.pssysaifactoryname;
    }

    public boolean isPSSysAIFactoryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIFactoryNameDirty();
        }
        return this.pssysaifactorynameDirtyFlag;
    }

    public void resetPSSysAIFactoryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIFactoryName();
            return;
        }
        this.pssysaifactorynameDirtyFlag = false;
        this.pssysaifactoryname = null;
    }

    public void setPSSysAIPipelineAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineagentid = string;
        this.pssysaipipelineagentidDirtyFlag = true;
    }

    public String getPSSysAIPipelineAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgentId();
        }
        return this.pssysaipipelineagentid;
    }

    public boolean isPSSysAIPipelineAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineAgentIdDirty();
        }
        return this.pssysaipipelineagentidDirtyFlag;
    }

    public void resetPSSysAIPipelineAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineAgentId();
            return;
        }
        this.pssysaipipelineagentidDirtyFlag = false;
        this.pssysaipipelineagentid = null;
    }

    public void setPSSysAIPipelineAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIPipelineAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaipipelineagentname = string;
        this.pssysaipipelineagentnameDirtyFlag = true;
    }

    public String getPSSysAIPipelineAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgentName();
        }
        return this.pssysaipipelineagentname;
    }

    public boolean isPSSysAIPipelineAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIPipelineAgentNameDirty();
        }
        return this.pssysaipipelineagentnameDirtyFlag;
    }

    public void resetPSSysAIPipelineAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIPipelineAgentName();
            return;
        }
        this.pssysaipipelineagentnameDirtyFlag = false;
        this.pssysaipipelineagentname = null;
    }

    public void setPSSysAIWorkerAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIWorkerAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaiworkeragentid = string;
        this.pssysaiworkeragentidDirtyFlag = true;
    }

    public String getPSSysAIWorkerAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgentId();
        }
        return this.pssysaiworkeragentid;
    }

    public boolean isPSSysAIWorkerAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIWorkerAgentIdDirty();
        }
        return this.pssysaiworkeragentidDirtyFlag;
    }

    public void resetPSSysAIWorkerAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIWorkerAgentId();
            return;
        }
        this.pssysaiworkeragentidDirtyFlag = false;
        this.pssysaiworkeragentid = null;
    }

    public void setPSSysAIWorkerAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAIWorkerAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysaiworkeragentname = string;
        this.pssysaiworkeragentnameDirtyFlag = true;
    }

    public String getPSSysAIWorkerAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgentName();
        }
        return this.pssysaiworkeragentname;
    }

    public boolean isPSSysAIWorkerAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAIWorkerAgentNameDirty();
        }
        return this.pssysaiworkeragentnameDirtyFlag;
    }

    public void resetPSSysAIWorkerAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAIWorkerAgentName();
            return;
        }
        this.pssysaiworkeragentnameDirtyFlag = false;
        this.pssysaiworkeragentname = null;
    }

    public void setPSSysBackServiceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBackServiceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbackserviceid = string;
        this.pssysbackserviceidDirtyFlag = true;
    }

    public String getPSSysBackServiceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBackServiceId();
        }
        return this.pssysbackserviceid;
    }

    public boolean isPSSysBackServiceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBackServiceIdDirty();
        }
        return this.pssysbackserviceidDirtyFlag;
    }

    public void resetPSSysBackServiceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBackServiceId();
            return;
        }
        this.pssysbackserviceidDirtyFlag = false;
        this.pssysbackserviceid = null;
    }

    public void setPSSysBackServiceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBackServiceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbackservicename = string;
        this.pssysbackservicenameDirtyFlag = true;
    }

    public String getPSSysBackServiceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBackServiceName();
        }
        return this.pssysbackservicename;
    }

    public boolean isPSSysBackServiceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBackServiceNameDirty();
        }
        return this.pssysbackservicenameDirtyFlag;
    }

    public void resetPSSysBackServiceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBackServiceName();
            return;
        }
        this.pssysbackservicenameDirtyFlag = false;
        this.pssysbackservicename = null;
    }

    public void setPSSysBDSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemeid = string;
        this.pssysbdschemeidDirtyFlag = true;
    }

    public String getPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeId();
        }
        return this.pssysbdschemeid;
    }

    public boolean isPSSysBDSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeIdDirty();
        }
        return this.pssysbdschemeidDirtyFlag;
    }

    public void resetPSSysBDSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeId();
            return;
        }
        this.pssysbdschemeidDirtyFlag = false;
        this.pssysbdschemeid = null;
    }

    public void setPSSysBDSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdschemename = string;
        this.pssysbdschemenameDirtyFlag = true;
    }

    public String getPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDSchemeName();
        }
        return this.pssysbdschemename;
    }

    public boolean isPSSysBDSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDSchemeNameDirty();
        }
        return this.pssysbdschemenameDirtyFlag;
    }

    public void resetPSSysBDSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDSchemeName();
            return;
        }
        this.pssysbdschemenameDirtyFlag = false;
        this.pssysbdschemename = null;
    }

    public void setPSSysBDTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtableid = string;
        this.pssysbdtableidDirtyFlag = true;
    }

    public String getPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableId();
        }
        return this.pssysbdtableid;
    }

    public boolean isPSSysBDTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableIdDirty();
        }
        return this.pssysbdtableidDirtyFlag;
    }

    public void resetPSSysBDTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableId();
            return;
        }
        this.pssysbdtableidDirtyFlag = false;
        this.pssysbdtableid = null;
    }

    public void setPSSysBDTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBDTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbdtablename = string;
        this.pssysbdtablenameDirtyFlag = true;
    }

    public String getPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTableName();
        }
        return this.pssysbdtablename;
    }

    public boolean isPSSysBDTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBDTableNameDirty();
        }
        return this.pssysbdtablenameDirtyFlag;
    }

    public void resetPSSysBDTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBDTableName();
            return;
        }
        this.pssysbdtablenameDirtyFlag = false;
        this.pssysbdtablename = null;
    }

    public void setPSSysBIAggTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtableid = string;
        this.pssysbiaggtableidDirtyFlag = true;
    }

    public String getPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableId();
        }
        return this.pssysbiaggtableid;
    }

    public boolean isPSSysBIAggTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableIdDirty();
        }
        return this.pssysbiaggtableidDirtyFlag;
    }

    public void resetPSSysBIAggTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableId();
            return;
        }
        this.pssysbiaggtableidDirtyFlag = false;
        this.pssysbiaggtableid = null;
    }

    public void setPSSysBIAggTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIAggTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbiaggtablename = string;
        this.pssysbiaggtablenameDirtyFlag = true;
    }

    public String getPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTableName();
        }
        return this.pssysbiaggtablename;
    }

    public boolean isPSSysBIAggTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIAggTableNameDirty();
        }
        return this.pssysbiaggtablenameDirtyFlag;
    }

    public void resetPSSysBIAggTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIAggTableName();
            return;
        }
        this.pssysbiaggtablenameDirtyFlag = false;
        this.pssysbiaggtablename = null;
    }

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBIReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportid = string;
        this.pssysbireportidDirtyFlag = true;
    }

    public String getPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportId();
        }
        return this.pssysbireportid;
    }

    public boolean isPSSysBIReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportIdDirty();
        }
        return this.pssysbireportidDirtyFlag;
    }

    public void resetPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportId();
            return;
        }
        this.pssysbireportidDirtyFlag = false;
        this.pssysbireportid = null;
    }

    public void setPSSysBIReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportname = string;
        this.pssysbireportnameDirtyFlag = true;
    }

    public String getPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportName();
        }
        return this.pssysbireportname;
    }

    public boolean isPSSysBIReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportNameDirty();
        }
        return this.pssysbireportnameDirtyFlag;
    }

    public void resetPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportName();
            return;
        }
        this.pssysbireportnameDirtyFlag = false;
        this.pssysbireportname = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysBISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemename = string;
        this.pssysbischemenameDirtyFlag = true;
    }

    public String getPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeName();
        }
        return this.pssysbischemename;
    }

    public boolean isPSSysBISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeNameDirty();
        }
        return this.pssysbischemenameDirtyFlag;
    }

    public void resetPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeName();
            return;
        }
        this.pssysbischemenameDirtyFlag = false;
        this.pssysbischemename = null;
    }

    public void setPSSysDataSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDataSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdatasyncagentid = string;
        this.pssysdatasyncagentidDirtyFlag = true;
    }

    public String getPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDataSyncAgentId();
        }
        return this.pssysdatasyncagentid;
    }

    public boolean isPSSysDataSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDataSyncAgentIdDirty();
        }
        return this.pssysdatasyncagentidDirtyFlag;
    }

    public void resetPSSysDataSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDataSyncAgentId();
            return;
        }
        this.pssysdatasyncagentidDirtyFlag = false;
        this.pssysdatasyncagentid = null;
    }

    public void setPSSysDataSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDataSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdatasyncagentname = string;
        this.pssysdatasyncagentnameDirtyFlag = true;
    }

    public String getPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDataSyncAgentName();
        }
        return this.pssysdatasyncagentname;
    }

    public boolean isPSSysDataSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDataSyncAgentNameDirty();
        }
        return this.pssysdatasyncagentnameDirtyFlag;
    }

    public void resetPSSysDataSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDataSyncAgentName();
            return;
        }
        this.pssysdatasyncagentnameDirtyFlag = false;
        this.pssysdatasyncagentname = null;
    }

    public void setPSSysDBSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemeid = string;
        this.pssysdbschemeidDirtyFlag = true;
    }

    public String getPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeId();
        }
        return this.pssysdbschemeid;
    }

    public boolean isPSSysDBSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeIdDirty();
        }
        return this.pssysdbschemeidDirtyFlag;
    }

    public void resetPSSysDBSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeId();
            return;
        }
        this.pssysdbschemeidDirtyFlag = false;
        this.pssysdbschemeid = null;
    }

    public void setPSSysDBSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbschemename = string;
        this.pssysdbschemenameDirtyFlag = true;
    }

    public String getPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBSchemeName();
        }
        return this.pssysdbschemename;
    }

    public boolean isPSSysDBSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBSchemeNameDirty();
        }
        return this.pssysdbschemenameDirtyFlag;
    }

    public void resetPSSysDBSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBSchemeName();
            return;
        }
        this.pssysdbschemenameDirtyFlag = false;
        this.pssysdbschemename = null;
    }

    public void setPSSysDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtableid = string;
        this.pssysdbtableidDirtyFlag = true;
    }

    public String getPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableId();
        }
        return this.pssysdbtableid;
    }

    public boolean isPSSysDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableIdDirty();
        }
        return this.pssysdbtableidDirtyFlag;
    }

    public void resetPSSysDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableId();
            return;
        }
        this.pssysdbtableidDirtyFlag = false;
        this.pssysdbtableid = null;
    }

    public void setPSSysDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbtablename = string;
        this.pssysdbtablenameDirtyFlag = true;
    }

    public String getPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTableName();
        }
        return this.pssysdbtablename;
    }

    public boolean isPSSysDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBTableNameDirty();
        }
        return this.pssysdbtablenameDirtyFlag;
    }

    public void resetPSSysDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBTableName();
            return;
        }
        this.pssysdbtablenameDirtyFlag = false;
        this.pssysdbtablename = null;
    }

    public void setPSSysDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodeid = string;
        this.pssysdelogicnodeidDirtyFlag = true;
    }

    public String getPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeId();
        }
        return this.pssysdelogicnodeid;
    }

    public boolean isPSSysDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeIdDirty();
        }
        return this.pssysdelogicnodeidDirtyFlag;
    }

    public void resetPSSysDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeId();
            return;
        }
        this.pssysdelogicnodeidDirtyFlag = false;
        this.pssysdelogicnodeid = null;
    }

    public void setPSSysDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdelogicnodename = string;
        this.pssysdelogicnodenameDirtyFlag = true;
    }

    public String getPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNodeName();
        }
        return this.pssysdelogicnodename;
    }

    public boolean isPSSysDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDELogicNodeNameDirty();
        }
        return this.pssysdelogicnodenameDirtyFlag;
    }

    public void resetPSSysDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDELogicNodeName();
            return;
        }
        this.pssysdelogicnodenameDirtyFlag = false;
        this.pssysdelogicnodename = null;
    }

    public void setPSSysEAIElementId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementid = string;
        this.pssyseaielementidDirtyFlag = true;
    }

    public String getPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementId();
        }
        return this.pssyseaielementid;
    }

    public boolean isPSSysEAIElementIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementIdDirty();
        }
        return this.pssyseaielementidDirtyFlag;
    }

    public void resetPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementId();
            return;
        }
        this.pssyseaielementidDirtyFlag = false;
        this.pssyseaielementid = null;
    }

    public void setPSSysEAIElementName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementname = string;
        this.pssyseaielementnameDirtyFlag = true;
    }

    public String getPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementName();
        }
        return this.pssyseaielementname;
    }

    public boolean isPSSysEAIElementNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementNameDirty();
        }
        return this.pssyseaielementnameDirtyFlag;
    }

    public void resetPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementName();
            return;
        }
        this.pssyseaielementnameDirtyFlag = false;
        this.pssyseaielementname = null;
    }

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
    }

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysSearchDocId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocid = string;
        this.pssyssearchdocidDirtyFlag = true;
    }

    public String getPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocId();
        }
        return this.pssyssearchdocid;
    }

    public boolean isPSSysSearchDocIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocIdDirty();
        }
        return this.pssyssearchdocidDirtyFlag;
    }

    public void resetPSSysSearchDocId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocId();
            return;
        }
        this.pssyssearchdocidDirtyFlag = false;
        this.pssyssearchdocid = null;
    }

    public void setPSSysSearchDocName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchDocName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchdocname = string;
        this.pssyssearchdocnameDirtyFlag = true;
    }

    public String getPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDocName();
        }
        return this.pssyssearchdocname;
    }

    public boolean isPSSysSearchDocNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchDocNameDirty();
        }
        return this.pssyssearchdocnameDirtyFlag;
    }

    public void resetPSSysSearchDocName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchDocName();
            return;
        }
        this.pssyssearchdocnameDirtyFlag = false;
        this.pssyssearchdocname = null;
    }

    public void setPSSysSearchSchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemeid = string;
        this.pssyssearchschemeidDirtyFlag = true;
    }

    public String getPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeId();
        }
        return this.pssyssearchschemeid;
    }

    public boolean isPSSysSearchSchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeIdDirty();
        }
        return this.pssyssearchschemeidDirtyFlag;
    }

    public void resetPSSysSearchSchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeId();
            return;
        }
        this.pssyssearchschemeidDirtyFlag = false;
        this.pssyssearchschemeid = null;
    }

    public void setPSSysSearchSchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSearchSchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssearchschemename = string;
        this.pssyssearchschemenameDirtyFlag = true;
    }

    public String getPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchSchemeName();
        }
        return this.pssyssearchschemename;
    }

    public boolean isPSSysSearchSchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSearchSchemeNameDirty();
        }
        return this.pssyssearchschemenameDirtyFlag;
    }

    public void resetPSSysSearchSchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSearchSchemeName();
            return;
        }
        this.pssyssearchschemenameDirtyFlag = false;
        this.pssyssearchschemename = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
    }

    public void setPSSysSQLCmdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdid = string;
        this.pssyssqlcmdidDirtyFlag = true;
    }

    public String getPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdId();
        }
        return this.pssyssqlcmdid;
    }

    public boolean isPSSysSQLCmdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdIdDirty();
        }
        return this.pssyssqlcmdidDirtyFlag;
    }

    public void resetPSSysSQLCmdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdId();
            return;
        }
        this.pssyssqlcmdidDirtyFlag = false;
        this.pssyssqlcmdid = null;
    }

    public void setPSSysSQLCmdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSQLCmdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssqlcmdname = string;
        this.pssyssqlcmdnameDirtyFlag = true;
    }

    public String getPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSQLCmdName();
        }
        return this.pssyssqlcmdname;
    }

    public boolean isPSSysSQLCmdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSQLCmdNameDirty();
        }
        return this.pssyssqlcmdnameDirtyFlag;
    }

    public void resetPSSysSQLCmdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSQLCmdName();
            return;
        }
        this.pssyssqlcmdnameDirtyFlag = false;
        this.pssyssqlcmdname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSysUniStateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistateid = string;
        this.pssysunistateidDirtyFlag = true;
    }

    public String getPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateId();
        }
        return this.pssysunistateid;
    }

    public boolean isPSSysUniStateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateIdDirty();
        }
        return this.pssysunistateidDirtyFlag;
    }

    public void resetPSSysUniStateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateId();
            return;
        }
        this.pssysunistateidDirtyFlag = false;
        this.pssysunistateid = null;
    }

    public void setPSSysUniStateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniStateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunistatename = string;
        this.pssysunistatenameDirtyFlag = true;
    }

    public String getPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniStateName();
        }
        return this.pssysunistatename;
    }

    public boolean isPSSysUniStateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniStateNameDirty();
        }
        return this.pssysunistatenameDirtyFlag;
    }

    public void resetPSSysUniStateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniStateName();
            return;
        }
        this.pssysunistatenameDirtyFlag = false;
        this.pssysunistatename = null;
    }

    public void setPSSysUtilDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildeid = string;
        this.pssysutildeidDirtyFlag = true;
    }

    public String getPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEId();
        }
        return this.pssysutildeid;
    }

    public boolean isPSSysUtilDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDEIdDirty();
        }
        return this.pssysutildeidDirtyFlag;
    }

    public void resetPSSysUtilDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEId();
            return;
        }
        this.pssysutildeidDirtyFlag = false;
        this.pssysutildeid = null;
    }

    public void setPSSysUtilDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutildename = string;
        this.pssysutildenameDirtyFlag = true;
    }

    public String getPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDEName();
        }
        return this.pssysutildename;
    }

    public boolean isPSSysUtilDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilDENameDirty();
        }
        return this.pssysutildenameDirtyFlag;
    }

    public void resetPSSysUtilDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilDEName();
            return;
        }
        this.pssysutildenameDirtyFlag = false;
        this.pssysutildename = null;
    }

    public void setPSViewMsgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgid = string;
        this.psviewmsgidDirtyFlag = true;
    }

    public String getPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgId();
        }
        return this.psviewmsgid;
    }

    public boolean isPSViewMsgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgIdDirty();
        }
        return this.psviewmsgidDirtyFlag;
    }

    public void resetPSViewMsgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgId();
            return;
        }
        this.psviewmsgidDirtyFlag = false;
        this.psviewmsgid = null;
    }

    public void setPSViewMsgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsgname = string;
        this.psviewmsgnameDirtyFlag = true;
    }

    public String getPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgName();
        }
        return this.psviewmsgname;
    }

    public boolean isPSViewMsgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgNameDirty();
        }
        return this.psviewmsgnameDirtyFlag;
    }

    public void resetPSViewMsgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgName();
            return;
        }
        this.psviewmsgnameDirtyFlag = false;
        this.psviewmsgname = null;
    }

    public void setPSWFDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdeid = string;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSWFDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfdename = string;
        this.pswfdenameDirtyFlag = true;
    }

    public String getPSWFDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEName();
        }
        return this.pswfdename;
    }

    public boolean isPSWFDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDENameDirty();
        }
        return this.pswfdenameDirtyFlag;
    }

    public void resetPSWFDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEName();
            return;
        }
        this.pswfdenameDirtyFlag = false;
        this.pswfdename = null;
    }

    public void setPSWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowid = string;
        this.psworkflowidDirtyFlag = true;
    }

    public String getPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowId();
        }
        return this.psworkflowid;
    }

    public boolean isPSWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowIdDirty();
        }
        return this.psworkflowidDirtyFlag;
    }

    public void resetPSWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowId();
            return;
        }
        this.psworkflowidDirtyFlag = false;
        this.psworkflowid = null;
    }

    public void setPSWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkflowname = string;
        this.psworkflownameDirtyFlag = true;
    }

    public String getPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflowName();
        }
        return this.psworkflowname;
    }

    public boolean isPSWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkflowNameDirty();
        }
        return this.psworkflownameDirtyFlag;
    }

    public void resetPSWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkflowName();
            return;
        }
        this.psworkflownameDirtyFlag = false;
        this.psworkflowname = null;
    }

    public void setRetPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retpsdlparamid = string;
        this.retpsdlparamidDirtyFlag = true;
    }

    public String getRetPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSDLParamId();
        }
        return this.retpsdlparamid;
    }

    public boolean isRetPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetPSDLParamIdDirty();
        }
        return this.retpsdlparamidDirtyFlag;
    }

    public void resetRetPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetPSDLParamId();
            return;
        }
        this.retpsdlparamidDirtyFlag = false;
        this.retpsdlparamid = null;
    }

    public void setRetPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retpsdlparamname = string;
        this.retpsdlparamnameDirtyFlag = true;
    }

    public String getRetPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSDLParamName();
        }
        return this.retpsdlparamname;
    }

    public boolean isRetPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetPSDLParamNameDirty();
        }
        return this.retpsdlparamnameDirtyFlag;
    }

    public void resetRetPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetPSDLParamName();
            return;
        }
        this.retpsdlparamnameDirtyFlag = false;
        this.retpsdlparamname = null;
    }

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
    }

    public void setSrcIndex(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcIndex(n);
            return;
        }
        this.srcindex = n;
        this.srcindexDirtyFlag = true;
    }

    public Integer getSrcIndex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcIndex();
        }
        return this.srcindex;
    }

    public boolean isSrcIndexDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcIndexDirty();
        }
        return this.srcindexDirtyFlag;
    }

    public void resetSrcIndex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcIndex();
            return;
        }
        this.srcindexDirtyFlag = false;
        this.srcindex = null;
    }

    public void setSrcPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdlparamid = string;
        this.srcpsdlparamidDirtyFlag = true;
    }

    public String getSrcPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParamId();
        }
        return this.srcpsdlparamid;
    }

    public boolean isSrcPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDLParamIdDirty();
        }
        return this.srcpsdlparamidDirtyFlag;
    }

    public void resetSrcPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDLParamId();
            return;
        }
        this.srcpsdlparamidDirtyFlag = false;
        this.srcpsdlparamid = null;
    }

    public void setSrcPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdlparamname = string;
        this.srcpsdlparamnameDirtyFlag = true;
    }

    public String getSrcPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParamName();
        }
        return this.srcpsdlparamname;
    }

    public boolean isSrcPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDLParamNameDirty();
        }
        return this.srcpsdlparamnameDirtyFlag;
    }

    public void resetSrcPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDLParamName();
            return;
        }
        this.srcpsdlparamnameDirtyFlag = false;
        this.srcpsdlparamname = null;
    }

    public void setSrcSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcSize(n);
            return;
        }
        this.srcsize = n;
        this.srcsizeDirtyFlag = true;
    }

    public Integer getSrcSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcSize();
        }
        return this.srcsize;
    }

    public boolean isSrcSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcSizeDirty();
        }
        return this.srcsizeDirtyFlag;
    }

    public void resetSrcSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcSize();
            return;
        }
        this.srcsizeDirtyFlag = false;
        this.srcsize = null;
    }

    public void setThreadRunMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadRunMode(n);
            return;
        }
        this.threadrunmode = n;
        this.threadrunmodeDirtyFlag = true;
    }

    public Integer getThreadRunMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadRunMode();
        }
        return this.threadrunmode;
    }

    public boolean isThreadRunModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadRunModeDirty();
        }
        return this.threadrunmodeDirtyFlag;
    }

    public void resetThreadRunMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadRunMode();
            return;
        }
        this.threadrunmodeDirtyFlag = false;
        this.threadrunmode = null;
    }

    public void setThreadRunTimer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThreadRunTimer(n);
            return;
        }
        this.threadruntimer = n;
        this.threadruntimerDirtyFlag = true;
    }

    public Integer getThreadRunTimer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThreadRunTimer();
        }
        return this.threadruntimer;
    }

    public boolean isThreadRunTimerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThreadRunTimerDirty();
        }
        return this.threadruntimerDirtyFlag;
    }

    public void resetThreadRunTimer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThreadRunTimer();
            return;
        }
        this.threadruntimerDirtyFlag = false;
        this.threadruntimer = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
    }

    public void setTSMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSMode(n);
            return;
        }
        this.tsmode = n;
        this.tsmodeDirtyFlag = true;
    }

    public Integer getTSMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSMode();
        }
        return this.tsmode;
    }

    public boolean isTSModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSModeDirty();
        }
        return this.tsmodeDirtyFlag;
    }

    public void resetTSMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSMode();
            return;
        }
        this.tsmodeDirtyFlag = false;
        this.tsmode = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
        this.updatemanDirtyFlag = true;
    }

    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSDELogicNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELogicNodeBase pSDELogicNodeBase) {
        pSDELogicNodeBase.resetCodeName();
        pSDELogicNodeBase.resetCreateDate();
        pSDELogicNodeBase.resetCreateMan();
        pSDELogicNodeBase.resetCustomDSTParam();
        pSDELogicNodeBase.resetCustomSrcParam();
        pSDELogicNodeBase.resetDebugMode();
        pSDELogicNodeBase.resetDstPSDEUtilDEId();
        pSDELogicNodeBase.resetDstPSDEUtilDEName();
        pSDELogicNodeBase.resetDstIndex();
        pSDELogicNodeBase.resetDstParamAction();
        pSDELogicNodeBase.resetDstPSDEActionId();
        pSDELogicNodeBase.resetDstPSDEActionName();
        pSDELogicNodeBase.resetDstPSDEDataExpId();
        pSDELogicNodeBase.resetDstPSDEDataExpName();
        pSDELogicNodeBase.resetDstPSDEDataFlowId();
        pSDELogicNodeBase.resetDstPSDEDataFlowName();
        pSDELogicNodeBase.resetDstPSDEDataImpId();
        pSDELogicNodeBase.resetDstPSDEDataImpName();
        pSDELogicNodeBase.resetDstPSDEDataQueryId();
        pSDELogicNodeBase.resetDstPSDEDataQueryName();
        pSDELogicNodeBase.resetDstPSDEDataSetId();
        pSDELogicNodeBase.resetDstPSDEDataSetName();
        pSDELogicNodeBase.resetDstPSDEDataSyncId();
        pSDELogicNodeBase.resetDstPSDEDataSyncName();
        pSDELogicNodeBase.resetDstPSDEDTSQueueId();
        pSDELogicNodeBase.resetDstPSDEDTSQueueName();
        pSDELogicNodeBase.resetDstPSDEFGroupId();
        pSDELogicNodeBase.resetDstPSDEFGroupName();
        pSDELogicNodeBase.resetDstPSDEFormId();
        pSDELogicNodeBase.resetDstPSDEFormName();
        pSDELogicNodeBase.resetDstPSDEFValueRuleId();
        pSDELogicNodeBase.resetDstPSDEFValueRuleName();
        pSDELogicNodeBase.resetDstPSDEId();
        pSDELogicNodeBase.resetDstPSDELogicId();
        pSDELogicNodeBase.resetDstPSDELogicName();
        pSDELogicNodeBase.resetDstPSDEMapId();
        pSDELogicNodeBase.resetDstPSDEMapName();
        pSDELogicNodeBase.resetDstPSDEName();
        pSDELogicNodeBase.resetDstPSDENotifyId();
        pSDELogicNodeBase.resetDstPSDENotifyName();
        pSDELogicNodeBase.resetDstPSDEPrintId();
        pSDELogicNodeBase.resetDstPSDEPrintName();
        pSDELogicNodeBase.resetDstPSDEReportId();
        pSDELogicNodeBase.resetDstPSDEReportName();
        pSDELogicNodeBase.resetDstPSDESampleDataId();
        pSDELogicNodeBase.resetDstPSDESampleDataName();
        pSDELogicNodeBase.resetDstPSDEUAGroupId();
        pSDELogicNodeBase.resetDstPSDEUAGroupName();
        pSDELogicNodeBase.resetDstPSDEUILogicId();
        pSDELogicNodeBase.resetDstPSDEUILogicName();
        pSDELogicNodeBase.resetDstPSDEViewId();
        pSDELogicNodeBase.resetDstPSDEViewName();
        pSDELogicNodeBase.resetDstPSDEVRGroupId();
        pSDELogicNodeBase.resetDstPSDEVRGroupName();
        pSDELogicNodeBase.resetDstPSDEWizardId();
        pSDELogicNodeBase.resetDstPSDEWizardName();
        pSDELogicNodeBase.resetDstPSDLParamId();
        pSDELogicNodeBase.resetDstPSDLParamName();
        pSDELogicNodeBase.resetDstSortDir();
        pSDELogicNodeBase.resetDynaModelFlag();
        pSDELogicNodeBase.resetISPSDLParamId();
        pSDELogicNodeBase.resetISPSDLParamName();
        pSDELogicNodeBase.resetLeftPos();
        pSDELogicNodeBase.resetLogicNodeSubType();
        pSDELogicNodeBase.resetLogicNodeType();
        pSDELogicNodeBase.resetMemo();
        pSDELogicNodeBase.resetMsgPSLanResId();
        pSDELogicNodeBase.resetMsgPSLanResName();
        pSDELogicNodeBase.resetNodeParams();
        pSDELogicNodeBase.resetOptPSDLParamId();
        pSDELogicNodeBase.resetOptPSDLParamName();
        pSDELogicNodeBase.resetOrderValue();
        pSDELogicNodeBase.resetOSPSDLParamId();
        pSDELogicNodeBase.resetOSPSDLParamName();
        pSDELogicNodeBase.resetParallelOutput();
        pSDELogicNodeBase.resetParam1();
        pSDELogicNodeBase.resetParam10();
        pSDELogicNodeBase.resetParam11();
        pSDELogicNodeBase.resetParam12();
        pSDELogicNodeBase.resetParam13();
        pSDELogicNodeBase.resetParam14();
        pSDELogicNodeBase.resetParam2();
        pSDELogicNodeBase.resetParam3();
        pSDELogicNodeBase.resetParam4();
        pSDELogicNodeBase.resetParam5();
        pSDELogicNodeBase.resetParam6();
        pSDELogicNodeBase.resetParam7();
        pSDELogicNodeBase.resetParam8();
        pSDELogicNodeBase.resetParam9();
        pSDELogicNodeBase.resetPSDEId();
        pSDELogicNodeBase.resetPSDELogicId();
        pSDELogicNodeBase.resetPSDELogicName();
        pSDELogicNodeBase.resetPSDELogicNodeId();
        pSDELogicNodeBase.resetPSDELogicNodeName();
        pSDELogicNodeBase.resetPSDEMainStateId();
        pSDELogicNodeBase.resetPSDEMainStateName();
        pSDELogicNodeBase.resetPSDEUIActionId();
        pSDELogicNodeBase.resetPSDEUIActionName();
        pSDELogicNodeBase.resetPSDynaInstId();
        pSDELogicNodeBase.resetPSSubSysSADetailId();
        pSDELogicNodeBase.resetPSSubSysSADetailName();
        pSDELogicNodeBase.resetPSSubSysServiceAPIId();
        pSDELogicNodeBase.resetPSSubSysServiceAPIName();
        pSDELogicNodeBase.resetPSSysAIChatAgentId();
        pSDELogicNodeBase.resetPSSysAIChatAgentName();
        pSDELogicNodeBase.resetPSSysAIFactoryId();
        pSDELogicNodeBase.resetPSSysAIFactoryName();
        pSDELogicNodeBase.resetPSSysAIPipelineAgentId();
        pSDELogicNodeBase.resetPSSysAIPipelineAgentName();
        pSDELogicNodeBase.resetPSSysAIWorkerAgentId();
        pSDELogicNodeBase.resetPSSysAIWorkerAgentName();
        pSDELogicNodeBase.resetPSSysBackServiceId();
        pSDELogicNodeBase.resetPSSysBackServiceName();
        pSDELogicNodeBase.resetPSSysBDSchemeId();
        pSDELogicNodeBase.resetPSSysBDSchemeName();
        pSDELogicNodeBase.resetPSSysBDTableId();
        pSDELogicNodeBase.resetPSSysBDTableName();
        pSDELogicNodeBase.resetPSSysBIAggTableId();
        pSDELogicNodeBase.resetPSSysBIAggTableName();
        pSDELogicNodeBase.resetPSSysBICubeId();
        pSDELogicNodeBase.resetPSSysBICubeName();
        pSDELogicNodeBase.resetPSSysBIReportId();
        pSDELogicNodeBase.resetPSSysBIReportName();
        pSDELogicNodeBase.resetPSSysBISchemeId();
        pSDELogicNodeBase.resetPSSysBISchemeName();
        pSDELogicNodeBase.resetPSSysDataSyncAgentId();
        pSDELogicNodeBase.resetPSSysDataSyncAgentName();
        pSDELogicNodeBase.resetPSSysDBSchemeId();
        pSDELogicNodeBase.resetPSSysDBSchemeName();
        pSDELogicNodeBase.resetPSSysDBTableId();
        pSDELogicNodeBase.resetPSSysDBTableName();
        pSDELogicNodeBase.resetPSSysDELogicNodeId();
        pSDELogicNodeBase.resetPSSysDELogicNodeName();
        pSDELogicNodeBase.resetPSSysEAIElementId();
        pSDELogicNodeBase.resetPSSysEAIElementName();
        pSDELogicNodeBase.resetPSSysEAISchemeId();
        pSDELogicNodeBase.resetPSSysEAISchemeName();
        pSDELogicNodeBase.resetPSSysMsgTemplId();
        pSDELogicNodeBase.resetPSSysMsgTemplName();
        pSDELogicNodeBase.resetPSSysPFPluginId();
        pSDELogicNodeBase.resetPSSysPFPluginName();
        pSDELogicNodeBase.resetPSSysResourceId();
        pSDELogicNodeBase.resetPSSysResourceName();
        pSDELogicNodeBase.resetPSSysSearchDocId();
        pSDELogicNodeBase.resetPSSysSearchDocName();
        pSDELogicNodeBase.resetPSSysSearchSchemeId();
        pSDELogicNodeBase.resetPSSysSearchSchemeName();
        pSDELogicNodeBase.resetPSSysSFPluginId();
        pSDELogicNodeBase.resetPSSysSFPluginName();
        pSDELogicNodeBase.resetPSSysSQLCmdId();
        pSDELogicNodeBase.resetPSSysSQLCmdName();
        pSDELogicNodeBase.resetPSSystemId();
        pSDELogicNodeBase.resetPSSysUniStateId();
        pSDELogicNodeBase.resetPSSysUniStateName();
        pSDELogicNodeBase.resetPSSysUtilDEId();
        pSDELogicNodeBase.resetPSSysUtilDEName();
        pSDELogicNodeBase.resetPSViewMsgId();
        pSDELogicNodeBase.resetPSViewMsgName();
        pSDELogicNodeBase.resetPSWFDEId();
        pSDELogicNodeBase.resetPSWFDEName();
        pSDELogicNodeBase.resetPSWorkflowId();
        pSDELogicNodeBase.resetPSWorkflowName();
        pSDELogicNodeBase.resetRetPSDLParamId();
        pSDELogicNodeBase.resetRetPSDLParamName();
        pSDELogicNodeBase.resetShapeParams();
        pSDELogicNodeBase.resetSrcIndex();
        pSDELogicNodeBase.resetSrcPSDLParamId();
        pSDELogicNodeBase.resetSrcPSDLParamName();
        pSDELogicNodeBase.resetSrcSize();
        pSDELogicNodeBase.resetThreadRunMode();
        pSDELogicNodeBase.resetThreadRunTimer();
        pSDELogicNodeBase.resetTopPos();
        pSDELogicNodeBase.resetTSMode();
        pSDELogicNodeBase.resetUpdateDate();
        pSDELogicNodeBase.resetUpdateMan();
        pSDELogicNodeBase.resetUserCat();
        pSDELogicNodeBase.resetUserParams();
        pSDELogicNodeBase.resetUserTag();
        pSDELogicNodeBase.resetUserTag2();
        pSDELogicNodeBase.resetUserTag3();
        pSDELogicNodeBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDSTParamDirty()) {
            hashMap.put(FIELD_CUSTOMDSTPARAM, this.getCustomDSTParam());
        }
        if (!bl || this.isCustomSrcParamDirty()) {
            hashMap.put(FIELD_CUSTOMSRCPARAM, this.getCustomSrcParam());
        }
        if (!bl || this.isDebugModeDirty()) {
            hashMap.put(FIELD_DEBUGMODE, this.getDebugMode());
        }
        if (!bl || this.isDstPSDEUtilDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEUTILDEID, this.getDstPSDEUtilDEId());
        }
        if (!bl || this.isDstPSDEUtilDENameDirty()) {
            hashMap.put(FIELD_DSTPSDEUTILDENAME, this.getDstPSDEUtilDEName());
        }
        if (!bl || this.isDstIndexDirty()) {
            hashMap.put(FIELD_DSTINDEX, this.getDstIndex());
        }
        if (!bl || this.isDstParamActionDirty()) {
            hashMap.put(FIELD_DSTPARAMACTION, this.getDstParamAction());
        }
        if (!bl || this.isDstPSDEActionIdDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONID, this.getDstPSDEActionId());
        }
        if (!bl || this.isDstPSDEActionNameDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONNAME, this.getDstPSDEActionName());
        }
        if (!bl || this.isDstPSDEDataExpIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAEXPID, this.getDstPSDEDataExpId());
        }
        if (!bl || this.isDstPSDEDataExpNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAEXPNAME, this.getDstPSDEDataExpName());
        }
        if (!bl || this.isDstPSDEDataFlowIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAFLOWID, this.getDstPSDEDataFlowId());
        }
        if (!bl || this.isDstPSDEDataFlowNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAFLOWNAME, this.getDstPSDEDataFlowName());
        }
        if (!bl || this.isDstPSDEDataImpIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAIMPID, this.getDstPSDEDataImpId());
        }
        if (!bl || this.isDstPSDEDataImpNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAIMPNAME, this.getDstPSDEDataImpName());
        }
        if (!bl || this.isDstPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYID, this.getDstPSDEDataQueryId());
        }
        if (!bl || this.isDstPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYNAME, this.getDstPSDEDataQueryName());
        }
        if (!bl || this.isDstPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETID, this.getDstPSDEDataSetId());
        }
        if (!bl || this.isDstPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETNAME, this.getDstPSDEDataSetName());
        }
        if (!bl || this.isDstPSDEDataSyncIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASYNCID, this.getDstPSDEDataSyncId());
        }
        if (!bl || this.isDstPSDEDataSyncNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASYNCNAME, this.getDstPSDEDataSyncName());
        }
        if (!bl || this.isDstPSDEDTSQueueIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDTSQUEUEID, this.getDstPSDEDTSQueueId());
        }
        if (!bl || this.isDstPSDEDTSQueueNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDTSQUEUENAME, this.getDstPSDEDTSQueueName());
        }
        if (!bl || this.isDstPSDEFGroupIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFGROUPID, this.getDstPSDEFGroupId());
        }
        if (!bl || this.isDstPSDEFGroupNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFGROUPNAME, this.getDstPSDEFGroupName());
        }
        if (!bl || this.isDstPSDEFormIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFORMID, this.getDstPSDEFormId());
        }
        if (!bl || this.isDstPSDEFormNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFORMNAME, this.getDstPSDEFormName());
        }
        if (!bl || this.isDstPSDEFValueRuleIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFVALUERULEID, this.getDstPSDEFValueRuleId());
        }
        if (!bl || this.isDstPSDEFValueRuleNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFVALUERULENAME, this.getDstPSDEFValueRuleName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
        }
        if (!bl || this.isDstPSDELogicIdDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICID, this.getDstPSDELogicId());
        }
        if (!bl || this.isDstPSDELogicNameDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICNAME, this.getDstPSDELogicName());
        }
        if (!bl || this.isDstPSDEMapIdDirty()) {
            hashMap.put(FIELD_DSTPSDEMAPID, this.getDstPSDEMapId());
        }
        if (!bl || this.isDstPSDEMapNameDirty()) {
            hashMap.put(FIELD_DSTPSDEMAPNAME, this.getDstPSDEMapName());
        }
        if (!bl || this.isDstPSDENameDirty()) {
            hashMap.put(FIELD_DSTPSDENAME, this.getDstPSDEName());
        }
        if (!bl || this.isDstPSDENotifyIdDirty()) {
            hashMap.put(FIELD_DSTPSDENOTIFYID, this.getDstPSDENotifyId());
        }
        if (!bl || this.isDstPSDENotifyNameDirty()) {
            hashMap.put(FIELD_DSTPSDENOTIFYNAME, this.getDstPSDENotifyName());
        }
        if (!bl || this.isDstPSDEPrintIdDirty()) {
            hashMap.put(FIELD_DSTPSDEPRINTID, this.getDstPSDEPrintId());
        }
        if (!bl || this.isDstPSDEPrintNameDirty()) {
            hashMap.put(FIELD_DSTPSDEPRINTNAME, this.getDstPSDEPrintName());
        }
        if (!bl || this.isDstPSDEReportIdDirty()) {
            hashMap.put(FIELD_DSTPSDEREPORTID, this.getDstPSDEReportId());
        }
        if (!bl || this.isDstPSDEReportNameDirty()) {
            hashMap.put(FIELD_DSTPSDEREPORTNAME, this.getDstPSDEReportName());
        }
        if (!bl || this.isDstPSDESampleDataIdDirty()) {
            hashMap.put(FIELD_DSTPSDESAMPLEDATAID, this.getDstPSDESampleDataId());
        }
        if (!bl || this.isDstPSDESampleDataNameDirty()) {
            hashMap.put(FIELD_DSTPSDESAMPLEDATANAME, this.getDstPSDESampleDataName());
        }
        if (!bl || this.isDstPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_DSTPSDEUAGROUPID, this.getDstPSDEUAGroupId());
        }
        if (!bl || this.isDstPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_DSTPSDEUAGROUPNAME, this.getDstPSDEUAGroupName());
        }
        if (!bl || this.isDstPSDEUILogicIdDirty()) {
            hashMap.put(FIELD_DSTPSDEUILOGICID, this.getDstPSDEUILogicId());
        }
        if (!bl || this.isDstPSDEUILogicNameDirty()) {
            hashMap.put(FIELD_DSTPSDEUILOGICNAME, this.getDstPSDEUILogicName());
        }
        if (!bl || this.isDstPSDEViewIdDirty()) {
            hashMap.put(FIELD_DSTPSDEVIEWID, this.getDstPSDEViewId());
        }
        if (!bl || this.isDstPSDEViewNameDirty()) {
            hashMap.put(FIELD_DSTPSDEVIEWNAME, this.getDstPSDEViewName());
        }
        if (!bl || this.isDstPSDEVRGroupIdDirty()) {
            hashMap.put(FIELD_DSTPSDEVRGROUPID, this.getDstPSDEVRGroupId());
        }
        if (!bl || this.isDstPSDEVRGroupNameDirty()) {
            hashMap.put(FIELD_DSTPSDEVRGROUPNAME, this.getDstPSDEVRGroupName());
        }
        if (!bl || this.isDstPSDEWizardIdDirty()) {
            hashMap.put(FIELD_DSTPSDEWIZARDID, this.getDstPSDEWizardId());
        }
        if (!bl || this.isDstPSDEWizardNameDirty()) {
            hashMap.put(FIELD_DSTPSDEWIZARDNAME, this.getDstPSDEWizardName());
        }
        if (!bl || this.isDstPSDLParamIdDirty()) {
            hashMap.put(FIELD_DSTPSDLPARAMID, this.getDstPSDLParamId());
        }
        if (!bl || this.isDstPSDLParamNameDirty()) {
            hashMap.put(FIELD_DSTPSDLPARAMNAME, this.getDstPSDLParamName());
        }
        if (!bl || this.isDstSortDirDirty()) {
            hashMap.put(FIELD_DSTSORTDIR, this.getDstSortDir());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isISPSDLParamIdDirty()) {
            hashMap.put(FIELD_ISPSDLPARAMID, this.getISPSDLParamId());
        }
        if (!bl || this.isISPSDLParamNameDirty()) {
            hashMap.put(FIELD_ISPSDLPARAMNAME, this.getISPSDLParamName());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isLogicNodeSubTypeDirty()) {
            hashMap.put(FIELD_LOGICNODESUBTYPE, this.getLogicNodeSubType());
        }
        if (!bl || this.isLogicNodeTypeDirty()) {
            hashMap.put(FIELD_LOGICNODETYPE, this.getLogicNodeType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMsgPSLanResIdDirty()) {
            hashMap.put(FIELD_MSGPSLANRESID, this.getMsgPSLanResId());
        }
        if (!bl || this.isMsgPSLanResNameDirty()) {
            hashMap.put(FIELD_MSGPSLANRESNAME, this.getMsgPSLanResName());
        }
        if (!bl || this.isNodeParamsDirty()) {
            hashMap.put(FIELD_NODEPARAMS, this.getNodeParams());
        }
        if (!bl || this.isOptPSDLParamIdDirty()) {
            hashMap.put(FIELD_OPTPSDLPARAMID, this.getOptPSDLParamId());
        }
        if (!bl || this.isOptPSDLParamNameDirty()) {
            hashMap.put(FIELD_OPTPSDLPARAMNAME, this.getOptPSDLParamName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isOSPSDLParamIdDirty()) {
            hashMap.put(FIELD_OSPSDLPARAMID, this.getOSPSDLParamId());
        }
        if (!bl || this.isOSPSDLParamNameDirty()) {
            hashMap.put(FIELD_OSPSDLPARAMNAME, this.getOSPSDLParamName());
        }
        if (!bl || this.isParallelOutputDirty()) {
            hashMap.put(FIELD_PARALLELOUTPUT, this.getParallelOutput());
        }
        if (!bl || this.isParam1Dirty()) {
            hashMap.put(FIELD_PARAM1, this.getParam1());
        }
        if (!bl || this.isParam10Dirty()) {
            hashMap.put(FIELD_PARAM10, this.getParam10());
        }
        if (!bl || this.isParam11Dirty()) {
            hashMap.put(FIELD_PARAM11, this.getParam11());
        }
        if (!bl || this.isParam12Dirty()) {
            hashMap.put(FIELD_PARAM12, this.getParam12());
        }
        if (!bl || this.isParam13Dirty()) {
            hashMap.put(FIELD_PARAM13, this.getParam13());
        }
        if (!bl || this.isParam14Dirty()) {
            hashMap.put(FIELD_PARAM14, this.getParam14());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isParam9Dirty()) {
            hashMap.put(FIELD_PARAM9, this.getParam9());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSDELOGICNODEID, this.getPSDELogicNodeId());
        }
        if (!bl || this.isPSDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNODENAME, this.getPSDELogicNodeName());
        }
        if (!bl || this.isPSDEMainStateIdDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATEID, this.getPSDEMainStateId());
        }
        if (!bl || this.isPSDEMainStateNameDirty()) {
            hashMap.put(FIELD_PSDEMAINSTATENAME, this.getPSDEMainStateName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSubSysSADetailIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILID, this.getPSSubSysSADetailId());
        }
        if (!bl || this.isPSSubSysSADetailNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSADETAILNAME, this.getPSSubSysSADetailName());
        }
        if (!bl || this.isPSSubSysServiceAPIIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPIID, this.getPSSubSysServiceAPIId());
        }
        if (!bl || this.isPSSubSysServiceAPINameDirty()) {
            hashMap.put(FIELD_PSSUBSYSSERVICEAPINAME, this.getPSSubSysServiceAPIName());
        }
        if (!bl || this.isPSSysAIChatAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTID, this.getPSSysAIChatAgentId());
        }
        if (!bl || this.isPSSysAIChatAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAICHATAGENTNAME, this.getPSSysAIChatAgentName());
        }
        if (!bl || this.isPSSysAIFactoryIdDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYID, this.getPSSysAIFactoryId());
        }
        if (!bl || this.isPSSysAIFactoryNameDirty()) {
            hashMap.put(FIELD_PSSYSAIFACTORYNAME, this.getPSSysAIFactoryName());
        }
        if (!bl || this.isPSSysAIPipelineAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEAGENTID, this.getPSSysAIPipelineAgentId());
        }
        if (!bl || this.isPSSysAIPipelineAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, this.getPSSysAIPipelineAgentName());
        }
        if (!bl || this.isPSSysAIWorkerAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTID, this.getPSSysAIWorkerAgentId());
        }
        if (!bl || this.isPSSysAIWorkerAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSAIWORKERAGENTNAME, this.getPSSysAIWorkerAgentName());
        }
        if (!bl || this.isPSSysBackServiceIdDirty()) {
            hashMap.put(FIELD_PSSYSBACKSERVICEID, this.getPSSysBackServiceId());
        }
        if (!bl || this.isPSSysBackServiceNameDirty()) {
            hashMap.put(FIELD_PSSYSBACKSERVICENAME, this.getPSSysBackServiceName());
        }
        if (!bl || this.isPSSysBDSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMEID, this.getPSSysBDSchemeId());
        }
        if (!bl || this.isPSSysBDSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBDSCHEMENAME, this.getPSSysBDSchemeName());
        }
        if (!bl || this.isPSSysBDTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLEID, this.getPSSysBDTableId());
        }
        if (!bl || this.isPSSysBDTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBDTABLENAME, this.getPSSysBDTableName());
        }
        if (!bl || this.isPSSysBIAggTableIdDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLEID, this.getPSSysBIAggTableId());
        }
        if (!bl || this.isPSSysBIAggTableNameDirty()) {
            hashMap.put(FIELD_PSSYSBIAGGTABLENAME, this.getPSSysBIAggTableName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBIReportIdDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTID, this.getPSSysBIReportId());
        }
        if (!bl || this.isPSSysBIReportNameDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTNAME, this.getPSSysBIReportName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isPSSysDataSyncAgentIdDirty()) {
            hashMap.put(FIELD_PSSYSDATASYNCAGENTID, this.getPSSysDataSyncAgentId());
        }
        if (!bl || this.isPSSysDataSyncAgentNameDirty()) {
            hashMap.put(FIELD_PSSYSDATASYNCAGENTNAME, this.getPSSysDataSyncAgentName());
        }
        if (!bl || this.isPSSysDBSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMEID, this.getPSSysDBSchemeId());
        }
        if (!bl || this.isPSSysDBSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSDBSCHEMENAME, this.getPSSysDBSchemeName());
        }
        if (!bl || this.isPSSysDBTableIdDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLEID, this.getPSSysDBTableId());
        }
        if (!bl || this.isPSSysDBTableNameDirty()) {
            hashMap.put(FIELD_PSSYSDBTABLENAME, this.getPSSysDBTableName());
        }
        if (!bl || this.isPSSysDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODEID, this.getPSSysDELogicNodeId());
        }
        if (!bl || this.isPSSysDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSSYSDELOGICNODENAME, this.getPSSysDELogicNodeName());
        }
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTNAME, this.getPSSysEAIElementName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSearchDocIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCID, this.getPSSysSearchDocId());
        }
        if (!bl || this.isPSSysSearchDocNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHDOCNAME, this.getPSSysSearchDocName());
        }
        if (!bl || this.isPSSysSearchSchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMEID, this.getPSSysSearchSchemeId());
        }
        if (!bl || this.isPSSysSearchSchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSSEARCHSCHEMENAME, this.getPSSysSearchSchemeName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysSQLCmdIdDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDID, this.getPSSysSQLCmdId());
        }
        if (!bl || this.isPSSysSQLCmdNameDirty()) {
            hashMap.put(FIELD_PSSYSSQLCMDNAME, this.getPSSysSQLCmdName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysUniStateIdDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATEID, this.getPSSysUniStateId());
        }
        if (!bl || this.isPSSysUniStateNameDirty()) {
            hashMap.put(FIELD_PSSYSUNISTATENAME, this.getPSSysUniStateName());
        }
        if (!bl || this.isPSSysUtilDEIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILDEID, this.getPSSysUtilDEId());
        }
        if (!bl || this.isPSSysUtilDENameDirty()) {
            hashMap.put(FIELD_PSSYSUTILDENAME, this.getPSSysUtilDEName());
        }
        if (!bl || this.isPSViewMsgIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGID, this.getPSViewMsgId());
        }
        if (!bl || this.isPSViewMsgNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGNAME, this.getPSViewMsgName());
        }
        if (!bl || this.isPSWFDEIdDirty()) {
            hashMap.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bl || this.isPSWFDENameDirty()) {
            hashMap.put(FIELD_PSWFDENAME, this.getPSWFDEName());
        }
        if (!bl || this.isPSWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWORKFLOWID, this.getPSWorkflowId());
        }
        if (!bl || this.isPSWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWORKFLOWNAME, this.getPSWorkflowName());
        }
        if (!bl || this.isRetPSDLParamIdDirty()) {
            hashMap.put(FIELD_RETPSDLPARAMID, this.getRetPSDLParamId());
        }
        if (!bl || this.isRetPSDLParamNameDirty()) {
            hashMap.put(FIELD_RETPSDLPARAMNAME, this.getRetPSDLParamName());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
        }
        if (!bl || this.isSrcIndexDirty()) {
            hashMap.put(FIELD_SRCINDEX, this.getSrcIndex());
        }
        if (!bl || this.isSrcPSDLParamIdDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMID, this.getSrcPSDLParamId());
        }
        if (!bl || this.isSrcPSDLParamNameDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMNAME, this.getSrcPSDLParamName());
        }
        if (!bl || this.isSrcSizeDirty()) {
            hashMap.put(FIELD_SRCSIZE, this.getSrcSize());
        }
        if (!bl || this.isThreadRunModeDirty()) {
            hashMap.put(FIELD_THREADRUNMODE, this.getThreadRunMode());
        }
        if (!bl || this.isThreadRunTimerDirty()) {
            hashMap.put(FIELD_THREADRUNTIMER, this.getThreadRunTimer());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
        }
        if (!bl || this.isTSModeDirty()) {
            hashMap.put(FIELD_TSMODE, this.getTSMode());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSDELogicNodeBase.get(this, n);
    }

    private static Object get(PSDELogicNodeBase pSDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicNodeBase.getCodeName();
            }
            case 1: {
                return pSDELogicNodeBase.getCreateDate();
            }
            case 2: {
                return pSDELogicNodeBase.getCreateMan();
            }
            case 3: {
                return pSDELogicNodeBase.getCustomDSTParam();
            }
            case 4: {
                return pSDELogicNodeBase.getCustomSrcParam();
            }
            case 5: {
                return pSDELogicNodeBase.getDebugMode();
            }
            case 6: {
                return pSDELogicNodeBase.getDstPSDEUtilDEId();
            }
            case 7: {
                return pSDELogicNodeBase.getDstPSDEUtilDEName();
            }
            case 8: {
                return pSDELogicNodeBase.getDstIndex();
            }
            case 9: {
                return pSDELogicNodeBase.getDstParamAction();
            }
            case 10: {
                return pSDELogicNodeBase.getDstPSDEActionId();
            }
            case 11: {
                return pSDELogicNodeBase.getDstPSDEActionName();
            }
            case 12: {
                return pSDELogicNodeBase.getDstPSDEDataExpId();
            }
            case 13: {
                return pSDELogicNodeBase.getDstPSDEDataExpName();
            }
            case 14: {
                return pSDELogicNodeBase.getDstPSDEDataFlowId();
            }
            case 15: {
                return pSDELogicNodeBase.getDstPSDEDataFlowName();
            }
            case 16: {
                return pSDELogicNodeBase.getDstPSDEDataImpId();
            }
            case 17: {
                return pSDELogicNodeBase.getDstPSDEDataImpName();
            }
            case 18: {
                return pSDELogicNodeBase.getDstPSDEDataQueryId();
            }
            case 19: {
                return pSDELogicNodeBase.getDstPSDEDataQueryName();
            }
            case 20: {
                return pSDELogicNodeBase.getDstPSDEDataSetId();
            }
            case 21: {
                return pSDELogicNodeBase.getDstPSDEDataSetName();
            }
            case 22: {
                return pSDELogicNodeBase.getDstPSDEDataSyncId();
            }
            case 23: {
                return pSDELogicNodeBase.getDstPSDEDataSyncName();
            }
            case 24: {
                return pSDELogicNodeBase.getDstPSDEDTSQueueId();
            }
            case 25: {
                return pSDELogicNodeBase.getDstPSDEDTSQueueName();
            }
            case 26: {
                return pSDELogicNodeBase.getDstPSDEFGroupId();
            }
            case 27: {
                return pSDELogicNodeBase.getDstPSDEFGroupName();
            }
            case 28: {
                return pSDELogicNodeBase.getDstPSDEFormId();
            }
            case 29: {
                return pSDELogicNodeBase.getDstPSDEFormName();
            }
            case 30: {
                return pSDELogicNodeBase.getDstPSDEFValueRuleId();
            }
            case 31: {
                return pSDELogicNodeBase.getDstPSDEFValueRuleName();
            }
            case 32: {
                return pSDELogicNodeBase.getDstPSDEId();
            }
            case 33: {
                return pSDELogicNodeBase.getDstPSDELogicId();
            }
            case 34: {
                return pSDELogicNodeBase.getDstPSDELogicName();
            }
            case 35: {
                return pSDELogicNodeBase.getDstPSDEMapId();
            }
            case 36: {
                return pSDELogicNodeBase.getDstPSDEMapName();
            }
            case 37: {
                return pSDELogicNodeBase.getDstPSDEName();
            }
            case 38: {
                return pSDELogicNodeBase.getDstPSDENotifyId();
            }
            case 39: {
                return pSDELogicNodeBase.getDstPSDENotifyName();
            }
            case 40: {
                return pSDELogicNodeBase.getDstPSDEPrintId();
            }
            case 41: {
                return pSDELogicNodeBase.getDstPSDEPrintName();
            }
            case 42: {
                return pSDELogicNodeBase.getDstPSDEReportId();
            }
            case 43: {
                return pSDELogicNodeBase.getDstPSDEReportName();
            }
            case 44: {
                return pSDELogicNodeBase.getDstPSDESampleDataId();
            }
            case 45: {
                return pSDELogicNodeBase.getDstPSDESampleDataName();
            }
            case 46: {
                return pSDELogicNodeBase.getDstPSDEUAGroupId();
            }
            case 47: {
                return pSDELogicNodeBase.getDstPSDEUAGroupName();
            }
            case 48: {
                return pSDELogicNodeBase.getDstPSDEUILogicId();
            }
            case 49: {
                return pSDELogicNodeBase.getDstPSDEUILogicName();
            }
            case 50: {
                return pSDELogicNodeBase.getDstPSDEViewId();
            }
            case 51: {
                return pSDELogicNodeBase.getDstPSDEViewName();
            }
            case 52: {
                return pSDELogicNodeBase.getDstPSDEVRGroupId();
            }
            case 53: {
                return pSDELogicNodeBase.getDstPSDEVRGroupName();
            }
            case 54: {
                return pSDELogicNodeBase.getDstPSDEWizardId();
            }
            case 55: {
                return pSDELogicNodeBase.getDstPSDEWizardName();
            }
            case 56: {
                return pSDELogicNodeBase.getDstPSDLParamId();
            }
            case 57: {
                return pSDELogicNodeBase.getDstPSDLParamName();
            }
            case 58: {
                return pSDELogicNodeBase.getDstSortDir();
            }
            case 59: {
                return pSDELogicNodeBase.getDynaModelFlag();
            }
            case 60: {
                return pSDELogicNodeBase.getISPSDLParamId();
            }
            case 61: {
                return pSDELogicNodeBase.getISPSDLParamName();
            }
            case 62: {
                return pSDELogicNodeBase.getLeftPos();
            }
            case 63: {
                return pSDELogicNodeBase.getLogicNodeSubType();
            }
            case 64: {
                return pSDELogicNodeBase.getLogicNodeType();
            }
            case 65: {
                return pSDELogicNodeBase.getMemo();
            }
            case 66: {
                return pSDELogicNodeBase.getMsgPSLanResId();
            }
            case 67: {
                return pSDELogicNodeBase.getMsgPSLanResName();
            }
            case 68: {
                return pSDELogicNodeBase.getNodeParams();
            }
            case 69: {
                return pSDELogicNodeBase.getOptPSDLParamId();
            }
            case 70: {
                return pSDELogicNodeBase.getOptPSDLParamName();
            }
            case 71: {
                return pSDELogicNodeBase.getOrderValue();
            }
            case 72: {
                return pSDELogicNodeBase.getOSPSDLParamId();
            }
            case 73: {
                return pSDELogicNodeBase.getOSPSDLParamName();
            }
            case 74: {
                return pSDELogicNodeBase.getParallelOutput();
            }
            case 75: {
                return pSDELogicNodeBase.getParam1();
            }
            case 76: {
                return pSDELogicNodeBase.getParam10();
            }
            case 77: {
                return pSDELogicNodeBase.getParam11();
            }
            case 78: {
                return pSDELogicNodeBase.getParam12();
            }
            case 79: {
                return pSDELogicNodeBase.getParam13();
            }
            case 80: {
                return pSDELogicNodeBase.getParam14();
            }
            case 81: {
                return pSDELogicNodeBase.getParam2();
            }
            case 82: {
                return pSDELogicNodeBase.getParam3();
            }
            case 83: {
                return pSDELogicNodeBase.getParam4();
            }
            case 84: {
                return pSDELogicNodeBase.getParam5();
            }
            case 85: {
                return pSDELogicNodeBase.getParam6();
            }
            case 86: {
                return pSDELogicNodeBase.getParam7();
            }
            case 87: {
                return pSDELogicNodeBase.getParam8();
            }
            case 88: {
                return pSDELogicNodeBase.getParam9();
            }
            case 89: {
                return pSDELogicNodeBase.getPSDEId();
            }
            case 90: {
                return pSDELogicNodeBase.getPSDELogicId();
            }
            case 91: {
                return pSDELogicNodeBase.getPSDELogicName();
            }
            case 92: {
                return pSDELogicNodeBase.getPSDELogicNodeId();
            }
            case 93: {
                return pSDELogicNodeBase.getPSDELogicNodeName();
            }
            case 94: {
                return pSDELogicNodeBase.getPSDEMainStateId();
            }
            case 95: {
                return pSDELogicNodeBase.getPSDEMainStateName();
            }
            case 96: {
                return pSDELogicNodeBase.getPSDEUIActionId();
            }
            case 97: {
                return pSDELogicNodeBase.getPSDEUIActionName();
            }
            case 98: {
                return pSDELogicNodeBase.getPSDynaInstId();
            }
            case 99: {
                return pSDELogicNodeBase.getPSSubSysSADetailId();
            }
            case 100: {
                return pSDELogicNodeBase.getPSSubSysSADetailName();
            }
            case 101: {
                return pSDELogicNodeBase.getPSSubSysServiceAPIId();
            }
            case 102: {
                return pSDELogicNodeBase.getPSSubSysServiceAPIName();
            }
            case 103: {
                return pSDELogicNodeBase.getPSSysAIChatAgentId();
            }
            case 104: {
                return pSDELogicNodeBase.getPSSysAIChatAgentName();
            }
            case 105: {
                return pSDELogicNodeBase.getPSSysAIFactoryId();
            }
            case 106: {
                return pSDELogicNodeBase.getPSSysAIFactoryName();
            }
            case 107: {
                return pSDELogicNodeBase.getPSSysAIPipelineAgentId();
            }
            case 108: {
                return pSDELogicNodeBase.getPSSysAIPipelineAgentName();
            }
            case 109: {
                return pSDELogicNodeBase.getPSSysAIWorkerAgentId();
            }
            case 110: {
                return pSDELogicNodeBase.getPSSysAIWorkerAgentName();
            }
            case 111: {
                return pSDELogicNodeBase.getPSSysBackServiceId();
            }
            case 112: {
                return pSDELogicNodeBase.getPSSysBackServiceName();
            }
            case 113: {
                return pSDELogicNodeBase.getPSSysBDSchemeId();
            }
            case 114: {
                return pSDELogicNodeBase.getPSSysBDSchemeName();
            }
            case 115: {
                return pSDELogicNodeBase.getPSSysBDTableId();
            }
            case 116: {
                return pSDELogicNodeBase.getPSSysBDTableName();
            }
            case 117: {
                return pSDELogicNodeBase.getPSSysBIAggTableId();
            }
            case 118: {
                return pSDELogicNodeBase.getPSSysBIAggTableName();
            }
            case 119: {
                return pSDELogicNodeBase.getPSSysBICubeId();
            }
            case 120: {
                return pSDELogicNodeBase.getPSSysBICubeName();
            }
            case 121: {
                return pSDELogicNodeBase.getPSSysBIReportId();
            }
            case 122: {
                return pSDELogicNodeBase.getPSSysBIReportName();
            }
            case 123: {
                return pSDELogicNodeBase.getPSSysBISchemeId();
            }
            case 124: {
                return pSDELogicNodeBase.getPSSysBISchemeName();
            }
            case 125: {
                return pSDELogicNodeBase.getPSSysDataSyncAgentId();
            }
            case 126: {
                return pSDELogicNodeBase.getPSSysDataSyncAgentName();
            }
            case 127: {
                return pSDELogicNodeBase.getPSSysDBSchemeId();
            }
            case 128: {
                return pSDELogicNodeBase.getPSSysDBSchemeName();
            }
            case 129: {
                return pSDELogicNodeBase.getPSSysDBTableId();
            }
            case 130: {
                return pSDELogicNodeBase.getPSSysDBTableName();
            }
            case 131: {
                return pSDELogicNodeBase.getPSSysDELogicNodeId();
            }
            case 132: {
                return pSDELogicNodeBase.getPSSysDELogicNodeName();
            }
            case 133: {
                return pSDELogicNodeBase.getPSSysEAIElementId();
            }
            case 134: {
                return pSDELogicNodeBase.getPSSysEAIElementName();
            }
            case 135: {
                return pSDELogicNodeBase.getPSSysEAISchemeId();
            }
            case 136: {
                return pSDELogicNodeBase.getPSSysEAISchemeName();
            }
            case 137: {
                return pSDELogicNodeBase.getPSSysMsgTemplId();
            }
            case 138: {
                return pSDELogicNodeBase.getPSSysMsgTemplName();
            }
            case 139: {
                return pSDELogicNodeBase.getPSSysPFPluginId();
            }
            case 140: {
                return pSDELogicNodeBase.getPSSysPFPluginName();
            }
            case 141: {
                return pSDELogicNodeBase.getPSSysResourceId();
            }
            case 142: {
                return pSDELogicNodeBase.getPSSysResourceName();
            }
            case 143: {
                return pSDELogicNodeBase.getPSSysSearchDocId();
            }
            case 144: {
                return pSDELogicNodeBase.getPSSysSearchDocName();
            }
            case 145: {
                return pSDELogicNodeBase.getPSSysSearchSchemeId();
            }
            case 146: {
                return pSDELogicNodeBase.getPSSysSearchSchemeName();
            }
            case 147: {
                return pSDELogicNodeBase.getPSSysSFPluginId();
            }
            case 148: {
                return pSDELogicNodeBase.getPSSysSFPluginName();
            }
            case 149: {
                return pSDELogicNodeBase.getPSSysSQLCmdId();
            }
            case 150: {
                return pSDELogicNodeBase.getPSSysSQLCmdName();
            }
            case 151: {
                return pSDELogicNodeBase.getPSSystemId();
            }
            case 152: {
                return pSDELogicNodeBase.getPSSysUniStateId();
            }
            case 153: {
                return pSDELogicNodeBase.getPSSysUniStateName();
            }
            case 154: {
                return pSDELogicNodeBase.getPSSysUtilDEId();
            }
            case 155: {
                return pSDELogicNodeBase.getPSSysUtilDEName();
            }
            case 156: {
                return pSDELogicNodeBase.getPSViewMsgId();
            }
            case 157: {
                return pSDELogicNodeBase.getPSViewMsgName();
            }
            case 158: {
                return pSDELogicNodeBase.getPSWFDEId();
            }
            case 159: {
                return pSDELogicNodeBase.getPSWFDEName();
            }
            case 160: {
                return pSDELogicNodeBase.getPSWorkflowId();
            }
            case 161: {
                return pSDELogicNodeBase.getPSWorkflowName();
            }
            case 162: {
                return pSDELogicNodeBase.getRetPSDLParamId();
            }
            case 163: {
                return pSDELogicNodeBase.getRetPSDLParamName();
            }
            case 164: {
                return pSDELogicNodeBase.getShapeParams();
            }
            case 165: {
                return pSDELogicNodeBase.getSrcIndex();
            }
            case 166: {
                return pSDELogicNodeBase.getSrcPSDLParamId();
            }
            case 167: {
                return pSDELogicNodeBase.getSrcPSDLParamName();
            }
            case 168: {
                return pSDELogicNodeBase.getSrcSize();
            }
            case 169: {
                return pSDELogicNodeBase.getThreadRunMode();
            }
            case 170: {
                return pSDELogicNodeBase.getThreadRunTimer();
            }
            case 171: {
                return pSDELogicNodeBase.getTopPos();
            }
            case 172: {
                return pSDELogicNodeBase.getTSMode();
            }
            case 173: {
                return pSDELogicNodeBase.getUpdateDate();
            }
            case 174: {
                return pSDELogicNodeBase.getUpdateMan();
            }
            case 175: {
                return pSDELogicNodeBase.getUserCat();
            }
            case 176: {
                return pSDELogicNodeBase.getUserParams();
            }
            case 177: {
                return pSDELogicNodeBase.getUserTag();
            }
            case 178: {
                return pSDELogicNodeBase.getUserTag2();
            }
            case 179: {
                return pSDELogicNodeBase.getUserTag3();
            }
            case 180: {
                return pSDELogicNodeBase.getUserTag4();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSDELogicNodeBase.set(this, n, object);
    }

    private static void set(PSDELogicNodeBase pSDELogicNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicNodeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELogicNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELogicNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELogicNodeBase.setCustomDSTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELogicNodeBase.setCustomSrcParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELogicNodeBase.setDebugMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDELogicNodeBase.setDstPSDEUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELogicNodeBase.setDstPSDEUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELogicNodeBase.setDstIndex(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDELogicNodeBase.setDstParamAction(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELogicNodeBase.setDstPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELogicNodeBase.setDstPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELogicNodeBase.setDstPSDEDataExpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDELogicNodeBase.setDstPSDEDataExpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDELogicNodeBase.setDstPSDEDataFlowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDELogicNodeBase.setDstPSDEDataFlowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDELogicNodeBase.setDstPSDEDataImpId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELogicNodeBase.setDstPSDEDataImpName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELogicNodeBase.setDstPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELogicNodeBase.setDstPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELogicNodeBase.setDstPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELogicNodeBase.setDstPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELogicNodeBase.setDstPSDEDataSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELogicNodeBase.setDstPSDEDataSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELogicNodeBase.setDstPSDEDTSQueueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELogicNodeBase.setDstPSDEDTSQueueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDELogicNodeBase.setDstPSDEFGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELogicNodeBase.setDstPSDEFGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDELogicNodeBase.setDstPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDELogicNodeBase.setDstPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELogicNodeBase.setDstPSDEFValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELogicNodeBase.setDstPSDEFValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELogicNodeBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELogicNodeBase.setDstPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDELogicNodeBase.setDstPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDELogicNodeBase.setDstPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDELogicNodeBase.setDstPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDELogicNodeBase.setDstPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDELogicNodeBase.setDstPSDENotifyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDELogicNodeBase.setDstPSDENotifyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDELogicNodeBase.setDstPSDEPrintId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDELogicNodeBase.setDstPSDEPrintName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDELogicNodeBase.setDstPSDEReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDELogicNodeBase.setDstPSDEReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDELogicNodeBase.setDstPSDESampleDataId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDELogicNodeBase.setDstPSDESampleDataName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDELogicNodeBase.setDstPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDELogicNodeBase.setDstPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDELogicNodeBase.setDstPSDEUILogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDELogicNodeBase.setDstPSDEUILogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDELogicNodeBase.setDstPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDELogicNodeBase.setDstPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSDELogicNodeBase.setDstPSDEVRGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDELogicNodeBase.setDstPSDEVRGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDELogicNodeBase.setDstPSDEWizardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 55: {
                pSDELogicNodeBase.setDstPSDEWizardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDELogicNodeBase.setDstPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDELogicNodeBase.setDstPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDELogicNodeBase.setDstSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDELogicNodeBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 60: {
                pSDELogicNodeBase.setISPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSDELogicNodeBase.setISPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSDELogicNodeBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 63: {
                pSDELogicNodeBase.setLogicNodeSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSDELogicNodeBase.setLogicNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSDELogicNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSDELogicNodeBase.setMsgPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 67: {
                pSDELogicNodeBase.setMsgPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSDELogicNodeBase.setNodeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 69: {
                pSDELogicNodeBase.setOptPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 70: {
                pSDELogicNodeBase.setOptPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 71: {
                pSDELogicNodeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 72: {
                pSDELogicNodeBase.setOSPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 73: {
                pSDELogicNodeBase.setOSPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 74: {
                pSDELogicNodeBase.setParallelOutput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 75: {
                pSDELogicNodeBase.setParam1(DataObject.getStringValue((Object)object));
                return;
            }
            case 76: {
                pSDELogicNodeBase.setParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 77: {
                pSDELogicNodeBase.setParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 78: {
                pSDELogicNodeBase.setParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 79: {
                pSDELogicNodeBase.setParam13(DataObject.getStringValue((Object)object));
                return;
            }
            case 80: {
                pSDELogicNodeBase.setParam14(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSDELogicNodeBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 82: {
                pSDELogicNodeBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 83: {
                pSDELogicNodeBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 84: {
                pSDELogicNodeBase.setParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 85: {
                pSDELogicNodeBase.setParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 86: {
                pSDELogicNodeBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 87: {
                pSDELogicNodeBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 88: {
                pSDELogicNodeBase.setParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 89: {
                pSDELogicNodeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 90: {
                pSDELogicNodeBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 91: {
                pSDELogicNodeBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 92: {
                pSDELogicNodeBase.setPSDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 93: {
                pSDELogicNodeBase.setPSDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 94: {
                pSDELogicNodeBase.setPSDEMainStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 95: {
                pSDELogicNodeBase.setPSDEMainStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 96: {
                pSDELogicNodeBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 97: {
                pSDELogicNodeBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 98: {
                pSDELogicNodeBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 99: {
                pSDELogicNodeBase.setPSSubSysSADetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 100: {
                pSDELogicNodeBase.setPSSubSysSADetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 101: {
                pSDELogicNodeBase.setPSSubSysServiceAPIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 102: {
                pSDELogicNodeBase.setPSSubSysServiceAPIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 103: {
                pSDELogicNodeBase.setPSSysAIChatAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 104: {
                pSDELogicNodeBase.setPSSysAIChatAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 105: {
                pSDELogicNodeBase.setPSSysAIFactoryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 106: {
                pSDELogicNodeBase.setPSSysAIFactoryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 107: {
                pSDELogicNodeBase.setPSSysAIPipelineAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 108: {
                pSDELogicNodeBase.setPSSysAIPipelineAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 109: {
                pSDELogicNodeBase.setPSSysAIWorkerAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 110: {
                pSDELogicNodeBase.setPSSysAIWorkerAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 111: {
                pSDELogicNodeBase.setPSSysBackServiceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 112: {
                pSDELogicNodeBase.setPSSysBackServiceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 113: {
                pSDELogicNodeBase.setPSSysBDSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 114: {
                pSDELogicNodeBase.setPSSysBDSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 115: {
                pSDELogicNodeBase.setPSSysBDTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 116: {
                pSDELogicNodeBase.setPSSysBDTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 117: {
                pSDELogicNodeBase.setPSSysBIAggTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 118: {
                pSDELogicNodeBase.setPSSysBIAggTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 119: {
                pSDELogicNodeBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 120: {
                pSDELogicNodeBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 121: {
                pSDELogicNodeBase.setPSSysBIReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 122: {
                pSDELogicNodeBase.setPSSysBIReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 123: {
                pSDELogicNodeBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 124: {
                pSDELogicNodeBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 125: {
                pSDELogicNodeBase.setPSSysDataSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 126: {
                pSDELogicNodeBase.setPSSysDataSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 127: {
                pSDELogicNodeBase.setPSSysDBSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 128: {
                pSDELogicNodeBase.setPSSysDBSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 129: {
                pSDELogicNodeBase.setPSSysDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 130: {
                pSDELogicNodeBase.setPSSysDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 131: {
                pSDELogicNodeBase.setPSSysDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 132: {
                pSDELogicNodeBase.setPSSysDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 133: {
                pSDELogicNodeBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 134: {
                pSDELogicNodeBase.setPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 135: {
                pSDELogicNodeBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 136: {
                pSDELogicNodeBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 137: {
                pSDELogicNodeBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 138: {
                pSDELogicNodeBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 139: {
                pSDELogicNodeBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 140: {
                pSDELogicNodeBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 141: {
                pSDELogicNodeBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 142: {
                pSDELogicNodeBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 143: {
                pSDELogicNodeBase.setPSSysSearchDocId(DataObject.getStringValue((Object)object));
                return;
            }
            case 144: {
                pSDELogicNodeBase.setPSSysSearchDocName(DataObject.getStringValue((Object)object));
                return;
            }
            case 145: {
                pSDELogicNodeBase.setPSSysSearchSchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 146: {
                pSDELogicNodeBase.setPSSysSearchSchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 147: {
                pSDELogicNodeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 148: {
                pSDELogicNodeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 149: {
                pSDELogicNodeBase.setPSSysSQLCmdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 150: {
                pSDELogicNodeBase.setPSSysSQLCmdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 151: {
                pSDELogicNodeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 152: {
                pSDELogicNodeBase.setPSSysUniStateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 153: {
                pSDELogicNodeBase.setPSSysUniStateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 154: {
                pSDELogicNodeBase.setPSSysUtilDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 155: {
                pSDELogicNodeBase.setPSSysUtilDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 156: {
                pSDELogicNodeBase.setPSViewMsgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 157: {
                pSDELogicNodeBase.setPSViewMsgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 158: {
                pSDELogicNodeBase.setPSWFDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 159: {
                pSDELogicNodeBase.setPSWFDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 160: {
                pSDELogicNodeBase.setPSWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 161: {
                pSDELogicNodeBase.setPSWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 162: {
                pSDELogicNodeBase.setRetPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 163: {
                pSDELogicNodeBase.setRetPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 164: {
                pSDELogicNodeBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 165: {
                pSDELogicNodeBase.setSrcIndex(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 166: {
                pSDELogicNodeBase.setSrcPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 167: {
                pSDELogicNodeBase.setSrcPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 168: {
                pSDELogicNodeBase.setSrcSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 169: {
                pSDELogicNodeBase.setThreadRunMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 170: {
                pSDELogicNodeBase.setThreadRunTimer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 171: {
                pSDELogicNodeBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 172: {
                pSDELogicNodeBase.setTSMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 173: {
                pSDELogicNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 174: {
                pSDELogicNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 175: {
                pSDELogicNodeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 176: {
                pSDELogicNodeBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 177: {
                pSDELogicNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 178: {
                pSDELogicNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 179: {
                pSDELogicNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 180: {
                pSDELogicNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSDELogicNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDELogicNodeBase pSDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicNodeBase.getCodeName() == null;
            }
            case 1: {
                return pSDELogicNodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELogicNodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELogicNodeBase.getCustomDSTParam() == null;
            }
            case 4: {
                return pSDELogicNodeBase.getCustomSrcParam() == null;
            }
            case 5: {
                return pSDELogicNodeBase.getDebugMode() == null;
            }
            case 6: {
                return pSDELogicNodeBase.getDstPSDEUtilDEId() == null;
            }
            case 7: {
                return pSDELogicNodeBase.getDstPSDEUtilDEName() == null;
            }
            case 8: {
                return pSDELogicNodeBase.getDstIndex() == null;
            }
            case 9: {
                return pSDELogicNodeBase.getDstParamAction() == null;
            }
            case 10: {
                return pSDELogicNodeBase.getDstPSDEActionId() == null;
            }
            case 11: {
                return pSDELogicNodeBase.getDstPSDEActionName() == null;
            }
            case 12: {
                return pSDELogicNodeBase.getDstPSDEDataExpId() == null;
            }
            case 13: {
                return pSDELogicNodeBase.getDstPSDEDataExpName() == null;
            }
            case 14: {
                return pSDELogicNodeBase.getDstPSDEDataFlowId() == null;
            }
            case 15: {
                return pSDELogicNodeBase.getDstPSDEDataFlowName() == null;
            }
            case 16: {
                return pSDELogicNodeBase.getDstPSDEDataImpId() == null;
            }
            case 17: {
                return pSDELogicNodeBase.getDstPSDEDataImpName() == null;
            }
            case 18: {
                return pSDELogicNodeBase.getDstPSDEDataQueryId() == null;
            }
            case 19: {
                return pSDELogicNodeBase.getDstPSDEDataQueryName() == null;
            }
            case 20: {
                return pSDELogicNodeBase.getDstPSDEDataSetId() == null;
            }
            case 21: {
                return pSDELogicNodeBase.getDstPSDEDataSetName() == null;
            }
            case 22: {
                return pSDELogicNodeBase.getDstPSDEDataSyncId() == null;
            }
            case 23: {
                return pSDELogicNodeBase.getDstPSDEDataSyncName() == null;
            }
            case 24: {
                return pSDELogicNodeBase.getDstPSDEDTSQueueId() == null;
            }
            case 25: {
                return pSDELogicNodeBase.getDstPSDEDTSQueueName() == null;
            }
            case 26: {
                return pSDELogicNodeBase.getDstPSDEFGroupId() == null;
            }
            case 27: {
                return pSDELogicNodeBase.getDstPSDEFGroupName() == null;
            }
            case 28: {
                return pSDELogicNodeBase.getDstPSDEFormId() == null;
            }
            case 29: {
                return pSDELogicNodeBase.getDstPSDEFormName() == null;
            }
            case 30: {
                return pSDELogicNodeBase.getDstPSDEFValueRuleId() == null;
            }
            case 31: {
                return pSDELogicNodeBase.getDstPSDEFValueRuleName() == null;
            }
            case 32: {
                return pSDELogicNodeBase.getDstPSDEId() == null;
            }
            case 33: {
                return pSDELogicNodeBase.getDstPSDELogicId() == null;
            }
            case 34: {
                return pSDELogicNodeBase.getDstPSDELogicName() == null;
            }
            case 35: {
                return pSDELogicNodeBase.getDstPSDEMapId() == null;
            }
            case 36: {
                return pSDELogicNodeBase.getDstPSDEMapName() == null;
            }
            case 37: {
                return pSDELogicNodeBase.getDstPSDEName() == null;
            }
            case 38: {
                return pSDELogicNodeBase.getDstPSDENotifyId() == null;
            }
            case 39: {
                return pSDELogicNodeBase.getDstPSDENotifyName() == null;
            }
            case 40: {
                return pSDELogicNodeBase.getDstPSDEPrintId() == null;
            }
            case 41: {
                return pSDELogicNodeBase.getDstPSDEPrintName() == null;
            }
            case 42: {
                return pSDELogicNodeBase.getDstPSDEReportId() == null;
            }
            case 43: {
                return pSDELogicNodeBase.getDstPSDEReportName() == null;
            }
            case 44: {
                return pSDELogicNodeBase.getDstPSDESampleDataId() == null;
            }
            case 45: {
                return pSDELogicNodeBase.getDstPSDESampleDataName() == null;
            }
            case 46: {
                return pSDELogicNodeBase.getDstPSDEUAGroupId() == null;
            }
            case 47: {
                return pSDELogicNodeBase.getDstPSDEUAGroupName() == null;
            }
            case 48: {
                return pSDELogicNodeBase.getDstPSDEUILogicId() == null;
            }
            case 49: {
                return pSDELogicNodeBase.getDstPSDEUILogicName() == null;
            }
            case 50: {
                return pSDELogicNodeBase.getDstPSDEViewId() == null;
            }
            case 51: {
                return pSDELogicNodeBase.getDstPSDEViewName() == null;
            }
            case 52: {
                return pSDELogicNodeBase.getDstPSDEVRGroupId() == null;
            }
            case 53: {
                return pSDELogicNodeBase.getDstPSDEVRGroupName() == null;
            }
            case 54: {
                return pSDELogicNodeBase.getDstPSDEWizardId() == null;
            }
            case 55: {
                return pSDELogicNodeBase.getDstPSDEWizardName() == null;
            }
            case 56: {
                return pSDELogicNodeBase.getDstPSDLParamId() == null;
            }
            case 57: {
                return pSDELogicNodeBase.getDstPSDLParamName() == null;
            }
            case 58: {
                return pSDELogicNodeBase.getDstSortDir() == null;
            }
            case 59: {
                return pSDELogicNodeBase.getDynaModelFlag() == null;
            }
            case 60: {
                return pSDELogicNodeBase.getISPSDLParamId() == null;
            }
            case 61: {
                return pSDELogicNodeBase.getISPSDLParamName() == null;
            }
            case 62: {
                return pSDELogicNodeBase.getLeftPos() == null;
            }
            case 63: {
                return pSDELogicNodeBase.getLogicNodeSubType() == null;
            }
            case 64: {
                return pSDELogicNodeBase.getLogicNodeType() == null;
            }
            case 65: {
                return pSDELogicNodeBase.getMemo() == null;
            }
            case 66: {
                return pSDELogicNodeBase.getMsgPSLanResId() == null;
            }
            case 67: {
                return pSDELogicNodeBase.getMsgPSLanResName() == null;
            }
            case 68: {
                return pSDELogicNodeBase.getNodeParams() == null;
            }
            case 69: {
                return pSDELogicNodeBase.getOptPSDLParamId() == null;
            }
            case 70: {
                return pSDELogicNodeBase.getOptPSDLParamName() == null;
            }
            case 71: {
                return pSDELogicNodeBase.getOrderValue() == null;
            }
            case 72: {
                return pSDELogicNodeBase.getOSPSDLParamId() == null;
            }
            case 73: {
                return pSDELogicNodeBase.getOSPSDLParamName() == null;
            }
            case 74: {
                return pSDELogicNodeBase.getParallelOutput() == null;
            }
            case 75: {
                return pSDELogicNodeBase.getParam1() == null;
            }
            case 76: {
                return pSDELogicNodeBase.getParam10() == null;
            }
            case 77: {
                return pSDELogicNodeBase.getParam11() == null;
            }
            case 78: {
                return pSDELogicNodeBase.getParam12() == null;
            }
            case 79: {
                return pSDELogicNodeBase.getParam13() == null;
            }
            case 80: {
                return pSDELogicNodeBase.getParam14() == null;
            }
            case 81: {
                return pSDELogicNodeBase.getParam2() == null;
            }
            case 82: {
                return pSDELogicNodeBase.getParam3() == null;
            }
            case 83: {
                return pSDELogicNodeBase.getParam4() == null;
            }
            case 84: {
                return pSDELogicNodeBase.getParam5() == null;
            }
            case 85: {
                return pSDELogicNodeBase.getParam6() == null;
            }
            case 86: {
                return pSDELogicNodeBase.getParam7() == null;
            }
            case 87: {
                return pSDELogicNodeBase.getParam8() == null;
            }
            case 88: {
                return pSDELogicNodeBase.getParam9() == null;
            }
            case 89: {
                return pSDELogicNodeBase.getPSDEId() == null;
            }
            case 90: {
                return pSDELogicNodeBase.getPSDELogicId() == null;
            }
            case 91: {
                return pSDELogicNodeBase.getPSDELogicName() == null;
            }
            case 92: {
                return pSDELogicNodeBase.getPSDELogicNodeId() == null;
            }
            case 93: {
                return pSDELogicNodeBase.getPSDELogicNodeName() == null;
            }
            case 94: {
                return pSDELogicNodeBase.getPSDEMainStateId() == null;
            }
            case 95: {
                return pSDELogicNodeBase.getPSDEMainStateName() == null;
            }
            case 96: {
                return pSDELogicNodeBase.getPSDEUIActionId() == null;
            }
            case 97: {
                return pSDELogicNodeBase.getPSDEUIActionName() == null;
            }
            case 98: {
                return pSDELogicNodeBase.getPSDynaInstId() == null;
            }
            case 99: {
                return pSDELogicNodeBase.getPSSubSysSADetailId() == null;
            }
            case 100: {
                return pSDELogicNodeBase.getPSSubSysSADetailName() == null;
            }
            case 101: {
                return pSDELogicNodeBase.getPSSubSysServiceAPIId() == null;
            }
            case 102: {
                return pSDELogicNodeBase.getPSSubSysServiceAPIName() == null;
            }
            case 103: {
                return pSDELogicNodeBase.getPSSysAIChatAgentId() == null;
            }
            case 104: {
                return pSDELogicNodeBase.getPSSysAIChatAgentName() == null;
            }
            case 105: {
                return pSDELogicNodeBase.getPSSysAIFactoryId() == null;
            }
            case 106: {
                return pSDELogicNodeBase.getPSSysAIFactoryName() == null;
            }
            case 107: {
                return pSDELogicNodeBase.getPSSysAIPipelineAgentId() == null;
            }
            case 108: {
                return pSDELogicNodeBase.getPSSysAIPipelineAgentName() == null;
            }
            case 109: {
                return pSDELogicNodeBase.getPSSysAIWorkerAgentId() == null;
            }
            case 110: {
                return pSDELogicNodeBase.getPSSysAIWorkerAgentName() == null;
            }
            case 111: {
                return pSDELogicNodeBase.getPSSysBackServiceId() == null;
            }
            case 112: {
                return pSDELogicNodeBase.getPSSysBackServiceName() == null;
            }
            case 113: {
                return pSDELogicNodeBase.getPSSysBDSchemeId() == null;
            }
            case 114: {
                return pSDELogicNodeBase.getPSSysBDSchemeName() == null;
            }
            case 115: {
                return pSDELogicNodeBase.getPSSysBDTableId() == null;
            }
            case 116: {
                return pSDELogicNodeBase.getPSSysBDTableName() == null;
            }
            case 117: {
                return pSDELogicNodeBase.getPSSysBIAggTableId() == null;
            }
            case 118: {
                return pSDELogicNodeBase.getPSSysBIAggTableName() == null;
            }
            case 119: {
                return pSDELogicNodeBase.getPSSysBICubeId() == null;
            }
            case 120: {
                return pSDELogicNodeBase.getPSSysBICubeName() == null;
            }
            case 121: {
                return pSDELogicNodeBase.getPSSysBIReportId() == null;
            }
            case 122: {
                return pSDELogicNodeBase.getPSSysBIReportName() == null;
            }
            case 123: {
                return pSDELogicNodeBase.getPSSysBISchemeId() == null;
            }
            case 124: {
                return pSDELogicNodeBase.getPSSysBISchemeName() == null;
            }
            case 125: {
                return pSDELogicNodeBase.getPSSysDataSyncAgentId() == null;
            }
            case 126: {
                return pSDELogicNodeBase.getPSSysDataSyncAgentName() == null;
            }
            case 127: {
                return pSDELogicNodeBase.getPSSysDBSchemeId() == null;
            }
            case 128: {
                return pSDELogicNodeBase.getPSSysDBSchemeName() == null;
            }
            case 129: {
                return pSDELogicNodeBase.getPSSysDBTableId() == null;
            }
            case 130: {
                return pSDELogicNodeBase.getPSSysDBTableName() == null;
            }
            case 131: {
                return pSDELogicNodeBase.getPSSysDELogicNodeId() == null;
            }
            case 132: {
                return pSDELogicNodeBase.getPSSysDELogicNodeName() == null;
            }
            case 133: {
                return pSDELogicNodeBase.getPSSysEAIElementId() == null;
            }
            case 134: {
                return pSDELogicNodeBase.getPSSysEAIElementName() == null;
            }
            case 135: {
                return pSDELogicNodeBase.getPSSysEAISchemeId() == null;
            }
            case 136: {
                return pSDELogicNodeBase.getPSSysEAISchemeName() == null;
            }
            case 137: {
                return pSDELogicNodeBase.getPSSysMsgTemplId() == null;
            }
            case 138: {
                return pSDELogicNodeBase.getPSSysMsgTemplName() == null;
            }
            case 139: {
                return pSDELogicNodeBase.getPSSysPFPluginId() == null;
            }
            case 140: {
                return pSDELogicNodeBase.getPSSysPFPluginName() == null;
            }
            case 141: {
                return pSDELogicNodeBase.getPSSysResourceId() == null;
            }
            case 142: {
                return pSDELogicNodeBase.getPSSysResourceName() == null;
            }
            case 143: {
                return pSDELogicNodeBase.getPSSysSearchDocId() == null;
            }
            case 144: {
                return pSDELogicNodeBase.getPSSysSearchDocName() == null;
            }
            case 145: {
                return pSDELogicNodeBase.getPSSysSearchSchemeId() == null;
            }
            case 146: {
                return pSDELogicNodeBase.getPSSysSearchSchemeName() == null;
            }
            case 147: {
                return pSDELogicNodeBase.getPSSysSFPluginId() == null;
            }
            case 148: {
                return pSDELogicNodeBase.getPSSysSFPluginName() == null;
            }
            case 149: {
                return pSDELogicNodeBase.getPSSysSQLCmdId() == null;
            }
            case 150: {
                return pSDELogicNodeBase.getPSSysSQLCmdName() == null;
            }
            case 151: {
                return pSDELogicNodeBase.getPSSystemId() == null;
            }
            case 152: {
                return pSDELogicNodeBase.getPSSysUniStateId() == null;
            }
            case 153: {
                return pSDELogicNodeBase.getPSSysUniStateName() == null;
            }
            case 154: {
                return pSDELogicNodeBase.getPSSysUtilDEId() == null;
            }
            case 155: {
                return pSDELogicNodeBase.getPSSysUtilDEName() == null;
            }
            case 156: {
                return pSDELogicNodeBase.getPSViewMsgId() == null;
            }
            case 157: {
                return pSDELogicNodeBase.getPSViewMsgName() == null;
            }
            case 158: {
                return pSDELogicNodeBase.getPSWFDEId() == null;
            }
            case 159: {
                return pSDELogicNodeBase.getPSWFDEName() == null;
            }
            case 160: {
                return pSDELogicNodeBase.getPSWorkflowId() == null;
            }
            case 161: {
                return pSDELogicNodeBase.getPSWorkflowName() == null;
            }
            case 162: {
                return pSDELogicNodeBase.getRetPSDLParamId() == null;
            }
            case 163: {
                return pSDELogicNodeBase.getRetPSDLParamName() == null;
            }
            case 164: {
                return pSDELogicNodeBase.getShapeParams() == null;
            }
            case 165: {
                return pSDELogicNodeBase.getSrcIndex() == null;
            }
            case 166: {
                return pSDELogicNodeBase.getSrcPSDLParamId() == null;
            }
            case 167: {
                return pSDELogicNodeBase.getSrcPSDLParamName() == null;
            }
            case 168: {
                return pSDELogicNodeBase.getSrcSize() == null;
            }
            case 169: {
                return pSDELogicNodeBase.getThreadRunMode() == null;
            }
            case 170: {
                return pSDELogicNodeBase.getThreadRunTimer() == null;
            }
            case 171: {
                return pSDELogicNodeBase.getTopPos() == null;
            }
            case 172: {
                return pSDELogicNodeBase.getTSMode() == null;
            }
            case 173: {
                return pSDELogicNodeBase.getUpdateDate() == null;
            }
            case 174: {
                return pSDELogicNodeBase.getUpdateMan() == null;
            }
            case 175: {
                return pSDELogicNodeBase.getUserCat() == null;
            }
            case 176: {
                return pSDELogicNodeBase.getUserParams() == null;
            }
            case 177: {
                return pSDELogicNodeBase.getUserTag() == null;
            }
            case 178: {
                return pSDELogicNodeBase.getUserTag2() == null;
            }
            case 179: {
                return pSDELogicNodeBase.getUserTag3() == null;
            }
            case 180: {
                return pSDELogicNodeBase.getUserTag4() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSDELogicNodeBase.contains(this, n);
    }

    private static boolean contains(PSDELogicNodeBase pSDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicNodeBase.isCodeNameDirty();
            }
            case 1: {
                return pSDELogicNodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELogicNodeBase.isCreateManDirty();
            }
            case 3: {
                return pSDELogicNodeBase.isCustomDSTParamDirty();
            }
            case 4: {
                return pSDELogicNodeBase.isCustomSrcParamDirty();
            }
            case 5: {
                return pSDELogicNodeBase.isDebugModeDirty();
            }
            case 6: {
                return pSDELogicNodeBase.isDstPSDEUtilDEIdDirty();
            }
            case 7: {
                return pSDELogicNodeBase.isDstPSDEUtilDENameDirty();
            }
            case 8: {
                return pSDELogicNodeBase.isDstIndexDirty();
            }
            case 9: {
                return pSDELogicNodeBase.isDstParamActionDirty();
            }
            case 10: {
                return pSDELogicNodeBase.isDstPSDEActionIdDirty();
            }
            case 11: {
                return pSDELogicNodeBase.isDstPSDEActionNameDirty();
            }
            case 12: {
                return pSDELogicNodeBase.isDstPSDEDataExpIdDirty();
            }
            case 13: {
                return pSDELogicNodeBase.isDstPSDEDataExpNameDirty();
            }
            case 14: {
                return pSDELogicNodeBase.isDstPSDEDataFlowIdDirty();
            }
            case 15: {
                return pSDELogicNodeBase.isDstPSDEDataFlowNameDirty();
            }
            case 16: {
                return pSDELogicNodeBase.isDstPSDEDataImpIdDirty();
            }
            case 17: {
                return pSDELogicNodeBase.isDstPSDEDataImpNameDirty();
            }
            case 18: {
                return pSDELogicNodeBase.isDstPSDEDataQueryIdDirty();
            }
            case 19: {
                return pSDELogicNodeBase.isDstPSDEDataQueryNameDirty();
            }
            case 20: {
                return pSDELogicNodeBase.isDstPSDEDataSetIdDirty();
            }
            case 21: {
                return pSDELogicNodeBase.isDstPSDEDataSetNameDirty();
            }
            case 22: {
                return pSDELogicNodeBase.isDstPSDEDataSyncIdDirty();
            }
            case 23: {
                return pSDELogicNodeBase.isDstPSDEDataSyncNameDirty();
            }
            case 24: {
                return pSDELogicNodeBase.isDstPSDEDTSQueueIdDirty();
            }
            case 25: {
                return pSDELogicNodeBase.isDstPSDEDTSQueueNameDirty();
            }
            case 26: {
                return pSDELogicNodeBase.isDstPSDEFGroupIdDirty();
            }
            case 27: {
                return pSDELogicNodeBase.isDstPSDEFGroupNameDirty();
            }
            case 28: {
                return pSDELogicNodeBase.isDstPSDEFormIdDirty();
            }
            case 29: {
                return pSDELogicNodeBase.isDstPSDEFormNameDirty();
            }
            case 30: {
                return pSDELogicNodeBase.isDstPSDEFValueRuleIdDirty();
            }
            case 31: {
                return pSDELogicNodeBase.isDstPSDEFValueRuleNameDirty();
            }
            case 32: {
                return pSDELogicNodeBase.isDstPSDEIdDirty();
            }
            case 33: {
                return pSDELogicNodeBase.isDstPSDELogicIdDirty();
            }
            case 34: {
                return pSDELogicNodeBase.isDstPSDELogicNameDirty();
            }
            case 35: {
                return pSDELogicNodeBase.isDstPSDEMapIdDirty();
            }
            case 36: {
                return pSDELogicNodeBase.isDstPSDEMapNameDirty();
            }
            case 37: {
                return pSDELogicNodeBase.isDstPSDENameDirty();
            }
            case 38: {
                return pSDELogicNodeBase.isDstPSDENotifyIdDirty();
            }
            case 39: {
                return pSDELogicNodeBase.isDstPSDENotifyNameDirty();
            }
            case 40: {
                return pSDELogicNodeBase.isDstPSDEPrintIdDirty();
            }
            case 41: {
                return pSDELogicNodeBase.isDstPSDEPrintNameDirty();
            }
            case 42: {
                return pSDELogicNodeBase.isDstPSDEReportIdDirty();
            }
            case 43: {
                return pSDELogicNodeBase.isDstPSDEReportNameDirty();
            }
            case 44: {
                return pSDELogicNodeBase.isDstPSDESampleDataIdDirty();
            }
            case 45: {
                return pSDELogicNodeBase.isDstPSDESampleDataNameDirty();
            }
            case 46: {
                return pSDELogicNodeBase.isDstPSDEUAGroupIdDirty();
            }
            case 47: {
                return pSDELogicNodeBase.isDstPSDEUAGroupNameDirty();
            }
            case 48: {
                return pSDELogicNodeBase.isDstPSDEUILogicIdDirty();
            }
            case 49: {
                return pSDELogicNodeBase.isDstPSDEUILogicNameDirty();
            }
            case 50: {
                return pSDELogicNodeBase.isDstPSDEViewIdDirty();
            }
            case 51: {
                return pSDELogicNodeBase.isDstPSDEViewNameDirty();
            }
            case 52: {
                return pSDELogicNodeBase.isDstPSDEVRGroupIdDirty();
            }
            case 53: {
                return pSDELogicNodeBase.isDstPSDEVRGroupNameDirty();
            }
            case 54: {
                return pSDELogicNodeBase.isDstPSDEWizardIdDirty();
            }
            case 55: {
                return pSDELogicNodeBase.isDstPSDEWizardNameDirty();
            }
            case 56: {
                return pSDELogicNodeBase.isDstPSDLParamIdDirty();
            }
            case 57: {
                return pSDELogicNodeBase.isDstPSDLParamNameDirty();
            }
            case 58: {
                return pSDELogicNodeBase.isDstSortDirDirty();
            }
            case 59: {
                return pSDELogicNodeBase.isDynaModelFlagDirty();
            }
            case 60: {
                return pSDELogicNodeBase.isISPSDLParamIdDirty();
            }
            case 61: {
                return pSDELogicNodeBase.isISPSDLParamNameDirty();
            }
            case 62: {
                return pSDELogicNodeBase.isLeftPosDirty();
            }
            case 63: {
                return pSDELogicNodeBase.isLogicNodeSubTypeDirty();
            }
            case 64: {
                return pSDELogicNodeBase.isLogicNodeTypeDirty();
            }
            case 65: {
                return pSDELogicNodeBase.isMemoDirty();
            }
            case 66: {
                return pSDELogicNodeBase.isMsgPSLanResIdDirty();
            }
            case 67: {
                return pSDELogicNodeBase.isMsgPSLanResNameDirty();
            }
            case 68: {
                return pSDELogicNodeBase.isNodeParamsDirty();
            }
            case 69: {
                return pSDELogicNodeBase.isOptPSDLParamIdDirty();
            }
            case 70: {
                return pSDELogicNodeBase.isOptPSDLParamNameDirty();
            }
            case 71: {
                return pSDELogicNodeBase.isOrderValueDirty();
            }
            case 72: {
                return pSDELogicNodeBase.isOSPSDLParamIdDirty();
            }
            case 73: {
                return pSDELogicNodeBase.isOSPSDLParamNameDirty();
            }
            case 74: {
                return pSDELogicNodeBase.isParallelOutputDirty();
            }
            case 75: {
                return pSDELogicNodeBase.isParam1Dirty();
            }
            case 76: {
                return pSDELogicNodeBase.isParam10Dirty();
            }
            case 77: {
                return pSDELogicNodeBase.isParam11Dirty();
            }
            case 78: {
                return pSDELogicNodeBase.isParam12Dirty();
            }
            case 79: {
                return pSDELogicNodeBase.isParam13Dirty();
            }
            case 80: {
                return pSDELogicNodeBase.isParam14Dirty();
            }
            case 81: {
                return pSDELogicNodeBase.isParam2Dirty();
            }
            case 82: {
                return pSDELogicNodeBase.isParam3Dirty();
            }
            case 83: {
                return pSDELogicNodeBase.isParam4Dirty();
            }
            case 84: {
                return pSDELogicNodeBase.isParam5Dirty();
            }
            case 85: {
                return pSDELogicNodeBase.isParam6Dirty();
            }
            case 86: {
                return pSDELogicNodeBase.isParam7Dirty();
            }
            case 87: {
                return pSDELogicNodeBase.isParam8Dirty();
            }
            case 88: {
                return pSDELogicNodeBase.isParam9Dirty();
            }
            case 89: {
                return pSDELogicNodeBase.isPSDEIdDirty();
            }
            case 90: {
                return pSDELogicNodeBase.isPSDELogicIdDirty();
            }
            case 91: {
                return pSDELogicNodeBase.isPSDELogicNameDirty();
            }
            case 92: {
                return pSDELogicNodeBase.isPSDELogicNodeIdDirty();
            }
            case 93: {
                return pSDELogicNodeBase.isPSDELogicNodeNameDirty();
            }
            case 94: {
                return pSDELogicNodeBase.isPSDEMainStateIdDirty();
            }
            case 95: {
                return pSDELogicNodeBase.isPSDEMainStateNameDirty();
            }
            case 96: {
                return pSDELogicNodeBase.isPSDEUIActionIdDirty();
            }
            case 97: {
                return pSDELogicNodeBase.isPSDEUIActionNameDirty();
            }
            case 98: {
                return pSDELogicNodeBase.isPSDynaInstIdDirty();
            }
            case 99: {
                return pSDELogicNodeBase.isPSSubSysSADetailIdDirty();
            }
            case 100: {
                return pSDELogicNodeBase.isPSSubSysSADetailNameDirty();
            }
            case 101: {
                return pSDELogicNodeBase.isPSSubSysServiceAPIIdDirty();
            }
            case 102: {
                return pSDELogicNodeBase.isPSSubSysServiceAPINameDirty();
            }
            case 103: {
                return pSDELogicNodeBase.isPSSysAIChatAgentIdDirty();
            }
            case 104: {
                return pSDELogicNodeBase.isPSSysAIChatAgentNameDirty();
            }
            case 105: {
                return pSDELogicNodeBase.isPSSysAIFactoryIdDirty();
            }
            case 106: {
                return pSDELogicNodeBase.isPSSysAIFactoryNameDirty();
            }
            case 107: {
                return pSDELogicNodeBase.isPSSysAIPipelineAgentIdDirty();
            }
            case 108: {
                return pSDELogicNodeBase.isPSSysAIPipelineAgentNameDirty();
            }
            case 109: {
                return pSDELogicNodeBase.isPSSysAIWorkerAgentIdDirty();
            }
            case 110: {
                return pSDELogicNodeBase.isPSSysAIWorkerAgentNameDirty();
            }
            case 111: {
                return pSDELogicNodeBase.isPSSysBackServiceIdDirty();
            }
            case 112: {
                return pSDELogicNodeBase.isPSSysBackServiceNameDirty();
            }
            case 113: {
                return pSDELogicNodeBase.isPSSysBDSchemeIdDirty();
            }
            case 114: {
                return pSDELogicNodeBase.isPSSysBDSchemeNameDirty();
            }
            case 115: {
                return pSDELogicNodeBase.isPSSysBDTableIdDirty();
            }
            case 116: {
                return pSDELogicNodeBase.isPSSysBDTableNameDirty();
            }
            case 117: {
                return pSDELogicNodeBase.isPSSysBIAggTableIdDirty();
            }
            case 118: {
                return pSDELogicNodeBase.isPSSysBIAggTableNameDirty();
            }
            case 119: {
                return pSDELogicNodeBase.isPSSysBICubeIdDirty();
            }
            case 120: {
                return pSDELogicNodeBase.isPSSysBICubeNameDirty();
            }
            case 121: {
                return pSDELogicNodeBase.isPSSysBIReportIdDirty();
            }
            case 122: {
                return pSDELogicNodeBase.isPSSysBIReportNameDirty();
            }
            case 123: {
                return pSDELogicNodeBase.isPSSysBISchemeIdDirty();
            }
            case 124: {
                return pSDELogicNodeBase.isPSSysBISchemeNameDirty();
            }
            case 125: {
                return pSDELogicNodeBase.isPSSysDataSyncAgentIdDirty();
            }
            case 126: {
                return pSDELogicNodeBase.isPSSysDataSyncAgentNameDirty();
            }
            case 127: {
                return pSDELogicNodeBase.isPSSysDBSchemeIdDirty();
            }
            case 128: {
                return pSDELogicNodeBase.isPSSysDBSchemeNameDirty();
            }
            case 129: {
                return pSDELogicNodeBase.isPSSysDBTableIdDirty();
            }
            case 130: {
                return pSDELogicNodeBase.isPSSysDBTableNameDirty();
            }
            case 131: {
                return pSDELogicNodeBase.isPSSysDELogicNodeIdDirty();
            }
            case 132: {
                return pSDELogicNodeBase.isPSSysDELogicNodeNameDirty();
            }
            case 133: {
                return pSDELogicNodeBase.isPSSysEAIElementIdDirty();
            }
            case 134: {
                return pSDELogicNodeBase.isPSSysEAIElementNameDirty();
            }
            case 135: {
                return pSDELogicNodeBase.isPSSysEAISchemeIdDirty();
            }
            case 136: {
                return pSDELogicNodeBase.isPSSysEAISchemeNameDirty();
            }
            case 137: {
                return pSDELogicNodeBase.isPSSysMsgTemplIdDirty();
            }
            case 138: {
                return pSDELogicNodeBase.isPSSysMsgTemplNameDirty();
            }
            case 139: {
                return pSDELogicNodeBase.isPSSysPFPluginIdDirty();
            }
            case 140: {
                return pSDELogicNodeBase.isPSSysPFPluginNameDirty();
            }
            case 141: {
                return pSDELogicNodeBase.isPSSysResourceIdDirty();
            }
            case 142: {
                return pSDELogicNodeBase.isPSSysResourceNameDirty();
            }
            case 143: {
                return pSDELogicNodeBase.isPSSysSearchDocIdDirty();
            }
            case 144: {
                return pSDELogicNodeBase.isPSSysSearchDocNameDirty();
            }
            case 145: {
                return pSDELogicNodeBase.isPSSysSearchSchemeIdDirty();
            }
            case 146: {
                return pSDELogicNodeBase.isPSSysSearchSchemeNameDirty();
            }
            case 147: {
                return pSDELogicNodeBase.isPSSysSFPluginIdDirty();
            }
            case 148: {
                return pSDELogicNodeBase.isPSSysSFPluginNameDirty();
            }
            case 149: {
                return pSDELogicNodeBase.isPSSysSQLCmdIdDirty();
            }
            case 150: {
                return pSDELogicNodeBase.isPSSysSQLCmdNameDirty();
            }
            case 151: {
                return pSDELogicNodeBase.isPSSystemIdDirty();
            }
            case 152: {
                return pSDELogicNodeBase.isPSSysUniStateIdDirty();
            }
            case 153: {
                return pSDELogicNodeBase.isPSSysUniStateNameDirty();
            }
            case 154: {
                return pSDELogicNodeBase.isPSSysUtilDEIdDirty();
            }
            case 155: {
                return pSDELogicNodeBase.isPSSysUtilDENameDirty();
            }
            case 156: {
                return pSDELogicNodeBase.isPSViewMsgIdDirty();
            }
            case 157: {
                return pSDELogicNodeBase.isPSViewMsgNameDirty();
            }
            case 158: {
                return pSDELogicNodeBase.isPSWFDEIdDirty();
            }
            case 159: {
                return pSDELogicNodeBase.isPSWFDENameDirty();
            }
            case 160: {
                return pSDELogicNodeBase.isPSWorkflowIdDirty();
            }
            case 161: {
                return pSDELogicNodeBase.isPSWorkflowNameDirty();
            }
            case 162: {
                return pSDELogicNodeBase.isRetPSDLParamIdDirty();
            }
            case 163: {
                return pSDELogicNodeBase.isRetPSDLParamNameDirty();
            }
            case 164: {
                return pSDELogicNodeBase.isShapeParamsDirty();
            }
            case 165: {
                return pSDELogicNodeBase.isSrcIndexDirty();
            }
            case 166: {
                return pSDELogicNodeBase.isSrcPSDLParamIdDirty();
            }
            case 167: {
                return pSDELogicNodeBase.isSrcPSDLParamNameDirty();
            }
            case 168: {
                return pSDELogicNodeBase.isSrcSizeDirty();
            }
            case 169: {
                return pSDELogicNodeBase.isThreadRunModeDirty();
            }
            case 170: {
                return pSDELogicNodeBase.isThreadRunTimerDirty();
            }
            case 171: {
                return pSDELogicNodeBase.isTopPosDirty();
            }
            case 172: {
                return pSDELogicNodeBase.isTSModeDirty();
            }
            case 173: {
                return pSDELogicNodeBase.isUpdateDateDirty();
            }
            case 174: {
                return pSDELogicNodeBase.isUpdateManDirty();
            }
            case 175: {
                return pSDELogicNodeBase.isUserCatDirty();
            }
            case 176: {
                return pSDELogicNodeBase.isUserParamsDirty();
            }
            case 177: {
                return pSDELogicNodeBase.isUserTagDirty();
            }
            case 178: {
                return pSDELogicNodeBase.isUserTag2Dirty();
            }
            case 179: {
                return pSDELogicNodeBase.isUserTag3Dirty();
            }
            case 180: {
                return pSDELogicNodeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELogicNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELogicNodeBase pSDELogicNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELogicNodeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getCustomDSTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdstparam", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getCustomDSTParam()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getCustomSrcParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customsrcparam", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getCustomSrcParam()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDebugMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"debugmode", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDebugMode()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstdeutildeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUtilDEId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstdeutildename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUtilDEName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstIndex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstindex", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstIndex()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstParamAction() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstparamaction", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstParamAction()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEActionId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEActionName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataExpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataexpid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataExpId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataExpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataexpname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataExpName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataFlowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataflowid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataFlowId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataFlowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataflowname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataFlowName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataImpId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataimpid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataImpId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataImpName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataimpname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataImpName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasyncid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataSyncId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasyncname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDataSyncName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDTSQueueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedtsqueueid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDTSQueueId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDTSQueueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedtsqueuename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEDTSQueueName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefgroupid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFGroupId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefgroupname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFGroupName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeformid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFormId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeformname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFormName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefvalueruleid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFValueRuleId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefvaluerulename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEFValueRuleName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDELogicName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdemapid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEMapId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdemapname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEMapName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDENotifyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdenotifyid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDENotifyId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDENotifyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdenotifyname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDENotifyName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEPrintId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeprintid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEPrintId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEPrintName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeprintname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEPrintName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdereportid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEReportId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdereportname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEReportName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDESampleDataId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdesampledataid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDESampleDataId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDESampleDataName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdesampledataname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDESampleDataName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeuagroupid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeuagroupname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUILogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeuilogicid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUILogicId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUILogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeuilogicname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEUILogicName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeviewid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEViewId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeviewname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEViewName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEVRGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevrgroupid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEVRGroupId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEVRGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdevrgroupname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEVRGroupName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEWizardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdewizardid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEWizardId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEWizardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdewizardname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDEWizardName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDstSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstsortdir", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDstSortDir()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getISPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ispsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getISPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getISPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ispsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getISPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getLogicNodeSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicnodesubtype", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getLogicNodeSubType()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getLogicNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicnodetype", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getLogicNodeType()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getMsgPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpslanresid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getMsgPSLanResId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getMsgPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"msgpslanresname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getMsgPSLanResName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getNodeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodeparams", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getNodeParams()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getOptPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"optpsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getOptPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getOptPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"optpsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getOptPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getOSPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ospsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getOSPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getOSPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ospsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getOSPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParallelOutput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paralleloutput", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParallelOutput()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam1() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param1", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam1()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param10", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam10()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param11", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam11()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param12", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam12()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param13", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam13()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param14", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam14()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam2()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam3()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam4()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam5()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam6()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam7()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam8()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param9", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getParam9()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDEMainStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstateid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDEMainStateId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDEMainStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemainstatename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDEMainStateName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysSADetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSubSysSADetailId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysSADetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsyssadetailname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSubSysSADetailName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysServiceAPIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSubSysServiceAPIId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysServiceAPIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysserviceapiname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSubSysServiceAPIName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIChatAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIChatAgentId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIChatAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaichatagentname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIChatAgentName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIFactoryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIFactoryId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIFactoryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaifactoryname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIFactoryName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIPipelineAgentId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaipipelineagentname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIPipelineAgentName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIWorkerAgentId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysaiworkeragentname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysAIWorkerAgentName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBackServiceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbackserviceid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBackServiceId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBackServiceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbackservicename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBackServiceName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBDSchemeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdschemename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBDSchemeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtableid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBDTableId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbdtablename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBDTableName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIAggTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtableid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBIAggTableId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIAggTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbiaggtablename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBIAggTableName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBIReportId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBIReportName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDataSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdatasyncagentid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDataSyncAgentId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDataSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdatasyncagentname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDataSyncAgentName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDBSchemeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbschemename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDBSchemeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtableid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDBTableId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbtablename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDBTableName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdelogicnodename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchDocId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSearchDocId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchDocName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchdocname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSearchDocName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchSchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSearchSchemeId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchSchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssearchschemename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSearchSchemeName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSQLCmdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSQLCmdId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysSQLCmdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssqlcmdname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysSQLCmdName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysUniStateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistateid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysUniStateId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysUniStateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunistatename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysUniStateName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysUtilDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysUtilDEId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSSysUtilDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutildename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSSysUtilDEName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSViewMsgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSViewMsgId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSViewMsgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsgname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSViewMsgName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdeid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSWFDEId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSWFDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfdename", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSWFDEName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSWorkflowId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getPSWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkflowname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getPSWorkflowName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getRetPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retpsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getRetPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getRetPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retpsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getRetPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getSrcIndex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcindex", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getSrcIndex()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getSrcPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamid", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getSrcPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getSrcPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamname", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getSrcPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getSrcSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcsize", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getSrcSize()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getThreadRunMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadrunmode", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getThreadRunMode()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getThreadRunTimer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"threadruntimer", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getThreadRunTimer()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getTopPos()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getTSMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tsmode", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getTSMode()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELogicNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELogicNodeBase.getJSONValue((Object)pSDELogicNodeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELogicNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELogicNodeBase pSDELogicNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELogicNodeBase.getCodeName() != null) {
            object = pSDELogicNodeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getCreateDate() != null) {
            object = pSDELogicNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getCreateMan() != null) {
            object = pSDELogicNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getCustomDSTParam() != null) {
            object = pSDELogicNodeBase.getCustomDSTParam();
            xmlNode.setAttribute(FIELD_CUSTOMDSTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getCustomSrcParam() != null) {
            object = pSDELogicNodeBase.getCustomSrcParam();
            xmlNode.setAttribute(FIELD_CUSTOMSRCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDebugMode() != null) {
            object = pSDELogicNodeBase.getDebugMode();
            xmlNode.setAttribute(FIELD_DEBUGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUtilDEId() != null) {
            object = pSDELogicNodeBase.getDstPSDEUtilDEId();
            xmlNode.setAttribute("DSTPSDEUTILDEID", object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUtilDEName() != null) {
            object = pSDELogicNodeBase.getDstPSDEUtilDEName();
            xmlNode.setAttribute("DSTPSDEUTILDENAME", object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstIndex() != null) {
            object = pSDELogicNodeBase.getDstIndex();
            xmlNode.setAttribute(FIELD_DSTINDEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getDstParamAction() != null) {
            object = pSDELogicNodeBase.getDstParamAction();
            xmlNode.setAttribute(FIELD_DSTPARAMACTION, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEActionId() != null) {
            object = pSDELogicNodeBase.getDstPSDEActionId();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEActionName() != null) {
            object = pSDELogicNodeBase.getDstPSDEActionName();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataExpId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataExpId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAEXPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataExpName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataExpName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAEXPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataFlowId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataFlowId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataFlowName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataFlowName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataImpId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataImpId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAIMPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataImpName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataImpName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAIMPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataQueryId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataQueryName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSetId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataSetId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSetName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataSetName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSyncId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataSyncId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDataSyncName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDataSyncName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDTSQueueId() != null) {
            object = pSDELogicNodeBase.getDstPSDEDTSQueueId();
            xmlNode.setAttribute(FIELD_DSTPSDEDTSQUEUEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEDTSQueueName() != null) {
            object = pSDELogicNodeBase.getDstPSDEDTSQueueName();
            xmlNode.setAttribute(FIELD_DSTPSDEDTSQUEUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFGroupId() != null) {
            object = pSDELogicNodeBase.getDstPSDEFGroupId();
            xmlNode.setAttribute(FIELD_DSTPSDEFGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFGroupName() != null) {
            object = pSDELogicNodeBase.getDstPSDEFGroupName();
            xmlNode.setAttribute(FIELD_DSTPSDEFGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFormId() != null) {
            object = pSDELogicNodeBase.getDstPSDEFormId();
            xmlNode.setAttribute(FIELD_DSTPSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFormName() != null) {
            object = pSDELogicNodeBase.getDstPSDEFormName();
            xmlNode.setAttribute(FIELD_DSTPSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFValueRuleId() != null) {
            object = pSDELogicNodeBase.getDstPSDEFValueRuleId();
            xmlNode.setAttribute(FIELD_DSTPSDEFVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEFValueRuleName() != null) {
            object = pSDELogicNodeBase.getDstPSDEFValueRuleName();
            xmlNode.setAttribute(FIELD_DSTPSDEFVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEId() != null) {
            object = pSDELogicNodeBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDELogicId() != null) {
            object = pSDELogicNodeBase.getDstPSDELogicId();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDELogicName() != null) {
            object = pSDELogicNodeBase.getDstPSDELogicName();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEMapId() != null) {
            object = pSDELogicNodeBase.getDstPSDEMapId();
            xmlNode.setAttribute(FIELD_DSTPSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEMapName() != null) {
            object = pSDELogicNodeBase.getDstPSDEMapName();
            xmlNode.setAttribute(FIELD_DSTPSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEName() != null) {
            object = pSDELogicNodeBase.getDstPSDEName();
            xmlNode.setAttribute(FIELD_DSTPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDENotifyId() != null) {
            object = pSDELogicNodeBase.getDstPSDENotifyId();
            xmlNode.setAttribute(FIELD_DSTPSDENOTIFYID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDENotifyName() != null) {
            object = pSDELogicNodeBase.getDstPSDENotifyName();
            xmlNode.setAttribute(FIELD_DSTPSDENOTIFYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEPrintId() != null) {
            object = pSDELogicNodeBase.getDstPSDEPrintId();
            xmlNode.setAttribute(FIELD_DSTPSDEPRINTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEPrintName() != null) {
            object = pSDELogicNodeBase.getDstPSDEPrintName();
            xmlNode.setAttribute(FIELD_DSTPSDEPRINTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEReportId() != null) {
            object = pSDELogicNodeBase.getDstPSDEReportId();
            xmlNode.setAttribute(FIELD_DSTPSDEREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEReportName() != null) {
            object = pSDELogicNodeBase.getDstPSDEReportName();
            xmlNode.setAttribute(FIELD_DSTPSDEREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDESampleDataId() != null) {
            object = pSDELogicNodeBase.getDstPSDESampleDataId();
            xmlNode.setAttribute(FIELD_DSTPSDESAMPLEDATAID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDESampleDataName() != null) {
            object = pSDELogicNodeBase.getDstPSDESampleDataName();
            xmlNode.setAttribute(FIELD_DSTPSDESAMPLEDATANAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUAGroupId() != null) {
            object = pSDELogicNodeBase.getDstPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_DSTPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUAGroupName() != null) {
            object = pSDELogicNodeBase.getDstPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_DSTPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUILogicId() != null) {
            object = pSDELogicNodeBase.getDstPSDEUILogicId();
            xmlNode.setAttribute(FIELD_DSTPSDEUILOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEUILogicName() != null) {
            object = pSDELogicNodeBase.getDstPSDEUILogicName();
            xmlNode.setAttribute(FIELD_DSTPSDEUILOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEViewId() != null) {
            object = pSDELogicNodeBase.getDstPSDEViewId();
            xmlNode.setAttribute(FIELD_DSTPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEViewName() != null) {
            object = pSDELogicNodeBase.getDstPSDEViewName();
            xmlNode.setAttribute(FIELD_DSTPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEVRGroupId() != null) {
            object = pSDELogicNodeBase.getDstPSDEVRGroupId();
            xmlNode.setAttribute(FIELD_DSTPSDEVRGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEVRGroupName() != null) {
            object = pSDELogicNodeBase.getDstPSDEVRGroupName();
            xmlNode.setAttribute(FIELD_DSTPSDEVRGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEWizardId() != null) {
            object = pSDELogicNodeBase.getDstPSDEWizardId();
            xmlNode.setAttribute(FIELD_DSTPSDEWIZARDID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDEWizardName() != null) {
            object = pSDELogicNodeBase.getDstPSDEWizardName();
            xmlNode.setAttribute(FIELD_DSTPSDEWIZARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDLParamId() != null) {
            object = pSDELogicNodeBase.getDstPSDLParamId();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstPSDLParamName() != null) {
            object = pSDELogicNodeBase.getDstPSDLParamName();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDstSortDir() != null) {
            object = pSDELogicNodeBase.getDstSortDir();
            xmlNode.setAttribute(FIELD_DSTSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getDynaModelFlag() != null) {
            object = pSDELogicNodeBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getISPSDLParamId() != null) {
            object = pSDELogicNodeBase.getISPSDLParamId();
            xmlNode.setAttribute(FIELD_ISPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getISPSDLParamName() != null) {
            object = pSDELogicNodeBase.getISPSDLParamName();
            xmlNode.setAttribute(FIELD_ISPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getLeftPos() != null) {
            object = pSDELogicNodeBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getLogicNodeSubType() != null) {
            object = pSDELogicNodeBase.getLogicNodeSubType();
            xmlNode.setAttribute(FIELD_LOGICNODESUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getLogicNodeType() != null) {
            object = pSDELogicNodeBase.getLogicNodeType();
            xmlNode.setAttribute(FIELD_LOGICNODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getMemo() != null) {
            object = pSDELogicNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getMsgPSLanResId() != null) {
            object = pSDELogicNodeBase.getMsgPSLanResId();
            xmlNode.setAttribute(FIELD_MSGPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getMsgPSLanResName() != null) {
            object = pSDELogicNodeBase.getMsgPSLanResName();
            xmlNode.setAttribute(FIELD_MSGPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getNodeParams() != null) {
            object = pSDELogicNodeBase.getNodeParams();
            xmlNode.setAttribute(FIELD_NODEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getOptPSDLParamId() != null) {
            object = pSDELogicNodeBase.getOptPSDLParamId();
            xmlNode.setAttribute(FIELD_OPTPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getOptPSDLParamName() != null) {
            object = pSDELogicNodeBase.getOptPSDLParamName();
            xmlNode.setAttribute(FIELD_OPTPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getOrderValue() != null) {
            object = pSDELogicNodeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getOSPSDLParamId() != null) {
            object = pSDELogicNodeBase.getOSPSDLParamId();
            xmlNode.setAttribute(FIELD_OSPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getOSPSDLParamName() != null) {
            object = pSDELogicNodeBase.getOSPSDLParamName();
            xmlNode.setAttribute(FIELD_OSPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParallelOutput() != null) {
            object = pSDELogicNodeBase.getParallelOutput();
            xmlNode.setAttribute(FIELD_PARALLELOUTPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getParam1() != null) {
            object = pSDELogicNodeBase.getParam1();
            xmlNode.setAttribute(FIELD_PARAM1, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam10() != null) {
            object = pSDELogicNodeBase.getParam10();
            xmlNode.setAttribute(FIELD_PARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getParam11() != null) {
            object = pSDELogicNodeBase.getParam11();
            xmlNode.setAttribute(FIELD_PARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam12() != null) {
            object = pSDELogicNodeBase.getParam12();
            xmlNode.setAttribute(FIELD_PARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam13() != null) {
            object = pSDELogicNodeBase.getParam13();
            xmlNode.setAttribute(FIELD_PARAM13, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam14() != null) {
            object = pSDELogicNodeBase.getParam14();
            xmlNode.setAttribute(FIELD_PARAM14, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam2() != null) {
            object = pSDELogicNodeBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam3() != null) {
            object = pSDELogicNodeBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam4() != null) {
            object = pSDELogicNodeBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam5() != null) {
            object = pSDELogicNodeBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam6() != null) {
            object = pSDELogicNodeBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getParam7() != null) {
            object = pSDELogicNodeBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getParam8() != null) {
            object = pSDELogicNodeBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getParam9() != null) {
            object = pSDELogicNodeBase.getParam9();
            xmlNode.setAttribute(FIELD_PARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getPSDEId() != null) {
            object = pSDELogicNodeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicId() != null) {
            object = pSDELogicNodeBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicName() != null) {
            object = pSDELogicNodeBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicNodeId() != null) {
            object = pSDELogicNodeBase.getPSDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDELogicNodeName() != null) {
            object = pSDELogicNodeBase.getPSDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDEMainStateId() != null) {
            object = pSDELogicNodeBase.getPSDEMainStateId();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDEMainStateName() != null) {
            object = pSDELogicNodeBase.getPSDEMainStateName();
            xmlNode.setAttribute(FIELD_PSDEMAINSTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDEUIActionId() != null) {
            object = pSDELogicNodeBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDEUIActionName() != null) {
            object = pSDELogicNodeBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSDynaInstId() != null) {
            object = pSDELogicNodeBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysSADetailId() != null) {
            object = pSDELogicNodeBase.getPSSubSysSADetailId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysSADetailName() != null) {
            object = pSDELogicNodeBase.getPSSubSysSADetailName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSADETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysServiceAPIId() != null) {
            object = pSDELogicNodeBase.getPSSubSysServiceAPIId();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPIID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSubSysServiceAPIName() != null) {
            object = pSDELogicNodeBase.getPSSubSysServiceAPIName();
            xmlNode.setAttribute(FIELD_PSSUBSYSSERVICEAPINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIChatAgentId() != null) {
            object = pSDELogicNodeBase.getPSSysAIChatAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIChatAgentName() != null) {
            object = pSDELogicNodeBase.getPSSysAIChatAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAICHATAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIFactoryId() != null) {
            object = pSDELogicNodeBase.getPSSysAIFactoryId();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIFactoryName() != null) {
            object = pSDELogicNodeBase.getPSSysAIFactoryName();
            xmlNode.setAttribute(FIELD_PSSYSAIFACTORYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentId() != null) {
            object = pSDELogicNodeBase.getPSSysAIPipelineAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentName() != null) {
            object = pSDELogicNodeBase.getPSSysAIPipelineAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIPIPELINEAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentId() != null) {
            object = pSDELogicNodeBase.getPSSysAIWorkerAgentId();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentName() != null) {
            object = pSDELogicNodeBase.getPSSysAIWorkerAgentName();
            xmlNode.setAttribute(FIELD_PSSYSAIWORKERAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBackServiceId() != null) {
            object = pSDELogicNodeBase.getPSSysBackServiceId();
            xmlNode.setAttribute(FIELD_PSSYSBACKSERVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBackServiceName() != null) {
            object = pSDELogicNodeBase.getPSSysBackServiceName();
            xmlNode.setAttribute(FIELD_PSSYSBACKSERVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDSchemeId() != null) {
            object = pSDELogicNodeBase.getPSSysBDSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDSchemeName() != null) {
            object = pSDELogicNodeBase.getPSSysBDSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBDSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDTableId() != null) {
            object = pSDELogicNodeBase.getPSSysBDTableId();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBDTableName() != null) {
            object = pSDELogicNodeBase.getPSSysBDTableName();
            xmlNode.setAttribute(FIELD_PSSYSBDTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIAggTableId() != null) {
            object = pSDELogicNodeBase.getPSSysBIAggTableId();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIAggTableName() != null) {
            object = pSDELogicNodeBase.getPSSysBIAggTableName();
            xmlNode.setAttribute(FIELD_PSSYSBIAGGTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBICubeId() != null) {
            object = pSDELogicNodeBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBICubeName() != null) {
            object = pSDELogicNodeBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIReportId() != null) {
            object = pSDELogicNodeBase.getPSSysBIReportId();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBIReportName() != null) {
            object = pSDELogicNodeBase.getPSSysBIReportName();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBISchemeId() != null) {
            object = pSDELogicNodeBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysBISchemeName() != null) {
            object = pSDELogicNodeBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDataSyncAgentId() != null) {
            object = pSDELogicNodeBase.getPSSysDataSyncAgentId();
            xmlNode.setAttribute(FIELD_PSSYSDATASYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDataSyncAgentName() != null) {
            object = pSDELogicNodeBase.getPSSysDataSyncAgentName();
            xmlNode.setAttribute(FIELD_PSSYSDATASYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBSchemeId() != null) {
            object = pSDELogicNodeBase.getPSSysDBSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBSchemeName() != null) {
            object = pSDELogicNodeBase.getPSSysDBSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSDBSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBTableId() != null) {
            object = pSDELogicNodeBase.getPSSysDBTableId();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDBTableName() != null) {
            object = pSDELogicNodeBase.getPSSysDBTableName();
            xmlNode.setAttribute(FIELD_PSSYSDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDELogicNodeId() != null) {
            object = pSDELogicNodeBase.getPSSysDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysDELogicNodeName() != null) {
            object = pSDELogicNodeBase.getPSSysDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSSYSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAIElementId() != null) {
            object = pSDELogicNodeBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAIElementName() != null) {
            object = pSDELogicNodeBase.getPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAISchemeId() != null) {
            object = pSDELogicNodeBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysEAISchemeName() != null) {
            object = pSDELogicNodeBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysMsgTemplId() != null) {
            object = pSDELogicNodeBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysMsgTemplName() != null) {
            object = pSDELogicNodeBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysPFPluginId() != null) {
            object = pSDELogicNodeBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysPFPluginName() != null) {
            object = pSDELogicNodeBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysResourceId() != null) {
            object = pSDELogicNodeBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysResourceName() != null) {
            object = pSDELogicNodeBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchDocId() != null) {
            object = pSDELogicNodeBase.getPSSysSearchDocId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchDocName() != null) {
            object = pSDELogicNodeBase.getPSSysSearchDocName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHDOCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchSchemeId() != null) {
            object = pSDELogicNodeBase.getPSSysSearchSchemeId();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSearchSchemeName() != null) {
            object = pSDELogicNodeBase.getPSSysSearchSchemeName();
            xmlNode.setAttribute(FIELD_PSSYSSEARCHSCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSFPluginId() != null) {
            object = pSDELogicNodeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSFPluginName() != null) {
            object = pSDELogicNodeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSQLCmdId() != null) {
            object = pSDELogicNodeBase.getPSSysSQLCmdId();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysSQLCmdName() != null) {
            object = pSDELogicNodeBase.getPSSysSQLCmdName();
            xmlNode.setAttribute(FIELD_PSSYSSQLCMDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSystemId() != null) {
            object = pSDELogicNodeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysUniStateId() != null) {
            object = pSDELogicNodeBase.getPSSysUniStateId();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysUniStateName() != null) {
            object = pSDELogicNodeBase.getPSSysUniStateName();
            xmlNode.setAttribute(FIELD_PSSYSUNISTATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysUtilDEId() != null) {
            object = pSDELogicNodeBase.getPSSysUtilDEId();
            xmlNode.setAttribute(FIELD_PSSYSUTILDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSSysUtilDEName() != null) {
            object = pSDELogicNodeBase.getPSSysUtilDEName();
            xmlNode.setAttribute(FIELD_PSSYSUTILDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSViewMsgId() != null) {
            object = pSDELogicNodeBase.getPSViewMsgId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSViewMsgName() != null) {
            object = pSDELogicNodeBase.getPSViewMsgName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSWFDEId() != null) {
            object = pSDELogicNodeBase.getPSWFDEId();
            xmlNode.setAttribute(FIELD_PSWFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSWFDEName() != null) {
            object = pSDELogicNodeBase.getPSWFDEName();
            xmlNode.setAttribute(FIELD_PSWFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSWorkflowId() != null) {
            object = pSDELogicNodeBase.getPSWorkflowId();
            xmlNode.setAttribute(FIELD_PSWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getPSWorkflowName() != null) {
            object = pSDELogicNodeBase.getPSWorkflowName();
            xmlNode.setAttribute(FIELD_PSWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getRetPSDLParamId() != null) {
            object = pSDELogicNodeBase.getRetPSDLParamId();
            xmlNode.setAttribute(FIELD_RETPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getRetPSDLParamName() != null) {
            object = pSDELogicNodeBase.getRetPSDLParamName();
            xmlNode.setAttribute(FIELD_RETPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getShapeParams() != null) {
            object = pSDELogicNodeBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getSrcIndex() != null) {
            object = pSDELogicNodeBase.getSrcIndex();
            xmlNode.setAttribute(FIELD_SRCINDEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getSrcPSDLParamId() != null) {
            object = pSDELogicNodeBase.getSrcPSDLParamId();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getSrcPSDLParamName() != null) {
            object = pSDELogicNodeBase.getSrcPSDLParamName();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getSrcSize() != null) {
            object = pSDELogicNodeBase.getSrcSize();
            xmlNode.setAttribute(FIELD_SRCSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getThreadRunMode() != null) {
            object = pSDELogicNodeBase.getThreadRunMode();
            xmlNode.setAttribute(FIELD_THREADRUNMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getThreadRunTimer() != null) {
            object = pSDELogicNodeBase.getThreadRunTimer();
            xmlNode.setAttribute(FIELD_THREADRUNTIMER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getTopPos() != null) {
            object = pSDELogicNodeBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getTSMode() != null) {
            object = pSDELogicNodeBase.getTSMode();
            xmlNode.setAttribute(FIELD_TSMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getUpdateDate() != null) {
            object = pSDELogicNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicNodeBase.getUpdateMan() != null) {
            object = pSDELogicNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserCat() != null) {
            object = pSDELogicNodeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserParams() != null) {
            object = pSDELogicNodeBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserTag() != null) {
            object = pSDELogicNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserTag2() != null) {
            object = pSDELogicNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserTag3() != null) {
            object = pSDELogicNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicNodeBase.getUserTag4() != null) {
            object = pSDELogicNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELogicNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELogicNodeBase pSDELogicNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELogicNodeBase.isCodeNameDirty() && (bl || pSDELogicNodeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDELogicNodeBase.getCodeName());
        }
        if (pSDELogicNodeBase.isCreateDateDirty() && (bl || pSDELogicNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELogicNodeBase.getCreateDate());
        }
        if (pSDELogicNodeBase.isCreateManDirty() && (bl || pSDELogicNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELogicNodeBase.getCreateMan());
        }
        if (pSDELogicNodeBase.isCustomDSTParamDirty() && (bl || pSDELogicNodeBase.getCustomDSTParam() != null)) {
            iDataObject.set(FIELD_CUSTOMDSTPARAM, (Object)pSDELogicNodeBase.getCustomDSTParam());
        }
        if (pSDELogicNodeBase.isCustomSrcParamDirty() && (bl || pSDELogicNodeBase.getCustomSrcParam() != null)) {
            iDataObject.set(FIELD_CUSTOMSRCPARAM, (Object)pSDELogicNodeBase.getCustomSrcParam());
        }
        if (pSDELogicNodeBase.isDebugModeDirty() && (bl || pSDELogicNodeBase.getDebugMode() != null)) {
            iDataObject.set(FIELD_DEBUGMODE, (Object)pSDELogicNodeBase.getDebugMode());
        }
        if (pSDELogicNodeBase.isDstPSDEUtilDEIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEUtilDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEUTILDEID, (Object)pSDELogicNodeBase.getDstPSDEUtilDEId());
        }
        if (pSDELogicNodeBase.isDstPSDEUtilDENameDirty() && (bl || pSDELogicNodeBase.getDstPSDEUtilDEName() != null)) {
            iDataObject.set(FIELD_DSTPSDEUTILDENAME, (Object)pSDELogicNodeBase.getDstPSDEUtilDEName());
        }
        if (pSDELogicNodeBase.isDstIndexDirty() && (bl || pSDELogicNodeBase.getDstIndex() != null)) {
            iDataObject.set(FIELD_DSTINDEX, (Object)pSDELogicNodeBase.getDstIndex());
        }
        if (pSDELogicNodeBase.isDstParamActionDirty() && (bl || pSDELogicNodeBase.getDstParamAction() != null)) {
            iDataObject.set(FIELD_DSTPARAMACTION, (Object)pSDELogicNodeBase.getDstParamAction());
        }
        if (pSDELogicNodeBase.isDstPSDEActionIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEActionId() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONID, (Object)pSDELogicNodeBase.getDstPSDEActionId());
        }
        if (pSDELogicNodeBase.isDstPSDEActionNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEActionName() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONNAME, (Object)pSDELogicNodeBase.getDstPSDEActionName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataExpIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataExpId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAEXPID, (Object)pSDELogicNodeBase.getDstPSDEDataExpId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataExpNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataExpName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAEXPNAME, (Object)pSDELogicNodeBase.getDstPSDEDataExpName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataFlowIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataFlowId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAFLOWID, (Object)pSDELogicNodeBase.getDstPSDEDataFlowId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataFlowNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataFlowName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAFLOWNAME, (Object)pSDELogicNodeBase.getDstPSDEDataFlowName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataImpIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataImpId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAIMPID, (Object)pSDELogicNodeBase.getDstPSDEDataImpId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataImpNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataImpName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAIMPNAME, (Object)pSDELogicNodeBase.getDstPSDEDataImpName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataQueryIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYID, (Object)pSDELogicNodeBase.getDstPSDEDataQueryId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataQueryNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYNAME, (Object)pSDELogicNodeBase.getDstPSDEDataQueryName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataSetIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETID, (Object)pSDELogicNodeBase.getDstPSDEDataSetId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataSetNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETNAME, (Object)pSDELogicNodeBase.getDstPSDEDataSetName());
        }
        if (pSDELogicNodeBase.isDstPSDEDataSyncIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataSyncId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASYNCID, (Object)pSDELogicNodeBase.getDstPSDEDataSyncId());
        }
        if (pSDELogicNodeBase.isDstPSDEDataSyncNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDataSyncName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASYNCNAME, (Object)pSDELogicNodeBase.getDstPSDEDataSyncName());
        }
        if (pSDELogicNodeBase.isDstPSDEDTSQueueIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEDTSQueueId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDTSQUEUEID, (Object)pSDELogicNodeBase.getDstPSDEDTSQueueId());
        }
        if (pSDELogicNodeBase.isDstPSDEDTSQueueNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEDTSQueueName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDTSQUEUENAME, (Object)pSDELogicNodeBase.getDstPSDEDTSQueueName());
        }
        if (pSDELogicNodeBase.isDstPSDEFGroupIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEFGroupId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFGROUPID, (Object)pSDELogicNodeBase.getDstPSDEFGroupId());
        }
        if (pSDELogicNodeBase.isDstPSDEFGroupNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEFGroupName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFGROUPNAME, (Object)pSDELogicNodeBase.getDstPSDEFGroupName());
        }
        if (pSDELogicNodeBase.isDstPSDEFormIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEFormId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFORMID, (Object)pSDELogicNodeBase.getDstPSDEFormId());
        }
        if (pSDELogicNodeBase.isDstPSDEFormNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEFormName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFORMNAME, (Object)pSDELogicNodeBase.getDstPSDEFormName());
        }
        if (pSDELogicNodeBase.isDstPSDEFValueRuleIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEFValueRuleId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFVALUERULEID, (Object)pSDELogicNodeBase.getDstPSDEFValueRuleId());
        }
        if (pSDELogicNodeBase.isDstPSDEFValueRuleNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEFValueRuleName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFVALUERULENAME, (Object)pSDELogicNodeBase.getDstPSDEFValueRuleName());
        }
        if (pSDELogicNodeBase.isDstPSDEIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDELogicNodeBase.getDstPSDEId());
        }
        if (pSDELogicNodeBase.isDstPSDELogicIdDirty() && (bl || pSDELogicNodeBase.getDstPSDELogicId() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICID, (Object)pSDELogicNodeBase.getDstPSDELogicId());
        }
        if (pSDELogicNodeBase.isDstPSDELogicNameDirty() && (bl || pSDELogicNodeBase.getDstPSDELogicName() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICNAME, (Object)pSDELogicNodeBase.getDstPSDELogicName());
        }
        if (pSDELogicNodeBase.isDstPSDEMapIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEMapId() != null)) {
            iDataObject.set(FIELD_DSTPSDEMAPID, (Object)pSDELogicNodeBase.getDstPSDEMapId());
        }
        if (pSDELogicNodeBase.isDstPSDEMapNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEMapName() != null)) {
            iDataObject.set(FIELD_DSTPSDEMAPNAME, (Object)pSDELogicNodeBase.getDstPSDEMapName());
        }
        if (pSDELogicNodeBase.isDstPSDENameDirty() && (bl || pSDELogicNodeBase.getDstPSDEName() != null)) {
            iDataObject.set(FIELD_DSTPSDENAME, (Object)pSDELogicNodeBase.getDstPSDEName());
        }
        if (pSDELogicNodeBase.isDstPSDENotifyIdDirty() && (bl || pSDELogicNodeBase.getDstPSDENotifyId() != null)) {
            iDataObject.set(FIELD_DSTPSDENOTIFYID, (Object)pSDELogicNodeBase.getDstPSDENotifyId());
        }
        if (pSDELogicNodeBase.isDstPSDENotifyNameDirty() && (bl || pSDELogicNodeBase.getDstPSDENotifyName() != null)) {
            iDataObject.set(FIELD_DSTPSDENOTIFYNAME, (Object)pSDELogicNodeBase.getDstPSDENotifyName());
        }
        if (pSDELogicNodeBase.isDstPSDEPrintIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEPrintId() != null)) {
            iDataObject.set(FIELD_DSTPSDEPRINTID, (Object)pSDELogicNodeBase.getDstPSDEPrintId());
        }
        if (pSDELogicNodeBase.isDstPSDEPrintNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEPrintName() != null)) {
            iDataObject.set(FIELD_DSTPSDEPRINTNAME, (Object)pSDELogicNodeBase.getDstPSDEPrintName());
        }
        if (pSDELogicNodeBase.isDstPSDEReportIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEReportId() != null)) {
            iDataObject.set(FIELD_DSTPSDEREPORTID, (Object)pSDELogicNodeBase.getDstPSDEReportId());
        }
        if (pSDELogicNodeBase.isDstPSDEReportNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEReportName() != null)) {
            iDataObject.set(FIELD_DSTPSDEREPORTNAME, (Object)pSDELogicNodeBase.getDstPSDEReportName());
        }
        if (pSDELogicNodeBase.isDstPSDESampleDataIdDirty() && (bl || pSDELogicNodeBase.getDstPSDESampleDataId() != null)) {
            iDataObject.set(FIELD_DSTPSDESAMPLEDATAID, (Object)pSDELogicNodeBase.getDstPSDESampleDataId());
        }
        if (pSDELogicNodeBase.isDstPSDESampleDataNameDirty() && (bl || pSDELogicNodeBase.getDstPSDESampleDataName() != null)) {
            iDataObject.set(FIELD_DSTPSDESAMPLEDATANAME, (Object)pSDELogicNodeBase.getDstPSDESampleDataName());
        }
        if (pSDELogicNodeBase.isDstPSDEUAGroupIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_DSTPSDEUAGROUPID, (Object)pSDELogicNodeBase.getDstPSDEUAGroupId());
        }
        if (pSDELogicNodeBase.isDstPSDEUAGroupNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_DSTPSDEUAGROUPNAME, (Object)pSDELogicNodeBase.getDstPSDEUAGroupName());
        }
        if (pSDELogicNodeBase.isDstPSDEUILogicIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEUILogicId() != null)) {
            iDataObject.set(FIELD_DSTPSDEUILOGICID, (Object)pSDELogicNodeBase.getDstPSDEUILogicId());
        }
        if (pSDELogicNodeBase.isDstPSDEUILogicNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEUILogicName() != null)) {
            iDataObject.set(FIELD_DSTPSDEUILOGICNAME, (Object)pSDELogicNodeBase.getDstPSDEUILogicName());
        }
        if (pSDELogicNodeBase.isDstPSDEViewIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEViewId() != null)) {
            iDataObject.set(FIELD_DSTPSDEVIEWID, (Object)pSDELogicNodeBase.getDstPSDEViewId());
        }
        if (pSDELogicNodeBase.isDstPSDEViewNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEViewName() != null)) {
            iDataObject.set(FIELD_DSTPSDEVIEWNAME, (Object)pSDELogicNodeBase.getDstPSDEViewName());
        }
        if (pSDELogicNodeBase.isDstPSDEVRGroupIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEVRGroupId() != null)) {
            iDataObject.set(FIELD_DSTPSDEVRGROUPID, (Object)pSDELogicNodeBase.getDstPSDEVRGroupId());
        }
        if (pSDELogicNodeBase.isDstPSDEVRGroupNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEVRGroupName() != null)) {
            iDataObject.set(FIELD_DSTPSDEVRGROUPNAME, (Object)pSDELogicNodeBase.getDstPSDEVRGroupName());
        }
        if (pSDELogicNodeBase.isDstPSDEWizardIdDirty() && (bl || pSDELogicNodeBase.getDstPSDEWizardId() != null)) {
            iDataObject.set(FIELD_DSTPSDEWIZARDID, (Object)pSDELogicNodeBase.getDstPSDEWizardId());
        }
        if (pSDELogicNodeBase.isDstPSDEWizardNameDirty() && (bl || pSDELogicNodeBase.getDstPSDEWizardName() != null)) {
            iDataObject.set(FIELD_DSTPSDEWIZARDNAME, (Object)pSDELogicNodeBase.getDstPSDEWizardName());
        }
        if (pSDELogicNodeBase.isDstPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getDstPSDLParamId() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMID, (Object)pSDELogicNodeBase.getDstPSDLParamId());
        }
        if (pSDELogicNodeBase.isDstPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getDstPSDLParamName() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMNAME, (Object)pSDELogicNodeBase.getDstPSDLParamName());
        }
        if (pSDELogicNodeBase.isDstSortDirDirty() && (bl || pSDELogicNodeBase.getDstSortDir() != null)) {
            iDataObject.set(FIELD_DSTSORTDIR, (Object)pSDELogicNodeBase.getDstSortDir());
        }
        if (pSDELogicNodeBase.isDynaModelFlagDirty() && (bl || pSDELogicNodeBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELogicNodeBase.getDynaModelFlag());
        }
        if (pSDELogicNodeBase.isISPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getISPSDLParamId() != null)) {
            iDataObject.set(FIELD_ISPSDLPARAMID, (Object)pSDELogicNodeBase.getISPSDLParamId());
        }
        if (pSDELogicNodeBase.isISPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getISPSDLParamName() != null)) {
            iDataObject.set(FIELD_ISPSDLPARAMNAME, (Object)pSDELogicNodeBase.getISPSDLParamName());
        }
        if (pSDELogicNodeBase.isLeftPosDirty() && (bl || pSDELogicNodeBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSDELogicNodeBase.getLeftPos());
        }
        if (pSDELogicNodeBase.isLogicNodeSubTypeDirty() && (bl || pSDELogicNodeBase.getLogicNodeSubType() != null)) {
            iDataObject.set(FIELD_LOGICNODESUBTYPE, (Object)pSDELogicNodeBase.getLogicNodeSubType());
        }
        if (pSDELogicNodeBase.isLogicNodeTypeDirty() && (bl || pSDELogicNodeBase.getLogicNodeType() != null)) {
            iDataObject.set(FIELD_LOGICNODETYPE, (Object)pSDELogicNodeBase.getLogicNodeType());
        }
        if (pSDELogicNodeBase.isMemoDirty() && (bl || pSDELogicNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELogicNodeBase.getMemo());
        }
        if (pSDELogicNodeBase.isMsgPSLanResIdDirty() && (bl || pSDELogicNodeBase.getMsgPSLanResId() != null)) {
            iDataObject.set(FIELD_MSGPSLANRESID, (Object)pSDELogicNodeBase.getMsgPSLanResId());
        }
        if (pSDELogicNodeBase.isMsgPSLanResNameDirty() && (bl || pSDELogicNodeBase.getMsgPSLanResName() != null)) {
            iDataObject.set(FIELD_MSGPSLANRESNAME, (Object)pSDELogicNodeBase.getMsgPSLanResName());
        }
        if (pSDELogicNodeBase.isNodeParamsDirty() && (bl || pSDELogicNodeBase.getNodeParams() != null)) {
            iDataObject.set(FIELD_NODEPARAMS, (Object)pSDELogicNodeBase.getNodeParams());
        }
        if (pSDELogicNodeBase.isOptPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getOptPSDLParamId() != null)) {
            iDataObject.set(FIELD_OPTPSDLPARAMID, (Object)pSDELogicNodeBase.getOptPSDLParamId());
        }
        if (pSDELogicNodeBase.isOptPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getOptPSDLParamName() != null)) {
            iDataObject.set(FIELD_OPTPSDLPARAMNAME, (Object)pSDELogicNodeBase.getOptPSDLParamName());
        }
        if (pSDELogicNodeBase.isOrderValueDirty() && (bl || pSDELogicNodeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELogicNodeBase.getOrderValue());
        }
        if (pSDELogicNodeBase.isOSPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getOSPSDLParamId() != null)) {
            iDataObject.set(FIELD_OSPSDLPARAMID, (Object)pSDELogicNodeBase.getOSPSDLParamId());
        }
        if (pSDELogicNodeBase.isOSPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getOSPSDLParamName() != null)) {
            iDataObject.set(FIELD_OSPSDLPARAMNAME, (Object)pSDELogicNodeBase.getOSPSDLParamName());
        }
        if (pSDELogicNodeBase.isParallelOutputDirty() && (bl || pSDELogicNodeBase.getParallelOutput() != null)) {
            iDataObject.set(FIELD_PARALLELOUTPUT, (Object)pSDELogicNodeBase.getParallelOutput());
        }
        if (pSDELogicNodeBase.isParam1Dirty() && (bl || pSDELogicNodeBase.getParam1() != null)) {
            iDataObject.set(FIELD_PARAM1, (Object)pSDELogicNodeBase.getParam1());
        }
        if (pSDELogicNodeBase.isParam10Dirty() && (bl || pSDELogicNodeBase.getParam10() != null)) {
            iDataObject.set(FIELD_PARAM10, (Object)pSDELogicNodeBase.getParam10());
        }
        if (pSDELogicNodeBase.isParam11Dirty() && (bl || pSDELogicNodeBase.getParam11() != null)) {
            iDataObject.set(FIELD_PARAM11, (Object)pSDELogicNodeBase.getParam11());
        }
        if (pSDELogicNodeBase.isParam12Dirty() && (bl || pSDELogicNodeBase.getParam12() != null)) {
            iDataObject.set(FIELD_PARAM12, (Object)pSDELogicNodeBase.getParam12());
        }
        if (pSDELogicNodeBase.isParam13Dirty() && (bl || pSDELogicNodeBase.getParam13() != null)) {
            iDataObject.set(FIELD_PARAM13, (Object)pSDELogicNodeBase.getParam13());
        }
        if (pSDELogicNodeBase.isParam14Dirty() && (bl || pSDELogicNodeBase.getParam14() != null)) {
            iDataObject.set(FIELD_PARAM14, (Object)pSDELogicNodeBase.getParam14());
        }
        if (pSDELogicNodeBase.isParam2Dirty() && (bl || pSDELogicNodeBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSDELogicNodeBase.getParam2());
        }
        if (pSDELogicNodeBase.isParam3Dirty() && (bl || pSDELogicNodeBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSDELogicNodeBase.getParam3());
        }
        if (pSDELogicNodeBase.isParam4Dirty() && (bl || pSDELogicNodeBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSDELogicNodeBase.getParam4());
        }
        if (pSDELogicNodeBase.isParam5Dirty() && (bl || pSDELogicNodeBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSDELogicNodeBase.getParam5());
        }
        if (pSDELogicNodeBase.isParam6Dirty() && (bl || pSDELogicNodeBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSDELogicNodeBase.getParam6());
        }
        if (pSDELogicNodeBase.isParam7Dirty() && (bl || pSDELogicNodeBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSDELogicNodeBase.getParam7());
        }
        if (pSDELogicNodeBase.isParam8Dirty() && (bl || pSDELogicNodeBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSDELogicNodeBase.getParam8());
        }
        if (pSDELogicNodeBase.isParam9Dirty() && (bl || pSDELogicNodeBase.getParam9() != null)) {
            iDataObject.set(FIELD_PARAM9, (Object)pSDELogicNodeBase.getParam9());
        }
        if (pSDELogicNodeBase.isPSDEIdDirty() && (bl || pSDELogicNodeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDELogicNodeBase.getPSDEId());
        }
        if (pSDELogicNodeBase.isPSDELogicIdDirty() && (bl || pSDELogicNodeBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELogicNodeBase.getPSDELogicId());
        }
        if (pSDELogicNodeBase.isPSDELogicNameDirty() && (bl || pSDELogicNodeBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDELogicNodeBase.getPSDELogicName());
        }
        if (pSDELogicNodeBase.isPSDELogicNodeIdDirty() && (bl || pSDELogicNodeBase.getPSDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODEID, (Object)pSDELogicNodeBase.getPSDELogicNodeId());
        }
        if (pSDELogicNodeBase.isPSDELogicNodeNameDirty() && (bl || pSDELogicNodeBase.getPSDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODENAME, (Object)pSDELogicNodeBase.getPSDELogicNodeName());
        }
        if (pSDELogicNodeBase.isPSDEMainStateIdDirty() && (bl || pSDELogicNodeBase.getPSDEMainStateId() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATEID, (Object)pSDELogicNodeBase.getPSDEMainStateId());
        }
        if (pSDELogicNodeBase.isPSDEMainStateNameDirty() && (bl || pSDELogicNodeBase.getPSDEMainStateName() != null)) {
            iDataObject.set(FIELD_PSDEMAINSTATENAME, (Object)pSDELogicNodeBase.getPSDEMainStateName());
        }
        if (pSDELogicNodeBase.isPSDEUIActionIdDirty() && (bl || pSDELogicNodeBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDELogicNodeBase.getPSDEUIActionId());
        }
        if (pSDELogicNodeBase.isPSDEUIActionNameDirty() && (bl || pSDELogicNodeBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDELogicNodeBase.getPSDEUIActionName());
        }
        if (pSDELogicNodeBase.isPSDynaInstIdDirty() && (bl || pSDELogicNodeBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELogicNodeBase.getPSDynaInstId());
        }
        if (pSDELogicNodeBase.isPSSubSysSADetailIdDirty() && (bl || pSDELogicNodeBase.getPSSubSysSADetailId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILID, (Object)pSDELogicNodeBase.getPSSubSysSADetailId());
        }
        if (pSDELogicNodeBase.isPSSubSysSADetailNameDirty() && (bl || pSDELogicNodeBase.getPSSubSysSADetailName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSADETAILNAME, (Object)pSDELogicNodeBase.getPSSubSysSADetailName());
        }
        if (pSDELogicNodeBase.isPSSubSysServiceAPIIdDirty() && (bl || pSDELogicNodeBase.getPSSubSysServiceAPIId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPIID, (Object)pSDELogicNodeBase.getPSSubSysServiceAPIId());
        }
        if (pSDELogicNodeBase.isPSSubSysServiceAPINameDirty() && (bl || pSDELogicNodeBase.getPSSubSysServiceAPIName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSSERVICEAPINAME, (Object)pSDELogicNodeBase.getPSSubSysServiceAPIName());
        }
        if (pSDELogicNodeBase.isPSSysAIChatAgentIdDirty() && (bl || pSDELogicNodeBase.getPSSysAIChatAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTID, (Object)pSDELogicNodeBase.getPSSysAIChatAgentId());
        }
        if (pSDELogicNodeBase.isPSSysAIChatAgentNameDirty() && (bl || pSDELogicNodeBase.getPSSysAIChatAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAICHATAGENTNAME, (Object)pSDELogicNodeBase.getPSSysAIChatAgentName());
        }
        if (pSDELogicNodeBase.isPSSysAIFactoryIdDirty() && (bl || pSDELogicNodeBase.getPSSysAIFactoryId() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYID, (Object)pSDELogicNodeBase.getPSSysAIFactoryId());
        }
        if (pSDELogicNodeBase.isPSSysAIFactoryNameDirty() && (bl || pSDELogicNodeBase.getPSSysAIFactoryName() != null)) {
            iDataObject.set(FIELD_PSSYSAIFACTORYNAME, (Object)pSDELogicNodeBase.getPSSysAIFactoryName());
        }
        if (pSDELogicNodeBase.isPSSysAIPipelineAgentIdDirty() && (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTID, (Object)pSDELogicNodeBase.getPSSysAIPipelineAgentId());
        }
        if (pSDELogicNodeBase.isPSSysAIPipelineAgentNameDirty() && (bl || pSDELogicNodeBase.getPSSysAIPipelineAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIPIPELINEAGENTNAME, (Object)pSDELogicNodeBase.getPSSysAIPipelineAgentName());
        }
        if (pSDELogicNodeBase.isPSSysAIWorkerAgentIdDirty() && (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTID, (Object)pSDELogicNodeBase.getPSSysAIWorkerAgentId());
        }
        if (pSDELogicNodeBase.isPSSysAIWorkerAgentNameDirty() && (bl || pSDELogicNodeBase.getPSSysAIWorkerAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSAIWORKERAGENTNAME, (Object)pSDELogicNodeBase.getPSSysAIWorkerAgentName());
        }
        if (pSDELogicNodeBase.isPSSysBackServiceIdDirty() && (bl || pSDELogicNodeBase.getPSSysBackServiceId() != null)) {
            iDataObject.set(FIELD_PSSYSBACKSERVICEID, (Object)pSDELogicNodeBase.getPSSysBackServiceId());
        }
        if (pSDELogicNodeBase.isPSSysBackServiceNameDirty() && (bl || pSDELogicNodeBase.getPSSysBackServiceName() != null)) {
            iDataObject.set(FIELD_PSSYSBACKSERVICENAME, (Object)pSDELogicNodeBase.getPSSysBackServiceName());
        }
        if (pSDELogicNodeBase.isPSSysBDSchemeIdDirty() && (bl || pSDELogicNodeBase.getPSSysBDSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMEID, (Object)pSDELogicNodeBase.getPSSysBDSchemeId());
        }
        if (pSDELogicNodeBase.isPSSysBDSchemeNameDirty() && (bl || pSDELogicNodeBase.getPSSysBDSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBDSCHEMENAME, (Object)pSDELogicNodeBase.getPSSysBDSchemeName());
        }
        if (pSDELogicNodeBase.isPSSysBDTableIdDirty() && (bl || pSDELogicNodeBase.getPSSysBDTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLEID, (Object)pSDELogicNodeBase.getPSSysBDTableId());
        }
        if (pSDELogicNodeBase.isPSSysBDTableNameDirty() && (bl || pSDELogicNodeBase.getPSSysBDTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBDTABLENAME, (Object)pSDELogicNodeBase.getPSSysBDTableName());
        }
        if (pSDELogicNodeBase.isPSSysBIAggTableIdDirty() && (bl || pSDELogicNodeBase.getPSSysBIAggTableId() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLEID, (Object)pSDELogicNodeBase.getPSSysBIAggTableId());
        }
        if (pSDELogicNodeBase.isPSSysBIAggTableNameDirty() && (bl || pSDELogicNodeBase.getPSSysBIAggTableName() != null)) {
            iDataObject.set(FIELD_PSSYSBIAGGTABLENAME, (Object)pSDELogicNodeBase.getPSSysBIAggTableName());
        }
        if (pSDELogicNodeBase.isPSSysBICubeIdDirty() && (bl || pSDELogicNodeBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSDELogicNodeBase.getPSSysBICubeId());
        }
        if (pSDELogicNodeBase.isPSSysBICubeNameDirty() && (bl || pSDELogicNodeBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSDELogicNodeBase.getPSSysBICubeName());
        }
        if (pSDELogicNodeBase.isPSSysBIReportIdDirty() && (bl || pSDELogicNodeBase.getPSSysBIReportId() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTID, (Object)pSDELogicNodeBase.getPSSysBIReportId());
        }
        if (pSDELogicNodeBase.isPSSysBIReportNameDirty() && (bl || pSDELogicNodeBase.getPSSysBIReportName() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTNAME, (Object)pSDELogicNodeBase.getPSSysBIReportName());
        }
        if (pSDELogicNodeBase.isPSSysBISchemeIdDirty() && (bl || pSDELogicNodeBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSDELogicNodeBase.getPSSysBISchemeId());
        }
        if (pSDELogicNodeBase.isPSSysBISchemeNameDirty() && (bl || pSDELogicNodeBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSDELogicNodeBase.getPSSysBISchemeName());
        }
        if (pSDELogicNodeBase.isPSSysDataSyncAgentIdDirty() && (bl || pSDELogicNodeBase.getPSSysDataSyncAgentId() != null)) {
            iDataObject.set(FIELD_PSSYSDATASYNCAGENTID, (Object)pSDELogicNodeBase.getPSSysDataSyncAgentId());
        }
        if (pSDELogicNodeBase.isPSSysDataSyncAgentNameDirty() && (bl || pSDELogicNodeBase.getPSSysDataSyncAgentName() != null)) {
            iDataObject.set(FIELD_PSSYSDATASYNCAGENTNAME, (Object)pSDELogicNodeBase.getPSSysDataSyncAgentName());
        }
        if (pSDELogicNodeBase.isPSSysDBSchemeIdDirty() && (bl || pSDELogicNodeBase.getPSSysDBSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMEID, (Object)pSDELogicNodeBase.getPSSysDBSchemeId());
        }
        if (pSDELogicNodeBase.isPSSysDBSchemeNameDirty() && (bl || pSDELogicNodeBase.getPSSysDBSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSDBSCHEMENAME, (Object)pSDELogicNodeBase.getPSSysDBSchemeName());
        }
        if (pSDELogicNodeBase.isPSSysDBTableIdDirty() && (bl || pSDELogicNodeBase.getPSSysDBTableId() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLEID, (Object)pSDELogicNodeBase.getPSSysDBTableId());
        }
        if (pSDELogicNodeBase.isPSSysDBTableNameDirty() && (bl || pSDELogicNodeBase.getPSSysDBTableName() != null)) {
            iDataObject.set(FIELD_PSSYSDBTABLENAME, (Object)pSDELogicNodeBase.getPSSysDBTableName());
        }
        if (pSDELogicNodeBase.isPSSysDELogicNodeIdDirty() && (bl || pSDELogicNodeBase.getPSSysDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODEID, (Object)pSDELogicNodeBase.getPSSysDELogicNodeId());
        }
        if (pSDELogicNodeBase.isPSSysDELogicNodeNameDirty() && (bl || pSDELogicNodeBase.getPSSysDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSSYSDELOGICNODENAME, (Object)pSDELogicNodeBase.getPSSysDELogicNodeName());
        }
        if (pSDELogicNodeBase.isPSSysEAIElementIdDirty() && (bl || pSDELogicNodeBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSDELogicNodeBase.getPSSysEAIElementId());
        }
        if (pSDELogicNodeBase.isPSSysEAIElementNameDirty() && (bl || pSDELogicNodeBase.getPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTNAME, (Object)pSDELogicNodeBase.getPSSysEAIElementName());
        }
        if (pSDELogicNodeBase.isPSSysEAISchemeIdDirty() && (bl || pSDELogicNodeBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSDELogicNodeBase.getPSSysEAISchemeId());
        }
        if (pSDELogicNodeBase.isPSSysEAISchemeNameDirty() && (bl || pSDELogicNodeBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSDELogicNodeBase.getPSSysEAISchemeName());
        }
        if (pSDELogicNodeBase.isPSSysMsgTemplIdDirty() && (bl || pSDELogicNodeBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSDELogicNodeBase.getPSSysMsgTemplId());
        }
        if (pSDELogicNodeBase.isPSSysMsgTemplNameDirty() && (bl || pSDELogicNodeBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSDELogicNodeBase.getPSSysMsgTemplName());
        }
        if (pSDELogicNodeBase.isPSSysPFPluginIdDirty() && (bl || pSDELogicNodeBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDELogicNodeBase.getPSSysPFPluginId());
        }
        if (pSDELogicNodeBase.isPSSysPFPluginNameDirty() && (bl || pSDELogicNodeBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDELogicNodeBase.getPSSysPFPluginName());
        }
        if (pSDELogicNodeBase.isPSSysResourceIdDirty() && (bl || pSDELogicNodeBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSDELogicNodeBase.getPSSysResourceId());
        }
        if (pSDELogicNodeBase.isPSSysResourceNameDirty() && (bl || pSDELogicNodeBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSDELogicNodeBase.getPSSysResourceName());
        }
        if (pSDELogicNodeBase.isPSSysSearchDocIdDirty() && (bl || pSDELogicNodeBase.getPSSysSearchDocId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCID, (Object)pSDELogicNodeBase.getPSSysSearchDocId());
        }
        if (pSDELogicNodeBase.isPSSysSearchDocNameDirty() && (bl || pSDELogicNodeBase.getPSSysSearchDocName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHDOCNAME, (Object)pSDELogicNodeBase.getPSSysSearchDocName());
        }
        if (pSDELogicNodeBase.isPSSysSearchSchemeIdDirty() && (bl || pSDELogicNodeBase.getPSSysSearchSchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMEID, (Object)pSDELogicNodeBase.getPSSysSearchSchemeId());
        }
        if (pSDELogicNodeBase.isPSSysSearchSchemeNameDirty() && (bl || pSDELogicNodeBase.getPSSysSearchSchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSSEARCHSCHEMENAME, (Object)pSDELogicNodeBase.getPSSysSearchSchemeName());
        }
        if (pSDELogicNodeBase.isPSSysSFPluginIdDirty() && (bl || pSDELogicNodeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDELogicNodeBase.getPSSysSFPluginId());
        }
        if (pSDELogicNodeBase.isPSSysSFPluginNameDirty() && (bl || pSDELogicNodeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDELogicNodeBase.getPSSysSFPluginName());
        }
        if (pSDELogicNodeBase.isPSSysSQLCmdIdDirty() && (bl || pSDELogicNodeBase.getPSSysSQLCmdId() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDID, (Object)pSDELogicNodeBase.getPSSysSQLCmdId());
        }
        if (pSDELogicNodeBase.isPSSysSQLCmdNameDirty() && (bl || pSDELogicNodeBase.getPSSysSQLCmdName() != null)) {
            iDataObject.set(FIELD_PSSYSSQLCMDNAME, (Object)pSDELogicNodeBase.getPSSysSQLCmdName());
        }
        if (pSDELogicNodeBase.isPSSystemIdDirty() && (bl || pSDELogicNodeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDELogicNodeBase.getPSSystemId());
        }
        if (pSDELogicNodeBase.isPSSysUniStateIdDirty() && (bl || pSDELogicNodeBase.getPSSysUniStateId() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATEID, (Object)pSDELogicNodeBase.getPSSysUniStateId());
        }
        if (pSDELogicNodeBase.isPSSysUniStateNameDirty() && (bl || pSDELogicNodeBase.getPSSysUniStateName() != null)) {
            iDataObject.set(FIELD_PSSYSUNISTATENAME, (Object)pSDELogicNodeBase.getPSSysUniStateName());
        }
        if (pSDELogicNodeBase.isPSSysUtilDEIdDirty() && (bl || pSDELogicNodeBase.getPSSysUtilDEId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDEID, (Object)pSDELogicNodeBase.getPSSysUtilDEId());
        }
        if (pSDELogicNodeBase.isPSSysUtilDENameDirty() && (bl || pSDELogicNodeBase.getPSSysUtilDEName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILDENAME, (Object)pSDELogicNodeBase.getPSSysUtilDEName());
        }
        if (pSDELogicNodeBase.isPSViewMsgIdDirty() && (bl || pSDELogicNodeBase.getPSViewMsgId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGID, (Object)pSDELogicNodeBase.getPSViewMsgId());
        }
        if (pSDELogicNodeBase.isPSViewMsgNameDirty() && (bl || pSDELogicNodeBase.getPSViewMsgName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGNAME, (Object)pSDELogicNodeBase.getPSViewMsgName());
        }
        if (pSDELogicNodeBase.isPSWFDEIdDirty() && (bl || pSDELogicNodeBase.getPSWFDEId() != null)) {
            iDataObject.set(FIELD_PSWFDEID, (Object)pSDELogicNodeBase.getPSWFDEId());
        }
        if (pSDELogicNodeBase.isPSWFDENameDirty() && (bl || pSDELogicNodeBase.getPSWFDEName() != null)) {
            iDataObject.set(FIELD_PSWFDENAME, (Object)pSDELogicNodeBase.getPSWFDEName());
        }
        if (pSDELogicNodeBase.isPSWorkflowIdDirty() && (bl || pSDELogicNodeBase.getPSWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWID, (Object)pSDELogicNodeBase.getPSWorkflowId());
        }
        if (pSDELogicNodeBase.isPSWorkflowNameDirty() && (bl || pSDELogicNodeBase.getPSWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWORKFLOWNAME, (Object)pSDELogicNodeBase.getPSWorkflowName());
        }
        if (pSDELogicNodeBase.isRetPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getRetPSDLParamId() != null)) {
            iDataObject.set(FIELD_RETPSDLPARAMID, (Object)pSDELogicNodeBase.getRetPSDLParamId());
        }
        if (pSDELogicNodeBase.isRetPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getRetPSDLParamName() != null)) {
            iDataObject.set(FIELD_RETPSDLPARAMNAME, (Object)pSDELogicNodeBase.getRetPSDLParamName());
        }
        if (pSDELogicNodeBase.isShapeParamsDirty() && (bl || pSDELogicNodeBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSDELogicNodeBase.getShapeParams());
        }
        if (pSDELogicNodeBase.isSrcIndexDirty() && (bl || pSDELogicNodeBase.getSrcIndex() != null)) {
            iDataObject.set(FIELD_SRCINDEX, (Object)pSDELogicNodeBase.getSrcIndex());
        }
        if (pSDELogicNodeBase.isSrcPSDLParamIdDirty() && (bl || pSDELogicNodeBase.getSrcPSDLParamId() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMID, (Object)pSDELogicNodeBase.getSrcPSDLParamId());
        }
        if (pSDELogicNodeBase.isSrcPSDLParamNameDirty() && (bl || pSDELogicNodeBase.getSrcPSDLParamName() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMNAME, (Object)pSDELogicNodeBase.getSrcPSDLParamName());
        }
        if (pSDELogicNodeBase.isSrcSizeDirty() && (bl || pSDELogicNodeBase.getSrcSize() != null)) {
            iDataObject.set(FIELD_SRCSIZE, (Object)pSDELogicNodeBase.getSrcSize());
        }
        if (pSDELogicNodeBase.isThreadRunModeDirty() && (bl || pSDELogicNodeBase.getThreadRunMode() != null)) {
            iDataObject.set(FIELD_THREADRUNMODE, (Object)pSDELogicNodeBase.getThreadRunMode());
        }
        if (pSDELogicNodeBase.isThreadRunTimerDirty() && (bl || pSDELogicNodeBase.getThreadRunTimer() != null)) {
            iDataObject.set(FIELD_THREADRUNTIMER, (Object)pSDELogicNodeBase.getThreadRunTimer());
        }
        if (pSDELogicNodeBase.isTopPosDirty() && (bl || pSDELogicNodeBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSDELogicNodeBase.getTopPos());
        }
        if (pSDELogicNodeBase.isTSModeDirty() && (bl || pSDELogicNodeBase.getTSMode() != null)) {
            iDataObject.set(FIELD_TSMODE, (Object)pSDELogicNodeBase.getTSMode());
        }
        if (pSDELogicNodeBase.isUpdateDateDirty() && (bl || pSDELogicNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELogicNodeBase.getUpdateDate());
        }
        if (pSDELogicNodeBase.isUpdateManDirty() && (bl || pSDELogicNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELogicNodeBase.getUpdateMan());
        }
        if (pSDELogicNodeBase.isUserCatDirty() && (bl || pSDELogicNodeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELogicNodeBase.getUserCat());
        }
        if (pSDELogicNodeBase.isUserParamsDirty() && (bl || pSDELogicNodeBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDELogicNodeBase.getUserParams());
        }
        if (pSDELogicNodeBase.isUserTagDirty() && (bl || pSDELogicNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELogicNodeBase.getUserTag());
        }
        if (pSDELogicNodeBase.isUserTag2Dirty() && (bl || pSDELogicNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELogicNodeBase.getUserTag2());
        }
        if (pSDELogicNodeBase.isUserTag3Dirty() && (bl || pSDELogicNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELogicNodeBase.getUserTag3());
        }
        if (pSDELogicNodeBase.isUserTag4Dirty() && (bl || pSDELogicNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELogicNodeBase.getUserTag4());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSDELogicNodeBase.remove(this, n);
    }

    private static boolean remove(PSDELogicNodeBase pSDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicNodeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDELogicNodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELogicNodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELogicNodeBase.resetCustomDSTParam();
                return true;
            }
            case 4: {
                pSDELogicNodeBase.resetCustomSrcParam();
                return true;
            }
            case 5: {
                pSDELogicNodeBase.resetDebugMode();
                return true;
            }
            case 6: {
                pSDELogicNodeBase.resetDstPSDEUtilDEId();
                return true;
            }
            case 7: {
                pSDELogicNodeBase.resetDstPSDEUtilDEName();
                return true;
            }
            case 8: {
                pSDELogicNodeBase.resetDstIndex();
                return true;
            }
            case 9: {
                pSDELogicNodeBase.resetDstParamAction();
                return true;
            }
            case 10: {
                pSDELogicNodeBase.resetDstPSDEActionId();
                return true;
            }
            case 11: {
                pSDELogicNodeBase.resetDstPSDEActionName();
                return true;
            }
            case 12: {
                pSDELogicNodeBase.resetDstPSDEDataExpId();
                return true;
            }
            case 13: {
                pSDELogicNodeBase.resetDstPSDEDataExpName();
                return true;
            }
            case 14: {
                pSDELogicNodeBase.resetDstPSDEDataFlowId();
                return true;
            }
            case 15: {
                pSDELogicNodeBase.resetDstPSDEDataFlowName();
                return true;
            }
            case 16: {
                pSDELogicNodeBase.resetDstPSDEDataImpId();
                return true;
            }
            case 17: {
                pSDELogicNodeBase.resetDstPSDEDataImpName();
                return true;
            }
            case 18: {
                pSDELogicNodeBase.resetDstPSDEDataQueryId();
                return true;
            }
            case 19: {
                pSDELogicNodeBase.resetDstPSDEDataQueryName();
                return true;
            }
            case 20: {
                pSDELogicNodeBase.resetDstPSDEDataSetId();
                return true;
            }
            case 21: {
                pSDELogicNodeBase.resetDstPSDEDataSetName();
                return true;
            }
            case 22: {
                pSDELogicNodeBase.resetDstPSDEDataSyncId();
                return true;
            }
            case 23: {
                pSDELogicNodeBase.resetDstPSDEDataSyncName();
                return true;
            }
            case 24: {
                pSDELogicNodeBase.resetDstPSDEDTSQueueId();
                return true;
            }
            case 25: {
                pSDELogicNodeBase.resetDstPSDEDTSQueueName();
                return true;
            }
            case 26: {
                pSDELogicNodeBase.resetDstPSDEFGroupId();
                return true;
            }
            case 27: {
                pSDELogicNodeBase.resetDstPSDEFGroupName();
                return true;
            }
            case 28: {
                pSDELogicNodeBase.resetDstPSDEFormId();
                return true;
            }
            case 29: {
                pSDELogicNodeBase.resetDstPSDEFormName();
                return true;
            }
            case 30: {
                pSDELogicNodeBase.resetDstPSDEFValueRuleId();
                return true;
            }
            case 31: {
                pSDELogicNodeBase.resetDstPSDEFValueRuleName();
                return true;
            }
            case 32: {
                pSDELogicNodeBase.resetDstPSDEId();
                return true;
            }
            case 33: {
                pSDELogicNodeBase.resetDstPSDELogicId();
                return true;
            }
            case 34: {
                pSDELogicNodeBase.resetDstPSDELogicName();
                return true;
            }
            case 35: {
                pSDELogicNodeBase.resetDstPSDEMapId();
                return true;
            }
            case 36: {
                pSDELogicNodeBase.resetDstPSDEMapName();
                return true;
            }
            case 37: {
                pSDELogicNodeBase.resetDstPSDEName();
                return true;
            }
            case 38: {
                pSDELogicNodeBase.resetDstPSDENotifyId();
                return true;
            }
            case 39: {
                pSDELogicNodeBase.resetDstPSDENotifyName();
                return true;
            }
            case 40: {
                pSDELogicNodeBase.resetDstPSDEPrintId();
                return true;
            }
            case 41: {
                pSDELogicNodeBase.resetDstPSDEPrintName();
                return true;
            }
            case 42: {
                pSDELogicNodeBase.resetDstPSDEReportId();
                return true;
            }
            case 43: {
                pSDELogicNodeBase.resetDstPSDEReportName();
                return true;
            }
            case 44: {
                pSDELogicNodeBase.resetDstPSDESampleDataId();
                return true;
            }
            case 45: {
                pSDELogicNodeBase.resetDstPSDESampleDataName();
                return true;
            }
            case 46: {
                pSDELogicNodeBase.resetDstPSDEUAGroupId();
                return true;
            }
            case 47: {
                pSDELogicNodeBase.resetDstPSDEUAGroupName();
                return true;
            }
            case 48: {
                pSDELogicNodeBase.resetDstPSDEUILogicId();
                return true;
            }
            case 49: {
                pSDELogicNodeBase.resetDstPSDEUILogicName();
                return true;
            }
            case 50: {
                pSDELogicNodeBase.resetDstPSDEViewId();
                return true;
            }
            case 51: {
                pSDELogicNodeBase.resetDstPSDEViewName();
                return true;
            }
            case 52: {
                pSDELogicNodeBase.resetDstPSDEVRGroupId();
                return true;
            }
            case 53: {
                pSDELogicNodeBase.resetDstPSDEVRGroupName();
                return true;
            }
            case 54: {
                pSDELogicNodeBase.resetDstPSDEWizardId();
                return true;
            }
            case 55: {
                pSDELogicNodeBase.resetDstPSDEWizardName();
                return true;
            }
            case 56: {
                pSDELogicNodeBase.resetDstPSDLParamId();
                return true;
            }
            case 57: {
                pSDELogicNodeBase.resetDstPSDLParamName();
                return true;
            }
            case 58: {
                pSDELogicNodeBase.resetDstSortDir();
                return true;
            }
            case 59: {
                pSDELogicNodeBase.resetDynaModelFlag();
                return true;
            }
            case 60: {
                pSDELogicNodeBase.resetISPSDLParamId();
                return true;
            }
            case 61: {
                pSDELogicNodeBase.resetISPSDLParamName();
                return true;
            }
            case 62: {
                pSDELogicNodeBase.resetLeftPos();
                return true;
            }
            case 63: {
                pSDELogicNodeBase.resetLogicNodeSubType();
                return true;
            }
            case 64: {
                pSDELogicNodeBase.resetLogicNodeType();
                return true;
            }
            case 65: {
                pSDELogicNodeBase.resetMemo();
                return true;
            }
            case 66: {
                pSDELogicNodeBase.resetMsgPSLanResId();
                return true;
            }
            case 67: {
                pSDELogicNodeBase.resetMsgPSLanResName();
                return true;
            }
            case 68: {
                pSDELogicNodeBase.resetNodeParams();
                return true;
            }
            case 69: {
                pSDELogicNodeBase.resetOptPSDLParamId();
                return true;
            }
            case 70: {
                pSDELogicNodeBase.resetOptPSDLParamName();
                return true;
            }
            case 71: {
                pSDELogicNodeBase.resetOrderValue();
                return true;
            }
            case 72: {
                pSDELogicNodeBase.resetOSPSDLParamId();
                return true;
            }
            case 73: {
                pSDELogicNodeBase.resetOSPSDLParamName();
                return true;
            }
            case 74: {
                pSDELogicNodeBase.resetParallelOutput();
                return true;
            }
            case 75: {
                pSDELogicNodeBase.resetParam1();
                return true;
            }
            case 76: {
                pSDELogicNodeBase.resetParam10();
                return true;
            }
            case 77: {
                pSDELogicNodeBase.resetParam11();
                return true;
            }
            case 78: {
                pSDELogicNodeBase.resetParam12();
                return true;
            }
            case 79: {
                pSDELogicNodeBase.resetParam13();
                return true;
            }
            case 80: {
                pSDELogicNodeBase.resetParam14();
                return true;
            }
            case 81: {
                pSDELogicNodeBase.resetParam2();
                return true;
            }
            case 82: {
                pSDELogicNodeBase.resetParam3();
                return true;
            }
            case 83: {
                pSDELogicNodeBase.resetParam4();
                return true;
            }
            case 84: {
                pSDELogicNodeBase.resetParam5();
                return true;
            }
            case 85: {
                pSDELogicNodeBase.resetParam6();
                return true;
            }
            case 86: {
                pSDELogicNodeBase.resetParam7();
                return true;
            }
            case 87: {
                pSDELogicNodeBase.resetParam8();
                return true;
            }
            case 88: {
                pSDELogicNodeBase.resetParam9();
                return true;
            }
            case 89: {
                pSDELogicNodeBase.resetPSDEId();
                return true;
            }
            case 90: {
                pSDELogicNodeBase.resetPSDELogicId();
                return true;
            }
            case 91: {
                pSDELogicNodeBase.resetPSDELogicName();
                return true;
            }
            case 92: {
                pSDELogicNodeBase.resetPSDELogicNodeId();
                return true;
            }
            case 93: {
                pSDELogicNodeBase.resetPSDELogicNodeName();
                return true;
            }
            case 94: {
                pSDELogicNodeBase.resetPSDEMainStateId();
                return true;
            }
            case 95: {
                pSDELogicNodeBase.resetPSDEMainStateName();
                return true;
            }
            case 96: {
                pSDELogicNodeBase.resetPSDEUIActionId();
                return true;
            }
            case 97: {
                pSDELogicNodeBase.resetPSDEUIActionName();
                return true;
            }
            case 98: {
                pSDELogicNodeBase.resetPSDynaInstId();
                return true;
            }
            case 99: {
                pSDELogicNodeBase.resetPSSubSysSADetailId();
                return true;
            }
            case 100: {
                pSDELogicNodeBase.resetPSSubSysSADetailName();
                return true;
            }
            case 101: {
                pSDELogicNodeBase.resetPSSubSysServiceAPIId();
                return true;
            }
            case 102: {
                pSDELogicNodeBase.resetPSSubSysServiceAPIName();
                return true;
            }
            case 103: {
                pSDELogicNodeBase.resetPSSysAIChatAgentId();
                return true;
            }
            case 104: {
                pSDELogicNodeBase.resetPSSysAIChatAgentName();
                return true;
            }
            case 105: {
                pSDELogicNodeBase.resetPSSysAIFactoryId();
                return true;
            }
            case 106: {
                pSDELogicNodeBase.resetPSSysAIFactoryName();
                return true;
            }
            case 107: {
                pSDELogicNodeBase.resetPSSysAIPipelineAgentId();
                return true;
            }
            case 108: {
                pSDELogicNodeBase.resetPSSysAIPipelineAgentName();
                return true;
            }
            case 109: {
                pSDELogicNodeBase.resetPSSysAIWorkerAgentId();
                return true;
            }
            case 110: {
                pSDELogicNodeBase.resetPSSysAIWorkerAgentName();
                return true;
            }
            case 111: {
                pSDELogicNodeBase.resetPSSysBackServiceId();
                return true;
            }
            case 112: {
                pSDELogicNodeBase.resetPSSysBackServiceName();
                return true;
            }
            case 113: {
                pSDELogicNodeBase.resetPSSysBDSchemeId();
                return true;
            }
            case 114: {
                pSDELogicNodeBase.resetPSSysBDSchemeName();
                return true;
            }
            case 115: {
                pSDELogicNodeBase.resetPSSysBDTableId();
                return true;
            }
            case 116: {
                pSDELogicNodeBase.resetPSSysBDTableName();
                return true;
            }
            case 117: {
                pSDELogicNodeBase.resetPSSysBIAggTableId();
                return true;
            }
            case 118: {
                pSDELogicNodeBase.resetPSSysBIAggTableName();
                return true;
            }
            case 119: {
                pSDELogicNodeBase.resetPSSysBICubeId();
                return true;
            }
            case 120: {
                pSDELogicNodeBase.resetPSSysBICubeName();
                return true;
            }
            case 121: {
                pSDELogicNodeBase.resetPSSysBIReportId();
                return true;
            }
            case 122: {
                pSDELogicNodeBase.resetPSSysBIReportName();
                return true;
            }
            case 123: {
                pSDELogicNodeBase.resetPSSysBISchemeId();
                return true;
            }
            case 124: {
                pSDELogicNodeBase.resetPSSysBISchemeName();
                return true;
            }
            case 125: {
                pSDELogicNodeBase.resetPSSysDataSyncAgentId();
                return true;
            }
            case 126: {
                pSDELogicNodeBase.resetPSSysDataSyncAgentName();
                return true;
            }
            case 127: {
                pSDELogicNodeBase.resetPSSysDBSchemeId();
                return true;
            }
            case 128: {
                pSDELogicNodeBase.resetPSSysDBSchemeName();
                return true;
            }
            case 129: {
                pSDELogicNodeBase.resetPSSysDBTableId();
                return true;
            }
            case 130: {
                pSDELogicNodeBase.resetPSSysDBTableName();
                return true;
            }
            case 131: {
                pSDELogicNodeBase.resetPSSysDELogicNodeId();
                return true;
            }
            case 132: {
                pSDELogicNodeBase.resetPSSysDELogicNodeName();
                return true;
            }
            case 133: {
                pSDELogicNodeBase.resetPSSysEAIElementId();
                return true;
            }
            case 134: {
                pSDELogicNodeBase.resetPSSysEAIElementName();
                return true;
            }
            case 135: {
                pSDELogicNodeBase.resetPSSysEAISchemeId();
                return true;
            }
            case 136: {
                pSDELogicNodeBase.resetPSSysEAISchemeName();
                return true;
            }
            case 137: {
                pSDELogicNodeBase.resetPSSysMsgTemplId();
                return true;
            }
            case 138: {
                pSDELogicNodeBase.resetPSSysMsgTemplName();
                return true;
            }
            case 139: {
                pSDELogicNodeBase.resetPSSysPFPluginId();
                return true;
            }
            case 140: {
                pSDELogicNodeBase.resetPSSysPFPluginName();
                return true;
            }
            case 141: {
                pSDELogicNodeBase.resetPSSysResourceId();
                return true;
            }
            case 142: {
                pSDELogicNodeBase.resetPSSysResourceName();
                return true;
            }
            case 143: {
                pSDELogicNodeBase.resetPSSysSearchDocId();
                return true;
            }
            case 144: {
                pSDELogicNodeBase.resetPSSysSearchDocName();
                return true;
            }
            case 145: {
                pSDELogicNodeBase.resetPSSysSearchSchemeId();
                return true;
            }
            case 146: {
                pSDELogicNodeBase.resetPSSysSearchSchemeName();
                return true;
            }
            case 147: {
                pSDELogicNodeBase.resetPSSysSFPluginId();
                return true;
            }
            case 148: {
                pSDELogicNodeBase.resetPSSysSFPluginName();
                return true;
            }
            case 149: {
                pSDELogicNodeBase.resetPSSysSQLCmdId();
                return true;
            }
            case 150: {
                pSDELogicNodeBase.resetPSSysSQLCmdName();
                return true;
            }
            case 151: {
                pSDELogicNodeBase.resetPSSystemId();
                return true;
            }
            case 152: {
                pSDELogicNodeBase.resetPSSysUniStateId();
                return true;
            }
            case 153: {
                pSDELogicNodeBase.resetPSSysUniStateName();
                return true;
            }
            case 154: {
                pSDELogicNodeBase.resetPSSysUtilDEId();
                return true;
            }
            case 155: {
                pSDELogicNodeBase.resetPSSysUtilDEName();
                return true;
            }
            case 156: {
                pSDELogicNodeBase.resetPSViewMsgId();
                return true;
            }
            case 157: {
                pSDELogicNodeBase.resetPSViewMsgName();
                return true;
            }
            case 158: {
                pSDELogicNodeBase.resetPSWFDEId();
                return true;
            }
            case 159: {
                pSDELogicNodeBase.resetPSWFDEName();
                return true;
            }
            case 160: {
                pSDELogicNodeBase.resetPSWorkflowId();
                return true;
            }
            case 161: {
                pSDELogicNodeBase.resetPSWorkflowName();
                return true;
            }
            case 162: {
                pSDELogicNodeBase.resetRetPSDLParamId();
                return true;
            }
            case 163: {
                pSDELogicNodeBase.resetRetPSDLParamName();
                return true;
            }
            case 164: {
                pSDELogicNodeBase.resetShapeParams();
                return true;
            }
            case 165: {
                pSDELogicNodeBase.resetSrcIndex();
                return true;
            }
            case 166: {
                pSDELogicNodeBase.resetSrcPSDLParamId();
                return true;
            }
            case 167: {
                pSDELogicNodeBase.resetSrcPSDLParamName();
                return true;
            }
            case 168: {
                pSDELogicNodeBase.resetSrcSize();
                return true;
            }
            case 169: {
                pSDELogicNodeBase.resetThreadRunMode();
                return true;
            }
            case 170: {
                pSDELogicNodeBase.resetThreadRunTimer();
                return true;
            }
            case 171: {
                pSDELogicNodeBase.resetTopPos();
                return true;
            }
            case 172: {
                pSDELogicNodeBase.resetTSMode();
                return true;
            }
            case 173: {
                pSDELogicNodeBase.resetUpdateDate();
                return true;
            }
            case 174: {
                pSDELogicNodeBase.resetUpdateMan();
                return true;
            }
            case 175: {
                pSDELogicNodeBase.resetUserCat();
                return true;
            }
            case 176: {
                pSDELogicNodeBase.resetUserParams();
                return true;
            }
            case 177: {
                pSDELogicNodeBase.resetUserTag();
                return true;
            }
            case 178: {
                pSDELogicNodeBase.resetUserTag2();
                return true;
            }
            case 179: {
                pSDELogicNodeBase.resetUserTag3();
                return true;
            }
            case 180: {
                pSDELogicNodeBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getDstPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDE();
        }
        if (this.getDstPSDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELock;
        synchronized (n) {
            if (this.dstpsde != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEId(), (Object)this.dstpsde.getPSDataEntityId()) != 0L) {
                this.dstpsde = null;
            }
            if (this.dstpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getDstPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.dstpsde = pSDataEntity;
            }
            return this.dstpsde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getDstPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEAction();
        }
        if (this.getDstPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEActionLock;
        synchronized (n) {
            if (this.dstpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEActionId(), (Object)this.dstpsdeaction.getPSDEActionId()) != 0L) {
                this.dstpsdeaction = null;
            }
            if (this.dstpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getDstPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.dstpsdeaction = pSDEAction;
            }
            return this.dstpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataExp getDstPSDEDataExp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataExp();
        }
        if (this.getDstPSDEDataExpId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataExpLock;
        synchronized (n) {
            if (this.dstpsdedataexp != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataExpId(), (Object)this.dstpsdedataexp.getPSDEDataExpId()) != 0L) {
                this.dstpsdedataexp = null;
            }
            if (this.dstpsdedataexp == null) {
                PSDEDataExp pSDEDataExp = new PSDEDataExp();
                pSDEDataExp.setPSDEDataExpId(this.getDstPSDEDataExpId());
                PSDEDataExpService pSDEDataExpService = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataExpService.autoGet((IEntity)pSDEDataExp);
                this.dstpsdedataexp = pSDEDataExp;
            }
            return this.dstpsdedataexp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataImp getDstPSDEDataImp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataImp();
        }
        if (this.getDstPSDEDataImpId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataImpLock;
        synchronized (n) {
            if (this.dstpsdedataimp != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataImpId(), (Object)this.dstpsdedataimp.getPSDEDataImpId()) != 0L) {
                this.dstpsdedataimp = null;
            }
            if (this.dstpsdedataimp == null) {
                PSDEDataImp pSDEDataImp = new PSDEDataImp();
                pSDEDataImp.setPSDEDataImpId(this.getDstPSDEDataImpId());
                PSDEDataImpService pSDEDataImpService = (PSDEDataImpService)ServiceGlobal.getService(PSDEDataImpService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataImpService.autoGet((IEntity)pSDEDataImp);
                this.dstpsdedataimp = pSDEDataImp;
            }
            return this.dstpsdedataimp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getDstPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQuery();
        }
        if (this.getDstPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataQueryLock;
        synchronized (n) {
            if (this.dstpsdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataQueryId(), (Object)this.dstpsdedataquery.getPSDEDataQueryId()) != 0L) {
                this.dstpsdedataquery = null;
            }
            if (this.dstpsdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getDstPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.dstpsdedataquery = pSDEDataQuery;
            }
            return this.dstpsdedataquery;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSet();
        }
        if (this.getDstPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataSetLock;
        synchronized (n) {
            if (this.dstpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataSetId(), (Object)this.dstpsdedataset.getPSDEDataSetId()) != 0L) {
                this.dstpsdedataset = null;
            }
            if (this.dstpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getDstPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet((IEntity)pSDEDataSet);
                this.dstpsdedataset = pSDEDataSet;
            }
            return this.dstpsdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSync getDstPSDEDataSync() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSync();
        }
        if (this.getDstPSDEDataSyncId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataSyncLock;
        synchronized (n) {
            if (this.dstpsdedatasync != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataSyncId(), (Object)this.dstpsdedatasync.getPSDEDataSyncId()) != 0L) {
                this.dstpsdedatasync = null;
            }
            if (this.dstpsdedatasync == null) {
                PSDEDataSync pSDEDataSync = new PSDEDataSync();
                pSDEDataSync.setPSDEDataSyncId(this.getDstPSDEDataSyncId());
                PSDEDataSyncService pSDEDataSyncService = (PSDEDataSyncService)ServiceGlobal.getService(PSDEDataSyncService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSyncService.autoGet((IEntity)pSDEDataSync);
                this.dstpsdedatasync = pSDEDataSync;
            }
            return this.dstpsdedatasync;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDTSQueue getDstPSDEDTSQueue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDTSQueue();
        }
        if (this.getDstPSDEDTSQueueId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDTSQueueLock;
        synchronized (n) {
            if (this.dstpsdedtsqueue != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDTSQueueId(), (Object)this.dstpsdedtsqueue.getPSDEDTSQueueId()) != 0L) {
                this.dstpsdedtsqueue = null;
            }
            if (this.dstpsdedtsqueue == null) {
                PSDEDTSQueue pSDEDTSQueue = new PSDEDTSQueue();
                pSDEDTSQueue.setPSDEDTSQueueId(this.getDstPSDEDTSQueueId());
                PSDEDTSQueueService pSDEDTSQueueService = (PSDEDTSQueueService)ServiceGlobal.getService(PSDEDTSQueueService.class, (SessionFactory)this.getSessionFactory());
                pSDEDTSQueueService.autoGet((IEntity)pSDEDTSQueue);
                this.dstpsdedtsqueue = pSDEDTSQueue;
            }
            return this.dstpsdedtsqueue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFGroup getDstPSDEFGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFGroup();
        }
        if (this.getDstPSDEFGroupId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEFGroupLock;
        synchronized (n) {
            if (this.dstpsdefgroup != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEFGroupId(), (Object)this.dstpsdefgroup.getPSDEFGroupId()) != 0L) {
                this.dstpsdefgroup = null;
            }
            if (this.dstpsdefgroup == null) {
                PSDEFGroup pSDEFGroup = new PSDEFGroup();
                pSDEFGroup.setPSDEFGroupId(this.getDstPSDEFGroupId());
                PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEFGroupService.autoGet((IEntity)pSDEFGroup);
                this.dstpsdefgroup = pSDEFGroup;
            }
            return this.dstpsdefgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getDstPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEForm();
        }
        if (this.getDstPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEFormLock;
        synchronized (n) {
            if (this.dstpsdeform != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEFormId(), (Object)this.dstpsdeform.getPSDEFormId()) != 0L) {
                this.dstpsdeform = null;
            }
            if (this.dstpsdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getDstPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.dstpsdeform = pSDEForm;
            }
            return this.dstpsdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getDstPSDEFValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFValueRule();
        }
        if (this.getDstPSDEFValueRuleId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEFValueRuleLock;
        synchronized (n) {
            if (this.dstpsdefvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEFValueRuleId(), (Object)this.dstpsdefvaluerule.getPSDEFValueRuleId()) != 0L) {
                this.dstpsdefvaluerule = null;
            }
            if (this.dstpsdefvaluerule == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getDstPSDEFValueRuleId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet((IEntity)pSDEFValueRule);
                this.dstpsdefvaluerule = pSDEFValueRule;
            }
            return this.dstpsdefvaluerule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getDstPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParam();
        }
        if (this.getDstPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objDstPSDLParamLock;
        synchronized (n) {
            if (this.dstpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDLParamId(), (Object)this.dstpsdlparam.getPSDELogicParamId()) != 0L) {
                this.dstpsdlparam = null;
            }
            if (this.dstpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getDstPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.dstpsdlparam = pSDELogicParam;
            }
            return this.dstpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getISPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getISPSDLParam();
        }
        if (this.getISPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objISPSDLParamLock;
        synchronized (n) {
            if (this.ispsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getISPSDLParamId(), (Object)this.ispsdlparam.getPSDELogicParamId()) != 0L) {
                this.ispsdlparam = null;
            }
            if (this.ispsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getISPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.ispsdlparam = pSDELogicParam;
            }
            return this.ispsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getOptPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOptPSDLParam();
        }
        if (this.getOptPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objOptPSDLParamLock;
        synchronized (n) {
            if (this.optpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getOptPSDLParamId(), (Object)this.optpsdlparam.getPSDELogicParamId()) != 0L) {
                this.optpsdlparam = null;
            }
            if (this.optpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getOptPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.optpsdlparam = pSDELogicParam;
            }
            return this.optpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getOSPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSPSDLParam();
        }
        if (this.getOSPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objOSPSDLParamLock;
        synchronized (n) {
            if (this.ospsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getOSPSDLParamId(), (Object)this.ospsdlparam.getPSDELogicParamId()) != 0L) {
                this.ospsdlparam = null;
            }
            if (this.ospsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getOSPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.ospsdlparam = pSDELogicParam;
            }
            return this.ospsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getRetPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetPSDLParam();
        }
        if (this.getRetPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objRetPSDLParamLock;
        synchronized (n) {
            if (this.retpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getRetPSDLParamId(), (Object)this.retpsdlparam.getPSDELogicParamId()) != 0L) {
                this.retpsdlparam = null;
            }
            if (this.retpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getRetPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.retpsdlparam = pSDELogicParam;
            }
            return this.retpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getSrcPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParam();
        }
        if (this.getSrcPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDLParamLock;
        synchronized (n) {
            if (this.srcpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDLParamId(), (Object)this.srcpsdlparam.getPSDELogicParamId()) != 0L) {
                this.srcpsdlparam = null;
            }
            if (this.srcpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getSrcPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.srcpsdlparam = pSDELogicParam;
            }
            return this.srcpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getDstPSDEDataFlow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataFlow();
        }
        if (this.getDstPSDEDataFlowId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataFlowLock;
        synchronized (n) {
            if (this.dstpsdedataflow != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataFlowId(), (Object)this.dstpsdedataflow.getPSDELogicId()) != 0L) {
                this.dstpsdedataflow = null;
            }
            if (this.dstpsdedataflow == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getDstPSDEDataFlowId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.dstpsdedataflow = pSDELogic;
            }
            return this.dstpsdedataflow;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getDstPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogic();
        }
        if (this.getDstPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELogicLock;
        synchronized (n) {
            if (this.dstpsdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDELogicId(), (Object)this.dstpsdelogic.getPSDELogicId()) != 0L) {
                this.dstpsdelogic = null;
            }
            if (this.dstpsdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getDstPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.dstpsdelogic = pSDELogic;
            }
            return this.dstpsdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getDstPSDEUILogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUILogic();
        }
        if (this.getDstPSDEUILogicId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEUILogicLock;
        synchronized (n) {
            if (this.dstpsdeuilogic != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEUILogicId(), (Object)this.dstpsdeuilogic.getPSDELogicId()) != 0L) {
                this.dstpsdeuilogic = null;
            }
            if (this.dstpsdeuilogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getDstPSDEUILogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.dstpsdeuilogic = pSDELogic;
            }
            return this.dstpsdeuilogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMainState getPSDEMainState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMainState();
        }
        if (this.getPSDEMainStateId() == null) {
            return null;
        }
        Integer n = this.objPSDEMainStateLock;
        synchronized (n) {
            if (this.psdemainstate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMainStateId(), (Object)this.psdemainstate.getPSDEMainStateId()) != 0L) {
                this.psdemainstate = null;
            }
            if (this.psdemainstate == null) {
                PSDEMainState pSDEMainState = new PSDEMainState();
                pSDEMainState.setPSDEMainStateId(this.getPSDEMainStateId());
                PSDEMainStateService pSDEMainStateService = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
                pSDEMainStateService.autoGet((IEntity)pSDEMainState);
                this.psdemainstate = pSDEMainState;
            }
            return this.psdemainstate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMap getDstPSDEMap() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEMap();
        }
        if (this.getDstPSDEMapId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEMapLock;
        synchronized (n) {
            if (this.dstpsdemap != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEMapId(), (Object)this.dstpsdemap.getPSDEMapId()) != 0L) {
                this.dstpsdemap = null;
            }
            if (this.dstpsdemap == null) {
                PSDEMap pSDEMap = new PSDEMap();
                pSDEMap.setPSDEMapId(this.getDstPSDEMapId());
                PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
                pSDEMapService.autoGet((IEntity)pSDEMap);
                this.dstpsdemap = pSDEMap;
            }
            return this.dstpsdemap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDENotify getDstPSDENotify() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDENotify();
        }
        if (this.getDstPSDENotifyId() == null) {
            return null;
        }
        Integer n = this.objDstPSDENotifyLock;
        synchronized (n) {
            if (this.dstpsdenotify != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDENotifyId(), (Object)this.dstpsdenotify.getPSDENotifyId()) != 0L) {
                this.dstpsdenotify = null;
            }
            if (this.dstpsdenotify == null) {
                PSDENotify pSDENotify = new PSDENotify();
                pSDENotify.setPSDENotifyId(this.getDstPSDENotifyId());
                PSDENotifyService pSDENotifyService = (PSDENotifyService)ServiceGlobal.getService(PSDENotifyService.class, (SessionFactory)this.getSessionFactory());
                pSDENotifyService.autoGet((IEntity)pSDENotify);
                this.dstpsdenotify = pSDENotify;
            }
            return this.dstpsdenotify;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEPrint getDstPSDEPrint() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEPrint();
        }
        if (this.getDstPSDEPrintId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEPrintLock;
        synchronized (n) {
            if (this.dstpsdeprint != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEPrintId(), (Object)this.dstpsdeprint.getPSDEPrintId()) != 0L) {
                this.dstpsdeprint = null;
            }
            if (this.dstpsdeprint == null) {
                PSDEPrint pSDEPrint = new PSDEPrint();
                pSDEPrint.setPSDEPrintId(this.getDstPSDEPrintId());
                PSDEPrintService pSDEPrintService = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
                pSDEPrintService.autoGet((IEntity)pSDEPrint);
                this.dstpsdeprint = pSDEPrint;
            }
            return this.dstpsdeprint;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEReport getDstPSDEReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEReport();
        }
        if (this.getDstPSDEReportId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEReportLock;
        synchronized (n) {
            if (this.dstpsdereport != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEReportId(), (Object)this.dstpsdereport.getPSDEReportId()) != 0L) {
                this.dstpsdereport = null;
            }
            if (this.dstpsdereport == null) {
                PSDEReport pSDEReport = new PSDEReport();
                pSDEReport.setPSDEReportId(this.getDstPSDEReportId());
                PSDEReportService pSDEReportService = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
                pSDEReportService.autoGet((IEntity)pSDEReport);
                this.dstpsdereport = pSDEReport;
            }
            return this.dstpsdereport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESampleData getDstPSDESampleData() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDESampleData();
        }
        if (this.getDstPSDESampleDataId() == null) {
            return null;
        }
        Integer n = this.objDstPSDESampleDataLock;
        synchronized (n) {
            if (this.dstpsdesampledata != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDESampleDataId(), (Object)this.dstpsdesampledata.getPSDESampleDataId()) != 0L) {
                this.dstpsdesampledata = null;
            }
            if (this.dstpsdesampledata == null) {
                PSDESampleData pSDESampleData = new PSDESampleData();
                pSDESampleData.setPSDESampleDataId(this.getDstPSDESampleDataId());
                PSDESampleDataService pSDESampleDataService = (PSDESampleDataService)ServiceGlobal.getService(PSDESampleDataService.class, (SessionFactory)this.getSessionFactory());
                pSDESampleDataService.autoGet((IEntity)pSDESampleData);
                this.dstpsdesampledata = pSDESampleData;
            }
            return this.dstpsdesampledata;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getDstPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUAGroup();
        }
        if (this.getDstPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEUAGroupLock;
        synchronized (n) {
            if (this.dstpsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEUAGroupId(), (Object)this.dstpsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.dstpsdeuagroup = null;
            }
            if (this.dstpsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getDstPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.dstpsdeuagroup = pSDEUAGroup;
            }
            return this.dstpsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUtilDE getDstPSDEUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEUtilDE();
        }
        if (this.getDstPSDEUtilDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEUtilDELock;
        synchronized (n) {
            if (this.dstpsdeutilde != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEUtilDEId(), (Object)this.dstpsdeutilde.getPSDEUtilDEId()) != 0L) {
                this.dstpsdeutilde = null;
            }
            if (this.dstpsdeutilde == null) {
                PSDEUtilDE pSDEUtilDE = new PSDEUtilDE();
                pSDEUtilDE.setPSDEUtilDEId(this.getDstPSDEUtilDEId());
                PSDEUtilDEService pSDEUtilDEService = (PSDEUtilDEService)ServiceGlobal.getService(PSDEUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSDEUtilDEService.autoGet((IEntity)pSDEUtilDE);
                this.dstpsdeutilde = pSDEUtilDE;
            }
            return this.dstpsdeutilde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getDstPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEView();
        }
        if (this.getDstPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEViewLock;
        synchronized (n) {
            if (this.dstpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEViewId(), (Object)this.dstpsdeview.getPSDEViewBaseId()) != 0L) {
                this.dstpsdeview = null;
            }
            if (this.dstpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getDstPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.dstpsdeview = pSDEViewBase;
            }
            return this.dstpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEVRGroup getDstPSDEVRGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEVRGroup();
        }
        if (this.getDstPSDEVRGroupId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEVRGroupLock;
        synchronized (n) {
            if (this.dstpsdevrgroup != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEVRGroupId(), (Object)this.dstpsdevrgroup.getPSDEVRGroupId()) != 0L) {
                this.dstpsdevrgroup = null;
            }
            if (this.dstpsdevrgroup == null) {
                PSDEVRGroup pSDEVRGroup = new PSDEVRGroup();
                pSDEVRGroup.setPSDEVRGroupId(this.getDstPSDEVRGroupId());
                PSDEVRGroupService pSDEVRGroupService = (PSDEVRGroupService)ServiceGlobal.getService(PSDEVRGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEVRGroupService.autoGet((IEntity)pSDEVRGroup);
                this.dstpsdevrgroup = pSDEVRGroup;
            }
            return this.dstpsdevrgroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEWizard getDstPSDEWizard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEWizard();
        }
        if (this.getDstPSDEWizardId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEWizardLock;
        synchronized (n) {
            if (this.dstpsdewizard != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEWizardId(), (Object)this.dstpsdewizard.getPSDEWizardId()) != 0L) {
                this.dstpsdewizard = null;
            }
            if (this.dstpsdewizard == null) {
                PSDEWizard pSDEWizard = new PSDEWizard();
                pSDEWizard.setPSDEWizardId(this.getDstPSDEWizardId());
                PSDEWizardService pSDEWizardService = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
                pSDEWizardService.autoGet((IEntity)pSDEWizard);
                this.dstpsdewizard = pSDEWizard;
            }
            return this.dstpsdewizard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getMsgPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgPSLanRes();
        }
        if (this.getMsgPSLanResId() == null) {
            return null;
        }
        Integer n = this.objMsgPSLanResLock;
        synchronized (n) {
            if (this.msgpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getMsgPSLanResId(), (Object)this.msgpslanres.getPSLanguageResId()) != 0L) {
                this.msgpslanres = null;
            }
            if (this.msgpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getMsgPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.msgpslanres = pSLanguageRes;
            }
            return this.msgpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysSADetail getPSSubSysSADetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysSADetail();
        }
        if (this.getPSSubSysSADetailId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysSADetailLock;
        synchronized (n) {
            if (this.pssubsyssadetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysSADetailId(), (Object)this.pssubsyssadetail.getPSSubSysSADetailId()) != 0L) {
                this.pssubsyssadetail = null;
            }
            if (this.pssubsyssadetail == null) {
                PSSubSysSADetail pSSubSysSADetail = new PSSubSysSADetail();
                pSSubSysSADetail.setPSSubSysSADetailId(this.getPSSubSysSADetailId());
                PSSubSysSADetailService pSSubSysSADetailService = (PSSubSysSADetailService)ServiceGlobal.getService(PSSubSysSADetailService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysSADetailService.autoGet((IEntity)pSSubSysSADetail);
                this.pssubsyssadetail = pSSubSysSADetail;
            }
            return this.pssubsyssadetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysServiceAPI();
        }
        if (this.getPSSubSysServiceAPIId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysServiceAPILock;
        synchronized (n) {
            if (this.pssubsysserviceapi != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysServiceAPIId(), (Object)this.pssubsysserviceapi.getPSSubSysServiceAPIId()) != 0L) {
                this.pssubsysserviceapi = null;
            }
            if (this.pssubsysserviceapi == null) {
                PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
                pSSubSysServiceAPI.setPSSubSysServiceAPIId(this.getPSSubSysServiceAPIId());
                PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysServiceAPIService.autoGet((IEntity)pSSubSysServiceAPI);
                this.pssubsysserviceapi = pSSubSysServiceAPI;
            }
            return this.pssubsysserviceapi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIChatAgent getPSSysAIChatAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIChatAgent();
        }
        if (this.getPSSysAIChatAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIChatAgentLock;
        synchronized (n) {
            if (this.pssysaichatagent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIChatAgentId(), (Object)this.pssysaichatagent.getPSSysAIChatAgentId()) != 0L) {
                this.pssysaichatagent = null;
            }
            if (this.pssysaichatagent == null) {
                PSSysAIChatAgent pSSysAIChatAgent = new PSSysAIChatAgent();
                pSSysAIChatAgent.setPSSysAIChatAgentId(this.getPSSysAIChatAgentId());
                PSSysAIChatAgentService pSSysAIChatAgentService = (PSSysAIChatAgentService)ServiceGlobal.getService(PSSysAIChatAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIChatAgentService.autoGet((IEntity)pSSysAIChatAgent);
                this.pssysaichatagent = pSSysAIChatAgent;
            }
            return this.pssysaichatagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIFactory getPSSysAIFactory() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIFactory();
        }
        if (this.getPSSysAIFactoryId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIFactoryLock;
        synchronized (n) {
            if (this.pssysaifactory != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIFactoryId(), (Object)this.pssysaifactory.getPSSysAIFactoryId()) != 0L) {
                this.pssysaifactory = null;
            }
            if (this.pssysaifactory == null) {
                PSSysAIFactory pSSysAIFactory = new PSSysAIFactory();
                pSSysAIFactory.setPSSysAIFactoryId(this.getPSSysAIFactoryId());
                PSSysAIFactoryService pSSysAIFactoryService = (PSSysAIFactoryService)ServiceGlobal.getService(PSSysAIFactoryService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIFactoryService.autoGet((IEntity)pSSysAIFactory);
                this.pssysaifactory = pSSysAIFactory;
            }
            return this.pssysaifactory;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIPipelineAgent getPSSysAIPipelineAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIPipelineAgent();
        }
        if (this.getPSSysAIPipelineAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIPipelineAgentLock;
        synchronized (n) {
            if (this.pssysaipipelineagent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIPipelineAgentId(), (Object)this.pssysaipipelineagent.getPSSysAIPipelineAgentId()) != 0L) {
                this.pssysaipipelineagent = null;
            }
            if (this.pssysaipipelineagent == null) {
                PSSysAIPipelineAgent pSSysAIPipelineAgent = new PSSysAIPipelineAgent();
                pSSysAIPipelineAgent.setPSSysAIPipelineAgentId(this.getPSSysAIPipelineAgentId());
                PSSysAIPipelineAgentService pSSysAIPipelineAgentService = (PSSysAIPipelineAgentService)ServiceGlobal.getService(PSSysAIPipelineAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIPipelineAgentService.autoGet((IEntity)pSSysAIPipelineAgent);
                this.pssysaipipelineagent = pSSysAIPipelineAgent;
            }
            return this.pssysaipipelineagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysAIWorkerAgent getPSSysAIWorkerAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAIWorkerAgent();
        }
        if (this.getPSSysAIWorkerAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysAIWorkerAgentLock;
        synchronized (n) {
            if (this.pssysaiworkeragent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAIWorkerAgentId(), (Object)this.pssysaiworkeragent.getPSSysAIWorkerAgentId()) != 0L) {
                this.pssysaiworkeragent = null;
            }
            if (this.pssysaiworkeragent == null) {
                PSSysAIWorkerAgent pSSysAIWorkerAgent = new PSSysAIWorkerAgent();
                pSSysAIWorkerAgent.setPSSysAIWorkerAgentId(this.getPSSysAIWorkerAgentId());
                PSSysAIWorkerAgentService pSSysAIWorkerAgentService = (PSSysAIWorkerAgentService)ServiceGlobal.getService(PSSysAIWorkerAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysAIWorkerAgentService.autoGet((IEntity)pSSysAIWorkerAgent);
                this.pssysaiworkeragent = pSSysAIWorkerAgent;
            }
            return this.pssysaiworkeragent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBackService getPSSysBackService() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBackService();
        }
        if (this.getPSSysBackServiceId() == null) {
            return null;
        }
        Integer n = this.objPSSysBackServiceLock;
        synchronized (n) {
            if (this.pssysbackservice != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBackServiceId(), (Object)this.pssysbackservice.getPSSysBackServiceId()) != 0L) {
                this.pssysbackservice = null;
            }
            if (this.pssysbackservice == null) {
                PSSysBackService pSSysBackService = new PSSysBackService();
                pSSysBackService.setPSSysBackServiceId(this.getPSSysBackServiceId());
                PSSysBackServiceService pSSysBackServiceService = (PSSysBackServiceService)ServiceGlobal.getService(PSSysBackServiceService.class, (SessionFactory)this.getSessionFactory());
                pSSysBackServiceService.autoGet((IEntity)pSSysBackService);
                this.pssysbackservice = pSSysBackService;
            }
            return this.pssysbackservice;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDScheme();
        }
        if (this.getPSSysBDSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDSchemeLock;
        synchronized (n) {
            if (this.pssysbdscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDSchemeId(), (Object)this.pssysbdscheme.getPSSysBDSchemeId()) != 0L) {
                this.pssysbdscheme = null;
            }
            if (this.pssysbdscheme == null) {
                PSSysBDScheme pSSysBDScheme = new PSSysBDScheme();
                pSSysBDScheme.setPSSysBDSchemeId(this.getPSSysBDSchemeId());
                PSSysBDSchemeService pSSysBDSchemeService = (PSSysBDSchemeService)ServiceGlobal.getService(PSSysBDSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDSchemeService.autoGet((IEntity)pSSysBDScheme);
                this.pssysbdscheme = pSSysBDScheme;
            }
            return this.pssysbdscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBDTable getPSSysBDTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBDTable();
        }
        if (this.getPSSysBDTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBDTableLock;
        synchronized (n) {
            if (this.pssysbdtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBDTableId(), (Object)this.pssysbdtable.getPSSysBDTableId()) != 0L) {
                this.pssysbdtable = null;
            }
            if (this.pssysbdtable == null) {
                PSSysBDTable pSSysBDTable = new PSSysBDTable();
                pSSysBDTable.setPSSysBDTableId(this.getPSSysBDTableId());
                PSSysBDTableService pSSysBDTableService = (PSSysBDTableService)ServiceGlobal.getService(PSSysBDTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBDTableService.autoGet((IEntity)pSSysBDTable);
                this.pssysbdtable = pSSysBDTable;
            }
            return this.pssysbdtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIAggTable getPSSysBIAggTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIAggTable();
        }
        if (this.getPSSysBIAggTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIAggTableLock;
        synchronized (n) {
            if (this.pssysbiaggtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIAggTableId(), (Object)this.pssysbiaggtable.getPSSysBIAggTableId()) != 0L) {
                this.pssysbiaggtable = null;
            }
            if (this.pssysbiaggtable == null) {
                PSSysBIAggTable pSSysBIAggTable = new PSSysBIAggTable();
                pSSysBIAggTable.setPSSysBIAggTableId(this.getPSSysBIAggTableId());
                PSSysBIAggTableService pSSysBIAggTableService = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIAggTableService.autoGet((IEntity)pSSysBIAggTable);
                this.pssysbiaggtable = pSSysBIAggTable;
            }
            return this.pssysbiaggtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIReport getPSSysBIReport() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReport();
        }
        if (this.getPSSysBIReportId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIReportLock;
        synchronized (n) {
            if (this.pssysbireport != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIReportId(), (Object)this.pssysbireport.getPSSysBIReportId()) != 0L) {
                this.pssysbireport = null;
            }
            if (this.pssysbireport == null) {
                PSSysBIReport pSSysBIReport = new PSSysBIReport();
                pSSysBIReport.setPSSysBIReportId(this.getPSSysBIReportId());
                PSSysBIReportService pSSysBIReportService = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIReportService.autoGet((IEntity)pSSysBIReport);
                this.pssysbireport = pSSysBIReport;
            }
            return this.pssysbireport;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIScheme getPSSysBIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIScheme();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBISchemeLock;
        synchronized (n) {
            if (this.pssysbischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBISchemeId(), (Object)this.pssysbischeme.getPSSysBISchemeId()) != 0L) {
                this.pssysbischeme = null;
            }
            if (this.pssysbischeme == null) {
                PSSysBIScheme pSSysBIScheme = new PSSysBIScheme();
                pSSysBIScheme.setPSSysBISchemeId(this.getPSSysBISchemeId());
                PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBISchemeService.autoGet((IEntity)pSSysBIScheme);
                this.pssysbischeme = pSSysBIScheme;
            }
            return this.pssysbischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDataSyncAgent getPSSysDatasyncAgent() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDatasyncAgent();
        }
        if (this.getPSSysDataSyncAgentId() == null) {
            return null;
        }
        Integer n = this.objPSSysDatasyncAgentLock;
        synchronized (n) {
            if (this.pssysdatasyncagent != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDataSyncAgentId(), (Object)this.pssysdatasyncagent.getPSSysDataSyncAgentId()) != 0L) {
                this.pssysdatasyncagent = null;
            }
            if (this.pssysdatasyncagent == null) {
                PSSysDataSyncAgent pSSysDataSyncAgent = new PSSysDataSyncAgent();
                pSSysDataSyncAgent.setPSSysDataSyncAgentId(this.getPSSysDataSyncAgentId());
                PSSysDataSyncAgentService pSSysDataSyncAgentService = (PSSysDataSyncAgentService)ServiceGlobal.getService(PSSysDataSyncAgentService.class, (SessionFactory)this.getSessionFactory());
                pSSysDataSyncAgentService.autoGet((IEntity)pSSysDataSyncAgent);
                this.pssysdatasyncagent = pSSysDataSyncAgent;
            }
            return this.pssysdatasyncagent;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBScheme();
        }
        if (this.getPSSysDBSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBSchemeLock;
        synchronized (n) {
            if (this.pssysdbscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBSchemeId(), (Object)this.pssysdbscheme.getPSSysDBSchemeId()) != 0L) {
                this.pssysdbscheme = null;
            }
            if (this.pssysdbscheme == null) {
                PSSysDBScheme pSSysDBScheme = new PSSysDBScheme();
                pSSysDBScheme.setPSSysDBSchemeId(this.getPSSysDBSchemeId());
                PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBSchemeService.autoGet((IEntity)pSSysDBScheme);
                this.pssysdbscheme = pSSysDBScheme;
            }
            return this.pssysdbscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBTable getPSSysDBTable() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBTable();
        }
        if (this.getPSSysDBTableId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBTableLock;
        synchronized (n) {
            if (this.pssysdbtable != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBTableId(), (Object)this.pssysdbtable.getPSSysDBTableId()) != 0L) {
                this.pssysdbtable = null;
            }
            if (this.pssysdbtable == null) {
                PSSysDBTable pSSysDBTable = new PSSysDBTable();
                pSSysDBTable.setPSSysDBTableId(this.getPSSysDBTableId());
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBTableService.autoGet((IEntity)pSSysDBTable);
                this.pssysdbtable = pSSysDBTable;
            }
            return this.pssysdbtable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDELogicNode getPSSysDELogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDELogicNode();
        }
        if (this.getPSSysDELogicNodeId() == null) {
            return null;
        }
        Integer n = this.objPSSysDELogicNodeLock;
        synchronized (n) {
            if (this.pssysdelogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDELogicNodeId(), (Object)this.pssysdelogicnode.getPSSysDELogicNodeId()) != 0L) {
                this.pssysdelogicnode = null;
            }
            if (this.pssysdelogicnode == null) {
                PSSysDELogicNode pSSysDELogicNode = new PSSysDELogicNode();
                pSSysDELogicNode.setPSSysDELogicNodeId(this.getPSSysDELogicNodeId());
                PSSysDELogicNodeService pSSysDELogicNodeService = (PSSysDELogicNodeService)ServiceGlobal.getService(PSSysDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSSysDELogicNodeService.autoGet((IEntity)pSSysDELogicNode);
                this.pssysdelogicnode = pSSysDELogicNode;
            }
            return this.pssysdelogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElement getPSSysEAIElement() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElement();
        }
        if (this.getPSSysEAIElementId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIElementLock;
        synchronized (n) {
            if (this.pssyseaielement != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIElementId(), (Object)this.pssyseaielement.getPSSysEAIElementId()) != 0L) {
                this.pssyseaielement = null;
            }
            if (this.pssyseaielement == null) {
                PSSysEAIElement pSSysEAIElement = new PSSysEAIElement();
                pSSysEAIElement.setPSSysEAIElementId(this.getPSSysEAIElementId());
                PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementService.autoGet((IEntity)pSSysEAIElement);
                this.pssyseaielement = pSSysEAIElement;
            }
            return this.pssyseaielement;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIScheme getPSSysEAIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIScheme();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAISchemeLock;
        synchronized (n) {
            if (this.pssyseaischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAISchemeId(), (Object)this.pssyseaischeme.getPSSysEAISchemeId()) != 0L) {
                this.pssyseaischeme = null;
            }
            if (this.pssyseaischeme == null) {
                PSSysEAIScheme pSSysEAIScheme = new PSSysEAIScheme();
                pSSysEAIScheme.setPSSysEAISchemeId(this.getPSSysEAISchemeId());
                PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAISchemeService.autoGet((IEntity)pSSysEAIScheme);
                this.pssyseaischeme = pSSysEAIScheme;
            }
            return this.pssyseaischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet((IEntity)pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchDoc getPSSysSearchDoc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchDoc();
        }
        if (this.getPSSysSearchDocId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchDocLock;
        synchronized (n) {
            if (this.pssyssearchdoc != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchDocId(), (Object)this.pssyssearchdoc.getPSSysSearchDocId()) != 0L) {
                this.pssyssearchdoc = null;
            }
            if (this.pssyssearchdoc == null) {
                PSSysSearchDoc pSSysSearchDoc = new PSSysSearchDoc();
                pSSysSearchDoc.setPSSysSearchDocId(this.getPSSysSearchDocId());
                PSSysSearchDocService pSSysSearchDocService = (PSSysSearchDocService)ServiceGlobal.getService(PSSysSearchDocService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchDocService.autoGet((IEntity)pSSysSearchDoc);
                this.pssyssearchdoc = pSSysSearchDoc;
            }
            return this.pssyssearchdoc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSearchScheme();
        }
        if (this.getPSSysSearchSchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysSearchSchemeLock;
        synchronized (n) {
            if (this.pssyssearchscheme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSearchSchemeId(), (Object)this.pssyssearchscheme.getPSSysSearchSchemeId()) != 0L) {
                this.pssyssearchscheme = null;
            }
            if (this.pssyssearchscheme == null) {
                PSSysSearchScheme pSSysSearchScheme = new PSSysSearchScheme();
                pSSysSearchScheme.setPSSysSearchSchemeId(this.getPSSysSearchSchemeId());
                PSSysSearchSchemeService pSSysSearchSchemeService = (PSSysSearchSchemeService)ServiceGlobal.getService(PSSysSearchSchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysSearchSchemeService.autoGet((IEntity)pSSysSearchScheme);
                this.pssyssearchscheme = pSSysSearchScheme;
            }
            return this.pssyssearchscheme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSQLCmd getPSSysSqlCmd() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSqlCmd();
        }
        if (this.getPSSysSQLCmdId() == null) {
            return null;
        }
        Integer n = this.objPSSysSqlCmdLock;
        synchronized (n) {
            if (this.pssyssqlcmd != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSQLCmdId(), (Object)this.pssyssqlcmd.getPSSysSQLCmdId()) != 0L) {
                this.pssyssqlcmd = null;
            }
            if (this.pssyssqlcmd == null) {
                PSSysSQLCmd pSSysSQLCmd = new PSSysSQLCmd();
                pSSysSQLCmd.setPSSysSQLCmdId(this.getPSSysSQLCmdId());
                PSSysSQLCmdService pSSysSQLCmdService = (PSSysSQLCmdService)ServiceGlobal.getService(PSSysSQLCmdService.class, (SessionFactory)this.getSessionFactory());
                pSSysSQLCmdService.autoGet((IEntity)pSSysSQLCmd);
                this.pssyssqlcmd = pSSysSQLCmd;
            }
            return this.pssyssqlcmd;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniState getPSSysUniState() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniState();
        }
        if (this.getPSSysUniStateId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniStateLock;
        synchronized (n) {
            if (this.pssysunistate != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniStateId(), (Object)this.pssysunistate.getPSSysUniStateId()) != 0L) {
                this.pssysunistate = null;
            }
            if (this.pssysunistate == null) {
                PSSysUniState pSSysUniState = new PSSysUniState();
                pSSysUniState.setPSSysUniStateId(this.getPSSysUniStateId());
                PSSysUniStateService pSSysUniStateService = (PSSysUniStateService)ServiceGlobal.getService(PSSysUniStateService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniStateService.autoGet((IEntity)pSSysUniState);
                this.pssysunistate = pSSysUniState;
            }
            return this.pssysunistate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUtilDE getPSSysUtilDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilDE();
        }
        if (this.getPSSysUtilDEId() == null) {
            return null;
        }
        Integer n = this.objPSSysUtilDELock;
        synchronized (n) {
            if (this.pssysutilde != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUtilDEId(), (Object)this.pssysutilde.getPSSysUtilDEId()) != 0L) {
                this.pssysutilde = null;
            }
            if (this.pssysutilde == null) {
                PSSysUtilDE pSSysUtilDE = new PSSysUtilDE();
                pSSysUtilDE.setPSSysUtilDEId(this.getPSSysUtilDEId());
                PSSysUtilDEService pSSysUtilDEService = (PSSysUtilDEService)ServiceGlobal.getService(PSSysUtilDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysUtilDEService.autoGet((IEntity)pSSysUtilDE);
                this.pssysutilde = pSSysUtilDE;
            }
            return this.pssysutilde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsg getPSViewMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsg();
        }
        if (this.getPSViewMsgId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgLock;
        synchronized (n) {
            if (this.psviewmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgId(), (Object)this.psviewmsg.getPSViewMsgId()) != 0L) {
                this.psviewmsg = null;
            }
            if (this.psviewmsg == null) {
                PSViewMsg pSViewMsg = new PSViewMsg();
                pSViewMsg.setPSViewMsgId(this.getPSViewMsgId());
                PSViewMsgService pSViewMsgService = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgService.autoGet((IEntity)pSViewMsg);
                this.psviewmsg = pSViewMsg;
            }
            return this.psviewmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFDE getPSWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWF();
        }
        if (this.getPSWFDEId() == null) {
            return null;
        }
        Integer n = this.objPSWFLock;
        synchronized (n) {
            if (this.pswf != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFDEId(), (Object)this.pswf.getPSWFDEId()) != 0L) {
                this.pswf = null;
            }
            if (this.pswf == null) {
                PSWFDE pSWFDE = new PSWFDE();
                pSWFDE.setPSWFDEId(this.getPSWFDEId());
                PSWFDEService pSWFDEService = (PSWFDEService)ServiceGlobal.getService(PSWFDEService.class, (SessionFactory)this.getSessionFactory());
                pSWFDEService.autoGet((IEntity)pSWFDE);
                this.pswf = pSWFDE;
            }
            return this.pswf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkflow getPSWorkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkflow();
        }
        if (this.getPSWorkflowId() == null) {
            return null;
        }
        Integer n = this.objPSWorkflowLock;
        synchronized (n) {
            if (this.psworkflow != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkflowId(), (Object)this.psworkflow.getPSWorkflowId()) != 0L) {
                this.psworkflow = null;
            }
            if (this.psworkflow == null) {
                PSWorkflow pSWorkflow = new PSWorkflow();
                pSWorkflow.setPSWorkflowId(this.getPSWorkflowId());
                PSWorkflowService pSWorkflowService = (PSWorkflowService)ServiceGlobal.getService(PSWorkflowService.class, (SessionFactory)this.getSessionFactory());
                pSWorkflowService.autoGet((IEntity)pSWorkflow);
                this.psworkflow = pSWorkflow;
            }
            return this.psworkflow;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELNParam> getPSDELNParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELNParams();
        }
        if (this.getPSDELogicNodeId() == null) {
            return null;
        }
        PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        PSDELNParamService pSDELNParamService = (PSDELNParamService)ServiceGlobal.getService(PSDELNParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELNParamsLock;
        synchronized (n) {
            if (this.psdelnparams == null) {
                this.psdelnparams = pSDELogicNodeService.isTempData((IEntity)this) ? pSDELNParamService.selectTempByPSDELogicNode(this) : pSDELNParamService.selectByPSDELogicNode(this);
            }
            return this.psdelnparams;
        }
    }

    private PSDELogicNodeBase getProxyEntity() {
        return this.proxyPSDELogicNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELogicNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELogicNodeBase) {
            this.proxyPSDELogicNodeBase = (PSDELogicNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMDSTPARAM, 3);
        fieldIndexMap.put(FIELD_CUSTOMSRCPARAM, 4);
        fieldIndexMap.put(FIELD_DEBUGMODE, 5);
        fieldIndexMap.put(FIELD_DSTPSDEUTILDEID, 6);
        fieldIndexMap.put(FIELD_DSTPSDEUTILDENAME, 7);
        fieldIndexMap.put(FIELD_DSTINDEX, 8);
        fieldIndexMap.put(FIELD_DSTPARAMACTION, 9);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONID, 10);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONNAME, 11);
        fieldIndexMap.put(FIELD_DSTPSDEDATAEXPID, 12);
        fieldIndexMap.put(FIELD_DSTPSDEDATAEXPNAME, 13);
        fieldIndexMap.put(FIELD_DSTPSDEDATAFLOWID, 14);
        fieldIndexMap.put(FIELD_DSTPSDEDATAFLOWNAME, 15);
        fieldIndexMap.put(FIELD_DSTPSDEDATAIMPID, 16);
        fieldIndexMap.put(FIELD_DSTPSDEDATAIMPNAME, 17);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYID, 18);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYNAME, 19);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETID, 20);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETNAME, 21);
        fieldIndexMap.put(FIELD_DSTPSDEDATASYNCID, 22);
        fieldIndexMap.put(FIELD_DSTPSDEDATASYNCNAME, 23);
        fieldIndexMap.put(FIELD_DSTPSDEDTSQUEUEID, 24);
        fieldIndexMap.put(FIELD_DSTPSDEDTSQUEUENAME, 25);
        fieldIndexMap.put(FIELD_DSTPSDEFGROUPID, 26);
        fieldIndexMap.put(FIELD_DSTPSDEFGROUPNAME, 27);
        fieldIndexMap.put(FIELD_DSTPSDEFORMID, 28);
        fieldIndexMap.put(FIELD_DSTPSDEFORMNAME, 29);
        fieldIndexMap.put(FIELD_DSTPSDEFVALUERULEID, 30);
        fieldIndexMap.put(FIELD_DSTPSDEFVALUERULENAME, 31);
        fieldIndexMap.put(FIELD_DSTPSDEID, 32);
        fieldIndexMap.put(FIELD_DSTPSDELOGICID, 33);
        fieldIndexMap.put(FIELD_DSTPSDELOGICNAME, 34);
        fieldIndexMap.put(FIELD_DSTPSDEMAPID, 35);
        fieldIndexMap.put(FIELD_DSTPSDEMAPNAME, 36);
        fieldIndexMap.put(FIELD_DSTPSDENAME, 37);
        fieldIndexMap.put(FIELD_DSTPSDENOTIFYID, 38);
        fieldIndexMap.put(FIELD_DSTPSDENOTIFYNAME, 39);
        fieldIndexMap.put(FIELD_DSTPSDEPRINTID, 40);
        fieldIndexMap.put(FIELD_DSTPSDEPRINTNAME, 41);
        fieldIndexMap.put(FIELD_DSTPSDEREPORTID, 42);
        fieldIndexMap.put(FIELD_DSTPSDEREPORTNAME, 43);
        fieldIndexMap.put(FIELD_DSTPSDESAMPLEDATAID, 44);
        fieldIndexMap.put(FIELD_DSTPSDESAMPLEDATANAME, 45);
        fieldIndexMap.put(FIELD_DSTPSDEUAGROUPID, 46);
        fieldIndexMap.put(FIELD_DSTPSDEUAGROUPNAME, 47);
        fieldIndexMap.put(FIELD_DSTPSDEUILOGICID, 48);
        fieldIndexMap.put(FIELD_DSTPSDEUILOGICNAME, 49);
        fieldIndexMap.put(FIELD_DSTPSDEVIEWID, 50);
        fieldIndexMap.put(FIELD_DSTPSDEVIEWNAME, 51);
        fieldIndexMap.put(FIELD_DSTPSDEVRGROUPID, 52);
        fieldIndexMap.put(FIELD_DSTPSDEVRGROUPNAME, 53);
        fieldIndexMap.put(FIELD_DSTPSDEWIZARDID, 54);
        fieldIndexMap.put(FIELD_DSTPSDEWIZARDNAME, 55);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMID, 56);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMNAME, 57);
        fieldIndexMap.put(FIELD_DSTSORTDIR, 58);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 59);
        fieldIndexMap.put(FIELD_ISPSDLPARAMID, 60);
        fieldIndexMap.put(FIELD_ISPSDLPARAMNAME, 61);
        fieldIndexMap.put(FIELD_LEFTPOS, 62);
        fieldIndexMap.put(FIELD_LOGICNODESUBTYPE, 63);
        fieldIndexMap.put(FIELD_LOGICNODETYPE, 64);
        fieldIndexMap.put(FIELD_MEMO, 65);
        fieldIndexMap.put(FIELD_MSGPSLANRESID, 66);
        fieldIndexMap.put(FIELD_MSGPSLANRESNAME, 67);
        fieldIndexMap.put(FIELD_NODEPARAMS, 68);
        fieldIndexMap.put(FIELD_OPTPSDLPARAMID, 69);
        fieldIndexMap.put(FIELD_OPTPSDLPARAMNAME, 70);
        fieldIndexMap.put(FIELD_ORDERVALUE, 71);
        fieldIndexMap.put(FIELD_OSPSDLPARAMID, 72);
        fieldIndexMap.put(FIELD_OSPSDLPARAMNAME, 73);
        fieldIndexMap.put(FIELD_PARALLELOUTPUT, 74);
        fieldIndexMap.put(FIELD_PARAM1, 75);
        fieldIndexMap.put(FIELD_PARAM10, 76);
        fieldIndexMap.put(FIELD_PARAM11, 77);
        fieldIndexMap.put(FIELD_PARAM12, 78);
        fieldIndexMap.put(FIELD_PARAM13, 79);
        fieldIndexMap.put(FIELD_PARAM14, 80);
        fieldIndexMap.put(FIELD_PARAM2, 81);
        fieldIndexMap.put(FIELD_PARAM3, 82);
        fieldIndexMap.put(FIELD_PARAM4, 83);
        fieldIndexMap.put(FIELD_PARAM5, 84);
        fieldIndexMap.put(FIELD_PARAM6, 85);
        fieldIndexMap.put(FIELD_PARAM7, 86);
        fieldIndexMap.put(FIELD_PARAM8, 87);
        fieldIndexMap.put(FIELD_PARAM9, 88);
        fieldIndexMap.put(FIELD_PSDEID, 89);
        fieldIndexMap.put(FIELD_PSDELOGICID, 90);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 91);
        fieldIndexMap.put(FIELD_PSDELOGICNODEID, 92);
        fieldIndexMap.put(FIELD_PSDELOGICNODENAME, 93);
        fieldIndexMap.put(FIELD_PSDEMAINSTATEID, 94);
        fieldIndexMap.put(FIELD_PSDEMAINSTATENAME, 95);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 96);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 97);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 98);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILID, 99);
        fieldIndexMap.put(FIELD_PSSUBSYSSADETAILNAME, 100);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPIID, 101);
        fieldIndexMap.put(FIELD_PSSUBSYSSERVICEAPINAME, 102);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTID, 103);
        fieldIndexMap.put(FIELD_PSSYSAICHATAGENTNAME, 104);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYID, 105);
        fieldIndexMap.put(FIELD_PSSYSAIFACTORYNAME, 106);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTID, 107);
        fieldIndexMap.put(FIELD_PSSYSAIPIPELINEAGENTNAME, 108);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTID, 109);
        fieldIndexMap.put(FIELD_PSSYSAIWORKERAGENTNAME, 110);
        fieldIndexMap.put(FIELD_PSSYSBACKSERVICEID, 111);
        fieldIndexMap.put(FIELD_PSSYSBACKSERVICENAME, 112);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMEID, 113);
        fieldIndexMap.put(FIELD_PSSYSBDSCHEMENAME, 114);
        fieldIndexMap.put(FIELD_PSSYSBDTABLEID, 115);
        fieldIndexMap.put(FIELD_PSSYSBDTABLENAME, 116);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLEID, 117);
        fieldIndexMap.put(FIELD_PSSYSBIAGGTABLENAME, 118);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 119);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 120);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTID, 121);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTNAME, 122);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 123);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 124);
        fieldIndexMap.put(FIELD_PSSYSDATASYNCAGENTID, 125);
        fieldIndexMap.put(FIELD_PSSYSDATASYNCAGENTNAME, 126);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMEID, 127);
        fieldIndexMap.put(FIELD_PSSYSDBSCHEMENAME, 128);
        fieldIndexMap.put(FIELD_PSSYSDBTABLEID, 129);
        fieldIndexMap.put(FIELD_PSSYSDBTABLENAME, 130);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODEID, 131);
        fieldIndexMap.put(FIELD_PSSYSDELOGICNODENAME, 132);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 133);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTNAME, 134);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 135);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 136);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 137);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 138);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 139);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 140);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 141);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 142);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCID, 143);
        fieldIndexMap.put(FIELD_PSSYSSEARCHDOCNAME, 144);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMEID, 145);
        fieldIndexMap.put(FIELD_PSSYSSEARCHSCHEMENAME, 146);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 147);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 148);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDID, 149);
        fieldIndexMap.put(FIELD_PSSYSSQLCMDNAME, 150);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 151);
        fieldIndexMap.put(FIELD_PSSYSUNISTATEID, 152);
        fieldIndexMap.put(FIELD_PSSYSUNISTATENAME, 153);
        fieldIndexMap.put(FIELD_PSSYSUTILDEID, 154);
        fieldIndexMap.put(FIELD_PSSYSUTILDENAME, 155);
        fieldIndexMap.put(FIELD_PSVIEWMSGID, 156);
        fieldIndexMap.put(FIELD_PSVIEWMSGNAME, 157);
        fieldIndexMap.put(FIELD_PSWFDEID, 158);
        fieldIndexMap.put(FIELD_PSWFDENAME, 159);
        fieldIndexMap.put(FIELD_PSWORKFLOWID, 160);
        fieldIndexMap.put(FIELD_PSWORKFLOWNAME, 161);
        fieldIndexMap.put(FIELD_RETPSDLPARAMID, 162);
        fieldIndexMap.put(FIELD_RETPSDLPARAMNAME, 163);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 164);
        fieldIndexMap.put(FIELD_SRCINDEX, 165);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMID, 166);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMNAME, 167);
        fieldIndexMap.put(FIELD_SRCSIZE, 168);
        fieldIndexMap.put(FIELD_THREADRUNMODE, 169);
        fieldIndexMap.put(FIELD_THREADRUNTIMER, 170);
        fieldIndexMap.put(FIELD_TOPPOS, 171);
        fieldIndexMap.put(FIELD_TSMODE, 172);
        fieldIndexMap.put(FIELD_UPDATEDATE, 173);
        fieldIndexMap.put(FIELD_UPDATEMAN, 174);
        fieldIndexMap.put(FIELD_USERCAT, 175);
        fieldIndexMap.put(FIELD_USERPARAMS, 176);
        fieldIndexMap.put(FIELD_USERTAG, 177);
        fieldIndexMap.put(FIELD_USERTAG2, 178);
        fieldIndexMap.put(FIELD_USERTAG3, 179);
        fieldIndexMap.put(FIELD_USERTAG4, 180);
    }
}

