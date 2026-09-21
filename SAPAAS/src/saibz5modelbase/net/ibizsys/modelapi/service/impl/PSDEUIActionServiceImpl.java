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
import java.util.Collection;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUIAction;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataExpDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDEPrintDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFProcessDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSDEUIActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEUIActionServiceImpl
extends PSModelServiceImplBase<PSDEUIAction, PSDEUIActionDTO>
implements IPSDEUIActionService {
    private static final Log log = LogFactory.getLog(PSDEUIActionServiceImpl.class);

    @Override
    public List<PSDEUIAction> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUIAction get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUIAction> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEUIAction item : list) {
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
    public List<PSDEUIActionDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEUIAction> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEUIActionDTO> dtoList = new ArrayList<PSDEUIActionDTO>();
            for (PSDEUIAction item : list) {
                PSDEUIActionDTO dto = (PSDEUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUIAction> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUIAction get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUIAction> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSDEUIAction item : list) {
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
    public List<PSDEUIActionDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSDEUIAction> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSDEUIActionDTO> dtoList = new ArrayList<PSDEUIActionDTO>();
            for (PSDEUIAction item : list) {
                PSDEUIActionDTO dto = (PSDEUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUIAction> listByPSWorkflow(PSWorkflow parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUIAction get(PSWorkflow parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUIAction> list = this.listByPSWorkflow(parent);
        if (list != null) {
            for (PSDEUIAction item : list) {
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
    public List<PSDEUIActionDTO> listDTOByPSWorkflow(String strParentKey) throws Exception {
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey);
        List<PSDEUIAction> list = this.listByPSWorkflow(psworkflow);
        if (list != null) {
            ArrayList<PSDEUIActionDTO> dtoList = new ArrayList<PSDEUIActionDTO>();
            for (PSDEUIAction item : list) {
                PSDEUIActionDTO dto = (PSDEUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUIAction> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUIAction get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUIAction> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDEUIAction item : list) {
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
    public List<PSDEUIActionDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDEUIAction> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDEUIActionDTO> dtoList = new ArrayList<PSDEUIActionDTO>();
            for (PSDEUIAction item : list) {
                PSDEUIActionDTO dto = (PSDEUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEUIAction> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUIAction get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUIAction> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSDEUIAction item : list) {
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
    public List<PSDEUIActionDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSDEUIAction> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSDEUIActionDTO> dtoList = new ArrayList<PSDEUIActionDTO>();
            for (PSDEUIAction item : list) {
                PSDEUIActionDTO dto = (PSDEUIActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEUIAction> onListAll() throws Exception {
        List pssystems;
        List psmodules;
        List psworkflows;
        List pswfversions;
        ArrayList<PSDEUIAction> list = new ArrayList<PSDEUIAction>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEUIAction> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll()) != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSDEUIAction> items = this.listByPSWFVersion(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psworkflows = PSModelServiceUtil.getInstance().getPSWorkflowService().listAll()) != null) {
            for (PSWorkflow parent : psworkflows) {
                List<PSDEUIAction> items = this.listByPSWorkflow(parent);
                if (items == null) continue;
                list.addAll((Collection<PSDEUIAction>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSDEUIAction> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSDEUIAction> items = this.listByPSSystem(parent);
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
    protected PSDEUIAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEUIAction item;
        PSDEUIAction item2;
        PSDEUIAction item3;
        PSDEUIAction item4;
        PSDEUIAction item5;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item5 = this.get(psdataentity, strCurKey, true)) != null) {
            return item5;
        }
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item4 = this.get(pswfversion, strCurKey, true)) != null) {
            return item4;
        }
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey, true);
        if (psworkflow != null && (item3 = this.get(psworkflow, strCurKey, true)) != null) {
            return item3;
        }
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEUIAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEUIActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWorkflowService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEUIAction et) throws Exception {
        if (StringUtils.hasLength((String)et.getRepPSSysUIActionId())) {
            return et.getRepPSSysUIActionId();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEUIActionDTO dto, PSDEUIAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEUIActionId(t.getId().replace("/", "."));
        }
        if (t.getActionLevel() != null || !bIgnoreNull) {
            dto.setActionLevel(t.getActionLevel());
        }
        if (t.getActionTarget() != null || !bIgnoreNull) {
            dto.setActionTarget(t.getActionTarget());
        }
        if (t.getBusyIndicator() != null || !bIgnoreNull) {
            dto.setBusyIndicator(t.getBusyIndicator());
        }
        if (t.getCapPSLanResId() != null || !bIgnoreNull) {
            dto.setCapPSLanResId(t.getCapPSLanResId());
        }
        if (t.getCapPSLanResName() != null || !bIgnoreNull) {
            dto.setCapPSLanResName(t.getCapPSLanResName());
        }
        if (t.getCaption() != null || !bIgnoreNull) {
            dto.setCaption(t.getCaption());
        }
        if (t.getCloseEditView() != null || !bIgnoreNull) {
            dto.setCloseEditView(t.getCloseEditView());
        }
        if (t.getCMPSLanResId() != null || !bIgnoreNull) {
            dto.setCMPSLanResId(t.getCMPSLanResId());
        }
        if (t.getCMPSLanResName() != null || !bIgnoreNull) {
            dto.setCMPSLanResName(t.getCMPSLanResName());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getConfirmInfo() != null || !bIgnoreNull) {
            dto.setConfirmInfo(t.getConfirmInfo());
        }
        if (t.getCounterId() != null || !bIgnoreNull) {
            dto.setCounterId(t.getCounterId());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getDataItem() != null || !bIgnoreNull) {
            dto.setDataItem(t.getDataItem());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableRTModel() != null || !bIgnoreNull) {
            dto.setEnableRTModel(t.getEnableRTModel());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getFrontProType() != null || !bIgnoreNull) {
            dto.setFrontProType(t.getFrontProType());
        }
        if (t.getGlobalFlag() != null || !bIgnoreNull) {
            dto.setGlobalFlag(t.getGlobalFlag());
        }
        if (t.getHtmlPageUrl() != null || !bIgnoreNull) {
            dto.setHtmlPageUrl(t.getHtmlPageUrl());
        }
        if (t.getItemObj() != null || !bIgnoreNull) {
            dto.setItemObj(t.getItemObj());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobPSDEViewId(t.getMobPSDEViewId());
        }
        if (t.getMobPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobPSDEViewName(t.getMobPSDEViewName());
        }
        if (t.getNextPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setNextPSDEUIActionId(t.getNextPSDEUIActionId());
        }
        if (t.getNextPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setNextPSDEUIActionName(t.getNextPSDEUIActionName());
        }
        if (t.getNo2PSDEDataExpId() != null || !bIgnoreNull) {
            dto.setNo2PSDEDataExpId(t.getNo2PSDEDataExpId());
        }
        if (t.getNo2PSDEDataExpName() != null || !bIgnoreNull) {
            dto.setNo2PSDEDataExpName(t.getNo2PSDEDataExpName());
        }
        if (t.getNoPrivDM() != null || !bIgnoreNull) {
            dto.setNoPrivDM(t.getNoPrivDM());
        }
        if (t.getParamItem() != null || !bIgnoreNull) {
            dto.setParamItem(t.getParamItem());
        }
        if (t.getPDTViewFlag() != null || !bIgnoreNull) {
            dto.setPDTViewFlag(t.getPDTViewFlag());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEDataExpId() != null || !bIgnoreNull) {
            dto.setPSDEDataExpId(t.getPSDEDataExpId());
        }
        if (t.getPSDEDataImpId() != null || !bIgnoreNull) {
            dto.setPSDEDataImpId(t.getPSDEDataImpId());
        }
        if (t.getPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpName(t.getPSDEDataImpName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getPSDEPrintId() != null || !bIgnoreNull) {
            dto.setPSDEPrintId(t.getPSDEPrintId());
        }
        if (t.getPSDEPrintName() != null || !bIgnoreNull) {
            dto.setPSDEPrintName(t.getPSDEPrintName());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDEViewLogicId() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicId(t.getPSDEViewLogicId());
        }
        if (t.getPSDEViewLogicName() != null || !bIgnoreNull) {
            dto.setPSDEViewLogicName(t.getPSDEViewLogicName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getPSSysPDTViewId() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewId(t.getPSSysPDTViewId());
        }
        if (t.getPSSysPDTViewName() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewName(t.getPSSysPDTViewName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUIActionId() != null || !bIgnoreNull) {
            dto.setPSSysUIActionId(t.getPSSysUIActionId());
        }
        if (t.getPSSysUIActionName() != null || !bIgnoreNull) {
            dto.setPSSysUIActionName(t.getPSSysUIActionName());
        }
        if (t.getPSSysViewLogicId() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicId(t.getPSSysViewLogicId());
        }
        if (t.getPSSysViewLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicName(t.getPSSysViewLogicName());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPSWFLinkId() != null || !bIgnoreNull) {
            dto.setPSWFLinkId(t.getPSWFLinkId());
        }
        if (t.getPSWFLinkName() != null || !bIgnoreNull) {
            dto.setPSWFLinkName(t.getPSWFLinkName());
        }
        if (t.getPSWFProcessId() != null || !bIgnoreNull) {
            dto.setPSWFProcessId(t.getPSWFProcessId());
        }
        if (t.getPSWFProcessName() != null || !bIgnoreNull) {
            dto.setPSWFProcessName(t.getPSWFProcessName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getReloadData() != null || !bIgnoreNull) {
            dto.setReloadData(t.getReloadData());
        }
        if (t.getRepPSSysUIActionId() != null || !bIgnoreNull) {
            dto.setRepPSSysUIActionId(t.getRepPSSysUIActionId());
        }
        if (t.getRepPSSysUIActionName() != null || !bIgnoreNull) {
            dto.setRepPSSysUIActionName(t.getRepPSSysUIActionName());
        }
        if (t.getSMPSLanResId() != null || !bIgnoreNull) {
            dto.setSMPSLanResId(t.getSMPSLanResId());
        }
        if (t.getSMPSLanResName() != null || !bIgnoreNull) {
            dto.setSMPSLanResName(t.getSMPSLanResName());
        }
        if (t.getSuccessInfo() != null || !bIgnoreNull) {
            dto.setSuccessInfo(t.getSuccessInfo());
        }
        if (t.getSysItemObj() != null || !bIgnoreNull) {
            dto.setSysItemObj(t.getSysItemObj());
        }
        if (t.getTemplMode() != null || !bIgnoreNull) {
            dto.setTemplMode(t.getTemplMode());
        }
        if (t.getTextItem() != null || !bIgnoreNull) {
            dto.setTextItem(t.getTextItem());
        }
        if (t.getTimeout() != null || !bIgnoreNull) {
            dto.setTimeout(t.getTimeout());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
        }
        if (t.getUATag() != null || !bIgnoreNull) {
            dto.setUATag(t.getUATag());
        }
        if (t.getUATag2() != null || !bIgnoreNull) {
            dto.setUATag2(t.getUATag2());
        }
        if (t.getUATag3() != null || !bIgnoreNull) {
            dto.setUATag3(t.getUATag3());
        }
        if (t.getUATag4() != null || !bIgnoreNull) {
            dto.setUATag4(t.getUATag4());
        }
        if (t.getUIActionCode() != null || !bIgnoreNull) {
            dto.setUIActionCode(t.getUIActionCode());
        }
        if (t.getUIActionParam() != null || !bIgnoreNull) {
            dto.setUIActionParam(t.getUIActionParam());
        }
        if (t.getUIActionParam10() != null || !bIgnoreNull) {
            dto.setUIActionParam10(t.getUIActionParam10());
        }
        if (t.getUIActionParam11() != null || !bIgnoreNull) {
            dto.setUIActionParam11(t.getUIActionParam11());
        }
        if (t.getUIActionParam12() != null || !bIgnoreNull) {
            dto.setUIActionParam12(t.getUIActionParam12());
        }
        if (t.getUIActionParam2() != null || !bIgnoreNull) {
            dto.setUIActionParam2(t.getUIActionParam2());
        }
        if (t.getUIActionParam3() != null || !bIgnoreNull) {
            dto.setUIActionParam3(t.getUIActionParam3());
        }
        if (t.getUIActionParam4() != null || !bIgnoreNull) {
            dto.setUIActionParam4(t.getUIActionParam4());
        }
        if (t.getUIActionParam5() != null || !bIgnoreNull) {
            dto.setUIActionParam5(t.getUIActionParam5());
        }
        if (t.getUIActionParam6() != null || !bIgnoreNull) {
            dto.setUIActionParam6(t.getUIActionParam6());
        }
        if (t.getUIActionParam7() != null || !bIgnoreNull) {
            dto.setUIActionParam7(t.getUIActionParam7());
        }
        if (t.getUIActionParam8() != null || !bIgnoreNull) {
            dto.setUIActionParam8(t.getUIActionParam8());
        }
        if (t.getUIActionParam9() != null || !bIgnoreNull) {
            dto.setUIActionParam9(t.getUIActionParam9());
        }
        if (t.getUIActionParams() != null || !bIgnoreNull) {
            dto.setUIActionParams(t.getUIActionParams());
        }
        if (t.getUIActionType() != null || !bIgnoreNull) {
            dto.setUIActionType(t.getUIActionType());
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
        if (t.getUserConfirm() != null || !bIgnoreNull) {
            dto.setUserConfirm(t.getUserConfirm());
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
        if (t.getViewActions() != null || !bIgnoreNull) {
            dto.setViewActions(t.getViewActions());
        }
        if (t.getViewLogicType() != null || !bIgnoreNull) {
            dto.setViewLogicType(t.getViewLogicType());
        }
        if (t.getVLExecMode() != null || !bIgnoreNull) {
            dto.setVLExecMode(t.getVLExecMode());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCMPSLanResId())) {
            dto.setCMPSLanResId(this.getRealPSModelId(t, dto.getCMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            dto.setMobPSDEViewId(this.getRealPSModelId(t, dto.getMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEUIActionId())) {
            dto.setNextPSDEUIActionId(this.getRealPSModelId(t, dto.getNextPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEDataExpId())) {
            dto.setNo2PSDEDataExpId(this.getRealPSModelId(t, dto.getNo2PSDEDataExpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            dto.setPSDEDataImpId(this.getRealPSModelId(t, dto.getPSDEDataImpId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEPrintId())) {
            dto.setPSDEPrintId(this.getRealPSModelId(t, dto.getPSDEPrintId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewLogicId())) {
            dto.setPSDEViewLogicId(this.getRealPSModelId(t, dto.getPSDEViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            dto.setPSSysPDTViewId(this.getRealPSModelId(t, dto.getPSSysPDTViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            dto.setPSSysViewLogicId(this.getRealPSModelId(t, dto.getPSSysViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if ("PSWORKFLOW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            dto.setPSWFLinkId(this.getRealPSModelId(t, dto.getPSWFLinkId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            dto.setPSWFProcessId(this.getRealPSModelId(t, dto.getPSWFProcessId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSMPSLanResId())) {
            dto.setSMPSLanResId(this.getRealPSModelId(t, dto.getSMPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getCMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCMPSLanResId());
            dto.setCMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobPSDEViewId());
            dto.setMobPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getNextPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getNextPSDEUIActionId());
            dto.setNextPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setNextPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo2PSDEDataExpId())) {
            linkDTO = (PSDEDataExpDTO)PSModelServiceUtil.getInstance().getPSDEDataExpService().getDTO(dto.getNo2PSDEDataExpId());
            dto.setNo2PSDEDataExpName(((PSDEDataExpDTO)linkDTO).getPSDEDataExpName());
        } else {
            dto.setNo2PSDEDataExpName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataImpId())) {
            linkDTO = (PSDEDataImpDTO)PSModelServiceUtil.getInstance().getPSDEDataImpService().getDTO(dto.getPSDEDataImpId());
            dto.setPSDEDataImpName(((PSDEDataImpDTO)linkDTO).getPSDEDataImpName());
        } else {
            dto.setPSDEDataImpName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEPrintId())) {
            linkDTO = (PSDEPrintDTO)PSModelServiceUtil.getInstance().getPSDEPrintService().getDTO(dto.getPSDEPrintId());
            dto.setPSDEPrintName(((PSDEPrintDTO)linkDTO).getPSDEPrintName());
        } else {
            dto.setPSDEPrintName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewLogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDEViewLogicId());
            dto.setPSDEViewLogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDEViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            linkDTO = (PSSysPDTViewDTO)PSModelServiceUtil.getInstance().getPSSysPDTViewService().getDTO(dto.getPSSysPDTViewId());
            dto.setPSSysPDTViewName(((PSSysPDTViewDTO)linkDTO).getPSSysPDTViewName());
        } else {
            dto.setPSSysPDTViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            linkDTO = (PSSysViewLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewLogicService().getDTO(dto.getPSSysViewLogicId());
            dto.setPSSysViewLogicName(((PSSysViewLogicDTO)linkDTO).getPSSysViewLogicName());
        } else {
            dto.setPSSysViewLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            linkDTO = (PSWFLinkDTO)PSModelServiceUtil.getInstance().getPSWFLinkService().getDTO(dto.getPSWFLinkId(), true);
        }
        if (StringUtils.hasLength((String)dto.getPSWFProcessId())) {
            linkDTO = (PSWFProcessDTO)PSModelServiceUtil.getInstance().getPSWFProcessService().getDTO(dto.getPSWFProcessId(), true);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFVersionName(null);
        }
        if (StringUtils.hasLength((String)dto.getSMPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getSMPSLanResId());
            dto.setSMPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setSMPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEUIACTION";
    }

    @Override
    public PSDEUIAction createDomain() {
        return new PSDEUIAction();
    }

    @Override
    public PSDEUIActionDTO createDTO() {
        return new PSDEUIActionDTO();
    }
}

