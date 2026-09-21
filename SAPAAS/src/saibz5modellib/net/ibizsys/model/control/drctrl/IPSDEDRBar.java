/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import java.util.Iterator;
import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.IPSDRBar;

public interface IPSDEDRBar
extends IPSDRBar,
IPSDEDRCtrl {
    public Iterator<IPSDEDRBarGroup> getPSDEDRBarGroups() throws Exception;
}

