/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplicationObject
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.res.IPSSysPDTView
 */
package net.ibizsys.model.app;

import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.res.IPSSysPDTView;

public interface IPSAppPDTView
extends IPSApplicationObject {
    public IPSSysPDTView getPSSysPDTView();

    public IPSAppView getPSAppView() throws Exception;
}

