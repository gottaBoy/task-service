package net.ibizsys.pscore.srv.util.gitlab;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class PSGitLabPluginImplBase implements IPSGitLabPlugin {
   private static final Log log = LogFactory.getLog(PSGitLabPluginImplBase.class);
   private RestTemplate restTemplate = new RestTemplate();

   protected String executeGet(PSSVNServer var1, String var2, Map<String, Object> var3, HttpHeaders var4) throws Exception {
      return this.executeGet(var1, var2, var3, null, var4);
   }

   protected String executePost(PSSVNServer var1, String var2, Map<String, Object> var3, HttpHeaders var4) throws Exception {
      return this.executePost(var1, var2, var3, null, var4);
   }

   protected String executeGet(PSSVNServer var1, String var2, Map<String, Object> var3, String var4, HttpHeaders var5) throws Exception {
      if (var5 == null) {
         var5 = new HttpHeaders();
      }

      if (!var5.containsKey("PRIVATE-TOKEN")) {
         var5.add("PRIVATE-TOKEN", var1.getGitToken());
      }

      if (StringUtils.hasLength(var4) && !var5.containsKey("SUDO")) {
         var5.add("SUDO", var4);
      }

      HttpEntity var6 = new HttpEntity(null, var5);
      String var7 = String.format("%1$s/api/v4/%2$s", var1.getGitPath(), var2);
      UriComponentsBuilder var8 = UriComponentsBuilder.fromHttpUrl(var7);
      if (var3 != null) {
         for (Entry var10 : var3.entrySet()) {
            var8.queryParam((String)var10.getKey(), var10.getValue());
         }
      }

      try {
         ResponseEntity var12 = this.restTemplate.exchange(new URI(var8.build().toString()), HttpMethod.GET, var6, String.class);
         if (var12.getStatusCode() != HttpStatus.OK && var12.getStatusCode() != HttpStatus.FOUND) {
            throw new Exception(StringHelper.format("请求发生异常，%1$s", var12.getStatusCode().getReasonPhrase()));
         }

         String var13 = (String)var12.getBody();
         if (!StringHelper.isNullOrEmpty(var13)) {
            var13 = new String(var13.getBytes("ISO-8859-1"), "utf8");
         }

         return var13;
      } catch (Exception var11) {
         this.outputException(var11, var7, HttpMethod.GET, var3);
         throw new Exception(StringHelper.format("请求发生异常，%1$s", var11.getMessage()), var11);
      }
   }

   protected String executePost(PSSVNServer var1, String var2, Map<String, Object> var3, String var4, HttpHeaders var5) throws Exception {
      if (var5 == null) {
         var5 = new HttpHeaders();
      }

      if (!var5.containsKey("PRIVATE-TOKEN")) {
         var5.add("PRIVATE-TOKEN", var1.getGitToken());
      }

      var5.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      if (StringUtils.hasLength(var4) && !var5.containsKey("SUDO")) {
         var5.add("SUDO", var4);
      }

      String var6 = String.format("%1$s/api/v4/%2$s", var1.getGitPath(), var2);
      LinkedMultiValueMap var7 = new LinkedMultiValueMap();
      if (var3 != null) {
         for (Entry var9 : var3.entrySet()) {
            var7.add(var9.getKey(), var9.getValue());
         }
      }

      HttpEntity var12 = new HttpEntity<>(var7, var5);

      try {
         ResponseEntity var13 = this.restTemplate.exchange(new URI(var6), HttpMethod.POST, var12, String.class);
         if (var13.getStatusCode() == HttpStatus.CREATED) {
            String var10 = (String)var13.getBody();
            if (!StringHelper.isNullOrEmpty(var10)) {
               var10 = new String(var10.getBytes("ISO-8859-1"), "utf8");
            }

            return var10;
         } else {
            throw new Exception(StringHelper.format("请求发生异常，%1$s", var13.getStatusCode().getReasonPhrase()));
         }
      } catch (Exception var11) {
         this.outputException(var11, var6, HttpMethod.POST, var3);
         throw new Exception(StringHelper.format("请求发生异常，%1$s", var11.getMessage()), var11);
      }
   }

   protected String executePut(PSSVNServer var1, String var2, Map<String, Object> var3, String var4, HttpHeaders var5) throws Exception {
      if (var5 == null) {
         var5 = new HttpHeaders();
      }

      if (!var5.containsKey("PRIVATE-TOKEN")) {
         var5.add("PRIVATE-TOKEN", var1.getGitToken());
      }

      var5.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      if (StringUtils.hasLength(var4) && !var5.containsKey("SUDO")) {
         var5.add("SUDO", var4);
      }

      String var6 = String.format("%1$s/api/v4/%2$s", var1.getGitPath(), var2);
      LinkedMultiValueMap var7 = new LinkedMultiValueMap();
      if (var3 != null) {
         for (Entry var9 : var3.entrySet()) {
            var7.add(var9.getKey(), var9.getValue());
         }
      }

      HttpEntity var12 = new HttpEntity<>(var7, var5);

      try {
         ResponseEntity var13 = this.restTemplate.exchange(new URI(var6), HttpMethod.PUT, var12, String.class);
         if (var13.getStatusCode() == HttpStatus.OK) {
            String var10 = (String)var13.getBody();
            if (!StringHelper.isNullOrEmpty(var10)) {
               var10 = new String(var10.getBytes("ISO-8859-1"), "utf8");
            }

            return var10;
         } else {
            throw new Exception(StringHelper.format("请求发生异常，%1$s", var13.getStatusCode().getReasonPhrase()));
         }
      } catch (Exception var11) {
         this.outputException(var11, var6, HttpMethod.PUT, var3);
         throw new Exception(StringHelper.format("请求发生异常，%1$s", var11.getMessage()), var11);
      }
   }

   protected String executeDelete(PSSVNServer var1, String var2, Map<String, Object> var3, String var4, HttpHeaders var5) throws Exception {
      if (var5 == null) {
         var5 = new HttpHeaders();
      }

      if (!var5.containsKey("PRIVATE-TOKEN")) {
         var5.add("PRIVATE-TOKEN", var1.getGitToken());
      }

      var5.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      if (StringUtils.hasLength(var4) && !var5.containsKey("SUDO")) {
         var5.add("SUDO", var4);
      }

      String var6 = String.format("%1$s/api/v4/%2$s", var1.getGitPath(), var2);
      LinkedMultiValueMap var7 = new LinkedMultiValueMap();
      if (var3 != null) {
         for (Entry var9 : var3.entrySet()) {
            var7.add(var9.getKey(), var9.getValue());
         }
      }

      HttpEntity var12 = new HttpEntity<>(var7, var5);

      try {
         ResponseEntity var13 = this.restTemplate.exchange(new URI(var6), HttpMethod.DELETE, var12, String.class);
         if (var13.getStatusCode() != HttpStatus.OK && var13.getStatusCode() != HttpStatus.NO_CONTENT) {
            throw new Exception(StringHelper.format("请求发生异常，%1$s", var13.getStatusCode().getReasonPhrase()));
         }

         String var10 = (String)var13.getBody();
         if (!StringHelper.isNullOrEmpty(var10)) {
            var10 = new String(var10.getBytes("ISO-8859-1"), "utf8");
         }

         return var10;
      } catch (Exception var11) {
         this.outputException(var11, var6, HttpMethod.DELETE, var3);
         throw new Exception(StringHelper.format("请求发生异常，%1$s", var11.getMessage()), var11);
      }
   }

   protected void outputException(Exception var1, String var2, HttpMethod var3, Map<String, Object> var4) {
      StringBuilderEx var5 = new StringBuilderEx();
      var5.append("请求[%1$s][%2$s]", var2, var3);
      if (var4 != null) {
         var5.append("，参数{", var2, var3);

         for (Entry var7 : var4.entrySet()) {
            var5.append("%1$s:%2$s,", var7.getKey(), var7.getValue());
         }

         var5.append("}", var2, var3);
      }

      String var11 = null;
      if (var1 instanceof HttpClientErrorException) {
         HttpClientErrorException var12 = (HttpClientErrorException)var1;
         byte[] var8 = var12.getResponseBodyAsByteArray();
         if (var8 != null) {
            try {
               var11 = new String(var12.getResponseBodyAsByteArray(), "utf8");
            } catch (UnsupportedEncodingException var10) {
               log.error(var10);
            }
         }
      }

      if (StringHelper.isNullOrEmpty(var11)) {
         log.error(String.format("%1$s 发生异常，%2$s", var5.toString(), var1.getMessage()), var1);
      } else {
         log.error(String.format("%1$s 发生异常，%2$s，详细 ==> %3$s", var5.toString(), var1.getMessage(), var11), var1);
      }
   }
}
