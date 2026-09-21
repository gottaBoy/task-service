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
import net.ibizsys.modelapi.domain.PSSysBIHierarchy;
import net.ibizsys.modelapi.domain.PSSysBILevel;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysBIHierarchyDTO;
import net.ibizsys.modelapi.dto.PSSysBILevelDTO;
import net.ibizsys.modelapi.service.IPSSysBILevelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBILevelServiceImpl
extends PSModelServiceImplBase<PSSysBILevel, PSSysBILevelDTO>
implements IPSSysBILevelService {
    private static final Log log = LogFactory.getLog(PSSysBILevelServiceImpl.class);

    @Override
    public List<PSSysBILevel> listByPSSysBIHierarchy(PSSysBIHierarchy parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBILevel get(PSSysBIHierarchy parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBILevel> list = this.listByPSSysBIHierarchy(parent);
        if (list != null) {
            for (PSSysBILevel item : list) {
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
    public List<PSSysBILevelDTO> listDTOByPSSysBIHierarchy(String strParentKey) throws Exception {
        PSSysBIHierarchy pssysbihierarchy = (PSSysBIHierarchy)PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().get(strParentKey);
        List<PSSysBILevel> list = this.listByPSSysBIHierarchy(pssysbihierarchy);
        if (list != null) {
            ArrayList<PSSysBILevelDTO> dtoList = new ArrayList<PSSysBILevelDTO>();
            for (PSSysBILevel item : list) {
                PSSysBILevelDTO dto = (PSSysBILevelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBILevel> onListAll() throws Exception {
        ArrayList<PSSysBILevel> list = new ArrayList<PSSysBILevel>();
        List pssysbihierarchies = PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().listAll();
        if (pssysbihierarchies != null) {
            for (PSSysBIHierarchy parent : pssysbihierarchies) {
                List<PSSysBILevel> items = this.listByPSSysBIHierarchy(parent);
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
    protected PSSysBILevel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBILevel item;
        PSSysBIHierarchy pssysbihierarchy = (PSSysBIHierarchy)PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().get(strParentKey, true);
        if (pssysbihierarchy != null && (item = this.get(pssysbihierarchy, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBILevel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBILevelDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBIHierarchyId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBILevel et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBILevelDTO dto, PSSysBILevel t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBILevelId(t.getId().replace("/", "."));
        }
        if (t.getBILevelTag() != null || !bIgnoreNull) {
            dto.setBILevelTag(t.getBILevelTag());
        }
        if (t.getBILevelTag2() != null || !bIgnoreNull) {
            dto.setBILevelTag2(t.getBILevelTag2());
        }
        if (t.getBILevelType() != null || !bIgnoreNull) {
            dto.setBILevelType(t.getBILevelType());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysBIHierarchyId() != null || !bIgnoreNull) {
            dto.setPSSysBIHierarchyId(t.getPSSysBIHierarchyId());
        }
        if (t.getPSSysBIHierarchyName() != null || !bIgnoreNull) {
            dto.setPSSysBIHierarchyName(t.getPSSysBIHierarchyName());
        }
        if (t.getPSSysBILevelName() != null || !bIgnoreNull) {
            dto.setPSSysBILevelName(t.getPSSysBILevelName());
        }
        if (t.getTextPSDEFId() != null || !bIgnoreNull) {
            dto.setTextPSDEFId(t.getTextPSDEFId());
        }
        if (t.getTextPSDEFName() != null || !bIgnoreNull) {
            dto.setTextPSDEFName(t.getTextPSDEFName());
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
        if (t.getValuePSDEFId() != null || !bIgnoreNull) {
            dto.setValuePSDEFId(t.getValuePSDEFId());
        }
        if (t.getValuePSDEFName() != null || !bIgnoreNull) {
            dto.setValuePSDEFName(t.getValuePSDEFName());
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIHierarchyId())) {
            dto.setPSSysBIHierarchyId(this.getRealPSModelId(t, dto.getPSSysBIHierarchyId()).replace("/", "."));
        }
        if ("PSSYSBIHIERARCHY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBIHierarchyId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            dto.setTextPSDEFId(this.getRealPSModelId(t, dto.getTextPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            dto.setValuePSDEFId(this.getRealPSModelId(t, dto.getValuePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIHierarchyId())) {
            linkDTO = (PSSysBIHierarchyDTO)PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().getDTO(dto.getPSSysBIHierarchyId());
            dto.setPSDEId(((PSSysBIHierarchyDTO)linkDTO).getPSDEId());
            dto.setPSSysBIHierarchyName(((PSSysBIHierarchyDTO)linkDTO).getPSSysBIHierarchyName());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysBIHierarchyName(null);
        }
        if (StringUtils.hasLength((String)dto.getTextPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTextPSDEFId());
            dto.setTextPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTextPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getValuePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getValuePSDEFId());
            dto.setValuePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setValuePSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBILEVEL";
    }

    @Override
    public PSSysBILevel createDomain() {
        return new PSSysBILevel();
    }

    @Override
    public PSSysBILevelDTO createDTO() {
        return new PSSysBILevelDTO();
    }
}

