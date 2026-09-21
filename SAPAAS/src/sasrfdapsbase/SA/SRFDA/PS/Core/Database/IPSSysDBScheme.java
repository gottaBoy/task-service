/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDBScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u6570\u636e\u5e93\u4f53\u7cfb\u5bf9\u8c61\u63a5\u53e3", model="PSSysDBScheme")
public interface IPSSysDBScheme
extends IPSSystemObject,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDBScheme var3) throws Exception;

    @Override
    public String getCodeName();

    public String getCodeName2();

    public String getDSLink();

    public Iterator<IPSSysDBTable> getAllPSSysDBTables() throws Exception;

    public IPSSysDBTable getPSSysDBTable(String var1) throws Exception;

    public IPSSysDBTable getPSSysDBTable(String var1, boolean var2) throws Exception;

    public void resetPSSysDBTable(String var1) throws Exception;

    public void resetAllPSSysDBTables();

    public IPSSystemModule getPSSystemModule();

    public void load(int var1) throws Exception;

    public int getLoadingLevel();

    public int getLoadedLevel();

    public String getSchemeTag();

    public String getSchemeTag2();

    public boolean isExistingModel();

    public boolean isAutoExtendModel();

    public IPSSysModelGroup getPSSysModelGroup();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getSaaSDataIdColumnName();

    public String getSaaSDCIdColumnName();

    public String getDBInstTag();

    public boolean isPubIndex();

    public boolean isEnableFKeyIndex();

    public boolean isEnableSaaSDCIdIndex();

    public String getDBObjNameCase();
}

