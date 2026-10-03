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
import net.ibizsys.modelapi.domain.PSAppPVPart;
import net.ibizsys.modelapi.domain.PSAppPortalView;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppPVPartDTO;
import net.ibizsys.modelapi.dto.PSAppPortalViewDTO;
import net.ibizsys.modelapi.dto.PSAppUtilViewDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysPortletDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.service.IPSAppPVPartService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppPVPartServiceImpl
extends PSModelServiceImplBase<PSAppPVPart, PSAppPVPartDTO>
implements IPSAppPVPartService {
    private static final Log log = LogFactory.getLog(PSAppPVPartServiceImpl.class);

    @Override
    public List<PSAppPVPart> listByPSAppPVPart(PSAppPVPart parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppPVPart get(PSAppPVPart parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppPVPart> list = this.listByPSAppPVPart(parent);
        if (list != null) {
            for (PSAppPVPart item : list) {
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
    public List<PSAppPVPartDTO> listDTOByPSAppPVPart(String strParentKey) throws Exception {
        PSAppPVPart psapppvpart = (PSAppPVPart)PSModelServiceUtil.getInstance().getPSAppPVPartService().get(strParentKey);
        List<PSAppPVPart> list = this.listByPSAppPVPart(psapppvpart);
        if (list != null) {
            ArrayList<PSAppPVPartDTO> dtoList = new ArrayList<PSAppPVPartDTO>();
            for (PSAppPVPart item : list) {
                PSAppPVPartDTO dto = (PSAppPVPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSAppPVPart> listByPSAppPortalView(PSAppPortalView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppPVPart get(PSAppPortalView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppPVPart> list = this.listByPSAppPortalView(parent);
        if (list != null) {
            for (PSAppPVPart item : list) {
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
    public List<PSAppPVPartDTO> listDTOByPSAppPortalView(String strParentKey) throws Exception {
        PSAppPortalView psappportalview = (PSAppPortalView)PSModelServiceUtil.getInstance().getPSAppPortalViewService().get(strParentKey);
        List<PSAppPVPart> list = this.listByPSAppPortalView(psappportalview);
        if (list != null) {
            ArrayList<PSAppPVPartDTO> dtoList = new ArrayList<PSAppPVPartDTO>();
            for (PSAppPVPart item : list) {
                PSAppPVPartDTO dto = (PSAppPVPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppPVPart> onListAll() throws Exception {
        ArrayList<PSAppPVPart> list = new ArrayList<PSAppPVPart>();
        List<PSAppPortalView> psappportalviews = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listAll();
        if (psappportalviews != null) {
            for (PSAppPortalView parent : psappportalviews) {
                List<PSAppPVPart> items = this.listByPSAppPortalView(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSAppPVPart> alllist = new ArrayList<PSAppPVPart>();
        alllist.addAll(list);
        for (PSAppPVPart item : list) {
            List<PSAppPVPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppPVPart> listAllChild(PSAppPVPart parent) throws Exception {
        List<PSAppPVPart> list = this.listByPSAppPVPart(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSAppPVPart> alllist = new ArrayList<PSAppPVPart>();
        alllist.addAll(list);
        for (PSAppPVPart item : list) {
            List<PSAppPVPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppPVPart> listAllByPSAppPortalView(PSAppPortalView parent) throws Exception {
        List<PSAppPVPart> list = this.listByPSAppPortalView(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSAppPVPart> alllist = new ArrayList<PSAppPVPart>();
        alllist.addAll(list);
        for (PSAppPVPart item : list) {
            List<PSAppPVPart> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSAppPVPartDTO> listAllDTOByPSAppPortalView(String strParentKey) throws Exception {
        PSAppPortalView psappportalview = (PSAppPortalView)PSModelServiceUtil.getInstance().getPSAppPortalViewService().get(strParentKey);
        List<PSAppPVPart> list = this.listAllByPSAppPortalView(psappportalview);
        if (list != null) {
            ArrayList<PSAppPVPartDTO> dtoList = new ArrayList<PSAppPVPartDTO>();
            for (PSAppPVPart item : list) {
                PSAppPVPartDTO dto = (PSAppPVPartDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSAppPVPart onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppPVPart item;
        PSAppPVPart item2;
        PSAppPVPart psapppvpart = (PSAppPVPart)PSModelServiceUtil.getInstance().getPSAppPVPartService().get(strParentKey, true);
        if (psapppvpart != null && (item2 = this.get(psapppvpart, strCurKey, true)) != null) {
            return item2;
        }
        PSAppPortalView psappportalview = (PSAppPortalView)PSModelServiceUtil.getInstance().getPSAppPortalViewService().get(strParentKey, true);
        if (psappportalview != null && (item = this.get(psappportalview, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppPVPart)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppPVPartDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSAppPVPartId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppPVPartService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSAppPortalViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppPortalViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppPVPart et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppPVPartName())) {
            return et.getPSAppPVPartName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppPVPartDTO dto, PSAppPVPart t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppPVPartId(t.getId().replace("/", "."));
        }
        if (t.getAMPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setAMPSSysPFPluginId(t.getAMPSSysPFPluginId());
        }
        if (t.getAMPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setAMPSSysPFPluginName(t.getAMPSSysPFPluginName());
        }
        if (t.getBL_Pos() != null || !bIgnoreNull) {
            dto.setBL_Pos(t.getBL_Pos());
        }
        if (t.getColId() != null || !bIgnoreNull) {
            dto.setColId(t.getColId());
        }
        if (t.getColSpan() != null || !bIgnoreNull) {
            dto.setColSpan(t.getColSpan());
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
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getEnableCustomMenu() != null || !bIgnoreNull) {
            dto.setEnableCustomMenu(t.getEnableCustomMenu());
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
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMenuPSAppUtilViewId() != null || !bIgnoreNull) {
            dto.setMenuPSAppUtilViewId(t.getMenuPSAppUtilViewId());
        }
        if (t.getMenuPSAppUtilViewName() != null || !bIgnoreNull) {
            dto.setMenuPSAppUtilViewName(t.getMenuPSAppUtilViewName());
        }
        if (t.getMOBAMStyle() != null || !bIgnoreNull) {
            dto.setMOBAMStyle(t.getMOBAMStyle());
        }
        if (t.getNewRowMode() != null || !bIgnoreNull) {
            dto.setNewRowMode(t.getNewRowMode());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPartParams() != null || !bIgnoreNull) {
            dto.setPartParams(t.getPartParams());
        }
        if (t.getPartStyle() != null || !bIgnoreNull) {
            dto.setPartStyle(t.getPartStyle());
        }
        if (t.getPortletType() != null || !bIgnoreNull) {
            dto.setPortletType(t.getPortletType());
        }
        if (t.getPosInfo() != null || !bIgnoreNull) {
            dto.setPosInfo(t.getPosInfo());
        }
        if (t.getPPSAppPVPartId() != null || !bIgnoreNull) {
            dto.setPPSAppPVPartId(t.getPPSAppPVPartId());
        }
        if (t.getPPSAppPVPartName() != null || !bIgnoreNull) {
            dto.setPPSAppPVPartName(t.getPPSAppPVPartName());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSAppPortalViewId() != null || !bIgnoreNull) {
            dto.setPSAppPortalViewId(t.getPSAppPortalViewId());
        }
        if (t.getPSAppPortalViewName() != null || !bIgnoreNull) {
            dto.setPSAppPortalViewName(t.getPSAppPortalViewName());
        }
        if (t.getPSAppPVPartName() != null || !bIgnoreNull) {
            dto.setPSAppPVPartName(t.getPSAppPVPartName());
        }
        if (t.getPSAppViewId() != null || !bIgnoreNull) {
            dto.setPSAppViewId(t.getPSAppViewId());
        }
        if (t.getPSAppViewName() != null || !bIgnoreNull) {
            dto.setPSAppViewName(t.getPSAppViewName());
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
        if (t.getPSSysPortletId() != null || !bIgnoreNull) {
            dto.setPSSysPortletId(t.getPSSysPortletId());
        }
        if (t.getPSSysPortletName() != null || !bIgnoreNull) {
            dto.setPSSysPortletName(t.getPSSysPortletName());
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
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getPVPartType() != null || !bIgnoreNull) {
            dto.setPVPartType(t.getPVPartType());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getShowTitleBar() != null || !bIgnoreNull) {
            dto.setShowTitleBar(t.getShowTitleBar());
        }
        if (t.getSwapMode() != null || !bIgnoreNull) {
            dto.setSwapMode(t.getSwapMode());
        }
        if (t.getTitle() != null || !bIgnoreNull) {
            dto.setTitle(t.getTitle());
        }
        if (t.getTitleBarCloseMode() != null || !bIgnoreNull) {
            dto.setTitleBarCloseMode(t.getTitleBarCloseMode());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
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
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getAMPSSysPFPluginId())) {
            dto.setAMPSSysPFPluginId(this.getRealPSModelId(t, dto.getAMPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMenuPSAppUtilViewId())) {
            dto.setMenuPSAppUtilViewId(this.getRealPSModelId(t, dto.getMenuPSAppUtilViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSAppPVPartId())) {
            dto.setPPSAppPVPartId(this.getRealPSModelId(t, dto.getPPSAppPVPartId()).replace("/", "."));
        }
        if ("PSAPPPVPART".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSAppPVPartId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppPortalViewId())) {
            dto.setPSAppPortalViewId(this.getRealPSModelId(t, dto.getPSAppPortalViewId()).replace("/", "."));
        }
        if ("PSAPPPORTALVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppPortalViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            dto.setPSSysPortletId(this.getRealPSModelId(t, dto.getPSSysPortletId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysResourceId())) {
            dto.setPSSysResourceId(this.getRealPSModelId(t, dto.getPSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAMPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getAMPSSysPFPluginId());
            dto.setAMPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setAMPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getMenuPSAppUtilViewId())) {
            linkDTO = (PSAppUtilViewDTO)PSModelServiceUtil.getInstance().getPSAppUtilViewService().getDTO(dto.getMenuPSAppUtilViewId());
            dto.setMenuPSAppUtilViewName(((PSAppUtilViewDTO)linkDTO).getPSAppUtilViewName());
        } else {
            dto.setMenuPSAppUtilViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSAppPVPartId())) {
            linkDTO = (PSAppPVPartDTO)PSModelServiceUtil.getInstance().getPSAppPVPartService().getDTO(dto.getPPSAppPVPartId());
            dto.setPPSAppPVPartName(((PSAppPVPartDTO)linkDTO).getPSAppPVPartName());
        } else {
            dto.setPPSAppPVPartName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppPortalViewId())) {
            linkDTO = (PSAppPortalViewDTO)PSModelServiceUtil.getInstance().getPSAppPortalViewService().getDTO(dto.getPSAppPortalViewId());
            dto.setPSAppPortalViewName(((PSAppPortalViewDTO)linkDTO).getPSAppPortalViewName());
            dto.setPSSystemId(((PSAppViewDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSAppPortalViewName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getPSAppViewId());
            dto.setPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setPSAppViewName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            linkDTO = (PSSysPortletDTO)PSModelServiceUtil.getInstance().getPSSysPortletService().getDTO(dto.getPSSysPortletId());
            dto.setPortletType(((PSSysPortletDTO)linkDTO).getPortletType());
            dto.setPSSysPortletName(((PSSysPortletDTO)linkDTO).getPSSysPortletName());
        } else {
            dto.setPortletType(null);
            dto.setPSSysPortletName(null);
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
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTitlePSLanResId());
            dto.setTitlePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTitlePSLanResName(null);
        }
        List<PSAppPVPart> list = PSModelServiceUtil.getInstance().getPSAppPVPartService().listByPSAppPVPart(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSAppPVPartDTO> psapppvparts = new ArrayList<PSAppPVPartDTO>();
            for (PSAppPVPart item : list) {
                PSAppPVPartDTO dstItem = (PSAppPVPartDTO)PSModelServiceUtil.getInstance().getPSAppPVPartService().toDTO(item);
                psapppvparts.add(dstItem);
            }
            dto.setPsapppvparts(psapppvparts);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPPVPART";
    }

    @Override
    public PSAppPVPart createDomain() {
        return new PSAppPVPart();
    }

    @Override
    public PSAppPVPartDTO createDTO() {
        return new PSAppPVPartDTO();
    }
}

