/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.IServiceAPIAction
 *  net.ibizsys.paas.api.RestServiceAPIActionModel
 *  net.ibizsys.paas.api.RestServiceAPIClientModelBase
 */
package net.ibizsys.paas.sysmodel.util.dynaclient;

import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.RestServiceAPIActionModel;
import net.ibizsys.paas.api.RestServiceAPIClientModelBase;

public class DefaultDynaAPIClientModel
extends RestServiceAPIClientModelBase {
    public DefaultDynaAPIClientModel() throws Exception {
        this.setId("6EE6F748-B8F7-4589-9003-B5B835FEF593");
        this.setName("\u52a8\u6001\u914d\u7f6e\u63a5\u53e3");
        this.setUniqueTag("DynaSystem");
        this.prepareAPIActions();
    }

    protected void prepareAPIActions() throws Exception {
        this.prepareAPIActions_INT_PSDYNAWFVER();
        this.prepareAPIActions_INT_PSDYNACODELISTINST();
        this.prepareAPIActions_INT_PSDYNAWFVERINST();
        this.prepareAPIActions_INT_PSDYNAAPPVIEW();
        this.prepareAPIActions_INT_PSDYNAAPPVIEWINST();
    }

    protected void prepareAPIActions_INT_PSDYNAWFVER() throws Exception {
        RestServiceAPIActionModel action12 = new RestServiceAPIActionModel();
        action12.setId("INT_PSDYNAWFVER__DEACTION__GETDRAFT");
        action12.setName("GetDraft");
        action12.setUniqueTag("INT_PSDYNAWFVER__DEACTION__GETDRAFT");
        action12.setActionType("DEACTION");
        action12.setRequestMethod("GET");
        action12.setActionPath("/psdynawfver/getdraft");
        action12.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action12);
        RestServiceAPIActionModel action13 = new RestServiceAPIActionModel();
        action13.setId("INT_PSDYNAWFVER__DEACTION__REMOVE");
        action13.setName("Remove");
        action13.setUniqueTag("INT_PSDYNAWFVER__DEACTION__REMOVE");
        action13.setActionType("DEACTION");
        action13.setRequestMethod("DELETE");
        action13.setActionPath("/psdynawfver");
        action13.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action13);
        RestServiceAPIActionModel action14 = new RestServiceAPIActionModel();
        action14.setId("INT_PSDYNAWFVER__DEACTION__CHECKKEY");
        action14.setName("CheckKey");
        action14.setUniqueTag("INT_PSDYNAWFVER__DEACTION__CHECKKEY");
        action14.setActionType("DEACTION");
        action14.setRequestMethod("POST");
        action14.setActionPath("/psdynawfver/checkkey");
        action14.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action14);
        RestServiceAPIActionModel action15 = new RestServiceAPIActionModel();
        action15.setId("INT_PSDYNAWFVER__DEACTION__GET");
        action15.setName("Get");
        action15.setUniqueTag("INT_PSDYNAWFVER__DEACTION__GET");
        action15.setActionType("DEACTION");
        action15.setRequestMethod("GET");
        action15.setActionPath("/psdynawfver");
        action15.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action15);
        RestServiceAPIActionModel action16 = new RestServiceAPIActionModel();
        action16.setId("INT_PSDYNAWFVER__DEACTION__UPDATE");
        action16.setName("Update");
        action16.setUniqueTag("INT_PSDYNAWFVER__DEACTION__UPDATE");
        action16.setActionType("DEACTION");
        action16.setRequestMethod("PUT");
        action16.setActionPath("/psdynawfver");
        action16.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action16);
        RestServiceAPIActionModel action17 = new RestServiceAPIActionModel();
        action17.setId("INT_PSDYNAWFVER__DEACTION__CREATE");
        action17.setName("Create");
        action17.setUniqueTag("INT_PSDYNAWFVER__DEACTION__CREATE");
        action17.setActionType("DEACTION");
        action17.setRequestMethod("POST");
        action17.setActionPath("/psdynawfver");
        action17.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action17);
        RestServiceAPIActionModel action18 = new RestServiceAPIActionModel();
        action18.setId("INT_PSDYNAWFVER__DEACTION__SAVE");
        action18.setName("Save");
        action18.setUniqueTag("INT_PSDYNAWFVER__DEACTION__SAVE");
        action18.setActionType("DEACTION");
        action18.setRequestMethod("POST");
        action18.setActionPath("/psdynawfver/save");
        action18.setKeyField("PSDYNAWFVERID");
        this.registerServiceAPIAction((IServiceAPIAction)action18);
    }

    protected void prepareAPIActions_INT_PSDYNACODELISTINST() throws Exception {
        RestServiceAPIActionModel action19 = new RestServiceAPIActionModel();
        action19.setId("INT_PSDYNACODELISTINST__DEACTION__GET");
        action19.setName("Get");
        action19.setUniqueTag("INT_PSDYNACODELISTINST__DEACTION__GET");
        action19.setActionType("DEACTION");
        action19.setRequestMethod("GET");
        action19.setActionPath("/psdynacodelistinst");
        action19.setKeyField("PSDYNACODELISTINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action19);
        RestServiceAPIActionModel action20 = new RestServiceAPIActionModel();
        action20.setId("INT_PSDYNACODELISTINST__FETCH__BYINST");
        action20.setName("BYINST");
        action20.setUniqueTag("INT_PSDYNACODELISTINST__FETCH__BYINST");
        action20.setActionType("FETCH");
        action20.setRequestMethod("POST");
        action20.setActionPath("/psdynacodelistinst/fetchbyinst");
        action20.setKeyField("PSDYNACODELISTINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action20);
    }

    protected void prepareAPIActions_INT_PSDYNAWFVERINST() throws Exception {
        RestServiceAPIActionModel action0 = new RestServiceAPIActionModel();
        action0.setId("INT_PSDYNAWFVERINST__DEACTION__GET");
        action0.setName("Get");
        action0.setUniqueTag("INT_PSDYNAWFVERINST__DEACTION__GET");
        action0.setActionType("DEACTION");
        action0.setRequestMethod("GET");
        action0.setActionPath("/psdynawfverinst");
        action0.setKeyField("PSDYNAWFVERINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action0);
        RestServiceAPIActionModel action1 = new RestServiceAPIActionModel();
        action1.setId("INT_PSDYNAWFVERINST__FETCH__BYINST");
        action1.setName("BYINST");
        action1.setUniqueTag("INT_PSDYNAWFVERINST__FETCH__BYINST");
        action1.setActionType("FETCH");
        action1.setRequestMethod("POST");
        action1.setActionPath("/psdynawfverinst/fetchbyinst");
        action1.setKeyField("PSDYNAWFVERINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action1);
    }

    protected void prepareAPIActions_INT_PSDYNAAPPVIEW() throws Exception {
        RestServiceAPIActionModel action21 = new RestServiceAPIActionModel();
        action21.setId("INT_PSDYNAAPPVIEW__DEACTION__GET");
        action21.setName("Get");
        action21.setUniqueTag("INT_PSDYNAAPPVIEW__DEACTION__GET");
        action21.setActionType("DEACTION");
        action21.setRequestMethod("GET");
        action21.setActionPath("/psdynaappview");
        action21.setKeyField("PSDYNAAPPVIEWID");
        this.registerServiceAPIAction((IServiceAPIAction)action21);
    }

    protected void prepareAPIActions_INT_PSDYNAAPPVIEWINST() throws Exception {
        RestServiceAPIActionModel action2 = new RestServiceAPIActionModel();
        action2.setId("INT_PSDYNAAPPVIEWINST__SELECT");
        action2.setName("Select");
        action2.setUniqueTag("INT_PSDYNAAPPVIEWINST__SELECT");
        action2.setActionType("SELECT");
        action2.setRequestMethod("POST");
        action2.setActionPath("/psdynaappviewinst/select");
        action2.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action2);
        RestServiceAPIActionModel action3 = new RestServiceAPIActionModel();
        action3.setId("INT_PSDYNAAPPVIEWINST__DEACTION__SAVE");
        action3.setName("Save");
        action3.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__SAVE");
        action3.setActionType("DEACTION");
        action3.setRequestMethod("POST");
        action3.setActionPath("/psdynaappviewinst/save");
        action3.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action3);
        RestServiceAPIActionModel action4 = new RestServiceAPIActionModel();
        action4.setId("INT_PSDYNAAPPVIEWINST__DEACTION__GET");
        action4.setName("Get");
        action4.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__GET");
        action4.setActionType("DEACTION");
        action4.setRequestMethod("GET");
        action4.setActionPath("/psdynaappviewinst");
        action4.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action4);
        RestServiceAPIActionModel action5 = new RestServiceAPIActionModel();
        action5.setId("INT_PSDYNAAPPVIEWINST__DEACTION__CHECKKEY");
        action5.setName("CheckKey");
        action5.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__CHECKKEY");
        action5.setActionType("DEACTION");
        action5.setRequestMethod("POST");
        action5.setActionPath("/psdynaappviewinst/checkkey");
        action5.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action5);
        RestServiceAPIActionModel action6 = new RestServiceAPIActionModel();
        action6.setId("INT_PSDYNAAPPVIEWINST__DEACTION__UPDATE");
        action6.setName("Update");
        action6.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__UPDATE");
        action6.setActionType("DEACTION");
        action6.setRequestMethod("PUT");
        action6.setActionPath("/psdynaappviewinst");
        action6.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action6);
        RestServiceAPIActionModel action7 = new RestServiceAPIActionModel();
        action7.setId("INT_PSDYNAAPPVIEWINST__DEACTION__CREATE");
        action7.setName("Create");
        action7.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__CREATE");
        action7.setActionType("DEACTION");
        action7.setRequestMethod("POST");
        action7.setActionPath("/psdynaappviewinst");
        action7.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action7);
        RestServiceAPIActionModel action8 = new RestServiceAPIActionModel();
        action8.setId("INT_PSDYNAAPPVIEWINST__DEACTION__REMOVE");
        action8.setName("Remove");
        action8.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__REMOVE");
        action8.setActionType("DEACTION");
        action8.setRequestMethod("DELETE");
        action8.setActionPath("/psdynaappviewinst");
        action8.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action8);
        RestServiceAPIActionModel action9 = new RestServiceAPIActionModel();
        action9.setId("INT_PSDYNAAPPVIEWINST__DEACTION__GETDRAFT");
        action9.setName("GetDraft");
        action9.setUniqueTag("INT_PSDYNAAPPVIEWINST__DEACTION__GETDRAFT");
        action9.setActionType("DEACTION");
        action9.setRequestMethod("GET");
        action9.setActionPath("/psdynaappviewinst/getdraft");
        action9.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action9);
        RestServiceAPIActionModel action10 = new RestServiceAPIActionModel();
        action10.setId("INT_PSDYNAAPPVIEWINST__FETCH__BYINST");
        action10.setName("BYINST");
        action10.setUniqueTag("INT_PSDYNAAPPVIEWINST__FETCH__BYINST");
        action10.setActionType("FETCH");
        action10.setRequestMethod("POST");
        action10.setActionPath("/psdynaappviewinst/fetchbyinst");
        action10.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action10);
        RestServiceAPIActionModel action11 = new RestServiceAPIActionModel();
        action11.setId("INT_PSDYNAAPPVIEWINST__FETCH__DEFAULT");
        action11.setName("DEFAULT");
        action11.setUniqueTag("INT_PSDYNAAPPVIEWINST__FETCH__DEFAULT");
        action11.setActionType("FETCH");
        action11.setRequestMethod("POST");
        action11.setActionPath("/psdynaappviewinst/fetchdefault");
        action11.setKeyField("PSDYNAAPPVIEWINSTID");
        this.registerServiceAPIAction((IServiceAPIAction)action11);
    }
}

