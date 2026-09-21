/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEScriptAction;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEScriptActionImpl
extends PSDEActionImplBase
implements IPSDEScriptAction {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEACTION";
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", group="\u57fa\u672c", order=140, doctype="code", fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.psDEAction.getCUSTOMCODE();
    }

    @Override
    protected String onCalcActionMode(String strPSDEActionName) throws Exception {
        String strActionMode = super.onCalcActionMode(strPSDEActionName);
        if (StringHelper.compare((String)strActionMode, (String)"UNKNOWN", (boolean)false) == 0) {
            return "CUSTOM";
        }
        return strActionMode;
    }
}

