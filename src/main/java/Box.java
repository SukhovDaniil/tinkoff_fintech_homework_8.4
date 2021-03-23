/**
 * Обобщенный класс, описыаеющий коробку.
 *
 * @param <T> generic элемента, содержащегося в коробке
 */
public class Box<T> {
    private T element;

    /**
     * Кладет элемет в коробку.
     *
     * @param inputElement елемент, кладущийся в коробку
     */
    public void put(final T inputElement) {
        this.element = inputElement;
    }

    /**
     * @return возвращает элемент, хранящийся в коробке
     * @throws NullPointerException в случае, если коробка пуста (this.element == null)
     */
    public T get() throws NullPointerException {
        if (this.element == null) {
            throw new NullPointerException();
        } else {
            return this.element;
        }
    }
}
