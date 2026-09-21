/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysPDTView
extends IPSSystemObject,
IPSModelObject {
    public String getPSPDTViewId();

    public String getPSDEViewBaseId();

    public String getCaption(String var1);
}

