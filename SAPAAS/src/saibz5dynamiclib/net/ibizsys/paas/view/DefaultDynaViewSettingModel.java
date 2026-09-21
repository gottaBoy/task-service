/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler
 *  net.ibizsys.paas.ctrlmodel.IDynaCtrlModel
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 */
package net.ibizsys.paas.view;

import java.util.HashMap;
import net.ibizsys.paas.controller.DefaultDynaGridViewControllerInst;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaSearchFormModel;
import net.ibizsys.paas.ctrlmodel.IDynaToolbarModel;
import net.ibizsys.paas.ctrlmodel.form.DefaultDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DefaultDynaToolbarModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DynaViewSettingModelBase;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.pswf.controller.DefaultDynaMobWFEditViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFEditViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFExpViewControllerInst;
import net.ibizsys.pswf.controller.DefaultDynaWFGridViewControllerInst;

public class DefaultDynaViewSettingModel
extends DynaViewSettingModelBase {
    private HashMap<String, String> dynaViewControllerInstMap = new HashMap();
    private HashMap<String, String> dynaCtrlModelMap = new HashMap();
    private HashMap<String, String> dynaCtrlHandlerMap = new HashMap();

    public DefaultDynaViewSettingModel() {
        this.dynaViewControllerInstMap.put("DEWFEDITVIEW", DefaultDynaWFEditViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEWFEDITVIEW2", DefaultDynaWFEditViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEWFEDITVIEW3", DefaultDynaWFEditViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEWFEXPVIEW", DefaultDynaWFExpViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEMOBWFEDITVIEW", DefaultDynaMobWFEditViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEMOBWFEDITVIEW3", DefaultDynaMobWFEditViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEWFGRIDVIEW", DefaultDynaWFGridViewControllerInst.class.getName());
        this.dynaViewControllerInstMap.put("DEGRIDVIEW", DefaultDynaGridViewControllerInst.class.getName());
        this.dynaCtrlModelMap.put("FORM", DefaultDynaEditFormModel.class.getName());
        this.dynaCtrlModelMap.put("TOOLBAR", DefaultDynaToolbarModel.class.getName());
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IDynaToolbarModel createDynaToolbarModel() {
        return new DefaultDynaToolbarModel();
    }

    @Override
    public IDynaEditFormModel createDynaEditFormModel() {
        return new DefaultDynaEditFormModel();
    }

    @Override
    public IDynaSearchFormModel createDynaSearchFormModel() {
        return null;
    }

    @Override
    protected IDynaViewControllerInst createDynaViewControllerInst(DSDynaViewInst dsDynaViewInst) throws Exception {
        String strViewInstObj = dsDynaViewInst.getViewInstObj();
        if (StringHelper.isNullOrEmpty((String)strViewInstObj)) {
            strViewInstObj = this.dynaViewControllerInstMap.get(dsDynaViewInst.getViewType());
        }
        if (!StringHelper.isNullOrEmpty((String)strViewInstObj)) {
            Object objViewInst = ObjectHelper.create((String)strViewInstObj);
            if (objViewInst == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u5bf9\u8c61[%1$s]", (Object)strViewInstObj));
            }
            if (!(objViewInst instanceof IDynaViewControllerInst)) {
                throw new Exception(StringHelper.format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strViewInstObj));
            }
            return (IDynaViewControllerInst)objViewInst;
        }
        return super.createDynaViewControllerInst(dsDynaViewInst);
    }

    @Override
    public IDynaCtrlModel createDynaCtrlModel(String strCtrlType, Object ctrlParam) throws Exception {
        String strCtrlModelObj = this.dynaCtrlModelMap.get(strCtrlType);
        if (StringHelper.isNullOrEmpty((String)strCtrlModelObj)) {
            return null;
        }
        Object objCtrlModel = ObjectHelper.create((String)strCtrlModelObj);
        if (objCtrlModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u5bf9\u8c61[%1$s]", (Object)strCtrlModelObj));
        }
        if (!(objCtrlModel instanceof IDynaCtrlModel)) {
            throw new Exception(StringHelper.format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCtrlModelObj));
        }
        return (IDynaCtrlModel)objCtrlModel;
    }

    @Override
    public IDynaCtrlHandler createDynaCtrlHandler(IDynaCtrlModel iDynaCtrlModel) throws Exception {
        String strCtrlHandlerObj = this.dynaCtrlHandlerMap.get(iDynaCtrlModel.getControlType());
        if (StringHelper.isNullOrEmpty((String)strCtrlHandlerObj)) {
            return null;
        }
        Object objCtrlHandler = ObjectHelper.create((String)strCtrlHandlerObj);
        if (objCtrlHandler == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u521b\u5efa\u5bf9\u8c61[%1$s]", (Object)strCtrlHandlerObj));
        }
        if (!(objCtrlHandler instanceof IDynaCtrlHandler)) {
            throw new Exception(StringHelper.format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCtrlHandlerObj));
        }
        return (IDynaCtrlHandler)objCtrlHandler;
    }
}

