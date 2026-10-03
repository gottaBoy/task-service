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
import net.ibizsys.modelapi.domain.PSAppWF;
import net.ibizsys.modelapi.domain.PSAppWFVer;
import net.ibizsys.modelapi.dto.PSAppWFDTO;
import net.ibizsys.modelapi.dto.PSAppWFVerDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.service.IPSAppWFVerService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppWFVerServiceImpl
extends PSModelServiceImplBase<PSAppWFVer, PSAppWFVerDTO>
implements IPSAppWFVerService {
    private static final Log log = LogFactory.getLog(PSAppWFVerServiceImpl.class);

    @Override
    public List<PSAppWFVer> listByPSAppWF(PSAppWF parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppWFVer get(PSAppWF parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppWFVer> list = this.listByPSAppWF(parent);
        if (list != null) {
            for (PSAppWFVer item : list) {
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
    public List<PSAppWFVerDTO> listDTOByPSAppWF(String strParentKey) throws Exception {
        PSAppWF psappwf = (PSAppWF)PSModelServiceUtil.getInstance().getPSAppWFService().get(strParentKey);
        List<PSAppWFVer> list = this.listByPSAppWF(psappwf);
        if (list != null) {
            ArrayList<PSAppWFVerDTO> dtoList = new ArrayList<PSAppWFVerDTO>();
            for (PSAppWFVer item : list) {
                PSAppWFVerDTO dto = (PSAppWFVerDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppWFVer> onListAll() throws Exception {
        ArrayList<PSAppWFVer> list = new ArrayList<PSAppWFVer>();
        List<PSAppWF> psappwfs = PSModelServiceUtil.getInstance().getPSAppWFService().listAll();
        if (psappwfs != null) {
            for (PSAppWF parent : psappwfs) {
                List<PSAppWFVer> items = this.listByPSAppWF(parent);
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
    protected PSAppWFVer onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppWFVer item;
        PSAppWF psappwf = (PSAppWF)PSModelServiceUtil.getInstance().getPSAppWFService().get(strParentKey, true);
        if (psappwf != null && (item = this.get(psappwf, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppWFVer)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppWFVerDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSAppWFId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppWFService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppWFVer et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppWFVerName())) {
            return et.getPSAppWFVerName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppWFVerDTO dto, PSAppWFVer t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppWFVerId(t.getId().replace("/", "."));
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
        if (t.getPSAppWFId() != null || !bIgnoreNull) {
            dto.setPSAppWFId(t.getPSAppWFId());
        }
        if (t.getPSAppWFName() != null || !bIgnoreNull) {
            dto.setPSAppWFName(t.getPSAppWFName());
        }
        if (t.getPSAppWFVerName() != null || !bIgnoreNull) {
            dto.setPSAppWFVerName(t.getPSAppWFVerName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getPSWorkflowId() != null || !bIgnoreNull) {
            dto.setPSWorkflowId(t.getPSWorkflowId());
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
        if (StringUtils.hasLength((String)dto.getPSAppWFId())) {
            dto.setPSAppWFId(this.getRealPSModelId(t, dto.getPSAppWFId()).replace("/", "."));
        }
        if ("PSAPPWF".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppWFId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppWFId())) {
            linkDTO = (PSAppWFDTO)PSModelServiceUtil.getInstance().getPSAppWFService().getDTO(dto.getPSAppWFId());
            dto.setPSAppWFName(((PSAppWFDTO)linkDTO).getPSAppWFName());
        } else {
            dto.setPSAppWFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId(), true);
            if (linkDTO != null) {
                dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
            }
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
            dto.setPSWorkflowId(((PSWFVersionDTO)linkDTO).getPSWFId());
        } else {
            dto.setPSWFVersionName(null);
            dto.setPSWorkflowId(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPWFVER";
    }

    @Override
    public PSAppWFVer createDomain() {
        return new PSAppWFVer();
    }

    @Override
    public PSAppWFVerDTO createDTO() {
        return new PSAppWFVerDTO();
    }
}

