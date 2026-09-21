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
import net.ibizsys.modelapi.domain.PSPanelEngine;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelItem;
import net.ibizsys.modelapi.domain.PSSysViewPanelLogic;
import net.ibizsys.modelapi.domain.PSSysViewPanelModel;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSPanelEngineDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysViewPanelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysViewPanelServiceImpl
extends PSModelServiceImplBase<PSSysViewPanel, PSSysViewPanelDTO>
implements IPSSysViewPanelService {
    private static final Log log = LogFactory.getLog(PSSysViewPanelServiceImpl.class);

    @Override
    public List<PSSysViewPanel> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanel get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanel> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysViewPanel item : list) {
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
    public List<PSSysViewPanelDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysViewPanel> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysViewPanelDTO> dtoList = new ArrayList<PSSysViewPanelDTO>();
            for (PSSysViewPanel item : list) {
                PSSysViewPanelDTO dto = (PSSysViewPanelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysViewPanel> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanel get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanel> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysViewPanel item : list) {
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
    public List<PSSysViewPanelDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysViewPanel> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysViewPanelDTO> dtoList = new ArrayList<PSSysViewPanelDTO>();
            for (PSSysViewPanel item : list) {
                PSSysViewPanelDTO dto = (PSSysViewPanelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysViewPanel> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanel get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanel> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysViewPanel item : list) {
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
    public List<PSSysViewPanelDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysViewPanel> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysViewPanelDTO> dtoList = new ArrayList<PSSysViewPanelDTO>();
            for (PSSysViewPanel item : list) {
                PSSysViewPanelDTO dto = (PSSysViewPanelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysViewPanel> onListAll() throws Exception {
        List pssystems;
        List psmodules;
        ArrayList<PSSysViewPanel> list = new ArrayList<PSSysViewPanel>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysViewPanel> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSSysViewPanel>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSSysViewPanel> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysViewPanel> items = this.listByPSSystem(parent);
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
    protected PSSysViewPanel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysViewPanel item;
        PSSysViewPanel item2;
        PSSysViewPanel item3;
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
        return (PSSysViewPanel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysViewPanelDTO dto) throws Exception {
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
    public String getModelTag(PSSysViewPanel et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysViewPanelDTO dto, PSSysViewPanel t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysViewPanelId(t.getId().replace("/", "."));
        }
        if (t.getBodyOnlyFlag() != null || !bIgnoreNull) {
            dto.setBodyOnlyFlag(t.getBodyOnlyFlag());
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
        if (t.getDataName() != null || !bIgnoreNull) {
            dto.setDataName(t.getDataName());
        }
        if (t.getEnablePageFooter() != null || !bIgnoreNull) {
            dto.setEnablePageFooter(t.getEnablePageFooter());
        }
        if (t.getEnablePageHeader() != null || !bIgnoreNull) {
            dto.setEnablePageHeader(t.getEnablePageHeader());
        }
        if (t.getGetDataMode() != null || !bIgnoreNull) {
            dto.setGetDataMode(t.getGetDataMode());
        }
        if (t.getGetDataTimer() != null || !bIgnoreNull) {
            dto.setGetDataTimer(t.getGetDataTimer());
        }
        if (t.getGetPSDEActionId() != null || !bIgnoreNull) {
            dto.setGetPSDEActionId(t.getGetPSDEActionId());
        }
        if (t.getGetPSDEActionName() != null || !bIgnoreNull) {
            dto.setGetPSDEActionName(t.getGetPSDEActionName());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getNavBarHeight() != null || !bIgnoreNull) {
            dto.setNavBarHeight(t.getNavBarHeight());
        }
        if (t.getNavBarPos() != null || !bIgnoreNull) {
            dto.setNavBarPos(t.getNavBarPos());
        }
        if (t.getNavBarPSSysCssId() != null || !bIgnoreNull) {
            dto.setNavBarPSSysCssId(t.getNavBarPSSysCssId());
        }
        if (t.getNavBarPSSysCssName() != null || !bIgnoreNull) {
            dto.setNavBarPSSysCssName(t.getNavBarPSSysCssName());
        }
        if (t.getNavBarStyle() != null || !bIgnoreNull) {
            dto.setNavBarStyle(t.getNavBarStyle());
        }
        if (t.getNavBarWidth() != null || !bIgnoreNull) {
            dto.setNavBarWidth(t.getNavBarWidth());
        }
        if (t.getOwnerId() != null || !bIgnoreNull) {
            dto.setOwnerId(t.getOwnerId());
        }
        if (t.getOwnerTag() != null || !bIgnoreNull) {
            dto.setOwnerTag(t.getOwnerTag());
        }
        if (t.getOwnerType() != null || !bIgnoreNull) {
            dto.setOwnerType(t.getOwnerType());
        }
        if (t.getPageFormat() != null || !bIgnoreNull) {
            dto.setPageFormat(t.getPageFormat());
        }
        if (t.getPageHeight() != null || !bIgnoreNull) {
            dto.setPageHeight(t.getPageHeight());
        }
        if (t.getPageMarginBottom() != null || !bIgnoreNull) {
            dto.setPageMarginBottom(t.getPageMarginBottom());
        }
        if (t.getPageMarginLeft() != null || !bIgnoreNull) {
            dto.setPageMarginLeft(t.getPageMarginLeft());
        }
        if (t.getPageMarginRight() != null || !bIgnoreNull) {
            dto.setPageMarginRight(t.getPageMarginRight());
        }
        if (t.getPageMarginTop() != null || !bIgnoreNull) {
            dto.setPageMarginTop(t.getPageMarginTop());
        }
        if (t.getPageWidth() != null || !bIgnoreNull) {
            dto.setPageWidth(t.getPageWidth());
        }
        if (t.getPanelHeight() != null || !bIgnoreNull) {
            dto.setPanelHeight(t.getPanelHeight());
        }
        if (t.getPanelNavBar() != null || !bIgnoreNull) {
            dto.setPanelNavBar(t.getPanelNavBar());
        }
        if (t.getPanelStyle() != null || !bIgnoreNull) {
            dto.setPanelStyle(t.getPanelStyle());
        }
        if (t.getPanelWidth() != null || !bIgnoreNull) {
            dto.setPanelWidth(t.getPanelWidth());
        }
        if (t.getPPI() != null || !bIgnoreNull) {
            dto.setPPI(t.getPPI());
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
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
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
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getPublicFlag() != null || !bIgnoreNull) {
            dto.setPublicFlag(t.getPublicFlag());
        }
        if (t.getShowFooterFirstPage() != null || !bIgnoreNull) {
            dto.setShowFooterFirstPage(t.getShowFooterFirstPage());
        }
        if (t.getShowHeaderFirstPage() != null || !bIgnoreNull) {
            dto.setShowHeaderFirstPage(t.getShowHeaderFirstPage());
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
        if (t.getViewLayoutFlag() != null || !bIgnoreNull) {
            dto.setViewLayoutFlag(t.getViewLayoutFlag());
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            dto.setGetPSDEActionId(this.getRealPSModelId(t, dto.getGetPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNavBarPSSysCssId())) {
            dto.setNavBarPSSysCssId(this.getRealPSModelId(t, dto.getNavBarPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGetPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getGetPSDEActionId());
            dto.setGetPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setGetPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getNavBarPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getNavBarPSSysCssId());
            dto.setNavBarPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setNavBarPSSysCssName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().listByPSSysViewPanel(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysViewPanelLogicDTO> pssysviewpanellogics = new ArrayList<PSSysViewPanelLogicDTO>();
            for (PSSysViewPanelLogic pSSysViewPanelLogic : list) {
                dstItem = (PSSysViewPanelLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().toDTO(pSSysViewPanelLogic);
                pssysviewpanellogics.add((PSSysViewPanelLogicDTO)dstItem);
            }
            dto.setPssysviewpanellogics(pssysviewpanellogics);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysViewPanelModelService().listByPSSysViewPanel(t)) != null && list.size() > 0) {
            ArrayList<PSSysViewPanelModelDTO> pssysviewpanelmodels = new ArrayList<PSSysViewPanelModelDTO>();
            for (PSSysViewPanelModel pSSysViewPanelModel : list) {
                dstItem = (PSSysViewPanelModelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelModelService().toDTO(pSSysViewPanelModel);
                pssysviewpanelmodels.add((PSSysViewPanelModelDTO)dstItem);
            }
            dto.setPssysviewpanelmodels(pssysviewpanelmodels);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSPanelEngineService().listByPSSysViewPanel(t)) != null && list.size() > 0) {
            ArrayList<PSPanelEngineDTO> pspanelengines = new ArrayList<PSPanelEngineDTO>();
            for (PSPanelEngine pSPanelEngine : list) {
                dstItem = (PSPanelEngineDTO)PSModelServiceUtil.getInstance().getPSPanelEngineService().toDTO(pSPanelEngine);
                pspanelengines.add((PSPanelEngineDTO)dstItem);
            }
            dto.setPspanelengines(pspanelengines);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().listByPSSysViewPanel(t)) != null && list.size() > 0) {
            ArrayList<PSSysViewPanelItemDTO> pssysviewpanelitems = new ArrayList<PSSysViewPanelItemDTO>();
            for (PSSysViewPanelItem pSSysViewPanelItem : list) {
                dstItem = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().toDTO(pSSysViewPanelItem);
                pssysviewpanelitems.add((PSSysViewPanelItemDTO)dstItem);
            }
            dto.setPssysviewpanelitems(pssysviewpanelitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSVIEWPANEL";
    }

    @Override
    public PSSysViewPanel createDomain() {
        return new PSSysViewPanel();
    }

    @Override
    public PSSysViewPanelDTO createDTO() {
        return new PSSysViewPanelDTO();
    }
}

