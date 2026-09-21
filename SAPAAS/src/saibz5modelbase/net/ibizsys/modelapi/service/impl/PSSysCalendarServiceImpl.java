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
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCalendar;
import net.ibizsys.modelapi.domain.PSSysCalendarItem;
import net.ibizsys.modelapi.domain.PSSysCalendarLogic;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarItemDTO;
import net.ibizsys.modelapi.dto.PSSysCalendarLogicDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysCalendarService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysCalendarServiceImpl
extends PSModelServiceImplBase<PSSysCalendar, PSSysCalendarDTO>
implements IPSSysCalendarService {
    private static final Log log = LogFactory.getLog(PSSysCalendarServiceImpl.class);

    @Override
    public List<PSSysCalendar> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCalendar get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCalendar> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSSysCalendar item : list) {
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
    public List<PSSysCalendarDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSSysCalendar> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSSysCalendarDTO> dtoList = new ArrayList<PSSysCalendarDTO>();
            for (PSSysCalendar item : list) {
                PSSysCalendarDTO dto = (PSSysCalendarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysCalendar> listByPSModule(PSModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCalendar get(PSModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCalendar> list = this.listByPSModule(parent);
        if (list != null) {
            for (PSSysCalendar item : list) {
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
    public List<PSSysCalendarDTO> listDTOByPSModule(String strParentKey) throws Exception {
        PSModule psmodule = (PSModule)PSModelServiceUtil.getInstance().getPSModuleService().get(strParentKey);
        List<PSSysCalendar> list = this.listByPSModule(psmodule);
        if (list != null) {
            ArrayList<PSSysCalendarDTO> dtoList = new ArrayList<PSSysCalendarDTO>();
            for (PSSysCalendar item : list) {
                PSSysCalendarDTO dto = (PSSysCalendarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSSysCalendar> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysCalendar get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysCalendar> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysCalendar item : list) {
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
    public List<PSSysCalendarDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysCalendar> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysCalendarDTO> dtoList = new ArrayList<PSSysCalendarDTO>();
            for (PSSysCalendar item : list) {
                PSSysCalendarDTO dto = (PSSysCalendarDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysCalendar> onListAll() throws Exception {
        ArrayList<PSSysCalendar> list = new ArrayList<PSSysCalendar>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSSysCalendar> items = this.listByPSDataEntity(parent);
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
    protected PSSysCalendar onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysCalendar item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysCalendar)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysCalendarDTO dto) throws Exception {
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
    public String getModelTag(PSSysCalendar et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysCalendarDTO dto, PSSysCalendar t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysCalendarId(t.getId().replace("/", "."));
        }
        if (t.getBatPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarId(t.getBatPSDEToolbarId());
        }
        if (t.getBatPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setBatPSDEToolbarName(t.getBatPSDEToolbarName());
        }
        if (t.getCalendarStyle() != null || !bIgnoreNull) {
            dto.setCalendarStyle(t.getCalendarStyle());
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
        if (t.getEmptyText() != null || !bIgnoreNull) {
            dto.setEmptyText(t.getEmptyText());
        }
        if (t.getEmptyTextPSLanResId() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResId(t.getEmptyTextPSLanResId());
        }
        if (t.getEmptyTextPSLanResName() != null || !bIgnoreNull) {
            dto.setEmptyTextPSLanResName(t.getEmptyTextPSLanResName());
        }
        if (t.getGanttFlag() != null || !bIgnoreNull) {
            dto.setGanttFlag(t.getGanttFlag());
        }
        if (t.getGanttPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGanttPSSysPFPluginId(t.getGanttPSSysPFPluginId());
        }
        if (t.getGanttPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGanttPSSysPFPluginName(t.getGanttPSSysPFPluginName());
        }
        if (t.getGanttStyle() != null || !bIgnoreNull) {
            dto.setGanttStyle(t.getGanttStyle());
        }
        if (t.getGroupHeight() != null || !bIgnoreNull) {
            dto.setGroupHeight(t.getGroupHeight());
        }
        if (t.getGroupLayout() != null || !bIgnoreNull) {
            dto.setGroupLayout(t.getGroupLayout());
        }
        if (t.getGroupMode() != null || !bIgnoreNull) {
            dto.setGroupMode(t.getGroupMode());
        }
        if (t.getGroupPSCodeListId() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListId(t.getGroupPSCodeListId());
        }
        if (t.getGroupPSCodeListName() != null || !bIgnoreNull) {
            dto.setGroupPSCodeListName(t.getGroupPSCodeListName());
        }
        if (t.getGroupPSDEFId() != null || !bIgnoreNull) {
            dto.setGroupPSDEFId(t.getGroupPSDEFId());
        }
        if (t.getGroupPSDEFName() != null || !bIgnoreNull) {
            dto.setGroupPSDEFName(t.getGroupPSDEFName());
        }
        if (t.getGroupPSSysCssId() != null || !bIgnoreNull) {
            dto.setGroupPSSysCssId(t.getGroupPSSysCssId());
        }
        if (t.getGroupPSSysCssName() != null || !bIgnoreNull) {
            dto.setGroupPSSysCssName(t.getGroupPSSysCssName());
        }
        if (t.getGroupPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setGroupPSSysPFPluginId(t.getGroupPSSysPFPluginId());
        }
        if (t.getGroupPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setGroupPSSysPFPluginName(t.getGroupPSSysPFPluginName());
        }
        if (t.getGroupWidth() != null || !bIgnoreNull) {
            dto.setGroupWidth(t.getGroupWidth());
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
        if (t.getPSCtrlLogicGroupId() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupId(t.getPSCtrlLogicGroupId());
        }
        if (t.getPSCtrlLogicGroupName() != null || !bIgnoreNull) {
            dto.setPSCtrlLogicGroupName(t.getPSCtrlLogicGroupName());
        }
        if (t.getPSCtrlMsgId() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgId(t.getPSCtrlMsgId());
        }
        if (t.getPSCtrlMsgName() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgName(t.getPSCtrlMsgName());
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
        if (t.getPSSysCalendarName() != null || !bIgnoreNull) {
            dto.setPSSysCalendarName(t.getPSSysCalendarName());
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
        if (t.getQuickPSDEToolbarId() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarId(t.getQuickPSDEToolbarId());
        }
        if (t.getQuickPSDEToolbarName() != null || !bIgnoreNull) {
            dto.setQuickPSDEToolbarName(t.getQuickPSDEToolbarName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            dto.setBatPSDEToolbarId(this.getRealPSModelId(t, dto.getBatPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            dto.setEmptyTextPSLanResId(this.getRealPSModelId(t, dto.getEmptyTextPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGanttPSSysPFPluginId())) {
            dto.setGanttPSSysPFPluginId(this.getRealPSModelId(t, dto.getGanttPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            dto.setGroupPSCodeListId(this.getRealPSModelId(t, dto.getGroupPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            dto.setGroupPSDEFId(this.getRealPSModelId(t, dto.getGroupPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysCssId())) {
            dto.setGroupPSSysCssId(this.getRealPSModelId(t, dto.getGroupPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysPFPluginId())) {
            dto.setGroupPSSysPFPluginId(this.getRealPSModelId(t, dto.getGroupPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            dto.setPSCtrlLogicGroupId(this.getRealPSModelId(t, dto.getPSCtrlLogicGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            dto.setPSCtrlMsgId(this.getRealPSModelId(t, dto.getPSCtrlMsgId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            dto.setQuickPSDEToolbarId(this.getRealPSModelId(t, dto.getQuickPSDEToolbarId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBatPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getBatPSDEToolbarId());
            dto.setBatPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setBatPSDEToolbarName(null);
        }
        if (StringUtils.hasLength((String)dto.getEmptyTextPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getEmptyTextPSLanResId());
            dto.setEmptyTextPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setEmptyTextPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getGanttPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGanttPSSysPFPluginId());
            dto.setGanttPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGanttPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getGroupPSCodeListId());
            dto.setGroupPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setGroupPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getGroupPSDEFId());
            dto.setGroupPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setGroupPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getGroupPSSysCssId());
            dto.setGroupPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setGroupPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getGroupPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getGroupPSSysPFPluginId());
            dto.setGroupPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setGroupPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlLogicGroupId())) {
            linkDTO = (PSCtrlLogicGroupDTO)PSModelServiceUtil.getInstance().getPSCtrlLogicGroupService().getDTO(dto.getPSCtrlLogicGroupId());
            dto.setPSCtrlLogicGroupName(((PSCtrlLogicGroupDTO)linkDTO).getPSCtrlLogicGroupName());
        } else {
            dto.setPSCtrlLogicGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            linkDTO = (PSCtrlMsgDTO)PSModelServiceUtil.getInstance().getPSCtrlMsgService().getDTO(dto.getPSCtrlMsgId());
            dto.setPSCtrlMsgName(((PSCtrlMsgDTO)linkDTO).getPSCtrlMsgName());
        } else {
            dto.setPSCtrlMsgName(null);
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
        if (StringUtils.hasLength((String)dto.getQuickPSDEToolbarId())) {
            linkDTO = (PSDEToolbarDTO)PSModelServiceUtil.getInstance().getPSDEToolbarService().getDTO(dto.getQuickPSDEToolbarId());
            dto.setQuickPSDEToolbarName(((PSDEToolbarDTO)linkDTO).getPSDEToolbarName());
        } else {
            dto.setQuickPSDEToolbarName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSSysCalendarItemService().listByPSSysCalendar(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysCalendarItemDTO> pssyscalendaritems = new ArrayList<PSSysCalendarItemDTO>();
            for (PSSysCalendarItem pSSysCalendarItem : list) {
                dstItem = (PSSysCalendarItemDTO)PSModelServiceUtil.getInstance().getPSSysCalendarItemService().toDTO(pSSysCalendarItem);
                pssyscalendaritems.add((PSSysCalendarItemDTO)dstItem);
            }
            dto.setPssyscalendaritems(pssyscalendaritems);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSSysCalendarLogicService().listByPSSysCalendar(t)) != null && list.size() > 0) {
            ArrayList<PSSysCalendarLogicDTO> pssyscalendarlogics = new ArrayList<PSSysCalendarLogicDTO>();
            for (PSSysCalendarLogic pSSysCalendarLogic : list) {
                dstItem = (PSSysCalendarLogicDTO)PSModelServiceUtil.getInstance().getPSSysCalendarLogicService().toDTO(pSSysCalendarLogic);
                pssyscalendarlogics.add((PSSysCalendarLogicDTO)dstItem);
            }
            dto.setPssyscalendarlogics(pssyscalendarlogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSCALENDAR";
    }

    @Override
    public PSSysCalendar createDomain() {
        return new PSSysCalendar();
    }

    @Override
    public PSSysCalendarDTO createDTO() {
        return new PSSysCalendarDTO();
    }
}

