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
import net.ibizsys.modelapi.domain.PSSysMapItem;
import net.ibizsys.modelapi.domain.PSSysMapView;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysMapItemDTO;
import net.ibizsys.modelapi.dto.PSSysMapViewDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSSysMapItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysMapItemServiceImpl
extends PSModelServiceImplBase<PSSysMapItem, PSSysMapItemDTO>
implements IPSSysMapItemService {
    private static final Log log = LogFactory.getLog(PSSysMapItemServiceImpl.class);

    @Override
    public List<PSSysMapItem> listByPSSysMapView(PSSysMapView parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysMapItem get(PSSysMapView parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysMapItem> list = this.listByPSSysMapView(parent);
        if (list != null) {
            for (PSSysMapItem item : list) {
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
    public List<PSSysMapItemDTO> listDTOByPSSysMapView(String strParentKey) throws Exception {
        PSSysMapView pssysmapview = (PSSysMapView)PSModelServiceUtil.getInstance().getPSSysMapViewService().get(strParentKey);
        List<PSSysMapItem> list = this.listByPSSysMapView(pssysmapview);
        if (list != null) {
            ArrayList<PSSysMapItemDTO> dtoList = new ArrayList<PSSysMapItemDTO>();
            for (PSSysMapItem item : list) {
                PSSysMapItemDTO dto = (PSSysMapItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysMapItem> onListAll() throws Exception {
        ArrayList<PSSysMapItem> list = new ArrayList<PSSysMapItem>();
        List pssysmapviews = PSModelServiceUtil.getInstance().getPSSysMapViewService().listAll();
        if (pssysmapviews != null) {
            for (PSSysMapView parent : pssysmapviews) {
                List<PSSysMapItem> items = this.listByPSSysMapView(parent);
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
    protected PSSysMapItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysMapItem item;
        PSSysMapView pssysmapview = (PSSysMapView)PSModelServiceUtil.getInstance().getPSSysMapViewService().get(strParentKey, true);
        if (pssysmapview != null && (item = this.get(pssysmapview, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysMapItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysMapItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysMapViewId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysMapViewService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysMapItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysMapItemName())) {
            return et.getPSSysMapItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysMapItemDTO dto, PSSysMapItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysMapItemId(t.getId().replace("/", "."));
        }
        if (t.getAltPSDEFId() != null || !bIgnoreNull) {
            dto.setAltPSDEFId(t.getAltPSDEFId());
        }
        if (t.getAltPSDEFName() != null || !bIgnoreNull) {
            dto.setAltPSDEFName(t.getAltPSDEFName());
        }
        if (t.getBKColor() != null || !bIgnoreNull) {
            dto.setBKColor(t.getBKColor());
        }
        if (t.getBKColorPSDEFId() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFId(t.getBKColorPSDEFId());
        }
        if (t.getBKColorPSDEFName() != null || !bIgnoreNull) {
            dto.setBKColorPSDEFName(t.getBKColorPSDEFName());
        }
        if (t.getBorderColor() != null || !bIgnoreNull) {
            dto.setBorderColor(t.getBorderColor());
        }
        if (t.getBorderWidth() != null || !bIgnoreNull) {
            dto.setBorderWidth(t.getBorderWidth());
        }
        if (t.getClsPSDEFId() != null || !bIgnoreNull) {
            dto.setClsPSDEFId(t.getClsPSDEFId());
        }
        if (t.getClsPSDEFName() != null || !bIgnoreNull) {
            dto.setClsPSDEFName(t.getClsPSDEFName());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
        }
        if (t.getColorPSDEFId() != null || !bIgnoreNull) {
            dto.setColorPSDEFId(t.getColorPSDEFId());
        }
        if (t.getColorPSDEFName() != null || !bIgnoreNull) {
            dto.setColorPSDEFName(t.getColorPSDEFName());
        }
        if (t.getContentPSDEFId() != null || !bIgnoreNull) {
            dto.setContentPSDEFId(t.getContentPSDEFId());
        }
        if (t.getContentPSDEFName() != null || !bIgnoreNull) {
            dto.setContentPSDEFName(t.getContentPSDEFName());
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
        if (t.getData2PSDEFId() != null || !bIgnoreNull) {
            dto.setData2PSDEFId(t.getData2PSDEFId());
        }
        if (t.getData2PSDEFName() != null || !bIgnoreNull) {
            dto.setData2PSDEFName(t.getData2PSDEFName());
        }
        if (t.getDataPSDEFId() != null || !bIgnoreNull) {
            dto.setDataPSDEFId(t.getDataPSDEFId());
        }
        if (t.getDataPSDEFName() != null || !bIgnoreNull) {
            dto.setDataPSDEFName(t.getDataPSDEFName());
        }
        if (t.getDynaClass() != null || !bIgnoreNull) {
            dto.setDynaClass(t.getDynaClass());
        }
        if (t.getGroupPSDEFId() != null || !bIgnoreNull) {
            dto.setGroupPSDEFId(t.getGroupPSDEFId());
        }
        if (t.getGroupPSDEFName() != null || !bIgnoreNull) {
            dto.setGroupPSDEFName(t.getGroupPSDEFName());
        }
        if (t.getIconPSDEFId() != null || !bIgnoreNull) {
            dto.setIconPSDEFId(t.getIconPSDEFId());
        }
        if (t.getIconPSDEFName() != null || !bIgnoreNull) {
            dto.setIconPSDEFName(t.getIconPSDEFName());
        }
        if (t.getItemStyle() != null || !bIgnoreNull) {
            dto.setItemStyle(t.getItemStyle());
        }
        if (t.getItemStyleText() != null || !bIgnoreNull) {
            dto.setItemStyleText(t.getItemStyleText());
        }
        if (t.getItemType() != null || !bIgnoreNull) {
            dto.setItemType(t.getItemType());
        }
        if (t.getKeyPSDEFId() != null || !bIgnoreNull) {
            dto.setKeyPSDEFId(t.getKeyPSDEFId());
        }
        if (t.getKeyPSDEFName() != null || !bIgnoreNull) {
            dto.setKeyPSDEFName(t.getKeyPSDEFName());
        }
        if (t.getLatPSDEFId() != null || !bIgnoreNull) {
            dto.setLatPSDEFId(t.getLatPSDEFId());
        }
        if (t.getLatPSDEFName() != null || !bIgnoreNull) {
            dto.setLatPSDEFName(t.getLatPSDEFName());
        }
        if (t.getLongPSDEFId() != null || !bIgnoreNull) {
            dto.setLongPSDEFId(t.getLongPSDEFId());
        }
        if (t.getLongPSDEFName() != null || !bIgnoreNull) {
            dto.setLongPSDEFName(t.getLongPSDEFName());
        }
        if (t.getMaxSize() != null || !bIgnoreNull) {
            dto.setMaxSize(t.getMaxSize());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelObj() != null || !bIgnoreNull) {
            dto.setModelObj(t.getModelObj());
        }
        if (t.getNamePSLanResId() != null || !bIgnoreNull) {
            dto.setNamePSLanResId(t.getNamePSLanResId());
        }
        if (t.getNamePSLanResName() != null || !bIgnoreNull) {
            dto.setNamePSLanResName(t.getNamePSLanResName());
        }
        if (t.getNavViewFilter() != null || !bIgnoreNull) {
            dto.setNavViewFilter(t.getNavViewFilter());
        }
        if (t.getNavViewParam() != null || !bIgnoreNull) {
            dto.setNavViewParam(t.getNavViewParam());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getOrderValuePSDEFId() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFId(t.getOrderValuePSDEFId());
        }
        if (t.getOrderValuePSDEFName() != null || !bIgnoreNull) {
            dto.setOrderValuePSDEFName(t.getOrderValuePSDEFName());
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
        if (t.getPSDELogicId() != null || !bIgnoreNull) {
            dto.setPSDELogicId(t.getPSDELogicId());
        }
        if (t.getPSDELogicName() != null || !bIgnoreNull) {
            dto.setPSDELogicName(t.getPSDELogicName());
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
        if (t.getPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setPSDEToolbarId(t.getPSDEToolbarId());
        }
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
        }
        if (t.getPSDEViewBaseId() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseId(t.getPSDEViewBaseId());
        }
        if (t.getPSDEViewBaseName() != null || !bIgnoreNull) {
            dto.setPSDEViewBaseName(t.getPSDEViewBaseName());
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
        if (t.getPSSysMapItemName() != null || !bIgnoreNull) {
            dto.setPSSysMapItemName(t.getPSSysMapItemName());
        }
        if (t.getPSSysMapViewId() != null || !bIgnoreNull) {
            dto.setPSSysMapViewId(t.getPSSysMapViewId());
        }
        if (t.getPSSysMapViewName() != null || !bIgnoreNull) {
            dto.setPSSysMapViewName(t.getPSSysMapViewName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getRadius() != null || !bIgnoreNull) {
            dto.setRadius(t.getRadius());
        }
        if (t.getRemovePSDEActionId() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionId(t.getRemovePSDEActionId());
        }
        if (t.getRemovePSDEActionName() != null || !bIgnoreNull) {
            dto.setRemovePSDEActionName(t.getRemovePSDEActionName());
        }
        if (t.getRemovePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivId(t.getRemovePSDEOPPrivId());
        }
        if (t.getRemovePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setRemovePSDEOPPrivName(t.getRemovePSDEOPPrivName());
        }
        if (t.getTag2PSDEFId() != null || !bIgnoreNull) {
            dto.setTag2PSDEFId(t.getTag2PSDEFId());
        }
        if (t.getTag2PSDEFName() != null || !bIgnoreNull) {
            dto.setTag2PSDEFName(t.getTag2PSDEFName());
        }
        if (t.getTagPSDEFId() != null || !bIgnoreNull) {
            dto.setTagPSDEFId(t.getTagPSDEFId());
        }
        if (t.getTagPSDEFName() != null || !bIgnoreNull) {
            dto.setTagPSDEFName(t.getTagPSDEFName());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
        }
        if (t.getTipsPSDEFId() != null || !bIgnoreNull) {
            dto.setTipsPSDEFId(t.getTipsPSDEFId());
        }
        if (t.getTipsPSDEFName() != null || !bIgnoreNull) {
            dto.setTipsPSDEFName(t.getTipsPSDEFName());
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
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getAltPSDEFId())) {
            dto.setAltPSDEFId(this.getRealPSModelId(t, dto.getAltPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            dto.setBKColorPSDEFId(this.getRealPSModelId(t, dto.getBKColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            dto.setClsPSDEFId(this.getRealPSModelId(t, dto.getClsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            dto.setColorPSDEFId(this.getRealPSModelId(t, dto.getColorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            dto.setContentPSDEFId(this.getRealPSModelId(t, dto.getContentPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getData2PSDEFId())) {
            dto.setData2PSDEFId(this.getRealPSModelId(t, dto.getData2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            dto.setDataPSDEFId(this.getRealPSModelId(t, dto.getDataPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            dto.setGroupPSDEFId(this.getRealPSModelId(t, dto.getGroupPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            dto.setIconPSDEFId(this.getRealPSModelId(t, dto.getIconPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            dto.setKeyPSDEFId(this.getRealPSModelId(t, dto.getKeyPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLatPSDEFId())) {
            dto.setLatPSDEFId(this.getRealPSModelId(t, dto.getLatPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLongPSDEFId())) {
            dto.setLongPSDEFId(this.getRealPSModelId(t, dto.getLongPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            dto.setOrderValuePSDEFId(this.getRealPSModelId(t, dto.getOrderValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            dto.setPSDEToolbarId(this.getRealPSModelId(t, dto.getPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            dto.setPSDEViewBaseId(this.getRealPSModelId(t, dto.getPSDEViewBaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMapViewId())) {
            dto.setPSSysMapViewId(this.getRealPSModelId(t, dto.getPSSysMapViewId()).replace("/", "."));
        }
        if ("PSSYSMAPVIEW".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysMapViewId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            dto.setRemovePSDEActionId(this.getRealPSModelId(t, dto.getRemovePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            dto.setRemovePSDEOPPrivId(this.getRealPSModelId(t, dto.getRemovePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTag2PSDEFId())) {
            dto.setTag2PSDEFId(this.getRealPSModelId(t, dto.getTag2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTagPSDEFId())) {
            dto.setTagPSDEFId(this.getRealPSModelId(t, dto.getTagPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipsPSDEFId())) {
            dto.setTipsPSDEFId(this.getRealPSModelId(t, dto.getTipsPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAltPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getAltPSDEFId());
            dto.setAltPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setAltPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getBKColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBKColorPSDEFId());
            dto.setBKColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBKColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getClsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getClsPSDEFId());
            dto.setClsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setClsPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getColorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getColorPSDEFId());
            dto.setColorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setColorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getContentPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getContentPSDEFId());
            dto.setContentPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setContentPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getData2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getData2PSDEFId());
            dto.setData2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setData2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDataPSDEFId());
            dto.setDataPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDataPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getGroupPSDEFId());
            dto.setGroupPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setGroupPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getIconPSDEFId());
            dto.setIconPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setIconPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getKeyPSDEFId());
            dto.setKeyPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setKeyPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLatPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getLatPSDEFId());
            dto.setLatPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setLatPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getLongPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getLongPSDEFId());
            dto.setLongPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setLongPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNamePSLanResId());
            dto.setNamePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNamePSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getOrderValuePSDEFId());
            dto.setOrderValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setOrderValuePSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getPSDELogicId());
            dto.setPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getPSDEToolbarId());
            dto.setPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewBaseId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewBaseId());
            dto.setPSDEViewBaseName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewBaseName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysMapViewId())) {
            linkDTO = (PSSysMapViewDTO)PSModelServiceUtil.getInstance().getPSSysMapViewService().getDTO(dto.getPSSysMapViewId());
            dto.setPSSysMapViewName(((PSSysMapViewDTO)linkDTO).getPSSysMapViewName());
        } else {
            dto.setPSSysMapViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getRemovePSDEActionId());
            dto.setRemovePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setRemovePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getRemovePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getRemovePSDEOPPrivId());
            dto.setRemovePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setRemovePSDEOPPrivName(null);
        }
        if (StringUtils.hasLength((String)dto.getTag2PSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTag2PSDEFId());
            dto.setTag2PSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTag2PSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTagPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTagPSDEFId());
            dto.setTagPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTagPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipsPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTipsPSDEFId());
            dto.setTipsPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTipsPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSMAPITEM";
    }

    @Override
    public PSSysMapItem createDomain() {
        return new PSSysMapItem();
    }

    @Override
    public PSSysMapItemDTO createDTO() {
        return new PSSysMapItemDTO();
    }
}

