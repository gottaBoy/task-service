/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSUIActionParamImpl
extends PSObjectImpl
implements IPSUIActionParam {
    private String strValue = "";
    private String strDesc = null;
    private String strKey = "";
    private IPSUIAction iPSUIAction = null;
    private boolean bRawValue = false;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSUIAction iPSUIAction, String strKey, String strValue, String strDesc, boolean bRawValue) throws Exception {
        this.setDAGlobalHelper(iDGlobalHelper);
        this.setId(strKey);
        this.setName(strKey);
        this.iPSUIAction = iPSUIAction;
        this.strKey = strKey;
        this.strValue = strValue;
        this.strDesc = strDesc;
        this.bRawValue = bRawValue;
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
        return this.iPSUIAction.getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.iPSUIAction.getModelId(), (Object)this.getName());
    }

    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSUIACTIONPARAM", (Object)this.getPSUIAction().getModelType());
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c")
    public boolean isRawValue() {
        return this.bRawValue;
    }
}

