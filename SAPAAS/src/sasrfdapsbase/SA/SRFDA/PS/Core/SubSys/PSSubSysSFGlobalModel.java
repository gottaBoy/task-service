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

import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.PSSubSysSFImpl;
import SA.SRFDA.PS.Data.PSSubSysSF;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysSFGlobalModel
extends PSSubSysGlobalModelBase<String, PSSubSysSF, IPSSubSysSF> {
    private static final Log log = LogFactory.getLog(PSSubSysSFGlobalModel.class);
    protected HashMap<String, IPSSubSysSF> psSubSysSFMap = new HashMap();

    @Override
    protected PSSubSysSF GetObject(String strPSSubSysSFId) {
        PSSubSysSF psSubSysSF = new PSSubSysSF();
        CallResult callResult = this.iPSModelHelper.getPSSubSysSF(strPSSubSysSFId, psSubSysSF);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u670d\u52a1\u5c42[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubSysSFId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubSysSF;
    }

    @Override
    protected IPSSubSysSF OnCreateModelHelper(PSSubSysSF vt) throws Exception {
        PSSubSysSFImpl iPSSubSysSF = new PSSubSysSFImpl();
        iPSSubSysSF.init(this.iDAGlobalHelper, this.getPSSubSys(), vt);
        return iPSSubSysSF;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubSysSF obj) {
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
    protected IPSSubSysSF registerModel(PSSubSysSF vt) throws Exception {
        IPSSubSysSF iPSSubSysSF = (IPSSubSysSF)this.InternalGetModelHelper(vt.getPSSUBSYSSFID());
        if (iPSSubSysSF != null) {
            return iPSSubSysSF;
        }
        this.setModel(vt.getPSSUBSYSSFID(), vt, null);
        iPSSubSysSF = (IPSSubSysSF)this.FindModelHelper(vt.getPSSUBSYSSFID());
        this.psSubSysSFMap.put(iPSSubSysSF.getPSSFStyleId(), iPSSubSysSF);
        return iPSSubSysSF;
    }

    @Override
    protected Vector<PSSubSysSF> getAllModels() throws Exception {
        Vector<PSSubSysSF> list = new Vector<PSSubSysSF>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubSysSFs(this.getPSSubSys().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u670d\u52a1\u5c42\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    public IPSSubSysSF getPSSubSysSFBySFStyle(String strPSSFStyleId, boolean bTryMode) throws Exception {
        this.preloadModels();
        IPSSubSysSF iPSSubSysSF = this.psSubSysSFMap.get(strPSSFStyleId);
        if (iPSSubSysSF == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u4f53\u7cfb\u7c7b\u578b[%1$s]\u5bf9\u5e94\u7684\u5b50\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb", (Object)strPSSFStyleId));
        }
        return iPSSubSysSF;
    }

    @Override
    protected String getObjectId(PSSubSysSF vt) {
        return vt.getPSSUBSYSSFID();
    }
}

