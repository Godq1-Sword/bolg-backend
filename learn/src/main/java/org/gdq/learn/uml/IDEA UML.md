# IDEA UML

UML(Unified Model Language,UML)是用来设计软件蓝图的可视化建模语言,1997 年被国际对象管理组织(OMG)采纳为面向对象的建模语言的国际标准它的特点是简单、统一、图形化、能表达软件设计中的动态与静态信息

本文主要介绍关于IDEA类图和类与接口之间的关系

## 类、接口和类图

ctrl+shit+alt+u 打开uml页面

- ![idea_umlstatus](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_umlstatus.png)
- **访问修饰符：**
  1. ![idea_public](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_public.png) : public
  2. ![idea_protected](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_protected.png) : protected
  3. ![idea_default](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_default.png) : default
  4. ![idea_private](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_private.png) : private
- **final修饰符：**![idea_final](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_final.png)

- **static修饰符：**![idea_static](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_static.png)

- **abstract修饰符**
  1. 抽象类 ：![idea_absclass](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_absclass.png)
  2. 抽象方法 ：![idea_absmethod](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/idea_absmethod.png)

### 1. 类

含有一定方法/属性的集合体

![uml_exampleclass](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_exampleclass.png)

### 2. 接口

需要类实现的一些方法/属性的结构体

![uml_iexample](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_iexample.png)



### 3. 类图

描述类、接口之间的静态结构和关系

![uml_examplegraph](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_examplegraph-1588132189668.png)

## 类之间的关系

在软件系统中,类不是孤立存在的,类与类之间存在各种关系根据类与类之间的耦合度从弱到强排列,UML 中的类图有以下几种关系：依赖关系、关联关系、聚合关系、组合关系、泛化关系和实现关系,其中泛化和实现的耦合度最高

### 1.依赖关系

**虚线箭头**

依赖(Dependency)关系是一种使用关系(调用),耦合度最低

![uml_exampledep](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_exampledep.png)

### 2.关联/聚合/组合关系

**黑色实线菱形箭头**

关联(Association)关系是对象之间的一种引用关系,可以相互关联,例如我和我的朋友

聚合(Aggregation)是关联关系的一种,是强关联关系,是整体和部分之间的关系,例如公司和员工

组合(Composition)是关联关系的一种,强烈的聚合关系,是整体和部分之间的关系,且不可分割,例如身体和四肢

![uml_exampleass](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_exampleass.png)

### 3.泛化关系

**黑色实线箭头**

泛化(Generalization)关系是对象之间耦合度最大的一种关系,表示继承关系 

![uml_exampleext](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_exampleext.png)

### 4.实现关系

**绿色虚线箭头**

实现(Realization)关系是接口与实现类之间的关系 

![uml_exampleimp](https://raw.githubusercontent.com/Godq1-Sword/bolg/bolg-backend/image/uml_exampleimp.png)