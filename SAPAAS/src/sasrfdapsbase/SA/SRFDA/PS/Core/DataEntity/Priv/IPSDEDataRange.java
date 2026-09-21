/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataRange
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import net.ibizsys.paas.core.IDEDataRange;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(util=true, description="\u5b9e\u4f53\u6570\u636e\u8303\u56f4\u63a5\u53e3")
public interface IPSDEDataRange
extends IDEDataRange {
    public static final int ORG_CURRENT = 1;
    public static final int ORG_PARENT = 2;
    public static final int ORG_CHILD = 4;
    public static final int ORG_NULL = 8;
    public static final int SECTOR_CURRENT = 1;
    public static final int SECTOR_PARENT = 2;
    public static final int SECTOR_CHILD = 4;
    public static final int SECTOR_NULL = 8;

    public boolean isEnableOrgDR();

    public boolean isEnableSecDR();

    public boolean isEnableSecBC();

    public long getOrgDR();

    public long getSecDR();

    public String getSecBC();

    public boolean isEnableUserDR();

    public String getUserDRAction();

    public String getCustomDRMode();

    public String getCustomDRMode2();

    public String getCustomDRModeParam();

    public String getCustomDRMode2Param();
}

