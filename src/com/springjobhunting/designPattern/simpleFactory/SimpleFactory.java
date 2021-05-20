package com.springjobhunting.designPattern.simpleFactory;

/**
 * @author Rico_dds
 * @date 2021/5/15 11:02
 */
public class SimpleFactory {
    public static void main(String[] args) {

        DoorFactory doorFactory = new DoorFactory();
        Door wood = doorFactory.makeDoor(12, 20, "wood");
        Door iron = doorFactory.makeDoor(5, 10, "iron");

        System.out.println(wood.getHeight());
        System.out.println(wood.getWidth());

        System.out.println(iron.getHeight());
        System.out.println(iron.getWidth());

    }
}
interface Door{
    float getHeight();
    float getWidth();
}


class WoodenDoor implements Door{
    private float height;
    private float width;

    public WoodenDoor(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public float getHeight() {
        System.out.print("获取木门的高度为：");
        return height;
    }

    @Override
    public float getWidth() {
        System.out.print("获取木门的宽度为：");
        return width;
    }
}


class IronDoor implements Door{
    private float height;
    private float width;

    public IronDoor(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public float getHeight() {
        System.out.print("获取铁门的高度为：");
        return height;
    }

    @Override
    public float getWidth() {
        System.out.print("获取铁门的宽度为：");
        return width;
    }
}


class DoorFactory{

    public static Door makeDoor(float height, float width, String type){
        if(type.equals("wood")){
            return new WoodenDoor(height, width);
        } else if (type.equals("iron")){
            return new IronDoor(height, width);
        } else {
            return null;
        }
    }

}