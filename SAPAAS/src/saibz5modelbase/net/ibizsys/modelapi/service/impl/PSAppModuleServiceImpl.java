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
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppMenuDTO;
import net.ibizsys.modelapi.dto.PSAppModuleDTO;
import net.ibizsys.modelapi.dto.PSModuleDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppModuleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppModuleServiceImpl
extends PSModelServiceImplBase<PSAppModule, PSAppModuleDTO>
implements IPSAppModuleService {
    private static final Log log = LogFactory.getLog(PSAppModuleServiceImpl.class);

    @Override
    public List<PSAppModule> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppModule get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppModule> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppModule item : list) {
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
    public List<PSAppModuleDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppModule> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppModuleDTO> dtoList = new ArrayList<PSAppModuleDTO>();
            for (PSAppModule item : list) {
                PSAppModuleDTO dto = (PSAppModuleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppModule> onListAll() throws Exception {
        ArrayList<PSAppModule> list = new ArrayList<PSAppModule>();
        List<PSSysApp> pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppModule> items = this.listByPSSysApp(parent);
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
    protected PSAppModule onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppModule item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppModule)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppModuleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppModule et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppModuleDTO dto, PSAppModule t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppModuleId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getColor() != null || !bIgnoreNull) {
            dto.setColor(t.getColor());
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
        if (t.getEnableModuleStyle() != null || !bIgnoreNull) {
            dto.setEnableModuleStyle(t.getEnableModuleStyle());
        }
        if (t.getFromObjId() != null || !bIgnoreNull) {
            dto.setFromObjId(t.getFromObjId());
        }
        if (t.getMainMenuSide() != null || !bIgnoreNull) {
            dto.setMainMenuSide(t.getMainMenuSide());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getModuleSN() != null || !bIgnoreNull) {
            dto.setModuleSN(t.getModuleSN());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSAppMenuId() != null || !bIgnoreNull) {
            dto.setPSAppMenuId(t.getPSAppMenuId());
        }
        if (t.getPSAppMenuName() != null || !bIgnoreNull) {
            dto.setPSAppMenuName(t.getPSAppMenuName());
        }
        if (t.getPSAppModuleName() != null || !bIgnoreNull) {
            dto.setPSAppModuleName(t.getPSAppModuleName());
        }
        if (t.getPSModuleId() != null || !bIgnoreNull) {
            dto.setPSModuleId(t.getPSModuleId());
        }
        if (t.getPSModuleName() != null || !bIgnoreNull) {
            dto.setPSModuleName(t.getPSModuleName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            dto.setPSAppMenuId(this.getRealPSModelId(t, dto.getPSAppMenuId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            dto.setPSModuleId(this.getRealPSModelId(t, dto.getPSModuleId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppMenuId())) {
            linkDTO = (PSAppMenuDTO)PSModelServiceUtil.getInstance().getPSAppMenuService().getDTO(dto.getPSAppMenuId());
            dto.setPSAppMenuName(((PSAppMenuDTO)linkDTO).getPSAppMenuName());
        } else {
            dto.setPSAppMenuName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSModuleId())) {
            linkDTO = (PSModuleDTO)PSModelServiceUtil.getInstance().getPSModuleService().getDTO(dto.getPSModuleId());
            dto.setPSModuleName(((PSModuleDTO)linkDTO).getPSModuleName());
        } else {
            dto.setPSModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPMODULE";
    }

    @Override
    public PSAppModule createDomain() {
        return new PSAppModule();
    }

    @Override
    public PSAppModuleDTO createDTO() {
        return new PSAppModuleDTO();
    }
}

