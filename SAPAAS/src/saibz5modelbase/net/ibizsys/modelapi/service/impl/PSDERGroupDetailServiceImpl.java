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
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDERGroupDetail;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSDERGroupDTO;
import net.ibizsys.modelapi.dto.PSDERGroupDetailDTO;
import net.ibizsys.modelapi.service.IPSDERGroupDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDERGroupDetailServiceImpl
extends PSModelServiceImplBase<PSDERGroupDetail, PSDERGroupDetailDTO>
implements IPSDERGroupDetailService {
    private static final Log log = LogFactory.getLog(PSDERGroupDetailServiceImpl.class);

    @Override
    public List<PSDERGroupDetail> listByPSDERGroup(PSDERGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDERGroupDetail get(PSDERGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDERGroupDetail> list = this.listByPSDERGroup(parent);
        if (list != null) {
            for (PSDERGroupDetail item : list) {
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
    public List<PSDERGroupDetailDTO> listDTOByPSDERGroup(String strParentKey) throws Exception {
        PSDERGroup psdergroup = (PSDERGroup)PSModelServiceUtil.getInstance().getPSDERGroupService().get(strParentKey);
        List<PSDERGroupDetail> list = this.listByPSDERGroup(psdergroup);
        if (list != null) {
            ArrayList<PSDERGroupDetailDTO> dtoList = new ArrayList<PSDERGroupDetailDTO>();
            for (PSDERGroupDetail item : list) {
                PSDERGroupDetailDTO dto = (PSDERGroupDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDERGroupDetail> onListAll() throws Exception {
        ArrayList<PSDERGroupDetail> list = new ArrayList<PSDERGroupDetail>();
        List psdergroups = PSModelServiceUtil.getInstance().getPSDERGroupService().listAll();
        if (psdergroups != null) {
            for (PSDERGroup parent : psdergroups) {
                List<PSDERGroupDetail> items = this.listByPSDERGroup(parent);
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
    protected PSDERGroupDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDERGroupDetail item;
        PSDERGroup psdergroup = (PSDERGroup)PSModelServiceUtil.getInstance().getPSDERGroupService().get(strParentKey, true);
        if (psdergroup != null && (item = this.get(psdergroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSDERGroupDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDERGroupDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDERGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDERGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDERGroupDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDERGroupDetailName())) {
            return et.getPSDERGroupDetailName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDERGroupDetailDTO dto, PSDERGroupDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDERGroupDetailId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDERGroupDetailName() != null || !bIgnoreNull) {
            dto.setPSDERGroupDetailName(t.getPSDERGroupDetailName());
        }
        if (t.getPSDERGroupId() != null || !bIgnoreNull) {
            dto.setPSDERGroupId(t.getPSDERGroupId());
        }
        if (t.getPSDERGroupName() != null || !bIgnoreNull) {
            dto.setPSDERGroupName(t.getPSDERGroupName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
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
        if (StringUtils.hasLength((String)dto.getPSDERGroupId())) {
            dto.setPSDERGroupId(this.getRealPSModelId(t, dto.getPSDERGroupId()).replace("/", "."));
        }
        if ("PSDERGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDERGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERGroupId())) {
            linkDTO = (PSDERGroupDTO)PSModelServiceUtil.getInstance().getPSDERGroupService().getDTO(dto.getPSDERGroupId());
            dto.setPSDERGroupName(((PSDERGroupDTO)linkDTO).getPSDERGroupName());
        } else {
            dto.setPSDERGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDERGROUPDETAIL";
    }

    @Override
    public PSDERGroupDetail createDomain() {
        return new PSDERGroupDetail();
    }

    @Override
    public PSDERGroupDetailDTO createDTO() {
        return new PSDERGroupDetailDTO();
    }
}

