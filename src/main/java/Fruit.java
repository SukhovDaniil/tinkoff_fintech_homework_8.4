/**
 * Класс, описывающий тип "Фрукт".
 */
public class Fruit {
    private boolean fresh;

    /**
     * Переопределяем конструктор по умолчанию.
     * Сделано на случай, если при проверке ДЗ не используется создание объекта при помощи конструктора
     */
    Fruit() {
        this.fresh = false;
    }

    /**
     * Конструктор фрукта, инициализируеющий параметр свежести.
     *
     * @param fresh параметр, говорящий о свежести фрукта
     */
    Fruit(final boolean fresh) {
        this.fresh = fresh;
    }

    /**
     * @return свежесть фрукта (true - свежий, false - несвежий)
     */
    public boolean getFresh() {
        return this.fresh;
    }

    /**
     * Устанавливает свежесть фрукта.
     *
     * @param fresh свжежсть (true - свежий, false - не свежий)
     */
    public void setFresh(final boolean fresh) {
        this.fresh = fresh;
    }
}
