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
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DataEntity.Priv.IPSSysDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSSysDEOPPrivImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDEOPPrivGlobalModel
extends PSSystemGlobalModelBase<String, PSDEOPPriv, IPSSysDEOPPriv> {
    private static final Log log = LogFactory.getLog(PSSysDEOPPrivGlobalModel.class);

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) {
        this.bEnableEmptyMap = true;
        return super.Init(iDAGlobalHelper, iPSSystem);
    }

    @Override
    protected PSDEOPPriv GetObject(String strPSDEOPPrivId) {
        PSDEOPPriv psDEOPPriv = new PSDEOPPriv();
        CallResult callResult = this.iPSModelHelper.getPSDEOPPriv(strPSDEOPPrivId, psDEOPPriv);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEOPPrivId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEOPPriv;
    }

    @Override
    protected IPSSysDEOPPriv OnCreateModelHelper(PSDEOPPriv vt) throws Exception {
        PSSysDEOPPrivImpl iPSDEOPPriv = new PSSysDEOPPrivImpl();
        iPSDEOPPriv.init(this.iDAGlobalHelper, this.getPSSystem(), null, vt);
        return iPSDEOPPriv;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEOPPriv obj) {
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
    protected IPSSysDEOPPriv registerModel(PSDEOPPriv vt) throws Exception {
        IPSSysDEOPPriv iPSDEOPPriv = (IPSSysDEOPPriv)this.InternalGetModelHelper(vt.getPSDEOPPRIVID());
        if (iPSDEOPPriv != null) {
            return iPSDEOPPriv;
        }
        this.setModel(vt.getPSDEOPPRIVID(), vt, null);
        return (IPSSysDEOPPriv)this.FindModelHelper(vt.getPSDEOPPRIVID());
    }

    @Override
    protected Vector<PSDEOPPriv> getAllModels() throws Exception {
        Vector<PSDEOPPriv> psDEOPPrivList = new Vector<PSDEOPPriv>();
        CallResult callResult = this.iPSModelHelper.getPSDEOPPrivsBySystem(this.getPSSystem().getId(), psDEOPPrivList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u64cd\u4f5c\u6807\u8bc6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEOPPrivList;
    }

    @Override
    protected String getObjectId(PSDEOPPriv vt) {
        return vt.getPSDEOPPRIVID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEOPPriv vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEOPPRIVNAME())) {
            return new String[]{vt.getPSDEOPPRIVNAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

