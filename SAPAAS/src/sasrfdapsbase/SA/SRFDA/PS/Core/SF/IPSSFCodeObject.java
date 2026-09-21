/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;

@PSModelIgnoreMeta
public interface IPSSFCodeObject {
    public static final String CODETYPE_PKG = "PKG";
    public static final String CODETYPE_SERVICEBASE = "SERVICEBASE";
    public static final String CODETYPE_DAOBASE = "DAOBASE";
    public static final String CODETYPE_ENTITYBASE = "ENTITYBASE";
    public static final String CODETYPE_DEMODELBASE = "DEMODELBASE";
    public static final String CODETYPE_CODELISTBASE = "CODELISTBASE";
    public static final String CODETYPE_COUNTERBASE = "COUNTERBASE";
    public static final String CODETYPE_SERVICE = "SERVICE";
    public static final String CODETYPE_DAO = "DAO";
    public static final String CODETYPE_ENTITY = "ENTITY";
    public static final String CODETYPE_DEMODEL = "DEMODEL";
    public static final String CODETYPE_CODELIST = "CODELIST";
    public static final String CODETYPE_COUNTER = "COUNTER";
    public static final String CODETYPE_BADAOBASE = "BADAOBASE";
    public static final String CODETYPE_BADAO = "BADAO";

    public String getClassOrPkgName(String var1, IPSSysSFPub var2) throws Exception;

    public String getCodeName();
}

