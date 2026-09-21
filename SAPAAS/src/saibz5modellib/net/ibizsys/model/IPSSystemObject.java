/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystemObject
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.core.ISystemObject;

public interface IPSSystemObject
extends IPSModelObject,
ISystemObject {
    public IPSSystem getPSSystem();
}

