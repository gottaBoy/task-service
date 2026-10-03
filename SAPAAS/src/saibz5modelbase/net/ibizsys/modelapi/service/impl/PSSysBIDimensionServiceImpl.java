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
import net.ibizsys.modelapi.domain.PSSysBIDimension;
import net.ibizsys.modelapi.domain.PSSysBIHierarchy;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.dto.PSSysBIDimensionDTO;
import net.ibizsys.modelapi.dto.PSSysBIHierarchyDTO;
import net.ibizsys.modelapi.dto.PSSysBISchemeDTO;
import net.ibizsys.modelapi.service.IPSSysBIDimensionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBIDimensionServiceImpl
extends PSModelServiceImplBase<PSSysBIDimension, PSSysBIDimensionDTO>
implements IPSSysBIDimensionService {
    private static final Log log = LogFactory.getLog(PSSysBIDimensionServiceImpl.class);

    @Override
    public List<PSSysBIDimension> listByPSSysBIScheme(PSSysBIScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBIDimension get(PSSysBIScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBIDimension> list = this.listByPSSysBIScheme(parent);
        if (list != null) {
            for (PSSysBIDimension item : list) {
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
    public List<PSSysBIDimensionDTO> listDTOByPSSysBIScheme(String strParentKey) throws Exception {
        PSSysBIScheme pssysbischeme = (PSSysBIScheme)PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strParentKey);
        List<PSSysBIDimension> list = this.listByPSSysBIScheme(pssysbischeme);
        if (list != null) {
            ArrayList<PSSysBIDimensionDTO> dtoList = new ArrayList<PSSysBIDimensionDTO>();
            for (PSSysBIDimension item : list) {
                PSSysBIDimensionDTO dto = (PSSysBIDimensionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBIDimension> onListAll() throws Exception {
        ArrayList<PSSysBIDimension> list = new ArrayList<PSSysBIDimension>();
        List<PSSysBIScheme> pssysbischemes = PSModelServiceUtil.getInstance().getPSSysBISchemeService().listAll();
        if (pssysbischemes != null) {
            for (PSSysBIScheme parent : pssysbischemes) {
                List<PSSysBIDimension> items = this.listByPSSysBIScheme(parent);
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
    protected PSSysBIDimension onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBIDimension item;
        PSSysBIScheme pssysbischeme = (PSSysBIScheme)PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strParentKey, true);
        if (pssysbischeme != null && (item = this.get(pssysbischeme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBIDimension)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBIDimensionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBISchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBIDimension et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBIDimensionDTO dto, PSSysBIDimension t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBIDimensionId(t.getId().replace("/", "."));
        }
        if (t.getBIDimensionTag() != null || !bIgnoreNull) {
            dto.setBIDimensionTag(t.getBIDimensionTag());
        }
        if (t.getBIDimensionTag2() != null || !bIgnoreNull) {
            dto.setBIDimensionTag2(t.getBIDimensionTag2());
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
        if (t.getPSSysBIDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionName(t.getPSSysBIDimensionName());
        }
        if (t.getPSSysBISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeId(t.getPSSysBISchemeId());
        }
        if (t.getPSSysBISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeName(t.getPSSysBISchemeName());
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
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            dto.setPSSysBISchemeId(this.getRealPSModelId(t, dto.getPSSysBISchemeId()).replace("/", "."));
        }
        if ("PSSYSBISCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBISchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            PSSysBISchemeDTO linkDTO = (PSSysBISchemeDTO)PSModelServiceUtil.getInstance().getPSSysBISchemeService().getDTO(dto.getPSSysBISchemeId());
            dto.setPSSysBISchemeName(linkDTO.getPSSysBISchemeName());
        } else {
            dto.setPSSysBISchemeName(null);
        }
        List<PSSysBIHierarchy> list = PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().listByPSSysBIDimension(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysBIHierarchyDTO> pssysbihierarchies = new ArrayList<PSSysBIHierarchyDTO>();
            for (PSSysBIHierarchy item : list) {
                PSSysBIHierarchyDTO dstItem = (PSSysBIHierarchyDTO)PSModelServiceUtil.getInstance().getPSSysBIHierarchyService().toDTO(item);
                pssysbihierarchies.add(dstItem);
            }
            dto.setPssysbihierarchies(pssysbihierarchies);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBIDIMENSION";
    }

    @Override
    public PSSysBIDimension createDomain() {
        return new PSSysBIDimension();
    }

    @Override
    public PSSysBIDimensionDTO createDTO() {
        return new PSSysBIDimensionDTO();
    }
}

