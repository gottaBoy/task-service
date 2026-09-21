/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.pf.IPSPFObject;

public interface IPSPFPubCode
extends IPSPFObject {
    public static final String TARGETTYPE_VIEW = "VIEW";
    public static final String TARGETTYPE_APP = "APP";
    public static final String TARGETTYPE_VIEWCTRL = "VIEWCTRL";

    public String getTargetType();

    public String getPreviewCode();

    public String getPluginTemplCode();
}

