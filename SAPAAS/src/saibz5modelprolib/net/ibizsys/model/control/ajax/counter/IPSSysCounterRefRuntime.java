/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 */
package net.ibizsys.model.control.ajax.counter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;

public interface IPSSysCounterRefRuntime
extends IPSSysCounterRef,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, IPSSysCounter var2, ObjectNode var3) throws Exception;
}

