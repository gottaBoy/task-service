/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Core.WX.PSWXAccountObjectImpl;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSWXMenuFuncImpl
extends PSWXAccountObjectImpl
implements IPSWXMenuFunc {
    protected PSWXMenuFunc psWXMenuFunc = null;
    private IPSWXEntApp iPSWXEntApp = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWXAccount iPSWXAccount, IPSWXEntApp iPSWXEntApp, PSWXMenuFunc psWXMenuFunc) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSWXAccount(iPSWXAccount);
        this.iPSWXEntApp = iPSWXEntApp;
        this.psWXMenuFunc = psWXMenuFunc;
        this.setId(this.psWXMenuFunc.getPSWXMENUFUNCID());
        this.setName(this.psWXMenuFunc.getPSWXMENUFUNCNAME());
        this.setPSObjectData(this.psWXMenuFunc);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b")
    public String getWXMenuFuncType() {
        return this.psWXMenuFunc.getFUNCTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u70b9\u51fb\u6807\u8bb0")
    public String getClickTag() {
        return this.psWXMenuFunc.getCLICKTAG();
    }

    @Override
    public IPSWXEntApp getPSWXEntApp() {
        return this.iPSWXEntApp;
    }
}

