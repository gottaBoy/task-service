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
import net.ibizsys.modelapi.domain.PSPanelEngine;
import net.ibizsys.modelapi.domain.PSSysViewPanel;
import net.ibizsys.modelapi.dto.PSPanelEngineDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelLogicDTO;
import net.ibizsys.modelapi.service.IPSPanelEngineService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSPanelEngineServiceImpl
extends PSModelServiceImplBase<PSPanelEngine, PSPanelEngineDTO>
implements IPSPanelEngineService {
    private static final Log log = LogFactory.getLog(PSPanelEngineServiceImpl.class);

    @Override
    public List<PSPanelEngine> listByPSSysViewPanel(PSSysViewPanel parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSPanelEngine get(PSSysViewPanel parent, String strKey, boolean bTryMode) throws Exception {
        List<PSPanelEngine> list = this.listByPSSysViewPanel(parent);
        if (list != null) {
            for (PSPanelEngine item : list) {
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
    public List<PSPanelEngineDTO> listDTOByPSSysViewPanel(String strParentKey) throws Exception {
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey);
        List<PSPanelEngine> list = this.listByPSSysViewPanel(pssysviewpanel);
        if (list != null) {
            ArrayList<PSPanelEngineDTO> dtoList = new ArrayList<PSPanelEngineDTO>();
            for (PSPanelEngine item : list) {
                PSPanelEngineDTO dto = (PSPanelEngineDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSPanelEngine> onListAll() throws Exception {
        ArrayList<PSPanelEngine> list = new ArrayList<PSPanelEngine>();
        List<PSSysViewPanel> pssysviewpanels = PSModelServiceUtil.getInstance().getPSSysViewPanelService().listAll();
        if (pssysviewpanels != null) {
            for (PSSysViewPanel parent : pssysviewpanels) {
                List<PSPanelEngine> items = this.listByPSSysViewPanel(parent);
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
    protected PSPanelEngine onGet(String strParentKey, String strCurKey) throws Exception {
        PSPanelEngine item;
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey, true);
        if (pssysviewpanel != null && (item = this.get(pssysviewpanel, strCurKey, true)) != null) {
            return item;
        }
        return (PSPanelEngine)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSPanelEngineDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysViewPanelId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSPanelEngine et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSPanelEngineName())) {
            return et.getPSPanelEngineName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSPanelEngineDTO dto, PSPanelEngine t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSPanelEngineId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getEngineParam() != null || !bIgnoreNull) {
            dto.setEngineParam(t.getEngineParam());
        }
        if (t.getEngineParam10() != null || !bIgnoreNull) {
            dto.setEngineParam10(t.getEngineParam10());
        }
        if (t.getEngineParam10Flag() != null || !bIgnoreNull) {
            dto.setEngineParam10Flag(t.getEngineParam10Flag());
        }
        if (t.getEngineParam10Label() != null || !bIgnoreNull) {
            dto.setEngineParam10Label(t.getEngineParam10Label());
        }
        if (t.getEngineParam2() != null || !bIgnoreNull) {
            dto.setEngineParam2(t.getEngineParam2());
        }
        if (t.getEngineParam2Flag() != null || !bIgnoreNull) {
            dto.setEngineParam2Flag(t.getEngineParam2Flag());
        }
        if (t.getEngineParam2Label() != null || !bIgnoreNull) {
            dto.setEngineParam2Label(t.getEngineParam2Label());
        }
        if (t.getEngineParam3() != null || !bIgnoreNull) {
            dto.setEngineParam3(t.getEngineParam3());
        }
        if (t.getEngineParam3Flag() != null || !bIgnoreNull) {
            dto.setEngineParam3Flag(t.getEngineParam3Flag());
        }
        if (t.getEngineParam3Label() != null || !bIgnoreNull) {
            dto.setEngineParam3Label(t.getEngineParam3Label());
        }
        if (t.getEngineParam4() != null || !bIgnoreNull) {
            dto.setEngineParam4(t.getEngineParam4());
        }
        if (t.getEngineParam4Flag() != null || !bIgnoreNull) {
            dto.setEngineParam4Flag(t.getEngineParam4Flag());
        }
        if (t.getEngineParam4Label() != null || !bIgnoreNull) {
            dto.setEngineParam4Label(t.getEngineParam4Label());
        }
        if (t.getEngineParam5() != null || !bIgnoreNull) {
            dto.setEngineParam5(t.getEngineParam5());
        }
        if (t.getEngineParam5Flag() != null || !bIgnoreNull) {
            dto.setEngineParam5Flag(t.getEngineParam5Flag());
        }
        if (t.getEngineParam5Label() != null || !bIgnoreNull) {
            dto.setEngineParam5Label(t.getEngineParam5Label());
        }
        if (t.getEngineParam6() != null || !bIgnoreNull) {
            dto.setEngineParam6(t.getEngineParam6());
        }
        if (t.getEngineParam6Flag() != null || !bIgnoreNull) {
            dto.setEngineParam6Flag(t.getEngineParam6Flag());
        }
        if (t.getEngineParam6Label() != null || !bIgnoreNull) {
            dto.setEngineParam6Label(t.getEngineParam6Label());
        }
        if (t.getEngineParam7() != null || !bIgnoreNull) {
            dto.setEngineParam7(t.getEngineParam7());
        }
        if (t.getEngineParam7Flag() != null || !bIgnoreNull) {
            dto.setEngineParam7Flag(t.getEngineParam7Flag());
        }
        if (t.getEngineParam7Label() != null || !bIgnoreNull) {
            dto.setEngineParam7Label(t.getEngineParam7Label());
        }
        if (t.getEngineParam8() != null || !bIgnoreNull) {
            dto.setEngineParam8(t.getEngineParam8());
        }
        if (t.getEngineParam8Flag() != null || !bIgnoreNull) {
            dto.setEngineParam8Flag(t.getEngineParam8Flag());
        }
        if (t.getEngineParam8Label() != null || !bIgnoreNull) {
            dto.setEngineParam8Label(t.getEngineParam8Label());
        }
        if (t.getEngineParam9() != null || !bIgnoreNull) {
            dto.setEngineParam9(t.getEngineParam9());
        }
        if (t.getEngineParam9Flag() != null || !bIgnoreNull) {
            dto.setEngineParam9Flag(t.getEngineParam9Flag());
        }
        if (t.getEngineParam9Label() != null || !bIgnoreNull) {
            dto.setEngineParam9Label(t.getEngineParam9Label());
        }
        if (t.getEngineParamFlag() != null || !bIgnoreNull) {
            dto.setEngineParamFlag(t.getEngineParamFlag());
        }
        if (t.getEngineParamLabel() != null || !bIgnoreNull) {
            dto.setEngineParamLabel(t.getEngineParamLabel());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNo2PanelItemFlag() != null || !bIgnoreNull) {
            dto.setNo2PanelItemFlag(t.getNo2PanelItemFlag());
        }
        if (t.getNo2PanelItemLabel() != null || !bIgnoreNull) {
            dto.setNo2PanelItemLabel(t.getNo2PanelItemLabel());
        }
        if (t.getNo2PanelLogicFlag() != null || !bIgnoreNull) {
            dto.setNo2PanelLogicFlag(t.getNo2PanelLogicFlag());
        }
        if (t.getNo2PanelLogicLabel() != null || !bIgnoreNull) {
            dto.setNo2PanelLogicLabel(t.getNo2PanelLogicLabel());
        }
        if (t.getNo2PSPanelItemId() != null || !bIgnoreNull) {
            dto.setNo2PSPanelItemId(t.getNo2PSPanelItemId());
        }
        if (t.getNo2PSPanelItemName() != null || !bIgnoreNull) {
            dto.setNo2PSPanelItemName(t.getNo2PSPanelItemName());
        }
        if (t.getNo2PSPanelLogicId() != null || !bIgnoreNull) {
            dto.setNo2PSPanelLogicId(t.getNo2PSPanelLogicId());
        }
        if (t.getNo2PSPanelLogicName() != null || !bIgnoreNull) {
            dto.setNo2PSPanelLogicName(t.getNo2PSPanelLogicName());
        }
        if (t.getNo3PanelItemFlag() != null || !bIgnoreNull) {
            dto.setNo3PanelItemFlag(t.getNo3PanelItemFlag());
        }
        if (t.getNo3PanelItemLabel() != null || !bIgnoreNull) {
            dto.setNo3PanelItemLabel(t.getNo3PanelItemLabel());
        }
        if (t.getNo3PanelLogicFlag() != null || !bIgnoreNull) {
            dto.setNo3PanelLogicFlag(t.getNo3PanelLogicFlag());
        }
        if (t.getNo3PanelLogicLabel() != null || !bIgnoreNull) {
            dto.setNo3PanelLogicLabel(t.getNo3PanelLogicLabel());
        }
        if (t.getNo3PSPanelItemId() != null || !bIgnoreNull) {
            dto.setNo3PSPanelItemId(t.getNo3PSPanelItemId());
        }
        if (t.getNo3PSPanelItemName() != null || !bIgnoreNull) {
            dto.setNo3PSPanelItemName(t.getNo3PSPanelItemName());
        }
        if (t.getNo3PSPanelLogicId() != null || !bIgnoreNull) {
            dto.setNo3PSPanelLogicId(t.getNo3PSPanelLogicId());
        }
        if (t.getNo3PSPanelLogicName() != null || !bIgnoreNull) {
            dto.setNo3PSPanelLogicName(t.getNo3PSPanelLogicName());
        }
        if (t.getNo4PanelItemFlag() != null || !bIgnoreNull) {
            dto.setNo4PanelItemFlag(t.getNo4PanelItemFlag());
        }
        if (t.getNo4PanelItemLabel() != null || !bIgnoreNull) {
            dto.setNo4PanelItemLabel(t.getNo4PanelItemLabel());
        }
        if (t.getNo4PanelLogicFlag() != null || !bIgnoreNull) {
            dto.setNo4PanelLogicFlag(t.getNo4PanelLogicFlag());
        }
        if (t.getNo4PanelLogicLabel() != null || !bIgnoreNull) {
            dto.setNo4PanelLogicLabel(t.getNo4PanelLogicLabel());
        }
        if (t.getNo4PSPanelItemId() != null || !bIgnoreNull) {
            dto.setNo4PSPanelItemId(t.getNo4PSPanelItemId());
        }
        if (t.getNo4PSPanelItemName() != null || !bIgnoreNull) {
            dto.setNo4PSPanelItemName(t.getNo4PSPanelItemName());
        }
        if (t.getNo4PSPanelLogicId() != null || !bIgnoreNull) {
            dto.setNo4PSPanelLogicId(t.getNo4PSPanelLogicId());
        }
        if (t.getNo4PSPanelLogicName() != null || !bIgnoreNull) {
            dto.setNo4PSPanelLogicName(t.getNo4PSPanelLogicName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPanelItemFlag() != null || !bIgnoreNull) {
            dto.setPanelItemFlag(t.getPanelItemFlag());
        }
        if (t.getPanelItemLabel() != null || !bIgnoreNull) {
            dto.setPanelItemLabel(t.getPanelItemLabel());
        }
        if (t.getPanelLogicFlag() != null || !bIgnoreNull) {
            dto.setPanelLogicFlag(t.getPanelLogicFlag());
        }
        if (t.getPanelLogicLabel() != null || !bIgnoreNull) {
            dto.setPanelLogicLabel(t.getPanelLogicLabel());
        }
        if (t.getPSPanelEngineName() != null || !bIgnoreNull) {
            dto.setPSPanelEngineName(t.getPSPanelEngineName());
        }
        if (t.getPSPanelItemId() != null || !bIgnoreNull) {
            dto.setPSPanelItemId(t.getPSPanelItemId());
        }
        if (t.getPSPanelItemName() != null || !bIgnoreNull) {
            dto.setPSPanelItemName(t.getPSPanelItemName());
        }
        if (t.getPSPanelLogicId() != null || !bIgnoreNull) {
            dto.setPSPanelLogicId(t.getPSPanelLogicId());
        }
        if (t.getPSPanelLogicName() != null || !bIgnoreNull) {
            dto.setPSPanelLogicName(t.getPSPanelLogicName());
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
        if (t.getPSUIEngineTypeId() != null || !bIgnoreNull) {
            dto.setPSUIEngineTypeId(t.getPSUIEngineTypeId());
        }
        if (t.getPSUIEngineTypeName() != null || !bIgnoreNull) {
            dto.setPSUIEngineTypeName(t.getPSUIEngineTypeName());
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
        if (t.getViewParam() != null || !bIgnoreNull) {
            dto.setViewParam(t.getViewParam());
        }
        if (t.getViewParam10() != null || !bIgnoreNull) {
            dto.setViewParam10(t.getViewParam10());
        }
        if (t.getViewParam2() != null || !bIgnoreNull) {
            dto.setViewParam2(t.getViewParam2());
        }
        if (t.getViewParam3() != null || !bIgnoreNull) {
            dto.setViewParam3(t.getViewParam3());
        }
        if (t.getViewParam4() != null || !bIgnoreNull) {
            dto.setViewParam4(t.getViewParam4());
        }
        if (t.getViewParam5() != null || !bIgnoreNull) {
            dto.setViewParam5(t.getViewParam5());
        }
        if (t.getViewParam6() != null || !bIgnoreNull) {
            dto.setViewParam6(t.getViewParam6());
        }
        if (t.getViewParam7() != null || !bIgnoreNull) {
            dto.setViewParam7(t.getViewParam7());
        }
        if (t.getViewParam8() != null || !bIgnoreNull) {
            dto.setViewParam8(t.getViewParam8());
        }
        if (t.getViewParam9() != null || !bIgnoreNull) {
            dto.setViewParam9(t.getViewParam9());
        }
        if (t.getWFViewParam() != null || !bIgnoreNull) {
            dto.setWFViewParam(t.getWFViewParam());
        }
        if (t.getWFViewParam2() != null || !bIgnoreNull) {
            dto.setWFViewParam2(t.getWFViewParam2());
        }
        if (t.getWFViewParam3() != null || !bIgnoreNull) {
            dto.setWFViewParam3(t.getWFViewParam3());
        }
        if (t.getWFViewParam4() != null || !bIgnoreNull) {
            dto.setWFViewParam4(t.getWFViewParam4());
        }
        if (StringUtils.hasLength((String)dto.getNo2PSPanelItemId())) {
            dto.setNo2PSPanelItemId(this.getRealPSModelId(t, dto.getNo2PSPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSPanelLogicId())) {
            dto.setNo2PSPanelLogicId(this.getRealPSModelId(t, dto.getNo2PSPanelLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3PSPanelItemId())) {
            dto.setNo3PSPanelItemId(this.getRealPSModelId(t, dto.getNo3PSPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo3PSPanelLogicId())) {
            dto.setNo3PSPanelLogicId(this.getRealPSModelId(t, dto.getNo3PSPanelLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo4PSPanelItemId())) {
            dto.setNo4PSPanelItemId(this.getRealPSModelId(t, dto.getNo4PSPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo4PSPanelLogicId())) {
            dto.setNo4PSPanelLogicId(this.getRealPSModelId(t, dto.getNo4PSPanelLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSPanelItemId())) {
            dto.setPSPanelItemId(this.getRealPSModelId(t, dto.getPSPanelItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSPanelLogicId())) {
            dto.setPSPanelLogicId(this.getRealPSModelId(t, dto.getPSPanelLogicId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            dto.setPSSysViewPanelId(this.getRealPSModelId(t, dto.getPSSysViewPanelId()).replace("/", "."));
        }
        if ("PSSYSVIEWPANEL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewPanelId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNo2PSPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getNo2PSPanelItemId());
            dto.setNo2PSPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setNo2PSPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo2PSPanelLogicId())) {
            linkDTO = (PSSysViewPanelLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().getDTO(dto.getNo2PSPanelLogicId());
            dto.setNo2PSPanelLogicName(((PSSysViewPanelLogicDTO)linkDTO).getPSSysViewPanelLogicName());
        } else {
            dto.setNo2PSPanelLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3PSPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getNo3PSPanelItemId());
            dto.setNo3PSPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setNo3PSPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo3PSPanelLogicId())) {
            linkDTO = (PSSysViewPanelLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().getDTO(dto.getNo3PSPanelLogicId());
            dto.setNo3PSPanelLogicName(((PSSysViewPanelLogicDTO)linkDTO).getPSSysViewPanelLogicName());
        } else {
            dto.setNo3PSPanelLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo4PSPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getNo4PSPanelItemId());
            dto.setNo4PSPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setNo4PSPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getNo4PSPanelLogicId())) {
            linkDTO = (PSSysViewPanelLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().getDTO(dto.getNo4PSPanelLogicId());
            dto.setNo4PSPanelLogicName(((PSSysViewPanelLogicDTO)linkDTO).getPSSysViewPanelLogicName());
        } else {
            dto.setNo4PSPanelLogicName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getPSPanelItemId());
            dto.setPSPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setPSPanelItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSPanelLogicId())) {
            linkDTO = (PSSysViewPanelLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelLogicService().getDTO(dto.getPSPanelLogicId());
            dto.setPSPanelLogicName(((PSSysViewPanelLogicDTO)linkDTO).getPSSysViewPanelLogicName());
        } else {
            dto.setPSPanelLogicName(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSPANELENGINE";
    }

    @Override
    public PSPanelEngine createDomain() {
        return new PSPanelEngine();
    }

    @Override
    public PSPanelEngineDTO createDTO() {
        return new PSPanelEngineDTO();
    }
}

