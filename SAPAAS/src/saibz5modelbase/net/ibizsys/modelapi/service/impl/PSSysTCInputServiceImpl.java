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
import net.ibizsys.modelapi.domain.PSSysTCInput;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSSysSampleValueDTO;
import net.ibizsys.modelapi.dto.PSSysTCInputDTO;
import net.ibizsys.modelapi.dto.PSSysTestCaseDTO;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.service.IPSSysTCInputService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTCInputServiceImpl
extends PSModelServiceImplBase<PSSysTCInput, PSSysTCInputDTO>
implements IPSSysTCInputService {
    private static final Log log = LogFactory.getLog(PSSysTCInputServiceImpl.class);

    @Override
    public List<PSSysTCInput> listByPSSysTestCase(PSSysTestCase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTCInput get(PSSysTestCase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTCInput> list = this.listByPSSysTestCase(parent);
        if (list != null) {
            for (PSSysTCInput item : list) {
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
    public List<PSSysTCInputDTO> listDTOByPSSysTestCase(String strParentKey) throws Exception {
        PSSysTestCase pssystestcase = (PSSysTestCase)PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strParentKey);
        List<PSSysTCInput> list = this.listByPSSysTestCase(pssystestcase);
        if (list != null) {
            ArrayList<PSSysTCInputDTO> dtoList = new ArrayList<PSSysTCInputDTO>();
            for (PSSysTCInput item : list) {
                PSSysTCInputDTO dto = (PSSysTCInputDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTCInput> onListAll() throws Exception {
        ArrayList<PSSysTCInput> list = new ArrayList<PSSysTCInput>();
        List pssystestcases = PSModelServiceUtil.getInstance().getPSSysTestCaseService().listAll();
        if (pssystestcases != null) {
            for (PSSysTestCase parent : pssystestcases) {
                List<PSSysTCInput> items = this.listByPSSysTestCase(parent);
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
    protected PSSysTCInput onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTCInput item;
        PSSysTestCase pssystestcase = (PSSysTestCase)PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strParentKey, true);
        if (pssystestcase != null && (item = this.get(pssystestcase, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTCInput)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTCInputDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysTestCaseId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysTCInput et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysTCInputName())) {
            return et.getPSSysTCInputName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTCInputDTO dto, PSSysTCInput t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTCInputId(t.getId().replace("/", "."));
        }
        if (t.getActionParams() != null || !bIgnoreNull) {
            dto.setActionParams(t.getActionParams());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getDEFPSSysSampleValueId() != null || !bIgnoreNull) {
            dto.setDEFPSSysSampleValueId(t.getDEFPSSysSampleValueId());
        }
        if (t.getDEFPSSysSampleValueName() != null || !bIgnoreNull) {
            dto.setDEFPSSysSampleValueName(t.getDEFPSSysSampleValueName());
        }
        if (t.getDEFValue() != null || !bIgnoreNull) {
            dto.setDEFValue(t.getDEFValue());
        }
        if (t.getInputTag() != null || !bIgnoreNull) {
            dto.setInputTag(t.getInputTag());
        }
        if (t.getInputTag2() != null || !bIgnoreNull) {
            dto.setInputTag2(t.getInputTag2());
        }
        if (t.getInputTag3() != null || !bIgnoreNull) {
            dto.setInputTag3(t.getInputTag3());
        }
        if (t.getInputTag4() != null || !bIgnoreNull) {
            dto.setInputTag4(t.getInputTag4());
        }
        if (t.getInputType() != null || !bIgnoreNull) {
            dto.setInputType(t.getInputType());
        }
        if (t.getInputValues() != null || !bIgnoreNull) {
            dto.setInputValues(t.getInputValues());
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
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysTCInputName() != null || !bIgnoreNull) {
            dto.setPSSysTCInputName(t.getPSSysTCInputName());
        }
        if (t.getPSSysTestCaseId() != null || !bIgnoreNull) {
            dto.setPSSysTestCaseId(t.getPSSysTestCaseId());
        }
        if (t.getPSSysTestCaseName() != null || !bIgnoreNull) {
            dto.setPSSysTestCaseName(t.getPSSysTestCaseName());
        }
        if (t.getPSSysTestDataId() != null || !bIgnoreNull) {
            dto.setPSSysTestDataId(t.getPSSysTestDataId());
        }
        if (t.getPSSysTestDataName() != null || !bIgnoreNull) {
            dto.setPSSysTestDataName(t.getPSSysTestDataName());
        }
        if (t.getTargetType() != null || !bIgnoreNull) {
            dto.setTargetType(t.getTargetType());
        }
        if (t.getTestDataSN() != null || !bIgnoreNull) {
            dto.setTestDataSN(t.getTestDataSN());
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
        if (StringUtils.hasLength((String)dto.getDEFPSSysSampleValueId())) {
            dto.setDEFPSSysSampleValueId(this.getRealPSModelId(t, dto.getDEFPSSysSampleValueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestCaseId())) {
            dto.setPSSysTestCaseId(this.getRealPSModelId(t, dto.getPSSysTestCaseId()).replace("/", "."));
        }
        if ("PSSYSTESTCASE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysTestCaseId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            dto.setPSSysTestDataId(this.getRealPSModelId(t, dto.getPSSysTestDataId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDEFPSSysSampleValueId())) {
            linkDTO = (PSSysSampleValueDTO)PSModelServiceUtil.getInstance().getPSSysSampleValueService().getDTO(dto.getDEFPSSysSampleValueId());
            dto.setDEFPSSysSampleValueName(((PSSysSampleValueDTO)linkDTO).getPSSysSampleValueName());
        } else {
            dto.setDEFPSSysSampleValueName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestCaseId())) {
            linkDTO = (PSSysTestCaseDTO)PSModelServiceUtil.getInstance().getPSSysTestCaseService().getDTO(dto.getPSSysTestCaseId());
            dto.setPSDEFId(((PSSysTestCaseDTO)linkDTO).getPSDEFId());
            dto.setPSDEId(((PSSysTestCaseDTO)linkDTO).getPSDEId());
            dto.setPSSysTestCaseName(((PSSysTestCaseDTO)linkDTO).getPSSysTestCaseName());
            dto.setTargetType(((PSSysTestCaseDTO)linkDTO).getTargetType());
        } else {
            dto.setPSDEFId(null);
            dto.setPSDEId(null);
            dto.setPSSysTestCaseName(null);
            dto.setTargetType(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            linkDTO = (PSSysTestDataDTO)PSModelServiceUtil.getInstance().getPSSysTestDataService().getDTO(dto.getPSSysTestDataId());
            dto.setPSSysTestDataName(((PSSysTestDataDTO)linkDTO).getPSSysTestDataName());
        } else {
            dto.setPSSysTestDataName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSTCINPUT";
    }

    @Override
    public PSSysTCInput createDomain() {
        return new PSSysTCInput();
    }

    @Override
    public PSSysTCInputDTO createDTO() {
        return new PSSysTCInputDTO();
    }
}

