/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBAColSet
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDColSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.psba.core.IBAColSet;

@PSModelPFIgnoreMeta
public interface IPSSysBDColSet
extends IPSSysBDTableObject,
IBAColSet,
IPSBDColSet {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDTable var2, PSSysBDColSet var3) throws Exception;

    public Iterator<? extends IPSSysBDColumn> getAllPSSysBDColumns();
}

