/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Util.SimpleXmlWriter;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SystemDumpHelper {
    private static final Log log = LogFactory.getLog(SystemDumpHelper.class);

    public static void dump(IPSSystem iPSSystem, File file) throws Exception {
        FileWriter fileWriter = new FileWriter(file);
        try {
            SimpleXmlWriter simpleXmlWriter = new SimpleXmlWriter(fileWriter);
            SystemDumpHelper.dump(iPSSystem, "", false, simpleXmlWriter);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (Exception ex) {
            fileWriter.flush();
            fileWriter.close();
            throw ex;
        }
    }

    public static void dump(IPSModelObject iPSModelObject, String strModelType, boolean bRefMode, SimpleXmlWriter simpleXmlWriter) throws Exception {
        String strElementName = strModelType;
        if (StringHelper.IsNullOrEmpty((String)strElementName)) {
            strElementName = iPSModelObject.getModelType();
        }
        if (StringHelper.IsNullOrEmpty((String)strElementName)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5bf9\u8c61[%1$s]\u7c7b\u578b", (Object)iPSModelObject));
        }
        log.debug((Object)StringHelper.Format((String)"\u6a21\u578b\u5bfc\u51fa[%1$s][%2$s][%3$s]", (Object)strElementName, (Object)iPSModelObject.getModelName(), (Object)bRefMode));
        if (bRefMode) {
            simpleXmlWriter.writeStartElement("PSOBJECTREF");
            simpleXmlWriter.writeAttributeString("TYPE", strElementName);
            simpleXmlWriter.writeAttributeString("ID", iPSModelObject.getId());
            simpleXmlWriter.writeAttributeString("NAME", iPSModelObject.getName());
            simpleXmlWriter.writeEndElement();
        } else {
            Method[] methods;
            int n;
            simpleXmlWriter.writeStartElement(strElementName);
            simpleXmlWriter.writeAttributeString("ID", iPSModelObject.getId());
            simpleXmlWriter.writeAttributeString("NAME", iPSModelObject.getName());
            HashMap<String, Method> clsMethodMap = null;
            Class<?> intClass = iPSModelObject.getModelClass(strModelType);
            if (intClass != null) {
                Method[] methods2;
                clsMethodMap = new HashMap<String, Method>();
                Method[] methodArray = methods2 = intClass.getMethods();
                n = methods2.length;
                int n2 = 0;
                while (n2 < n) {
                    Method m = methodArray[n2];
                    clsMethodMap.put(m.getName(), m);
                    ++n2;
                }
            }
            Class<?> modelCls = iPSModelObject.getClass();
            Method[] methodArray = methods = modelCls.getMethods();
            int n3 = methods.length;
            n = 0;
            while (n < n3) {
                block31: {
                    PSModelRTMeta meta;
                    Method m = methodArray[n];
                    if (!(clsMethodMap != null && !clsMethodMap.containsKey(m.getName()) || m.getParameterTypes().length != 0 || (meta = m.getAnnotation(PSModelRTMeta.class)) == null || meta.debugmode() || meta.hidemethod())) {
                        String strText = meta.name();
                        if (StringHelper.IsNullOrEmpty((String)strText)) {
                            strText = m.getName();
                        }
                        if (strText.indexOf("get") == 0) {
                            strText = strText.substring(3);
                        }
                        Object objValue = null;
                        try {
                            objValue = m.invoke(iPSModelObject, new Object[0]);
                        }
                        catch (Exception ex2) {
                            objValue = ex2.getMessage();
                        }
                        if (objValue == null) {
                            simpleXmlWriter.writeStartElement(strText.toUpperCase());
                            simpleXmlWriter.writeEndElement();
                            break block31;
                        }
                        if (objValue instanceof IPSModelObject) {
                            IPSModelObject iPSModelObject2 = (IPSModelObject)objValue;
                            if (iPSModelObject2 != iPSModelObject) {
                                String strModelType2 = iPSModelObject2.getModelType(meta.modeltype());
                                simpleXmlWriter.writeStartElement(strText.toUpperCase());
                                SystemDumpHelper.dump(iPSModelObject2, strModelType2, !meta.child(), simpleXmlWriter);
                                simpleXmlWriter.writeEndElement();
                            }
                            break block31;
                        }
                        if (objValue instanceof Iterator || objValue instanceof ArrayList || objValue.getClass().isArray()) {
                            Object objItem2;
                            ArrayList list3 = new ArrayList();
                            if (objValue instanceof Iterator) {
                                Iterator it = (Iterator)objValue;
                                while (it.hasNext()) {
                                    objItem2 = it.next();
                                    list3.add(objItem2);
                                }
                            } else if (objValue instanceof ArrayList) {
                                for (Object objItem2 : (ArrayList)objValue) {
                                    list3.add(objItem2);
                                }
                            } else if (objValue.getClass().isArray()) {
                                Object[] list2;
                                Object[] objectArray = list2 = (Object[])objValue;
                                int n4 = list2.length;
                                int n5 = 0;
                                while (n5 < n4) {
                                    objItem2 = objectArray[n5];
                                    list3.add(objItem2);
                                    ++n5;
                                }
                            }
                            simpleXmlWriter.writeStartElement(strText.toUpperCase());
                            simpleXmlWriter.writeStartElement("PSOBJECTS");
                            for (Object objItem3 : list3) {
                                if (objItem3 == null) continue;
                                if (objItem3 instanceof IPSModelObject) {
                                    IPSModelObject iPSModelObject2 = (IPSModelObject)objItem3;
                                    if (iPSModelObject2 == iPSModelObject) continue;
                                    String strModelType2 = iPSModelObject2.getModelType(meta.modeltype());
                                    SystemDumpHelper.dump(iPSModelObject2, strModelType2, !meta.child(), simpleXmlWriter);
                                    continue;
                                }
                                simpleXmlWriter.writeStartElement("PSOBJECT");
                                simpleXmlWriter.writeCDATA(objItem3.toString());
                                simpleXmlWriter.writeEndElement();
                            }
                            simpleXmlWriter.writeEndElement();
                            simpleXmlWriter.writeEndElement();
                            break block31;
                        }
                        if (objValue instanceof String) {
                            if (!StringHelper.IsNullOrEmpty((String)((String)objValue))) {
                                simpleXmlWriter.writeStartElement(strText.toUpperCase());
                                simpleXmlWriter.writeCDATA((String)objValue);
                                simpleXmlWriter.writeEndElement();
                            }
                        } else {
                            simpleXmlWriter.writeStartElement(strText.toUpperCase());
                            simpleXmlWriter.writeCDATA(objValue.toString());
                            simpleXmlWriter.writeEndElement();
                        }
                    }
                }
                ++n;
            }
            simpleXmlWriter.writeEndElement();
        }
    }
}

