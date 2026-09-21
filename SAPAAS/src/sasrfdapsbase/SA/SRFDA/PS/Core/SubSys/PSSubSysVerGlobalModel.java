/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.PSSubSysVerImpl;
import SA.SRFDA.PS.Data.PSSubSysVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysVerGlobalModel
extends PSSubSysGlobalModelBase<String, PSSubSysVer, IPSSubSysVer> {
    private static final Log log = LogFactory.getLog(PSSubSysVerGlobalModel.class);
    protected HashMap<Integer, IPSSubSysVer> psSubSysVerMap = new HashMap();

    @Override
    protected PSSubSysVer GetObject(String strPSSubSysVerId) {
        PSSubSysVer psSubSysVer = new PSSubSysVer();
        CallResult callResult = this.iPSModelHelper.getPSSubSysVer(strPSSubSysVerId, psSubSysVer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubSysVerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubSysVer;
    }

    @Override
    protected IPSSubSysVer OnCreateModelHelper(PSSubSysVer vt) throws Exception {
        PSSubSysVerImpl iPSSubSysVer = new PSSubSysVerImpl();
        iPSSubSysVer.init(this.iDAGlobalHelper, this.getPSSubSys(), vt);
        return iPSSubSysVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSysVer obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSSubSysVer registerModel(PSSubSysVer vt) throws Exception {
        IPSSubSysVer iPSSubSysVer = (IPSSubSysVer)this.InternalGetModelHelper(vt.getPSSUBSYSVERID());
        if (iPSSubSysVer != null) {
            return iPSSubSysVer;
        }
        this.setModel(vt.getPSSUBSYSVERID(), vt, null);
        iPSSubSysVer = (IPSSubSysVer)this.FindModelHelper(vt.getPSSUBSYSVERID());
        this.psSubSysVerMap.put(iPSSubSysVer.getVersion(), iPSSubSysVer);
        return iPSSubSysVer;
    }

    @Override
    protected Vector<PSSubSysVer> getAllModels() throws Exception {
        Vector<PSSubSysVer> list = new Vector<PSSubSysVer>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubSysVers(this.getPSSubSys().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u7248\u672c\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    public IPSSubSysVer getPSSubSysVerByVer(int nVersion, boolean bTryMode) throws Exception {
        this.preloadModels();
        IPSSubSysVer iPSSubSysVer = this.psSubSysVerMap.get(nVersion);
        if (iPSSubSysVer == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7248\u672c\u53f7[%1$s]\u5bf9\u5e94\u7684\u5b50\u7cfb\u7edf\u7248\u672c", (Object)nVersion));
        }
        return iPSSubSysVer;
    }

    @Override
    protected String getObjectId(PSSubSysVer vt) {
        return vt.getPSSUBSYSVERID();
    }
}

