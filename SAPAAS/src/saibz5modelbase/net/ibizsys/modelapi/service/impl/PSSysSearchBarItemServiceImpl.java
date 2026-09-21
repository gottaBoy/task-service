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
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSysSearchBarItem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.dto.PSSysSearchBarDTO;
import net.ibizsys.modelapi.dto.PSSysSearchBarItemDTO;
import net.ibizsys.modelapi.service.IPSSysSearchBarItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchBarItemServiceImpl
extends PSModelServiceImplBase<PSSysSearchBarItem, PSSysSearchBarItemDTO>
implements IPSSysSearchBarItemService {
    private static final Log log = LogFactory.getLog(PSSysSearchBarItemServiceImpl.class);

    @Override
    public List<PSSysSearchBarItem> listByPSSysSearchBar(PSSysSearchBar parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchBarItem get(PSSysSearchBar parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchBarItem> list = this.listByPSSysSearchBar(parent);
        if (list != null) {
            for (PSSysSearchBarItem item : list) {
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
    public List<PSSysSearchBarItemDTO> listDTOByPSSysSearchBar(String strParentKey) throws Exception {
        PSSysSearchBar pssyssearchbar = (PSSysSearchBar)PSModelServiceUtil.getInstance().getPSSysSearchBarService().get(strParentKey);
        List<PSSysSearchBarItem> list = this.listByPSSysSearchBar(pssyssearchbar);
        if (list != null) {
            ArrayList<PSSysSearchBarItemDTO> dtoList = new ArrayList<PSSysSearchBarItemDTO>();
            for (PSSysSearchBarItem item : list) {
                PSSysSearchBarItemDTO dto = (PSSysSearchBarItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchBarItem> onListAll() throws Exception {
        ArrayList<PSSysSearchBarItem> list = new ArrayList<PSSysSearchBarItem>();
        List pssyssearchbars = PSModelServiceUtil.getInstance().getPSSysSearchBarService().listAll();
        if (pssyssearchbars != null) {
            for (PSSysSearchBar parent : pssyssearchbars) {
                List<PSSysSearchBarItem> items = this.listByPSSysSearchBar(parent);
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
    protected PSSysSearchBarItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchBarItem item;
        PSSysSearchBar pssyssearchbar = (PSSysSearchBar)PSModelServiceUtil.getInstance().getPSSysSearchBarService().get(strParentKey, true);
        if (pssyssearchbar != null && (item = this.get(pssyssearchbar, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchBarItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchBarItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSearchBarId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSearchBarService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchBarItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysSearchBarItemName())) {
            return et.getPSSysSearchBarItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchBarItemDTO dto, PSSysSearchBarItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchBarItemId(t.getId().replace("/", "."));
        }
        if (t.getAddSeparator() != null || !bIgnoreNull) {
            dto.setAddSeparator(t.getAddSeparator());
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
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCtrlDynaClass() != null || !bIgnoreNull) {
            dto.setCtrlDynaClass(t.getCtrlDynaClass());
        }
        if (t.getCtrlHeight() != null || !bIgnoreNull) {
            dto.setCtrlHeight(t.getCtrlHeight());
        }
        if (t.getCtrlPSSysCssId() != null || !bIgnoreNull) {
            dto.setCtrlPSSysCssId(t.getCtrlPSSysCssId());
        }
        if (t.getCtrlPSSysCssName() != null || !bIgnoreNull) {
            dto.setCtrlPSSysCssName(t.getCtrlPSSysCssName());
        }
        if (t.getCtrlRawCssStyle() != null || !bIgnoreNull) {
            dto.setCtrlRawCssStyle(t.getCtrlRawCssStyle());
        }
        if (t.getCtrlWidth() != null || !bIgnoreNull) {
            dto.setCtrlWidth(t.getCtrlWidth());
        }
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorTypeName() != null || !bIgnoreNull) {
            dto.setEditorTypeName(t.getEditorTypeName());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHtmlContent() != null || !bIgnoreNull) {
            dto.setHtmlContent(t.getHtmlContent());
        }
        if (t.getItemSubType() != null || !bIgnoreNull) {
            dto.setItemSubType(t.getItemSubType());
        }
        if (t.getItemTag() != null || !bIgnoreNull) {
            dto.setItemTag(t.getItemTag());
        }
        if (t.getItemTag2() != null || !bIgnoreNull) {
            dto.setItemTag2(t.getItemTag2());
        }
        if (t.getItemType() != null || !bIgnoreNull) {
            dto.setItemType(t.getItemType());
        }
        if (t.getLabelDynaClass() != null || !bIgnoreNull) {
            dto.setLabelDynaClass(t.getLabelDynaClass());
        }
        if (t.getLabelPos() != null || !bIgnoreNull) {
            dto.setLabelPos(t.getLabelPos());
        }
        if (t.getLabelPSSysCssId() != null || !bIgnoreNull) {
            dto.setLabelPSSysCssId(t.getLabelPSSysCssId());
        }
        if (t.getLabelPSSysCssName() != null || !bIgnoreNull) {
            dto.setLabelPSSysCssName(t.getLabelPSSysCssName());
        }
        if (t.getLabelRawCssStyle() != null || !bIgnoreNull) {
            dto.setLabelRawCssStyle(t.getLabelRawCssStyle());
        }
        if (t.getLabelWidth() != null || !bIgnoreNull) {
            dto.setLabelWidth(t.getLabelWidth());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPHPSLanResId() != null || !bIgnoreNull) {
            dto.setPHPSLanResId(t.getPHPSLanResId());
        }
        if (t.getPHPSLanResName() != null || !bIgnoreNull) {
            dto.setPHPSLanResName(t.getPHPSLanResName());
        }
        if (t.getPlaceHolder() != null || !bIgnoreNull) {
            dto.setPlaceHolder(t.getPlaceHolder());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFSFItemId() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemId(t.getPSDEFSFItemId());
        }
        if (t.getPSDEFSFItemName() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemName(t.getPSDEFSFItemName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysEditorStyleId() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleId(t.getPSSysEditorStyleId());
        }
        if (t.getPSSysEditorStyleName() != null || !bIgnoreNull) {
            dto.setPSSysEditorStyleName(t.getPSSysEditorStyleName());
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
        if (t.getPSSysSearchBarId() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarId(t.getPSSysSearchBarId());
        }
        if (t.getPSSysSearchBarItemName() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarItemName(t.getPSSysSearchBarItemName());
        }
        if (t.getPSSysSearchBarName() != null || !bIgnoreNull) {
            dto.setPSSysSearchBarName(t.getPSSysSearchBarName());
        }
        if (t.getRawContent() != null || !bIgnoreNull) {
            dto.setRawContent(t.getRawContent());
        }
        if (t.getRawCssStyle() != null || !bIgnoreNull) {
            dto.setRawCssStyle(t.getRawCssStyle());
        }
        if (t.getRawServiceMethod() != null || !bIgnoreNull) {
            dto.setRawServiceMethod(t.getRawServiceMethod());
        }
        if (t.getRawServiceUrl() != null || !bIgnoreNull) {
            dto.setRawServiceUrl(t.getRawServiceUrl());
        }
        if (t.getShowCaption() != null || !bIgnoreNull) {
            dto.setShowCaption(t.getShowCaption());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
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
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
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
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCtrlPSSysCssId())) {
            dto.setCtrlPSSysCssId(this.getRealPSModelId(t, dto.getCtrlPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            dto.setLabelPSSysCssId(this.getRealPSModelId(t, dto.getLabelPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            dto.setPHPSLanResId(this.getRealPSModelId(t, dto.getPHPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            dto.setPSDEFSFItemId(this.getRealPSModelId(t, dto.getPSDEFSFItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            dto.setPSSysEditorStyleId(this.getRealPSModelId(t, dto.getPSSysEditorStyleId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            dto.setPSSysSearchBarId(this.getRealPSModelId(t, dto.getPSSysSearchBarId()).replace("/", "."));
        }
        if ("PSSYSSEARCHBAR".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSearchBarId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getCtrlPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getCtrlPSSysCssId());
            dto.setCtrlPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setCtrlPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getLabelPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getLabelPSSysCssId());
            dto.setLabelPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setLabelPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPHPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getPHPSLanResId());
            dto.setPHPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setPHPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            linkDTO = (PSDEFSFItemDTO)PSModelServiceUtil.getInstance().getPSDEFSFItemService().getDTO(dto.getPSDEFSFItemId());
            dto.setPSDEFSFItemName(((PSDEFSFItemDTO)linkDTO).getPSDEFSFItemName());
        } else {
            dto.setPSDEFSFItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEditorStyleId())) {
            linkDTO = (PSSysEditorStyleDTO)PSModelServiceUtil.getInstance().getPSSysEditorStyleService().getDTO(dto.getPSSysEditorStyleId());
            dto.setPSSysEditorStyleName(((PSSysEditorStyleDTO)linkDTO).getPSSysEditorStyleName());
        } else {
            dto.setPSSysEditorStyleName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysSearchBarId())) {
            linkDTO = (PSSysSearchBarDTO)PSModelServiceUtil.getInstance().getPSSysSearchBarService().getDTO(dto.getPSSysSearchBarId());
            dto.setMobFlag(((PSSysSearchBarDTO)linkDTO).getMobFlag());
            dto.setPSDEId(((PSSysSearchBarDTO)linkDTO).getPSDEId());
            dto.setPSSysSearchBarName(((PSSysSearchBarDTO)linkDTO).getPSSysSearchBarName());
        } else {
            dto.setMobFlag(null);
            dto.setPSDEId(null);
            dto.setPSSysSearchBarName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSSEARCHBARITEM";
    }

    @Override
    public PSSysSearchBarItem createDomain() {
        return new PSSysSearchBarItem();
    }

    @Override
    public PSSysSearchBarItemDTO createDTO() {
        return new PSSysSearchBarItemDTO();
    }
}

