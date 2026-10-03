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
import net.ibizsys.modelapi.domain.PSDEDBIdxField;
import net.ibizsys.modelapi.domain.PSDEDBIndex;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDBIdxFieldDTO;
import net.ibizsys.modelapi.dto.PSDEDBIndexDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEDBIndexService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDBIndexServiceImpl
extends PSModelServiceImplBase<PSDEDBIndex, PSDEDBIndexDTO>
implements IPSDEDBIndexService {
    private static final Log log = LogFactory.getLog(PSDEDBIndexServiceImpl.class);

    @Override
    public List<PSDEDBIndex> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDBIndex get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDBIndex> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDBIndex item : list) {
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
    public List<PSDEDBIndexDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDBIndex> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDBIndexDTO> dtoList = new ArrayList<PSDEDBIndexDTO>();
            for (PSDEDBIndex item : list) {
                PSDEDBIndexDTO dto = (PSDEDBIndexDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDBIndex> onListAll() throws Exception {
        ArrayList<PSDEDBIndex> list = new ArrayList<PSDEDBIndex>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDBIndex> items = this.listByPSDataEntity(parent);
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
    protected PSDEDBIndex onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDBIndex item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDBIndex)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDBIndexDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDBIndex et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDBIndexName())) {
            return et.getPSDEDBIndexName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDBIndexDTO dto, PSDEDBIndex t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDBIndexId(t.getId().replace("/", "."));
        }
        if (t.getAllowReverse() != null || !bIgnoreNull) {
            dto.setAllowReverse(t.getAllowReverse());
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
        if (t.getIndexType() != null || !bIgnoreNull) {
            dto.setIndexType(t.getIndexType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEDBIndexName() != null || !bIgnoreNull) {
            dto.setPSDEDBIndexName(t.getPSDEDBIndexName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getRemoveFlag() != null || !bIgnoreNull) {
            dto.setRemoveFlag(t.getRemoveFlag());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            PSDataEntityDTO linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(linkDTO.getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        List<PSDEDBIdxField> list = PSModelServiceUtil.getInstance().getPSDEDBIdxFieldService().listByPSDEDBIndex(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEDBIdxFieldDTO> psdedbidxfields = new ArrayList<PSDEDBIdxFieldDTO>();
            for (PSDEDBIdxField item : list) {
                PSDEDBIdxFieldDTO dstItem = (PSDEDBIdxFieldDTO)PSModelServiceUtil.getInstance().getPSDEDBIdxFieldService().toDTO(item);
                psdedbidxfields.add(dstItem);
            }
            dto.setPsdedbidxfields(psdedbidxfields);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDBINDEX";
    }

    @Override
    public PSDEDBIndex createDomain() {
        return new PSDEDBIndex();
    }

    @Override
    public PSDEDBIndexDTO createDTO() {
        return new PSDEDBIndexDTO();
    }
}

