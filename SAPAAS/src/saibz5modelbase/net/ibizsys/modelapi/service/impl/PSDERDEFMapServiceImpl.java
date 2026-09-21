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
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDERDEFMap;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDERDEFMapDTO;
import net.ibizsys.modelapi.dto.PSDERDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDERDEFMapService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDERDEFMapServiceImpl
extends PSModelServiceImplBase<PSDERDEFMap, PSDERDEFMapDTO>
implements IPSDERDEFMapService {
    private static final Log log = LogFactory.getLog(PSDERDEFMapServiceImpl.class);

    @Override
    public List<PSDERDEFMap> listByPSDER(PSDER parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDERDEFMap get(PSDER parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDERDEFMap> list = this.listByPSDER(parent);
        if (list != null) {
            for (PSDERDEFMap item : list) {
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
    public List<PSDERDEFMapDTO> listDTOByPSDER(String strParentKey) throws Exception {
        PSDER psder = (PSDER)PSModelServiceUtil.getInstance().getPSDERService().get(strParentKey);
        List<PSDERDEFMap> list = this.listByPSDER(psder);
        if (list != null) {
            ArrayList<PSDERDEFMapDTO> dtoList = new ArrayList<PSDERDEFMapDTO>();
            for (PSDERDEFMap item : list) {
                PSDERDEFMapDTO dto = (PSDERDEFMapDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDERDEFMap> onListAll() throws Exception {
        ArrayList<PSDERDEFMap> list = new ArrayList<PSDERDEFMap>();
        List psders = PSModelServiceUtil.getInstance().getPSDERService().listAll();
        if (psders != null) {
            for (PSDER parent : psders) {
                List<PSDERDEFMap> items = this.listByPSDER(parent);
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
    protected PSDERDEFMap onGet(String strParentKey, String strCurKey) throws Exception {
        PSDERDEFMap item;
        PSDER psder = (PSDER)PSModelServiceUtil.getInstance().getPSDERService().get(strParentKey, true);
        if (psder != null && (item = this.get(psder, strCurKey, true)) != null) {
            return item;
        }
        return (PSDERDEFMap)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDERDEFMapDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDERId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDERService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDERDEFMap et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDERDEFMapDTO dto, PSDERDEFMap t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDERDEFMapId(t.getId().replace("/", "."));
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
        if (t.getFormulaFormat() != null || !bIgnoreNull) {
            dto.setFormulaFormat(t.getFormulaFormat());
        }
        if (t.getMajorPSDEFId() != null || !bIgnoreNull) {
            dto.setMajorPSDEFId(t.getMajorPSDEFId());
        }
        if (t.getMajorPSDEFName() != null || !bIgnoreNull) {
            dto.setMajorPSDEFName(t.getMajorPSDEFName());
        }
        if (t.getMajorPSDEId() != null || !bIgnoreNull) {
            dto.setMajorPSDEId(t.getMajorPSDEId());
        }
        if (t.getMapType() != null || !bIgnoreNull) {
            dto.setMapType(t.getMapType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMinorPSDEFId() != null || !bIgnoreNull) {
            dto.setMinorPSDEFId(t.getMinorPSDEFId());
        }
        if (t.getMinorPSDEFName() != null || !bIgnoreNull) {
            dto.setMinorPSDEFName(t.getMinorPSDEFName());
        }
        if (t.getMinorPSDEId() != null || !bIgnoreNull) {
            dto.setMinorPSDEId(t.getMinorPSDEId());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDERDEFMapName() != null || !bIgnoreNull) {
            dto.setPSDERDEFMapName(t.getPSDERDEFMapName());
        }
        if (t.getPSDERId() != null || !bIgnoreNull) {
            dto.setPSDERId(t.getPSDERId());
        }
        if (t.getPSDERName() != null || !bIgnoreNull) {
            dto.setPSDERName(t.getPSDERName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
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
        if (StringUtils.hasLength((String)dto.getMajorPSDEFId())) {
            dto.setMajorPSDEFId(this.getRealPSModelId(t, dto.getMajorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFId())) {
            dto.setMinorPSDEFId(this.getRealPSModelId(t, dto.getMinorPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            dto.setPSDERId(this.getRealPSModelId(t, dto.getPSDERId()).replace("/", "."));
        }
        if ("PSDER".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDERId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getMajorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMajorPSDEFId());
            dto.setMajorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMajorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getMinorPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getMinorPSDEFId());
            dto.setMinorPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setMinorPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDQName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDERId())) {
            linkDTO = (PSDERDTO)PSModelServiceUtil.getInstance().getPSDERService().getDTO(dto.getPSDERId());
            dto.setMajorPSDEId(((PSDERDTO)linkDTO).getMajorPSDEId());
            dto.setMinorPSDEId(((PSDERDTO)linkDTO).getMinorPSDEId());
            dto.setPSDERName(((PSDERDTO)linkDTO).getPSDERName());
        } else {
            dto.setMajorPSDEId(null);
            dto.setMinorPSDEId(null);
            dto.setPSDERName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDERDEFMAP";
    }

    @Override
    public PSDERDEFMap createDomain() {
        return new PSDERDEFMap();
    }

    @Override
    public PSDERDEFMapDTO createDTO() {
        return new PSDERDEFMapDTO();
    }
}

