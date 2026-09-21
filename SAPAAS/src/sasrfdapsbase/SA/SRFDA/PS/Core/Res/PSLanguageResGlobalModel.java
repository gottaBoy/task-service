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
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.PSLanguageResImpl;
import SA.SRFDA.PS.Data.PSLanguageRes;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageResGlobalModel
extends PSSystemGlobalModelBase<String, PSLanguageRes, IPSLanguageRes> {
    private static final Log log = LogFactory.getLog(PSLanguageResGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        return super.OnInit();
    }

    @Override
    protected PSLanguageRes GetObject(String strPSLanguageResId) {
        return null;
    }

    @Override
    protected IPSLanguageRes OnCreateModelHelper(PSLanguageRes vt) throws Exception {
        PSLanguageResImpl iPSLanguageRes = null;
        iPSLanguageRes = new PSLanguageResImpl();
        iPSLanguageRes.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSLanguageRes;
    }

    @Override
    protected Boolean TestObjectRenew(PSLanguageRes obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSLanguageRes registerModel(PSLanguageRes vt) throws Exception {
        IPSLanguageRes iIPSLanguageRes = (IPSLanguageRes)this.InternalGetModelHelper(vt.getPSLANGUAGERESID());
        if (iIPSLanguageRes != null) {
            return iIPSLanguageRes;
        }
        this.setModel(vt.getPSLANGUAGERESID(), vt, null);
        IPSLanguageRes iPSLanguageRes = (IPSLanguageRes)this.FindModelHelper(vt.getPSLANGUAGERESID());
        this.setModel(vt.getLANRESTAG(), vt, iPSLanguageRes);
        return iPSLanguageRes;
    }

    @Override
    protected Vector<PSLanguageRes> getAllModels() throws Exception {
        Vector<PSLanguageRes> list = new Vector<PSLanguageRes>();
        CallResult callResult = this.iPSModelHelper.getAllPSLanguageReses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8bed\u8a00\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Collections.sort(list, new Comparator<PSLanguageRes>(){

            @Override
            public int compare(PSLanguageRes arg0, PSLanguageRes arg1) {
                return arg0.getLANRESTAG().compareTo(arg1.getLANRESTAG());
            }
        });
        return list;
    }

    @Override
    protected String getObjectId(PSLanguageRes vt) {
        return vt.getPSLANGUAGERESID();
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
}

