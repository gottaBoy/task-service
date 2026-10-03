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
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWXLogic;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSWXAccountDTO;
import net.ibizsys.modelapi.dto.PSWXEntAppDTO;
import net.ibizsys.modelapi.dto.PSWXLogicDTO;
import net.ibizsys.modelapi.dto.PSWXMenuFuncDTO;
import net.ibizsys.modelapi.service.IPSWXLogicService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWXLogicServiceImpl
extends PSModelServiceImplBase<PSWXLogic, PSWXLogicDTO>
implements IPSWXLogicService {
    private static final Log log = LogFactory.getLog(PSWXLogicServiceImpl.class);

    @Override
    public List<PSWXLogic> listByPSWXAccount(PSWXAccount parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXLogic get(PSWXAccount parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXLogic> list = this.listByPSWXAccount(parent);
        if (list != null) {
            for (PSWXLogic item : list) {
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
    public List<PSWXLogicDTO> listDTOByPSWXAccount(String strParentKey) throws Exception {
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey);
        List<PSWXLogic> list = this.listByPSWXAccount(pswxaccount);
        if (list != null) {
            ArrayList<PSWXLogicDTO> dtoList = new ArrayList<PSWXLogicDTO>();
            for (PSWXLogic item : list) {
                PSWXLogicDTO dto = (PSWXLogicDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWXLogic> onListAll() throws Exception {
        ArrayList<PSWXLogic> list = new ArrayList<PSWXLogic>();
        List<PSWXAccount> pswxaccounts = PSModelServiceUtil.getInstance().getPSWXAccountService().listAll();
        if (pswxaccounts != null) {
            for (PSWXAccount parent : pswxaccounts) {
                List<PSWXLogic> items = this.listByPSWXAccount(parent);
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
    protected PSWXLogic onGet(String strParentKey, String strCurKey) throws Exception {
        PSWXLogic item;
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey, true);
        if (pswxaccount != null && (item = this.get(pswxaccount, strCurKey, true)) != null) {
            return item;
        }
        return (PSWXLogic)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWXLogicDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWXAccountId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXAccountService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWXLogic et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWXLogicDTO dto, PSWXLogic t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWXLogicId(t.getId().replace("/", "."));
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
        if (t.getEventType() != null || !bIgnoreNull) {
            dto.setEventType(t.getEventType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
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
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSWXAccountId() != null || !bIgnoreNull) {
            dto.setPSWXAccountId(t.getPSWXAccountId());
        }
        if (t.getPSWXAccountName() != null || !bIgnoreNull) {
            dto.setPSWXAccountName(t.getPSWXAccountName());
        }
        if (t.getPSWXEntAppId() != null || !bIgnoreNull) {
            dto.setPSWXEntAppId(t.getPSWXEntAppId());
        }
        if (t.getPSWXEntAppName() != null || !bIgnoreNull) {
            dto.setPSWXEntAppName(t.getPSWXEntAppName());
        }
        if (t.getPSWXLogicName() != null || !bIgnoreNull) {
            dto.setPSWXLogicName(t.getPSWXLogicName());
        }
        if (t.getPSWXMenuFuncId() != null || !bIgnoreNull) {
            dto.setPSWXMenuFuncId(t.getPSWXMenuFuncId());
        }
        if (t.getPSWXMenuFuncName() != null || !bIgnoreNull) {
            dto.setPSWXMenuFuncName(t.getPSWXMenuFuncName());
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
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            dto.setPSDEActionId(this.getRealPSModelId(t, dto.getPSDEActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            dto.setPSWXAccountId(this.getRealPSModelId(t, dto.getPSWXAccountId()).replace("/", "."));
        }
        if ("PSWXACCOUNT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWXAccountId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXEntAppId())) {
            dto.setPSWXEntAppId(this.getRealPSModelId(t, dto.getPSWXEntAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuFuncId())) {
            dto.setPSWXMenuFuncId(this.getRealPSModelId(t, dto.getPSWXMenuFuncId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEActionId())) {
            linkDTO = (PSDEActionDTO)PSModelServiceUtil.getInstance().getPSDEActionService().getDTO(dto.getPSDEActionId());
            dto.setPSDEActionName(((PSDEActionDTO)linkDTO).getPSDEActionName());
        } else {
            dto.setPSDEActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            linkDTO = (PSWXAccountDTO)PSModelServiceUtil.getInstance().getPSWXAccountService().getDTO(dto.getPSWXAccountId());
            dto.setPSWXAccountName(((PSWXAccountDTO)linkDTO).getPSWXAccountName());
        } else {
            dto.setPSWXAccountName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXEntAppId())) {
            linkDTO = (PSWXEntAppDTO)PSModelServiceUtil.getInstance().getPSWXEntAppService().getDTO(dto.getPSWXEntAppId());
            dto.setPSWXEntAppName(((PSWXEntAppDTO)linkDTO).getPSWXEntAppName());
        } else {
            dto.setPSWXEntAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXMenuFuncId())) {
            linkDTO = (PSWXMenuFuncDTO)PSModelServiceUtil.getInstance().getPSWXMenuFuncService().getDTO(dto.getPSWXMenuFuncId());
            dto.setPSWXMenuFuncName(((PSWXMenuFuncDTO)linkDTO).getPSWXMenuFuncName());
        } else {
            dto.setPSWXMenuFuncName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSWXLOGIC";
    }

    @Override
    public PSWXLogic createDomain() {
        return new PSWXLogic();
    }

    @Override
    public PSWXLogicDTO createDTO() {
        return new PSWXLogicDTO();
    }
}

