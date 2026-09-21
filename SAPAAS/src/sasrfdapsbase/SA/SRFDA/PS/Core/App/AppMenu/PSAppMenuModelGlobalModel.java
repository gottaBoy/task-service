/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.AppMenu;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.AppMenu.PSAppMenuModelImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuModelGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppMenu, IPSAppMenuModel> {
    private static final Log log = LogFactory.getLog(PSAppMenuModelGlobalModel.class);

    @Override
    protected PSAppMenu GetObject(String strPSAppMenuId) {
        PSAppMenu psAppMenu = new PSAppMenu();
        CallResult callResult = this.iPSModelHelper.getPSAppMenu(strPSAppMenuId, psAppMenu);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u83dc\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppMenuId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppMenu.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppMenu;
    }

    @Override
    protected IPSAppMenuModel OnCreateModelHelper(PSAppMenu vt) throws Exception {
        PSAppMenuModelImpl iPSAppMenu = new PSAppMenuModelImpl();
        iPSAppMenu.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppMenu;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppMenu obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppMenu vt) {
        return vt.getPSAPPMENUID();
    }

    @Override
    protected IPSAppMenuModel registerModel(PSAppMenu vt) throws Exception {
        IPSAppMenuModel iPSAppMenu = (IPSAppMenuModel)this.InternalGetModelHelper(vt.getPSAPPMENUID());
        if (iPSAppMenu != null) {
            return iPSAppMenu;
        }
        this.setModel(vt.getPSAPPMENUID(), vt, null);
        return (IPSAppMenuModel)this.FindModelHelper(vt.getPSAPPMENUID());
    }

    @Override
    protected Vector<PSAppMenu> getAllModels() throws Exception {
        Vector<PSAppMenu> list = new Vector<PSAppMenu>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppMenus(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

