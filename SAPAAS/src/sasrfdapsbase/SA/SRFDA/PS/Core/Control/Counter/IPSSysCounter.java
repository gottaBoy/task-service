/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterItem;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u8ba1\u6570\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysCounter")
public interface IPSSysCounter
extends IPSModelObject,
IPSSystemObject,
IPSSFCodeObject,
IPSSysSFPubObject,
IPSNavigateParamContainer {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysCounter var3) throws Exception;

    public String getCounterType();

    public IPSCounterType getPSCounterType();

    @Override
    public String getCodeName();

    public String getBaseClass(String var1) throws Exception;

    public int getTimer();

    public boolean getRefFlag();

    public IPSSystemModule getPSSystemModule();

    public boolean isSubSysCounter();

    public Iterator<IPSSysCounterItem> getPSSysCounterItems();

    public IPSCounter getPSCounter();

    public IPSDataEntity getPSDataEntity();

    public IPSDEAction getPSDEAction() throws Exception;

    public IPSDEDataSet getPSDEDataSet() throws Exception;

    public IPSXCodeObject getRender();

    public String getCounterData();

    public String getCounterData2();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getPSCounterId();

    public String getCustomCond();

    public String getUniqueTag();
}

