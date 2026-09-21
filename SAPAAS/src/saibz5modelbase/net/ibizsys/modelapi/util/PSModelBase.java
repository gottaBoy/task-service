/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonAnyGetter
 *  com.fasterxml.jackson.annotation.JsonAnySetter
 *  com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.PropertyAccessor
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.databind.DeserializationContext
 *  com.fasterxml.jackson.databind.DeserializationFeature
 *  com.fasterxml.jackson.databind.JsonDeserializer
 *  com.fasterxml.jackson.databind.JsonSerializer
 *  com.fasterxml.jackson.databind.Module
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.SerializationFeature
 *  com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateDeserializer
 *  com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer
 *  com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer
 *  com.fasterxml.jackson.databind.module.SimpleModule
 *  com.fasterxml.jackson.databind.ser.std.DateSerializer
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.util;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import net.ibizsys.modelapi.util.IPSModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public abstract class PSModelBase
implements IPSModel {
    private static final Log log = LogFactory.getLog(PSModelBase.class);
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "GMT+8";
    @JsonIgnore
    private Map<String, Object> otherProperties = null;
    protected static ObjectMapper MAPPER = PSModelBase.getObjectMapper();
    @JsonIgnore
    private IPSModel parent = null;
    @JsonIgnore
    private String strFilePath = null;
    @JsonIgnore
    private String strSrfTag = null;
    @JsonIgnore
    private String strSrfDynaInstId = null;
    @JsonIgnore
    private String strId = null;
    @JsonIgnore
    private String strName = null;
    @JsonIgnore
    private boolean inited = false;

    static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule();
        String[] patternArr = PATTERN.split(" ");
        module.addSerializer(java.util.Date.class, (JsonSerializer)new DateSerializer(Boolean.valueOf(false), (DateFormat)new SimpleDateFormat(PATTERN)));
        module.addSerializer(Timestamp.class, (JsonSerializer)new DateSerializer(Boolean.valueOf(false), (DateFormat)new SimpleDateFormat(PATTERN)));
        module.addSerializer(Date.class, (JsonSerializer)new DateSerializer(Boolean.valueOf(false), (DateFormat)new SimpleDateFormat(PATTERN)));
        module.addDeserializer(java.util.Date.class, (JsonDeserializer)new DateDeserializers.DateDeserializer(){

            public java.util.Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) {
                try {
                    String text = jsonParser.getText().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat(PSModelBase.PATTERN);
                    return sdf.parse(text);
                }
                catch (Exception ex) {
                    log.debug((Object)ex);
                    throw new RuntimeException(ex);
                }
            }
        });
        module.addDeserializer(Timestamp.class, (JsonDeserializer)new DateDeserializers.TimestampDeserializer(){

            public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) {
                try {
                    String text = jsonParser.getText().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat(PSModelBase.PATTERN);
                    return new Timestamp(sdf.parse(text).getTime());
                }
                catch (Exception ex) {
                    log.debug((Object)ex);
                    throw new RuntimeException(ex);
                }
            }
        });
        module.addDeserializer(Date.class, (JsonDeserializer)new DateDeserializers.SqlDateDeserializer(){

            public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) {
                try {
                    String text = jsonParser.getText().trim();
                    SimpleDateFormat sdf = new SimpleDateFormat(PSModelBase.PATTERN);
                    return new Date(sdf.parse(text).getTime());
                }
                catch (Exception ex) {
                    log.debug((Object)ex);
                    throw new RuntimeException(ex);
                }
            }
        });
        objectMapper.registerModule((Module)module);
        return objectMapper;
    }

    @Override
    public IPSModel getSrfParent() {
        return this.parent;
    }

    public void setSrfParent(IPSModel parent) {
        this.parent = parent;
    }

    @Override
    public String getSrfFilePath() {
        return this.strFilePath;
    }

    public void setSrfFilePath(String strFilePath) {
        this.strFilePath = strFilePath;
        this.inited = false;
    }

    public void setSrfFilePath(String strFilePath, boolean bInit) {
        this.strFilePath = strFilePath;
        this.inited = bInit;
    }

    @Override
    public String getSrfTag() {
        return this.strSrfTag;
    }

    public void setSrfTag(String strSrfTag) {
        this.strSrfTag = strSrfTag;
    }

    @Override
    public String getSrfDynaInstId() {
        return this.strSrfDynaInstId;
    }

    public void setSrfDynaInstId(String strSrfDynaInstId) {
        this.strSrfDynaInstId = strSrfDynaInstId;
    }

    @Override
    public boolean isFromDynaInst() {
        return StringUtils.hasLength((String)this.getSrfDynaInstId());
    }

    @Override
    public boolean containsPSModels(String strName, boolean bFullMode) {
        return false;
    }

    @Override
    public List<? extends IPSModel> getPSModels(String strName) throws Exception {
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%1$s]\u6a21\u578b\u96c6\u5408", strName));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void init() throws Exception {
        PSModelBase pSModelBase = this;
        synchronized (pSModelBase) {
            if (!this.inited) {
                this.inited = true;
                this.onInit();
            }
        }
    }

    protected void onInit() throws Exception {
        if (StringUtils.hasLength((String)this.getSrfFilePath())) {
            System.out.println(String.format("\u52a0\u8f7d\u6a21\u578b\u6587\u4ef6[%1$s]", this.getSrfFilePath()));
            this.onLoad(this.getSrfFilePath());
        }
    }

    protected void onLoad(String strJsonFilePath) throws Exception {
    }

    @Override
    public void reset() {
        this.onReset();
    }

    protected void onReset() {
        this.otherProperties = null;
    }

    @Override
    public String getId() {
        return this.strId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    protected void onInitRuntime() throws Exception {
    }

    @Override
    public void to(IPSModel dst, boolean bSimple, boolean bDeepMode) throws Exception {
        if (this.any() != null) {
            for (Map.Entry<String, Object> entry : this.any().entrySet()) {
                dst.set(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public void from(IPSModel src, boolean bSimple, boolean bDeepMode) throws Exception {
        if (src.any() != null) {
            for (Map.Entry<String, Object> entry : src.any().entrySet()) {
                this.set(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public Object get(String name) {
        this.tryInit();
        if (this.otherProperties == null) {
            return null;
        }
        return this.otherProperties.get(name);
    }

    @Override
    @JsonAnyGetter
    public Map<String, Object> any() {
        this.tryInit();
        return this.otherProperties;
    }

    @Override
    @JsonAnySetter
    public void set(String name, Object value) {
        this.tryInit();
        if (this.otherProperties == null) {
            this.otherProperties = new HashMap<String, Object>();
        }
        this.otherProperties.put(name, value);
    }

    public boolean contains(String name) {
        this.tryInit();
        if (this.otherProperties == null) {
            return false;
        }
        return this.otherProperties.containsKey(name);
    }

    public void remove(String name) {
        this.tryInit();
        if (this.otherProperties != null) {
            this.otherProperties.remove(name);
        }
    }

    public boolean tryInit() {
        try {
            this.init();
            return true;
        }
        catch (Exception e) {
            log.error((Object)e);
            return false;
        }
    }
}

