/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.expbar.ExpBarItem
 *  net.ibizsys.paas.control.expbar.ExpBarRootItem
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.expbar.ExpBarItem;
import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.ctrlmodel.IDynaWFExpBarModel;
import net.ibizsys.pswf.ctrlmodel.WFExpBarModelBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaWFExpBarModelBase
extends WFExpBarModelBase
implements IDynaWFExpBarModel {
    private static final Log log = LogFactory.getLog(DynaWFExpBarModelBase.class);
    private IDynaViewControllerInst iDynaViewControllerInst = null;
    private ObjectNode modelJsonObject = null;

    public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
        super.init((IViewController)iDynaViewControllerInst);
        if (modelObject != null && modelObject instanceof ObjectNode) {
            this.loadJsonObject((ObjectNode)modelObject);
        }
    }

    protected void onInit() throws Exception {
        if (this.getViewController() instanceof IDynaViewControllerInst) {
            this.iDynaViewControllerInst = (IDynaViewControllerInst)this.getViewController();
        }
        super.onInit();
    }

    public IDynaViewControllerInst getDynaViewControllerInst() {
        return this.iDynaViewControllerInst;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            throw new Exception("\u90e8\u4ef6\u6a21\u578b\u4e2d\u6ca1\u6709\u6307\u5b9a\u90e8\u4ef6\u540d\u79f0");
        }
        this.setName(strName);
    }

    @Override
    public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
        if (jo == null) {
            jo = JsonNodeHelper.createObjectNode();
        }
        DynaCtrlModelBase.fillJsonObject(this, jo);
        this.onFillJsonObject(jo);
        return jo;
    }

    protected void onFillJsonObject(ObjectNode jo) throws Exception {
    }

    protected void onPrepareRootItem(ExpBarRootItem expBarRootItem) throws Exception {
        ICodeList iCodeList;
        ExpBarItem myWorkExpBarItem = expBarRootItem.getItem("MYWFWORK", true);
        if (myWorkExpBarItem != null && (iCodeList = this.getWFVersionModel().getWFStepCodeList()) != null && iCodeList.getCodeItems() != null) {
            Iterator codeItems = iCodeList.getCodeItems();
            while (codeItems.hasNext()) {
                ICodeItem iCodeItem = (ICodeItem)codeItems.next();
                ExpBarItem expBarItem = expBarRootItem.addItem(StringHelper.format((String)"%1$s:%2$s", (Object)"MYWFWORK", (Object)iCodeItem.getValue()), "MYWFWORK");
                expBarItem.setText(iCodeItem.getText());
                expBarItem.setExpViewId(myWorkExpBarItem.getExpViewId());
                expBarItem.setCounterId(StringHelper.format((String)"%1$s%2$s", (Object)"V", (Object)iCodeItem.getValue()));
                expBarItem.setCounterMode(1);
                expBarItem.setViewParam("srfwfstep", iCodeItem.getValue());
                expBarItem.setViewParam("srfviewmode", iCodeItem.getValue());
            }
        }
        super.onPrepareRootItem(expBarRootItem);
    }
}

