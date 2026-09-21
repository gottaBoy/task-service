/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Func;

import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.Func.PSAppFuncImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppFuncGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppFunc, IPSAppFunc> {
    private static final Log log = LogFactory.getLog(PSAppFuncGlobalModel.class);
    private HashMap<String, String> autoAppFuncCodeNameMap = new HashMap();
    private int nLastAppFuncIndex = 1;

    @Override
    protected PSAppFunc GetObject(String strPSAppFuncId) {
        PSAppFunc psAppFunc = new PSAppFunc();
        CallResult callResult = this.iPSModelHelper.getPSAppFunc(strPSAppFuncId, psAppFunc);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u529f\u80fd[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppFuncId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppFunc.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        if (this.getPSApplication().getPSPFStyle().isAutoNameOrCode()) {
            this.fillPSAppFuncCodeName(psAppFunc);
        }
        return psAppFunc;
    }

    @Override
    protected IPSAppFunc OnCreateModelHelper(PSAppFunc vt) throws Exception {
        PSAppFuncImpl iPSAppFunc = new PSAppFuncImpl();
        iPSAppFunc.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppFunc;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppFunc obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppFunc vt) {
        return vt.getPSAPPFUNCID();
    }

    @Override
    protected IPSAppFunc registerModel(PSAppFunc vt) throws Exception {
        IPSAppFunc iPSAppFunc = (IPSAppFunc)this.InternalGetModelHelper(vt.getPSAPPFUNCID());
        if (iPSAppFunc != null) {
            return iPSAppFunc;
        }
        this.setModel(vt.getPSAPPFUNCID(), vt, null);
        return (IPSAppFunc)this.FindModelHelper(vt.getPSAPPFUNCID());
    }

    @Override
    protected Vector<PSAppFunc> getAllModels() throws Exception {
        Vector<PSAppFunc> list = new Vector<PSAppFunc>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppFuncs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.getPSApplication().getPSPFStyle().isAutoNameOrCode()) {
            for (PSAppFunc psAppFunc : list) {
                if (StringHelper.IsNullOrEmpty((String)psAppFunc.getCODENAME())) continue;
                this.autoAppFuncCodeNameMap.put(psAppFunc.getCODENAME().toUpperCase(), "");
            }
            for (PSAppFunc psAppFunc : list) {
                this.fillPSAppFuncCodeName(psAppFunc);
            }
        }
        for (PSAppFunc psAppFunc : list) {
            this.setModel(psAppFunc.getPSAPPFUNCID(), psAppFunc, null);
        }
        for (PSAppFunc psAppFunc : list) {
            if (StringHelper.IsNullOrEmpty((String)psAppFunc.getCODENAME()) || this.InternalGetModel(psAppFunc.getCODENAME()) == null) continue;
            this.setModel(psAppFunc.getCODENAME(), psAppFunc, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            this.getPSSystemUtil().getPSSysConsole().error(this.getPSApplication().getFullModelName(), StringHelper.Format((String)"\u52a0\u8f7d\u5e94\u7528\u529f\u80fd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40001, objObjectId);
    }

    protected void fillPSAppFuncCodeName(PSAppFunc psAppFunc) {
        if (StringHelper.IsNullOrEmpty((String)psAppFunc.getCODENAME())) {
            String strCodeName;
            do {
                ++this.nLastAppFuncIndex;
            } while (this.autoAppFuncCodeNameMap.containsKey(strCodeName = StringHelper.Format((String)"_%1$s", (Object)this.nLastAppFuncIndex)));
            psAppFunc.setCODENAME(strCodeName);
            this.autoAppFuncCodeNameMap.put(strCodeName, "");
        }
    }

    @Override
    public void appendAllModelHelpers(IPSAppFunc ht) throws Exception {
        super.appendAllModelHelpers(ht);
        this.setModel(ht.getId(), (PSAppFunc)ht.getModelData(), ht);
    }
}

