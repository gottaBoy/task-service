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
import net.ibizsys.modelapi.dto.PSDEAGDetailDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEActionGroupDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.service.IPSDEAGDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEAGDetailServiceImpl
extends PSModelServiceImplBase<PSDEAGDetail, PSDEAGDetailDTO>
implements IPSDEAGDetailService {
    private static final Log log = LogFactory.getLog(PSDEAGDetailServiceImpl.class);

    @Override
    public List<PSDEAGDetail> listByPSDEActionGroup(PSDEActionGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEAGDetail get(PSDEActionGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEAGDetail> list = this.listByPSDEActionGroup(parent);
        if (list != null) {
            for (PSDEAGDetail item : list) {
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
    public List<PSDEAGDetailDTO> listDTOByPSDEActionGroup(String strParentKey) throws Exception {
        PSDEActionGroup psdeactiongroup = (PSDEActionGroup)PSModelServiceUtil.getInstance().getPSDEActionGroupService().get(strParentKey);
        List<PSDEAGDetail> list = this.listByPSDEActionGroup(psdeactiongroup);
        if (list != null) {
            ArrayList<PSDEAGDetailDTO> dtoList = new ArrayList<PSDEAGDetailDTO>();
            for (PSDEAGDetail item : list) {
                PSDEAGDetailDTO dto = (PSDEAGDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEAGDetail> onListAll() throws Exception {
        ArrayList<PSDEAGDetail> list = new ArrayList<PSDEAGDetail>();
        List psdeactiongroups = PSModelServiceUtil.getInstance().getPSDEActionGroupService().listAll();
        if (psdeactiongroups != null) {
            for (PSDEActionGroup parent : psdeactiongroups) {
                List<PSDEAGDetail> items = this.listByPSDEActionGroup(parent);
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
    protected PSDEAGDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEAGDetail item;
        PSDEActionGroup psdeactiongroup = (PSDEActionGroup)PSModelServiceUtil.getInstance().getPSDEActionGroupService().get(strParentKey, true);
        if (psdeactiongroup != null && (item = this.get(psdeactiongroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEAGDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEAGDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEActionGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEActionGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEAGDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEAGDetailDTO dto, PSDEAGDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEAGDetailId(t.getId().replace("/", "."));
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
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEActionGroupId() != null || !bIgnoreNull) {
            dto.setPSDEActionGroupId(t.getPSDEActionGroupId());
        }
        if (t.getPSDEActionGroupName() != null || !bIgnoreNull) {
            dto.setPSDEActionGroupName(t.getPSDEActionGroupName());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEAGDetailName() != null || !bIgnoreNull) {
            dto.setPSDEAGDetailName(t.getPSDEAGDetailName());
        }
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
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
        if (StringUtils.hasLength((String)dto.getPSDEActionGroupId())) {
            dto.setPSDEActionGroupId(this.getRealPSModelId(t, dto.getPSDEActionGroupId()).replace("/", "."));
        }
        if ("PSDEACTIONGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEActionGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionGroupId())) {
            linkDTO = (PSDEActionGroupDTO)PSModelServiceUtil.getInstance().getPSDEActionGroupService().getDTO(dto.getPSDEActionGroupId());
            dto.setPSDEActionGroupName(((PSDEActionGroupDTO)linkDTO).getPSDEActionGroupName());
            dto.setPSDEId(((PSDEActionGroupDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEActionGroupName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEAGDETAIL";
    }

    @Override
    public PSDEAGDetail createDomain() {
        return new PSDEAGDetail();
    }

    @Override
    public PSDEAGDetailDTO createDTO() {
        return new PSDEAGDetailDTO();
    }
}

