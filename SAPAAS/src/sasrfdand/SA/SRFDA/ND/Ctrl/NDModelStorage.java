/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDDiskOwnerTypeHelper;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDConfigTypeGlobalModel;
import SA.SRFDA.ND.Ctrl.NDDiskOwnerTypeGlobalModel;
import SA.SRFDA.ND.Ctrl.NDFSOTypeGlobalModel;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDModelStorage
implements INDModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected NDDiskOwnerTypeGlobalModel ndDiskOwnerTypeGlobalModel = new NDDiskOwnerTypeGlobalModel();
    protected NDFSOTypeGlobalModel ndFSOTypeGlobalModel = new NDFSOTypeGlobalModel();
    protected Hashtable<String, NDDisk> ndDiskMap = new Hashtable();
    protected NDConfigTypeGlobalModel ndConfigTypeGlobalModel = new NDConfigTypeGlobalModel();
    private static final Log log = LogFactory.getLog(NDModelStorage.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.ndDiskOwnerTypeGlobalModel.Init(iDAGlobalHelper);
        this.ndFSOTypeGlobalModel.Init(iDAGlobalHelper);
        this.ndConfigTypeGlobalModel.Init(iDAGlobalHelper);
    }

    protected final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final INDModelHelper getNDModelHelper() throws Exception {
        return NDModelHelperFactory.Create(this.getDAGlobalHelper());
    }

    @Override
    public INDDiskOwnerTypeHelper FindNDDiskOwnerType(String strNDDiskOwnerTypeId) throws Exception {
        return (INDDiskOwnerTypeHelper)this.ndDiskOwnerTypeGlobalModel.FindModelHelper(strNDDiskOwnerTypeId);
    }

    @Override
    public INDFSOTypeHelper FindNDFSOType(String strNDFSOTypeId) throws Exception {
        return (INDFSOTypeHelper)this.ndFSOTypeGlobalModel.FindModelHelper(strNDFSOTypeId);
    }

    @Override
    public NDFSObject FindNDFSObject(String strRootNDFSObjectId, String strFullPath, boolean bFirstShare) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strFullPath)) {
            return null;
        }
        NDFSObject lastNDFSObject = null;
        String[] paths = strFullPath.split("[\\\\]");
        int i = 0;
        while (i < paths.length) {
            String strName = paths[i];
            if (!StringHelper.IsNullOrEmpty((String)(strName = strName.trim()))) {
                CallResult callResult;
                if (lastNDFSObject == null) {
                    if (bFirstShare) {
                        NDShare ndShare = new NDShare();
                        callResult = this.getNDModelHelper().GetNDShare(strRootNDFSObjectId, strName, ndShare);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u901a\u8fc7\u540d\u79f0\u67e5\u627e\u5171\u4eab\u5bf9\u8c61[%1$s|%2$s],%3$s", (Object)strRootNDFSObjectId, (Object)strName, (Object)callResult.getErrorInfo()));
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8def\u5f84[%1$s],%2$s", (Object)strFullPath, (Object)callResult.getErrorInfo()));
                        }
                        lastNDFSObject = new NDFSObject();
                        callResult = this.getNDModelHelper().GetNDObject(ndShare.getNDFSOBJECTID(), lastNDFSObject);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s],%2$s", (Object)ndShare.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8def\u5f84[%1$s],%2$s", (Object)strFullPath, (Object)callResult.getErrorInfo()));
                        }
                    } else {
                        lastNDFSObject = new NDFSObject();
                        CallResult callResult2 = this.getNDModelHelper().GetNDFSObject(strRootNDFSObjectId, null, strName, lastNDFSObject);
                        if (callResult2.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u901a\u8fc7\u540d\u79f0\u67e5\u627e\u6587\u4ef6\u5bf9\u8c61[%1$s|%2$s],%3$s", (Object)strRootNDFSObjectId, (Object)strName, (Object)callResult2.getErrorInfo()));
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8def\u5f84[%1$s],%2$s", (Object)strFullPath, (Object)callResult2.getErrorInfo()));
                        }
                    }
                } else {
                    String strPNDFSObjectId = lastNDFSObject.getNDFSOBJECTID();
                    lastNDFSObject.Reset();
                    callResult = this.getNDModelHelper().GetNDFSObject(strRootNDFSObjectId, strPNDFSObjectId, strName, lastNDFSObject);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u901a\u8fc7\u540d\u79f0\u67e5\u627e\u6587\u4ef6\u5bf9\u8c61[%1$s|%2$s|%3$s],%4$s", (Object)strRootNDFSObjectId, (Object)strPNDFSObjectId, (Object)strName, (Object)callResult.getErrorInfo()));
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8def\u5f84[%1$s],%2$s", (Object)strFullPath, (Object)callResult.getErrorInfo()));
                    }
                }
            }
            ++i;
        }
        return lastNDFSObject;
    }

    @Override
    public NDFSObject FindNDFSObject(String strRootNDFSObjectId, String strPNDFSObjectId, String strFullPath) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strPNDFSObjectId)) {
            return this.FindNDFSObject(strRootNDFSObjectId, strFullPath, false);
        }
        if (StringHelper.IsNullOrEmpty((String)strFullPath)) {
            return null;
        }
        NDFSObject lastNDFSObject = null;
        String[] paths = strFullPath.split("[\\\\]");
        int i = 0;
        while (i < paths.length) {
            String strName = paths[i];
            if (!StringHelper.IsNullOrEmpty((String)(strName = strName.trim()))) {
                if (lastNDFSObject == null) {
                    lastNDFSObject = new NDFSObject();
                } else {
                    lastNDFSObject.Reset();
                }
                CallResult callResult = this.getNDModelHelper().GetNDFSObject(strRootNDFSObjectId, strPNDFSObjectId, strName, lastNDFSObject);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u8def\u5f84[%1$s],%2$s", (Object)strFullPath, (Object)callResult.getErrorInfo()));
                }
                strPNDFSObjectId = lastNDFSObject.getNDFSOBJECTID();
            }
            ++i;
        }
        return lastNDFSObject;
    }

    @Override
    public NDDisk FindNDDisk(String strNDDiskId) throws Exception {
        NDDisk ndDisk = this.ndDiskMap.get(strNDDiskId);
        if (ndDisk != null) {
            return ndDisk;
        }
        ndDisk = new NDDisk();
        CallResult callResult = this.getNDModelHelper().GetNDDisk(strNDDiskId, ndDisk);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u7f51\u76d8[%1$s],%2$s", (Object)strNDDiskId, (Object)callResult.getErrorInfo()));
        }
        this.ndDiskMap.put(strNDDiskId, ndDisk);
        return ndDisk;
    }

    @Override
    public INDConfigTypeHelper FindNDConfigType(String strNDConfigType) throws Exception {
        return (INDConfigTypeHelper)this.ndConfigTypeGlobalModel.FindModelHelper(strNDConfigType);
    }

    protected final int GetLastVersion(String strDEId, String strKey, int nVersion) {
        if (nVersion < 0) {
            return this.getDAGlobalHelper().getDAModelStorage().GetDAModelVersion(strDEId, (Object)strKey);
        }
        if (nVersion == 0) {
            return this.getDAGlobalHelper().getDAModelStorage().GetDAModelVersion(strDEId, (Object)strKey, true);
        }
        return nVersion;
    }
}

