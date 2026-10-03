package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DEShortcut;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PickerExWriter extends BaseFormCtrlWriter {
   private static final Log log = LogFactory.getLog(PickerExWriter.class);
   public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
   public static final String TAG_EDITPAGEID = "EDITPAGEID";
   public static final String TAG_SHOWBUTTON = "SHOWBUTTON";
   public static final String TAG_DATALINK = "DATALINK";
   public static final String TAG_ACHIDETRIGGER = "ACHIDETRIGGER";
   public static final String TAG_ACUSERMODE = "ACUSERMODE";
   public static final String TAG_TBDV = "TBDV";
   public static final String TAG_TBDV2 = "TBDV2";
   public static final String TAG_TBDVT = "TBDVT";
   public static final String TAG_TBDVT2 = "TBDVT2";
   public static final String TAG_PICKUPDE = "PICKUPDE";
   public static final String TAG_PICKUPTEXTITEM = "PICKUPTEXTITEM";
   public static final String TAG_APPENDURLPARAMS = "APPENDURLPARAMS";
   public static final String TAG_ACUSERPARAMSEX = "ACUSERPARAMSEX";

   @Override
   protected XMLNode OnGetFormCtrlNode(
      IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams
   ) {
      IPickupDEFHelper iPickupDEFHelper = null;
      ILinkDEFHelper pickupTextDEFHelper = null;
      String strPickupDEId = "";
      String strPickupTextItem = "";
      boolean bPickupDEMode = false;
      IDEHelper iPickupDEHelper = null;
      IDEFHelper iTextDEFHelper = null;
      if (!(iDEFHelper instanceof IPickupDEFHelper)) {
         if (StringHelper.Compare(iDEFHelper.GetDataType(), "INHERIT", true) == 0) {
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            if (!(linkDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) {
               log.error(StringHelper.Format("属性[%1$s]没有实现接口[IPickupDEFHelper]，无法构建表单对象", iDEFHelper.GetFullName()));
               return null;
            }

            iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
            pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
            iPickupDEHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper();
         } else {
            if (ctrlParams == null) {
               log.error(StringHelper.Format("属性[%1$s]没有实现接口[IPickupDEFHelper]，无法构建表单对象", iDEFHelper.GetFullName()));
               return null;
            }

            strPickupDEId = ctrlParams.get("PICKUPDE");
            strPickupTextItem = ctrlParams.get("PICKUPTEXTITEM");
            if (StringHelper.IsNullOrEmpty(strPickupDEId) || StringHelper.IsNullOrEmpty(strPickupTextItem)) {
               log.error(StringHelper.Format("属性[%1$s]没有实现接口[IPickupDEFHelper]，无法构建表单对象", iDEFHelper.GetFullName()));
               return null;
            }

            iPickupDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPickupDEId);
            if (iPickupDEHelper == null) {
               log.error(StringHelper.Format("无法获取实体[%1$s]辅助对象", strPickupDEId));
               return null;
            }

            iTextDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strPickupTextItem);
            if (iTextDEFHelper == null) {
               log.error(StringHelper.Format("无法获取实体属性[%1$s:%2$s]辅助对象", strPickupDEId, strPickupTextItem));
               return null;
            }

            bPickupDEMode = true;
         }
      } else {
         iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
         pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
         iPickupDEHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper();
      }

      XMLNode ctrlNode = new XMLNode();
      ctrlNode.setNodeName("SRFEXPICKEREX");
      String strRangeCond = "";
      String strResetCond = "";
      DER1N der1N = new DER1N();
      new CallResult();
      if (!bPickupDEMode) {
         CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(iPickupDEFHelper.GetDERId(), der1N);
         if (callResult.getRetCode() == 0) {
            strRangeCond = der1N.getRANGECOND();
         }
      }

      if (this.IsShowButton()) {
         String strPickupPageId = this.GetPickupPageId(ctrlParams);
         if (!bPickupDEMode && StringHelper.IsNullOrEmpty(strPickupPageId)) {
            strPickupPageId = der1N.getPICKUPPAGEID();
         }

         if (StringHelper.IsNullOrEmpty(strPickupPageId)) {
            strPickupPageId = iPickupDEHelper.GetPickupPageId();
         }

         String strDialogURL = "../srfpage/pickupview.jsp";
         int nDialogWidth = 0;
         int nDialogHeight = 0;
         String strDialogResizable = "yes";
         String strDialogScroll = "yes";
         String strDialogStatus = "no";
         String strAppendFormParams = "";
         if (!StringHelper.IsNullOrEmpty(strPickupPageId)) {
            Page pickupPage = new Page();
            CallResult var54 = this.globalHelperEx.getDAModelHelper().GetPage(strPickupPageId, pickupPage);
            if (var54 == null || var54.getRetCode() != 0) {
               log.error(StringHelper.Format("无法找到指定页面实体[%1$s]", strPickupPageId));
               return null;
            }

            if (!StringHelper.IsNullOrEmpty(pickupPage.GetTotalPagePath())) {
               strDialogURL = pickupPage.GetTotalPagePath();
            }

            if (pickupPage.getWIDTH() != 0) {
               nDialogWidth = pickupPage.getWIDTH();
            }

            if (pickupPage.getHEIGHT() != 0) {
               nDialogHeight = pickupPage.getHEIGHT();
            }
         }

         strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
         if (bPickupDEMode) {
            strDialogURL = strDialogURL
               + StringHelper.Format(
                  "SRFDEFID=%1$s&SRFDEID=%4$s",
                  iDEFHelper.getId(),
                  iPickupDEHelper.GetKeyDEFHelper().getName(),
                  iPickupDEHelper.GetMajorDEFHelper().getName(),
                  iPickupDEHelper.getId()
               );
         } else {
            strDialogURL = strDialogURL
               + StringHelper.Format(
                  "SRFDEFID=%1$s&SRFDEID=%4$s&SRFDER1NID=%5$s",
                  iDEFHelper.getId(),
                  iPickupDEFHelper.GetRelatedDEFHelper().getName(),
                  pickupTextDEFHelper.GetRelatedDEFHelper().getName(),
                  iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId(),
                  iPickupDEFHelper.GetDERId()
               );
         }

         String strAppendURLParams = this.GetAppendURLParams(ctrlParams);
         if (StringHelper.IsNullOrEmpty(strAppendURLParams)) {
            strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
            strDialogURL = strDialogURL + strAppendURLParams;
         }

         if (!bSearchMode) {
            String strURL = "../srfpage/editview.jsp?";
            int nWidth = 980;
            int nHeight = 680;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            String strEditPageId = this.GetEditPageId(ctrlParams);
            if (StringHelper.IsNullOrEmpty(strEditPageId)) {
               strEditPageId = iPickupDEHelper.GetInfoPageId();
            }

            if (!StringHelper.IsNullOrEmpty(strEditPageId)) {
               Page editPage = this.globalHelperEx.getDAModelStorage().FindPage(strEditPageId);
               if (editPage == null) {
                  log.error("获取页面信息失败");
                  return null;
               }

               if (!StringHelper.IsNullOrEmpty(editPage.GetTotalPagePath())) {
                  strURL = editPage.GetTotalPagePath();
               }

               if (editPage.getWIDTH() != 0) {
                  nWidth = editPage.getWIDTH();
               }

               if (editPage.getHEIGHT() != 0) {
                  nHeight = editPage.getHEIGHT();
               }

               if (!StringHelper.IsNullOrEmpty(editPage.getWINDOWSTYLE())) {
                  strWindowStyle = editPage.getWINDOWSTYLE();
               }
            }

            strURL = URLHelper.AppendURLSeperator(strURL);
            strURL = strURL + StringHelper.Format("SRFDEID=%1$s", iPickupDEHelper.getId());
            strURL = URLHelper.AppendURLSeperator(strURL);
            if (bPickupDEMode) {
               strURL = strURL + iPickupDEHelper.GetKeyDEFHelper().getName();
            } else {
               strURL = strURL + iPickupDEFHelper.GetRealDEFHelper().getName();
            }

            strURL = strURL + "=";
            if (this.GetPickupDataLink(ctrlParams)) {
               if (StringHelper.Compare(this.strPageModel, "SL", true) == 0) {
                  JSONObject jo = new JSONObject();
                  jo.put("url", strURL);
                  jo.put("width", nWidth);
                  jo.put("height", nHeight);
                  ctrlNode.SetValue("DATALINKJSCODE", jo.toString());
               } else {
                  String strDataLinkJSCode = StringHelper.Format("var _URL='%1$s'+_V;", strURL);
                  strDataLinkJSCode = strDataLinkJSCode
                     + StringHelper.Format("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", nWidth, nHeight, strWindowStyle);
                  ctrlNode.SetValue("DATALINKJSCODE", strDataLinkJSCode);
               }
            }

            Vector<DEShortcut> deShortcuts = new Vector<>();
            CallResult var55 = this.globalHelperEx.getDAModelHelper().GetDEShortcuts(iPickupDEHelper.getId(), 1, deShortcuts);
            if (var55.IsError()) {
               log.error(StringHelper.Format("查询实体[%1$s]快捷方式发生错误，%2$s", iPickupDEHelper.getId(), var55.getErrorInfo()));
               return null;
            }

            if (deShortcuts.size() > 0) {
               XMLNode dataLinksNode = new XMLNode();
               dataLinksNode.setNodeName("SRFEXDATALINK");
               ctrlNode.AddNode(dataLinksNode);

               for (DEShortcut shortCut : deShortcuts) {
                  XMLNode dataLinkNode = new XMLNode();
                  dataLinkNode.setNodeName("SRFEXDATALINK");
                  dataLinksNode.AddNode(dataLinkNode);
                  if (!StringHelper.IsNullOrEmpty(shortCut.getICONPATH())) {
                     dataLinkNode.SetValue("DATALINKIMAGE", shortCut.getICONPATH());
                  }

                  dataLinkNode.SetValue("DATALINKTIPMESSAGE", shortCut.getDESHORTCUTNAME());
                  dataLinkNode.SetValue("DATALINKJSCODE", shortCut.getJSCODE());
               }
            }

            if (!StringHelper.IsNullOrEmpty(strRangeCond)) {
               try {
                  int nIndex = 0;
                  Properties properties = PropertiesHelper.Load(strRangeCond);
                  Enumeration en = properties.keys();

                  while (en.hasMoreElements()) {
                     String strKey = (String)en.nextElement();
                     String strValue = PropertiesHelper.GetProperty(properties, strKey);
                     IDEFHelper rcDEFHelper = iPickupDEHelper.GetDEFHelper(strKey);
                     if (rcDEFHelper == null) {
                        log.warn(StringHelper.Format("无法获取范围条件中主实体属性[%1$s]辅助对象", strKey));
                        rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                        if (rcDEFHelper == null) {
                           log.error(StringHelper.Format("无法在主实体属性[%1$s]辅助对象", strValue));
                           break;
                        }

                        if (!StringHelper.IsNullOrEmpty(strAppendFormParams)) {
                           strAppendFormParams = strAppendFormParams + ",";
                        }

                        strAppendFormParams = strAppendFormParams + strKey + "|" + strValue;
                        strResetCond = formCtrlConfig.GetExtValue("RESETCOND", "");
                        if (!StringHelper.IsNullOrEmpty(strResetCond)) {
                           strResetCond = strResetCond + ";";
                        }

                        strResetCond = strResetCond + strValue;
                        formCtrlConfig.SetValue("RESETCOND", strResetCond);
                        String strLastCode = formCtrlConfig.GetExtValue("ENABLECOND", "");
                        if (StringHelper.IsNullOrEmpty(strLastCode)) {
                           formCtrlConfig.SetValue("ENABLECOND", StringHelper.Format("dp.Val(\"%1$s\")+\"!=''\"", strValue));
                        } else {
                           String strNewCode = "'('+" + strLastCode + "+')&&('+" + StringHelper.Format("dp.Val(\"%1$s\")+\"!=''\"", strValue) + "+')'";
                           formCtrlConfig.SetValue("ENABLECOND", strNewCode);
                        }
                     } else {
                        if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                           log.error(StringHelper.Format("主实体属性[%1$s]不是关系属性", strKey));
                           break;
                        }

                        ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                        String strDERId = rcLinkDEFHelper.GetDERId();
                        String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                        if (!StringHelper.IsNullOrEmpty(strAppendFormParams)) {
                           strAppendFormParams = strAppendFormParams + ",";
                        }

                        strAppendFormParams = strAppendFormParams + strRelatedName + "|" + strValue;
                        strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                        strDialogURL = strDialogURL + StringHelper.Format("%1$s=%2$s", "SRFDERID", strDERId);
                        strResetCond = formCtrlConfig.GetExtValue("RESETCOND", "");
                        if (!StringHelper.IsNullOrEmpty(strResetCond)) {
                           strResetCond = strResetCond + ";";
                        }

                        strResetCond = strResetCond + strValue;
                        formCtrlConfig.SetValue("RESETCOND", strResetCond);
                        String strLastCode = formCtrlConfig.GetExtValue("ENABLECOND", "");
                        if (StringHelper.IsNullOrEmpty(strLastCode)) {
                           formCtrlConfig.SetValue("ENABLECOND", StringHelper.Format("dp.Val(\"%1$s\")+\"!=''\"", strValue));
                        } else {
                           String strNewCode = "'('+" + strLastCode + "+')&&('+" + StringHelper.Format("dp.Val(\"%1$s\")+\"!=''\"", strValue) + "+')'";
                           formCtrlConfig.SetValue("ENABLECOND", strNewCode);
                        }
                     }
                  }
               } catch (Exception ex) {
                  log.error(ex);
               }
            }
         }

         ctrlNode.SetValue("DIALOGURL", strDialogURL);
         if (nDialogWidth != 800) {
            ctrlNode.SetValue("DIALOGWIDTH", String.valueOf(nDialogWidth));
         }

         if (nDialogHeight != 600) {
            ctrlNode.SetValue("DIALOGHEIGHT", String.valueOf(nDialogHeight));
         }

         if (StringHelper.Compare(strDialogResizable, "no", true) != 0) {
            ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
         }

         if (StringHelper.Compare(strDialogScroll, "yes", true) != 0) {
            ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
         }

         if (StringHelper.Compare(strDialogStatus, "no", true) != 0) {
            ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
         }

         ctrlNode.SetValue("APPENDFORMPARAMS", strAppendFormParams);
      } else {
         ctrlNode.SetValue("SHOWBUTTON", "FALSE");
      }

      String strTipsInfo = iPickupDEHelper.getDataEntity().getTIPSINFO();
      String strTipsObject = iPickupDEHelper.getDataEntity().getTIPSOBJECT();
      if (!StringHelper.IsNullOrEmpty(strTipsInfo) || !StringHelper.IsNullOrEmpty(strTipsObject)) {
         String strTooltipURL = StringHelper.Format(
            "../srfpage/tooltipsbackend.jsp?SRFDEID=%1$s&%2$s=", iPickupDEHelper.getId(), iPickupDEHelper.GetKeyDEFHelper().getName()
         );
         ctrlNode.SetValue("TOOLTIPURL", strTooltipURL);
      }

      XMLNode childNode = new XMLNode();
      childNode.setNodeName("SRFEXTEXTBOX");
      ctrlNode.AddNode(childNode);
      if (bPickupDEMode) {
         childNode.setID(iTextDEFHelper.GetFormCtrl().GetFormCtrlId());
      } else {
         childNode.setID(pickupTextDEFHelper.GetFormCtrl().GetFormCtrlId());
      }

      if (iDEFHelper.GetFormCtrl() != null) {
         CopyCtrlParams(childNode, ctrlParams);
      }

      String strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "");
      XMLNode itemNode = AppendFormItemNode(
         this.globalHelperEx, bPickupDEMode ? iTextDEFHelper : pickupTextDEFHelper, formCtrlConfig, childNode, this.strLanguage
      );
      itemNode.SetValue("ALLOWEMPTY", "TRUE");
      itemNode.SetValue("MAXLENGTH", "65535");
      if (ctrlParams != null) {
         String strTBDV = ctrlParams.get("TBDV");
         String strTBDV2 = ctrlParams.get("TBDV2");
         String strTBDVT = ctrlParams.get("TBDVT");
         String strTBDVT2 = ctrlParams.get("TBDVT2");
         itemNode.SetValue("DV", strTBDV);
         itemNode.SetValue("DV2", strTBDV2);
         itemNode.SetValue("DVT", strTBDVT);
         itemNode.SetValue("DVT2", strTBDVT2);
         ctrlParams.remove("TBDV");
         ctrlParams.remove("TBDV2");
         ctrlParams.remove("TBDVT");
         ctrlParams.remove("TBDVT2");
      }

      formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
      if (this.IsEnableAC()) {
         String strACAppendURLParams = "";
         String strACAppendFormParams = "";
         if (!StringHelper.IsNullOrEmpty(strRangeCond)) {
            try {
               Properties properties = PropertiesHelper.Load(strRangeCond);
               Enumeration en = properties.keys();
               if (en.hasMoreElements()) {
                  String strKey = (String)en.nextElement();
                  String strValue = PropertiesHelper.GetProperty(properties, strKey);
                  IDEFHelper rcDEFHelper = iPickupDEHelper.GetDEFHelper(strKey);
                  if (rcDEFHelper == null) {
                     log.warn(StringHelper.Format("无法获取范围条件中主实体属性[%1$s]辅助对象", strKey));
                     rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                     if (rcDEFHelper == null) {
                        log.error(StringHelper.Format("无法在主实体属性[%1$s]辅助对象", strValue));
                     } else {
                        strACAppendFormParams = strKey + "|" + strValue;
                     }
                  } else if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                     log.error(StringHelper.Format("主实体属性[%1$s]不是关系属性", strKey));
                  } else {
                     ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                     String strDERId = rcLinkDEFHelper.GetDERId();
                     strACAppendURLParams = StringHelper.Format("SRFDERID=%1$s", strDERId);
                     String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                     strACAppendFormParams = strRelatedName + "|" + strValue;
                  }
               }
            } catch (Exception ex) {
               log.error(ex);
            }
         }

         strACAppendFormParams = GetCtrlParam(ctrlParams, "ACAPPENDFORMPARAMS", strACAppendFormParams);
         if (iPickupDEFHelper != null) {
            if (!StringHelper.IsNullOrEmpty(strACAppendURLParams)) {
               strACAppendURLParams = strACAppendURLParams + "&";
            }

            strACAppendURLParams = strACAppendURLParams + StringHelper.Format("SRFDER1NID=%1$s", iPickupDEFHelper.GetDERId());
         }

         String strUserACAppendURLParams = GetCtrlParam(ctrlParams, "ACAPPENDURLPARAMS", "");
         if (!StringHelper.IsNullOrEmpty(strUserACAppendURLParams)) {
            if (!StringHelper.IsNullOrEmpty(strACAppendURLParams)) {
               strACAppendURLParams = strACAppendURLParams + "&";
            }

            strACAppendURLParams = strACAppendURLParams + strUserACAppendURLParams;
         }

         childNode.SetValue("ACAPPENDURLPARAMS", strACAppendURLParams);
         childNode.SetValue("ACAPPENDFORMPARAMS", strACAppendFormParams);
         childNode.SetValue("ACMODE", "SRFDAAC");
         childNode.SetValue("ACHIDETRIGGER", this.IsHideACTrigger() ? "TRUE" : "FALSE");
         if (!this.IsHideACTrigger()) {
            childNode.SetValue("ACWIDTHMODE", "TRUE");
         }

         childNode.SetValue("FORCESELECTION", "TRUE");
         String strACUserParams = StringHelper.Format("srfdeid:'%1$s'", iPickupDEHelper.getId());
         String strACUserMode = "";
         if (ctrlParams != null) {
            strACUserMode = ctrlParams.get("ACUSERMODE");
            ctrlParams.remove("ACUSERMODE");
         }

         if (StringHelper.IsNullOrEmpty(strACUserMode)) {
            strACUserMode = der1N.getDEACMODENAME();
         }

         if (!StringHelper.IsNullOrEmpty(strACUserMode)) {
            strACUserParams = strACUserParams + StringHelper.Format(",acusermode:'%1$s'", strACUserMode);
         }

         childNode.SetValue("ACUSERPARAMS", strACUserParams);
         childNode.SetValue("ACLISTWIDTH", this.GetACListWidth(ctrlParams));
         childNode.SetValue("ACCARETFORMPARAMS", this.GetACCaretFormParams(ctrlParams));
         childNode.SetValue("ACMINCHARS", this.GetACMinchars(ctrlParams));
      } else {
         ctrlNode.SetValue("PICKONLY", "TRUE");
      }

      if (iDEFHelper.GetFormCtrl().IsEnableFormCreate() && iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) {
         itemNode.SetValue("ENABLECOND", "ALL");
      } else if (iDEFHelper.GetFormCtrl().IsEnableFormCreate()) {
         itemNode.SetValue("ENABLECOND", "CREATE");
      } else if (iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) {
         itemNode.SetValue("ENABLECOND", "UPDATE");
      } else {
         itemNode.SetValue("ENABLECOND", "NONE");
      }

      itemNode.SetValue("VALIDCOND", itemNode.GetExtValue("ENABLECOND", ""));
      itemNode.RemoveExtValue("ALLOWEMPTYCOND");
      return ctrlNode;
   }

   @Override
   protected XMLNode OnAppendFormItemNode(IDEFHelper helper, XMLNode formCtrlConfig, XMLNode ctrlNode) {
      return super.OnAppendFormItemNode(helper, formCtrlConfig, ctrlNode);
   }

   protected String GetACCaretFormParams(TreeMap<String, String> ctrlParams) {
      String strACCaretFormParams = "";
      if (ctrlParams != null) {
         strACCaretFormParams = ctrlParams.get("ACCARETFORMPARAMS");
         ctrlParams.remove("ACCARETFORMPARAMS");
         return strACCaretFormParams;
      } else {
         return "";
      }
   }

   protected String GetACListWidth(TreeMap<String, String> ctrlParams) {
      String strACListWidth = "";
      if (ctrlParams != null) {
         strACListWidth = ctrlParams.get("ACLISTWIDTH");
         ctrlParams.remove("ACLISTWIDTH");
         if (!StringHelper.IsNullOrEmpty(strACListWidth)) {
            return strACListWidth;
         }
      }

      return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACLISTWIDTH", "400");
   }

   protected boolean GetPickupDataLink(TreeMap<String, String> ctrlParams) {
      if (ctrlParams != null) {
         String strDataLink = ctrlParams.get("DATALINK");
         if (!StringHelper.IsNullOrEmpty(strDataLink)) {
            return StringHelper.Compare(strDataLink, "FALSE", true) != 0;
         }
      }

      return true;
   }

   protected String GetACMinchars(TreeMap<String, String> ctrlParams) {
      String strACMinchars = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACMINCHARS", "2");
      if (ctrlParams != null) {
         strACMinchars = ctrlParams.get("ACMINCHARS");
         ctrlParams.remove("ACMINCHARS");
      }

      return strACMinchars;
   }

   protected String GetPickupPageId(TreeMap<String, String> ctrlParams) {
      if (ctrlParams != null) {
         String strPickupPageId = ctrlParams.get("PICKUPPAGEID");
         if (!StringHelper.IsNullOrEmpty(strPickupPageId)) {
            return strPickupPageId;
         }
      }

      return this.formCtrlHelperConfig.GetExtValue("PICKUPPAGEID", "");
   }

   protected String GetEditPageId(TreeMap<String, String> ctrlParams) {
      if (ctrlParams != null) {
         String strEditPageId = ctrlParams.get("EDITPAGEID");
         if (!StringHelper.IsNullOrEmpty(strEditPageId)) {
            return strEditPageId;
         }
      }

      return this.formCtrlHelperConfig.GetExtValue("EDITPAGEID", "");
   }

   protected String GetAppendURLParams(TreeMap<String, String> ctrlParams) {
      if (ctrlParams != null) {
         String strAppendUrlParams = ctrlParams.get("APPENDURLPARAMS");
         if (!StringHelper.IsNullOrEmpty(strAppendUrlParams)) {
            return strAppendUrlParams;
         }
      }

      return this.formCtrlHelperConfig.GetExtValue("APPENDURLPARAMS", "");
   }

   protected boolean IsShowButton() {
      return this.formCtrlHelperConfig.GetExtValue("SHOWBUTTON", true);
   }

   protected boolean IsEnableAC() {
      return this.formCtrlHelperConfig.GetExtValue("AC", true);
   }

   protected boolean IsHideACTrigger() {
      return this.formCtrlHelperConfig.GetExtValue("ACHIDETRIGGER", true);
   }

   @Override
   protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
      IPickupDEFHelper iPickupDEFHelper = null;
      ILinkDEFHelper pickupTextDEFHelper = null;
      if (!(iDEFHelper instanceof ILinkDEFHelper)) {
         if (StringHelper.Compare(iDEFHelper.GetDataType(), "INHERIT", true) != 0) {
            log.error(StringHelper.Format("属性[%1$s]没有实现接口[IPickupDEFHelper]，无法构建表格单元编辑对象", iDEFHelper.GetFullName()));
            return null;
         }

         ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
         if (!(linkDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) {
            log.error(StringHelper.Format("属性[%1$s]没有实现接口[IPickupDEFHelper]，无法构建表格单元编辑对象", iDEFHelper.GetFullName()));
            return null;
         }

         iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
         pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
      } else {
         iPickupDEFHelper = iDEFHelper.getDEHelper().GetPickupDEFHelper((ILinkDEFHelper)iDEFHelper);
         pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
      }

      TreeMap<String, String> ctrlParams = new TreeMap<>();
      if (!StringHelper.IsNullOrEmpty(iDEFHelper.getDGItem().GetEditorParam(dgModeDetail))) {
         try {
            Properties properties = PropertiesHelper.Load(iDEFHelper.getDGItem().GetEditorParam(dgModeDetail));
            Enumeration en = properties.keys();

            while (en.hasMoreElements()) {
               String strKey = (String)en.nextElement();
               String strValue = PropertiesHelper.GetProperty(properties, strKey);
               ctrlParams.put(strKey.toUpperCase(), strValue);
            }
         } catch (Exception ex) {
            return null;
         }
      }

      String strRangeCond = "";
      DER1N der1N = new DER1N();
      CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(iPickupDEFHelper.GetDERId(), der1N);
      if (callResult.getRetCode() == 0) {
         strRangeCond = der1N.getRANGECOND();
      }

      XMLNode ctrlNode = new XMLNode();
      ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
      ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.PickupColumnEditor");
      ctrlNode.SetValue("VALUEFIELD", iPickupDEFHelper.getName());
      ctrlNode.SetValue("ACMODE", "SRFDAAC");
      ctrlNode.SetValue("FORCESELECTION", "TRUE");
      String strACUserParams = StringHelper.Format("srfdeid:'%1$s'", iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId());
      String strACUserMode = "";
      if (ctrlParams != null) {
         strACUserMode = ctrlParams.get("ACUSERMODE");
         ctrlParams.remove("ACUSERMODE");
      }

      if (StringHelper.IsNullOrEmpty(strACUserMode)) {
         strACUserMode = der1N.getDEACMODENAME();
      }

      if (!StringHelper.IsNullOrEmpty(strACUserMode)) {
         strACUserParams = strACUserParams + StringHelper.Format(",acusermode:'%1$s'", strACUserMode);
      }

      ctrlNode.SetValue("ACUSERPARAMS", strACUserParams);
      String strACHIDETRIGGER = "";
      if (ctrlParams != null) {
         strACHIDETRIGGER = ctrlParams.get("ACHIDETRIGGER");
         ctrlParams.remove("ACHIDETRIGGER");
      }

      if (!StringHelper.IsNullOrEmpty(strACHIDETRIGGER)) {
         ctrlNode.SetValue("ACHIDETRIGGER", strACHIDETRIGGER);
      }

      String strAppendFormParams = "";
      String strACAppendURLParams = "";
      if (!StringHelper.IsNullOrEmpty(strRangeCond)) {
         try {
            Properties properties = PropertiesHelper.Load(strRangeCond);
            Enumeration en = properties.keys();
            if (en.hasMoreElements()) {
               String strKey = (String)en.nextElement();
               String strValue = PropertiesHelper.GetProperty(properties, strKey);
               IDEFHelper rcDEFHelper = iPickupDEFHelper.getDEHelper().GetDEFHelper(strKey);
               if (rcDEFHelper == null) {
                  log.warn(StringHelper.Format("无法获取范围条件中主实体属性[%1$s]辅助对象", strKey));
                  rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                  if (rcDEFHelper == null) {
                     log.error(StringHelper.Format("无法在主实体属性[%1$s]辅助对象", strValue));
                  } else {
                     strAppendFormParams = strKey + "|" + strValue;
                  }
               } else if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                  log.error(StringHelper.Format("主实体属性[%1$s]不是关系属性", strKey));
               } else {
                  ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                  String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                  String strDERId = rcLinkDEFHelper.GetDERId();
                  strACAppendURLParams = StringHelper.Format("SRFDERID=%1$s", strDERId);
                  strAppendFormParams = strRelatedName + "|" + strValue;
               }
            }
         } catch (Exception ex) {
            log.error(ex);
         }
      }

      if (iPickupDEFHelper != null) {
         if (!StringHelper.IsNullOrEmpty(strACAppendURLParams)) {
            strACAppendURLParams = strACAppendURLParams + "&";
         }

         strACAppendURLParams = strACAppendURLParams + StringHelper.Format("SRFDER1NID=%1$s", iPickupDEFHelper.GetDERId());
      }

      if (ctrlParams != null) {
         String strACAPPENDFORMPARAMS = ctrlParams.get("ACAPPENDFORMPARAMS");
         ctrlParams.remove("ACAPPENDFORMPARAMS");
         if (!StringHelper.IsNullOrEmpty(strACAPPENDFORMPARAMS)) {
            if (!StringHelper.IsNullOrEmpty(strAppendFormParams)) {
               strAppendFormParams = strAppendFormParams + ",";
            }

            strAppendFormParams = strAppendFormParams + strACAPPENDFORMPARAMS;
         }
      }

      if (ctrlParams != null) {
         String strACAPPENDURLPARAMS = ctrlParams.get("ACAPPENDURLPARAMS");
         ctrlParams.remove("ACAPPENDURLPARAMS");
         if (!StringHelper.IsNullOrEmpty(strACAPPENDURLPARAMS)) {
            strACAppendURLParams = strACAppendURLParams + "&";
            strACAppendURLParams = strACAppendURLParams + strACAPPENDURLPARAMS;
         }
      }

      ctrlNode.SetValue("ACAPPENDFORMPARAMS", strAppendFormParams);
      ctrlNode.SetValue("ACAPPENDURLPARAMS", strACAppendURLParams);
      String strPickupPageId = this.GetPickupPageId(ctrlParams);
      if (StringHelper.IsNullOrEmpty(strPickupPageId)) {
         strPickupPageId = der1N.getPICKUPPAGEID();
      }

      if (StringHelper.IsNullOrEmpty(strPickupPageId)) {
         strPickupPageId = iPickupDEFHelper.GetRealDEFHelper().getDEHelper().GetPickupPageId();
      }

      String strDialogURL = "../srfpage/pickupview.jsp";
      int nDialogWidth = 800;
      int nDialogHeight = 600;
      String strDialogResizable = "yes";
      String strDialogScroll = "yes";
      String strDialogStatus = "no";
      strAppendFormParams = "";
      if (!StringHelper.IsNullOrEmpty(strPickupPageId)) {
         Page pickupPage = new Page();
         callResult = this.globalHelperEx.getDAModelHelper().GetPage(strPickupPageId, pickupPage);
         if (callResult == null || callResult.getRetCode() != 0) {
            log.error(StringHelper.Format("无法找到指定页面实体[%1$s]", strPickupPageId));
            return null;
         }

         if (!StringHelper.IsNullOrEmpty(pickupPage.GetTotalPagePath())) {
            strDialogURL = pickupPage.GetTotalPagePath();
         }
      }

      strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
      strDialogURL = strDialogURL
         + StringHelper.Format(
            "SRFDEFID=%1$s&SRFDEID=%4$s&SRFDER1NID=%5$S",
            iDEFHelper.getId(),
            iPickupDEFHelper.GetRelatedDEFHelper().getName(),
            pickupTextDEFHelper.GetRelatedDEFHelper().getName(),
            iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId(),
            iPickupDEFHelper.GetDERId()
         );
      String strAppendURLParams = this.GetAppendURLParams(ctrlParams);
      if (StringHelper.IsNullOrEmpty(strAppendURLParams)) {
         strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
         strDialogURL = strDialogURL + strAppendURLParams;
      }

      if (!StringHelper.IsNullOrEmpty(strRangeCond)) {
         try {
            int nIndex = 0;
            Properties properties = PropertiesHelper.Load(strRangeCond);
            Enumeration en = properties.keys();
            if (en.hasMoreElements()) {
               String strKey = (String)en.nextElement();
               String strValue = PropertiesHelper.GetProperty(properties, strKey);
               IDEFHelper rcDEFHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().GetDEFHelper(strKey);
               if (rcDEFHelper == null) {
                  log.warn(StringHelper.Format("无法获取范围条件中主实体属性[%1$s]辅助对象", strKey));
                  rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                  if (rcDEFHelper == null) {
                     log.error(StringHelper.Format("无法在主实体属性[%1$s]辅助对象", strValue));
                  } else {
                     strAppendFormParams = strKey + "|" + strValue;
                  }
               } else if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                  log.error(StringHelper.Format("主实体属性[%1$s]不是关系属性", strKey));
               } else {
                  ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                  String strDERId = rcLinkDEFHelper.GetDERId();
                  String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                  strAppendFormParams = strRelatedName + "|" + strValue;
                  strDialogURL = URLHelper.AppendURLSeperator(strDialogURL);
                  strDialogURL = strDialogURL + StringHelper.Format("%1$s=%2$s", "SRFDERID", strDERId);
               }
            }
         } catch (Exception ex) {
            log.error(ex);
         }
      }

      ctrlNode.SetValue("DIALOGURL", strDialogURL);
      ctrlNode.SetValue("DIALOGWIDTH", String.valueOf(nDialogWidth));
      ctrlNode.SetValue("DIALOGHEIGHT", String.valueOf(nDialogHeight));
      ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
      ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
      ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
      ctrlNode.SetValue("APPENDFORMPARAMS", strAppendFormParams);

      for (String strKey : ctrlParams.keySet()) {
         ctrlNode.SetValue(strKey, ctrlParams.get(strKey));
      }

      return ctrlNode;
   }
}
