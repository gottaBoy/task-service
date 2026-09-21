/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBAScheme
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysBDScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.psba.core.IBAScheme;

@PSModelPFIgnoreMeta
public interface IPSSysBDScheme
extends IPSBDScheme,
IPSSystemObject,
IBAScheme,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysBDScheme var3) throws Exception;

    public Iterator<String> getBDTypes();

    public boolean isDefaultMode();

    public Iterator<? extends IPSSysBDModule> getAllPSSysBDModules() throws Exception;

    public IPSSysBDModule getPSSysBDModule(String var1) throws Exception;

    public void resetPSSysBDModule(String var1) throws Exception;

    public void resetAllPSSysBDModules();

    public Iterator<? extends IPSSysBDPart> getAllPSSysBDParts() throws Exception;

    public IPSSysBDPart getPSSysBDPart(String var1) throws Exception;

    public void resetPSSysBDPart(String var1) throws Exception;

    public void resetAllPSSysBDParts();

    public Iterator<? extends IPSSysBDTable> getAllPSSysBDTables() throws Exception;

    public IPSSysBDTable getPSSysBDTable(String var1) throws Exception;

    public IPSSysBDTable getPSSysBDTable(String var1, boolean var2) throws Exception;

    public void resetPSSysBDTable(String var1) throws Exception;

    public void resetAllPSSysBDTables();

    public Iterator<IPSSysBDTableRS> getAllPSSysBDTableRSes() throws Exception;

    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSs() throws Exception;

    public IPSSysBDTableRS getPSSysBDTableRS(String var1) throws Exception;

    public IPSSysBDTableRS getPSSysBDTableRS(String var1, boolean var2) throws Exception;

    public void resetPSSysBDTableRS(String var1) throws Exception;

    public void resetAllPSSysBDTableRSes();

    public void resetAllPSSysBDTableRSs();

    public boolean isDefault();

    public String getRowKeySeparator();

    public IPSSystemModule getPSSystemModule();

    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public IPSSysModelGroup getPSSysModelGroup();

    public String getDBObjNameCase();
}

