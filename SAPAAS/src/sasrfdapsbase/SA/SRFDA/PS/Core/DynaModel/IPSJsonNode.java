/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeOwner;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import com.fasterxml.jackson.databind.JsonNode;

@PSModelPFIgnoreMeta
public interface IPSJsonNode
extends IPSJsonNodeOwner {
    public static final String FIELD_ALLOF = "allOf";
    public static final String FIELD_ANYOF = "anyOf";
    public static final String FIELD_ONEOF = "oneOf";
    public static final String FIELD_NOT = "not";

    public IPSJsonNodeOwner getPSJsonNodeOwner();

    public JsonNode getJsonNode();
}

