/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Core.WF.PSWFWorkTimeImpl;
import SA.SRFDA.PS.Data.PSWFWorkTime;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFWorkTimeGlobalModel
extends PSSystemGlobalModelBase<String, PSWFWorkTime, IPSWFWorkTime> {
    private static final Log log = LogFactory.getLog(PSWFWorkTimeGlobalModel.class);

    @Override
    protected PSWFWorkTime GetObject(String strPSWFWorkTimeId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5de5\u4f5c\u6d41\u5de5\u4f5c\u65f6\u95f4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFWorkTimeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFWorkTime OnCreateModelHelper(PSWFWorkTime vt) throws Exception {
        PSWFWorkTimeImpl iPSWFWorkTime = new PSWFWorkTimeImpl();
        iPSWFWorkTime.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSWFWorkTime;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFWorkTime obj) {
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
    protected Vector<PSWFWorkTime> getAllModels() throws Exception {
        Vector<PSWFWorkTime> psDEDataSetList = new Vector<PSWFWorkTime>();
        CallResult callResult = this.iPSModelHelper.getAllPSWFWorkTimes(this.getPSSystem().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5de5\u4f5c\u6d41\u5de5\u4f5c\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected IPSWFWorkTime registerModel(PSWFWorkTime vt) throws Exception {
        IPSWFWorkTime iPSWFWorkTime = (IPSWFWorkTime)this.InternalGetModelHelper(vt.getPSWFWORKTIMEID());
        if (iPSWFWorkTime != null) {
            return iPSWFWorkTime;
        }
        this.setModel(vt.getPSWFWORKTIMEID(), vt, null);
        return (IPSWFWorkTime)this.FindModelHelper(vt.getPSWFWORKTIMEID());
    }

    @Override
    protected String getObjectId(PSWFWorkTime vt) {
        return vt.getPSWFWORKTIMEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSWFWorkTime vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

