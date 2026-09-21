/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDevSlnSysDynaInst
extends IPSObject {
    public static final String INSTTYPE_DEFAULT = "DEFAULT";
    public static final String INSTTYPE_MODULE = "MODULE";

    public IPSDevSlnSys getPSDevSlnSys();

    public String getInstType();

    public int getInstState();

    public String getInstTag();

    public String getInstTag2();

    public String getInstTag3();

    public String getInstTag4();

    public String getPSDevCenterId();

    public String getPPSDevSlnSysDynaInstId();

    public String getPSDevSlnId();
}

