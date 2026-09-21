/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.Pub;

import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.Pub.IPSAppViewCode;
import SA.SRFDA.PS.Core.App.Pub.PSAppViewCodeImpl;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class PSAppViewCodeGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppViewCode, IPSAppViewCode> {
    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSAppViewCode GetObject(String strPSApplicationViewId) {
        return null;
    }

    @Override
    protected IPSAppViewCode OnCreateModelHelper(PSAppViewCode vt) throws Exception {
        PSAppViewCodeImpl iPSAppViewCode = new PSAppViewCodeImpl();
        iPSAppViewCode.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppViewCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppViewCode obj) {
        return false;
    }

    @Override
    protected IPSAppViewCode registerModel(PSAppViewCode vt) throws Exception {
        IPSAppViewCode iAppViewCode = (IPSAppViewCode)this.InternalGetModelHelper(vt.getPSAPPVIEWCODEID());
        if (iAppViewCode != null) {
            return iAppViewCode;
        }
        this.setModel(vt.getPSAPPVIEWCODEID(), vt, null);
        return (IPSAppViewCode)this.FindModelHelper(vt.getPSAPPVIEWCODEID());
    }

    @Override
    protected Vector<PSAppViewCode> getAllModels() throws Exception {
        Vector<PSAppViewCode> list2 = new Vector<PSAppViewCode>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppViewCodes(this.iPSApplication.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e94\u7528\u5168\u90e8\u89c6\u56fe\u4ee3\u7801\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSAppViewCode> list = new Vector<PSAppViewCode>();
        String strUIStyle = "";
        if (this.getPSApplication().getPSAppUIStyle() != null) {
            strUIStyle = this.getPSApplication().getPSAppUIStyle().getUIStyle();
        }
        for (PSAppViewCode psAppViewCode : list2) {
            if (StringHelper.IsNullOrEmpty((String)strUIStyle) || StringHelper.Compare((String)strUIStyle, (String)"DEFAULT", (boolean)true) == 0) {
                if (!StringHelper.IsNullOrEmpty((String)psAppViewCode.getUISTYLE()) && StringHelper.Compare((String)psAppViewCode.getUISTYLE(), (String)"DEFAULT", (boolean)true) != 0) continue;
                list.add(psAppViewCode);
                continue;
            }
            if (StringHelper.Compare((String)psAppViewCode.getUISTYLE(), (String)strUIStyle, (boolean)true) != 0) continue;
            list.add(psAppViewCode);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppViewCode vt) {
        return vt.getPSAPPVIEWCODEID();
    }
}

