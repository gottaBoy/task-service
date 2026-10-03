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
import net.ibizsys.modelapi.domain.PSSysTCAssert;
import net.ibizsys.modelapi.domain.PSSysTestCase;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysTCAssertDTO;
import net.ibizsys.modelapi.dto.PSSysTCInputDTO;
import net.ibizsys.modelapi.dto.PSSysTestCaseDTO;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.service.IPSSysTCAssertService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTCAssertServiceImpl
extends PSModelServiceImplBase<PSSysTCAssert, PSSysTCAssertDTO>
implements IPSSysTCAssertService {
    private static final Log log = LogFactory.getLog(PSSysTCAssertServiceImpl.class);

    @Override
    public List<PSSysTCAssert> listByPSSysTestCase(PSSysTestCase parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTCAssert get(PSSysTestCase parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTCAssert> list = this.listByPSSysTestCase(parent);
        if (list != null) {
            for (PSSysTCAssert item : list) {
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
    public List<PSSysTCAssertDTO> listDTOByPSSysTestCase(String strParentKey) throws Exception {
        PSSysTestCase pssystestcase = (PSSysTestCase)PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strParentKey);
        List<PSSysTCAssert> list = this.listByPSSysTestCase(pssystestcase);
        if (list != null) {
            ArrayList<PSSysTCAssertDTO> dtoList = new ArrayList<PSSysTCAssertDTO>();
            for (PSSysTCAssert item : list) {
                PSSysTCAssertDTO dto = (PSSysTCAssertDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTCAssert> onListAll() throws Exception {
        ArrayList<PSSysTCAssert> list = new ArrayList<PSSysTCAssert>();
        List<PSSysTestCase> pssystestcases = PSModelServiceUtil.getInstance().getPSSysTestCaseService().listAll();
        if (pssystestcases != null) {
            for (PSSysTestCase parent : pssystestcases) {
                List<PSSysTCAssert> items = this.listByPSSysTestCase(parent);
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
    protected PSSysTCAssert onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTCAssert item;
        PSSysTestCase pssystestcase = (PSSysTestCase)PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strParentKey, true);
        if (pssystestcase != null && (item = this.get(pssystestcase, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTCAssert)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTCAssertDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysTestCaseId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysTestCaseService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysTCAssert et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysTCAssertName())) {
            return et.getPSSysTCAssertName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTCAssertDTO dto, PSSysTCAssert t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTCAssertId(t.getId().replace("/", "."));
        }
        if (t.getAssertResult() != null || !bIgnoreNull) {
            dto.setAssertResult(t.getAssertResult());
        }
        if (t.getAssertTag() != null || !bIgnoreNull) {
            dto.setAssertTag(t.getAssertTag());
        }
        if (t.getAssertTag2() != null || !bIgnoreNull) {
            dto.setAssertTag2(t.getAssertTag2());
        }
        if (t.getAssertTag3() != null || !bIgnoreNull) {
            dto.setAssertTag3(t.getAssertTag3());
        }
        if (t.getAssertTag4() != null || !bIgnoreNull) {
            dto.setAssertTag4(t.getAssertTag4());
        }
        if (t.getAssertType() != null || !bIgnoreNull) {
            dto.setAssertType(t.getAssertType());
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
        if (t.getDstKeyPSDEFId() != null || !bIgnoreNull) {
            dto.setDstKeyPSDEFId(t.getDstKeyPSDEFId());
        }
        if (t.getDstKeyPSDEFName() != null || !bIgnoreNull) {
            dto.setDstKeyPSDEFName(t.getDstKeyPSDEFName());
        }
        if (t.getDstPSDEId() != null || !bIgnoreNull) {
            dto.setDstPSDEId(t.getDstPSDEId());
        }
        if (t.getDstPSDEName() != null || !bIgnoreNull) {
            dto.setDstPSDEName(t.getDstPSDEName());
        }
        if (t.getExceptionData() != null || !bIgnoreNull) {
            dto.setExceptionData(t.getExceptionData());
        }
        if (t.getExceptionData2() != null || !bIgnoreNull) {
            dto.setExceptionData2(t.getExceptionData2());
        }
        if (t.getExceptionName() != null || !bIgnoreNull) {
            dto.setExceptionName(t.getExceptionName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysTCAssertName() != null || !bIgnoreNull) {
            dto.setPSSysTCAssertName(t.getPSSysTCAssertName());
        }
        if (t.getPSSysTCInputId() != null || !bIgnoreNull) {
            dto.setPSSysTCInputId(t.getPSSysTCInputId());
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
        if (StringUtils.hasLength((String)dto.getDstKeyPSDEFId())) {
            dto.setDstKeyPSDEFId(this.getRealPSModelId(t, dto.getDstKeyPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            dto.setDstPSDEId(this.getRealPSModelId(t, dto.getDstPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTCInputId())) {
            dto.setPSSysTCInputId(this.getRealPSModelId(t, dto.getPSSysTCInputId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getDstKeyPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDstKeyPSDEFId());
            dto.setDstKeyPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDstKeyPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getDstPSDEId());
            dto.setDstPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setDstPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTCInputId())) {
            linkDTO = (PSSysTCInputDTO)PSModelServiceUtil.getInstance().getPSSysTCInputService().getDTO(dto.getPSSysTCInputId());
            dto.setPSSysTCInputName(((PSSysTCInputDTO)linkDTO).getPSSysTCInputName());
        } else {
            dto.setPSSysTCInputName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestCaseId())) {
            linkDTO = (PSSysTestCaseDTO)PSModelServiceUtil.getInstance().getPSSysTestCaseService().getDTO(dto.getPSSysTestCaseId());
            dto.setPSDEId(((PSSysTestCaseDTO)linkDTO).getPSDEId());
            dto.setPSSysTestCaseName(((PSSysTestCaseDTO)linkDTO).getPSSysTestCaseName());
            dto.setTargetType(((PSSysTestCaseDTO)linkDTO).getTargetType());
        } else {
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
        return "PSSYSTCASSERT";
    }

    @Override
    public PSSysTCAssert createDomain() {
        return new PSSysTCAssert();
    }

    @Override
    public PSSysTCAssertDTO createDTO() {
        return new PSSysTCAssertDTO();
    }
}

