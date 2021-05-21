import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    //очищаем массив резюме
    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    //сохранем новое резюме в массив, если в нем есть место, в конец после других резюме
    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size++;
        }
    }

    //возвращаем резюме по uuid или null, если резюме по uuid не найдено
    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    // удаляем резюме с указанным uuid. Если в массиве после удаленного элемента есть другие резюме, перемещаем их в массиве на одну ячейку к началу массива
    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                while (i + 1 < size) {
                    storage[i] = storage[i + 1];
                    i++;
                }
                storage[i] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    // возвращает количество резюме в массиве
    int size() {
        return size;
    }
}
