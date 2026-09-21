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
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUAGroupDetail;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.dto.PSDEUAGroupDetailDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysImageDTO;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.service.IPSDEUAGroupDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEUAGroupDetailServiceImpl
extends PSModelServiceImplBase<PSDEUAGroupDetail, PSDEUAGroupDetailDTO>
implements IPSDEUAGroupDetailService {
    private static final Log log = LogFactory.getLog(PSDEUAGroupDetailServiceImpl.class);

    @Override
    public List<PSDEUAGroupDetail> listByPSDEUAGroup(PSDEUAGroup parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUAGroupDetail get(PSDEUAGroup parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUAGroupDetail> list = this.listByPSDEUAGroup(parent);
        if (list != null) {
            for (PSDEUAGroupDetail item : list) {
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
    public List<PSDEUAGroupDetailDTO> listDTOByPSDEUAGroup(String strParentKey) throws Exception {
        PSDEUAGroup psdeuagroup = (PSDEUAGroup)PSModelServiceUtil.getInstance().getPSDEUAGroupService().get(strParentKey);
        List<PSDEUAGroupDetail> list = this.listByPSDEUAGroup(psdeuagroup);
        if (list != null) {
            ArrayList<PSDEUAGroupDetailDTO> dtoList = new ArrayList<PSDEUAGroupDetailDTO>();
            for (PSDEUAGroupDetail item : list) {
                PSDEUAGroupDetailDTO dto = (PSDEUAGroupDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEUAGroupDetail> onListAll() throws Exception {
        ArrayList<PSDEUAGroupDetail> list = new ArrayList<PSDEUAGroupDetail>();
        List psdeuagroups = PSModelServiceUtil.getInstance().getPSDEUAGroupService().listAll();
        if (psdeuagroups != null) {
            for (PSDEUAGroup parent : psdeuagroups) {
                List<PSDEUAGroupDetail> items = this.listByPSDEUAGroup(parent);
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
    protected PSDEUAGroupDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEUAGroupDetail item;
        PSDEUAGroup psdeuagroup = (PSDEUAGroup)PSModelServiceUtil.getInstance().getPSDEUAGroupService().get(strParentKey, true);
        if (psdeuagroup != null && (item = this.get(psdeuagroup, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEUAGroupDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEUAGroupDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEUAGroupId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEUAGroupService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEUAGroupDetail et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEUAGroupDetailDTO dto, PSDEUAGroupDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEUAGRPDetailId(t.getId().replace("/", "."));
        }
        if (t.getActionLevel() != null || !bIgnoreNull) {
            dto.setActionLevel(t.getActionLevel());
        }
        if (t.getAddSeparator() != null || !bIgnoreNull) {
            dto.setAddSeparator(t.getAddSeparator());
        }
        if (t.getAfterContent() != null || !bIgnoreNull) {
            dto.setAfterContent(t.getAfterContent());
        }
        if (t.getAfterItemType() != null || !bIgnoreNull) {
            dto.setAfterItemType(t.getAfterItemType());
        }
        if (t.getAfterPSSysCssId() != null || !bIgnoreNull) {
            dto.setAfterPSSysCssId(t.getAfterPSSysCssId());
        }
        if (t.getAfterPSSysCssName() != null || !bIgnoreNull) {
            dto.setAfterPSSysCssName(t.getAfterPSSysCssName());
        }
        if (t.getAfterPSSysResourceId() != null || !bIgnoreNull) {
            dto.setAfterPSSysResourceId(t.getAfterPSSysResourceId());
        }
        if (t.getAfterPSSysResourceName() != null || !bIgnoreNull) {
            dto.setAfterPSSysResourceName(t.getAfterPSSysResourceName());
        }
        if (t.getBeforeContent() != null || !bIgnoreNull) {
            dto.setBeforeContent(t.getBeforeContent());
        }
        if (t.getBeforeItemType() != null || !bIgnoreNull) {
            dto.setBeforeItemType(t.getBeforeItemType());
        }
        if (t.getBeforePSSysCssId() != null || !bIgnoreNull) {
            dto.setBeforePSSysCssId(t.getBeforePSSysCssId());
        }
        if (t.getBeforePSSysCssName() != null || !bIgnoreNull) {
            dto.setBeforePSSysCssName(t.getBeforePSSysCssName());
        }
        if (t.getBeforePSSysResourceId() != null || !bIgnoreNull) {
            dto.setBeforePSSysResourceId(t.getBeforePSSysResourceId());
        }
        if (t.getBeforePSSysResourceName() != null || !bIgnoreNull) {
            dto.setBeforePSSysResourceName(t.getBeforePSSysResourceName());
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
        if (t.getDetailTag() != null || !bIgnoreNull) {
            dto.setDetailTag(t.getDetailTag());
        }
        if (t.getDetailTag2() != null || !bIgnoreNull) {
            dto.setDetailTag2(t.getDetailTag2());
        }
        if (t.getDetailType() != null || !bIgnoreNull) {
            dto.setDetailType(t.getDetailType());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEUAGroupId() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupId(t.getPSDEUAGroupId());
        }
        if (t.getPSDEUAGroupName() != null || !bIgnoreNull) {
            dto.setPSDEUAGroupName(t.getPSDEUAGroupName());
        }
        if (t.getPSDEUAGRPDetailName() != null || !bIgnoreNull) {
            dto.setPSDEUAGRPDetailName(t.getPSDEUAGRPDetailName());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysImageId() != null || !bIgnoreNull) {
            dto.setPSSysImageId(t.getPSSysImageId());
        }
        if (t.getPSSysImageName() != null || !bIgnoreNull) {
            dto.setPSSysImageName(t.getPSSysImageName());
        }
        if (t.getShowMode() != null || !bIgnoreNull) {
            dto.setShowMode(t.getShowMode());
        }
        if (t.getUACaption() != null || !bIgnoreNull) {
            dto.setUACaption(t.getUACaption());
        }
        if (t.getUIActionParams() != null || !bIgnoreNull) {
            dto.setUIActionParams(t.getUIActionParams());
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
        if (StringUtils.hasLength((String)dto.getAfterPSSysCssId())) {
            dto.setAfterPSSysCssId(this.getRealPSModelId(t, dto.getAfterPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAfterPSSysResourceId())) {
            dto.setAfterPSSysResourceId(this.getRealPSModelId(t, dto.getAfterPSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeforePSSysCssId())) {
            dto.setBeforePSSysCssId(this.getRealPSModelId(t, dto.getBeforePSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getBeforePSSysResourceId())) {
            dto.setBeforePSSysResourceId(this.getRealPSModelId(t, dto.getBeforePSSysResourceId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            dto.setPSDEUAGroupId(this.getRealPSModelId(t, dto.getPSDEUAGroupId()).replace("/", "."));
        }
        if ("PSDEUAGROUP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEUAGroupId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            dto.setPSSysImageId(this.getRealPSModelId(t, dto.getPSSysImageId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getAfterPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getAfterPSSysCssId());
            dto.setAfterPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setAfterPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getAfterPSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getAfterPSSysResourceId());
            dto.setAfterPSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setAfterPSSysResourceName(null);
        }
        if (StringUtils.hasLength((String)dto.getBeforePSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getBeforePSSysCssId());
            dto.setBeforePSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setBeforePSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getBeforePSSysResourceId())) {
            linkDTO = (PSSysResourceDTO)PSModelServiceUtil.getInstance().getPSSysResourceService().getDTO(dto.getBeforePSSysResourceId());
            dto.setBeforePSSysResourceName(((PSSysResourceDTO)linkDTO).getPSSysResourceName());
        } else {
            dto.setBeforePSSysResourceName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUAGroupId())) {
            linkDTO = (PSDEUAGroupDTO)PSModelServiceUtil.getInstance().getPSDEUAGroupService().getDTO(dto.getPSDEUAGroupId());
            dto.setPSDEId(((PSDEUAGroupDTO)linkDTO).getPSDEId());
            dto.setPSDEUAGroupName(((PSDEUAGroupDTO)linkDTO).getPSDEUAGroupName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEUAGroupName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
            dto.setUACaption(((PSDEUIActionDTO)linkDTO).getCaption());
        } else {
            dto.setPSDEUIActionName(null);
            dto.setUACaption(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysImageId())) {
            linkDTO = (PSSysImageDTO)PSModelServiceUtil.getInstance().getPSSysImageService().getDTO(dto.getPSSysImageId());
            dto.setPSSysImageName(((PSSysImageDTO)linkDTO).getPSSysImageName());
        } else {
            dto.setPSSysImageName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEUAGRPDETAIL";
    }

    @Override
    public PSDEUAGroupDetail createDomain() {
        return new PSDEUAGroupDetail();
    }

    @Override
    public PSDEUAGroupDetailDTO createDTO() {
        return new PSDEUAGroupDetailDTO();
    }
}

