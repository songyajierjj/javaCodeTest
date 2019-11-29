package com.gather;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class JavaGather {

    public static void main(String[] args) {
        Iterable iterable;
        //继承了iterable接口
        Collection conllection;

        //继承了Collection接口
        List list;
        Vector vector; //继承了AbstractList类，实现了List接口，每次扩容2呗，初始化一个长度为10的数组，线程安全的动态数组，随机访问
        Stack stack;//继承Vector类，线程安全的栈
        ArrayList arrayList;//继承了AbstractList类，实现了List接口，每次扩容原数组大小的一半,使用时再创建数组，线程不安全，随机访问
        LinkedList linkedList;//继承AbstractSequentialList类，实现List接口，迭代器访问
        ArrayQueue arrayQueue; //继承AbstractList

        Queue queue;
        Deque deque;//继承Queue,双端队列，其实现类可当成队列或栈使用
        ArrayDeque arrayDeque;//实现Deque


        Set set ;//接口
        AbstractSet AbstractSet;//实现set,类
        HashSet hashSet;//类，实现set
        LinkedHashSet linkedHashSet;//类，继承hashSet
        SortedSet sortedSet;//接口，继承set，有序集合
        NavigableSet NavigableSet;//接口，继承SortedSet
        TreeSet treeSet;//类，实现NavigableSet继承AbstractSet

        Map map;//接口
        AbstractMap AbstractMap;//类，实现map
        HashMap hashMap;//类，继承AbstractMap实现map
        SortedMap sortedMap;//接口，继承map
        NavigableMap NavigableMap;//接口，继承SortedMap
        TreeMap treeMap;//类，继承AbstractMap，实现NavigableMap
        LinkedHashMap linkedHashMap;//类，继承HashMap实现map
        Hashtable hashtable;//类，实现map

    }
}
