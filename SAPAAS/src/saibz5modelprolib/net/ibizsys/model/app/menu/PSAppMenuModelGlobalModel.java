/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.menu.IPSAppMenuModel
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.menu;

import java.util.Vector;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.control.menu.PSAppMenuImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSAppMenu;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuModelGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppMenu, IPSAppMenuModel> {
    private static final Log log = LogFactory.getLog(PSAppMenuModelGlobalModel.class);

    @Override
    protected PSAppMenu getObject(String strPSAppMenuId) {
        PSAppMenu psAppMenu = new PSAppMenu();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppMenu(strPSAppMenuId, psAppMenu);
        if (callResult.isError()) {
            String strInfo = StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u83dc\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppMenuId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, (IPSModelObject)this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppMenu.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppMenu;
    }

    @Override
    protected IPSAppMenuModel onCreateModelHelper(PSAppMenu vt) throws Exception {
        PSAppMenuImpl iPSAppMenu = new PSAppMenuImpl();
        iPSAppMenu.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppMenu;
    }

    @Override
    protected Boolean testObjectRenew(PSAppMenu obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppMenu vt) {
        return vt.getPSAPPMENUID();
    }

    @Override
    protected IPSAppMenuModel registerModel(PSAppMenu vt) throws Exception {
        IPSAppMenuModel iPSAppMenu = (IPSAppMenuModel)this.internalGetModelHelper(vt.getPSAPPMENUID());
        if (iPSAppMenu != null) {
            return iPSAppMenu;
        }
        this.setModel(vt.getPSAPPMENUID(), vt, null);
        return (IPSAppMenuModel)this.findModelHelper(vt.getPSAPPMENUID());
    }

    @Override
    protected Vector<PSAppMenu> getAllModels() throws Exception {
        Vector<PSAppMenu> list = new Vector<PSAppMenu>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppMenus(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppMenu psAppMenu : list) {
            this.setModel(psAppMenu.getPSAPPMENUID(), psAppMenu, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40000, objObjectId);
    }
}

