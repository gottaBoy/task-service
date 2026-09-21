/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSJsonNodeSchema
extends IPSJsonNode {
    public static final String FIELD_REF = "$ref";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_TYPE = "type";
    public static final String TYPE_NULL = "null";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_OBJECT = "object";
    public static final String TYPE_ARRAY = "array";
    public static final String TYPE_NUMBER = "number";
    public static final String TYPE_INTEGER = "integer";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_UNKNOWN = "unknown";

    public String getType();

    public String getDescription();

    public IPSJsonNodeSchema getRefPSJsonNodeSchema() throws Exception;

    public boolean isRefMode();

    public String getRefSchemaId();
}

