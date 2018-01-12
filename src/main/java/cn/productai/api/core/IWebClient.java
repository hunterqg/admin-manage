package cn.productai.api.core;

import cn.productai.api.core.base.BaseRequest;
import cn.productai.api.core.base.BaseResponse;

import java.nio.charset.Charset;

/**
 * Created by Thinkpad on 2017/7/3.
 *
 */
public interface IWebClient {
    void setHost(String host);
    String getHost();

    void setEncoding(Charset charset);
    Charset getEncoding();

    void setProfile(IProfile profile);
    IProfile getProfile();

    <T extends BaseResponse> T getResponse(BaseRequest<T> request) throws Exception ;
}
