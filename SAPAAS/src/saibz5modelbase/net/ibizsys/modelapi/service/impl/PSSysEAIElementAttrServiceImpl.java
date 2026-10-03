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
import net.ibizsys.modelapi.domain.PSSysEAIElement;
import net.ibizsys.modelapi.domain.PSSysEAIElementAttr;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementAttrDTO;
import net.ibizsys.modelapi.dto.PSSysEAIElementDTO;
import net.ibizsys.modelapi.service.IPSSysEAIElementAttrService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIElementAttrServiceImpl
extends PSModelServiceImplBase<PSSysEAIElementAttr, PSSysEAIElementAttrDTO>
implements IPSSysEAIElementAttrService {
    private static final Log log = LogFactory.getLog(PSSysEAIElementAttrServiceImpl.class);

    @Override
    public List<PSSysEAIElementAttr> listByPSSysEAIElement(PSSysEAIElement parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIElementAttr get(PSSysEAIElement parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIElementAttr> list = this.listByPSSysEAIElement(parent);
        if (list != null) {
            for (PSSysEAIElementAttr item : list) {
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
    public List<PSSysEAIElementAttrDTO> listDTOByPSSysEAIElement(String strParentKey) throws Exception {
        PSSysEAIElement pssyseaielement = (PSSysEAIElement)PSModelServiceUtil.getInstance().getPSSysEAIElementService().get(strParentKey);
        List<PSSysEAIElementAttr> list = this.listByPSSysEAIElement(pssyseaielement);
        if (list != null) {
            ArrayList<PSSysEAIElementAttrDTO> dtoList = new ArrayList<PSSysEAIElementAttrDTO>();
            for (PSSysEAIElementAttr item : list) {
                PSSysEAIElementAttrDTO dto = (PSSysEAIElementAttrDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIElementAttr> onListAll() throws Exception {
        ArrayList<PSSysEAIElementAttr> list = new ArrayList<PSSysEAIElementAttr>();
        List<PSSysEAIElement> pssyseaielements = PSModelServiceUtil.getInstance().getPSSysEAIElementService().listAll();
        if (pssyseaielements != null) {
            for (PSSysEAIElement parent : pssyseaielements) {
                List<PSSysEAIElementAttr> items = this.listByPSSysEAIElement(parent);
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
    protected PSSysEAIElementAttr onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIElementAttr item;
        PSSysEAIElement pssyseaielement = (PSSysEAIElement)PSModelServiceUtil.getInstance().getPSSysEAIElementService().get(strParentKey, true);
        if (pssyseaielement != null && (item = this.get(pssyseaielement, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIElementAttr)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIElementAttrDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAIElementId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAIElementService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIElementAttr et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysEAIElementAttrName())) {
            return et.getPSSysEAIElementAttrName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIElementAttrDTO dto, PSSysEAIElementAttr t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIElementAttrId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
        }
        if (t.getAttrTag() != null || !bIgnoreNull) {
            dto.setAttrTag(t.getAttrTag());
        }
        if (t.getAttrTag2() != null || !bIgnoreNull) {
            dto.setAttrTag2(t.getAttrTag2());
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
        if (t.getDefaultValue() != null || !bIgnoreNull) {
            dto.setDefaultValue(t.getDefaultValue());
        }
        if (t.getEAIElementAttrType() != null || !bIgnoreNull) {
            dto.setEAIElementAttrType(t.getEAIElementAttrType());
        }
        if (t.getFixedValue() != null || !bIgnoreNull) {
            dto.setFixedValue(t.getFixedValue());
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
        if (t.getPSSysEAIDataTypeName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDataTypeName(t.getPSSysEAIDataTypeName());
        }
        if (t.getPSSysEAIElementAttrName() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementAttrName(t.getPSSysEAIElementAttrName());
        }
        if (t.getPSSysEAIElementId() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementId(t.getPSSysEAIElementId());
        }
        if (t.getPSSysEAIElementName() != null || !bIgnoreNull) {
            dto.setPSSysEAIElementName(t.getPSSysEAIElementName());
        }
        if (t.getPSSysEAISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeId(t.getPSSysEAISchemeId());
        }
        if (t.getRefPSSysEAIElementId() != null || !bIgnoreNull) {
            dto.setRefPSSysEAIElementId(t.getRefPSSysEAIElementId());
        }
        if (t.getRefPSSysEAIElementName() != null || !bIgnoreNull) {
            dto.setRefPSSysEAIElementName(t.getRefPSSysEAIElementName());
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
        if (StringUtils.hasLength((String)dto.getPSSysEAIDataTypeId())) {
            dto.setPSSysEAIDataTypeId(this.getRealPSModelId(t, dto.getPSSysEAIDataTypeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            dto.setPSSysEAIElementId(this.getRealPSModelId(t, dto.getPSSysEAIElementId()).replace("/", "."));
        }
        if ("PSSYSEAIELEMENT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAIElementId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysEAIElementId())) {
            dto.setRefPSSysEAIElementId(this.getRealPSModelId(t, dto.getRefPSSysEAIElementId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIDataTypeId())) {
            linkDTO = (PSSysEAIDataTypeDTO)PSModelServiceUtil.getInstance().getPSSysEAIDataTypeService().getDTO(dto.getPSSysEAIDataTypeId());
            dto.setPSSysEAIDataTypeName(((PSSysEAIDataTypeDTO)linkDTO).getPSSysEAIDataTypeName());
        } else {
            dto.setPSSysEAIDataTypeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAIElementId())) {
            linkDTO = (PSSysEAIElementDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementService().getDTO(dto.getPSSysEAIElementId());
            dto.setPSSysEAIElementName(((PSSysEAIElementDTO)linkDTO).getPSSysEAIElementName());
            dto.setPSSysEAISchemeId(((PSSysEAIElementDTO)linkDTO).getPSSysEAISchemeId());
        } else {
            dto.setPSSysEAIElementName(null);
            dto.setPSSysEAISchemeId(null);
        }
        if (StringUtils.hasLength((String)dto.getRefPSSysEAIElementId())) {
            linkDTO = (PSSysEAIElementDTO)PSModelServiceUtil.getInstance().getPSSysEAIElementService().getDTO(dto.getRefPSSysEAIElementId());
            dto.setRefPSSysEAIElementName(((PSSysEAIElementDTO)linkDTO).getPSSysEAIElementName());
        } else {
            dto.setRefPSSysEAIElementName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIELEMENTATTR";
    }

    @Override
    public PSSysEAIElementAttr createDomain() {
        return new PSSysEAIElementAttr();
    }

    @Override
    public PSSysEAIElementAttrDTO createDTO() {
        return new PSSysEAIElementAttrDTO();
    }
}

