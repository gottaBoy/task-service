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
import net.ibizsys.modelapi.domain.PSACHandler;
import net.ibizsys.modelapi.domain.PSACHandlerAction;
import net.ibizsys.modelapi.dto.PSACHandlerActionDTO;
import net.ibizsys.modelapi.dto.PSACHandlerDTO;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDEOPPrivDTO;
import net.ibizsys.modelapi.service.IPSACHandlerActionService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSACHandlerActionServiceImpl
extends PSModelServiceImplBase<PSACHandlerAction, PSACHandlerActionDTO>
implements IPSACHandlerActionService {
    private static final Log log = LogFactory.getLog(PSACHandlerActionServiceImpl.class);

    @Override
    public List<PSACHandlerAction> listByPSACHandler(PSACHandler parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSACHandlerAction get(PSACHandler parent, String strKey, boolean bTryMode) throws Exception {
        List<PSACHandlerAction> list = this.listByPSACHandler(parent);
        if (list != null) {
            for (PSACHandlerAction item : list) {
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
    public List<PSACHandlerActionDTO> listDTOByPSACHandler(String strParentKey) throws Exception {
        PSACHandler psachandler = (PSACHandler)PSModelServiceUtil.getInstance().getPSACHandlerService().get(strParentKey);
        List<PSACHandlerAction> list = this.listByPSACHandler(psachandler);
        if (list != null) {
            ArrayList<PSACHandlerActionDTO> dtoList = new ArrayList<PSACHandlerActionDTO>();
            for (PSACHandlerAction item : list) {
                PSACHandlerActionDTO dto = (PSACHandlerActionDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSACHandlerAction> onListAll() throws Exception {
        ArrayList<PSACHandlerAction> list = new ArrayList<PSACHandlerAction>();
        List psachandlers = PSModelServiceUtil.getInstance().getPSACHandlerService().listAll();
        if (psachandlers != null) {
            for (PSACHandler parent : psachandlers) {
                List<PSACHandlerAction> items = this.listByPSACHandler(parent);
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
    protected PSACHandlerAction onGet(String strParentKey, String strCurKey) throws Exception {
        PSACHandlerAction item;
        PSACHandler psachandler = (PSACHandler)PSModelServiceUtil.getInstance().getPSACHandlerService().get(strParentKey, true);
        if (psachandler != null && (item = this.get(psachandler, strCurKey, true)) != null) {
            return item;
        }
        return (PSACHandlerAction)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSACHandlerActionDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSACHandlerId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSACHandlerService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSACHandlerAction et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSACHandlerActionName())) {
            return et.getPSACHandlerActionName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSACHandlerActionDTO dto, PSACHandlerAction t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSACHandlerActionId(t.getId().replace("/", "."));
        }
        if (t.getActionDesc() != null || !bIgnoreNull) {
            dto.setActionDesc(t.getActionDesc());
        }
        if (t.getActionTimeout() != null || !bIgnoreNull) {
            dto.setActionTimeout(t.getActionTimeout());
        }
        if (t.getActionType() != null || !bIgnoreNull) {
            dto.setActionType(t.getActionType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDataAccAction() != null || !bIgnoreNull) {
            dto.setDataAccAction(t.getDataAccAction());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSACHandlerActionName() != null || !bIgnoreNull) {
            dto.setPSACHandlerActionName(t.getPSACHandlerActionName());
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
        if (t.getPSDEOPPrivId() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivId(t.getPSDEOPPrivId());
        }
        if (t.getPSDEOPPrivName() != null || !bIgnoreNull) {
            dto.setPSDEOPPrivName(t.getPSDEOPPrivName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSACHandlerId())) {
            dto.setPSACHandlerId(this.getRealPSModelId(t, dto.getPSACHandlerId()).replace("/", "."));
        }
        if ("PSACHANDLER".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSACHandlerId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            dto.setPSDEOPPrivId(this.getRealPSModelId(t, dto.getPSDEOPPrivId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEOPPrivId())) {
            linkDTO = (PSDEOPPrivDTO)PSModelServiceUtil.getInstance().getPSDEOPPrivService().getDTO(dto.getPSDEOPPrivId());
            dto.setPSDEOPPrivName(((PSDEOPPrivDTO)linkDTO).getPSDEOPPrivName());
        } else {
            dto.setPSDEOPPrivName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSACHANDLERACTION";
    }

    @Override
    public PSACHandlerAction createDomain() {
        return new PSACHandlerAction();
    }

    @Override
    public PSACHandlerActionDTO createDTO() {
        return new PSACHandlerActionDTO();
    }
}

