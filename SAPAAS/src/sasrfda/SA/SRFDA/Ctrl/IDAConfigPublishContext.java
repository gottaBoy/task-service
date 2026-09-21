/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Enumeration;

public interface IDAConfigPublishContext {
    public String getDEId();

    public boolean isAlwaysPublish();

    public IDEHelper getDEHelper();

    public IDEMainStateHelper getDEMainState();

    public IDEMainActionHelper getDEMainAction();

    public ISRFDAWebContext getWebContext();

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);

    public String getConfigMode();

    public BaseDataEntity getActiveData();

    public void setActiveData(BaseDataEntity var1);

    public Enumeration<String> getAttributeNames();

    public ISRFDAPage getPage();

    public String getAppendConfigId();

    public IDEDataCtrl getDEDataCtrl(String var1) throws Exception;
}

