/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WS.Common.SRFWSGlobal;
import SA.SRFDA.WS.Ctrl.BaseWSObject;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;

public abstract class BaseWSWebPartHelper
extends BaseWSObject
implements IWSWebPartHelper {
    ISRFDAGlobalHelper iDAGlobalHelper = null;
    IWSWBTypeHelper iWSWBType = null;
    WSWebPart wsWebPart = null;
    IWSWebPartPublishContext iWSWebpartPublishContext = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWSWBTypeHelper iWSWBType, WSWebPart wsWebPart) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.wsWebPart = wsWebPart;
        this.iWSWBType = iWSWBType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
        String strIndexDEFId;
        String strIndexDEFValue;
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(SRFWSGlobal.DEID_WSWEBPART);
        DERINDEX derIndex = iDEHelper.FindDERINDEX(strIndexDEFValue = this.wsWebPart.GetParamStringValue(strIndexDEFId = iDEHelper.GetIndexTypeDEFHelper().getDEField().getDEFNAME(), ""));
        if (derIndex == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5206\u7c7b[%2$s]\u7d22\u5f15\u5bf9\u8c61", (Object)SRFWSGlobal.DEID_WSWEBPART, (Object)strIndexDEFValue));
        }
        String strDEId = derIndex.getDEID();
        IDEHelper mainDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(strDEId);
        String strSql = StringHelper.Format((String)"select * from %1$s where %2$s = '%3$s'", (Object)mainDEHelper.getDataEntity().getVIEWNAME(), (Object)mainDEHelper.GetKeyDEFHelper().getDEField().getDEFNAME(), (Object)this.wsWebPart.getWSWEBPARTID());
        SelectResult selectResult = null;
        try {
            selectResult = this.iDAGlobalHelper.getDBCaller(mainDEHelper.GetDBStorage()).CallRaw2(strSql);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u67e5\u8be2[%2$s]\u53d1\u751f\u9519\u8bef", (Object)strDEId, (Object)strSql));
        }
        if (selectResult == null || selectResult.getMainTable().GetRowCount() != 1) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u7d22\u5f15\u5b9e\u4f53[%3$s]\u8bb0\u5f55[%1$s\uff1a%2$s],\u8be6\u7ec6\uff1a", (Object)strDEId, (Object)this.wsWebPart.getWSWBTYPEID(), (Object)SRFWSGlobal.DEID_WSWEBPART, (Object)(selectResult == null ? "\u65e0" : selectResult.getErrorInfo())));
        }
        this.OnFillIndexDataEntity(selectResult.getMainTable().GetRow(0));
    }

    protected abstract void OnFillIndexDataEntity(DataRow var1) throws Exception;

    @Override
    public void Publish(IWSWebPartPublishContext iWSWebpartPublishContext) throws Exception {
        this.iWSWebpartPublishContext = iWSWebpartPublishContext;
        this.iWSWBType = this.getWSModelStorage().FindWSWBTypeHelper(this.wsWebPart.getWSWBTYPEID());
        iWSWebpartPublishContext.setWebPartPublishedModel(this.iWSWBType.getWSWBType().getTEMPLATE());
        this.OnPublish();
    }

    protected boolean IsPreProcess() {
        return true;
    }

    protected void OnPublish() throws Exception {
        this.iWSWebpartPublishContext.setWebPartPublishedModel(this.OnGetPublishedModel());
    }

    protected String OnGetPublishedModel() throws Exception {
        String strPublishText = "";
        if (this.IsPreProcess()) {
            strPublishText = this.TemplateProcess();
        }
        return strPublishText;
    }

    protected String TemplateProcess() throws Exception {
        String strWebPartTemplModel = this.getWebPartTemplModel();
        TreeMap<String, Object> pageModellMap = new TreeMap<String, Object>();
        this.FillPageWebPartModelContext(pageModellMap);
        StringTemplateLoader templLoader = new StringTemplateLoader();
        templLoader.putTemplate("HTML", strWebPartTemplModel);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)templLoader);
        StringWriter sw = new StringWriter();
        Template templ = config.getTemplate("HTML");
        templ.process(pageModellMap, (Writer)sw);
        return sw.toString();
    }

    protected abstract void FillPageWebPartModelContext(Map<String, Object> var1);

    @Override
    public WSWebPart getWSWebPart() {
        return this.wsWebPart;
    }

    protected IWSPageHelper getWSPageHelper() {
        return this.iWSWebpartPublishContext.getWSPageHelper();
    }

    protected String getWebPartTemplModel() {
        return this.iWSWBType.getWSWBType().getTEMPLATE();
    }
}

