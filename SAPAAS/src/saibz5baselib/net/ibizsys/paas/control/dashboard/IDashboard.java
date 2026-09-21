/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.dashboard;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.dashboard.IPortlet;

public interface IDashboard
extends IControl {
    public double[] getColumnModels();

    public Iterator<IPortlet> getPortlets();
}

