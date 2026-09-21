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
import net.ibizsys.modelapi.domain.PSDEActionParam;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEActionParamDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEActionParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEActionParamServiceImpl
extends PSModelServiceImplBase<PSDEActionParam, PSDEActionParamDTO>
implements IPSDEActionParamService {
    private static final Log log = LogFactory.getLog(PSDEActionParamServiceImpl.class);

    @Override
    public List<PSDEActionParam> listByPSDEAction(PSDEAction parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEActionParam get(PSDEAction parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEActionParam> list = this.listByPSDEAction(parent);
        if (list != null) {
            for (PSDEActionParam item : list) {
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
    public List<PSDEActionParamDTO> listDTOByPSDEAction(String strParentKey) throws Exception {
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey);
        List<PSDEActionParam> list = this.listByPSDEAction(psdeaction);
        if (list != null) {
            ArrayList<PSDEActionParamDTO> dtoList = new ArrayList<PSDEActionParamDTO>();
            for (PSDEActionParam item : list) {
                PSDEActionParamDTO dto = (PSDEActionParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEActionParam> onListAll() throws Exception {
        ArrayList<PSDEActionParam> list = new ArrayList<PSDEActionParam>();
        List psdeactions = PSModelServiceUtil.getInstance().getPSDEActionService().listAll();
        if (psdeactions != null) {
            for (PSDEAction parent : psdeactions) {
                List<PSDEActionParam> items = this.listByPSDEAction(parent);
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
    protected PSDEActionParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEActionParam item;
        PSDEAction psdeaction = (PSDEAction)PSModelServiceUtil.getInstance().getPSDEActionService().get(strParentKey, true);
        if (psdeaction != null && (item = this.get(psdeaction, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEActionParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEActionParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEActionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEActionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEActionParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEActionParamName())) {
            return et.getPSDEActionParamName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEActionParamDTO dto, PSDEActionParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEActionParamId(t.getId().replace("/", "."));
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
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamDesc() != null || !bIgnoreNull) {
            dto.setParamDesc(t.getParamDesc());
        }
        if (t.getParamTag() != null || !bIgnoreNull) {
            dto.setParamTag(t.getParamTag());
        }
        if (t.getParamTag2() != null || !bIgnoreNull) {
            dto.setParamTag2(t.getParamTag2());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEActionParamName() != null || !bIgnoreNull) {
            dto.setPSDEActionParamName(t.getPSDEActionParamName());
        }
        if (t.getPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleId(t.getPSDEFValueRuleId());
        }
        if (t.getPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleName(t.getPSDEFValueRuleName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
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
        if (t.getValue() != null || !bIgnoreNull) {
            dto.setValue(t.getValue());
        }
        if (t.getValueDesc() != null || !bIgnoreNull) {
            dto.setValueDesc(t.getValueDesc());
        }
        if (t.getValueType() != null || !bIgnoreNull) {
            dto.setValueType(t.getValueType());
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if ("PSDEACTION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEActionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            dto.setPSDEFValueRuleId(this.getRealPSModelId(t, dto.getPSDEFValueRuleId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
            dto.setPSDEId(((PSDEActionDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEActionName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFValueRuleId());
            dto.setPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFValueRuleName(null);
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
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACTIONPARAM";
    }

    @Override
    public PSDEActionParam createDomain() {
        return new PSDEActionParam();
    }

    @Override
    public PSDEActionParamDTO createDTO() {
        return new PSDEActionParamDTO();
    }
}

