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
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.domain.PSSysViewPanelLogic;
import net.ibizsys.modelapi.dto.PSAppFuncDTO;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.service.IPSSysViewPanelLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysViewPanelLogicServiceImpl
extends PSModelServiceImplBase<PSSysViewPanelLogic, PSSysViewPanelLogicDTO>
implements IPSSysViewPanelLogicService {
    private static final Log log = LogFactory.getLog(PSSysViewPanelLogicServiceImpl.class);

    @Override
    public List<PSSysViewPanelLogic> listByPSSysViewPanel(PSSysViewPanel parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanelLogic get(PSSysViewPanel parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanelLogic> list = this.listByPSSysViewPanel(parent);
        if (list != null) {
            for (PSSysViewPanelLogic item : list) {
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
    public List<PSSysViewPanelLogicDTO> listDTOByPSSysViewPanel(String strParentKey) throws Exception {
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey);
        List<PSSysViewPanelLogic> list = this.listByPSSysViewPanel(pssysviewpanel);
        if (list != null) {
            ArrayList<PSSysViewPanelLogicDTO> dtoList = new ArrayList<PSSysViewPanelLogicDTO>();
            for (PSSysViewPanelLogic item : list) {
                PSSysViewPanelLogicDTO dto = (PSSysViewPanelLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysViewPanelLogic> onListAll() throws Exception {
        ArrayList<PSSysViewPanelLogic> list = new ArrayList<PSSysViewPanelLogic>();
        List pssysviewpanels = PSModelServiceUtil.getInstance().getPSSysViewPanelService().listAll();
        if (pssysviewpanels != null) {
            for (PSSysViewPanel parent : pssysviewpanels) {
                List<PSSysViewPanelLogic> items = this.listByPSSysViewPanel(parent);
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
    protected PSSysViewPanelLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysViewPanelLogic item;
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey, true);
        if (pssysviewpanel != null && (item = this.get(pssysviewpanel, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysViewPanelLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysViewPanelLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysViewPanelId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysViewPanelLogic et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysViewPanelLogicName())) {
            return et.getPSSysViewPanelLogicName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysViewPanelLogicDTO dto, PSSysViewPanelLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysViewPanelLogicId(t.getId().replace("/", "."));
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
        if (t.getCtrlEvent() != null || !bIgnoreNull) {
            dto.setCtrlEvent(t.getCtrlEvent());
        }
        if (t.getCtrlEventArg() != null || !bIgnoreNull) {
            dto.setCtrlEventArg(t.getCtrlEventArg());
        }
        if (t.getCtrlEventArg2() != null || !bIgnoreNull) {
            dto.setCtrlEventArg2(t.getCtrlEventArg2());
        }
        if (t.getCtrlEventName() != null || !bIgnoreNull) {
            dto.setCtrlEventName(t.getCtrlEventName());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getDstLogicType() != null || !bIgnoreNull) {
            dto.setDstLogicType(t.getDstLogicType());
        }
        if (t.getLogicParam() != null || !bIgnoreNull) {
            dto.setLogicParam(t.getLogicParam());
        }
        if (t.getLogicParam2() != null || !bIgnoreNull) {
            dto.setLogicParam2(t.getLogicParam2());
        }
        if (t.getLogicType() != null || !bIgnoreNull) {
            dto.setLogicType(t.getLogicType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamPSPanelItemId() != null || !bIgnoreNull) {
            dto.setParamPSPanelItemId(t.getParamPSPanelItemId());
        }
        if (t.getParamPSPanelItemName() != null || !bIgnoreNull) {
            dto.setParamPSPanelItemName(t.getParamPSPanelItemName());
        }
        if (t.getPSAppFuncId() != null || !bIgnoreNull) {
            dto.setPSAppFuncId(t.getPSAppFuncId());
        }
        if (t.getPSAppFuncName() != null || !bIgnoreNull) {
            dto.setPSAppFuncName(t.getPSAppFuncName());
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
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSysViewLogicId() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicId(t.getPSSysViewLogicId());
        }
        if (t.getPSSysViewLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicName(t.getPSSysViewLogicName());
        }
        if (t.getPSSysViewPanelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelId(t.getPSSysViewPanelId());
        }
        if (t.getPSSysViewPanelItemId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelItemId(t.getPSSysViewPanelItemId());
        }
        if (t.getPSSysViewPanelItemName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelItemName(t.getPSSysViewPanelItemName());
        }
        if (t.getPSSysViewPanelLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelLogicName(t.getPSSysViewPanelLogicName());
        }
        if (t.getPSSysViewPanelModelId() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelModelId(t.getPSSysViewPanelModelId());
        }
        if (t.getPSSysViewPanelModelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelModelName(t.getPSSysViewPanelModelName());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getTimer() != null || !bIgnoreNull) {
            dto.setTimer(t.getTimer());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getParamPSPanelItemId())) {
            dto.setParamPSPanelItemId(this.getRealPSModelId(t, dto.getParamPSPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppFuncId())) {
            dto.setPSAppFuncId(this.getRealPSModelId(t, dto.getPSAppFuncId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if ("PSSYSVIEWPANEL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewPanelId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelItemId())) {
            dto.setPSSysViewPanelItemId(this.getRealPSModelId(t, dto.getPSSysViewPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelModelId())) {
            dto.setPSSysViewPanelModelId(this.getRealPSModelId(t, dto.getPSSysViewPanelModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getParamPSPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getParamPSPanelItemId());
            dto.setParamPSPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setParamPSPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppFuncId())) {
            linkDTO = (PSAppFuncDTO)PSModelServiceUtil.getInstance().getPSAppFuncService().getDTO(dto.getPSAppFuncId());
            dto.setPSAppFuncName(((PSAppFuncDTO)linkDTO).getPSAppFuncName());
        } else {
            dto.setPSAppFuncName(null);
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
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSystemId(((PSSysViewPanelDTO)linkDTO).getPSSystemId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSystemId(null);
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getPSSysViewPanelItemId(), true);
            if (linkDTO != null) {
                dto.setPSSysViewPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
            }
        } else {
            dto.setPSSysViewPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelModelId())) {
            linkDTO = (PSSysViewPanelModelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelModelService().getDTO(dto.getPSSysViewPanelModelId());
            dto.setPSSysViewPanelModelName(((PSSysViewPanelModelDTO)linkDTO).getPSSysViewPanelModelName());
        } else {
            dto.setPSSysViewPanelModelName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSVIEWPANELLOGIC";
    }

    @Override
    public PSSysViewPanelLogic createDomain() {
        return new PSSysViewPanelLogic();
    }

    @Override
    public PSSysViewPanelLogicDTO createDTO() {
        return new PSSysViewPanelLogicDTO();
    }
}

