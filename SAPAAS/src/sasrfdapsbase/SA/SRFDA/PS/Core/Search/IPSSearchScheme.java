/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSearchDoc;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSearchScheme
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getSearchEngineType();

    public Iterator<? extends IPSSearchDoc> getAllPSSearchDocs() throws Exception;

    public IPSSearchDoc getPSSearchDoc(String var1) throws Exception;

    public IPSSearchDoc getPSSearchDoc(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSearchDE> getAllPSSearchDEs() throws Exception;

    public IPSSearchDE getPSSearchDE(String var1) throws Exception;

    public IPSSearchDE getPSSearchDE(String var1, boolean var2) throws Exception;

    public int getDefaultDocShards();

    public int getDefaultDocReplicas();

    public String getSchemeTag();

    public String getSchemeTag2();
}

