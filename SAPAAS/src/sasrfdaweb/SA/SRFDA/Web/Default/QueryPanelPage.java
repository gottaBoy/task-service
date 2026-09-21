/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER11
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERCUSTOM
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExTextBox
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExTextBox;
import java.util.Vector;

public class QueryPanelPage
extends SRFDAPage {
    protected String strDEID = "";
    protected String strPDEID = "";
    protected String strPPanelId = "";
    protected SRFExDropDownList ddlDataEntities = null;
    protected SRFExTextBox tbDataEntity = null;
    protected SRFExTextBox tbAlias = null;
    protected SRFExHidden hdDataEntity = null;
    protected SRFExButton btnAddRelation = null;
    protected SRFExButton btnAddExtSelect = null;
    protected SRFExButton btnRemoveRelation = null;
    protected SRFExButton btnShowFilter = null;
    protected SRFExButton btnAddGroupLogic = null;
    protected SRFExButton btnAddSingleLogic = null;
    protected SRFExButton btnAddCustomLogic = null;
    protected SRFExButton btnRemoveLogic = null;
    protected boolean bMainQuery = false;
    protected String strDERFullId = "";
    protected boolean bConditionOnly = false;
    protected boolean bExtSelect = false;
    protected boolean bLeftOuterJoin = false;
    protected boolean bRightJoin = false;

    public QueryPanelPage() {
        this.setMainPage(false);
        this.setJSCache(false);
    }

    public String GetCurDEID() {
        return this.strDEID;
    }

    protected void OnInitComponents() {
        CallResult callResult;
        String[] arr;
        this.strDEID = this.getWebContext().getSRFDEID();
        this.strPDEID = this.getWebContext().getSRFPDEID();
        this.strPPanelId = this.getWebContext().GetParamValue("PPANELID");
        this.strDERFullId = this.getWebContext().GetParamValue("DERFULLID");
        this.bConditionOnly = StringHelper.Compare((String)this.getWebContext().GetParamValue("CONDONLY"), (String)"TRUE", (boolean)true) == 0;
        this.bExtSelect = StringHelper.Compare((String)this.getWebContext().GetParamValue("EXTSELECT"), (String)"TRUE", (boolean)true) == 0;
        this.bLeftOuterJoin = StringHelper.Compare((String)this.getWebContext().GetParamValue("LEFTOUTERJOIN"), (String)"TRUE", (boolean)true) == 0;
        boolean bl = this.bRightJoin = StringHelper.Compare((String)this.getWebContext().GetParamValue("RIGHTJOIN"), (String)"TRUE", (boolean)true) == 0;
        if (this.strPDEID.indexOf(":") != -1 && (arr = this.strPDEID.split("[:]")).length == 3) {
            this.strPDEID = arr[2];
        }
        this.setID(this.strPPanelId);
        super.OnInitComponents();
        boolean bl2 = this.bMainQuery = !StringHelper.IsNullOrEmpty((String)this.strDEID);
        if (!this.bMainQuery && !StringHelper.IsNullOrEmpty((String)this.strDERFullId) && (arr = this.strDERFullId.split("[:]")).length == 3) {
            DER11 der11;
            DER1N der1N;
            if (StringHelper.Compare((String)"N1", (String)arr[0], (boolean)true) == 0 || StringHelper.Compare((String)"N1RIGHT", (String)arr[0], (boolean)true) == 0) {
                der1N = new DER1N();
                callResult = this.getDAModelHelper().GetDER1N(arr[1], der1N);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der1N.getMAJORDEID();
                this.strPDEID = der1N.getMINORDEID();
            }
            if (StringHelper.Compare((String)"1N", (String)arr[0], (boolean)true) == 0 || StringHelper.Compare((String)"1NNOT", (String)arr[0], (boolean)true) == 0) {
                der1N = new DER1N();
                callResult = this.getDAModelHelper().GetDER1N(arr[1], der1N);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der1N.getMINORDEID();
                this.strPDEID = der1N.getMAJORDEID();
            }
            if (StringHelper.Compare((String)"1NLEFTOUT", (String)arr[0], (boolean)true) == 0) {
                der1N = new DER1N();
                callResult = this.getDAModelHelper().GetDER1N(arr[1], der1N);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der1N.getMINORDEID();
                this.strPDEID = der1N.getMAJORDEID();
            }
            if (StringHelper.Compare((String)"11", (String)arr[0], (boolean)true) == 0) {
                der11 = new DER11();
                callResult = this.getDAModelHelper().GetDER11(arr[1], der11);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der11.getMAJORDEID();
                this.strPDEID = der11.getMINORDEID();
            }
            if (StringHelper.Compare((String)"11M", (String)arr[0], (boolean)true) == 0) {
                der11 = new DER11();
                callResult = this.getDAModelHelper().GetDER11(arr[1], der11);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der11.getMINORDEID();
                this.strPDEID = der11.getMAJORDEID();
            }
            if (StringHelper.Compare((String)"CUSTOMN1", (String)arr[0], (boolean)true) == 0) {
                der1N = new DERCUSTOM();
                callResult = this.getDAModelHelper().GetDERCUSTOM(arr[1], (DERCUSTOM)der1N);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der1N.getMAJORDEID();
                this.strPDEID = der1N.getMINORDEID();
            }
            if (StringHelper.Compare((String)"CUSTOM1N", (String)arr[0], (boolean)true) == 0 || StringHelper.Compare((String)"CUSTOM1NNOT", (String)arr[0], (boolean)true) == 0) {
                der1N = new DERCUSTOM();
                callResult = this.getDAModelHelper().GetDERCUSTOM(arr[1], (DERCUSTOM)der1N);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.strDEID = der1N.getMINORDEID();
                this.strPDEID = der1N.getMAJORDEID();
            }
        }
        StringBuilderEx script = new StringBuilderEx();
        if (!this.bConditionOnly) {
            this.hdDataEntity = new SRFExHidden();
            this.hdDataEntity.InitConfig();
            this.hdDataEntity.setID("hdDataEntity");
            this.AddControl((SRFExControl)this.hdDataEntity);
            this.tbAlias = new SRFExTextBox();
            this.tbAlias.InitConfig();
            this.tbAlias.setID("tbAlias");
            this.tbAlias.getTextBoxConfig().setWidthEx(1.0);
            this.AddControl((SRFExControl)this.tbAlias);
            if (this.bMainQuery) {
                this.tbDataEntity = new SRFExTextBox();
                this.tbDataEntity.InitConfig();
                this.tbDataEntity.setID("tbDataEntity");
                this.tbDataEntity.getTextBoxConfig().setWidthEx(1.0);
                this.tbDataEntity.getTextBoxConfig().setReadOnly(true);
                DataEntity dataEntity = new DataEntity();
                callResult = this.getDAModelHelper().GetDataEntity(this.strDEID, dataEntity);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.tbDataEntity.getTextBoxConfig().setText(StringHelper.Format((String)"%1$s[%2$s]", (Object)dataEntity.getDENAME(), (Object)dataEntity.getDELOGICNAME()));
                this.AddControl((SRFExControl)this.tbDataEntity);
            } else {
                DERCUSTOM der;
                DER1N der2;
                DER11 der3;
                this.ddlDataEntities = new SRFExDropDownList();
                this.ddlDataEntities.InitConfig();
                this.ddlDataEntities.setID("ddlDataEntities");
                this.ddlDataEntities.getDropDownListConfig().setWidthEx(1.0);
                Vector list11 = new Vector();
                callResult = this.getDAModelHelper().GetDER11s(true, this.strPDEID, list11);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
                int i = 0;
                while (i < list11.size()) {
                    der3 = (DER11)list11.get(i);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[1:1\u9644\u5c5e\u5b9e\u4f53]%1$s(%2$s) - %3$s", (Object)der3.getMINORDELOGICNAME(), (Object)der3.getMINORDENAME(), (Object)der3.getDERLOGICNAME()), "11M:" + der3.getDERID() + ":" + der3.getMINORDEID()));
                    ++i;
                }
                list11.clear();
                callResult = this.getDAModelHelper().GetDER11s(false, this.strPDEID, list11);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                i = 0;
                while (i < list11.size()) {
                    der3 = (DER11)list11.get(i);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[1:1\u4e3b\u5b9e\u4f53]%1$s(%2$s) - %3$s", (Object)der3.getMAJORDELOGICNAME(), (Object)der3.getMAJORDENAME(), (Object)der3.getDERLOGICNAME()), "11:" + der3.getDERID() + ":" + der3.getMAJORDEID()));
                    ++i;
                }
                Vector listindex = new Vector();
                callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDERINDEXVIEWs(true, this.strPDEID, listindex);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                for (DERINDEX derIndex : listindex) {
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u7d22\u5f15-\u9644\u5c5e\u5b9e\u4f53]%1$s(%2$s) - %3$s", (Object)derIndex.getDELOGICNAME(), (Object)derIndex.getDENAME(), (Object)derIndex.getDERINDEXNAME()), "INDEXM:" + derIndex.getDERINDEXID() + ":" + derIndex.getDEID()));
                }
                listindex.clear();
                callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDERINDEXVIEWs(false, this.strPDEID, listindex);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                for (DERINDEX derIndex : listindex) {
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u7d22\u5f15-\u9644\u5c5e\u5b9e\u4f53]%1$s(%2$s) - %3$s", (Object)derIndex.getINDEXDELOGICNAME(), (Object)derIndex.getINDEXDENAME(), (Object)derIndex.getDERINDEXNAME()), "INDEX:" + derIndex.getDERINDEXID() + ":" + derIndex.getINDEXDEID()));
                }
                Vector list = new Vector();
                callResult = this.getDAModelHelper().GetDERN1s(this.strPDEID, list);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                int i2 = 0;
                while (i2 < list.size()) {
                    der2 = (DER1N)list.get(i2);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u76f8\u5173N:1]%1$s(%2$s) - %3$s", (Object)der2.getMAJORDELOGICNAME(), (Object)der2.getMAJORDENAME(), (Object)der2.getDERLOGICNAME()), "N1:" + der2.getDERID() + ":" + der2.getMAJORDEID()));
                    ++i2;
                }
                if (this.bRightJoin) {
                    i2 = 0;
                    while (i2 < list.size()) {
                        der2 = (DER1N)list.get(i2);
                        this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u53f3\u8054\u63a5N:1]%1$s(%2$s) - %3$s", (Object)der2.getMAJORDELOGICNAME(), (Object)der2.getMAJORDENAME(), (Object)der2.getDERLOGICNAME()), "N1RIGHT:" + der2.getDERID() + ":" + der2.getMAJORDEID()));
                        ++i2;
                    }
                }
                list.clear();
                callResult = this.getDAModelHelper().GetDER1Ns(this.strPDEID, list);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                i2 = 0;
                while (i2 < list.size()) {
                    der2 = (DER1N)list.get(i2);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u5b58\u57281:N]%1$s(%2$s) - %3$s", (Object)der2.getMINORDELOGICNAME(), (Object)der2.getMINORDENAME(), (Object)der2.getDERLOGICNAME()), "1N:" + der2.getDERID() + ":" + der2.getMINORDEID()));
                    ++i2;
                }
                i2 = 0;
                while (i2 < list.size()) {
                    der2 = (DER1N)list.get(i2);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u4e0d\u5b58\u57281:N]%1$s(%2$s) - %3$s", (Object)der2.getMINORDELOGICNAME(), (Object)der2.getMINORDENAME(), (Object)der2.getDERLOGICNAME()), "1NNOT:" + der2.getDERID() + ":" + der2.getMINORDEID()));
                    ++i2;
                }
                if (this.bLeftOuterJoin) {
                    i2 = 0;
                    while (i2 < list.size()) {
                        der2 = (DER1N)list.get(i2);
                        this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u5de6\u5916\u8054\u63a5 1:N]%1$s(%2$s) - %3$s", (Object)der2.getMINORDELOGICNAME(), (Object)der2.getMINORDENAME(), (Object)der2.getDERLOGICNAME()), "1NLEFTOUT:" + der2.getDERID() + ":" + der2.getMINORDEID()));
                        ++i2;
                    }
                }
                Vector customList = new Vector();
                callResult = this.getDAModelHelper().GetDERCUSTOMs(false, this.strPDEID, customList);
                if (callResult == null || callResult.getRetCode() != 0) {
                    return;
                }
                int i3 = 0;
                while (i3 < customList.size()) {
                    der = (DERCUSTOM)customList.get(i3);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u81ea\u5b9a\u4e49N:1]%1$s(%2$s) - %3$s", (Object)der.getMAJORDENAME(), (Object)der.getMAJORDENAME(), (Object)der.getCUSTOMDERNAME()), "CUSTOMN1:" + der.getCUSTOMDERID() + ":" + der.getMAJORDEID()));
                    ++i3;
                }
                i3 = 0;
                while (i3 < customList.size()) {
                    der = (DERCUSTOM)customList.get(i3);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u81ea\u5b9a\u4e49\u5b58\u57281:N]%1$s(%2$s) - %3$s", (Object)der.getMAJORDENAME(), (Object)der.getMINORDENAME(), (Object)der.getCUSTOMDERNAME()), "CUSTOM1N:" + der.getCUSTOMDERID() + ":" + der.getMINORDEID()));
                    ++i3;
                }
                i3 = 0;
                while (i3 < customList.size()) {
                    der = (DERCUSTOM)customList.get(i3);
                    this.ddlDataEntities.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"[\u81ea\u5b9a\u4e49\u4e0d\u5b58\u57281:N]%1$s(%2$s) - %3$s", (Object)der.getMAJORDENAME(), (Object)der.getMINORDENAME(), (Object)der.getCUSTOMDERNAME()), "CUSTOM1NNOT:" + der.getCUSTOMDERID() + ":" + der.getMINORDEID()));
                    ++i3;
                }
                this.AddControl((SRFExControl)this.ddlDataEntities);
                if (!StringHelper.IsNullOrEmpty((String)this.strDERFullId) && this.ddlDataEntities.getDropDownListConfig().getListItems().FindByValue(this.strDERFullId) != null) {
                    this.ddlDataEntities.getDropDownListConfig().setSelectedValue(this.strDERFullId);
                }
                script.Reset();
                script.Append("var queryItem = queryModel.findItem('%1$s');", (Object)this.getID());
                script.Append("queryItem.removeAllChild();");
                script.Append("queryItem.setDERId(Ext.getDom('%1$s').value);", (Object)this.ddlDataEntities.getUniqueID());
                script.Append("Ext.getDom('%1$s').value = Ext.getDom('%2$s').value;", (Object)this.hdDataEntity.getUniqueID(), (Object)this.ddlDataEntities.getUniqueID());
                script.Append("var tb = Ext.getDom('TBC_%1$s');", (Object)this.getID());
                script.Append("while(tb.rows.length!=0){tb.deleteRow(0);}");
                script.Append("$P.tree['TBLOGIC_%1$s'].getRootNode().xml.deid = Ext.getDom('%2$s').value;", (Object)this.getID(), (Object)this.ddlDataEntities.getUniqueID());
                script.Append("while($P.tree['TBLOGIC_%1$s'].getRootNode().hasChildNodes()){$P.tree['TBLOGIC_%1$s'].getRootNode().item(0).remove();}", (Object)this.getID(), (Object)this.ddlDataEntities.getUniqueID());
                this.ddlDataEntities.getDropDownListConfig().setSelectChangedJSCode(script.toString());
            }
            this.hdDataEntity.setValue(this.strDEID);
            this.btnAddRelation = new SRFExButton();
            this.btnAddRelation.InitConfig();
            this.btnAddRelation.setID("btnAddRelation");
            this.btnAddRelation.getButtonConfig().setText("\u589e\u52a0\u5173\u7cfb");
            this.btnAddRelation.getButtonConfig().setTips("\u589e\u52a0\u5b9e\u4f53\u5173\u7cfb");
            this.btnAddRelation.setResourceId("");
            script.Reset();
            script.Append("var pdeid = Ext.getDom('%1$s').value;", (Object)this.hdDataEntity.getUniqueID());
            script.Append("if(pdeid == ''){alert('\u8bf7\u5148\u9009\u62e9\u6570\u636e\u5b9e\u4f53!');return;}");
            script.Append("var curQueryItem = queryModel.findItem('%1$s');", (Object)this.getID());
            script.Append("var itemid=curQueryItem.createid();");
            script.Append("var queryItem = new SRFDA.QueryItem({id:itemid});");
            script.Append("curQueryItem.appendChild(queryItem);");
            script.Append("loadQueryPanel('%1$s',itemid,pdeid,'');", (Object)this.getID());
            this.btnAddRelation.getButtonConfig().setJSCode(script.toString());
            this.AddControl((SRFExControl)this.btnAddRelation);
            if (!this.bMainQuery) {
                this.btnRemoveRelation = new SRFExButton();
                this.btnRemoveRelation.InitConfig();
                this.btnRemoveRelation.setID("btnRemoveRelation");
                this.btnRemoveRelation.getButtonConfig().setText("\u5220\u9664");
                this.btnRemoveRelation.getButtonConfig().setTips("\u5220\u9664\u5f53\u524d\u5b9e\u4f53");
                this.btnRemoveRelation.getButtonConfig().setIconCls("sx-tb-delete");
                this.btnRemoveRelation.setResourceId("");
                script.Reset();
                script.Append("removeQueryPanel('%1$s');", (Object)this.getID());
                this.btnRemoveRelation.getButtonConfig().setJSCode(script.toString());
                this.AddControl((SRFExControl)this.btnRemoveRelation);
            }
            this.btnShowFilter = new SRFExButton();
            this.btnShowFilter.InitConfig();
            this.btnShowFilter.setID("btnShowFilter");
            this.btnShowFilter.getButtonConfig().setText("\u8fc7\u6ee4\u6761\u4ef6");
            this.btnShowFilter.getButtonConfig().setTips("\u663e\u793a\u8fc7\u6ee4\u6761\u4ef6\u754c\u9762");
            this.btnShowFilter.setResourceId("");
            this.AddControl((SRFExControl)this.btnShowFilter);
            script.Reset();
            script.Append("var tbr = Ext.getDom('TBR_%1$s');", (Object)this.getID());
            script.Append("if(tbr.style.display == ''){tbr.style.display='none';$P.button['%1$s'].toggle(false);}else{tbr.style.display='';$P.button['%1$s'].toggle(true);}", (Object)this.btnShowFilter.getUniqueID());
            this.btnShowFilter.getButtonConfig().setJSCode(script.toString());
            if (this.IsExtSelect()) {
                this.btnAddExtSelect = new SRFExButton();
                this.btnAddExtSelect.InitConfig();
                this.btnAddExtSelect.setID("btnAddExtSelect");
                if (this.bMainQuery) {
                    this.btnAddExtSelect.getButtonConfig().setText("\u9009\u62e9\u8f93\u51fa");
                    this.btnAddExtSelect.getButtonConfig().setTips("\u9009\u62e9\u68c0\u7d22\u8f93\u51fa");
                } else {
                    this.btnAddExtSelect.getButtonConfig().setText("\u989d\u5916\u8f93\u51fa");
                    this.btnAddExtSelect.getButtonConfig().setTips("\u989d\u5916\u68c0\u7d22\u8f93\u51fa");
                }
                this.btnAddExtSelect.setResourceId("");
                this.AddControl((SRFExControl)this.btnAddExtSelect);
                script.Reset();
                script.Append("var tbr2 = Ext.getDom('TBR2_%1$s');", (Object)this.getID());
                script.Append("if(tbr2.style.display == ''){tbr2.style.display='none';$P.button['%1$s'].toggle(false);}else{tbr2.style.display='';$P.button['%1$s'].toggle(true);}", (Object)this.btnAddExtSelect.getUniqueID());
                this.btnAddExtSelect.getButtonConfig().setJSCode(script.toString());
            }
        }
        this.btnAddGroupLogic = new SRFExButton();
        this.btnAddGroupLogic.InitConfig();
        this.btnAddGroupLogic.setID("btnAddGroupLogic");
        this.btnAddGroupLogic.getButtonConfig().setText("\u589e\u52a0\u7ec4\u903b\u8f91");
        this.btnAddGroupLogic.getButtonConfig().setTips("\u589e\u52a0\u7ec4\u903b\u8f91");
        this.btnAddGroupLogic.getButtonConfig().setWidth(100);
        this.btnAddGroupLogic.setResourceId("");
        script.Reset();
        script.Append("var tree = $P.tree['TBLOGIC_%1$s'];", (Object)this.getID());
        script.Append("addgrouplogic(tree);");
        this.btnAddGroupLogic.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnAddGroupLogic);
        this.btnAddSingleLogic = new SRFExButton();
        this.btnAddSingleLogic.InitConfig();
        this.btnAddSingleLogic.setID("btnAddSingleLogic");
        this.btnAddSingleLogic.getButtonConfig().setText("\u589e\u52a0\u5355\u9879\u903b\u8f91");
        this.btnAddSingleLogic.getButtonConfig().setTips("\u589e\u52a0\u5355\u9879\u903b\u8f91");
        this.btnAddSingleLogic.getButtonConfig().setWidth(100);
        this.btnAddSingleLogic.setResourceId("");
        script.Reset();
        script.Append("var tree = $P.tree['TBLOGIC_%1$s'];", (Object)this.getID());
        script.Append("addsinglelogic(tree);");
        this.btnAddSingleLogic.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnAddSingleLogic);
        script.Reset();
        this.btnAddCustomLogic = new SRFExButton();
        this.btnAddCustomLogic.InitConfig();
        this.btnAddCustomLogic.setID("btnAddCustomLogic");
        this.btnAddCustomLogic.getButtonConfig().setText("\u589e\u52a0\u81ea\u5b9a\u4e49\u903b\u8f91");
        this.btnAddCustomLogic.getButtonConfig().setTips("\u589e\u52a0\u81ea\u5b9a\u4e49\u903b\u8f91");
        this.btnAddCustomLogic.setResourceId("");
        this.btnAddCustomLogic.getButtonConfig().setWidth(100);
        script.Reset();
        script.Append("var tree = $P.tree['TBLOGIC_%1$s'];", (Object)this.getID());
        script.Append("addcustomlogic(tree);");
        this.btnAddCustomLogic.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnAddCustomLogic);
        this.btnRemoveLogic = new SRFExButton();
        this.btnRemoveLogic.InitConfig();
        this.btnRemoveLogic.setID("btnRemoveLogic");
        this.btnRemoveLogic.getButtonConfig().setText("\u5220\u9664\u903b\u8f91");
        this.btnRemoveLogic.getButtonConfig().setTips("\u5220\u9664\u903b\u8f91");
        this.btnRemoveLogic.setResourceId("");
        this.btnRemoveLogic.getButtonConfig().setWidth(100);
        script.Reset();
        script.Append("var tree = $P.tree['TBLOGIC_%1$s'];", (Object)this.getID());
        script.Append("removelogic(tree);");
        this.btnRemoveLogic.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnRemoveLogic);
    }

    public String RenderDataEntityCtrl() {
        if (this.tbDataEntity != null) {
            return this.Render(this.tbDataEntity.getID());
        }
        if (this.ddlDataEntities != null) {
            return this.Render(this.ddlDataEntities.getID());
        }
        return "";
    }

    public String RenderRemoveRelationButton() {
        if (this.bMainQuery) {
            return "";
        }
        return this.Render("btnRemoveRelation");
    }

    public boolean IsConditionOnly() {
        return this.bConditionOnly;
    }

    public boolean IsExtSelect() {
        return !this.IsConditionOnly() && this.bExtSelect;
    }

    public boolean IsMainQuery() {
        return this.bMainQuery;
    }
}

