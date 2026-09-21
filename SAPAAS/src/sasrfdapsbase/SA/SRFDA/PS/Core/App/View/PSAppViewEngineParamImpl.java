/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngineParam;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSAppViewEngineParamImpl
extends PSObjectImpl
implements IPSAppViewEngineParam {
    private IPSAppViewEngine iPSAppViewEngine = null;
    private String strParamType = null;
    private Object objValue = null;
    private IPSAppViewLogic iPSAppViewLogic = null;
    private IPSControl iPSControl = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppViewEngine iPSAppViewEngine, String strName, String strParamType, Object objValue) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSAppViewEngine = iPSAppViewEngine;
        this.setName(strName);
        this.strParamType = strParamType;
        if (StringHelper.compare((String)this.getParamType(), (String)"LOGIC", (boolean)true) == 0) {
            if (!(objValue instanceof IPSAppViewLogic)) {
                throw new Exception("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e\uff0c\u4e0d\u662f\u89c6\u56fe\u903b\u8f91\u7c7b\u578b");
            }
            this.iPSAppViewLogic = (IPSAppViewLogic)objValue;
        }
        if (StringHelper.compare((String)this.getParamType(), (String)"CTRL", (boolean)true) == 0) {
            if (!(objValue instanceof IPSControl)) {
                throw new Exception("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e\uff0c\u4e0d\u662f\u89c6\u56fe\u90e8\u4ef6\u7c7b\u578b");
            }
            this.iPSControl = (IPSControl)objValue;
        }
        if (StringHelper.compare((String)this.getParamType(), (String)"VALUE", (boolean)true) == 0) {
            this.objValue = objValue;
        }
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u540d\u79f0")
    public String getName() {
        return super.getName();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b")
    public String getParamType() {
        return this.strParamType;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91")
    public IPSAppViewLogic getPSAppViewLogic() {
        return this.iPSAppViewLogic;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u90e8\u4ef6")
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c")
    public Object getValue() {
        return this.objValue;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppViewEngine().getPSSysModelInstId();
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine() {
        return this.iPSAppViewEngine;
    }

    @Override
    public String getModelType() {
        if ("PSPANELENGINE".equals(this.getPSAppViewEngine().getModelType())) {
            return "PSPANELENGINEPARAM";
        }
        return "PSAPPVIEWENGINEPARAM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppViewEngine().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u540d\u79f0")
    public String getCtrlName() {
        if (this.getPSControl() != null) {
            return this.getPSControl().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u903b\u8f91\u540d\u79f0")
    public String getAppViewLogicName() {
        if (this.getPSAppViewLogic() != null) {
            return this.getPSAppViewLogic().getName();
        }
        return null;
    }
}

