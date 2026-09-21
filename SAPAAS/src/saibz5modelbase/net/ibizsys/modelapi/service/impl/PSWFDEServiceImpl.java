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
import net.ibizsys.modelapi.domain.PSWFDE;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSWFDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFDEServiceImpl
extends PSModelServiceImplBase<PSWFDE, PSWFDEDTO>
implements IPSWFDEService {
    private static final Log log = LogFactory.getLog(PSWFDEServiceImpl.class);

    @Override
    public List<PSWFDE> listByPSWorkflow(PSWorkflow parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFDE get(PSWorkflow parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFDE> list = this.listByPSWorkflow(parent);
        if (list != null) {
            for (PSWFDE item : list) {
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
    public List<PSWFDEDTO> listDTOByPSWorkflow(String strParentKey) throws Exception {
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey);
        List<PSWFDE> list = this.listByPSWorkflow(psworkflow);
        if (list != null) {
            ArrayList<PSWFDEDTO> dtoList = new ArrayList<PSWFDEDTO>();
            for (PSWFDE item : list) {
                PSWFDEDTO dto = (PSWFDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFDE> onListAll() throws Exception {
        ArrayList<PSWFDE> list = new ArrayList<PSWFDE>();
        List psworkflows = PSModelServiceUtil.getInstance().getPSWorkflowService().listAll();
        if (psworkflows != null) {
            for (PSWorkflow parent : psworkflows) {
                List<PSWFDE> items = this.listByPSWorkflow(parent);
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
    protected PSWFDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFDE item;
        PSWorkflow psworkflow = (PSWorkflow)PSModelServiceUtil.getInstance().getPSWorkflowService().get(strParentKey, true);
        if (psworkflow != null && (item = this.get(psworkflow, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWorkflowService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEName())) {
            return et.getPSDEName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFDEDTO dto, PSWFDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFDEId(t.getId().replace("/", "."));
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
        if (t.getDefaultMode() != null || !bIgnoreNull) {
            dto.setDefaultMode(t.getDefaultMode());
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
        if (t.getExtCntStates() != null || !bIgnoreNull) {
            dto.setExtCntStates(t.getExtCntStates());
        }
        if (t.getFinishPSDEActionId() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionId(t.getFinishPSDEActionId());
        }
        if (t.getFinishPSDEActionName() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionName(t.getFinishPSDEActionName());
        }
        if (t.getInitPSDEActionId() != null || !bIgnoreNull) {
            dto.setInitPSDEActionId(t.getInitPSDEActionId());
        }
        if (t.getInitPSDEActionName() != null || !bIgnoreNull) {
            dto.setInitPSDEActionName(t.getInitPSDEActionName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobProxyData2PSDEViewId() != null || !bIgnoreNull) {
            dto.setMobProxyData2PSDEViewId(t.getMobProxyData2PSDEViewId());
        }
        if (t.getMobProxyData2PSDEViewName() != null || !bIgnoreNull) {
            dto.setMobProxyData2PSDEViewName(t.getMobProxyData2PSDEViewName());
        }
        if (t.getMobProxyDataPSDEViewId() != null || !bIgnoreNull) {
            dto.setMobProxyDataPSDEViewId(t.getMobProxyDataPSDEViewId());
        }
        if (t.getMobProxyDataPSDEViewName() != null || !bIgnoreNull) {
            dto.setMobProxyDataPSDEViewName(t.getMobProxyDataPSDEViewName());
        }
        if (t.getMyWFData() != null || !bIgnoreNull) {
            dto.setMyWFData(t.getMyWFData());
        }
        if (t.getMyWFDataPSLanResId() != null || !bIgnoreNull) {
            dto.setMyWFDataPSLanResId(t.getMyWFDataPSLanResId());
        }
        if (t.getMyWFDataPSLanResName() != null || !bIgnoreNull) {
            dto.setMyWFDataPSLanResName(t.getMyWFDataPSLanResName());
        }
        if (t.getMyWFWork() != null || !bIgnoreNull) {
            dto.setMyWFWork(t.getMyWFWork());
        }
        if (t.getMyWFWorkPSLanResId() != null || !bIgnoreNull) {
            dto.setMyWFWorkPSLanResId(t.getMyWFWorkPSLanResId());
        }
        if (t.getMyWFWorkPSLanResName() != null || !bIgnoreNull) {
            dto.setMyWFWorkPSLanResName(t.getMyWFWorkPSLanResName());
        }
        if (t.getProxyData2PSDEViewId() != null || !bIgnoreNull) {
            dto.setProxyData2PSDEViewId(t.getProxyData2PSDEViewId());
        }
        if (t.getProxyData2PSDEViewName() != null || !bIgnoreNull) {
            dto.setProxyData2PSDEViewName(t.getProxyData2PSDEViewName());
        }
        if (t.getProxyDataPSDEFId() != null || !bIgnoreNull) {
            dto.setProxyDataPSDEFId(t.getProxyDataPSDEFId());
        }
        if (t.getProxyDataPSDEFName() != null || !bIgnoreNull) {
            dto.setProxyDataPSDEFName(t.getProxyDataPSDEFName());
        }
        if (t.getProxyDataPSDEViewId() != null || !bIgnoreNull) {
            dto.setProxyDataPSDEViewId(t.getProxyDataPSDEViewId());
        }
        if (t.getProxyDataPSDEViewName() != null || !bIgnoreNull) {
            dto.setProxyDataPSDEViewName(t.getProxyDataPSDEViewName());
        }
        if (t.getProxyModulePSDEFId() != null || !bIgnoreNull) {
            dto.setProxyModulePSDEFId(t.getProxyModulePSDEFId());
        }
        if (t.getProxyModulePSDEFName() != null || !bIgnoreNull) {
            dto.setProxyModulePSDEFName(t.getProxyModulePSDEFName());
        }
        if (t.getProxyWFPSDEFId() != null || !bIgnoreNull) {
            dto.setProxyWFPSDEFId(t.getProxyWFPSDEFId());
        }
        if (t.getProxyWFPSDEFName() != null || !bIgnoreNull) {
            dto.setProxyWFPSDEFName(t.getProxyWFPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSWFDEName() != null || !bIgnoreNull) {
            dto.setPSWFDEName(t.getPSWFDEName());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFName() != null || !bIgnoreNull) {
            dto.setPSWFName(t.getPSWFName());
        }
        if (t.getPWFInstPSDEFId() != null || !bIgnoreNull) {
            dto.setPWFInstPSDEFId(t.getPWFInstPSDEFId());
        }
        if (t.getPWFInstPSDEFName() != null || !bIgnoreNull) {
            dto.setPWFInstPSDEFName(t.getPWFInstPSDEFName());
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
        if (t.getStatePSDEFId() != null || !bIgnoreNull) {
            dto.setStatePSDEFId(t.getStatePSDEFId());
        }
        if (t.getStatePSDEFName() != null || !bIgnoreNull) {
            dto.setStatePSDEFName(t.getStatePSDEFName());
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
        if (t.getUserStart() != null || !bIgnoreNull) {
            dto.setUserStart(t.getUserStart());
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
        if (t.getWFActorPSDEFId() != null || !bIgnoreNull) {
            dto.setWFActorPSDEFId(t.getWFActorPSDEFId());
        }
        if (t.getWFActorPSDEFName() != null || !bIgnoreNull) {
            dto.setWFActorPSDEFName(t.getWFActorPSDEFName());
        }
        if (t.getWFIdPSDEFId() != null || !bIgnoreNull) {
            dto.setWFIdPSDEFId(t.getWFIdPSDEFId());
        }
        if (t.getWFIdPSDEFName() != null || !bIgnoreNull) {
            dto.setWFIdPSDEFName(t.getWFIdPSDEFName());
        }
        if (t.getWFInstPSDEFId() != null || !bIgnoreNull) {
            dto.setWFInstPSDEFId(t.getWFInstPSDEFId());
        }
        if (t.getWFInstPSDEFName() != null || !bIgnoreNull) {
            dto.setWFInstPSDEFName(t.getWFInstPSDEFName());
        }
        if (t.getWFMode() != null || !bIgnoreNull) {
            dto.setWFMode(t.getWFMode());
        }
        if (t.getWFProxyMode() != null || !bIgnoreNull) {
            dto.setWFProxyMode(t.getWFProxyMode());
        }
        if (t.getWFRetPSDEFId() != null || !bIgnoreNull) {
            dto.setWFRetPSDEFId(t.getWFRetPSDEFId());
        }
        if (t.getWFRetPSDEFName() != null || !bIgnoreNull) {
            dto.setWFRetPSDEFName(t.getWFRetPSDEFName());
        }
        if (t.getWFStatePSDEFId() != null || !bIgnoreNull) {
            dto.setWFStatePSDEFId(t.getWFStatePSDEFId());
        }
        if (t.getWFStatePSDEFName() != null || !bIgnoreNull) {
            dto.setWFStatePSDEFName(t.getWFStatePSDEFName());
        }
        if (t.getWFStepPSDEFId() != null || !bIgnoreNull) {
            dto.setWFStepPSDEFId(t.getWFStepPSDEFId());
        }
        if (t.getWFStepPSDEFName() != null || !bIgnoreNull) {
            dto.setWFStepPSDEFName(t.getWFStepPSDEFName());
        }
        if (t.getWFVerPSDEFId() != null || !bIgnoreNull) {
            dto.setWFVerPSDEFId(t.getWFVerPSDEFId());
        }
        if (t.getWFVerPSDEFName() != null || !bIgnoreNull) {
            dto.setWFVerPSDEFName(t.getWFVerPSDEFName());
        }
        if (StringUtils.hasLength((String)dto.getActionMobPSDEViewId())) {
            dto.setActionMobPSDEViewId(this.getRealPSModelId(t, dto.getActionMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getActionPSDEViewId())) {
            dto.setActionPSDEViewId(this.getRealPSModelId(t, dto.getActionPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            dto.setFinishPSDEActionId(this.getRealPSModelId(t, dto.getFinishPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            dto.setInitPSDEActionId(this.getRealPSModelId(t, dto.getInitPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobProxyData2PSDEViewId())) {
            dto.setMobProxyData2PSDEViewId(this.getRealPSModelId(t, dto.getMobProxyData2PSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMobProxyDataPSDEViewId())) {
            dto.setMobProxyDataPSDEViewId(this.getRealPSModelId(t, dto.getMobProxyDataPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMyWFDataPSLanResId())) {
            dto.setMyWFDataPSLanResId(this.getRealPSModelId(t, dto.getMyWFDataPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMyWFWorkPSLanResId())) {
            dto.setMyWFWorkPSLanResId(this.getRealPSModelId(t, dto.getMyWFWorkPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getProxyData2PSDEViewId())) {
            dto.setProxyData2PSDEViewId(this.getRealPSModelId(t, dto.getProxyData2PSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getProxyDataPSDEFId())) {
            dto.setProxyDataPSDEFId(this.getRealPSModelId(t, dto.getProxyDataPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getProxyDataPSDEViewId())) {
            dto.setProxyDataPSDEViewId(this.getRealPSModelId(t, dto.getProxyDataPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getProxyModulePSDEFId())) {
            dto.setProxyModulePSDEFId(this.getRealPSModelId(t, dto.getProxyModulePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getProxyWFPSDEFId())) {
            dto.setProxyWFPSDEFId(this.getRealPSModelId(t, dto.getProxyWFPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            dto.setPSWFId(this.getRealPSModelId(t, dto.getPSWFId()).replace("/", "."));
        }
        if ("PSWORKFLOW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPWFInstPSDEFId())) {
            dto.setPWFInstPSDEFId(this.getRealPSModelId(t, dto.getPWFInstPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStartMobPSDEViewId())) {
            dto.setStartMobPSDEViewId(this.getRealPSModelId(t, dto.getStartMobPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStartPSDEViewId())) {
            dto.setStartPSDEViewId(this.getRealPSModelId(t, dto.getStartPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            dto.setStatePSDEFId(this.getRealPSModelId(t, dto.getStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFActorPSDEFId())) {
            dto.setWFActorPSDEFId(this.getRealPSModelId(t, dto.getWFActorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFIdPSDEFId())) {
            dto.setWFIdPSDEFId(this.getRealPSModelId(t, dto.getWFIdPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFInstPSDEFId())) {
            dto.setWFInstPSDEFId(this.getRealPSModelId(t, dto.getWFInstPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFRetPSDEFId())) {
            dto.setWFRetPSDEFId(this.getRealPSModelId(t, dto.getWFRetPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFStatePSDEFId())) {
            dto.setWFStatePSDEFId(this.getRealPSModelId(t, dto.getWFStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFStepPSDEFId())) {
            dto.setWFStepPSDEFId(this.getRealPSModelId(t, dto.getWFStepPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getWFVerPSDEFId())) {
            dto.setWFVerPSDEFId(this.getRealPSModelId(t, dto.getWFVerPSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getFinishPSDEActionId());
            dto.setFinishPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setFinishPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getInitPSDEActionId());
            dto.setInitPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setInitPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobProxyData2PSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobProxyData2PSDEViewId());
            dto.setMobProxyData2PSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobProxyData2PSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMobProxyDataPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getMobProxyDataPSDEViewId());
            dto.setMobProxyDataPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setMobProxyDataPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getMyWFDataPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getMyWFDataPSLanResId());
            dto.setMyWFDataPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setMyWFDataPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getMyWFWorkPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getMyWFWorkPSLanResId());
            dto.setMyWFWorkPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setMyWFWorkPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getProxyData2PSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getProxyData2PSDEViewId());
            dto.setProxyData2PSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setProxyData2PSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getProxyDataPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getProxyDataPSDEFId());
            dto.setProxyDataPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setProxyDataPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getProxyDataPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getProxyDataPSDEViewId());
            dto.setProxyDataPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setProxyDataPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getProxyModulePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getProxyModulePSDEFId());
            dto.setProxyModulePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setProxyModulePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getProxyWFPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getProxyWFPSDEFId());
            dto.setProxyWFPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setProxyWFPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWFId());
            dto.setPSWFName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPWFInstPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPWFInstPSDEFId());
            dto.setPWFInstPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPWFInstPSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getStatePSDEFId());
            dto.setStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setStatePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFActorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFActorPSDEFId());
            dto.setWFActorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFActorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFIdPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFIdPSDEFId());
            dto.setWFIdPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFIdPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFInstPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFInstPSDEFId());
            dto.setWFInstPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFInstPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFRetPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFRetPSDEFId());
            dto.setWFRetPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFRetPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFStatePSDEFId());
            dto.setWFStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFStatePSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFStepPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFStepPSDEFId());
            dto.setWFStepPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFStepPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getWFVerPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getWFVerPSDEFId());
            dto.setWFVerPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setWFVerPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSWFDE";
    }

    @Override
    public PSWFDE createDomain() {
        return new PSWFDE();
    }

    @Override
    public PSWFDEDTO createDTO() {
        return new PSWFDEDTO();
    }
}

