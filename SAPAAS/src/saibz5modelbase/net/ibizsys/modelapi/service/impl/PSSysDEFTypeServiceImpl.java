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
import net.ibizsys.modelapi.domain.PSSysDEFType;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCodeListDTO;
import net.ibizsys.modelapi.dto.PSSysDEFTypeDTO;
import net.ibizsys.modelapi.dto.PSSysUnitDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysDEFTypeService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysDEFTypeServiceImpl
extends PSModelServiceImplBase<PSSysDEFType, PSSysDEFTypeDTO>
implements IPSSysDEFTypeService {
    private static final Log log = LogFactory.getLog(PSSysDEFTypeServiceImpl.class);

    @Override
    public List<PSSysDEFType> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysDEFType get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysDEFType> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysDEFType item : list) {
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
    public List<PSSysDEFTypeDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysDEFType> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysDEFTypeDTO> dtoList = new ArrayList<PSSysDEFTypeDTO>();
            for (PSSysDEFType item : list) {
                PSSysDEFTypeDTO dto = (PSSysDEFTypeDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysDEFType> onListAll() throws Exception {
        ArrayList<PSSysDEFType> list = new ArrayList<PSSysDEFType>();
        List<PSSystem> pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysDEFType> items = this.listByPSSystem(parent);
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
    protected PSSysDEFType onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysDEFType item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysDEFType)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysDEFTypeDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysDEFType et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysDEFTypeName())) {
            return et.getPSSysDEFTypeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysDEFTypeDTO dto, PSSysDEFType t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysDEFTypeId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getEditorHeight() != null || !bIgnoreNull) {
            dto.setEditorHeight(t.getEditorHeight());
        }
        if (t.getEditorType() != null || !bIgnoreNull) {
            dto.setEditorType(t.getEditorType());
        }
        if (t.getEditorWidth() != null || !bIgnoreNull) {
            dto.setEditorWidth(t.getEditorWidth());
        }
        if (t.getFields() != null || !bIgnoreNull) {
            dto.setFields(t.getFields());
        }
        if (t.getGridColAlign() != null || !bIgnoreNull) {
            dto.setGridColAlign(t.getGridColAlign());
        }
        if (t.getGridColCLMode() != null || !bIgnoreNull) {
            dto.setGridColCLMode(t.getGridColCLMode());
        }
        if (t.getGridColWidth() != null || !bIgnoreNull) {
            dto.setGridColWidth(t.getGridColWidth());
        }
        if (t.getJSFormat() != null || !bIgnoreNull) {
            dto.setJSFormat(t.getJSFormat());
        }
        if (t.getMaxValue() != null || !bIgnoreNull) {
            dto.setMaxValue(t.getMaxValue());
        }
        if (t.getMBEditorHeight() != null || !bIgnoreNull) {
            dto.setMBEditorHeight(t.getMBEditorHeight());
        }
        if (t.getMBEditorType() != null || !bIgnoreNull) {
            dto.setMBEditorType(t.getMBEditorType());
        }
        if (t.getMBEditorWidth() != null || !bIgnoreNull) {
            dto.setMBEditorWidth(t.getMBEditorWidth());
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
        if (t.getPrecision2() != null || !bIgnoreNull) {
            dto.setPrecision2(t.getPrecision2());
        }
        if (t.getPSCodeListId() != null || !bIgnoreNull) {
            dto.setPSCodeListId(t.getPSCodeListId());
        }
        if (t.getPSCodeListName() != null || !bIgnoreNull) {
            dto.setPSCodeListName(t.getPSCodeListName());
        }
        if (t.getPSDEFTypeId() != null || !bIgnoreNull) {
            dto.setPSDEFTypeId(t.getPSDEFTypeId());
        }
        if (t.getPSDEFTypeName() != null || !bIgnoreNull) {
            dto.setPSDEFTypeName(t.getPSDEFTypeName());
        }
        if (t.getPSSysDEFTypeName() != null || !bIgnoreNull) {
            dto.setPSSysDEFTypeName(t.getPSSysDEFTypeName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPSSysUnitId() != null || !bIgnoreNull) {
            dto.setPSSysUnitId(t.getPSSysUnitId());
        }
        if (t.getPSSysUnitName() != null || !bIgnoreNull) {
            dto.setPSSysUnitName(t.getPSSysUnitName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getPYFormat() != null || !bIgnoreNull) {
            dto.setPYFormat(t.getPYFormat());
        }
        if (t.getSearchEditorHeight() != null || !bIgnoreNull) {
            dto.setSearchEditorHeight(t.getSearchEditorHeight());
        }
        if (t.getSearchEditorType() != null || !bIgnoreNull) {
            dto.setSearchEditorType(t.getSearchEditorType());
        }
        if (t.getSearchEditorWidth() != null || !bIgnoreNull) {
            dto.setSearchEditorWidth(t.getSearchEditorWidth());
        }
        if (t.getSearchMBEditorHeight() != null || !bIgnoreNull) {
            dto.setSearchMBEditorHeight(t.getSearchMBEditorHeight());
        }
        if (t.getSearchMBEditorType() != null || !bIgnoreNull) {
            dto.setSearchMBEditorType(t.getSearchMBEditorType());
        }
        if (t.getSearchMBEditorWidth() != null || !bIgnoreNull) {
            dto.setSearchMBEditorWidth(t.getSearchMBEditorWidth());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
        }
        if (t.getStrLength() != null || !bIgnoreNull) {
            dto.setStrLength(t.getStrLength());
        }
        if (t.getTSFormat() != null || !bIgnoreNull) {
            dto.setTSFormat(t.getTSFormat());
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
        if (t.getValueFormat() != null || !bIgnoreNull) {
            dto.setValueFormat(t.getValueFormat());
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            dto.setPSCodeListId(this.getRealPSModelId(t, dto.getPSCodeListId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            dto.setPSSysUnitId(this.getRealPSModelId(t, dto.getPSSysUnitId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCodeListId())) {
            linkDTO = (PSCodeListDTO)PSModelServiceUtil.getInstance().getPSCodeListService().getDTO(dto.getPSCodeListId());
            dto.setPSCodeListName(((PSCodeListDTO)linkDTO).getPSCodeListName());
        } else {
            dto.setPSCodeListName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUnitId())) {
            linkDTO = (PSSysUnitDTO)PSModelServiceUtil.getInstance().getPSSysUnitService().getDTO(dto.getPSSysUnitId(), true);
            if (linkDTO != null) {
                dto.setPSSysUnitName(((PSSysUnitDTO)linkDTO).getPSSysUnitName());
            }
        } else {
            dto.setPSSysUnitName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSDEFTYPE";
    }

    @Override
    public PSSysDEFType createDomain() {
        return new PSSysDEFType();
    }

    @Override
    public PSSysDEFTypeDTO createDTO() {
        return new PSSysDEFTypeDTO();
    }
}

