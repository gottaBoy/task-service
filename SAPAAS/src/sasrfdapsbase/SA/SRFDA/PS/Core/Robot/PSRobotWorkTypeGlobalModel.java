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
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotWorkTypeImpl;
import SA.SRFDA.PS.Data.PSRobotWorkType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotWorkTypeGlobalModel
extends PSGlobalModelBase<String, PSRobotWorkType, IPSRobotWorkType> {
    private static final Log log = LogFactory.getLog(PSRobotWorkTypeGlobalModel.class);

    @Override
    protected PSRobotWorkType GetObject(String strPSRobotWorkTypeId) {
        PSRobotWorkType PSRobotWorkType2 = new PSRobotWorkType();
        CallResult callResult = this.iPSModelHelper.getPSRobotWorkType(strPSRobotWorkTypeId, PSRobotWorkType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u673a\u5668\u4eba\u5de5\u4f5c\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSRobotWorkTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSRobotWorkType2;
    }

    @Override
    protected IPSRobotWorkType OnCreateModelHelper(PSRobotWorkType vt) throws Exception {
        PSRobotWorkTypeImpl iPSRobotWorkType = new PSRobotWorkTypeImpl();
        iPSRobotWorkType.init(this.iDAGlobalHelper, vt);
        return iPSRobotWorkType;
    }

    @Override
    protected Boolean TestObjectRenew(PSRobotWorkType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSRobotWorkType vt) {
        return vt.getPSROBOTWORKTYPEID();
    }
}

