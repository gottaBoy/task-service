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
import net.ibizsys.modelapi.domain.PSAppUtilPage;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUtilPageDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppUtilPageService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppUtilPageServiceImpl
extends PSModelServiceImplBase<PSAppUtilPage, PSAppUtilPageDTO>
implements IPSAppUtilPageService {
    private static final Log log = LogFactory.getLog(PSAppUtilPageServiceImpl.class);

    @Override
    public List<PSAppUtilPage> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppUtilPage get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppUtilPage> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppUtilPage item : list) {
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
    public List<PSAppUtilPageDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppUtilPage> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppUtilPageDTO> dtoList = new ArrayList<PSAppUtilPageDTO>();
            for (PSAppUtilPage item : list) {
                PSAppUtilPageDTO dto = (PSAppUtilPageDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppUtilPage> onListAll() throws Exception {
        ArrayList<PSAppUtilPage> list = new ArrayList<PSAppUtilPage>();
        List<PSSysApp> pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppUtilPage> items = this.listByPSSysApp(parent);
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
    protected PSAppUtilPage onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppUtilPage item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppUtilPage)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppUtilPageDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppUtilPage et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppUtilPageName())) {
            return et.getPSAppUtilPageName();
        }
        if (StringUtils.hasLength((String)et.getPSAppUtilPageName())) {
            return et.getPSAppUtilPageName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppUtilPageDTO dto, PSAppUtilPage t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppUtilPageId(t.getId().replace("/", "."));
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
        if (t.getPageUrl() != null || !bIgnoreNull) {
            dto.setPageUrl(t.getPageUrl());
        }
        if (t.getPSAppUtilPageName() != null || !bIgnoreNull) {
            dto.setPSAppUtilPageName(t.getPSAppUtilPageName());
        }
        if (t.getPSAppViewId() != null || !bIgnoreNull) {
            dto.setPSAppViewId(t.getPSAppViewId());
        }
        if (t.getPSAppViewName() != null || !bIgnoreNull) {
            dto.setPSAppViewName(t.getPSAppViewName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getTargetType() != null || !bIgnoreNull) {
            dto.setTargetType(t.getTargetType());
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
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            linkDTO = (PSAppViewDTO)PSModelServiceUtil.getInstance().getPSAppViewService().getDTO(dto.getPSAppViewId());
            dto.setPSAppViewName(((PSAppViewDTO)linkDTO).getPSAppViewName());
        } else {
            dto.setPSAppViewName(null);
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
        return "PSAPPUTILPAGE";
    }

    @Override
    public PSAppUtilPage createDomain() {
        return new PSAppUtilPage();
    }

    @Override
    public PSAppUtilPageDTO createDTO() {
        return new PSAppUtilPageDTO();
    }
}

