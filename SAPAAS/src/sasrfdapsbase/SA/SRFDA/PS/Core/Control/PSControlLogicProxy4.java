/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.PSControlLogicProxy3;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelIgnoreMeta
public class PSControlLogicProxy4
extends PSControlLogicProxy3 {
    public PSControlLogicProxy4(IPSControl iPSControl, IPSAppViewLogic iPSAppViewLogic, IPSAppDEUIAction iPSAppDEUIAction) {
        super(iPSControl, iPSAppViewLogic, iPSAppDEUIAction);
    }

    public PSControlLogicProxy4(IPSControl iPSControl, IPSAppViewLogic iPSAppViewLogic) {
        super(iPSControl, iPSAppViewLogic);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0")
    public String getItemName() {
        return null;
    }
}

