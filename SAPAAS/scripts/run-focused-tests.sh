#!/usr/bin/env bash
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
IMAGE="${TASK_BUILDER_IMAGE:-maven:3.9-eclipse-temurin-8@sha256:db6bb29eb4d2507d01acc525bddf1b3a8216e3c29ca983be2e715028070281a4}"

if ! command -v docker >/dev/null 2>&1; then
  echo "Docker is required for the focused JDK 8 regressions." >&2
  exit 1
fi

docker run --rm \
  --mount "type=bind,src=$ROOT_DIR,dst=/workspace/task7,readonly" \
  --workdir /workspace/task7 \
  "$IMAGE" \
  bash -euo pipefail -c '
    output="$(mktemp -d)"
    trap '\''rm -rf "$output"'\'' EXIT
    javac -source 7 -target 7 -encoding UTF-8 \
      -d "$output" SAPAAS/build-tools/BuildPreflight.java
    java -cp "$output" BuildPreflight --self-test
    expected="$(sed -n '\''s/.*name="expected-dependency-count" value="\([0-9][0-9]*\)".*/\1/p'\'' SAPAAS/resources/classes/build.xml)"
    test -n "$expected"
    java -cp "$output" BuildPreflight --dependencies SAPAAS/lib SAPAAS/lib/SHA256SUMS "$expected"
    api="SAPAAS/build-tools/lib/javax.servlet-api-4.0.1.jar:SAPAAS/build-tools/lib/jsp-api-task7.jar:SAPAAS/build-tools/lib/tomcat-el-api-9.0.100.jar:SAPAAS/build-tools/lib/jxl-2.6.12.jar"
    javac -source 7 -target 7 -encoding UTF-8 \
      -classpath "SAPAAS/lib/*:$api:$output" \
      -sourcepath "SAPAAS/src/saim:SAPAAS/src/saibz5baselib:SAPAAS/src/saibz5wflib:SAPAAS/src/sasrf:SAPAAS/src/sasrfda:SAPAAS/src/sasrfdaeai:SAPAAS/src/sasrfdaeai2:SAPAAS/src/sasrfdaweb:SAPAAS/src/sasrfdauac:SAPAAS/src/sasrfex_2_1:SAPAAS/src/sawf" \
      -d "$output" \
      SAPAAS/src/saim/SA/IM/Ctrl/IMMTFtpUser.java \
      SAPAAS/src/saim/SA/IM/Ctrl/IMMTFtpUserManager.java \
      SAPAAS/src/saibz5baselib/net/ibizsys/saas/demodel/DataEntityModelBase.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/Transformer/BaseTransformer.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/Transformer/TransformerHelper.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/EAIDAGlobalHelper.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/InstanceMgr.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/EAIService.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/EAIServiceMgr.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/ServiceMgr.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/Server.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Ctrl/ServerEx.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Config/BaseServiceConfigWriter.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Endpoint/BaseProcessEndpoint.java \
      SAPAAS/src/sasrfdaeai/SA/SRFDA/EAI/Log/EAIJDBCAppender.java \
      SAPAAS/src/sasrfdaweb/SA/SRFDA/Ctrl/ToolbarWriter/DefaultToolbarWriterContext.java \
      SAPAAS/src/sasrfdauac/org/jasig/cas/client/validation/Saml11TicketValidator.java \
      SAPAAS/src/sasrfex_2_1/SA/SRFramework/WebEx/DP/UI/DPFormItemConfigUtility.java \
      SAPAAS/src/sasrfex_2_1/SA/SRFramework/WebEx/Utility/Jsp/SimpleServletRequest.java \
      SAPAAS/src/sasrfex_2_1/SA/SRFramework/WebEx/Utility/Jsp/SimpleServletResponse.java \
      SAPAAS/src/sasrfex_2_1/SA/SRFramework/WebEx/Utility/Jsp/SimplePageContext.java \
      SAPAAS/src/sawf/SRFWF/Model/WFEmbedProcessesConfig.java \
      SAPAAS/src/saibz5studiolib/net/ibizsys/pscore/srv/util/gitlab/util/JacksonJsonEnumHelper.java \
      SAPAAS/test/SRFWF/Model/WFEmbedProcessesConfigTest.java \
      SAPAAS/test/SA/IM/Ctrl/IMMTFtpUserManagerTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/Transformer/BaseTransformerTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/Transformer/TransformerHelperTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/Transformer/RecoveredTransformerTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/Transformer/JSONTransformerTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/EAIDAGlobalHelperTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/InstanceMgrTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/EAIServiceMgrPathTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/ServiceMgrLifecycleTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Config/BaseServiceConfigWriterTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/Router/DecideOutboundRouterTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Endpoint/BaseProcessEndpointTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Endpoint/EndpointProcessesTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Log/EAIJDBCAppenderTest.java \
      SAPAAS/test/SA/SRFDA/Ctrl/ToolbarWriter/DefaultToolbarWriterContextTest.java \
      SAPAAS/test/org/jasig/cas/client/validation/Saml11TicketValidatorTest.java \
      SAPAAS/test/org/jasig/cas/client/util/CommonUtilsTest.java \
      SAPAAS/test/SA/SRFDA/EAI/Ctrl/DataCtrl/DBOPPKGDataCtrlTest.java \
      SAPAAS/test/SA/SRFDA/Ctrl/XMLCollectionManagersTest.java \
      SAPAAS/test/SA/SRFDA/Model/XMLCollectionManagersTest.java \
      SAPAAS/test/SA/SRFramework/WebEx/Utility/Jsp/SimpleServletAdaptersTest.java \
      SAPAAS/test/SA/SRFramework/WebEx/DP/UI/DPFormItemConfigUtilityTest.java \
      SAPAAS/test/net/ibizsys/pscore/srv/util/gitlab/util/JacksonJsonEnumHelperTest.java
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelperTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SRFWF.Model.WFEmbedProcessesConfigTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.IM.Ctrl.IMMTFtpUserManagerTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.Transformer.BaseTransformerTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.Transformer.TransformerHelperTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.Transformer.RecoveredTransformerTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.Transformer.JSONTransformerTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.EAIDAGlobalHelperTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.InstanceMgrTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.EAIServiceMgrPathTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.ServiceMgrLifecycleTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Config.BaseServiceConfigWriterTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.Router.DecideOutboundRouterTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Endpoint.BaseProcessEndpointTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Endpoint.EndpointProcessesTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Log.EAIJDBCAppenderTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContextTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner org.jasig.cas.client.validation.Saml11TicketValidatorTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner org.jasig.cas.client.util.CommonUtilsTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.EAI.Ctrl.DataCtrl.DBOPPKGDataCtrlTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.Ctrl.XMLCollectionManagersTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFDA.Model.XMLCollectionManagersTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFramework.WebEx.Utility.Jsp.SimpleServletAdaptersTest
    java -cp "SAPAAS/lib/*:$api:$output" \
      junit.textui.TestRunner SA.SRFramework.WebEx.DP.UI.DPFormItemConfigUtilityTest
  '
