/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSearchField;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
public interface IPSSearchDoc
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getLogicName();

    public int getShards();

    public int getReplicas();

    public Iterator<? extends IPSSearchDE> getAllPSSearchDEs() throws Exception;

    public IPSSearchDE getPSSearchDE(String var1) throws Exception;

    public IPSSearchDE getPSSearchDE(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSearchField> getAllPSSearchFields() throws Exception;

    public IPSSearchField getPSSearchField(String var1) throws Exception;

    public IPSSearchField getPSSearchField(String var1, boolean var2) throws Exception;

    public String getDocTag();

    public String getDocTag2();

    public Properties getDocParams();
}

