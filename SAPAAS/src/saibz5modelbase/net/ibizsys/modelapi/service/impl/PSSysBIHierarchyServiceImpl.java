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
import net.ibizsys.modelapi.domain.PSSysBILevel;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysBIDimensionDTO;
import net.ibizsys.modelapi.dto.PSSysBIHierarchyDTO;
import net.ibizsys.modelapi.dto.PSSysBILevelDTO;
import net.ibizsys.modelapi.service.IPSSysBIHierarchyService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBIHierarchyServiceImpl
extends PSModelServiceImplBase<PSSysBIHierarchy, PSSysBIHierarchyDTO>
implements IPSSysBIHierarchyService {
    private static final Log log = LogFactory.getLog(PSSysBIHierarchyServiceImpl.class);

    @Override
    public List<PSSysBIHierarchy> listByPSSysBIDimension(PSSysBIDimension parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBIHierarchy get(PSSysBIDimension parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBIHierarchy> list = this.listByPSSysBIDimension(parent);
        if (list != null) {
            for (PSSysBIHierarchy item : list) {
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
    public List<PSSysBIHierarchyDTO> listDTOByPSSysBIDimension(String strParentKey) throws Exception {
        PSSysBIDimension pssysbidimension = (PSSysBIDimension)PSModelServiceUtil.getInstance().getPSSysBIDimensionService().get(strParentKey);
        List<PSSysBIHierarchy> list = this.listByPSSysBIDimension(pssysbidimension);
        if (list != null) {
            ArrayList<PSSysBIHierarchyDTO> dtoList = new ArrayList<PSSysBIHierarchyDTO>();
            for (PSSysBIHierarchy item : list) {
                PSSysBIHierarchyDTO dto = (PSSysBIHierarchyDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBIHierarchy> onListAll() throws Exception {
        ArrayList<PSSysBIHierarchy> list = new ArrayList<PSSysBIHierarchy>();
        List pssysbidimensions = PSModelServiceUtil.getInstance().getPSSysBIDimensionService().listAll();
        if (pssysbidimensions != null) {
            for (PSSysBIDimension parent : pssysbidimensions) {
                List<PSSysBIHierarchy> items = this.listByPSSysBIDimension(parent);
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
    protected PSSysBIHierarchy onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBIHierarchy item;
        PSSysBIDimension pssysbidimension = (PSSysBIDimension)PSModelServiceUtil.getInstance().getPSSysBIDimensionService().get(strParentKey, true);
        if (pssysbidimension != null && (item = this.get(pssysbidimension, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBIHierarchy)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBIHierarchyDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBIDimensionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBIDimensionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBIHierarchy et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBIHierarchyName())) {
            return et.getPSSysBIHierarchyName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBIHierarchyDTO dto, PSSysBIHierarchy t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBIHierarchyId(t.getId().replace("/", "."));
        }
        if (t.getAllCaption() != null || !bIgnoreNull) {
            dto.setAllCaption(t.getAllCaption());
        }
        if (t.getBIHierarchyTag() != null || !bIgnoreNull) {
            dto.setBIHierarchyTag(t.getBIHierarchyTag());
        }
        if (t.getBIHierarchyTag2() != null || !bIgnoreNull) {
            dto.setBIHierarchyTag2(t.getBIHierarchyTag2());
        }
        if (t.getBIHierarchyType() != null || !bIgnoreNull) {
            dto.setBIHierarchyType(t.getBIHierarchyType());
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
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysBIDimensionId() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionId(t.getPSSysBIDimensionId());
        }
        if (t.getPSSysBIDimensionName() != null || !bIgnoreNull) {
            dto.setPSSysBIDimensionName(t.getPSSysBIDimensionName());
        }
        if (t.getPSSysBIHierarchyName() != null || !bIgnoreNull) {
            dto.setPSSysBIHierarchyName(t.getPSSysBIHierarchyName());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIDimensionId())) {
            dto.setPSSysBIDimensionId(this.getRealPSModelId(t, dto.getPSSysBIDimensionId()).replace("/", "."));
        }
        if ("PSSYSBIDIMENSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBIDimensionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBIDimensionId())) {
            linkDTO = (PSSysBIDimensionDTO)PSModelServiceUtil.getInstance().getPSSysBIDimensionService().getDTO(dto.getPSSysBIDimensionId());
            dto.setPSSysBIDimensionName(((PSSysBIDimensionDTO)linkDTO).getPSSysBIDimensionName());
        } else {
            dto.setPSSysBIDimensionName(null);
        }
        List<PSSysBILevel> list = PSModelServiceUtil.getInstance().getPSSysBILevelService().listByPSSysBIHierarchy(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysBILevelDTO> pssysbilevels = new ArrayList<PSSysBILevelDTO>();
            for (PSSysBILevel item : list) {
                PSSysBILevelDTO dstItem = (PSSysBILevelDTO)PSModelServiceUtil.getInstance().getPSSysBILevelService().toDTO(item);
                pssysbilevels.add(dstItem);
            }
            dto.setPssysbilevels(pssysbilevels);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBIHIERARCHY";
    }

    @Override
    public PSSysBIHierarchy createDomain() {
        return new PSSysBIHierarchy();
    }

    @Override
    public PSSysBIHierarchyDTO createDTO() {
        return new PSSysBIHierarchyDTO();
    }
}

