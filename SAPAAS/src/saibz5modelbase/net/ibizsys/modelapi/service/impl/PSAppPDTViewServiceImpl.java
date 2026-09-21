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
import net.ibizsys.modelapi.domain.PSAppPDTView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppPDTViewDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.service.IPSAppPDTViewService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppPDTViewServiceImpl
extends PSModelServiceImplBase<PSAppPDTView, PSAppPDTViewDTO>
implements IPSAppPDTViewService {
    private static final Log log = LogFactory.getLog(PSAppPDTViewServiceImpl.class);

    @Override
    public List<PSAppPDTView> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppPDTView get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppPDTView> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppPDTView item : list) {
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
    public List<PSAppPDTViewDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppPDTView> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppPDTViewDTO> dtoList = new ArrayList<PSAppPDTViewDTO>();
            for (PSAppPDTView item : list) {
                PSAppPDTViewDTO dto = (PSAppPDTViewDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppPDTView> onListAll() throws Exception {
        ArrayList<PSAppPDTView> list = new ArrayList<PSAppPDTView>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppPDTView> items = this.listByPSSysApp(parent);
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
    protected PSAppPDTView onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppPDTView item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppPDTView)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppPDTViewDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppPDTView et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppPDTViewName())) {
            return et.getPSAppPDTViewName();
        }
        if (StringUtils.hasLength((String)et.getPSSysPDTViewId())) {
            return et.getPSSysPDTViewId();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppPDTViewDTO dto, PSAppPDTView t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppPDTViewId(t.getId().replace("/", "."));
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
        if (t.getPSAppPDTViewName() != null || !bIgnoreNull) {
            dto.setPSAppPDTViewName(t.getPSAppPDTViewName());
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
        if (t.getPSSysPDTViewId() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewId(t.getPSSysPDTViewId());
        }
        if (t.getPSSysPDTViewName() != null || !bIgnoreNull) {
            dto.setPSSysPDTViewName(t.getPSSysPDTViewName());
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
        if (StringUtils.hasLength((String)dto.getPSAppViewId())) {
            dto.setPSAppViewId(this.getRealPSModelId(t, dto.getPSAppViewId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            dto.setPSSysPDTViewId(this.getRealPSModelId(t, dto.getPSSysPDTViewId()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSSysPDTViewId())) {
            linkDTO = (PSSysPDTViewDTO)PSModelServiceUtil.getInstance().getPSSysPDTViewService().getDTO(dto.getPSSysPDTViewId());
            dto.setPSSysPDTViewName(((PSSysPDTViewDTO)linkDTO).getPSSysPDTViewName());
        } else {
            dto.setPSSysPDTViewName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPPDTVIEW";
    }

    @Override
    public PSAppPDTView createDomain() {
        return new PSAppPDTView();
    }

    @Override
    public PSAppPDTViewDTO createDTO() {
        return new PSAppPDTViewDTO();
    }
}

