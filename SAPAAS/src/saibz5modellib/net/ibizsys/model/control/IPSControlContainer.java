/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import java.util.Iterator;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSControlContainer
extends IPSModelObject {
    public String getId();

    public String getName();

    public IPSAppView getPSAppView();

    public boolean hasPSControl(String var1);

    public Iterator<IPSControl> getPSControls();

    public IPSControl getPSControl(String var1) throws Exception;

    public Iterator<IPSAjaxControl> getPSAjaxControls();

    public IPSControl registerPSControl(String var1, String var2, IPSControlParam var3) throws Exception;
}

