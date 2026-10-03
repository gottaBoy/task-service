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
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.domain.PSViewMsgGrpDetail;
import net.ibizsys.modelapi.dto.PSViewMsgDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.dto.PSViewMsgGrpDetailDTO;
import net.ibizsys.modelapi.service.IPSViewMsgGrpDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSViewMsgGrpDetailServiceImpl
extends PSModelServiceImplBase<PSViewMsgGrpDetail, PSViewMsgGrpDetailDTO>
implements IPSViewMsgGrpDetailService {
    private static final Log log = LogFactory.getLog(PSViewMsgGrpDetailServiceImpl.class);

    @Override
    public List<PSViewMsgGrpDetail> listByPSViewMsgGroup(PSViewMsgGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSViewMsgGrpDetail get(PSViewMsgGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSViewMsgGrpDetail> list = this.listByPSViewMsgGroup(parent);
        if (list != null) {
            for (PSViewMsgGrpDetail item : list) {
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
    public List<PSViewMsgGrpDetailDTO> listDTOByPSViewMsgGroup(String strParentKey) throws Exception {
        PSViewMsgGroup psviewmsggroup = (PSViewMsgGroup)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().get(strParentKey);
        List<PSViewMsgGrpDetail> list = this.listByPSViewMsgGroup(psviewmsggroup);
        if (list != null) {
            ArrayList<PSViewMsgGrpDetailDTO> dtoList = new ArrayList<PSViewMsgGrpDetailDTO>();
            for (PSViewMsgGrpDetail item : list) {
                PSViewMsgGrpDetailDTO dto = (PSViewMsgGrpDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSViewMsgGrpDetail> onListAll() throws Exception {
        ArrayList<PSViewMsgGrpDetail> list = new ArrayList<PSViewMsgGrpDetail>();
        List<PSViewMsgGroup> psviewmsggroups = PSModelServiceUtil.getInstance().getPSViewMsgGroupService().listAll();
        if (psviewmsggroups != null) {
            for (PSViewMsgGroup parent : psviewmsggroups) {
                List<PSViewMsgGrpDetail> items = this.listByPSViewMsgGroup(parent);
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
    protected PSViewMsgGrpDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSViewMsgGrpDetail item;
        PSViewMsgGroup psviewmsggroup = (PSViewMsgGroup)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().get(strParentKey, true);
        if (psviewmsggroup != null && (item = this.get(psviewmsggroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSViewMsgGrpDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSViewMsgGrpDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSViewMsgGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSViewMsgGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSViewMsgGrpDetail et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSViewMsgGrpDetailDTO dto, PSViewMsgGrpDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSViewMsgGrpDetailId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynamicMode() != null || !bIgnoreNull) {
            dto.setDynamicMode(t.getDynamicMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMsgPos() != null || !bIgnoreNull) {
            dto.setMsgPos(t.getMsgPos());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSViewMsgGroupId() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupId(t.getPSViewMsgGroupId());
        }
        if (t.getPSViewMsgGroupName() != null || !bIgnoreNull) {
            dto.setPSViewMsgGroupName(t.getPSViewMsgGroupName());
        }
        if (t.getPSViewMsgGrpDetailName() != null || !bIgnoreNull) {
            dto.setPSViewMsgGrpDetailName(t.getPSViewMsgGrpDetailName());
        }
        if (t.getPSViewMsgId() != null || !bIgnoreNull) {
            dto.setPSViewMsgId(t.getPSViewMsgId());
        }
        if (t.getPSViewMsgName() != null || !bIgnoreNull) {
            dto.setPSViewMsgName(t.getPSViewMsgName());
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
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            dto.setPSViewMsgGroupId(this.getRealPSModelId(t, dto.getPSViewMsgGroupId()).replace("/", "."));
        }
        if ("PSVIEWMSGGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSViewMsgGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgId())) {
            dto.setPSViewMsgId(this.getRealPSModelId(t, dto.getPSViewMsgId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgGroupId())) {
            linkDTO = (PSViewMsgGroupDTO)PSModelServiceUtil.getInstance().getPSViewMsgGroupService().getDTO(dto.getPSViewMsgGroupId());
            dto.setPSViewMsgGroupName(((PSViewMsgGroupDTO)linkDTO).getPSViewMsgGroupName());
        } else {
            dto.setPSViewMsgGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSViewMsgId())) {
            linkDTO = (PSViewMsgDTO)PSModelServiceUtil.getInstance().getPSViewMsgService().getDTO(dto.getPSViewMsgId());
            dto.setDynamicMode(((PSViewMsgDTO)linkDTO).getDynamicMode());
            dto.setPSViewMsgName(((PSViewMsgDTO)linkDTO).getPSViewMsgName());
        } else {
            dto.setDynamicMode(null);
            dto.setPSViewMsgName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSVIEWMSGGRPDETAIL";
    }

    @Override
    public PSViewMsgGrpDetail createDomain() {
        return new PSViewMsgGrpDetail();
    }

    @Override
    public PSViewMsgGrpDetailDTO createDTO() {
        return new PSViewMsgGrpDetailDTO();
    }
}

