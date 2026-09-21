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
import net.ibizsys.modelapi.domain.PSAppPortlet;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.dto.PSAppPortletDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysPortletDTO;
import net.ibizsys.modelapi.service.IPSAppPortletService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppPortletServiceImpl
extends PSModelServiceImplBase<PSAppPortlet, PSAppPortletDTO>
implements IPSAppPortletService {
    private static final Log log = LogFactory.getLog(PSAppPortletServiceImpl.class);

    @Override
    public List<PSAppPortlet> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppPortlet get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppPortlet> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppPortlet item : list) {
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
    public List<PSAppPortletDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppPortlet> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppPortletDTO> dtoList = new ArrayList<PSAppPortletDTO>();
            for (PSAppPortlet item : list) {
                PSAppPortletDTO dto = (PSAppPortletDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppPortlet> onListAll() throws Exception {
        ArrayList<PSAppPortlet> list = new ArrayList<PSAppPortlet>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppPortlet> items = this.listByPSSysApp(parent);
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
    protected PSAppPortlet onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppPortlet item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppPortlet)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppPortletDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppPortlet et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppPortletName())) {
            return et.getPSAppPortletName();
        }
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppPortletDTO dto, PSAppPortlet t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppPortletId(t.getId().replace("/", "."));
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
        if (t.getPSAppLocalDEId() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEId(t.getPSAppLocalDEId());
        }
        if (t.getPSAppLocalDEName() != null || !bIgnoreNull) {
            dto.setPSAppLocalDEName(t.getPSAppLocalDEName());
        }
        if (t.getPSAppPortletName() != null || !bIgnoreNull) {
            dto.setPSAppPortletName(t.getPSAppPortletName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysPortletId() != null || !bIgnoreNull) {
            dto.setPSSysPortletId(t.getPSSysPortletId());
        }
        if (t.getPSSysPortletName() != null || !bIgnoreNull) {
            dto.setPSSysPortletName(t.getPSSysPortletName());
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
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            dto.setPSAppLocalDEId(this.getRealPSModelId(t, dto.getPSAppLocalDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            dto.setPSSysPortletId(this.getRealPSModelId(t, dto.getPSSysPortletId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppLocalDEId())) {
            linkDTO = (PSAppLocalDEDTO)PSModelServiceUtil.getInstance().getPSAppLocalDEService().getDTO(dto.getPSAppLocalDEId());
            dto.setPSAppLocalDEName(((PSAppLocalDEDTO)linkDTO).getPSAppLocalDEName());
        } else {
            dto.setPSAppLocalDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPortletId())) {
            linkDTO = (PSSysPortletDTO)PSModelServiceUtil.getInstance().getPSSysPortletService().getDTO(dto.getPSSysPortletId());
            dto.setPSSysPortletName(((PSSysPortletDTO)linkDTO).getPSSysPortletName());
        } else {
            dto.setPSSysPortletName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPPORTLET";
    }

    @Override
    public PSAppPortlet createDomain() {
        return new PSAppPortlet();
    }

    @Override
    public PSAppPortletDTO createDTO() {
        return new PSAppPortletDTO();
    }
}

