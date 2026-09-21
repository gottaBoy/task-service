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
import net.ibizsys.modelapi.domain.PSDEMapAction;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEMapActionDTO;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.service.IPSDEMapActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEMapActionServiceImpl
extends PSModelServiceImplBase<PSDEMapAction, PSDEMapActionDTO>
implements IPSDEMapActionService {
    private static final Log log = LogFactory.getLog(PSDEMapActionServiceImpl.class);

    @Override
    public List<PSDEMapAction> listByPSDEMap(PSDEMap parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEMapAction get(PSDEMap parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEMapAction> list = this.listByPSDEMap(parent);
        if (list != null) {
            for (PSDEMapAction item : list) {
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
    public List<PSDEMapActionDTO> listDTOByPSDEMap(String strParentKey) throws Exception {
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey);
        List<PSDEMapAction> list = this.listByPSDEMap(psdemap);
        if (list != null) {
            ArrayList<PSDEMapActionDTO> dtoList = new ArrayList<PSDEMapActionDTO>();
            for (PSDEMapAction item : list) {
                PSDEMapActionDTO dto = (PSDEMapActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEMapAction> onListAll() throws Exception {
        ArrayList<PSDEMapAction> list = new ArrayList<PSDEMapAction>();
        List psdemaps = PSModelServiceUtil.getInstance().getPSDEMapService().listAll();
        if (psdemaps != null) {
            for (PSDEMap parent : psdemaps) {
                List<PSDEMapAction> items = this.listByPSDEMap(parent);
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
    protected PSDEMapAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEMapAction item;
        PSDEMap psdemap = (PSDEMap)PSModelServiceUtil.getInstance().getPSDEMapService().get(strParentKey, true);
        if (psdemap != null && (item = this.get(psdemap, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEMapAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEMapActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEMapId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEMapService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEMapAction et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEMapActionDTO dto, PSDEMapAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEMapActionId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDstPSDEActionId() != null || !bIgnoreNull) {
            dto.setDstPSDEActionId(t.getDstPSDEActionId());
        }
        if (t.getDstPSDEActionName() != null || !bIgnoreNull) {
            dto.setDstPSDEActionName(t.getDstPSDEActionName());
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
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEMapActionName() != null || !bIgnoreNull) {
            dto.setPSDEMapActionName(t.getPSDEMapActionName());
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
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            dto.setDstPSDEActionId(this.getRealPSModelId(t, dto.getDstPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEMapId())) {
            dto.setPSDEMapId(this.getRealPSModelId(t, dto.getPSDEMapId()).replace("/", "."));
        }
        if ("PSDEMAP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEMapId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getDstPSDEActionId());
            dto.setDstPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setDstPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
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
        return "PSDEMAPACTION";
    }

    @Override
    public PSDEMapAction createDomain() {
        return new PSDEMapAction();
    }

    @Override
    public PSDEMapActionDTO createDTO() {
        return new PSDEMapActionDTO();
    }
}

