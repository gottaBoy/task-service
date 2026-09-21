/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import org.hibernate.SessionFactory;

public abstract class CounterHandlerBase
extends ModelBaseImpl
implements ICounterHandler {
    private ThreadLocal<IWebContext> webContext = new ThreadLocal();
    private ThreadLocal<IViewController> viewController = new ThreadLocal();
    private ISystem iSystem = null;
    private HashMap<String, String> counterItemMap = new HashMap();
    private SessionFactory sessionFactory = null;

    @Override
    public void init(ISystem iSystem) throws Exception {
        this.iSystem = iSystem;
        this.onInit();
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    protected ISystemModel getSystemModel() {
        return (ISystemModel)this.iSystem;
    }

    public IWebContext getWebContext() {
        return this.webContext.get();
    }

    private void setWebContext(IWebContext value) {
        this.webContext.set(value);
    }

    public IViewController getViewController() {
        return this.viewController.get();
    }

    private void setViewController(IViewController value) {
        this.viewController.set(value);
    }

    @Override
    public AjaxActionResult processAction(String strAction, IViewController iViewController, IWebContext iWebContext) throws Exception {
        this.setWebContext(iWebContext);
        this.setViewController(iViewController);
        AjaxActionResult ajaxActionResult = this.onProcessAction(strAction);
        return ajaxActionResult;
    }

    @Override
    public int getCounterItemValue(String strCounterItem, IViewController iViewController, IWebContext iWebContext) throws Exception {
        this.setWebContext(iWebContext);
        this.setViewController(iViewController);
        return this.getCounterItemValue(strCounterItem);
    }

    protected int getCounterItemValue(String strCounterItem) throws Exception {
        return 0;
    }

    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            return this.onFetch();
        }
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onFetch() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerCounterItem(String strItem, String strMemo) {
        strItem = strItem.toUpperCase();
        if (StringHelper.isNullOrEmpty(strMemo)) {
            strMemo = "";
        }
        HashMap<String, String> hashMap = this.counterItemMap;
        synchronized (hashMap) {
            this.counterItemMap.put(strItem, strMemo);
        }
    }

    protected Iterator<String> getCounterItems() {
        return this.counterItemMap.keySet().iterator();
    }

    public SessionFactory getSessionFactory() {
        if (this.sessionFactory != null) {
            return this.sessionFactory;
        }
        if (this.getViewController() != null) {
            return this.getViewController().getSessionFactory();
        }
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

