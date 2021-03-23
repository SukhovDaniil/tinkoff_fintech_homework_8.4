/**
 * Утилитарный класс, содержащий методы работы с коробками.
 */
public class BoxUtil {
    //TODO Придумать, как копировать элемент, а не предавать его ссылку

    /**
     * Копирует объект из коробки-источника в коробку-получатель.
     *
     * @param src  коробка-источник
     * @param dest коробка-получатель. Коробка-получатель может быть типизированна тем же классом,
     *             что и коробка-источник, или его родителем
     * @param <T>  generic элемента, содержащегося в коробке-источнике
     */
    public static <T> void copyFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        try {
            dest.put(src.get());
        } catch (NullPointerException e) {
            System.out.println("В коробке-источнике [" + src.getClass() + "] отсутствует элемент.");
            throw e;
        }
    }

    /**
     * Копирует фрукт из коробки-источника в коробку-получатель при условии, что фрукт свежий.
     *
     * @param src  коробка-источник (может быть типизирована Fruit и наследниками)
     * @param dest коробка-получатель (может быть типизирована тем же классом, что и коробка-источник,
     *             или его родителем - Fruit и выше)
     * @param <T>  generic элемента в коробка-источнике
     */
    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        try {
            if (src.get().getFresh()) {
                copyFromBoxToBox(src, dest);
            }
        } catch (NullPointerException e) {
            System.out.println("В коробке-источнике [" + src.getClass() + "] отсутствует элемент.");
            throw e;
        }
    }

    /**
     * Выводит в консоль (через toString()) элемент из вложенной коробки.
     *
     * @param box внешняя коробка: может содержать в себе любую коробку
     * @param <T> generic внешней коробки: ограничен коробкой (любой)
     */
    public static <T extends Box<?>> void printElementFromTwoBoxes(final Box<T> box) {
        try {
            System.out.println(box.get().get().toString());
        } catch (NullPointerException e) {
            System.out.println("В одной из коробок лежит null.");
            throw e;
        }
    }

    /**
     * Выводит в консоль (через toString()) элемент из последней коробки.
     *
     * @param box коробка с любым содержимым (в т.ч. с ещё одной коробкой)
     */
    public static void printElementFromBoxes(final Box<?> box) {
        try {
            if (box.get() instanceof Box<?>) {
                printElementFromBoxes((Box<?>) box.get());
            } else {
                System.out.println(box.get().toString());
            }
        } catch (NullPointerException e) {
            System.out.println("В последней коробке [" + box.get().getClass() + "] отсутствует содержимое.");
            throw e;
        }
    }
}
