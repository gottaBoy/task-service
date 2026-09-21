/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  IPSAppVfiew
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pub.PSPFCtrlCodePublisherImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSVueMobCtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problem: \n\tPSFR7TemplHelper cannot be resolved\n");
    }

    protected String getPSControlCodeName(IPSAppVfiew iPSAppVfiew, IPSControl iPSControl) {
        throw new Error("Unresolved compilation problems: \n\tIPSAppVfiew cannot be resolved to a type\n\tThe method ormat(String, String, String) is undefined for the type StringHelper\n");
    }
}

