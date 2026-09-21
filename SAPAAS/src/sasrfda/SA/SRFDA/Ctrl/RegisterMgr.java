/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;

public class RegisterMgr {
    protected ISRFDAGlobalHelper iGlobalHelper = null;
    protected TreeMap<String, Registry> registerMap = new TreeMap();

    public RegisterMgr(ISRFDAGlobalHelper iGlobalHelper) {
        this.iGlobalHelper = iGlobalHelper;
    }

    public String GetRegistryParam(String strPath, String strDefault) {
        String[] parts = strPath.split("[\\\\]");
        if (parts.length != 3) {
            return strDefault;
        }
        Registry registry = this.GetRegistry(parts[0], parts[1]);
        if (registry == null) {
            return strDefault;
        }
        return registry.GetParam(parts[2], strDefault);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Registry GetRegistry(String strSystemName, String strSection) {
        String strKey = StringHelper.Format((String)"[%1$s]%2$s", (Object)strSystemName.toUpperCase(), (Object)strSection.toUpperCase());
        TreeMap<String, Registry> treeMap = this.registerMap;
        synchronized (treeMap) {
            if (this.registerMap.containsKey(strKey)) {
                return this.registerMap.get(strKey);
            }
        }
        if (this.iGlobalHelper.getDAModelHelper() == null) {
            return null;
        }
        Registry registry = new Registry();
        CallResult callResult = this.iGlobalHelper.getDAModelHelper().GetRegistry(strSystemName, strSection, registry);
        if (callResult.IsError() && callResult.getRetCode() != 3) {
            return null;
        }
        TreeMap<String, Registry> treeMap2 = this.registerMap;
        synchronized (treeMap2) {
            if (this.registerMap.size() > 1000) {
                this.registerMap.clear();
            }
            this.registerMap.put(strKey, registry);
        }
        return registry;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void Reset() {
        TreeMap<String, Registry> treeMap = this.registerMap;
        synchronized (treeMap) {
            this.registerMap.clear();
        }
    }
}

