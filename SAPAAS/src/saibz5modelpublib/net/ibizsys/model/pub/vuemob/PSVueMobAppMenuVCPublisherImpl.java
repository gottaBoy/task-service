/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlCodePublisherImpl;

public class PSVueMobAppMenuVCPublisherImpl
extends PSVueMobCtrlCodePublisherImpl {
    protected IPSAppMenu iPSAppMenu = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSAppMenu = (IPSAppMenu)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> hashMap) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tiPSPublisherContext cannot be resolved to a variable\n\tThe method close() is undefined for the type IPSPFCtrlPartCodePublisher\n");
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobAppMenuVCPublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlCodePublisherImpl\n");
    }
}

