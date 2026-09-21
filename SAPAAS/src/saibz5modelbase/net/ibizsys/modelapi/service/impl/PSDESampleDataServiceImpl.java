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
import net.ibizsys.modelapi.domain.PSDESampleData;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDESampleDataDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDESampleDataService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDESampleDataServiceImpl
extends PSModelServiceImplBase<PSDESampleData, PSDESampleDataDTO>
implements IPSDESampleDataService {
    private static final Log log = LogFactory.getLog(PSDESampleDataServiceImpl.class);

    @Override
    public List<PSDESampleData> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESampleData get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESampleData> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDESampleData item : list) {
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
    public List<PSDESampleDataDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDESampleData> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDESampleDataDTO> dtoList = new ArrayList<PSDESampleDataDTO>();
            for (PSDESampleData item : list) {
                PSDESampleDataDTO dto = (PSDESampleDataDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDESampleData> onListAll() throws Exception {
        ArrayList<PSDESampleData> list = new ArrayList<PSDESampleData>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDESampleData> items = this.listByPSDataEntity(parent);
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
    protected PSDESampleData onGet(String strParentKey, String strCurKey) throws Exception {
        PSDESampleData item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDESampleData)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDESampleDataDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDESampleData et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDESampleDataName())) {
            return et.getPSDESampleDataName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDESampleDataDTO dto, PSDESampleData t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDESampleDataId(t.getId().replace("/", "."));
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
        if (t.getData2() != null || !bIgnoreNull) {
            dto.setData2(t.getData2());
        }
        if (t.getDataType() != null || !bIgnoreNull) {
            dto.setDataType(t.getDataType());
        }
        if (t.getLogicMode() != null || !bIgnoreNull) {
            dto.setLogicMode(t.getLogicMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMainStateId() != null || !bIgnoreNull) {
            dto.setPSDEMainStateId(t.getPSDEMainStateId());
        }
        if (t.getPSDEMainStateName() != null || !bIgnoreNull) {
            dto.setPSDEMainStateName(t.getPSDEMainStateName());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDESampleDataName() != null || !bIgnoreNull) {
            dto.setPSDESampleDataName(t.getPSDESampleDataName());
        }
        if (t.getRandomCnt() != null || !bIgnoreNull) {
            dto.setRandomCnt(t.getRandomCnt());
        }
        if (t.getRandomMode() != null || !bIgnoreNull) {
            dto.setRandomMode(t.getRandomMode());
        }
        if (t.getRandomParam() != null || !bIgnoreNull) {
            dto.setRandomParam(t.getRandomParam());
        }
        if (t.getRandomParam2() != null || !bIgnoreNull) {
            dto.setRandomParam2(t.getRandomParam2());
        }
        if (t.getRandomParam3() != null || !bIgnoreNull) {
            dto.setRandomParam3(t.getRandomParam3());
        }
        if (t.getRandomParam4() != null || !bIgnoreNull) {
            dto.setRandomParam4(t.getRandomParam4());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            dto.setPSDEMainStateId(this.getRealPSModelId(t, dto.getPSDEMainStateId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMainStateId())) {
            linkDTO = (PSDEMainStateDTO)PSModelServiceUtil.getInstance().getPSDEMainStateService().getDTO(dto.getPSDEMainStateId());
            dto.setPSDEMainStateName(((PSDEMainStateDTO)linkDTO).getPSDEMainStateName());
        } else {
            dto.setPSDEMainStateName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDESAMPLEDATA";
    }

    @Override
    public PSDESampleData createDomain() {
        return new PSDESampleData();
    }

    @Override
    public PSDESampleDataDTO createDTO() {
        return new PSDESampleDataDTO();
    }
}

