/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResBooking.PSBookingResTypeImpl;
import SA.SRFDA.PS.Data.PSBookingResType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSBookingResTypeGlobalModel
extends PSGlobalModelBase<String, PSBookingResType, IPSBookingResType> {
    private static final Log log = LogFactory.getLog(PSBookingResTypeGlobalModel.class);

    @Override
    protected PSBookingResType GetObject(String strPSBookingResTypeId) {
        PSBookingResType psBookingResType = new PSBookingResType();
        CallResult callResult = this.iPSModelHelper.getPSBookingResType(strPSBookingResTypeId, psBookingResType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9884\u7ea6\u8d44\u6e90\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSBookingResTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psBookingResType;
    }

    @Override
    protected IPSBookingResType OnCreateModelHelper(PSBookingResType vt) throws Exception {
        IPSBookingResType iPSBookingResType = null;
        iPSBookingResType = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new PSBookingResTypeImpl() : (IPSBookingResType)ObjectHelper.create((String)vt.getTYPEHELPER());
        iPSBookingResType.init(this.iDAGlobalHelper, vt);
        return iPSBookingResType;
    }

    @Override
    protected Boolean TestObjectRenew(PSBookingResType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSBookingResType vt) {
        return vt.getPSBOOKINGRESTYPEID();
    }
}

