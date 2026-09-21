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
import net.ibizsys.modelapi.domain.PSDEDataImp;
import net.ibizsys.modelapi.domain.PSDEDataImpItem;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpDTO;
import net.ibizsys.modelapi.dto.PSDEDataImpItemDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEDataImpService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDataImpServiceImpl
extends PSModelServiceImplBase<PSDEDataImp, PSDEDataImpDTO>
implements IPSDEDataImpService {
    private static final Log log = LogFactory.getLog(PSDEDataImpServiceImpl.class);

    @Override
    public List<PSDEDataImp> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDataImp get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDataImp> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDataImp item : list) {
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
    public List<PSDEDataImpDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDataImp> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDataImpDTO> dtoList = new ArrayList<PSDEDataImpDTO>();
            for (PSDEDataImp item : list) {
                PSDEDataImpDTO dto = (PSDEDataImpDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDataImp> onListAll() throws Exception {
        ArrayList<PSDEDataImp> list = new ArrayList<PSDEDataImp>();
        List psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDataImp> items = this.listByPSDataEntity(parent);
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
    protected PSDEDataImp onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDataImp item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDataImp)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDataImpDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDataImp et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEDataImpName())) {
            return et.getPSDEDataImpName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDataImpDTO dto, PSDEDataImp t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDataImpId(t.getId().replace("/", "."));
        }
        if (t.getActionHolder() != null || !bIgnoreNull) {
            dto.setActionHolder(t.getActionHolder());
        }
        if (t.getBatchSize() != null || !bIgnoreNull) {
            dto.setBatchSize(t.getBatchSize());
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
        if (t.getCreatePSDEActionId() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionId(t.getCreatePSDEActionId());
        }
        if (t.getCreatePSDEActionName() != null || !bIgnoreNull) {
            dto.setCreatePSDEActionName(t.getCreatePSDEActionName());
        }
        if (t.getCreatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivId(t.getCreatePSDEOPPrivId());
        }
        if (t.getCreatePSDEOPPrivIName() != null || !bIgnoreNull) {
            dto.setCreatePSDEOPPrivIName(t.getCreatePSDEOPPrivIName());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPOTime() != null || !bIgnoreNull) {
            dto.setPOTime(t.getPOTime());
        }
        if (t.getPSDEDataImpName() != null || !bIgnoreNull) {
            dto.setPSDEDataImpName(t.getPSDEDataImpName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getStopWhenError() != null || !bIgnoreNull) {
            dto.setStopWhenError(t.getStopWhenError());
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
        if (t.getUpdatePSDEActionId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionId(t.getUpdatePSDEActionId());
        }
        if (t.getUpdatePSDEActionName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEActionName(t.getUpdatePSDEActionName());
        }
        if (t.getUpdatePSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivId(t.getUpdatePSDEOPPrivId());
        }
        if (t.getUpdatePSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setUpdatePSDEOPPrivName(t.getUpdatePSDEOPPrivName());
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
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            dto.setCreatePSDEActionId(this.getRealPSModelId(t, dto.getCreatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            dto.setCreatePSDEOPPrivId(this.getRealPSModelId(t, dto.getCreatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            dto.setUpdatePSDEActionId(this.getRealPSModelId(t, dto.getUpdatePSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            dto.setUpdatePSDEOPPrivId(this.getRealPSModelId(t, dto.getUpdatePSDEOPPrivId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getCreatePSDEActionId());
            dto.setCreatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setCreatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getCreatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getCreatePSDEOPPrivId());
            dto.setCreatePSDEOPPrivIName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setCreatePSDEOPPrivIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getUpdatePSDEActionId());
            dto.setUpdatePSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setUpdatePSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getUpdatePSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getUpdatePSDEOPPrivId());
            dto.setUpdatePSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setUpdatePSDEOPPrivName(null);
        }
        List<PSDEDataImpItem> list = PSModelServiceUtil.getInstance().getPSDEDataImpItemService().listByPSDEDataImp(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEDataImpItemDTO> psdedataimpitems = new ArrayList<PSDEDataImpItemDTO>();
            for (PSDEDataImpItem item : list) {
                PSDEDataImpItemDTO dstItem = (PSDEDataImpItemDTO)PSModelServiceUtil.getInstance().getPSDEDataImpItemService().toDTO(item);
                psdedataimpitems.add(dstItem);
            }
            dto.setPsdedataimpitems(psdedataimpitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDATAIMP";
    }

    @Override
    public PSDEDataImp createDomain() {
        return new PSDEDataImp();
    }

    @Override
    public PSDEDataImpDTO createDTO() {
        return new PSDEDataImpDTO();
    }
}

