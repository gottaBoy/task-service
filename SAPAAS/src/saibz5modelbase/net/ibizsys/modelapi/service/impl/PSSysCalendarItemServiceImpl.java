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
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCalendarItem;
import net.ibizsys.modelapi.domain.PSSysCalendarItemRV;
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
import net.ibizsys.modelapi.dto.PSSysCalendarDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarItemDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarItemRVDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.service.IPSSysCalendarItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCalendarItemServiceImpl
extends PSModelServiceImplBase<PSSysCalendarItem, PSSysCalendarItemDTO>
implements IPSSysCalendarItemService {
    private static final Log log = LogFactory.getLog(PSSysCalendarItemServiceImpl.class);

    @Override
    public List<PSSysCalendarItem> listByPSSysCalendar(PSSysCalendar parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCalendarItem get(PSSysCalendar parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCalendarItem> list = this.listByPSSysCalendar(parent);
        if (list != null) {
            for (PSSysCalendarItem item : list) {
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
    public List<PSSysCalendarItemDTO> listDTOByPSSysCalendar(String strParentKey) throws Exception {
        PSSysCalendar pssyscalendar = (PSSysCalendar)PSModelServiceUtil.getInstance().getPSSysCalendarService().get(strParentKey);
        List<PSSysCalendarItem> list = this.listByPSSysCalendar(pssyscalendar);
        if (list != null) {
            ArrayList<PSSysCalendarItemDTO> dtoList = new ArrayList<PSSysCalendarItemDTO>();
            for (PSSysCalendarItem item : list) {
                PSSysCalendarItemDTO dto = (PSSysCalendarItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCalendarItem> onListAll() throws Exception {
        ArrayList<PSSysCalendarItem> list = new ArrayList<PSSysCalendarItem>();
        List pssyscalendars = PSModelServiceUtil.getInstance().getPSSysCalendarService().listAll();
        if (pssyscalendars != null) {
            for (PSSysCalendar parent : pssyscalendars) {
                List<PSSysCalendarItem> items = this.listByPSSysCalendar(parent);
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
    protected PSSysCalendarItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCalendarItem item;
        PSSysCalendar pssyscalendar = (PSSysCalendar)PSModelServiceUtil.getInstance().getPSSysCalendarService().get(strParentKey, true);
        if (pssyscalendar != null && (item = this.get(pssyscalendar, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCalendarItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCalendarItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysCalendarId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysCalendarService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysCalendarItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysCalendarItemName())) {
            return et.getPSSysCalendarItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCalendarItemDTO dto, PSSysCalendarItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCalendarItemId(t.getId().replace("/", "."));
        }
        if (t.getBeginPSDEFId() != null || !bIgnoreNull) {
            dto.setBeginPSDEFId(t.getBeginPSDEFId());
        }
        if (t.getBeginPSDEFName() != null || !bIgnoreNull) {
            dto.setBeginPSDEFName(t.getBeginPSDEFName());
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
        if (t.getCreatePSDEActionId() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionId(t.getCreatePSDEActionId());
        }
        if (t.getCreatePSDEActionName() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionName(t.getCreatePSDEActionName());
        }
        if (t.getCreatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivId(t.getCreatePSDEOPPrivId());
        }
        if (t.getCreatePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivName(t.getCreatePSDEOPPrivName());
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
        if (t.getEditMode() != null || !bIgnoreNull) {
            dto.setEditMode(t.getEditMode());
        }
        if (t.getEnableViewActions() != null || !bIgnoreNull) {
            dto.setEnableViewActions(t.getEnableViewActions());
        }
        if (t.getEndPSDEFId() != null || !bIgnoreNull) {
            dto.setEndPSDEFId(t.getEndPSDEFId());
        }
        if (t.getEndPSDEFName() != null || !bIgnoreNull) {
            dto.setEndPSDEFName(t.getEndPSDEFName());
        }
        if (t.getFinishPSDEFId() != null || !bIgnoreNull) {
            dto.setFinishPSDEFId(t.getFinishPSDEFId());
        }
        if (t.getFinishPSDEFName() != null || !bIgnoreNull) {
            dto.setFinishPSDEFName(t.getFinishPSDEFName());
        }
        if (t.getGanttPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGanttPSSysPFPluginId(t.getGanttPSSysPFPluginId());
        }
        if (t.getGanttPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGanttPSSysPFPluginName(t.getGanttPSSysPFPluginName());
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
        if (t.getLevelPSDEFId() != null || !bIgnoreNull) {
            dto.setLevelPSDEFId(t.getLevelPSDEFId());
        }
        if (t.getLevelPSDEFName() != null || !bIgnoreNull) {
            dto.setLevelPSDEFName(t.getLevelPSDEFName());
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
        if (t.getPKeyPSDEFId() != null || !bIgnoreNull) {
            dto.setPKeyPSDEFId(t.getPKeyPSDEFId());
        }
        if (t.getPKeyPSDEFName() != null || !bIgnoreNull) {
            dto.setPKeyPSDEFName(t.getPKeyPSDEFName());
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
        if (t.getPSSysCalendarId() != null || !bIgnoreNull) {
            dto.setPSSysCalendarId(t.getPSSysCalendarId());
        }
        if (t.getPSSysCalendarItemName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarItemName(t.getPSSysCalendarItemName());
        }
        if (t.getPSSysCalendarName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarName(t.getPSSysCalendarName());
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
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
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
        if (t.getTotalPSDEFId() != null || !bIgnoreNull) {
            dto.setTotalPSDEFId(t.getTotalPSDEFId());
        }
        if (t.getTotalPSDEFName() != null || !bIgnoreNull) {
            dto.setTotalPSDEFName(t.getTotalPSDEFName());
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
        if (t.getUpdatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivId(t.getUpdatePSDEOPPrivId());
        }
        if (t.getUpdatePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivName(t.getUpdatePSDEOPPrivName());
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
        if (t.getViewActions() != null || !bIgnoreNull) {
            dto.setViewActions(t.getViewActions());
        }
        if (StringUtils.hasLength((String)dto.getBeginPSDEFId())) {
            dto.setBeginPSDEFId(this.getRealPSModelId(t, dto.getBeginPSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            dto.setCreatePSDEActionId(this.getRealPSModelId(t, dto.getCreatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            dto.setCreatePSDEOPPrivId(this.getRealPSModelId(t, dto.getCreatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getData2PSDEFId())) {
            dto.setData2PSDEFId(this.getRealPSModelId(t, dto.getData2PSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDataPSDEFId())) {
            dto.setDataPSDEFId(this.getRealPSModelId(t, dto.getDataPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEndPSDEFId())) {
            dto.setEndPSDEFId(this.getRealPSModelId(t, dto.getEndPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEFId())) {
            dto.setFinishPSDEFId(this.getRealPSModelId(t, dto.getFinishPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGanttPSSysPFPluginId())) {
            dto.setGanttPSSysPFPluginId(this.getRealPSModelId(t, dto.getGanttPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getIconPSDEFId())) {
            dto.setIconPSDEFId(this.getRealPSModelId(t, dto.getIconPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getKeyPSDEFId())) {
            dto.setKeyPSDEFId(this.getRealPSModelId(t, dto.getKeyPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getLevelPSDEFId())) {
            dto.setLevelPSDEFId(this.getRealPSModelId(t, dto.getLevelPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getOrderValuePSDEFId())) {
            dto.setOrderValuePSDEFId(this.getRealPSModelId(t, dto.getOrderValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPKeyPSDEFId())) {
            dto.setPKeyPSDEFId(this.getRealPSModelId(t, dto.getPKeyPSDEFId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysCalendarId())) {
            dto.setPSSysCalendarId(this.getRealPSModelId(t, dto.getPSSysCalendarId()).replace("/", "."));
        }
        if ("PSSYSCALENDAR".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysCalendarId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getTotalPSDEFId())) {
            dto.setTotalPSDEFId(this.getRealPSModelId(t, dto.getTotalPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            dto.setUpdatePSDEActionId(this.getRealPSModelId(t, dto.getUpdatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            dto.setUpdatePSDEOPPrivId(this.getRealPSModelId(t, dto.getUpdatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeginPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getBeginPSDEFId());
            dto.setBeginPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setBeginPSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCreatePSDEActionId());
            dto.setCreatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCreatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getCreatePSDEOPPrivId());
            dto.setCreatePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setCreatePSDEOPPrivName(null);
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
        if (StringUtils.hasLength((String)dto.getEndPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getEndPSDEFId());
            dto.setEndPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setEndPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getFinishPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getFinishPSDEFId());
            dto.setFinishPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setFinishPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getGanttPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGanttPSSysPFPluginId());
            dto.setGanttPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGanttPSSysPFPluginName(null);
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
        if (StringUtils.hasLength((String)dto.getLevelPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getLevelPSDEFId());
            dto.setLevelPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setLevelPSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getPKeyPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPKeyPSDEFId());
            dto.setPKeyPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPKeyPSDEFName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysCalendarId())) {
            linkDTO = (PSSysCalendarDTO)PSModelServiceUtil.getInstance().getPSSysCalendarService().getDTO(dto.getPSSysCalendarId());
            dto.setPSSysCalendarName(((PSSysCalendarDTO)linkDTO).getPSSysCalendarName());
        } else {
            dto.setPSSysCalendarName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
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
        if (StringUtils.hasLength((String)dto.getTotalPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTotalPSDEFId());
            dto.setTotalPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTotalPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUpdatePSDEActionId());
            dto.setUpdatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUpdatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUpdatePSDEOPPrivId());
            dto.setUpdatePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUpdatePSDEOPPrivName(null);
        }
        List<PSSysCalendarItemRV> list = PSModelServiceUtil.getInstance().getPSSysCalendarItemRVService().listByPSSysCalendarItem(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysCalendarItemRVDTO> pssyscalendaritemrvs = new ArrayList<PSSysCalendarItemRVDTO>();
            for (PSSysCalendarItemRV item : list) {
                PSSysCalendarItemRVDTO dstItem = (PSSysCalendarItemRVDTO)PSModelServiceUtil.getInstance().getPSSysCalendarItemRVService().toDTO(item);
                pssyscalendaritemrvs.add(dstItem);
            }
            dto.setPssyscalendaritemrvs(pssyscalendaritemrvs);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSCALENDARITEM";
    }

    @Override
    public PSSysCalendarItem createDomain() {
        return new PSSysCalendarItem();
    }

    @Override
    public PSSysCalendarItemDTO createDTO() {
        return new PSSysCalendarItemDTO();
    }
}

