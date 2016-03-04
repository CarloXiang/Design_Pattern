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