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
import net.ibizsys.modelapi.domain.PSSysBICube;
import net.ibizsys.modelapi.domain.PSSysBICubeDimension;
import net.ibizsys.modelapi.domain.PSSysBICubeLevel;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDimensionDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeLevelDTO;
import net.ibizsys.modelapi.dto.PSSysBIDimensionDTO;
import net.ibizsys.modelapi.service.IPSSysBICubeDimensionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBICubeDimensionServiceImpl
extends PSModelServiceImplBase<PSSysBICubeDimension, PSSysBICubeDimensionDTO>
implements IPSSysBICubeDimensionService {
    private static final Log log = LogFactory.getLog(PSSysBICubeDimensionServiceImpl.class);

    @Override
    public List<PSSysBICubeDimension> listByPSSysBICube(PSSysBICube parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBICubeDimension get(PSSysBICube parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBICubeDimension> list = this.listByPSSysBICube(parent);
        if (list != null) {
            for (PSSysBICubeDimension item : list) {
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
    public List<PSSysBICubeDimensionDTO> listDTOByPSSysBICube(String strParentKey) throws Exception {
        PSSysBICube pssysbicube = (PSSysBICube)PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strParentKey);
        List<PSSysBICubeDimension> list = this.listByPSSysBICube(pssysbicube);
        if (list != null) {
            ArrayList<PSSysBICubeDimensionDTO> dtoList = new ArrayList<PSSysBICubeDimensionDTO>();
            for (PSSysBICubeDimension item : list) {
                PSSysBICubeDimensionDTO dto = (PSSysBICubeDimensionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBICubeDimension> onListAll() throws Exception {
        ArrayList<PSSysBICubeDimension> list = new ArrayList<PSSysBICubeDimension>();
        List pssysbicubes = PSModelServiceUtil.getInstance().getPSSysBICubeService().listAll();
        if (pssysbicubes != null) {
            for (PSSysBICube parent : pssysbicubes) {
                List<PSSysBICubeDimension> items = this.listByPSSysBICube(parent);
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
    protected PSSysBICubeDimension onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBICubeDimension item;
        PSSysBICube pssysbicube = (PSSysBICube)PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strParentKey, true);
        if (pssysbicube != null && (item = this.get(pssysbicube, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBICubeDimension)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBICubeDimensionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBICubeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBICubeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBICubeDimension et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBICubeDimensionName())) {
            return et.getPSSysBICubeDimensionName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBICubeDimensionDTO dto, PSSysBICubeDimension t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBICubeDimensionId(t.getId().replace("/", "."));
        }
        if (t.getBICubeDimensionTag() != null || !bIgnoreNull) {
            dto.setBICubeDimensionTag(t.getBICubeDimensionTag());
        }
        if (t.getBICubeDimensionTag2() != null || !bIgnoreNull) {
            dto.setBICubeDimensionTag2(t.getBICubeDimensionTag2());
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
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysBICubeDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeDimensionName(t.getPSSysBICubeDimensionName());
        }
        if (t.getPSSysBICubeId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeId(t.getPSSysBICubeId());
        }
        if (t.getPSSysBICubeName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeName(t.getPSSysBICubeName());
        }
        if (t.getPSSysBIDimensionId() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionId(t.getPSSysBIDimensionId());
        }
        if (t.getPSSysBIDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionName(t.getPSSysBIDimensionName());
        }
        if (t.getPSSysBISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeId(t.getPSSysBISchemeId());
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
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            dto.setPSSysBICubeId(this.getRealPSModelId(t, dto.getPSSysBICubeId()).replace("/", "."));
        }
        if ("PSSYSBICUBE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBICubeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIDimensionId())) {
            dto.setPSSysBIDimensionId(this.getRealPSModelId(t, dto.getPSSysBIDimensionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            linkDTO = (PSSysBICubeDTO)PSModelServiceUtil.getInstance().getPSSysBICubeService().getDTO(dto.getPSSysBICubeId());
            dto.setPSDEId(((PSSysBICubeDTO)linkDTO).getPSDEId());
            dto.setPSSysBICubeName(((PSSysBICubeDTO)linkDTO).getPSSysBICubeName());
            dto.setPSSysBISchemeId(((PSSysBICubeDTO)linkDTO).getPSSysBISchemeId());
        } else {
            dto.setPSDEId(null);
            dto.setPSSysBICubeName(null);
            dto.setPSSysBISchemeId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIDimensionId())) {
            linkDTO = (PSSysBIDimensionDTO)PSModelServiceUtil.getInstance().getPSSysBIDimensionService().getDTO(dto.getPSSysBIDimensionId());
            dto.setPSSysBIDimensionName(((PSSysBIDimensionDTO)linkDTO).getPSSysBIDimensionName());
        } else {
            dto.setPSSysBIDimensionName(null);
        }
        List<PSSysBICubeLevel> list = PSModelServiceUtil.getInstance().getPSSysBICubeLevelService().listByPSSysBICubeDimension(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysBICubeLevelDTO> pssysbicubelevels = new ArrayList<PSSysBICubeLevelDTO>();
            for (PSSysBICubeLevel item : list) {
                PSSysBICubeLevelDTO dstItem = (PSSysBICubeLevelDTO)PSModelServiceUtil.getInstance().getPSSysBICubeLevelService().toDTO(item);
                pssysbicubelevels.add(dstItem);
            }
            dto.setPssysbicubelevels(pssysbicubelevels);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBICUBEDIMENSION";
    }

    @Override
    public PSSysBICubeDimension createDomain() {
        return new PSSysBICubeDimension();
    }

    @Override
    public PSSysBICubeDimensionDTO createDTO() {
        return new PSSysBICubeDimensionDTO();
    }
}

