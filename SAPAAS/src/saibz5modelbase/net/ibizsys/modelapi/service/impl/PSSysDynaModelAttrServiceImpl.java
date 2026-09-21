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
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSysDynaModelAttr;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelAttrDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSSysDynaModelAttrService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDynaModelAttrServiceImpl
extends PSModelServiceImplBase<PSSysDynaModelAttr, PSSysDynaModelAttrDTO>
implements IPSSysDynaModelAttrService {
    private static final Log log = LogFactory.getLog(PSSysDynaModelAttrServiceImpl.class);

    @Override
    public List<PSSysDynaModelAttr> listByPSSysDynaModel(PSSysDynaModel parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDynaModelAttr get(PSSysDynaModel parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDynaModelAttr> list = this.listByPSSysDynaModel(parent);
        if (list != null) {
            for (PSSysDynaModelAttr item : list) {
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
    public List<PSSysDynaModelAttrDTO> listDTOByPSSysDynaModel(String strParentKey) throws Exception {
        PSSysDynaModel pssysdynamodel = (PSSysDynaModel)PSModelServiceUtil.getInstance().getPSSysDynaModelService().get(strParentKey);
        List<PSSysDynaModelAttr> list = this.listByPSSysDynaModel(pssysdynamodel);
        if (list != null) {
            ArrayList<PSSysDynaModelAttrDTO> dtoList = new ArrayList<PSSysDynaModelAttrDTO>();
            for (PSSysDynaModelAttr item : list) {
                PSSysDynaModelAttrDTO dto = (PSSysDynaModelAttrDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDynaModelAttr> onListAll() throws Exception {
        ArrayList<PSSysDynaModelAttr> list = new ArrayList<PSSysDynaModelAttr>();
        List pssysdynamodels = PSModelServiceUtil.getInstance().getPSSysDynaModelService().listAll();
        if (pssysdynamodels != null) {
            for (PSSysDynaModel parent : pssysdynamodels) {
                List<PSSysDynaModelAttr> items = this.listByPSSysDynaModel(parent);
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
    protected PSSysDynaModelAttr onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDynaModelAttr item;
        PSSysDynaModel pssysdynamodel = (PSSysDynaModel)PSModelServiceUtil.getInstance().getPSSysDynaModelService().get(strParentKey, true);
        if (pssysdynamodel != null && (item = this.get(pssysdynamodel, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDynaModelAttr)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDynaModelAttrDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysDynaModelId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysDynaModelService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDynaModelAttr et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDynaModelAttrName())) {
            return et.getPSSysDynaModelAttrName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDynaModelAttrDTO dto, PSSysDynaModelAttr t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDynaModelAttrId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getArrayFlag() != null || !bIgnoreNull) {
            dto.setArrayFlag(t.getArrayFlag());
        }
        if (t.getAttrTag() != null || !bIgnoreNull) {
            dto.setAttrTag(t.getAttrTag());
        }
        if (t.getAttrTag2() != null || !bIgnoreNull) {
            dto.setAttrTag2(t.getAttrTag2());
        }
        if (t.getAttrValue() != null || !bIgnoreNull) {
            dto.setAttrValue(t.getAttrValue());
        }
        if (t.getAttrValue10() != null || !bIgnoreNull) {
            dto.setAttrValue10(t.getAttrValue10());
        }
        if (t.getAttrValue11() != null || !bIgnoreNull) {
            dto.setAttrValue11(t.getAttrValue11());
        }
        if (t.getAttrValue12() != null || !bIgnoreNull) {
            dto.setAttrValue12(t.getAttrValue12());
        }
        if (t.getAttrValue13() != null || !bIgnoreNull) {
            dto.setAttrValue13(t.getAttrValue13());
        }
        if (t.getAttrValue14() != null || !bIgnoreNull) {
            dto.setAttrValue14(t.getAttrValue14());
        }
        if (t.getAttrValue15() != null || !bIgnoreNull) {
            dto.setAttrValue15(t.getAttrValue15());
        }
        if (t.getAttrValue16() != null || !bIgnoreNull) {
            dto.setAttrValue16(t.getAttrValue16());
        }
        if (t.getAttrValue2() != null || !bIgnoreNull) {
            dto.setAttrValue2(t.getAttrValue2());
        }
        if (t.getAttrValue20() != null || !bIgnoreNull) {
            dto.setAttrValue20(t.getAttrValue20());
        }
        if (t.getAttrValue21() != null || !bIgnoreNull) {
            dto.setAttrValue21(t.getAttrValue21());
        }
        if (t.getAttrValue22() != null || !bIgnoreNull) {
            dto.setAttrValue22(t.getAttrValue22());
        }
        if (t.getAttrValue23() != null || !bIgnoreNull) {
            dto.setAttrValue23(t.getAttrValue23());
        }
        if (t.getAttrValue24() != null || !bIgnoreNull) {
            dto.setAttrValue24(t.getAttrValue24());
        }
        if (t.getAttrValue25() != null || !bIgnoreNull) {
            dto.setAttrValue25(t.getAttrValue25());
        }
        if (t.getAttrValue26() != null || !bIgnoreNull) {
            dto.setAttrValue26(t.getAttrValue26());
        }
        if (t.getAttrValue27() != null || !bIgnoreNull) {
            dto.setAttrValue27(t.getAttrValue27());
        }
        if (t.getAttrValue28() != null || !bIgnoreNull) {
            dto.setAttrValue28(t.getAttrValue28());
        }
        if (t.getAttrValue29() != null || !bIgnoreNull) {
            dto.setAttrValue29(t.getAttrValue29());
        }
        if (t.getAttrValue3() != null || !bIgnoreNull) {
            dto.setAttrValue3(t.getAttrValue3());
        }
        if (t.getAttrValue30() != null || !bIgnoreNull) {
            dto.setAttrValue30(t.getAttrValue30());
        }
        if (t.getAttrValue4() != null || !bIgnoreNull) {
            dto.setAttrValue4(t.getAttrValue4());
        }
        if (t.getAttrValue5() != null || !bIgnoreNull) {
            dto.setAttrValue5(t.getAttrValue5());
        }
        if (t.getAttrValue6() != null || !bIgnoreNull) {
            dto.setAttrValue6(t.getAttrValue6());
        }
        if (t.getAttrValue7() != null || !bIgnoreNull) {
            dto.setAttrValue7(t.getAttrValue7());
        }
        if (t.getAttrValue8() != null || !bIgnoreNull) {
            dto.setAttrValue8(t.getAttrValue8());
        }
        if (t.getAttrValue9() != null || !bIgnoreNull) {
            dto.setAttrValue9(t.getAttrValue9());
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
        if (t.getDynaModelUsage() != null || !bIgnoreNull) {
            dto.setDynaModelUsage(t.getDynaModelUsage());
        }
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSSysDynaModelAttrName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelAttrName(t.getPSSysDynaModelAttrName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getRefPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setRefPSDEFGroupId(t.getRefPSDEFGroupId());
        }
        if (t.getRefPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setRefPSDEFGroupName(t.getRefPSDEFGroupName());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRefPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setRefPSSysDynaModelId(t.getRefPSSysDynaModelId());
        }
        if (t.getRefPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setRefPSSysDynaModelName(t.getRefPSSysDynaModelName());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
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
        if (t.getValueType() != null || !bIgnoreNull) {
            dto.setValueType(t.getValueType());
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if ("PSSYSDYNAMODEL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysDynaModelId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEFGroupId())) {
            dto.setRefPSDEFGroupId(this.getRealPSModelId(t, dto.getRefPSDEFGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDynaModelId())) {
            dto.setRefPSSysDynaModelId(this.getRealPSModelId(t, dto.getRefPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setDynaModelUsage(((PSSysDynaModelDTO)linkDTO).getDynaModelUsage());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setDynaModelUsage(null);
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getRefPSDEFGroupId());
            dto.setRefPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setRefPSDEFGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getRefPSSysDynaModelId());
            dto.setRefPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setRefPSSysDynaModelName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDYNAMODELATTR";
    }

    @Override
    public PSSysDynaModelAttr createDomain() {
        return new PSSysDynaModelAttr();
    }

    @Override
    public PSSysDynaModelAttrDTO createDTO() {
        return new PSSysDynaModelAttrDTO();
    }
}

