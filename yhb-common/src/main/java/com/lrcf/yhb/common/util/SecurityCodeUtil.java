package com.lrcf.yhb.common.util;

import com.alibaba.fastjson.JSON;
import com.lrcf.yhb.common.config.BaseConstants;
import com.lrcf.yhb.common.redis.RedisUtil;
import com.lrcf.yhb.common.redis.pojo.User;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 
* @ClassName: SecurityCodeUtil.java
* @Description:生成各种图形验证码的工具类
* @version: v1.0.0
* @author: YJ
 */
public class SecurityCodeUtil {
	private static Random random = new Random();
	private static String randString = "0123456789";// 随机产生数字 
    private static int width = 78;// 图片宽  
    private static int height = 32;// 图片高  
    private static int lineSize = 180;// 干扰线数量
    private static String randFH="+x-";  
    private String randZF="岚儒金服";//随机数字 
    private static int stringNum = 2;// 随机产生字符数量  

	
	public static String getTowCalcPic(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		String timesTamp = request.getParameter("timesTamp");//时间戳
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类  
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);  
        Graphics2D g = (Graphics2D) image.getGraphics();// 产生Image对象的Graphics对象,修改对象可以在图像上进行各种绘制操作  
        g.fillRect(0, 0, width, height);  //填充指定的矩形。int x,int y,int width,int height.x - 要填充矩形的 x 坐标。 y - 要填充矩形的 y 坐标。width - 要填充矩形的宽度。height - 要填充矩形的高度。
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));  //设置绘制字体
        g.setColor(getRandColor(110, 133)); //设置绘制颜色
        // 绘制干扰线  
        for (int i = 0; i <= lineSize; i++) {  
            drowLine(g);  
        } 
        // 绘制随机字符  
        String randomString = "";  
        for (int i = 1; i <= stringNum; i++) {  
            randomString = drowString(g, randomString, i);  
        }   
        //解析绘制图形的字符串并计算结果值
        char [] stringArr = randomString.toCharArray();  
        if(stringArr[1]=='+'){  
            randomString=String.valueOf(Integer.parseInt(String.valueOf(stringArr[0]))+Integer.parseInt(String.valueOf(stringArr[2])));   
        }else if(stringArr[1]=='-'){  
            randomString=String.valueOf(Integer.parseInt(String.valueOf(stringArr[0]))-Integer.parseInt(String.valueOf(stringArr[2])));    
        }else if(stringArr[1]=='x'){  
            randomString=String.valueOf(Integer.parseInt(String.valueOf(stringArr[0]))*Integer.parseInt(String.valueOf(stringArr[2])));   
        } 
        g.dispose();  //释放此图形的上下文以及它使用的所有系统资源 释放以后将不能使用g
        RedisUtil.set(BaseConstants.RANDOM_CODE_KEY + ":" + timesTamp, randomString ,BaseConstants.RANDOM_EXPIRE_TIME);
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        
        
        try {  
        	
            ImageIO.write(image, "JPEG", jpegOutputStream);
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        byte[] captchaChallengeAsJpeg   = jpegOutputStream.toByteArray();
		ServletOutputStream responseOutputStream = response.getOutputStream();//获取输出流
		responseOutputStream.write(captchaChallengeAsJpeg);//输出流
		responseOutputStream.flush();
		responseOutputStream.close();
        
		return randomString;
		
	}

	
	
	/**
	 * 绘制计算算子，并返回 用于后端程序解析计算
	 */
    private static String drowString(Graphics2D g, String randomString, int i) {  
    	g.setFont(getFont());  
    	g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
    	// 设置字体旋转角度
    	int degree = new Random().nextInt() % 30;
    	int x = 5;
    	// 正向角度
    	g.rotate(degree * Math.PI / 180, x, 20);
    	g.drawString(randomString, x, 20);
    	// 反向角度
    	g.rotate(-degree * Math.PI / 180, x, 20);
    	String rand1 = String.valueOf(getRandomString(random.nextInt(randString.length())));  
    	String rand2 = String.valueOf(getRandomString(random.nextInt(randString.length())));  
    	String rand3 = String.valueOf(getRandomStringFH(random.nextInt(randFH.length())));  
    	randomString += rand1+rand3+rand2+"=?";  
    	/* g.translate(random.nextInt(2), random.nextInt(2));  */
    	/*   g.drawString(randomString, 13 * i, 24);  */
    	return randomString;  
    }
    
    /** 
     * 绘制干扰线 
     */  
    private static void drowLine(Graphics g) {  
        int x = random.nextInt(width);  
        int y = random.nextInt(height);  
        int xl = random.nextInt(13);  
        int yl = random.nextInt(13);  
        // 设置边框颜色
      //  g.setColor(Color.black);
        // 边框区域
        
        /*g.drawRect(0, 0, WIDTH - 2, HEIGHT - 2);*/
        g.drawLine(x, y, x + xl, y + yl - 1);  
    }  
  
    /** 
     * 获取随机的字符 
     */  
    public static String getRandomString(int num) {  
        return String.valueOf(randString.charAt(num));  
    }  
      
    /**
     * 获取随机的运算符号 
     */  
    public static String getRandomStringFH(int num) {  
    	return String.valueOf(randFH.charAt(num));  
    }
    /**
     * 获得字体 
     */  
    private static Font getFont() {  
    	return new Font("Fixedsys", Font.CENTER_BASELINE, 18);  
    }  
    /**
     * 获得颜色 
     */  
    private static Color getRandColor(int fc, int bc) {  
    	if (fc > 255)  
    		fc = 255;  
    	if (bc > 255)  
    		bc = 255;  
    	int r = fc + random.nextInt(bc - fc - 16);//110+7  
    	int g = fc + random.nextInt(bc - fc - 14);//110+9  
    	int b = fc + random.nextInt(bc - fc - 18);//110+5  
    	return new Color(r, g, b);  
    }  
    
    /* 
     * 获取随机的汉字 
     */  
    public String getRandomString2(int num) {  
        return String.valueOf(randZF.charAt(num));  
    }  
}
