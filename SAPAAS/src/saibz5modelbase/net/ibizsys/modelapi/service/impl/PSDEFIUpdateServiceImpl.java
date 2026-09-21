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
import net.ibizsys.modelapi.domain.PSDEFIUDetail;
import net.ibizsys.modelapi.domain.PSDEFIUpdate;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEFIUDetailDTO;
import net.ibizsys.modelapi.dto.PSDEFIUpdateDTO;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.service.IPSDEFIUpdateService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEFIUpdateServiceImpl
extends PSModelServiceImplBase<PSDEFIUpdate, PSDEFIUpdateDTO>
implements IPSDEFIUpdateService {
    private static final Log log = LogFactory.getLog(PSDEFIUpdateServiceImpl.class);

    @Override
    public List<PSDEFIUpdate> listByPSDEForm(PSDEForm parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEFIUpdate get(PSDEForm parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEFIUpdate> list = this.listByPSDEForm(parent);
        if (list != null) {
            for (PSDEFIUpdate item : list) {
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
    public List<PSDEFIUpdateDTO> listDTOByPSDEForm(String strParentKey) throws Exception {
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey);
        List<PSDEFIUpdate> list = this.listByPSDEForm(psdeform);
        if (list != null) {
            ArrayList<PSDEFIUpdateDTO> dtoList = new ArrayList<PSDEFIUpdateDTO>();
            for (PSDEFIUpdate item : list) {
                PSDEFIUpdateDTO dto = (PSDEFIUpdateDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEFIUpdate> onListAll() throws Exception {
        ArrayList<PSDEFIUpdate> list = new ArrayList<PSDEFIUpdate>();
        List psdeforms = PSModelServiceUtil.getInstance().getPSDEFormService().listAll();
        if (psdeforms != null) {
            for (PSDEForm parent : psdeforms) {
                List<PSDEFIUpdate> items = this.listByPSDEForm(parent);
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
    protected PSDEFIUpdate onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEFIUpdate item;
        PSDEForm psdeform = (PSDEForm)PSModelServiceUtil.getInstance().getPSDEFormService().get(strParentKey, true);
        if (psdeform != null && (item = this.get(psdeform, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEFIUpdate)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEFIUpdateDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEFormId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEFormService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEFIUpdate et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEFIUpdateName())) {
            return et.getPSDEFIUpdateName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEFIUpdateDTO dto, PSDEFIUpdate t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEFIUpdateId(t.getId().replace("/", "."));
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
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
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
        if (t.getPSDEFIUpdateName() != null || !bIgnoreNull) {
            dto.setPSDEFIUpdateName(t.getPSDEFIUpdateName());
        }
        if (t.getPSDEFormId() != null || !bIgnoreNull) {
            dto.setPSDEFormId(t.getPSDEFormId());
        }
        if (t.getPSDEFormName() != null || !bIgnoreNull) {
            dto.setPSDEFormName(t.getPSDEFormName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
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
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            dto.setPSDEFormId(this.getRealPSModelId(t, dto.getPSDEFormId()).replace("/", "."));
        }
        if ("PSDEFORM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEFormId(t.getSrfParent().getId().replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEFormId())) {
            linkDTO = (PSDEFormDTO)PSModelServiceUtil.getInstance().getPSDEFormService().getDTO(dto.getPSDEFormId());
            dto.setPSDEFormName(((PSDEFormDTO)linkDTO).getPSDEFormName());
            dto.setPSDEId(((PSDEFormDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSDEFormName(null);
            dto.setPSDEId(null);
        }
        List<PSDEFIUDetail> list = PSModelServiceUtil.getInstance().getPSDEFIUDetailService().listByPSDEFIUpdate(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSDEFIUDetailDTO> psdefiudetails = new ArrayList<PSDEFIUDetailDTO>();
            for (PSDEFIUDetail item : list) {
                PSDEFIUDetailDTO dstItem = (PSDEFIUDetailDTO)PSModelServiceUtil.getInstance().getPSDEFIUDetailService().toDTO(item);
                psdefiudetails.add(dstItem);
            }
            dto.setPsdefiudetails(psdefiudetails);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEFIUPDATE";
    }

    @Override
    public PSDEFIUpdate createDomain() {
        return new PSDEFIUpdate();
    }

    @Override
    public PSDEFIUpdateDTO createDTO() {
        return new PSDEFIUpdateDTO();
    }
}

