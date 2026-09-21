/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysDEFInputTip;
import SA.SRFDA.PS.Core.Res.PSSysDEFInputTipImpl;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEFInputTipGlobalModel
extends PSSystemGlobalModelBase<String, PSDEFInputTip, IPSSysDEFInputTip> {
    private static final Log log = LogFactory.getLog(PSSysDEFInputTipGlobalModel.class);

    @Override
    protected PSDEFInputTip GetObject(String strPSDEFInputTipId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFInputTipId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSSysDEFInputTip OnCreateModelHelper(PSDEFInputTip vt) throws Exception {
        PSSysDEFInputTipImpl iPSDEFInputTip = new PSSysDEFInputTipImpl();
        iPSDEFInputTip.init(this.iDAGlobalHelper, this.iPSSystem, vt);
        return iPSDEFInputTip;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFInputTip obj) {
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
    protected IPSSysDEFInputTip registerModel(PSDEFInputTip vt) throws Exception {
        IPSSysDEFInputTip iPSDEFInputTip = (IPSSysDEFInputTip)this.InternalGetModelHelper(vt.getPSDEFINPUTTIPID());
        if (iPSDEFInputTip != null) {
            return iPSDEFInputTip;
        }
        this.setModel(vt.getPSDEFINPUTTIPID(), vt, null);
        iPSDEFInputTip = (IPSSysDEFInputTip)this.FindModelHelper(vt.getPSDEFINPUTTIPID());
        return iPSDEFInputTip;
    }

    @Override
    protected Vector<PSDEFInputTip> getAllModels() throws Exception {
        Vector<PSDEFInputTip> list = new Vector<PSDEFInputTip>();
        CallResult callResult = this.iPSModelHelper.getPSDEFInputTipsBySystem(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDEFInputTip vt) {
        return vt.getPSDEFINPUTTIPID();
    }
}

