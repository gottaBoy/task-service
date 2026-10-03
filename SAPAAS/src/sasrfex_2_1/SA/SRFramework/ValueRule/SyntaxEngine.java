package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;

public class SyntaxEngine {
   private String strLastError = "";

   public ArrayList Parse(String strSAVR) {
      ArrayList childs = new ArrayList();
      int nRet = this.InternalParse(strSAVR, 0, childs);
      if (nRet == -1) {
         return null;
      } else {
         return nRet != strSAVR.length() ? null : childs;
      }
   }

   private int InternalParse(String strSAVR, int nStartPos, ArrayList childs) {
      if (StringHelper.IsNullOrEmpty(strSAVR)) {
         this.strLastError = "无法解析空规则串";
         return -1;
      }

      int nPos = nStartPos;
      int nLastPos = nStartPos;
      String strLastPart = "";

      while (nPos < strSAVR.length()) {
         char ch = strSAVR.charAt(nPos);
         label81:
         switch (ch) {
            case ' ':
               if (!StringHelper.IsNullOrEmpty(strLastPart)) {
                  childs.add(strLastPart);
                  strLastPart = "";
               }
               break;
            case '\'':
               String strString = "'";
               if (!StringHelper.IsNullOrEmpty(strLastPart)) {
                  this.strLastError = StringHelper.Format("位置[%1$s]出现了'''，无法识别'%2$s'", nLastPos, strLastPart);
                  return -1;
               }

               nLastPos = nPos++;

               while (true) {
                  ch = strSAVR.charAt(nPos);
                  if (ch != '\'') {
                     strString = strString + ch;
                  } else {
                     if (nPos + 1 >= strSAVR.length()) {
                        strString = strString + "'";
                        childs.add(strString);
                        strString = "";
                        break;
                     }

                     if (strSAVR.charAt(nPos + 1) != '\'') {
                        strString = strString + "'";
                        childs.add(strString);
                        strString = "";
                        break;
                     }

                     strString = strString + "'";
                     nPos++;
                  }

                  if (nPos >= strSAVR.length()) {
                     break;
                  }

                  nPos++;
               }

               if (!StringHelper.IsNullOrEmpty(strString)) {
                  this.strLastError = StringHelper.Format("位置[%1$s]的字符串没有封闭", nLastPos);
                  return -1;
               }
               break;
            case '(':
               if (!StringHelper.IsNullOrEmpty(strLastPart)) {
                  childs.add(strLastPart);
                  strLastPart = "";
               }

               ArrayList subchilds = new ArrayList();
               int nRet = this.InternalParse(strSAVR, nPos + 1, subchilds);
               if (nRet == -1) {
                  return -1;
               }

               childs.add(subchilds);
               nLastPos = nPos;
               nPos = nRet;

               while (true) {
                  ch = strSAVR.charAt(nPos);
                  if (ch != ' ') {
                     if (ch != ')') {
                        this.strLastError = StringHelper.Format("无法定位位置[%1$s]'('对应的')',出现了'%2$s'", nLastPos, ch);
                        return -1;
                     }
                     break label81;
                  }

                  if (nPos >= strSAVR.length()) {
                     this.strLastError = StringHelper.Format("无法定位位置[%1$s]'('对应的')'", nLastPos);
                     return -1;
                  }

                  nPos++;
               }
            case ')':
               return nPos;
            case ',':
               if (!StringHelper.IsNullOrEmpty(strLastPart)) {
                  childs.add(strLastPart);
                  strLastPart = "";
               }
               break;
            default:
               strLastPart = strLastPart + ch;
         }

         nPos++;
      }

      if (!StringHelper.IsNullOrEmpty(strLastPart)) {
         childs.add(strLastPart);
         strLastPart = "";
      }

      return nPos;
   }

   public String getLastError() {
      return this.strLastError;
   }
}
