/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.drctrl.IPSDEDRBarGroup;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlItem;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDEDRBarItem
extends IPSDEDRCtrlItem,
IPSModelObject {
    public IPSDEDRBarGroup getPSDEDRBarGroup();
}

