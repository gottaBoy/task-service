/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDEActionWizardItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEActionWizardItemModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.ViewWizard;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DEActionWizardModel
extends ModelBase3Impl
implements IDEActionWizardModel {
    private IDataEntityModel iDataEntity = null;
    private ArrayList<IDEActionWizardItem> deActionWizardItemList = new ArrayList();
    private String strKeywords = null;
    private String strWizardUrl = null;

    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = (IDataEntityModel)iDataEntity;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public String getKeywords() {
        return this.strKeywords;
    }

    @Override
    public String getWizardUrl() {
        return this.strWizardUrl;
    }

    public void setKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public void setWizardUrl(String strWizardUrl) {
        this.strWizardUrl = strWizardUrl;
    }

    @Override
    public Iterator<IDEActionWizardItem> getDEActionWizardItems() {
        return this.deActionWizardItemList.iterator();
    }

    @Override
    public void registerDEActionWizardItemModel(IDEActionWizardItemModel iDEActionWizardItemModel) throws Exception {
        this.deActionWizardItemList.add(iDEActionWizardItemModel);
    }

    @Override
    public int fillViewWizards(IViewController iViewController, String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
        if (StringHelper.isNullOrEmpty(strQuery)) {
            viewWizardList.add(this);
            return 1;
        }
        if (this.getName().indexOf(strQuery) != -1) {
            viewWizardList.add(this);
            return 1;
        }
        if (!StringHelper.isNullOrEmpty(this.getKeywords()) && this.getKeywords().indexOf(strQuery) != -1) {
            viewWizardList.add(this);
            return 1;
        }
        return 0;
    }

    @Override
    public JSONObject toJSONObject(boolean bDetailMode) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (!bDetailMode) {
            return ViewWizard.toJSONObject(jsonObject, this);
        }
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (IDEActionWizardItem iDEActionWizardItem : this.deActionWizardItemList) {
            JSONObject item = new JSONObject();
            item.put("name", JSONObjectHelper.stripQuotes(iDEActionWizardItem.getName(), true));
            item.put("value", JSONObjectHelper.stripQuotes(iDEActionWizardItem.getActionValue(), true));
            item.put("content", JSONObjectHelper.stripQuotes(iDEActionWizardItem.getContent(), true));
            item.put("url", JSONObjectHelper.stripQuotes(iDEActionWizardItem.getMoreUrl(), true));
            list.add(item);
        }
        jsonObject.put("items", (Object)JSONArray.fromArray((Object[])list.toArray()));
        return jsonObject;
    }
}

