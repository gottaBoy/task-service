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

import SA.SRFDA.PS.Core.SubSys.IPSSubSysDMItem;
import SA.SRFDA.PS.Core.SubSys.PSSubSysDMItemImpl;
import SA.SRFDA.PS.Core.SubSys.PSSubSysVerGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysDMItemGlobalModel
extends PSSubSysVerGlobalModelBase<String, PSSysDMItem, IPSSubSysDMItem> {
    private static final Log log = LogFactory.getLog(PSSubSysDMItemGlobalModel.class);

    @Override
    protected PSSysDMItem GetObject(String strPSSubSysDMItemId) {
        return null;
    }

    @Override
    protected IPSSubSysDMItem OnCreateModelHelper(PSSysDMItem vt) throws Exception {
        PSSubSysDMItemImpl iPSSubSysDMItem = new PSSubSysDMItemImpl();
        iPSSubSysDMItem.init(this.iDAGlobalHelper, this.getPSSubSysVer(), vt);
        return iPSSubSysDMItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDMItem obj) {
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
    protected IPSSubSysDMItem registerModel(PSSysDMItem vt) throws Exception {
        IPSSubSysDMItem iPSSubSysDMItem = (IPSSubSysDMItem)this.InternalGetModelHelper(vt.getPSSYSDMITEMID());
        if (iPSSubSysDMItem != null) {
            return iPSSubSysDMItem;
        }
        this.setModel(vt.getPSSYSDMITEMID(), vt, null);
        iPSSubSysDMItem = (IPSSubSysDMItem)this.FindModelHelper(vt.getPSSYSDMITEMID());
        return iPSSubSysDMItem;
    }

    @Override
    protected Vector<PSSysDMItem> getAllModels() throws Exception {
        Vector<PSSysDMItem> list = new Vector<PSSysDMItem>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDMItems(this.getPSSubSysVer().getPSSystemId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u7248\u672c\u6570\u636e\u7ed3\u6784\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDMItem vt) {
        return vt.getPSSYSDMITEMID();
    }
}

