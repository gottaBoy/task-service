/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.pf.PSPFImpl
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.pf.PSPFImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSReactPFImpl
extends PSPFImpl {
    public String getPSAppViewPageUrl(IPSAppView iPSAppView) throws Exception {
        String strPageUrl = StringHelper.format((String)"/%1$s/%2$s.jsp", (Object)iPSAppView.getPSAppModule().getCodeName(), (Object)iPSAppView.getName()).toLowerCase();
        return strPageUrl;
    }
}

