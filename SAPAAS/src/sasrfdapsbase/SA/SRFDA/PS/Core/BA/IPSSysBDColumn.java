/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBAColumn
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableObject;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.psba.core.IBAColumn;

@PSModelPFIgnoreMeta
public interface IPSSysBDColumn
extends IPSSysBDTableObject,
IBAColumn,
IPSBDColumn {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDTable var2, PSSysBDColumn var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public IPSSysBDTableDE getPSSysBDTableDE();

    public IPSSysBDColSet getPSSysBDColSet();

    public IPSDEField getPSDEField();
}

