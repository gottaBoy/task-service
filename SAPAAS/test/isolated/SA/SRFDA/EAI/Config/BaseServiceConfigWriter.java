package SA.SRFDA.EAI.Config;

import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.SimpleXMLWriter;

public class BaseServiceConfigWriter {
    public CallResult Export(EAIService service, SimpleXMLWriter writer, DefaultConfigWriterContext context) {
        writer.WriteRaw("<mule/>");
        return new CallResult();
    }
}
