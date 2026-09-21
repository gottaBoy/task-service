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
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapDetail;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.dto.PSDEMapDetailDTO;
import net.ibizsys.modelapi.service.IPSDEMapDetailService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMapDetailServiceImpl
extends PSModelServiceImplBase<PSDEMapDetail, PSDEMapDetailDTO>
implements IPSDEMapDetailService {
    private static final Log log = LogFactory.getLog(PSDEMapDetailServiceImpl.class);

    @Override
    public List<PSDEMapDetail> listByPSDEMap(PSDEMap parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMapDetail get(PSDEMap parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMapDetail> list = this.listByPSDEMap(parent);
        if (list != null) {
            for (PSDEMapDetail item : list) {
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
    public List<PSDEMapDetailDTO> listDTOByPSDEMap(String strParentKey) throws Exception {
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey);
        List<PSDEMapDetail> list = this.listByPSDEMap(psdemap);
        if (list != null) {
            ArrayList<PSDEMapDetailDTO> dtoList = new ArrayList<PSDEMapDetailDTO>();
            for (PSDEMapDetail item : list) {
                PSDEMapDetailDTO dto = (PSDEMapDetailDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMapDetail> onListAll() throws Exception {
        ArrayList<PSDEMapDetail> list = new ArrayList<PSDEMapDetail>();
        List psdemaps = PSModelServiceUtil.getInstance().getPSDEMapService().listAll();
        if (psdemaps != null) {
            for (PSDEMap parent : psdemaps) {
                List<PSDEMapDetail> items = this.listByPSDEMap(parent);
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
    protected PSDEMapDetail onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMapDetail item;
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey, true);
        if (psdemap != null && (item = this.get(psdemap, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMapDetail)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMapDetailDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEMapId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMapService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMapDetail et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMapDetailDTO dto, PSDEMapDetail t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMapDetailId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDstFieldName() != null || !bIgnoreNull) {
            dto.setDstFieldName(t.getDstFieldName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMapDetailName() != null || !bIgnoreNull) {
            dto.setPSDEMapDetailName(t.getPSDEMapDetailName());
        }
        if (t.getPSDEMapId() != null || !bIgnoreNull) {
            dto.setPSDEMapId(t.getPSDEMapId());
        }
        if (t.getPSDEMapName() != null || !bIgnoreNull) {
            dto.setPSDEMapName(t.getPSDEMapName());
        }
        if (t.getSrcPSDEFId() != null || !bIgnoreNull) {
            dto.setSrcPSDEFId(t.getSrcPSDEFId());
        }
        if (t.getSrcPSDEFName() != null || !bIgnoreNull) {
            dto.setSrcPSDEFName(t.getSrcPSDEFName());
        }
        if (t.getSrcType() != null || !bIgnoreNull) {
            dto.setSrcType(t.getSrcType());
        }
        if (t.getSrcValue() != null || !bIgnoreNull) {
            dto.setSrcValue(t.getSrcValue());
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
        if (StringUtils.hasLength((String)dto.getPSDEMapId())) {
            dto.setPSDEMapId(this.getRealPSModelId(t, dto.getPSDEMapId()).replace("/", "."));
        }
        if ("PSDEMAP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEMapId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDEFId())) {
            dto.setSrcPSDEFId(this.getRealPSModelId(t, dto.getSrcPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMapId())) {
            linkDTO = (PSDEMapDTO)PSModelServiceUtil.getInstance().getPSDEMapService().getDTO(dto.getPSDEMapId());
            dto.setPSDEId(((PSDEMapDTO)linkDTO).getPSDEId());
            dto.setPSDEMapName(((PSDEMapDTO)linkDTO).getPSDEMapName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDEMapName(null);
        }
        if (StringUtils.hasLength((String)dto.getSrcPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getSrcPSDEFId());
            dto.setSrcPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setSrcPSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMAPDETAIL";
    }

    @Override
    public PSDEMapDetail createDomain() {
        return new PSDEMapDetail();
    }

    @Override
    public PSDEMapDetailDTO createDTO() {
        return new PSDEMapDetailDTO();
    }
}

