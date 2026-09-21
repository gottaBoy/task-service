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
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDEWizardForm;
import net.ibizsys.modelapi.domain.PSDEWizardLogic;
import net.ibizsys.modelapi.domain.PSDEWizardStep;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.dto.PSDEWizardFormDTO;
import net.ibizsys.modelapi.dto.PSDEWizardLogicDTO;
import net.ibizsys.modelapi.dto.PSDEWizardStepDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.service.IPSDEWizardService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEWizardServiceImpl
extends PSModelServiceImplBase<PSDEWizard, PSDEWizardDTO>
implements IPSDEWizardService {
    private static final Log log = LogFactory.getLog(PSDEWizardServiceImpl.class);

    @Override
    public List<PSDEWizard> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEWizard get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEWizard> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEWizard item : list) {
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
    public List<PSDEWizardDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEWizard> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEWizardDTO> dtoList = new ArrayList<PSDEWizardDTO>();
            for (PSDEWizard item : list) {
                PSDEWizardDTO dto = (PSDEWizardDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEWizard> onListAll() throws Exception {
        ArrayList<PSDEWizard> list = new ArrayList<PSDEWizard>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEWizard> items = this.listByPSDataEntity(parent);
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
    protected PSDEWizard onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEWizard item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEWizard)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEWizardDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEWizard et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEWizardDTO dto, PSDEWizard t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEWizardId(t.getId().replace("/", "."));
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
        if (t.getEnableMSLogic() != null || !bIgnoreNull) {
            dto.setEnableMSLogic(t.getEnableMSLogic());
        }
        if (t.getFinishCaption() != null || !bIgnoreNull) {
            dto.setFinishCaption(t.getFinishCaption());
        }
        if (t.getFinishPSDEActionId() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionId(t.getFinishPSDEActionId());
        }
        if (t.getFinishPSDEActionName() != null || !bIgnoreNull) {
            dto.setFinishPSDEActionName(t.getFinishPSDEActionName());
        }
        if (t.getFinishPSLanResId() != null || !bIgnoreNull) {
            dto.setFinishPSLanResId(t.getFinishPSLanResId());
        }
        if (t.getFinishPSLanResName() != null || !bIgnoreNull) {
            dto.setFinishPSLanResName(t.getFinishPSLanResName());
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
        if (t.getNextCaption() != null || !bIgnoreNull) {
            dto.setNextCaption(t.getNextCaption());
        }
        if (t.getNextPSLanResId() != null || !bIgnoreNull) {
            dto.setNextPSLanResId(t.getNextPSLanResId());
        }
        if (t.getNextPSLanResName() != null || !bIgnoreNull) {
            dto.setNextPSLanResName(t.getNextPSLanResName());
        }
        if (t.getPrevCaption() != null || !bIgnoreNull) {
            dto.setPrevCaption(t.getPrevCaption());
        }
        if (t.getPrevPSLanResId() != null || !bIgnoreNull) {
            dto.setPrevPSLanResId(t.getPrevPSLanResId());
        }
        if (t.getPrevPSLanResName() != null || !bIgnoreNull) {
            dto.setPrevPSLanResName(t.getPrevPSLanResName());
        }
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSCtrlMsgId() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgId(t.getPSCtrlMsgId());
        }
        if (t.getPSCtrlMsgName() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgName(t.getPSCtrlMsgName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEWizardName() != null || !bIgnoreNull) {
            dto.setPSDEWizardName(t.getPSDEWizardName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
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
        if (t.getStatePSDEFId() != null || !bIgnoreNull) {
            dto.setStatePSDEFId(t.getStatePSDEFId());
        }
        if (t.getStatePSDEFName() != null || !bIgnoreNull) {
            dto.setStatePSDEFName(t.getStatePSDEFName());
        }
        if (t.getStateWizardFlag() != null || !bIgnoreNull) {
            dto.setStateWizardFlag(t.getStateWizardFlag());
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
        if (t.getWizardStyle() != null || !bIgnoreNull) {
            dto.setWizardStyle(t.getWizardStyle());
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            dto.setFinishPSDEActionId(this.getRealPSModelId(t, dto.getFinishPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFinishPSLanResId())) {
            dto.setFinishPSLanResId(this.getRealPSModelId(t, dto.getFinishPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            dto.setInitPSDEActionId(this.getRealPSModelId(t, dto.getInitPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNextPSLanResId())) {
            dto.setNextPSLanResId(this.getRealPSModelId(t, dto.getNextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPrevPSLanResId())) {
            dto.setPrevPSLanResId(this.getRealPSModelId(t, dto.getPrevPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            dto.setPSCtrlMsgId(this.getRealPSModelId(t, dto.getPSCtrlMsgId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            dto.setStatePSDEFId(this.getRealPSModelId(t, dto.getStatePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getFinishPSDEActionId());
            dto.setFinishPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setFinishPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getFinishPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getFinishPSLanResId());
            dto.setFinishPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setFinishPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getInitPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getInitPSDEActionId());
            dto.setInitPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setInitPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getNextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNextPSLanResId());
            dto.setNextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPrevPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPrevPSLanResId());
            dto.setPrevPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPrevPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            linkDTO = (PSCtrlMsgDTO)PSModelServiceUtil.getInstance().getPSCtrlMsgService().getDTO(dto.getPSCtrlMsgId());
            dto.setPSCtrlMsgName(((PSCtrlMsgDTO)linkDTO).getPSCtrlMsgName());
        } else {
            dto.setPSCtrlMsgName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
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
        if (StringUtils.hasLength((String)dto.getStatePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getStatePSDEFId());
            dto.setStatePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setStatePSDEFName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEWizardStepService().listByPSDEWizard(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEWizardStepDTO> psdewizardsteps = new ArrayList<PSDEWizardStepDTO>();
            for (PSDEWizardStep pSDEWizardStep : list) {
                dstItem = (PSDEWizardStepDTO)PSModelServiceUtil.getInstance().getPSDEWizardStepService().toDTO(pSDEWizardStep);
                psdewizardsteps.add((PSDEWizardStepDTO)dstItem);
            }
            dto.setPsdewizardsteps(psdewizardsteps);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEWizardFormService().listByPSDEWizard(t)) != null && list.size() > 0) {
            ArrayList<PSDEWizardFormDTO> psdewizardforms = new ArrayList<PSDEWizardFormDTO>();
            for (PSDEWizardForm pSDEWizardForm : list) {
                dstItem = (PSDEWizardFormDTO)PSModelServiceUtil.getInstance().getPSDEWizardFormService().toDTO(pSDEWizardForm);
                psdewizardforms.add((PSDEWizardFormDTO)dstItem);
            }
            dto.setPsdewizardforms(psdewizardforms);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEWizardLogicService().listByPSDEWizard(t)) != null && list.size() > 0) {
            ArrayList<PSDEWizardLogicDTO> psdewizardlogics = new ArrayList<PSDEWizardLogicDTO>();
            for (PSDEWizardLogic pSDEWizardLogic : list) {
                dstItem = (PSDEWizardLogicDTO)PSModelServiceUtil.getInstance().getPSDEWizardLogicService().toDTO(pSDEWizardLogic);
                psdewizardlogics.add((PSDEWizardLogicDTO)dstItem);
            }
            dto.setPsdewizardlogics(psdewizardlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEWIZARD";
    }

    @Override
    public PSDEWizard createDomain() {
        return new PSDEWizard();
    }

    @Override
    public PSDEWizardDTO createDTO() {
        return new PSDEWizardDTO();
    }
}

