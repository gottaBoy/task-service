/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.titlebar.ITitleBar
 */
package net.ibizsys.model.control.titlebar;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.titlebar.ITitleBar;

public interface IPSTitleBar
extends IPSControl,
ITitleBar {
    public static final String TITLEBARTYPE_SYS = "SYSTITLEBAR";
    public static final String TITLEBARTYPE_APP = "APPTITLEBAR";
    public static final String TITLEBARSTYLE_USER = "USER";
    public static final String TITLEBARTYPE_USER2 = "USER2";

    public String getCaption();

    public Iterator<IPSControl> getLeftPSControls();

    public Iterator<IPSControl> getRightPSControls();

    public String getTitleBarStyle();

    public String getTitleBarType();

    public IPSSysImage getPSSysImage();
}

