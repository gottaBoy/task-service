/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.control.counter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysCounterRef
extends IPSModelObject {
    public IPSSysCounter getPSSysCounter();

    public ObjectNode getRefMode();

    public String getTag();
}

