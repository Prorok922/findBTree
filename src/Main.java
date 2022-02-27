public class Main {
    // проверка, задано ли двоичное дерево
    // это BST или нет

    /* Программа драйвера для проверки функций */

        public static void main(String args[]) {

            BinaryTree tree = new BinaryTree();

            tree.root = new Node(4);
            tree.root.left = new Node(2);
            tree.root.right = new Node(5);
            tree.root.left.left = new Node(1);
            tree.root.left.right = new Node(3);



            if (tree.isBST())
                System.out.println("IS BST");
            else
                System.out.println("Not a BST");
        }
    }

    /* Класс, содержащий левого и правого потомка текущего
       значение узла и ключа */

class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }

}

class BinaryTree {

    // Корень бинарного дерева
    Node root;


    /* может дать минимальное и максимальное значение в соответствии с вашим кодом или
    Можно написать функцию, чтобы найти минимальное и максимальное значение дерева. */


    /* возвращает true, если данное дерево поиска является двоичным
    дерево поиска (эффективная версия) */

    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }


    /* Возвращает true, если данное дерево является BST и его
    Значения> = мин и <= макс. */

    boolean isBSTUtil(Node node, int min, int max) {

        /* пустое дерево BST */
        if (node == null) return true;


        /* false, если этот узел нарушает ограничения min / max */
        if (node.data < min || node.data > max) return false;


        /* рекурсивно проверять поддеревья
        ужесточение мин / макс ограничений */
        // Разрешить только разные значения

        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
}
