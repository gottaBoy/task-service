/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.PSDEFInputTipImpl;
import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFInputTip;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFInputTipGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFInputTip, IPSDEFInputTip> {
    private static final Log log = LogFactory.getLog(PSDEFInputTipGlobalModel.class);
    private IPSDEFInputTip defaultPSDEFInputTip = null;

    @Override
    protected PSDEFInputTip GetObject(String strPSDEFInputTipId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFInputTipId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFInputTip OnCreateModelHelper(PSDEFInputTip vt) throws Exception {
        PSDEFInputTipImpl iPSDEFInputTip = new PSDEFInputTipImpl();
        iPSDEFInputTip.init(this.iDAGlobalHelper, this.iPSDEField, vt);
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
    protected IPSDEFInputTip registerModel(PSDEFInputTip vt) throws Exception {
        IPSDEFInputTip iPSDEFInputTip = (IPSDEFInputTip)this.InternalGetModelHelper(vt.getPSDEFINPUTTIPID());
        if (iPSDEFInputTip != null) {
            return iPSDEFInputTip;
        }
        this.setModel(vt.getPSDEFINPUTTIPID(), vt, null);
        if (!StringHelper.IsNullOrEmpty((String)vt.getTIPMODE())) {
            this.setModel(vt.getTIPMODE(), vt, null);
        }
        if ((iPSDEFInputTip = (IPSDEFInputTip)this.FindModelHelper(vt.getPSDEFINPUTTIPID())) != null && this.defaultPSDEFInputTip == null && iPSDEFInputTip.isDefault()) {
            this.defaultPSDEFInputTip = iPSDEFInputTip;
        }
        return iPSDEFInputTip;
    }

    @Override
    protected Vector<PSDEFInputTip> getAllModels() throws Exception {
        Vector<PSDEFInputTip> psDEFInputTipList = new Vector<PSDEFInputTip>();
        ArrayList<PSDEFInputTip> psDEFInputTipList2 = this.getPSDEField().getPSDEFieldData().getPSDEFInputTips(false);
        if (psDEFInputTipList2 != null) {
            psDEFInputTipList.addAll(psDEFInputTipList2);
        }
        return psDEFInputTipList;
    }

    @Override
    protected String getObjectId(PSDEFInputTip vt) {
        return vt.getPSDEFINPUTTIPID();
    }

    public IPSDEFInputTip getDefaultPSDEFInputTip() {
        this.preloadModels();
        return this.defaultPSDEFInputTip;
    }
}

