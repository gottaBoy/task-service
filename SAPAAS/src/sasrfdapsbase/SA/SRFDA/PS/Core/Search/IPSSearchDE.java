/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDEField;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSearchDE
extends IPSModelObject {
    public IPSDataEntity getPSDataEntity();

    @Override
    public String getCodeName();

    public Iterator<? extends IPSSearchDEField> getAllPSSearchDEFields() throws Exception;

    public IPSSearchDEField getPSSearchDEField(String var1) throws Exception;

    public IPSSearchDEField getPSSearchDEField(String var1, boolean var2) throws Exception;

    public String getDETag();

    public String getDETag2();

    public boolean isNoSQLStorage();
}

