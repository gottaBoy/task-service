/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSystemDBConfig
extends IPSSystemObject {
    public static final String OBJNAME_DEFAULT = "DEFAULT";
    public static final String OBJNAME_UCASE = "UCASE";
    public static final String OBJNAME_LCASE = "LCASE";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSystemDBConfig var3) throws Exception;

    public String getPSDBDevInstId();

    public boolean isDefaultMode();

    public String getTableSpace(String var1);

    public String getDBType();

    public boolean isNoDBInstMode();

    public String getPSDCDBDevInstId();

    public String getPSDCDBDevInstName();

    public boolean isPubModelComment();

    public boolean isPubView();

    public boolean isPubFKey();

    public boolean isPubIndex();

    public boolean isPubModel();

    public String getObjNameCase();

    public String getNullValueOrderMode();
}

