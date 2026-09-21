/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgModel;

public class ViewMsgGroupModel
extends SystemModelObjectBase
implements IViewMsgGroupModel {
    protected ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList();
    private String strUniqueTag = null;

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        if (!StringHelper.isNullOrEmpty(this.getUserTag()) && !StringHelper.isNullOrEmpty(this.getUserTag2())) {
            this.strUniqueTag = StringHelper.format("%1$s||%2$s", this.getUserTag(), this.getUserTag2());
        } else if (!StringHelper.isNullOrEmpty(this.getUserTag())) {
            this.strUniqueTag = this.getUserTag();
        } else if (!StringHelper.isNullOrEmpty(this.getUserTag2())) {
            this.strUniqueTag = this.getUserTag2();
        }
        this.onInit();
    }

    @Override
    public void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception {
        this.viewMsgModelList.add(iViewMsgModel);
    }

    @Override
    public void fillViewMessages(IViewController iViewController, ArrayList<IViewMessage> viewMessageList) throws Exception {
        ArrayList<IViewMsgModel> viewMsgModelList2 = new ArrayList<IViewMsgModel>();
        for (IViewMsgModel iViewMsgModel : this.viewMsgModelList) {
            iViewMsgModel.fillViewMessages(iViewController, viewMsgModelList2);
        }
        Collections.sort(viewMsgModelList2, new Comparator<IViewMsgModel>(){

            @Override
            public int compare(IViewMsgModel o1, IViewMsgModel o2) {
                return o1.getOrderValue() - o2.getOrderValue();
            }
        });
        viewMessageList.addAll(viewMsgModelList2);
    }

    @Override
    public String getUniqueTag() {
        return this.strUniqueTag;
    }
}

