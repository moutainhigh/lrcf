package com.lrcf.yhb.common.config;


import com.lrcf.yhb.common.util.HttpClientHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WebClient {

	/**
	 * 通过get来访问url
	 * 
	 * @param src
	 *            需要访问的url
	 * @return
	 * @throws Exception
	 */
	public String doGet(String src) throws Exception {
		return doGet(src, "utf-8");
	}

	/**
	 * 通过get来访问url
	 * 
	 * @param src
	 *            需要访问的地址
	 * @param outputencode
	 *            获取输出时的编码
	 * @return
	 * @throws Exception
	 */
	public String doGet(String src, String outputencode)
			throws Exception {
		return doGet(src, outputencode, null);
	}

	/**
	 * 通过get来访问url
	 * 
	 * @param src
	 *            需要访问的地址
	 * @param outputencode
	 *            获取输出时的编码
	 * @param headers
	 *            需要添加的访问头信息
	 * @return
	 * @throws Exception
	 */
	public String doGet(String src, String outputencode,
			HashMap<String, String> headers) throws Exception {
		StringBuffer result = new StringBuffer();
		URL url = new URL(src);
		URLConnection connection = url.openConnection();
		BufferedReader in = null;
		try {
			if (headers != null) {
				Iterator<String> iterators = headers.keySet().iterator();
				while (iterators.hasNext()) {
					String key = iterators.next();
					connection.setRequestProperty(key, headers.get(key));
				}
			}
			connection.connect();
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), outputencode));
			String line;
			while ((line = in.readLine()) != null) {
				result.append("\n" + line);
			}
			return result.toString();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (in != null) {
				in.close();
			}
		}

	}
	/**
	 * 通过Post来访问URl  http协议提交数据
	 * @param urlStr
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPostFY(String urlStr,Map<String, String> params) throws Exception{
    	String responseString="";
    	PostMethod xmlpost;
 	    int statusCode = 0;
 	    HttpClient httpclient = new HttpClient();
// 	    httpclient.setConnectionTimeout(new Integer(timeOut).intValue());
 	    xmlpost = new PostMethod(urlStr);
 	    //创建数据列表   序列 +100
 	    httpclient.getParams().setParameter(
 	    		HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        try{
        	//组合请求参数
			List<NameValuePair> nvps = HttpClientHandler.buildNameValuePair(params);
        	xmlpost.setRequestBody((NameValuePair[]) nvps.toArray(new NameValuePair[nvps.size()])); 
        	statusCode = httpclient.executeMethod(xmlpost);
	    	responseString = xmlpost.getResponseBodyAsString();
            if(statusCode<HttpURLConnection.HTTP_OK || statusCode>=HttpURLConnection.HTTP_MULT_CHOICE){
                System.err.println("失败返回码[" + statusCode + "]");
                throw new Exception("请求接口失败，失败码[ "+ statusCode +" ]");
            }
        }catch(IOException e){
            e.printStackTrace();
            System.err.println(e.toString());
            throw e;
        }
        return responseString;
    }
}
