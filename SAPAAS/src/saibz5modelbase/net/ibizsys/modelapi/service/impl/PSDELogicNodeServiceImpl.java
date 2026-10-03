/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDELNParam;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicNode;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDTSQueueDTO;
import net.ibizsys.modelapi.dto.PSDEDataExpDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEDataSyncDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDELNParamDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSDELogicParamDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.dto.PSDENotifyDTO;
import net.ibizsys.modelapi.dto.PSDEPrintDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEVRGroupDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.dto.PSSysBISchemeDTO;
import net.ibizsys.modelapi.dto.PSSysBackServiceDTO;
import net.ibizsys.modelapi.dto.PSSysDBSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysDBTableDTO;
import net.ibizsys.modelapi.dto.PSSysDELogicNodeDTO;
import net.ibizsys.modelapi.dto.PSSysDataSyncAgentDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementDTO;
import net.ibizsys.modelapi.dto.PSSysEAISchemeDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysUniStateDTO;
import net.ibizsys.modelapi.dto.PSSysUtilDEDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSDELogicNodeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDELogicNodeServiceImpl
extends PSModelServiceImplBase<PSDELogicNode, PSDELogicNodeDTO>
implements IPSDELogicNodeService {
    private static final Log log = LogFactory.getLog(PSDELogicNodeServiceImpl.class);

    @Override
    public List<PSDELogicNode> listByPSDELogic(PSDELogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDELogicNode get(PSDELogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDELogicNode> list = this.listByPSDELogic(parent);
        if (list != null) {
            for (PSDELogicNode item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSDELogicNodeDTO> listDTOByPSDELogic(String strParentKey) throws Exception {
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey);
        List<PSDELogicNode> list = this.listByPSDELogic(psdelogic);
        if (list != null) {
            ArrayList<PSDELogicNodeDTO> dtoList = new ArrayList<PSDELogicNodeDTO>();
            for (PSDELogicNode item : list) {
                PSDELogicNodeDTO dto = (PSDELogicNodeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDELogicNode> onListAll() throws Exception {
        ArrayList<PSDELogicNode> list = new ArrayList<PSDELogicNode>();
        List<PSDELogic> psdelogics = PSModelServiceUtil.getInstance().getPSDELogicService().listAll();
        if (psdelogics != null) {
            for (PSDELogic parent : psdelogics) {
                List<PSDELogicNode> items = this.listByPSDELogic(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSDELogicNode onGet(String strParentKey, String strCurKey) throws Exception {
        PSDELogicNode item;
        PSDELogic psdelogic = (PSDELogic)PSModelServiceUtil.getInstance().getPSDELogicService().get(strParentKey, true);
        if (psdelogic != null && (item = this.get(psdelogic, strCurKey, true)) != null) {
            return item;
        }
        return (PSDELogicNode)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDELogicNodeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDELogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDELogicService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDELogicNode et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDELogicNodeDTO dto, PSDELogicNode t, boolean bIgnoreNull) throws Exception {
        List<PSDELNParam> list;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDELogicNodeId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDSTParam() != null || !bIgnoreNull) {
            dto.setCustomDSTParam(t.getCustomDSTParam());
        }
        if (t.getCustomSrcParam() != null || !bIgnoreNull) {
            dto.setCustomSrcParam(t.getCustomSrcParam());
        }
        if (t.getDebugMode() != null || !bIgnoreNull) {
            dto.setDebugMode(t.getDebugMode());
        }
        if (t.getDstIndex() != null || !bIgnoreNull) {
            dto.setDstIndex(t.getDstIndex());
        }
        if (t.getDstParamAction() != null || !bIgnoreNull) {
            dto.setDstParamAction(t.getDstParamAction());
        }
        if (t.getDstPSDEActionId() != null || !bIgnoreNull) {
            dto.setDstPSDEActionId(t.getDstPSDEActionId());
        }
        if (t.getDstPSDEActionName() != null || !bIgnoreNull) {
            dto.setDstPSDEActionName(t.getDstPSDEActionName());
        }
        if (t.getDstPSDEDataExpId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataExpId(t.getDstPSDEDataExpId());
        }
        if (t.getDstPSDEDataExpName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataExpName(t.getDstPSDEDataExpName());
        }
        if (t.getDstPSDEDataImpId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataImpId(t.getDstPSDEDataImpId());
        }
        if (t.getDstPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataImpName(t.getDstPSDEDataImpName());
        }
        if (t.getDstPSDEDataQueryId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryId(t.getDstPSDEDataQueryId());
        }
        if (t.getDstPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryName(t.getDstPSDEDataQueryName());
        }
        if (t.getDstPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSetId(t.getDstPSDEDataSetId());
        }
        if (t.getDstPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSetName(t.getDstPSDEDataSetName());
        }
        if (t.getDstPSDEDataSyncId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSyncId(t.getDstPSDEDataSyncId());
        }
        if (t.getDstPSDEDataSyncName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataSyncName(t.getDstPSDEDataSyncName());
        }
        if (t.getDstPSDEDTSQueueId() != null || !bIgnoreNull) {
            dto.setDstPSDEDTSQueueId(t.getDstPSDEDTSQueueId());
        }
        if (t.getDstPSDEDTSQueueName() != null || !bIgnoreNull) {
            dto.setDstPSDEDTSQueueName(t.getDstPSDEDTSQueueName());
        }
        if (t.getDstPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setDstPSDEFValueRuleId(t.getDstPSDEFValueRuleId());
        }
        if (t.getDstPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setDstPSDEFValueRuleName(t.getDstPSDEFValueRuleName());
        }
        if (t.getDstPSDEId() != null || !bIgnoreNull) {
            dto.setDstPSDEId(t.getDstPSDEId());
        }
        if (t.getDstPSDELogicId() != null || !bIgnoreNull) {
            dto.setDstPSDELogicId(t.getDstPSDELogicId());
        }
        if (t.getDstPSDELogicName() != null || !bIgnoreNull) {
            dto.setDstPSDELogicName(t.getDstPSDELogicName());
        }
        if (t.getDstPSDEMapId() != null || !bIgnoreNull) {
            dto.setDstPSDEMapId(t.getDstPSDEMapId());
        }
        if (t.getDstPSDEMapName() != null || !bIgnoreNull) {
            dto.setDstPSDEMapName(t.getDstPSDEMapName());
        }
        if (t.getDstPSDEName() != null || !bIgnoreNull) {
            dto.setDstPSDEName(t.getDstPSDEName());
        }
        if (t.getDstPSDENotifyId() != null || !bIgnoreNull) {
            dto.setDstPSDENotifyId(t.getDstPSDENotifyId());
        }
        if (t.getDstPSDENotifyName() != null || !bIgnoreNull) {
            dto.setDstPSDENotifyName(t.getDstPSDENotifyName());
        }
        if (t.getDstPSDEPrintId() != null || !bIgnoreNull) {
            dto.setDstPSDEPrintId(t.getDstPSDEPrintId());
        }
        if (t.getDstPSDEPrintName() != null || !bIgnoreNull) {
            dto.setDstPSDEPrintName(t.getDstPSDEPrintName());
        }
        if (t.getDstPSDEReportId() != null || !bIgnoreNull) {
            dto.setDstPSDEReportId(t.getDstPSDEReportId());
        }
        if (t.getDstPSDEReportName() != null || !bIgnoreNull) {
            dto.setDstPSDEReportName(t.getDstPSDEReportName());
        }
        if (t.getDstPSDEVRGroupId() != null || !bIgnoreNull) {
            dto.setDstPSDEVRGroupId(t.getDstPSDEVRGroupId());
        }
        if (t.getDstPSDEVRGroupName() != null || !bIgnoreNull) {
            dto.setDstPSDEVRGroupName(t.getDstPSDEVRGroupName());
        }
        if (t.getDstPSDLParamId() != null || !bIgnoreNull) {
            dto.setDstPSDLParamId(t.getDstPSDLParamId());
        }
        if (t.getDstPSDLParamName() != null || !bIgnoreNull) {
            dto.setDstPSDLParamName(t.getDstPSDLParamName());
        }
        if (t.getDstSortDir() != null || !bIgnoreNull) {
            dto.setDstSortDir(t.getDstSortDir());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getISPSDLParamId() != null || !bIgnoreNull) {
            dto.setISPSDLParamId(t.getISPSDLParamId());
        }
        if (t.getISPSDLParamName() != null || !bIgnoreNull) {
            dto.setISPSDLParamName(t.getISPSDLParamName());
        }
        if (t.getLeftPos() != null || !bIgnoreNull) {
            dto.setLeftPos(t.getLeftPos());
        }
        if (t.getLogicNodeSubType() != null || !bIgnoreNull) {
            dto.setLogicNodeSubType(t.getLogicNodeSubType());
        }
        if (t.getLogicNodeType() != null || !bIgnoreNull) {
            dto.setLogicNodeType(t.getLogicNodeType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMsgPSLanResId() != null || !bIgnoreNull) {
            dto.setMsgPSLanResId(t.getMsgPSLanResId());
        }
        if (t.getMsgPSLanResName() != null || !bIgnoreNull) {
            dto.setMsgPSLanResName(t.getMsgPSLanResName());
        }
        if (t.getNodeParams() != null || !bIgnoreNull) {
            dto.setNodeParams(t.getNodeParams());
        }
        if (t.getOSPSDLParamId() != null || !bIgnoreNull) {
            dto.setOSPSDLParamId(t.getOSPSDLParamId());
        }
        if (t.getOSPSDLParamName() != null || !bIgnoreNull) {
            dto.setOSPSDLParamName(t.getOSPSDLParamName());
        }
        if (t.getParallelOutput() != null || !bIgnoreNull) {
            dto.setParallelOutput(t.getParallelOutput());
        }
        if (t.getParam1() != null || !bIgnoreNull) {
            dto.setParam1(t.getParam1());
        }
        if (t.getParam10() != null || !bIgnoreNull) {
            dto.setParam10(t.getParam10());
        }
        if (t.getParam11() != null || !bIgnoreNull) {
            dto.setParam11(t.getParam11());
        }
        if (t.getParam12() != null || !bIgnoreNull) {
            dto.setParam12(t.getParam12());
        }
        if (t.getParam13() != null || !bIgnoreNull) {
            dto.setParam13(t.getParam13());
        }
        if (t.getParam14() != null || !bIgnoreNull) {
            dto.setParam14(t.getParam14());
        }
        if (t.getParam2() != null || !bIgnoreNull) {
            dto.setParam2(t.getParam2());
        }
        if (t.getParam3() != null || !bIgnoreNull) {
            dto.setParam3(t.getParam3());
        }
        if (t.getParam4() != null || !bIgnoreNull) {
            dto.setParam4(t.getParam4());
        }
        if (t.getParam5() != null || !bIgnoreNull) {
            dto.setParam5(t.getParam5());
        }
        if (t.getParam6() != null || !bIgnoreNull) {
            dto.setParam6(t.getParam6());
        }
        if (t.getParam7() != null || !bIgnoreNull) {
            dto.setParam7(t.getParam7());
        }
        if (t.getParam8() != null || !bIgnoreNull) {
            dto.setParam8(t.getParam8());
        }
        if (t.getParam9() != null || !bIgnoreNull) {
            dto.setParam9(t.getParam9());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDELogicNodeName() != null || !bIgnoreNull) {
            dto.setPSDELogicNodeName(t.getPSDELogicNodeName());
        }
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSubSysSADetailId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailId(t.getPSSubSysSADetailId());
        }
        if (t.getPSSubSysSADetailName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailName(t.getPSSubSysSADetailName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getPSSysBackServiceId() != null || !bIgnoreNull) {
            dto.setPSSysBackServiceId(t.getPSSysBackServiceId());
        }
        if (t.getPSSysBackServiceName() != null || !bIgnoreNull) {
            dto.setPSSysBackServiceName(t.getPSSysBackServiceName());
        }
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
        }
        if (t.getPSSysBDSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeName(t.getPSSysBDSchemeName());
        }
        if (t.getPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setPSSysBDTableId(t.getPSSysBDTableId());
        }
        if (t.getPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableName(t.getPSSysBDTableName());
        }
        if (t.getPSSysBIReportId() != null || !bIgnoreNull) {
            dto.setPSSysBIReportId(t.getPSSysBIReportId());
        }
        if (t.getPSSysBIReportName() != null || !bIgnoreNull) {
            dto.setPSSysBIReportName(t.getPSSysBIReportName());
        }
        if (t.getPSSysBISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeId(t.getPSSysBISchemeId());
        }
        if (t.getPSSysBISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeName(t.getPSSysBISchemeName());
        }
        if (t.getPSSysDataSyncAgentId() != null || !bIgnoreNull) {
            dto.setPSSysDataSyncAgentId(t.getPSSysDataSyncAgentId());
        }
        if (t.getPSSysDataSyncAgentName() != null || !bIgnoreNull) {
            dto.setPSSysDataSyncAgentName(t.getPSSysDataSyncAgentName());
        }
        if (t.getPSSysDBSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeId(t.getPSSysDBSchemeId());
        }
        if (t.getPSSysDBSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysDBSchemeName(t.getPSSysDBSchemeName());
        }
        if (t.getPSSysDBTableId() != null || !bIgnoreNull) {
            dto.setPSSysDBTableId(t.getPSSysDBTableId());
        }
        if (t.getPSSysDBTableName() != null || !bIgnoreNull) {
            dto.setPSSysDBTableName(t.getPSSysDBTableName());
        }
        if (t.getPSSysDELogicNodeId() != null || !bIgnoreNull) {
            dto.setPSSysDELogicNodeId(t.getPSSysDELogicNodeId());
        }
        if (t.getPSSysDELogicNodeName() != null || !bIgnoreNull) {
            dto.setPSSysDELogicNodeName(t.getPSSysDELogicNodeName());
        }
        if (t.getPSSysEAIElementId() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementId(t.getPSSysEAIElementId());
        }
        if (t.getPSSysEAIElementName() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementName(t.getPSSysEAIElementName());
        }
        if (t.getPSSysEAISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeId(t.getPSSysEAISchemeId());
        }
        if (t.getPSSysEAISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeName(t.getPSSysEAISchemeName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysSearchDocId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocId(t.getPSSysSearchDocId());
        }
        if (t.getPSSysSearchDocName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocName(t.getPSSysSearchDocName());
        }
        if (t.getPSSysSearchSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeId(t.getPSSysSearchSchemeId());
        }
        if (t.getPSSysSearchSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysSearchSchemeName(t.getPSSysSearchSchemeName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSysSQLCmdId() != null || !bIgnoreNull) {
            dto.setPSSysSQLCmdId(t.getPSSysSQLCmdId());
        }
        if (t.getPSSysSQLCmdName() != null || !bIgnoreNull) {
            dto.setPSSysSQLCmdName(t.getPSSysSQLCmdName());
        }
        if (t.getPSSysUniStateId() != null || !bIgnoreNull) {
            dto.setPSSysUniStateId(t.getPSSysUniStateId());
        }
        if (t.getPSSysUniStateName() != null || !bIgnoreNull) {
            dto.setPSSysUniStateName(t.getPSSysUniStateName());
        }
        if (t.getPSSysUtilDEId() != null || !bIgnoreNull) {
            dto.setPSSysUtilDEId(t.getPSSysUtilDEId());
        }
        if (t.getPSSysUtilDEName() != null || !bIgnoreNull) {
            dto.setPSSysUtilDEName(t.getPSSysUtilDEName());
        }
        if (t.getPSWFDEId() != null || !bIgnoreNull) {
            dto.setPSWFDEId(t.getPSWFDEId());
        }
        if (t.getPSWFDEName() != null || !bIgnoreNull) {
            dto.setPSWFDEName(t.getPSWFDEName());
        }
        if (t.getPSWorkflowId() != null || !bIgnoreNull) {
            dto.setPSWorkflowId(t.getPSWorkflowId());
        }
        if (t.getPSWorkflowName() != null || !bIgnoreNull) {
            dto.setPSWorkflowName(t.getPSWorkflowName());
        }
        if (t.getRetPSDLParamId() != null || !bIgnoreNull) {
            dto.setRetPSDLParamId(t.getRetPSDLParamId());
        }
        if (t.getRetPSDLParamName() != null || !bIgnoreNull) {
            dto.setRetPSDLParamName(t.getRetPSDLParamName());
        }
        if (t.getShapeParams() != null || !bIgnoreNull) {
            dto.setShapeParams(t.getShapeParams());
        }
        if (t.getSrcIndex() != null || !bIgnoreNull) {
            dto.setSrcIndex(t.getSrcIndex());
        }
        if (t.getSrcPSDLParamId() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamId(t.getSrcPSDLParamId());
        }
        if (t.getSrcPSDLParamName() != null || !bIgnoreNull) {
            dto.setSrcPSDLParamName(t.getSrcPSDLParamName());
        }
        if (t.getSrcSize() != null || !bIgnoreNull) {
            dto.setSrcSize(t.getSrcSize());
        }
        if (t.getThreadRunMode() != null || !bIgnoreNull) {
            dto.setThreadRunMode(t.getThreadRunMode());
        }
        if (t.getThreadRunTimer() != null || !bIgnoreNull) {
            dto.setThreadRunTimer(t.getThreadRunTimer());
        }
        if (t.getTopPos() != null || !bIgnoreNull) {
            dto.setTopPos(t.getTopPos());
        }
        if (t.getTSMode() != null || !bIgnoreNull) {
            dto.setTSMode(t.getTSMode());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            dto.setDstPSDEActionId(this.getRealPSModelId(t, dto.getDstPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataExpId())) {
            dto.setDstPSDEDataExpId(this.getRealPSModelId(t, dto.getDstPSDEDataExpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataImpId())) {
            dto.setDstPSDEDataImpId(this.getRealPSModelId(t, dto.getDstPSDEDataImpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            dto.setDstPSDEDataQueryId(this.getRealPSModelId(t, dto.getDstPSDEDataQueryId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSetId())) {
            dto.setDstPSDEDataSetId(this.getRealPSModelId(t, dto.getDstPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSyncId())) {
            dto.setDstPSDEDataSyncId(this.getRealPSModelId(t, dto.getDstPSDEDataSyncId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDTSQueueId())) {
            dto.setDstPSDEDTSQueueId(this.getRealPSModelId(t, dto.getDstPSDEDTSQueueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFValueRuleId())) {
            dto.setDstPSDEFValueRuleId(this.getRealPSModelId(t, dto.getDstPSDEFValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            dto.setDstPSDEId(this.getRealPSModelId(t, dto.getDstPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDELogicId())) {
            dto.setDstPSDELogicId(this.getRealPSModelId(t, dto.getDstPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEMapId())) {
            dto.setDstPSDEMapId(this.getRealPSModelId(t, dto.getDstPSDEMapId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDENotifyId())) {
            dto.setDstPSDENotifyId(this.getRealPSModelId(t, dto.getDstPSDENotifyId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEPrintId())) {
            dto.setDstPSDEPrintId(this.getRealPSModelId(t, dto.getDstPSDEPrintId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEReportId())) {
            dto.setDstPSDEReportId(this.getRealPSModelId(t, dto.getDstPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEVRGroupId())) {
            dto.setDstPSDEVRGroupId(this.getRealPSModelId(t, dto.getDstPSDEVRGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            dto.setDstPSDLParamId(this.getRealPSModelId(t, dto.getDstPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getISPSDLParamId())) {
            dto.setISPSDLParamId(this.getRealPSModelId(t, dto.getISPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMsgPSLanResId())) {
            dto.setMsgPSLanResId(this.getRealPSModelId(t, dto.getMsgPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOSPSDLParamId())) {
            dto.setOSPSDLParamId(this.getRealPSModelId(t, dto.getOSPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if ("PSDELOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDELogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            dto.setPSSubSysSADetailId(this.getRealPSModelId(t, dto.getPSSubSysSADetailId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBackServiceId())) {
            dto.setPSSysBackServiceId(this.getRealPSModelId(t, dto.getPSSysBackServiceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            dto.setPSSysBDTableId(this.getRealPSModelId(t, dto.getPSSysBDTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            dto.setPSSysBISchemeId(this.getRealPSModelId(t, dto.getPSSysBISchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDataSyncAgentId())) {
            dto.setPSSysDataSyncAgentId(this.getRealPSModelId(t, dto.getPSSysDataSyncAgentId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            dto.setPSSysDBSchemeId(this.getRealPSModelId(t, dto.getPSSysDBSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            dto.setPSSysDBTableId(this.getRealPSModelId(t, dto.getPSSysDBTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDELogicNodeId())) {
            dto.setPSSysDELogicNodeId(this.getRealPSModelId(t, dto.getPSSysDELogicNodeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            dto.setPSSysEAIElementId(this.getRealPSModelId(t, dto.getPSSysEAIElementId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            dto.setPSSysEAISchemeId(this.getRealPSModelId(t, dto.getPSSysEAISchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            dto.setPSSysSearchDocId(this.getRealPSModelId(t, dto.getPSSysSearchDocId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            dto.setPSSysSearchSchemeId(this.getRealPSModelId(t, dto.getPSSysSearchSchemeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniStateId())) {
            dto.setPSSysUniStateId(this.getRealPSModelId(t, dto.getPSSysUniStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUtilDEId())) {
            dto.setPSSysUtilDEId(this.getRealPSModelId(t, dto.getPSSysUtilDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            dto.setPSWFDEId(this.getRealPSModelId(t, dto.getPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            dto.setPSWorkflowId(this.getRealPSModelId(t, dto.getPSWorkflowId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRetPSDLParamId())) {
            dto.setRetPSDLParamId(this.getRealPSModelId(t, dto.getRetPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            dto.setSrcPSDLParamId(this.getRealPSModelId(t, dto.getSrcPSDLParamId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getDstPSDEActionId());
            dto.setDstPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setDstPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataExpId())) {
            linkDTO = (PSDEDataExpDTO)PSModelServiceUtil.getInstance().getPSDEDataExpService().getDTO(dto.getDstPSDEDataExpId());
            dto.setDstPSDEDataExpName(((PSDEDataExpDTO)linkDTO).getPSDEDataExpName());
        } else {
            dto.setDstPSDEDataExpName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataImpId())) {
            linkDTO = (PSDEDataImpDTO)PSModelServiceUtil.getInstance().getPSDEDataImpService().getDTO(dto.getDstPSDEDataImpId());
            dto.setDstPSDEDataImpName(((PSDEDataImpDTO)linkDTO).getPSDEDataImpName());
        } else {
            dto.setDstPSDEDataImpName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getDstPSDEDataQueryId());
            dto.setDstPSDEDataQueryName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setDstPSDEDataQueryName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getDstPSDEDataSetId());
            dto.setDstPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setDstPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataSyncId())) {
            linkDTO = (PSDEDataSyncDTO)PSModelServiceUtil.getInstance().getPSDEDataSyncService().getDTO(dto.getDstPSDEDataSyncId());
            dto.setDstPSDEDataSyncName(((PSDEDataSyncDTO)linkDTO).getPSDEDataSyncName());
        } else {
            dto.setDstPSDEDataSyncName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDTSQueueId())) {
            linkDTO = (PSDEDTSQueueDTO)PSModelServiceUtil.getInstance().getPSDEDTSQueueService().getDTO(dto.getDstPSDEDTSQueueId());
            dto.setDstPSDEDTSQueueName(((PSDEDTSQueueDTO)linkDTO).getPSDEDTSQueueName());
        } else {
            dto.setDstPSDEDTSQueueName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getDstPSDEFValueRuleId());
            dto.setDstPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setDstPSDEFValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getDstPSDEId());
            dto.setDstPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDstPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getDstPSDELogicId());
            dto.setDstPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setDstPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEMapId())) {
            linkDTO = (PSDEMapDTO)PSModelServiceUtil.getInstance().getPSDEMapService().getDTO(dto.getDstPSDEMapId());
            dto.setDstPSDEMapName(((PSDEMapDTO)linkDTO).getPSDEMapName());
        } else {
            dto.setDstPSDEMapName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDENotifyId())) {
            linkDTO = (PSDENotifyDTO)PSModelServiceUtil.getInstance().getPSDENotifyService().getDTO(dto.getDstPSDENotifyId());
            dto.setDstPSDENotifyName(((PSDENotifyDTO)linkDTO).getPSDENotifyName());
        } else {
            dto.setDstPSDENotifyName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEPrintId())) {
            linkDTO = (PSDEPrintDTO)PSModelServiceUtil.getInstance().getPSDEPrintService().getDTO(dto.getDstPSDEPrintId());
            dto.setDstPSDEPrintName(((PSDEPrintDTO)linkDTO).getPSDEPrintName());
        } else {
            dto.setDstPSDEPrintName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getDstPSDEReportId());
            dto.setDstPSDEReportName(((PSDEReportDTO)linkDTO).getPSDEReportName());
        } else {
            dto.setDstPSDEReportName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEVRGroupId())) {
            linkDTO = (PSDEVRGroupDTO)PSModelServiceUtil.getInstance().getPSDEVRGroupService().getDTO(dto.getDstPSDEVRGroupId());
            dto.setDstPSDEVRGroupName(((PSDEVRGroupDTO)linkDTO).getPSDEVRGroupName());
        } else {
            dto.setDstPSDEVRGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getDstPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setDstPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setDstPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getISPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getISPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setISPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setISPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getMsgPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getMsgPSLanResId());
            dto.setMsgPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setMsgPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getOSPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getOSPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setOSPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setOSPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId(), true);
            if (linkDTO != null) {
                dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
            }
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEMainStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            linkDTO = (PSSubSysSADetailDTO)PSModelServiceUtil.getInstance().getPSSubSysSADetailService().getDTO(dto.getPSSubSysSADetailId());
            dto.setPSSubSysSADetailName(((PSSubSysSADetailDTO)linkDTO).getPSSubSysSADetailName());
        } else {
            dto.setPSSubSysSADetailName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBackServiceId())) {
            linkDTO = (PSSysBackServiceDTO)PSModelServiceUtil.getInstance().getPSSysBackServiceService().getDTO(dto.getPSSysBackServiceId());
            dto.setPSSysBackServiceName(((PSSysBackServiceDTO)linkDTO).getPSSysBackServiceName());
        } else {
            dto.setPSSysBackServiceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            linkDTO = (PSSysBDSchemeDTO)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().getDTO(dto.getPSSysBDSchemeId());
            dto.setPSSysBDSchemeName(((PSSysBDSchemeDTO)linkDTO).getPSSysBDSchemeName());
        } else {
            dto.setPSSysBDSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getPSSysBDTableId());
            dto.setPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setPSSysBDTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            linkDTO = (PSSysBISchemeDTO)PSModelServiceUtil.getInstance().getPSSysBISchemeService().getDTO(dto.getPSSysBISchemeId());
            dto.setPSSysBISchemeName(((PSSysBISchemeDTO)linkDTO).getPSSysBISchemeName());
        } else {
            dto.setPSSysBISchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDataSyncAgentId())) {
            linkDTO = (PSSysDataSyncAgentDTO)PSModelServiceUtil.getInstance().getPSSysDataSyncAgentService().getDTO(dto.getPSSysDataSyncAgentId());
            dto.setPSSysDataSyncAgentName(((PSSysDataSyncAgentDTO)linkDTO).getPSSysDataSyncAgentName());
        } else {
            dto.setPSSysDataSyncAgentName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBSchemeId())) {
            linkDTO = (PSSysDBSchemeDTO)PSModelServiceUtil.getInstance().getPSSysDBSchemeService().getDTO(dto.getPSSysDBSchemeId());
            dto.setPSSysDBSchemeName(((PSSysDBSchemeDTO)linkDTO).getPSSysDBSchemeName());
        } else {
            dto.setPSSysDBSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDBTableId())) {
            linkDTO = (PSSysDBTableDTO)PSModelServiceUtil.getInstance().getPSSysDBTableService().getDTO(dto.getPSSysDBTableId());
            dto.setPSSysDBTableName(((PSSysDBTableDTO)linkDTO).getPSSysDBTableName());
        } else {
            dto.setPSSysDBTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDELogicNodeId())) {
            linkDTO = (PSSysDELogicNodeDTO)PSModelServiceUtil.getInstance().getPSSysDELogicNodeService().getDTO(dto.getPSSysDELogicNodeId());
            dto.setPSSysDELogicNodeName(((PSSysDELogicNodeDTO)linkDTO).getPSSysDELogicNodeName());
        } else {
            dto.setPSSysDELogicNodeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            linkDTO = (PSSysEAIElementDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementService().getDTO(dto.getPSSysEAIElementId());
            dto.setPSSysEAIElementName(((PSSysEAIElementDTO)linkDTO).getPSSysEAIElementName());
        } else {
            dto.setPSSysEAIElementName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            linkDTO = (PSSysEAISchemeDTO)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().getDTO(dto.getPSSysEAISchemeId());
            dto.setPSSysEAISchemeName(((PSSysEAISchemeDTO)linkDTO).getPSSysEAISchemeName());
        } else {
            dto.setPSSysEAISchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            linkDTO = (PSSysSearchDocDTO)PSModelServiceUtil.getInstance().getPSSysSearchDocService().getDTO(dto.getPSSysSearchDocId());
            dto.setPSSysSearchDocName(((PSSysSearchDocDTO)linkDTO).getPSSysSearchDocName());
        } else {
            dto.setPSSysSearchDocName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchSchemeId())) {
            linkDTO = (PSSysSearchSchemeDTO)PSModelServiceUtil.getInstance().getPSSysSearchSchemeService().getDTO(dto.getPSSysSearchSchemeId());
            dto.setPSSysSearchSchemeName(((PSSysSearchSchemeDTO)linkDTO).getPSSysSearchSchemeName());
        } else {
            dto.setPSSysSearchSchemeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniStateId())) {
            linkDTO = (PSSysUniStateDTO)PSModelServiceUtil.getInstance().getPSSysUniStateService().getDTO(dto.getPSSysUniStateId());
            dto.setPSSysUniStateName(((PSSysUniStateDTO)linkDTO).getPSSysUniStateName());
        } else {
            dto.setPSSysUniStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUtilDEId())) {
            linkDTO = (PSSysUtilDEDTO)PSModelServiceUtil.getInstance().getPSSysUtilDEService().getDTO(dto.getPSSysUtilDEId());
            dto.setPSSysUtilDEName(((PSSysUtilDEDTO)linkDTO).getPSSysUtilDEName());
        } else {
            dto.setPSSysUtilDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getPSWFDEId());
            dto.setPSWFDEName(((PSWFDEDTO)linkDTO).getPSWFDEName());
        } else {
            dto.setPSWFDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWorkflowId());
            dto.setPSWorkflowName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWorkflowName(null);
        }
        if (StringUtils.hasLength((String)dto.getRetPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getRetPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setRetPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setRetPSDLParamName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDLParamId())) {
            linkDTO = (PSDELogicParamDTO)PSModelServiceUtil.getInstance().getPSDELogicParamService().getDTO(dto.getSrcPSDLParamId(), true);
            if (linkDTO != null) {
                dto.setSrcPSDLParamName(((PSDELogicParamDTO)linkDTO).getPSDELogicParamName());
            }
        } else {
            dto.setSrcPSDLParamName(null);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDELNParamService().listByPSDELogicNode(t)) != null && list.size() > 0) {
            ArrayList<PSDELNParamDTO> psdelnparams = new ArrayList<PSDELNParamDTO>();
            for (PSDELNParam item : list) {
                PSDELNParamDTO dstItem = (PSDELNParamDTO)PSModelServiceUtil.getInstance().getPSDELNParamService().toDTO(item);
                psdelnparams.add(dstItem);
            }
            dto.setPsdelnparams(psdelnparams);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELOGICNODE";
    }

    @Override
    public PSDELogicNode createDomain() {
        return new PSDELogicNode();
    }

    @Override
    public PSDELogicNodeDTO createDTO() {
        return new PSDELogicNodeDTO();
    }
}

