/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.IDAMBConfigHelperContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Mobile.UIPart.Model.MBListConfig
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSItemConfig
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Mobile.UIPart;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.IDAMBConfigHelperContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.Ctrl.DAMBConfigHelperContext;
import SA.SRFDA.Mobile.Ctrl.MBConfigMgrHelper;
import SA.SRFDA.Mobile.UIPart.BaseMobileUIPart;
import SA.SRFDA.Mobile.UIPart.IMobileList;
import SA.SRFDA.Mobile.UIPart.IMobilePublishContext;
import SA.SRFDA.Mobile.UIPart.Model.MBListConfig;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSItemConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Hashtable;

public abstract class BaseMobileList
extends BaseMobileUIPart
implements IMobileList {
    protected MBList mbList;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, String strId, MBList mbList) throws Exception {
        this.mbList = mbList;
        if (this.mbList == null) {
            throw new Exception("\u79fb\u52a8\u5e94\u7528\u5217\u8868\u5bf9\u8c61\u65e0\u6548");
        }
        this.BaseInit(iDAGlobalHelper, iDEHelper, strId);
    }

    @Override
    protected String OnUIPartCodeGetExtendClass(IMobilePublishContext context) {
        return "Ext.List";
    }

    @Override
    protected void OnUIPartCodeGenerate(IMobilePublishContext context, StringBuilderEx sb) throws Exception {
        this.OnModelCodeGenerate(context, sb);
        super.OnUIPartCodeGenerate(context, sb);
    }

    protected void OnModelCodeGenerate(IMobilePublishContext context, StringBuilderEx sb) throws Exception {
        DAMBConfigHelperContext daMBContextHelperContext = new DAMBConfigHelperContext();
        daMBContextHelperContext.setDEHelper(this.getDEHelper());
        daMBContextHelperContext.setMBList(this.mbList);
        String strConfigId = this.getDAGlobalHelper().getDAMBConfigHelper(context.getLanguage(), "").GetMBListConfigId((IDAMBConfigHelperContext)daMBContextHelperContext);
        MBListConfig listConfig = MBConfigMgrHelper.GetMBListMgr(this.getDAGlobalHelper()).GetMBListConfig(strConfigId);
        if (listConfig == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u79fb\u52a8\u5217\u8868\u914d\u7f6e[%1$s]", (Object)strConfigId));
        }
        sb.Append("/*\u6ce8\u518c\u6a21\u578b*/\r\n");
        sb.Append("Ext.regModel('%1$sModel',{\r\n", (Object)this.getUniqueName());
        sb.Append("fields: [");
        boolean bFirst = true;
        int i = 0;
        while (i < listConfig.getDSConfig().getList().size()) {
            MBUIPartDSItemConfig dataGridDSItemConfig = (MBUIPartDSItemConfig)listConfig.getDSConfig().getList().get(i);
            if (bFirst) {
                bFirst = false;
            } else {
                sb.Append(",");
            }
            sb.Append("'%1$s'", (Object)dataGridDSItemConfig.getID().toLowerCase());
            ++i;
        }
        sb.Append("]\r\n");
        sb.Append("});\r\n");
    }

    @Override
    protected String OnGetPublishJSFileName() {
        return StringHelper.Format((String)"MBLIST_%1$s.js", (Object)this.mbList.getMBLISTID());
    }

    @Override
    protected String OnGetUniqueName(IMobilePublishContext context) throws Exception {
        return context.CalcUniqueName(StringHelper.Format((String)"%1$sList", (Object)this.strDEJSObjectName));
    }

    @Override
    protected void OnUIPartCodePrepareProperties(IMobilePublishContext context, Hashtable<String, String> properties) throws Exception {
        String line;
        super.OnUIPartCodePrepareProperties(context, properties);
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("new Ext.XTemplate(\r\n");
        BufferedReader br = new BufferedReader(new StringReader(this.mbList.getITEMTPL()));
        while ((line = br.readLine()) != null) {
            sb.Append("'%1$s',\r\n", (Object)line);
        }
        br.close();
        sb.Append("{");
        if (!StringHelper.IsNullOrEmpty((String)this.mbList.getITEMTPLFUNC())) {
            sb.Append(this.mbList.getITEMTPLFUNC());
        }
        sb.Append("}");
        sb.Append(")");
        properties.put("itemTpl", sb.toString());
    }
}

