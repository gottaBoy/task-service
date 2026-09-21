/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormTabPage;

public interface IPSDEFormTabPanel
extends IPSDEFormDetail {
    public Iterator<IPSDEFormTabPage> getPSDEFormTabPages();
}

