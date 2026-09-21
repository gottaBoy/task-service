/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Enumeration;
import java.util.Hashtable;

public class DAConfigPublishContext
implements IDAConfigPublishContext {
    private IDEHelper iDEHelper = null;
    private boolean bAlwaysPublish = false;
    private Hashtable<String, Object> attributeMap = new Hashtable();
    private ISRFDAPage iPage = null;
    private String strConfigMode = "";
    private BaseDataEntity activeData = null;
    private IDEMainStateHelper iDEMainStateHelper;
    private IDEMainActionHelper iDEMainActionHelper;
    private String strAppendConfigId = "";
    private Hashtable<String, IDEDataCtrl> deDataCtrlMap = new Hashtable();

    @Override
    public IDEHelper getDEHelper() {
        if (this.iDEHelper == null && this.getPage() != null) {
            return this.getPage().getDEHelper();
        }
        return this.iDEHelper;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    @Override
    public ISRFDAPage getPage() {
        return this.iPage;
    }

    public void setPage(ISRFDAPage iPage) {
        this.iPage = iPage;
    }

    @Override
    public ISRFDAWebContext getWebContext() {
        if (this.iPage != null) {
            return this.iPage.getWebContext();
        }
        return null;
    }

    @Override
    public boolean isAlwaysPublish() {
        return this.bAlwaysPublish;
    }

    public void setAlwaysPublish(boolean bAlwaysPublish) {
        this.bAlwaysPublish = bAlwaysPublish;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return this.attributeMap.keys();
    }

    @Override
    public Object getAttribute(String strKey) {
        return this.attributeMap.get(strKey);
    }

    @Override
    public void setAttribute(String strKey, Object objValue) {
        if (objValue == null) {
            this.attributeMap.remove(strKey);
        }
        this.attributeMap.put(strKey, objValue);
    }

    public void From(IDAConfigPublishContext iDAConfigPublishContext) {
        this.setDEHelper(iDAConfigPublishContext.getDEHelper());
        this.setAlwaysPublish(iDAConfigPublishContext.isAlwaysPublish());
        this.setPage(iDAConfigPublishContext.getPage());
        this.setConfigMode(iDAConfigPublishContext.getConfigMode());
        this.setActiveData(iDAConfigPublishContext.getActiveData());
        this.setDEMainState(iDAConfigPublishContext.getDEMainState());
        this.setDEMainAction(iDAConfigPublishContext.getDEMainAction());
        Enumeration<String> en = iDAConfigPublishContext.getAttributeNames();
        while (en.hasMoreElements()) {
            String strKey = en.nextElement();
            this.setAttribute(strKey, iDAConfigPublishContext.getAttribute(strKey));
        }
    }

    @Override
    public String getConfigMode() {
        return this.strConfigMode;
    }

    public void setConfigMode(String strConfigMode) {
        this.strConfigMode = strConfigMode;
    }

    @Override
    public BaseDataEntity getActiveData() {
        return this.activeData;
    }

    @Override
    public void setActiveData(BaseDataEntity baseDataEntity) {
        this.activeData = baseDataEntity;
    }

    public void setDEMainState(IDEMainStateHelper iDEMainStateHelper) {
        this.iDEMainStateHelper = iDEMainStateHelper;
    }

    @Override
    public IDEMainStateHelper getDEMainState() {
        return this.iDEMainStateHelper;
    }

    @Override
    public IDEMainActionHelper getDEMainAction() {
        return this.iDEMainActionHelper;
    }

    public void setDEMainAction(IDEMainActionHelper iDEMainActionHelper) {
        this.iDEMainActionHelper = iDEMainActionHelper;
    }

    @Override
    public String getDEId() {
        if (this.getDEHelper() == null) {
            return "";
        }
        return this.getDEHelper().getId();
    }

    @Override
    public String getAppendConfigId() {
        return this.strAppendConfigId;
    }

    public void setAppendConfigId(String strAppendConfigId) {
        this.strAppendConfigId = strAppendConfigId;
    }

    @Override
    public IDEDataCtrl getDEDataCtrl(String strDEId) throws Exception {
        IDEDataCtrl iDEDataCtrl = this.deDataCtrlMap.get(strDEId);
        if (iDEDataCtrl != null) {
            return iDEDataCtrl;
        }
        if (this.getWebContext() != null) {
            iDEDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl2(strDEId, "SYSTEM", null);
        } else if (this.getDEHelper() != null) {
            iDEDataCtrl = this.getDEHelper().getGlobalHelper().getDAModelStorage().FindDEDataCtrl2(strDEId, "SYSTEM", null);
        } else {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5168\u5c40\u6a21\u578b\u5bf9\u8c61");
        }
        this.deDataCtrlMap.put(strDEId, iDEDataCtrl);
        return iDEDataCtrl;
    }
}

