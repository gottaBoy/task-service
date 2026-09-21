/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.PSAbsoluteLayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSAutoTableLayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSBorderLayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSFlexLayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSGrid12LayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSGrid24LayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSSimpleFlexLayoutImpl;
import SA.SRFDA.PS.Core.Control.Layout.PSTableLayoutImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFramework.DataEx.BaseDataEntity;
import net.ibizsys.paas.util.StringHelper;

public class PSLayoutFactory {
    public static IPSLayout createPSLayout(IPSModelObject iPSModelObject, String strLayoutMode, BaseDataEntity baseDataEntity) throws Exception {
        PSLayout psLayout = new PSLayout();
        psLayout.proxy(baseDataEntity);
        IPSLayout iPSLayout = PSLayoutFactory.createPSLayout(strLayoutMode);
        iPSLayout.init(iPSModelObject, psLayout);
        return iPSLayout;
    }

    protected static IPSLayout createPSLayout(String strLayoutMode) throws Exception {
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_12COL", (boolean)true) == 0) {
            return new PSGrid12LayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE_24COL", (boolean)true) == 0) {
            return new PSGrid24LayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"TABLE", (boolean)true) == 0) {
            return new PSTableLayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"AUTOTABLE", (boolean)true) == 0) {
            return new PSAutoTableLayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"BORDER", (boolean)true) == 0) {
            return new PSBorderLayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"FLEX", (boolean)true) == 0) {
            return new PSFlexLayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"SIMPLEFLEX", (boolean)true) == 0) {
            return new PSSimpleFlexLayoutImpl();
        }
        if (StringHelper.compare((String)strLayoutMode, (String)"ABSOLUTE", (boolean)true) == 0) {
            return new PSAbsoluteLayoutImpl();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5e03\u5c40\u6a21\u5f0f[%1$s]", (Object)strLayoutMode));
    }
}

