/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSAppDEView;
import net.ibizsys.modelapi.domain.PSAppDynaDEView;
import net.ibizsys.modelapi.domain.PSAppIndexView;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppPanelView;
import net.ibizsys.modelapi.domain.PSAppPortalView;
import net.ibizsys.modelapi.domain.PSAppUtilView;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppDEViewDTO;
import net.ibizsys.modelapi.dto.PSAppDynaDEViewDTO;
import net.ibizsys.modelapi.dto.PSAppIndexViewDTO;
import net.ibizsys.modelapi.dto.PSAppPanelViewDTO;
import net.ibizsys.modelapi.dto.PSAppPortalViewDTO;
import net.ibizsys.modelapi.dto.PSAppUtilViewDTO;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.service.IPSAppViewServiceProxy;
import net.ibizsys.modelapi.service.impl.PSAppViewServiceImpl;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewServiceProxyImpl
extends PSAppViewServiceImpl<PSAppView, PSAppViewDTO>
implements IPSAppViewServiceProxy {
    private static final Log log = LogFactory.getLog(PSAppViewServiceProxyImpl.class);

    @Override
    public List<PSAppView> listByPSAppModule(PSAppModule parent) throws Exception {
        ArrayList<PSAppView> list = new ArrayList<PSAppView>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listByPSAppModule(parent);
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listByPSAppModule(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listByPSAppModule(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listByPSAppModule(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listByPSAppModule(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listByPSAppModule(parent)) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public List<PSAppViewDTO> listDTOByPSAppModule(String strParentKey) throws Exception {
        ArrayList<PSAppViewDTO> list = new ArrayList<PSAppViewDTO>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listDTOByPSAppModule(strParentKey);
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listDTOByPSAppModule(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listDTOByPSAppModule(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listDTOByPSAppModule(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listDTOByPSAppModule(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listDTOByPSAppModule(strParentKey)) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public List<PSAppView> listByPSSysApp(PSSysApp parent) throws Exception {
        ArrayList<PSAppView> list = new ArrayList<PSAppView>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listByPSSysApp(parent);
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listByPSSysApp(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listByPSSysApp(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listByPSSysApp(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listByPSSysApp(parent)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listByPSSysApp(parent)) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public List<PSAppViewDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        ArrayList<PSAppViewDTO> list = new ArrayList<PSAppViewDTO>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listDTOByPSSysApp(strParentKey);
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listDTOByPSSysApp(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listDTOByPSSysApp(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listDTOByPSSysApp(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listDTOByPSSysApp(strParentKey)) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listDTOByPSSysApp(strParentKey)) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public List<PSAppView> listAll() throws Exception {
        ArrayList<PSAppView> list = new ArrayList<PSAppView>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listAll();
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listAll()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listAll()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listAll()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listAll()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listAll()) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public List<PSAppViewDTO> listAllDTO() throws Exception {
        ArrayList<PSAppViewDTO> list = new ArrayList<PSAppViewDTO>();
        List items = PSModelServiceUtil.getInstance().getPSAppDEViewService().listAllDTO();
        if (items != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().listAllDTO()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppIndexViewService().listAllDTO()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPanelViewService().listAllDTO()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppPortalViewService().listAllDTO()) != null) {
            list.addAll(items);
        }
        if ((items = PSModelServiceUtil.getInstance().getPSAppUtilViewService().listAllDTO()) != null) {
            list.addAll(items);
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    public PSAppView get(String strKey, boolean bTryMode) throws Exception {
        PSAppView item = (PSAppDEView)PSModelServiceUtil.getInstance().getPSAppDEViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppDynaDEView)PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppIndexView)PSModelServiceUtil.getInstance().getPSAppIndexViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppPanelView)PSModelServiceUtil.getInstance().getPSAppPanelViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppPortalView)PSModelServiceUtil.getInstance().getPSAppPortalViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppUtilView)PSModelServiceUtil.getInstance().getPSAppUtilViewService().get(strKey, true);
        if (item != null) {
            return item;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]\uff0c\u8def\u5f84\u4e3a[%2$s]", this.getModelName(), strKey));
    }

    @Override
    public PSAppViewDTO getDTO(String strKey, boolean bTryMode) throws Exception {
        PSAppViewDTO item = (PSAppDEViewDTO)PSModelServiceUtil.getInstance().getPSAppDEViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppDynaDEViewDTO)PSModelServiceUtil.getInstance().getPSAppDynaDEViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppIndexViewDTO)PSModelServiceUtil.getInstance().getPSAppIndexViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppPanelViewDTO)PSModelServiceUtil.getInstance().getPSAppPanelViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppPortalViewDTO)PSModelServiceUtil.getInstance().getPSAppPortalViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        item = (PSAppUtilViewDTO)PSModelServiceUtil.getInstance().getPSAppUtilViewService().getDTO(strKey, true);
        if (item != null) {
            return item;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b[%1$s]\uff0c\u8def\u5f84\u4e3a[%2$s]", this.getModelName(), strKey));
    }

    @Override
    public String getModelName() {
        return "PSAPPVIEW";
    }

    @Override
    public PSAppView createDomain() {
        return new PSAppView();
    }

    @Override
    public PSAppViewDTO createDTO() {
        return new PSAppViewDTO();
    }
}

