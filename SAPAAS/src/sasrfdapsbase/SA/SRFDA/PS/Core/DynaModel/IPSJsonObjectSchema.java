/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.DynaModel.IPSJsonProperties;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSJsonObjectSchema
extends IPSJsonNodeSchema {
    public static final String FIELD_PROPERTIES = "properties";
    public static final String FIELD_ADDITIONALPROPERTIES = "additionalProperties";
    public static final String FIELD_PATTERNPROPERTIES = "patternProperties";
    public static final String FIELD_REQUIRED = "required";
    public static final String FIELD_PROPERTYNAMES = "propertyNames";

    public IPSJsonProperties getPSJsonProperties();

    public Iterator<String> getRequired();

    public boolean isEnableAdditionalProperties();

    public IPSJsonNodeSchema getAdditionalPSJsonNodeSchema();
}

