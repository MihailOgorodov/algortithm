package org.example.sem4;

/**
 * Перечисление цветов узла дерева.
 */
enum Color {
    RED,
    BLACK
}

/**
 * Класс реализующий узел дерева.
 */
class RBNode<T> {
    T data;
    RBNode<T> left;
    RBNode<T> right;
    RBNode<T> parent;
    Color color;

    /**
     * Конструктор по-умолчанию.
     */
    public RBNode(T data) {
        this.data = data;
        this.color = Color.RED;
    }
}

/**
 * Класс реализующий красно-черное дерево
 */
class RBTree<T extends Comparable<T>> {
    /**
     * Корень дерева.
     */
    private RBNode<T> root;

    /**
     * Нулевая ссылка.
     */
    public RBTree() {
        this.root = null;
    }

    /**
     * Метод, осуществляющий левый поворот дерева tree относительно узла node.
     */
    private void leftRotate(RBNode<T> x) {
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    /**
     * Метод, осуществляющий правый поворот дерева tree относительно узла node.
     */
    private void rightRotate(RBNode<T> x) {
        RBNode<T> y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.right = x;
        x.parent = y;
    }

    /**
     * Исправление древа для сохранения свойств красно-черного дерева.
     */
    private void insertFixup(RBNode<T> z) {
        while (z.parent != null && z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                RBNode<T> y = z.parent.parent.right;
                if (y != null && y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                RBNode<T> y = z.parent.parent.left;
                if (y != null && y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        this.root.color = Color.BLACK;
    }

    /**
     * Метод добавления элемента дерева.
     */
    public void insert(T data) {
        RBNode<T> z = new RBNode<>(data);
        RBNode<T> y = null;
        RBNode<T> x = this.root;
        while (x != null) {
            y = x;
            if (z.data.compareTo(x.data) <= 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            this.root = z;
        } else if (z.data.compareTo(y.data) <= 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        insertFixup(z);
    }


    public static void main(String[] args) {
        RBTree<Integer> tree = new RBTree<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        System.out.println(tree);
    }
}
