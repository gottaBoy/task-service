/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDConfigValueHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.ND.Ctrl.NDUserModelStorage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDANDWebCTXHelper {
    public static final String TAG_SRFDANDROOTPATH = "SRFDANDROOTPATH";
    public static final String TAG_SRFDANDROOTFSOID = "SRFDANDROOTFSOID";
    public static final String TAG_SRFDANDFOLDERPATH = "SRFDANDFOLDERPATH";
    public static final String TAG_SRFDANDOWNERID = "SRFDANDOWNERID";
    public static final String TAG_SRFDANDUSERMODELSTORAGE = "SRFDANDUSERMODELSTORAGE";
    public static final String TAG_SRFDANDSHAREID = "SRFDANDSHAREID";
    public static final String TAG_SRFDANDFSOID = "SRFDANDFSOID";
    public static final String TAG_SRFDANDDISKID = "SRFDANDDISKID";
    private static final Log log = LogFactory.getLog(SRFDANDWebCTXHelper.class);

    public static String GetNDRootPath(ISRFDAWebContext webContext) {
        String strValue = webContext.GetPostValue(TAG_SRFDANDROOTPATH);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return webContext.GetParamValue(TAG_SRFDANDROOTPATH);
    }

    public static String GetNDRootFSOId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetPostValue(TAG_SRFDANDROOTFSOID);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return webContext.GetParamValue(TAG_SRFDANDROOTFSOID);
    }

    public static String GetNDFolderPath(ISRFDAWebContext webContext) {
        String strValue = webContext.GetPostValue(TAG_SRFDANDFOLDERPATH);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return webContext.GetParamValue(TAG_SRFDANDFOLDERPATH);
    }

    public static String GetNDOwnerId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_SRFDANDOWNERID);
    }

    public static String GetNDShareId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_SRFDANDSHAREID);
    }

    public static String GetNDDiskId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_SRFDANDDISKID);
    }

    public static INDUserModelStorage GetNDUserModelStorage(ISRFDAWebContext webContext) throws Exception {
        Object obj = webContext.GetSessionValue(TAG_SRFDANDUSERMODELSTORAGE);
        if (obj != null && obj instanceof INDUserModelStorage) {
            return (INDUserModelStorage)obj;
        }
        INDModelStorage iNDModelStorage = NDModelStorageFactory.Create(webContext.getGlobalHelper());
        INDConfigTypeHelper iNDConfigTypeHelper = iNDModelStorage.FindNDConfigType("NDORGTREE");
        INDConfigValueHelper iNDConfigValue = iNDConfigTypeHelper.FindDefaultNDConfigValue();
        NDUserModelStorage iNDUserModelStorage = new NDUserModelStorage();
        iNDUserModelStorage.setNDORGTreeId(iNDConfigValue.getConfigValue());
        iNDUserModelStorage.Init(webContext.getGlobalHelper(), webContext.GetUserRoleHelper());
        webContext.SetSessionValue(TAG_SRFDANDUSERMODELSTORAGE, (Object)iNDUserModelStorage);
        return iNDUserModelStorage;
    }

    public static void SetNDUserModelStorage(ISRFDAWebContext webContext, INDUserModelStorage iNDUserModelStorage) {
        webContext.SetSessionValue(TAG_SRFDANDUSERMODELSTORAGE, (Object)iNDUserModelStorage);
    }
}

