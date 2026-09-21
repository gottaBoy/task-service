/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSParam;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDETreeNodeRSParamImpl
extends PSObjectImpl
implements IPSDETreeNodeRSParam {
    private String strValue = "";
    private String strDesc = null;
    private String strKey = "";
    private IPSDETreeNodeRS iPSDETreeNodeRS = null;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSDETreeNodeRS iPSDETreeNodeRS, String strKey, String strValue, String strDesc) throws Exception {
        this.setDAGlobalHelper(iDGlobalHelper);
        this.setId(strKey);
        this.setName(strKey);
        this.iPSDETreeNodeRS = iPSDETreeNodeRS;
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
        return this.getPSDETreeNodeRS().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u5173\u7cfb")
    public IPSDETreeNodeRS getPSDETreeNodeRS() {
        return this.iPSDETreeNodeRS;
    }

    @Override
    public String getModelType() {
        return "PSDETREENODERSEPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSDETreeNodeRS() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDETreeNodeRS().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }
}

