package cn.productai.api.examples;

import cn.productai.api.core.DefaultProductAIClient;
import cn.productai.api.core.DefaultProfile;
import cn.productai.api.core.IProfile;
import cn.productai.api.core.IWebClient;
import cn.productai.api.core.enums.LanguageType;
import cn.productai.api.core.enums.ServiceType;
import cn.productai.api.core.exceptions.ClientException;
import cn.productai.api.pai.entity.classify.ClassifyByImageFileRequest;
import cn.productai.api.pai.entity.classify.ClassifyResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Zhong Wang on 2017/7/5.
 * 场景分析与标注
 * https://api-doc.productai.cn/doc/pai.html#场景分析与标注
 */
public class ClassifyByFile {

    public void run(IWebClient client, File file) {


        ClassifyByImageFileRequest request = new ClassifyByImageFileRequest(ServiceType.Classify, "_0000159");
        request.setImageFile(file);
        request.setLanguage(LanguageType.Chinese);

        // you can pass the extra paras to the request
        request.getOptions().put("para1", "1");
        request.getOptions().put("para2", "中文");
        request.getOptions().put("para3", "value3");

        try {
            ClassifyResponse response = client.getResponse(request);
            String jsonStr = response.getResponseJsonString();
            JSONObject json = JSON.parseObject(jsonStr);
            json.put("fname",file.getName());
            System.out.println(json.toString());
/*
            System.out.println("==============================Result==============================");

            for (ClassifyResult r : response.getResults()) {
                // access the response directly
                System.out.println(String.format("%s - %s", r.getCategory(), r.getScore()));
            }

            System.out.println("==============================Result==============================");
*/
        } catch (cn.productai.api.core.exceptions.ServerException e) {
            System.out.println(String.format("ServerException occurred. ErrorCode: %s \r\n ErrorMessage: %s",
                    e.getErrorCode(),
                    e.getErrorMessage()));
            e.printStackTrace();

        } catch (ClientException e) {
            System.out.println(String.format("ClientException occurred. ErrorCode: %s \r\n ErrorMessage: %s \r\n RequestId: %s",
                    e.getErrorCode(),
                    e.getErrorMessage(),
                    e.getRequestId()));
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println(String.format("%s occurred. ErrorMessage: %s", e.getClass().getName(), e.getMessage()));
            e.printStackTrace();
        }
    }


    public static void main(String [] args) {

        IProfile profile = new DefaultProfile();
        profile.setAccessKeyId("363c58349cd46cecff19ccb87eb50e85");
        profile.setSecretKey("aae908114bd413dca68bb751e3654870");
        profile.setVersion("1");
        profile.setGlobalLanguage(LanguageType.Chinese);

        IWebClient client = new DefaultProductAIClient(profile);

        ClassifyByFile classifyByFile = new ClassifyByFile();
        File imageFloder = new File("/home/qingao/download/MMirror/segment");
        File [] files = imageFloder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {

                if(f.isFile()) {
                    String fileName = f.getName();
                    int dotIndex = fileName.lastIndexOf('.');
                    String suffix = null;
                    if(dotIndex > 0) {
                        suffix = fileName.substring(dotIndex+1,fileName.length());
                    }
                    if(suffix != null && suffix.equalsIgnoreCase("jpg")) {
                        return true;
                    }else{
                        return false;
                    }

                }else {
                    return false;
                }
            }
        });
        System.out.println("==>  通用图片内容分析与标注  <==");
        System.out.println("See https://api-doc.productai.cn/doc/pai.html#通用图片内容分析与标注 for details.\r\n");
        int index = 0;
        for(File f : files) {
            classifyByFile.run(client,f);
            index++;
//            if(index>200) {
//                break;
//            }
        }

    }
}
