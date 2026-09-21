/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSUIAction;

@PSModelIgnoreMeta
public abstract class PSAppUIActionImpl
extends PSObjectImpl
implements IPSUIAction,
IPSPFLogicCodeObject {
    private IPSUIAction iPSUIAction = null;

    protected void setPSUIAction(IPSUIAction iPSUIAction) {
        this.iPSUIAction = iPSUIAction;
    }

    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    @Override
    public void fillUIActionItem(Object objUIActionItem) throws Exception {
        this.getPSUIAction().fillUIActionItem(objUIActionItem);
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return ((IPSPFLogicCodeObject)((Object)this.getPSUIAction())).getPFLogicCodeCat();
    }
}

