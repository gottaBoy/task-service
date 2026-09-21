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
import net.ibizsys.modelapi.domain.PSDEFIVR;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSDEFIVRDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEFIVRService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFIVRServiceImpl
extends PSModelServiceImplBase<PSDEFIVR, PSDEFIVRDTO>
implements IPSDEFIVRService {
    private static final Log log = LogFactory.getLog(PSDEFIVRServiceImpl.class);

    @Override
    public List<PSDEFIVR> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFIVR get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFIVR> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFIVR item : list) {
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
    public List<PSDEFIVRDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFIVR> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFIVRDTO> dtoList = new ArrayList<PSDEFIVRDTO>();
            for (PSDEFIVR item : list) {
                PSDEFIVRDTO dto = (PSDEFIVRDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFIVR> onListAll() throws Exception {
        ArrayList<PSDEFIVR> list = new ArrayList<PSDEFIVR>();
        List psdeforms = PSModelServiceUtil.getInstance().getPSDEFormService().listAll();
        if (psdeforms != null) {
            for (PSDEForm parent : psdeforms) {
                List<PSDEFIVR> items = this.listByPSDEForm(parent);
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
    protected PSDEFIVR onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFIVR item;
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey, true);
        if (psdeform != null && (item = this.get(psdeform, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFIVR)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFIVRDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFIVR et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFIVRDTO dto, PSDEFIVR t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFIVRId(t.getId().replace("/", "."));
        }
        if (t.getCheckMode() != null || !bIgnoreNull) {
            dto.setCheckMode(t.getCheckMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEFIId() != null || !bIgnoreNull) {
            dto.setPSDEFIId(t.getPSDEFIId());
        }
        if (t.getPSDEFIName() != null || !bIgnoreNull) {
            dto.setPSDEFIName(t.getPSDEFIName());
        }
        if (t.getPSDEFIVRName() != null || !bIgnoreNull) {
            dto.setPSDEFIVRName(t.getPSDEFIVRName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEFVRId() != null || !bIgnoreNull) {
            dto.setPSDEFVRId(t.getPSDEFVRId());
        }
        if (t.getPSDEFVRName() != null || !bIgnoreNull) {
            dto.setPSDEFVRName(t.getPSDEFVRName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
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
        if (t.getVRType() != null || !bIgnoreNull) {
            dto.setVRType(t.getVRType());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFIId())) {
            dto.setPSDEFIId(this.getRealPSModelId(t, dto.getPSDEFIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            dto.setPSDEFVRId(this.getRealPSModelId(t, dto.getPSDEFVRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFIId())) {
            linkDTO = (PSDEFormDetailDTO)PSModelServiceUtil.getInstance().getPSDEFormDetailService().getDTO(dto.getPSDEFIId(), true);
            if (linkDTO != null) {
                dto.setPSDEFIName(((PSDEFormDetailDTO)linkDTO).getPSDEFormDetailName());
            }
        } else {
            dto.setPSDEFIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId(), true);
            if (linkDTO != null) {
                dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
            }
        } else {
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFVRId());
            dto.setPSDEFVRName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFVRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFIVR";
    }

    @Override
    public PSDEFIVR createDomain() {
        return new PSDEFIVR();
    }

    @Override
    public PSDEFIVRDTO createDTO() {
        return new PSDEFIVRDTO();
    }
}

