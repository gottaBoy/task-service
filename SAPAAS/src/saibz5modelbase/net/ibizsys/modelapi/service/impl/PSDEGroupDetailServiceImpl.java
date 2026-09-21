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
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDEGroupDetail;
import net.ibizsys.modelapi.dto.PSDEGroupDTO;
import net.ibizsys.modelapi.dto.PSDEGroupDetailDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEGroupDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGroupDetailServiceImpl
extends PSModelServiceImplBase<PSDEGroupDetail, PSDEGroupDetailDTO>
implements IPSDEGroupDetailService {
    private static final Log log = LogFactory.getLog(PSDEGroupDetailServiceImpl.class);

    @Override
    public List<PSDEGroupDetail> listByPSDEGroup(PSDEGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGroupDetail get(PSDEGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGroupDetail> list = this.listByPSDEGroup(parent);
        if (list != null) {
            for (PSDEGroupDetail item : list) {
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
    public List<PSDEGroupDetailDTO> listDTOByPSDEGroup(String strParentKey) throws Exception {
        PSDEGroup psdegroup = (PSDEGroup)PSModelServiceUtil.getInstance().getPSDEGroupService().get(strParentKey);
        List<PSDEGroupDetail> list = this.listByPSDEGroup(psdegroup);
        if (list != null) {
            ArrayList<PSDEGroupDetailDTO> dtoList = new ArrayList<PSDEGroupDetailDTO>();
            for (PSDEGroupDetail item : list) {
                PSDEGroupDetailDTO dto = (PSDEGroupDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGroupDetail> onListAll() throws Exception {
        ArrayList<PSDEGroupDetail> list = new ArrayList<PSDEGroupDetail>();
        List psdegroups = PSModelServiceUtil.getInstance().getPSDEGroupService().listAll();
        if (psdegroups != null) {
            for (PSDEGroup parent : psdegroups) {
                List<PSDEGroupDetail> items = this.listByPSDEGroup(parent);
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
    protected PSDEGroupDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGroupDetail item;
        PSDEGroup psdegroup = (PSDEGroup)PSModelServiceUtil.getInstance().getPSDEGroupService().get(strParentKey, true);
        if (psdegroup != null && (item = this.get(psdegroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGroupDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGroupDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGroupDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGroupDetailDTO dto, PSDEGroupDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGroupDetailId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCodeName2() != null || !bIgnoreNull) {
            dto.setCodeName2(t.getCodeName2());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDETag() != null || !bIgnoreNull) {
            dto.setDETag(t.getDETag());
        }
        if (t.getDETag2() != null || !bIgnoreNull) {
            dto.setDETag2(t.getDETag2());
        }
        if (t.getDetailParam() != null || !bIgnoreNull) {
            dto.setDetailParam(t.getDetailParam());
        }
        if (t.getDetailParam2() != null || !bIgnoreNull) {
            dto.setDetailParam2(t.getDetailParam2());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModColor() != null || !bIgnoreNull) {
            dto.setModColor(t.getModColor());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEGroupDetailName() != null || !bIgnoreNull) {
            dto.setPSDEGroupDetailName(t.getPSDEGroupDetailName());
        }
        if (t.getPSDEGroupId() != null || !bIgnoreNull) {
            dto.setPSDEGroupId(t.getPSDEGroupId());
        }
        if (t.getPSDEGroupName() != null || !bIgnoreNull) {
            dto.setPSDEGroupName(t.getPSDEGroupName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
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
        if (StringUtils.hasLength((String)dto.getPSDEGroupId())) {
            dto.setPSDEGroupId(this.getRealPSModelId(t, dto.getPSDEGroupId()).replace("/", "."));
        }
        if ("PSDEGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGroupId())) {
            linkDTO = (PSDEGroupDTO)PSModelServiceUtil.getInstance().getPSDEGroupService().getDTO(dto.getPSDEGroupId());
            dto.setPSDEGroupName(((PSDEGroupDTO)linkDTO).getPSDEGroupName());
        } else {
            dto.setPSDEGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setColor(((PSDataEntityDTO)linkDTO).getColor());
            dto.setLogicName(((PSDataEntityDTO)linkDTO).getLogicName());
            dto.setModColor(((PSDataEntityDTO)linkDTO).getModColor());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
            dto.setPSModuleName(((PSDataEntityDTO)linkDTO).getPSModuleName());
        } else {
            dto.setColor(null);
            dto.setLogicName(null);
            dto.setModColor(null);
            dto.setPSDEName(null);
            dto.setPSModuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEGROUPDETAIL";
    }

    @Override
    public PSDEGroupDetail createDomain() {
        return new PSDEGroupDetail();
    }

    @Override
    public PSDEGroupDetailDTO createDTO() {
        return new PSDEGroupDetailDTO();
    }
}

