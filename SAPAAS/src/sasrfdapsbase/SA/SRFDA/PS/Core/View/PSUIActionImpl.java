/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PSModelObject3Impl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFramework.Utility.StringHelper;

public abstract class PSUIActionImpl
extends PSModelObject3Impl
implements IPSUIAction,
IPSPFLogicCodeObject {
    @Override
    public void fillUIActionItem(Object objUIActionItem) throws Exception {
        if (objUIActionItem instanceof PSDEToolbarItem) {
            this.onFillPSDEToolbarItem((PSDEToolbarItem)((Object)objUIActionItem));
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u586b\u5145\u754c\u9762\u64cd\u4f5c\u9879\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)objUIActionItem.getClass().getCanonicalName()));
    }

    protected void onFillPSDEToolbarItem(PSDEToolbarItem psDEToolbarItem) throws Exception {
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return "UIACTION";
    }
}

