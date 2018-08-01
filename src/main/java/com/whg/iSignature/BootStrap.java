package com.whg.iSignature;

import java.io.IOException;
import java.text.ParseException;

import org.dom4j.DocumentException;
import org.springframework.context.ApplicationContext;

/**
 * <p>后端业务逻辑静态初始化启动类,包括一些静态资源检测加载,定时任务等</p>
 * @author wanghg
 * @date 2017年3月31日 下午5:50:14
 */
public class BootStrap {
	
    private final ApplicationContext ac;

    private final String contextPath;

    public BootStrap(ApplicationContext ac, String contextPath) {
        this.ac = ac;
        this.contextPath = contextPath;
    }

    public void startServer() {
        try {
            loadStaticData();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
	private void loadStaticData() throws DocumentException, ParseException, IOException, ClassNotFoundException {
    	Log4jProperties.init();
    }

}
