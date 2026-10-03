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
import net.ibizsys.modelapi.domain.PSDEDSGrpParam;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSGrpParamDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.service.IPSDEDSGrpParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDSGrpParamServiceImpl
extends PSModelServiceImplBase<PSDEDSGrpParam, PSDEDSGrpParamDTO>
implements IPSDEDSGrpParamService {
    private static final Log log = LogFactory.getLog(PSDEDSGrpParamServiceImpl.class);

    @Override
    public List<PSDEDSGrpParam> listByPSDEDataSet(PSDEDataSet parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDSGrpParam get(PSDEDataSet parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDSGrpParam> list = this.listByPSDEDataSet(parent);
        if (list != null) {
            for (PSDEDSGrpParam item : list) {
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
    public List<PSDEDSGrpParamDTO> listDTOByPSDEDataSet(String strParentKey) throws Exception {
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey);
        List<PSDEDSGrpParam> list = this.listByPSDEDataSet(psdedataset);
        if (list != null) {
            ArrayList<PSDEDSGrpParamDTO> dtoList = new ArrayList<PSDEDSGrpParamDTO>();
            for (PSDEDSGrpParam item : list) {
                PSDEDSGrpParamDTO dto = (PSDEDSGrpParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDSGrpParam> onListAll() throws Exception {
        ArrayList<PSDEDSGrpParam> list = new ArrayList<PSDEDSGrpParam>();
        List<PSDEDataSet> psdedatasets = PSModelServiceUtil.getInstance().getPSDEDataSetService().listAll();
        if (psdedatasets != null) {
            for (PSDEDataSet parent : psdedatasets) {
                List<PSDEDSGrpParam> items = this.listByPSDEDataSet(parent);
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
    protected PSDEDSGrpParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDSGrpParam item;
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey, true);
        if (psdedataset != null && (item = this.get(psdedataset, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDSGrpParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDSGrpParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDSId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDSGrpParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDSGrpParamName())) {
            return et.getPSDEDSGrpParamName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDSGrpParamDTO dto, PSDEDSGrpParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDSGrpParamId(t.getId().replace("/", "."));
        }
        if (t.getAggMode() != null || !bIgnoreNull) {
            dto.setAggMode(t.getAggMode());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDEFName() != null || !bIgnoreNull) {
            dto.setCustomDEFName(t.getCustomDEFName());
        }
        if (t.getGroupCode() != null || !bIgnoreNull) {
            dto.setGroupCode(t.getGroupCode());
        }
        if (t.getGroupFlag() != null || !bIgnoreNull) {
            dto.setGroupFlag(t.getGroupFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderDir() != null || !bIgnoreNull) {
            dto.setOrderDir(t.getOrderDir());
        }
        if (t.getPSDEDSGrpParamName() != null || !bIgnoreNull) {
            dto.setPSDEDSGrpParamName(t.getPSDEDSGrpParamName());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getSortOrderValue() != null || !bIgnoreNull) {
            dto.setSortOrderValue(t.getSortOrderValue());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
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
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if ("PSDEDATASET".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDSId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
            dto.setPSDEId(((PSDEDataSetDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEDSName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDSGRPPARAM";
    }

    @Override
    public PSDEDSGrpParam createDomain() {
        return new PSDEDSGrpParam();
    }

    @Override
    public PSDEDSGrpParamDTO createDTO() {
        return new PSDEDSGrpParamDTO();
    }
}

