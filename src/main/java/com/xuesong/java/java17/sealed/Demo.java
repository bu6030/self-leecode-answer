package com.xuesong.java.java17.sealed;

/**
 * JAVA17 新增密封类，通过 sealed 关键字标识
 * permits 允许继承的子类
 */
public sealed class Demo
permits Child, NoSealedChild {

}
