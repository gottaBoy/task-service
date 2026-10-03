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
import net.ibizsys.modelapi.domain.PSAppResource;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppResourceDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppResourceService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppResourceServiceImpl
extends PSModelServiceImplBase<PSAppResource, PSAppResourceDTO>
implements IPSAppResourceService {
    private static final Log log = LogFactory.getLog(PSAppResourceServiceImpl.class);

    @Override
    public List<PSAppResource> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppResource get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppResource> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppResource item : list) {
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
    public List<PSAppResourceDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppResource> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppResourceDTO> dtoList = new ArrayList<PSAppResourceDTO>();
            for (PSAppResource item : list) {
                PSAppResourceDTO dto = (PSAppResourceDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppResource> onListAll() throws Exception {
        ArrayList<PSAppResource> list = new ArrayList<PSAppResource>();
        List<PSSysApp> pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppResource> items = this.listByPSSysApp(parent);
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
    protected PSAppResource onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppResource item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppResource)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppResourceDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppResource et) throws Exception {
        if (StringUtils.hasLength((String)et.getResTag())) {
            return et.getResTag();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppResourceDTO dto, PSAppResource t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppResourceId(t.getId().replace("/", "."));
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getContentPSLanResId() != null || !bIgnoreNull) {
            dto.setContentPSLanResId(t.getContentPSLanResId());
        }
        if (t.getContentPSLanResName() != null || !bIgnoreNull) {
            dto.setContentPSLanResName(t.getContentPSLanResName());
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
        if (t.getPSAppResourceName() != null || !bIgnoreNull) {
            dto.setPSAppResourceName(t.getPSAppResourceName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getResourceType() != null || !bIgnoreNull) {
            dto.setResourceType(t.getResourceType());
        }
        if (t.getResTag() != null || !bIgnoreNull) {
            dto.setResTag(t.getResTag());
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
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            dto.setContentPSLanResId(this.getRealPSModelId(t, dto.getContentPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getContentPSLanResId());
            dto.setContentPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setContentPSLanResName(null);
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
        return "PSAPPRESOURCE";
    }

    @Override
    public PSAppResource createDomain() {
        return new PSAppResource();
    }

    @Override
    public PSAppResourceDTO createDTO() {
        return new PSAppResourceDTO();
    }
}

