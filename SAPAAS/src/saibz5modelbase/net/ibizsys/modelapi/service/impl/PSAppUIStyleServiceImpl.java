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
import net.ibizsys.modelapi.domain.PSAppUIStyle;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUIStyleDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppUIStyleService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppUIStyleServiceImpl
extends PSModelServiceImplBase<PSAppUIStyle, PSAppUIStyleDTO>
implements IPSAppUIStyleService {
    private static final Log log = LogFactory.getLog(PSAppUIStyleServiceImpl.class);

    @Override
    public List<PSAppUIStyle> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppUIStyle get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppUIStyle> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppUIStyle item : list) {
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
    public List<PSAppUIStyleDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppUIStyle> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppUIStyleDTO> dtoList = new ArrayList<PSAppUIStyleDTO>();
            for (PSAppUIStyle item : list) {
                PSAppUIStyleDTO dto = (PSAppUIStyleDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppUIStyle> onListAll() throws Exception {
        ArrayList<PSAppUIStyle> list = new ArrayList<PSAppUIStyle>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppUIStyle> items = this.listByPSSysApp(parent);
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
    protected PSAppUIStyle onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppUIStyle item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppUIStyle)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppUIStyleDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppUIStyle et) throws Exception {
        if (StringUtils.hasLength((String)et.getAppPKGName())) {
            return et.getAppPKGName();
        }
        if (StringUtils.hasLength((String)et.getUIStyle())) {
            return et.getUIStyle();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppUIStyleDTO dto, PSAppUIStyle t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppUIStyleId(t.getId().replace("/", "."));
        }
        if (t.getACMinChars() != null || !bIgnoreNull) {
            dto.setACMinChars(t.getACMinChars());
        }
        if (t.getAppFolder() != null || !bIgnoreNull) {
            dto.setAppFolder(t.getAppFolder());
        }
        if (t.getAppPKGName() != null || !bIgnoreNull) {
            dto.setAppPKGName(t.getAppPKGName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMainMenuSide() != null || !bIgnoreNull) {
            dto.setMainMenuSide(t.getMainMenuSide());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPFStyleParam() != null || !bIgnoreNull) {
            dto.setPFStyleParam(t.getPFStyleParam());
        }
        if (t.getPSAppUIStyleName() != null || !bIgnoreNull) {
            dto.setPSAppUIStyleName(t.getPSAppUIStyleName());
        }
        if (t.getPSPFId() != null || !bIgnoreNull) {
            dto.setPSPFId(t.getPSPFId());
        }
        if (t.getPSPFName() != null || !bIgnoreNull) {
            dto.setPSPFName(t.getPSPFName());
        }
        if (t.getPSPFStyleId() != null || !bIgnoreNull) {
            dto.setPSPFStyleId(t.getPSPFStyleId());
        }
        if (t.getPSPFStyleName() != null || !bIgnoreNull) {
            dto.setPSPFStyleName(t.getPSPFStyleName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getRootPSAppViewId() != null || !bIgnoreNull) {
            dto.setRootPSAppViewId(t.getRootPSAppViewId());
        }
        if (t.getRootPSAppViewName() != null || !bIgnoreNull) {
            dto.setRootPSAppViewName(t.getRootPSAppViewName());
        }
        if (t.getUIStyle() != null || !bIgnoreNull) {
            dto.setUIStyle(t.getUIStyle());
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
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getRootPSAppViewId())) {
            dto.setRootPSAppViewId(this.getRealPSModelId(t, dto.getRootPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getRootPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getRootPSAppViewId());
            dto.setRootPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setRootPSAppViewName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPUISTYLE";
    }

    @Override
    public PSAppUIStyle createDomain() {
        return new PSAppUIStyle();
    }

    @Override
    public PSAppUIStyleDTO createDTO() {
        return new PSAppUIStyleDTO();
    }
}

