/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import SA.TM.Ctrl.TMUserSessionStorage;
import java.util.Hashtable;

public class TMUSSFactory {
    public static final String STORAGEID = "{1A46D185-E9FC-438E-9122-254BE7C30E11}";
    private static Hashtable<String, ITMUserSessionStorage> tmUserSessionStorageMap = new Hashtable();

    public static void RemoveUSS(String strOPPersonId) throws Exception {
        tmUserSessionStorageMap.remove(strOPPersonId);
    }

    public static ITMUserSessionStorage GetCurrentUSS(ISRFDAGlobalHelper iSRFDAGlobalHelper, String strOPPersonId) throws Exception {
        ITMUserSessionStorage objValue = tmUserSessionStorageMap.get(strOPPersonId);
        if (objValue != null) {
            if (objValue instanceof ITMUserSessionStorage) {
                return objValue;
            }
            throw new Exception("\u5b58\u50a8\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        TMUserSessionStorage iBIUserSessionStorage = new TMUserSessionStorage();
        iBIUserSessionStorage.Init(iSRFDAGlobalHelper, strOPPersonId);
        tmUserSessionStorageMap.put(strOPPersonId, iBIUserSessionStorage);
        return iBIUserSessionStorage;
    }

    public static ITMUserSessionStorage GetCurrentUSS(ISRFDAWebContext webContext) throws Exception {
        Object objValue = webContext.GetSessionValue(STORAGEID);
        if (objValue != null) {
            if (objValue instanceof ITMUserSessionStorage) {
                return (ITMUserSessionStorage)objValue;
            }
            throw new Exception("\u5b58\u50a8\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        TMUserSessionStorage iBIUserSessionStorage = new TMUserSessionStorage();
        iBIUserSessionStorage.Init(webContext.getGlobalHelper(), webContext.getCurUserId());
        webContext.SetSessionValue(STORAGEID, (Object)iBIUserSessionStorage);
        return iBIUserSessionStorage;
    }
}

