package com.designpattern.jiegoumoshi.facade;

public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startUp(){
        System.out.println("Start computer");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
    }

    public void shutDown(){
        System.out.println("shutDown computer");
        disk.shutDown();
        memory.shutDown();
        cpu.shudDown();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startUp();
        computer.shutDown();
    }

}
