/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlTypeImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBarParam;
import SA.SRFDA.PS.Core.Control.TitleBar.PSAppTitleBarImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.PSSysTitleBarImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSTitleBarControlTypeImpl
extends PSControlTypeImpl {
    @Override
    public IPSControl createPSControl(IPSControlParam iPSControlParam) throws Exception {
        IPSTitleBarParam iPSTitleBarParam = (IPSTitleBarParam)iPSControlParam;
        if (StringHelper.Compare((String)iPSTitleBarParam.getTitleBarType(), (String)"SYSTITLEBAR", (boolean)true) == 0) {
            PSSysTitleBarImpl iPSControl = new PSSysTitleBarImpl();
            iPSControl.setPSControlType(this);
            return iPSControl;
        }
        if (StringHelper.Compare((String)iPSTitleBarParam.getTitleBarType(), (String)"APPTITLEBAR", (boolean)true) == 0) {
            PSAppTitleBarImpl iPSControl = new PSAppTitleBarImpl();
            iPSControl.setPSControlType(this);
            return iPSControl;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6807\u9898\u680f\u7c7b\u578b[%1$s]", (Object)iPSTitleBarParam.getTitleBarType()));
    }
}

