/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;

public interface IPSModelJsonExporter2 {
    public ArrayList<ObjectNode> toJsonObjects(ArrayList<ObjectNode> var1) throws Exception;
}

