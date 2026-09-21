/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSModelInfo {
    public static final String TYPE_INFO = "info";
    public static final String TYPE_WARN = "warn";
    public static final String TYPE_ERROR = "error";

    public String getTag();

    public String getInfo();

    public String getType();

    public String getLinkTag();
}

