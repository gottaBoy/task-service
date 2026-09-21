/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysCss
extends IPSSystemObject,
IPSModelObject {
    public String getPSCssTemplId();

    public String getCssName();

    public String getCssStyle();

    public String getRawCssStyle();
}

