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
import net.ibizsys.modelapi.domain.PSSysTDItem;
import net.ibizsys.modelapi.domain.PSSysTestData;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysSampleValueDTO;
import net.ibizsys.modelapi.dto.PSSysTDItemDTO;
import net.ibizsys.modelapi.dto.PSSysTestDataDTO;
import net.ibizsys.modelapi.service.IPSSysTDItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysTDItemServiceImpl
extends PSModelServiceImplBase<PSSysTDItem, PSSysTDItemDTO>
implements IPSSysTDItemService {
    private static final Log log = LogFactory.getLog(PSSysTDItemServiceImpl.class);

    @Override
    public List<PSSysTDItem> listByPSSysTestData(PSSysTestData parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysTDItem get(PSSysTestData parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysTDItem> list = this.listByPSSysTestData(parent);
        if (list != null) {
            for (PSSysTDItem item : list) {
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
    public List<PSSysTDItemDTO> listDTOByPSSysTestData(String strParentKey) throws Exception {
        PSSysTestData pssystestdata = (PSSysTestData)PSModelServiceUtil.getInstance().getPSSysTestDataService().get(strParentKey);
        List<PSSysTDItem> list = this.listByPSSysTestData(pssystestdata);
        if (list != null) {
            ArrayList<PSSysTDItemDTO> dtoList = new ArrayList<PSSysTDItemDTO>();
            for (PSSysTDItem item : list) {
                PSSysTDItemDTO dto = (PSSysTDItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysTDItem> onListAll() throws Exception {
        ArrayList<PSSysTDItem> list = new ArrayList<PSSysTDItem>();
        List pssystestdata = PSModelServiceUtil.getInstance().getPSSysTestDataService().listAll();
        if (pssystestdata != null) {
            for (PSSysTestData parent : pssystestdata) {
                List<PSSysTDItem> items = this.listByPSSysTestData(parent);
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
    protected PSSysTDItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysTDItem item;
        PSSysTestData pssystestdata = (PSSysTestData)PSModelServiceUtil.getInstance().getPSSysTestDataService().get(strParentKey, true);
        if (pssystestdata != null && (item = this.get(pssystestdata, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysTDItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysTDItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysTestDataId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysTestDataService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysTDItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysTDItemName())) {
            return et.getPSSysTDItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysTDItemDTO dto, PSSysTDItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysTDItemId(t.getId().replace("/", "."));
        }
        if (t.getBadValue() != null || !bIgnoreNull) {
            dto.setBadValue(t.getBadValue());
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
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysSampleValueId() != null || !bIgnoreNull) {
            dto.setPSSysSampleValueId(t.getPSSysSampleValueId());
        }
        if (t.getPSSysSampleValueName() != null || !bIgnoreNull) {
            dto.setPSSysSampleValueName(t.getPSSysSampleValueName());
        }
        if (t.getPSSysTDItemName() != null || !bIgnoreNull) {
            dto.setPSSysTDItemName(t.getPSSysTDItemName());
        }
        if (t.getPSSysTestDataId() != null || !bIgnoreNull) {
            dto.setPSSysTestDataId(t.getPSSysTestDataId());
        }
        if (t.getPSSysTestDataName() != null || !bIgnoreNull) {
            dto.setPSSysTestDataName(t.getPSSysTestDataName());
        }
        if (t.getRefPSDEId() != null || !bIgnoreNull) {
            dto.setRefPSDEId(t.getRefPSDEId());
        }
        if (t.getRefPSDEName() != null || !bIgnoreNull) {
            dto.setRefPSDEName(t.getRefPSDEName());
        }
        if (t.getRefPSSysTestDataId() != null || !bIgnoreNull) {
            dto.setRefPSSysTestDataId(t.getRefPSSysTestDataId());
        }
        if (t.getRefPSSysTestDataName() != null || !bIgnoreNull) {
            dto.setRefPSSysTestDataName(t.getRefPSSysTestDataName());
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
        if (t.getValue() != null || !bIgnoreNull) {
            dto.setValue(t.getValue());
        }
        if (t.getValueRange() != null || !bIgnoreNull) {
            dto.setValueRange(t.getValueRange());
        }
        if (t.getValueType() != null || !bIgnoreNull) {
            dto.setValueType(t.getValueType());
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSampleValueId())) {
            dto.setPSSysSampleValueId(this.getRealPSModelId(t, dto.getPSSysSampleValueId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            dto.setPSSysTestDataId(this.getRealPSModelId(t, dto.getPSSysTestDataId()).replace("/", "."));
        }
        if ("PSSYSTESTDATA".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysTestDataId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            dto.setRefPSDEId(this.getRealPSModelId(t, dto.getRefPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysTestDataId())) {
            dto.setRefPSSysTestDataId(this.getRealPSModelId(t, dto.getRefPSSysTestDataId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSampleValueId())) {
            linkDTO = (PSSysSampleValueDTO)PSModelServiceUtil.getInstance().getPSSysSampleValueService().getDTO(dto.getPSSysSampleValueId());
            dto.setPSSysSampleValueName(((PSSysSampleValueDTO)linkDTO).getPSSysSampleValueName());
        } else {
            dto.setPSSysSampleValueName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysTestDataId())) {
            linkDTO = (PSSysTestDataDTO)PSModelServiceUtil.getInstance().getPSSysTestDataService().getDTO(dto.getPSSysTestDataId());
            dto.setPSDEId(((PSSysTestDataDTO)linkDTO).getPSDEId());
            dto.setPSSysTestDataName(((PSSysTestDataDTO)linkDTO).getPSSysTestDataName());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysTestDataName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getRefPSDEId());
            dto.setRefPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setRefPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysTestDataId())) {
            linkDTO = (PSSysTestDataDTO)PSModelServiceUtil.getInstance().getPSSysTestDataService().getDTO(dto.getRefPSSysTestDataId());
            dto.setRefPSSysTestDataName(((PSSysTestDataDTO)linkDTO).getPSSysTestDataName());
        } else {
            dto.setRefPSSysTestDataName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSTDITEM";
    }

    @Override
    public PSSysTDItem createDomain() {
        return new PSSysTDItem();
    }

    @Override
    public PSSysTDItemDTO createDTO() {
        return new PSSysTDItemDTO();
    }
}

