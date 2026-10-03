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
import net.ibizsys.modelapi.domain.PSDEDataView;
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDEListItem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEDataViewDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDEListItemDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEListItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEListItemServiceImpl
extends PSModelServiceImplBase<PSDEListItem, PSDEListItemDTO>
implements IPSDEListItemService {
    private static final Log log = LogFactory.getLog(PSDEListItemServiceImpl.class);

    @Override
    public List<PSDEListItem> listByPSDEDataView(PSDEDataView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEListItem get(PSDEDataView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEListItem> list = this.listByPSDEDataView(parent);
        if (list != null) {
            for (PSDEListItem item : list) {
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
    public List<PSDEListItemDTO> listDTOByPSDEDataView(String strParentKey) throws Exception {
        PSDEDataView psdedataview = (PSDEDataView)PSModelServiceUtil.getInstance().getPSDEDataViewService().get(strParentKey);
        List<PSDEListItem> list = this.listByPSDEDataView(psdedataview);
        if (list != null) {
            ArrayList<PSDEListItemDTO> dtoList = new ArrayList<PSDEListItemDTO>();
            for (PSDEListItem item : list) {
                PSDEListItemDTO dto = (PSDEListItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEListItem> listByPSDEList(PSDEList parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEListItem get(PSDEList parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEListItem> list = this.listByPSDEList(parent);
        if (list != null) {
            for (PSDEListItem item : list) {
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
    public List<PSDEListItemDTO> listDTOByPSDEList(String strParentKey) throws Exception {
        PSDEList psdelist = (PSDEList)PSModelServiceUtil.getInstance().getPSDEListService().get(strParentKey);
        List<PSDEListItem> list = this.listByPSDEList(psdelist);
        if (list != null) {
            ArrayList<PSDEListItemDTO> dtoList = new ArrayList<PSDEListItemDTO>();
            for (PSDEListItem item : list) {
                PSDEListItemDTO dto = (PSDEListItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEListItem> onListAll() throws Exception {
        List<PSDEList> psdelists;
        ArrayList<PSDEListItem> list = new ArrayList<PSDEListItem>();
        List<PSDEDataView> psdedataviews = PSModelServiceUtil.getInstance().getPSDEDataViewService().listAll();
        if (psdedataviews != null) {
            for (PSDEDataView parent : psdedataviews) {
                List<PSDEListItem> items = this.listByPSDEDataView(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((psdelists = PSModelServiceUtil.getInstance().getPSDEListService().listAll()) != null) {
            for (PSDEList parent : psdelists) {
                List<PSDEListItem> items = this.listByPSDEList(parent);
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
    protected PSDEListItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEListItem item;
        PSDEListItem item2;
        PSDEDataView psdedataview = (PSDEDataView)PSModelServiceUtil.getInstance().getPSDEDataViewService().get(strParentKey, true);
        if (psdedataview != null && (item2 = this.get(psdedataview, strCurKey, true)) != null) {
            return item2;
        }
        PSDEList psdelist = (PSDEList)PSModelServiceUtil.getInstance().getPSDEListService().get(strParentKey, true);
        if (psdelist != null && (item = this.get(psdelist, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEListItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEListItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDataViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataViewService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEListId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEListService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEListItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEListItemName())) {
            return et.getPSDEListItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEListItemDTO dto, PSDEListItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEListItemId(t.getId().replace("/", "."));
        }
        if (t.getAlign() != null || !bIgnoreNull) {
            dto.setAlign(t.getAlign());
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
        if (t.getCLConvertMode() != null || !bIgnoreNull) {
            dto.setCLConvertMode(t.getCLConvertMode());
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
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDataItems() != null || !bIgnoreNull) {
            dto.setDataItems(t.getDataItems());
        }
        if (t.getDataViewPSDEId() != null || !bIgnoreNull) {
            dto.setDataViewPSDEId(t.getDataViewPSDEId());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableItemPriv() != null || !bIgnoreNull) {
            dto.setEnableItemPriv(t.getEnableItemPriv());
        }
        if (t.getGroupItem() != null || !bIgnoreNull) {
            dto.setGroupItem(t.getGroupItem());
        }
        if (t.getItemType() != null || !bIgnoreNull) {
            dto.setItemType(t.getItemType());
        }
        if (t.getLCRPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setLCRPSSysPFPluginId(t.getLCRPSSysPFPluginId());
        }
        if (t.getLCRPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setLCRPSSysPFPluginName(t.getLCRPSSysPFPluginName());
        }
        if (t.getListPSDEId() != null || !bIgnoreNull) {
            dto.setListPSDEId(t.getListPSDEId());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNoSort() != null || !bIgnoreNull) {
            dto.setNoSort(t.getNoSort());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPreventXSS() != null || !bIgnoreNull) {
            dto.setPreventXSS(t.getPreventXSS());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEDataViewId() != null || !bIgnoreNull) {
            dto.setPSDEDataViewId(t.getPSDEDataViewId());
        }
        if (t.getPSDEDataViewName() != null || !bIgnoreNull) {
            dto.setPSDEDataViewName(t.getPSDEDataViewName());
        }
        if (t.getPSDEListId() != null || !bIgnoreNull) {
            dto.setPSDEListId(t.getPSDEListId());
        }
        if (t.getPSDEListItemName() != null || !bIgnoreNull) {
            dto.setPSDEListItemName(t.getPSDEListItemName());
        }
        if (t.getPSDEListName() != null || !bIgnoreNull) {
            dto.setPSDEListName(t.getPSDEListName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
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
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthUnit() != null || !bIgnoreNull) {
            dto.setWidthUnit(t.getWidthUnit());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLCRPSSysPFPluginId())) {
            dto.setLCRPSSysPFPluginId(this.getRealPSModelId(t, dto.getLCRPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataViewId())) {
            dto.setPSDEDataViewId(this.getRealPSModelId(t, dto.getPSDEDataViewId()).replace("/", "."));
        }
        if ("PSDEDATAVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDataViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            dto.setPSDEListId(this.getRealPSModelId(t, dto.getPSDEListId()).replace("/", "."));
        }
        if ("PSDELIST".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEListId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getLCRPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getLCRPSSysPFPluginId());
            dto.setLCRPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setLCRPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataViewId())) {
            linkDTO = (PSDEDataViewDTO)PSModelServiceUtil.getInstance().getPSDEDataViewService().getDTO(dto.getPSDEDataViewId(), true);
            if (linkDTO != null) {
                dto.setDataViewPSDEId(((PSDEDataViewDTO)linkDTO).getPSDEId());
                dto.setPSDEDataViewName(((PSDEDataViewDTO)linkDTO).getPSDEDataViewName());
            }
        } else {
            dto.setDataViewPSDEId(null);
            dto.setPSDEDataViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            linkDTO = (PSDEListDTO)PSModelServiceUtil.getInstance().getPSDEListService().getDTO(dto.getPSDEListId(), true);
            if (linkDTO != null) {
                dto.setListPSDEId(((PSDEListDTO)linkDTO).getPSDEId());
                dto.setPSDEListName(((PSDEListDTO)linkDTO).getPSDEListName());
            }
        } else {
            dto.setListPSDEId(null);
            dto.setPSDEListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDELISTITEM";
    }

    @Override
    public PSDEListItem createDomain() {
        return new PSDEListItem();
    }

    @Override
    public PSDEListItemDTO createDTO() {
        return new PSDEListItemDTO();
    }
}

