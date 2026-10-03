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
import net.ibizsys.modelapi.domain.PSSysEAIDataType;
import net.ibizsys.modelapi.domain.PSSysEAIDataTypeItem;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeItemDTO;
import net.ibizsys.modelapi.service.IPSSysEAIDataTypeItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIDataTypeItemServiceImpl
extends PSModelServiceImplBase<PSSysEAIDataTypeItem, PSSysEAIDataTypeItemDTO>
implements IPSSysEAIDataTypeItemService {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeItemServiceImpl.class);

    @Override
    public List<PSSysEAIDataTypeItem> listByPSSysEAIDataType(PSSysEAIDataType parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIDataTypeItem get(PSSysEAIDataType parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIDataTypeItem> list = this.listByPSSysEAIDataType(parent);
        if (list != null) {
            for (PSSysEAIDataTypeItem item : list) {
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
    public List<PSSysEAIDataTypeItemDTO> listDTOByPSSysEAIDataType(String strParentKey) throws Exception {
        PSSysEAIDataType pssyseaidatatype = (PSSysEAIDataType)PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().get(strParentKey);
        List<PSSysEAIDataTypeItem> list = this.listByPSSysEAIDataType(pssyseaidatatype);
        if (list != null) {
            ArrayList<PSSysEAIDataTypeItemDTO> dtoList = new ArrayList<PSSysEAIDataTypeItemDTO>();
            for (PSSysEAIDataTypeItem item : list) {
                PSSysEAIDataTypeItemDTO dto = (PSSysEAIDataTypeItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIDataTypeItem> onListAll() throws Exception {
        ArrayList<PSSysEAIDataTypeItem> list = new ArrayList<PSSysEAIDataTypeItem>();
        List<PSSysEAIDataType> pssyseaidatatypes = PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().listAll();
        if (pssyseaidatatypes != null) {
            for (PSSysEAIDataType parent : pssyseaidatatypes) {
                List<PSSysEAIDataTypeItem> items = this.listByPSSysEAIDataType(parent);
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
    protected PSSysEAIDataTypeItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIDataTypeItem item;
        PSSysEAIDataType pssyseaidatatype = (PSSysEAIDataType)PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().get(strParentKey, true);
        if (pssyseaidatatype != null && (item = this.get(pssyseaidatatype, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIDataTypeItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIDataTypeItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAIDataTypeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIDataTypeItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysEAIDataTypeItemName())) {
            return et.getPSSysEAIDataTypeItemName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIDataTypeItemDTO dto, PSSysEAIDataTypeItem t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIDataTypeItemId(t.getId().replace("/", "."));
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
        if (t.getData() != null || !bIgnoreNull) {
            dto.setData(t.getData());
        }
        if (t.getEAIDataTypeItemTag() != null || !bIgnoreNull) {
            dto.setEAIDataTypeItemTag(t.getEAIDataTypeItemTag());
        }
        if (t.getEAIDataTypeItemTag2() != null || !bIgnoreNull) {
            dto.setEAIDataTypeItemTag2(t.getEAIDataTypeItemTag2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSSysEAIDataTypeId() != null || !bIgnoreNull) {
            dto.setPSSysEAIDataTypeId(t.getPSSysEAIDataTypeId());
        }
        if (t.getPSSysEAIDataTypeItemName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDataTypeItemName(t.getPSSysEAIDataTypeItemName());
        }
        if (t.getPSSysEAIDataTypeName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDataTypeName(t.getPSSysEAIDataTypeName());
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
        if (StringUtils.hasLength((String)dto.getPSSysEAIDataTypeId())) {
            dto.setPSSysEAIDataTypeId(this.getRealPSModelId(t, dto.getPSSysEAIDataTypeId()).replace("/", "."));
        }
        if ("PSSYSEAIDATATYPE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAIDataTypeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIDataTypeId())) {
            PSSysEAIDataTypeDTO linkDTO = (PSSysEAIDataTypeDTO)PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().getDTO(dto.getPSSysEAIDataTypeId());
            dto.setPSSysEAIDataTypeName(linkDTO.getPSSysEAIDataTypeName());
        } else {
            dto.setPSSysEAIDataTypeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIDATATYPEITEM";
    }

    @Override
    public PSSysEAIDataTypeItem createDomain() {
        return new PSSysEAIDataTypeItem();
    }

    @Override
    public PSSysEAIDataTypeItemDTO createDTO() {
        return new PSSysEAIDataTypeItemDTO();
    }
}

