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
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionVR;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEActionVRDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEActionVRService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEActionVRServiceImpl
extends PSModelServiceImplBase<PSDEActionVR, PSDEActionVRDTO>
implements IPSDEActionVRService {
    private static final Log log = LogFactory.getLog(PSDEActionVRServiceImpl.class);

    @Override
    public List<PSDEActionVR> listByPSDEAction(PSDEAction parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEActionVR get(PSDEAction parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEActionVR> list = this.listByPSDEAction(parent);
        if (list != null) {
            for (PSDEActionVR item : list) {
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
    public List<PSDEActionVRDTO> listDTOByPSDEAction(String strParentKey) throws Exception {
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey);
        List<PSDEActionVR> list = this.listByPSDEAction(psdeaction);
        if (list != null) {
            ArrayList<PSDEActionVRDTO> dtoList = new ArrayList<PSDEActionVRDTO>();
            for (PSDEActionVR item : list) {
                PSDEActionVRDTO dto = (PSDEActionVRDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEActionVR> onListAll() throws Exception {
        ArrayList<PSDEActionVR> list = new ArrayList<PSDEActionVR>();
        List<PSDEAction> psdeactions = PSModelServiceUtil.getInstance().getPSDEActionService().listAll();
        if (psdeactions != null) {
            for (PSDEAction parent : psdeactions) {
                List<PSDEActionVR> items = this.listByPSDEAction(parent);
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
    protected PSDEActionVR onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEActionVR item;
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey, true);
        if (psdeaction != null && (item = this.get(psdeaction, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEActionVR)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEActionVRDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEActionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEActionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEActionVR et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEActionVRDTO dto, PSDEActionVR t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEActionVRId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEActionVRName() != null || !bIgnoreNull) {
            dto.setPSDEActionVRName(t.getPSDEActionVRName());
        }
        if (t.getPSDEFVRId() != null || !bIgnoreNull) {
            dto.setPSDEFVRId(t.getPSDEFVRId());
        }
        if (t.getPSDEFVRName() != null || !bIgnoreNull) {
            dto.setPSDEFVRName(t.getPSDEFVRName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
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
        if (t.getVRType() != null || !bIgnoreNull) {
            dto.setVRType(t.getVRType());
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if ("PSDEACTION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEActionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            dto.setPSDEFVRId(this.getRealPSModelId(t, dto.getPSDEFVRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
            dto.setPSDEId(((PSDEActionDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEActionName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFVRId());
            dto.setPSDEFVRName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFVRName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACTIONVR";
    }

    @Override
    public PSDEActionVR createDomain() {
        return new PSDEActionVR();
    }

    @Override
    public PSDEActionVRDTO createDTO() {
        return new PSDEActionVRDTO();
    }
}

