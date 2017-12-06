### 项目背景

任何一个应用都需要后台管理系统。凡是后台系统又都涉及到认证与授权，必然也会经历用户角色权限这三步曲，当然也会经历重复但极其繁锁的页面设计，还希望页面能高大上点......

软件开发从来就没有银弹，很多人都想着设计一枚银弹，结果发现造出来的东西要么华而不实，要么技术框架落后不够现代化，要么不是主流技术，总之，我是很想找到一个已有的产品直接使用，但是真的没有找到一个符合我心意的。最终决定从头开始，重新做一个自己认为能够真正解决大部分人需求的最小通用后台管理系统，这便是admin-manage产生的初衷。

### 主要特点

1.全现代化web应用

基于adminlte的页面模板，响应式布局，不低俗的ui，内嵌服务器，打成jar包即可运行。

2.基于最主流最新的技术框架，满足绝大多数人的技术选型需求。

首选spring 技术栈。spring boot ，spring security 作为核心技术框架，spring session 会话管理，spring cache缓存管理，thymeleaf作为模板引擎。使用最主流的技术使前后端技术维护更容易，想怎样改就怎样改。模型设计理念参考ddd。

3.坚持实用性第一，只保留最小后台管理系统内核功能。

只提供后台管理系统最基本的认证，授权，用户与角色及最基本常用的系统管理功能。无任何强制约束，无任何深奥设计，简单直白。期望作为一个后台管理内核嵌入你的后台应用，让你无论做什么应用的后台系统，能真正的只关注对业务的管理。

### 权限控制设计简述

依然使用用户>角色>权限模型。一个用户具有多个角色，任意一个角色具备权限即可通过。对于权限，从实用性的角度，只设计了针对url访问的权限，支持ant风格的通配符。

在admin-manage中，权限是指需要保护的url，需要配置到权限仓储中才会保护此url，否则任何认证了的用户都能访问此url。这样设计的意图也是简化管理admin-manage本身，避免一些不需要保护的资源为了能正常访问而需要配置成权限。

同时，借鉴linux的root帐户机制，内置一个固定名称为root的帐户作为超级管理员，方便日常开发调试，方便站点真正的管理员。

实现方式只是在spring security 过滤器链中插入了一个自定义过滤器，加载仓储中的用户角色及权限信息，拦截url，实现访问控制。

### 本地运行

项目基于idea和gradle环境，仓储目前是mysql。源码中有mysql脚本。系统全部配置在application-default.yml，执行完数据库脚本,修改相应数据源配置，直接运行Application.java即可，相信只要搞过java熟悉过springboot的都能运行起来，没什么技术含量。正常启动后浏览器打开

