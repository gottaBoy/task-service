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
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewCtrl;
import net.ibizsys.modelapi.domain.PSDEViewEngine;
import net.ibizsys.modelapi.domain.PSDEViewLogic;
import net.ibizsys.modelapi.domain.PSDEViewRV;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDEViewCtrlDTO;
import net.ibizsys.modelapi.dto.PSDEViewEngineDTO;
import net.ibizsys.modelapi.dto.PSDEViewLogicDTO;
import net.ibizsys.modelapi.dto.PSDEViewRVDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSubViewTypeDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.service.IPSDEViewBaseService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEViewBaseServiceImpl
extends PSModelServiceImplBase<PSDEViewBase, PSDEViewBaseDTO>
implements IPSDEViewBaseService {
    private static final Log log = LogFactory.getLog(PSDEViewBaseServiceImpl.class);

    @Override
    public List<PSDEViewBase> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEViewBase get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEViewBase> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEViewBase item : list) {
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
    public List<PSDEViewBaseDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEViewBase> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEViewBaseDTO> dtoList = new ArrayList<PSDEViewBaseDTO>();
            for (PSDEViewBase item : list) {
                PSDEViewBaseDTO dto = (PSDEViewBaseDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEViewBase> onListAll() throws Exception {
        ArrayList<PSDEViewBase> list = new ArrayList<PSDEViewBase>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEViewBase> items = this.listByPSDataEntity(parent);
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
    protected PSDEViewBase onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEViewBase item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEViewBase)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEViewBaseDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEViewBase et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEViewBaseDTO dto, PSDEViewBase t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEViewBaseId(t.getId().replace("/", "."));
        }
        if (t.getAccUserMode() != null || !bIgnoreNull) {
            dto.setAccUserMode(t.getAccUserMode());
        }
        if (t.getBottomInfo() != null || !bIgnoreNull) {
            dto.setBottomInfo(t.getBottomInfo());
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
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDEViewTag() != null || !bIgnoreNull) {
            dto.setDEViewTag(t.getDEViewTag());
        }
        if (t.getDEViewTag2() != null || !bIgnoreNull) {
            dto.setDEViewTag2(t.getDEViewTag2());
        }
        if (t.getDEViewTag3() != null || !bIgnoreNull) {
            dto.setDEViewTag3(t.getDEViewTag3());
        }
        if (t.getDEViewTag4() != null || !bIgnoreNull) {
            dto.setDEViewTag4(t.getDEViewTag4());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getDyncMode() != null || !bIgnoreNull) {
            dto.setDyncMode(t.getDyncMode());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getGroupPSCodeListId() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListId(t.getGroupPSCodeListId());
        }
        if (t.getGroupPSCodeListName() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListName(t.getGroupPSCodeListName());
        }
        if (t.getHeaderInfo() != null || !bIgnoreNull) {
            dto.setHeaderInfo(t.getHeaderInfo());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getLayoutPanelMode() != null || !bIgnoreNull) {
            dto.setLayoutPanelMode(t.getLayoutPanelMode());
        }
        if (t.getLoadDefault() != null || !bIgnoreNull) {
            dto.setLoadDefault(t.getLoadDefault());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelState() != null || !bIgnoreNull) {
            dto.setModelState(t.getModelState());
        }
        if (t.getOpenMode() != null || !bIgnoreNull) {
            dto.setOpenMode(t.getOpenMode());
        }
        if (t.getPDTParamPre() != null || !bIgnoreNull) {
            dto.setPDTParamPre(t.getPDTParamPre());
        }
        if (t.getPDVTParam() != null || !bIgnoreNull) {
            dto.setPDVTParam(t.getPDVTParam());
        }
        if (t.getPredefinedViewType() != null || !bIgnoreNull) {
            dto.setPredefinedViewType(t.getPredefinedViewType());
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
        if (t.getPSDEAWGroupId() != null || !bIgnoreNull) {
            dto.setPSDEAWGroupId(t.getPSDEAWGroupId());
        }
        if (t.getPSDEAWGroupName() != null || !bIgnoreNull) {
            dto.setPSDEAWGroupName(t.getPSDEAWGroupName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
        }
        if (t.getPSDEViewBaseType() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseType(t.getPSDEViewBaseType());
        }
        if (t.getPSDynaDEViewTemplId() != null || !bIgnoreNull) {
            dto.setPSDynaDEViewTemplId(t.getPSDynaDEViewTemplId());
        }
        if (t.getPSDynaDEViewTemplName() != null || !bIgnoreNull) {
            dto.setPSDynaDEViewTemplName(t.getPSDynaDEViewTemplName());
        }
        if (t.getPSHelpModuleId() != null || !bIgnoreNull) {
            dto.setPSHelpModuleId(t.getPSHelpModuleId());
        }
        if (t.getPSHelpModuleName() != null || !bIgnoreNull) {
            dto.setPSHelpModuleName(t.getPSHelpModuleName());
        }
        if (t.getPSSubViewTypeId() != null || !bIgnoreNull) {
            dto.setPSSubViewTypeId(t.getPSSubViewTypeId());
        }
        if (t.getPSSubViewTypeName() != null || !bIgnoreNull) {
            dto.setPSSubViewTypeName(t.getPSSubViewTypeName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
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
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
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
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getPSViewEngineId() != null || !bIgnoreNull) {
            dto.setPSViewEngineId(t.getPSViewEngineId());
        }
        if (t.getPSViewEngineName() != null || !bIgnoreNull) {
            dto.setPSViewEngineName(t.getPSViewEngineName());
        }
        if (t.getPSViewMsgGroupId() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupId(t.getPSViewMsgGroupId());
        }
        if (t.getPSViewMsgGroupName() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupName(t.getPSViewMsgGroupName());
        }
        if (t.getPSWFDEId() != null || !bIgnoreNull) {
            dto.setPSWFDEId(t.getPSWFDEId());
        }
        if (t.getPSWFDEName() != null || !bIgnoreNull) {
            dto.setPSWFDEName(t.getPSWFDEName());
        }
        if (t.getPSWFId() != null || !bIgnoreNull) {
            dto.setPSWFId(t.getPSWFId());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getReadOnlyMode() != null || !bIgnoreNull) {
            dto.setReadOnlyMode(t.getReadOnlyMode());
        }
        if (t.getShowCaptionBar() != null || !bIgnoreNull) {
            dto.setShowCaptionBar(t.getShowCaptionBar());
        }
        if (t.getSubCapPSLanResId() != null || !bIgnoreNull) {
            dto.setSubCapPSLanResId(t.getSubCapPSLanResId());
        }
        if (t.getSubCapPSLanResName() != null || !bIgnoreNull) {
            dto.setSubCapPSLanResName(t.getSubCapPSLanResName());
        }
        if (t.getSubCaption() != null || !bIgnoreNull) {
            dto.setSubCaption(t.getSubCaption());
        }
        if (t.getTempMode() != null || !bIgnoreNull) {
            dto.setTempMode(t.getTempMode());
        }
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getViewActions() != null || !bIgnoreNull) {
            dto.setViewActions(t.getViewActions());
        }
        if (t.getViewParam() != null || !bIgnoreNull) {
            dto.setViewParam(t.getViewParam());
        }
        if (t.getViewParam10() != null || !bIgnoreNull) {
            dto.setViewParam10(t.getViewParam10());
        }
        if (t.getViewParam2() != null || !bIgnoreNull) {
            dto.setViewParam2(t.getViewParam2());
        }
        if (t.getViewParam3() != null || !bIgnoreNull) {
            dto.setViewParam3(t.getViewParam3());
        }
        if (t.getViewParam4() != null || !bIgnoreNull) {
            dto.setViewParam4(t.getViewParam4());
        }
        if (t.getViewParam5() != null || !bIgnoreNull) {
            dto.setViewParam5(t.getViewParam5());
        }
        if (t.getViewParam6() != null || !bIgnoreNull) {
            dto.setViewParam6(t.getViewParam6());
        }
        if (t.getViewParam7() != null || !bIgnoreNull) {
            dto.setViewParam7(t.getViewParam7());
        }
        if (t.getViewParam8() != null || !bIgnoreNull) {
            dto.setViewParam8(t.getViewParam8());
        }
        if (t.getViewParam9() != null || !bIgnoreNull) {
            dto.setViewParam9(t.getViewParam9());
        }
        if (t.getViewParams() != null || !bIgnoreNull) {
            dto.setViewParams(t.getViewParams());
        }
        if (t.getViewSN() != null || !bIgnoreNull) {
            dto.setViewSN(t.getViewSN());
        }
        if (t.getWFViewParam() != null || !bIgnoreNull) {
            dto.setWFViewParam(t.getWFViewParam());
        }
        if (t.getWFViewParam2() != null || !bIgnoreNull) {
            dto.setWFViewParam2(t.getWFViewParam2());
        }
        if (t.getWFViewParam3() != null || !bIgnoreNull) {
            dto.setWFViewParam3(t.getWFViewParam3());
        }
        if (t.getWFViewParam4() != null || !bIgnoreNull) {
            dto.setWFViewParam4(t.getWFViewParam4());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            dto.setGroupPSCodeListId(this.getRealPSModelId(t, dto.getGroupPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubViewTypeId())) {
            dto.setPSSubViewTypeId(this.getRealPSModelId(t, dto.getPSSubViewTypeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            dto.setPSViewMsgGroupId(this.getRealPSModelId(t, dto.getPSViewMsgGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            dto.setPSWFDEId(this.getRealPSModelId(t, dto.getPSWFDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSubCapPSLanResId())) {
            dto.setSubCapPSLanResId(this.getRealPSModelId(t, dto.getSubCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getGroupPSCodeListId());
            dto.setGroupPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setGroupPSCodeListName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEMainStateName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubViewTypeId())) {
            linkDTO = (PSSubViewTypeDTO)PSModelServiceUtil.getInstance().getPSSubViewTypeService().getDTO(dto.getPSSubViewTypeId());
            dto.setPSSubViewTypeName(((PSSubViewTypeDTO)linkDTO).getPSSubViewTypeName());
        } else {
            dto.setPSSubViewTypeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(dto.getPSSysUniResId());
            dto.setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            dto.setPSSysUniResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            linkDTO = (PSViewMsgGroupDTO)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().getDTO(dto.getPSViewMsgGroupId());
            dto.setPSViewMsgGroupName(((PSViewMsgGroupDTO)linkDTO).getPSViewMsgGroupName());
        } else {
            dto.setPSViewMsgGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFDEId())) {
            linkDTO = (PSWFDEDTO)PSModelServiceUtil.getInstance().getPSWFDEService().getDTO(dto.getPSWFDEId());
            dto.setPSWFDEName(((PSWFDEDTO)linkDTO).getPSWFDEName());
            dto.setPSWFId(((PSWFDEDTO)linkDTO).getPSWFId());
        } else {
            dto.setPSWFDEName(null);
            dto.setPSWFId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFVersionName(null);
        }
        if (StringUtils.hasLength((String)dto.getSubCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getSubCapPSLanResId());
            dto.setSubCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setSubCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTitlePSLanResId());
            dto.setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTitlePSLanResName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEViewCtrlService().listByPSDEViewBase(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEViewCtrlDTO> psdeviewctrls = new ArrayList<PSDEViewCtrlDTO>();
            for (PSDEViewCtrl pSDEViewCtrl : list) {
                dstItem = (PSDEViewCtrlDTO)PSModelServiceUtil.getInstance().getPSDEViewCtrlService().toDTO(pSDEViewCtrl);
                psdeviewctrls.add((PSDEViewCtrlDTO)dstItem);
            }
            dto.setPsdeviewctrls(psdeviewctrls);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEViewEngineService().listByPSDEViewBase(t)) != null && list.size() > 0) {
            ArrayList<PSDEViewEngineDTO> psdeviewengines = new ArrayList<PSDEViewEngineDTO>();
            for (PSDEViewEngine pSDEViewEngine : list) {
                dstItem = (PSDEViewEngineDTO)PSModelServiceUtil.getInstance().getPSDEViewEngineService().toDTO(pSDEViewEngine);
                psdeviewengines.add((PSDEViewEngineDTO)dstItem);
            }
            dto.setPsdeviewengines(psdeviewengines);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEViewLogicService().listByPSDEViewBase(t)) != null && list.size() > 0) {
            ArrayList<PSDEViewLogicDTO> psdeviewlogics = new ArrayList<PSDEViewLogicDTO>();
            for (PSDEViewLogic pSDEViewLogic : list) {
                dstItem = (PSDEViewLogicDTO)PSModelServiceUtil.getInstance().getPSDEViewLogicService().toDTO(pSDEViewLogic);
                psdeviewlogics.add((PSDEViewLogicDTO)dstItem);
            }
            dto.setPsdeviewlogics(psdeviewlogics);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEViewRVService().listByPSDEViewBase(t)) != null && list.size() > 0) {
            ArrayList<PSDEViewRVDTO> psdeviewrvs = new ArrayList<PSDEViewRVDTO>();
            for (PSDEViewRV pSDEViewRV : list) {
                dstItem = (PSDEViewRVDTO)PSModelServiceUtil.getInstance().getPSDEViewRVService().toDTO(pSDEViewRV);
                psdeviewrvs.add((PSDEViewRVDTO)dstItem);
            }
            dto.setPsdeviewrvs(psdeviewrvs);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEVIEWBASE";
    }

    @Override
    public PSDEViewBase createDomain() {
        return new PSDEViewBase();
    }

    @Override
    public PSDEViewBaseDTO createDTO() {
        return new PSDEViewBaseDTO();
    }
}

