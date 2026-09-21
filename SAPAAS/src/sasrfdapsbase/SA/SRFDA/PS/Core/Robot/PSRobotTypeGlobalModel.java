/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Robot.IPSRobotType;
import SA.SRFDA.PS.Core.Robot.PSRobotTypeImpl;
import SA.SRFDA.PS.Data.PSRobotType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotTypeGlobalModel
extends PSGlobalModelBase<String, PSRobotType, IPSRobotType> {
    private static final Log log = LogFactory.getLog(PSRobotTypeGlobalModel.class);

    @Override
    protected PSRobotType GetObject(String strPSRobotTypeId) {
        PSRobotType PSRobotType2 = new PSRobotType();
        CallResult callResult = this.iPSModelHelper.getPSRobotType(strPSRobotTypeId, PSRobotType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u673a\u5668\u4eba\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSRobotTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSRobotType2;
    }

    @Override
    protected IPSRobotType OnCreateModelHelper(PSRobotType vt) throws Exception {
        PSRobotTypeImpl iPSRobotType = new PSRobotTypeImpl();
        iPSRobotType.init(this.iDAGlobalHelper, vt);
        return iPSRobotType;
    }

    @Override
    protected Boolean TestObjectRenew(PSRobotType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSRobotType vt) {
        return vt.getPSROBOTTYPEID();
    }
}

