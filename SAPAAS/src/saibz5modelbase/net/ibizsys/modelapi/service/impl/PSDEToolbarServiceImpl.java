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
import net.ibizsys.modelapi.domain.PSDETBItem;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDEToolbarLogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSDETBItemDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarLogicDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSDEToolbarService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEToolbarServiceImpl
extends PSModelServiceImplBase<PSDEToolbar, PSDEToolbarDTO>
implements IPSDEToolbarService {
    private static final Log log = LogFactory.getLog(PSDEToolbarServiceImpl.class);

    @Override
    public List<PSDEToolbar> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEToolbar get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEToolbar> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEToolbar item : list) {
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
    public List<PSDEToolbarDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEToolbar> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEToolbarDTO> dtoList = new ArrayList<PSDEToolbarDTO>();
            for (PSDEToolbar item : list) {
                PSDEToolbarDTO dto = (PSDEToolbarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEToolbar> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEToolbar get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEToolbar> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSDEToolbar item : list) {
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
    public List<PSDEToolbarDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSDEToolbar> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSDEToolbarDTO> dtoList = new ArrayList<PSDEToolbarDTO>();
            for (PSDEToolbar item : list) {
                PSDEToolbarDTO dto = (PSDEToolbarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEToolbar> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEToolbar get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEToolbar> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSDEToolbar item : list) {
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
    public List<PSDEToolbarDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSDEToolbar> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSDEToolbarDTO> dtoList = new ArrayList<PSDEToolbarDTO>();
            for (PSDEToolbar item : list) {
                PSDEToolbarDTO dto = (PSDEToolbarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEToolbar> onListAll() throws Exception {
        List pssystems;
        List psmodules;
        ArrayList<PSDEToolbar> list = new ArrayList<PSDEToolbar>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEToolbar> items = this.listByPSDataEntity(parent);
                if (items == null) continue;
                list.addAll((Collection<PSDEToolbar>)items);
            }
        }
        if ((psmodules = PSModelServiceUtil.getInstance().getPSModuleService().listAll()) != null) {
            for (PSModule parent : psmodules) {
                List<PSDEToolbar> items = this.listByPSModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll()) != null) {
            for (PSSystem parent : pssystems) {
                List<PSDEToolbar> items = this.listByPSSystem(parent);
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
    protected PSDEToolbar onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEToolbar item;
        PSDEToolbar item2;
        PSDEToolbar item3;
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
        return (PSDEToolbar)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEToolbarDTO dto) throws Exception {
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
    public String getModelTag(PSDEToolbar et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEToolbarDTO dto, PSDEToolbar t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEToolbarId(t.getId().replace("/", "."));
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
        if (t.getIconAlign() != null || !bIgnoreNull) {
            dto.setIconAlign(t.getIconAlign());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMobFlag() != null || !bIgnoreNull) {
            dto.setMobFlag(t.getMobFlag());
        }
        if (t.getNo2PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupId(t.getNo2PSDEUAGroupId());
        }
        if (t.getNo2PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo2PSDEUAGroupName(t.getNo2PSDEUAGroupName());
        }
        if (t.getNo3PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo3PSDEUAGroupId(t.getNo3PSDEUAGroupId());
        }
        if (t.getNo3PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo3PSDEUAGroupName(t.getNo3PSDEUAGroupName());
        }
        if (t.getNo4PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo4PSDEUAGroupId(t.getNo4PSDEUAGroupId());
        }
        if (t.getNo4PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo4PSDEUAGroupName(t.getNo4PSDEUAGroupName());
        }
        if (t.getNo5PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo5PSDEUAGroupId(t.getNo5PSDEUAGroupId());
        }
        if (t.getNo5PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo5PSDEUAGroupName(t.getNo5PSDEUAGroupName());
        }
        if (t.getNo6PSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setNo6PSDEUAGroupId(t.getNo6PSDEUAGroupId());
        }
        if (t.getNo6PSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setNo6PSDEUAGroupName(t.getNo6PSDEUAGroupName());
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
        if (t.getPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setPSDEToolbarName(t.getPSDEToolbarName());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
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
        if (t.getPSSysToolbarId() != null || !bIgnoreNull) {
            dto.setPSSysToolbarId(t.getPSSysToolbarId());
        }
        if (t.getPSSysToolbarName() != null || !bIgnoreNull) {
            dto.setPSSysToolbarName(t.getPSSysToolbarName());
        }
        if (t.getTemplToolbar() != null || !bIgnoreNull) {
            dto.setTemplToolbar(t.getTemplToolbar());
        }
        if (t.getToolbarSN() != null || !bIgnoreNull) {
            dto.setToolbarSN(t.getToolbarSN());
        }
        if (t.getToolbarStyle() != null || !bIgnoreNull) {
            dto.setToolbarStyle(t.getToolbarStyle());
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
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            dto.setNo2PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo2PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEUAGroupId())) {
            dto.setNo3PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo3PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEUAGroupId())) {
            dto.setNo4PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo4PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo5PSDEUAGroupId())) {
            dto.setNo5PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo5PSDEUAGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo6PSDEUAGroupId())) {
            dto.setNo6PSDEUAGroupId(this.getRealPSModelId(t, dto.getNo6PSDEUAGroupId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getNo2PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo2PSDEUAGroupId());
            dto.setNo2PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo2PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo3PSDEUAGroupId());
            dto.setNo3PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo3PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo4PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo4PSDEUAGroupId());
            dto.setNo4PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo4PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo5PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo5PSDEUAGroupId());
            dto.setNo5PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo5PSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo6PSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getNo6PSDEUAGroupId());
            dto.setNo6PSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setNo6PSDEUAGroupName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEUAGroupName(null);
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
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSDETBItemService().listByPSDEToolbar(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDETBItemDTO> psdetbitems = new ArrayList<PSDETBItemDTO>();
            for (PSDETBItem pSDETBItem : list) {
                dstItem = (PSDETBItemDTO)PSModelServiceUtil.getInstance().getPSDETBItemService().toDTO(pSDETBItem);
                psdetbitems.add((PSDETBItemDTO)dstItem);
            }
            dto.setPsdetbitems(psdetbitems);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSDEToolbarLogicService().listByPSDEToolbar(t)) != null && list.size() > 0) {
            ArrayList<PSDEToolbarLogicDTO> psdetoolbarlogics = new ArrayList<PSDEToolbarLogicDTO>();
            for (PSDEToolbarLogic pSDEToolbarLogic : list) {
                dstItem = (PSDEToolbarLogicDTO)PSModelServiceUtil.getInstance().getPSDEToolbarLogicService().toDTO(pSDEToolbarLogic);
                psdetoolbarlogics.add((PSDEToolbarLogicDTO)dstItem);
            }
            dto.setPsdetoolbarlogics(psdetoolbarlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDETOOLBAR";
    }

    @Override
    public PSDEToolbar createDomain() {
        return new PSDEToolbar();
    }

    @Override
    public PSDEToolbarDTO createDTO() {
        return new PSDEToolbarDTO();
    }
}

