/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DGEx.UI.DGExConfig
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.SP.UI.SPExConfig
 *  SA.SRFramework.WebEx.UI.DataGridConfig
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DataGridEx;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.util.Hashtable;

public class SRFDAConfigCache {
    protected Hashtable<String, Form> formMap = new Hashtable();
    protected Hashtable<String, DataGrid> dataGridMap = new Hashtable();
    protected Hashtable<String, DataGridEx> dataGridExMap = new Hashtable();
    protected Hashtable<String, Page> pageMap = new Hashtable();
    protected Hashtable<String, DPConfig> dpConfigMap = new Hashtable();
    protected Hashtable<String, SPExConfig> spExConfigMap = new Hashtable();
    protected Hashtable<String, DataGridConfig> dataGridConfigMap = new Hashtable();
    protected Hashtable<String, DGExConfig> dgExConfigMap = new Hashtable();
    protected Hashtable<String, Object> searchFormMap = new Hashtable();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    public SRFDAConfigCache(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Page FindPage(SRFDAWebContext webContext, String strPageId) {
        Page page;
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)strPageId);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, Page> hashtable = this.pageMap;
            synchronized (hashtable) {
                if (this.pageMap.containsKey(strFullKey)) {
                    return this.pageMap.get(strFullKey);
                }
            }
        }
        if ((page = this.iDAGlobalHelper.getDAModelStorage().FindPage(strPageId)) == null) {
            webContext.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u914d\u7f6e[%1$s]\u5931\u8d25", (Object)strPageId));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return page;
        }
        Hashtable<String, Page> hashtable = this.pageMap;
        synchronized (hashtable) {
            if (this.pageMap.size() >= 20) {
                this.pageMap.clear();
            }
            this.pageMap.put(strFullKey, page);
        }
        return page;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Form GetUserDEForm(SRFDAWebContext webContext, String strFormViewId) {
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)strFormViewId);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, Form> hashtable = this.formMap;
            synchronized (hashtable) {
                if (this.formMap.containsKey(strFullKey)) {
                    return this.formMap.get(strFullKey);
                }
            }
        }
        Form formView = new Form();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetUserDEForm(strFormViewId, webContext.getCurUserId(), formView);
        if (callResult == null || callResult.getRetCode() != 0) {
            webContext.getPage().PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u5355\u89c6\u56fe[%1$s]\u5931\u8d25", (Object)strFormViewId), callResult);
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return formView;
        }
        Hashtable<String, Form> hashtable = this.formMap;
        synchronized (hashtable) {
            if (this.formMap.size() >= 20) {
                this.formMap.clear();
            }
            this.formMap.put(strFullKey, formView);
        }
        return formView;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataGrid GetUserDEDataGrid(SRFDAWebContext webContext, String strGridViewId) {
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)strGridViewId);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, DataGrid> hashtable = this.dataGridMap;
            synchronized (hashtable) {
                if (this.dataGridMap.containsKey(strFullKey)) {
                    return this.dataGridMap.get(strFullKey);
                }
            }
        }
        DataGrid gridView = new DataGrid();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetUserDEDataGrid(strGridViewId, webContext.getCurUserId(), gridView);
        if (callResult == null || callResult.getRetCode() != 0) {
            webContext.getPage().PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u683c\u89c6\u56fe[%1$s]\u5931\u8d25", (Object)strGridViewId), callResult);
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return gridView;
        }
        Hashtable<String, DataGrid> hashtable = this.dataGridMap;
        synchronized (hashtable) {
            if (this.dataGridMap.size() >= 20) {
                this.dataGridMap.clear();
            }
            this.dataGridMap.put(strFullKey, gridView);
        }
        return gridView;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataGridEx GetDEDataGridEx(SRFDAWebContext webContext, String strGridViewExId) {
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)strGridViewExId);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, DataGridEx> hashtable = this.dataGridExMap;
            synchronized (hashtable) {
                if (this.dataGridExMap.containsKey(strFullKey)) {
                    return this.dataGridExMap.get(strFullKey);
                }
            }
        }
        DataGridEx gridView = new DataGridEx();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetDEDataGridEx(strGridViewExId, webContext.getCurUserId(), gridView);
        if (callResult == null || callResult.getRetCode() != 0) {
            webContext.getPage().PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6269\u5c55\u8868\u683c\u89c6\u56fe[%1$s]\u5931\u8d25", (Object)strGridViewExId), callResult);
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return gridView;
        }
        Hashtable<String, DataGridEx> hashtable = this.dataGridExMap;
        synchronized (hashtable) {
            if (this.dataGridExMap.size() >= 20) {
                this.dataGridExMap.clear();
            }
            this.dataGridExMap.put(strFullKey, gridView);
        }
        return gridView;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Form GetDefaultDEMainForm(SRFDAWebContext webContext, String strPageDataEntityId) {
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        Form formView = new Form();
        CallResult callResult = this.iDAGlobalHelper.getDAModelStorage().GetDEMainForm(strPageDataEntityId, formView, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            webContext.getPage().PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u9ed8\u8ba4\u8868\u5355\u89c6\u56fe\u5931\u8d25", (Object)strPageDataEntityId), callResult);
            return null;
        }
        if (webContext.IsBackEndMode() || StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return formView;
        }
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)formView.getFORMID());
        Hashtable<String, Form> hashtable = this.formMap;
        synchronized (hashtable) {
            if (this.formMap.size() >= 20) {
                this.formMap.clear();
            }
            this.formMap.put(strFullKey, formView);
        }
        return formView;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DPConfig GetDPConfig(SRFDAWebContext webContext, String strUniqueId, String strConfig) {
        DPConfig panelConfig;
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strAccSeq, (Object)strUniqueId, (Object)strConfig);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, DPConfig> hashtable = this.dpConfigMap;
            synchronized (hashtable) {
                if (this.dpConfigMap.containsKey(strFullKey)) {
                    return this.dpConfigMap.get(strFullKey);
                }
            }
        }
        if ((panelConfig = webContext.getDynamicPanelMgr().GetDPExConfig(strConfig)) == null) {
            webContext.getPage().PageLog((Object)webContext.getPage(), 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f[%1$s]\u65e0\u6548", (Object)strConfig));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return panelConfig;
        }
        Hashtable<String, DPConfig> hashtable = this.dpConfigMap;
        synchronized (hashtable) {
            if (this.dpConfigMap.size() >= 20) {
                this.dpConfigMap.clear();
            }
            this.dpConfigMap.put(strFullKey, panelConfig);
        }
        return panelConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SPExConfig GetSPExConfig(SRFDAWebContext webContext, String strUniqueId, String strConfig) {
        SPExConfig spExConfig;
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strAccSeq, (Object)strUniqueId, (Object)strConfig);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, SPExConfig> hashtable = this.spExConfigMap;
            synchronized (hashtable) {
                if (this.spExConfigMap.containsKey(strFullKey)) {
                    return this.spExConfigMap.get(strFullKey);
                }
            }
        }
        if ((spExConfig = webContext.getSearchPanelMgr().GetSPExConfig(strConfig)) == null) {
            webContext.getPage().PageLog((Object)webContext.getPage(), 1, StringHelper.Format((String)"\u641c\u7d22\u9762\u677f[%1$s]\u65e0\u6548", (Object)strConfig));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return spExConfig;
        }
        Hashtable<String, SPExConfig> hashtable = this.spExConfigMap;
        synchronized (hashtable) {
            if (this.spExConfigMap.size() >= 20) {
                this.spExConfigMap.clear();
            }
            this.spExConfigMap.put(strFullKey, spExConfig);
        }
        return spExConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataGridConfig GetDataGridConfig(SRFDAWebContext webContext, String strUniqueId, String strConfig) {
        DataGridConfig dataGridConfig;
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strAccSeq, (Object)strUniqueId, (Object)strConfig);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, DataGridConfig> hashtable = this.dataGridConfigMap;
            synchronized (hashtable) {
                if (this.dataGridConfigMap.containsKey(strFullKey)) {
                    return this.dataGridConfigMap.get(strFullKey);
                }
            }
        }
        if ((dataGridConfig = webContext.getDataGridMgr().GetDataGridConfig(strConfig)) == null) {
            webContext.getPage().PageLog((Object)webContext.getPage(), 1, StringHelper.Format((String)"\u8868\u683c\u89c6\u56fe[%1$s]\u65e0\u6548", (Object)strConfig));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return dataGridConfig;
        }
        Hashtable<String, DataGridConfig> hashtable = this.dataGridConfigMap;
        synchronized (hashtable) {
            if (this.dataGridConfigMap.size() >= 20) {
                this.dataGridConfigMap.clear();
            }
            this.dataGridConfigMap.put(strFullKey, dataGridConfig);
        }
        return dataGridConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DGExConfig GetDGExConfig(SRFDAWebContext webContext, String strUniqueId, String strConfig) {
        DGExConfig dgExConfig;
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strAccSeq, (Object)strUniqueId, (Object)strConfig);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Hashtable<String, DGExConfig> hashtable = this.dgExConfigMap;
            synchronized (hashtable) {
                if (this.dgExConfigMap.containsKey(strFullKey)) {
                    return this.dgExConfigMap.get(strFullKey);
                }
            }
        }
        if ((dgExConfig = webContext.getDataGridMgr().GetDGExConfig(strConfig)) == null) {
            webContext.getPage().PageLog((Object)webContext.getPage(), 1, StringHelper.Format((String)"\u8868\u683c\u6269\u5c55\u89c6\u56fe[%1$s]\u65e0\u6548", (Object)strConfig));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return dgExConfig;
        }
        Hashtable<String, DGExConfig> hashtable = this.dgExConfigMap;
        synchronized (hashtable) {
            if (this.dgExConfigMap.size() >= 20) {
                this.dgExConfigMap.clear();
            }
            this.dgExConfigMap.put(strFullKey, dgExConfig);
        }
        return dgExConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SearchForm GetDESearchForm(SRFDAWebContext webContext, String strSearchFormId, boolean bDefaultSF) {
        String strAccSeq = webContext.GetParamValue("SRFACCSEQ");
        String strFullKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strAccSeq, (Object)strSearchFormId);
        if (!StringHelper.IsNullOrEmpty((String)strAccSeq) && webContext.IsBackEndMode()) {
            Object objSearchForm = null;
            Hashtable<String, Object> hashtable = this.searchFormMap;
            synchronized (hashtable) {
                objSearchForm = this.searchFormMap.get(strFullKey);
            }
            if (objSearchForm != null) {
                if (objSearchForm instanceof SearchForm) {
                    return (SearchForm)((Object)objSearchForm);
                }
                return null;
            }
        }
        SearchForm searchForm = new SearchForm();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetDESearchForm(strSearchFormId, searchForm);
        if (callResult.IsError()) {
            if (bDefaultSF) {
                webContext.getPage().PageLog((Object)this, 4, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u641c\u7d22\u8868\u5355[%1$s]\u5931\u8d25,%2$s", (Object)strSearchFormId, (Object)callResult.getErrorInfo()));
                if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
                    return null;
                }
                Hashtable<String, Object> hashtable = this.searchFormMap;
                synchronized (hashtable) {
                    if (this.searchFormMap.size() >= 20) {
                        this.searchFormMap.clear();
                    }
                    this.searchFormMap.put(strFullKey, "");
                }
            } else {
                webContext.getPage().PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u641c\u7d22\u8868\u5355[%1$s]\u5931\u8d25", (Object)strSearchFormId), callResult);
            }
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strAccSeq)) {
            return searchForm;
        }
        Hashtable<String, Object> hashtable = this.searchFormMap;
        synchronized (hashtable) {
            if (this.searchFormMap.size() >= 20) {
                this.searchFormMap.clear();
            }
            this.searchFormMap.put(strFullKey, (Object)searchForm);
        }
        return searchForm;
    }
}

