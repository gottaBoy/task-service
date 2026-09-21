/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkCondModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.pswf.core.IWFLinkCondModel;

public interface IPSWFLinkCond
extends IPSModelObject,
IWFLinkCondModel {
    public static final String LOGICTYPE_GROUP = "GROUP";
    public static final String LOGICTYPE_SINGLE = "SINGLE";
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public IPSWFLinkCond getParentPSWFLinkCond();

    public IPSWFLink getPSWFLink();

    public String getCondType();
}

