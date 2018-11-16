#### 参考：https://blog.csdn.net/ahou2468/article/details/79015251
1. 启动WEB项目的时候，容器首先会去它的配置文件web.xml读取两个节点:  \<listener>\</listener>和\<context-param>\</context-param>。

2. 紧接着，容器创建一个ServletContext（application），这个WEB项目所有部分都将共享这个上下文。

3. 容器以<context-param></context-param>的name作为键，value作为值，将其转化为键值对，存入ServletContext。

4. 容器创建<listener></listener>中的类实例，根据配置的class类路径<listener-class>来创建监听，在监听中会有contextInitialized(ServletContextEvent args)初始化方法，
    启动Web应用时，系统调用Listener的该方法，在这个方法中获得：ServletContextapplication=ServletContextEvent.getServletContext();context-param的值就是application.getInitParameter("context-param的键");得到这个context-param的值之后，你就可以做一些操作了。

5. 举例：你可能想在项目启动之前就打开数据库，那么这里就可以在<context-param>中设置数据库的连接方式（驱动、url、user、password），在监听类中初始化数据库的连接。这个监听是自己写的一个类，除了初始化方法，它还有销毁方法，用于关闭应用前释放资源。比如:说数据库连接的关闭，此时，调用contextDestroyed(ServletContextEvent args)，关闭Web应用时，系统调用Listener的该方法。

6. 接着，容器会读取<filter></filter>，根据指定的类路径来实例化过滤器。

7. 以上都是在WEB项目还没有完全启动起来的时候就已经完成了的工作。如果系统中有Servlet，则Servlet是在第一次发起请求的时候被实例化的，而且一般不会被容器销毁，它可以服务于多个用户的请求。所以，Servlet的初始化都要比上面提到的那几个要迟。

8. **总的来说，web.xml的加载顺序是:\<context-param> -> \<listener> -> \<filter> -> \<servlet>。其中，如果web.xml中出现了相同的元素，则按照在配置文件中出现的先后顺序来加载。**

9. 对于某类元素而言，与它们出现的顺序是有关的。以<filter>为例，web.xml中当然可以定义多个<filter>，与<filter>相关的一个元素是<filter-mapping>，注意，对于拥有相同<filter-name>的<filter>和<filter-mapping>元素而言，<filter-mapping>必须出现在<filter>之后，否则当解析到<filter-mapping>时，它所对应的<filter-name>还未定义。web容器启动初始化每个<filter>时，按照<filter>出现的顺序来初始化的，当请求资源匹配多个<filter-mapping>时，<filter>拦截资源是按照<filter-mapping>元素出现的顺序来依次调用doFilter()方法的。<servlet>同<filter>类似，此处不再赘述。

## web.xml标签详解

* 1、<web-app></web-app> 部署描述符的根元素
* 2、<display-name></display-name> 定义了web应用的名称
* 3、\<distributable/> 可以使用distributable元素来告诉servlet/JSP容器，Web容器中部署的应用程序适合在分布式环境下运行。
* 4、<context-param></context-param> 上下文初始化参数
* 5、<session-config></session-config> 用于设置容器的session参数，比如：<session-timeout> 用于指定http session的失效时间。
* 6、<listener></listener> 为web应用程序定义监听器，监听器用来监听各种事件，比如：application和session事件，所有的监听器按照相同的方式定义，功能取决去它们各自实现的接口
* 7、<filter></filter> 使用Filter的完整流程是：Filter对用户请求进行预处理，接着将请求HttpServletRequest交给Servlet进行处理并生成响应，最后Filter再对服务器响应HttpServletResponse进行后处理。Filter与Servlet具有完全相同的生命周期，且Filter也可以通过<init-param>来配置初始化参数
* 8、\<servlet>\</servlet> Servlet通常称为服务器端小程序，是运行在服务器端的程序，用于处理及响应客户的请求。Servlet是个特殊的java类，继承于HttpServlet。客户端通常只有GET和POST两种请求方式，Servlet为了响应则两种请求，必须重写doGet()和doPost()方法。大部分时候，Servlet对于所有的请求响应都是完全一样的，此时只需要重写service()方法即可响应客户端的所有请求。
