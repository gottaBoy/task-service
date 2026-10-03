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
import net.ibizsys.modelapi.domain.PSAppWF;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppModuleDTO;
import net.ibizsys.modelapi.dto.PSAppWFDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.service.IPSAppWFService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppWFServiceImpl
extends PSModelServiceImplBase<PSAppWF, PSAppWFDTO>
implements IPSAppWFService {
    private static final Log log = LogFactory.getLog(PSAppWFServiceImpl.class);

    @Override
    public List<PSAppWF> listByPSAppModule(PSAppModule parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppWF get(PSAppModule parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppWF> list = this.listByPSAppModule(parent);
        if (list != null) {
            for (PSAppWF item : list) {
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
    public List<PSAppWFDTO> listDTOByPSAppModule(String strParentKey) throws Exception {
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey);
        List<PSAppWF> list = this.listByPSAppModule(psappmodule);
        if (list != null) {
            ArrayList<PSAppWFDTO> dtoList = new ArrayList<PSAppWFDTO>();
            for (PSAppWF item : list) {
                PSAppWFDTO dto = (PSAppWFDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSAppWF> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppWF get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppWF> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppWF item : list) {
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
    public List<PSAppWFDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppWF> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppWFDTO> dtoList = new ArrayList<PSAppWFDTO>();
            for (PSAppWF item : list) {
                PSAppWFDTO dto = (PSAppWFDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppWF> onListAll() throws Exception {
        List<PSSysApp> pssysapps;
        ArrayList<PSAppWF> list = new ArrayList<PSAppWF>();
        List<PSAppModule> psappmodules = PSModelServiceUtil.getInstance().getPSAppModuleService().listAll();
        if (psappmodules != null) {
            for (PSAppModule parent : psappmodules) {
                List<PSAppWF> items = this.listByPSAppModule(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll()) != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppWF> items = this.listByPSSysApp(parent);
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
    protected PSAppWF onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppWF item;
        PSAppWF item2;
        PSAppModule psappmodule = (PSAppModule)PSModelServiceUtil.getInstance().getPSAppModuleService().get(strParentKey, true);
        if (psappmodule != null && (item2 = this.get(psappmodule, strCurKey, true)) != null) {
            return item2;
        }
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppWF)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppWFDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSAppModuleId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppModuleService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppWF et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSAppWFName())) {
            return et.getPSAppWFName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppWFDTO dto, PSAppWF t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppWFId(t.getId().replace("/", "."));
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
        if (t.getPSAppModuleId() != null || !bIgnoreNull) {
            dto.setPSAppModuleId(t.getPSAppModuleId());
        }
        if (t.getPSAppModuleName() != null || !bIgnoreNull) {
            dto.setPSAppModuleName(t.getPSAppModuleName());
        }
        if (t.getPSAppWFName() != null || !bIgnoreNull) {
            dto.setPSAppWFName(t.getPSAppWFName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSWorkflowId() != null || !bIgnoreNull) {
            dto.setPSWorkflowId(t.getPSWorkflowId());
        }
        if (t.getPSWorkflowName() != null || !bIgnoreNull) {
            dto.setPSWorkflowName(t.getPSWorkflowName());
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
        if (StringUtils.hasLength((String)dto.getPSAppModuleId())) {
            dto.setPSAppModuleId(this.getRealPSModelId(t, dto.getPSAppModuleId()).replace("/", "."));
        }
        if ("PSAPPMODULE".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppModuleId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            dto.setPSWorkflowId(this.getRealPSModelId(t, dto.getPSWorkflowId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppModuleId())) {
            linkDTO = (PSAppModuleDTO)PSModelServiceUtil.getInstance().getPSAppModuleService().getDTO(dto.getPSAppModuleId());
            dto.setPSAppModuleName(((PSAppModuleDTO)linkDTO).getPSAppModuleName());
        } else {
            dto.setPSAppModuleName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWorkflowId())) {
            linkDTO = (PSWorkflowDTO)PSModelServiceUtil.getInstance().getPSWorkflowService().getDTO(dto.getPSWorkflowId());
            dto.setPSWorkflowName(((PSWorkflowDTO)linkDTO).getPSWorkflowName());
        } else {
            dto.setPSWorkflowName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPWF";
    }

    @Override
    public PSAppWF createDomain() {
        return new PSAppWF();
    }

    @Override
    public PSAppWFDTO createDTO() {
        return new PSAppWFDTO();
    }
}

