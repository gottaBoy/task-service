/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepFIPublishContext;
import SA.SRFDA.BI.Ctrl.BIRepPartHelper;
import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.Data.BIRepFilter;
import SA.SRFDA.BI.Ctrl.IBIRepFIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.Vector;

public class BIRepFilterHelper
extends BIRepPartHelper
implements IBIRepFilterHelper {
    protected BIRepFilter biRepFilter = null;
    protected Vector<IBIRepFIHelper> repFIHelpers = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIRepFilter biRepFilter) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepFilter = biRepFilter;
        this.biRepFilter.CopyTo(this.biRepPart, false);
        this.biRepPart.setBIREPPARTID(this.biRepFilter.getBIREPFILTERID());
        this.OnPrepareRepFilterItems();
        this.OnInit();
    }

    protected void OnPrepareRepFilterItems() throws Exception {
        Vector<BIRepFI> list = new Vector<BIRepFI>();
        CallResult callResult = this.getBIModelHelper().GetBIRepFIs(this.biRepFilter.getBIREPFILTERID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8fc7\u6ee4\u5668\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepFI biRepFI : list) {
            IBIRepFIHelper iBIRepFIHelper = this.OnCreateBIRepFIHelper(biRepFI);
            this.repFIHelpers.add(iBIRepFIHelper);
        }
    }

    protected IBIRepFIHelper OnCreateBIRepFIHelper(BIRepFI biRepFI) throws Exception {
        IBIRepFITypeHelper iBIRepFITypeHelper = this.getBIModelStorage().FindBIRepFIType(biRepFI.getFITYPE());
        return iBIRepFITypeHelper.GetBIRepFI(this, biRepFI);
    }

    protected void OnInit() throws Exception {
    }

    @Override
    protected String OnGetDefaultCtrlName() {
        return "SRFBIRepFilter";
    }

    @Override
    public int getCaptionWidth() {
        if (this.biRepFilter.isCAPTIONWIDTHNull()) {
            return 100;
        }
        return this.biRepFilter.getCAPTIONWIDTH();
    }

    @Override
    protected void OnPublish(IBIRepPartPublishContext iBIRepPartPublishContext) throws Exception {
        String strShortNSName = iBIRepPartPublishContext.RegisterNS(this.OnGetNameSpace());
        String strCtrlName = this.OnGetCtrlName();
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("<%1$s:%2$s ", (Object)strShortNSName, (Object)strCtrlName);
        Hashtable<String, String> propertyList = new Hashtable<String, String>();
        this.OnFillCtrlProperties(iBIRepPartPublishContext, propertyList);
        for (String strKey : propertyList.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, (Object)propertyList.get(strKey));
        }
        sb.Append(">\r\n", (Object)strShortNSName, (Object)strCtrlName);
        this.OnPublishPartParams(iBIRepPartPublishContext, strShortNSName, strCtrlName, sb);
        this.OnPublishFilterContent(iBIRepPartPublishContext, sb);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        iBIRepPartPublishContext.setBIRepPIModel(sb.toString());
    }

    protected void OnPublishFilterContent(IBIRepPartPublishContext iBIRepPartPublishContext, StringBuilderEx sb) throws Exception {
        String strFilterLayout = this.biRepFilter.getCUSTOMLAYOUT();
        if (StringHelper.IsNullOrEmpty((String)strFilterLayout)) {
            BIRepFIPublishContext biRepFIPublishContext = new BIRepFIPublishContext();
            biRepFIPublishContext.setBIRepPartPublishContext(iBIRepPartPublishContext);
            biRepFIPublishContext.setAutoLayout(true);
            String strColumnMode = this.biRepFilter.getCOLUMNMODEL();
            int nMaxColumnCount = 1;
            String[] columnModels = null;
            if (!StringHelper.IsNullOrEmpty((String)strColumnMode)) {
                columnModels = strColumnMode.split("[;]");
                nMaxColumnCount = columnModels.length;
            }
            int nRowIndex = 0;
            int nColumnIndex = 0;
            StringBuilderEx sbItem = new StringBuilderEx();
            int i = 0;
            while (i < this.repFIHelpers.size()) {
                IBIRepFIHelper iBIRepFIHelper = this.repFIHelpers.get(i);
                int nColSpan = iBIRepFIHelper.getColumnSpan();
                if (nColSpan > nMaxColumnCount) {
                    nColSpan = nMaxColumnCount;
                }
                while (true) {
                    if (nMaxColumnCount - nColumnIndex >= nColSpan) {
                        biRepFIPublishContext.setRowIndex(nRowIndex);
                        biRepFIPublishContext.setColumnIndex(nColumnIndex);
                        biRepFIPublishContext.setColumnSpan(nColSpan);
                        biRepFIPublishContext.setBIRepFIModel("");
                        iBIRepFIHelper.Publish(biRepFIPublishContext);
                        sbItem.Append("%1$s\r\n", (Object)biRepFIPublishContext.getBIRepFIModel());
                        nColumnIndex += nColSpan;
                        break;
                    }
                    ++nRowIndex;
                    nColumnIndex = 0;
                }
                ++i;
            }
            sb.Append("<Grid>\r\n");
            if (nMaxColumnCount > 1) {
                sb.Append("<Grid.ColumnDefinitions>\r\n");
                i = 0;
                while (i < columnModels.length) {
                    String strWidth = "";
                    strWidth = StringHelper.IsNullOrEmpty((String)columnModels[i]) ? "Auto" : (columnModels[i].indexOf("%") != -1 ? columnModels[i].replace("%", "*") : columnModels[i]);
                    sb.Append("<ColumnDefinition  Width=\"%1$s\"></ColumnDefinition>\r\n", (Object)strWidth);
                    ++i;
                }
                sb.Append("</Grid.ColumnDefinitions>\r\n");
            }
            if (nRowIndex >= 1) {
                sb.Append("<Grid.RowDefinitions>\r\n");
                i = 0;
                while (i <= nRowIndex) {
                    sb.Append("<RowDefinition Height=\"Auto\"></RowDefinition>\r\n");
                    ++i;
                }
                sb.Append("</Grid.RowDefinitions>\r\n");
            }
            sb.Append(sbItem.toString());
            sb.Append("</Grid>\r\n");
        }
    }
}

