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
import net.ibizsys.modelapi.domain.PSDETBItem;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDETBItemDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.service.IPSDETBItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETBItemServiceImpl
extends PSModelServiceImplBase<PSDETBItem, PSDETBItemDTO>
implements IPSDETBItemService {
    private static final Log log = LogFactory.getLog(PSDETBItemServiceImpl.class);

    @Override
    public List<PSDETBItem> listByPSDETBItem(PSDETBItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETBItem get(PSDETBItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETBItem> list = this.listByPSDETBItem(parent);
        if (list != null) {
            for (PSDETBItem item : list) {
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
    public List<PSDETBItemDTO> listDTOByPSDETBItem(String strParentKey) throws Exception {
        PSDETBItem psdetbitem = (PSDETBItem)PSModelServiceUtil.getInstance().getPSDETBItemService().get(strParentKey);
        List<PSDETBItem> list = this.listByPSDETBItem(psdetbitem);
        if (list != null) {
            ArrayList<PSDETBItemDTO> dtoList = new ArrayList<PSDETBItemDTO>();
            for (PSDETBItem item : list) {
                PSDETBItemDTO dto = (PSDETBItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDETBItem> listByPSDEToolbar(PSDEToolbar parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETBItem get(PSDEToolbar parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETBItem> list = this.listByPSDEToolbar(parent);
        if (list != null) {
            for (PSDETBItem item : list) {
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
    public List<PSDETBItemDTO> listDTOByPSDEToolbar(String strParentKey) throws Exception {
        PSDEToolbar psdetoolbar = (PSDEToolbar)PSModelServiceUtil.getInstance().getPSDEToolbarService().get(strParentKey);
        List<PSDETBItem> list = this.listByPSDEToolbar(psdetoolbar);
        if (list != null) {
            ArrayList<PSDETBItemDTO> dtoList = new ArrayList<PSDETBItemDTO>();
            for (PSDETBItem item : list) {
                PSDETBItemDTO dto = (PSDETBItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETBItem> onListAll() throws Exception {
        ArrayList<PSDETBItem> list = new ArrayList<PSDETBItem>();
        List<PSDEToolbar> psdetoolbars = PSModelServiceUtil.getInstance().getPSDEToolbarService().listAll();
        if (psdetoolbars != null) {
            for (PSDEToolbar parent : psdetoolbars) {
                List<PSDETBItem> items = this.listByPSDEToolbar(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDETBItem> alllist = new ArrayList<PSDETBItem>();
        alllist.addAll(list);
        for (PSDETBItem item : list) {
            List<PSDETBItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDETBItem> listAllChild(PSDETBItem parent) throws Exception {
        List<PSDETBItem> list = this.listByPSDETBItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDETBItem> alllist = new ArrayList<PSDETBItem>();
        alllist.addAll(list);
        for (PSDETBItem item : list) {
            List<PSDETBItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDETBItem> listAllByPSDEToolbar(PSDEToolbar parent) throws Exception {
        List<PSDETBItem> list = this.listByPSDEToolbar(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDETBItem> alllist = new ArrayList<PSDETBItem>();
        alllist.addAll(list);
        for (PSDETBItem item : list) {
            List<PSDETBItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDETBItemDTO> listAllDTOByPSDEToolbar(String strParentKey) throws Exception {
        PSDEToolbar psdetoolbar = (PSDEToolbar)PSModelServiceUtil.getInstance().getPSDEToolbarService().get(strParentKey);
        List<PSDETBItem> list = this.listAllByPSDEToolbar(psdetoolbar);
        if (list != null) {
            ArrayList<PSDETBItemDTO> dtoList = new ArrayList<PSDETBItemDTO>();
            for (PSDETBItem item : list) {
                PSDETBItemDTO dto = (PSDETBItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDETBItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETBItem item;
        PSDETBItem item2;
        PSDETBItem psdetbitem = (PSDETBItem)PSModelServiceUtil.getInstance().getPSDETBItemService().get(strParentKey, true);
        if (psdetbitem != null && (item2 = this.get(psdetbitem, strCurKey, true)) != null) {
            return item2;
        }
        PSDEToolbar psdetoolbar = (PSDEToolbar)PSModelServiceUtil.getInstance().getPSDEToolbarService().get(strParentKey, true);
        if (psdetoolbar != null && (item = this.get(psdetoolbar, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETBItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETBItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDETBItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETBItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEToolbarId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEToolbarService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETBItem et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETBItemDTO dto, PSDETBItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETBItemId(t.getId().replace("/", "."));
        }
        if (t.getActionLevel() != null || !bIgnoreNull) {
            dto.setActionLevel(t.getActionLevel());
        }
        if (t.getBorderStyle() != null || !bIgnoreNull) {
            dto.setBorderStyle(t.getBorderStyle());
        }
        if (t.getBtnActionType() != null || !bIgnoreNull) {
            dto.setBtnActionType(t.getBtnActionType());
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
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
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
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDEUACap() != null || !bIgnoreNull) {
            dto.setDEUACap(t.getDEUACap());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getGroupExtractMode() != null || !bIgnoreNull) {
            dto.setGroupExtractMode(t.getGroupExtractMode());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHiddenItem() != null || !bIgnoreNull) {
            dto.setHiddenItem(t.getHiddenItem());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getHtmlPageUrl() != null || !bIgnoreNull) {
            dto.setHtmlPageUrl(t.getHtmlPageUrl());
        }
        if (t.getItemStyle() != null || !bIgnoreNull) {
            dto.setItemStyle(t.getItemStyle());
        }
        if (t.getItemStyleText() != null || !bIgnoreNull) {
            dto.setItemStyleText(t.getItemStyleText());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNoPrivDM() != null || !bIgnoreNull) {
            dto.setNoPrivDM(t.getNoPrivDM());
        }
        if (t.getOpenPSAppViewId() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewId(t.getOpenPSAppViewId());
        }
        if (t.getOpenPSAppViewName() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewName(t.getOpenPSAppViewName());
        }
        if (t.getOpenPSDEViewId() != null || !bIgnoreNull) {
            dto.setOpenPSDEViewId(t.getOpenPSDEViewId());
        }
        if (t.getOpenPSDEViewName() != null || !bIgnoreNull) {
            dto.setOpenPSDEViewName(t.getOpenPSDEViewName());
        }
        if (t.getOpenPSSysPDTViewId() != null || !bIgnoreNull) {
            dto.setOpenPSSysPDTViewId(t.getOpenPSSysPDTViewId());
        }
        if (t.getOpenPSSysPDTViewName() != null || !bIgnoreNull) {
            dto.setOpenPSSysPDTViewName(t.getOpenPSSysPDTViewName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSDETBItemId() != null || !bIgnoreNull) {
            dto.setPPSDETBItemId(t.getPPSDETBItemId());
        }
        if (t.getPPSDETBItemName() != null || !bIgnoreNull) {
            dto.setPPSDETBItemName(t.getPPSDETBItemName());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
        }
        if (t.getPSDETBItemName() != null || !bIgnoreNull) {
            dto.setPSDETBItemName(t.getPSDETBItemName());
        }
        if (t.getPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setPSDEToolbarId(t.getPSDEToolbarId());
        }
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
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
        if (t.getPSSysResourceId() != null || !bIgnoreNull) {
            dto.setPSSysResourceId(t.getPSSysResourceId());
        }
        if (t.getPSSysResourceName() != null || !bIgnoreNull) {
            dto.setPSSysResourceName(t.getPSSysResourceName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getShowMode() != null || !bIgnoreNull) {
            dto.setShowMode(t.getShowMode());
        }
        if (t.getSpanFlag() != null || !bIgnoreNull) {
            dto.setSpanFlag(t.getSpanFlag());
        }
        if (t.getTBItemType() != null || !bIgnoreNull) {
            dto.setTBItemType(t.getTBItemType());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getToggleMode() != null || !bIgnoreNull) {
            dto.setToggleMode(t.getToggleMode());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
        }
        if (t.getUIActionParams() != null || !bIgnoreNull) {
            dto.setUIActionParams(t.getUIActionParams());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
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
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSAppViewId())) {
            dto.setOpenPSAppViewId(this.getRealPSModelId(t, dto.getOpenPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSDEViewId())) {
            dto.setOpenPSDEViewId(this.getRealPSModelId(t, dto.getOpenPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOpenPSSysPDTViewId())) {
            dto.setOpenPSSysPDTViewId(this.getRealPSModelId(t, dto.getOpenPSSysPDTViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDETBItemId())) {
            dto.setPPSDETBItemId(this.getRealPSModelId(t, dto.getPPSDETBItemId()).replace("/", "."));
        }
        if ("PSDETBITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDETBItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            dto.setPSDEToolbarId(this.getRealPSModelId(t, dto.getPSDEToolbarId()).replace("/", "."));
        }
        if ("PSDETOOLBAR".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEToolbarId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            dto.setPSSysResourceId(this.getRealPSModelId(t, dto.getPSSysResourceId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getOpenPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getOpenPSAppViewId());
            dto.setOpenPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setOpenPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getOpenPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getOpenPSDEViewId());
            dto.setOpenPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setOpenPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getOpenPSSysPDTViewId())) {
            linkDTO = (PSSysPDTViewDTO)PSModelServiceUtil.getInstance().getPSSysPDTViewService().getDTO(dto.getOpenPSSysPDTViewId());
            dto.setOpenPSSysPDTViewName(((PSSysPDTViewDTO)linkDTO).getPSSysPDTViewName());
        } else {
            dto.setOpenPSSysPDTViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDETBItemId())) {
            linkDTO = (PSDETBItemDTO)PSModelServiceUtil.getInstance().getPSDETBItemService().getDTO(dto.getPPSDETBItemId());
            dto.setPPSDETBItemName(((PSDETBItemDTO)linkDTO).getPSDETBItemName());
        } else {
            dto.setPPSDETBItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getPSDEToolbarId());
            dto.setPSDEId(((PSDEToolbarDTO)linkDTO).getPSDEId());
            dto.setPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
            dto.setPSSystemId(((PSDEToolbarDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEToolbarName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setDEUACap(((PSDEUIActionDTO)linkDTO).getCaption());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setDEUACap(null);
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getPSSysResourceId());
            dto.setPSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setPSSysResourceName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        List<PSDETBItem> list = PSModelServiceUtil.getInstance().getPSDETBItemService().listByPSDETBItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDETBItemDTO> psdetbitems = new ArrayList<PSDETBItemDTO>();
            for (PSDETBItem item : list) {
                PSDETBItemDTO dstItem = (PSDETBItemDTO)PSModelServiceUtil.getInstance().getPSDETBItemService().toDTO(item);
                psdetbitems.add(dstItem);
            }
            dto.setPsdetbitems(psdetbitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETBITEM";
    }

    @Override
    public PSDETBItem createDomain() {
        return new PSDETBItem();
    }

    @Override
    public PSDETBItemDTO createDTO() {
        return new PSDETBItemDTO();
    }
}

