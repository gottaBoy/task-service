/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Config.ISRFEAIConfigWriterContext;
import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.SimpleXMLWriter;

public interface ISRFEAIConfigWriter {
    public CallResult Init(EAIBaseProcessConfig var1, ISRFEAIConfigWriterContext var2);

    public String GetDataSourceId();

    public CallResult ExportConnector(SimpleXMLWriter var1);

    public CallResult ExportProtocol(SimpleXMLWriter var1);

    public CallResult ExportService(SimpleXMLWriter var1);
}

