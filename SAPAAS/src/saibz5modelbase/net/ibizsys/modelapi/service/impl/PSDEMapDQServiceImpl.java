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
import net.ibizsys.modelapi.domain.PSDEMapDQ;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEMapDQDTO;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.service.IPSDEMapDQService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMapDQServiceImpl
extends PSModelServiceImplBase<PSDEMapDQ, PSDEMapDQDTO>
implements IPSDEMapDQService {
    private static final Log log = LogFactory.getLog(PSDEMapDQServiceImpl.class);

    @Override
    public List<PSDEMapDQ> listByPSDEMap(PSDEMap parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMapDQ get(PSDEMap parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMapDQ> list = this.listByPSDEMap(parent);
        if (list != null) {
            for (PSDEMapDQ item : list) {
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
    public List<PSDEMapDQDTO> listDTOByPSDEMap(String strParentKey) throws Exception {
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey);
        List<PSDEMapDQ> list = this.listByPSDEMap(psdemap);
        if (list != null) {
            ArrayList<PSDEMapDQDTO> dtoList = new ArrayList<PSDEMapDQDTO>();
            for (PSDEMapDQ item : list) {
                PSDEMapDQDTO dto = (PSDEMapDQDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMapDQ> onListAll() throws Exception {
        ArrayList<PSDEMapDQ> list = new ArrayList<PSDEMapDQ>();
        List<PSDEMap> psdemaps = PSModelServiceUtil.getInstance().getPSDEMapService().listAll();
        if (psdemaps != null) {
            for (PSDEMap parent : psdemaps) {
                List<PSDEMapDQ> items = this.listByPSDEMap(parent);
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
    protected PSDEMapDQ onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMapDQ item;
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey, true);
        if (psdemap != null && (item = this.get(psdemap, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMapDQ)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMapDQDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEMapId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMapService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMapDQ et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMapDQDTO dto, PSDEMapDQ t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMapDQId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDstPSDEDataQueryId() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryId(t.getDstPSDEDataQueryId());
        }
        if (t.getDstPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setDstPSDEDataQueryName(t.getDstPSDEDataQueryName());
        }
        if (t.getDstPSDEId() != null || !bIgnoreNull) {
            dto.setDstPSDEId(t.getDstPSDEId());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPropertyMap() != null || !bIgnoreNull) {
            dto.setPropertyMap(t.getPropertyMap());
        }
        if (t.getPSDEDataQueryId() != null || !bIgnoreNull) {
            dto.setPSDEDataQueryId(t.getPSDEDataQueryId());
        }
        if (t.getPSDEDataQueryName() != null || !bIgnoreNull) {
            dto.setPSDEDataQueryName(t.getPSDEDataQueryName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMapDQName() != null || !bIgnoreNull) {
            dto.setPSDEMapDQName(t.getPSDEMapDQName());
        }
        if (t.getPSDEMapId() != null || !bIgnoreNull) {
            dto.setPSDEMapId(t.getPSDEMapId());
        }
        if (t.getPSDEMapName() != null || !bIgnoreNull) {
            dto.setPSDEMapName(t.getPSDEMapName());
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
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            dto.setDstPSDEDataQueryId(this.getRealPSModelId(t, dto.getDstPSDEDataQueryId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataQueryId())) {
            dto.setPSDEDataQueryId(this.getRealPSModelId(t, dto.getPSDEDataQueryId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMapId())) {
            dto.setPSDEMapId(this.getRealPSModelId(t, dto.getPSDEMapId()).replace("/", "."));
        }
        if ("PSDEMAP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEMapId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEDataQueryId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getDstPSDEDataQueryId());
            dto.setDstPSDEDataQueryName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setDstPSDEDataQueryName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataQueryId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDataQueryId());
            dto.setPSDEDataQueryName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
        } else {
            dto.setPSDEDataQueryName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEMapId())) {
            linkDTO = (PSDEMapDTO)PSModelServiceUtil.getInstance().getPSDEMapService().getDTO(dto.getPSDEMapId());
            dto.setDstPSDEId(((PSDEMapDTO)linkDTO).getDSTPSDEId());
            dto.setPSDEId(((PSDEMapDTO)linkDTO).getPSDEId());
            dto.setPSDEMapName(((PSDEMapDTO)linkDTO).getPSDEMapName());
        } else {
            dto.setDstPSDEId(null);
            dto.setPSDEId(null);
            dto.setPSDEMapName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEMAPDQ";
    }

    @Override
    public PSDEMapDQ createDomain() {
        return new PSDEMapDQ();
    }

    @Override
    public PSDEMapDQDTO createDTO() {
        return new PSDEMapDQDTO();
    }
}

