/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.angularga;

import java.util.HashMap;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;
import net.ibizsys.model.pub.angularga.PSAngularTemplHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularCtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSAngularTemplHelper.fillParams(params);
    }

    protected String getPSControlCodeName(IPSAppView iPSAppView, IPSControl iPSControl) {
        throw new Error("Unresolved compilation problems: \n\tThe method getPSControlCodeName(IPSAppView, IPSControl) of type PSAngularCtrlCodePublisherImpl must override or implement a supertype method\n\tThe method getFullCodeName() is undefined for the type IPSAppView\n\tThe method Format(String, String, String) is undefined for the type StringHelper\n");
    }
}

