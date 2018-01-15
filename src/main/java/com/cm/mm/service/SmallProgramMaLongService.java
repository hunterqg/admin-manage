package com.cm.mm.service;

import cn.productai.api.core.DefaultProductAIClient;
import cn.productai.api.core.DefaultProfile;
import cn.productai.api.core.IProfile;
import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import cn.productai.api.core.enums.ServiceType;
import cn.productai.api.core.exceptions.ClientException;
import cn.productai.api.pai.entity.classify.ClassifyByImageUrlRequest;
import cn.productai.api.pai.entity.classify.ClassifyResponse;
import cn.productai.api.pai.response.ClassifyResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cm.mm.dao.SmallProgramMaLongDao;
import com.cm.mm.model.SmallProgramMaLong;
import com.cm.mm.model.SmallProgramUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * Created by qingao on 2018/1/9.
 */
@Service
public class SmallProgramMaLongService {

    @Value("${spring.application.malong.access-key-id}")
    private String accessKeyId;
    @Value("${spring.application.malong.access-key-secret}")
    private String accessKeySecret;

    private Logger logger = LoggerFactory.getLogger(SmallProgramMaLongService.class);
    @Autowired
    private SmallProgramMaLongDao dao;

    public SmallProgramMaLong getMaLong(String url) {
        String md5 = DigestUtils.md5DigestAsHex(url.getBytes());
        logger.debug(String.format("%s -- %s",md5,url));
        SmallProgramMaLong maLong = dao.getSpMaLong(md5);

        if(maLong == null || StringUtils.isEmpty(maLong)) {
            String jsonStr = callApi(url);
            JSONObject json = JSON.parseObject(jsonStr);
            JSONArray labels = json.getJSONArray("labels");
            if(maLong == null) {
                maLong = new SmallProgramMaLong();
                maLong.setProp1(labels.toString());
                maLong.setUrl(url);
                maLong.setMd5(md5);
                dao.insertSmallProgramMaLong(maLong);
            }else{
                maLong.setProp1(labels.toString());
                dao.updateSmallProgramMaLong(maLong);
            }
            return maLong;
        }else {

            return dao.getSpMaLong(md5);
        }
    }


    private String callApi(String url) {
        IProfile profile = new DefaultProfile();
//        profile.setAccessKeyId("363c58349cd46cecff19ccb87eb50e85");
//        profile.setSecretKey("aae908114bd413dca68bb751e3654870");
        profile.setAccessKeyId(accessKeyId);
        profile.setSecretKey(accessKeySecret);
        profile.setVersion("1");
        profile.setGlobalLanguage(LanguageType.Chinese);

        IWebClient client = new DefaultProductAIClient(profile);
        ClassifyByImageUrlRequest request = new ClassifyByImageUrlRequest(ServiceType.Classify, "_0000111");
        request.setUrl(url);
        request.setLanguage(LanguageType.Chinese);

        // you can pass the extra paras to the request
        request.getOptions().put("para1", "1");
        request.getOptions().put("para2", "中文");
        request.getOptions().put("para3", "value3");

        try {
            ClassifyResponse response = client.getResponse(request);

            logger.debug("==============================Result==============================");
            String jsonStr = response.getResponseJsonString();
            logger.debug(JSON.parseObject(jsonStr).toString());
            logger.debug("==============================Result==============================");
            return jsonStr;
        } catch (cn.productai.api.core.exceptions.ServerException e) {
            logger.error(String.format("ServerException occurred. ErrorCode: %s \r\n ErrorMessage: %s",
                    e.getErrorCode(),
                    e.getErrorMessage()));
            e.printStackTrace();
            return null;

        } catch (ClientException e) {
            logger.error(String.format("ClientException occurred. ErrorCode: %s \r\n ErrorMessage: %s \r\n RequestId: %s",
                    e.getErrorCode(),
                    e.getErrorMessage(),
                    e.getRequestId()));
            e.printStackTrace();
            return null;

        } catch (Exception e) {
            logger.error(String.format("%s occurred. ErrorMessage: %s", e.getClass().getName(), e.getMessage()));
            e.printStackTrace();
            return null;
        }
    }
}
