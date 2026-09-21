/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

public class PSSysCounterRefImpl
extends PSObjectImpl
implements IPSSysCounterRef {
    private IPSSysCounter iPSSysCounter;
    private JSONObject jsonRefMode;
    private String strTag = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysCounter iPSSysCounter, JSONObject jsonRefMode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysCounter = iPSSysCounter;
        this.jsonRefMode = jsonRefMode;
        this.setId(StringHelper.format((String)"%1$s|%2$s", (Object)iPSSysCounter.getId(), (Object)jsonRefMode.toString()));
        this.setName(StringHelper.format((String)"%1$s|%2$s", (Object)iPSSysCounter.getName(), (Object)jsonRefMode.toString()));
        this.strTag = Helper.GenUniqueId((String)iPSSysCounter.getId(), (String)jsonRefMode.toString());
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668", outputdoc="false")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f")
    public JSONObject getRefMode() {
        return this.jsonRefMode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysCounter.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6807\u8bb0")
    public String getTag() {
        return this.strTag;
    }

    @Override
    public String getModelType() {
        return "PSSYSCOUNTERREF";
    }

    @Override
    public String getModelId() {
        return this.getTag();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getCodeName() {
        return this.strTag;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u7b97\u5668\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.iPSSysCounter.getUniqueTag();
    }
}

