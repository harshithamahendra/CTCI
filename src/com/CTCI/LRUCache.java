package com.CTCI;
import java.io.*;
import java.util.*;
public class LRUCache {
	LinkedHashMap<Integer,Integer> cache;
	int size;
	LRUCache(int capacity){
		this.size = capacity;
		cache = new LinkedHashMap<Integer,Integer>(capacity){
			protected boolean removeEldestEntry(Map.Entry eldest) {
	            return size() > size;
	         }
		};
	}
	
	public void set(int key, int val){
		if(!cache.containsKey(key))
			cache.put(key,val);
		else{
			cache.remove(key);
			cache.put(key,val);
		}
	}
	
	public int get(int key){
		if(!cache.containsKey(key)){
			return -1;
		}
		int value = cache.get(key);
		cache.remove(key);
		cache.put(key,value);
		return value;
	}
	
	public void display(){
		Iterator<Integer> iterator = cache.keySet().iterator();
		int key;
		while(iterator.hasNext()){
			key = iterator.next();
			System.out.println(key + " " + cache.get(key));;
		}
	}
	
	public static void main(String[] args){
		LRUCache L1 = new LRUCache(3);
		L1.set(1,11);
		L1.set(4,44);
		L1.set(3,33);
		L1.set(2,22);
		System.out.println(L1.get(5));
		L1.display();
	}
}
