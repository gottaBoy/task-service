/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSBIDimensionObject;
import SA.SRFDA.PS.Core.BI.IPSBILevel;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBIHierarchy
extends IPSBIDimensionObject {
    public static final String HIERARCHYTYPE_DE = "DE";

    @Override
    public IPSBIDimension getPSBIDimension();

    public IPSDataEntity getPSDataEntity();

    public String getHierarchyType();

    public String getHierarchyTag();

    public String getHierarchyTag2();

    public Iterator<? extends IPSBILevel> getAllPSBILevels() throws Exception;

    public IPSBILevel getPSBILevel(String var1) throws Exception;

    public IPSBILevel getPSBILevel(String var1, boolean var2) throws Exception;
}

