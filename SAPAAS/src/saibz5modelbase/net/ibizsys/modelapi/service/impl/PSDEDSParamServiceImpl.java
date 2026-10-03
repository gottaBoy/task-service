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
import net.ibizsys.modelapi.domain.PSDEDSParam;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSParamDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFSFItemDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEDSParamService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDSParamServiceImpl
extends PSModelServiceImplBase<PSDEDSParam, PSDEDSParamDTO>
implements IPSDEDSParamService {
    private static final Log log = LogFactory.getLog(PSDEDSParamServiceImpl.class);

    @Override
    public List<PSDEDSParam> listByPSDEDataSet(PSDEDataSet parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDSParam get(PSDEDataSet parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDSParam> list = this.listByPSDEDataSet(parent);
        if (list != null) {
            for (PSDEDSParam item : list) {
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
    public List<PSDEDSParamDTO> listDTOByPSDEDataSet(String strParentKey) throws Exception {
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey);
        List<PSDEDSParam> list = this.listByPSDEDataSet(psdedataset);
        if (list != null) {
            ArrayList<PSDEDSParamDTO> dtoList = new ArrayList<PSDEDSParamDTO>();
            for (PSDEDSParam item : list) {
                PSDEDSParamDTO dto = (PSDEDSParamDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDSParam> onListAll() throws Exception {
        ArrayList<PSDEDSParam> list = new ArrayList<PSDEDSParam>();
        List<PSDEDataSet> psdedatasets = PSModelServiceUtil.getInstance().getPSDEDataSetService().listAll();
        if (psdedatasets != null) {
            for (PSDEDataSet parent : psdedatasets) {
                List<PSDEDSParam> items = this.listByPSDEDataSet(parent);
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
    protected PSDEDSParam onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDSParam item;
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey, true);
        if (psdedataset != null && (item = this.get(psdedataset, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDSParam)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDSParamDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDSId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDSParam et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDSParamName())) {
            return et.getPSDEDSParamName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDSParamDTO dto, PSDEDSParam t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDSParamId(t.getId().replace("/", "."));
        }
        if (t.getAllowEmpty() != null || !bIgnoreNull) {
            dto.setAllowEmpty(t.getAllowEmpty());
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
        if (t.getJsonFormat() != null || !bIgnoreNull) {
            dto.setJsonFormat(t.getJsonFormat());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamDesc() != null || !bIgnoreNull) {
            dto.setParamDesc(t.getParamDesc());
        }
        if (t.getParamTag() != null || !bIgnoreNull) {
            dto.setParamTag(t.getParamTag());
        }
        if (t.getParamTag2() != null || !bIgnoreNull) {
            dto.setParamTag2(t.getParamTag2());
        }
        if (t.getPSDEDSId() != null || !bIgnoreNull) {
            dto.setPSDEDSId(t.getPSDEDSId());
        }
        if (t.getPSDEDSName() != null || !bIgnoreNull) {
            dto.setPSDEDSName(t.getPSDEDSName());
        }
        if (t.getPSDEDSParamName() != null || !bIgnoreNull) {
            dto.setPSDEDSParamName(t.getPSDEDSParamName());
        }
        if (t.getPSDEFSFItemId() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemId(t.getPSDEFSFItemId());
        }
        if (t.getPSDEFSFItemName() != null || !bIgnoreNull) {
            dto.setPSDEFSFItemName(t.getPSDEFSFItemName());
        }
        if (t.getPSDEFValueRuleId() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleId(t.getPSDEFValueRuleId());
        }
        if (t.getPSDEFValueRuleName() != null || !bIgnoreNull) {
            dto.setPSDEFValueRuleName(t.getPSDEFValueRuleName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
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
        if (t.getValue() != null || !bIgnoreNull) {
            dto.setValue(t.getValue());
        }
        if (t.getValueDesc() != null || !bIgnoreNull) {
            dto.setValueDesc(t.getValueDesc());
        }
        if (t.getValueType() != null || !bIgnoreNull) {
            dto.setValueType(t.getValueType());
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            dto.setPSDEDSId(this.getRealPSModelId(t, dto.getPSDEDSId()).replace("/", "."));
        }
        if ("PSDEDATASET".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDSId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            dto.setPSDEFSFItemId(this.getRealPSModelId(t, dto.getPSDEFSFItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            dto.setPSDEFValueRuleId(this.getRealPSModelId(t, dto.getPSDEFValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDSId());
            dto.setPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
            dto.setPSDEId(((PSDEDataSetDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEDSName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFSFItemId())) {
            linkDTO = (PSDEFSFItemDTO)PSModelServiceUtil.getInstance().getPSDEFSFItemService().getDTO(dto.getPSDEFSFItemId());
            dto.setPSDEFSFItemName(((PSDEFSFItemDTO)linkDTO).getPSDEFSFItemName());
        } else {
            dto.setPSDEFSFItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFValueRuleId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFValueRuleId());
            dto.setPSDEFValueRuleName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDSPARAM";
    }

    @Override
    public PSDEDSParam createDomain() {
        return new PSDEDSParam();
    }

    @Override
    public PSDEDSParamDTO createDTO() {
        return new PSDEDSParamDTO();
    }
}

