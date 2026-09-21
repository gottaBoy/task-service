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
import net.ibizsys.modelapi.domain.PSSysViewLogic;
import net.ibizsys.modelapi.domain.PSSysViewLogicParam;
import net.ibizsys.modelapi.dto.PSSysViewLogicDTO;
import net.ibizsys.modelapi.dto.PSSysViewLogicParamDTO;
import net.ibizsys.modelapi.service.IPSSysViewLogicParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysViewLogicParamServiceImpl
extends PSModelServiceImplBase<PSSysViewLogicParam, PSSysViewLogicParamDTO>
implements IPSSysViewLogicParamService {
    private static final Log log = LogFactory.getLog(PSSysViewLogicParamServiceImpl.class);

    @Override
    public List<PSSysViewLogicParam> listByPSSysViewLogic(PSSysViewLogic parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysViewLogicParam get(PSSysViewLogic parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysViewLogicParam> list = this.listByPSSysViewLogic(parent);
        if (list != null) {
            for (PSSysViewLogicParam item : list) {
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
    public List<PSSysViewLogicParamDTO> listDTOByPSSysViewLogic(String strParentKey) throws Exception {
        PSSysViewLogic pssysviewlogic = (PSSysViewLogic)PSModelServiceUtil.getInstance().getPSSysViewLogicService().get(strParentKey);
        List<PSSysViewLogicParam> list = this.listByPSSysViewLogic(pssysviewlogic);
        if (list != null) {
            ArrayList<PSSysViewLogicParamDTO> dtoList = new ArrayList<PSSysViewLogicParamDTO>();
            for (PSSysViewLogicParam item : list) {
                PSSysViewLogicParamDTO dto = (PSSysViewLogicParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysViewLogicParam> onListAll() throws Exception {
        ArrayList<PSSysViewLogicParam> list = new ArrayList<PSSysViewLogicParam>();
        List pssysviewlogics = PSModelServiceUtil.getInstance().getPSSysViewLogicService().listAll();
        if (pssysviewlogics != null) {
            for (PSSysViewLogic parent : pssysviewlogics) {
                List<PSSysViewLogicParam> items = this.listByPSSysViewLogic(parent);
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
    protected PSSysViewLogicParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysViewLogicParam item;
        PSSysViewLogic pssysviewlogic = (PSSysViewLogic)PSModelServiceUtil.getInstance().getPSSysViewLogicService().get(strParentKey, true);
        if (pssysviewlogic != null && (item = this.get(pssysviewlogic, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysViewLogicParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysViewLogicParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysViewLogicId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysViewLogicService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysViewLogicParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysViewLogicParamName())) {
            return et.getPSSysViewLogicParamName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysViewLogicParamDTO dto, PSSysViewLogicParam t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysViewLogicParamId(t.getId().replace("/", "."));
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
        if (t.getParamCat() != null || !bIgnoreNull) {
            dto.setParamCat(t.getParamCat());
        }
        if (t.getParamDesc() != null || !bIgnoreNull) {
            dto.setParamDesc(t.getParamDesc());
        }
        if (t.getParamKey() != null || !bIgnoreNull) {
            dto.setParamKey(t.getParamKey());
        }
        if (t.getParamState() != null || !bIgnoreNull) {
            dto.setParamState(t.getParamState());
        }
        if (t.getParamSubKey() != null || !bIgnoreNull) {
            dto.setParamSubKey(t.getParamSubKey());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getParamValue() != null || !bIgnoreNull) {
            dto.setParamValue(t.getParamValue());
        }
        if (t.getParamValue10() != null || !bIgnoreNull) {
            dto.setParamValue10(t.getParamValue10());
        }
        if (t.getParamValue2() != null || !bIgnoreNull) {
            dto.setParamValue2(t.getParamValue2());
        }
        if (t.getParamValue3() != null || !bIgnoreNull) {
            dto.setParamValue3(t.getParamValue3());
        }
        if (t.getParamValue4() != null || !bIgnoreNull) {
            dto.setParamValue4(t.getParamValue4());
        }
        if (t.getParamValue5() != null || !bIgnoreNull) {
            dto.setParamValue5(t.getParamValue5());
        }
        if (t.getParamValue6() != null || !bIgnoreNull) {
            dto.setParamValue6(t.getParamValue6());
        }
        if (t.getParamValue7() != null || !bIgnoreNull) {
            dto.setParamValue7(t.getParamValue7());
        }
        if (t.getParamValue8() != null || !bIgnoreNull) {
            dto.setParamValue8(t.getParamValue8());
        }
        if (t.getParamValue9() != null || !bIgnoreNull) {
            dto.setParamValue9(t.getParamValue9());
        }
        if (t.getPSSysViewLogicId() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicId(t.getPSSysViewLogicId());
        }
        if (t.getPSSysViewLogicName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicName(t.getPSSysViewLogicName());
        }
        if (t.getPSSysViewLogicParamName() != null || !bIgnoreNull) {
            dto.setPSSysViewLogicParamName(t.getPSSysViewLogicParamName());
        }
        if (t.getRefObjId() != null || !bIgnoreNull) {
            dto.setRefObjId(t.getRefObjId());
        }
        if (t.getRefObjName() != null || !bIgnoreNull) {
            dto.setRefObjName(t.getRefObjName());
        }
        if (t.getRefObjType() != null || !bIgnoreNull) {
            dto.setRefObjType(t.getRefObjType());
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
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            dto.setPSSysViewLogicId(this.getRealPSModelId(t, dto.getPSSysViewLogicId()).replace("/", "."));
        }
        if ("PSSYSVIEWLOGIC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysViewLogicId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysViewLogicId())) {
            PSSysViewLogicDTO linkDTO = (PSSysViewLogicDTO)PSModelServiceUtil.getInstance().getPSSysViewLogicService().getDTO(dto.getPSSysViewLogicId());
            dto.setPSSysViewLogicName(linkDTO.getPSSysViewLogicName());
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
        return "PSSYSVIEWLOGICPARAM";
    }

    @Override
    public PSSysViewLogicParam createDomain() {
        return new PSSysViewLogicParam();
    }

    @Override
    public PSSysViewLogicParamDTO createDTO() {
        return new PSSysViewLogicParamDTO();
    }
}

