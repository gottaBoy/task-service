/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.CodeList.DACodeListMgr;
import SA.SRFDA.Common.DAConfigMgr;
import SA.SRFDA.Ctrl.DEDCProcessStorage;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.RegisterMgr;
import SA.SRFDA.Ctrl.ServiceMgr;
import SA.SRFDA.Model.IDAFormItemHelper;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;

public interface ISRFDAGlobalHelper
extends ISRFExGlobalHelper {
    public DAConfigMgr getDAConfigMgr();

    public IDAModelStorage getDAModelStorage();

    public IDEDataCtrlHelper getDEDataCtrlHelper();

    public IDEDataCtrlHelper getDEDataCtrlHelper(String var1);

    public IDAModelHelper getDAModelHelper();

    public IDAFormItemHelper getDAFormItemHelper();

    public DACodeListMgr getCodeListMgr();

    public IDAConfigHelper getDAConfigHelper(String var1, String var2);

    public IDAMBConfigHelper getDAMBConfigHelper(String var1, String var2) throws Exception;

    public int getDAModelVersion();

    public String getDAModelDB();

    public DEDCProcessStorage getDEDCProcessStorage();

    public RegisterMgr getRegisterMgr();

    public ServiceMgr getServiceMgr();

    public ISRFDAPOLogger getPOLoggerEx();

    public IDataNotifyHelper getDataNotifyHelper();

    public IPasswordStorage getPasswordStorage() throws Exception;

    public String getAppMode();
}

