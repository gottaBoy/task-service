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
import net.ibizsys.modelapi.domain.PSDEGEIUDetail;
import net.ibizsys.modelapi.domain.PSDEGEIUpdate;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEGEIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.service.IPSDEGEIUpdateService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEGEIUpdateServiceImpl
extends PSModelServiceImplBase<PSDEGEIUpdate, PSDEGEIUpdateDTO>
implements IPSDEGEIUpdateService {
    private static final Log log = LogFactory.getLog(PSDEGEIUpdateServiceImpl.class);

    @Override
    public List<PSDEGEIUpdate> listByPSDEGrid(PSDEGrid parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEGEIUpdate get(PSDEGrid parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEGEIUpdate> list = this.listByPSDEGrid(parent);
        if (list != null) {
            for (PSDEGEIUpdate item : list) {
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
    public List<PSDEGEIUpdateDTO> listDTOByPSDEGrid(String strParentKey) throws Exception {
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey);
        List<PSDEGEIUpdate> list = this.listByPSDEGrid(psdegrid);
        if (list != null) {
            ArrayList<PSDEGEIUpdateDTO> dtoList = new ArrayList<PSDEGEIUpdateDTO>();
            for (PSDEGEIUpdate item : list) {
                PSDEGEIUpdateDTO dto = (PSDEGEIUpdateDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEGEIUpdate> onListAll() throws Exception {
        ArrayList<PSDEGEIUpdate> list = new ArrayList<PSDEGEIUpdate>();
        List psdegrids = PSModelServiceUtil.getInstance().getPSDEGridService().listAll();
        if (psdegrids != null) {
            for (PSDEGrid parent : psdegrids) {
                List<PSDEGEIUpdate> items = this.listByPSDEGrid(parent);
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
    protected PSDEGEIUpdate onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEGEIUpdate item;
        PSDEGrid psdegrid = (PSDEGrid)PSModelServiceUtil.getInstance().getPSDEGridService().get(strParentKey, true);
        if (psdegrid != null && (item = this.get(psdegrid, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEGEIUpdate)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEGEIUpdateDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEGridId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEGridService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEGEIUpdate et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEGEIUpdateName())) {
            return et.getPSDEGEIUpdateName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEGEIUpdateDTO dto, PSDEGEIUpdate t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEGEIUpdateId(t.getId().replace("/", "."));
        }
        if (t.getBusyIndicator() != null || !bIgnoreNull) {
            dto.setBusyIndicator(t.getBusyIndicator());
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
        if (t.getCustomCode() != null || !bIgnoreNull) {
            dto.setCustomCode(t.getCustomCode());
        }
        if (t.getCustomMode() != null || !bIgnoreNull) {
            dto.setCustomMode(t.getCustomMode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSACHandlerId() != null || !bIgnoreNull) {
            dto.setPSACHandlerId(t.getPSACHandlerId());
        }
        if (t.getPSACHandlerName() != null || !bIgnoreNull) {
            dto.setPSACHandlerName(t.getPSACHandlerName());
        }
        if (t.getPSDEActionId() != null || !bIgnoreNull) {
            dto.setPSDEActionId(t.getPSDEActionId());
        }
        if (t.getPSDEActionName() != null || !bIgnoreNull) {
            dto.setPSDEActionName(t.getPSDEActionName());
        }
        if (t.getPSDEGEIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEGEIUpdateName(t.getPSDEGEIUpdateName());
        }
        if (t.getPSDEGridId() != null || !bIgnoreNull) {
            dto.setPSDEGridId(t.getPSDEGridId());
        }
        if (t.getPSDEGridName() != null || !bIgnoreNull) {
            dto.setPSDEGridName(t.getPSDEGridName());
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
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            dto.setPSDEGridId(this.getRealPSModelId(t, dto.getPSDEGridId()).replace("/", "."));
        }
        if ("PSDEGRID".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEGridId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            linkDTO = (PSACHandlerDTO)PSModelServiceUtil.getInstance().getPSACHandlerService().getDTO(dto.getPSACHandlerId());
            dto.setPSACHandlerName(((PSACHandlerDTO)linkDTO).getPSACHandlerName());
        } else {
            dto.setPSACHandlerName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEGridId())) {
            linkDTO = (PSDEGridDTO)PSModelServiceUtil.getInstance().getPSDEGridService().getDTO(dto.getPSDEGridId());
            dto.setPSDEGridName(((PSDEGridDTO)linkDTO).getPSDEGridName());
        } else {
            dto.setPSDEGridName(null);
        }
        List<PSDEGEIUDetail> list = PSModelServiceUtil.getInstance().getPSDEGEIUDetailService().listByPSDEGEIUpdate(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEGEIUDetailDTO> psdegeiudetails = new ArrayList<PSDEGEIUDetailDTO>();
            for (PSDEGEIUDetail item : list) {
                PSDEGEIUDetailDTO dstItem = (PSDEGEIUDetailDTO)PSModelServiceUtil.getInstance().getPSDEGEIUDetailService().toDTO(item);
                psdegeiudetails.add(dstItem);
            }
            dto.setPsdegeiudetails(psdegeiudetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEGEIUPDATE";
    }

    @Override
    public PSDEGEIUpdate createDomain() {
        return new PSDEGEIUpdate();
    }

    @Override
    public PSDEGEIUpdateDTO createDTO() {
        return new PSDEGEIUpdateDTO();
    }
}

