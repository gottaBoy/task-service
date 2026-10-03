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
import net.ibizsys.modelapi.domain.PSSysSearchDE;
import net.ibizsys.modelapi.domain.PSSysSearchDEField;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDEDTO;
import net.ibizsys.modelapi.dto.PSSysSearchDEFieldDTO;
import net.ibizsys.modelapi.dto.PSSysSearchFieldDTO;
import net.ibizsys.modelapi.service.IPSSysSearchDEFieldService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSearchDEFieldServiceImpl
extends PSModelServiceImplBase<PSSysSearchDEField, PSSysSearchDEFieldDTO>
implements IPSSysSearchDEFieldService {
    private static final Log log = LogFactory.getLog(PSSysSearchDEFieldServiceImpl.class);

    @Override
    public List<PSSysSearchDEField> listByPSSysSearchDE(PSSysSearchDE parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSearchDEField get(PSSysSearchDE parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSearchDEField> list = this.listByPSSysSearchDE(parent);
        if (list != null) {
            for (PSSysSearchDEField item : list) {
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
    public List<PSSysSearchDEFieldDTO> listDTOByPSSysSearchDE(String strParentKey) throws Exception {
        PSSysSearchDE pssyssearchde = (PSSysSearchDE)PSModelServiceUtil.getInstance().getPSSysSearchDEService().get(strParentKey);
        List<PSSysSearchDEField> list = this.listByPSSysSearchDE(pssyssearchde);
        if (list != null) {
            ArrayList<PSSysSearchDEFieldDTO> dtoList = new ArrayList<PSSysSearchDEFieldDTO>();
            for (PSSysSearchDEField item : list) {
                PSSysSearchDEFieldDTO dto = (PSSysSearchDEFieldDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSearchDEField> onListAll() throws Exception {
        ArrayList<PSSysSearchDEField> list = new ArrayList<PSSysSearchDEField>();
        List<PSSysSearchDE> pssyssearchdes = PSModelServiceUtil.getInstance().getPSSysSearchDEService().listAll();
        if (pssyssearchdes != null) {
            for (PSSysSearchDE parent : pssyssearchdes) {
                List<PSSysSearchDEField> items = this.listByPSSysSearchDE(parent);
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
    protected PSSysSearchDEField onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSearchDEField item;
        PSSysSearchDE pssyssearchde = (PSSysSearchDE)PSModelServiceUtil.getInstance().getPSSysSearchDEService().get(strParentKey, true);
        if (pssyssearchde != null && (item = this.get(pssyssearchde, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSearchDEField)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSearchDEFieldDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSearchDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSearchDEService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSearchDEField et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysSearchDEFieldName())) {
            return et.getPSSysSearchDEFieldName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSearchDEFieldDTO dto, PSSysSearchDEField t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSearchDEFieldId(t.getId().replace("/", "."));
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
        if (t.getFieldTag() != null || !bIgnoreNull) {
            dto.setFieldTag(t.getFieldTag());
        }
        if (t.getFieldTag2() != null || !bIgnoreNull) {
            dto.setFieldTag2(t.getFieldTag2());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
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
        if (t.getPSSysSearchDEFieldName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDEFieldName(t.getPSSysSearchDEFieldName());
        }
        if (t.getPSSysSearchDEId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDEId(t.getPSSysSearchDEId());
        }
        if (t.getPSSysSearchDEName() != null || !bIgnoreNull) {
            dto.setPSSysSearchDEName(t.getPSSysSearchDEName());
        }
        if (t.getPSSysSearchDocId() != null || !bIgnoreNull) {
            dto.setPSSysSearchDocId(t.getPSSysSearchDocId());
        }
        if (t.getPSSysSearchFieldId() != null || !bIgnoreNull) {
            dto.setPSSysSearchFieldId(t.getPSSysSearchFieldId());
        }
        if (t.getPSSysSearchFieldName() != null || !bIgnoreNull) {
            dto.setPSSysSearchFieldName(t.getPSSysSearchFieldName());
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
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            dto.setPSDEFId(this.getRealPSModelId(t, dto.getPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDEId())) {
            dto.setPSSysSearchDEId(this.getRealPSModelId(t, dto.getPSSysSearchDEId()).replace("/", "."));
        }
        if ("PSSYSSEARCHDE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSearchDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchFieldId())) {
            dto.setPSSysSearchFieldId(this.getRealPSModelId(t, dto.getPSSysSearchFieldId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getPSDEFId());
            dto.setPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
            dto.setPSDEId(((PSDEFieldDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEFName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchDEId())) {
            linkDTO = (PSSysSearchDEDTO)PSModelServiceUtil.getInstance().getPSSysSearchDEService().getDTO(dto.getPSSysSearchDEId());
            dto.setPSSysSearchDEName(((PSSysSearchDEDTO)linkDTO).getPSSysSearchDEName());
            dto.setPSSysSearchDocId(((PSSysSearchDEDTO)linkDTO).getPSSysSearchDocId());
        } else {
            dto.setPSSysSearchDEName(null);
            dto.setPSSysSearchDocId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSearchFieldId())) {
            linkDTO = (PSSysSearchFieldDTO)PSModelServiceUtil.getInstance().getPSSysSearchFieldService().getDTO(dto.getPSSysSearchFieldId());
            dto.setPSSysSearchFieldName(((PSSysSearchFieldDTO)linkDTO).getPSSysSearchFieldName());
        } else {
            dto.setPSSysSearchFieldName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSEARCHDEFIELD";
    }

    @Override
    public PSSysSearchDEField createDomain() {
        return new PSSysSearchDEField();
    }

    @Override
    public PSSysSearchDEFieldDTO createDTO() {
        return new PSSysSearchDEFieldDTO();
    }
}

