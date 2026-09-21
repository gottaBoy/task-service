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
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSSysSFPubImpl;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSFPubGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSFPub, IPSSysSFPub> {
    private static final Log log = LogFactory.getLog(PSSysSFPubGlobalModel.class);
    private IPSSysSFPub defaultPSSysSFPub = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) {
        return super.Init(iDAGlobalHelper, iPSSystem);
    }

    @Override
    protected PSSysSFPub GetObject(String strPSSysSFPubId) {
        PSSysSFPub psSysSFPub = new PSSysSFPub();
        CallResult callResult = this.iPSModelHelper.getPSSysSFPub(strPSSysSFPubId, psSysSFPub);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u670d\u52a1\u53d1\u5e03[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSFPubId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSFPub;
    }

    @Override
    protected IPSSysSFPub OnCreateModelHelper(PSSysSFPub vt) throws Exception {
        PSSysSFPubImpl iPSSysSFPub = new PSSysSFPubImpl();
        iPSSysSFPub.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysSFPub;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSFPub obj) {
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
    protected IPSSysSFPub registerModel(PSSysSFPub vt) throws Exception {
        IPSSysSFPub iPSSysSFPub = (IPSSysSFPub)this.InternalGetModelHelper(vt.getPSSYSSFPUBID());
        if (iPSSysSFPub != null) {
            return iPSSysSFPub;
        }
        this.setModel(vt.getPSSYSSFPUBID(), vt, null);
        iPSSysSFPub = (IPSSysSFPub)this.FindModelHelper(vt.getPSSYSSFPUBID());
        if (iPSSysSFPub.getDefaultFlag()) {
            this.defaultPSSysSFPub = iPSSysSFPub;
        }
        return iPSSysSFPub;
    }

    @Override
    protected Vector<PSSysSFPub> getAllModels() throws Exception {
        Vector<PSSysSFPub> list = new Vector<PSSysSFPub>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSFPubs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u670d\u52a1\u53d1\u5e03\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        PSSysSFPub defaultPsSysSFPub = null;
        for (PSSysSFPub psSysSFPub : list) {
            if (psSysSFPub.isDEFAULTPUBNull() || !psSysSFPub.getDEFAULTPUB()) continue;
            defaultPsSysSFPub = psSysSFPub;
            break;
        }
        if (defaultPsSysSFPub == null) {
            int nRootCount = 0;
            for (PSSysSFPub psSysSFPub : list) {
                if (!StringHelper.IsNullOrEmpty((String)psSysSFPub.getPPSSYSSFPUBID())) continue;
                ++nRootCount;
            }
            if (nRootCount == 1) {
                for (PSSysSFPub psSysSFPub : list) {
                    if (!StringHelper.IsNullOrEmpty((String)psSysSFPub.getPPSSYSSFPUBID())) continue;
                    psSysSFPub.setDEFAULTPUB(true);
                    defaultPsSysSFPub = psSysSFPub;
                    break;
                }
            }
        }
        Vector<PSSysSFPub> list2 = new Vector<PSSysSFPub>();
        list2.addAll(list);
        list.clear();
        for (PSSysSFPub psSysSFPub : list2) {
            if (!StringHelper.IsNullOrEmpty((String)psSysSFPub.getPPSSYSSFPUBID())) continue;
            list.add(psSysSFPub);
        }
        for (PSSysSFPub psSysSFPub : list2) {
            if (StringHelper.IsNullOrEmpty((String)psSysSFPub.getPPSSYSSFPUBID())) continue;
            list.add(psSysSFPub);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSFPub vt) {
        return vt.getPSSYSSFPUBID();
    }

    public IPSSysSFPub getDefaultPSSysSFPub() {
        this.preloadModels();
        return this.defaultPSSysSFPub;
    }
}

