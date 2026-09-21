/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.panel;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.panel.IPanelField;

public interface IPanel
extends IControl {
    public Iterator<IPanelField> getPanelFields();

    public IPanelField getPanelField(String var1, boolean var2) throws Exception;
}

