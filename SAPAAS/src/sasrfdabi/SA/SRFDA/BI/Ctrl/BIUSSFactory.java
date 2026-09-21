/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBIUserSessionStorage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class BIUSSFactory {
    public static final String STORAGEID = "{1A46D185-E9FC-438E-9122-254BE7C30E10}";

    public static IBIUserSessionStorage GetCurrentUSS(ISRFDAWebContext webContext) throws Exception {
        Object objValue = webContext.GetSessionValue(STORAGEID);
        if (objValue != null) {
            if (objValue instanceof IBIUserSessionStorage) {
                return (IBIUserSessionStorage)objValue;
            }
            throw new Exception("\u5b58\u50a8\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        String strObjectType = "SA.SRFDA.BI.Ctrl.BIUserSessionStorage";
        objValue = ObjectHelper.Create((String)strObjectType);
        if (objValue == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b58\u50a8\u5bf9\u8c61[%1$s]", (Object)strObjectType));
        }
        if (!(objValue instanceof IBIUserSessionStorage)) {
            throw new Exception("\u5b58\u50a8\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        IBIUserSessionStorage iBIUserSessionStorage = (IBIUserSessionStorage)objValue;
        iBIUserSessionStorage.Init(webContext.getGlobalHelper(), webContext.getCurUserId());
        webContext.SetSessionValue(STORAGEID, objValue);
        return (IBIUserSessionStorage)objValue;
    }
}

