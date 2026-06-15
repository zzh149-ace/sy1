# 九九乘法表 Servlet 项目（sy1）

## 项目简介
本项目演示如何使用 HttpServlet 来处理 HTTP 的 GET 和 POST 请求，通过重写 `doGet()` 和 `doPost()` 方法来生成和显示九九乘法表。

## 项目结构
```
sy1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/servlet/
│   │   │       └── ServletDemo1.java
│   │   └── webapp/
│   │       ├── multiTable.html
│   │       └── WEB-INF/
│   │           └── web.xml
├── pom.xml
└── README.md
```

## 技术栈
- Java 8
- Servlet 4.0
- Maven
- Tomcat 8+

## 主要文件说明

### ServletDemo1.java
- 继承 `HttpServlet` 类
- 使用 `@WebServlet` 注解配置路由为 `/ServletDemo1`
- 重写 `doGet()` 方法处理 GET 请求
- 重写 `doPost()` 方法处理 POST 请求
- 两个方法都调用 `printMultiplicationTable()` 方法生成九九乘法表

### multiTable.html
- 提供用户界面
- 包含两个表单：
  - 第一个表单使用 GET 方式提交
  - 第二个表单使用 POST 方式提交

## 编译和部署步骤

### 1. 编译项目
```bash
mvn clean package
```

### 2. 部署到 Tomcat
将生成的 `sy1.war` 文件复制到 Tomcat 的 `webapps` 目录：
```bash
cp target/sy1.war $TOMCAT_HOME/webapps/
```

### 3. 启动 Tomcat
```bash
cd $TOMCAT_HOME/bin
./startup.sh  # Linux/Mac
# 或
startup.bat   # Windows
```

### 4. 访问应用
在浏览器中输入：
```
http://localhost:8080/sy1/multiTable.html
```

## 使用方法

1. 打开 `multiTable.html` 页面
2. 点击 "GET 提交" 按钮，使用 GET 方式提交表单
3. 点击 "POST 提交" 按钮，使用 POST 方式提交表单
4. 服务器会显示九九乘法表

## 学习要点

1. **HttpServlet 的核心方法**
   - `doGet()`: 处理 GET 请求
   - `doPost()`: 处理 POST 请求
   - `service()`: 自动路由请求到相应方法

2. **请求和响应对象**
   - `HttpServletRequest`: 获取请求信息
   - `HttpServletResponse`: 生成响应结果

3. **注解方式配置路由**
   - `@WebServlet`: 配置 Servlet 的访问路径

4. **字符编码处理**
   - 设置 `Content-Type` 为 `text/html;charset=UTF-8` 确保中文显示正确

## 预期输出

点击按钮后，浏览器会显示如下格式的九九乘法表：

```
get 提交方式 (或 post 提交方式)
1*1=1
1*2=2 2*2=4
1*3=3 2*3=6 3*3=9
... 以此类推
```

## 许可证
MIT