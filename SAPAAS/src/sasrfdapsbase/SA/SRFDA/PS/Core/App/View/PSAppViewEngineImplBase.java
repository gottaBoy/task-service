/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngineParam;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSUIEngineParam;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSAppViewEngineImplBase
extends PSObjectImpl
implements IPSAppViewEngine,
IPSModelSortable {
    private ArrayList<IPSAppViewEngineParam> psAppViewEngineParamList = null;

    @Override
    public Iterator<? extends IPSAppViewEngineParam> getPSAppViewEngineParams() {
        if (this.psAppViewEngineParamList == null || this.psAppViewEngineParamList.size() == 0) {
            return null;
        }
        return this.psAppViewEngineParamList.iterator();
    }

    protected void registerPSAppViewEngineParam(IPSAppViewEngineParam iPSAppViewEngineParam) throws Exception {
        if (this.psAppViewEngineParamList == null) {
            this.psAppViewEngineParamList = new ArrayList();
        }
        this.psAppViewEngineParamList.add(iPSAppViewEngineParam);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u53c2\u6570\u96c6\u5408", hideempty=true, child=true, rtname="getParams")
    public Iterator<? extends IPSUIEngineParam> getPSUIEngineParams() {
        return this.getPSAppViewEngineParams();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWENGINE";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppView() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppView().getId(), (Object)this.getName());
        }
        return super.getModelId();
    }
}

