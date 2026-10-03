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
import net.ibizsys.modelapi.domain.PSSysSearchDoc;
import net.ibizsys.modelapi.domain.PSSysSearchField;
import net.ibizsys.modelapi.dto.PSSysSearchDocDTO;
import net.ibizsys.modelapi.dto.PSSysSearchFieldDTO;
import net.ibizsys.modelapi.service.IPSSysSearchFieldService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchFieldServiceImpl
extends PSModelServiceImplBase<PSSysSearchField, PSSysSearchFieldDTO>
implements IPSSysSearchFieldService {
    private static final Log log = LogFactory.getLog(PSSysSearchFieldServiceImpl.class);

    @Override
    public List<PSSysSearchField> listByPSSysSearchDoc(PSSysSearchDoc parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchField get(PSSysSearchDoc parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchField> list = this.listByPSSysSearchDoc(parent);
        if (list != null) {
            for (PSSysSearchField item : list) {
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
    public List<PSSysSearchFieldDTO> listDTOByPSSysSearchDoc(String strParentKey) throws Exception {
        PSSysSearchDoc pssyssearchdoc = (PSSysSearchDoc)PSModelServiceUtil.getInstance().getPSSysSearchDocService().get(strParentKey);
        List<PSSysSearchField> list = this.listByPSSysSearchDoc(pssyssearchdoc);
        if (list != null) {
            ArrayList<PSSysSearchFieldDTO> dtoList = new ArrayList<PSSysSearchFieldDTO>();
            for (PSSysSearchField item : list) {
                PSSysSearchFieldDTO dto = (PSSysSearchFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchField> onListAll() throws Exception {
        ArrayList<PSSysSearchField> list = new ArrayList<PSSysSearchField>();
        List<PSSysSearchDoc> pssyssearchdocs = PSModelServiceUtil.getInstance().getPSSysSearchDocService().listAll();
        if (pssyssearchdocs != null) {
            for (PSSysSearchDoc parent : pssyssearchdocs) {
                List<PSSysSearchField> items = this.listByPSSysSearchDoc(parent);
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
    protected PSSysSearchField onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchField item;
        PSSysSearchDoc pssyssearchdoc = (PSSysSearchDoc)PSModelServiceUtil.getInstance().getPSSysSearchDocService().get(strParentKey, true);
        if (pssyssearchdoc != null && (item = this.get(pssyssearchdoc, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchField)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchFieldDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSearchDocId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSearchDocService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchField et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysSearchFieldName())) {
            return et.getPSSysSearchFieldName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchFieldDTO dto, PSSysSearchField t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchFieldId(t.getId().replace("/", "."));
        }
        if (t.getAnalyzer() != null || !bIgnoreNull) {
            dto.setAnalyzer(t.getAnalyzer());
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
        if (t.getDateFormat() != null || !bIgnoreNull) {
            dto.setDateFormat(t.getDateFormat());
        }
        if (t.getFieldDataFlag() != null || !bIgnoreNull) {
            dto.setFieldDataFlag(t.getFieldDataFlag());
        }
        if (t.getFieldTag() != null || !bIgnoreNull) {
            dto.setFieldTag(t.getFieldTag());
        }
        if (t.getFieldTag2() != null || !bIgnoreNull) {
            dto.setFieldTag2(t.getFieldTag2());
        }
        if (t.getFieldType() != null || !bIgnoreNull) {
            dto.setFieldType(t.getFieldType());
        }
        if (t.getIgnoreFields() != null || !bIgnoreNull) {
            dto.setIgnoreFields(t.getIgnoreFields());
        }
        if (t.getIncInParentFlag() != null || !bIgnoreNull) {
            dto.setIncInParentFlag(t.getIncInParentFlag());
        }
        if (t.getIndexFlag() != null || !bIgnoreNull) {
            dto.setIndexFlag(t.getIndexFlag());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPattern() != null || !bIgnoreNull) {
            dto.setPattern(t.getPattern());
        }
        if (t.getPKey() != null || !bIgnoreNull) {
            dto.setPKey(t.getPKey());
        }
        if (t.getPSSysSearchDocId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocId(t.getPSSysSearchDocId());
        }
        if (t.getPSSysSearchDocName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocName(t.getPSSysSearchDocName());
        }
        if (t.getPSSysSearchFieldName() != null || !bIgnoreNull) {
            dto.setPSSysSearchFieldName(t.getPSSysSearchFieldName());
        }
        if (t.getSearchAnalyzer() != null || !bIgnoreNull) {
            dto.setSearchAnalyzer(t.getSearchAnalyzer());
        }
        if (t.getStdDataType() != null || !bIgnoreNull) {
            dto.setStdDataType(t.getStdDataType());
        }
        if (t.getStoreFlag() != null || !bIgnoreNull) {
            dto.setStoreFlag(t.getStoreFlag());
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
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            dto.setPSSysSearchDocId(this.getRealPSModelId(t, dto.getPSSysSearchDocId()).replace("/", "."));
        }
        if ("PSSYSSEARCHDOC".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSearchDocId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDocId())) {
            PSSysSearchDocDTO linkDTO = (PSSysSearchDocDTO)PSModelServiceUtil.getInstance().getPSSysSearchDocService().getDTO(dto.getPSSysSearchDocId());
            dto.setPSSysSearchDocName(linkDTO.getPSSysSearchDocName());
        } else {
            dto.setPSSysSearchDocName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSEARCHFIELD";
    }

    @Override
    public PSSysSearchField createDomain() {
        return new PSSysSearchField();
    }

    @Override
    public PSSysSearchFieldDTO createDTO() {
        return new PSSysSearchFieldDTO();
    }
}

