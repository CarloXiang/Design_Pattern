# Design_Pattern
设计模式学习。 
【不用理解设计模式是做什么用的，只需要用的时候能够想到它就行了，因为设计模式本质上仅仅是简化编码的技巧或者工具】

#### 1.简单工厂模式
简单工厂模式是类的**创建模式**，是由一个工厂类数据根据传入的参数决定创建哪一种产品的实例。
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png)

**简单工厂模式在java中的应用** 
<br/>java.text.DateFormat

**简单工厂模式的优缺点**
<br/>优点：
<br/>1) 模式的核心是工厂类，这个类含有必要的逻辑，可以决定在什么时候创建哪一个产品的实例，以达到分工明确
<br/>2) 客户端不再创建对象，而是把创建对象的职责交给了具体的工厂去创建
<br/>缺点：
<br/>1) 工厂的静态方法无法被继承
<br/>2) 代码维护不易，对象要是很多的话，工厂是一个很庞大的类
<br/>3) 这种模式对“开-闭”原则支持的不够，如果有新的产品加入到系统中就要修改工厂类 

#### 2.工厂方法模式
工厂方法模式去掉了简单工厂模式中工厂方法的静态属性，使得它可以被子类继承。这样在简单工厂模式里集中在工厂方法上的压力可以有工厂方法模式里不同的工厂子类来分担。

工厂方法模式使用继承自抽象工厂角色的多个子类来代替简单工厂模式中的“上帝类”。这样使得结构变得灵活起来--当有新产品产生时，只要按照抽象产品角色、抽象工厂角色提供的
合同生成，那么久可以被客户使用，而不必去修改任何已有的代码。可以看出工厂方法模式是符合开闭原则的！
<br/>
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png)

可以看出工厂方法的加入，使得对象的数量成倍增长。当产品种类非常多时，会出现大量的与之对应的工厂对象，这不是我们所希望的。因为如果不能避免这种情况，可以考虑使用简单工厂模式与工厂方法模式相结合的方式来减少工厂类：即对于产品树上类似的种类（一般是树的叶子中互为兄弟的）使用简单工厂模式来实现。

<br/>**简单工厂和工厂方法模式的比较**

工厂方法模式和简单工厂模式在定义上的不同是很明显的。工厂方法模式的核心是一个抽象工厂类,而不像简单工厂模式, 把核心放在一个实类上。工厂方法模式可以允许很多实的工厂类从抽象工厂类继承下来, 从而可以在实际上成为多个简单工厂模式的综合,从而推广了简单工厂模式。 
反过来讲,简单工厂模式是由工厂方法模式退化而来。设想如果我们非常确定一个系统只需要一个实的工厂类, 那么就不妨把抽象工厂类合并到实的工厂类中去。而这样一来,我们就退化到简单工厂模式了。

##### 抽象工厂模式
<pre>
<code>
//抽象工厂类
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
//具体工厂类，其中Food,Vehicle，Weapon是抽象类，
public class DefaultFactory extends AbstractFactory{
    @Override
    public Food createFood() {
        return new Apple();
    }
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
//测试类
public class Test {
    public static void main(String[] args) {
        AbstractFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.shoot();
        Food a = f.createFood();
        a.printName();
    }
}
</code>
</pre>

**在抽象工厂模式中，抽象产品 (AbstractProduct) 可能是一个或多个，从而构成一个或多个产品族(Product Family)。在只有一个产品族的情况下，抽象工厂模式实际上退化到工厂方法模式。**



#### 3.代理模式

1. 简介
代理模式(Proxy Pattern)是GoF 23种Java常用的设计模式之一。代理模式的定义：Provide a surrogate or placeholder for another object to control access to it(为其他对象
提供一种代理以控制对这个对象的访问)。使用代理模式创建代理对象，让代理对象控制目标对象的访问（目标对象可以是远程对象、创建开销大的对象或需要安全控制的对象），并且可以在不改变目标
对象的情况下添加一些额外的功能。
<br/>
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F.png)

<br/>
2. 模式中包含的角色及其职责
Subject: 抽象主题角色，抽象主题类可以是抽象类，也可以是接口，是一个最普通的业务类型定义，无特殊要求。
RealSubject：具体主题角色，也叫被委托角色、被代理角色。是业务逻辑的具体执行者。
Proxy：代理主题角色，也叫委托类、代理类。它把所有抽象主题定义的方法给具体主题角色实现，并且在具体主题角色处理完毕前后做预处理和善后工作。（最简单的比如打印日志。Spring的AOP就是用代理模式思想设计实现的）

<br/>
3.应用场景
现实世界中，秘书就相当于一个代理，老板开会，那么通知员工开会时间、布置会场、会后整理会场等等开会相关动作就可以交给秘书做，老板就只需要开会就行了，不需要亲自做那些事。
同理，在我们程序设计中也可使用代理模式来将由一系列组合在一起的代码进行解耦合，比如业务代码中的日志模块就可以在代理中进行。Spring的AOP就是典型的动态代理应用。

#### 4.动态代理模式
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F.png)
<br/>动态代理模式通过使用反射，可以在运行期决定加载哪个类，避免了一个类对应一个代理的问题；同时，通过统一的invoke方法，统一了代理类对原函数的处理过程，使用动态代理很大程度上减少了重复的代码，降低了维护的复杂性和成本。


#### 5.装饰器模式
装饰模式能够实现动态的为对象添加功能，是从一个对象外部来给对象添加功能。通常给对象添加功能，要么直接修改对象添加相应的功能，
要么派生对应的子类来扩展，抑或是使用对象组合的方式。显然，直接修改对应的类这种方式并不可取。
在面向对象的设计中，而我们也应该尽量使用对象组合，而不是对象继承来扩展和复用功能。装饰器模式就是基于对象组合的方式，
可以很灵活的给对象添加所需要的功能。装饰器模式的本质就是动态组合。动态是手段，组合才是目的。总之，装饰模式是通过把复杂的功能简单化，
分散化，然后再运行期间，根据需要来动态组合的这样一个模式。
<br/>
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E8%A3%85%E9%A5%B0%E5%99%A8%E6%A8%A1%E5%BC%8F.png)

#### 6.观察者模式
观察者模式(Observer)是对象的行为模式，又叫发布-订阅(Publish/Subscribe)模式、模型-视图(Model-View)模式、源-监听器(Source/Listener)模式或从属者(Dependents)模式。
观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
<br/>
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E8%A7%82%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F.png)

#### 7.装饰者模式
策略模式定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变化。
<br/>
**组成** <br/>
    -抽象策略角色：策略类，通常由一个接口或者抽象类实现。
    -具体策略角色：包装了相关算法和行为。
    -持有一个策略类的引用，最终给科幻端调用。
    
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F.png)

**优缺点** <br/>
优点：<br/>
1、策略没事提供了管理相关的算法族的办法。
2、策略模式提供了可以替换继承关系的办法。
3、使用策略模式可以避免使用多重条件转移语句。

缺点：<br/>
1、客户端必须知道所有的策略类，并且自行决定使用哪一个策略类。换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
2、策略模式造成很多的策略类，每个具体策略类都会产生一个新类。

#### 8.模板方法模式
模板方法模式是类的行为模式。准备一个抽象类，将部分逻辑以具体构造函数的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。不同的子类可以以不同的方式实现这些抽象方法，从而对剩余的逻辑有不同的实现。这就是模板方法模式的用意。
<br/>
![image](https://github.com/jasonli822/Design_Pattern/blob/master/diagrams%2F%E7%AE%80%E5%8D%95%E5%B7%A5%E5%8E%82%E6%A8%A1%E5%BC%8F.png)

模板方法在Servlet中的应用

使用过Servlet的人都清楚，除了要在web.xml做相应的配置外，还需继承一个叫HttpServlet的抽象类。HttpServlet提供了一个service()方法，这个方法调用七个do方法中的一个或几个，完成对客户端调用的响应。
这些do方法需要由HttpServlet的具体子类提供，因此这是典型的模板方法模式。下面是service()方法的源代码：
```java
protected void service(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

    String method = req.getMethod();

    if (method.equals(METHOD_GET)) {
        long lastModified = getLastModified(req);
        if (lastModified == -1) {
            // servlet doesn't support if-modified-since, no reason
            // to go through further expensive logic
            doGet(req, resp);
        } else {
            long ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
            if (ifModifiedSince < (lastModified / 1000 * 1000)) {
                // If the servlet mod time is later, call doGet()
                // Round down to the nearest second for a proper compare
                // A ifModifiedSince of -1 will always be less
                maybeSetLastModified(resp, lastModified);
                doGet(req, resp);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            }
        }

    } else if (method.equals(METHOD_HEAD)) {
        long lastModified = getLastModified(req);
        maybeSetLastModified(resp, lastModified);
        doHead(req, resp);

    } else if (method.equals(METHOD_POST)) {
        doPost(req, resp);

    } else if (method.equals(METHOD_PUT)) {
        doPut(req, resp);

    } else if (method.equals(METHOD_DELETE)) {
        doDelete(req, resp);

    } else if (method.equals(METHOD_OPTIONS)) {
        doOptions(req,resp);

    } else if (method.equals(METHOD_TRACE)) {
        doTrace(req,resp);

    } else {
        //
        // Note that this means NO servlet supports whatever
        // method was requested, anywhere on this server.
        //

        String errMsg = lStrings.getString("http.method_not_implemented");
        Object[] errArgs = new Object[1];
        errArgs[0] = method;
        errMsg = MessageFormat.format(errMsg, errArgs);

        resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
    }
}
```
当然，service()方法也可以被子类置换掉。
下面给出一个简单的Servlet例子：
```java
public class TestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("using the GET method");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("using the POST method");
    }

}
```
TestServlet继承HttpServlet，并且置换掉了父类的两个方法：doGet()和doPost()。

从上面的列子可以看出这是一个典型的模板方法模式。

HttpServlet担任抽象模板角色
    模板方法：由service()方法担任。
    基本方法：由doPost()、doGet()等方法担任。

TestServlet担任具体模板角色
    TestServlet置换了父类HttpServlet中七个基本方法中的其中两个，分别是doGet()和doPost()。
