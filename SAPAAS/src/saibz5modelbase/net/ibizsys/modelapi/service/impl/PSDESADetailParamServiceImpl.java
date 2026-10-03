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
import net.ibizsys.modelapi.domain.PSDESADetail;
import net.ibizsys.modelapi.domain.PSDESADetailParam;
import net.ibizsys.modelapi.dto.PSDESADetailDTO;
import net.ibizsys.modelapi.dto.PSDESADetailParamDTO;
import net.ibizsys.modelapi.service.IPSDESADetailParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDESADetailParamServiceImpl
extends PSModelServiceImplBase<PSDESADetailParam, PSDESADetailParamDTO>
implements IPSDESADetailParamService {
    private static final Log log = LogFactory.getLog(PSDESADetailParamServiceImpl.class);

    @Override
    public List<PSDESADetailParam> listByPSDESADetail(PSDESADetail parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDESADetailParam get(PSDESADetail parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDESADetailParam> list = this.listByPSDESADetail(parent);
        if (list != null) {
            for (PSDESADetailParam item : list) {
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
    public List<PSDESADetailParamDTO> listDTOByPSDESADetail(String strParentKey) throws Exception {
        PSDESADetail psdesadetail = (PSDESADetail)PSModelServiceUtil.getInstance().getPSDESADetailService().get(strParentKey);
        List<PSDESADetailParam> list = this.listByPSDESADetail(psdesadetail);
        if (list != null) {
            ArrayList<PSDESADetailParamDTO> dtoList = new ArrayList<PSDESADetailParamDTO>();
            for (PSDESADetailParam item : list) {
                PSDESADetailParamDTO dto = (PSDESADetailParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDESADetailParam> onListAll() throws Exception {
        ArrayList<PSDESADetailParam> list = new ArrayList<PSDESADetailParam>();
        List<PSDESADetail> psdesadetails = PSModelServiceUtil.getInstance().getPSDESADetailService().listAll();
        if (psdesadetails != null) {
            for (PSDESADetail parent : psdesadetails) {
                List<PSDESADetailParam> items = this.listByPSDESADetail(parent);
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
    protected PSDESADetailParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDESADetailParam item;
        PSDESADetail psdesadetail = (PSDESADetail)PSModelServiceUtil.getInstance().getPSDESADetailService().get(strParentKey, true);
        if (psdesadetail != null && (item = this.get(psdesadetail, strCurKey, true)) != null) {
            return item;
        }
        return (PSDESADetailParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDESADetailParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDESADetailId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDESADetailService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDESADetailParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSDESADetailParamName())) {
            return et.getPSDESADetailParamName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDESADetailParamDTO dto, PSDESADetailParam t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDESADetailParamId(t.getId().replace("/", "."));
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
        if (t.getPSDESADetailId() != null || !bIgnoreNull) {
            dto.setPSDESADetailId(t.getPSDESADetailId());
        }
        if (t.getPSDESADetailName() != null || !bIgnoreNull) {
            dto.setPSDESADetailName(t.getPSDESADetailName());
        }
        if (t.getPSDESADetailParamName() != null || !bIgnoreNull) {
            dto.setPSDESADetailParamName(t.getPSDESADetailParamName());
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
        if (StringUtils.hasLength((String)dto.getPSDESADetailId())) {
            dto.setPSDESADetailId(this.getRealPSModelId(t, dto.getPSDESADetailId()).replace("/", "."));
        }
        if ("PSDESADETAIL".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDESADetailId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDESADetailId())) {
            PSDESADetailDTO linkDTO = (PSDESADetailDTO)PSModelServiceUtil.getInstance().getPSDESADetailService().getDTO(dto.getPSDESADetailId());
            dto.setPSDESADetailName(linkDTO.getPSDESADetailName());
        } else {
            dto.setPSDESADetailName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDESADETAILPARAM";
    }

    @Override
    public PSDESADetailParam createDomain() {
        return new PSDESADetailParam();
    }

    @Override
    public PSDESADetailParamDTO createDTO() {
        return new PSDESADetailParamDTO();
    }
}

