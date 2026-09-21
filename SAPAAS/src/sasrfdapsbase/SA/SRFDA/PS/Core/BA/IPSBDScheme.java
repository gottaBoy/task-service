/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDTable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBDScheme
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getShortCodeName();

    public String getBDType();

    public Iterator<? extends IPSBDTable> getAllPSBDTables() throws Exception;

    public IPSBDTable getPSBDTable(String var1) throws Exception;

    public IPSBDTable getPSBDTable(String var1, boolean var2) throws Exception;

    public String getSchemeTag();

    public String getSchemeTag2();
}

