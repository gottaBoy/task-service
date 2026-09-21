/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import com.fasterxml.jackson.databind.node.ObjectNode;

@PSModelIgnoreMeta
public interface IPSModelExporter {
    public static final String MODE_SELF = "SELF";
    public static final String MODE_SIMPLE = "SIMPLE";

    public ObjectNode toJsonObject(ObjectNode var1, IPSModelObject var2, String var3) throws Exception;
}

