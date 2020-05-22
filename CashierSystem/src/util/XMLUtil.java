package util;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;

/**
 * @author : kongyy
 * @time : 2020/5/20 21:48
 */

public class XMLUtil{

//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象

    public static Object getBean(){
        try {
            //创建DOM文档对象
            DocumentBuilderFactory  dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc ;
            doc = builder.parse(new File("CashierSystem.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getDisount(){
        try {
            //创建DOM文档对象
            DocumentBuilderFactory  dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc ;
            doc = builder.parse(new File("CashierSystem.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            String name = "";
            if(cName.equals("discount.VIPDiscount")){
                name = "VIP折扣";
            }
            else if(cName.equals("discount.StaffDiscount")){
                name = "员工折扣";
            }
            else if(cName.equals("discount.StudentDiscount")){
                name = "学生折扣";
            }
            return name;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}