/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataImport
 */
package SA.SRFDA.PS.Core.DataEntity.DataImport;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImportItem;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEDataImport;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataImp")
public interface IPSDEDataImport
extends IPSDataEntityObject,
IDEDataImport {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDataImport var3) throws Exception;

    @Override
    public String getCodeName();

    public Iterator<IPSDEDataImportItem> getPSDEDataImportItems();

    public IPSDEAction getCreatePSDEAction();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getCreatePSDEOPPriv();

    public IPSDEOPPriv getUpdatePSDEOPPriv();

    public boolean isEnableBackend();

    public boolean isEnableFront();

    public int getActionHolder();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();

    public int getBatchSize();

    public boolean isDefaultMode();

    public boolean isIgnoreError();

    public String getCreateDataAccessAction();

    public String getUpdateDataAccessAction();

    public int getPOTime();

    public boolean isValid();

    public boolean isEnableCustomized();

    public String getImpTag();

    public String getImpTag2();

    public Properties getImpParams();
}

