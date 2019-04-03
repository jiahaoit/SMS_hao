package com.bao.utils;
import java.io.File;

import javax.servlet.jsp.jstl.core.Config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bao.model.JDBCInfo;


/**
 * 读取XML配置文件中的数据,返回一个已经封装好的JDBCInfo对象,用于链接数据库
 */
public class XmlConfigReader {
	SAXReader reader = new SAXReader();
	JDBCInfo info = new JDBCInfo();

	public XmlConfigReader() {
		try {
			//Document doc = reader.read(ClassLoader.getSystemResourceAsStream("config.xml"));// 不要用绝对路径
			// 用类装载器来读取文件,因为SRC目录所有文件和java类最终都会编译到classes或bin中
			Document doc = reader.read(getClass().getClassLoader().getResourceAsStream("config.xml"));
			Element root = doc.getRootElement();// 读根元素
			Element dbinfo = root.element("db-info");// 读子元素
			Element driverNameElt = dbinfo.element("drivername");
			Element urlElt = dbinfo.element("url");
			Element userNameElt = dbinfo.element("username");
			Element passwordElt = dbinfo.element("password");

			info.setDrivername(driverNameElt.getStringValue());
			info.setUrl(urlElt.getStringValue());
			info.setUsername(userNameElt.getStringValue());
			info.setPassword(passwordElt.getStringValue());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 此方法是用于返回一个已经读好XML元素的对象
	 * 
	 * @return
	 */
	public JDBCInfo getJdbcInfo() {
		return info;
	}
}

