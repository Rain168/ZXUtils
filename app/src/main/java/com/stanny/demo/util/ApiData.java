package com.stanny.demo.util;

import com.zx.zxutils.http.ZXApiParams;
import com.zx.zxutils.http.ZXBaseResult;
import com.zx.zxutils.http.ZXHttpApi;
import com.zx.zxutils.util.ZXMD5Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Xiangb on 2017/5/25.
 * 功能：
 */

public class ApiData extends ZXHttpApi {

    /**
     * 构造
     *
     * @param apiType
     */
    public ApiData(int apiType) {
        super(apiType);
    }


    @Override
    public ZXApiParams getHttpParams(int apiType, Object... infos) {
        params.clearParam();
        switch (apiType) {
            case 0:
                params.setApiUrl("http://192.168.110.238:7070/GAMarketSupervise/GaClientService.do");
                params.setApiMethod(HTTP_MOTHOD.POST);
                params.addParam("method", infos[0]);
                params.addParam("loginname", "admin");
                params.addParam("passwd", ZXMD5Util.getMD5(ZXMD5Util.getMD5("admin")));
                params.addParam("source", "chongqingzxgs_mobile");
                break;
            case 1:
                params.setApiUrl("http://192.168.110.238:7070/GAMarketSupervise/GaClientService.do");
                params.setApiMethod(HTTP_MOTHOD.GET);
                params.addParam("method", infos[0]);
                params.addParam("loginname", "admin");
                params.addParam("passwd", ZXMD5Util.getMD5(ZXMD5Util.getMD5("admin")));
                params.addParam("source", "chongqingzxgs_mobile");
                break;
            case 2:
                params.setApiUrl("http://192.168.110.238:7070/GAMarketSupervise/eventfileUpload");
                params.setApiMethod(HTTP_MOTHOD.UPLOAD);
                params.addParam("image", infos[0]);
//                params.addFileMap((Map<String, File>) infos[1]);
//                params.addDataMap((Map<String, String>) infos[2]);
                break;
            case 3:
                params.setApiUrl("http://192.168.110.238:7070/upload/GAMarketMobile/Android/GAMarketMobile.apk");
                params.setApiMethod(HTTP_MOTHOD.DOWNLOAD);
                params.setSavePath(infos[0]);
                params.setAutoRename(infos[1]);
                break;
            case 4:
                params.setApiUrl("http://zhsq.digitalcq.com/tlghdw/api_v1.do");
                params.setApiMethod(HTTP_MOTHOD.POST);
                params.addParam("method", "allVisitlog");
                params.addParam("visitdata", "[{\"FileID\":\"userLogin\",\"FileName\":\"%E7%99%BB%E5%BD%95\",\"readTimes\":3,\"soft_version\":\"1.0.0\",\"sys_version\":\"7.0\"}]");
                params.addParam("e", "bdc4645043f6846a0cefffd8791cecf2");
                params.addParam("code", "ba0ad332d01f59b69c939b62cafe057e");
                params.addParam("os", "android_phone");
                break;
            default:
                break;
        }
        return params;
    }

    @Override
    public ZXBaseResult getHttpResult(int apiType, String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        switch (apiType) {
            case 1:
                response = jsonObject.getString("data");
                result.setEntry(response);
                break;
            case 0:
                response = jsonObject.getString("data");
                result.setEntry(response);
                break;
            default:
                break;
        }
        return result;
    }
}
