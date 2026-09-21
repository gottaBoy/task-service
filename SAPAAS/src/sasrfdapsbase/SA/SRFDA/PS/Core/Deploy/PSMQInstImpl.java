/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMQInstImpl
extends PSObjectImpl
implements IPSMQInst {
    private static final Log log = LogFactory.getLog(PSMQInstImpl.class);
    protected PSMQInst psMQInst = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMQInst psMQInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psMQInst = psMQInst;
        this.setId(this.psMQInst.getPSMQINSTID());
        this.setName(this.psMQInst.getPSMQINSTNAME());
        this.setPSObjectData(this.psMQInst);
        this.onInit();
    }

    @Override
    public String getMQType() {
        return this.psMQInst.getMQTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getConnUrl() {
        return this.psMQInst.getCONNSTR();
    }

    @Override
    public String getUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getUserName", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psMQInst.getUSERNAME();
    }

    @Override
    public String getPassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]getPassword", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.psMQInst.getPASSWD();
    }
}

