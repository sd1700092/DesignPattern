package com.imooc.jdkproxy.sourcecode;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy {
  public static Object newProxyInstance(Class intfce, InvocationHandler h) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//    String rt = "\r\n";
    StringBuilder methodStr= new StringBuilder();
    for (Method m : intfce.getMethods()) {
      methodStr.append("  @Override\n"
          + "  public void " + m.getName() +"() {\n"
          + "try{\n"
          + "Method md = " + intfce.getName() + ".class.getMethod(\"" + m.getName() + "\");\n"
          + "h.invoke(this, md);"
          + "} catch(Exception e){"
          + " e.printStackTrace();"
          + "}"
          + "  }\n"
          );
    }
    String str = "package com.imooc.jdkproxy;\n" +
        "import java.lang.reflect.Method;\n" +
        "import com.imooc.jdkproxy.sourcecode.InvocationHandler;\n" +
        "\n" +
        "public class $Proxy0 implements " + intfce.getName() + " {\n" +
        "  private InvocationHandler h;\n" +
        "  \n" +
        "  public $Proxy0(InvocationHandler h) {\n" +
        "    this.h = h;\n" +
        "  }\n" +
        "  \n" +
        methodStr.toString() + "\n" +
        "}\n";
  
    //产生代理类的java文件
    String fileName = System.getProperty("user.dir") + "\\src\\main\\java\\com\\imooc\\jdkproxy\\$Proxy0.java";
//    System.out.println(fileName);
    File file = new File(fileName);
    FileUtils.writeStringToFile(file, str);
  
    //编译
    //拿到编译器
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    //文件管理者
    StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
    //获取文件
    Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(fileName);
    //编译任务
    JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
    //进行编译
    t.call();
    fileMgr.close();
    
    //把生成好的编译文件load到内存中 记得前提是class文件生成是正常的。
    ClassLoader cl = ClassLoader.getSystemClassLoader();
    Class c = cl.loadClass("com.imooc.jdkproxy.$Proxy0");
    
    Constructor ctr = c.getConstructor(InvocationHandler.class);
    System.out.println(c.getName());
    return ctr.newInstance(h);
  }
}
