/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEMobCalendarView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEMobCalendarView;
import net.ibizsys.model.app.view.PSAppDECalendarViewImpl;

public class PSAppDEMobCalendarViewImpl
extends PSAppDECalendarViewImpl
implements IPSAppDEMobCalendarView {
    @Override
    public boolean isMobileView() {
        return true;
    }
}

