package com.whg.iSignature;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * <p>描述：可通过set252Log4j.jsp动态修改Constant.LOG_LEVEL的值来重新动态加载log4j配置</p>
 * <p>PS:在log4j.properties里面先设置为INFO是为了查看启动加载信息，然后在BootStrap里面再启用此类的init方法重新动态加载log4j配置</p>
 * @author whg
 * @date 2016-11-09 上午13:19:07
 */
public class Log4jProperties {
	
	private static final String LOG_LEVEL = "INFO";
	
	public static void init(){
		Properties pro = new Properties();
		
		//Global logging configuration
		pro.put("log4j.rootLogger", LOG_LEVEL+", stdout");

		pro.put("log4j.logger.com.skylinematrix", LOG_LEVEL);
		pro.put("log4j.logger.com.skylinematrix.crazyFarm.bo.battle", LOG_LEVEL);
		pro.put("log4j.logger.com.skylinematrix.keyvalue", "DEBUG");
		pro.put("log4j.logger.com.skylinematrix.exception.ExceptionHandler", "DEBUG");
		pro.put("log4j.logger.com.skylinematrix.crazyFarm.bo.audit.BlackList", "INFO");
		pro.put("log4j.logger.com.skylinematrix.crazyFarm.job", "INFO");

		pro.put("log4j.appender.empty", "org.apache.log4j.varia.NullAppender");

		//Standard Output
		pro.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		pro.put("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		pro.put("log4j.appender.stdout.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss,SSS}] [%5p] [%t] [%c{1}:%L] [%m]%n");

		//File Output
		pro.put("log4j.appender.fileout", "org.apache.log4j.RollingFileAppender");
		pro.put("log4j.appender.fileout.File", "${catalina.home}/logs/crazyFarm/fileout.log");
		pro.put("log4j.appender.fileout.MaxFileSize", "10000KB");
		pro.put("log4j.appender.fileout.layout", "org.apache.log4j.PatternLayout");
		pro.put("log4j.appender.fileout.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss,SSS}] [%5p] [%t] [%c{1}:%L] [%m]%n");

		PropertyConfigurator.configure(pro);
	}
	
}
