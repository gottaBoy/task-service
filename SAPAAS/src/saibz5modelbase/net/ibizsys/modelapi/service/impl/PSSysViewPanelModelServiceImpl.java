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
import net.ibizsys.modelapi.domain.PSSysViewPanelModel;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelItemDTO;
import net.ibizsys.modelapi.dto.PSSysViewPanelModelDTO;
import net.ibizsys.modelapi.service.IPSSysViewPanelModelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysViewPanelModelServiceImpl
extends PSModelServiceImplBase<PSSysViewPanelModel, PSSysViewPanelModelDTO>
implements IPSSysViewPanelModelService {
    private static final Log log = LogFactory.getLog(PSSysViewPanelModelServiceImpl.class);

    @Override
    public List<PSSysViewPanelModel> listByPSSysViewPanel(PSSysViewPanel parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewPanelModel get(PSSysViewPanel parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewPanelModel> list = this.listByPSSysViewPanel(parent);
        if (list != null) {
            for (PSSysViewPanelModel item : list) {
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
    public List<PSSysViewPanelModelDTO> listDTOByPSSysViewPanel(String strParentKey) throws Exception {
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey);
        List<PSSysViewPanelModel> list = this.listByPSSysViewPanel(pssysviewpanel);
        if (list != null) {
            ArrayList<PSSysViewPanelModelDTO> dtoList = new ArrayList<PSSysViewPanelModelDTO>();
            for (PSSysViewPanelModel item : list) {
                PSSysViewPanelModelDTO dto = (PSSysViewPanelModelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysViewPanelModel> onListAll() throws Exception {
        ArrayList<PSSysViewPanelModel> list = new ArrayList<PSSysViewPanelModel>();
        List<PSSysViewPanel> pssysviewpanels = PSModelServiceUtil.getInstance().getPSSysViewPanelService().listAll();
        if (pssysviewpanels != null) {
            for (PSSysViewPanel parent : pssysviewpanels) {
                List<PSSysViewPanelModel> items = this.listByPSSysViewPanel(parent);
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
    protected PSSysViewPanelModel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysViewPanelModel item;
        PSSysViewPanel pssysviewpanel = (PSSysViewPanel)PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strParentKey, true);
        if (pssysviewpanel != null && (item = this.get(pssysviewpanel, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysViewPanelModel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysViewPanelModelDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysViewPanelId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewPanelService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysViewPanelModel et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysViewPanelModelName())) {
            return et.getPSSysViewPanelModelName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysViewPanelModelDTO dto, PSSysViewPanelModel t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysViewPanelModelId(t.getId().replace("/", "."));
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
        if (t.getCtrlModelName() != null || !bIgnoreNull) {
            dto.setCtrlModelName(t.getCtrlModelName());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDataType() != null || !bIgnoreNull) {
            dto.setDataType(t.getDataType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModelTag() != null || !bIgnoreNull) {
            dto.setModelTag(t.getModelTag());
        }
        if (t.getModelTag2() != null || !bIgnoreNull) {
            dto.setModelTag2(t.getModelTag2());
        }
        if (t.getModelType() != null || !bIgnoreNull) {
            dto.setModelType(t.getModelType());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
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
        if (t.getPSSysViewPanelModelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelModelName(t.getPSSysViewPanelModelName());
        }
        if (t.getPSSysViewPanelName() != null || !bIgnoreNull) {
            dto.setPSSysViewPanelName(t.getPSSysViewPanelName());
        }
        if (t.getRefFieldName() != null || !bIgnoreNull) {
            dto.setRefFieldName(t.getRefFieldName());
        }
        if (t.getRefModelName() != null || !bIgnoreNull) {
            dto.setRefModelName(t.getRefModelName());
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
        if (t.getViewModelName() != null || !bIgnoreNull) {
            dto.setViewModelName(t.getViewModelName());
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelId())) {
            linkDTO = (PSSysViewPanelDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelService().getDTO(dto.getPSSysViewPanelId());
            dto.setPSSysViewPanelName(((PSSysViewPanelDTO)linkDTO).getPSSysViewPanelName());
        } else {
            dto.setPSSysViewPanelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewPanelItemId())) {
            linkDTO = (PSSysViewPanelItemDTO)PSModelServiceUtil.getInstance().getPSSysViewPanelItemService().getDTO(dto.getPSSysViewPanelItemId());
            dto.setPSSysViewPanelItemName(((PSSysViewPanelItemDTO)linkDTO).getPSSysViewPanelItemName());
        } else {
            dto.setPSSysViewPanelItemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSVIEWPANELMODEL";
    }

    @Override
    public PSSysViewPanelModel createDomain() {
        return new PSSysViewPanelModel();
    }

    @Override
    public PSSysViewPanelModelDTO createDTO() {
        return new PSSysViewPanelModelDTO();
    }
}

