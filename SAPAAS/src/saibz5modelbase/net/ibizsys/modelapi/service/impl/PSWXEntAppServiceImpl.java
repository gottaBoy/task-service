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
import net.ibizsys.modelapi.domain.PSWXEntApp;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSWXAccountDTO;
import net.ibizsys.modelapi.dto.PSWXEntAppDTO;
import net.ibizsys.modelapi.service.IPSWXEntAppService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWXEntAppServiceImpl
extends PSModelServiceImplBase<PSWXEntApp, PSWXEntAppDTO>
implements IPSWXEntAppService {
    private static final Log log = LogFactory.getLog(PSWXEntAppServiceImpl.class);

    @Override
    public List<PSWXEntApp> listByPSWXAccount(PSWXAccount parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXEntApp get(PSWXAccount parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXEntApp> list = this.listByPSWXAccount(parent);
        if (list != null) {
            for (PSWXEntApp item : list) {
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
    public List<PSWXEntAppDTO> listDTOByPSWXAccount(String strParentKey) throws Exception {
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey);
        List<PSWXEntApp> list = this.listByPSWXAccount(pswxaccount);
        if (list != null) {
            ArrayList<PSWXEntAppDTO> dtoList = new ArrayList<PSWXEntAppDTO>();
            for (PSWXEntApp item : list) {
                PSWXEntAppDTO dto = (PSWXEntAppDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWXEntApp> onListAll() throws Exception {
        ArrayList<PSWXEntApp> list = new ArrayList<PSWXEntApp>();
        List<PSWXAccount> pswxaccounts = PSModelServiceUtil.getInstance().getPSWXAccountService().listAll();
        if (pswxaccounts != null) {
            for (PSWXAccount parent : pswxaccounts) {
                List<PSWXEntApp> items = this.listByPSWXAccount(parent);
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
    protected PSWXEntApp onGet(String strParentKey, String strCurKey) throws Exception {
        PSWXEntApp item;
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey, true);
        if (pswxaccount != null && (item = this.get(pswxaccount, strCurKey, true)) != null) {
            return item;
        }
        return (PSWXEntApp)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWXEntAppDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWXAccountId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXAccountService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWXEntApp et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWXEntAppDTO dto, PSWXEntApp t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWXEntAppId(t.getId().replace("/", "."));
        }
        if (t.getAppType() != null || !bIgnoreNull) {
            dto.setAppType(t.getAppType());
        }
        if (t.getAppUrl() != null || !bIgnoreNull) {
            dto.setAppUrl(t.getAppUrl());
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
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSWXAccountId() != null || !bIgnoreNull) {
            dto.setPSWXAccountId(t.getPSWXAccountId());
        }
        if (t.getPSWXAccountName() != null || !bIgnoreNull) {
            dto.setPSWXAccountName(t.getPSWXAccountName());
        }
        if (t.getPSWXEntAppName() != null || !bIgnoreNull) {
            dto.setPSWXEntAppName(t.getPSWXEntAppName());
        }
        if (t.getRepEnterFlag() != null || !bIgnoreNull) {
            dto.setRepEnterFlag(t.getRepEnterFlag());
        }
        if (t.getRepLocationFlag() != null || !bIgnoreNull) {
            dto.setRepLocationFlag(t.getRepLocationFlag());
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
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            dto.setPSWXAccountId(this.getRealPSModelId(t, dto.getPSWXAccountId()).replace("/", "."));
        }
        if ("PSWXACCOUNT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWXAccountId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            linkDTO = (PSWXAccountDTO)PSModelServiceUtil.getInstance().getPSWXAccountService().getDTO(dto.getPSWXAccountId());
            dto.setPSWXAccountName(((PSWXAccountDTO)linkDTO).getPSWXAccountName());
        } else {
            dto.setPSWXAccountName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSWXENTAPP";
    }

    @Override
    public PSWXEntApp createDomain() {
        return new PSWXEntApp();
    }

    @Override
    public PSWXEntAppDTO createDTO() {
        return new PSWXEntAppDTO();
    }
}

