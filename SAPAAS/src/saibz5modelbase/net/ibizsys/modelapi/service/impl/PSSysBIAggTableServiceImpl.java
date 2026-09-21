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
import net.ibizsys.modelapi.domain.PSSysBIAggColumn;
import net.ibizsys.modelapi.domain.PSSysBIAggTable;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysBIAggColumnDTO;
import net.ibizsys.modelapi.dto.PSSysBIAggTableDTO;
import net.ibizsys.modelapi.dto.PSSysBICubeDTO;
import net.ibizsys.modelapi.dto.PSSysBISchemeDTO;
import net.ibizsys.modelapi.service.IPSSysBIAggTableService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysBIAggTableServiceImpl
extends PSModelServiceImplBase<PSSysBIAggTable, PSSysBIAggTableDTO>
implements IPSSysBIAggTableService {
    private static final Log log = LogFactory.getLog(PSSysBIAggTableServiceImpl.class);

    @Override
    public List<PSSysBIAggTable> listByPSSysBIScheme(PSSysBIScheme parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysBIAggTable get(PSSysBIScheme parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysBIAggTable> list = this.listByPSSysBIScheme(parent);
        if (list != null) {
            for (PSSysBIAggTable item : list) {
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
    public List<PSSysBIAggTableDTO> listDTOByPSSysBIScheme(String strParentKey) throws Exception {
        PSSysBIScheme pssysbischeme = (PSSysBIScheme)PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strParentKey);
        List<PSSysBIAggTable> list = this.listByPSSysBIScheme(pssysbischeme);
        if (list != null) {
            ArrayList<PSSysBIAggTableDTO> dtoList = new ArrayList<PSSysBIAggTableDTO>();
            for (PSSysBIAggTable item : list) {
                PSSysBIAggTableDTO dto = (PSSysBIAggTableDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysBIAggTable> onListAll() throws Exception {
        ArrayList<PSSysBIAggTable> list = new ArrayList<PSSysBIAggTable>();
        List pssysbischemes = PSModelServiceUtil.getInstance().getPSSysBISchemeService().listAll();
        if (pssysbischemes != null) {
            for (PSSysBIScheme parent : pssysbischemes) {
                List<PSSysBIAggTable> items = this.listByPSSysBIScheme(parent);
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
    protected PSSysBIAggTable onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysBIAggTable item;
        PSSysBIScheme pssysbischeme = (PSSysBIScheme)PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strParentKey, true);
        if (pssysbischeme != null && (item = this.get(pssysbischeme, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysBIAggTable)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysBIAggTableDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysBISchemeId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysBISchemeService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysBIAggTable et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        if (StringUtils.hasLength((String)et.getPSSysBIAggTableName())) {
            return et.getPSSysBIAggTableName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysBIAggTableDTO dto, PSSysBIAggTable t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysBIAggTableId(t.getId().replace("/", "."));
        }
        if (t.getBIAggTableTag() != null || !bIgnoreNull) {
            dto.setBIAggTableTag(t.getBIAggTableTag());
        }
        if (t.getBIAggTableTag2() != null || !bIgnoreNull) {
            dto.setBIAggTableTag2(t.getBIAggTableTag2());
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
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSSysBIAggTableName() != null || !bIgnoreNull) {
            dto.setPSSysBIAggTableName(t.getPSSysBIAggTableName());
        }
        if (t.getPSSysBICubeId() != null || !bIgnoreNull) {
            dto.setPSSysBICubeId(t.getPSSysBICubeId());
        }
        if (t.getPSSysBICubeName() != null || !bIgnoreNull) {
            dto.setPSSysBICubeName(t.getPSSysBICubeName());
        }
        if (t.getPSSysBISchemeId() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeId(t.getPSSysBISchemeId());
        }
        if (t.getPSSysBISchemeName() != null || !bIgnoreNull) {
            dto.setPSSysBISchemeName(t.getPSSysBISchemeName());
        }
        if (t.getRealTimeMode() != null || !bIgnoreNull) {
            dto.setRealTimeMode(t.getRealTimeMode());
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            dto.setPSSysBICubeId(this.getRealPSModelId(t, dto.getPSSysBICubeId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            dto.setPSSysBISchemeId(this.getRealPSModelId(t, dto.getPSSysBISchemeId()).replace("/", "."));
        }
        if ("PSSYSBISCHEME".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysBISchemeId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBICubeId())) {
            linkDTO = (PSSysBICubeDTO)PSModelServiceUtil.getInstance().getPSSysBICubeService().getDTO(dto.getPSSysBICubeId());
            dto.setPSSysBICubeName(((PSSysBICubeDTO)linkDTO).getPSSysBICubeName());
        } else {
            dto.setPSSysBICubeName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysBISchemeId())) {
            linkDTO = (PSSysBISchemeDTO)PSModelServiceUtil.getInstance().getPSSysBISchemeService().getDTO(dto.getPSSysBISchemeId());
            dto.setPSSysBISchemeName(((PSSysBISchemeDTO)linkDTO).getPSSysBISchemeName());
        } else {
            dto.setPSSysBISchemeName(null);
        }
        List<PSSysBIAggColumn> list = PSModelServiceUtil.getInstance().getPSSysBIAggColumnService().listByPSSysBIAggTable(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSSysBIAggColumnDTO> pssysbiaggcolumns = new ArrayList<PSSysBIAggColumnDTO>();
            for (PSSysBIAggColumn item : list) {
                PSSysBIAggColumnDTO dstItem = (PSSysBIAggColumnDTO)PSModelServiceUtil.getInstance().getPSSysBIAggColumnService().toDTO(item);
                pssysbiaggcolumns.add(dstItem);
            }
            dto.setPssysbiaggcolumns(pssysbiaggcolumns);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSSYSBIAGGTABLE";
    }

    @Override
    public PSSysBIAggTable createDomain() {
        return new PSSysBIAggTable();
    }

    @Override
    public PSSysBIAggTableDTO createDTO() {
        return new PSSysBIAggTableDTO();
    }
}

