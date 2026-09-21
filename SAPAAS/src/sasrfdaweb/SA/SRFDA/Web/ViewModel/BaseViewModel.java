/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFDA.Web.ViewModel.LinkModel;
import java.util.Hashtable;
import net.sf.json.JSONObject;

public abstract class BaseViewModel {
    protected Hashtable<String, BaseViewModel> childViewModelMap = new Hashtable();
    protected Hashtable<String, LinkModel> linkModelMap = new Hashtable();

    public void RegisterViewModel(String strKey, BaseViewModel viewModel) {
        this.childViewModelMap.put(strKey, viewModel);
    }

    public BaseViewModel GetViewModel(String strKey) {
        BaseViewModel viewModel = null;
        if (this.childViewModelMap.containsKey(strKey)) {
            viewModel = this.childViewModelMap.get(strKey);
        }
        return viewModel;
    }

    public void UnregisterViewModel(String strKey) {
        if (this.childViewModelMap.containsKey(strKey)) {
            this.childViewModelMap.remove(strKey);
        }
    }

    public void RegisterLinkModel(String strKey, LinkModel linkModel) {
        this.linkModelMap.put(strKey, linkModel);
    }

    public LinkModel GetLinkModel(String strKey) {
        LinkModel linkModel = null;
        if (this.linkModelMap.containsKey(strKey)) {
            linkModel = this.linkModelMap.get(strKey);
        }
        return linkModel;
    }

    public void UnregisterLinkModel(String strKey) {
        if (this.linkModelMap.containsKey(strKey)) {
            this.linkModelMap.remove(strKey);
        }
    }

    public void FillJSONObject(JSONObject jo) {
        this.OnFillJSONObject(jo);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        for (String strKey : this.childViewModelMap.keySet()) {
            BaseViewModel viewModel = this.childViewModelMap.get(strKey);
            jo.put(strKey, (Object)viewModel.GetJSONObject());
        }
        if (this.linkModelMap.size() > 0) {
            JSONObject links = new JSONObject();
            jo.put("links", (Object)links);
            for (String strKey : this.linkModelMap.keySet()) {
                LinkModel linkModel = this.linkModelMap.get(strKey);
                links.put(strKey, (Object)linkModel.GetJSONObject());
            }
        }
    }

    public JSONObject GetJSONObject() {
        JSONObject jo = new JSONObject();
        this.FillJSONObject(jo);
        return jo;
    }
}

