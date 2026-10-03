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
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTemplDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysWFCatDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSWXAccountDTO;
import net.ibizsys.modelapi.dto.PSWXEntAppDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWorkflowService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWorkflowServiceImpl
extends PSModelServiceImplBase<PSWorkflow, PSWorkflowDTO>
implements IPSWorkflowService {
    private static final Log log = LogFactory.getLog(PSWorkflowServiceImpl.class);

    @Override
    public List<PSWorkflow> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWorkflow get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWorkflow> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSWorkflow item : list) {
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
    public List<PSWorkflowDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSWorkflow> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSWorkflowDTO> dtoList = new ArrayList<PSWorkflowDTO>();
            for (PSWorkflow item : list) {
                PSWorkflowDTO dto = (PSWorkflowDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWorkflow> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWorkflow get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWorkflow> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSWorkflow item : list) {
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
    public List<PSWorkflowDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSWorkflow> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSWorkflowDTO> dtoList = new ArrayList<PSWorkflowDTO>();
            for (PSWorkflow item : list) {
                PSWorkflowDTO dto = (PSWorkflowDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWorkflow> onListAll() throws Exception {
        List<PSSystem> pssystems;
        ArrayList<PSWorkflow> list = new ArrayList<PSWorkflow>();
        List<PSModule> psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll();
        if (psmodules != null) {
            for (PSModule parent : psmodules) {
                List<PSWorkflow> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSWorkflow> items = this.listByPSSystem(parent);
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
    protected PSWorkflow onGet(String strParentKey, String strCurKey) throws Exception {
        PSWorkflow item;
        PSWorkflow item2;
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSWorkflow)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWorkflowDTO dto) throws Exception {
        String strPickupValue = null;
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
    public String getModelTag(PSWorkflow et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWorkflowDTO dto, PSWorkflow t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWorkflowId(t.getId().replace("/", "."));
        }
        if (t.getActionMobPSDEViewId() != null || !bIgnoreNull) {
            dto.setActionMobPSDEViewId(t.getActionMobPSDEViewId());
        }
        if (t.getActionMobPSDEViewName() != null || !bIgnoreNull) {
            dto.setActionMobPSDEViewName(t.getActionMobPSDEViewName());
        }
        if (t.getActionPSDEViewId() != null || !bIgnoreNull) {
            dto.setActionPSDEViewId(t.getActionPSDEViewId());
        }
        if (t.getActionPSDEViewName() != null || !bIgnoreNull) {
            dto.setActionPSDEViewName(t.getActionPSDEViewName());
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEditableWFStep() != null || !bIgnoreNull) {
            dto.setEditableWFStep(t.getEditableWFStep());
        }
        if (t.getEnable() != null || !bIgnoreNull) {
            dto.setEnable(t.getEnable());
        }
        if (t.getEnableDynaSys() != null || !bIgnoreNull) {
            dto.setEnableDynaSys(t.getEnableDynaSys());
        }
        if (t.getEnableDynaView() != null || !bIgnoreNull) {
            dto.setEnableDynaView(t.getEnableDynaView());
        }
        if (t.getEnableMob() != null || !bIgnoreNull) {
            dto.setEnableMob(t.getEnableMob());
        }
        if (t.getExtCntStates() != null || !bIgnoreNull) {
            dto.setExtCntStates(t.getExtCntStates());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobWFEditViewType() != null || !bIgnoreNull) {
            dto.setMobWFEditViewType(t.getMobWFEditViewType());
        }
        if (t.getModColor() != null || !bIgnoreNull) {
            dto.setModColor(t.getModColor());
        }
        if (t.getNamePSLanResId() != null || !bIgnoreNull) {
            dto.setNamePSLanResId(t.getNamePSLanResId());
        }
        if (t.getNamePSLanResName() != null || !bIgnoreNull) {
            dto.setNamePSLanResName(t.getNamePSLanResName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
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
        if (t.getPSSysWFCatId() != null || !bIgnoreNull) {
            dto.setPSSysWFCatId(t.getPSSysWFCatId());
        }
        if (t.getPSSysWFCatName() != null || !bIgnoreNull) {
            dto.setPSSysWFCatName(t.getPSSysWFCatName());
        }
        if (t.getPSWorkflowName() != null || !bIgnoreNull) {
            dto.setPSWorkflowName(t.getPSWorkflowName());
        }
        if (t.getPSWXAccountId() != null || !bIgnoreNull) {
            dto.setPSWXAccountId(t.getPSWXAccountId());
        }
        if (t.getPSWXAccountName() != null || !bIgnoreNull) {
            dto.setPSWXAccountName(t.getPSWXAccountName());
        }
        if (t.getPSWXEntAppId() != null || !bIgnoreNull) {
            dto.setPSWXEntAppId(t.getPSWXEntAppId());
        }
        if (t.getPSWXEntAppName() != null || !bIgnoreNull) {
            dto.setPSWXEntAppName(t.getPSWXEntAppName());
        }
        if (t.getRemindPSSysMsgTemplId() != null || !bIgnoreNull) {
            dto.setRemindPSSysMsgTemplId(t.getRemindPSSysMsgTemplId());
        }
        if (t.getRemindPSSysMsgTemplName() != null || !bIgnoreNull) {
            dto.setRemindPSSysMsgTemplName(t.getRemindPSSysMsgTemplName());
        }
        if (t.getRemoteEngineFlag() != null || !bIgnoreNull) {
            dto.setRemoteEngineFlag(t.getRemoteEngineFlag());
        }
        if (t.getStartMobPSDEViewId() != null || !bIgnoreNull) {
            dto.setStartMobPSDEViewId(t.getStartMobPSDEViewId());
        }
        if (t.getStartMobPSDEViewName() != null || !bIgnoreNull) {
            dto.setStartMobPSDEViewName(t.getStartMobPSDEViewName());
        }
        if (t.getStartPSDEViewId() != null || !bIgnoreNull) {
            dto.setStartPSDEViewId(t.getStartPSDEViewId());
        }
        if (t.getStartPSDEViewName() != null || !bIgnoreNull) {
            dto.setStartPSDEViewName(t.getStartPSDEViewName());
        }
        if (t.getStateCodeListId() != null || !bIgnoreNull) {
            dto.setStateCodeListId(t.getStateCodeListId());
        }
        if (t.getStateCodeListName() != null || !bIgnoreNull) {
            dto.setStateCodeListName(t.getStateCodeListName());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getWFCancelValue() != null || !bIgnoreNull) {
            dto.setWFCancelValue(t.getWFCancelValue());
        }
        if (t.getWFCancelValueText() != null || !bIgnoreNull) {
            dto.setWFCancelValueText(t.getWFCancelValueText());
        }
        if (t.getWFEditViewType() != null || !bIgnoreNull) {
            dto.setWFEditViewType(t.getWFEditViewType());
        }
        if (t.getWFEngineType() != null || !bIgnoreNull) {
            dto.setWFEngineType(t.getWFEngineType());
        }
        if (t.getWFErrorValue() != null || !bIgnoreNull) {
            dto.setWFErrorValue(t.getWFErrorValue());
        }
        if (t.getWFErrorValueText() != null || !bIgnoreNull) {
            dto.setWFErrorValueText(t.getWFErrorValueText());
        }
        if (t.getWFFinishValue() != null || !bIgnoreNull) {
            dto.setWFFinishValue(t.getWFFinishValue());
        }
        if (t.getWFFinishValueText() != null || !bIgnoreNull) {
            dto.setWFFinishValueText(t.getWFFinishValueText());
        }
        if (t.getWFProxyMode() != null || !bIgnoreNull) {
            dto.setWFProxyMode(t.getWFProxyMode());
        }
        if (t.getWFSN() != null || !bIgnoreNull) {
            dto.setWFSN(t.getWFSN());
        }
        if (t.getWFStateValue() != null || !bIgnoreNull) {
            dto.setWFStateValue(t.getWFStateValue());
        }
        if (t.getWFStepCodeListId() != null || !bIgnoreNull) {
            dto.setWFStepCodeListId(t.getWFStepCodeListId());
        }
        if (t.getWFStepCodeListName() != null || !bIgnoreNull) {
            dto.setWFStepCodeListName(t.getWFStepCodeListName());
        }
        if (t.getWFTag() != null || !bIgnoreNull) {
            dto.setWFTag(t.getWFTag());
        }
        if (t.getWFTag2() != null || !bIgnoreNull) {
            dto.setWFTag2(t.getWFTag2());
        }
        if (t.getWFTag3() != null || !bIgnoreNull) {
            dto.setWFTag3(t.getWFTag3());
        }
        if (t.getWFTag4() != null || !bIgnoreNull) {
            dto.setWFTag4(t.getWFTag4());
        }
        if (t.getWFType() != null || !bIgnoreNull) {
            dto.setWFType(t.getWFType());
        }
        if (StringUtils.hasLength((String)dto.getActionMobPSDEViewId())) {
            dto.setActionMobPSDEViewId(this.getRealPSModelId(t, dto.getActionMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getActionPSDEViewId())) {
            dto.setActionPSDEViewId(this.getRealPSModelId(t, dto.getActionPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysWFCatId())) {
            dto.setPSSysWFCatId(this.getRealPSModelId(t, dto.getPSSysWFCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            dto.setPSWXAccountId(this.getRealPSModelId(t, dto.getPSWXAccountId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXEntAppId())) {
            dto.setPSWXEntAppId(this.getRealPSModelId(t, dto.getPSWXEntAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemindPSSysMsgTemplId())) {
            dto.setRemindPSSysMsgTemplId(this.getRealPSModelId(t, dto.getRemindPSSysMsgTemplId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStartMobPSDEViewId())) {
            dto.setStartMobPSDEViewId(this.getRealPSModelId(t, dto.getStartMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStartPSDEViewId())) {
            dto.setStartPSDEViewId(this.getRealPSModelId(t, dto.getStartPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStateCodeListId())) {
            dto.setStateCodeListId(this.getRealPSModelId(t, dto.getStateCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFStepCodeListId())) {
            dto.setWFStepCodeListId(this.getRealPSModelId(t, dto.getWFStepCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getActionMobPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getActionMobPSDEViewId());
            dto.setActionMobPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setActionMobPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getActionPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getActionPSDEViewId());
            dto.setActionPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setActionPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNamePSLanResId());
            dto.setNamePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNamePSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setModColor(((PSModuleDTO)linkDTO).getColor());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setModColor(null);
            dto.setPSModuleName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysWFCatId())) {
            linkDTO = (PSSysWFCatDTO)PSModelServiceUtil.getInstance().getPSSysWFCatService().getDTO(dto.getPSSysWFCatId());
            dto.setPSSysWFCatName(((PSSysWFCatDTO)linkDTO).getPSSysWFCatName());
        } else {
            dto.setPSSysWFCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            linkDTO = (PSWXAccountDTO)PSModelServiceUtil.getInstance().getPSWXAccountService().getDTO(dto.getPSWXAccountId());
            dto.setPSWXAccountName(((PSWXAccountDTO)linkDTO).getPSWXAccountName());
        } else {
            dto.setPSWXAccountName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXEntAppId())) {
            linkDTO = (PSWXEntAppDTO)PSModelServiceUtil.getInstance().getPSWXEntAppService().getDTO(dto.getPSWXEntAppId());
            dto.setPSWXEntAppName(((PSWXEntAppDTO)linkDTO).getPSWXEntAppName());
        } else {
            dto.setPSWXEntAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemindPSSysMsgTemplId())) {
            linkDTO = (PSSysMsgTemplDTO)PSModelServiceUtil.getInstance().getPSSysMsgTemplService().getDTO(dto.getRemindPSSysMsgTemplId());
            dto.setRemindPSSysMsgTemplName(((PSSysMsgTemplDTO)linkDTO).getPSSysMsgTemplName());
        } else {
            dto.setRemindPSSysMsgTemplName(null);
        }
        if (StringUtils.hasLength((String)dto.getStartMobPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getStartMobPSDEViewId());
            dto.setStartMobPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setStartMobPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getStartPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getStartPSDEViewId());
            dto.setStartPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setStartPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getStateCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getStateCodeListId());
            dto.setStateCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setStateCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFStepCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getWFStepCodeListId());
            dto.setWFStepCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setWFStepCodeListName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSWORKFLOW";
    }

    @Override
    public PSWorkflow createDomain() {
        return new PSWorkflow();
    }

    @Override
    public PSWorkflowDTO createDTO() {
        return new PSWorkflowDTO();
    }
}

