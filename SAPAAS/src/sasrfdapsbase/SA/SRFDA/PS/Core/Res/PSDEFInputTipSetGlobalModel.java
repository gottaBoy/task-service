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
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.PSDEFInputTipSetImpl;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFInputTipSetGlobalModel
extends PSSystemGlobalModelBase<String, PSDEFInputTipSet, IPSDEFInputTipSet> {
    private static final Log log = LogFactory.getLog(PSDEFInputTipSetGlobalModel.class);

    @Override
    protected PSDEFInputTipSet GetObject(String strPSDEFInputTipSetId) {
        PSDEFInputTipSet psDEFInputTipSet = new PSDEFInputTipSet();
        CallResult callResult = this.iPSModelHelper.getPSDEFInputTipSet(strPSDEFInputTipSetId, psDEFInputTipSet);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFInputTipSetId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEFInputTipSet;
    }

    @Override
    protected IPSDEFInputTipSet OnCreateModelHelper(PSDEFInputTipSet vt) throws Exception {
        PSDEFInputTipSetImpl iPSDEFInputTipSet = new PSDEFInputTipSetImpl();
        iPSDEFInputTipSet.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSDEFInputTipSet;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFInputTipSet obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSDEFInputTipSet registerModel(PSDEFInputTipSet vt) throws Exception {
        IPSDEFInputTipSet iIPSDEFInputTipSet = (IPSDEFInputTipSet)this.InternalGetModelHelper(vt.getPSDEFINPUTTIPSETID());
        if (iIPSDEFInputTipSet != null) {
            return iIPSDEFInputTipSet;
        }
        this.setModel(vt.getPSDEFINPUTTIPSETID(), vt, null);
        return (IPSDEFInputTipSet)this.FindModelHelper(vt.getPSDEFINPUTTIPSETID());
    }

    @Override
    protected Vector<PSDEFInputTipSet> getAllModels() throws Exception {
        Vector<PSDEFInputTipSet> list = new Vector<PSDEFInputTipSet>();
        CallResult callResult = this.iPSModelHelper.getAllPSDEFInputTipSets(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDEFInputTipSet vt) {
        return vt.getPSDEFINPUTTIPSETID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEFInputTipSet vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

