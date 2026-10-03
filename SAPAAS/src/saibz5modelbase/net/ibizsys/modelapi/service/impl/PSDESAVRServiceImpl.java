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
import net.ibizsys.modelapi.domain.PSDESAVR;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDESAVRDTO;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDESAVRService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDESAVRServiceImpl
extends PSModelServiceImplBase<PSDESAVR, PSDESAVRDTO>
implements IPSDESAVRService {
    private static final Log log = LogFactory.getLog(PSDESAVRServiceImpl.class);

    @Override
    public List<PSDESAVR> listByPSDEServiceAPI(PSDEServiceAPI parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESAVR get(PSDEServiceAPI parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESAVR> list = this.listByPSDEServiceAPI(parent);
        if (list != null) {
            for (PSDESAVR item : list) {
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
    public List<PSDESAVRDTO> listDTOByPSDEServiceAPI(String strParentKey) throws Exception {
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey);
        List<PSDESAVR> list = this.listByPSDEServiceAPI(psdeserviceapi);
        if (list != null) {
            ArrayList<PSDESAVRDTO> dtoList = new ArrayList<PSDESAVRDTO>();
            for (PSDESAVR item : list) {
                PSDESAVRDTO dto = (PSDESAVRDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDESAVR> onListAll() throws Exception {
        ArrayList<PSDESAVR> list = new ArrayList<PSDESAVR>();
        List<PSDEServiceAPI> psdeserviceapis = PSModelServiceUtil.getInstance().getPSDEServiceAPIService().listAll();
        if (psdeserviceapis != null) {
            for (PSDEServiceAPI parent : psdeserviceapis) {
                List<PSDESAVR> items = this.listByPSDEServiceAPI(parent);
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
    protected PSDESAVR onGet(String strParentKey, String strCurKey) throws Exception {
        PSDESAVR item;
        PSDEServiceAPI psdeserviceapi = (PSDEServiceAPI)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strParentKey, true);
        if (psdeserviceapi != null && (item = this.get(psdeserviceapi, strCurKey, true)) != null) {
            return item;
        }
        return (PSDESAVR)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDESAVRDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEServiceAPIId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEServiceAPIService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDESAVR et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDESAVRDTO dto, PSDESAVR t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDESAVRId(t.getId().replace("/", "."));
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
        if (t.getPSDEFVRId() != null || !bIgnoreNull) {
            dto.setPSDEFVRId(t.getPSDEFVRId());
        }
        if (t.getPSDEFVRName() != null || !bIgnoreNull) {
            dto.setPSDEFVRName(t.getPSDEFVRName());
        }
        if (t.getPSDESAVRName() != null || !bIgnoreNull) {
            dto.setPSDESAVRName(t.getPSDESAVRName());
        }
        if (t.getPSDEServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIId(t.getPSDEServiceAPIId());
        }
        if (t.getPSDEServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSDEServiceAPIName(t.getPSDEServiceAPIName());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getVRType() != null || !bIgnoreNull) {
            dto.setVRType(t.getVRType());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            dto.setPSDEFVRId(this.getRealPSModelId(t, dto.getPSDEFVRId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            dto.setPSDEServiceAPIId(this.getRealPSModelId(t, dto.getPSDEServiceAPIId()).replace("/", "."));
        }
        if ("PSDESERVICEAPI".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEServiceAPIId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEServiceAPIId())) {
            linkDTO = (PSDEServiceAPIDTO)PSModelServiceUtil.getInstance().getPSDEServiceAPIService().getDTO(dto.getPSDEServiceAPIId());
            dto.setPSDEServiceAPIName(((PSDEServiceAPIDTO)linkDTO).getPSDEServiceAPIName());
        } else {
            dto.setPSDEServiceAPIName(null);
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
    public String getModelName() {
        return "PSDESAVR";
    }

    @Override
    public PSDESAVR createDomain() {
        return new PSDESAVR();
    }

    @Override
    public PSDESAVRDTO createDTO() {
        return new PSDESAVRDTO();
    }
}

