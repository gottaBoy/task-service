/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ConfigPublisher
 *  SA.SRFDA.Ctrl.IDAConfigHelperContext
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDAConfigPublisher
 *  SA.SRFDA.Ctrl.IDAConfigPublisherContext
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Data.ConfigPublisher;
import SA.SRFDA.Ctrl.IDAConfigHelperContext;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDAConfigPublisher;
import SA.SRFDA.Ctrl.IDAConfigPublisherContext;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;

public abstract class DAConfigPublisher<T extends IDAConfigPublishContext>
implements IDAConfigPublisher<T>,
IDAConfigPublisherContext {
    protected ConfigPublisher configPublisher = null;
    protected IDAConfigHelperContext iDAConfigHelperContext = null;

    public void Init(IDAConfigHelperContext iDAConfigHelperContext, ConfigPublisher configPublisher) throws Exception {
        this.iDAConfigHelperContext = iDAConfigHelperContext;
        this.configPublisher = configPublisher;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public final IDAConfigHelperContext getDAConfigHelperContext() {
        return this.iDAConfigHelperContext;
    }

    public XMLNode Publish(T iDAConfigPublishContext) throws Exception {
        return this.OnPublish(iDAConfigPublishContext);
    }

    protected abstract XMLNode OnPublish(T var1) throws Exception;

    public final String GetConfigId(T iDAConfigPublishContext) throws Exception {
        String strConfigId = this.OnGetConfigId(iDAConfigPublishContext);
        if (!StringHelper.IsNullOrEmpty((String)iDAConfigPublishContext.getAppendConfigId())) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s", (Object)iDAConfigPublishContext.getAppendConfigId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iDAConfigHelperContext.getPageModel())) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.iDAConfigHelperContext.getPageModel());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iDAConfigHelperContext.getLanguage())) {
            strConfigId = String.valueOf(strConfigId) + "_" + this.iDAConfigHelperContext.getLanguage();
        }
        strConfigId = strConfigId.toUpperCase();
        return strConfigId;
    }

    protected abstract String OnGetConfigId(T var1) throws Exception;

    public String GetLocalization(IDEHelper iDEHelper, String strResId, String strDefault) {
        return this.iDAConfigHelperContext.GetLocalization(iDEHelper, strResId, strDefault);
    }

    public String GetLocalization(IDEHelper iDEHelper, String strResId, String strResId2, String strDefault) {
        return this.iDAConfigHelperContext.GetLocalization(iDEHelper, strResId, strResId2, strDefault);
    }

    public final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAConfigHelperContext.getDAGlobalHelper();
    }

    public final String getLanguage() {
        return this.iDAConfigHelperContext.getLanguage();
    }

    public final String getPageModel() {
        return this.iDAConfigHelperContext.getPageModel();
    }

    public final IDAModelStorage getDAModelStorage() {
        return this.getDAGlobalHelper().getDAModelStorage();
    }

    protected static String AppendPageId(String strConfigId, IDAConfigPublishContext iDAConfigPublishContext) {
        if (iDAConfigPublishContext.getPage() == null) {
            return strConfigId;
        }
        strConfigId = iDAConfigPublishContext.getPage().getPageData() == null ? String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s", (Object)iDAConfigPublishContext.getPage().getPageType()) : String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s_%2$s_%3$s", (Object)iDAConfigPublishContext.getPage().getPageType(), (Object)iDAConfigPublishContext.getPage().getPageData().getId(), (Object)iDAConfigPublishContext.getPage().getPageData().getVersion());
        return strConfigId;
    }
}

