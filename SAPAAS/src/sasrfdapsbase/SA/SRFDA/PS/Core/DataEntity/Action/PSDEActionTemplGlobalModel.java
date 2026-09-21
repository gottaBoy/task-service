/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionTemplImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEActionTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionTemplGlobalModel
extends PSSystemGlobalModelBase<String, PSDEActionTempl, IPSDEActionTempl> {
    private static final Log log = LogFactory.getLog(PSDEActionTemplGlobalModel.class);

    @Override
    protected PSDEActionTempl GetObject(String strPSDEActionTemplId) {
        PSDEActionTempl psDEActionTempl = new PSDEActionTempl();
        CallResult callResult = this.iPSModelHelper.getPSDEActionTempl(strPSDEActionTemplId, psDEActionTempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEActionTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEActionTempl;
    }

    @Override
    protected IPSDEActionTempl OnCreateModelHelper(PSDEActionTempl vt) throws Exception {
        PSDEActionTemplImpl iPSDEActionTempl = null;
        iPSDEActionTempl = new PSDEActionTemplImpl();
        iPSDEActionTempl.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSDEActionTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEActionTempl obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSDEActionTempl registerModel(PSDEActionTempl vt) throws Exception {
        IPSDEActionTempl iIPSDEActionTempl = (IPSDEActionTempl)this.InternalGetModelHelper(vt.getPSDEACTIONTEMPLID());
        if (iIPSDEActionTempl != null) {
            return iIPSDEActionTempl;
        }
        this.setModel(vt.getPSDEACTIONTEMPLID(), vt, null);
        return (IPSDEActionTempl)this.FindModelHelper(vt.getPSDEACTIONTEMPLID());
    }

    @Override
    protected Vector<PSDEActionTempl> getAllModels() throws Exception {
        Vector<PSDEActionTempl> list = new Vector<PSDEActionTempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSDEActionTempls(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDEActionTempl vt) {
        return vt.getPSDEACTIONTEMPLID();
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

    protected String[] getObjectAliases(PSDEActionTempl vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

