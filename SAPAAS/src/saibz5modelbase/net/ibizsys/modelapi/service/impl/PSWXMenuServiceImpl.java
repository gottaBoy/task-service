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
import net.ibizsys.modelapi.domain.PSWXMenu;
import net.ibizsys.modelapi.domain.PSWXMenuItem;
import net.ibizsys.modelapi.dto.PSWXAccountDTO;
import net.ibizsys.modelapi.dto.PSWXEntAppDTO;
import net.ibizsys.modelapi.dto.PSWXMenuDTO;
import net.ibizsys.modelapi.dto.PSWXMenuItemDTO;
import net.ibizsys.modelapi.service.IPSWXMenuService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWXMenuServiceImpl
extends PSModelServiceImplBase<PSWXMenu, PSWXMenuDTO>
implements IPSWXMenuService {
    private static final Log log = LogFactory.getLog(PSWXMenuServiceImpl.class);

    @Override
    public List<PSWXMenu> listByPSWXEntApp(PSWXEntApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXMenu get(PSWXEntApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXMenu> list = this.listByPSWXEntApp(parent);
        if (list != null) {
            for (PSWXMenu item : list) {
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
    public List<PSWXMenuDTO> listDTOByPSWXEntApp(String strParentKey) throws Exception {
        PSWXEntApp pswxentapp = (PSWXEntApp)PSModelServiceUtil.getInstance().getPSWXEntAppService().get(strParentKey);
        List<PSWXMenu> list = this.listByPSWXEntApp(pswxentapp);
        if (list != null) {
            ArrayList<PSWXMenuDTO> dtoList = new ArrayList<PSWXMenuDTO>();
            for (PSWXMenu item : list) {
                PSWXMenuDTO dto = (PSWXMenuDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWXMenu> listByPSWXAccount(PSWXAccount parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWXMenu get(PSWXAccount parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWXMenu> list = this.listByPSWXAccount(parent);
        if (list != null) {
            for (PSWXMenu item : list) {
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
    public List<PSWXMenuDTO> listDTOByPSWXAccount(String strParentKey) throws Exception {
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey);
        List<PSWXMenu> list = this.listByPSWXAccount(pswxaccount);
        if (list != null) {
            ArrayList<PSWXMenuDTO> dtoList = new ArrayList<PSWXMenuDTO>();
            for (PSWXMenu item : list) {
                PSWXMenuDTO dto = (PSWXMenuDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWXMenu> onListAll() throws Exception {
        List<PSWXAccount> pswxaccounts;
        ArrayList<PSWXMenu> list = new ArrayList<PSWXMenu>();
        List<PSWXEntApp> pswxentapps = PSModelServiceUtil.getInstance().getPSWXEntAppService().listAll();
        if (pswxentapps != null) {
            for (PSWXEntApp parent : pswxentapps) {
                List<PSWXMenu> items = this.listByPSWXEntApp(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pswxaccounts = PSModelServiceUtil.getInstance().getPSWXAccountService().listAll()) != null) {
            for (PSWXAccount parent : pswxaccounts) {
                List<PSWXMenu> items = this.listByPSWXAccount(parent);
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
    protected PSWXMenu onGet(String strParentKey, String strCurKey) throws Exception {
        PSWXMenu item;
        PSWXMenu item2;
        PSWXEntApp pswxentapp = (PSWXEntApp)PSModelServiceUtil.getInstance().getPSWXEntAppService().get(strParentKey, true);
        if (pswxentapp != null && (item2 = this.get(pswxentapp, strCurKey, true)) != null) {
            return item2;
        }
        PSWXAccount pswxaccount = (PSWXAccount)PSModelServiceUtil.getInstance().getPSWXAccountService().get(strParentKey, true);
        if (pswxaccount != null && (item = this.get(pswxaccount, strCurKey, true)) != null) {
            return item;
        }
        return (PSWXMenu)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWXMenuDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSWXEntAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXEntAppService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWXAccountId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWXAccountService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWXMenu et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWXMenuDTO dto, PSWXMenu t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWXMenuId(t.getId().replace("/", "."));
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
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
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
        if (t.getPSWXMenuName() != null || !bIgnoreNull) {
            dto.setPSWXMenuName(t.getPSWXMenuName());
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
        if (StringUtils.hasLength((String)dto.getPSWXAccountId())) {
            dto.setPSWXAccountId(this.getRealPSModelId(t, dto.getPSWXAccountId()).replace("/", "."));
        }
        if ("PSWXACCOUNT".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWXAccountId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWXEntAppId())) {
            dto.setPSWXEntAppId(this.getRealPSModelId(t, dto.getPSWXEntAppId()).replace("/", "."));
        }
        if ("PSWXENTAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWXEntAppId(t.getSrfParent().getId().replace("/", "."));
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
        List<PSWXMenuItem> list = PSModelServiceUtil.getInstance().getPSWXMenuItemService().listByPSWXMenu(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSWXMenuItemDTO> pswxmenuitems = new ArrayList<PSWXMenuItemDTO>();
            for (PSWXMenuItem item : list) {
                PSWXMenuItemDTO dstItem = (PSWXMenuItemDTO)PSModelServiceUtil.getInstance().getPSWXMenuItemService().toDTO(item);
                pswxmenuitems.add(dstItem);
            }
            dto.setPswxmenuitems(pswxmenuitems);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWXMENU";
    }

    @Override
    public PSWXMenu createDomain() {
        return new PSWXMenu();
    }

    @Override
    public PSWXMenuDTO createDTO() {
        return new PSWXMenuDTO();
    }
}

