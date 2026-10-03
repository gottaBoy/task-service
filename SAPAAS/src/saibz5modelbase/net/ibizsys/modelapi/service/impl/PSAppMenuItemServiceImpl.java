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
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSAppMenuItem;
import net.ibizsys.modelapi.dto.PSAppFuncDTO;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppMenuItemDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.service.IPSAppMenuItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppMenuItemServiceImpl
extends PSModelServiceImplBase<PSAppMenuItem, PSAppMenuItemDTO>
implements IPSAppMenuItemService {
    private static final Log log = LogFactory.getLog(PSAppMenuItemServiceImpl.class);

    @Override
    public List<PSAppMenuItem> listByPSAppMenuItem(PSAppMenuItem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppMenuItem get(PSAppMenuItem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppMenuItem> list = this.listByPSAppMenuItem(parent);
        if (list != null) {
            for (PSAppMenuItem item : list) {
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
    public List<PSAppMenuItemDTO> listDTOByPSAppMenuItem(String strParentKey) throws Exception {
        PSAppMenuItem psappmenuitem = (PSAppMenuItem)PSModelServiceUtil.getInstance().getPSAppMenuItemService().get(strParentKey);
        List<PSAppMenuItem> list = this.listByPSAppMenuItem(psappmenuitem);
        if (list != null) {
            ArrayList<PSAppMenuItemDTO> dtoList = new ArrayList<PSAppMenuItemDTO>();
            for (PSAppMenuItem item : list) {
                PSAppMenuItemDTO dto = (PSAppMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSAppMenuItem> listByPSAppMenu(PSAppMenu parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppMenuItem get(PSAppMenu parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppMenuItem> list = this.listByPSAppMenu(parent);
        if (list != null) {
            for (PSAppMenuItem item : list) {
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
    public List<PSAppMenuItemDTO> listDTOByPSAppMenu(String strParentKey) throws Exception {
        PSAppMenu psappmenu = (PSAppMenu)PSModelServiceUtil.getInstance().getPSAppMenuService().get(strParentKey);
        List<PSAppMenuItem> list = this.listByPSAppMenu(psappmenu);
        if (list != null) {
            ArrayList<PSAppMenuItemDTO> dtoList = new ArrayList<PSAppMenuItemDTO>();
            for (PSAppMenuItem item : list) {
                PSAppMenuItemDTO dto = (PSAppMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppMenuItem> onListAll() throws Exception {
        ArrayList<PSAppMenuItem> list = new ArrayList<PSAppMenuItem>();
        List<PSAppMenu> psappmenus = PSModelServiceUtil.getInstance().getPSAppMenuService().listAll();
        if (psappmenus != null) {
            for (PSAppMenu parent : psappmenus) {
                List<PSAppMenuItem> items = this.listByPSAppMenu(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSAppMenuItem> alllist = new ArrayList<PSAppMenuItem>();
        alllist.addAll(list);
        for (PSAppMenuItem item : list) {
            List<PSAppMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppMenuItem> listAllChild(PSAppMenuItem parent) throws Exception {
        List<PSAppMenuItem> list = this.listByPSAppMenuItem(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSAppMenuItem> alllist = new ArrayList<PSAppMenuItem>();
        alllist.addAll(list);
        for (PSAppMenuItem item : list) {
            List<PSAppMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppMenuItem> listAllByPSAppMenu(PSAppMenu parent) throws Exception {
        List<PSAppMenuItem> list = this.listByPSAppMenu(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSAppMenuItem> alllist = new ArrayList<PSAppMenuItem>();
        alllist.addAll(list);
        for (PSAppMenuItem item : list) {
            List<PSAppMenuItem> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppMenuItemDTO> listAllDTOByPSAppMenu(String strParentKey) throws Exception {
        PSAppMenu psappmenu = (PSAppMenu)PSModelServiceUtil.getInstance().getPSAppMenuService().get(strParentKey);
        List<PSAppMenuItem> list = this.listAllByPSAppMenu(psappmenu);
        if (list != null) {
            ArrayList<PSAppMenuItemDTO> dtoList = new ArrayList<PSAppMenuItemDTO>();
            for (PSAppMenuItem item : list) {
                PSAppMenuItemDTO dto = (PSAppMenuItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSAppMenuItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppMenuItem item;
        PSAppMenuItem item2;
        PSAppMenuItem psappmenuitem = (PSAppMenuItem)PSModelServiceUtil.getInstance().getPSAppMenuItemService().get(strParentKey, true);
        if (psappmenuitem != null && (item2 = this.get(psappmenuitem, strCurKey, true)) != null) {
            return item2;
        }
        PSAppMenu psappmenu = (PSAppMenu)PSModelServiceUtil.getInstance().getPSAppMenuService().get(strParentKey, true);
        if (psappmenu != null && (item = this.get(psappmenu, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppMenuItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppMenuItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSAppMenuItemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppMenuItemService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSAppMenuId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppMenuService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppMenuItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppMenuItemName())) {
            return et.getPSAppMenuItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppMenuItemDTO dto, PSAppMenuItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppMenuItemId(t.getId().replace("/", "."));
        }
        if (t.getActionLevel() != null || !bIgnoreNull) {
            dto.setActionLevel(t.getActionLevel());
        }
        if (t.getAMItemType() != null || !bIgnoreNull) {
            dto.setAMItemType(t.getAMItemType());
        }
        if (t.getBL_Pos() != null || !bIgnoreNull) {
            dto.setBL_Pos(t.getBL_Pos());
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
        if (t.getCol_LG() != null || !bIgnoreNull) {
            dto.setCol_LG(t.getCol_LG());
        }
        if (t.getCol_LG_OS() != null || !bIgnoreNull) {
            dto.setCol_LG_OS(t.getCol_LG_OS());
        }
        if (t.getCol_MD() != null || !bIgnoreNull) {
            dto.setCol_MD(t.getCol_MD());
        }
        if (t.getCol_MD_OS() != null || !bIgnoreNull) {
            dto.setCol_MD_OS(t.getCol_MD_OS());
        }
        if (t.getCol_SM() != null || !bIgnoreNull) {
            dto.setCol_SM(t.getCol_SM());
        }
        if (t.getCol_SM_OS() != null || !bIgnoreNull) {
            dto.setCol_SM_OS(t.getCol_SM_OS());
        }
        if (t.getCol_XS() != null || !bIgnoreNull) {
            dto.setCol_XS(t.getCol_XS());
        }
        if (t.getCol_XS_OS() != null || !bIgnoreNull) {
            dto.setCol_XS_OS(t.getCol_XS_OS());
        }
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
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
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getDisableClose() != null || !bIgnoreNull) {
            dto.setDisableClose(t.getDisableClose());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getEnableMode() != null || !bIgnoreNull) {
            dto.setEnableMode(t.getEnableMode());
        }
        if (t.getExpand() != null || !bIgnoreNull) {
            dto.setExpand(t.getExpand());
        }
        if (t.getFillerObj() != null || !bIgnoreNull) {
            dto.setFillerObj(t.getFillerObj());
        }
        if (t.getFlexAlign() != null || !bIgnoreNull) {
            dto.setFlexAlign(t.getFlexAlign());
        }
        if (t.getFlexDir() != null || !bIgnoreNull) {
            dto.setFlexDir(t.getFlexDir());
        }
        if (t.getFlexGrow() != null || !bIgnoreNull) {
            dto.setFlexGrow(t.getFlexGrow());
        }
        if (t.getFlexVAlign() != null || !bIgnoreNull) {
            dto.setFlexVAlign(t.getFlexVAlign());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHiddenItem() != null || !bIgnoreNull) {
            dto.setHiddenItem(t.getHiddenItem());
        }
        if (t.getHIdeSideBar() != null || !bIgnoreNull) {
            dto.setHIdeSideBar(t.getHIdeSideBar());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getHtmlPageUrl() != null || !bIgnoreNull) {
            dto.setHtmlPageUrl(t.getHtmlPageUrl());
        }
        if (t.getInformTag() != null || !bIgnoreNull) {
            dto.setInformTag(t.getInformTag());
        }
        if (t.getInformTag2() != null || !bIgnoreNull) {
            dto.setInformTag2(t.getInformTag2());
        }
        if (t.getItemStyle() != null || !bIgnoreNull) {
            dto.setItemStyle(t.getItemStyle());
        }
        if (t.getItemStyleText() != null || !bIgnoreNull) {
            dto.setItemStyleText(t.getItemStyleText());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMenuItemState() != null || !bIgnoreNull) {
            dto.setMenuItemState(t.getMenuItemState());
        }
        if (t.getOpenDefault() != null || !bIgnoreNull) {
            dto.setOpenDefault(t.getOpenDefault());
        }
        if (t.getOpenPSAppViewId() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewId(t.getOpenPSAppViewId());
        }
        if (t.getOpenPSAppViewName() != null || !bIgnoreNull) {
            dto.setOpenPSAppViewName(t.getOpenPSAppViewName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSAppMenuItemId() != null || !bIgnoreNull) {
            dto.setPPSAppMenuItemId(t.getPPSAppMenuItemId());
        }
        if (t.getPPSAppMenuItemName() != null || !bIgnoreNull) {
            dto.setPPSAppMenuItemName(t.getPPSAppMenuItemName());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPredefinedTypeText() != null || !bIgnoreNull) {
            dto.setPredefinedTypeText(t.getPredefinedTypeText());
        }
        if (t.getPSAppFuncId() != null || !bIgnoreNull) {
            dto.setPSAppFuncId(t.getPSAppFuncId());
        }
        if (t.getPSAppFuncName() != null || !bIgnoreNull) {
            dto.setPSAppFuncName(t.getPSAppFuncName());
        }
        if (t.getPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEId(t.getPSAppLocalDEId());
        }
        if (t.getPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEName(t.getPSAppLocalDEName());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuItemName() != null || !bIgnoreNull) {
            dto.setPSAppMenuItemName(t.getPSAppMenuItemName());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
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
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
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
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getRefPSAppMenuId() != null || !bIgnoreNull) {
            dto.setRefPSAppMenuId(t.getRefPSAppMenuId());
        }
        if (t.getRefPSAppMenuName() != null || !bIgnoreNull) {
            dto.setRefPSAppMenuName(t.getRefPSAppMenuName());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getTitleBarCloseMode() != null || !bIgnoreNull) {
            dto.setTitleBarCloseMode(t.getTitleBarCloseMode());
        }
        if (t.getToggleMode() != null || !bIgnoreNull) {
            dto.setToggleMode(t.getToggleMode());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
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
        if (StringUtils.hasLength((String)dto.getPPSAppMenuItemId())) {
            dto.setPPSAppMenuItemId(this.getRealPSModelId(t, dto.getPPSAppMenuItemId()).replace("/", "."));
        }
        if ("PSAPPMENUITEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSAppMenuItemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppFuncId())) {
            dto.setPSAppFuncId(this.getRealPSModelId(t, dto.getPSAppFuncId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            dto.setPSAppLocalDEId(this.getRealPSModelId(t, dto.getPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if ("PSAPPMENU".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppMenuId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSAppMenuId())) {
            dto.setRefPSAppMenuId(this.getRealPSModelId(t, dto.getRefPSAppMenuId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPPSAppMenuItemId())) {
            linkDTO = (PSAppMenuItemDTO)PSModelServiceUtil.getInstance().getPSAppMenuItemService().getDTO(dto.getPPSAppMenuItemId());
            dto.setPPSAppMenuItemName(((PSAppMenuItemDTO)linkDTO).getPSAppMenuItemName());
        } else {
            dto.setPPSAppMenuItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppFuncId())) {
            linkDTO = (PSAppFuncDTO)PSModelServiceUtil.getInstance().getPSAppFuncService().getDTO(dto.getPSAppFuncId());
            dto.setPSAppFuncName(((PSAppFuncDTO)linkDTO).getPSAppFuncName());
        } else {
            dto.setPSAppFuncName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPSAppLocalDEId());
            dto.setPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
            dto.setPSDEId(((PSAppLocalDEDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSAppLocalDEName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
            dto.setPSSysAppId(((PSAppMenuDTO)linkDTO).getPSSysAppId());
        } else {
            dto.setPSAppMenuName(null);
            dto.setPSSysAppId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
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
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            linkDTO = (PSSysUniResDTO)PSModelServiceUtil.getInstance().getPSSysUniResService().getDTO(dto.getPSSysUniResId());
            dto.setPSSysUniResName(((PSSysUniResDTO)linkDTO).getPSSysUniResName());
        } else {
            dto.setPSSysUniResName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getRefPSAppMenuId());
            dto.setRefPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setRefPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        List<PSAppMenuItem> list = PSModelServiceUtil.getInstance().getPSAppMenuItemService().listByPSAppMenuItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSAppMenuItemDTO> psappmenuitems = new ArrayList<PSAppMenuItemDTO>();
            for (PSAppMenuItem item : list) {
                PSAppMenuItemDTO dstItem = (PSAppMenuItemDTO)PSModelServiceUtil.getInstance().getPSAppMenuItemService().toDTO(item);
                psappmenuitems.add(dstItem);
            }
            dto.setPsappmenuitems(psappmenuitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPMENUITEM";
    }

    @Override
    public PSAppMenuItem createDomain() {
        return new PSAppMenuItem();
    }

    @Override
    public PSAppMenuItemDTO createDTO() {
        return new PSAppMenuItemDTO();
    }
}

