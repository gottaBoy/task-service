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

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFuncAPI;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncItemImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDevSlnMSDepAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepFuncAPIImpl
extends PSDevSlnMSDepFuncItemImplBase
implements IPSDevSlnMSDepFuncAPI {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepFuncAPIImpl.class);
    private String strPSSysServiceAPIId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevSlnSys iPSDevSlnSys, PSDevSlnMSDepAPI psDevSlnMSDepAPI) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        this.strPSSysServiceAPIId = this.psDevSlnMSDepFuncItem.getPSSYSSERVICEAPIID();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="Http\u7aef\u53e3")
    public int getHttpPort() {
        return this.getPSDevSlnMSDepFunc().getHttpPort();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDevSlnSys getPSDevSlnSys() throws Exception {
        return this.getPSDevSlnMSDepFunc().getPSDevSlnSys();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3")
    public IPSSysServiceAPI getPSSysServiceAPI() throws Exception {
        IPSDevSlnSys iPSDevSlnSys = this.getPSDevSlnSys();
        if (iPSDevSlnSys != null) {
            if (StringHelper.isNullOrEmpty((String)this.strPSSysServiceAPIId)) {
                return null;
            }
            return iPSDevSlnSys.getPSSystem().getPSSysServiceAPI(this.strPSSysServiceAPIId);
        }
        return null;
    }

    @Override
    public String getPSDevCenterDBInstId() {
        return this.getPSDevSlnMSDepFunc().getPSDevCenterDBInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5b9e\u4f8b")
    public IPSDBDevInst getPSDBDevInst() {
        return this.getPSDevSlnMSDepFunc().getPSDBDevInst();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u7c7b\u578b", codelist="MSDeployFuncItemType")
    public String getItemType() {
        return "API";
    }

    @Override
    public String getPSDevSlnSysAPIId() {
        return null;
    }
}

