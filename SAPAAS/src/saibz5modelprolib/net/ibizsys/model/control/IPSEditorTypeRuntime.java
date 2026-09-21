/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSEditorType
 */
package net.ibizsys.model.control;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.entity.PSEditorType;

public interface IPSEditorTypeRuntime
extends IPSEditorType {
    public void init(IPSModelStorageContext var1, PSEditorType var2) throws Exception;
}

