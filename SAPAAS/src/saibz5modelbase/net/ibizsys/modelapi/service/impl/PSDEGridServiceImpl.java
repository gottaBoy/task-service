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
import net.ibizsys.modelapi.domain.PSDEGEIUpdate;
import net.ibizsys.modelapi.domain.PSDEGEIVR;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDEGridCol;
import net.ibizsys.modelapi.domain.PSDEGridLogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEGEIVRDTO;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSDEGridLogicDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSDEGridService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGridServiceImpl
extends PSModelServiceImplBase<PSDEGrid, PSDEGridDTO>
implements IPSDEGridService {
    private static final Log log = LogFactory.getLog(PSDEGridServiceImpl.class);

    @Override
    public List<PSDEGrid> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGrid get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGrid> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEGrid item : list) {
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
    public List<PSDEGridDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEGrid> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEGridDTO> dtoList = new ArrayList<PSDEGridDTO>();
            for (PSDEGrid item : list) {
                PSDEGridDTO dto = (PSDEGridDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGrid> onListAll() throws Exception {
        ArrayList<PSDEGrid> list = new ArrayList<PSDEGrid>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEGrid> items = this.listByPSDataEntity(parent);
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
    protected PSDEGrid onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGrid item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGrid)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGridDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGrid et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGridDTO dto, PSDEGrid t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGridId(t.getId().replace("/", "."));
        }
        if (t.getAggMode() != null || !bIgnoreNull) {
            dto.setAggMode(t.getAggMode());
        }
        if (t.getAggPSDEActionId() != null || !bIgnoreNull) {
            dto.setAggPSDEActionId(t.getAggPSDEActionId());
        }
        if (t.getAggPSDEActionName() != null || !bIgnoreNull) {
            dto.setAggPSDEActionName(t.getAggPSDEActionName());
        }
        if (t.getAggPSDEDSId() != null || !bIgnoreNull) {
            dto.setAggPSDEDSId(t.getAggPSDEDSId());
        }
        if (t.getAggPSDEDSName() != null || !bIgnoreNull) {
            dto.setAggPSDEDSName(t.getAggPSDEDSName());
        }
        if (t.getAggPSDEId() != null || !bIgnoreNull) {
            dto.setAggPSDEId(t.getAggPSDEId());
        }
        if (t.getAggPSDEName() != null || !bIgnoreNull) {
            dto.setAggPSDEName(t.getAggPSDEName());
        }
        if (t.getAggPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setAggPSSysViewPanelId(t.getAggPSSysViewPanelId());
        }
        if (t.getAggPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setAggPSSysViewPanelName(t.getAggPSSysViewPanelName());
        }
        if (t.getBatPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarId(t.getBatPSDEToolbarId());
        }
        if (t.getBatPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarName(t.getBatPSDEToolbarName());
        }
        if (t.getBufferRendererMode() != null || !bIgnoreNull) {
            dto.setBufferRendererMode(t.getBufferRendererMode());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColEnableFilter() != null || !bIgnoreNull) {
            dto.setColEnableFilter(t.getColEnableFilter());
        }
        if (t.getColEnableLink() != null || !bIgnoreNull) {
            dto.setColEnableLink(t.getColEnableLink());
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
        if (t.getCustomCond() != null || !bIgnoreNull) {
            dto.setCustomCond(t.getCustomCond());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEmptyText() != null || !bIgnoreNull) {
            dto.setEmptyText(t.getEmptyText());
        }
        if (t.getEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResId(t.getEmptyTextPSLanResId());
        }
        if (t.getEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResName(t.getEmptyTextPSLanResName());
        }
        if (t.getEnablePagingBar() != null || !bIgnoreNull) {
            dto.setEnablePagingBar(t.getEnablePagingBar());
        }
        if (t.getForceFit() != null || !bIgnoreNull) {
            dto.setForceFit(t.getForceFit());
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
        if (t.getGridSN() != null || !bIgnoreNull) {
            dto.setGridSN(t.getGridSN());
        }
        if (t.getGridStyle() != null || !bIgnoreNull) {
            dto.setGridStyle(t.getGridStyle());
        }
        if (t.getGroupMode() != null || !bIgnoreNull) {
            dto.setGroupMode(t.getGroupMode());
        }
        if (t.getGroupPSCodeListId() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListId(t.getGroupPSCodeListId());
        }
        if (t.getGroupPSCodeListName() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListName(t.getGroupPSCodeListName());
        }
        if (t.getGroupPSDEFId() != null || !bIgnoreNull) {
            dto.setGroupPSDEFId(t.getGroupPSDEFId());
        }
        if (t.getGroupPSDEFName() != null || !bIgnoreNull) {
            dto.setGroupPSDEFName(t.getGroupPSDEFName());
        }
        if (t.getGroupPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setGroupPSDEUAGroupId(t.getGroupPSDEUAGroupId());
        }
        if (t.getGroupPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setGroupPSDEUAGroupName(t.getGroupPSDEUAGroupName());
        }
        if (t.getGroupPSSysCssId() != null || !bIgnoreNull) {
            dto.setGroupPSSysCssId(t.getGroupPSSysCssId());
        }
        if (t.getGroupPSSysCssName() != null || !bIgnoreNull) {
            dto.setGroupPSSysCssName(t.getGroupPSSysCssName());
        }
        if (t.getGroupPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGroupPSSysPFPluginId(t.getGroupPSSysPFPluginId());
        }
        if (t.getGroupPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGroupPSSysPFPluginName(t.getGroupPSSysPFPluginName());
        }
        if (t.getIgnoreDSItem() != null || !bIgnoreNull) {
            dto.setIgnoreDSItem(t.getIgnoreDSItem());
        }
        if (t.getItemPSSysCssId() != null || !bIgnoreNull) {
            dto.setItemPSSysCssId(t.getItemPSSysCssId());
        }
        if (t.getItemPSSysCssName() != null || !bIgnoreNull) {
            dto.setItemPSSysCssName(t.getItemPSSysCssName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorSortDir() != null || !bIgnoreNull) {
            dto.setMinorSortDir(t.getMinorSortDir());
        }
        if (t.getMinorSortPSDEFId() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFId(t.getMinorSortPSDEFId());
        }
        if (t.getMinorSortPSDEFName() != null || !bIgnoreNull) {
            dto.setMinorSortPSDEFName(t.getMinorSortPSDEFName());
        }
        if (t.getNavPSDERId() != null || !bIgnoreNull) {
            dto.setNavPSDERId(t.getNavPSDERId());
        }
        if (t.getNavPSDERName() != null || !bIgnoreNull) {
            dto.setNavPSDERName(t.getNavPSDERName());
        }
        if (t.getNavPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setNavPSDEViewBaseId(t.getNavPSDEViewBaseId());
        }
        if (t.getNavPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setNavPSDEViewBaseName(t.getNavPSDEViewBaseName());
        }
        if (t.getNavViewFilter() != null || !bIgnoreNull) {
            dto.setNavViewFilter(t.getNavViewFilter());
        }
        if (t.getNavViewParam() != null || !bIgnoreNull) {
            dto.setNavViewParam(t.getNavViewParam());
        }
        if (t.getNoSort() != null || !bIgnoreNull) {
            dto.setNoSort(t.getNoSort());
        }
        if (t.getOrderValuePSDEFId() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFId(t.getOrderValuePSDEFId());
        }
        if (t.getOrderValuePSDEFName() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFName(t.getOrderValuePSDEFName());
        }
        if (t.getPagingSize() != null || !bIgnoreNull) {
            dto.setPagingSize(t.getPagingSize());
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
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
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
        if (t.getQuickPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarId(t.getQuickPSDEToolbarId());
        }
        if (t.getQuickPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarName(t.getQuickPSDEToolbarName());
        }
        if (t.getRemovePSDEActionId() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionId(t.getRemovePSDEActionId());
        }
        if (t.getRemovePSDEActionName() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionName(t.getRemovePSDEActionName());
        }
        if (t.getShowHeader() != null || !bIgnoreNull) {
            dto.setShowHeader(t.getShowHeader());
        }
        if (t.getSortMode() != null || !bIgnoreNull) {
            dto.setSortMode(t.getSortMode());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
        }
        if (t.getTreePPSDEFId() != null || !bIgnoreNull) {
            dto.setTreePPSDEFId(t.getTreePPSDEFId());
        }
        if (t.getTreePPSDEFName() != null || !bIgnoreNull) {
            dto.setTreePPSDEFName(t.getTreePPSDEFName());
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
        if (StringUtils.hasLength((String)dto.getAggPSDEActionId())) {
            dto.setAggPSDEActionId(this.getRealPSModelId(t, dto.getAggPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAggPSDEDSId())) {
            dto.setAggPSDEDSId(this.getRealPSModelId(t, dto.getAggPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAggPSDEId())) {
            dto.setAggPSDEId(this.getRealPSModelId(t, dto.getAggPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAggPSSysViewPanelId())) {
            dto.setAggPSSysViewPanelId(this.getRealPSModelId(t, dto.getAggPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            dto.setBatPSDEToolbarId(this.getRealPSModelId(t, dto.getBatPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCopyPSDEActionId())) {
            dto.setCopyPSDEActionId(this.getRealPSModelId(t, dto.getCopyPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            dto.setCreatePSDEActionId(this.getRealPSModelId(t, dto.getCreatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetDraftPSDEActionId())) {
            dto.setGetDraftPSDEActionId(this.getRealPSModelId(t, dto.getGetDraftPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            dto.setGetPSDEActionId(this.getRealPSModelId(t, dto.getGetPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            dto.setGroupPSCodeListId(this.getRealPSModelId(t, dto.getGroupPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            dto.setGroupPSDEFId(this.getRealPSModelId(t, dto.getGroupPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEUAGroupId())) {
            dto.setGroupPSDEUAGroupId(this.getRealPSModelId(t, dto.getGroupPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysCssId())) {
            dto.setGroupPSSysCssId(this.getRealPSModelId(t, dto.getGroupPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysPFPluginId())) {
            dto.setGroupPSSysPFPluginId(this.getRealPSModelId(t, dto.getGroupPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getItemPSSysCssId())) {
            dto.setItemPSSysCssId(this.getRealPSModelId(t, dto.getItemPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            dto.setMinorSortPSDEFId(this.getRealPSModelId(t, dto.getMinorSortPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNavPSDERId())) {
            dto.setNavPSDERId(this.getRealPSModelId(t, dto.getNavPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNavPSDEViewBaseId())) {
            dto.setNavPSDEViewBaseId(this.getRealPSModelId(t, dto.getNavPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            dto.setOrderValuePSDEFId(this.getRealPSModelId(t, dto.getOrderValuePSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            dto.setQuickPSDEToolbarId(this.getRealPSModelId(t, dto.getQuickPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            dto.setRemovePSDEActionId(this.getRealPSModelId(t, dto.getRemovePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTreePPSDEFId())) {
            dto.setTreePPSDEFId(this.getRealPSModelId(t, dto.getTreePPSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getAggPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getAggPSDEActionId());
            dto.setAggPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setAggPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getAggPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getAggPSDEDSId());
            dto.setAggPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setAggPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getAggPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getAggPSDEId());
            dto.setAggPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setAggPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getAggPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getAggPSSysViewPanelId());
            dto.setAggPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setAggPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getBatPSDEToolbarId());
            dto.setBatPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setBatPSDEToolbarName(null);
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
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
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
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getGroupPSCodeListId());
            dto.setGroupPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setGroupPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getGroupPSDEFId());
            dto.setGroupPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setGroupPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getGroupPSDEUAGroupId());
            dto.setGroupPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setGroupPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getGroupPSSysCssId());
            dto.setGroupPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setGroupPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGroupPSSysPFPluginId());
            dto.setGroupPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGroupPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getItemPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getItemPSSysCssId());
            dto.setItemPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setItemPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorSortPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMinorSortPSDEFId());
            dto.setMinorSortPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMinorSortPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNavPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getNavPSDERId());
            dto.setNavPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setNavPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getNavPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getNavPSDEViewBaseId());
            dto.setNavPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setNavPSDEViewBaseName(null);
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getOrderValuePSDEFId());
            dto.setOrderValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setOrderValuePSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
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
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getQuickPSDEToolbarId());
            dto.setQuickPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setQuickPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRemovePSDEActionId());
            dto.setRemovePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRemovePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getTreePPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTreePPSDEFId());
            dto.setTreePPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTreePPSDEFName(null);
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
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEGridColService().listByPSDEGrid(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEGridColDTO> psdegridcols = new ArrayList<PSDEGridColDTO>();
            for (PSDEGridCol pSDEGridCol : list) {
                dstItem = (PSDEGridColDTO)PSModelServiceUtil.getInstance().getPSDEGridColService().toDTO(pSDEGridCol);
                psdegridcols.add((PSDEGridColDTO)dstItem);
            }
            dto.setPsdegridcols(psdegridcols);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().listByPSDEGrid(t)) != null && list.size() > 0) {
            ArrayList<PSDEGEIUpdateDTO> psdegeiupdates = new ArrayList<PSDEGEIUpdateDTO>();
            for (PSDEGEIUpdate pSDEGEIUpdate : list) {
                dstItem = (PSDEGEIUpdateDTO)PSModelServiceUtil.getInstance().getPSDEGEIUpdateService().toDTO(pSDEGEIUpdate);
                psdegeiupdates.add((PSDEGEIUpdateDTO)dstItem);
            }
            dto.setPsdegeiupdates(psdegeiupdates);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEGEIVRService().listByPSDEGrid(t)) != null && list.size() > 0) {
            ArrayList<PSDEGEIVRDTO> psdegeivrs = new ArrayList<PSDEGEIVRDTO>();
            for (PSDEGEIVR pSDEGEIVR : list) {
                dstItem = (PSDEGEIVRDTO)PSModelServiceUtil.getInstance().getPSDEGEIVRService().toDTO(pSDEGEIVR);
                psdegeivrs.add((PSDEGEIVRDTO)dstItem);
            }
            dto.setPsdegeivrs(psdegeivrs);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEGridLogicService().listByPSDEGrid(t)) != null && list.size() > 0) {
            ArrayList<PSDEGridLogicDTO> psdegridlogics = new ArrayList<PSDEGridLogicDTO>();
            for (PSDEGridLogic pSDEGridLogic : list) {
                dstItem = (PSDEGridLogicDTO)PSModelServiceUtil.getInstance().getPSDEGridLogicService().toDTO(pSDEGridLogic);
                psdegridlogics.add((PSDEGridLogicDTO)dstItem);
            }
            dto.setPsdegridlogics(psdegridlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEGRID";
    }

    @Override
    public PSDEGrid createDomain() {
        return new PSDEGrid();
    }

    @Override
    public PSDEGridDTO createDTO() {
        return new PSDEGridDTO();
    }
}

