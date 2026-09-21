/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.paas.core;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IDynaModelJsonExporter {
    public ObjectNode toJsonObject(ObjectNode var1) throws Exception;
}

