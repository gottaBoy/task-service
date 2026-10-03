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
import net.ibizsys.modelapi.domain.PSDEAGDetail;
import net.ibizsys.modelapi.domain.PSDEActionGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEAGDetailDTO;
import net.ibizsys.modelapi.dto.PSDEActionGroupDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEActionGroupService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEActionGroupServiceImpl
extends PSModelServiceImplBase<PSDEActionGroup, PSDEActionGroupDTO>
implements IPSDEActionGroupService {
    private static final Log log = LogFactory.getLog(PSDEActionGroupServiceImpl.class);

    @Override
    public List<PSDEActionGroup> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEActionGroup get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEActionGroup> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEActionGroup item : list) {
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
    public List<PSDEActionGroupDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEActionGroup> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEActionGroupDTO> dtoList = new ArrayList<PSDEActionGroupDTO>();
            for (PSDEActionGroup item : list) {
                PSDEActionGroupDTO dto = (PSDEActionGroupDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEActionGroup> onListAll() throws Exception {
        ArrayList<PSDEActionGroup> list = new ArrayList<PSDEActionGroup>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEActionGroup> items = this.listByPSDataEntity(parent);
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
    protected PSDEActionGroup onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEActionGroup item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEActionGroup)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEActionGroupDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEActionGroup et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDEActionGroupName())) {
            return et.getPSDEActionGroupName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEActionGroupDTO dto, PSDEActionGroup t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEActionGroupId(t.getId().replace("/", "."));
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
        if (t.getGroupTag() != null || !bIgnoreNull) {
            dto.setGroupTag(t.getGroupTag());
        }
        if (t.getGroupTag2() != null || !bIgnoreNull) {
            dto.setGroupTag2(t.getGroupTag2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEActionGroupName() != null || !bIgnoreNull) {
            dto.setPSDEActionGroupName(t.getPSDEActionGroupName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
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
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            PSDataEntityDTO linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(linkDTO.getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        List<PSDEAGDetail> list = PSModelServiceUtil.getInstance().getPSDEAGDetailService().listByPSDEActionGroup(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEAGDetailDTO> psdeagdetails = new ArrayList<PSDEAGDetailDTO>();
            for (PSDEAGDetail item : list) {
                PSDEAGDetailDTO dstItem = (PSDEAGDetailDTO)PSModelServiceUtil.getInstance().getPSDEAGDetailService().toDTO(item);
                psdeagdetails.add(dstItem);
            }
            dto.setPsdeagdetails(psdeagdetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEACTIONGROUP";
    }

    @Override
    public PSDEActionGroup createDomain() {
        return new PSDEActionGroup();
    }

    @Override
    public PSDEActionGroupDTO createDTO() {
        return new PSDEActionGroupDTO();
    }
}

