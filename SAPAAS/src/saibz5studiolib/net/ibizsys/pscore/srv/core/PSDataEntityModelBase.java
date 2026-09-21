/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.demodel.DataEntityModelBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.core;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.demodel.DataEntityModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;

public abstract class PSDataEntityModelBase<ET extends IEntity>
extends DataEntityModelBase<ET>
implements IPSDataEntityModel<ET> {
    private Map<String, IPSDEFGroupModel> psDEFGroupModelMap = null;
    private Map<String, IDEField> deFieldMap = null;
    private String strCodeName = null;
    private String strServiceCodeName = null;
    private boolean bTranslateDEFieldServiceCodeName = false;
    private String strMemo = null;

    public static boolean isSimpleMode() {
        return PSCoreSysModel.isSimpleMode();
    }

    protected void prepareModels() throws Exception {
        super.prepareModels();
        this.preparePSDEFGroupModels();
    }

    public void setMemo(String string) {
        this.strMemo = string;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    protected void prepareDEACModes() throws Exception {
        if (!PSDataEntityModelBase.isSimpleMode()) {
            this.onPrepareDEACModes();
        }
    }

    protected void onPrepareDEACModes() throws Exception {
    }

    protected void preparePSDEFGroupModels() throws Exception {
        if (!PSDataEntityModelBase.isSimpleMode()) {
            this.onPreparePSDEFGroupModels();
        }
    }

    protected void onPreparePSDEFGroupModels() throws Exception {
    }

    public void registerPSDEFGroupModel(IPSDEFGroupModel iPSDEFGroupModel) throws Exception {
        if (this.psDEFGroupModelMap != null && this.psDEFGroupModelMap.containsKey(iPSDEFGroupModel.getId())) {
            throw new Exception(StringHelper.format((String)"\u5df2\u5b58\u5728\u6807\u8bc6\u4e3a[%1$s]\u7684\u5c5e\u6027\u7ec4", (Object)iPSDEFGroupModel.getId()));
        }
        if (this.psDEFGroupModelMap != null && this.psDEFGroupModelMap.containsKey(iPSDEFGroupModel.getName())) {
            throw new Exception(StringHelper.format((String)"\u5c5e\u6027\u7ec4\u5df2\u5b58\u5728\u540d\u79f0\u4e3a[%1$s]\u7684\u5c5e\u6027\u7ec4", (Object)iPSDEFGroupModel.getName()));
        }
        if (this.psDEFGroupModelMap == null) {
            this.psDEFGroupModelMap = new HashMap<String, IPSDEFGroupModel>();
        }
        this.psDEFGroupModelMap.put(iPSDEFGroupModel.getId(), iPSDEFGroupModel);
        this.psDEFGroupModelMap.put(iPSDEFGroupModel.getName(), iPSDEFGroupModel);
    }

    @Override
    public IPSDEFGroupModel getPSDEFGroupModel(String string, boolean bl) throws Exception {
        IPSDEFGroupModel iPSDEFGroupModel;
        IPSDEFGroupModel iPSDEFGroupModel2 = iPSDEFGroupModel = this.psDEFGroupModelMap == null ? null : this.psDEFGroupModelMap.get(string);
        if (iPSDEFGroupModel == null && !bl) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6807\u8bc6\u6216\u540d\u79f0\u4e3a[%1$s]\u7684\u5c5e\u6027\u7ec4", (Object)string));
        }
        return iPSDEFGroupModel;
    }

    protected void prepareDEUIActions() throws Exception {
        if (!PSDataEntityModelBase.isSimpleMode()) {
            this.onPrepareDEUIActions();
        }
    }

    protected void onPrepareDEUIActions() throws Exception {
    }

    protected void preparePDTDEViews() throws Exception {
        if (!PSDataEntityModelBase.isSimpleMode()) {
            this.onPreparePDTDEViews();
        }
    }

    protected void onPreparePDTDEViews() throws Exception {
    }

    public void registerDEField(IDEField iDEField) {
        IPSDEFieldModel iPSDEFieldModel;
        super.registerDEField(iDEField);
        if (iDEField instanceof IPSDEFieldModel && !StringHelper.isNullOrEmpty((String)(iPSDEFieldModel = (IPSDEFieldModel)iDEField).getCodeName())) {
            if (StringHelper.compare((String)iPSDEFieldModel.getName(), (String)iPSDEFieldModel.getCodeName(), (boolean)true) != 0) {
                if (this.deFieldMap == null) {
                    this.deFieldMap = new HashMap<String, IDEField>();
                }
                this.deFieldMap.put(iPSDEFieldModel.getCodeName(), iDEField);
                this.deFieldMap.put(iPSDEFieldModel.getCodeName().toUpperCase(), iDEField);
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEFieldModel.getServiceCodeName()) && StringHelper.compare((String)iPSDEFieldModel.getCodeName(), (String)iPSDEFieldModel.getServiceCodeName(), (boolean)true) != 0) {
                this.bTranslateDEFieldServiceCodeName = true;
                if (this.deFieldMap == null) {
                    this.deFieldMap = new HashMap<String, IDEField>();
                }
                this.deFieldMap.put(iPSDEFieldModel.getServiceCodeName(), iDEField);
                this.deFieldMap.put(iPSDEFieldModel.getServiceCodeName().toUpperCase(), iDEField);
            }
        }
    }

    @Override
    public IPSDEFieldModel getDEField(String string, boolean bl) throws Exception {
        if (this.deFieldMap == null) {
            return (IPSDEFieldModel)super.getDEField(string, bl);
        }
        IDEField iDEField = super.getDEField(string, true);
        if (iDEField != null) {
            return (IPSDEFieldModel)iDEField;
        }
        IDEField iDEField2 = this.deFieldMap.get(string);
        if (iDEField2 == null && (iDEField2 = this.deFieldMap.get(string.toUpperCase())) == null && !bl) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)string));
        }
        return (IPSDEFieldModel)iDEField2;
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    public void setCodeName(String string) {
        this.strCodeName = string;
    }

    @Override
    public String getServiceCodeName() {
        if (!StringHelper.isNullOrEmpty((String)this.strServiceCodeName)) {
            return this.strServiceCodeName;
        }
        return this.getCodeName();
    }

    public void setServiceCodeName(String string) {
        this.strServiceCodeName = string;
    }

    @Override
    public IPSDEFieldModel getKeyDEField() {
        return (IPSDEFieldModel)super.getKeyDEField();
    }

    @Override
    public boolean isTranslateDEFieldServiceCodeName() {
        return this.bTranslateDEFieldServiceCodeName;
    }
}

