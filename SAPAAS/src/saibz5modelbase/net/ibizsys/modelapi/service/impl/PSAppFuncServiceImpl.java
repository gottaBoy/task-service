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
import net.ibizsys.modelapi.domain.PSAppFunc;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppFuncDTO;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.service.IPSAppFuncService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppFuncServiceImpl
extends PSModelServiceImplBase<PSAppFunc, PSAppFuncDTO>
implements IPSAppFuncService {
    private static final Log log = LogFactory.getLog(PSAppFuncServiceImpl.class);

    @Override
    public List<PSAppFunc> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppFunc get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppFunc> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppFunc item : list) {
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
    public List<PSAppFuncDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppFunc> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppFuncDTO> dtoList = new ArrayList<PSAppFuncDTO>();
            for (PSAppFunc item : list) {
                PSAppFuncDTO dto = (PSAppFuncDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppFunc> onListAll() throws Exception {
        ArrayList<PSAppFunc> list = new ArrayList<PSAppFunc>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppFunc> items = this.listByPSSysApp(parent);
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
    protected PSAppFunc onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppFunc item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppFunc)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppFuncDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppFunc et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppFuncDTO dto, PSAppFunc t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppFuncId(t.getId().replace("/", "."));
        }
        if (t.getAppFuncType() != null || !bIgnoreNull) {
            dto.setAppFuncType(t.getAppFuncType());
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
        if (t.getDynaInstTag() != null || !bIgnoreNull) {
            dto.setDynaInstTag(t.getDynaInstTag());
        }
        if (t.getDynaInstTag2() != null || !bIgnoreNull) {
            dto.setDynaInstTag2(t.getDynaInstTag2());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getFromObjId() != null || !bIgnoreNull) {
            dto.setFromObjId(t.getFromObjId());
        }
        if (t.getFuncSN() != null || !bIgnoreNull) {
            dto.setFuncSN(t.getFuncSN());
        }
        if (t.getJSCode() != null || !bIgnoreNull) {
            dto.setJSCode(t.getJSCode());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getNamePSLanResId() != null || !bIgnoreNull) {
            dto.setNamePSLanResId(t.getNamePSLanResId());
        }
        if (t.getNamePSLanResName() != null || !bIgnoreNull) {
            dto.setNamePSLanResName(t.getNamePSLanResName());
        }
        if (t.getOpenMode() != null || !bIgnoreNull) {
            dto.setOpenMode(t.getOpenMode());
        }
        if (t.getOpenViewParam() != null || !bIgnoreNull) {
            dto.setOpenViewParam(t.getOpenViewParam());
        }
        if (t.getPageUrl() != null || !bIgnoreNull) {
            dto.setPageUrl(t.getPageUrl());
        }
        if (t.getPSAppFuncName() != null || !bIgnoreNull) {
            dto.setPSAppFuncName(t.getPSAppFuncName());
        }
        if (t.getPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEId(t.getPSAppLocalDEId());
        }
        if (t.getPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEName(t.getPSAppLocalDEName());
        }
        if (t.getPSAppSubAppId() != null || !bIgnoreNull) {
            dto.setPSAppSubAppId(t.getPSAppSubAppId());
        }
        if (t.getPSAppSubAppName() != null || !bIgnoreNull) {
            dto.setPSAppSubAppName(t.getPSAppSubAppName());
        }
        if (t.getPSAppViewId() != null || !bIgnoreNull) {
            dto.setPSAppViewId(t.getPSAppViewId());
        }
        if (t.getPSAppViewName() != null || !bIgnoreNull) {
            dto.setPSAppViewName(t.getPSAppViewName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEUIActionId() != null || !bIgnoreNull) {
            dto.setPSDEUIActionId(t.getPSDEUIActionId());
        }
        if (t.getPSDEUIActionName() != null || !bIgnoreNull) {
            dto.setPSDEUIActionName(t.getPSDEUIActionName());
        }
        if (t.getPSDynaAppId() != null || !bIgnoreNull) {
            dto.setPSDynaAppId(t.getPSDynaAppId());
        }
        if (t.getPSDynaAppName() != null || !bIgnoreNull) {
            dto.setPSDynaAppName(t.getPSDynaAppName());
        }
        if (t.getPSPDTAppFuncId() != null || !bIgnoreNull) {
            dto.setPSPDTAppFuncId(t.getPSPDTAppFuncId());
        }
        if (t.getPSPDTAppFuncName() != null || !bIgnoreNull) {
            dto.setPSPDTAppFuncName(t.getPSPDTAppFuncName());
        }
        if (t.getPSSubAppId() != null || !bIgnoreNull) {
            dto.setPSSubAppId(t.getPSSubAppId());
        }
        if (t.getPSSubAppName() != null || !bIgnoreNull) {
            dto.setPSSubAppName(t.getPSSubAppName());
        }
        if (t.getPSSubAppViewId() != null || !bIgnoreNull) {
            dto.setPSSubAppViewId(t.getPSSubAppViewId());
        }
        if (t.getPSSubAppViewName() != null || !bIgnoreNull) {
            dto.setPSSubAppViewName(t.getPSSubAppViewName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getSystemFlag() != null || !bIgnoreNull) {
            dto.setSystemFlag(t.getSystemFlag());
        }
        if (t.getTipPSLanResId() != null || !bIgnoreNull) {
            dto.setTipPSLanResId(t.getTipPSLanResId());
        }
        if (t.getTipPSLanResName() != null || !bIgnoreNull) {
            dto.setTipPSLanResName(t.getTipPSLanResName());
        }
        if (t.getTooltipInfo() != null || !bIgnoreNull) {
            dto.setTooltipInfo(t.getTooltipInfo());
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
        if (t.getUserData() != null || !bIgnoreNull) {
            dto.setUserData(t.getUserData());
        }
        if (t.getUserData2() != null || !bIgnoreNull) {
            dto.setUserData2(t.getUserData2());
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
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            dto.setNamePSLanResId(this.getRealPSModelId(t, dto.getNamePSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            dto.setPSAppLocalDEId(this.getRealPSModelId(t, dto.getPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            dto.setPSDEUIActionId(this.getRealPSModelId(t, dto.getPSDEUIActionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            dto.setTipPSLanResId(this.getRealPSModelId(t, dto.getTipPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getNamePSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getNamePSLanResId());
            dto.setNamePSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setNamePSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPSAppLocalDEId());
            dto.setPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
            dto.setPSDEId(((PSAppLocalDEDTO)linkDTO).getPSDEId());
        } else {
            dto.setPSAppLocalDEName(null);
            dto.setPSDEId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getPSAppViewId());
            dto.setPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setPSAppViewName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEUIActionId())) {
            linkDTO = (PSDEUIActionDTO)PSModelServiceUtil.getInstance().getPSDEUIActionService().getDTO(dto.getPSDEUIActionId());
            dto.setPSDEUIActionName(((PSDEUIActionDTO)linkDTO).getPSDEUIActionName());
        } else {
            dto.setPSDEUIActionName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId());
            dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getTipPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getTipPSLanResId());
            dto.setTipPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setTipPSLanResName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPFUNC";
    }

    @Override
    public PSAppFunc createDomain() {
        return new PSAppFunc();
    }

    @Override
    public PSAppFuncDTO createDTO() {
        return new PSAppFuncDTO();
    }
}

