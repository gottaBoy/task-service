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
import java.util.Collection;
import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysPortlet;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEListDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysPortletCatDTO;
import net.ibizsys.modelapi.dto.PSSysPortletDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysUniResDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysPortletService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysPortletServiceImpl
extends PSModelServiceImplBase<PSSysPortlet, PSSysPortletDTO>
implements IPSSysPortletService {
    private static final Log log = LogFactory.getLog(PSSysPortletServiceImpl.class);

    @Override
    public List<PSSysPortlet> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPortlet get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPortlet> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysPortlet item : list) {
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
    public List<PSSysPortletDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysPortlet> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysPortletDTO> dtoList = new ArrayList<PSSysPortletDTO>();
            for (PSSysPortlet item : list) {
                PSSysPortletDTO dto = (PSSysPortletDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysPortlet> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPortlet get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPortlet> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysPortlet item : list) {
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
    public List<PSSysPortletDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysPortlet> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysPortletDTO> dtoList = new ArrayList<PSSysPortletDTO>();
            for (PSSysPortlet item : list) {
                PSSysPortletDTO dto = (PSSysPortletDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysPortlet> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPortlet get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPortlet> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysPortlet item : list) {
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
    public List<PSSysPortletDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysPortlet> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysPortletDTO> dtoList = new ArrayList<PSSysPortletDTO>();
            for (PSSysPortlet item : list) {
                PSSysPortletDTO dto = (PSSysPortletDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysPortlet> onListAll() throws Exception {
        List<PSSystem> pssystems;
        List<PSModule> psmodules;
        ArrayList<PSSysPortlet> list = new ArrayList<PSSysPortlet>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysPortlet> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSSysPortlet>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSSysPortlet> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysPortlet> items = this.listByPSSystem(parent);
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
    protected PSSysPortlet onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysPortlet item;
        PSSysPortlet item2;
        PSSysPortlet item3;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item3 = this.get(psdataentity, strCurKey, true)) != null) {
            return item3;
        }
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey, true);
        if (psmodule != null && (item2 = this.get(psmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysPortlet)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysPortletDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysPortlet et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysPortletName())) {
            return et.getPSSysPortletName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysPortletDTO dto, PSSysPortlet t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysPortletId(t.getId().replace("/", "."));
        }
        if (t.getADPSDELogicId() != null || !bIgnoreNull) {
            dto.setADPSDELogicId(t.getADPSDELogicId());
        }
        if (t.getADPSDELogicName() != null || !bIgnoreNull) {
            dto.setADPSDELogicName(t.getADPSDELogicName());
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
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
        if (t.getDashboardScope() != null || !bIgnoreNull) {
            dto.setDashboardScope(t.getDashboardScope());
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
        if (t.getGroupExtractMode() != null || !bIgnoreNull) {
            dto.setGroupExtractMode(t.getGroupExtractMode());
        }
        if (t.getHeight() != null || !bIgnoreNull) {
            dto.setHeight(t.getHeight());
        }
        if (t.getHtmlShowMode() != null || !bIgnoreNull) {
            dto.setHtmlShowMode(t.getHtmlShowMode());
        }
        if (t.getHtmlUrl() != null || !bIgnoreNull) {
            dto.setHtmlUrl(t.getHtmlUrl());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPortletParams() != null || !bIgnoreNull) {
            dto.setPortletParams(t.getPortletParams());
        }
        if (t.getPortletStyle() != null || !bIgnoreNull) {
            dto.setPortletStyle(t.getPortletStyle());
        }
        if (t.getPortletType() != null || !bIgnoreNull) {
            dto.setPortletType(t.getPortletType());
        }
        if (t.getPSACHandlerId() != null || !bIgnoreNull) {
            dto.setPSACHandlerId(t.getPSACHandlerId());
        }
        if (t.getPSACHandlerName() != null || !bIgnoreNull) {
            dto.setPSACHandlerName(t.getPSACHandlerName());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSAppViewId() != null || !bIgnoreNull) {
            dto.setPSAppViewId(t.getPSAppViewId());
        }
        if (t.getPSAppViewName() != null || !bIgnoreNull) {
            dto.setPSAppViewName(t.getPSAppViewName());
        }
        if (t.getPSDEChartId() != null || !bIgnoreNull) {
            dto.setPSDEChartId(t.getPSDEChartId());
        }
        if (t.getPSDEChartName() != null || !bIgnoreNull) {
            dto.setPSDEChartName(t.getPSDEChartName());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEListId() != null || !bIgnoreNull) {
            dto.setPSDEListId(t.getPSDEListId());
        }
        if (t.getPSDEListName() != null || !bIgnoreNull) {
            dto.setPSDEListName(t.getPSDEListName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEReportId() != null || !bIgnoreNull) {
            dto.setPSDEReportId(t.getPSDEReportId());
        }
        if (t.getPSDEReportName() != null || !bIgnoreNull) {
            dto.setPSDEReportName(t.getPSDEReportName());
        }
        if (t.getPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setPSDEToolbarId(t.getPSDEToolbarId());
        }
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEViewId() != null || !bIgnoreNull) {
            dto.setPSDEViewId(t.getPSDEViewId());
        }
        if (t.getPSDEViewName() != null || !bIgnoreNull) {
            dto.setPSDEViewName(t.getPSDEViewName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSPortletId() != null || !bIgnoreNull) {
            dto.setPSPortletId(t.getPSPortletId());
        }
        if (t.getPSPortletName() != null || !bIgnoreNull) {
            dto.setPSPortletName(t.getPSPortletName());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
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
        if (t.getPSSysPortletCatId() != null || !bIgnoreNull) {
            dto.setPSSysPortletCatId(t.getPSSysPortletCatId());
        }
        if (t.getPSSysPortletCatName() != null || !bIgnoreNull) {
            dto.setPSSysPortletCatName(t.getPSSysPortletCatName());
        }
        if (t.getPSSysPortletName() != null || !bIgnoreNull) {
            dto.setPSSysPortletName(t.getPSSysPortletName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUniResId() != null || !bIgnoreNull) {
            dto.setPSSysUniResId(t.getPSSysUniResId());
        }
        if (t.getPSSysUniResName() != null || !bIgnoreNull) {
            dto.setPSSysUniResName(t.getPSSysUniResName());
        }
        if (t.getReloadTimer() != null || !bIgnoreNull) {
            dto.setReloadTimer(t.getReloadTimer());
        }
        if (t.getShowTitleBar() != null || !bIgnoreNull) {
            dto.setShowTitleBar(t.getShowTitleBar());
        }
        if (t.getTemplEngine() != null || !bIgnoreNull) {
            dto.setTemplEngine(t.getTemplEngine());
        }
        if (t.getTitlePSLanResId() != null || !bIgnoreNull) {
            dto.setTitlePSLanResId(t.getTitlePSLanResId());
        }
        if (t.getTitlePSLanResName() != null || !bIgnoreNull) {
            dto.setTitlePSLanResName(t.getTitlePSLanResName());
        }
        if (t.getTitlePSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setTitlePSSysPFPluginId(t.getTitlePSSysPFPluginId());
        }
        if (t.getTitlePSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setTitlePSSysPFPluginName(t.getTitlePSSysPFPluginName());
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
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            dto.setPSDEChartId(this.getRealPSModelId(t, dto.getPSDEChartId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            dto.setPSDEListId(this.getRealPSModelId(t, dto.getPSDEListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            dto.setPSDEReportId(this.getRealPSModelId(t, dto.getPSDEReportId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            dto.setPSDEToolbarId(this.getRealPSModelId(t, dto.getPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewId())) {
            dto.setPSDEViewId(this.getRealPSModelId(t, dto.getPSDEViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if ("PSMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSModuleId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPortletCatId())) {
            dto.setPSSysPortletCatId(this.getRealPSModelId(t, dto.getPSSysPortletCatId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUniResId())) {
            dto.setPSSysUniResId(this.getRealPSModelId(t, dto.getPSSysUniResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSLanResId())) {
            dto.setTitlePSLanResId(this.getRealPSModelId(t, dto.getTitlePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTitlePSSysPFPluginId())) {
            dto.setTitlePSSysPFPluginId(this.getRealPSModelId(t, dto.getTitlePSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getADPSDELogicId())) {
            linkDTO = (PSDELogicDTO)PSModelServiceUtil.getInstance().getPSDELogicService().getDTO(dto.getADPSDELogicId());
            dto.setADPSDELogicName(((PSDELogicDTO)linkDTO).getPSDELogicName());
        } else {
            dto.setADPSDELogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getPSACHandlerId());
            dto.setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getPSAppViewId());
            dto.setPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEChartId())) {
            linkDTO = (PSDEChartDTO)PSModelServiceUtil.getInstance().getPSDEChartService().getDTO(dto.getPSDEChartId());
            dto.setPSDEChartName(((PSDEChartDTO)linkDTO).getPSDEChartName());
        } else {
            dto.setPSDEChartName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEListId())) {
            linkDTO = (PSDEListDTO)PSModelServiceUtil.getInstance().getPSDEListService().getDTO(dto.getPSDEListId());
            dto.setPSDEListName(((PSDEListDTO)linkDTO).getPSDEListName());
        } else {
            dto.setPSDEListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEReportId())) {
            linkDTO = (PSDEReportDTO)PSModelServiceUtil.getInstance().getPSDEReportService().getDTO(dto.getPSDEReportId());
            dto.setPSDEReportName(((PSDEReportDTO)linkDTO).getPSDEReportName());
        } else {
            dto.setPSDEReportName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getPSDEToolbarId());
            dto.setPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEViewId())) {
            linkDTO = (PSDEViewBaseDTO)PSModelServiceUtil.getInstance().getPSDEViewBaseService().getDTO(dto.getPSDEViewId());
            dto.setPSDEViewName(((PSDEViewBaseDTO)linkDTO).getPSDEViewBaseName());
        } else {
            dto.setPSDEViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPortletCatId())) {
            linkDTO = (PSSysPortletCatDTO)PSModelServiceUtil.getInstance().getPSSysPortletCatService().getDTO(dto.getPSSysPortletCatId());
            dto.setPSSysPortletCatName(((PSSysPortletCatDTO)linkDTO).getPSSysPortletCatName());
        } else {
            dto.setPSSysPortletCatName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
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
        if (StringUtils.hasLength((String)dto.getTitlePSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getTitlePSSysPFPluginId());
            dto.setTitlePSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setTitlePSSysPFPluginName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSPORTLET";
    }

    @Override
    public PSSysPortlet createDomain() {
        return new PSSysPortlet();
    }

    @Override
    public PSSysPortletDTO createDTO() {
        return new PSSysPortletDTO();
    }
}

