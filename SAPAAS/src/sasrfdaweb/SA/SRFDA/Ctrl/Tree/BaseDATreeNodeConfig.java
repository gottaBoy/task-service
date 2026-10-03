/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.PP.PPTreePanel
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.Ctrl.Tree;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.PP.PPTreePanel;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.Vector;

public class BaseDATreeNodeConfig
extends TreeNodeConfig {
    private SRFDAPage page = null;
    private PPTreePanel ppTreePanel = null;

    public BaseDATreeNodeConfig() {
        this.setAsyncMode(true);
        this.setLeaf(false);
    }

    protected SRFDAPage getPage() {
        return this.page;
    }

    public void setPage(SRFDAPage page) {
        this.page = page;
    }

    public PPTreePanel getPPTreePanel() {
        return this.ppTreePanel;
    }

    public void setPPTreePanel(PPTreePanel ppTreePanel) {
        this.ppTreePanel = ppTreePanel;
    }

    public boolean FromDataRow(DataRow dr) throws Exception {
        String strValue;
        String strId = "";
        String strText = "";
        String strSelectValue = "";
        String strSelectText = "";
        String strImg = "";
        String IDKEY = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String TEXTKEY = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        String SELECTVALUEKEY = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        String SELECTTEXTKEY = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        String TEXTFORMAT = "%1$s";
        String EXSELECTINFOKEY = "";
        String TREEICON = "";
        String strLeafFlag = "";
        String strNodeIdField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODEIDFIELDNull()) {
            strNodeIdField = this.ppTreePanel.getNODEIDFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeIdField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.ID", strNodeIdField)))) {
            IDKEY = strNodeIdField;
            SELECTVALUEKEY = strNodeIdField;
        }
        String strNodeTextField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODETEXTFIELDNull()) {
            strNodeTextField = this.ppTreePanel.getNODETEXTFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeTextField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.TEXT", strNodeTextField)))) {
            TEXTKEY = strNodeTextField;
            SELECTTEXTKEY = strNodeTextField;
        }
        String strNodeSelValueField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODESELVALUEFIELDNull()) {
            strNodeSelValueField = this.ppTreePanel.getNODESELVALUEFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeSelValueField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.SELECTVALUE", strNodeSelValueField)))) {
            SELECTVALUEKEY = strNodeSelValueField;
        }
        String strNodeSelTextField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODESELTEXTFIELDNull()) {
            strNodeSelTextField = this.ppTreePanel.getNODESELTEXTFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeSelTextField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.SELECTTEXT", strNodeSelTextField)))) {
            SELECTTEXTKEY = strNodeSelTextField;
        }
        String strNodeTextFmt = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODETEXTFMTNull()) {
            strNodeTextFmt = this.ppTreePanel.getNODETEXTFMT();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeTextFmt = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.TEXTFORMAT", strNodeTextFmt)))) {
            TEXTFORMAT = strNodeTextFmt;
        }
        if (this.getPage().getPageParam("PAGE.TREEACTIONHELPER.EXSELECTINFO") != null) {
            EXSELECTINFOKEY = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.EXSELECTINFO").toString();
        }
        if (StringHelper.Length((String)EXSELECTINFOKEY) == 0) {
            EXSELECTINFOKEY = this.getPage().getWebContext().GetParamValue("EXSELECTINFO");
        }
        String strNodeIconField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODEICONFIELDNull()) {
            strNodeIconField = this.ppTreePanel.getNODEICONFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeIconField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.TREEICON", strNodeIconField)))) {
            TREEICON = strNodeIconField;
        }
        String strNodeLeafField = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODELEAFFIELDNull()) {
            strNodeLeafField = this.ppTreePanel.getNODELEAFFIELD();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strNodeLeafField = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.LEAF", strNodeLeafField)))) {
            strLeafFlag = strNodeLeafField;
        }
        if (dr == null) {
            return false;
        }
        if (!dr.IsDBNull(IDKEY)) {
            strId = dr.Get(IDKEY).toString();
        }
        String[] arrTextKeys = TEXTKEY.split("\\|");
        Object[] arrTextValues = new Object[arrTextKeys.length];
        int i = 0;
        while (i < arrTextKeys.length) {
            if (StringHelper.Length((String)arrTextKeys[i]) != 0) {
                arrTextValues[i] = !dr.IsDBNull(arrTextKeys[i]) ? dr.Get(arrTextKeys[i]) : "";
            }
            ++i;
        }
        String[] arrExSelectInfo = EXSELECTINFOKEY.split(",");
        int i2 = 0;
        while (i2 < arrExSelectInfo.length) {
            if (StringHelper.Length((String)arrExSelectInfo[i2]) != 0) {
                String key = "";
                String askey = "";
                String[] arrExSelectInfoKeys = arrExSelectInfo[i2].split("\\|");
                if (!StringHelper.IsNullOrEmpty((String)arrExSelectInfoKeys[0])) {
                    key = arrExSelectInfoKeys[0];
                    askey = arrExSelectInfoKeys[0];
                    if (arrExSelectInfoKeys.length > 1 && !StringHelper.IsNullOrEmpty((String)arrExSelectInfoKeys[1])) {
                        askey = arrExSelectInfoKeys[1];
                    }
                    if (!dr.IsDBNull(key)) {
                        this.setTagValue(askey, dr.Get(key));
                    }
                }
            }
            ++i2;
        }
        strText = StringHelper.Format((String)TEXTFORMAT, (Object[])arrTextValues);
        if (!dr.IsDBNull(SELECTVALUEKEY)) {
            strSelectValue = dr.Get(SELECTVALUEKEY).toString();
        }
        if (!dr.IsDBNull(SELECTTEXTKEY)) {
            strSelectText = dr.Get(SELECTTEXTKEY).toString();
        }
        strImg = this.getPage().getDEHelper().getDataEntity().getSMALLICON();
        if (this.getPage().getDEHelper().IsIndexDE()) {
            String strIndexType = "";
            if (!dr.IsDBNull(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName())) {
                strIndexType = dr.Get(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName()).toString();
            }
            Vector<DERINDEX> list = this.getPage().getDEHelper().GetDERINDEXs(true);
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (StringHelper.Compare((String)dERINDEX.getTYPEVALUE(), (String)strIndexType, (boolean)true) != 0) continue;
                strImg = iDEHelper.getDataEntity().getSMALLICON();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)TREEICON) && !dr.IsDBNull(TREEICON)) {
            strImg = dr.Get(TREEICON).toString();
        }
        if (!(StringHelper.IsNullOrEmpty((String)strLeafFlag) || dr.IsDBNull(strLeafFlag) || StringHelper.Compare((String)(strValue = dr.Get(strLeafFlag).toString()), (String)"1", (boolean)true) != 0 && StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) != 0)) {
            this.setLeaf(true);
        }
        this.setIcon(strImg);
        this.setID(strId);
        this.setText(strText);
        this.setTagValue("value", strSelectValue);
        if (StringHelper.Length((String)strSelectText) == 0) {
            strSelectText = strText;
        }
        this.setTagValue("selecttext", strSelectText);
        return true;
    }
}
