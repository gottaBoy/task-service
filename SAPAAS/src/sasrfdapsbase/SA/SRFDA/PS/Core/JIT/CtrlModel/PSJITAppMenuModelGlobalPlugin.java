/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModelGlobalPlugin
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.ctrlmodel.IAppMenuModelGlobalPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJITAppMenuModelGlobalPlugin
implements IAppMenuModelGlobalPlugin {
    private final Log log = LogFactory.getLog(PSJITAppMenuModelGlobalPlugin.class);
    private HashMap<String, IAppMenuModel> appMenuModelMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerAppMenuModel(String strAppMenuModelClsType, IAppMenuModel iAppMenuModel) {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.getInstance().getAppModel().registerAppMenuModel2(strAppMenuModelClsType, iAppMenuModel);
            return;
        }
        HashMap<String, IAppMenuModel> hashMap = this.appMenuModelMap;
        synchronized (hashMap) {
            this.appMenuModelMap.put(strAppMenuModelClsType, iAppMenuModel);
        }
    }

    public IAppMenuModel getAppMenuModel(Class cls) throws Exception {
        return this.getAppMenuModel(cls.getCanonicalName());
    }

    public IAppMenuModel getAppMenuModel(String strAppMenuModelClsType) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            return PSJITWebContext.getInstance().getAppModel().getAppMenuModel2(strAppMenuModelClsType);
        }
        return this.internalGetAppMenuModel(strAppMenuModelClsType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IAppMenuModel internalGetAppMenuModel(String strAppMenuModelClsType) throws Exception {
        HashMap<String, IAppMenuModel> hashMap = this.appMenuModelMap;
        synchronized (hashMap) {
            IAppMenuModel iAppMenuModel = this.appMenuModelMap.get(strAppMenuModelClsType);
            return iAppMenuModel;
        }
    }

    public Iterator<IAppMenuModel> getAllAppMenuModels() throws Exception {
        return this.appMenuModelMap.values().iterator();
    }
}

