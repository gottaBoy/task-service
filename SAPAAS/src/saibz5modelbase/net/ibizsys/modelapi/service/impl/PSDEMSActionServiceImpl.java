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
import net.ibizsys.modelapi.domain.PSDEMSAction;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEMSActionDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.service.IPSDEMSActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMSActionServiceImpl
extends PSModelServiceImplBase<PSDEMSAction, PSDEMSActionDTO>
implements IPSDEMSActionService {
    private static final Log log = LogFactory.getLog(PSDEMSActionServiceImpl.class);

    @Override
    public List<PSDEMSAction> listByPSDEMainState(PSDEMainState parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMSAction get(PSDEMainState parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMSAction> list = this.listByPSDEMainState(parent);
        if (list != null) {
            for (PSDEMSAction item : list) {
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
    public List<PSDEMSActionDTO> listDTOByPSDEMainState(String strParentKey) throws Exception {
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey);
        List<PSDEMSAction> list = this.listByPSDEMainState(psdemainstate);
        if (list != null) {
            ArrayList<PSDEMSActionDTO> dtoList = new ArrayList<PSDEMSActionDTO>();
            for (PSDEMSAction item : list) {
                PSDEMSActionDTO dto = (PSDEMSActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMSAction> onListAll() throws Exception {
        ArrayList<PSDEMSAction> list = new ArrayList<PSDEMSAction>();
        List<PSDEMainState> psdemainstates = PSModelServiceUtil.getInstance().getPSDEMainStateService().listAll();
        if (psdemainstates != null) {
            for (PSDEMainState parent : psdemainstates) {
                List<PSDEMSAction> items = this.listByPSDEMainState(parent);
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
    protected PSDEMSAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMSAction item;
        PSDEMainState psdemainstate = (PSDEMainState)PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strParentKey, true);
        if (psdemainstate != null && (item = this.get(psdemainstate, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMSAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMSActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEMSId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMainStateService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMSAction et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMSActionDTO dto, PSDEMSAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMSActionId(t.getId().replace("/", "."));
        }
        if (t.getAllowMode() != null || !bIgnoreNull) {
            dto.setAllowMode(t.getAllowMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMSActionName() != null || !bIgnoreNull) {
            dto.setPSDEMSActionName(t.getPSDEMSActionName());
        }
        if (t.getPSDEMSId() != null || !bIgnoreNull) {
            dto.setPSDEMSId(t.getPSDEMSId());
        }
        if (t.getPSDEMSName() != null || !bIgnoreNull) {
            dto.setPSDEMSName(t.getPSDEMSName());
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
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMSId())) {
            dto.setPSDEMSId(this.getRealPSModelId(t, dto.getPSDEMSId()).replace("/", "."));
        }
        if ("PSDEMAINSTATE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEMSId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMSId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMSId());
            dto.setAllowMode(((PSDEMainStateDTO)linkDTO).getAllowMode());
            dto.setPSDEId(((PSDEMainStateDTO)linkDTO).getPSDEId());
            dto.setPSDEMSName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setAllowMode(null);
            dto.setPSDEId(null);
            dto.setPSDEMSName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMSACTION";
    }

    @Override
    public PSDEMSAction createDomain() {
        return new PSDEMSAction();
    }

    @Override
    public PSDEMSActionDTO createDTO() {
        return new PSDEMSActionDTO();
    }
}

