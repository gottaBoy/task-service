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
import net.ibizsys.modelapi.domain.PSDEDQJoin;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDQJoinDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEDataQueryService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataQueryServiceImpl
extends PSModelServiceImplBase<PSDEDataQuery, PSDEDataQueryDTO>
implements IPSDEDataQueryService {
    private static final Log log = LogFactory.getLog(PSDEDataQueryServiceImpl.class);

    @Override
    public List<PSDEDataQuery> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataQuery get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataQuery> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDataQuery item : list) {
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
    public List<PSDEDataQueryDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDataQuery> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDataQueryDTO> dtoList = new ArrayList<PSDEDataQueryDTO>();
            for (PSDEDataQuery item : list) {
                PSDEDataQueryDTO dto = (PSDEDataQueryDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataQuery> onListAll() throws Exception {
        ArrayList<PSDEDataQuery> list = new ArrayList<PSDEDataQuery>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDataQuery> items = this.listByPSDataEntity(parent);
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
    protected PSDEDataQuery onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataQuery item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataQuery)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataQueryDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataQuery et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDataQueryName())) {
            return et.getPSDEDataQueryName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataQueryDTO dto, PSDEDataQuery t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataQueryId(t.getId().replace("/", "."));
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
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getDefaultMode() != null || !bIgnoreNull) {
            dto.setDefaultMode(t.getDefaultMode());
        }
        if (t.getDQSN() != null || !bIgnoreNull) {
            dto.setDQSN(t.getDQSN());
        }
        if (t.getDQTag() != null || !bIgnoreNull) {
            dto.setDQTag(t.getDQTag());
        }
        if (t.getDQTag2() != null || !bIgnoreNull) {
            dto.setDQTag2(t.getDQTag2());
        }
        if (t.getDQTag3() != null || !bIgnoreNull) {
            dto.setDQTag3(t.getDQTag3());
        }
        if (t.getDQTag4() != null || !bIgnoreNull) {
            dto.setDQTag4(t.getDQTag4());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPrivMode() != null || !bIgnoreNull) {
            dto.setPrivMode(t.getPrivMode());
        }
        if (t.getPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setPSDEDataQueryName(t.getPSDEDataQueryName());
        }
        if (t.getPSDEFGroupId() != null || !bIgnoreNull) {
            dto.setPSDEFGroupId(t.getPSDEFGroupId());
        }
        if (t.getPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupName(t.getPSDEFGroupName());
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
        if (t.getPubMode() != null || !bIgnoreNull) {
            dto.setPubMode(t.getPubMode());
        }
        if (t.getQueryViewFlag() != null || !bIgnoreNull) {
            dto.setQueryViewFlag(t.getQueryViewFlag());
        }
        if (t.getRequestMethod() != null || !bIgnoreNull) {
            dto.setRequestMethod(t.getRequestMethod());
        }
        if (t.getRequestPath() != null || !bIgnoreNull) {
            dto.setRequestPath(t.getRequestPath());
        }
        if (t.getToDoTask() != null || !bIgnoreNull) {
            dto.setToDoTask(t.getToDoTask());
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
        if (t.getViewColLevel() != null || !bIgnoreNull) {
            dto.setViewColLevel(t.getViewColLevel());
        }
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            dto.setPSDEFGroupId(this.getRealPSModelId(t, dto.getPSDEFGroupId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEFGroupId())) {
            linkDTO = (PSDEFGroupDTO)PSModelServiceUtil.getInstance().getPSDEFGroupService().getDTO(dto.getPSDEFGroupId());
            dto.setPSDEFGroupName(((PSDEFGroupDTO)linkDTO).getPSDEFGroupName());
        } else {
            dto.setPSDEFGroupName(null);
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
        List<PSDEDQJoin> list = PSModelServiceUtil.getInstance().getPSDEDQJoinService().listByPSDEDataQuery(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEDQJoinDTO> psdedqjoins = new ArrayList<PSDEDQJoinDTO>();
            for (PSDEDQJoin item : list) {
                PSDEDQJoinDTO dstItem = (PSDEDQJoinDTO)PSModelServiceUtil.getInstance().getPSDEDQJoinService().toDTO(item);
                psdedqjoins.add(dstItem);
            }
            dto.setPsdedqjoins(psdedqjoins);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDATAQUERY";
    }

    @Override
    public PSDEDataQuery createDomain() {
        return new PSDEDataQuery();
    }

    @Override
    public PSDEDataQueryDTO createDTO() {
        return new PSDEDataQueryDTO();
    }
}

