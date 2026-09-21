/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.ISRFExPage
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.WebEx.ISRFExPage;

public interface ISRFDAPage
extends ISRFExPage {
    public IDEDataCtrl getDEDataCtrl2(String var1) throws Exception;

    public String getPageDataEntityId();

    public DataEntity getPageDataEntity();

    public IDAConfigHelper getDAConfigHelper();

    public IDEHelper getDEHelper();

    public IDAModelHelper getDAModelHelper();

    public ISRFDAWebContext getWebContext();

    public IPageHelper getPageData();

    public String getPageType();

    public IDAModelStorage getDAModelStorage();

    public ISRFDAGlobalHelper getDAGlobalHelper();

    public String getPageModel();
}

