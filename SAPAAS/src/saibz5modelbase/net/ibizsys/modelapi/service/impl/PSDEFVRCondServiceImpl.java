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
import net.ibizsys.modelapi.domain.PSDEFVRCond;
import net.ibizsys.modelapi.domain.PSDEFValueRule;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.dto.PSDEFVRCondDTO;
import net.ibizsys.modelapi.dto.PSDEFValueRuleDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysValueRuleDTO;
import net.ibizsys.modelapi.service.IPSDEFVRCondService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFVRCondServiceImpl
extends PSModelServiceImplBase<PSDEFVRCond, PSDEFVRCondDTO>
implements IPSDEFVRCondService {
    private static final Log log = LogFactory.getLog(PSDEFVRCondServiceImpl.class);

    @Override
    public List<PSDEFVRCond> listByPSDEFVRCond(PSDEFVRCond parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFVRCond get(PSDEFVRCond parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFVRCond> list = this.listByPSDEFVRCond(parent);
        if (list != null) {
            for (PSDEFVRCond item : list) {
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
    public List<PSDEFVRCondDTO> listDTOByPSDEFVRCond(String strParentKey) throws Exception {
        PSDEFVRCond psdefvrcond = (PSDEFVRCond)PSModelServiceUtil.getInstance().getPSDEFVRCondService().get(strParentKey);
        List<PSDEFVRCond> list = this.listByPSDEFVRCond(psdefvrcond);
        if (list != null) {
            ArrayList<PSDEFVRCondDTO> dtoList = new ArrayList<PSDEFVRCondDTO>();
            for (PSDEFVRCond item : list) {
                PSDEFVRCondDTO dto = (PSDEFVRCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSDEFVRCond> listByPSDEFValueRule(PSDEFValueRule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFVRCond get(PSDEFValueRule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFVRCond> list = this.listByPSDEFValueRule(parent);
        if (list != null) {
            for (PSDEFVRCond item : list) {
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
    public List<PSDEFVRCondDTO> listDTOByPSDEFValueRule(String strParentKey) throws Exception {
        PSDEFValueRule psdefvaluerule = (PSDEFValueRule)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().get(strParentKey);
        List<PSDEFVRCond> list = this.listByPSDEFValueRule(psdefvaluerule);
        if (list != null) {
            ArrayList<PSDEFVRCondDTO> dtoList = new ArrayList<PSDEFVRCondDTO>();
            for (PSDEFVRCond item : list) {
                PSDEFVRCondDTO dto = (PSDEFVRCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFVRCond> onListAll() throws Exception {
        ArrayList<PSDEFVRCond> list = new ArrayList<PSDEFVRCond>();
        List<PSDEFValueRule> psdefvaluerules = PSModelServiceUtil.getInstance().getPSDEFValueRuleService().listAll();
        if (psdefvaluerules != null) {
            for (PSDEFValueRule parent : psdefvaluerules) {
                List<PSDEFVRCond> items = this.listByPSDEFValueRule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSDEFVRCond> alllist = new ArrayList<PSDEFVRCond>();
        alllist.addAll(list);
        for (PSDEFVRCond item : list) {
            List<PSDEFVRCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFVRCond> listAllChild(PSDEFVRCond parent) throws Exception {
        List<PSDEFVRCond> list = this.listByPSDEFVRCond(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFVRCond> alllist = new ArrayList<PSDEFVRCond>();
        alllist.addAll(list);
        for (PSDEFVRCond item : list) {
            List<PSDEFVRCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFVRCond> listAllByPSDEFValueRule(PSDEFValueRule parent) throws Exception {
        List<PSDEFVRCond> list = this.listByPSDEFValueRule(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSDEFVRCond> alllist = new ArrayList<PSDEFVRCond>();
        alllist.addAll(list);
        for (PSDEFVRCond item : list) {
            List<PSDEFVRCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSDEFVRCondDTO> listAllDTOByPSDEFValueRule(String strParentKey) throws Exception {
        PSDEFValueRule psdefvaluerule = (PSDEFValueRule)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().get(strParentKey);
        List<PSDEFVRCond> list = this.listAllByPSDEFValueRule(psdefvaluerule);
        if (list != null) {
            ArrayList<PSDEFVRCondDTO> dtoList = new ArrayList<PSDEFVRCondDTO>();
            for (PSDEFVRCond item : list) {
                PSDEFVRCondDTO dto = (PSDEFVRCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSDEFVRCond onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFVRCond item;
        PSDEFVRCond item2;
        PSDEFVRCond psdefvrcond = (PSDEFVRCond)PSModelServiceUtil.getInstance().getPSDEFVRCondService().get(strParentKey, true);
        if (psdefvrcond != null && (item2 = this.get(psdefvrcond, strCurKey, true)) != null) {
            return item2;
        }
        PSDEFValueRule psdefvaluerule = (PSDEFValueRule)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().get(strParentKey, true);
        if (psdefvaluerule != null && (item = this.get(psdefvaluerule, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFVRCond)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFVRCondDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSDEFVRCondId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFVRCondService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSDEFVRId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFValueRuleService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFVRCond et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFVRCondDTO dto, PSDEFVRCond t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFVRCondId(t.getId().replace("/", "."));
        }
        if (t.getCondTag() != null || !bIgnoreNull) {
            dto.setCondTag(t.getCondTag());
        }
        if (t.getCondTag2() != null || !bIgnoreNull) {
            dto.setCondTag2(t.getCondTag2());
        }
        if (t.getCondType() != null || !bIgnoreNull) {
            dto.setCondType(t.getCondType());
        }
        if (t.getCondValue() != null || !bIgnoreNull) {
            dto.setCondValue(t.getCondValue());
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getExtMajorPSDEFId() != null || !bIgnoreNull) {
            dto.setExtMajorPSDEFId(t.getExtMajorPSDEFId());
        }
        if (t.getExtMajorPSDEFName() != null || !bIgnoreNull) {
            dto.setExtMajorPSDEFName(t.getExtMajorPSDEFName());
        }
        if (t.getExtMinorPSDEFId() != null || !bIgnoreNull) {
            dto.setExtMinorPSDEFId(t.getExtMinorPSDEFId());
        }
        if (t.getExtMinorPSDEFName() != null || !bIgnoreNull) {
            dto.setExtMinorPSDEFName(t.getExtMinorPSDEFName());
        }
        if (t.getGroupNotFlag() != null || !bIgnoreNull) {
            dto.setGroupNotFlag(t.getGroupNotFlag());
        }
        if (t.getGroupOP() != null || !bIgnoreNull) {
            dto.setGroupOP(t.getGroupOP());
        }
        if (t.getKeyCondFlag() != null || !bIgnoreNull) {
            dto.setKeyCondFlag(t.getKeyCondFlag());
        }
        if (t.getMajorPSDEDSId() != null || !bIgnoreNull) {
            dto.setMajorPSDEDSId(t.getMajorPSDEDSId());
        }
        if (t.getMajorPSDEDSName() != null || !bIgnoreNull) {
            dto.setMajorPSDEDSName(t.getMajorPSDEDSName());
        }
        if (t.getMajorPSDEId() != null || !bIgnoreNull) {
            dto.setMajorPSDEId(t.getMajorPSDEId());
        }
        if (t.getMajorPSDEName() != null || !bIgnoreNull) {
            dto.setMajorPSDEName(t.getMajorPSDEName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParam() != null || !bIgnoreNull) {
            dto.setParam(t.getParam());
        }
        if (t.getParam10() != null || !bIgnoreNull) {
            dto.setParam10(t.getParam10());
        }
        if (t.getParam2() != null || !bIgnoreNull) {
            dto.setParam2(t.getParam2());
        }
        if (t.getParam3() != null || !bIgnoreNull) {
            dto.setParam3(t.getParam3());
        }
        if (t.getParam4() != null || !bIgnoreNull) {
            dto.setParam4(t.getParam4());
        }
        if (t.getParam5() != null || !bIgnoreNull) {
            dto.setParam5(t.getParam5());
        }
        if (t.getParam6() != null || !bIgnoreNull) {
            dto.setParam6(t.getParam6());
        }
        if (t.getParam7() != null || !bIgnoreNull) {
            dto.setParam7(t.getParam7());
        }
        if (t.getParam8() != null || !bIgnoreNull) {
            dto.setParam8(t.getParam8());
        }
        if (t.getParam9() != null || !bIgnoreNull) {
            dto.setParam9(t.getParam9());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getPPSDEFVRCondId() != null || !bIgnoreNull) {
            dto.setPPSDEFVRCondId(t.getPPSDEFVRCondId());
        }
        if (t.getPPSDEFVRCondName() != null || !bIgnoreNull) {
            dto.setPPSDEFVRCondName(t.getPPSDEFVRCondName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEFId() != null || !bIgnoreNull) {
            dto.setPSDEFId(t.getPSDEFId());
        }
        if (t.getPSDEFName() != null || !bIgnoreNull) {
            dto.setPSDEFName(t.getPSDEFName());
        }
        if (t.getPSDEFVRCondName() != null || !bIgnoreNull) {
            dto.setPSDEFVRCondName(t.getPSDEFVRCondName());
        }
        if (t.getPSDEFVRId() != null || !bIgnoreNull) {
            dto.setPSDEFVRId(t.getPSDEFVRId());
        }
        if (t.getPSDEFVRName() != null || !bIgnoreNull) {
            dto.setPSDEFVRName(t.getPSDEFVRName());
        }
        if (t.getPSSysValueRuleId() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleId(t.getPSSysValueRuleId());
        }
        if (t.getPSSysValueRuleName() != null || !bIgnoreNull) {
            dto.setPSSysValueRuleName(t.getPSSysValueRuleName());
        }
        if (t.getRIPSLanResId() != null || !bIgnoreNull) {
            dto.setRIPSLanResId(t.getRIPSLanResId());
        }
        if (t.getRIPSLanResName() != null || !bIgnoreNull) {
            dto.setRIPSLanResName(t.getRIPSLanResName());
        }
        if (t.getRuleInfo() != null || !bIgnoreNull) {
            dto.setRuleInfo(t.getRuleInfo());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (StringUtils.hasLength((String)dto.getExtMajorPSDEFId())) {
            dto.setExtMajorPSDEFId(this.getRealPSModelId(t, dto.getExtMajorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getExtMinorPSDEFId())) {
            dto.setExtMinorPSDEFId(this.getRealPSModelId(t, dto.getExtMinorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEDSId())) {
            dto.setMajorPSDEDSId(this.getRealPSModelId(t, dto.getMajorPSDEDSId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEId())) {
            dto.setMajorPSDEId(this.getRealPSModelId(t, dto.getMajorPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFVRCondId())) {
            dto.setPPSDEFVRCondId(this.getRealPSModelId(t, dto.getPPSDEFVRCondId()).replace("/", "."));
        }
        if ("PSDEFVRCOND".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSDEFVRCondId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            dto.setPSDEFVRId(this.getRealPSModelId(t, dto.getPSDEFVRId()).replace("/", "."));
        }
        if ("PSDEFVALUERULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFVRId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            dto.setPSSysValueRuleId(this.getRealPSModelId(t, dto.getPSSysValueRuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRIPSLanResId())) {
            dto.setRIPSLanResId(this.getRealPSModelId(t, dto.getRIPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getExtMajorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getExtMajorPSDEFId());
            dto.setExtMajorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setExtMajorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getExtMinorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getExtMinorPSDEFId());
            dto.setExtMinorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setExtMinorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEDSId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getMajorPSDEDSId());
            dto.setMajorPSDEDSName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setMajorPSDEDSName(null);
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getMajorPSDEId());
            dto.setMajorPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setMajorPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSDEFVRCondId())) {
            linkDTO = (PSDEFVRCondDTO)PSModelServiceUtil.getInstance().getPSDEFVRCondService().getDTO(dto.getPPSDEFVRCondId());
            dto.setPPSDEFVRCondName(((PSDEFVRCondDTO)linkDTO).getPSDEFVRCondName());
        } else {
            dto.setPPSDEFVRCondName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEFVRId())) {
            linkDTO = (PSDEFValueRuleDTO)PSModelServiceUtil.getInstance().getPSDEFValueRuleService().getDTO(dto.getPSDEFVRId());
            dto.setPSDEFVRName(((PSDEFValueRuleDTO)linkDTO).getPSDEFValueRuleName());
        } else {
            dto.setPSDEFVRName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysValueRuleId())) {
            linkDTO = (PSSysValueRuleDTO)PSModelServiceUtil.getInstance().getPSSysValueRuleService().getDTO(dto.getPSSysValueRuleId());
            dto.setPSSysValueRuleName(((PSSysValueRuleDTO)linkDTO).getPSSysValueRuleName());
        } else {
            dto.setPSSysValueRuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getRIPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getRIPSLanResId());
            dto.setRIPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setRIPSLanResName(null);
        }
        List<PSDEFVRCond> list = PSModelServiceUtil.getInstance().getPSDEFVRCondService().listByPSDEFVRCond(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEFVRCondDTO> psdefvrconds = new ArrayList<PSDEFVRCondDTO>();
            for (PSDEFVRCond item : list) {
                PSDEFVRCondDTO dstItem = (PSDEFVRCondDTO)PSModelServiceUtil.getInstance().getPSDEFVRCondService().toDTO(item);
                psdefvrconds.add(dstItem);
            }
            dto.setPsdefvrconds(psdefvrconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFVRCOND";
    }

    @Override
    public PSDEFVRCond createDomain() {
        return new PSDEFVRCond();
    }

    @Override
    public PSDEFVRCondDTO createDTO() {
        return new PSDEFVRCondDTO();
    }
}

