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
import net.ibizsys.modelapi.domain.PSDETreeCol;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDETreeColDTO;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSDETreeColService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDETreeColServiceImpl
extends PSModelServiceImplBase<PSDETreeCol, PSDETreeColDTO>
implements IPSDETreeColService {
    private static final Log log = LogFactory.getLog(PSDETreeColServiceImpl.class);

    @Override
    public List<PSDETreeCol> listByPSDETreeView(PSDETreeView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDETreeCol get(PSDETreeView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDETreeCol> list = this.listByPSDETreeView(parent);
        if (list != null) {
            for (PSDETreeCol item : list) {
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
    public List<PSDETreeColDTO> listDTOByPSDETreeView(String strParentKey) throws Exception {
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey);
        List<PSDETreeCol> list = this.listByPSDETreeView(psdetreeview);
        if (list != null) {
            ArrayList<PSDETreeColDTO> dtoList = new ArrayList<PSDETreeColDTO>();
            for (PSDETreeCol item : list) {
                PSDETreeColDTO dto = (PSDETreeColDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDETreeCol> onListAll() throws Exception {
        ArrayList<PSDETreeCol> list = new ArrayList<PSDETreeCol>();
        List<PSDETreeView> psdetreeviews = PSModelServiceUtil.getInstance().getPSDETreeViewService().listAll();
        if (psdetreeviews != null) {
            for (PSDETreeView parent : psdetreeviews) {
                List<PSDETreeCol> items = this.listByPSDETreeView(parent);
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
    protected PSDETreeCol onGet(String strParentKey, String strCurKey) throws Exception {
        PSDETreeCol item;
        PSDETreeView psdetreeview = (PSDETreeView)PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strParentKey, true);
        if (psdetreeview != null && (item = this.get(psdetreeview, strCurKey, true)) != null) {
            return item;
        }
        return (PSDETreeCol)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDETreeColDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDETreeViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDETreeViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDETreeCol et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDETreeColName())) {
            return et.getPSDETreeColName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDETreeColDTO dto, PSDETreeCol t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDETreeColId(t.getId().replace("/", "."));
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
        if (t.getCellPSSysCssId() != null || !bIgnoreNull) {
            dto.setCellPSSysCssId(t.getCellPSSysCssId());
        }
        if (t.getCellPSSysCssName() != null || !bIgnoreNull) {
            dto.setCellPSSysCssName(t.getCellPSSysCssName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getGCRPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginId(t.getGCRPSSysPFPluginId());
        }
        if (t.getGCRPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGCRPSSysPFPluginName(t.getGCRPSSysPFPluginName());
        }
        if (t.getGridColStyle() != null || !bIgnoreNull) {
            dto.setGridColStyle(t.getGridColStyle());
        }
        if (t.getGridColType() != null || !bIgnoreNull) {
            dto.setGridColType(t.getGridColType());
        }
        if (t.getHeaderPSSysCssId() != null || !bIgnoreNull) {
            dto.setHeaderPSSysCssId(t.getHeaderPSSysCssId());
        }
        if (t.getHeaderPSSysCssName() != null || !bIgnoreNull) {
            dto.setHeaderPSSysCssName(t.getHeaderPSSysCssName());
        }
        if (t.getHideDefault() != null || !bIgnoreNull) {
            dto.setHideDefault(t.getHideDefault());
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
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDETreeColName() != null || !bIgnoreNull) {
            dto.setPSDETreeColName(t.getPSDETreeColName());
        }
        if (t.getPSDETreeViewId() != null || !bIgnoreNull) {
            dto.setPSDETreeViewId(t.getPSDETreeViewId());
        }
        if (t.getPSDETreeViewName() != null || !bIgnoreNull) {
            dto.setPSDETreeViewName(t.getPSDETreeViewName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
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
        if (t.getWidth() != null || !bIgnoreNull) {
            dto.setWidth(t.getWidth());
        }
        if (t.getWidthUnit() != null || !bIgnoreNull) {
            dto.setWidthUnit(t.getWidthUnit());
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            dto.setCapPSLanResId(this.getRealPSModelId(t, dto.getCapPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCellPSSysCssId())) {
            dto.setCellPSSysCssId(this.getRealPSModelId(t, dto.getCellPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            dto.setGCRPSSysPFPluginId(this.getRealPSModelId(t, dto.getGCRPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getHeaderPSSysCssId())) {
            dto.setHeaderPSSysCssId(this.getRealPSModelId(t, dto.getHeaderPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            dto.setPSDETreeViewId(this.getRealPSModelId(t, dto.getPSDETreeViewId()).replace("/", "."));
        }
        if ("PSDETREEVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDETreeViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCapPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getCapPSLanResId());
            dto.setCapPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setCapPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getCellPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getCellPSSysCssId());
            dto.setCellPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setCellPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getGCRPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGCRPSSysPFPluginId());
            dto.setGCRPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGCRPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getHeaderPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getHeaderPSSysCssId());
            dto.setHeaderPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setHeaderPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDETreeViewId())) {
            linkDTO = (PSDETreeViewDTO)PSModelServiceUtil.getInstance().getPSDETreeViewService().getDTO(dto.getPSDETreeViewId());
            dto.setPSDETreeViewName(((PSDETreeViewDTO)linkDTO).getPSDETreeViewName());
        } else {
            dto.setPSDETreeViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETREECOL";
    }

    @Override
    public PSDETreeCol createDomain() {
        return new PSDETreeCol();
    }

    @Override
    public PSDETreeColDTO createDTO() {
        return new PSDETreeColDTO();
    }
}

