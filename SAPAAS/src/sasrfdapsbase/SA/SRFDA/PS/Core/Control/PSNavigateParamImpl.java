/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSNavigateParamImpl
extends PSObjectImpl
implements IPSNavigateParam {
    private String strValue = "";
    private String strDesc = null;
    private String strKey = "";
    private IPSModelObject iPSModelObject = null;
    private boolean bRawValue = false;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSModelObject iPSModelObject, String strKey, String strValue, String strDesc, boolean bRawValue) throws Exception {
        this.setDAGlobalHelper(iDGlobalHelper);
        this.setId(strKey);
        this.setName(strKey);
        this.iPSModelObject = iPSModelObject;
        this.strKey = strKey;
        this.strValue = strValue;
        this.strDesc = strDesc;
        this.bRawValue = bRawValue;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c")
    public boolean isRawValue() {
        return this.bRawValue;
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
        return this.iPSModelObject.getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.iPSModelObject.getModelId(), (Object)this.getName());
    }

    public IPSModelObject getPSModelObject() {
        return this.iPSModelObject;
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSNAVIGATEPARAM", (Object)this.getPSModelObject().getModelType());
    }
}

