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
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeDTO;
import net.ibizsys.modelapi.dto.PSSysEAIDataTypeItemDTO;
import net.ibizsys.modelapi.dto.PSSysEAISchemeDTO;
import net.ibizsys.modelapi.service.IPSSysEAIDataTypeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysEAIDataTypeServiceImpl
extends PSModelServiceImplBase<PSSysEAIDataType, PSSysEAIDataTypeDTO>
implements IPSSysEAIDataTypeService {
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeServiceImpl.class);

    @Override
    public List<PSSysEAIDataType> listByPSSysEAIScheme(PSSysEAIScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysEAIDataType get(PSSysEAIScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysEAIDataType> list = this.listByPSSysEAIScheme(parent);
        if (list != null) {
            for (PSSysEAIDataType item : list) {
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
    public List<PSSysEAIDataTypeDTO> listDTOByPSSysEAIScheme(String strParentKey) throws Exception {
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey);
        List<PSSysEAIDataType> list = this.listByPSSysEAIScheme(pssyseaischeme);
        if (list != null) {
            ArrayList<PSSysEAIDataTypeDTO> dtoList = new ArrayList<PSSysEAIDataTypeDTO>();
            for (PSSysEAIDataType item : list) {
                PSSysEAIDataTypeDTO dto = (PSSysEAIDataTypeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysEAIDataType> onListAll() throws Exception {
        ArrayList<PSSysEAIDataType> list = new ArrayList<PSSysEAIDataType>();
        List<PSSysEAIScheme> pssyseaischemes = PSModelServiceUtil.getInstance().getPSSysEAISchemeService().listAll();
        if (pssyseaischemes != null) {
            for (PSSysEAIScheme parent : pssyseaischemes) {
                List<PSSysEAIDataType> items = this.listByPSSysEAIScheme(parent);
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
    protected PSSysEAIDataType onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysEAIDataType item;
        PSSysEAIScheme pssyseaischeme = (PSSysEAIScheme)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strParentKey, true);
        if (pssyseaischeme != null && (item = this.get(pssyseaischeme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysEAIDataType)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysEAIDataTypeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysEAISchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysEAISchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysEAIDataType et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysEAIDataTypeDTO dto, PSSysEAIDataType t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysEAIDataTypeId(t.getId().replace("/", "."));
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
        if (t.getEAIDataTypeTag() != null || !bIgnoreNull) {
            dto.setEAIDataTypeTag(t.getEAIDataTypeTag());
        }
        if (t.getEAIDataTypeTag2() != null || !bIgnoreNull) {
            dto.setEAIDataTypeTag2(t.getEAIDataTypeTag2());
        }
        if (t.getEnableEnum() != null || !bIgnoreNull) {
            dto.setEnableEnum(t.getEnableEnum());
        }
        if (t.getIncMaxValue() != null || !bIgnoreNull) {
            dto.setIncMaxValue(t.getIncMaxValue());
        }
        if (t.getIncMinValue() != null || !bIgnoreNull) {
            dto.setIncMinValue(t.getIncMinValue());
        }
        if (t.getMaxStrLength() != null || !bIgnoreNull) {
            dto.setMaxStrLength(t.getMaxStrLength());
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
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSSysEAIDataTypeName() != null || !bIgnoreNull) {
            dto.setPSSysEAIDataTypeName(t.getPSSysEAIDataTypeName());
        }
        if (t.getPSSysEAISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeId(t.getPSSysEAISchemeId());
        }
        if (t.getPSSysEAISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysEAISchemeName(t.getPSSysEAISchemeName());
        }
        if (t.getRegExpCode() != null || !bIgnoreNull) {
            dto.setRegExpCode(t.getRegExpCode());
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
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            dto.setPSSysEAISchemeId(this.getRealPSModelId(t, dto.getPSSysEAISchemeId()).replace("/", "."));
        }
        if ("PSSYSEAISCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysEAISchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysEAISchemeId())) {
            PSSysEAISchemeDTO linkDTO = (PSSysEAISchemeDTO)PSModelServiceUtil.getInstance().getPSSysEAISchemeService().getDTO(dto.getPSSysEAISchemeId());
            dto.setPSSysEAISchemeName(linkDTO.getPSSysEAISchemeName());
        } else {
            dto.setPSSysEAISchemeName(null);
        }
        List<PSSysEAIDataTypeItem> list = PSModelServiceUtil.getInstance().getPSSysEAIDataTypeItemService().listByPSSysEAIDataType(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysEAIDataTypeItemDTO> pssyseaidatatypeitems = new ArrayList<PSSysEAIDataTypeItemDTO>();
            for (PSSysEAIDataTypeItem item : list) {
                PSSysEAIDataTypeItemDTO dstItem = (PSSysEAIDataTypeItemDTO)PSModelServiceUtil.getInstance().getPSSysEAIDataTypeItemService().toDTO(item);
                pssyseaidatatypeitems.add(dstItem);
            }
            dto.setPssyseaidatatypeitems(pssyseaidatatypeitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSEAIDATATYPE";
    }

    @Override
    public PSSysEAIDataType createDomain() {
        return new PSSysEAIDataType();
    }

    @Override
    public PSSysEAIDataTypeDTO createDTO() {
        return new PSSysEAIDataTypeDTO();
    }
}

