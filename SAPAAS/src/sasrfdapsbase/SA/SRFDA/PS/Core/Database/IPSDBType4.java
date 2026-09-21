/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.DataEx.BaseDataEntity;

@PSModelIgnoreMeta
public interface IPSDBType4 {
    public static final String DBINSTTYPE_PSSYSMODELINST = "PSSYSMODELINST";
    public static final String DBINSTTYPE_PSDBDEVINST = "PSDBDEVINST";
    public static final String DBINSTTYPE_PSDEVCENTERDBINST = "PSDEVCENTERDBINST";

    public void backupDBInst(String var1, BaseDataEntity var2, BaseDataEntity var3, boolean var4) throws Exception;

    public void restoreDBInst(String var1, BaseDataEntity var2, BaseDataEntity var3) throws Exception;
}

