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
import net.ibizsys.modelapi.domain.PSDEFDLogic;
import net.ibizsys.modelapi.domain.PSDEFIUDetail;
import net.ibizsys.modelapi.domain.PSDEFIUpdate;
import net.ibizsys.modelapi.domain.PSDEFIVR;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormDetail;
import net.ibizsys.modelapi.domain.PSDEFormLogic;
import net.ibizsys.modelapi.domain.PSDEFormRF;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFDLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEFIVRDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFormLogicDTO;
import net.ibizsys.modelapi.dto.PSDEFormRFDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.service.IPSDEFormService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFormServiceImpl
extends PSModelServiceImplBase<PSDEForm, PSDEFormDTO>
implements IPSDEFormService {
    private static final Log log = LogFactory.getLog(PSDEFormServiceImpl.class);

    @Override
    public List<PSDEForm> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEForm get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEForm> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEForm item : list) {
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
    public List<PSDEFormDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEForm> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEFormDTO> dtoList = new ArrayList<PSDEFormDTO>();
            for (PSDEForm item : list) {
                PSDEFormDTO dto = (PSDEFormDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEForm> onListAll() throws Exception {
        ArrayList<PSDEForm> list = new ArrayList<PSDEForm>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEForm> items = this.listByPSDataEntity(parent);
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
    protected PSDEForm onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEForm item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEForm)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFormDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEForm et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFormDTO dto, PSDEForm t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFormId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCopyPSDEActionId() != null || !bIgnoreNull) {
            dto.setCopyPSDEActionId(t.getCopyPSDEActionId());
        }
        if (t.getCopyPSDEActionName() != null || !bIgnoreNull) {
            dto.setCopyPSDEActionName(t.getCopyPSDEActionName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCreatePSDEActionId() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionId(t.getCreatePSDEActionId());
        }
        if (t.getCreatePSDEActionName() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionName(t.getCreatePSDEActionName());
        }
        if (t.getCtrlColSpan() != null || !bIgnoreNull) {
            dto.setCtrlColSpan(t.getCtrlColSpan());
        }
        if (t.getDataType() != null || !bIgnoreNull) {
            dto.setDataType(t.getDataType());
        }
        if (t.getDetailStyle() != null || !bIgnoreNull) {
            dto.setDetailStyle(t.getDetailStyle());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getDynaSysRefMode() != null || !bIgnoreNull) {
            dto.setDynaSysRefMode(t.getDynaSysRefMode());
        }
        if (t.getEnableAdvSearch() != null || !bIgnoreNull) {
            dto.setEnableAdvSearch(t.getEnableAdvSearch());
        }
        if (t.getFormItemStyle() != null || !bIgnoreNull) {
            dto.setFormItemStyle(t.getFormItemStyle());
        }
        if (t.getFormNavBar() != null || !bIgnoreNull) {
            dto.setFormNavBar(t.getFormNavBar());
        }
        if (t.getFormSN() != null || !bIgnoreNull) {
            dto.setFormSN(t.getFormSN());
        }
        if (t.getFormStyle() != null || !bIgnoreNull) {
            dto.setFormStyle(t.getFormStyle());
        }
        if (t.getFormTag() != null || !bIgnoreNull) {
            dto.setFormTag(t.getFormTag());
        }
        if (t.getFormTag2() != null || !bIgnoreNull) {
            dto.setFormTag2(t.getFormTag2());
        }
        if (t.getFormTag3() != null || !bIgnoreNull) {
            dto.setFormTag3(t.getFormTag3());
        }
        if (t.getFormTag4() != null || !bIgnoreNull) {
            dto.setFormTag4(t.getFormTag4());
        }
        if (t.getFormType() != null || !bIgnoreNull) {
            dto.setFormType(t.getFormType());
        }
        if (t.getFormWidth() != null || !bIgnoreNull) {
            dto.setFormWidth(t.getFormWidth());
        }
        if (t.getFuncMode() != null || !bIgnoreNull) {
            dto.setFuncMode(t.getFuncMode());
        }
        if (t.getGetDraftPSDEActionId() != null || !bIgnoreNull) {
            dto.setGetDraftPSDEActionId(t.getGetDraftPSDEActionId());
        }
        if (t.getGetDraftPSDEActionName() != null || !bIgnoreNull) {
            dto.setGetDraftPSDEActionName(t.getGetDraftPSDEActionName());
        }
        if (t.getGetPSDEActionId() != null || !bIgnoreNull) {
            dto.setGetPSDEActionId(t.getGetPSDEActionId());
        }
        if (t.getGetPSDEActionName() != null || !bIgnoreNull) {
            dto.setGetPSDEActionName(t.getGetPSDEActionName());
        }
        if (t.getInfoFormFlag() != null || !bIgnoreNull) {
            dto.setInfoFormFlag(t.getInfoFormFlag());
        }
        if (t.getLabelColSpan() != null || !bIgnoreNull) {
            dto.setLabelColSpan(t.getLabelColSpan());
        }
        if (t.getLabelColSpan2() != null || !bIgnoreNull) {
            dto.setLabelColSpan2(t.getLabelColSpan2());
        }
        if (t.getLabelWidth() != null || !bIgnoreNull) {
            dto.setLabelWidth(t.getLabelWidth());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getNavBarHeight() != null || !bIgnoreNull) {
            dto.setNavBarHeight(t.getNavBarHeight());
        }
        if (t.getNavBarPos() != null || !bIgnoreNull) {
            dto.setNavBarPos(t.getNavBarPos());
        }
        if (t.getNavBarPSSysCssId() != null || !bIgnoreNull) {
            dto.setNavBarPSSysCssId(t.getNavBarPSSysCssId());
        }
        if (t.getNavBarPSSysCssName() != null || !bIgnoreNull) {
            dto.setNavBarPSSysCssName(t.getNavBarPSSysCssName());
        }
        if (t.getNavBarStyle() != null || !bIgnoreNull) {
            dto.setNavBarStyle(t.getNavBarStyle());
        }
        if (t.getNavBarWidth() != null || !bIgnoreNull) {
            dto.setNavBarWidth(t.getNavBarWidth());
        }
        if (t.getPDVTParam() != null || !bIgnoreNull) {
            dto.setPDVTParam(t.getPDVTParam());
        }
        if (t.getPSACHandlerId() != null || !bIgnoreNull) {
            dto.setPSACHandlerId(t.getPSACHandlerId());
        }
        if (t.getPSACHandlerName() != null || !bIgnoreNull) {
            dto.setPSACHandlerName(t.getPSACHandlerName());
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
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDynaDEFormId() != null || !bIgnoreNull) {
            dto.setPSDynaDEFormId(t.getPSDynaDEFormId());
        }
        if (t.getPSDynaDEFormInstId() != null || !bIgnoreNull) {
            dto.setPSDynaDEFormInstId(t.getPSDynaDEFormInstId());
        }
        if (t.getPSDynaDEFormInstName() != null || !bIgnoreNull) {
            dto.setPSDynaDEFormInstName(t.getPSDynaDEFormInstName());
        }
        if (t.getPSDynaDEFormName() != null || !bIgnoreNull) {
            dto.setPSDynaDEFormName(t.getPSDynaDEFormName());
        }
        if (t.getPSDynaInstName() != null || !bIgnoreNull) {
            dto.setPSDynaInstName(t.getPSDynaInstName());
        }
        if (t.getPSPFId() != null || !bIgnoreNull) {
            dto.setPSPFId(t.getPSPFId());
        }
        if (t.getPSPFName() != null || !bIgnoreNull) {
            dto.setPSPFName(t.getPSPFName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
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
        if (t.getRemovePSDEActionId() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionId(t.getRemovePSDEActionId());
        }
        if (t.getRemovePSDEActionName() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionName(t.getRemovePSDEActionName());
        }
        if (t.getSearchBtnPos() != null || !bIgnoreNull) {
            dto.setSearchBtnPos(t.getSearchBtnPos());
        }
        if (t.getSearchBtnStyle() != null || !bIgnoreNull) {
            dto.setSearchBtnStyle(t.getSearchBtnStyle());
        }
        if (t.getShowTabHeader() != null || !bIgnoreNull) {
            dto.setShowTabHeader(t.getShowTabHeader());
        }
        if (t.getTabHeaderPos() != null || !bIgnoreNull) {
            dto.setTabHeaderPos(t.getTabHeaderPos());
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
        if (t.getUpdatePSDEActionId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionId(t.getUpdatePSDEActionId());
        }
        if (t.getUpdatePSDEActionName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionName(t.getUpdatePSDEActionName());
        }
        if (t.getUser2PSDEActionId() != null || !bIgnoreNull) {
            dto.setUser2PSDEActionId(t.getUser2PSDEActionId());
        }
        if (t.getUser2PSDEActionName() != null || !bIgnoreNull) {
            dto.setUser2PSDEActionName(t.getUser2PSDEActionName());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getUserPSDEActionId() != null || !bIgnoreNull) {
            dto.setUserPSDEActionId(t.getUserPSDEActionId());
        }
        if (t.getUserPSDEActionName() != null || !bIgnoreNull) {
            dto.setUserPSDEActionName(t.getUserPSDEActionName());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (StringUtils.hasLength((String)dto.getCopyPSDEActionId())) {
            dto.setCopyPSDEActionId(this.getRealPSModelId(t, dto.getCopyPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            dto.setCreatePSDEActionId(this.getRealPSModelId(t, dto.getCreatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetDraftPSDEActionId())) {
            dto.setGetDraftPSDEActionId(this.getRealPSModelId(t, dto.getGetDraftPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            dto.setGetPSDEActionId(this.getRealPSModelId(t, dto.getGetPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNavBarPSSysCssId())) {
            dto.setNavBarPSSysCssId(this.getRealPSModelId(t, dto.getNavBarPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            dto.setRemovePSDEActionId(this.getRealPSModelId(t, dto.getRemovePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            dto.setUpdatePSDEActionId(this.getRealPSModelId(t, dto.getUpdatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEActionId())) {
            dto.setUser2PSDEActionId(this.getRealPSModelId(t, dto.getUser2PSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEActionId())) {
            dto.setUserPSDEActionId(this.getRealPSModelId(t, dto.getUserPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCopyPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCopyPSDEActionId());
            dto.setCopyPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCopyPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCreatePSDEActionId());
            dto.setCreatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCreatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getGetDraftPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getGetDraftPSDEActionId());
            dto.setGetDraftPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setGetDraftPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getGetPSDEActionId());
            dto.setGetPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setGetPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getNavBarPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getNavBarPSSysCssId());
            dto.setNavBarPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setNavBarPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getPSACHandlerId());
            dto.setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setPSACHandlerName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
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
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRemovePSDEActionId());
            dto.setRemovePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRemovePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUpdatePSDEActionId());
            dto.setUpdatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUpdatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUser2PSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUser2PSDEActionId());
            dto.setUser2PSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUser2PSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUserPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUserPSDEActionId());
            dto.setUserPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUserPSDEActionName(null);
        }
        List<PSDEFormDetail> pSDEFormDetailList = PSModelServiceUtil.getInstance().getPSDEFormDetailService().listByPSDEForm(t);
        if (pSDEFormDetailList != null && pSDEFormDetailList.size() > 0) {
            ArrayList<PSDEFormDetailDTO> psdeformdetails = new ArrayList<PSDEFormDetailDTO>();
            for (PSDEFormDetail pSDEFormDetail : pSDEFormDetailList) {
                dstItem = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().toDTO(pSDEFormDetail);
                psdeformdetails.add((PSDEFormDetailDTO)dstItem);
            }
            dto.setPsdeformdetails(psdeformdetails);
        }
        List<PSDEFormRF> pSDEFormRFList = PSModelServiceUtil.getInstance().getPSDEFormRFService().listByPSDEForm(t);
        if (pSDEFormRFList != null && pSDEFormRFList.size() > 0) {
            ArrayList<PSDEFormRFDTO> psdeformrves = new ArrayList<PSDEFormRFDTO>();
            for (PSDEFormRF pSDEFormRF : pSDEFormRFList) {
                dstItem = (PSDEFormRFDTO)PSModelServiceUtil.getInstance().getPSDEFormRFService().toDTO(pSDEFormRF);
                psdeformrves.add((PSDEFormRFDTO)dstItem);
            }
            dto.setPsdeformrves(psdeformrves);
        }
        List<PSDEFDLogic> pSDEFDLogicList = PSModelServiceUtil.getInstance().getPSDEFDLogicService().listByPSDEForm(t);
        if (pSDEFDLogicList != null && pSDEFDLogicList.size() > 0) {
            ArrayList<PSDEFDLogicDTO> psdefdlogics = new ArrayList<PSDEFDLogicDTO>();
            for (PSDEFDLogic pSDEFDLogic : pSDEFDLogicList) {
                dstItem = (PSDEFDLogicDTO)PSModelServiceUtil.getInstance().getPSDEFDLogicService().toDTO(pSDEFDLogic);
                psdefdlogics.add((PSDEFDLogicDTO)dstItem);
            }
            dto.setPsdefdlogics(psdefdlogics);
        }
        List<PSDEFIUDetail> pSDEFIUDetailList = PSModelServiceUtil.getInstance().getPSDEFIUDetailService().listByPSDEForm(t);
        if (pSDEFIUDetailList != null && pSDEFIUDetailList.size() > 0) {
            ArrayList<PSDEFIUDetailDTO> psdefiudetails = new ArrayList<PSDEFIUDetailDTO>();
            for (PSDEFIUDetail pSDEFIUDetail : pSDEFIUDetailList) {
                dstItem = (PSDEFIUDetailDTO)PSModelServiceUtil.getInstance().getPSDEFIUDetailService().toDTO(pSDEFIUDetail);
                psdefiudetails.add((PSDEFIUDetailDTO)dstItem);
            }
            dto.setPsdefiudetails(psdefiudetails);
        }
        List<PSDEFIUpdate> pSDEFIUpdateList = PSModelServiceUtil.getInstance().getPSDEFIUpdateService().listByPSDEForm(t);
        if (pSDEFIUpdateList != null && pSDEFIUpdateList.size() > 0) {
            ArrayList<PSDEFIUpdateDTO> psdefiupdates = new ArrayList<PSDEFIUpdateDTO>();
            for (PSDEFIUpdate pSDEFIUpdate : pSDEFIUpdateList) {
                dstItem = (PSDEFIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEFIUpdateService().toDTO(pSDEFIUpdate);
                psdefiupdates.add((PSDEFIUpdateDTO)dstItem);
            }
            dto.setPsdefiupdates(psdefiupdates);
        }
        List<PSDEFIVR> pSDEFIVRList = PSModelServiceUtil.getInstance().getPSDEFIVRService().listByPSDEForm(t);
        if (pSDEFIVRList != null && pSDEFIVRList.size() > 0) {
            ArrayList<PSDEFIVRDTO> psdefivrs = new ArrayList<PSDEFIVRDTO>();
            for (PSDEFIVR pSDEFIVR : pSDEFIVRList) {
                dstItem = (PSDEFIVRDTO)PSModelServiceUtil.getInstance().getPSDEFIVRService().toDTO(pSDEFIVR);
                psdefivrs.add((PSDEFIVRDTO)dstItem);
            }
            dto.setPsdefivrs(psdefivrs);
        }
        List<PSDEFormLogic> pSDEFormLogicList = PSModelServiceUtil.getInstance().getPSDEFormLogicService().listByPSDEForm(t);
        if (pSDEFormLogicList != null && pSDEFormLogicList.size() > 0) {
            ArrayList<PSDEFormLogicDTO> psdeformlogics = new ArrayList<PSDEFormLogicDTO>();
            for (PSDEFormLogic pSDEFormLogic : pSDEFormLogicList) {
                dstItem = (PSDEFormLogicDTO)PSModelServiceUtil.getInstance().getPSDEFormLogicService().toDTO(pSDEFormLogic);
                psdeformlogics.add((PSDEFormLogicDTO)dstItem);
            }
            dto.setPsdeformlogics(psdeformlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFORM";
    }

    @Override
    public PSDEForm createDomain() {
        return new PSDEForm();
    }

    @Override
    public PSDEFormDTO createDTO() {
        return new PSDEFormDTO();
    }
}

