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
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSAppMenuItem;
import net.ibizsys.modelapi.domain.PSAppMenuLogic;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppMenuItemDTO;
import net.ibizsys.modelapi.dto.PSAppMenuLogicDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysCounterDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSAppMenuService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppMenuServiceImpl
extends PSModelServiceImplBase<PSAppMenu, PSAppMenuDTO>
implements IPSAppMenuService {
    private static final Log log = LogFactory.getLog(PSAppMenuServiceImpl.class);

    @Override
    public List<PSAppMenu> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppMenu get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppMenu> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppMenu item : list) {
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
    public List<PSAppMenuDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppMenu> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppMenuDTO> dtoList = new ArrayList<PSAppMenuDTO>();
            for (PSAppMenu item : list) {
                PSAppMenuDTO dto = (PSAppMenuDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppMenu> onListAll() throws Exception {
        ArrayList<PSAppMenu> list = new ArrayList<PSAppMenu>();
        List<PSSysApp> pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppMenu> items = this.listByPSSysApp(parent);
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
    protected PSAppMenu onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppMenu item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppMenu)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppMenuDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppMenu et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppMenuName())) {
            return et.getPSAppMenuName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppMenuDTO dto, PSAppMenu t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppMenuId(t.getId().replace("/", "."));
        }
        if (t.getAppMenuStyle() != null || !bIgnoreNull) {
            dto.setAppMenuStyle(t.getAppMenuStyle());
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
        if (t.getCustomizedFlag() != null || !bIgnoreNull) {
            dto.setCustomizedFlag(t.getCustomizedFlag());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getFlexAlign() != null || !bIgnoreNull) {
            dto.setFlexAlign(t.getFlexAlign());
        }
        if (t.getFlexDir() != null || !bIgnoreNull) {
            dto.setFlexDir(t.getFlexDir());
        }
        if (t.getFlexVAlign() != null || !bIgnoreNull) {
            dto.setFlexVAlign(t.getFlexVAlign());
        }
        if (t.getFromObjId() != null || !bIgnoreNull) {
            dto.setFromObjId(t.getFromObjId());
        }
        if (t.getJSModel() != null || !bIgnoreNull) {
            dto.setJSModel(t.getJSModel());
        }
        if (t.getLayoutMode() != null || !bIgnoreNull) {
            dto.setLayoutMode(t.getLayoutMode());
        }
        if (t.getLogicName() != null || !bIgnoreNull) {
            dto.setLogicName(t.getLogicName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getMenuSN() != null || !bIgnoreNull) {
            dto.setMenuSN(t.getMenuSN());
        }
        if (t.getOwnerId() != null || !bIgnoreNull) {
            dto.setOwnerId(t.getOwnerId());
        }
        if (t.getOwnerTag() != null || !bIgnoreNull) {
            dto.setOwnerTag(t.getOwnerTag());
        }
        if (t.getOwnerType() != null || !bIgnoreNull) {
            dto.setOwnerType(t.getOwnerType());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSDynaAppId() != null || !bIgnoreNull) {
            dto.setPSDynaAppId(t.getPSDynaAppId());
        }
        if (t.getPSDynaAppName() != null || !bIgnoreNull) {
            dto.setPSDynaAppName(t.getPSDynaAppName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysCounterId() != null || !bIgnoreNull) {
            dto.setPSSysCounterId(t.getPSSysCounterId());
        }
        if (t.getPSSysCounterName() != null || !bIgnoreNull) {
            dto.setPSSysCounterName(t.getPSSysCounterName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPublicFlag() != null || !bIgnoreNull) {
            dto.setPublicFlag(t.getPublicFlag());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            dto.setPSSysCounterId(this.getRealPSModelId(t, dto.getPSSysCounterId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
            dto.setPSSystemId(((PSSysAppDTO)linkDTO).getPSSystemId());
        } else {
            dto.setPSSysAppName(null);
            dto.setPSSystemId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysCounterId())) {
            linkDTO = (PSSysCounterDTO)PSModelServiceUtil.getInstance().getPSSysCounterService().getDTO(dto.getPSSysCounterId());
            dto.setPSSysCounterName(((PSSysCounterDTO)linkDTO).getPSSysCounterName());
        } else {
            dto.setPSSysCounterName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        List<PSAppMenuItem> pSAppMenuItemList = PSModelServiceUtil.getInstance().getPSAppMenuItemService().listByPSAppMenu(t);
        if (pSAppMenuItemList != null && pSAppMenuItemList.size() > 0) {
            ArrayList<PSAppMenuItemDTO> psappmenuitems = new ArrayList<PSAppMenuItemDTO>();
            for (PSAppMenuItem pSAppMenuItem : pSAppMenuItemList) {
                dstItem = (PSAppMenuItemDTO)PSModelServiceUtil.getInstance().getPSAppMenuItemService().toDTO(pSAppMenuItem);
                psappmenuitems.add((PSAppMenuItemDTO)dstItem);
            }
            dto.setPsappmenuitems(psappmenuitems);
        }
        List<PSAppMenuLogic> pSAppMenuLogicList = PSModelServiceUtil.getInstance().getPSAppMenuLogicService().listByPSAppMenu(t);
        if (pSAppMenuLogicList != null && pSAppMenuLogicList.size() > 0) {
            ArrayList<PSAppMenuLogicDTO> psappmenulogics = new ArrayList<PSAppMenuLogicDTO>();
            for (PSAppMenuLogic pSAppMenuLogic : pSAppMenuLogicList) {
                dstItem = (PSAppMenuLogicDTO)PSModelServiceUtil.getInstance().getPSAppMenuLogicService().toDTO(pSAppMenuLogic);
                psappmenulogics.add((PSAppMenuLogicDTO)dstItem);
            }
            dto.setPsappmenulogics(psappmenulogics);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPMENU";
    }

    @Override
    public PSAppMenu createDomain() {
        return new PSAppMenu();
    }

    @Override
    public PSAppMenuDTO createDTO() {
        return new PSAppMenuDTO();
    }
}

