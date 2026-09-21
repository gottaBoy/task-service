/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.DefaultDynaStaticCodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModel;
import net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public abstract class DynaStaticCodeListModelBase
extends StaticCodeListModelBase
implements IDynaCodeListModelContainer {
    private HashMap<String, IDynaCodeListModel> dynaCodeListModelMap = new HashMap();

    @Override
    public void registerDynaCodeListModel(IDynaCodeListModel iDynaCodeListModel) throws Exception {
        String strDynaSysInstId = iDynaCodeListModel.getDynaInstId();
        this.dynaCodeListModelMap.put(strDynaSysInstId, iDynaCodeListModel);
    }

    @Override
    public void resetCurrentDynaSysInst() {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            this.dynaCodeListModelMap.remove(strDynaSysInstId);
        }
    }

    @Override
    public void resetAllDynaSysInst() {
        this.dynaCodeListModelMap.clear();
    }

    public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeListText(strValue, bRecursion);
        }
        return super.getCodeListText(strValue, bRecursion);
    }

    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeListText(strValue, bRecursion, activeData, iWebContext);
        }
        return super.getCodeListText(strValue, bRecursion, activeData, iWebContext);
    }

    public ICodeItem getCodeItemByText(String strText) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeItemByText(strText);
        }
        return super.getCodeItemByText(strText);
    }

    public ICodeItem getCodeItem(String strValue) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeItem(strValue);
        }
        return super.getCodeItem(strValue);
    }

    public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeItemByText(strText, bRecursion);
        }
        return super.getCodeItemByText(strText, bRecursion);
    }

    public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeItem(strValue, bRecursion);
        }
        return super.getCodeItem(strValue, bRecursion);
    }

    protected IDynaCodeListModel getCurrentDynaCodeListModel() {
        String strDynaSysInstId;
        if (WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)(strDynaSysInstId = WebContext.getDynaSysInstId((IWebContext)WebContext.getCurrent())))) {
            return this.dynaCodeListModelMap.get(strDynaSysInstId);
        }
        return null;
    }

    public Iterator<ICodeItem> getCodeItems() throws Exception {
        IDynaCodeListModel iDynaCodeListModel = this.getCurrentDynaCodeListModel();
        if (iDynaCodeListModel != null) {
            return iDynaCodeListModel.getCodeItems();
        }
        return super.getCodeItems();
    }

    @Override
    public IDynaCodeListModel createDynaCodeListModel(IEntity iEntity) throws Exception {
        return new DefaultDynaStaticCodeListModel();
    }
}

