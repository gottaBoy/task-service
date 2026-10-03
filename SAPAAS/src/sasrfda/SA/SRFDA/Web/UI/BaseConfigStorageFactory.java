/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.UI;

import SA.SRFDA.Web.UI.BaseConfigStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

public abstract class BaseConfigStorageFactory<T2 extends BaseConfigStorage> {
    protected Hashtable<String, T2> configStorageMap = new Hashtable();

    public T2 GetConfigStorage(ISRFDAGlobalHelper iGlobalHelper) throws Exception {
        return this.GetConfigStorage(iGlobalHelper, "");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public T2 GetConfigStorage(ISRFDAGlobalHelper iGlobalHelper, String strTag) throws Exception {
        BaseConfigStorage t2 = null;
        Hashtable<String, T2> hashtable = this.configStorageMap;
        synchronized (hashtable) {
            if (this.configStorageMap.containsKey(strTag)) {
                t2 = (BaseConfigStorage)this.configStorageMap.get(strTag);
            }
        }
        if (t2 != null) {
            return (T2)t2;
        }
        t2 = this.CreateConfigStorage(iGlobalHelper);
        if (t2 == null) {
            throw new Exception("\u6ca1\u6709\u5efa\u7acb\u914d\u7f6e\u5b58\u50a8\u5bf9\u8c61");
        }
        hashtable = this.configStorageMap;
        synchronized (hashtable) {
            this.configStorageMap.put(strTag, (T2)t2);
        }
        return (T2)t2;
    }

    protected abstract T2 CreateConfigStorage(ISRFDAGlobalHelper var1) throws Exception;

    protected ArrayList GetConfigFolders(ISRFDAGlobalHelper iGlobalHelper) {
        ArrayList<String> arrConfigPaths = new ArrayList<String>();
        String strRootPath = iGlobalHelper.GetAppRootPath();
        String strConfigFolderPaths = iGlobalHelper.getWebConfig().GetExtValue("CONFIGEXPATH", "configex");
        String[] strConfigFolder = strConfigFolderPaths.split("[|]");
        int i = 0;
        while (i < strConfigFolder.length) {
            String strFolder = strConfigFolder[i];
            if (StringHelper.Length((String)strFolder) != 0) {
                String strConfigPath = String.valueOf(strRootPath) + strFolder + File.separator;
                arrConfigPaths.add(strConfigPath);
            }
            ++i;
        }
        return arrConfigPaths;
    }
}

