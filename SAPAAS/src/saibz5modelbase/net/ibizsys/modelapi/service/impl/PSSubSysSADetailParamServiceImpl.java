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
import net.ibizsys.modelapi.domain.PSSubSysSADetail;
import net.ibizsys.modelapi.domain.PSSubSysSADetailParam;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.dto.PSSubSysSADetailParamDTO;
import net.ibizsys.modelapi.service.IPSSubSysSADetailParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSubSysSADetailParamServiceImpl
extends PSModelServiceImplBase<PSSubSysSADetailParam, PSSubSysSADetailParamDTO>
implements IPSSubSysSADetailParamService {
    private static final Log log = LogFactory.getLog(PSSubSysSADetailParamServiceImpl.class);

    @Override
    public List<PSSubSysSADetailParam> listByPSSubSysSADetail(PSSubSysSADetail parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSubSysSADetailParam get(PSSubSysSADetail parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSubSysSADetailParam> list = this.listByPSSubSysSADetail(parent);
        if (list != null) {
            for (PSSubSysSADetailParam item : list) {
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
    public List<PSSubSysSADetailParamDTO> listDTOByPSSubSysSADetail(String strParentKey) throws Exception {
        PSSubSysSADetail pssubsyssadetail = (PSSubSysSADetail)PSModelServiceUtil.getInstance().getPSSubSysSADetailService().get(strParentKey);
        List<PSSubSysSADetailParam> list = this.listByPSSubSysSADetail(pssubsyssadetail);
        if (list != null) {
            ArrayList<PSSubSysSADetailParamDTO> dtoList = new ArrayList<PSSubSysSADetailParamDTO>();
            for (PSSubSysSADetailParam item : list) {
                PSSubSysSADetailParamDTO dto = (PSSubSysSADetailParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSubSysSADetailParam> onListAll() throws Exception {
        ArrayList<PSSubSysSADetailParam> list = new ArrayList<PSSubSysSADetailParam>();
        List pssubsyssadetails = PSModelServiceUtil.getInstance().getPSSubSysSADetailService().listAll();
        if (pssubsyssadetails != null) {
            for (PSSubSysSADetail parent : pssubsyssadetails) {
                List<PSSubSysSADetailParam> items = this.listByPSSubSysSADetail(parent);
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
    protected PSSubSysSADetailParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSSubSysSADetailParam item;
        PSSubSysSADetail pssubsyssadetail = (PSSubSysSADetail)PSModelServiceUtil.getInstance().getPSSubSysSADetailService().get(strParentKey, true);
        if (pssubsyssadetail != null && (item = this.get(pssubsyssadetail, strCurKey, true)) != null) {
            return item;
        }
        return (PSSubSysSADetailParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSubSysSADetailParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSubSysSADetailId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSubSysSADetailService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSubSysSADetailParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSubSysSADetailParamName())) {
            return et.getPSSubSysSADetailParamName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSubSysSADetailParamDTO dto, PSSubSysSADetailParam t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSubSysSADetailParamId(t.getId().replace("/", "."));
        }
        if (t.getArrayFlag() != null || !bIgnoreNull) {
            dto.setArrayFlag(t.getArrayFlag());
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamTag() != null || !bIgnoreNull) {
            dto.setParamTag(t.getParamTag());
        }
        if (t.getParamTag2() != null || !bIgnoreNull) {
            dto.setParamTag2(t.getParamTag2());
        }
        if (t.getPSSubSysSADetailId() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailId(t.getPSSubSysSADetailId());
        }
        if (t.getPSSubSysSADetailName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailName(t.getPSSubSysSADetailName());
        }
        if (t.getPSSubSysSADetailParamName() != null || !bIgnoreNull) {
            dto.setPSSubSysSADetailParamName(t.getPSSubSysSADetailParamName());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
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
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            dto.setPSSubSysSADetailId(this.getRealPSModelId(t, dto.getPSSubSysSADetailId()).replace("/", "."));
        }
        if ("PSSUBSYSSADETAIL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSubSysSADetailId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysSADetailId())) {
            PSSubSysSADetailDTO linkDTO = (PSSubSysSADetailDTO)PSModelServiceUtil.getInstance().getPSSubSysSADetailService().getDTO(dto.getPSSubSysSADetailId());
            dto.setPSSubSysSADetailName(linkDTO.getPSSubSysSADetailName());
        } else {
            dto.setPSSubSysSADetailName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSUBSYSSADETAILPARAM";
    }

    @Override
    public PSSubSysSADetailParam createDomain() {
        return new PSSubSysSADetailParam();
    }

    @Override
    public PSSubSysSADetailParamDTO createDTO() {
        return new PSSubSysSADetailParamDTO();
    }
}

