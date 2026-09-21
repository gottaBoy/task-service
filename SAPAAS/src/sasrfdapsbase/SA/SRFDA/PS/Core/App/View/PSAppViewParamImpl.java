/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewParam;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSAppViewParamImpl
extends PSObjectImpl
implements IPSAppViewParam {
    private String strValue = "";
    private String strDesc = null;
    private String strKey = "";
    private IPSAppView iPSAppView = null;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSAppView iPSAppView, String strKey, String strValue, String strDesc) throws Exception {
        this.setDAGlobalHelper(iDGlobalHelper);
        this.setId(strKey);
        this.setName(strKey);
        this.iPSAppView = iPSAppView;
        this.strKey = strKey;
        this.strValue = strValue;
        this.strDesc = strDesc;
    }

    @Override
    @PSModelRTMeta(description="\u503c")
    public String getValue() {
        return this.strValue;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570")
    public String getKey() {
        return this.strKey;
    }

    @Override
    @PSModelRTMeta(description="\u8bf4\u660e")
    public String getDesc() {
        return this.strDesc;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public void setDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public void setKey(String strKey) {
        this.strKey = strKey;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppView().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe")
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWEPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppView() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppView().getId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

