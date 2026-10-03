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
import net.ibizsys.modelapi.domain.PSDEFGroup;
import net.ibizsys.modelapi.domain.PSDEFGroupDetail;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.dto.PSDEFGroupDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.dto.PSDEVRGroupDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.service.IPSDEFGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFGroupServiceImpl
extends PSModelServiceImplBase<PSDEFGroup, PSDEFGroupDTO>
implements IPSDEFGroupService {
    private static final Log log = LogFactory.getLog(PSDEFGroupServiceImpl.class);

    @Override
    public List<PSDEFGroup> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFGroup get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFGroup> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEFGroup item : list) {
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
    public List<PSDEFGroupDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEFGroup> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEFGroupDTO> dtoList = new ArrayList<PSDEFGroupDTO>();
            for (PSDEFGroup item : list) {
                PSDEFGroupDTO dto = (PSDEFGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFGroup> onListAll() throws Exception {
        ArrayList<PSDEFGroup> list = new ArrayList<PSDEFGroup>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEFGroup> items = this.listByPSDataEntity(parent);
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
    protected PSDEFGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFGroup item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEFGroupName())) {
            return et.getPSDEFGroupName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFGroupDTO dto, PSDEFGroup t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFGroupId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDTOCodeName() != null || !bIgnoreNull) {
            dto.setDTOCodeName(t.getDTOCodeName());
        }
        if (t.getGroupTag() != null || !bIgnoreNull) {
            dto.setGroupTag(t.getGroupTag());
        }
        if (t.getGroupTag2() != null || !bIgnoreNull) {
            dto.setGroupTag2(t.getGroupTag2());
        }
        if (t.getGroupType() != null || !bIgnoreNull) {
            dto.setGroupType(t.getGroupType());
        }
        if (t.getInitPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setInitPSSysDynaModelId(t.getInitPSSysDynaModelId());
        }
        if (t.getInitPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setInitPSSysDynaModelName(t.getInitPSSysDynaModelName());
        }
        if (t.getLogicMode() != null || !bIgnoreNull) {
            dto.setLogicMode(t.getLogicMode());
        }
        if (t.getLogicParam() != null || !bIgnoreNull) {
            dto.setLogicParam(t.getLogicParam());
        }
        if (t.getLogicParam2() != null || !bIgnoreNull) {
            dto.setLogicParam2(t.getLogicParam2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEFGroupName() != null || !bIgnoreNull) {
            dto.setPSDEFGroupName(t.getPSDEFGroupName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEVRGroupId() != null || !bIgnoreNull) {
            dto.setPSDEVRGroupId(t.getPSDEVRGroupId());
        }
        if (t.getPSDEVRGroupName() != null || !bIgnoreNull) {
            dto.setPSDEVRGroupName(t.getPSDEVRGroupName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
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
        if (StringUtils.hasLength((String)dto.getInitPSSysDynaModelId())) {
            dto.setInitPSSysDynaModelId(this.getRealPSModelId(t, dto.getInitPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEVRGroupId())) {
            dto.setPSDEVRGroupId(this.getRealPSModelId(t, dto.getPSDEVRGroupId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getInitPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getInitPSSysDynaModelId());
            dto.setInitPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setInitPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
        } else {
            dto.setPSDEFormName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEVRGroupId())) {
            linkDTO = (PSDEVRGroupDTO)PSModelServiceUtil.getInstance().getPSDEVRGroupService().getDTO(dto.getPSDEVRGroupId());
            dto.setPSDEVRGroupName(((PSDEVRGroupDTO)linkDTO).getPSDEVRGroupName());
        } else {
            dto.setPSDEVRGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        List<PSDEFGroupDetail> list = PSModelServiceUtil.getInstance().getPSDEFGroupDetailService().listByPSDEFGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEFGroupDetailDTO> psdefgroupdetails = new ArrayList<PSDEFGroupDetailDTO>();
            for (PSDEFGroupDetail item : list) {
                PSDEFGroupDetailDTO dstItem = (PSDEFGroupDetailDTO)PSModelServiceUtil.getInstance().getPSDEFGroupDetailService().toDTO(item);
                psdefgroupdetails.add(dstItem);
            }
            dto.setPsdefgroupdetails(psdefgroupdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFGROUP";
    }

    @Override
    public PSDEFGroup createDomain() {
        return new PSDEFGroup();
    }

    @Override
    public PSDEFGroupDTO createDTO() {
        return new PSDEFGroupDTO();
    }
}

