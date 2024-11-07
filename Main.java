import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

//Задание №1.1
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка: {" + x + "; " + y + "}";
    }

    public static List<Point> inputPoints(int count) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            double x = 0;
            double y = 0;

            boolean validX = false;
            while (!validX) {
                try {
                    System.out.print("Введите координату X для точки " + i + ": ");
                    String inputX = scanner.nextLine();
                    x = Double.parseDouble(inputX);
                    System.out.print("Введите координату Y для точки " + i + ": ");
                    String inputY = scanner.nextLine();
                    y = Double.parseDouble(inputY);
                    validX = true;
                    Point point = new Point(x, y);
                    points.add(point);
                    System.out.println(point);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка!\nВведите корректное значение");

                }
            }
        }
        return points;
    }



    public static void showGraph(List<Point> points) {
        JFrame frame = new JFrame("График точек");
        GraphPlotter graphPlotter = new GraphPlotter(points);

        frame.add(graphPlotter);
        frame.setSize(695, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
// Класс для отображения точек и линий на графике для первого задания
class GraphPlotter extends JPanel {
    private List<Point> points;


    public GraphPlotter(List<Point> points) {
        this.points = points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxes(g);
        drawPoints(g);
    }

    public void drawAxes(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.drawLine(width / 2, 0, width / 2, height); // Y-axis
        g.drawLine(0, height / 2, width, height / 2); // X-axis

        for (int i = -width / 2; i <= width / 2; i += 20) {
            g.drawLine(width / 2 + i, height / 2 - 5, width / 2 + i, height / 2 + 5); // X-axis ticks
            g.drawLine(width / 2 - 5, height / 2 + i, width / 2 + 5, height / 2 + i); // Y-axis ticks
        }
    }

    public void drawPoints(Graphics g) {
        g.setColor(Color.BLACK);
        for (Point point : points) {
            int x = (int) (point.getX() * 20);
            int y = (int) (-point.getY() * 20);
            g.fillOval(getWidth() / 2 + x - 3, getHeight() / 2 + y - 3, 6, 6);
        }
    }
}

//Задание№2.1

class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String toString() {
        return "Линия от {" + start.getX() + ";" + start.getY() + "} до {" + end.getX() + ";" + end.getY() + "}";
    }

    public void moveStart(double newX, double newY) {
        this.start.setX(newX);
        this.start.setY(newY);
    }

    public void moveEnd(double newX, double newY) {
        this.end.setX(newX);
        this.end.setY(newY);
    }
}


class GraphPlotter1 extends JPanel {
    private List<Line> lines;

    public GraphPlotter1(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxes(g);
        drawLines(g);
    }

    private void drawAxes(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.drawLine(width / 2, 0, width / 2, height); // Y-axis
        g.drawLine(0, height / 2, width, height / 2); // X-axis

        for (int i = -width / 2; i <= width / 2; i += 20) {
            g.drawLine(width / 2 + i, height / 2 - 5, width / 2 + i, height / 2 + 5);
            g.drawLine(width / 2 - 5, height / 2 + i, width / 2 + 5, height / 2 + i);
        }
    }
    private void drawLines(Graphics g) {
        g.setColor(Color.BLACK);
        for (Line line : lines) {
            int x1 = (int) (line.getStart().getX() * 20);
            int y1 = (int) (-line.getStart().getY() * 20);
            int x2 = (int) (line.getEnd().getX() * 20);
            int y2 = (int) (-line.getEnd().getY() * 20);
            g.drawLine(getWidth() / 2 + x1, getHeight() / 2 + y1, getWidth() / 2 + x2, getHeight() / 2 + y2);
        }
    }

}

//Задание №3.1
class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades.clone();
    }

    public void setGrade(int index, int grade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = grade;
        }
    }

    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
//Задание № 4.1


class Pointfor4 {
    private double x;
    private double y;


    public Pointfor4(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка: {" + x + "; " + y + "}";
    }
}

// Класс для отображения точек на графике для 4 задания
class GraphPlotter3 extends JPanel {
    private Pointfor4[] points7;

    public GraphPlotter3(Pointfor4[] points7) {
        this.points7 = points7;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxes(g); // Рисуем оси
        drawPoints(g); // Рисуем точки
    }

    // Метод для рисования осей
    private void drawAxes(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.drawLine(width / 2, 0, width / 2, height); // Y-ось
        g.drawLine(0, height / 2, width, height / 2); // X-ось

        // Добавляем метки на оси
        for (int i = -width / 2; i <= width / 2; i += 20) {
            g.drawLine(width / 2 + i, height / 2 - 5, width / 2 + i, height / 2 + 5); // X-axis ticks
            g.drawLine(width / 2 - 5, height / 2 + i, width / 2 + 5, height / 2 + i); // Y-axis ticks
        }
    }

    // Метод для рисования точек
    private void drawPoints(Graphics g) {
        g.setColor(Color.BLACK);
        for (Pointfor4 point : points7) {
            int x = (int) (point.getX() * 20); // Умножаем координаты для масштаба
            int y = (int) (-point.getY() * 20); // Инвертируем Y, так как на графике Y растет вниз
            g.fillOval(getWidth() / 2 + x - 3, getHeight() / 2 + y - 3, 6, 6); // Рисуем точку
        }
    }

}


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1,2,3,4):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Задание 1.1
                System.out.println("Задание № 1:");
                List<Point> points = Point.inputPoints(3);
                Point.showGraph(points);
                break;

            case 2:
                // Задание 2.1
                Point p1 = new Point(1, 3);
                Point p2 = new Point(23, 8);
                Point p3 = new Point(5, 10);
                Point p4 = new Point(25, 10);

                Line line1 = new Line(p1, p2);

                Line line2 = new Line(p3, p4);

                // Линия 3: начинается в точке начала линии 1 и заканчивается в точке конца линии 2
                Line line3 = new Line(new Point(line1.getStart().getX(), line1.getStart().getY()),
                        new Point(line2.getEnd().getX(), line2.getEnd().getY()));


                System.out.println("Исходные линии:");
                System.out.println(line1);
                System.out.println(line2);
                System.out.println(line3);



                // Создаем список линий для отображения на графике
                List<Line> lines = new ArrayList<>();
                lines.add(line1);
                lines.add(line2);
                lines.add(line3);

                // Создаем графический интерфейс для отображения линий
                JFrame frame = new JFrame("График линий");
                GraphPlotter1 graphPlotter = new GraphPlotter1(lines);

                frame.add(graphPlotter);
                frame.setSize(1055, 600); // Размер окна
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null); // Окно по центру экрана
                frame.setVisible(true);





                // Изменяем координаты линии 1 и линии 2
                line1.moveStart(5, 5);
                line1.moveEnd(15, 15);
                line2.moveStart(10, 10);
                line2.moveEnd(30, 10);


                line3 = new Line(new Point(line1.getStart().getX(), line1.getStart().getY()),
                        new Point(line2.getEnd().getX(), line2.getEnd().getY()));

                System.out.println("\nПосле изменения координат линии 1 и линии 2:");
                System.out.println(line1);
                System.out.println(line2);
                System.out.println(line3);

                // Изменяем координаты первой линии так, чтобы третья линия не менялась
                line1.moveStart(0, 0);
                line1.moveEnd(5, 5);

                System.out.println("\nПосле изменения только линии 1:");
                System.out.println(line1); // Изменения в первой линии
                System.out.println(line3); // Третья линия остается неизменной


                List<Line> lines3 = new ArrayList<>();
                lines3.add(line1);
                lines3.add(line2);
                lines3.add(line3);


                JFrame frame1 = new JFrame("График линий");
                GraphPlotter1 graphPlotter1 = new GraphPlotter1(lines3);

                frame1.add(graphPlotter1);
                frame1.setSize(1215, 600); // Размер окна
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setLocationRelativeTo(null); // Окно по центру экрана
                frame1.setVisible(true);

                break;
            case 3:
                // Задача 3.1
                int[] vasyaGrades = {3, 4, 5};
                Student vasya = new Student("1. Создать студента Васю с оценками: 3,4,5", vasyaGrades);

                Student petya = new Student("2. Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с\n" +
                        "оценками Васи полю с оценками Пети.", vasyaGrades); // Копируем массив оценок Васи


                Student petya2 = new Student("3. Заменить первую оценку Пети на число 5. Вывести на экран строковое представление\n" +
                        "Васи и Пети. Объяснить результат", vasyaGrades);
                petya2.setGrade(0, 5);
                System.out.println("Задание№ 3:");
                System.out.println("Студенты:");
                System.out.println(vasya);
                System.out.println(petya); // Оценки Пети изменились
                System.out.println(petya2); // Оценки Пети изменились
                // Андрей
                Student andrey = new Student("Андрей", vasyaGrades.clone()); // Клонируем массив оценок
                System.out.println("После клонирования оценок для Андрея:");
                System.out.println(vasya);
                System.out.println(andrey);
                break;
            case 4:
                // Задание 4.1
                Pointfor4 point1 = new Pointfor4(3, 5);
                Pointfor4 point2 = new Pointfor4(25, 6);
                Pointfor4 point3 = new Pointfor4(7, 8);


                System.out.println(point1);
                System.out.println(point2);
                System.out.println(point3);


                Pointfor4[] points7 = {point1, point2, point3};


                JFrame frame3 = new JFrame("График точек");
                GraphPlotter3 graphPlotter3 = new GraphPlotter3(points7);

                frame3.add(graphPlotter3);
                frame3.setSize(1215, 600); // Размер окна
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setLocationRelativeTo(null); // Окно по центру экрана
                frame3.setVisible(true);
                break;

            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите задание 1,2,3,4");
                break;
        }


    }









}
