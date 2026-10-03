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
import net.ibizsys.modelapi.domain.PSAppMenuLogic;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppMenuLogicDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.service.IPSAppMenuLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppMenuLogicServiceImpl
extends PSModelServiceImplBase<PSAppMenuLogic, PSAppMenuLogicDTO>
implements IPSAppMenuLogicService {
    private static final Log log = LogFactory.getLog(PSAppMenuLogicServiceImpl.class);

    @Override
    public List<PSAppMenuLogic> listByPSAppMenu(PSAppMenu parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppMenuLogic get(PSAppMenu parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppMenuLogic> list = this.listByPSAppMenu(parent);
        if (list != null) {
            for (PSAppMenuLogic item : list) {
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
    public List<PSAppMenuLogicDTO> listDTOByPSAppMenu(String strParentKey) throws Exception {
        PSAppMenu psappmenu = (PSAppMenu)PSModelServiceUtil.getInstance().getPSAppMenuService().get(strParentKey);
        List<PSAppMenuLogic> list = this.listByPSAppMenu(psappmenu);
        if (list != null) {
            ArrayList<PSAppMenuLogicDTO> dtoList = new ArrayList<PSAppMenuLogicDTO>();
            for (PSAppMenuLogic item : list) {
                PSAppMenuLogicDTO dto = (PSAppMenuLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppMenuLogic> onListAll() throws Exception {
        ArrayList<PSAppMenuLogic> list = new ArrayList<PSAppMenuLogic>();
        List<PSAppMenu> psappmenus = PSModelServiceUtil.getInstance().getPSAppMenuService().listAll();
        if (psappmenus != null) {
            for (PSAppMenu parent : psappmenus) {
                List<PSAppMenuLogic> items = this.listByPSAppMenu(parent);
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
    protected PSAppMenuLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppMenuLogic item;
        PSAppMenu psappmenu = (PSAppMenu)PSModelServiceUtil.getInstance().getPSAppMenuService().get(strParentKey, true);
        if (psappmenu != null && (item = this.get(psappmenu, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppMenuLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppMenuLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSAppMenuId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppMenuService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppMenuLogic et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppMenuLogicName())) {
            return et.getPSAppMenuLogicName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppMenuLogicDTO dto, PSAppMenuLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppMenuLogicId(t.getId().replace("/", "."));
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
        if (t.getDstLogicType() != null || !bIgnoreNull) {
            dto.setDstLogicType(t.getDstLogicType());
        }
        if (t.getEventArg() != null || !bIgnoreNull) {
            dto.setEventArg(t.getEventArg());
        }
        if (t.getEventArg2() != null || !bIgnoreNull) {
            dto.setEventArg2(t.getEventArg2());
        }
        if (t.getEventNames() != null || !bIgnoreNull) {
            dto.setEventNames(t.getEventNames());
        }
        if (t.getLogicParam() != null || !bIgnoreNull) {
            dto.setLogicParam(t.getLogicParam());
        }
        if (t.getLogicParam2() != null || !bIgnoreNull) {
            dto.setLogicParam2(t.getLogicParam2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuLogicName() != null || !bIgnoreNull) {
            dto.setPSAppMenuLogicName(t.getPSAppMenuLogicName());
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
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysViewLogicId() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicId(t.getPSSysViewLogicId());
        }
        if (t.getPSSysViewLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicName(t.getPSSysViewLogicName());
        }
        if (t.getTimer() != null || !bIgnoreNull) {
            dto.setTimer(t.getTimer());
        }
        if (t.getTriggerType() != null || !bIgnoreNull) {
            dto.setTriggerType(t.getTriggerType());
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
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if ("PSAPPMENU".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppMenuId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDELogicId())) {
            dto.setPSDELogicId(this.getRealPSModelId(t, dto.getPSDELogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            dto.setPSSysViewLogicId(this.getRealPSModelId(t, dto.getPSSysViewLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
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
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            linkDTO = (PSSysViewLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewLogicService().getDTO(dto.getPSSysViewLogicId());
            dto.setPSSysViewLogicName(((PSSysViewLogicDTO)linkDTO).getPSSysViewLogicName());
        } else {
            dto.setPSSysViewLogicName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPMENULOGIC";
    }

    @Override
    public PSAppMenuLogic createDomain() {
        return new PSAppMenuLogic();
    }

    @Override
    public PSAppMenuLogicDTO createDTO() {
        return new PSAppMenuLogicDTO();
    }
}

