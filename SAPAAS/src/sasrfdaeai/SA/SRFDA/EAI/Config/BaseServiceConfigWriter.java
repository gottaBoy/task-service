/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Registry
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.Ctrl.Data.Registry;
import SA.SRFDA.EAI.Config.BaseDataSourceConfigWriter;
import SA.SRFDA.EAI.Config.BaseJDBCConnectorConfigWriter;
import SA.SRFDA.EAI.Config.ISRFEAIConfigWriter;
import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Ctrl.Data.EAIDataSource;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcess;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Ctrl.Data.JDBCConnector;
import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIChainingProcessConfig;
import SA.SRFDA.EAI.Model.EAIDecideProcessConfig;
import SA.SRFDA.EAI.Model.EAIInboundProcessConfig;
import SA.SRFDA.EAI.Model.EAIMulticastingProcessConfig;
import SA.SRFDA.EAI.Model.EAIOutboundProcessConfig;
import SA.SRFDA.EAI.Model.EAIProcessConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

public class BaseServiceConfigWriter {
    protected Vector<ISRFEAIConfigWriter> configWriters = new Vector();

    public CallResult Export(EAIService eaiService, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        xmlWriter.WriteStartElement("mule");
        xmlWriter.WriteAttributeString("xmlns", "http://www.mulesource.org/schema/mule/core/2.2");
        xmlWriter.WriteAttributeString("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        xmlWriter.WriteAttributeString("xmlns:spring", "http://www.springframework.org/schema/beans");
        xmlWriter.WriteAttributeString("xmlns:context", "http://www.springframework.org/schema/context");
        xmlWriter.WriteAttributeString("xmlns:stdio", "http://www.mulesource.org/schema/mule/stdio/2.2");
        xmlWriter.WriteAttributeString("xmlns:http", "http://www.mulesource.org/schema/mule/http/2.2");
        xmlWriter.WriteAttributeString("xmlns:axis", "http://www.mulesource.org/schema/mule/axis/2.2");
        xmlWriter.WriteAttributeString("xmlns:vm", "http://www.mulesource.org/schema/mule/vm/2.2");
        xmlWriter.WriteAttributeString("xmlns:xm", "http://www.mulesource.org/schema/mule/xml/2.2");
        xmlWriter.WriteAttributeString("xmlns:jdbc", "http://www.mulesource.org/schema/mule/jdbc/2.2");
        xmlWriter.WriteAttributeString("xmlns:tcp", "http://www.mulesource.org/schema/mule/tcp/2.2");
        xmlWriter.WriteAttributeString("xmlns:udp", "http://www.mulesource.org/schema/mule/udp/2.2");
        xmlWriter.WriteAttributeString("xmlns:ftp", "http://www.mulesource.org/schema/mule/ftp/2.2");
        xmlWriter.WriteAttributeString("xmlns:file", "http://www.mulesource.org/schema/mule/file/2.2");
        xmlWriter.WriteAttributeString("xmlns:sftp", "http://www.mulesource.org/schema/mule/sftp/2.2");
        xmlWriter.WriteAttributeString("xmlns:cxf", "http://www.mulesource.org/schema/mule/cxf/2.2");
        xmlWriter.WriteRaw("\r\n");
        xmlWriter.WriteAttributeString("xsi:schemaLocation", "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd http://www.mulesource.org/schema/mule/core/2.2 http://www.mulesource.org/schema/mule/core/2.2/mule.xsd http://www.mulesource.org/schema/mule/stdio/2.2 http://www.mulesource.org/schema/mule/stdio/2.2/mule-stdio.xsd http://www.mulesource.org/schema/mule/jdbc/2.2 http://www.mulesource.org/schema/mule/jdbc/2.2/mule-jdbc.xsd http://www.mulesource.org/schema/mule/http/2.2 http://www.mulesource.org/schema/mule/http/2.2/mule-http.xsd http://www.mulesource.org/schema/mule/axis/2.2 http://www.mulesource.org/schema/mule/axis/2.2/mule-axis.xsd http://www.mulesource.org/schema/mule/vm/2.2 http://www.mulesource.org/schema/mule/vm/2.2/mule-vm.xsd http://www.mulesource.org/schema/mule/xml/2.2 http://www.mulesource.org/schema/mule/xml/2.2/mule-xml.xsd http://www.mulesource.org/schema/mule/tcp/2.2 http://www.mulesource.org/schema/mule/tcp/2.2/mule-tcp.xsd http://www.mulesource.org/schema/mule/udp/2.2 http://www.mulesource.org/schema/mule/udp/2.2/mule-udp.xsd http://www.mulesource.org/schema/mule/ftp/2.2 http://www.mulesource.org/schema/mule/ftp/2.2/mule-ftp.xsd http://www.mulesource.org/schema/mule/file/2.2 http://www.mulesource.org/schema/mule/file/2.2/mule-file.xsd http://www.mulesource.org/schema/mule/sftp/2.2 http://www.softanywhere.com/schema/saeai/sftp/mule-sftp.xsd http://www.mulesource.org/schema/mule/cxf/2.2 http://www.mulesource.org/schema/mule/cxf/2.2/mule-cxf.xsd ");
        Registry registry = new Registry();
        callResult = writerContext.getGlobalHelper().getDAModelHelper().GetRegistry("EAI", "SRFDADATASOURCE", registry);
        if (callResult.IsError()) {
            callResult.ReformatErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u6ce8\u518c\u8868[%1$s]\u4fe1\u606f\u5931\u8d25\uff0c%%1$s", (Object)"SRFDADATASOURCE"));
            return callResult;
        }
        xmlWriter.WriteStartElement("spring:bean");
        xmlWriter.WriteAttributeString("id", "SRFDADATASOURCE");
        xmlWriter.WriteAttributeString("class", "org.enhydra.jdbc.standard.StandardDataSource");
        xmlWriter.WriteAttributeString("destroy-method", "shutdown");
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "driverName");
        xmlWriter.WriteAttributeString("value", registry.GetParam("DRIVERNAME", ""));
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "url");
        xmlWriter.WriteAttributeString("value", registry.GetParam("URL", ""));
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "user");
        xmlWriter.WriteAttributeString("value", registry.GetParam("USER", ""));
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "password");
        xmlWriter.WriteAttributeString("value", registry.GetParam("PASSWORD", ""));
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        xmlWriter.WriteStartElement("spring:bean");
        xmlWriter.WriteAttributeString("id", "EAISERVICE");
        xmlWriter.WriteAttributeString("class", "SA.SRFDA.EAI.Ctrl.InstanceMgr");
        xmlWriter.WriteStartElement("spring:property");
        xmlWriter.WriteAttributeString("name", "config");
        xmlWriter.WriteStartElement("spring:map");
        xmlWriter.WriteStartElement("spring:entry");
        xmlWriter.WriteAttributeString("key", "SERVICEID");
        xmlWriter.WriteAttributeString("value", writerContext.getServiceId());
        xmlWriter.WriteEndElement();
        registry.Reset();
        callResult = writerContext.getGlobalHelper().getDAModelHelper().GetRegistry("EAI", "EAIINSTANCE", registry);
        if (callResult.IsError()) {
            callResult.ReformatErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u6ce8\u518c\u8868[%1$s]\u4fe1\u606f\u5931\u8d25\uff0c%%1$s", (Object)"EAIINSTANCE"));
            return callResult;
        }
        for (Object strKey : registry.GetParams().keySet()) {
            xmlWriter.WriteStartElement("spring:entry");
            xmlWriter.WriteAttributeString("key", strKey.toString());
            xmlWriter.WriteAttributeString("value", registry.GetParam(strKey.toString(), ""));
            xmlWriter.WriteEndElement();
        }
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        xmlWriter.WriteEndElement();
        registry.Reset();
        Iterator iterator = writerContext.getEAIConfig().getProcessesConfig().iterator();
        while (iterator.hasNext()) {
            EAIBaseProcessConfig processConfig = (EAIBaseProcessConfig)((Object)iterator.next());
            String strSecKey = "";
            if (processConfig instanceof EAIInboundProcessConfig) {
                EAIInboundProcessConfig inboundProcessConfig = (EAIInboundProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"INBOUND", (Object)inboundProcessConfig.getInboundType());
            } else if (processConfig instanceof EAIOutboundProcessConfig) {
                EAIOutboundProcessConfig outboundProcessConfig = (EAIOutboundProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s.%2$s", (Object)"OUTBOUND", (Object)outboundProcessConfig.getOutboundType());
            } else if (processConfig instanceof EAIDecideProcessConfig) {
                EAIDecideProcessConfig decideProcessConfig = (EAIDecideProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s", (Object)"DECISION");
            } else if (processConfig instanceof EAIChainingProcessConfig) {
                EAIChainingProcessConfig chainingProcessConfig = (EAIChainingProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s", (Object)"CHAINING");
            } else if (processConfig instanceof EAIMulticastingProcessConfig) {
                EAIMulticastingProcessConfig multicastingProcessConfig = (EAIMulticastingProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s", (Object)"MULTICASTING");
            } else if (processConfig instanceof EAIProcessConfig) {
                EAIProcessConfig realProcessConfig = (EAIProcessConfig)processConfig;
                strSecKey = StringHelper.Format((String)"%1$s", (Object)"PROCESS");
            }
            callResult = writerContext.getGlobalHelper().getDAModelHelper().GetRegistry("EAI", "CONFIGWRITER", registry);
            if (callResult.IsError()) {
                callResult.ReformatErrorInfo(StringHelper.Format((String)"\u52a0\u8f7d\u6ce8\u518c\u8868[%1$s]\u4fe1\u606f\u5931\u8d25\uff0c%%1$s", (Object)strSecKey));
                return callResult;
            }
            String strConfigWriter = registry.GetParam(strSecKey, "");
            if (StringHelper.IsNullOrEmpty((String)strConfigWriter)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5904\u7406[%1$s]\u914d\u7f6e\u7f16\u5199\u5668", (Object)strSecKey));
                return callResult;
            }
            Object objConfigWriter = ObjectHelper.Create((String)strConfigWriter);
            if (objConfigWriter == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u914d\u7f6e\u7f16\u5199\u5668[%1$s]", (Object)strConfigWriter));
                return callResult;
            }
            if (!(objConfigWriter instanceof ISRFEAIConfigWriter)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u5199\u5668[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strConfigWriter));
                return callResult;
            }
            ISRFEAIConfigWriter configWriter = (ISRFEAIConfigWriter)objConfigWriter;
            callResult = configWriter.Init(processConfig, writerContext);
            if (callResult.IsError()) {
                callResult.ReformatErrorInfo("\u521d\u59cb\u5316\u914d\u7f6e\u5668\u5931\u8d25\uff0c%1$s");
                return callResult;
            }
            this.configWriters.add((ISRFEAIConfigWriter)objConfigWriter);
        }
        TreeMap<String, String> dataSources = new TreeMap<String, String>();
        for (ISRFEAIConfigWriter eaiConfigWriter : this.configWriters) {
            String strDataSourceId = eaiConfigWriter.GetDataSourceId();
            if (StringHelper.IsNullOrEmpty((String)strDataSourceId)) continue;
            dataSources.put(strDataSourceId, strDataSourceId);
        }
        callResult = this.OnExportDataSources(eaiService, dataSources, xmlWriter, writerContext);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnExportConnectors(eaiService, xmlWriter, writerContext);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnExportProtocols(eaiService, xmlWriter, writerContext);
        if (callResult.IsError()) {
            return callResult;
        }
        callResult = this.OnExportServices(eaiService, xmlWriter, writerContext);
        if (callResult.IsError()) {
            return callResult;
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected CallResult OnExportServices(EAIService eaiService, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        Vector<EAIProcess> processes = new Vector<EAIProcess>();
        CallResult callResult = writerContext.getEAIDataCtrl().GetServiceProcesses(eaiService.getEAISERVICEID(), processes);
        if (callResult.getRetCode() != 0) {
            callResult.ReformatErrorInfo("\u67e5\u8be2\u670d\u52a1JDBC\u5165\u7ad9\u70b9\u5931\u8d25\uff0c%1$s");
            return callResult;
        }
        xmlWriter.WriteStartElement("model");
        xmlWriter.WriteAttributeString("name", eaiService.getEAISERVICENAME());
        for (ISRFEAIConfigWriter configWriter : this.configWriters) {
            callResult = configWriter.ExportService(xmlWriter);
            if (callResult.getRetCode() == 0) continue;
            callResult.ReformatErrorInfo("\u5bfc\u51fa\u670d\u52a1\u5931\u8d25\uff0c%1$s");
            return callResult;
        }
        xmlWriter.WriteEndElement();
        return callResult;
    }

    protected CallResult OnExportConnectors(EAIService eaiService, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        for (ISRFEAIConfigWriter configWriter : this.configWriters) {
            callResult = configWriter.ExportConnector(xmlWriter);
            if (callResult.getRetCode() == 0) continue;
            callResult.ReformatErrorInfo("\u5bfc\u51fa\u8fde\u63a5\u70b9\u5931\u8d25\uff0c%1$s");
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnExportProtocols(EAIService eaiService, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        for (ISRFEAIConfigWriter configWriter : this.configWriters) {
            callResult = configWriter.ExportProtocol(xmlWriter);
            if (callResult.getRetCode() == 0) continue;
            callResult.ReformatErrorInfo("\u5bfc\u51fa\u534f\u8bae\u5931\u8d25\uff0c%1$s");
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnExportJDBCConnector(JDBCConnector eaiJDBCOB, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        String strConfigWriter = eaiJDBCOB.getCONNECTORCW();
        Object objConfigWriter = ObjectHelper.Create((String)strConfigWriter);
        if (objConfigWriter == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u64cd\u4f5c\u914d\u7f6e\u7f16\u5199\u5668[%1$s]", (Object)strConfigWriter));
            return callResult;
        }
        if (!(objConfigWriter instanceof BaseJDBCConnectorConfigWriter)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u64cd\u4f5c\u914d\u7f6e\u7f16\u5199\u5668[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strConfigWriter));
            return callResult;
        }
        BaseJDBCConnectorConfigWriter configWriter = (BaseJDBCConnectorConfigWriter)objConfigWriter;
        return configWriter.Export(eaiJDBCOB, xmlWriter, writerContext);
    }

    protected CallResult OnExportDataSources(EAIService eaiService, TreeMap<String, String> dataSources, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        for (String strDataSourceId : dataSources.values()) {
            EAIDataSource dataSource = new EAIDataSource();
            callResult = writerContext.getEAIDataCtrl().GetDataSource(strDataSourceId, dataSource);
            if (callResult.IsError()) {
                callResult.ReformatErrorInfo("\u67e5\u8be2\u670d\u52a1\u5f15\u7528\u6570\u636e\u6e90\u9519\u8bef\uff0c%1$s");
                return callResult;
            }
            callResult = this.OnExportDataSources(dataSource, xmlWriter, writerContext);
            if (!callResult.IsError()) continue;
            callResult.ReformatErrorInfo("\u5bfc\u51fa\u6570\u636e\u6e90\u9519\u8bef\uff0c%1$s");
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnExportDataSources(EAIDataSource eaiDataSource, SimpleXMLWriter xmlWriter, ISRFEAIConfigWriterContext writerContext) {
        CallResult callResult = new CallResult();
        String strConfigWriter = eaiDataSource.getCONFIGWRITER();
        Object objConfigWriter = ObjectHelper.Create((String)strConfigWriter);
        if (objConfigWriter == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u6e90\u914d\u7f6e\u7f16\u5199\u5668[%1$s]", (Object)strConfigWriter));
            return callResult;
        }
        if (!(objConfigWriter instanceof BaseDataSourceConfigWriter)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6570\u636e\u6e90\u914d\u7f6e\u7f16\u5199\u5668[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strConfigWriter));
            return callResult;
        }
        BaseDataSourceConfigWriter configWriter = (BaseDataSourceConfigWriter)objConfigWriter;
        return configWriter.Export(eaiDataSource, xmlWriter, writerContext);
    }
}

