/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSJsonNodeSchema;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSJsonArraySchema
extends IPSJsonNodeSchema {
    public static final String FIELD_ITEMS = "items";
    public static final String FIELD_PREFIXITEMS = "prefixItems";
    public static final String FIELD_CONTAINS = "Contains";
    public static final String FIELD_UNIQUEITEMS = "uniqueItems";

    public IPSJsonNodeSchema getPSJsonNodeSchema();

    public boolean isEnableAdditionalItems();

    public boolean isEnableUniqueItems();

    public Iterator<IPSJsonNodeSchema> getPrefixPSJsonNodeSchemas();

    public Iterator<IPSJsonNodeSchema> getContainsPSJsonNodeSchemas();
}

