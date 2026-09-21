/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFDLogic;

public interface IPSDEFDGroupLogic
extends IPSDEFDLogic {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSDEFDLogic> getPSDEFDLogics();
}

