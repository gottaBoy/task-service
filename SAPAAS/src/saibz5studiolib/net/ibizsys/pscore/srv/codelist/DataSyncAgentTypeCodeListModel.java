/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="ca9f841e5771d359c0ae15eb734c7a82", name="\u5e73\u53f0\u6570\u636e\u540c\u6b65\u4ee3\u7406\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="KAFKA", text="Kafka", realtext="Kafka"), @CodeItem(value="RABBITMQ", text="RabbitMQ", realtext="RabbitMQ"), @CodeItem(value="ACTIVEMQ", text="ActiveMQ", realtext="ActiveMQ"), @CodeItem(value="ROCKETMQ", text="RocketMQ", realtext="RocketMQ"), @CodeItem(value="MQTT", text="MQTT", realtext="MQTT"), @CodeItem(value="STOMP", text="STOMP", realtext="STOMP"), @CodeItem(value="WS", text="WebSocket", realtext="WebSocket"), @CodeItem(value="INTERNAL", text="\u5185\u90e8\u901a\u8baf", realtext="\u5185\u90e8\u901a\u8baf", userdata="\u6307\u5b9a\u7528\u4e8e\u7cfb\u7edf\u5185\u90e8\u901a\u8baf\u7684\u4ee3\u7406"), @CodeItem(value="USER", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="USER2", text="\u7528\u6237\u81ea\u5b9a\u4e492", realtext="\u7528\u6237\u81ea\u5b9a\u4e492"), @CodeItem(value="USER3", text="\u7528\u6237\u81ea\u5b9a\u4e493", realtext="\u7528\u6237\u81ea\u5b9a\u4e493"), @CodeItem(value="USER4", text="\u7528\u6237\u81ea\u5b9a\u4e494", realtext="\u7528\u6237\u81ea\u5b9a\u4e494")})
public class DataSyncAgentTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String KAFKA = "KAFKA";
    public static final String RABBITMQ = "RABBITMQ";
    public static final String ACTIVEMQ = "ACTIVEMQ";
    public static final String ROCKETMQ = "ROCKETMQ";
    public static final String MQTT = "MQTT";
    public static final String STOMP = "STOMP";
    public static final String WS = "WS";
    public static final String INTERNAL = "INTERNAL";
    public static final String USER = "USER";
    public static final String USER2 = "USER2";
    public static final String USER3 = "USER3";
    public static final String USER4 = "USER4";

    public DataSyncAgentTypeCodeListModel() {
        this.initAnnotation(DataSyncAgentTypeCodeListModel.class);
        this.setUserData2("DataSyncAgentType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncAgentTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DataSyncAgentTypeCodeListModel");
    }
}

