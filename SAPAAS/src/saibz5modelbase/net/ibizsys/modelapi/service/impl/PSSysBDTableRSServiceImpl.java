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
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBDTableRS;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.dto.PSSysBDTableRSDTO;
import net.ibizsys.modelapi.service.IPSSysBDTableRSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBDTableRSServiceImpl
extends PSModelServiceImplBase<PSSysBDTableRS, PSSysBDTableRSDTO>
implements IPSSysBDTableRSService {
    private static final Log log = LogFactory.getLog(PSSysBDTableRSServiceImpl.class);

    @Override
    public List<PSSysBDTableRS> listByPSSysBDScheme(PSSysBDScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBDTableRS get(PSSysBDScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBDTableRS> list = this.listByPSSysBDScheme(parent);
        if (list != null) {
            for (PSSysBDTableRS item : list) {
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
    public List<PSSysBDTableRSDTO> listDTOByPSSysBDScheme(String strParentKey) throws Exception {
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey);
        List<PSSysBDTableRS> list = this.listByPSSysBDScheme(pssysbdscheme);
        if (list != null) {
            ArrayList<PSSysBDTableRSDTO> dtoList = new ArrayList<PSSysBDTableRSDTO>();
            for (PSSysBDTableRS item : list) {
                PSSysBDTableRSDTO dto = (PSSysBDTableRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBDTableRS> onListAll() throws Exception {
        ArrayList<PSSysBDTableRS> list = new ArrayList<PSSysBDTableRS>();
        List<PSSysBDScheme> pssysbdschemes = PSModelServiceUtil.getInstance().getPSSysBDSchemeService().listAll();
        if (pssysbdschemes != null) {
            for (PSSysBDScheme parent : pssysbdschemes) {
                List<PSSysBDTableRS> items = this.listByPSSysBDScheme(parent);
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
    protected PSSysBDTableRS onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBDTableRS item;
        PSSysBDScheme pssysbdscheme = (PSSysBDScheme)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strParentKey, true);
        if (pssysbdscheme != null && (item = this.get(pssysbdscheme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBDTableRS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBDTableRSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBDSchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBDSchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBDTableRS et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSSysBDTableRSName())) {
            return et.getPSSysBDTableRSName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBDTableRSDTO dto, PSSysBDTableRS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBDTableRSId(t.getId().replace("/", "."));
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
        if (t.getMajorPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setMajorPSSysBDTableId(t.getMajorPSSysBDTableId());
        }
        if (t.getMajorPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setMajorPSSysBDTableName(t.getMajorPSSysBDTableName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorCodeName() != null || !bIgnoreNull) {
            dto.setMinorCodeName(t.getMinorCodeName());
        }
        if (t.getMinorPSSysBDTableId() != null || !bIgnoreNull) {
            dto.setMinorPSSysBDTableId(t.getMinorPSSysBDTableId());
        }
        if (t.getMinorPSSysBDTableName() != null || !bIgnoreNull) {
            dto.setMinorPSSysBDTableName(t.getMinorPSSysBDTableName());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysBDSchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeId(t.getPSSysBDSchemeId());
        }
        if (t.getPSSysBDSchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBDSchemeName(t.getPSSysBDSchemeName());
        }
        if (t.getPSSysBDTableRSName() != null || !bIgnoreNull) {
            dto.setPSSysBDTableRSName(t.getPSSysBDTableRSName());
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
        if (StringUtils.hasLength((String)dto.getMajorPSSysBDTableId())) {
            dto.setMajorPSSysBDTableId(this.getRealPSModelId(t, dto.getMajorPSSysBDTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSSysBDTableId())) {
            dto.setMinorPSSysBDTableId(this.getRealPSModelId(t, dto.getMinorPSSysBDTableId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            dto.setPSSysBDSchemeId(this.getRealPSModelId(t, dto.getPSSysBDSchemeId()).replace("/", "."));
        }
        if ("PSSYSBDSCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBDSchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getMajorPSSysBDTableId());
            dto.setMajorPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setMajorPSSysBDTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSSysBDTableId())) {
            linkDTO = (PSSysBDTableDTO)PSModelServiceUtil.getInstance().getPSSysBDTableService().getDTO(dto.getMinorPSSysBDTableId());
            dto.setMinorPSSysBDTableName(((PSSysBDTableDTO)linkDTO).getPSSysBDTableName());
        } else {
            dto.setMinorPSSysBDTableName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBDSchemeId())) {
            linkDTO = (PSSysBDSchemeDTO)PSModelServiceUtil.getInstance().getPSSysBDSchemeService().getDTO(dto.getPSSysBDSchemeId());
            dto.setPSSysBDSchemeName(((PSSysBDSchemeDTO)linkDTO).getPSSysBDSchemeName());
        } else {
            dto.setPSSysBDSchemeName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSBDTABLERS";
    }

    @Override
    public PSSysBDTableRS createDomain() {
        return new PSSysBDTableRS();
    }

    @Override
    public PSSysBDTableRSDTO createDTO() {
        return new PSSysBDTableRSDTO();
    }
}

