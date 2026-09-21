/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBATable
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDSchemeObject;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDER;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.psba.core.IBATable;

@PSModelPFIgnoreMeta
public interface IPSSysBDTable
extends IPSBDTable,
IPSSysBDSchemeObject,
IBATable {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDScheme var2, PSSysBDTable var3) throws Exception;

    public Iterator<? extends IPSSysBDColSet> getAllPSSysBDColSets() throws Exception;

    public IPSSysBDColSet getPSSysBDColSet(String var1) throws Exception;

    public void resetPSSysBDColSet(String var1) throws Exception;

    public void resetAllPSSysBDColSets();

    public IPSSysBDColSet getDefaultPSSysBDColSet();

    public Iterator<? extends IPSSysBDTableDE> getAllPSSysBDTableDEs() throws Exception;

    public IPSSysBDTableDE getPSSysBDTableDE(String var1) throws Exception;

    public void resetPSSysBDTableDE(String var1) throws Exception;

    public void resetAllPSSysBDTableDEs();

    public Iterator<? extends IPSSysBDColumn> getAllPSSysBDColumns() throws Exception;

    public IPSSysBDColumn getPSSysBDColumn(String var1) throws Exception;

    public void resetPSSysBDColumn(String var1) throws Exception;

    public void resetAllPSSysBDColumns();

    public Iterator<? extends IPSSysBDTableDER> getAllPSSysBDTableDERs() throws Exception;

    public IPSSysBDTableDER getPSSysBDTableDER(String var1) throws Exception;

    public void resetPSSysBDTableDER(String var1) throws Exception;

    public void resetAllPSSysBDTableDERs();

    public Iterator<IPSSysBDTable> getPSSysBDTables(boolean var1) throws Exception;

    public IPSSysBDTable getInheritPSSysBDTable() throws Exception;

    public IPSSysBDModule getPSSysBDModule();

    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSes(boolean var1) throws Exception;

    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSs(boolean var1) throws Exception;

    public Iterator<? extends IPSSysBDTableRS> getMajorPSSysBDTableRSs() throws Exception;

    public Iterator<? extends IPSSysBDTableRS> getMinorPSSysBDTableRSs() throws Exception;

    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();

    public IPSDataEntity getMinorPSDE();

    public IPSDataEntity getInheritPSDE();
}

