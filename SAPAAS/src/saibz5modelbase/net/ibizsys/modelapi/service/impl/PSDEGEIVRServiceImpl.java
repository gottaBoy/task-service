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
import net.ibizsys.modelapi.domain.PSDEGEIVR;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEGEIVRDTO;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEGEIVRService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGEIVRServiceImpl
extends PSModelServiceImplBase<PSDEGEIVR, PSDEGEIVRDTO>
implements IPSDEGEIVRService {
    private static final Log log = LogFactory.getLog(PSDEGEIVRServiceImpl.class);

    @Override
    public List<PSDEGEIVR> listByPSDEGrid(PSDEGrid parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGEIVR get(PSDEGrid parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGEIVR> list = this.listByPSDEGrid(parent);
        if (list != null) {
            for (PSDEGEIVR item : list) {
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
    public List<PSDEGEIVRDTO> listDTOByPSDEGrid(String strParentKey) throws Exception {
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey);
        List<PSDEGEIVR> list = this.listByPSDEGrid(psdegrid);
        if (list != null) {
            ArrayList<PSDEGEIVRDTO> dtoList = new ArrayList<PSDEGEIVRDTO>();
            for (PSDEGEIVR item : list) {
                PSDEGEIVRDTO dto = (PSDEGEIVRDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGEIVR> onListAll() throws Exception {
        ArrayList<PSDEGEIVR> list = new ArrayList<PSDEGEIVR>();
        List<PSDEGrid> psdegrids = PSModelServiceUtil.getInstance().getPSDEGridService().listAll();
        if (psdegrids != null) {
            for (PSDEGrid parent : psdegrids) {
                List<PSDEGEIVR> items = this.listByPSDEGrid(parent);
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
    protected PSDEGEIVR onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGEIVR item;
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey, true);
        if (psdegrid != null && (item = this.get(psdegrid, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGEIVR)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGEIVRDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEGridId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGridService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGEIVR et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGEIVRDTO dto, PSDEGEIVR t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGEIVRId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEFVRId() != null || !bIgnoreNull) {
            dto.setPSDEFVRId(t.getPSDEFVRId());
        }
        if (t.getPSDEFVRName() != null || !bIgnoreNull) {
            dto.setPSDEFVRName(t.getPSDEFVRName());
        }
        if (t.getPSDEGEIVRName() != null || !bIgnoreNull) {
            dto.setPSDEGEIVRName(t.getPSDEGEIVRName());
        }
        if (t.getPSDEGridColId() != null || !bIgnoreNull) {
            dto.setPSDEGridColId(t.getPSDEGridColId());
        }
        if (t.getPSDEGridColName() != null || !bIgnoreNull) {
            dto.setPSDEGridColName(t.getPSDEGridColName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
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
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            dto.setPSDEFVRId(this.getRealPSModelId(t, dto.getPSDEFVRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridColId())) {
            dto.setPSDEGridColId(this.getRealPSModelId(t, dto.getPSDEGridColId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        }
        if ("PSDEGRID".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGridId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFVRId());
            dto.setPSDEFVRName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFVRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridColId())) {
            linkDTO = (PSDEGridColDTO)PSModelServiceUtil.getInstance().getPSDEGridColService().getDTO(dto.getPSDEGridColId(), true);
            if (linkDTO != null) {
                dto.setPSDEGridColName(((PSDEGridColDTO)linkDTO).getPSDEGridColName());
            }
        } else {
            dto.setPSDEGridColName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId(), true);
            if (linkDTO != null) {
                dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
            }
        } else {
            dto.setPSDEGridName(null);
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
        return "PSDEGEIVR";
    }

    @Override
    public PSDEGEIVR createDomain() {
        return new PSDEGEIVR();
    }

    @Override
    public PSDEGEIVRDTO createDTO() {
        return new PSDEGEIVRDTO();
    }
}

