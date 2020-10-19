package Lesson_2;

import java.util.Objects;

/*
Создайте класс, который описывает вектор (в трёхмерном пространстве).
У него должны быть:
- конструктор с параметрами в виде списка координат x, y, z
- метод, вычисляющий длину вектора sqrt(x^2 + y^2 + z^2). Корень можно посчитать с помощью Math.sqrt
- метод, вычисляющий скалярное произведение (x1*x2 + y1*y2 + z1*z2)
- статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N
 */
public class Vector {
    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getZ() {
        return z;
    }


    public double vectorLong(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public int scolar(Vector vector) {
        if (Objects.isNull(vector))
            return 0;
        return this.x*vector.getX() + this.y*vector.getY() + this.z*vector.getZ();
    }

    public static Vector[] arrayN (int n){
        Vector[] arN= new Vector[n];
        for (int i = 0; i<arN.length; i++){
            arN[i] = new Vector((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200));
        }
        return arN;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {

        Vector vectore = new Vector(1, 2, 10);
        Vector vectore1 = new Vector(10, 20, 100);
        System.out.println(vectore.scolar(vectore1));

        System.out.println(vectore.vectorLong());

        Vector[] array = arrayN(10);
        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }

    }
}
