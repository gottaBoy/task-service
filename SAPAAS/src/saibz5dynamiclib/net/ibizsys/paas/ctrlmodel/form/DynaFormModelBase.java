/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.controller.IDynaViewController
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.FormModelBase
 *  net.ibizsys.paas.ctrlmodel.ICtrlModel
 *  net.ibizsys.paas.ctrlmodel.IFormModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel.form;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.paas.ctrlmodel.FormModelBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;
import net.ibizsys.paas.ctrlmodel.IFormModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormButtonModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormDRUIPartModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormGroupModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormItemModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormPageModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormDetailModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormItemModel;
import net.ibizsys.paas.ctrlmodel.form.IDynaFormPageModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DynaFormModelBase
extends FormModelBase
implements IDynaFormModel {
    private static final Log log = LogFactory.getLog(DynaFormModelBase.class);
    private ArrayList<IDynaFormPageModel> dynaFormPageModelList = new ArrayList();
    private IDynaViewControllerInst iDynaViewControllerInst = null;
    private ObjectNode modelJsonObject = null;
    private IFormModel sourceFormModel = null;
    private String strLayoutMode = null;
    private String strFormStyle = null;
    private String strFormFuncMode = null;
    private IDynaFormModel sourceDynaFormModel = null;

    public void init(IDynaViewControllerInst iDynaViewControllerInst, Object modelObject) throws Exception {
        this.setEnableDynaCtrl(true);
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
    public IFormModel getSourceFormModel() {
        return this.sourceFormModel;
    }

    public IDynaFormModel getSourceDynaFormModel() {
        return this.sourceDynaFormModel;
    }

    @Override
    public void loadJsonObject(ObjectNode jsonObject) throws Exception {
        this.modelJsonObject = jsonObject;
        this.onLoadJsonObject(jsonObject);
    }

    protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
        IDynaViewController iDynaViewController;
        ICtrlModel iCtrlModel;
        String strName = JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"name", null);
        if (StringHelper.isNullOrEmpty((String)strName)) {
            throw new Exception("\u90e8\u4ef6\u6a21\u578b\u4e2d\u6ca1\u6709\u6307\u5b9a\u90e8\u4ef6\u540d\u79f0");
        }
        this.setName(strName);
        if (!StringHelper.isNullOrEmpty((String)this.getName()) && this.getDynaViewControllerInst() != null && (iCtrlModel = (iDynaViewController = this.getDynaViewControllerInst().getDynaViewController()).getCtrlModel(this.getName())) != null && iCtrlModel instanceof IFormModel) {
            this.sourceFormModel = (IFormModel)iCtrlModel;
            if (this.sourceFormModel instanceof IDynaFormModel) {
                this.sourceDynaFormModel = (IDynaFormModel)this.sourceFormModel;
            }
        }
        this.setLayoutMode(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"layoutmode", null));
        this.setFormFuncMode(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"formfuncmode", null));
        this.setFormStyle(JsonNodeHelper.getString((ObjectNode)jsonObject, (String)"formstyle", null));
        ArrayNode arrayNode = JsonNodeHelper.getArray((ObjectNode)jsonObject, (String)"pages");
        if (arrayNode != null) {
            int nSize = arrayNode.size();
            int i = 0;
            while (i < nSize) {
                ObjectNode itemNode = (ObjectNode)arrayNode.get(i);
                DynaFormPageModel iDynaFormPageModel = new DynaFormPageModel();
                iDynaFormPageModel.init(this, null, itemNode);
                this.addPageModel(iDynaFormPageModel);
                ++i;
            }
        }
    }

    public void addPageModel(IDynaFormPageModel iDynaFormPageModel) throws Exception {
        this.dynaFormPageModelList.add(iDynaFormPageModel);
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
        Iterator<IDynaFormPageModel> pageModels = this.getPageModels();
        ArrayList<IDynaFormItemModel> dynaFormItemModelList = new ArrayList<IDynaFormItemModel>();
        if (pageModels != null) {
            Iterator formItems;
            ArrayList<ObjectNode> list = new ArrayList<ObjectNode>();
            while (pageModels.hasNext()) {
                IDynaFormPageModel iDynaFormPageModel = pageModels.next();
                ObjectNode pageJo = iDynaFormPageModel.toJsonObject(null);
                list.add(pageJo);
                iDynaFormPageModel.fillDynaFormItemModels(dynaFormItemModelList);
            }
            JsonNodeHelper.put((ObjectNode)jo, (String)"pages", list);
            HashMap<String, IDynaFormItemModel> dynaFormItemModelMap = new HashMap<String, IDynaFormItemModel>();
            for (IDynaFormItemModel iDynaFormItemModel : dynaFormItemModelList) {
                dynaFormItemModelMap.put(iDynaFormItemModel.getName(), iDynaFormItemModel);
            }
            ArrayList<String> hiddenlist = new ArrayList<String>();
            if (this.getSourceDynaFormModel() != null && (formItems = this.getSourceDynaFormModel().getFormItems()) != null) {
                while (formItems.hasNext()) {
                    IDynaFormItemModel iDynaFormItemModel;
                    IFormItem iFormItem = (IFormItem)formItems.next();
                    if (!(iFormItem instanceof IDynaFormItemModel) || dynaFormItemModelMap.containsKey((iDynaFormItemModel = (IDynaFormItemModel)iFormItem).getName())) continue;
                    hiddenlist.add(iDynaFormItemModel.getName());
                }
            }
            JsonNodeHelper.put((ObjectNode)jo, (String)"hiddens", hiddenlist);
        }
    }

    @Override
    public Iterator<IDynaFormPageModel> getPageModels() {
        if (this.dynaFormPageModelList.size() == 0) {
            return null;
        }
        return this.dynaFormPageModelList.iterator();
    }

    @Override
    public IDynaFormDetailModel createDynaFormDetailModel(String strType) throws Exception {
        if (StringHelper.compare((String)strType, (String)"BUTTON", (boolean)true) == 0) {
            return new DynaFormButtonModel();
        }
        if (StringHelper.compare((String)strType, (String)"GROUPPANEL", (boolean)true) == 0) {
            return new DynaFormGroupModel();
        }
        if (StringHelper.compare((String)strType, (String)"FORMITEM", (boolean)true) == 0) {
            return new DynaFormItemModel();
        }
        if (StringHelper.compare((String)strType, (String)"DRUIPART", (boolean)true) == 0) {
            return new DynaFormDRUIPartModel();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u5355\u6210\u5458\u7c7b\u578b[%1$s]", (Object)strType));
    }

    @Override
    public String getLayoutMode() {
        if (StringHelper.isNullOrEmpty((String)this.strLayoutMode) && this.getSourceDynaFormModel() != null) {
            return this.getSourceDynaFormModel().getLayoutMode();
        }
        return this.strLayoutMode;
    }

    @Override
    public String getFormFuncMode() {
        if (StringHelper.isNullOrEmpty((String)this.strFormFuncMode) && this.getSourceDynaFormModel() != null) {
            return this.getSourceDynaFormModel().getFormFuncMode();
        }
        return this.strFormFuncMode;
    }

    @Override
    public String getFormStyle() {
        if (StringHelper.isNullOrEmpty((String)this.strFormStyle) && this.getSourceDynaFormModel() != null) {
            return this.getSourceDynaFormModel().getFormStyle();
        }
        return this.strFormStyle;
    }

    protected void setLayoutMode(String strLayoutMode) {
        this.strLayoutMode = strLayoutMode;
    }

    protected void setFormStyle(String strFormStyle) {
        this.strFormStyle = strFormStyle;
    }

    protected void setFormFuncMode(String strFormFuncMode) {
        this.strFormFuncMode = strFormFuncMode;
    }
}

