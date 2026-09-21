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
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDEListItem;
import net.ibizsys.modelapi.domain.PSDEListLogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDEListItemDTO;
import net.ibizsys.modelapi.dto.PSDEListLogicDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSDEListService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEListServiceImpl
extends PSModelServiceImplBase<PSDEList, PSDEListDTO>
implements IPSDEListService {
    private static final Log log = LogFactory.getLog(PSDEListServiceImpl.class);

    @Override
    public List<PSDEList> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEList get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEList> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEList item : list) {
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
    public List<PSDEListDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEList> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEListDTO> dtoList = new ArrayList<PSDEListDTO>();
            for (PSDEList item : list) {
                PSDEListDTO dto = (PSDEListDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEList> onListAll() throws Exception {
        ArrayList<PSDEList> list = new ArrayList<PSDEList>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEList> items = this.listByPSDataEntity(parent);
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
    protected PSDEList onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEList item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEList)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEListDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEList et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEListName())) {
            return et.getPSDEListName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEListDTO dto, PSDEList t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEListId(t.getId().replace("/", "."));
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
        }
        if (t.getAppendDEItems() != null || !bIgnoreNull) {
            dto.setAppendDEItems(t.getAppendDEItems());
        }
        if (t.getBatPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarId(t.getBatPSDEToolbarId());
        }
        if (t.getBatPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarName(t.getBatPSDEToolbarName());
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
        if (t.getItemPSSysCssId() != null || !bIgnoreNull) {
            dto.setItemPSSysCssId(t.getItemPSSysCssId());
        }
        if (t.getItemPSSysCssName() != null || !bIgnoreNull) {
            dto.setItemPSSysCssName(t.getItemPSSysCssName());
        }
        if (t.getItemPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setItemPSSysPFPluginId(t.getItemPSSysPFPluginId());
        }
        if (t.getItemPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setItemPSSysPFPluginName(t.getItemPSSysPFPluginName());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getLVTag() != null || !bIgnoreNull) {
            dto.setLVTag(t.getLVTag());
        }
        if (t.getLVTag2() != null || !bIgnoreNull) {
            dto.setLVTag2(t.getLVTag2());
        }
        if (t.getLVTag3() != null || !bIgnoreNull) {
            dto.setLVTag3(t.getLVTag3());
        }
        if (t.getLVTag4() != null || !bIgnoreNull) {
            dto.setLVTag4(t.getLVTag4());
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
        if (t.getMobListStyle() != null || !bIgnoreNull) {
            dto.setMobListStyle(t.getMobListStyle());
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
        if (t.getNo2PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupId(t.getNo2PSDEUAGroupId());
        }
        if (t.getNo2PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupName(t.getNo2PSDEUAGroupName());
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
        if (t.getPageSize() != null || !bIgnoreNull) {
            dto.setPageSize(t.getPageSize());
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
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEListName() != null || !bIgnoreNull) {
            dto.setPSDEListName(t.getPSDEListName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
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
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getQuickPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarId(t.getQuickPSDEToolbarId());
        }
        if (t.getQuickPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarName(t.getQuickPSDEToolbarName());
        }
        if (t.getShowHeader() != null || !bIgnoreNull) {
            dto.setShowHeader(t.getShowHeader());
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
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            dto.setADPSDELogicId(this.getRealPSModelId(t, dto.getADPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            dto.setBatPSDEToolbarId(this.getRealPSModelId(t, dto.getBatPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getItemPSSysPFPluginId())) {
            dto.setItemPSSysPFPluginId(this.getRealPSModelId(t, dto.getItemPSSysPFPluginId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            dto.setNo2PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo2PSDEUAGroupId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            dto.setQuickPSDEToolbarId(this.getRealPSModelId(t, dto.getQuickPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getBatPSDEToolbarId());
            dto.setBatPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setBatPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
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
        if (StringUtils.hasLength((String)dto.getItemPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getItemPSSysPFPluginId());
            dto.setItemPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setItemPSSysPFPluginName(null);
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
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo2PSDEUAGroupId());
            dto.setNo2PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo2PSDEUAGroupName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getQuickPSDEToolbarId());
            dto.setQuickPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setQuickPSDEToolbarName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDEListItemService().listByPSDEList(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEListItemDTO> psdelistitems = new ArrayList<PSDEListItemDTO>();
            for (PSDEListItem pSDEListItem : list) {
                dstItem = (PSDEListItemDTO)PSModelServiceUtil.getInstance().getPSDEListItemService().toDTO(pSDEListItem);
                psdelistitems.add((PSDEListItemDTO)dstItem);
            }
            dto.setPsdelistitems(psdelistitems);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEListLogicService().listByPSDEList(t)) != null && list.size() > 0) {
            ArrayList<PSDEListLogicDTO> psdelistlogics = new ArrayList<PSDEListLogicDTO>();
            for (PSDEListLogic pSDEListLogic : list) {
                dstItem = (PSDEListLogicDTO)PSModelServiceUtil.getInstance().getPSDEListLogicService().toDTO(pSDEListLogic);
                psdelistlogics.add((PSDEListLogicDTO)dstItem);
            }
            dto.setPsdelistlogics(psdelistlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELIST";
    }

    @Override
    public PSDEList createDomain() {
        return new PSDEList();
    }

    @Override
    public PSDEListDTO createDTO() {
        return new PSDEListDTO();
    }
}

