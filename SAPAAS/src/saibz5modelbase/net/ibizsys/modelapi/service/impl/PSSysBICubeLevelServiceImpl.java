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
import net.ibizsys.modelapi.domain.PSSysBICubeDimension;
import net.ibizsys.modelapi.domain.PSSysBICubeLevel;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDimensionDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeLevelDTO;
import net.ibizsys.modelapi.dto.PSSysBIHierarchyDTO;
import net.ibizsys.modelapi.dto.PSSysBILevelDTO;
import net.ibizsys.modelapi.service.IPSSysBICubeLevelService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBICubeLevelServiceImpl
extends PSModelServiceImplBase<PSSysBICubeLevel, PSSysBICubeLevelDTO>
implements IPSSysBICubeLevelService {
    private static final Log log = LogFactory.getLog(PSSysBICubeLevelServiceImpl.class);

    @Override
    public List<PSSysBICubeLevel> listByPSSysBICubeDimension(PSSysBICubeDimension parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBICubeLevel get(PSSysBICubeDimension parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBICubeLevel> list = this.listByPSSysBICubeDimension(parent);
        if (list != null) {
            for (PSSysBICubeLevel item : list) {
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
    public List<PSSysBICubeLevelDTO> listDTOByPSSysBICubeDimension(String strParentKey) throws Exception {
        PSSysBICubeDimension pssysbicubedimension = (PSSysBICubeDimension)PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().get(strParentKey);
        List<PSSysBICubeLevel> list = this.listByPSSysBICubeDimension(pssysbicubedimension);
        if (list != null) {
            ArrayList<PSSysBICubeLevelDTO> dtoList = new ArrayList<PSSysBICubeLevelDTO>();
            for (PSSysBICubeLevel item : list) {
                PSSysBICubeLevelDTO dto = (PSSysBICubeLevelDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBICubeLevel> onListAll() throws Exception {
        ArrayList<PSSysBICubeLevel> list = new ArrayList<PSSysBICubeLevel>();
        List<PSSysBICubeDimension> pssysbicubedimensions = PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().listAll();
        if (pssysbicubedimensions != null) {
            for (PSSysBICubeDimension parent : pssysbicubedimensions) {
                List<PSSysBICubeLevel> items = this.listByPSSysBICubeDimension(parent);
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
    protected PSSysBICubeLevel onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBICubeLevel item;
        PSSysBICubeDimension pssysbicubedimension = (PSSysBICubeDimension)PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().get(strParentKey, true);
        if (pssysbicubedimension != null && (item = this.get(pssysbicubedimension, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBICubeLevel)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBICubeLevelDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBICubeDimensionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBICubeLevel et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBICubeLevelDTO dto, PSSysBICubeLevel t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBICubeLevelId(t.getId().replace("/", "."));
        }
        if (t.getBICubeLevelTag() != null || !bIgnoreNull) {
            dto.setBICubeLevelTag(t.getBICubeLevelTag());
        }
        if (t.getBICubeLevelTag2() != null || !bIgnoreNull) {
            dto.setBICubeLevelTag2(t.getBICubeLevelTag2());
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
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysBICubeDimensionId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeDimensionId(t.getPSSysBICubeDimensionId());
        }
        if (t.getPSSysBICubeDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeDimensionName(t.getPSSysBICubeDimensionName());
        }
        if (t.getPSSysBICubeLevelName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeLevelName(t.getPSSysBICubeLevelName());
        }
        if (t.getPSSysBIDimensionId() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionId(t.getPSSysBIDimensionId());
        }
        if (t.getPSSysBIHierarchyId() != null || !bIgnoreNull) {
            dto.setPSSysBIHierarchyId(t.getPSSysBIHierarchyId());
        }
        if (t.getPSSysBIHierarchyName() != null || !bIgnoreNull) {
            dto.setPSSysBIHierarchyName(t.getPSSysBIHierarchyName());
        }
        if (t.getPSSysBILevelId() != null || !bIgnoreNull) {
            dto.setPSSysBILevelId(t.getPSSysBILevelId());
        }
        if (t.getPSSysBILevelName() != null || !bIgnoreNull) {
            dto.setPSSysBILevelName(t.getPSSysBILevelName());
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
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeDimensionId())) {
            dto.setPSSysBICubeDimensionId(this.getRealPSModelId(t, dto.getPSSysBICubeDimensionId()).replace("/", "."));
        }
        if ("PSSYSBICUBEDIMENSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBICubeDimensionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIHierarchyId())) {
            dto.setPSSysBIHierarchyId(this.getRealPSModelId(t, dto.getPSSysBIHierarchyId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBILevelId())) {
            dto.setPSSysBILevelId(this.getRealPSModelId(t, dto.getPSSysBILevelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeDimensionId())) {
            linkDTO = (PSSysBICubeDimensionDTO)PSModelServiceUtil.getInstance().getPSSysBICubeDimensionService().getDTO(dto.getPSSysBICubeDimensionId());
            dto.setPSDEId(((PSSysBICubeDimensionDTO)linkDTO).getPSDEId());
            dto.setPSSysBICubeDimensionName(((PSSysBICubeDimensionDTO)linkDTO).getPSSysBICubeDimensionName());
            dto.setPSSysBIDimensionId(((PSSysBICubeDimensionDTO)linkDTO).getPSSysBIDimensionId());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysBICubeDimensionName(null);
            dto.setPSSysBIDimensionId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIHierarchyId())) {
            linkDTO = (PSSysBIHierarchyDTO)PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().getDTO(dto.getPSSysBIHierarchyId());
            dto.setPSSysBIHierarchyName(((PSSysBIHierarchyDTO)linkDTO).getPSSysBIHierarchyName());
        } else {
            dto.setPSSysBIHierarchyName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBILevelId())) {
            linkDTO = (PSSysBILevelDTO)PSModelServiceUtil.getInstance().getPSSysBILevelService().getDTO(dto.getPSSysBILevelId());
            dto.setPSSysBILevelName(((PSSysBILevelDTO)linkDTO).getPSSysBILevelName());
        } else {
            dto.setPSSysBILevelName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBICUBELEVEL";
    }

    @Override
    public PSSysBICubeLevel createDomain() {
        return new PSSysBICubeLevel();
    }

    @Override
    public PSSysBICubeLevelDTO createDTO() {
        return new PSSysBICubeLevelDTO();
    }
}

