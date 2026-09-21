/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSSystemAS;
import SA.SRFDA.PS.Core.Deploy.PSSystemASImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSystemAS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemASGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemAS, IPSSystemAS> {
    private static final Log log = LogFactory.getLog(PSSystemASGlobalModel.class);

    @Override
    protected PSSystemAS GetObject(String strPSSystemASId) {
        PSSystemAS PSSystemAS2 = new PSSystemAS();
        CallResult callResult = this.iPSModelHelper.getPSSystemAS(strPSSystemASId, PSSystemAS2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5e94\u7528\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemASId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSystemAS2;
    }

    @Override
    protected IPSSystemAS OnCreateModelHelper(PSSystemAS vt) throws Exception {
        PSSystemASImpl iPSSystemAS = new PSSystemASImpl();
        iPSSystemAS.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSystemAS;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystemAS obj) {
        return false;
    }

    @Override
    protected IPSSystemAS registerModel(PSSystemAS vt) throws Exception {
        IPSSystemAS iPSSystemAS = (IPSSystemAS)this.InternalGetModelHelper(vt.getPSSYSTEMASID());
        if (iPSSystemAS != null) {
            return iPSSystemAS;
        }
        this.setModel(vt.getPSSYSTEMASID(), vt, null);
        return (IPSSystemAS)this.FindModelHelper(vt.getPSSYSTEMASID());
    }

    @Override
    protected Vector<PSSystemAS> getAllModels() throws Exception {
        Vector<PSSystemAS> list = new Vector<PSSystemAS>();
        CallResult callResult = this.iPSModelHelper.getPSSystemASes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSystemAS vt) {
        return vt.getPSSYSTEMASID();
    }
}

