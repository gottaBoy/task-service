/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.sysmodel;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.ICodeListHelper;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.hibernate.SessionFactory;

public abstract class CodeListModelBase
extends CodeItemModel
implements ICodeListModel {
    protected CodeList codeList = null;
    protected HashMap<String, CodeItemModel> codeItemModelMap = new HashMap();
    private ThreadLocal<IWebContext> webContext = new ThreadLocal();
    private SessionFactory sessionFactory = null;
    private String strGlobalId = null;
    private ICodeListHelper iCodeListHelper = null;

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof CodeList) {
                    this.prepareCodeList((CodeList)annotation);
                }
                ++n2;
            }
        }
    }

    protected void prepareCodeList(CodeList codeList) {
        this.codeList = codeList;
    }

    @Override
    public ISystem getSystem() {
        return null;
    }

    @Override
    public String getId() {
        return this.codeList.id();
    }

    @Override
    public String getName() {
        return this.codeList.name();
    }

    @Override
    public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
        return this.getCodeListText(strValue, bRecursion, null, null);
    }

    @Override
    public String getCodeListType() {
        return this.codeList.type();
    }

    @Override
    public String getHandler() {
        return null;
    }

    @Override
    public boolean isUserScope() {
        return this.codeList.userscope();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerCodeItemModel(CodeItemModel codeItemModel) {
        HashMap<String, CodeItemModel> hashMap = this.codeItemModelMap;
        synchronized (hashMap) {
            this.codeItemModelMap.put(codeItemModel.getValue(), codeItemModel);
            if (StringHelper.isNullOrEmpty(codeItemModel.getParentValue())) {
                this.childCodeItemList.add(codeItemModel);
            } else {
                CodeItemModel parentCodeItemModel = this.codeItemModelMap.get(codeItemModel.getParentValue());
                parentCodeItemModel.registerChildCodeItemModel(codeItemModel);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected CodeItemModel getCodeItemModel(String strValue) {
        HashMap<String, CodeItemModel> hashMap = this.codeItemModelMap;
        synchronized (hashMap) {
            return this.codeItemModelMap.get(strValue);
        }
    }

    @Override
    public void fillFetchResult(MDAjaxActionResult fetchResult, IWebContext iWebContext) throws Exception {
        this.setWebContext(iWebContext);
        Iterator<ICodeItem> codeItems = this.getCodeItems();
        if (codeItems == null) {
            return;
        }
        String strQuickSearch = null;
        if (iWebContext != null && !StringHelper.isNullOrEmpty(strQuickSearch = WebContext.getFetchQuickSearch(iWebContext))) {
            strQuickSearch = strQuickSearch.toUpperCase().trim();
        }
        while (codeItems.hasNext()) {
            ICodeItem iCodeItem = codeItems.next();
            if (!StringHelper.isNullOrEmpty(strQuickSearch)) {
                boolean bMatch = false;
                if (!StringHelper.isNullOrEmpty(iCodeItem.getText()) && iCodeItem.getText().toUpperCase().indexOf(strQuickSearch) != -1) {
                    bMatch = true;
                }
                if (!bMatch && !StringHelper.isNullOrEmpty(iCodeItem.getRealText()) && iCodeItem.getRealText().toUpperCase().indexOf(strQuickSearch) != -1) {
                    bMatch = true;
                }
                if (!bMatch && !StringHelper.isNullOrEmpty(iCodeItem.getValue()) && iCodeItem.getValue().toUpperCase().indexOf(strQuickSearch) != -1) {
                    bMatch = true;
                }
                if (!bMatch) continue;
            }
            JSONObject jo = new JSONObject();
            jo.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(), true));
            jo.put("realtext", JSONObjectHelper.stripQuotes(iCodeItem.getRealText(), true));
            jo.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(), true));
            fetchResult.getRows().add(jo);
        }
    }

    protected IWebContext getWebContext() {
        return this.webContext.get();
    }

    protected void setWebContext(IWebContext value) {
        this.webContext.set(value);
    }

    @Override
    public String getOrMode() {
        return this.codeList.ormode();
    }

    @Override
    public String getValueSeparator() {
        return this.codeList.valueseparator();
    }

    @Override
    public String getTextSeparator() {
        return this.codeList.textseparator();
    }

    @Override
    public String getEmptyText() {
        return this.codeList.emptytext();
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override
    public String getGlobalId() {
        return this.strGlobalId;
    }

    public void setGlobalId(String strGlobalId) {
        this.strGlobalId = strGlobalId;
    }

    @Override
    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        if (StringHelper.isNullOrEmpty(strValue)) {
            return this.getEmptyText();
        }
        if (StringHelper.compare(this.getOrMode(), "STR", true) == 0) {
            String[] values;
            String strTextSeparator;
            String strValueSeparator = this.getValueSeparator();
            if (StringHelper.isNullOrEmpty(strValueSeparator)) {
                strValueSeparator = ";";
            }
            if (StringHelper.isNullOrEmpty(strTextSeparator = this.getTextSeparator())) {
                strTextSeparator = "\u3001";
            }
            String strTotalText = "";
            String[] stringArray = values = StringHelper.split(strValue, strValueSeparator);
            int n = values.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                CodeItemModel iCodeItem = this.getCodeItemModel(strItem);
                if (iCodeItem == null) {
                    throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u503c[%1$s]\u5bf9\u5e94\u7684\u6587\u672c\u4fe1\u606f", strItem));
                }
                if (!StringHelper.isNullOrEmpty(strTotalText)) {
                    strTotalText = String.valueOf(strTotalText) + strTextSeparator;
                }
                strTotalText = String.valueOf(strTotalText) + iCodeItem.getText();
                ++n2;
            }
            return strTotalText;
        }
        if (StringHelper.compare(this.getOrMode(), "NUM", true) == 0) {
            int nValue;
            String strTextSeparator = this.getTextSeparator();
            if (StringHelper.isNullOrEmpty(strTextSeparator)) {
                strTextSeparator = "\u3001";
            }
            if ((nValue = Integer.parseInt(strValue)) == 0) {
                return this.getEmptyText();
            }
            String strTotalText = "";
            Iterator<ICodeItem> iCodeItems = this.getCodeItems();
            if (iCodeItems != null) {
                while (iCodeItems.hasNext()) {
                    ICodeItem iCodeItem = iCodeItems.next();
                    int nValueItem = Integer.parseInt(iCodeItem.getValue());
                    if ((nValue & nValueItem) != nValueItem) continue;
                    if (!StringHelper.isNullOrEmpty(strTotalText)) {
                        strTotalText = String.valueOf(strTotalText) + strTextSeparator;
                    }
                    strTotalText = String.valueOf(strTotalText) + iCodeItem.getText();
                }
            }
            return strTotalText;
        }
        CodeItemModel iCodeItem = this.getCodeItemModel(strValue);
        if (iCodeItem != null) {
            return iCodeItem.getText();
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u503c[%1$s]\u5bf9\u5e94\u7684\u6587\u672c\u4fe1\u606f", strValue));
    }

    @Override
    public void refresh() throws Exception {
        this.onRefresh();
    }

    protected void onRefresh() throws Exception {
    }

    @Override
    public void from(ICodeListModel iCodeListModel) throws Exception {
    }
}

