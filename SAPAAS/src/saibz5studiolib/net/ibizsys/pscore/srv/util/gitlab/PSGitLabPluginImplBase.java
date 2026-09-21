/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.util.LinkedMultiValueMap
 *  org.springframework.util.MultiValueMap
 *  org.springframework.util.StringUtils
 *  org.springframework.web.client.HttpClientErrorException
 *  org.springframework.web.client.RestTemplate
 *  org.springframework.web.util.UriComponentsBuilder
 */
package net.ibizsys.pscore.srv.util.gitlab;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class PSGitLabPluginImplBase
implements IPSGitLabPlugin {
    private static final Log log = LogFactory.getLog(PSGitLabPluginImplBase.class);
    private RestTemplate restTemplate = new RestTemplate();

    protected String executeGet(PSSVNServer pSSVNServer, String string, Map<String, Object> map, HttpHeaders httpHeaders) throws Exception {
        return this.executeGet(pSSVNServer, string, map, null, httpHeaders);
    }

    protected String executePost(PSSVNServer pSSVNServer, String string, Map<String, Object> map, HttpHeaders httpHeaders) throws Exception {
        return this.executePost(pSSVNServer, string, map, null, httpHeaders);
    }

    /*
     * WARNING - void declaration
     */
    protected String executeGet(PSSVNServer pSSVNServer, String string, Map<String, Object> map, String string2, HttpHeaders httpHeaders) throws Exception {
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        if (!httpHeaders.containsKey((Object)"PRIVATE-TOKEN")) {
            httpHeaders.add("PRIVATE-TOKEN", pSSVNServer.getGitToken());
        }
        if (StringUtils.hasLength((String)string2) && !httpHeaders.containsKey((Object)"SUDO")) {
            httpHeaders.add("SUDO", string2);
        }
        HttpEntity httpEntity = new HttpEntity(null, (MultiValueMap)httpHeaders);
        String string3 = String.format("%1$s/api/v4/%2$s", pSSVNServer.getGitPath(), string);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl((String)string3);
        if (map != null) {
            for (Map.Entry<String, Object> object : map.entrySet()) {
                uriComponentsBuilder.queryParam(object.getKey(), new Object[]{object.getValue()});
            }
        }
        try {
            ResponseEntity responseEntity = this.restTemplate.exchange(new URI(uriComponentsBuilder.build().toString()), HttpMethod.GET, httpEntity, String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.FOUND) {
                void var10_14;
                String string4 = (String)responseEntity.getBody();
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    String string5 = new String(string4.getBytes("ISO-8859-1"), "utf8");
                }
                return var10_14;
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)responseEntity.getStatusCode().getReasonPhrase()));
        }
        catch (Exception exception) {
            this.outputException(exception, string3, HttpMethod.GET, map);
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected String executePost(PSSVNServer pSSVNServer, String string, Map<String, Object> map, String string2, HttpHeaders httpHeaders) throws Exception {
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        if (!httpHeaders.containsKey((Object)"PRIVATE-TOKEN")) {
            httpHeaders.add("PRIVATE-TOKEN", pSSVNServer.getGitToken());
        }
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (StringUtils.hasLength((String)string2) && !httpHeaders.containsKey((Object)"SUDO")) {
            httpHeaders.add("SUDO", string2);
        }
        String string3 = String.format("%1$s/api/v4/%2$s", pSSVNServer.getGitPath(), string);
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                linkedMultiValueMap.add(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity httpEntity = new HttpEntity((Object)linkedMultiValueMap, (MultiValueMap)httpHeaders);
        try {
            ResponseEntity exception = this.restTemplate.exchange(new URI(string3), HttpMethod.POST, httpEntity, String.class);
            if (exception.getStatusCode() == HttpStatus.CREATED) {
                String string4 = (String)exception.getBody();
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    string4 = new String(string4.getBytes("ISO-8859-1"), "utf8");
                }
                return string4;
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getStatusCode().getReasonPhrase()));
        }
        catch (Exception exception) {
            this.outputException(exception, string3, HttpMethod.POST, map);
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected String executePut(PSSVNServer pSSVNServer, String string, Map<String, Object> map, String string2, HttpHeaders httpHeaders) throws Exception {
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        if (!httpHeaders.containsKey((Object)"PRIVATE-TOKEN")) {
            httpHeaders.add("PRIVATE-TOKEN", pSSVNServer.getGitToken());
        }
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (StringUtils.hasLength((String)string2) && !httpHeaders.containsKey((Object)"SUDO")) {
            httpHeaders.add("SUDO", string2);
        }
        String string3 = String.format("%1$s/api/v4/%2$s", pSSVNServer.getGitPath(), string);
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                linkedMultiValueMap.add(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity httpEntity = new HttpEntity((Object)linkedMultiValueMap, (MultiValueMap)httpHeaders);
        try {
            ResponseEntity exception = this.restTemplate.exchange(new URI(string3), HttpMethod.PUT, httpEntity, String.class);
            if (exception.getStatusCode() == HttpStatus.OK) {
                String string4 = (String)exception.getBody();
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    string4 = new String(string4.getBytes("ISO-8859-1"), "utf8");
                }
                return string4;
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getStatusCode().getReasonPhrase()));
        }
        catch (Exception exception) {
            this.outputException(exception, string3, HttpMethod.PUT, map);
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected String executeDelete(PSSVNServer pSSVNServer, String string, Map<String, Object> map, String string2, HttpHeaders httpHeaders) throws Exception {
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        if (!httpHeaders.containsKey((Object)"PRIVATE-TOKEN")) {
            httpHeaders.add("PRIVATE-TOKEN", pSSVNServer.getGitToken());
        }
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (StringUtils.hasLength((String)string2) && !httpHeaders.containsKey((Object)"SUDO")) {
            httpHeaders.add("SUDO", string2);
        }
        String string3 = String.format("%1$s/api/v4/%2$s", pSSVNServer.getGitPath(), string);
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                linkedMultiValueMap.add(entry.getKey(), entry.getValue());
            }
        }
        HttpEntity httpEntity = new HttpEntity((Object)linkedMultiValueMap, (MultiValueMap)httpHeaders);
        try {
            ResponseEntity exception = this.restTemplate.exchange(new URI(string3), HttpMethod.DELETE, httpEntity, String.class);
            if (exception.getStatusCode() == HttpStatus.OK || exception.getStatusCode() == HttpStatus.NO_CONTENT) {
                String string4 = (String)exception.getBody();
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    string4 = new String(string4.getBytes("ISO-8859-1"), "utf8");
                }
                return string4;
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getStatusCode().getReasonPhrase()));
        }
        catch (Exception exception) {
            this.outputException(exception, string3, HttpMethod.DELETE, map);
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected void outputException(Exception exception, String string, HttpMethod httpMethod, Map<String, Object> map) {
        HttpClientErrorException httpClientErrorException;
        byte[] byArray;
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("\u8bf7\u6c42[%1$s][%2$s]", (Object)string, (Object)httpMethod);
        if (map != null) {
            stringBuilderEx.append("\uff0c\u53c2\u6570{", (Object)string, (Object)httpMethod);
            for (Map.Entry<String, Object> object2 : map.entrySet()) {
                stringBuilderEx.append("%1$s:%2$s,", (Object)object2.getKey(), object2.getValue());
            }
            stringBuilderEx.append("}", (Object)string, (Object)httpMethod);
        }
        Object object3 = null;
        if (exception instanceof HttpClientErrorException && (byArray = (httpClientErrorException = (HttpClientErrorException)exception).getResponseBodyAsByteArray()) != null) {
            try {
                object3 = new String(httpClientErrorException.getResponseBodyAsByteArray(), "utf8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                log.error((Object)unsupportedEncodingException);
            }
        }
        if (StringHelper.isNullOrEmpty(object3)) {
            log.error((Object)String.format("%1$s \u53d1\u751f\u5f02\u5e38\uff0c%2$s", stringBuilderEx.toString(), exception.getMessage()), (Throwable)exception);
        } else {
            log.error((Object)String.format("%1$s \u53d1\u751f\u5f02\u5e38\uff0c%2$s\uff0c\u8be6\u7ec6 ==> %3$s", stringBuilderEx.toString(), exception.getMessage(), object3), (Throwable)exception);
        }
    }
}

