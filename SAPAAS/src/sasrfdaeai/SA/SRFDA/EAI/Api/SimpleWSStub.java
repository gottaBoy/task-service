/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.axiom.om.OMAbstractFactory
 *  org.apache.axiom.om.OMDataSource
 *  org.apache.axiom.om.OMElement
 *  org.apache.axiom.om.OMFactory
 *  org.apache.axiom.om.OMNamespace
 *  org.apache.axiom.om.OMNode
 *  org.apache.axiom.om.impl.llom.OMSourcedElementImpl
 *  org.apache.axiom.soap.SOAPEnvelope
 *  org.apache.axiom.soap.SOAPFactory
 *  org.apache.axis2.AxisFault
 *  org.apache.axis2.addressing.EndpointReference
 *  org.apache.axis2.client.OperationClient
 *  org.apache.axis2.client.ServiceClient
 *  org.apache.axis2.client.Stub
 *  org.apache.axis2.client.async.AxisCallback
 *  org.apache.axis2.context.ConfigurationContext
 *  org.apache.axis2.context.MessageContext
 *  org.apache.axis2.databinding.ADBBean
 *  org.apache.axis2.databinding.ADBDataSource
 *  org.apache.axis2.databinding.ADBException
 *  org.apache.axis2.databinding.utils.BeanUtil
 *  org.apache.axis2.databinding.utils.ConverterUtil
 *  org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl
 *  org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter
 *  org.apache.axis2.description.AxisOperation
 *  org.apache.axis2.description.AxisService
 *  org.apache.axis2.description.OutInAxisOperation
 *  org.apache.axis2.engine.MessageReceiver
 *  org.apache.axis2.util.CallbackReceiver
 *  org.apache.axis2.util.Utils
 */
package SA.SRFDA.EAI.Api;

import SA.SRFDA.EAI.Api.SimpleWSCallbackHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDataSource;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.llom.OMSourcedElementImpl;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl;
import org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.engine.MessageReceiver;
import org.apache.axis2.util.CallbackReceiver;
import org.apache.axis2.util.Utils;

public class SimpleWSStub
extends Stub {
    protected AxisOperation[] _operations;
    private HashMap faultExceptionNameMap = new HashMap();
    private HashMap faultExceptionClassNameMap = new HashMap();
    private HashMap faultMessageMap = new HashMap();
    private static int counter = 0;
    private QName[] opNameArray = null;

    private static synchronized String getUniqueSuffix() {
        if (counter > 99999) {
            counter = 0;
        }
        return String.valueOf(Long.toString(System.currentTimeMillis())) + "_" + ++counter;
    }

    private void populateAxisService() throws AxisFault {
        this._service = new AxisService("SimpleWS" + SimpleWSStub.getUniqueSuffix());
        this.addAnonymousOperations();
        this._operations = new AxisOperation[1];
        OutInAxisOperation __operation = new OutInAxisOperation();
        __operation.setName(new QName("http://Endpoint.EAI.SRFDA.SA", "Call"));
        this._service.addOperation((AxisOperation)__operation);
        this._operations[0] = __operation;
    }

    private void populateFaults() {
    }

    public SimpleWSStub(ConfigurationContext configurationContext, String targetEndpoint) throws AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    public SimpleWSStub(ConfigurationContext configurationContext, String targetEndpoint, boolean useSeparateListener) throws AxisFault {
        this.populateAxisService();
        this.populateFaults();
        this._serviceClient = new ServiceClient(configurationContext, this._service);
        configurationContext = this._serviceClient.getServiceContext().getConfigurationContext();
        this._serviceClient.getOptions().setTo(new EndpointReference(targetEndpoint));
        this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    public SimpleWSStub(ConfigurationContext configurationContext) throws AxisFault {
        this(configurationContext, "http://127.0.0.1:8002/test/SimpleWS");
    }

    public SimpleWSStub() throws AxisFault {
        this("http://127.0.0.1:8002/test/SimpleWS");
    }

    public SimpleWSStub(String targetEndpoint) throws AxisFault {
        this(null, targetEndpoint);
    }

    public CallResponse Call(Call call0) throws RemoteException {
        CallResponse callResponse;
        MessageContext _messageContext = null;
        try {
            OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
            this.addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
            _messageContext = new MessageContext();
            SOAPEnvelope env = null;
            env = this.toEnvelope(SimpleWSStub.getFactory((String)_operationClient.getOptions().getSoapVersionURI()), call0, this.optimizeContent(new QName("http://Endpoint.EAI.SRFDA.SA", "Call")));
            this._serviceClient.addHeadersToEnvelope(env);
            _messageContext.setEnvelope(env);
            _operationClient.addMessageContext(_messageContext);
            _operationClient.execute(true);
            MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
            SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
            Object object = this.fromOM(_returnEnv.getBody().getFirstElement(), CallResponse.class, this.getEnvelopeNamespaces(_returnEnv));
            callResponse = (CallResponse)object;
        }
        catch (AxisFault f) {
            try {
                OMElement faultElt = f.getDetail();
                if (faultElt != null) {
                    if (this.faultExceptionNameMap.containsKey(faultElt.getQName())) {
                        try {
                            String exceptionClassName = (String)this.faultExceptionClassNameMap.get(faultElt.getQName());
                            Class<?> exceptionClass = Class.forName(exceptionClassName);
                            Exception ex = (Exception)exceptionClass.newInstance();
                            String messageClassName = (String)this.faultMessageMap.get(faultElt.getQName());
                            Class<?> messageClass = Class.forName(messageClassName);
                            Object messageObject = this.fromOM(faultElt, messageClass, null);
                            Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                            m.invoke(ex, messageObject);
                            throw new RemoteException(ex.getMessage(), ex);
                        }
                        catch (ClassCastException e) {
                            throw f;
                        }
                        catch (ClassNotFoundException e) {
                            throw f;
                        }
                        catch (NoSuchMethodException e) {
                            throw f;
                        }
                        catch (InvocationTargetException e) {
                            throw f;
                        }
                        catch (IllegalAccessException e) {
                            throw f;
                        }
                        catch (InstantiationException e) {
                            throw f;
                        }
                    }
                    throw f;
                }
                throw f;
            }
            catch (Throwable throwable) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                throw throwable;
            }
        }
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        return callResponse;
    }

    public void startCall(Call call0, final SimpleWSCallbackHandler callback) throws RemoteException {
        OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
        _operationClient.getOptions().setAction("\"\"");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
        this.addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
        SOAPEnvelope env = null;
        final MessageContext _messageContext = new MessageContext();
        env = this.toEnvelope(SimpleWSStub.getFactory((String)_operationClient.getOptions().getSoapVersionURI()), call0, this.optimizeContent(new QName("http://Endpoint.EAI.SRFDA.SA", "Call")));
        this._serviceClient.addHeadersToEnvelope(env);
        _messageContext.setEnvelope(env);
        _operationClient.addMessageContext(_messageContext);
        _operationClient.setCallback(new AxisCallback(){

            public void onMessage(MessageContext resultContext) {
                try {
                    SOAPEnvelope resultEnv = resultContext.getEnvelope();
                    Object object = SimpleWSStub.this.fromOM(resultEnv.getBody().getFirstElement(), CallResponse.class, SimpleWSStub.this.getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultCall((CallResponse)object);
                }
                catch (AxisFault e) {
                    callback.receiveErrorCall((Exception)((Object)e));
                }
            }

            public void onError(Exception error) {
                if (error instanceof AxisFault) {
                    AxisFault f = (AxisFault)((Object)error);
                    OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (SimpleWSStub.this.faultExceptionNameMap.containsKey(faultElt.getQName())) {
                            try {
                                String exceptionClassName = (String)SimpleWSStub.this.faultExceptionClassNameMap.get(faultElt.getQName());
                                Class<?> exceptionClass = Class.forName(exceptionClassName);
                                Exception ex = (Exception)exceptionClass.newInstance();
                                String messageClassName = (String)SimpleWSStub.this.faultMessageMap.get(faultElt.getQName());
                                Class<?> messageClass = Class.forName(messageClassName);
                                Object messageObject = SimpleWSStub.this.fromOM(faultElt, messageClass, null);
                                Method m = exceptionClass.getMethod("setFaultMessage", messageClass);
                                m.invoke(ex, messageObject);
                                callback.receiveErrorCall(new RemoteException(ex.getMessage(), ex));
                            }
                            catch (ClassCastException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (ClassNotFoundException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (NoSuchMethodException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (InvocationTargetException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (IllegalAccessException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (InstantiationException e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                            catch (AxisFault e) {
                                callback.receiveErrorCall((Exception)((Object)f));
                            }
                        } else {
                            callback.receiveErrorCall((Exception)((Object)f));
                        }
                    } else {
                        callback.receiveErrorCall((Exception)((Object)f));
                    }
                } else {
                    callback.receiveErrorCall(error);
                }
            }

            public void onFault(MessageContext faultContext) {
                AxisFault fault = Utils.getInboundFaultFromMessageContext((MessageContext)faultContext);
                this.onError((Exception)((Object)fault));
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
                catch (AxisFault axisFault) {
                    callback.receiveErrorCall((Exception)((Object)axisFault));
                }
            }
        });
        CallbackReceiver _callbackReceiver = null;
        if (this._operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new CallbackReceiver();
            this._operations[0].setMessageReceiver((MessageReceiver)_callbackReceiver);
        }
        _operationClient.execute(false);
    }

    private Map getEnvelopeNamespaces(SOAPEnvelope env) {
        HashMap<String, String> returnMap = new HashMap<String, String>();
        Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            OMNamespace ns = (OMNamespace)namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private boolean optimizeContent(QName opName) {
        if (this.opNameArray == null) {
            return false;
        }
        int i = 0;
        while (i < this.opNameArray.length) {
            if (opName.equals(this.opNameArray[i])) {
                return true;
            }
            ++i;
        }
        return false;
    }

    private OMElement toOM(Call param, boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(Call.MY_QNAME, OMAbstractFactory.getOMFactory());
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }

    private OMElement toOM(CallResponse param, boolean optimizeContent) throws AxisFault {
        try {
            return param.getOMElement(CallResponse.MY_QNAME, OMAbstractFactory.getOMFactory());
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }

    private SOAPEnvelope toEnvelope(SOAPFactory factory, Call param, boolean optimizeContent) throws AxisFault {
        try {
            SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild((OMNode)param.getOMElement(Call.MY_QNAME, (OMFactory)factory));
            return emptyEnvelope;
        }
        catch (ADBException e) {
            throw AxisFault.makeFault((Throwable)e);
        }
    }

    private SOAPEnvelope toEnvelope(SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(OMElement param, Class type, Map extraNamespaces) throws AxisFault {
        try {
            if (Call.class.equals((Object)type)) {
                return Call.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
            if (CallResponse.class.equals((Object)type)) {
                return CallResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }
        }
        catch (Exception e) {
            throw AxisFault.makeFault((Throwable)e);
        }
        return null;
    }

    public static class Call
    implements ADBBean {
        public static final QName MY_QNAME = new QName("http://Endpoint.EAI.SRFDA.SA", "Call", "ns1");
        protected String localIn0;

        private static String generatePrefix(String namespace) {
            if (namespace.equals("http://Endpoint.EAI.SRFDA.SA")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

        public String getIn0() {
            return this.localIn0;
        }

        public void setIn0(String param) {
            this.localIn0 = param;
        }

        public static boolean isReaderMTOMAware(XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;
            try {
                isReaderMTOMAware = Boolean.TRUE.equals(reader.getProperty("IsDatahandlersAwareParsing"));
            }
            catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        public OMElement getOMElement(QName parentQName, final OMFactory factory) throws ADBException {
            ADBDataSource dataSource = new ADBDataSource(this, MY_QNAME){

                public void serialize(MTOMAwareXMLStreamWriter xmlWriter) throws XMLStreamException {
                    Call.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(MY_QNAME, factory, (OMDataSource)dataSource);
        }

        public void serialize(QName parentQName, OMFactory factory, MTOMAwareXMLStreamWriter xmlWriter) throws XMLStreamException, ADBException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(QName parentQName, OMFactory factory, MTOMAwareXMLStreamWriter xmlWriter, boolean serializeType) throws XMLStreamException, ADBException {
            String prefix = null;
            String namespace = null;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if (namespace != null && namespace.trim().length() > 0) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = Call.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                String namespacePrefix = this.registerPrefix((XMLStreamWriter)xmlWriter, "http://Endpoint.EAI.SRFDA.SA");
                if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", String.valueOf(namespacePrefix) + ":Call", (XMLStreamWriter)xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Call", (XMLStreamWriter)xmlWriter);
                }
            }
            if (!(namespace = "").equals("")) {
                prefix = xmlWriter.getPrefix(namespace);
                if (prefix == null) {
                    prefix = Call.generatePrefix(namespace);
                    xmlWriter.writeStartElement(prefix, "in0", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                } else {
                    xmlWriter.writeStartElement(namespace, "in0");
                }
            } else {
                xmlWriter.writeStartElement("in0");
            }
            if (this.localIn0 == null) {
                throw new ADBException("in0 cannot be null!!");
            }
            xmlWriter.writeCharacters(this.localIn0);
            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();
        }

        private void writeAttribute(String prefix, String namespace, String attName, String attValue, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        private void writeAttribute(String namespace, String attName, String attValue, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        private void writeQNameAttribute(String namespace, String attName, QName qname, XMLStreamWriter xmlWriter) throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue = attributePrefix.trim().length() > 0 ? String.valueOf(attributePrefix) + ":" + qname.getLocalPart() : qname.getLocalPart();
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        private void writeQName(QName qname, XMLStreamWriter xmlWriter) throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = Call.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(String.valueOf(prefix) + ":" + ConverterUtil.convertToString((QName)qname));
                } else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString((QName)qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString((QName)qname));
            }
        }

        private void writeQNames(QName[] qnames, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (qnames != null) {
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;
                int i = 0;
                while (i < qnames.length) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    if ((namespaceURI = qnames[i].getNamespaceURI()) != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if (prefix == null || prefix.length() == 0) {
                            prefix = Call.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString((QName)qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString((QName)qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString((QName)qnames[i]));
                    }
                    ++i;
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        private String registerPrefix(XMLStreamWriter xmlWriter, String namespace) throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = Call.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        public XMLStreamReader getPullParser(QName qName) throws ADBException {
            ArrayList<Object> elementList = new ArrayList<Object>();
            ArrayList attribList = new ArrayList();
            elementList.add(new QName("http://Endpoint.EAI.SRFDA.SA", "in0"));
            if (this.localIn0 == null) {
                throw new ADBException("in0 cannot be null!!");
            }
            elementList.add(ConverterUtil.convertToString((String)this.localIn0));
            return new ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
        }

        public static class Factory {
            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public static Call parse(XMLStreamReader reader) throws Exception {
                Call object = new Call();
                Object nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {
                    String fullTypeName;
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null && (fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")) != null) {
                        String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;
                        String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                        if (!"Call".equals(type)) {
                            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (Call)ExtensionMapper.getTypeObject(nsUri, type, reader);
                        }
                    }
                    Vector handledAttributes = new Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) throw new ADBException("Unexpected subelement " + reader.getLocalName());
                    if (!new QName("http://Endpoint.EAI.SRFDA.SA", "in0").equals(reader.getName())) throw new ADBException("Unexpected subelement " + reader.getLocalName());
                    String content = reader.getElementText();
                    object.setIn0(ConverterUtil.convertToString((String)content));
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) return object;
                    throw new ADBException("Unexpected subelement " + reader.getLocalName());
                }
                catch (XMLStreamException e) {
                    throw new Exception(e);
                }
            }
        }
    }

    public static class CallResponse
    implements ADBBean {
        public static final QName MY_QNAME = new QName("http://Endpoint.EAI.SRFDA.SA", "CallResponse", "ns1");
        protected String localCallReturn;

        private static String generatePrefix(String namespace) {
            if (namespace.equals("http://Endpoint.EAI.SRFDA.SA")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

        public String getCallReturn() {
            return this.localCallReturn;
        }

        public void setCallReturn(String param) {
            this.localCallReturn = param;
        }

        public static boolean isReaderMTOMAware(XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;
            try {
                isReaderMTOMAware = Boolean.TRUE.equals(reader.getProperty("IsDatahandlersAwareParsing"));
            }
            catch (IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        public OMElement getOMElement(QName parentQName, final OMFactory factory) throws ADBException {
            ADBDataSource dataSource = new ADBDataSource(this, MY_QNAME){

                public void serialize(MTOMAwareXMLStreamWriter xmlWriter) throws XMLStreamException {
                    CallResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                }
            };
            return new OMSourcedElementImpl(MY_QNAME, factory, (OMDataSource)dataSource);
        }

        public void serialize(QName parentQName, OMFactory factory, MTOMAwareXMLStreamWriter xmlWriter) throws XMLStreamException, ADBException {
            this.serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(QName parentQName, OMFactory factory, MTOMAwareXMLStreamWriter xmlWriter, boolean serializeType) throws XMLStreamException, ADBException {
            String prefix = null;
            String namespace = null;
            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            if (namespace != null && namespace.trim().length() > 0) {
                String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = CallResponse.generatePrefix(namespace);
                    }
                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }
            if (serializeType) {
                String namespacePrefix = this.registerPrefix((XMLStreamWriter)xmlWriter, "http://Endpoint.EAI.SRFDA.SA");
                if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", String.valueOf(namespacePrefix) + ":CallResponse", (XMLStreamWriter)xmlWriter);
                } else {
                    this.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "CallResponse", (XMLStreamWriter)xmlWriter);
                }
            }
            if (!(namespace = "").equals("")) {
                prefix = xmlWriter.getPrefix(namespace);
                if (prefix == null) {
                    prefix = CallResponse.generatePrefix(namespace);
                    xmlWriter.writeStartElement(prefix, "CallReturn", namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                } else {
                    xmlWriter.writeStartElement(namespace, "CallReturn");
                }
            } else {
                xmlWriter.writeStartElement("CallReturn");
            }
            if (this.localCallReturn == null) {
                throw new ADBException("CallReturn cannot be null!!");
            }
            xmlWriter.writeCharacters(this.localCallReturn);
            xmlWriter.writeEndElement();
            xmlWriter.writeEndElement();
        }

        private void writeAttribute(String prefix, String namespace, String attName, String attValue, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        private void writeAttribute(String namespace, String attName, String attValue, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        private void writeQNameAttribute(String namespace, String attName, QName qname, XMLStreamWriter xmlWriter) throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = this.registerPrefix(xmlWriter, attributeNamespace);
            }
            String attributeValue = attributePrefix.trim().length() > 0 ? String.valueOf(attributePrefix) + ":" + qname.getLocalPart() : qname.getLocalPart();
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                this.registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        private void writeQName(QName qname, XMLStreamWriter xmlWriter) throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = CallResponse.generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }
                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(String.valueOf(prefix) + ":" + ConverterUtil.convertToString((QName)qname));
                } else {
                    xmlWriter.writeCharacters(ConverterUtil.convertToString((QName)qname));
                }
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString((QName)qname));
            }
        }

        private void writeQNames(QName[] qnames, XMLStreamWriter xmlWriter) throws XMLStreamException {
            if (qnames != null) {
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;
                int i = 0;
                while (i < qnames.length) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    if ((namespaceURI = qnames[i].getNamespaceURI()) != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if (prefix == null || prefix.length() == 0) {
                            prefix = CallResponse.generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }
                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString((QName)qnames[i]));
                        } else {
                            stringToWrite.append(ConverterUtil.convertToString((QName)qnames[i]));
                        }
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString((QName)qnames[i]));
                    }
                    ++i;
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        private String registerPrefix(XMLStreamWriter xmlWriter, String namespace) throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = CallResponse.generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        public XMLStreamReader getPullParser(QName qName) throws ADBException {
            ArrayList<Object> elementList = new ArrayList<Object>();
            ArrayList attribList = new ArrayList();
            elementList.add(new QName("http://Endpoint.EAI.SRFDA.SA", "CallReturn"));
            if (this.localCallReturn == null) {
                throw new ADBException("CallReturn cannot be null!!");
            }
            elementList.add(ConverterUtil.convertToString((String)this.localCallReturn));
            return new ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
        }

        public static class Factory {
            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public static CallResponse parse(XMLStreamReader reader) throws Exception {
                CallResponse object = new CallResponse();
                Object nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {
                    String fullTypeName;
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null && (fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type")) != null) {
                        String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;
                        String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);
                        if (!"CallResponse".equals(type)) {
                            String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (CallResponse)ExtensionMapper.getTypeObject(nsUri, type, reader);
                        }
                    }
                    Vector handledAttributes = new Vector();
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) throw new ADBException("Unexpected subelement " + reader.getLocalName());
                    if (!new QName("http://Endpoint.EAI.SRFDA.SA", "CallReturn").equals(reader.getName())) throw new ADBException("Unexpected subelement " + reader.getLocalName());
                    String content = reader.getElementText();
                    object.setCallReturn(ConverterUtil.convertToString((String)content));
                    reader.next();
                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }
                    if (!reader.isStartElement()) return object;
                    throw new ADBException("Unexpected subelement " + reader.getLocalName());
                }
                catch (XMLStreamException e) {
                    throw new Exception(e);
                }
            }
        }
    }

    public static class ExtensionMapper {
        public static Object getTypeObject(String namespaceURI, String typeName, XMLStreamReader reader) throws Exception {
            throw new ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }
    }
}

