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
import net.ibizsys.modelapi.domain.PSSubSysSADE;
import net.ibizsys.modelapi.domain.PSSubSysSADEField;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSSubSysSADEFieldService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSubSysSADEFieldServiceImpl
extends PSModelServiceImplBase<PSSubSysSADEField, PSSubSysSADEFieldDTO>
implements IPSSubSysSADEFieldService {
    private static final Log log = LogFactory.getLog(PSSubSysSADEFieldServiceImpl.class);

    @Override
    public List<PSSubSysSADEField> listByPSSubSysSADE(PSSubSysSADE parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADEField get(PSSubSysSADE parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADEField> list = this.listByPSSubSysSADE(parent);
        if (list != null) {
            for (PSSubSysSADEField item : list) {
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
    public List<PSSubSysSADEFieldDTO> listDTOByPSSubSysSADE(String strParentKey) throws Exception {
        PSSubSysSADE pssubsyssade = (PSSubSysSADE)PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strParentKey);
        List<PSSubSysSADEField> list = this.listByPSSubSysSADE(pssubsyssade);
        if (list != null) {
            ArrayList<PSSubSysSADEFieldDTO> dtoList = new ArrayList<PSSubSysSADEFieldDTO>();
            for (PSSubSysSADEField item : list) {
                PSSubSysSADEFieldDTO dto = (PSSubSysSADEFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSubSysSADEField> onListAll() throws Exception {
        ArrayList<PSSubSysSADEField> list = new ArrayList<PSSubSysSADEField>();
        List pssubsyssades = PSModelServiceUtil.getInstance().getPSSubSysSADEService().listAll();
        if (pssubsyssades != null) {
            for (PSSubSysSADE parent : pssubsyssades) {
                List<PSSubSysSADEField> items = this.listByPSSubSysSADE(parent);
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
    protected PSSubSysSADEField onGet(String strParentKey, String strCurKey) throws Exception {
        PSSubSysSADEField item;
        PSSubSysSADE pssubsyssade = (PSSubSysSADE)PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strParentKey, true);
        if (pssubsyssade != null && (item = this.get(pssubsyssade, strCurKey, true)) != null) {
            return item;
        }
        return (PSSubSysSADEField)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSubSysSADEFieldDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSubSysSADEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysSADEService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSubSysSADEField et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSubSysSADEFieldName())) {
            return et.getPSSubSysSADEFieldName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSubSysSADEFieldDTO dto, PSSubSysSADEField t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSubSysSADEFieldId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getArrayFlag() != null || !bIgnoreNull) {
            dto.setArrayFlag(t.getArrayFlag());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getExampleValue() != null || !bIgnoreNull) {
            dto.setExampleValue(t.getExampleValue());
        }
        if (t.getFieldTag() != null || !bIgnoreNull) {
            dto.setFieldTag(t.getFieldTag());
        }
        if (t.getFieldTag2() != null || !bIgnoreNull) {
            dto.setFieldTag2(t.getFieldTag2());
        }
        if (t.getFieldType() != null || !bIgnoreNull) {
            dto.setFieldType(t.getFieldType());
        }
        if (t.getLength() != null || !bIgnoreNull) {
            dto.setLength(t.getLength());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMajorField() != null || !bIgnoreNull) {
            dto.setMajorField(t.getMajorField());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinStrLength() != null || !bIgnoreNull) {
            dto.setMinStrLength(t.getMinStrLength());
        }
        if (t.getMinValue() != null || !bIgnoreNull) {
            dto.setMinValue(t.getMinValue());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPKey() != null || !bIgnoreNull) {
            dto.setPKey(t.getPKey());
        }
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPredefinedType() != null || !bIgnoreNull) {
            dto.setPredefinedType(t.getPredefinedType());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDataTypeId() != null || !bIgnoreNull) {
            dto.setPSDataTypeId(t.getPSDataTypeId());
        }
        if (t.getPSDataTypeName() != null || !bIgnoreNull) {
            dto.setPSDataTypeName(t.getPSDataTypeName());
        }
        if (t.getPSSubSysSADEFieldName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEFieldName(t.getPSSubSysSADEFieldName());
        }
        if (t.getPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEId(t.getPSSubSysSADEId());
        }
        if (t.getPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADEName(t.getPSSubSysSADEName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getRefPSSubSysSADEId() != null || !bIgnoreNull) {
            dto.setRefPSSubSysSADEId(t.getRefPSSubSysSADEId());
        }
        if (t.getRefPSSubSysSADEName() != null || !bIgnoreNull) {
            dto.setRefPSSubSysSADEName(t.getRefPSSubSysSADEName());
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
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            dto.setPSSubSysSADEId(this.getRealPSModelId(t, dto.getPSSubSysSADEId()).replace("/", "."));
        }
        if ("PSSUBSYSSADE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysSADEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSubSysSADEId())) {
            dto.setRefPSSubSysSADEId(this.getRealPSModelId(t, dto.getRefPSSubSysSADEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getPSSubSysSADEId());
            dto.setPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
            dto.setPSSubSysServiceAPIId(((PSSubSysSADEDTO)linkDTO).getPSSubSysServiceAPIId());
        } else {
            dto.setPSSubSysSADEName(null);
            dto.setPSSubSysServiceAPIId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSubSysSADEId())) {
            linkDTO = (PSSubSysSADEDTO)PSModelServiceUtil.getInstance().getPSSubSysSADEService().getDTO(dto.getRefPSSubSysSADEId());
            dto.setRefPSSubSysSADEName(((PSSubSysSADEDTO)linkDTO).getPSSubSysSADEName());
        } else {
            dto.setRefPSSubSysSADEName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSUBSYSSADEFIELD";
    }

    @Override
    public PSSubSysSADEField createDomain() {
        return new PSSubSysSADEField();
    }

    @Override
    public PSSubSysSADEFieldDTO createDTO() {
        return new PSSubSysSADEFieldDTO();
    }
}

